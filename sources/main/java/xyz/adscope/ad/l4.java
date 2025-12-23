package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.w3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class l4 extends n0 implements g3 {

    /* renamed from: s, reason: collision with root package name */
    private final w3 f55354s;

    /* renamed from: t, reason: collision with root package name */
    private final z3 f55355t;

    /* renamed from: u, reason: collision with root package name */
    private x3 f55356u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements z3 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f55357a;

        private b() {
            this.f55357a = false;
        }

        @Override // xyz.adscope.ad.m2
        public void a(y3 y3Var) {
        }

        @Override // xyz.adscope.ad.z3
        public void renderFailed() {
            if (this.f55357a) {
                return;
            }
            this.f55357a = true;
            l4.this.f55666g.a(n1.EVENT_REPORT_RENDER_FAIL_CODE, l4.this.f55663d);
            l4.this.a(k4.NULL_EXPRESS_VIEW);
        }

        /* synthetic */ b(l4 l4Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.z3
        public void a(o2 o2Var) {
            b4 c6 = o2Var.c();
            if (c6 instanceof j3) {
                j3 j3Var = (j3) c6;
                i3 a6 = l4.this.a(o2Var.c(), j3Var.getInteractionType(), j3Var.getActionType());
                if (a6 != null) {
                    j3Var.a(a6);
                }
            }
        }

        @Override // xyz.adscope.ad.z3
        public void a() {
            l4.this.f55666g.a(n1.EVENT_REPORT_RENDER_SUCCESS_CODE, l4.this.f55663d);
            View expressView = l4.this.getExpressView();
            if (expressView instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) {
                xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar = (xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) expressView;
                l4.this.f55663d.a(a.c.c(aVar));
                l4 l4Var = l4.this;
                a.c.a(aVar, l4Var.c(l4Var.f55661b), l4.this.d(), l4.this.e());
                l4.this.b(expressView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        x3 x3Var = this.f55356u;
        if (x3Var != null) {
            x3Var.a(view);
        }
    }

    @Override // xyz.adscope.ad.r2
    public View getExpressView() {
        w3 w3Var = this.f55354s;
        if (w3Var != null) {
            return w3Var.getExpressView();
        }
        return null;
    }

    protected l4(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        super(context, bidModel, a2Var, b1Var);
        this.f55354s = w3.a.a(context, a2Var);
        this.f55355t = new b(this, null);
    }

    @Override // xyz.adscope.ad.n0, xyz.adscope.ad.r2
    public void destroyAd() {
        super.destroyAd();
        w3 w3Var = this.f55354s;
        if (w3Var != null) {
            w3Var.a();
        }
    }

    @Override // xyz.adscope.ad.g3
    public void a() {
        if (this.f55354s != null) {
            if (this.f55661b.d() != null) {
                w3 w3Var = this.f55354s;
                if ((w3Var instanceof k2) && ((k2) w3Var).c() != null) {
                    ((k2) this.f55354s).c().a(this.f55355t);
                }
                if (this.f55354s.a(this.f55661b.d())) {
                    this.f55666g.a(n1.EVENT_REPORT_RENDER_CODE, this.f55663d);
                    this.f55354s.b();
                    return;
                } else {
                    a(k4.RENDER_PREPARED_ERROR);
                    return;
                }
            }
            a(k4.INVALID_MEDIA_STRUCT);
        }
    }

    @Override // xyz.adscope.ad.g3
    public void a(x3 x3Var) {
        this.f55356u = x3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k4 k4Var) {
        x3 x3Var = this.f55356u;
        if (x3Var != null) {
            x3Var.a(k4Var);
        }
    }
}
