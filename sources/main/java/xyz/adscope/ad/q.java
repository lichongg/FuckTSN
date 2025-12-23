package xyz.adscope.ad;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.resp.basic.ASNPResponse;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.IRemoveAbleScheduledTask;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class q extends n2 implements g2 {

    /* renamed from: b, reason: collision with root package name */
    private final xyz.adscope.ad.e f55849b;

    /* renamed from: c, reason: collision with root package name */
    private ASNPInitConfig f55850c;

    /* renamed from: d, reason: collision with root package name */
    private final e f55851d;

    /* renamed from: e, reason: collision with root package name */
    private final d f55852e;

    /* renamed from: f, reason: collision with root package name */
    private final c3 f55853f;

    /* renamed from: g, reason: collision with root package name */
    private final IBaseThreadPool f55854g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements c3 {

        /* renamed from: a, reason: collision with root package name */
        private final c f55855a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f55856b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends c {
            @Override // xyz.adscope.ad.q.c
            protected void a(o oVar) {
                b.this.f55856b = false;
                super.a(oVar);
            }

            a(boolean z5) {
                super(q.this, z5, null);
            }

            @Override // xyz.adscope.ad.q.c
            protected void a() {
                b.this.f55856b = false;
                super.a();
            }
        }

        private b() {
            this.f55855a = new a(false);
            this.f55856b = false;
        }

        @Override // xyz.adscope.ad.c3
        public void a() {
            if (this.f55856b || q.this.f55854g == null) {
                return;
            }
            SDKLog.d("ASNPInitRouter", "请求强制更新Global配置...");
            this.f55856b = true;
            q.this.f55854g.executeInitAsyncTask(this.f55855a);
        }

        /* synthetic */ b(q qVar, a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ICommonTimeoutTask f55859a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f55860b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends ICommonTimeoutTask {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f55862a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j6, q qVar) {
                super(j6);
                this.f55862a = qVar;
            }

            @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
            protected void onScheduleTimeout() {
                c.this.a(o.ERROR_CONFIG_REQUEST_TIMEOUT);
                c.this.f55859a.cancelCountDown();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements IBaseHttpResponseCallback {
            @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
            public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                o[] oVarArr = new o[1];
                ConfigResponseModel a6 = c.this.a(iBaseHttpResponse.getResponseResult(), oVarArr);
                if (a6 != null) {
                    q.this.f55849b.a(a6, true, false);
                    c.this.a();
                    return;
                }
                c cVar = c.this;
                o oVar = oVarArr[0];
                if (oVar == null) {
                    oVar = o.ERROR_CONFIG_PARSE_FAIL;
                }
                cVar.a(oVar);
            }

            b() {
            }

            @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
            public void failCallback(IHttpRequestError iHttpRequestError) {
                SDKLog.e("ASNPInitRouter", "服务器请求失败 " + iHttpRequestError.getErrorCode() + " " + iHttpRequestError.getErrorMessage());
                c.this.a(o.ERROR_CONFIG_RESPONSE_ERROR);
            }
        }

        /* synthetic */ c(q qVar, boolean z5, a aVar) {
            this(z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f55860b = false;
        }

        private c(boolean z5) {
            this.f55860b = z5;
            this.f55859a = new a(10000L, q.this);
        }

        private String b() {
            return Base64Util.decodeToString(((q.this.f55850c == null || !q.this.f55850c.isUseHttps()) ? "aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FwaS92MS9jZmcvZ2V0Q29uZmln" : "aHR0cHM6Ly9zZGstYXBpLmFkbi1wbHVzLmNvbS5jbi9hcGkvdjEvY2ZnL2dldENvbmZpZw==").getBytes());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f55859a.startCountDown();
            q.this.a(a(q.this.f55849b.a(false)), new j1(q.this.f55715a, q.this.f55850c.getAppId()), new b());
        }

        protected void a() {
            ICommonTimeoutTask iCommonTimeoutTask = this.f55859a;
            if (iCommonTimeoutTask != null) {
                iCommonTimeoutTask.cancelCountDown();
            }
            q.this.c();
            if (this.f55860b) {
                q.this.b();
            }
        }

        protected void a(o oVar) {
            ICommonTimeoutTask iCommonTimeoutTask = this.f55859a;
            if (iCommonTimeoutTask != null) {
                iCommonTimeoutTask.cancelCountDown();
            }
            if (this.f55860b) {
                q.this.a(oVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ConfigResponseModel a(String str, o[] oVarArr) {
            if (!TextUtils.isEmpty(str)) {
                ASNPResponse aSNPResponse = new ASNPResponse(JsonUtil.parseJSONObject(str));
                if (aSNPResponse.b()) {
                    String decrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(q.this.f55715a).decrypt(aSNPResponse.a(), i0.a(q.this.f55715a, i0.b(), "asnpCfgPattern", "101,1001"), ILinkedEncrypt.B64Model.STEP_BY_STEP, false);
                    if (!TextUtils.isEmpty(decrypt) && JsonUtil.isValidJson(decrypt)) {
                        ConfigResponseModel configResponseModel = new ConfigResponseModel(JsonUtil.parseJSONObject(decrypt));
                        if (!configResponseModel.hasParseException()) {
                            return configResponseModel;
                        }
                        if (oVarArr != null && oVarArr.length > 0) {
                            oVarArr[0] = o.ERROR_CONFIG_PARSE_FAIL;
                        }
                        return null;
                    }
                }
            }
            if (oVarArr != null && oVarArr.length > 0) {
                oVarArr[0] = o.ERROR_CONFIG_RESPONSE_ERROR;
            }
            return null;
        }

        private String a(ConfigResponseModel configResponseModel) {
            if (configResponseModel != null && configResponseModel.f() != null) {
                String b6 = configResponseModel.f().b();
                if (!TextUtils.isEmpty(b6)) {
                    return b6;
                }
            }
            return b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final c f55865a;

        /* renamed from: b, reason: collision with root package name */
        private final g f55866b;

        /* synthetic */ d(q qVar, a aVar) {
            this();
        }

        private d() {
            a aVar = null;
            this.f55865a = new c(q.this, true, aVar);
            this.f55866b = new g(q.this, new f(q.this, new c(q.this, false, aVar), aVar), aVar);
        }

        private void a() {
            if (q.this.f55849b != null) {
                q.this.f55849b.f();
            }
        }

        private void b() {
            this.f55866b.a();
        }

        private void c() {
            this.f55865a.run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xyz.adscope.ad.g.c(q.this.f55715a)) {
                c();
                return;
            }
            b();
            a();
            if (q.this.f55849b == null) {
                q.this.a(o.ERROR_UNEXPECTED);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!q.this.f55849b.d()) {
                c();
                return;
            }
            if (q.this.f55849b.b(currentTimeMillis)) {
                c();
            } else {
                if (!q.this.f55849b.c(currentTimeMillis)) {
                    q.this.b();
                    return;
                }
                this.f55865a.c();
                c();
                q.this.b();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e extends n {

        /* renamed from: b, reason: collision with root package name */
        private f3 f55868b;

        /* synthetic */ e(Context context, a aVar) {
            this(context);
        }

        private e(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f3 f3Var) {
            this.f55868b = f3Var;
        }

        @Override // xyz.adscope.ad.n
        public void a(Message message) {
            f3 f3Var;
            if (message == null || (f3Var = this.f55868b) == null) {
                return;
            }
            int i6 = message.what;
            if (i6 == 0) {
                Object obj = message.obj;
                if (obj instanceof o) {
                    f3Var.a((o) obj);
                    return;
                } else {
                    f3Var.a(o.ERROR_UNEXPECTED);
                    return;
                }
            }
            if (i6 == 1) {
                f3Var.initSuccess();
            } else {
                if (i6 != 2) {
                    return;
                }
                f3Var.a();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final c f55869a;

        /* synthetic */ f(q qVar, c cVar, a aVar) {
            this(cVar);
        }

        private f(c cVar) {
            this.f55869a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xyz.adscope.ad.f.a().getOrCreateImplement(q.this.f55715a).a(System.currentTimeMillis()) != e.a.VALID) {
                this.f55869a.run();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class g extends IRemoveAbleScheduledTask {

        /* renamed from: a, reason: collision with root package name */
        private final d3 f55871a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements d3 {
            @Override // xyz.adscope.ad.d3
            public void a(ConfigResponseModel configResponseModel, e.a aVar, boolean z5) {
                g.this.stopScheduled();
                g.this.a(configResponseModel);
                if (z5) {
                    i0.b(q.this.f55715a, i0.b(), "asnpCfgPattern", "101,1001");
                    String a6 = a(configResponseModel, "101,1001");
                    if (TextUtils.isEmpty(a6)) {
                        return;
                    }
                    i0.b(q.this.f55715a, i0.b(), "asnpConfig", a6);
                    i0.b(q.this.f55715a, i0.b(), "asnpConfigLast", System.currentTimeMillis());
                }
            }

            a() {
            }

            private String a(ConfigResponseModel configResponseModel, String str) {
                if (configResponseModel != null) {
                    return LinkedEncryptManager.getInstance().getOrCreateImplement(q.this.f55715a).encrypt(configResponseModel.toJsonString(), str, ILinkedEncrypt.B64Model.STEP_BY_STEP, false);
                }
                return "";
            }
        }

        /* synthetic */ g(q qVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        private g(Runnable runnable) {
            super(runnable);
            this.f55871a = new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConfigResponseModel configResponseModel) {
            if (configResponseModel == null || configResponseModel.n() == null) {
                return;
            }
            int a6 = configResponseModel.n().a();
            if (a6 > 0) {
                long j6 = a6;
                startScheduled(j6, j6, TimeUnit.MILLISECONDS);
            } else {
                startScheduled(60000L, 60000L, TimeUnit.MILLISECONDS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (q.this.f55849b != null) {
                q.this.f55849b.a(this.f55871a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        this.f55851d.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f55851d.sendEmptyMessage(2);
    }

    private void d() {
        this.f55849b.a(this.f55853f);
    }

    q(Context context) {
        super(context);
        this.f55849b = xyz.adscope.ad.f.a().getOrCreateImplement(this.f55715a);
        a aVar = null;
        this.f55852e = new d(this, aVar);
        this.f55851d = new e(context, aVar);
        this.f55853f = new b(this, aVar);
        this.f55854g = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
    }

    @Override // xyz.adscope.ad.g2
    public void a(f3 f3Var) {
        this.f55851d.a(f3Var);
    }

    @Override // xyz.adscope.ad.g2
    public void a(ASNPInitConfig aSNPInitConfig) {
        this.f55850c = aSNPInitConfig;
        d();
        a();
    }

    private void a() {
        IBaseThreadPool iBaseThreadPool = this.f55854g;
        if (iBaseThreadPool != null) {
            iBaseThreadPool.executeInitAsyncTask(this.f55852e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        SDKLog.e("ASNPInitRouter", "初始化失败..." + oVar.b() + " " + oVar.c());
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = oVar;
        this.f55851d.sendMessage(obtain);
    }
}
