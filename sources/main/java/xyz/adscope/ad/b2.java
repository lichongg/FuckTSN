package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.d2;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.dev.oaid.OAIDHelper;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class b2<C extends a2, L extends d2> {

    /* renamed from: a, reason: collision with root package name */
    protected final xyz.adscope.ad.c f54864a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f54865b;

    /* renamed from: c, reason: collision with root package name */
    protected C f54866c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f54867d = false;

    /* renamed from: e, reason: collision with root package name */
    protected xyz.adscope.ad.a f54868e;

    /* renamed from: f, reason: collision with root package name */
    private final b2<C, L>.c f54869f;

    /* renamed from: g, reason: collision with root package name */
    private final v6 f54870g;

    /* renamed from: h, reason: collision with root package name */
    private final u6 f54871h;

    /* renamed from: i, reason: collision with root package name */
    private final w6 f54872i;

    /* renamed from: j, reason: collision with root package name */
    private ConfigResponseModel f54873j;

    /* renamed from: k, reason: collision with root package name */
    private final e2 f54874k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f54875l;

    /* renamed from: m, reason: collision with root package name */
    private String f54876m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ICollectionFetchCompare<StrategyFilterModel, String> {
        a() {
        }

        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(StrategyFilterModel strategyFilterModel, String str) {
            return (strategyFilterModel == null || TextUtils.isEmpty(str) || !str.equals(strategyFilterModel.d())) ? false : true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        public static b2 a(xyz.adscope.ad.c cVar, Context context, a2 a2Var) {
            return cVar == xyz.adscope.ad.c.NATIVE ? new u4(context, a2Var, cVar) : cVar == xyz.adscope.ad.c.UNIFIED ? new c7(context, a2Var, cVar) : new l1(context, a2Var, cVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements e3 {

        /* renamed from: a, reason: collision with root package name */
        private L f54878a;

        /* synthetic */ c(b2 b2Var, a aVar) {
            this();
        }

        private c() {
        }

        @Override // xyz.adscope.ad.e3
        public void onAdLoaded(List<s3> list) {
            b2.this.f54875l = false;
            b2.this.a(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(L l6) {
            this.f54878a = l6;
        }

        @Override // xyz.adscope.ad.e3
        public void a(y0 y0Var) {
            if (y0Var != y0.ERROR_AD_REQUESTING) {
                b2.this.f54875l = false;
            }
            L l6 = this.f54878a;
            if (l6 != null) {
                l6.onAdLoadFailed(y0Var.b(), y0Var.c());
            }
        }
    }

    protected abstract void a(List<s3> list);

    private boolean e() {
        Context context = this.f54865b;
        C c6 = this.f54866c;
        return i1.a(context, c6, a(c6.getSpaceID()));
    }

    private boolean g() {
        return this.f54873j != null;
    }

    public void a(L l6) {
        this.f54869f.a((b2<C, L>.c) l6);
        e2 e2Var = this.f54874k;
        if (e2Var != null) {
            e2Var.a(this.f54869f);
        }
    }

    protected L c() {
        return (L) ((c) this.f54869f).f54878a;
    }

    public String d() {
        return this.f54876m;
    }

    public boolean f() {
        return this.f54867d;
    }

    b2(Context context, C c6, xyz.adscope.ad.c cVar) {
        this.f54866c = c6;
        this.f54864a = cVar;
        this.f54865b = context;
        this.f54870g = new v6(context, c6.getApiKey(), c6.getSpaceID());
        u6 u6Var = new u6();
        this.f54871h = u6Var;
        this.f54872i = new w6(context, c6.getApiKey());
        u6Var.a(this.f54866c.getTimeoutMillion());
        this.f54868e = xyz.adscope.ad.b.a().getOrCreateImplement(this.f54865b);
        this.f54874k = new d4(this.f54865b, cVar);
        this.f54869f = new c(this, null);
    }

    protected boolean b() {
        w6 w6Var;
        long random = (long) ((Math.random() * 100.0d) + 1.0d);
        if (this.f54864a == xyz.adscope.ad.c.INTERSTITIAL && (w6Var = this.f54872i) != null) {
            w6Var.b(random);
            StrategyFilterModel a6 = a(this.f54866c.getSpaceID());
            if (a6 != null) {
                return this.f54872i.a(a6);
            }
            return false;
        }
        return false;
    }

    public void h() {
        ASNPInitConfig aSNPInitConfig;
        e orCreateImplement = f.a().getOrCreateImplement(this.f54865b);
        if (orCreateImplement != null) {
            aSNPInitConfig = orCreateImplement.a();
        } else {
            aSNPInitConfig = null;
        }
        a(aSNPInitConfig);
        C c6 = this.f54866c;
        if (c6 == null) {
            a(y0.ERROR_INVALID_CONFIG);
            return;
        }
        if (TextUtils.isEmpty(c6.getSpaceID())) {
            a(y0.ERROR_INVALID_SPACE_ID);
            return;
        }
        if (this.f54875l) {
            a(y0.ERROR_AD_REQUESTING);
            return;
        }
        if (orCreateImplement != null) {
            ConfigResponseModel a6 = orCreateImplement.a(true);
            this.f54873j = a6;
            if (a6 == null) {
                SDKLog.e("IBaseAdController", "unexpected error config copy is null...");
                a(y0.ERROR_SDK_NOT_INIT);
                return;
            }
            b1 a7 = a(this.f54866c);
            if (a7 == null) {
                a(y0.ERROR_S2S_VERIFICATION_FAILED);
                return;
            }
            this.f54876m = a7.t();
            a7.c(this.f54873j.d());
            l.a().getOrCreateImplement(this.f54865b).a(n1.EVENT_REPORT_LOAD_CODE, a7);
            if (!g()) {
                a(y0.ERROR_SDK_NOT_INIT);
                return;
            }
            if (a()) {
                a(y0.ERROR_REQUEST_TOO_OFTEN);
                return;
            }
            if (e()) {
                a(y0.ERROR_AD_BEING_COMPLAINED);
                return;
            } else if (b()) {
                a(y0.ERROR_UNITE_CONTROL);
                return;
            } else {
                a(orCreateImplement.a(), a7);
                return;
            }
        }
        SDKLog.e("IBaseAdController", "unexpected error config cache is null...");
        a(y0.ERROR_SDK_NOT_INIT);
    }

    private void a(ASNPInitConfig aSNPInitConfig) {
        if (aSNPInitConfig != null) {
            if (aSNPInitConfig.canUseOAIDInfo()) {
                SDKLog.d("IBaseAdController", "允许使用个性化推荐, 初始化OAID...");
                OAIDHelper.getInstance().initOAID(this.f54865b);
            }
            OAIDHelper.getInstance().setPersonalRecommend(aSNPInitConfig.canUseOAIDInfo());
        }
    }

    private b1 a(a2 a2Var) {
        b1 b1Var = new b1(a2Var);
        r5 s2SAdImpl = a2Var.getS2SAdImpl();
        if (s2SAdImpl == null) {
            return b1Var;
        }
        s2SAdImpl.a(this.f54865b);
        String c6 = s2SAdImpl.c();
        if (!s2SAdImpl.a().equals(a2Var.getSpaceID()) || TextUtils.isEmpty(c6)) {
            return null;
        }
        b1Var.e(c6);
        return b1Var;
    }

    private void a(ASNPInitConfig aSNPInitConfig, b1 b1Var) {
        C c6;
        e2 e2Var = this.f54874k;
        if (e2Var != null && (c6 = this.f54866c) != null) {
            this.f54867d = false;
            this.f54875l = true;
            e2Var.a(aSNPInitConfig, this.f54873j, c6, b1Var);
        } else {
            SDKLog.e("IBaseAdController", "unexpected error iAdRouter or mAdConfig is null...");
            a(y0.ERROR_UNEXPECTED);
        }
    }

    private void a(y0 y0Var) {
        b2<C, L>.c cVar = this.f54869f;
        if (cVar != null) {
            cVar.a(y0Var);
        }
    }

    private boolean a() {
        if (this.f54873j == null) {
            return false;
        }
        StrategyFilterModel a6 = a(this.f54866c.getSpaceID());
        return this.f54870g.a(a6) || this.f54871h.a(a6);
    }

    protected void a(long j6) {
        w6 w6Var = this.f54872i;
        if (w6Var != null) {
            w6Var.a(j6);
        }
    }

    private StrategyFilterModel a(String str) {
        if (this.f54873j == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (StrategyFilterModel) CollectionFetch.fetchFirstFromList(this.f54873j.e(), str, new a());
    }
}
