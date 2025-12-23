package com.bytedance.msdk.m;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.msdk.core.xt;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.s;
import com.bytedance.msdk.tl.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static long ae;
    private static boolean cw;

    /* renamed from: m, reason: collision with root package name */
    private static long f25151m;
    private static long xt;

    /* renamed from: r, reason: collision with root package name */
    private static AtomicBoolean f25152r = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    static Runnable f25150j = new Runnable() { // from class: com.bytedance.msdk.m.cw.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.j.up.cw.j("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) m.m()).getQueue().size());
            m.j(cw.f25150j, 5000L);
        }
    };
    private static final ComponentCallbacks up = new ComponentCallbacks() { // from class: com.bytedance.msdk.m.cw.3
        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.bytedance.msdk.core.up.j.j.j().xt();
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration configuration) {
        }
    };

    private static class j extends BroadcastReceiver {
        private j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || oq.i().la()) {
                return;
            }
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (s.j(context)) {
                        com.bytedance.msdk.up.cw.cw();
                    } else {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
    }

    interface xt {

        /* renamed from: j, reason: collision with root package name */
        public static final String f25155j = rn.j() + ".openadsdk.permission.TT_PANGOLIN";
    }

    private static void cw(Context context) {
        com.bytedance.msdk.up.cw.j(context);
        com.bytedance.msdk.up.cw.j();
    }

    private static void az() {
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "AppStateListener开始注册");
        com.bytedance.sdk.openadsdk.core.rn.j r5 = oq.i().r();
        if (r5 != null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "AppStateListener注册成功");
            r5.j(new j.xt() { // from class: com.bytedance.msdk.m.cw.4
                @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
                public void j() {
                    if (oq.i().la()) {
                        return;
                    }
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- AppStateListener on foreground");
                    long unused = cw.f25151m = SystemClock.elapsedRealtime();
                    com.bytedance.msdk.core.xt.j.cw();
                }

                @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
                public void xt() {
                    if (!oq.i().la()) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- AppStateListener on background");
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long j6 = elapsedRealtime - cw.f25151m;
                        com.bytedance.msdk.up.m.xt(j6);
                        com.bytedance.msdk.core.j.qv().xt(j6);
                        com.bytedance.msdk.up.xt.xt.f25323j = true;
                        if (elapsedRealtime - cw.ae >= 3000) {
                            if (com.bytedance.msdk.up.cw.xt()) {
                                long unused = cw.ae = elapsedRealtime;
                                if (!s.j(com.bytedance.msdk.core.xt.getContext())) {
                                    cw.av();
                                    return;
                                } else {
                                    com.bytedance.msdk.up.cw.cw();
                                    return;
                                }
                            }
                            return;
                        }
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "badkground too frequently ms: " + (elapsedRealtime - cw.ae));
                    }
                }
            });
        }
        if (com.bytedance.msdk.core.j.qv().jy()) {
            try {
                com.bytedance.msdk.core.xt.getContext().registerReceiver(new j(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), xt.f25155j, null);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    private static void jy() {
        com.bytedance.msdk.api.r.j.g.j hh;
        if (!cw || (hh = com.bytedance.msdk.core.j.qv().hh()) == null) {
            return;
        }
        hh.j();
        com.bytedance.msdk.core.j.qv().j((com.bytedance.msdk.api.r.j.g.j) null);
    }

    public static void r() {
        Context context;
        if (f25152r.get()) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt("TNCManager_GroMore", "初始化TNC initTTAdNetTNC：supportTNC：" + com.bytedance.msdk.core.xt.xt().h());
        if (com.bytedance.msdk.core.xt.xt().h() && (context = com.bytedance.msdk.core.xt.getContext()) != null) {
            try {
                com.bytedance.msdk.r.xt.j().xt().j(context, true, new com.bytedance.msdk.r.j(context));
            } catch (Exception unused) {
            }
            f25152r.set(true);
        }
    }

    public static boolean xt() {
        return cw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void av() {
        if (com.bytedance.msdk.core.xt.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(rn.j());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.bytedance.msdk.core.xt.getContext().sendBroadcast(intent, xt.f25155j);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public static String cw() {
        try {
            com.bytedance.msdk.j.j.r j6 = com.bytedance.msdk.m.xt.xt.j().j(MediationConstant.ADN_PANGLE);
            if (j6 != null) {
                return j6.cw();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void i() {
        try {
            com.bytedance.msdk.core.xt.xt().j(true);
        } catch (Throwable th) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    public static long j() {
        return xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void kt() {
        if (!com.bytedance.msdk.core.xt.xt().la()) {
            return;
        }
        Map<String, String> gq = com.bytedance.msdk.core.xt.xt().gq();
        com.bytedance.msdk.up.m.j((com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, mi.j(), 1);
        com.bytedance.msdk.up.m.j(mi.j(gq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mi() {
        if (com.bytedance.msdk.core.xt.xt().l()) {
            kt();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.msdk.m.cw.5
                @Override // java.lang.Runnable
                public void run() {
                    cw.kt();
                }
            }, 2000L);
        }
    }

    public static void up() {
        com.bytedance.msdk.core.xt.xt().xt(1);
        if (!f25152r.get()) {
            r();
        }
        Context context = com.bytedance.msdk.core.xt.getContext();
        if (context != null) {
            try {
                com.bytedance.msdk.j.up.cw.xt("TNCManager_GroMore", "尝试刷新TNC tryRefreshTNCConfig");
                com.bytedance.msdk.r.xt.j().xt().j(context, false);
            } catch (Exception unused) {
            }
        }
    }

    private static void w() {
        com.bytedance.msdk.core.ws.xt.j(com.bytedance.msdk.core.xt.xt()).j(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ws() {
        Application j6 = xt.j.j();
        if (j6 == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "lowMemoryListener注册失败, app = null");
            return;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "lowMemoryListener注册成功");
        ComponentCallbacks componentCallbacks = up;
        j6.unregisterComponentCallbacks(componentCallbacks);
        j6.registerComponentCallbacks(componentCallbacks);
    }

    private static void xt(final Context context) {
        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        j(true);
        xt = SystemClock.elapsedRealtime();
        az();
        r.j(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        tl.j().cw();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pre_time", elapsedRealtime - xt);
        } catch (Throwable unused) {
        }
        i();
        try {
            jSONObject.put("cfg_time", SystemClock.elapsedRealtime() - elapsedRealtime);
        } catch (Throwable unused2) {
        }
        cw(context);
        com.bytedance.msdk.core.xt.xt().j(true, jSONObject, new com.bytedance.msdk.core.m.xt() { // from class: com.bytedance.msdk.m.cw.1
            @Override // com.bytedance.msdk.core.m.xt
            public void j() {
                com.bytedance.msdk.core.xt.xt().j((com.bytedance.msdk.core.m.xt) null);
                m.r(new Runnable() { // from class: com.bytedance.msdk.m.cw.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.up.cw.xt(com.bytedance.msdk.core.xt.getContext());
                        cw.xt(context, cw.xt);
                        cw.ws();
                    }
                });
                cw.mi();
            }
        });
        w();
    }

    private static void j(boolean z5) {
        cw = z5;
        jy();
    }

    public static void j(@NonNull com.bytedance.msdk.api.r.j jVar, Context context) {
        j(context);
        j(jVar);
        xt(context);
    }

    @SuppressLint({"WrongConstant"})
    private static void j(com.bytedance.msdk.api.r.j jVar) {
        com.bytedance.msdk.core.j.qv().j(jVar.az());
        com.bytedance.msdk.core.j.qv().j(System.currentTimeMillis());
        com.bytedance.msdk.core.j.qv().cw(jVar.j());
        com.bytedance.msdk.core.j.qv().m(jVar.xt());
        com.bytedance.msdk.core.j.qv().cw(jVar.av());
        com.bytedance.msdk.core.j.qv().up(jVar.m().cw());
        com.bytedance.msdk.core.j.qv().m(jVar.m().r());
        com.bytedance.msdk.core.j.qv().j(jVar.m().xt());
        com.bytedance.msdk.core.j.qv().j(jVar.m().up());
        com.bytedance.msdk.core.j.qv().j(jVar.m().m());
        com.bytedance.msdk.core.j.qv().r(jVar.m().j());
        com.bytedance.msdk.core.j.qv().r(jVar.r());
        com.bytedance.msdk.core.j.qv().xt(jVar.up());
        com.bytedance.msdk.core.j.qv().up(jVar.m().ae());
        com.bytedance.msdk.core.j.qv().j(jVar.m().tl());
        com.bytedance.msdk.core.j.qv().j(jVar.g(), true);
        com.bytedance.msdk.core.j.qv().ae(jVar.m().g());
        com.bytedance.msdk.core.j.qv().xt(jVar.oq());
        com.bytedance.msdk.core.j.qv().cw(jVar.ws());
        com.bytedance.msdk.core.j.qv().ae(jVar.qv());
        com.bytedance.msdk.core.j.qv().tl(jVar.vl());
        com.bytedance.msdk.core.j.qv().j(jVar.jy());
        com.bytedance.msdk.core.j.qv().g(jVar.ae().xt());
        com.bytedance.msdk.core.j.qv().tl(jVar.ae().j());
        com.bytedance.msdk.core.j.qv().oq(jVar.ae().cw());
        com.bytedance.msdk.core.j.qv().qv(jVar.ae().r());
        if (jVar.ws() != null) {
            try {
                com.bytedance.msdk.core.j.qv().j((List<String>) jVar.ws().get(MediationConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        if (jVar.tl() != null) {
            com.bytedance.msdk.core.j.qv().xt(jVar.tl().j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Context context, long j6) {
        if (!r.j()) {
            com.bytedance.msdk.j.up.cw.j("TMe", "-----==---- 延时上报sdk_init");
            r.j(j6);
        } else {
            com.bytedance.msdk.j.up.cw.j("TMe", "-----==---- 正常上报sdk_init");
            r.xt(j6);
        }
    }

    public static void j(SparseArray<Object> sparseArray) {
        for (com.bytedance.msdk.j.j.r rVar : com.bytedance.msdk.m.xt.xt.j().cw()) {
            if (rVar != null) {
                try {
                    rVar.j(com.bytedance.msdk.core.j.qv().p(), sparseArray);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
    }

    public static void j(Context context) {
        if (context != null) {
            com.bytedance.msdk.core.xt.j(context);
        }
    }
}
