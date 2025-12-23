package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.up;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private AtomicBoolean cw;

    /* renamed from: j, reason: collision with root package name */
    private volatile String f29501j;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f29502r;
    private String xt;

    private static final class j {

        /* renamed from: j, reason: collision with root package name */
        static final m f29509j = new m();
    }

    private m() {
        this.f29501j = null;
        this.xt = null;
        this.cw = new AtomicBoolean(false);
        this.f29502r = new AtomicBoolean(false);
        j(v.getContext());
    }

    public String ae() {
        return "unionser_slardar_applog";
    }

    public String cw() {
        if (TextUtils.isEmpty(this.f29501j)) {
            this.f29501j = com.bytedance.embedapplog.j.tl();
            com.bytedance.sdk.openadsdk.tools.xt.cw(16, this.f29501j);
            com.bytedance.sdk.openadsdk.core.cw.r.j().vl(this.f29501j == null ? "" : this.f29501j);
        }
        return this.f29501j;
    }

    public String m() {
        return "164362";
    }

    public String r() {
        if (TextUtils.isEmpty(this.xt)) {
            this.xt = com.bytedance.embedapplog.j.oq();
        }
        return this.xt;
    }

    public String up() {
        return (String) com.bytedance.embedapplog.j.j("sdk_version_name", "");
    }

    public void xt() {
        if (!oq.i().g()) {
            com.bytedance.embedapplog.j.j(oq.i().tl());
            com.bytedance.embedapplog.j.j();
        } else {
            if (this.f29502r.get()) {
                return;
            }
            this.f29502r.set(true);
            new com.bytedance.sdk.openadsdk.core.r.xt("device_acquire_od").j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.6
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.f29502r != null) {
                        m.this.f29502r.set(false);
                    }
                }
            }).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.embedapplog.j.j(oq.i().tl());
                    com.bytedance.embedapplog.j.j();
                    if (m.this.f29502r != null) {
                        m.this.f29502r.set(false);
                    }
                }
            });
        }
    }

    private void j(Context context) {
        final com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        com.bytedance.embedapplog.tl tlVar = new com.bytedance.embedapplog.tl("164362", "unionser_slardar_applog");
        if (w5 != null) {
            boolean cw = w5.cw();
            tlVar.xt(cw);
            if (!cw) {
                tlVar.xt(w5.oq());
            }
            tlVar.j(w5.r());
            if (h.xt >= 4600) {
                tlVar.cw(w5.m());
                if (h.m() && h.xt >= 4900) {
                    tlVar.j(w5.ws());
                }
            }
        }
        tlVar.r(!com.bytedance.sdk.openadsdk.core.r.j.cw());
        tlVar.j(new com.bytedance.embedapplog.ae() { // from class: com.bytedance.sdk.openadsdk.core.m.1
            @Override // com.bytedance.embedapplog.ae
            public String j() {
                com.bytedance.sdk.openadsdk.i.cw.cw.r rVar = w5;
                if (rVar == null || rVar.r()) {
                    return com.bytedance.sdk.openadsdk.av.xt.j();
                }
                return null;
            }

            @Override // com.bytedance.embedapplog.ae
            public boolean cw() {
                return v.xt().gq();
            }

            @Override // com.bytedance.embedapplog.ae
            public String j(Context context2) {
                return com.bytedance.sdk.component.utils.i.xt(context2);
            }

            @Override // com.bytedance.embedapplog.ae
            public Looper m() {
                return com.bytedance.sdk.component.utils.tl.j().getLooper();
            }

            @Override // com.bytedance.embedapplog.ae
            public boolean r() {
                return com.bytedance.sdk.openadsdk.core.rn.az.j();
            }

            @Override // com.bytedance.embedapplog.ae
            public Looper up() {
                return com.bytedance.sdk.component.utils.tl.j().getLooper();
            }

            @Override // com.bytedance.embedapplog.ae
            public String xt() {
                return kt.v();
            }

            @Override // com.bytedance.embedapplog.ae
            public String j(String str) {
                return com.bytedance.sdk.openadsdk.core.rn.ch.xt(str);
            }

            @Override // com.bytedance.embedapplog.ae
            public JSONObject j(JSONObject jSONObject) {
                if (jSONObject != null) {
                    JSONArray tl = com.bytedance.sdk.openadsdk.core.rn.oq.tl();
                    try {
                        if (tl.length() != 0) {
                            jSONObject.put("ipv6_list", tl);
                        }
                    } catch (Exception unused) {
                    }
                }
                return jSONObject;
            }
        });
        tlVar.xt(0);
        tl();
        com.bytedance.embedapplog.j.j(context, tlVar);
        HashMap hashMap = new HashMap();
        String f6 = oq.i().f();
        hashMap.put("host_appid", TextUtils.isEmpty(f6) ? "164362" : f6);
        hashMap.put("is_plugin", Boolean.valueOf(h.j()));
        hashMap.put("sdk_version", "7.0.1.2");
        hashMap.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
        hashMap.put("sdk_api_version", h.cw);
        hashMap.put("channel", h.up());
        if (v.xt().w()) {
            hashMap.put("use_apm_sdk", "1");
        }
        com.bytedance.embedapplog.j.j((HashMap<String, Object>) hashMap);
    }

    private void tl() {
        boolean z5;
        final boolean tl = oq.i().tl();
        boolean g6 = oq.i().g();
        if (tl && !g6) {
            z5 = true;
        } else {
            z5 = false;
        }
        com.bytedance.embedapplog.j.j(z5);
        final boolean qv = oq.i().qv();
        com.bytedance.embedapplog.j.j(new com.bytedance.embedapplog.up() { // from class: com.bytedance.sdk.openadsdk.core.m.2
            @Override // com.bytedance.embedapplog.up
            public void j(up.j jVar) {
                if (jVar != null) {
                    com.bytedance.sdk.openadsdk.core.rn.f.j(jVar.f24072j);
                }
                if (qv || !tl || m.this.cw.get()) {
                    return;
                }
                m.this.j(new com.bytedance.sdk.openadsdk.av.r(jVar));
            }
        });
        if (g6) {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.this.j(new com.bytedance.sdk.openadsdk.av.r(com.bytedance.sdk.openadsdk.core.rn.f.cw(com.bytedance.sdk.openadsdk.core.rn.f.j(false))));
                }
            });
        } else if (!qv && tl) {
            com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.4
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.cw.get()) {
                        return;
                    }
                    m.this.j(new com.bytedance.sdk.openadsdk.av.r("timeout"));
                }
            }, 3000L);
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static void xt(String str, JSONObject jSONObject) {
        com.bytedance.embedapplog.j.j(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.av.r rVar) {
        this.cw.set(true);
        com.bytedance.sdk.openadsdk.core.rn.f.j(rVar);
    }

    public static m j() {
        return j.f29509j;
    }

    public void j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.bytedance.embedapplog.j.xt(str, jSONObject);
    }
}
