package xyz.adscope.ad;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.ad.n3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class x4 implements i3<View, OptimizeModel>, k2 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56119a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56120b;

    /* renamed from: c, reason: collision with root package name */
    protected final m3 f56121c = new m3();

    /* renamed from: d, reason: collision with root package name */
    protected OptimizeModel f56122d;

    /* renamed from: e, reason: collision with root package name */
    private w2 f56123e;

    /* renamed from: f, reason: collision with root package name */
    protected View f56124f;

    /* renamed from: g, reason: collision with root package name */
    protected b f56125g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b bVar = x4.this.f56125g;
            if (bVar != null) {
                bVar.a(view, motionEvent);
            }
            if (motionEvent.getAction() == 1) {
                x4.this.d();
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(View view, MotionEvent motionEvent);
    }

    @Override // xyz.adscope.ad.i3
    public void b() {
    }

    public void e() {
        this.f56124f = null;
        b();
    }

    protected void b(OptimizeModel optimizeModel) {
        View view = this.f56124f;
        if (view != null) {
            view.setOnTouchListener(new a());
        }
    }

    @Override // xyz.adscope.ad.k2
    public j2 c() {
        return this.f56121c;
    }

    protected void d() {
        m3 m3Var = this.f56121c;
        n3.a aVar = n3.a.OPTIMIZE_INTERACTIVE_TRIGGER;
        m3Var.a(aVar, this.f56124f);
        w2 w2Var = this.f56123e;
        if (w2Var != null) {
            w2Var.a(this.f56124f, aVar.getEventCode());
        }
    }

    public x4(Context context, String str) {
        this.f56119a = context;
        this.f56120b = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.ad.i3
    public void a(View view, c cVar) {
        this.f56124f = view;
        this.f56121c.a((Object) null);
    }

    @Override // xyz.adscope.ad.i3
    public void a() {
        this.f56121c.a();
    }

    @Override // xyz.adscope.ad.i3
    public void a(w2 w2Var) {
        this.f56123e = w2Var;
    }

    @Override // xyz.adscope.ad.i3
    public void a(OptimizeModel optimizeModel) {
        this.f56122d = optimizeModel;
        b(optimizeModel);
    }

    public void a(b bVar) {
        this.f56125g = bVar;
    }
}
