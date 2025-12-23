package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import com.stub.StubApp;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel;
import xyz.adscope.ad.n3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class g1 implements i3<View, InteractionModel>, k2 {

    /* renamed from: b, reason: collision with root package name */
    protected final String f55162b;

    /* renamed from: c, reason: collision with root package name */
    protected final Context f55163c;

    /* renamed from: d, reason: collision with root package name */
    private w2 f55164d;

    /* renamed from: e, reason: collision with root package name */
    protected View f55165e;

    /* renamed from: g, reason: collision with root package name */
    protected InteractionModel f55167g;

    /* renamed from: h, reason: collision with root package name */
    protected c f55168h;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f55166f = false;

    /* renamed from: a, reason: collision with root package name */
    private final m3 f55161a = new m3();

    @Override // xyz.adscope.ad.i3
    public void b() {
        this.f55166f = false;
        this.f55161a.b();
    }

    protected abstract void d();

    @Override // xyz.adscope.ad.k2
    public j2 c() {
        return this.f55161a;
    }

    public g1(Context context, String str) {
        this.f55163c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f55162b = str;
    }

    @Override // xyz.adscope.ad.i3
    public void a(View view, c cVar) {
        this.f55165e = view;
        this.f55168h = cVar;
        this.f55161a.a((Object) null);
    }

    @Override // xyz.adscope.ad.i3
    public void a() {
        this.f55166f = true;
        this.f55161a.a();
    }

    @Override // xyz.adscope.ad.i3
    public void a(w2 w2Var) {
        this.f55164d = w2Var;
    }

    protected void a(n3.a aVar) {
        if (aVar == n3.a.EULER_INTERACTIVE_TRIGGER || aVar == n3.a.SHAKE_INTERACTIVE_TRIGGER) {
            e7.a().getOrCreateImplement(this.f55163c).b(this.f55168h);
        }
        this.f55161a.a(aVar, this.f55165e);
        w2 w2Var = this.f55164d;
        if (w2Var != null) {
            w2Var.a(this.f55165e, aVar.getEventCode());
        }
    }

    @Override // xyz.adscope.ad.i3
    public void a(InteractionModel interactionModel) {
        this.f55167g = interactionModel;
        d();
    }
}
