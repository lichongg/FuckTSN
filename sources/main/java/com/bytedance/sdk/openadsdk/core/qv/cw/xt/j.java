package com.bytedance.sdk.openadsdk.core.qv.cw.xt;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public String cw;

    /* renamed from: j, reason: collision with root package name */
    public n f29940j;

    /* renamed from: r, reason: collision with root package name */
    public JSONObject f29941r;
    public String xt;

    public static j j() {
        return new j();
    }

    public j xt(String str) {
        this.cw = str;
        return this;
    }

    public static j j(JSONObject jSONObject) {
        String str;
        String str2;
        JSONObject jSONObject2;
        n nVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            str = jSONObject.optString(CommonNetImpl.TAG, null);
            try {
                str2 = jSONObject.optString("label", null);
                try {
                    jSONObject2 = jSONObject.optJSONObject(JThirdPlatFormInterface.KEY_EXTRA);
                    try {
                        nVar = com.bytedance.sdk.openadsdk.core.j.j(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObject2 = null;
                }
            } catch (Exception unused3) {
                str2 = null;
                jSONObject2 = str2;
                return j().j(str).xt(str2).xt(jSONObject2).j(nVar);
            }
        } catch (Exception unused4) {
            str = null;
            str2 = null;
        }
        return j().j(str).xt(str2).xt(jSONObject2).j(nVar);
    }

    public j xt(JSONObject jSONObject) {
        this.f29941r = jSONObject;
        return this;
    }

    public JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.TAG, this.xt);
            jSONObject.put("label", this.cw);
            JSONObject jSONObject2 = this.f29941r;
            if (jSONObject2 != null) {
                jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, jSONObject2);
            }
            n nVar = this.f29940j;
            if (nVar != null) {
                jSONObject.put("material_meta", nVar.tv());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public j j(n nVar) {
        this.f29940j = nVar;
        return this;
    }

    public j j(String str) {
        this.xt = str;
        return this;
    }
}
