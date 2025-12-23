package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AnalyticsReqeust extends SocializeRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42417a = "/share/multi_add/";

    /* renamed from: b, reason: collision with root package name */
    private static final int f42418b = 9;

    /* renamed from: c, reason: collision with root package name */
    private String f42419c;

    /* renamed from: d, reason: collision with root package name */
    private String f42420d;

    /* renamed from: e, reason: collision with root package name */
    private String f42421e;

    /* renamed from: f, reason: collision with root package name */
    private String f42422f;

    /* renamed from: g, reason: collision with root package name */
    private String f42423g;

    /* renamed from: h, reason: collision with root package name */
    private String f42424h;

    /* renamed from: i, reason: collision with root package name */
    private String f42425i;

    /* renamed from: j, reason: collision with root package name */
    private UMediaObject f42426j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f42420d = str;
        this.f42425i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f42417a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f42426j = uMediaObject;
            return;
        }
        if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f42423g = uMusic.getTitle();
            this.f42424h = uMusic.toUrl();
            this.f42425i = uMusic.getDescription();
            this.f42426j = uMusic.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f42423g = uMVideo.getTitle();
            this.f42424h = uMVideo.toUrl();
            this.f42425i = uMVideo.getDescription();
            this.f42426j = uMVideo.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f42423g = uMWeb.getTitle();
            this.f42424h = uMWeb.toUrl();
            this.f42425i = uMWeb.getDescription();
            this.f42426j = uMWeb.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f42423g = uMMin.getTitle();
            this.f42424h = uMMin.toUrl();
            this.f42425i = uMMin.getDescription();
            this.f42426j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f42420d = str;
    }

    public void setText(String str) {
        this.f42425i = str;
    }

    public void setType(String str) {
        this.f42422f = str;
    }

    public void setUID(String str) {
        this.f42421e = str;
    }

    public void setmUsid(String str) {
        this.f42419c = str;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        String str = this.f42420d;
        String str2 = this.f42419c;
        if (str2 == null) {
            str2 = "";
        }
        String format = String.format("{\"%s\":\"%s\"}", str, str2);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams("to", format);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_SNS, format);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, appkey);
        addStringParams("type", this.f42422f);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_USID, this.f42419c);
        addStringParams("ct", this.f42425i);
        if (!TextUtils.isEmpty(this.f42424h)) {
            addStringParams("url", this.f42424h);
        }
        if (!TextUtils.isEmpty(this.f42423g)) {
            addStringParams("title", this.f42423g);
        }
        addMediaParams(this.f42426j);
    }
}
