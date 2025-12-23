package com.scwang.smartrefresh.header.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int A = 1332;
    private static final float B = 5.0f;
    private static final int C = 10;
    private static final int D = 5;
    private static final float E = 5.0f;
    private static final int F = 12;
    private static final int G = 6;
    private static final float H = 0.8f;

    /* renamed from: n, reason: collision with root package name */
    private static final float f37124n = 1080.0f;

    /* renamed from: o, reason: collision with root package name */
    public static final int f37125o = 0;

    /* renamed from: p, reason: collision with root package name */
    public static final int f37126p = 1;

    /* renamed from: q, reason: collision with root package name */
    private static final int f37127q = 40;

    /* renamed from: r, reason: collision with root package name */
    private static final float f37128r = 8.75f;

    /* renamed from: s, reason: collision with root package name */
    private static final float f37129s = 2.5f;

    /* renamed from: t, reason: collision with root package name */
    private static final int f37130t = 56;

    /* renamed from: u, reason: collision with root package name */
    private static final float f37131u = 12.5f;

    /* renamed from: v, reason: collision with root package name */
    private static final float f37132v = 3.0f;

    /* renamed from: x, reason: collision with root package name */
    private static final float f37134x = 0.75f;

    /* renamed from: y, reason: collision with root package name */
    private static final float f37135y = 0.5f;

    /* renamed from: z, reason: collision with root package name */
    private static final float f37136z = 0.5f;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Animation> f37137a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final d f37138b;

    /* renamed from: c, reason: collision with root package name */
    private float f37139c;

    /* renamed from: d, reason: collision with root package name */
    private Resources f37140d;

    /* renamed from: e, reason: collision with root package name */
    private View f37141e;

    /* renamed from: f, reason: collision with root package name */
    private Animation f37142f;

    /* renamed from: g, reason: collision with root package name */
    float f37143g;

    /* renamed from: h, reason: collision with root package name */
    private double f37144h;

    /* renamed from: i, reason: collision with root package name */
    private double f37145i;

    /* renamed from: j, reason: collision with root package name */
    boolean f37146j;

    /* renamed from: k, reason: collision with root package name */
    private final Drawable.Callback f37147k;

    /* renamed from: l, reason: collision with root package name */
    private static final Interpolator f37122l = new LinearInterpolator();

    /* renamed from: m, reason: collision with root package name */
    static final Interpolator f37123m = new com.scwang.smartrefresh.header.internal.a();

    /* renamed from: w, reason: collision with root package name */
    private static final int[] f37133w = {ViewCompat.MEASURED_STATE_MASK};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Animation {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f37148a;

        a(d dVar) {
            this.f37148a = dVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f6, Transformation transformation) {
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.f37146j) {
                materialProgressDrawable.a(f6, this.f37148a);
                return;
            }
            float c6 = materialProgressDrawable.c(this.f37148a);
            float l6 = this.f37148a.l();
            float n6 = this.f37148a.n();
            float m6 = this.f37148a.m();
            MaterialProgressDrawable.this.n(f6, this.f37148a);
            if (f6 <= 0.5f) {
                this.f37148a.F(n6 + ((MaterialProgressDrawable.H - c6) * MaterialProgressDrawable.f37123m.getInterpolation(f6 / 0.5f)));
            }
            if (f6 > 0.5f) {
                this.f37148a.B(l6 + ((MaterialProgressDrawable.H - c6) * MaterialProgressDrawable.f37123m.getInterpolation((f6 - 0.5f) / 0.5f)));
            }
            this.f37148a.D(m6 + (0.25f * f6));
            MaterialProgressDrawable materialProgressDrawable2 = MaterialProgressDrawable.this;
            materialProgressDrawable2.i((f6 * 216.0f) + ((materialProgressDrawable2.f37143g / 5.0f) * MaterialProgressDrawable.f37124n));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f37150a;

        b(d dVar) {
            this.f37150a = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f37150a.H();
            this.f37150a.p();
            d dVar = this.f37150a;
            dVar.F(dVar.e());
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (!materialProgressDrawable.f37146j) {
                materialProgressDrawable.f37143g = (materialProgressDrawable.f37143g + 1.0f) % 5.0f;
                return;
            }
            materialProgressDrawable.f37146j = false;
            animation.setDuration(1332L);
            this.f37150a.E(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.f37143g = 0.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Drawable.Callback {
        c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
            MaterialProgressDrawable.this.scheduleSelf(runnable, j6);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MaterialProgressDrawable.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private final RectF f37153a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        private final Paint f37154b;

        /* renamed from: c, reason: collision with root package name */
        private final Paint f37155c;

        /* renamed from: d, reason: collision with root package name */
        private final Drawable.Callback f37156d;

        /* renamed from: e, reason: collision with root package name */
        private float f37157e;

        /* renamed from: f, reason: collision with root package name */
        private float f37158f;

        /* renamed from: g, reason: collision with root package name */
        private float f37159g;

        /* renamed from: h, reason: collision with root package name */
        private float f37160h;

        /* renamed from: i, reason: collision with root package name */
        private float f37161i;

        /* renamed from: j, reason: collision with root package name */
        private int[] f37162j;

        /* renamed from: k, reason: collision with root package name */
        private int f37163k;

        /* renamed from: l, reason: collision with root package name */
        private float f37164l;

        /* renamed from: m, reason: collision with root package name */
        private float f37165m;

        /* renamed from: n, reason: collision with root package name */
        private float f37166n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f37167o;

        /* renamed from: p, reason: collision with root package name */
        private Path f37168p;

        /* renamed from: q, reason: collision with root package name */
        private float f37169q;

        /* renamed from: r, reason: collision with root package name */
        private double f37170r;

        /* renamed from: s, reason: collision with root package name */
        private int f37171s;

        /* renamed from: t, reason: collision with root package name */
        private int f37172t;

        /* renamed from: u, reason: collision with root package name */
        private int f37173u;

        /* renamed from: v, reason: collision with root package name */
        private final Paint f37174v;

        /* renamed from: w, reason: collision with root package name */
        private int f37175w;

        /* renamed from: x, reason: collision with root package name */
        private int f37176x;

        public void r() {
            this.f37164l = 0.0f;
            this.f37165m = 0.0f;
            this.f37166n = 0.0f;
            F(0.0f);
            B(0.0f);
            D(0.0f);
        }

        public void t(float f6, float f7) {
            this.f37171s = (int) f6;
            this.f37172t = (int) f7;
        }

        private void b(Canvas canvas, float f6, float f7, Rect rect) {
            if (this.f37167o) {
                Path path = this.f37168p;
                if (path == null) {
                    Path path2 = new Path();
                    this.f37168p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f8 = (((int) this.f37161i) / 2) * this.f37169q;
                float cos = (float) ((this.f37170r * Math.cos(0.0d)) + rect.exactCenterX());
                float sin = (float) ((this.f37170r * Math.sin(0.0d)) + rect.exactCenterY());
                this.f37168p.moveTo(0.0f, 0.0f);
                this.f37168p.lineTo(this.f37171s * this.f37169q, 0.0f);
                Path path3 = this.f37168p;
                float f9 = this.f37171s;
                float f10 = this.f37169q;
                path3.lineTo((f9 * f10) / 2.0f, this.f37172t * f10);
                this.f37168p.offset(cos - f8, sin);
                this.f37168p.close();
                this.f37155c.setColor(this.f37176x);
                canvas.rotate((f6 + f7) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f37168p, this.f37155c);
            }
        }

        private int h() {
            return (this.f37163k + 1) % this.f37162j.length;
        }

        private void q() {
            this.f37156d.invalidateDrawable(null);
        }

        public void A(@NonNull int[] iArr) {
            this.f37162j = iArr;
            z(0);
        }

        public void B(float f6) {
            this.f37158f = f6;
            q();
        }

        public void D(float f6) {
            this.f37159g = f6;
            q();
        }

        public void E(boolean z5) {
            if (this.f37167o != z5) {
                this.f37167o = z5;
                q();
            }
        }

        public void F(float f6) {
            this.f37157e = f6;
            q();
        }

        public void G(float f6) {
            this.f37160h = f6;
            this.f37154b.setStrokeWidth(f6);
            q();
        }

        public void H() {
            this.f37164l = this.f37157e;
            this.f37165m = this.f37158f;
            this.f37166n = this.f37159g;
        }

        public void a(Canvas canvas, Rect rect) {
            float f6;
            Canvas canvas2;
            RectF rectF = this.f37153a;
            rectF.set(rect);
            float f7 = this.f37161i;
            rectF.inset(f7, f7);
            float f8 = this.f37157e;
            float f9 = this.f37159g;
            float f10 = (f8 + f9) * 360.0f;
            float f11 = ((this.f37158f + f9) * 360.0f) - f10;
            if (f11 != 0.0f) {
                this.f37154b.setColor(this.f37176x);
                f6 = f10;
                canvas2 = canvas;
                canvas2.drawArc(rectF, f6, f11, false, this.f37154b);
            } else {
                f6 = f10;
                canvas2 = canvas;
            }
            b(canvas2, f6, f11, rect);
            if (this.f37173u < 255) {
                this.f37174v.setColor(this.f37175w);
                this.f37174v.setAlpha(255 - this.f37173u);
                canvas2.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.f37174v);
            }
        }

        public int c() {
            return this.f37173u;
        }

        public double d() {
            return this.f37170r;
        }

        public float e() {
            return this.f37158f;
        }

        public float f() {
            return this.f37161i;
        }

        public int g() {
            return this.f37162j[h()];
        }

        public float i() {
            return this.f37159g;
        }

        public float j() {
            return this.f37157e;
        }

        public int k() {
            return this.f37162j[this.f37163k];
        }

        public float l() {
            return this.f37165m;
        }

        public float m() {
            return this.f37166n;
        }

        public float n() {
            return this.f37164l;
        }

        public float o() {
            return this.f37160h;
        }

        public void s(int i6) {
            this.f37173u = i6;
        }

        public void u(float f6) {
            if (f6 != this.f37169q) {
                this.f37169q = f6;
                q();
            }
        }

        public void v(@ColorInt int i6) {
            this.f37175w = i6;
        }

        public void w(double d6) {
            this.f37170r = d6;
        }

        public void x(int i6) {
            this.f37176x = i6;
        }

        public void y(ColorFilter colorFilter) {
            this.f37154b.setColorFilter(colorFilter);
            q();
        }

        public void z(int i6) {
            this.f37163k = i6;
            this.f37176x = this.f37162j[i6];
        }

        d(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.f37154b = paint;
            Paint paint2 = new Paint();
            this.f37155c = paint2;
            this.f37157e = 0.0f;
            this.f37158f = 0.0f;
            this.f37159g = 0.0f;
            this.f37160h = 5.0f;
            this.f37161i = MaterialProgressDrawable.f37129s;
            this.f37174v = new Paint(1);
            this.f37156d = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        public void C(int i6, int i7) {
            double ceil;
            float min = Math.min(i6, i7);
            double d6 = this.f37170r;
            if (d6 > 0.0d && min >= 0.0f) {
                ceil = (min / 2.0f) - d6;
            } else {
                ceil = Math.ceil(this.f37160h / 2.0f);
            }
            this.f37161i = (float) ceil;
        }

        public void p() {
            z(h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private int b(float f6, int i6, int i7) {
        return ((((i6 >> 24) & 255) + ((int) ((((i7 >> 24) & 255) - r0) * f6))) << 24) | ((((i6 >> 16) & 255) + ((int) ((((i7 >> 16) & 255) - r1) * f6))) << 16) | ((((i6 >> 8) & 255) + ((int) ((((i7 >> 8) & 255) - r2) * f6))) << 8) | ((i6 & 255) + ((int) (f6 * ((i7 & 255) - r8))));
    }

    private float d() {
        return this.f37139c;
    }

    private void j(double d6, double d7, double d8, double d9, float f6, float f7) {
        d dVar = this.f37138b;
        float f8 = this.f37140d.getDisplayMetrics().density;
        double d10 = f8;
        this.f37144h = d6 * d10;
        this.f37145i = d7 * d10;
        dVar.G(((float) d9) * f8);
        dVar.w(d8 * d10);
        dVar.z(0);
        dVar.t(f6 * f8, f7 * f8);
        dVar.C((int) this.f37144h, (int) this.f37145i);
    }

    private void l() {
        d dVar = this.f37138b;
        a aVar = new a(dVar);
        aVar.setRepeatCount(-1);
        aVar.setRepeatMode(1);
        aVar.setInterpolator(f37122l);
        aVar.setAnimationListener(new b(dVar));
        this.f37142f = aVar;
    }

    public void e(float f6) {
        this.f37138b.u(f6);
    }

    public void f(@ColorInt int i6) {
        this.f37138b.v(i6);
    }

    public void g(int... iArr) {
        this.f37138b.A(iArr);
        this.f37138b.z(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f37138b.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f37145i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f37144h;
    }

    public void h(float f6) {
        this.f37138b.D(f6);
    }

    void i(float f6) {
        this.f37139c = f6;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f37137a;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Animation animation = arrayList.get(i6);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void k(float f6, float f7) {
        this.f37138b.F(f6);
        this.f37138b.B(f7);
    }

    public void m(boolean z5) {
        this.f37138b.E(z5);
    }

    void n(float f6, d dVar) {
        if (f6 > 0.75f) {
            dVar.x(b((f6 - 0.75f) / 0.25f, dVar.k(), dVar.g()));
        }
    }

    public void o(int i6) {
        if (i6 == 0) {
            j(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            j(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f37138b.s(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f37138b.y(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f37142f.reset();
        this.f37138b.H();
        if (this.f37138b.e() != this.f37138b.j()) {
            this.f37146j = true;
            this.f37142f.setDuration(666L);
            this.f37141e.startAnimation(this.f37142f);
        } else {
            this.f37138b.z(0);
            this.f37138b.r();
            this.f37142f.setDuration(1332L);
            this.f37141e.startAnimation(this.f37142f);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f37141e.clearAnimation();
        i(0.0f);
        this.f37138b.E(false);
        this.f37138b.z(0);
        this.f37138b.r();
    }

    public MaterialProgressDrawable(Context context, View view) {
        c cVar = new c();
        this.f37147k = cVar;
        this.f37141e = view;
        this.f37140d = context.getResources();
        d dVar = new d(cVar);
        this.f37138b = dVar;
        dVar.A(f37133w);
        o(1);
        l();
    }

    void a(float f6, d dVar) {
        n(f6, dVar);
        float floor = (float) (Math.floor(dVar.m() / H) + 1.0d);
        dVar.F(dVar.n() + (((dVar.l() - c(dVar)) - dVar.n()) * f6));
        dVar.B(dVar.l());
        dVar.D(dVar.m() + ((floor - dVar.m()) * f6));
    }

    float c(d dVar) {
        return (float) Math.toRadians(dVar.o() / (dVar.d() * 6.283185307179586d));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f37139c, bounds.exactCenterX(), bounds.exactCenterY());
        this.f37138b.a(canvas, bounds);
        canvas.restoreToCount(save);
    }
}
