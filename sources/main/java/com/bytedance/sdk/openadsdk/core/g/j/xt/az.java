package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class az implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "label")
    private String f29022j;

    @com.bytedance.sdk.component.qv.xt.j(j = MediationConstant.EXTRA_LOG_EXTRA)
    private String xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        if (!j()) {
            com.bytedance.sdk.component.utils.vl.r("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            jVar.xt(map2);
            return false;
        }
        JSONObject j6 = j(map);
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, uf.xt(this.cw), this.f29022j, j6);
        jVar.j(map2);
        return true;
    }

    private JSONObject j(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("label");
            hashSet.add(MediationConstant.EXTRA_ADID);
            hashSet.add(MediationConstant.EXTRA_LOG_EXTRA);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean j() {
        return (TextUtils.isEmpty(this.f29022j) || TextUtils.isEmpty(this.xt) || this.cw == null) ? false : true;
    }
}
