package com.bytedance.sdk.openadsdk.core.dislike.cw;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private String ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private final int f28869j;

    /* renamed from: m, reason: collision with root package name */
    private final String f28870m;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f28871r;
    private final String up;
    private final List<m> xt = new ArrayList();

    public void j(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.f28869j);
        jSONObject.put("filter_words", m());
        jSONObject.put("close_on_dislike", tl());
    }

    public String xt() {
        return this.cw;
    }

    public String ae() {
        return this.ae;
    }

    public String cw() {
        return this.up;
    }

    public JSONArray m() {
        JSONObject ae;
        JSONArray jSONArray = new JSONArray();
        List<m> list = this.xt;
        if (list != null) {
            for (m mVar : list) {
                if ((mVar instanceof cw) && (ae = ((cw) mVar).ae()) != null) {
                    jSONArray.put(ae);
                }
            }
        }
        return jSONArray;
    }

    public String r() {
        return this.f28870m;
    }

    public boolean tl() {
        return this.f28871r;
    }

    public boolean up() {
        return this.f28869j == 1;
    }

    public void xt(String str) {
        this.ae = str;
    }

    public xt(JSONObject jSONObject, cw cwVar) {
        String str;
        int i6 = 0;
        this.f28869j = jSONObject.optInt("dislike_control", 0);
        this.f28871r = jSONObject.optBoolean("close_on_dislike", false);
        if (cwVar != null) {
            str = cwVar.j();
        } else {
            str = "";
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("filter_words");
        if (optJSONArray != null) {
            boolean z5 = false;
            while (i6 < optJSONArray.length()) {
                cw j6 = cw.j(optJSONArray.optJSONObject(i6));
                if (j6 != null && j6.up()) {
                    this.xt.add(j6);
                    if (!z5) {
                        z5 = TextUtils.equals(j6.j(), str);
                    }
                }
                i6++;
            }
            i6 = z5 ? 1 : 0;
        }
        if (cwVar != null && i6 == 0) {
            this.xt.add(cwVar);
        }
        this.up = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.f28870m = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
    }

    public List<m> j() {
        return this.xt;
    }

    public void j(String str) {
        this.cw = str;
    }
}
