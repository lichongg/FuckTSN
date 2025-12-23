package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LinkcardRequest extends SocializeRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42413a = "/share/linkcard/";

    /* renamed from: b, reason: collision with root package name */
    private String f42414b;

    /* renamed from: c, reason: collision with root package name */
    private BaseMediaObject f42415c;

    public LinkcardRequest(Context context) {
        super(context, "", LinkCardResponse.class, 0, URequest.RequestMethod.POST);
    }

    private int[] g() {
        int[] iArr = {120, 120};
        BaseMediaObject baseMediaObject = this.f42415c;
        if (baseMediaObject != null && baseMediaObject.getmExtra() != null) {
            Map<String, Object> map = this.f42415c.getmExtra();
            if (map.containsKey("width")) {
                iArr[0] = ((Integer) map.get("width")).intValue();
            }
            if (map.containsKey("height")) {
                iArr[1] = ((Integer) map.get("height")).intValue();
            }
        }
        return iArr;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display_name", this.f42415c.getTitle());
            jSONObject.put(SocializeProtocolConstants.IMAGE, f());
            jSONObject.put("summary", d());
            jSONObject.put(SocializeProtocolConstants.FULL_IMAGE, h());
            jSONObject.put("url", this.f42415c.toUrl());
            jSONObject.put(SocializeProtocolConstants.LINKS, i());
            jSONObject.put("tags", e());
            jSONObject.put(SocializeProtocolConstants.CREATE_AT, c());
            jSONObject.put(SocializeProtocolConstants.OBJECT_TYPE, b());
            return jSONObject;
        } catch (JSONException e6) {
            SLog.error(e6);
            return jSONObject;
        }
    }

    private String b() {
        BaseMediaObject baseMediaObject = this.f42415c;
        return baseMediaObject instanceof UMWeb ? "webpage" : baseMediaObject instanceof UMVideo ? "video" : baseMediaObject instanceof UMusic ? "audio" : "webpage";
    }

    private String c() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    private String d() {
        return (TextUtils.isEmpty(this.f42415c.getDescription()) || this.f42415c.getDescription().length() <= 300) ? this.f42415c.getDescription() : this.f42415c.getDescription().substring(0, 300);
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("display_name", Config.Descriptor);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (JSONException e6) {
            SLog.error(e6);
            return jSONArray;
        }
    }

    private JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f42415c.getThumbImage();
            if (thumbImage == null || !thumbImage.isUrlMedia()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", thumbImage.asUrlImage());
            }
            int[] g6 = g();
            jSONObject.put("width", g6[0]);
            jSONObject.put("height", g6[1]);
            return jSONObject;
        } catch (JSONException e6) {
            SLog.error(e6);
            return jSONObject;
        }
    }

    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f42415c.getThumbImage();
            if (thumbImage == null || !thumbImage.isUrlMedia()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", thumbImage.asUrlImage());
            }
            int[] g6 = g();
            jSONObject.put("width", g6[0]);
            jSONObject.put("height", g6[1]);
            return jSONObject;
        } catch (JSONException e6) {
            SLog.error(e6);
            return jSONObject;
        }
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f42415c.toUrl());
            return jSONObject;
        } catch (JSONException e6) {
            SLog.error(e6);
            return jSONObject;
        }
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f42413a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    public void setMedia(BaseMediaObject baseMediaObject) {
        this.f42415c = baseMediaObject;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        addStringParams("linkcard_info", a().toString());
    }
}
