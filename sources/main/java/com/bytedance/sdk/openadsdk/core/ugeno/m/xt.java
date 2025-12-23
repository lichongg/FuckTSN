package com.bytedance.sdk.openadsdk.core.ugeno.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.j.cw.j;
import com.bytedance.sdk.component.utils.vl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.sdk.component.adexpress.j.cw.j {
    public xt() {
    }

    public static xt xt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xt xtVar = new xt();
        xtVar.j(jSONObject.optString(CommonNetImpl.NAME));
        xtVar.xt(jSONObject.optString("version"));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    j.C0397j c0397j = new j.C0397j();
                    c0397j.j(optJSONObject.optString("url"));
                    c0397j.xt(optJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
                    c0397j.j(optJSONObject.optInt("level"));
                    arrayList.add(c0397j);
                }
            }
        }
        xtVar.j(arrayList);
        if (xtVar.m()) {
            return xtVar;
        }
        return null;
    }

    public xt(com.bytedance.sdk.component.adexpress.j.cw.j jVar) {
        if (jVar != null) {
            j(jVar.xt());
            xt(jVar.cw());
            j(jVar.getResources());
        }
    }

    public static xt up(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xt(new JSONObject(str));
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.j.cw.j
    public boolean m() {
        if (!TextUtils.isEmpty(cw()) && !TextUtils.isEmpty(xt())) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.j.cw.j
    public String tl() {
        if (m()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(CommonNetImpl.NAME, xt());
                jSONObject.putOpt("version", cw());
                JSONArray jSONArray = new JSONArray();
                if (getResources() != null) {
                    for (j.C0397j c0397j : getResources()) {
                        if (c0397j != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.putOpt("url", c0397j.j());
                            jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0397j.xt());
                            jSONObject2.putOpt("level", Integer.valueOf(c0397j.cw()));
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                jSONObject.putOpt("resources", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e6) {
                vl.j(e6);
                return null;
            }
        }
        return null;
    }
}
