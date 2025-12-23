package com.bytedance.sdk.openadsdk.core.up;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, j> f30933j = new HashMap<>();

    public static class j {

        /* renamed from: r, reason: collision with root package name */
        private int f30936r;

        /* renamed from: j, reason: collision with root package name */
        private long f30935j = 0;
        private int xt = 0;
        private int cw = 0;

        public void j(tl.xt xtVar) {
            long currentTimeMillis = System.currentTimeMillis();
            if (xtVar.m() > 0) {
                if (currentTimeMillis - this.f30935j < xtVar.m()) {
                    this.xt++;
                    this.f30936r += xtVar.ae();
                }
                this.f30935j = currentTimeMillis;
            }
            if (xtVar.tl() > 0) {
                int i6 = this.cw + 1;
                this.cw = i6;
                if (i6 > xtVar.tl()) {
                    this.f30936r += xtVar.g();
                }
            }
        }

        public void xt(tl.xt xtVar) {
            this.cw = 0;
            this.xt = 0;
            this.f30936r += xtVar.oq();
            this.f30936r = Math.min(xtVar.qv(), this.f30936r);
        }

        public j(tl.xt xtVar) {
            this.f30936r = xtVar.qv();
        }

        public int j(int i6, tl.xt xtVar) {
            int i7 = this.f30936r - i6;
            if (i7 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> vl = xtVar.vl();
            int i8 = -1;
            if (vl == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : vl.entrySet()) {
                int intValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i7 <= 0 && intValue > i8) {
                    i8 = intValue;
                }
            }
            return i8;
        }

        public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final tl.xt xtVar2, final String str, final String str2) {
            ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.up.xt.j.1
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("slot_type", Integer.valueOf(xtVar.kt()));
                    jSONObject.putOpt("rit", xtVar.r());
                    jSONObject.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject.putOpt("reason_value", str2);
                    jSONObject.putOpt("freq_count", Integer.valueOf(j.this.xt));
                    jSONObject.putOpt("continuous_count", Integer.valueOf(j.this.cw));
                    jSONObject.putOpt("score", Integer.valueOf(j.this.f30936r));
                    jSONObject.putOpt("score_threshold", Integer.valueOf(xtVar2.r()));
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("load_score_cache").xt(jSONObject.toString());
                }
            }, "load_score_cache");
        }
    }

    public static j j(String str, tl.xt xtVar) {
        if (TextUtils.isEmpty(str)) {
            return new j(xtVar);
        }
        HashMap<String, j> hashMap = f30933j;
        j jVar = hashMap.get(str);
        if (jVar == null) {
            j jVar2 = new j(xtVar);
            hashMap.put(str, jVar2);
            return jVar2;
        }
        return jVar;
    }
}
