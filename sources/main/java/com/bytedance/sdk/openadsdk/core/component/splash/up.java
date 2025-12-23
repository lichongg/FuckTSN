package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.ry;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f28788j;

    public static void j(Context context, ry ryVar, n nVar, boolean z5, long j6) {
        if (context == null || nVar == null || ryVar == null || !v.xt().ry()) {
            return;
        }
        boolean z6 = ryVar.r() == 1;
        boolean z7 = ryVar.tl() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", ryVar.j());
            jSONObject.put("server_load_type", ryVar.xt());
            jSONObject.put("tmax_type", ryVar.rn());
            if (z5) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", ryVar.cw());
            jSONObject.put("splash_creative_type", ryVar.r());
            if (ryVar.v() > 0) {
                if (ryVar.v() == 22) {
                    jSONObject.put("check_cloud_error_code", ryVar.l());
                }
                jSONObject.put("splash_get_cache_error_code", ryVar.v());
            }
            if (z6) {
                if (z7) {
                    jSONObject.put("cache_image_duration", ryVar.ae());
                } else {
                    jSONObject.put("download_image_duration", ryVar.m());
                    jSONObject.put("download_client_start_time", ryVar.av());
                    jSONObject.put("download_net_time", ryVar.i());
                    jSONObject.put("download_client_end_time", ryVar.w());
                    jSONObject.put("img_conttype", ryVar.a());
                    jSONObject.put("img_net_bframe_time", ryVar.p());
                    jSONObject.put("img_net_aframe_time", ryVar.h());
                }
                if (!z5) {
                    jSONObject.put("client_start_time", ryVar.vl());
                    jSONObject.put("network_time", ryVar.jy());
                    jSONObject.put("sever_time", ryVar.ws());
                    jSONObject.put("client_end_time", ryVar.az());
                }
                jSONObject.put("load_duration", ryVar.up());
                jSONObject.put("image_resolution", ryVar.oq());
                jSONObject.put("image_cachetype", ryVar.tl());
                jSONObject.put("image_size", ryVar.g());
            }
            if (ryVar.x() > 0) {
                jSONObject.put("real_user_duration", j6 - ryVar.x());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", ryVar.ch());
            jSONObject.put("on_call_back_time", ryVar.s());
            jSONObject.put("load_suc_time", ryVar.la());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.r.j.r());
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, "splash_ad", "splash_ad_loadtime", j6 - ryVar.kt(), jSONObject);
    }

    public static void xt(ry ryVar, long j6) {
        if (ryVar == null) {
            return;
        }
        ryVar.cw(j6);
    }

    public static void cw(ry ryVar, long j6) {
        if (ryVar == null) {
            return;
        }
        ryVar.qv(j6);
    }

    public static void r(ry ryVar, long j6) {
        if (ryVar != null) {
            ryVar.av(System.currentTimeMillis() - j6);
        }
    }

    public static void xt(n nVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r rVar) {
        if (nVar == null || rVar == null || !v.xt().ry()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", rVar.r());
            jSONObject.put("load_resource_duration", rVar.up());
            jSONObject.put("render_duration", rVar.m());
            jSONObject.put("ren_seq", rVar.xt());
            jSONObject.put("real_ren_seq", rVar.cw());
            jSONObject.put("final_t", rVar.tl() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", rVar.g());
            jSONObject.put("meta_load_Optimization", nVar.u());
            jSONObject.put("serial_render", rVar.oq());
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.cw(nVar, "splash_ad", "splash_total_duration", rVar.ae(), jSONObject);
    }

    public static void j(ry ryVar) {
        if (ryVar == null) {
            return;
        }
        ryVar.j(System.currentTimeMillis() - ryVar.kt());
    }

    public static void j(ry ryVar, ry ryVar2) {
        if (ryVar == null || ryVar2 == null) {
            return;
        }
        ryVar.vl(System.currentTimeMillis());
        ryVar2.vl(System.currentTimeMillis());
        if (tj.cw.get()) {
            ryVar.cw(0);
            ryVar2.cw(0);
            tj.cw.set(false);
        } else {
            ryVar.cw(1);
            ryVar2.cw(1);
        }
    }

    public static void j(ry ryVar, long j6) {
        if (ryVar == null) {
            return;
        }
        ryVar.xt(j6);
    }

    public static void j(ry ryVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
        if (ryVar == null || tlVar == null) {
            return;
        }
        if (tlVar.up()) {
            ryVar.r(2);
        } else {
            ryVar.r(1);
        }
    }

    public static void j(ry ryVar, boolean z5) {
        if (ryVar == null) {
            return;
        }
        if (z5) {
            ryVar.up(1);
        } else {
            ryVar.up(2);
        }
    }

    public static void j(ry ryVar, com.bytedance.sdk.openadsdk.core.v.j.xt xtVar, Map<String, String> map) {
        if (xtVar == null || ryVar == null) {
            return;
        }
        int xt = xtVar.xt();
        if (ryVar.g() == 0.0d) {
            ryVar.j(xt / 1024.0f);
        }
        Bitmap j6 = xtVar.j();
        if (j6 != null && TextUtils.isEmpty(ryVar.oq())) {
            ryVar.j(j6.getWidth() + "X" + j6.getHeight());
        }
        if (map == null || map.size() <= 0 || ryVar.qv() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (Exception unused) {
                }
            }
        }
        ryVar.j(jSONObject);
    }

    public static void j(ry ryVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
        if (ryVar == null || mVar == null) {
            return;
        }
        long m6 = mVar.m();
        long tl = mVar.tl();
        long ae = mVar.ae();
        long g6 = mVar.g();
        ryVar.r(m6);
        ryVar.up(ae);
        ryVar.m(tl);
        ryVar.ae(g6);
    }

    public static void j(n nVar, ry ryVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
        if (nVar == null || ryVar == null || tlVar == null || tlVar.up() || ryVar.tl() == 1 || !v.xt().ry()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", ryVar.g());
            jSONObject.put("image_resolution", ryVar.oq());
            jSONObject.put("download_client_start_time", ryVar.av());
            jSONObject.put("download_net_time", ryVar.i());
            jSONObject.put("download_client_end_time", ryVar.w());
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - ryVar.mi(), jSONObject);
    }

    public static void j(ry ryVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, long j6) {
        if (ryVar == null || tlVar == null) {
            return;
        }
        long ae = tlVar.ae();
        ryVar.oq(j6 - ae);
        ryVar.kt(tlVar.tl() - ae);
    }

    public static void j(boolean z5, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
        if (xtVar == null || aeVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = j(xtVar, z5 ? 4 : 3, nVar);
        if (j6 == null) {
            return;
        }
        ws.j().cw(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.up.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                int i6;
                int i7;
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar2 = com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae.this;
                if (aeVar2 != null) {
                    i6 = aeVar2.ae();
                    i7 = com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae.this.r();
                } else {
                    i6 = 1;
                    i7 = -1;
                }
                try {
                    jSONObject.put("if_have_cache", i6);
                    jSONObject.put("if_have_rt_ads", i7);
                } catch (Throwable unused) {
                }
                return j6.xt(jSONObject.toString());
            }
        });
    }

    private static com.bytedance.sdk.openadsdk.core.kt.j.xt j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6, n nVar) {
        String str;
        String str2;
        String str3;
        if (nVar != null) {
            str = nVar.fs();
            str3 = nVar.os();
            str2 = uf.jy(nVar);
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = uf.tl();
        }
        com.bytedance.sdk.openadsdk.core.kt.j.xt cw = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().m(str2).j(i6).cw(xtVar.r());
        if (str != null) {
            cw.r(str);
        }
        if (str3 != null) {
            cw.tl(str3);
        }
        return cw;
    }

    public static void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final long j6) {
        if (xtVar == null) {
            return;
        }
        ws.j().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.up.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j6);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(3).cw(xtVar.r()).m(uf.tl()).xt(jSONObject.toString());
            }
        });
    }

    public static void j(ry ryVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, long j6, n nVar) {
        if (tlVar == null || ryVar == null || nVar == null) {
            return;
        }
        if (!tlVar.up()) {
            m.j(j6, false, true, nVar, 0L, "loadSuccess");
            if (!tlVar.m()) {
                j(ryVar, SystemClock.elapsedRealtime() - j6);
                com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, "splash_ad", SystemClock.elapsedRealtime() - j6);
            } else {
                xt(ryVar, SystemClock.elapsedRealtime() - j6);
            }
        }
        j(ryVar, tlVar.m());
        j(ryVar, tlVar.r(), tlVar.g());
        j(ryVar, tlVar, System.currentTimeMillis());
        j(ryVar, tlVar.jy());
    }

    public static void j(ry ryVar, String str) {
        if (ryVar == null) {
            return;
        }
        ryVar.xt(str);
    }

    public static void j(boolean z5, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final boolean z6, final boolean z7) {
        if (nVar == null || xtVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = j(xtVar, z5 ? 4 : 3, nVar);
        if (j6 == null) {
            return;
        }
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.up.3
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!z7) {
                        jSONObject.put("image_CacheType", z6 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return j6.xt(jSONObject.toString());
            }
        });
    }

    public static void j(boolean z5, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (nVar == null || xtVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = j(xtVar, z5 ? 4 : 3, nVar);
        if (j6 == null) {
            return;
        }
        ws.j().r(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.up.4
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.this;
            }
        });
    }

    public static void j(n nVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r rVar) {
        if (rVar == null || nVar == null || !v.xt().ry()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", rVar.j());
            jSONObject.put("render_sequence", rVar.xt());
            jSONObject.put("real_render_sequence", rVar.cw());
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(nVar, "splash_ad", "splash_render_duration", rVar.m(), jSONObject);
    }

    public static void j(n nVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r rVar, g gVar) {
        if (nVar == null || gVar == null) {
            return;
        }
        if (hh.j(nVar) == 1) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "自渲染 ");
            rVar.cw(99);
        } else if (gVar.xt()) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "模版兜底 ");
            rVar.cw(99);
        } else {
            int xt = hh.xt(nVar);
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "模版渲染 ".concat(String.valueOf(xt)));
            rVar.cw(xt);
        }
    }

    public static void j(ry ryVar, ry ryVar2, nd ndVar, int i6, int i7) {
        if (ryVar == null || ryVar2 == null) {
            return;
        }
        ryVar.j(i6);
        ryVar.xt(i7);
        ryVar.az(ndVar.tl);
        ryVar2.j(i6);
        ryVar2.xt(i7);
        ryVar2.az(ndVar.tl);
    }

    public static void j(ry ryVar, int i6) {
        if (ryVar == null || ryVar.rn() >= i6) {
            return;
        }
        ryVar.ae(i6);
    }

    public static void j(int i6, n nVar, String str, int i7) {
        if (i6 == 2) {
            if (f28788j) {
                return;
            } else {
                f28788j = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i6);
            if (i6 == 1) {
                jSONObject.put("show_cnt", i7);
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.cw(nVar, str, jSONObject);
        } catch (JSONException unused) {
        }
    }
}
