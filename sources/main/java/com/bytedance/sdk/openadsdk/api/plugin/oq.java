package com.bytedance.sdk.openadsdk.api.plugin;

import a1.b;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.component.oq.qv;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.j;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.stub.StubApp;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends com.bytedance.sdk.openadsdk.api.j {

    /* renamed from: j, reason: collision with root package name */
    private static final j f27582j = new j();
    private boolean ae;

    /* renamed from: r, reason: collision with root package name */
    private ae f27584r;
    private SharedPreferences up;
    private volatile Initializer xt = up();
    private volatile Initializer cw = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f27583m = false;
    private com.bytedance.sdk.openadsdk.cw.cw tl = new com.bytedance.sdk.openadsdk.cw.cw() { // from class: com.bytedance.sdk.openadsdk.api.plugin.oq.1
        @Override // com.bytedance.sdk.openadsdk.cw.cw
        public Function<SparseArray<Object>, Object> j(int i6) {
            return oq.this.j(i6);
        }
    };

    private static final class cw {

        /* renamed from: j, reason: collision with root package name */
        private static final cw f27586j = new cw();
        private volatile Initializer xt;

        private static Initializer xt(ae aeVar) throws r {
            try {
                aeVar.xt("call_create_initializer");
                BaseDexClassLoader j6 = g.j(TTAppContextHolder.getContext()).j(aeVar, 60000);
                if (j6 == null) {
                    throw new r(4205, "Get initializer failed");
                }
                Class<?> loadClass = j6.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                aeVar.xt("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new g.cw());
                bundle.putInt("api_sdk_version", 7012);
                aeVar.xt("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                aeVar.xt("get_init_method_cost");
                try {
                    com.bytedance.sdk.openadsdk.api.r rVar = new com.bytedance.sdk.openadsdk.api.r(b.a(declaredMethod.invoke(null, bundle)));
                    aeVar.xt("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "Create initializer success");
                    return rVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Create initializer failed");
                if (th2 instanceof r) {
                    throw th2;
                }
                com.bytedance.sdk.openadsdk.api.m.j(th2);
                throw new r(4206, th2.getMessage());
            }
        }

        private cw() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer j(ae aeVar) throws r {
            if (this.xt == null) {
                synchronized (this) {
                    try {
                        if (this.xt == null) {
                            this.xt = xt(aeVar);
                        }
                    } finally {
                    }
                }
            }
            return this.xt;
        }
    }

    private static final class j extends j.cw {
        private j() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.j.cw
        protected void j(Throwable th) {
            g.j(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.j.cw
        protected Object j(Object obj) {
            boolean z5 = obj instanceof TTPluginListener;
            if (z5) {
                g.j(TTAppContextHolder.getContext()).j((TTPluginListener) obj);
            }
            if (!z5) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.cw.j((ILiveAdCustomConfig) obj) : com.bytedance.sdk.openadsdk.p.xt.j(obj) ? new com.bytedance.sdk.openadsdk.p.xt(obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return g.j(TTAppContextHolder.getContext()).j(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ExecutorService executorService = (ExecutorService) j(ExecutorService.class, 1);
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            qv.xt.j(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.mi.j.j().j(threadPoolExecutor);
        }
        ExecutorService executorService2 = (ExecutorService) j(ExecutorService.class, 2);
        if (executorService2 != null) {
            qv.xt.xt((ThreadPoolExecutor) executorService2);
        }
        ExecutorService executorService3 = (ExecutorService) j(ExecutorService.class, 3);
        if (executorService3 != null) {
            qv.xt.j((ScheduledExecutorService) executorService3);
        }
    }

    private static Initializer up() {
        try {
            Class<?> loadClass = TTAdSdk.class.getClassLoader().loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new g.cw());
            bundle.putInt("api_sdk_version", 7012);
            return new com.bytedance.sdk.openadsdk.api.r(b.a(loadClass.getDeclaredMethod("getNewInstance", Bundle.class).invoke(null, bundle)));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.j(th);
            com.bytedance.sdk.openadsdk.api.m.up("_tt_ad_sdk_", "Get direct initializer failed");
            return null;
        }
    }

    private void ae() {
        try {
            com.bytedance.sdk.openadsdk.api.m.cw("_tt_ad_sdk_", "istl push pl start");
            if (this.ae) {
                g.j(TTAppContextHolder.getContext()).xt();
            }
            com.bytedance.sdk.openadsdk.api.m.cw("_tt_ad_sdk_", "istl push pl done");
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.up("_tt_ad_sdk_", "istl err: " + th.getMessage());
            com.bytedance.sdk.openadsdk.api.m.j(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    protected com.bytedance.sdk.openadsdk.cw.cw cw() {
        return this.tl;
    }

    public boolean r() {
        if (this.up == null) {
            this.up = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
        }
        return this.up.getInt("_use_pl_", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    protected boolean xt(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.xt(context, adConfig, initCallback);
        this.f27584r = ae.j("duration");
        boolean z5 = false;
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e6) {
            com.bytedance.sdk.openadsdk.api.m.xt("_tt_ad_sdk_", e6);
        }
        if (com.bytedance.sdk.openadsdk.api.up.j()) {
            xt(com.bykv.j.j.j.j.g.a().e(false).b(4204).d("Only support >= 7.0").f());
            return false;
        }
        if (adConfig != null && adConfig.isDebug()) {
            z5 = true;
        }
        this.ae = z5;
        m.j(adConfig);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    protected void j(Result result) {
        super.j(result);
        m.j();
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    public boolean j(Context context, a aVar) {
        if (j(context) && r()) {
            com.bytedance.sdk.openadsdk.api.m.cw("_tt_ad_sdk_", "use pl Init");
            return false;
        }
        if (com.bytedance.sdk.openadsdk.api.plugin.cw.cw.xt()) {
            com.bytedance.sdk.openadsdk.api.m.up("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.xt != null) {
            this.f27583m = true;
            j(this.xt.getManager());
            this.xt.init(context, aVar.k());
            return false;
        }
        xt(com.bykv.j.j.j.j.g.a().e(false).b(4206).f());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    public void xt(Context context, a aVar) {
        com.bytedance.sdk.openadsdk.api.m.cw("_tt_ad_sdk_", "async init");
        if (this.f27583m && Build.VERSION.SDK_INT < 26) {
            com.bytedance.sdk.openadsdk.api.m.r("_tt_ad_sdk_", "lower 26");
            return;
        }
        this.f27584r.xt("wait_asyn_cost");
        if (!com.bytedance.sdk.openadsdk.api.plugin.cw.cw.xt() && !j(context)) {
            com.bytedance.sdk.openadsdk.api.m.r("_tt_ad_sdk_", "no pl");
            ae();
        } else {
            com.bytedance.sdk.openadsdk.api.m.r("_tt_ad_sdk_", "start pl load");
            j(this.f27584r, aVar);
        }
    }

    private class xt implements Function<SparseArray<Object>, Object> {
        private xt() {
        }

        public ValueSet j(int i6, Result result) {
            com.bytedance.sdk.openadsdk.api.m.cw("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (result.isSuccess() && oq.this.cw != null) {
                if (oq.this.f27583m && oq.this.xt != null && oq.this.xt.isInitSuccess()) {
                    oq oqVar = oq.this;
                    oqVar.xt(oqVar.xt.getManager());
                }
                oq oqVar2 = oq.this;
                oqVar2.xt = oqVar2.cw;
                oq oqVar3 = oq.this;
                oqVar3.j(oqVar3.xt.getManager());
            }
            if (!oq.this.f27583m) {
                oq.this.xt(result);
            }
            if (!result.isSuccess() || oq.this.cw == null) {
                return null;
            }
            oq.this.m();
            return null;
        }

        @Override // java.util.function.Function
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet k6 = a.j(sparseArray).k();
            int intValue = k6.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) k6.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 != null) {
                ValueSet k7 = a.j(sparseArray2).k();
                j(intValue, com.bykv.j.j.j.j.g.a().b(k7.intValue(-999900)).d(k7.stringValue(-999901)).e(k7.booleanValue(-999903)).c(a.j((SparseArray) k7.objectValue(-999902, SparseArray.class)).k()).f());
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    public boolean j() {
        return (com.bytedance.sdk.openadsdk.api.up.j() || this.xt == null || !this.xt.isInitSuccess()) ? false : true;
    }

    private boolean j(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.xt.r(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> j(int i6) {
        if (i6 == 2) {
            return com.bytedance.sdk.openadsdk.live.cw.j();
        }
        if (i6 == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.cw.j(TTAppContextHolder.getContext());
        }
        if (i6 != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.j.j.j();
    }

    @Override // com.bytedance.sdk.openadsdk.api.j
    public j.cw xt() {
        return f27582j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(Manager manager) {
        if (manager == null || !(manager instanceof com.bytedance.sdk.openadsdk.api.cw)) {
            return;
        }
        Function<SparseArray<Object>, Object> j6 = ((com.bytedance.sdk.openadsdk.api.cw) manager).j(1);
        if (f.a(j6)) {
            b.a(j6).apply(a.b(1).e(-99999987, 16).g(-99999985, Void.class).i(17, true).k().sparseArray());
        }
    }

    private void j(ae aeVar, a aVar) {
        if (this.cw == null || !this.cw.isInitSuccess()) {
            a j6 = a.j(aVar.k().sparseArray());
            j6.g(15, new xt());
            try {
                if (this.cw == null) {
                    synchronized (cw.class) {
                        try {
                            if (this.cw == null) {
                                Initializer j7 = cw.f27586j.j(aeVar);
                                this.cw = j7;
                                j(j7, aeVar, j6);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (r e6) {
                com.bytedance.sdk.openadsdk.api.m.r("bstsdk", "Load p_init failed: " + e6.j() + ", message: " + e6.getMessage());
                m.j(e6.j(), e6.getMessage(), 0L);
                if (this.f27583m) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.m.up("bstsdk", "finishInit, pl_error: " + e6.getMessage());
                xt(com.bykv.j.j.j.j.g.a().e(false).b(e6.j()).d(e6.getMessage()).f());
            } catch (Exception e7) {
                m.j(4206, "Load p_init failed: " + e7.getMessage(), 0L);
                com.bytedance.sdk.openadsdk.api.m.r("_tt_ad_sdk_", "Load p_init failed: " + e7.getMessage());
                if (this.f27583m) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.m.up("bstsdk", "finishInit, error: " + e7.getMessage());
                xt(com.bykv.j.j.j.j.g.a().e(false).b(4206).d(e7.getMessage()).f());
            }
        }
    }

    private <T> T j(Class<T> cls, int i6) {
        Bundle bundle = new Bundle();
        bundle.putInt(com.umeng.ccg.a.f41544t, i6);
        return (T) xt().getExtra(cls, bundle);
    }

    private static void j(Initializer initializer, ae aeVar, a aVar) throws r {
        if (initializer != null) {
            try {
                aeVar.j();
                JSONObject jSONObject = new JSONObject();
                aeVar.j(jSONObject, 20L);
                jSONObject.put("zeus", g.j(TTAppContextHolder.getContext()).j());
                aVar.g(17, com.bytedance.sdk.openadsdk.mi.j.j().xt());
                qv qvVar = qv.xt;
                aVar.g(20, qvVar.g());
                aVar.g(19, qvVar.oq());
                aVar.g(21, qvVar.vl());
                initializer.init(TTAppContextHolder.getContext(), aVar.g(9, jSONObject).k());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) StubApp.getOrigApplicationContext(TTAppContextHolder.getContext().getApplicationContext()));
                }
                com.bytedance.sdk.openadsdk.api.m.xt("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e6) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new r(4207, "Init error: " + e6.getMessage());
            }
        }
        throw new r(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "Init error");
    }
}
