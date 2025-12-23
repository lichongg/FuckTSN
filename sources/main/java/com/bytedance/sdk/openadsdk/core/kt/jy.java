package com.bytedance.sdk.openadsdk.core.kt;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class jy implements com.bytedance.sdk.openadsdk.core.kt.cw.j {

    /* renamed from: j, reason: collision with root package name */
    public static final jy f29343j = new jy();

    @Override // com.bytedance.sdk.openadsdk.core.kt.cw.j
    public void j(final com.bytedance.sdk.openadsdk.vl.j.j jVar, final String str, final boolean z5) {
        com.bytedance.sdk.openadsdk.l.ae.xt(new com.bytedance.sdk.component.oq.g("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.core.kt.jy.1
            @Override // java.lang.Runnable
            public void run() {
                if (up.j(str, 1.0d) || !z5) {
                    jy.this.j(jVar, z5);
                }
            }
        });
    }

    private jy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.vl.j.j jVar, boolean z5) {
        JSONObject jSONObject;
        try {
            JSONObject j6 = jVar.j().j();
            if (j6 != null) {
                String optString = j6.optString("event_extra");
                if (TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(optString);
                }
                int incrementAndGet = xt.xt.incrementAndGet();
                jSONObject.put("stats_index", incrementAndGet);
                jSONObject.put("sdk_session_id", xt.f29419j);
                jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.oq.i().nd() ? 1 : 0);
                if (!TextUtils.isEmpty(uf.f30156g)) {
                    jSONObject.put("wrong_stats_url", uf.f30156g);
                }
                if (!TextUtils.isEmpty(uf.oq)) {
                    jSONObject.put("wrong_applog_url", uf.oq);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.ch.j.j().j("DeviceRate", "bytebench_value")));
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("abtest_version", com.bytedance.sdk.openadsdk.core.oq.i().ff());
                } catch (Exception unused2) {
                }
                if (com.bytedance.sdk.openadsdk.core.oq.i().ae()) {
                    jSONObject.putOpt("first_of_two", 1);
                }
                j6.put("event_extra", jSONObject.toString());
                com.bytedance.sdk.component.tl.xt.r.j.j jVar2 = new com.bytedance.sdk.component.tl.xt.r.j.j(UUID.randomUUID().toString(), j6);
                jVar2.cw((byte) 0);
                jVar2.xt((byte) 3);
                jVar2.j((byte) 1);
                xt.j(jVar2, j6.optString("type"), incrementAndGet);
            }
        } catch (Throwable unused3) {
        }
    }
}
