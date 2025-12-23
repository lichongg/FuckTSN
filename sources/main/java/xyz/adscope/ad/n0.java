package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.a3;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.MediaModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.AdModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;
import xyz.adscope.ad.n3;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.u1;
import xyz.adscope.ad.y1;
import xyz.adscope.common.v2.beta.BetaTestManager;
import xyz.adscope.common.v2.beta.IBetaTest;
import xyz.adscope.common.v2.dev.info.ResIdentify;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.str.RegexUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class n0 implements r2 {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f55660a;

    /* renamed from: b, reason: collision with root package name */
    protected final BidModel f55661b;

    /* renamed from: c, reason: collision with root package name */
    protected final a2 f55662c;

    /* renamed from: d, reason: collision with root package name */
    protected final b1 f55663d;

    /* renamed from: e, reason: collision with root package name */
    protected final n3 f55664e;

    /* renamed from: f, reason: collision with root package name */
    protected final y1 f55665f;

    /* renamed from: g, reason: collision with root package name */
    protected final s1 f55666g;

    /* renamed from: h, reason: collision with root package name */
    private final j0 f55667h;

    /* renamed from: i, reason: collision with root package name */
    private final c f55668i;

    /* renamed from: j, reason: collision with root package name */
    private x2 f55669j;

    /* renamed from: k, reason: collision with root package name */
    private k3 f55670k;

    /* renamed from: l, reason: collision with root package name */
    private f4 f55671l;

    /* renamed from: m, reason: collision with root package name */
    private t3 f55672m;

    /* renamed from: n, reason: collision with root package name */
    private v1 f55673n;

    /* renamed from: o, reason: collision with root package name */
    private u1 f55674o;

    /* renamed from: p, reason: collision with root package name */
    private z2 f55675p;

    /* renamed from: q, reason: collision with root package name */
    private w4 f55676q;

    /* renamed from: r, reason: collision with root package name */
    private final IBetaTest f55677r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f55678a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NativeModel f55679b;

        a(Context context, NativeModel nativeModel) {
            this.f55678a = context;
            this.f55679b = nativeModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.a(StubApp.getOrigApplicationContext(this.f55678a.getApplicationContext()), this.f55679b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements y1 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f55681a;

        /* renamed from: b, reason: collision with root package name */
        private x1 f55682b;

        /* renamed from: c, reason: collision with root package name */
        private final u1.a f55683c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements u1.a {
            a() {
            }

            @Override // xyz.adscope.ad.u1.a
            public void a() {
                if (!n0.this.f55663d.z() && n0.this.f55669j != null) {
                    n0.this.f55663d.D();
                    n0.this.f55669j.onAdExposure();
                }
                if (n0.this.f55670k != null) {
                    n0.this.f55670k.a();
                }
            }

            @Override // xyz.adscope.ad.u1.a
            public void b() {
            }
        }

        private b() {
            this.f55681a = false;
            this.f55683c = new a();
        }

        @Override // xyz.adscope.ad.m2
        public void a(x1 x1Var) {
            this.f55682b = x1Var;
        }

        @Override // xyz.adscope.ad.y1
        public void b(l2 l2Var) {
            String str;
            n0 n0Var = n0.this;
            i1.a(n0Var.f55660a, n0Var.f55662c, System.currentTimeMillis());
            View expressView = n0.this.getExpressView();
            if (expressView instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) {
                str = a.c.a((xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) expressView);
                n0.this.f55663d.b(str);
            } else {
                str = "";
            }
            n0 n0Var2 = n0.this;
            n0Var2.f55666g.a(n1.EVENT_REPORT_COMPLAIN_CODE, n0Var2.f55663d);
            n0.this.f55672m.a(str);
            a((l2) y1.a.AD_CLOSE);
        }

        @Override // xyz.adscope.ad.y1
        public void c(l2 l2Var) {
            n0 n0Var = n0.this;
            s1 s1Var = n0Var.f55666g;
            n1 n1Var = n1.EVENT_REPORT_CLICK_CODE;
            s1Var.a(n1Var, n0Var.f55663d);
            x1 x1Var = this.f55682b;
            if (x1Var instanceof v2) {
                ((v2) x1Var).a(n0.this.f55663d.deepCopy());
            }
            if (n0.this.f55675p != null && n0.this.f55675p.b() == 1 && n0.this.f55674o != null) {
                n0.this.f55674o.a(l2Var, n0.this.f55663d, this.f55683c);
                if (!this.f55681a) {
                    this.f55681a = true;
                    n0.this.f55667h.a(n0.this.f55662c.getSpaceID(), n1Var);
                    n0 n0Var2 = n0.this;
                    n0Var2.f55666g.a(n1.EVENT_REPORT_CALL_CLICK_CODE, n0Var2.f55663d);
                }
            }
            if (n0.this.f55662c.getAdType() == xyz.adscope.ad.c.SPLASH) {
                a((l2) y1.a.AD_CLOSE);
            }
        }

        @Override // xyz.adscope.ad.y1
        public void a(l2 l2Var) {
            View expressView = n0.this.getExpressView();
            if (expressView instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) {
                ((xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) expressView).removeFromParent();
            }
            if (n0.this.f55669j != null) {
                n0.this.f55669j.onAdClosed();
                n0 n0Var = n0.this;
                n0Var.f55666g.a(n1.EVENT_REPORT_CLOSE_CODE, n0Var.f55663d);
            }
        }

        /* synthetic */ b(n0 n0Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.y1
        public void a(y1.a aVar) {
            v1 v1Var = n0.this.f55673n;
            n0 n0Var = n0.this;
            v1Var.a(aVar, n0Var.f55663d, n0Var.a(n0Var.f55661b).f());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements IBidding {
        private c() {
        }

        /* synthetic */ c(n0 n0Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.publish.ad.IBidding
        public int getECPM() {
            return n0.this.c();
        }

        @Override // xyz.adscope.ad.publish.ad.IBidding
        public void notifyBidLose(Map<String, String> map) {
            n0.this.a(map);
        }

        @Override // xyz.adscope.ad.publish.ad.IBidding
        public void notifyBidWin(Map<String, String> map) {
            n0.this.b(map);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected class d implements a3 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f55687a = false;

        /* renamed from: b, reason: collision with root package name */
        private Boolean f55688b = Boolean.FALSE;

        /* renamed from: c, reason: collision with root package name */
        private final u1.a f55689c = new a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements u1.a {
            a() {
            }

            @Override // xyz.adscope.ad.u1.a
            public void a() {
                n0 n0Var = n0.this;
                n0Var.f55666g.a(n1.EVENT_REPORT_CALL_EXPOSURE_CODE, n0Var.f55663d);
                n0.this.f55663d.D();
                if (n0.this.f55669j != null) {
                    n0.this.f55669j.onAdExposure();
                }
            }

            @Override // xyz.adscope.ad.u1.a
            public void b() {
                d.this.f55688b = Boolean.TRUE;
            }
        }

        @Override // xyz.adscope.ad.a3
        public void b(l2 l2Var, View view) {
            if (n0.this.f55676q != null) {
                n0.this.f55676q.d();
            }
            if (n0.this.f55663d.v() == 0) {
                n0.this.f55663d.C();
            }
            if (n0.this.f55663d.A() || n0.this.f55669j == null) {
                return;
            }
            n0.this.f55663d.E();
            n0.this.f55669j.onAdShown();
            n0 n0Var = n0.this;
            n0Var.f55666g.a(n1.EVENT_REPORT_SHOW_CODE, n0Var.f55663d);
        }

        protected d() {
        }

        @Override // xyz.adscope.ad.m2
        public void a(y2 y2Var) {
            n0.this.f55675p = y2Var;
        }

        @Override // xyz.adscope.ad.a3
        public void a(View view) {
            if (n0.this.f55676q != null) {
                n0.this.f55676q.c();
            }
        }

        @Override // xyz.adscope.ad.a3
        public void a(l2 l2Var, View view) {
            if (this.f55688b.booleanValue() || n0.this.f55674o == null || n0.this.f55669j == null) {
                return;
            }
            n0.this.f55674o.a(l2Var, n0.this.f55663d, this.f55689c);
            if (n0.this.f55676q != null) {
                n0.this.f55676q.a(n0.this.getExpressView());
            }
        }

        @Override // xyz.adscope.ad.a3
        public void b(View view) {
            if (this.f55687a) {
                return;
            }
            this.f55687a = true;
            i4 a6 = n0.this.a(view);
            if (a6 != null) {
                a6.a(view);
            }
            n0.this.f55663d.B();
            j0 j0Var = n0.this.f55667h;
            String spaceID = n0.this.f55662c.getSpaceID();
            n1 n1Var = n1.EVENT_REPORT_EXPOSURE_CODE;
            j0Var.a(spaceID, n1Var);
            v1 v1Var = n0.this.f55673n;
            a3.a aVar = a3.a.AD_EXPOSURE;
            n0 n0Var = n0.this;
            v1Var.a(aVar, n0Var.f55663d, n0Var.a(n0Var.f55661b).f());
            n0 n0Var2 = n0.this;
            n0Var2.f55666g.a(n1Var, n0Var2.f55663d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e implements n3 {
        private e() {
        }

        @Override // xyz.adscope.ad.m2
        public void a(m3 m3Var) {
        }

        /* synthetic */ e(n0 n0Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.n3
        public void a(View view, n3.a aVar) {
            xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar2;
            i4 c6;
            if (n0.this.f55676q != null) {
                n0.this.f55676q.e();
            }
            n0.this.f55663d.b(aVar.getEventCode());
            if (view instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) {
                aVar2 = (xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view;
            } else {
                aVar2 = view != null ? (xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view.getTag(ResIdentify.getIDIdentify(n0.this.f55660a, "scope_root_container")) : null;
            }
            if (aVar2 == null || (c6 = a.c.c(aVar2)) == null) {
                return;
            }
            c6.a(aVar2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected class f implements h4 {
        @Override // xyz.adscope.ad.m2
        public void a(g4 g4Var) {
        }

        protected f() {
        }

        @Override // xyz.adscope.ad.h4
        public void a(l2 l2Var, int i6) {
        }

        @Override // xyz.adscope.ad.h4
        public void d(l2 l2Var) {
            if (n0.this.f55671l != null) {
                n0.this.f55671l.onVideoPlay();
            }
        }

        @Override // xyz.adscope.ad.h4
        public void e(l2 l2Var) {
            if (n0.this.f55671l != null) {
                n0.this.f55671l.onVideoPlayCompleted();
            }
        }

        @Override // xyz.adscope.ad.h4
        public void f(l2 l2Var) {
            if (n0.this.f55671l != null) {
                n0.this.f55671l.onVideoPlayFailed();
            }
        }
    }

    private void d(BidModel bidModel) {
        u1 orCreateImplement = z.a().getOrCreateImplement(this.f55660a);
        this.f55674o = orCreateImplement;
        orCreateImplement.a(a(bidModel));
    }

    private void e(BidModel bidModel) {
        v1 orCreateImplement = c0.a().getOrCreateImplement(this.f55660a);
        this.f55673n = orCreateImplement;
        orCreateImplement.a(a(bidModel));
    }

    public void b(Map<String, String> map) {
        if (map != null) {
            String f6 = this.f55661b.f();
            if (TextUtils.isEmpty(f6)) {
                return;
            }
            String str = map.get("winPrice");
            String str2 = map.get(IBidding.BiddingPriceBuilder.SEC_HIGHEST_PRICE);
            String str3 = map.get("adnId");
            h1 h1Var = new h1(str, str2, "", str3, map.get(IBidding.BiddingPriceBuilder.EXPECT_PRICE));
            SDKLog.i("NativeImpl", "上报竞价结果... 竞价成功 竞成价格:" + str + " 次高价: " + str2 + " adn " + str3);
            this.f55663d.d(str);
            this.f55663d.a("1");
            a(f6, h1Var);
        }
    }

    public int c() {
        return (int) this.f55661b.e();
    }

    @Override // xyz.adscope.ad.r2
    public IBidding getBidding() {
        return this.f55668i;
    }

    protected n0(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        this.f55660a = context;
        this.f55661b = bidModel;
        this.f55662c = a2Var;
        this.f55663d = b1Var;
        a aVar = null;
        this.f55664e = new e(this, aVar);
        this.f55665f = new b(this, aVar);
        this.f55668i = new c(this, aVar);
        this.f55666g = l.a().getOrCreateImplement(context);
        this.f55667h = k0.a().getOrCreateImplement(context);
        e(bidModel);
        d(bidModel);
        a(context, b(bidModel));
        this.f55677r = BetaTestManager.getInstance().getOrCreateImplement(context);
        a(b(bidModel));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReportModel c(BidModel bidModel) {
        AdModel a6;
        if (bidModel == null || bidModel.d() == null || (a6 = bidModel.d().a()) == null || a6.b() == null) {
            return null;
        }
        return a6.b().e();
    }

    @Override // xyz.adscope.ad.r2
    public void a(x2 x2Var) {
        this.f55669j = x2Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d d() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f e() {
        return new f();
    }

    @Override // xyz.adscope.ad.r2
    public void a(k3 k3Var) {
        this.f55670k = k3Var;
    }

    @Override // xyz.adscope.ad.r2
    public void a(f4 f4Var) {
        this.f55671l = f4Var;
    }

    @Override // xyz.adscope.ad.r2
    public void a(t3 t3Var) {
        this.f55672m = t3Var;
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            String c6 = this.f55661b.c();
            if (TextUtils.isEmpty(c6)) {
                return;
            }
            String str = map.get("winPrice");
            String str2 = map.get("lossReason");
            String str3 = map.get(IBidding.BiddingPriceBuilder.SEC_HIGHEST_PRICE);
            String str4 = map.get("adnId");
            h1 h1Var = new h1(str, str3, str2, str4, map.get(IBidding.BiddingPriceBuilder.EXPECT_PRICE));
            SDKLog.i("NativeImpl", "上报竞价结果... 竞价失败 竞成价格:" + str + " 原因: " + str2 + " adn " + str4);
            this.f55663d.d(str);
            this.f55663d.a("0");
            a(c6, h1Var);
        }
    }

    protected NativeModel b(BidModel bidModel) {
        if (bidModel == null || bidModel.d() == null) {
            return null;
        }
        MediaModel d6 = bidModel.d();
        if (d6.a() == null || d6.a().b() == null) {
            return null;
        }
        return d6.a().b().d();
    }

    private boolean b() {
        ASNPInitConfig a6;
        xyz.adscope.ad.e orCreateImplement = xyz.adscope.ad.f.a().getOrCreateImplement(this.f55660a);
        if (orCreateImplement == null || (a6 = orCreateImplement.a()) == null) {
            return true;
        }
        return a6.isSupportSensor();
    }

    private void a(NativeModel nativeModel) {
        List<OptimizeModel> d6;
        if (nativeModel == null || (d6 = nativeModel.d()) == null || d6.isEmpty()) {
            return;
        }
        boolean z5 = false;
        OptimizeModel optimizeModel = d6.get(0);
        IBetaTest iBetaTest = this.f55677r;
        if (iBetaTest != null && iBetaTest.invokeBetaTest("4dcfae5406670c0ebd29c13c287229d7", f0.e(), 8)) {
            z5 = true;
        }
        if (optimizeModel == null || !z5) {
            return;
        }
        w4 w4Var = new w4(this.f55660a, this.f55662c.getApiKey(), optimizeModel);
        this.f55676q = w4Var;
        w4Var.a(this.f55664e);
    }

    protected DisplayModel a(BidModel bidModel) {
        AdModel a6;
        if (bidModel == null || bidModel.d() == null || (a6 = bidModel.d().a()) == null) {
            return null;
        }
        return a6.b();
    }

    private void a(Context context, NativeModel nativeModel) {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(context).executeBasicAsyncTask(new a(context, nativeModel));
    }

    private void a(String str, h1 h1Var) {
        new v5(this.f55660a, true).requestWithGetMethod(RegexUtil.replaceMacros(str, h1Var.getMacrosReplaceMap()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public i4 a(View view) {
        if (view != 0) {
            xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a expressRoot = view instanceof b4 ? ((b4) view).getExpressRoot() : null;
            if (view instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) {
                expressRoot = (xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view;
            }
            if (expressRoot != null) {
                return a.c.c(expressRoot);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i3 a(Object obj, String str, String str2) {
        i3 a6 = o4.a(this.f55660a, this.f55662c.getApiKey(), str, b());
        if (a6 != null) {
            a6.a(obj, this.f55662c.getAdType());
            NativeModel b6 = b(this.f55661b);
            if (b6 != null) {
                w2 a7 = a(str2, b6.c() != null ? b6.c().c() : -1, a(this.f55661b));
                w4 w4Var = this.f55676q;
                if (w4Var != null) {
                    w4Var.a(a7, obj);
                }
                if (a7 != null) {
                    a6.a(a7);
                    if (a6 instanceof k2) {
                        k2 k2Var = (k2) a6;
                        if (k2Var.c() != null) {
                            k2Var.c().a(this.f55664e);
                        }
                    }
                }
            }
        }
        return a6;
    }

    @Override // xyz.adscope.ad.r2
    public void destroyAd() {
    }

    protected w2 a(String str, int i6, DisplayModel displayModel) {
        j2 c6;
        w2 a6 = s0.a(str, i6);
        if (a6 != null) {
            a6.a(this.f55660a, this.f55662c.getApiKey(), displayModel);
            if ((a6 instanceof k2) && (c6 = ((k2) a6).c()) != null) {
                c6.a(this.f55665f);
            }
        }
        return a6;
    }
}
