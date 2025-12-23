package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a extends master.flame.danmaku.danmaku.model.b<Canvas, Typeface> {

    /* renamed from: j, reason: collision with root package name */
    public Canvas f49945j;

    /* renamed from: k, reason: collision with root package name */
    private int f49946k;

    /* renamed from: l, reason: collision with root package name */
    private int f49947l;

    /* renamed from: m, reason: collision with root package name */
    private float f49948m;

    /* renamed from: f, reason: collision with root package name */
    private Camera f49941f = new Camera();

    /* renamed from: g, reason: collision with root package name */
    private Matrix f49942g = new Matrix();

    /* renamed from: h, reason: collision with root package name */
    private final C0971a f49943h = new C0971a();

    /* renamed from: i, reason: collision with root package name */
    private b f49944i = new i();

    /* renamed from: n, reason: collision with root package name */
    private float f49949n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    private int f49950o = 160;

    /* renamed from: p, reason: collision with root package name */
    private float f49951p = 1.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f49952q = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f49953r = true;

    /* renamed from: s, reason: collision with root package name */
    private int f49954s = 2048;

    /* renamed from: t, reason: collision with root package name */
    private int f49955t = 2048;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a, reason: collision with other inner class name */
    public static class C0971a {
        public static final int B = 4;

        /* renamed from: a, reason: collision with root package name */
        private float f49956a;

        /* renamed from: c, reason: collision with root package name */
        public final TextPaint f49958c;

        /* renamed from: d, reason: collision with root package name */
        public final TextPaint f49959d;

        /* renamed from: e, reason: collision with root package name */
        private Paint f49960e;

        /* renamed from: f, reason: collision with root package name */
        private Paint f49961f;

        /* renamed from: g, reason: collision with root package name */
        private Paint f49962g;

        /* renamed from: v, reason: collision with root package name */
        private boolean f49977v;

        /* renamed from: b, reason: collision with root package name */
        private final Map<Float, Float> f49957b = new HashMap(10);

        /* renamed from: h, reason: collision with root package name */
        public int f49963h = 4;

        /* renamed from: i, reason: collision with root package name */
        private float f49964i = 4.0f;

        /* renamed from: j, reason: collision with root package name */
        private float f49965j = 3.5f;

        /* renamed from: k, reason: collision with root package name */
        public float f49966k = 1.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f49967l = 1.0f;

        /* renamed from: m, reason: collision with root package name */
        private int f49968m = 204;

        /* renamed from: n, reason: collision with root package name */
        public boolean f49969n = false;

        /* renamed from: o, reason: collision with root package name */
        private boolean f49970o = false;

        /* renamed from: p, reason: collision with root package name */
        public boolean f49971p = true;

        /* renamed from: q, reason: collision with root package name */
        private boolean f49972q = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f49973r = false;

        /* renamed from: s, reason: collision with root package name */
        public boolean f49974s = false;

        /* renamed from: t, reason: collision with root package name */
        public boolean f49975t = true;

        /* renamed from: u, reason: collision with root package name */
        private boolean f49976u = true;

        /* renamed from: w, reason: collision with root package name */
        private int f49978w = master.flame.danmaku.danmaku.model.c.f50052a;

        /* renamed from: x, reason: collision with root package name */
        private float f49979x = 1.0f;

        /* renamed from: y, reason: collision with root package name */
        private boolean f49980y = false;

        /* renamed from: z, reason: collision with root package name */
        private int f49981z = 0;
        private int A = 0;

        private void h(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.f49980y) {
                Float f6 = this.f49957b.get(Float.valueOf(dVar.f50065l));
                if (f6 == null || this.f49956a != this.f49979x) {
                    float f7 = this.f49979x;
                    this.f49956a = f7;
                    f6 = Float.valueOf(dVar.f50065l * f7);
                    this.f49957b.put(Float.valueOf(dVar.f50065l), f6);
                }
                paint.setTextSize(f6.floatValue());
            }
        }

        public void g(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z5) {
            if (this.f49977v) {
                if (z5) {
                    paint.setStyle(this.f49974s ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.f50063j & 16777215);
                    paint.setAlpha(this.f49974s ? (int) (this.f49968m * (this.f49978w / master.flame.danmaku.danmaku.model.c.f50052a)) : this.f49978w);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.f50060g & 16777215);
                    paint.setAlpha(this.f49978w);
                }
            } else if (z5) {
                paint.setStyle(this.f49974s ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.f50063j & 16777215);
                paint.setAlpha(this.f49974s ? this.f49968m : master.flame.danmaku.danmaku.model.c.f50052a);
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(dVar.f50060g & 16777215);
                paint.setAlpha(master.flame.danmaku.danmaku.model.c.f50052a);
            }
            if (dVar.getType() == 7) {
                paint.setAlpha(dVar.c());
            }
        }

        public void i() {
            this.f49957b.clear();
        }

        public void j(boolean z5) {
            this.f49972q = this.f49971p;
            this.f49970o = this.f49969n;
            this.f49974s = this.f49973r;
            this.f49976u = z5 && this.f49975t;
        }

        public Paint k(master.flame.danmaku.danmaku.model.d dVar) {
            this.f49962g.setColor(dVar.f50066m);
            return this.f49962g;
        }

        public TextPaint l(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
            TextPaint textPaint;
            int i6;
            if (z5) {
                textPaint = this.f49958c;
            } else {
                textPaint = this.f49959d;
                textPaint.set(this.f49958c);
            }
            textPaint.setTextSize(dVar.f50065l);
            h(dVar, textPaint);
            if (this.f49970o) {
                float f6 = this.f49964i;
                if (f6 > 0.0f && (i6 = dVar.f50063j) != 0) {
                    textPaint.setShadowLayer(f6, 0.0f, 0.0f, i6);
                    textPaint.setAntiAlias(this.f49976u);
                    return textPaint;
                }
            }
            textPaint.clearShadowLayer();
            textPaint.setAntiAlias(this.f49976u);
            return textPaint;
        }

        public float m() {
            boolean z5 = this.f49970o;
            if (z5 && this.f49972q) {
                return Math.max(this.f49964i, this.f49965j);
            }
            if (z5) {
                return this.f49964i;
            }
            if (this.f49972q) {
                return this.f49965j;
            }
            return 0.0f;
        }

        public Paint n(master.flame.danmaku.danmaku.model.d dVar) {
            this.f49961f.setColor(dVar.f50064k);
            return this.f49961f;
        }

        public boolean o(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.f49972q || this.f49974s) && this.f49965j > 0.0f && dVar.f50063j != 0;
        }

        public void p(boolean z5) {
            this.f49958c.setFakeBoldText(z5);
        }

        public void q(float f6, float f7, int i6) {
            if (this.f49966k == f6 && this.f49967l == f7 && this.f49968m == i6) {
                return;
            }
            if (f6 <= 1.0f) {
                f6 = 1.0f;
            }
            this.f49966k = f6;
            if (f7 <= 1.0f) {
                f7 = 1.0f;
            }
            this.f49967l = f7;
            if (i6 < 0) {
                i6 = 0;
            } else if (i6 > 255) {
                i6 = 255;
            }
            this.f49968m = i6;
        }

        public void r(float f6) {
            this.f49980y = f6 != 1.0f;
            this.f49979x = f6;
        }

        public void s(float f6) {
            this.f49964i = f6;
        }

        public void t(float f6) {
            this.f49958c.setStrokeWidth(f6);
            this.f49965j = f6;
        }

        public void u(int i6) {
            this.f49977v = i6 != master.flame.danmaku.danmaku.model.c.f50052a;
            this.f49978w = i6;
        }

        public void v(Typeface typeface) {
            this.f49958c.setTypeface(typeface);
        }

        public C0971a() {
            TextPaint textPaint = new TextPaint();
            this.f49958c = textPaint;
            textPaint.setStrokeWidth(this.f49965j);
            this.f49959d = new TextPaint(textPaint);
            this.f49960e = new Paint();
            Paint paint = new Paint();
            this.f49961f = paint;
            paint.setStrokeWidth(this.f49963h);
            Paint paint2 = this.f49961f;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f49962g = paint3;
            paint3.setStyle(style);
            this.f49962g.setStrokeWidth(4.0f);
        }
    }

    private synchronized TextPaint G(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        return this.f49943h.l(dVar, z5);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public synchronized void s(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7, boolean z5) {
        b bVar = this.f49944i;
        if (bVar != null) {
            bVar.d(dVar, canvas, f6, f7, z5, this.f49943h);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void b(int i6, float[] fArr) {
        if (i6 != -1) {
            if (i6 == 0) {
                C0971a c0971a = this.f49943h;
                c0971a.f49969n = false;
                c0971a.f49971p = false;
                c0971a.f49973r = false;
                return;
            }
            if (i6 == 1) {
                C0971a c0971a2 = this.f49943h;
                c0971a2.f49969n = true;
                c0971a2.f49971p = false;
                c0971a2.f49973r = false;
                O(fArr[0]);
                return;
            }
            if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                C0971a c0971a3 = this.f49943h;
                c0971a3.f49969n = false;
                c0971a3.f49971p = false;
                c0971a3.f49973r = true;
                N(fArr[0], fArr[1], (int) fArr[2]);
                return;
            }
        }
        C0971a c0971a4 = this.f49943h;
        c0971a4.f49969n = false;
        c0971a4.f49971p = true;
        c0971a4.f49973r = false;
        M(fArr[0]);
    }

    private void B(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z5) {
        this.f49944i.e(dVar, textPaint, z5);
        K(dVar, dVar.f50069p, dVar.f50070q);
    }

    private int J(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7) {
        this.f49941f.save();
        float f8 = this.f49948m;
        if (f8 != 0.0f) {
            this.f49941f.setLocation(0.0f, 0.0f, f8);
        }
        this.f49941f.rotateY(-dVar.f50062i);
        this.f49941f.rotateZ(-dVar.f50061h);
        this.f49941f.getMatrix(this.f49942g);
        this.f49942g.preTranslate(-f6, -f7);
        this.f49942g.postTranslate(f6, f7);
        this.f49941f.restore();
        int save = canvas.save();
        canvas.concat(this.f49942g);
        return save;
    }

    private void K(master.flame.danmaku.danmaku.model.d dVar, float f6, float f7) {
        int i6 = dVar.f50067n;
        float f8 = f6 + (i6 * 2);
        float f9 = f7 + (i6 * 2);
        if (dVar.f50066m != 0) {
            float f10 = 8;
            f8 += f10;
            f9 += f10;
        }
        dVar.f50069p = f8 + m();
        dVar.f50070q = f9;
    }

    private void update(Canvas canvas) {
        this.f49945j = canvas;
        if (canvas != null) {
            this.f49946k = canvas.getWidth();
            this.f49947l = canvas.getHeight();
            if (this.f49953r) {
                this.f49954s = F(canvas);
                this.f49955t = E(canvas);
            }
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Canvas u() {
        return this.f49945j;
    }

    public void M(float f6) {
        this.f49943h.t(f6);
    }

    public void N(float f6, float f7, int i6) {
        this.f49943h.q(f6, f7, i6);
    }

    public void O(float f6) {
        this.f49943h.s(f6);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void A(Typeface typeface) {
        this.f49943h.v(typeface);
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void c(float f6, int i6, float f7) {
        this.f49949n = f6;
        this.f49950o = i6;
        this.f49951p = f7;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public float d() {
        return this.f49951p;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void f(int i6) {
        this.f49943h.f49981z = i6;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        b bVar = this.f49944i;
        if (bVar != null) {
            bVar.g(dVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public float getDensity() {
        return this.f49949n;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int getDensityDpi() {
        return this.f49950o;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int getHeight() {
        return this.f49947l;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int getWidth() {
        return this.f49946k;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int h() {
        return this.f49943h.f49981z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int i() {
        return this.f49955t;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.n
    public boolean isHardwareAccelerated() {
        return this.f49953r;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void j(boolean z5) {
        this.f49953r = z5;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int k() {
        return this.f49943h.A;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void l(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        b bVar = this.f49944i;
        if (bVar != null) {
            bVar.f(dVar, z5);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public float m() {
        return this.f49943h.m();
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int n() {
        return this.f49952q;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int o() {
        return this.f49954s;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void q(int i6) {
        this.f49943h.A = i6;
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void r() {
        this.f49944i.b();
        this.f49943h.i();
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void setSize(int i6, int i7) {
        this.f49946k = i6;
        this.f49947l = i7;
        this.f49948m = (float) ((i6 / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b t() {
        return this.f49944i;
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void v(b bVar) {
        if (bVar != this.f49944i) {
            this.f49944i = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void x(boolean z5) {
        this.f49943h.p(z5);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void y(float f6) {
        this.f49943h.r(f6);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void z(int i6) {
        this.f49943h.u(i6);
    }

    @SuppressLint({"NewApi"})
    private static final int E(Canvas canvas) {
        return canvas.getMaximumBitmapHeight();
    }

    @SuppressLint({"NewApi"})
    private static final int F(Canvas canvas) {
        return canvas.getMaximumBitmapWidth();
    }

    private void H(Paint paint) {
        int alpha = paint.getAlpha();
        int i6 = master.flame.danmaku.danmaku.model.c.f50052a;
        if (alpha != i6) {
            paint.setAlpha(i6);
        }
    }

    private void I(Canvas canvas) {
        canvas.restore();
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void w(Canvas canvas) {
        update(canvas);
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void a(float f6) {
        float max = Math.max(f6, getWidth() / 682.0f) * 25.0f;
        this.f49952q = (int) max;
        if (f6 > 1.0f) {
            this.f49952q = (int) (max * f6);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void e(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        TextPaint G = G(dVar, z5);
        if (this.f49943h.f49972q) {
            this.f49943h.g(dVar, G, true);
        }
        B(dVar, G, z5);
        if (this.f49943h.f49972q) {
            this.f49943h.g(dVar, G, false);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int p(master.flame.danmaku.danmaku.model.d dVar) {
        boolean z5;
        a aVar;
        boolean z6;
        float l6 = dVar.l();
        float g6 = dVar.g();
        if (this.f49945j == null) {
            return 0;
        }
        int i6 = 1;
        Paint paint = null;
        if (dVar.getType() == 7) {
            if (dVar.c() == master.flame.danmaku.danmaku.model.c.f50053b) {
                return 0;
            }
            if (dVar.f50061h == 0.0f && dVar.f50062i == 0.0f) {
                z6 = false;
            } else {
                J(dVar, this.f49945j, g6, l6);
                z6 = true;
            }
            if (dVar.c() != master.flame.danmaku.danmaku.model.c.f50052a) {
                paint = this.f49943h.f49960e;
                paint.setAlpha(dVar.c());
            }
            z5 = z6;
        } else {
            z5 = false;
        }
        if (paint != null && paint.getAlpha() == master.flame.danmaku.danmaku.model.c.f50053b) {
            return 0;
        }
        if (!this.f49944i.c(dVar, this.f49945j, g6, l6, paint, this.f49943h.f49958c)) {
            if (paint != null) {
                this.f49943h.f49958c.setAlpha(paint.getAlpha());
                this.f49943h.f49959d.setAlpha(paint.getAlpha());
            } else {
                H(this.f49943h.f49958c);
            }
            aVar = this;
            aVar.s(dVar, this.f49945j, g6, l6, false);
            i6 = 2;
        } else {
            aVar = this;
        }
        if (z5) {
            I(aVar.f49945j);
        }
        return i6;
    }
}
