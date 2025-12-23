package xyz.adscope.ad;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par.SlideParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class t6 extends x4 {

    /* renamed from: h, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f55996h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f55997i;

    /* renamed from: j, reason: collision with root package name */
    private int f55998j;

    /* renamed from: k, reason: collision with root package name */
    private int f55999k;

    /* renamed from: l, reason: collision with root package name */
    private SlideParams f56000l;

    /* renamed from: m, reason: collision with root package name */
    private final long f56001m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f56002n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (t6.this.f56002n) {
                t6 t6Var = t6.this;
                t6Var.f56124f.getGlobalVisibleRect(t6Var.f55997i);
                if (t6.this.f55999k == 0) {
                    t6 t6Var2 = t6.this;
                    t6Var2.f55999k = t6Var2.f55997i.top;
                }
                t6 t6Var3 = t6.this;
                t6.b(t6Var3, Math.abs(t6Var3.f55997i.top - t6.this.f55999k));
                if (t6.this.f55998j <= t6.this.f56000l.a() || System.currentTimeMillis() - t6.this.f56001m <= t6.this.f56000l.b()) {
                    return;
                }
                t6.this.d();
                t6.this.f56124f.getViewTreeObserver().removeOnScrollChangedListener(t6.this.f55996h);
            }
        }
    }

    static /* synthetic */ int b(t6 t6Var, int i6) {
        int i7 = t6Var.f55998j + i6;
        t6Var.f55998j = i7;
        return i7;
    }

    private ViewTreeObserver.OnScrollChangedListener f() {
        if (this.f56000l == null) {
            return null;
        }
        this.f55997i = new Rect();
        return new a();
    }

    public t6(Context context, String str) {
        super(context, str);
        this.f56002n = false;
        this.f56001m = System.currentTimeMillis();
    }

    @Override // xyz.adscope.ad.x4, xyz.adscope.ad.i3
    public void b() {
        super.b();
        this.f56002n = false;
    }

    @Override // xyz.adscope.ad.x4, xyz.adscope.ad.i3
    public void a() {
        super.a();
        this.f56002n = true;
    }

    @Override // xyz.adscope.ad.x4
    protected void b(OptimizeModel optimizeModel) {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        this.f56000l = optimizeModel.d();
        if (this.f56124f != null) {
            this.f55996h = f();
            ViewTreeObserver viewTreeObserver = this.f56124f.getViewTreeObserver();
            if (viewTreeObserver == null || (onScrollChangedListener = this.f55996h) == null) {
                return;
            }
            viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.ad.x4, xyz.adscope.ad.i3
    public void a(View view, c cVar) {
        super.a(view, cVar);
    }
}
