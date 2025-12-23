package xyz.adscope.ad;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class a7 extends x4 {

    /* renamed from: h, reason: collision with root package name */
    private boolean f54800h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnTouchListener f54801i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f54802j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f54803k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || !a7.this.f54800h) {
                return false;
            }
            a7.this.d();
            a7.this.f54800h = false;
            a7.this.h();
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a7.this.f54800h = true;
                if (!a7.this.f54803k) {
                    a7.this.g();
                    return false;
                }
                a7.this.d();
                return false;
            }
            return false;
        }
    }

    private View.OnTouchListener f() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f54801i == null && this.f54802j) {
            View.OnTouchListener f6 = f();
            this.f54801i = f6;
            a(this.f56124f, f6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(this.f56124f, (View.OnTouchListener) null);
    }

    @Override // xyz.adscope.ad.x4
    protected void b(OptimizeModel optimizeModel) {
        super.b(optimizeModel);
        View view = this.f56124f;
        if (view != null) {
            view.setOnTouchListener(new b());
        }
    }

    public a7(Context context, String str) {
        super(context, str);
        this.f54800h = false;
        this.f54802j = false;
        this.f54803k = false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.ad.x4, xyz.adscope.ad.i3
    public void a(View view, c cVar) {
        super.a(view, cVar);
        if (view instanceof z6) {
            z6 z6Var = (z6) view;
            this.f54802j = z6Var.e();
            this.f54803k = z6Var.f();
        }
    }

    private void a(View view, View.OnTouchListener onTouchListener) {
        if (view != null) {
            for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ((ViewGroup) parent).setOnTouchListener(onTouchListener);
            }
        }
    }
}
