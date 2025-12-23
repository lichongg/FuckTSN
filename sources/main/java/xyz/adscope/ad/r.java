package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.ad.publish.IInitCallback;
import xyz.adscope.common.v2.dev.info.UserAgentHelper;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.location.ILocationHolder;
import xyz.adscope.common.v2.location.LocationManager;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class r implements t1 {

    /* renamed from: b, reason: collision with root package name */
    private final Context f55911b;

    /* renamed from: c, reason: collision with root package name */
    private final g2 f55912c;

    /* renamed from: d, reason: collision with root package name */
    private final j4 f55913d;

    /* renamed from: e, reason: collision with root package name */
    private final e f55914e;

    /* renamed from: f, reason: collision with root package name */
    private ASNPInitConfig f55915f;

    /* renamed from: a, reason: collision with root package name */
    private final String f55910a = "ASNPInitializeImpl";

    /* renamed from: g, reason: collision with root package name */
    private b f55916g = b.STANDBY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum b {
        STANDBY,
        INITIALING,
        SUCCESS,
        FAILED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements f3 {

        /* renamed from: a, reason: collision with root package name */
        private IInitCallback f55922a;

        /* synthetic */ c(r rVar, IInitCallback iInitCallback, a aVar) {
            this(iInitCallback);
        }

        private void a(n1 n1Var, j4 j4Var) {
            if (n1Var == null || j4Var == null) {
                return;
            }
            SDKLog.d("ASNPInitializeImpl", "上报初始化事件.  " + n1Var + " 耗时 " + j4Var.e());
            l.a().getOrCreateImplement(r.this.f55911b).a(n1Var, j4Var);
        }

        private c(IInitCallback iInitCallback) {
            this.f55922a = iInitCallback;
        }

        private void b() {
            ConfigResponseModel a6 = r.this.f55914e.a(false);
            if (a6 != null) {
                r.this.f55913d.a(a6.d());
            }
        }

        @Override // xyz.adscope.ad.f3
        public void initSuccess() {
            SDKLog.d("ASNPInitializeImpl", "初始化成功..." + System.currentTimeMillis());
            r.this.f55916g = b.SUCCESS;
            a(n1.EVENT_REPORT_INIT_CODE, r.this.f55913d.deepCopy());
            r.this.f55913d.a(System.currentTimeMillis());
            r.this.f55914e.a(r.this.f55913d.deepCopy());
            a(n1.EVENT_REPORT_INIT_SUCCESS_CODE, r.this.f55913d.deepCopy());
            IInitCallback iInitCallback = this.f55922a;
            if (iInitCallback != null) {
                iInitCallback.initSuccess();
                this.f55922a = null;
            }
        }

        @Override // xyz.adscope.ad.f3
        public void a() {
            b();
        }

        @Override // xyz.adscope.ad.f3
        public void a(o oVar) {
            SDKLog.d("ASNPInitializeImpl", "初始化失败..." + oVar.b() + " " + oVar.c());
            r.this.f55916g = b.FAILED;
            a(n1.EVENT_REPORT_INIT_CODE, r.this.f55913d.deepCopy());
            r.this.f55913d.a(System.currentTimeMillis());
            a(n1.EVENT_REPORT_INIT_FAIL_CODE, r.this.f55913d.deepCopy());
            r.this.f55914e.a(r.this.f55913d.deepCopy());
            IInitCallback iInitCallback = this.f55922a;
            if (iInitCallback != null) {
                iInitCallback.initFailed(oVar.b(), oVar.c());
            }
        }
    }

    private void b(boolean z5) {
        if (z5) {
            new g(this.f55911b).a();
        }
    }

    private void c() {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55911b).executeBasicAsyncTask(new Runnable() { // from class: xyz.adscope.ad.s7
            @Override // java.lang.Runnable
            public final void run() {
                r.this.i();
            }
        });
    }

    private void d() {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55911b).executeBasicAsyncTask(new Runnable() { // from class: xyz.adscope.ad.u7
            @Override // java.lang.Runnable
            public final void run() {
                r.this.j();
            }
        });
    }

    private void e() {
        k.a().getOrCreateImplement(this.f55911b);
    }

    private void f() {
        LinkedEncryptManager.getInstance().getOrCreateImplement(this.f55911b).initAesConfig(d.ASNP_AES);
    }

    private void g() {
        ASNPInitConfig aSNPInitConfig = this.f55915f;
        if (aSNPInitConfig != null) {
            b7.a().a(this.f55911b, aSNPInitConfig.getUiModel(), this.f55915f.getLightColor(), this.f55915f.getDarkColor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        e0.a(StubApp.getOrigApplicationContext(this.f55911b.getApplicationContext()));
    }

    r(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f55911b = origApplicationContext;
        j4 j4Var = new j4();
        this.f55913d = j4Var;
        this.f55912c = new q(context);
        e orCreateImplement = f.a().getOrCreateImplement(origApplicationContext);
        this.f55914e = orCreateImplement;
        orCreateImplement.a(j4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        l.a().getOrCreateImplement(this.f55911b).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        e7.a().getOrCreateImplement(this.f55911b).d();
        k0.a().getOrCreateImplement(this.f55911b).c();
    }

    private void k() {
        x.a().getOrCreateImplement(this.f55911b).a("plugins_all");
    }

    @Override // xyz.adscope.ad.t1
    public void a(ASNPInitConfig aSNPInitConfig, IInitCallback iInitCallback) {
        if (a(aSNPInitConfig.getAppId(), iInitCallback)) {
            return;
        }
        SDKLog.initSDKLog(this.f55911b);
        this.f55916g = b.INITIALING;
        this.f55915f = aSNPInitConfig;
        f();
        g();
        this.f55913d.b(System.currentTimeMillis());
        a(aSNPInitConfig);
        c();
        a(p.a(aSNPInitConfig, ASNPInitConfig.ASNPExtraConfig.KEY_CUSTOM_USER_AGENT));
        b(p.a(aSNPInitConfig, ASNPInitConfig.ASNPExtraConfig.KEY_HANDLE_EXCEPTION, true));
        a(aSNPInitConfig.canUpdateLocation());
        b();
        d();
        e();
        k();
        a(iInitCallback);
    }

    private void b() {
        Runnable runnable = new Runnable() { // from class: xyz.adscope.ad.t7
            @Override // java.lang.Runnable
            public final void run() {
                r.this.h();
            }
        };
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55911b);
        if (orCreateImplement != null) {
            orCreateImplement.executeLocalAsyncTask(runnable);
        }
    }

    private boolean a(String str, IInitCallback iInitCallback) {
        b bVar = this.f55916g;
        if (bVar != b.STANDBY && bVar != b.FAILED) {
            if (bVar == b.SUCCESS) {
                if (iInitCallback != null) {
                    ASNPInitConfig aSNPInitConfig = this.f55915f;
                    if (aSNPInitConfig != null && aSNPInitConfig.getAppId().equals(str)) {
                        iInitCallback.alreadyInit();
                    } else {
                        o oVar = o.ERROR_INIT_WITH_DIFFERENT_APP_ID;
                        iInitCallback.initFailed(oVar.b(), oVar.c());
                    }
                }
                return true;
            }
            if (bVar == b.INITIALING && iInitCallback != null) {
                iInitCallback.initializing();
                return true;
            }
        }
        return false;
    }

    private void a(ASNPInitConfig aSNPInitConfig) {
        e eVar = this.f55914e;
        if (eVar != null) {
            eVar.a(aSNPInitConfig);
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            UserAgentHelper.getInstance().asyncInitUserAgent(this.f55911b);
        } else {
            UserAgentHelper.getInstance().setCustomUserAgent(str);
        }
    }

    private void a(boolean z5) {
        ILocationHolder orCreateImplement = LocationManager.getInstance().getOrCreateImplement(this.f55911b);
        if (z5) {
            orCreateImplement.updatePermissionGranted();
        }
        orCreateImplement.setLocalLocation(this.f55915f.getCustomLocation());
    }

    private void a(IInitCallback iInitCallback) {
        this.f55912c.a(new c(this, iInitCallback, null));
        this.f55912c.a(this.f55915f);
    }

    @Override // xyz.adscope.ad.t1
    public boolean a() {
        return this.f55916g == b.SUCCESS;
    }
}
