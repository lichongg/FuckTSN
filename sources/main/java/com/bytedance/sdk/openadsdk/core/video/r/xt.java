package com.bytedance.sdk.openadsdk.core.video.r;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.up.j;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.ch.ae;
import com.bytedance.sdk.openadsdk.core.ch.cw;
import com.bytedance.sdk.openadsdk.core.ch.jy;
import com.bytedance.sdk.openadsdk.core.ch.oq;
import com.bytedance.sdk.openadsdk.core.ch.tl;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.m.cw.qv;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile com.bykv.vk.openvk.component.video.api.up.j f31118j;
    private static volatile com.bykv.vk.openvk.component.video.api.up.j xt;

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(final r rVar, final j.InterfaceC0307j interfaceC0307j, final n nVar) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            int tl = nVar != null ? uf.tl(nVar) : 0;
            boolean j6 = oq.j();
            if (!xt(tl) || !j6) {
                j(rVar, interfaceC0307j, nVar, currentTimeMillis, j6);
                return;
            }
            if (v.j(10003) == null) {
                j(rVar, interfaceC0307j, nVar, currentTimeMillis, j6);
                return;
            }
            cw cwVar = (cw) AutoService.j(cw.class);
            if (cwVar == null || !cwVar.r()) {
                j(rVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - currentTimeMillis);
                r(rVar, interfaceC0307j, nVar);
            } else {
                final JSONObject j7 = new jy().j(rVar);
                cwVar.j("video_cache", j7, new ae() { // from class: com.bytedance.sdk.openadsdk.core.video.r.xt.2
                    @Override // com.bytedance.sdk.openadsdk.core.ch.ae
                    protected PluginValueSet j(int i6, tl tlVar) {
                        SparseArray<Object> r5;
                        ws.j();
                        if (tlVar == null) {
                            r5 = null;
                        } else {
                            r5 = tlVar.r();
                        }
                        ws.j(r5, j7);
                        return xt.xt(i6, tlVar, rVar, interfaceC0307j, currentTimeMillis, nVar);
                    }
                });
            }
        } catch (Exception e6) {
            vl.cw("pit predict error:" + e6.getMessage());
        }
    }

    private static boolean j(int i6) {
        return i6 == 3 || i6 == 4;
    }

    private static boolean xt(int i6) {
        return i6 == 8 || i6 == 7;
    }

    private static void r(final r rVar, final j.InterfaceC0307j interfaceC0307j, final n nVar) {
        rVar.m(ErrorCode.UNKNOWN_ERROR);
        rVar.ae(ErrorCode.UNKNOWN_ERROR);
        rVar.tl(ErrorCode.UNKNOWN_ERROR);
        if (nVar != null) {
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
                return;
            }
            if (rVar.cw() == 400) {
                cw(rVar, nVar);
                return;
            }
            xt(rVar, nVar);
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        j.InterfaceC0307j interfaceC0307j2 = new j.InterfaceC0307j() { // from class: com.bytedance.sdk.openadsdk.core.video.r.xt.3
            @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
            public void j(r rVar2, int i6) {
                j.InterfaceC0307j interfaceC0307j3 = j.InterfaceC0307j.this;
                if (interfaceC0307j3 != null) {
                    interfaceC0307j3.j(rVar2, i6);
                }
                if (nVar != null) {
                    xt.j(rVar, nVar, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                vl.j("VideoPreloadUtils", "pit onVideoPreloadSuccess: ", rVar.i());
            }

            @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
            public void xt(r rVar2, int i6) {
                j.InterfaceC0307j interfaceC0307j3 = j.InterfaceC0307j.this;
                if (interfaceC0307j3 != null) {
                    interfaceC0307j3.j(rVar2, i6);
                }
                n nVar2 = nVar;
                if (nVar2 != null) {
                    xt.cw(rVar, nVar2);
                }
                vl.j("VideoPreloadUtils", "pit cancel: ", rVar.i());
            }

            @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
            public void j(r rVar2, int i6, String str) {
                j.InterfaceC0307j interfaceC0307j3 = j.InterfaceC0307j.this;
                if (interfaceC0307j3 != null) {
                    interfaceC0307j3.j(rVar2, i6, str);
                }
                if (nVar != null) {
                    xt.xt(rVar, nVar, SystemClock.elapsedRealtime() - elapsedRealtime, i6, str);
                }
                vl.j("VideoPreloadUtils", "pit onVideoPreloadFail: ", rVar.i());
            }
        };
        try {
            if (rVar.w() != 0 || Build.VERSION.SDK_INT >= 23) {
                xt(rVar).j(v.getContext(), rVar, interfaceC0307j2);
            } else {
                com.bykv.vk.openvk.component.video.j.xt.m.j.j().j(rVar);
            }
        } catch (Exception e6) {
            if (interfaceC0307j != null) {
                vl.j("VideoPreloadUtils", "pit exception onVideoPreloadFail: ", rVar.i());
                interfaceC0307j.j(rVar, -1, e6.getMessage());
            }
            if (nVar != null) {
                xt(rVar, nVar, SystemClock.elapsedRealtime() - elapsedRealtime, -1, e6.getMessage());
            }
            vl.j(e6);
        }
    }

    private static com.bykv.vk.openvk.component.video.api.up.j xt(r rVar) {
        if (rVar.w() == 1) {
            if (xt == null) {
                synchronized (xt.class) {
                    try {
                        if (xt == null) {
                            xt = new com.bytedance.sdk.component.vl.xt.xt.j();
                        }
                    } finally {
                    }
                }
            }
            return xt;
        }
        if (f31118j == null) {
            synchronized (xt.class) {
                try {
                    if (f31118j == null) {
                        f31118j = new com.bykv.vk.openvk.component.video.j.j.xt.j();
                    }
                } finally {
                }
            }
        }
        return f31118j;
    }

    public static void j(final r rVar, final j.InterfaceC0307j interfaceC0307j) {
        if (rVar == null) {
            xt(null, interfaceC0307j, null);
            return;
        }
        rVar.m();
        rVar.jy();
        final n j6 = j(rVar);
        if (rVar.m() <= 0 && !rVar.jy()) {
            xt(rVar, interfaceC0307j, j6);
        } else if (com.bytedance.sdk.openadsdk.l.ae.j()) {
            com.bytedance.sdk.openadsdk.l.ae.j(new g("csj_vPreload") { // from class: com.bytedance.sdk.openadsdk.core.video.r.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.cw(rVar, interfaceC0307j, j6);
                }
            });
        } else {
            cw(rVar, interfaceC0307j, j6);
        }
    }

    private static void j(r rVar, j.InterfaceC0307j interfaceC0307j, n nVar, long j6, boolean z5) {
        j(rVar, -1000, z5 ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j6);
        r(rVar, interfaceC0307j, nVar);
    }

    private static void xt(r rVar, j.InterfaceC0307j interfaceC0307j, n nVar) {
        if (interfaceC0307j != null) {
            interfaceC0307j.j(rVar, -100);
        }
        if (nVar != null) {
            if (xt(uf.tl(nVar)) || j(uf.tl(nVar))) {
                j(rVar, nVar, 0L);
            }
        }
    }

    private static void j(r rVar, int i6, int i7, String str, JSONObject jSONObject, long j6) {
        JSONObject j7 = rVar.j();
        try {
            j7.put("pitaya_cache_size", i6);
            j7.put("pitaya_code", i7);
            j7.put("pitaya_msg", str);
            j7.put("ext_plugin_code", wq.xt());
            j7.put(WiseOpenHianalyticsData.UNION_PACKAGE, jSONObject);
            j7.put("run_task_mills", j6);
        } catch (Exception e6) {
            e6.getMessage();
        }
    }

    private static boolean cw(r rVar) {
        return Build.VERSION.SDK_INT >= 23 || rVar.w() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PluginValueSet xt(int i6, tl tlVar, r rVar, j.InterfaceC0307j interfaceC0307j, long j6, n nVar) {
        int i7;
        int i8;
        String str;
        try {
        } catch (Exception e6) {
            e6.getMessage();
        }
        if (tlVar == null) {
            j(rVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j6);
            r(rVar, interfaceC0307j, nVar);
            return null;
        }
        com.bytedance.sdk.openadsdk.i.j cw = tlVar.cw();
        if (cw == null) {
            j(rVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j6);
            r(rVar, interfaceC0307j, nVar);
            return null;
        }
        PluginValueSet r5 = cw.r();
        if (r5 == null) {
            j(rVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j6);
            r(rVar, interfaceC0307j, nVar);
            return null;
        }
        JSONObject jSONObject = (JSONObject) r5.objectValue(2, JSONObject.class);
        r5.stringValue(5);
        JSONObject jSONObject2 = (JSONObject) r5.objectValue(3, JSONObject.class);
        JSONObject jSONObject3 = (JSONObject) r5.objectValue(4, JSONObject.class);
        if (!cw.j() || jSONObject == null) {
            i7 = -1000;
            i8 = -5;
            str = null;
        } else {
            i7 = jSONObject.optInt("pitaya_cache_size", -1);
            i8 = jSONObject.optInt("pitaya_code", 200);
            str = "success";
            jy.j(rVar, jSONObject, i7, i8);
        }
        if (!cw.j() && jSONObject3 != null) {
            str = jSONObject3.toString();
        }
        j(rVar, i7, i8, str, jSONObject2, System.currentTimeMillis() - j6);
        r(rVar, interfaceC0307j, nVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(r rVar, n nVar) {
        if (cw(rVar)) {
            String xt2 = uf.xt(nVar);
            JSONObject j6 = com.bytedance.sdk.openadsdk.m.xt.r.j(rVar, null, -1, rVar.w(), nVar, -1L);
            com.bytedance.sdk.openadsdk.m.cw.oq oqVar = new com.bytedance.sdk.openadsdk.m.cw.oq(rVar.av(), rVar.m());
            oqVar.j(rVar);
            com.bytedance.sdk.openadsdk.m.xt.r.r((com.bytedance.sdk.openadsdk.m.cw.xt<com.bytedance.sdk.openadsdk.m.cw.oq>) new com.bytedance.sdk.openadsdk.m.cw.xt(nVar, xt2, j6, oqVar));
        }
    }

    public static n j(r rVar) {
        if (rVar == null) {
            return null;
        }
        Object up = rVar.up("material_meta");
        if (up instanceof n) {
            return (n) up;
        }
        return null;
    }

    public static void j(r rVar, n nVar, long j6) {
        if (cw(rVar)) {
            String xt2 = uf.xt(nVar);
            JSONObject j7 = com.bytedance.sdk.openadsdk.m.xt.r.j(rVar, null, -1, rVar.w(), nVar, -1L);
            com.bytedance.sdk.openadsdk.m.cw.jy jyVar = new com.bytedance.sdk.openadsdk.m.cw.jy();
            jyVar.j(rVar.av());
            jyVar.j(rVar.m());
            jyVar.xt(j6);
            jyVar.j(rVar);
            if (rVar.f() == 1) {
                jyVar.cw(1L);
            } else {
                jyVar.cw(0L);
            }
            com.bytedance.sdk.openadsdk.m.xt.r.xt((com.bytedance.sdk.openadsdk.m.cw.xt<com.bytedance.sdk.openadsdk.m.cw.jy>) new com.bytedance.sdk.openadsdk.m.cw.xt(nVar, xt2, j7, jyVar));
        }
    }

    private static void xt(r rVar, n nVar) {
        if (cw(rVar)) {
            long vl = rVar.jy() ? rVar.vl() : rVar.m();
            String xt2 = uf.xt(nVar);
            JSONObject j6 = com.bytedance.sdk.openadsdk.m.xt.r.j(rVar, null, -1, rVar.w(), nVar, -1L);
            com.bytedance.sdk.openadsdk.m.cw.vl vlVar = new com.bytedance.sdk.openadsdk.m.cw.vl(rVar.av(), vl);
            vlVar.j(rVar);
            com.bytedance.sdk.openadsdk.m.xt.r.j((com.bytedance.sdk.openadsdk.m.cw.xt<com.bytedance.sdk.openadsdk.m.cw.vl>) new com.bytedance.sdk.openadsdk.m.cw.xt(nVar, xt2, j6, vlVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(r rVar, n nVar, long j6, int i6, String str) {
        if (cw(rVar)) {
            String xt2 = uf.xt(nVar);
            JSONObject j7 = com.bytedance.sdk.openadsdk.m.xt.r.j(rVar, null, -1, rVar.w(), nVar, -1L);
            qv qvVar = new qv();
            qvVar.j(rVar.av());
            qvVar.j(rVar.m());
            qvVar.xt(j6);
            qvVar.j(i6);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            qvVar.xt(str);
            qvVar.cw("");
            qvVar.j(rVar);
            com.bytedance.sdk.openadsdk.m.xt.r.cw((com.bytedance.sdk.openadsdk.m.cw.xt<qv>) new com.bytedance.sdk.openadsdk.m.cw.xt(nVar, xt2, j7, qvVar));
        }
    }
}
