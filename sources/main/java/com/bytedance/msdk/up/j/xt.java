package com.bytedance.msdk.up.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements j<com.bytedance.msdk.core.tl.ae> {

    /* renamed from: j, reason: collision with root package name */
    private Context f25253j;

    @Override // com.bytedance.msdk.up.j.up
    public synchronized void delete(String str) {
        if (this.f25253j != null && !TextUtils.isEmpty(str)) {
            l.j("freqctl_".concat(String.valueOf(str)), this.f25253j).m(str);
        }
    }

    private void cw(com.bytedance.msdk.core.tl.ae aeVar) {
        if (this.f25253j == null || aeVar == null) {
            return;
        }
        l j6 = l.j("freqctl_" + aeVar.xt(), this.f25253j);
        JSONObject j7 = j(aeVar, false);
        if (j7 != null) {
            j6.j(aeVar.r(), j7.toString());
        }
    }

    @Override // com.bytedance.msdk.up.j.up
    /* renamed from: j, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void xt(com.bytedance.msdk.core.tl.ae aeVar) {
        if (this.f25253j != null && aeVar != null) {
            l j6 = l.j("freqctl_" + aeVar.xt(), this.f25253j);
            String r5 = aeVar.r();
            JSONObject j7 = j(aeVar, true);
            if (j7 != null) {
                j6.j(r5, j7.toString());
            }
        }
    }

    @Override // com.bytedance.msdk.up.j.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public synchronized void j(com.bytedance.msdk.core.tl.ae aeVar) {
        if (aeVar != null) {
            cw(aeVar);
        }
    }

    public xt(Context context) {
        if (context != null) {
            this.f25253j = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.bytedance.msdk.up.j.up
    public synchronized com.bytedance.msdk.core.tl.ae query(String str) {
        if (this.f25253j == null) {
            return null;
        }
        return j(l.j("freqctl_".concat(String.valueOf(str)), this.f25253j).xt(str, ""), false);
    }

    @Override // com.bytedance.msdk.up.j.up
    public synchronized void delete(String str, String str2) {
        if (this.f25253j != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            l.j("freqctl_".concat(String.valueOf(str)), this.f25253j).m(str + "_" + str2);
        }
    }

    @Override // com.bytedance.msdk.up.j.up
    public synchronized com.bytedance.msdk.core.tl.ae query(String str, String str2) {
        if (this.f25253j == null) {
            return null;
        }
        return j(l.j("freqctl_".concat(String.valueOf(str)), this.f25253j).xt(str + "_" + str2, ""), true);
    }

    private JSONObject j(com.bytedance.msdk.core.tl.ae aeVar, boolean z5) {
        if (aeVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unity_id", aeVar.r());
            if (aeVar.j()) {
                jSONObject.put("adn_rit_show_rules_version", aeVar.m());
            } else {
                jSONObject.put("waterfall_show_rules_version", aeVar.up());
            }
            jSONObject.put("timing_mode", aeVar.ae());
            jSONObject.put("show_freqctl_rules", z5 ? aeVar.g() : aeVar.oq());
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    private com.bytedance.msdk.core.tl.ae j(String str, boolean z5) {
        String string;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] split = jSONObject.getString("unity_id").split("_");
            String str3 = split.length > 0 ? split[0] : "";
            String str4 = split.length > 1 ? split[1] : "";
            if (z5) {
                str2 = jSONObject.getString("adn_rit_show_rules_version");
                string = "";
            } else {
                string = jSONObject.getString("waterfall_show_rules_version");
                str2 = "";
            }
            return new com.bytedance.msdk.core.tl.ae(str3, str4, string, str2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }
}
