package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.AdSettings;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.dutexplorer.tmapcloak;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.qq.e.comm.managers.status.SDKStatus;
import java.io.Serializable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static int f28809j;

    /* renamed from: m, reason: collision with root package name */
    private static AtomicBoolean f28810m;
    private static Boolean xt;
    private final la cw = new la();

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f28811r = false;
    private AtomicBoolean up = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public String ae() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable unused) {
                return "unity_pure";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m() {
        if (xt == null) {
            try {
                Class.forName("kotlin.Result");
                xt = Boolean.TRUE;
            } catch (Throwable unused) {
                xt = Boolean.FALSE;
            }
        }
        return xt.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int up() {
        if (f28809j == 0) {
            try {
                try {
                    Class.forName("androidx.core.content.FileProvider");
                    f28809j = 1;
                } catch (Throwable unused) {
                    Class.forName("androidx.core.content.FileProvider");
                    f28809j = 2;
                }
            } catch (Throwable unused2) {
                f28809j = -1;
            }
        }
        return f28809j;
    }

    public cw(Bundle bundle) {
        if (bundle != null && bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
            if (com.bykv.j.j.j.j.f.a(serializable)) {
                com.bytedance.sdk.openadsdk.core.s.j.xt.j().j(a1.b.a(serializable));
            }
        }
    }

    public la xt() {
        return this.cw;
    }

    private void xt(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                h.f29116j = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private static void j(com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, boolean z5) {
        if (j(jVar)) {
            com.bytedance.sdk.openadsdk.tools.xt.cw(1, z5 ? "1" : "0");
            j(jVar.qv());
            com.bytedance.sdk.openadsdk.tools.xt.xt(2, jVar.j());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.tools.xt.cw(2, "0");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.tools.xt.cw(2, "1");
            }
            com.bytedance.sdk.openadsdk.tools.xt.xt(0, h.cw);
        }
    }

    private void xt(@ForbidWrapParam com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        if (jVar == null) {
            return;
        }
        String xt2 = jVar.xt();
        if (xt2 == null || xt2.isEmpty()) {
            xt2 = com.bytedance.sdk.openadsdk.core.tl.j.xt(v.getContext());
        }
        oq.i().j(a1.b.a(pluginValueSet.objectValue(16, a1.a.a())));
        oq.i().r(xt2);
        oq.i().cw(jVar.j());
        oq.i().cw(jVar.cw());
        oq.i().up(jVar.r());
        oq.i().m(jVar.up());
        oq.i().xt(jVar.m());
        oq.i().up(jVar.ws());
        oq.i().r(jVar.ae());
        oq.i().j(jVar.g());
        oq.i().ae(jVar.av());
        oq.i().j(jVar.qv());
        if (h.xt >= 5500) {
            oq.i().r(jVar.jy());
            oq.i().j(jVar.vl());
        } else {
            oq.i().r(pluginValueSet.intValue(7));
            oq.i().j(pluginValueSet.intValue(8));
        }
        if (j(jVar)) {
            com.bytedance.sdk.component.utils.vl.xt();
            com.bytedance.sdk.openadsdk.tools.xt.xt();
            com.ss.android.socialbase.downloader.m.j.j(2);
        }
    }

    private static void j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar) {
        String str;
        String str2;
        String str3;
        if (rVar == null || rVar.jy()) {
            rVar = oq.f29757j;
        }
        com.bytedance.sdk.openadsdk.tools.xt.cw(19, rVar.jy() ? "1" : "0");
        com.bytedance.sdk.openadsdk.tools.xt.cw(7, String.valueOf(rVar.j() ? 1 : 0));
        com.bytedance.sdk.openadsdk.i.cw.cw.cw g6 = rVar.g();
        String str4 = "";
        if (g6 == null) {
            str = "";
        } else {
            str = g6.j() + "," + g6.xt();
        }
        com.bytedance.sdk.openadsdk.tools.xt.cw(8, str);
        com.bytedance.sdk.openadsdk.tools.xt.cw(9, String.valueOf(rVar.cw() ? 1 : 0));
        String oq = rVar.oq();
        if (oq == null) {
            str2 = "";
        } else {
            str2 = oq.trim();
        }
        com.bytedance.sdk.openadsdk.tools.xt.cw(10, str2);
        com.bytedance.sdk.openadsdk.tools.xt.cw(11, String.valueOf(rVar.r() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.xt.cw(12, String.valueOf(rVar.up() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.xt.cw(17, String.valueOf(rVar.xt() ? 1 : 0));
        if (h.xt >= 4600) {
            com.bytedance.sdk.openadsdk.tools.xt.cw(22, String.valueOf(rVar.m() ? 1 : 0));
        }
        if (h.xt >= 7000) {
            com.bytedance.sdk.openadsdk.tools.xt.cw(24, String.valueOf(rVar.tl() ? 1 : 0));
        }
        String qv = rVar.qv();
        if (qv == null) {
            str3 = "";
        } else {
            str3 = qv.trim();
        }
        com.bytedance.sdk.openadsdk.tools.xt.cw(18, str3);
        try {
            if (rVar.vl() != null) {
                str4 = rVar.vl().trim();
            }
            com.bytedance.sdk.openadsdk.tools.xt.cw(13, str4);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.vl.cw("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(@ForbidWrapParam final Context context, final long j6, final long j7, final long j8, final ch chVar, final boolean z5, final com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, final String str, final int i6, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.p.ae aeVar) {
        tj.cw();
        if (v.xt().ry()) {
            com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.cw.6
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    boolean tj = oq.i().tj();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j6);
                    jSONObject.put("is_async", z5);
                    jSONObject.put("is_multi_process", jVar.oq());
                    jSONObject.put("is_debug", cw.j(jVar));
                    jSONObject.put("is_activate_init", tj);
                    jSONObject.put("is_plugin", h.j());
                    jSONObject.put("has_kotlin", cw.m());
                    jSONObject.put("use_mediation", jVar.av());
                    jSONObject.put("is_androidx", cw.up());
                    jSONObject.put("host_abi", com.bytedance.sdk.openadsdk.core.s.xt.xt.j());
                    jSONObject.put("minSdkVersion", com.bytedance.sdk.openadsdk.core.rn.uf.r(context));
                    jSONObject.put("targetSdkVersion", com.bytedance.sdk.openadsdk.core.rn.uf.cw(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", h.r());
                    jSONObject.put("is_keva_init_success", com.bytedance.sdk.openadsdk.core.rn.h.xt());
                    jSONObject.put(CrashHianalyticsData.THREAD_NAME, str);
                    jSONObject.put("thread_priority", i6);
                    jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.r.j.r());
                    jSONObject.put("opt_config", String.valueOf(aeVar));
                    oq.i().xt(false);
                    Object objectValue = pluginValueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j6);
                    jSONObject2.put("callback_cost", j7);
                    jSONObject2.put("total_cost", j8);
                    if (objectValue != null) {
                        jSONObject2.put("plugin", objectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    chVar.j(jSONObject3, 20L);
                    jSONObject2.put("init", jSONObject3);
                    jSONObject.put("cost", jSONObject2);
                    if (!jVar.av()) {
                        try {
                            Object invoke = AdSettings.class.getMethod("getSDKVersion", null).invoke(null, null);
                            if (invoke instanceof String) {
                                jSONObject.put("baidu_version", invoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object invoke2 = SDKStatus.class.getMethod("getIntegrationSDKVersion", null).invoke(null, null);
                            if (invoke2 instanceof String) {
                                jSONObject.put("gdt_version", invoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object invoke3 = Class.forName(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME).getMethod("getSDKVersion", null).invoke(null, null);
                            if (invoke3 instanceof String) {
                                jSONObject.put("ks_version", invoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    Object ae = cw.this.ae();
                    if (ae != null) {
                        jSONObject.put("develop_type", ae);
                    }
                    com.bytedance.sdk.openadsdk.core.kt.j.xt xt2 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("pangle_sdk_init").xt(jSONObject.toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(j7);
                    return xt2.up(sb.toString());
                }
            }, "pangle_sdk_init");
        }
    }

    public static boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.j jVar) {
        AtomicBoolean atomicBoolean = f28810m;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z5 = jVar.tl() && com.bytedance.sdk.openadsdk.core.rn.tl.j();
        f28810m = new AtomicBoolean(z5);
        return z5;
    }

    public boolean j() {
        return this.f28811r;
    }

    public void j(final Context context, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.wq.cw cwVar) {
        long elapsedRealtime;
        String name;
        int priority;
        try {
            final com.bytedance.sdk.openadsdk.i.cw.cw.j jVar = new com.bytedance.sdk.openadsdk.i.cw.cw.j(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
            v.j(context);
            try {
                elapsedRealtime = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
            } catch (Exception unused) {
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
            if (elapsedRealtime == 0) {
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
            final long j6 = elapsedRealtime;
            final ch j7 = ch.j("duration");
            Thread currentThread = Thread.currentThread();
            try {
                name = pluginValueSet.stringValue(2, currentThread.getName());
            } catch (Exception unused2) {
                name = currentThread.getName();
            }
            final String str = name;
            try {
                priority = pluginValueSet.intValue(3, currentThread.getPriority());
            } catch (Exception unused3) {
                priority = currentThread.getPriority();
            }
            final int i6 = priority;
            xt(pluginValueSet);
            oq.i().az();
            if (this.f28811r) {
                j(cwVar);
                return;
            }
            j(jVar, pluginValueSet);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            j(pluginValueSet);
            j7.j("init_thread_cost", SystemClock.elapsedRealtime() - elapsedRealtime2);
            final long elapsedRealtime3 = SystemClock.elapsedRealtime() - j6;
            j7.xt("sync_cost");
            com.bytedance.sdk.component.oq.qv.xt.vl().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    j7.xt("async_wait_cost");
                    if (cw.this.j(context, jVar, cwVar, j7)) {
                        j7.xt("async_done_cost");
                        long elapsedRealtime4 = SystemClock.elapsedRealtime() - j6;
                        j7.j();
                        cw.this.j(context, elapsedRealtime3, elapsedRealtime4, SystemClock.elapsedRealtime() - j6, j7, true, jVar, str, i6, pluginValueSet, v.xt().fk());
                    }
                }
            });
            com.bytedance.sdk.component.oq.ae.j(-1);
            com.bytedance.sdk.openadsdk.j.xt.xt.j();
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("init Async") { // from class: com.bytedance.sdk.openadsdk.core.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cw.this.up.get()) {
                            return;
                        }
                        cw.this.up.set(true);
                        m.j();
                        com.bytedance.sdk.openadsdk.core.rn.oq.cw();
                        com.bytedance.sdk.openadsdk.j.j.j.j(false);
                        com.bytedance.sdk.component.panglearmor.g.j();
                        com.bytedance.sdk.openadsdk.av.xt.j(context);
                        com.bytedance.sdk.openadsdk.av.xt.xt();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.vl.xt("Init sync exception: ".concat(String.valueOf(th)));
                    }
                }
            });
            tj.f30204j = true;
        } catch (Throwable th) {
            j(cwVar, th);
            j(new com.bytedance.sdk.openadsdk.i.cw.cw.j(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>()), this.f28811r);
        }
    }

    private void j(@ForbidWrapParam com.bytedance.sdk.openadsdk.core.wq.cw cwVar, Throwable th) {
        if (cwVar != null) {
            String message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            cwVar.j(1, com.bytedance.sdk.openadsdk.i.up.j().j(false).j(4000).j(message).xt());
            com.bytedance.sdk.component.utils.vl.cw("TTAdSdk", " init fail, msg = ", message);
        }
        this.f28811r = false;
    }

    private void j(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            com.bytedance.sdk.openadsdk.core.h.j.j();
        } catch (Exception unused) {
        }
    }

    private void j(com.bytedance.sdk.openadsdk.core.wq.cw cwVar) {
        com.bytedance.sdk.openadsdk.core.cw.j.j();
        if (cwVar != null) {
            cwVar.j(AVMDLDataLoader.KeyIsLiveSetP2pAllow, com.bytedance.sdk.openadsdk.i.up.j().j(true).j(com.bytedance.sdk.openadsdk.i.r.j().j(20, com.bytedance.sdk.component.oq.qv.xt.g()).xt()).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, @ForbidWrapParam com.bytedance.sdk.openadsdk.core.wq.cw cwVar, ch chVar) {
        if (this.f28811r) {
            j(cwVar);
            return false;
        }
        try {
            if (com.bytedance.sdk.openadsdk.core.r.j.cw()) {
                if (!tmapcloak.loadLibSuccess) {
                    j(cwVar, new Exception("load maparmor fail"));
                    return false;
                }
                chVar.xt("maparmor_load_cost");
            }
            j(context, jVar, chVar);
            this.f28811r = true;
            j(context, jVar);
            chVar.xt("async_init_cost");
            com.bytedance.sdk.component.utils.vl.r("TTAdSdk", "Init done finish: 7012");
            j(cwVar);
        } catch (Throwable th) {
            j(cwVar, th);
        }
        j(jVar, this.f28811r);
        return true;
    }

    private void j(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, ch chVar) {
        try {
            if (j(jVar)) {
                com.bytedance.sdk.openadsdk.core.rn.w.j();
                com.bykv.vk.openvk.component.video.api.m.cw.j();
                com.bytedance.sdk.component.g.j.j();
                com.bytedance.sdk.openadsdk.tools.xt.xt();
            }
        } catch (Throwable unused) {
        }
        chVar.xt("debug_set_cost");
        com.bytedance.sdk.openadsdk.core.multipro.r.j(context);
        chVar.xt("web_dir_cost");
        com.bytedance.sdk.component.g.cw.j.j((ThreadPoolExecutor) com.bytedance.sdk.component.oq.ae.j());
        chVar.xt("thread_pool_cost");
        com.bykv.vk.openvk.component.video.api.cw.j(jVar.oq());
        if (jVar.oq()) {
            com.bytedance.sdk.openadsdk.core.multipro.xt.j();
            oq.i().gq();
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.xt.xt();
        }
        chVar.xt("multi_cost");
        com.bykv.vk.openvk.component.video.api.cw.j(context, null);
        com.bykv.vk.openvk.component.video.j.j.j(context);
        chVar.xt("video_config_cost");
        tj.up();
        chVar.xt("dyna_init_cost");
        com.bytedance.sdk.openadsdk.core.rn.v.j(context);
        chVar.xt("armor_init_cost");
    }

    private void j(@ForbidWrapParam com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        xt(jVar, pluginValueSet);
        tj.r();
        com.bytedance.sdk.openadsdk.core.kt.xt.xt();
        try {
            com.bytedance.sdk.openadsdk.core.ugeno.up.j();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        if (jVar.oq()) {
            com.bytedance.sdk.openadsdk.core.rn.h.j();
        }
        com.bytedance.sdk.openadsdk.core.cw.cw.j().j(jVar.oq());
    }

    private void j(@ForbidWrapParam final Context context, @ForbidWrapParam final com.bytedance.sdk.openadsdk.i.cw.cw.j jVar) {
        com.bytedance.sdk.component.oq.ae.j(new com.bytedance.sdk.component.oq.g("init sync") { // from class: com.bytedance.sdk.openadsdk.core.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.qv.g.up();
                    com.bytedance.sdk.openadsdk.core.p.oq xt2 = v.xt();
                    if (!xt2.kk()) {
                        synchronized (xt2) {
                            try {
                                if (!xt2.kk()) {
                                    xt2.j();
                                }
                            } finally {
                            }
                        }
                    }
                    cw.this.j(jVar.oq(), context, true, 10000L);
                    com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.cw.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (oq.i().la()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.av.xt.cw();
                        }
                    }, 120000L);
                    com.bykv.vk.openvk.component.video.api.cw.j(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
                    com.bytedance.sdk.openadsdk.core.kt.xt.j(context, jVar.oq());
                    com.bytedance.sdk.openadsdk.core.qv.xt.cw();
                    wq.cw();
                    com.bykv.vk.openvk.component.video.j.j.j(com.bytedance.sdk.openadsdk.l.g.j(0));
                    if (xt2.vl()) {
                        final com.bykv.vk.openvk.component.video.api.j.xt j6 = com.bytedance.sdk.openadsdk.l.g.j(1);
                        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("preloadTTVideo") { // from class: com.bytedance.sdk.openadsdk.core.cw.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.vl.xt.xt.j(context, j6.r(), ExtractNativeUtils.f33109e, com.bytedance.sdk.openadsdk.l.g.xt(), com.bytedance.sdk.openadsdk.l.g.cw(), cw.j(jVar), new VideoEventEngineUploader() { // from class: com.bytedance.sdk.openadsdk.core.cw.3.2.1
                                    @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                                    public void onEvent(String str, JSONObject jSONObject) {
                                        m.j().j(str, jSONObject);
                                    }
                                });
                            }
                        });
                    }
                    com.bytedance.sdk.openadsdk.core.rn.oq.az();
                    tj.j(context);
                    com.bytedance.sdk.component.oq.ae.j(true);
                    com.bytedance.sdk.component.oq.ae.j(new com.bytedance.sdk.openadsdk.core.kt.xt.j());
                    com.bytedance.sdk.openadsdk.core.dislike.xt.j();
                    com.bytedance.sdk.openadsdk.core.rn.oq.j(context);
                    com.bytedance.sdk.openadsdk.j.xt.xt.cw(context);
                    com.bytedance.sdk.openadsdk.core.rn.oq.up(context);
                    com.bytedance.sdk.openadsdk.jy.r.j(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.bytedance.sdk.component.utils.mi.j();
                            com.bytedance.sdk.component.utils.ws.j(new com.bytedance.sdk.openadsdk.l.up());
                        } catch (Exception unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.rn.jy.j();
                    com.bytedance.sdk.openadsdk.core.rn.tl.j(jVar);
                    com.bytedance.sdk.openadsdk.core.rn.v.j();
                    com.bytedance.sdk.openadsdk.core.uf.j.j().j(context);
                    com.bytedance.sdk.openadsdk.core.rn.rn.j();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.xt("TTAdSdk", "Unexpected asyn init error: ".concat(String.valueOf(th)));
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z5, @ForbidWrapParam final Context context, final boolean z6, long j6) {
        com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.cw.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.live.xt.j();
                if (z5) {
                    if (com.bytedance.sdk.component.utils.i.j(context)) {
                        com.bytedance.sdk.openadsdk.core.p.tl.j(v.xt()).cw();
                        com.bytedance.sdk.component.utils.vl.j("TTAdSdk", "Load setting in main process");
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.p.tl.j(v.xt()).cw();
                }
                if (z6) {
                    com.bytedance.sdk.openadsdk.core.kt.xt.r();
                }
            }
        }, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(@ForbidWrapParam final Context context, final long j6, final long j7, final long j8, final ch chVar, final boolean z5, final com.bytedance.sdk.openadsdk.i.cw.cw.j jVar, final String str, final int i6, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.p.ae aeVar) {
        com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.cw.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.this.xt(context, j6, j7, j8, chVar, z5, jVar, str, i6, pluginValueSet, aeVar);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = com.bykv.j.j.j.j.e.i(sparseArray).k();
        switch (k6.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(j());
            case -999001:
                j((Context) k6.objectValue(-998000, Context.class), k6, new com.bytedance.sdk.openadsdk.core.wq.cw(a1.b.a(k6.objectValue(15, a1.a.a()))));
                return null;
            case -999000:
                return this.cw;
            default:
                return null;
        }
    }
}
