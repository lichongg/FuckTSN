package com.bytedance.msdk.cw.tl;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.oq.g;
import com.bytedance.msdk.tl.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    public static com.bytedance.msdk.cw.j.j j(com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, com.bytedance.msdk.cw.j.xt xtVar3) {
        com.bytedance.msdk.core.oq.j j6;
        com.bytedance.msdk.api.r.j.xt.cw.j j7;
        if (xtVar != null && xtVar2 != null) {
            xtVar.j(j(xtVar2, xtVar));
            xtVar.xt(xtVar2.v());
            if (xtVar.oq()) {
                com.bytedance.msdk.m.xt.j(com.bytedance.msdk.core.xt.getContext(), xtVar.jy());
                if (com.bytedance.msdk.m.xt.j.j(xtVar.jy()) != null && (j6 = com.bytedance.msdk.ae.j.xt.j().j(xtVar.jy())) != null && j6.cw() != null && (j7 = j6.cw().j(xtVar.s(), xtVar.az())) != null && j(j7)) {
                    return com.bytedance.msdk.cw.cw.xt.j.r.j(j7.j(), xtVar, xtVar3);
                }
            } else {
                if (xtVar.qv()) {
                    return com.bytedance.msdk.cw.cw.xt.j.r.j(xtVar, xtVar3);
                }
                if (com.bytedance.msdk.core.ae.cw.j(xtVar.tl())) {
                    return new com.bytedance.msdk.cw.cw.xt.j.cw(xtVar3);
                }
            }
        }
        return null;
    }

    public static String j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2) {
        if (xtVar != null && xtVar2 != null) {
            r0 = TextUtils.isEmpty(xtVar.j()) ? null : xtVar.j();
            if (!TextUtils.isEmpty(xtVar2.vl())) {
                return (r0 + "_") + xtVar2.vl();
            }
        }
        return r0;
    }

    public static boolean j(com.bytedance.msdk.api.r.j.xt.cw.j jVar) {
        Object apply;
        if (jVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> ae = com.bytedance.msdk.core.qv.j.j().ae();
        if (ae != null) {
            if (!TextUtils.isEmpty(jVar.j())) {
                e a6 = e.a();
                a6.g(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, jVar.j());
                com.bytedance.msdk.j.up.cw.xt("TMe", "custom className is " + jVar.j());
                a6.e(-99999987, 8229);
                a6.f(-99999985, Boolean.class);
                apply = ae.apply(a6.k().sparseArray());
                return ((Boolean) apply).booleanValue();
            }
            com.bytedance.msdk.j.up.cw.xt("TMe", "custom className is empty");
        } else {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "load ad check custom name class loader is null ");
        }
        return false;
    }

    public static Map<String, Object> j(com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (xtVar != null && xtVar2 != null) {
            com.bytedance.msdk.core.oq.j j6 = com.bytedance.msdk.core.xt.xt().j(xtVar.jy());
            if (j6 != null) {
                concurrentHashMap.put("tt_ad_network_config_appid", j6.j());
                concurrentHashMap.put("tt_ad_network_config_appKey", j6.xt());
            }
            concurrentHashMap.put("tt_ad_origin_type", Integer.valueOf(xtVar.ws()));
            concurrentHashMap.put("tt_ad_sub_type", Integer.valueOf(xtVar.az()));
            Map<String, Object> c6 = xtVar2.c();
            if (c6 != null && c6.size() > 0) {
                for (Map.Entry<String, Object> entry : c6.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        concurrentHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            int ch = xtVar2.ch();
            int s5 = xtVar2.s();
            if (ch < 0) {
                ch = 0;
            }
            if (s5 < 0) {
                s5 = 0;
            }
            concurrentHashMap.put("ad_height", Integer.valueOf(s5));
            concurrentHashMap.put("ad_width", Integer.valueOf(ch));
            concurrentHashMap.put("ad_type", Integer.valueOf(xtVar2.f()));
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    if (entry2.getKey() != null && entry2.getValue() != null) {
                        concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, g gVar, String str) {
        if (cwVar == null || xtVar2 == null || xtVar == null) {
            return;
        }
        if ((xtVar2.mi() == 0 || xtVar2.mi() == 100) && xtVar2.l() != 0.0d) {
            cwVar.j(xtVar2.l());
        }
        if (xtVar2.v()) {
            cwVar.xt(xtVar2.p());
            cwVar.cw(xtVar2.h());
            if (xtVar2.la() != null) {
                cwVar.up(xtVar2.la().cw());
                cwVar.m(xtVar2.la().r());
                cwVar.cw(xtVar2.la().tl());
                cwVar.r(xtVar2.la().g());
                cwVar.r(xtVar2.la().j());
            }
        }
        cwVar.az(xtVar2.mi());
        cwVar.i(xtVar2.kt());
        cwVar.av(xtVar2.tj());
        if (str == null) {
            str = "";
        }
        cwVar.w(str);
        cwVar.av(xtVar2.jy());
        cwVar.i(xtVar2.tl() != null ? xtVar2.tl().av() : "");
        cwVar.az(xtVar2.gq());
        cwVar.j(SystemClock.elapsedRealtime());
        cwVar.kt(xtVar2.vl());
        cwVar.mi(xtVar2.xt());
        cwVar.jy(com.bytedance.msdk.xt.j.xt(xtVar2.jy()));
        cwVar.ae(xtVar2.ae());
        cwVar.tl(xtVar2.m());
        cwVar.ae(xtVar.j());
        cwVar.g(xtVar2.ae());
        cwVar.oq(xtVar2.m());
        cwVar.m(xtVar2.ws());
        cwVar.up(xtVar2.az());
        cwVar.ws(xtVar.f());
        cwVar.cw(xtVar2.rn());
        cwVar.j(xtVar2.a());
        h.j(cwVar, xtVar2.tl(), xtVar, false);
        if (gVar != null) {
            int i6 = gVar.xt;
            cwVar.xt("if_test", Integer.valueOf(i6 == 1 ? i6 : 0));
            cwVar.xt("server_bidding_extra", gVar.f24631j);
            int tl = cwVar.tl(xtVar.j());
            if (tl == 1 || tl == 2) {
                cwVar.cw(gVar.up);
            }
        }
        if (xtVar2.la() == null || xtVar2.la() == null) {
            return;
        }
        cwVar.j("extra_data_and_no_parse", xtVar2.la().xt());
    }
}
