package com.bytedance.msdk.m.xt;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.api.r.oq;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    public static void j(com.bytedance.sdk.openadsdk.i.r rVar) {
        com.bytedance.sdk.openadsdk.i.cw.cw.j jVar = new com.bytedance.sdk.openadsdk.i.cw.cw.j(com.bytedance.msdk.core.j.qv().ol().sparseArray());
        rVar.j(8475, com.bytedance.sdk.openadsdk.i.cw.r.j(j(jVar.qv())));
        rVar.j(8457, com.bytedance.sdk.openadsdk.i.cw.r.j(j(jVar.az())));
        rVar.j(1, Boolean.valueOf(com.bytedance.msdk.ae.j.j.j().g()));
    }

    public static JSONObject xt() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, com.bytedance.msdk.j.j.r> xt = xt.j().xt();
            if (xt != null && xt.size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.j.j.r> entry : xt.entrySet()) {
                    String key = entry.getKey();
                    com.bytedance.msdk.j.j.r value = entry.getValue();
                    long up = value.up();
                    int m6 = value.m();
                    if (up != 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(NotificationCompat.CATEGORY_STATUS, m6);
                        jSONObject2.put("duration", up);
                        jSONObject.put(key, jSONObject2);
                        value.ae();
                    }
                }
            }
            if (com.bytedance.sdk.gromore.init.up.f27348m > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 1);
                jSONObject3.put("duration", com.bytedance.sdk.gromore.init.up.f27348m);
                jSONObject3.put("plugin", h.xt() ? 1 : 0);
                jSONObject.put(MediationConstant.ADN_PANGLE, jSONObject3);
                com.bytedance.sdk.gromore.init.up.f27348m = 0L;
            }
            if (com.bytedance.sdk.gromore.init.up.ae > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(NotificationCompat.CATEGORY_STATUS, 1);
                jSONObject4.put("duration", com.bytedance.sdk.gromore.init.up.ae);
                jSONObject4.put("plugin", h.xt() ? 1 : 0);
                jSONObject.put("fusion", jSONObject4);
                com.bytedance.sdk.gromore.init.up.ae = 0L;
            }
            if (com.bytedance.msdk.m.xt.j.r() != null && com.bytedance.msdk.m.xt.j.r().j() != null && com.bytedance.msdk.m.xt.j.r().j().size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.api.r.j.xt.m.j> entry2 : com.bytedance.msdk.m.xt.j.r().j().entrySet()) {
                    String key2 = entry2.getKey();
                    com.bytedance.msdk.api.r.j.xt.m.j value2 = entry2.getValue();
                    long up2 = value2.up();
                    int m7 = value2.m();
                    if (up2 != 0) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(NotificationCompat.CATEGORY_STATUS, m7);
                        jSONObject5.put("duration", up2);
                        jSONObject.put(key2, jSONObject5);
                        value2.ae();
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class j extends ae {
        public j(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar) {
            super(xtVar);
        }

        @Override // com.bytedance.msdk.m.xt.ae
        public boolean j() {
            int ya = com.bytedance.msdk.core.xt.xt().ya();
            if (ya > 0) {
                return true;
            }
            if (ya < 0) {
                return false;
            }
            return super.j();
        }

        @Override // com.bytedance.msdk.m.xt.ae
        public boolean xt() {
            int sm = com.bytedance.msdk.core.xt.xt().sm();
            if (sm > 0) {
                return false;
            }
            if (sm < 0) {
                return true;
            }
            return super.xt();
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.i.r rVar, com.bytedance.sdk.openadsdk.i.r rVar2) {
        rVar.j(8424, com.bytedance.sdk.openadsdk.i.cw.r.j(rVar2.xt()));
    }

    public static SparseArray<Object> j(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.j jVar) {
        if (jVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        j6.j(8458, Boolean.valueOf(jVar.up()));
        j6.j(8459, jVar.qv());
        j6.j(8460, jVar.j());
        j6.j(8461, Boolean.valueOf(jVar.xt()));
        j6.j(8310, new tl(jVar.cw()));
        j6.j(8462, jVar.r());
        j6.j(8463, jVar.m());
        j6.j(8464, jVar.ae());
        j6.j(8465, Boolean.valueOf(jVar.tl()));
        j6.j(8466, Boolean.valueOf(jVar.g()));
        j6.j(8467, Boolean.valueOf(jVar.oq()));
        return j6.xt();
    }

    public static SparseArray<Object> j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar) {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        if (rVar != null) {
            j6.j(8311, new j(rVar.av()));
            j6.j(8023, Boolean.valueOf(rVar.cw()));
            j6.j(8024, Boolean.valueOf(rVar.j()));
            j6.j(8025, Boolean.valueOf(rVar.up()));
            j6.j(8026, Boolean.valueOf(rVar.xt()));
            j6.j(8480, Boolean.valueOf(rVar.r()));
            j6.j(8479, Boolean.valueOf(rVar.m()));
            j6.j(8312, rVar.g() != null ? new m(rVar.g()) : null);
            j6.j(8483, rVar.g());
            j6.j(8484, rVar.oq());
            j6.j(8485, rVar.ws());
            j6.j(8486, rVar.vl());
            j6.j(8487, rVar.qv());
            j6.j(8554, rVar.az());
            j6.j(8549, Boolean.valueOf(rVar.ae()));
        } else {
            j6.j(8311, new j(null));
            Boolean bool = Boolean.TRUE;
            j6.j(8023, bool);
            j6.j(8024, bool);
            j6.j(8025, bool);
            j6.j(8026, bool);
            j6.j(8480, bool);
            j6.j(8479, bool);
            j6.j(8312, new m(null));
            j6.j(8483, null);
            j6.j(8484, "");
            j6.j(8485, "");
            j6.j(8486, "");
            j6.j(8487, "");
            j6.j(8549, bool);
        }
        return j6.xt();
    }

    public static void j() {
        oq.j(new com.bytedance.sdk.openadsdk.i.cw.cw.j(com.bytedance.msdk.core.j.qv().ol().sparseArray()).qv());
    }
}
