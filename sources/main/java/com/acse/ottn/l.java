package com.acse.ottn;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l extends Animation {

    /* renamed from: q, reason: collision with root package name */
    public static final boolean f4710q;

    /* renamed from: r, reason: collision with root package name */
    public static final WeakHashMap<View, l> f4711r;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f4712a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4714c;

    /* renamed from: e, reason: collision with root package name */
    public float f4716e;

    /* renamed from: f, reason: collision with root package name */
    public float f4717f;

    /* renamed from: g, reason: collision with root package name */
    public float f4718g;

    /* renamed from: h, reason: collision with root package name */
    public float f4719h;

    /* renamed from: i, reason: collision with root package name */
    public float f4720i;

    /* renamed from: l, reason: collision with root package name */
    public float f4723l;

    /* renamed from: m, reason: collision with root package name */
    public float f4724m;

    /* renamed from: b, reason: collision with root package name */
    public final Camera f4713b = new Camera();

    /* renamed from: d, reason: collision with root package name */
    public float f4715d = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f4721j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f4722k = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    public final RectF f4725n = new RectF();

    /* renamed from: o, reason: collision with root package name */
    public final RectF f4726o = new RectF();

    /* renamed from: p, reason: collision with root package name */
    public final Matrix f4727p = new Matrix();

    public static l a(View view) {
        WeakHashMap<View, l> weakHashMap = f4711r;
        l lVar = weakHashMap.get(view);
        if (lVar != null && lVar == view.getAnimation()) {
            return lVar;
        }
        l lVar2 = new l(view);
        weakHashMap.put(view, lVar2);
        return lVar2;
    }

    public float b() {
        return this.f4716e;
    }

    public float c() {
        return this.f4717f;
    }

    public float d() {
        return this.f4720i;
    }

    public float e() {
        return this.f4718g;
    }

    public float f() {
        return this.f4719h;
    }

    public float g() {
        return this.f4721j;
    }

    public float h() {
        return this.f4722k;
    }

    public int i() {
        View view = this.f4712a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int j() {
        View view = this.f4712a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float k() {
        return this.f4723l;
    }

    public float l() {
        return this.f4724m;
    }

    static {
        f4710q = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f4711r = new WeakHashMap<>();
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f6, Transformation transformation) {
        View view = this.f4712a.get();
        if (view != null) {
            transformation.setAlpha(this.f4715d);
            a(transformation.getMatrix(), view);
        }
    }

    public void b(float f6) {
        if (this.f4714c && this.f4716e == f6) {
            return;
        }
        p();
        this.f4714c = true;
        this.f4716e = f6;
        o();
    }

    public void c(float f6) {
        if (this.f4714c && this.f4717f == f6) {
            return;
        }
        p();
        this.f4714c = true;
        this.f4717f = f6;
        o();
    }

    public void d(float f6) {
        if (this.f4720i != f6) {
            p();
            this.f4720i = f6;
            o();
        }
    }

    public void e(float f6) {
        if (this.f4718g != f6) {
            p();
            this.f4718g = f6;
            o();
        }
    }

    public void f(float f6) {
        if (this.f4719h != f6) {
            p();
            this.f4719h = f6;
            o();
        }
    }

    public void g(float f6) {
        if (this.f4721j != f6) {
            p();
            this.f4721j = f6;
            o();
        }
    }

    public void h(float f6) {
        if (this.f4722k != f6) {
            p();
            this.f4722k = f6;
            o();
        }
    }

    public void k(float f6) {
        if (this.f4712a.get() != null) {
            i(f6 - r0.getLeft());
        }
    }

    public void l(float f6) {
        if (this.f4712a.get() != null) {
            j(f6 - r0.getTop());
        }
    }

    public float m() {
        if (this.f4712a.get() == null) {
            return 0.0f;
        }
        return r0.getLeft() + this.f4723l;
    }

    public float n() {
        if (this.f4712a.get() == null) {
            return 0.0f;
        }
        return r0.getTop() + this.f4724m;
    }

    public final void o() {
        View view = this.f4712a.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f4726o;
        a(rectF, view);
        rectF.union(this.f4725n);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void p() {
        View view = this.f4712a.get();
        if (view != null) {
            a(this.f4725n, view);
        }
    }

    public l(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f4712a = new WeakReference<>(view);
    }

    public void i(float f6) {
        if (this.f4723l != f6) {
            p();
            this.f4723l = f6;
            o();
        }
    }

    public void j(float f6) {
        if (this.f4724m != f6) {
            p();
            this.f4724m = f6;
            o();
        }
    }

    public float a() {
        return this.f4715d;
    }

    public void a(float f6) {
        if (this.f4715d != f6) {
            this.f4715d = f6;
            View view = this.f4712a.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void b(int i6) {
        View view = this.f4712a.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i6);
        }
    }

    public void a(int i6) {
        View view = this.f4712a.get();
        if (view != null) {
            view.scrollTo(i6, view.getScrollY());
        }
    }

    public final void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f4727p;
        matrix.reset();
        a(matrix, view);
        this.f4727p.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f6 = rectF.right;
        float f7 = rectF.left;
        if (f6 < f7) {
            rectF.right = f7;
            rectF.left = f6;
        }
        float f8 = rectF.bottom;
        float f9 = rectF.top;
        if (f8 < f9) {
            rectF.top = f8;
            rectF.bottom = f9;
        }
    }

    public final void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z5 = this.f4714c;
        float f6 = z5 ? this.f4716e : width / 2.0f;
        float f7 = z5 ? this.f4717f : height / 2.0f;
        float f8 = this.f4718g;
        float f9 = this.f4719h;
        float f10 = this.f4720i;
        if (f8 != 0.0f || f9 != 0.0f || f10 != 0.0f) {
            Camera camera = this.f4713b;
            camera.save();
            camera.rotateX(f8);
            camera.rotateY(f9);
            camera.rotateZ(-f10);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f6, -f7);
            matrix.postTranslate(f6, f7);
        }
        float f11 = this.f4721j;
        float f12 = this.f4722k;
        if (f11 != 1.0f || f12 != 1.0f) {
            matrix.postScale(f11, f12);
            matrix.postTranslate((-(f6 / width)) * ((f11 * width) - width), (-(f7 / height)) * ((f12 * height) - height));
        }
        matrix.postTranslate(this.f4723l, this.f4724m);
    }
}
