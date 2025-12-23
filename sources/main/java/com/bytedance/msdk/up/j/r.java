package com.bytedance.msdk.up.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.tl.g;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements cw<g> {

    /* renamed from: j, reason: collision with root package name */
    private Context f25252j;

    @Override // com.bytedance.msdk.up.j.up
    public synchronized void delete(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (this.f25252j != null && !TextUtils.isEmpty(str)) {
            l.j("pacing_".concat(str), this.f25252j).m(str);
        }
    }

    @Override // com.bytedance.msdk.up.j.up
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized void xt(g gVar) {
        try {
            if (this.f25252j != null && gVar != null) {
                l j6 = l.j("pacing_" + gVar.xt(), this.f25252j);
                String r5 = gVar.r();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("unity_id", gVar.r());
                    if (!gVar.j()) {
                        jSONObject.put("waterfall_show_rules_version", gVar.up());
                        jSONObject.put("adn_rit_show_rules_version", gVar.m());
                    }
                    jSONObject.put("timing_mode", gVar.ae());
                    StringBuilder sb = new StringBuilder();
                    sb.append(gVar.g());
                    jSONObject.put("show_pacing", sb.toString());
                    jSONObject.put("show_pacing_rule_id", gVar.oq());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(gVar.qv());
                    jSONObject.put("show_time", sb2.toString());
                    j6.j(r5, jSONObject.toString());
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public r(Context context) {
        if (context != null) {
            this.f25252j = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.bytedance.msdk.up.j.up
    public synchronized g query(String str) {
        if (!str.contains("_")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return j(l.j("pacing_".concat(str), this.f25252j).xt(str, ""), false);
        }
        throw new RuntimeException(" has slotId");
    }

    @Override // com.bytedance.msdk.up.j.up
    public synchronized void delete(String str, String str2) {
        if (!str.contains("_")) {
            if (this.f25252j != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                l.j("pacing_".concat(str), this.f25252j).m(str + "_" + str2);
            }
        } else {
            throw new RuntimeException(" has slotId");
        }
    }

    @Override // com.bytedance.msdk.up.j.up
    public synchronized g query(String str, String str2) {
        if (!str.contains("_")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return j(l.j("pacing_".concat(str), this.f25252j).xt(str + "_" + str2, ""), true);
        }
        throw new RuntimeException(" has slotId");
    }

    private g j(String str, boolean z5) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] split = jSONObject.getString("unity_id").split("_");
            String str4 = split.length > 0 ? split[0] : "";
            String str5 = split.length > 1 ? split[1] : "";
            if (z5) {
                str2 = "";
                str3 = str2;
            } else {
                String string = jSONObject.getString("waterfall_show_rules_version");
                str3 = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string;
            }
            return new g(str4, str5, str2, str3, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.bytedance.msdk.up.j.cw
    public synchronized void j(String str, long j6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g query = query(str);
        if (query != null) {
            query.j(j6);
            xt(query);
        }
    }

    @Override // com.bytedance.msdk.up.j.cw
    public synchronized void j(String str, String str2, long j6) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            g query = query(str, str2);
            if (query != null) {
                query.j(j6);
                xt(query);
            }
        }
    }
}
