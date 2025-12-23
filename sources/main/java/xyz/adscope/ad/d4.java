package xyz.adscope.ad;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.db.AdvertisingDBModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.AdResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.ext.ResponseExtModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.SeatBidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.AdModel;
import xyz.adscope.ad.model.impl.resp.basic.ASNPResponse;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.cache.AdCacheModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.ad.s3;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class d4 extends n2 implements e2 {

    /* renamed from: b, reason: collision with root package name */
    private final b f54954b;

    /* renamed from: c, reason: collision with root package name */
    private final xyz.adscope.ad.c f54955c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, e> f54956d;

    /* renamed from: e, reason: collision with root package name */
    private ASNPInitConfig f54957e;

    /* renamed from: f, reason: collision with root package name */
    private final IBaseThreadPool f54958f;

    /* renamed from: g, reason: collision with root package name */
    private a2 f54959g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ICollectionFetchCompare<StrategyModel, String> {
        a() {
        }

        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(StrategyModel strategyModel, String str) {
            if (strategyModel != null) {
                return str.equals(strategyModel.b());
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends n {

        /* renamed from: b, reason: collision with root package name */
        private e3 f54961b;

        /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        private b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(e3 e3Var) {
            this.f54961b = e3Var;
        }

        @Override // xyz.adscope.ad.n
        public void a(Message message) {
            e3 e3Var;
            if (message == null || (e3Var = this.f54961b) == null) {
                return;
            }
            int i6 = message.what;
            if (i6 == 0) {
                Object obj = message.obj;
                if (obj instanceof y0) {
                    e3Var.a((y0) obj);
                    return;
                }
                return;
            }
            if (i6 != 1) {
                return;
            }
            Object obj2 = message.obj;
            if (obj2 instanceof List) {
                e3Var.onAdLoaded((List) obj2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b1 f54962a;

        /* renamed from: b, reason: collision with root package name */
        private final ConfigResponseModel f54963b;

        /* renamed from: c, reason: collision with root package name */
        private final a2 f54964c;

        /* renamed from: d, reason: collision with root package name */
        private final s1 f54965d;

        /* synthetic */ c(d4 d4Var, ConfigResponseModel configResponseModel, a2 a2Var, b1 b1Var, a aVar) {
            this(configResponseModel, a2Var, b1Var);
        }

        private void a(d dVar, f fVar, h hVar, b1 b1Var) {
            AdResponseModel b6 = dVar.b();
            AdResponseModel b7 = fVar.b();
            AdResponseModel b8 = hVar.b();
            if (b6 == null && b7 == null && b8 == null) {
                if (dVar.a() != null) {
                    a(dVar.a());
                    return;
                } else if (hVar.a() != null) {
                    a(hVar.a());
                    return;
                } else {
                    a(y0.ERROR_REQUEST_FAILED);
                    return;
                }
            }
            if (b6 == null) {
                b6 = b7 != null ? b7 : b8;
            }
            if (b6.hasParseException()) {
                a(y0.ERROR_REQUEST_FAILED);
                return;
            }
            List<s3> a6 = a(b6, this.f54964c, b1Var);
            if (a6 == null || a6.isEmpty()) {
                a(y0.ERROR_NO_FILL);
            } else {
                a(a6);
                a(b6);
            }
        }

        private c(ConfigResponseModel configResponseModel, a2 a2Var, b1 b1Var) {
            b1 deepCopy = b1Var.deepCopy();
            this.f54962a = deepCopy;
            deepCopy.a(d4.this.f54957e);
            deepCopy.a(System.currentTimeMillis());
            this.f54963b = configResponseModel;
            this.f54964c = a2Var;
            this.f54965d = l.a().getOrCreateImplement(d4.this.f55715a);
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.a().getOrCreateImplement(d4.this.f55715a).a(this.f54964c.getSpaceID(), n1.EVENT_REPORT_LOAD_CODE);
            this.f54965d.a(n1.EVENT_REPORT_REQUEST_CODE, this.f54962a);
            System.currentTimeMillis();
            CountDownLatch countDownLatch = new CountDownLatch(3);
            d4 d4Var = d4.this;
            d dVar = d4Var.new d(d4Var.f55715a, this.f54963b, this.f54962a, this.f54964c, countDownLatch, false);
            d4 d4Var2 = d4.this;
            f fVar = d4Var2.new f(d4Var2.f55715a, this.f54963b, this.f54962a, this.f54964c, countDownLatch);
            d4 d4Var3 = d4.this;
            h hVar = d4Var3.new h(d4Var3.f55715a, this.f54963b, this.f54962a, this.f54964c, countDownLatch);
            d4.this.f54956d.put("RunHttp", dVar);
            d4.this.f54956d.put("RunLocal", fVar);
            g gVar = new g(d4.this.f54956d, null);
            dVar.a(gVar);
            fVar.a(gVar);
            if (d4.this.f54958f != null) {
                d4.this.f54958f.executeRequestAsyncTask(dVar);
                d4.this.f54958f.executeLocalAsyncTask(fVar);
                d4.this.f54958f.executeLocalAsyncTask(hVar);
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e6) {
                SDKLog.stack(e6);
            }
            a(dVar, fVar, hVar, this.f54962a);
            if (!d4.this.a(this.f54964c)) {
                a(dVar, fVar);
            }
        }

        private void a(d dVar, f fVar) {
            d4 d4Var = d4.this;
            if (d4Var.a(d4Var.a(this.f54963b)) && dVar.f54969l && !fVar.f54986n) {
                d4 d4Var2 = d4.this;
                d dVar2 = d4Var2.new d(d4Var2.f55715a, this.f54963b, this.f54962a, this.f54964c, null, true);
                if (d4.this.f54958f != null) {
                    d4.this.f54958f.executeRequestAsyncTask(dVar2);
                }
            }
        }

        private void a(AdResponseModel adResponseModel) {
            xyz.adscope.ad.e orCreateImplement;
            if (adResponseModel == null || adResponseModel.a() == null) {
                return;
            }
            ResponseExtModel a6 = adResponseModel.a();
            if (!a6.b() || (orCreateImplement = xyz.adscope.ad.f.a().getOrCreateImplement(d4.this.f55715a)) == null || orCreateImplement.c() >= a6.a()) {
                return;
            }
            orCreateImplement.h();
        }

        private List<s3> a(AdResponseModel adResponseModel, a2 a2Var, b1 b1Var) {
            List a6 = d4.this.a(adResponseModel);
            if (a6 == null || a6.isEmpty()) {
                return null;
            }
            return d4.this.a((List<BidModel>) a6, a2Var, b1Var);
        }

        private void a(List<s3> list) {
            this.f54965d.a(n1.EVENT_REPORT_REQUEST_SUCCESS_CODE, this.f54962a);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = list;
            d4.this.f54954b.sendMessage(obtain);
        }

        private void a(y0 y0Var) {
            this.f54962a.a(y0Var);
            this.f54965d.a(n1.EVENT_REPORT_REQUEST_FAIL_CODE, this.f54962a);
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = y0Var;
            d4.this.f54954b.sendMessage(obtain);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d extends e {

        /* renamed from: j, reason: collision with root package name */
        private final boolean f54967j;

        /* renamed from: k, reason: collision with root package name */
        private ICommonTimeoutTask f54968k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f54969l;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends ICommonTimeoutTask {
            a(long j6) {
                super(j6);
            }

            @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
            protected void onScheduleTimeout() {
                d.this.a(y0.ERROR_REQUEST_TIME_OUT);
                d.this.f54968k.cancelCountDown();
                d.this.f();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements IBaseHttpResponseCallback {
            @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
            public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                y0[] y0VarArr = new y0[1];
                AdResponseModel a6 = d.this.a(iBaseHttpResponse.getResponseResult(), y0VarArr);
                if (a6 == null) {
                    d.this.a(y0VarArr[0]);
                } else if (d.this.f54980h || d.this.f54967j) {
                    xyz.adscope.ad.a orCreateImplement = xyz.adscope.ad.b.a().getOrCreateImplement(d.this.f54973a);
                    if (orCreateImplement != null) {
                        orCreateImplement.a(d.this.f54975c.getSpaceID(), a6);
                        orCreateImplement.a(d4.this.f54957e.getAppId(), d.this.f54975c.getSpaceID(), a6);
                    }
                } else {
                    d.this.f54969l = true;
                    d.this.a(a6);
                    d.this.c();
                }
                d.this.f();
            }

            b() {
            }

            @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
            public void failCallback(IHttpRequestError iHttpRequestError) {
                if (d.this.f54967j) {
                    return;
                }
                d.this.a(y0.ERROR_REQUEST_FAILED);
                d.this.f();
            }
        }

        @Override // xyz.adscope.ad.d4.e
        protected boolean e() {
            return false;
        }

        d(Context context, ConfigResponseModel configResponseModel, b1 b1Var, a2 a2Var, CountDownLatch countDownLatch, boolean z5) {
            super(context, configResponseModel, b1Var, a2Var, countDownLatch);
            this.f54969l = false;
            this.f54967j = z5;
            a(a2Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d4.this.a(this.f54975c)) {
                f();
                return;
            }
            if (d4.this.f54957e.getIsTestAd()) {
                f();
                return;
            }
            this.f54969l = false;
            ICommonTimeoutTask iCommonTimeoutTask = this.f54968k;
            if (iCommonTimeoutTask != null) {
                iCommonTimeoutTask.startCountDown();
            }
            String a6 = a(this.f54974b);
            z0 z0Var = new z0(this.f54973a);
            z0Var.a(this.f54975c, d4.this.f54957e, d4.this.f54955c, this.f54979g.t());
            d4.this.a(a6, z0Var, new b());
        }

        private String g() {
            String str;
            xyz.adscope.ad.e orCreateImplement = xyz.adscope.ad.f.a().getOrCreateImplement(this.f54973a);
            if (orCreateImplement != null) {
                ASNPInitConfig a6 = orCreateImplement.a();
                if (a6 != null && a6.isUseHttps()) {
                    str = "aHR0cHM6Ly9zZGstYXBpLmFkbi1wbHVzLmNvbS5jbi9hcGkvdjIvYWQvZ2V0QWQ=";
                } else {
                    str = "aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FwaS92Mi9hZC9nZXRBZA==";
                }
                return Base64Util.decodeToString(str.getBytes());
            }
            return null;
        }

        private void a(a2 a2Var) {
            if (a2Var != null) {
                this.f54968k = new a(a2Var.getTimeoutMillion() > 0 ? a2Var.getTimeoutMillion() : 10000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AdResponseModel a(String str, y0[] y0VarArr) {
            if (!TextUtils.isEmpty(str)) {
                ASNPResponse aSNPResponse = new ASNPResponse(JsonUtil.parseJSONObject(str));
                if (aSNPResponse.b()) {
                    String decrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(this.f54973a).decrypt(aSNPResponse.a(), i0.a(this.f54973a, i0.b(), "asnpAdPattern", "101,1001"), ILinkedEncrypt.B64Model.STEP_BY_STEP, false);
                    if (!TextUtils.isEmpty(decrypt) && JsonUtil.isValidJson(decrypt)) {
                        AdResponseModel adResponseModel = new AdResponseModel(JsonUtil.parseJSONObject(decrypt));
                        if (!adResponseModel.hasParseException()) {
                            return adResponseModel;
                        }
                        if (y0VarArr != null && y0VarArr.length > 0) {
                            y0VarArr[0] = y0.ERROR_RESPONSE_PARSE_FAILED;
                        }
                        return null;
                    }
                }
            }
            if (y0VarArr != null && y0VarArr.length > 0) {
                y0VarArr[0] = y0.ERROR_REQUEST_FAILED;
            }
            return null;
        }

        private String a(ConfigResponseModel configResponseModel) {
            if (configResponseModel != null && configResponseModel.f() != null) {
                String a6 = configResponseModel.f().a();
                if (!TextUtils.isEmpty(a6)) {
                    return a6;
                }
            }
            return g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        protected Context f54973a;

        /* renamed from: b, reason: collision with root package name */
        protected ConfigResponseModel f54974b;

        /* renamed from: c, reason: collision with root package name */
        protected a2 f54975c;

        /* renamed from: d, reason: collision with root package name */
        protected CountDownLatch f54976d;

        /* renamed from: e, reason: collision with root package name */
        private g f54977e;

        /* renamed from: f, reason: collision with root package name */
        private AdResponseModel f54978f;

        /* renamed from: g, reason: collision with root package name */
        protected b1 f54979g;

        /* renamed from: h, reason: collision with root package name */
        protected volatile boolean f54980h = false;

        /* renamed from: i, reason: collision with root package name */
        private y0 f54981i;

        void a(g gVar) {
            this.f54977e = gVar;
        }

        protected synchronized void d() {
            this.f54980h = true;
            f();
        }

        protected abstract boolean e();

        protected void a(AdResponseModel adResponseModel) {
            if (this.f54980h) {
                return;
            }
            this.f54978f = adResponseModel;
        }

        AdResponseModel b() {
            return this.f54978f;
        }

        void c() {
            g gVar = this.f54977e;
            if (gVar != null) {
                gVar.a(e() ? "RunHttp" : "RunLocal");
            }
        }

        protected void f() {
            CountDownLatch countDownLatch = this.f54976d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                this.f54976d = null;
            }
        }

        e(Context context, ConfigResponseModel configResponseModel, b1 b1Var, a2 a2Var, CountDownLatch countDownLatch) {
            this.f54973a = context;
            this.f54974b = configResponseModel;
            this.f54979g = b1Var;
            this.f54975c = a2Var;
            this.f54976d = countDownLatch;
        }

        void a(y0 y0Var) {
            this.f54981i = y0Var;
        }

        y0 a() {
            return this.f54981i;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class f extends e {

        /* renamed from: j, reason: collision with root package name */
        private ICommonTimeoutTask f54982j;

        /* renamed from: k, reason: collision with root package name */
        private AdCacheModel f54983k;

        /* renamed from: l, reason: collision with root package name */
        private final xyz.adscope.ad.a f54984l;

        /* renamed from: m, reason: collision with root package name */
        private AdvertisingDBModel f54985m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f54986n;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends ICommonTimeoutTask {
            a(long j6) {
                super(j6);
            }

            @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
            protected void onScheduleTimeout() {
                f.this.f();
            }
        }

        @Override // xyz.adscope.ad.d4.e
        protected void d() {
            xyz.adscope.ad.a aVar;
            a((AdResponseModel) null);
            AdvertisingDBModel advertisingDBModel = this.f54985m;
            if (advertisingDBModel != null && (aVar = this.f54984l) != null) {
                aVar.a(advertisingDBModel);
            }
            super.d();
        }

        @Override // xyz.adscope.ad.d4.e
        protected boolean e() {
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f54986n = false;
            if (d4.this.a(this.f54975c)) {
                f();
                return;
            }
            if (!d4.this.a(this.f54983k)) {
                f();
                return;
            }
            xyz.adscope.ad.a aVar = this.f54984l;
            if (aVar != null) {
                AdResponseModel b6 = aVar.b(this.f54975c.getSpaceID());
                if (b6 == null) {
                    AdvertisingDBModel a6 = this.f54984l.a(d4.this.f54957e.getAppId(), this.f54975c.getSpaceID());
                    this.f54985m = a6;
                    if (a6 != null && !TextUtils.isEmpty(a6.a())) {
                        AdResponseModel adResponseModel = new AdResponseModel(JsonUtil.parseJSONObject(this.f54985m.a()));
                        if (!adResponseModel.hasParseException()) {
                            b6 = adResponseModel;
                        }
                    }
                }
                if (b6 != null) {
                    a(b6);
                    this.f54986n = true;
                    ICommonTimeoutTask iCommonTimeoutTask = this.f54982j;
                    if (iCommonTimeoutTask != null) {
                        iCommonTimeoutTask.startCountDown();
                        return;
                    } else {
                        c();
                        f();
                        return;
                    }
                }
            }
            f();
        }

        f(Context context, ConfigResponseModel configResponseModel, b1 b1Var, a2 a2Var, CountDownLatch countDownLatch) {
            super(context, configResponseModel, b1Var, a2Var, countDownLatch);
            this.f54986n = false;
            a(configResponseModel);
            this.f54984l = xyz.adscope.ad.b.a().getOrCreateImplement(this.f54973a);
        }

        private void a(ConfigResponseModel configResponseModel) {
            if (configResponseModel != null) {
                AdCacheModel a6 = d4.this.a(configResponseModel);
                this.f54983k = a6;
                if (a6 != null) {
                    long b6 = a6.b();
                    if (b6 > 0) {
                        this.f54982j = new a(b6);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class g {

        /* renamed from: a, reason: collision with root package name */
        private final Object f54989a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, e> f54990b;

        /* synthetic */ g(Map map, a aVar) {
            this(map);
        }

        private g(Map<String, e> map) {
            this.f54989a = new Object();
            this.f54990b = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            e eVar;
            synchronized (this.f54989a) {
                try {
                    Map<String, e> map = this.f54990b;
                    if (map != null && (eVar = map.get(str)) != null) {
                        eVar.d();
                        this.f54990b.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class h extends e {
        private boolean b(AdResponseModel adResponseModel) {
            List a6;
            BidModel bidModel;
            AdModel a7;
            if (adResponseModel == null || (a6 = d4.this.a(adResponseModel)) == null || a6.isEmpty() || (bidModel = (BidModel) a6.get(0)) == null || bidModel.d() == null || (a7 = bidModel.d().a()) == null) {
                return false;
            }
            return this.f54975c.getAdType().b().equals(a7.a());
        }

        @Override // xyz.adscope.ad.d4.e
        protected boolean e() {
            return true;
        }

        h(Context context, ConfigResponseModel configResponseModel, b1 b1Var, a2 a2Var, CountDownLatch countDownLatch) {
            super(context, configResponseModel, b1Var, a2Var, countDownLatch);
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject b6;
            r5 s2SAdImpl = this.f54975c.getS2SAdImpl();
            if (s2SAdImpl != null && (b6 = s2SAdImpl.b()) != null) {
                AdResponseModel adResponseModel = new AdResponseModel(b6);
                if (adResponseModel.hasParseException()) {
                    a(y0.ERROR_RESPONSE_PARSE_FAILED);
                } else if (b(adResponseModel)) {
                    a(adResponseModel);
                } else {
                    a(y0.ERROR_S2S_EXPRESS_TYPE_ERROR);
                }
            }
            f();
        }
    }

    public d4(Context context, xyz.adscope.ad.c cVar) {
        super(context);
        this.f54954b = new b(context, null);
        this.f54956d = new ArrayMap();
        this.f54955c = cVar;
        this.f54958f = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55715a);
    }

    @Override // xyz.adscope.ad.e2
    public void a(e3 e3Var) {
        this.f54954b.a(e3Var);
    }

    @Override // xyz.adscope.ad.e2
    public void a(ASNPInitConfig aSNPInitConfig, ConfigResponseModel configResponseModel, a2 a2Var, b1 b1Var) {
        this.f54957e = aSNPInitConfig;
        this.f54959g = a2Var;
        c cVar = new c(this, configResponseModel, a2Var, b1Var, null);
        IBaseThreadPool iBaseThreadPool = this.f54958f;
        if (iBaseThreadPool != null) {
            iBaseThreadPool.executeBasicAsyncTask(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a2 a2Var) {
        return (a2Var == null || a2Var.getS2SAdImpl() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdCacheModel a(ConfigResponseModel configResponseModel) {
        StrategyModel strategyModel;
        if (configResponseModel == null || (strategyModel = (StrategyModel) CollectionFetch.fetchFirstFromList(configResponseModel.j(), this.f54959g.getSpaceID(), new a())) == null) {
            return null;
        }
        return strategyModel.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdCacheModel adCacheModel) {
        return adCacheModel != null && adCacheModel.a() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<s3> a(List<BidModel> list, a2 a2Var, b1 b1Var) {
        ArrayList arrayList = new ArrayList();
        for (BidModel bidModel : list) {
            b1 deepCopy = b1Var.deepCopy();
            deepCopy.a(bidModel);
            arrayList.add(s3.a.a(this.f55715a, bidModel, a2Var, deepCopy));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BidModel> a(AdResponseModel adResponseModel) {
        List<SeatBidModel> b6 = adResponseModel.b();
        if (b6 == null || b6.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SeatBidModel seatBidModel : b6) {
            List<BidModel> a6 = seatBidModel.a();
            if (a6 != null && !a6.isEmpty()) {
                for (BidModel bidModel : a6) {
                    String str = "";
                    bidModel.a(seatBidModel.b() != null ? seatBidModel.b().a() : "");
                    if (seatBidModel.b() != null) {
                        str = seatBidModel.b().b();
                    }
                    bidModel.b(str);
                    arrayList.add(bidModel);
                }
            }
        }
        return arrayList;
    }
}
