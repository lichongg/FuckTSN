package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class MountanScenceView extends View {
    private static final int A = 240;
    private static final int B = 180;
    private static final int C = 100;
    private static final int D = 200;

    /* renamed from: a, reason: collision with root package name */
    private int f37066a;

    /* renamed from: b, reason: collision with root package name */
    private int f37067b;

    /* renamed from: c, reason: collision with root package name */
    private int f37068c;

    /* renamed from: d, reason: collision with root package name */
    private int f37069d;

    /* renamed from: e, reason: collision with root package name */
    private int f37070e;

    /* renamed from: f, reason: collision with root package name */
    private int f37071f;

    /* renamed from: g, reason: collision with root package name */
    private int f37072g;

    /* renamed from: h, reason: collision with root package name */
    private int f37073h;

    /* renamed from: i, reason: collision with root package name */
    private int f37074i;

    /* renamed from: j, reason: collision with root package name */
    private int f37075j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f37076k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f37077l;

    /* renamed from: m, reason: collision with root package name */
    private Paint f37078m;

    /* renamed from: n, reason: collision with root package name */
    private Paint f37079n;

    /* renamed from: o, reason: collision with root package name */
    private Path f37080o;

    /* renamed from: p, reason: collision with root package name */
    private Path f37081p;

    /* renamed from: q, reason: collision with root package name */
    private Path f37082q;

    /* renamed from: r, reason: collision with root package name */
    private Path f37083r;

    /* renamed from: s, reason: collision with root package name */
    private Path f37084s;

    /* renamed from: t, reason: collision with root package name */
    private Matrix f37085t;

    /* renamed from: u, reason: collision with root package name */
    private float f37086u;

    /* renamed from: v, reason: collision with root package name */
    private float f37087v;

    /* renamed from: w, reason: collision with root package name */
    private float f37088w;

    /* renamed from: x, reason: collision with root package name */
    private float f37089x;

    /* renamed from: y, reason: collision with root package name */
    private float f37090y;

    /* renamed from: z, reason: collision with root package name */
    private int f37091z;

    public MountanScenceView(Context context) {
        super(context);
        this.f37066a = Color.parseColor("#7ECEC9");
        this.f37067b = Color.parseColor("#86DAD7");
        this.f37068c = Color.parseColor("#3C929C");
        this.f37069d = Color.parseColor("#3E5F73");
        this.f37070e = Color.parseColor("#1F7177");
        this.f37071f = Color.parseColor("#0C3E48");
        this.f37072g = Color.parseColor("#34888F");
        this.f37073h = Color.parseColor("#1B6169");
        this.f37074i = Color.parseColor("#57B1AE");
        this.f37075j = Color.parseColor("#62A4AD");
        this.f37076k = new Paint();
        this.f37077l = new Paint();
        this.f37078m = new Paint();
        this.f37079n = new Paint();
        this.f37080o = new Path();
        this.f37081p = new Path();
        this.f37082q = new Path();
        this.f37083r = new Path();
        this.f37084s = new Path();
        this.f37085t = new Matrix();
        this.f37086u = 5.0f;
        this.f37087v = 5.0f;
        this.f37088w = 0.0f;
        this.f37089x = 1.0f;
        this.f37090y = Float.MAX_VALUE;
        this.f37091z = 0;
        b(context, null, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i6) {
        this.f37076k.setAntiAlias(true);
        this.f37076k.setStyle(Paint.Style.FILL);
        this.f37077l.setAntiAlias(true);
        this.f37078m.setAntiAlias(true);
        this.f37079n.setAntiAlias(true);
        this.f37079n.setStyle(Paint.Style.STROKE);
        this.f37079n.setStrokeWidth(2.0f);
        this.f37079n.setStrokeJoin(Paint.Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MountanScenceView);
        int i7 = R.styleable.MountanScenceView_msvPrimaryColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            setPrimaryColor(obtainStyledAttributes.getColor(i7, ViewCompat.MEASURED_STATE_MASK));
        }
        this.f37091z = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MountanScenceView_msvViewportHeight, 0);
        obtainStyledAttributes.recycle();
        c(this.f37088w, 180);
        e(this.f37088w, true);
    }

    private void c(float f6, int i6) {
        this.f37085t.reset();
        this.f37085t.setScale(this.f37086u, this.f37087v);
        int i7 = (int) (10.0f * f6);
        this.f37080o.reset();
        this.f37080o.moveTo(0.0f, i7 + 95);
        this.f37080o.lineTo(55.0f, i7 + 74);
        this.f37080o.lineTo(146.0f, i7 + 104);
        this.f37080o.lineTo(227.0f, i7 + 72);
        this.f37080o.lineTo(240.0f, i7 + 80);
        this.f37080o.lineTo(240.0f, 180.0f);
        this.f37080o.lineTo(0.0f, 180.0f);
        this.f37080o.close();
        this.f37080o.transform(this.f37085t);
        int i8 = (int) (20.0f * f6);
        this.f37081p.reset();
        this.f37081p.moveTo(0.0f, i8 + 103);
        this.f37081p.lineTo(67.0f, i8 + 90);
        this.f37081p.lineTo(165.0f, i8 + 115);
        this.f37081p.lineTo(221.0f, i8 + 87);
        this.f37081p.lineTo(240.0f, i8 + 100);
        this.f37081p.lineTo(240.0f, 180.0f);
        this.f37081p.lineTo(0.0f, 180.0f);
        this.f37081p.close();
        this.f37081p.transform(this.f37085t);
        int i9 = (int) (f6 * 30.0f);
        this.f37082q.reset();
        this.f37082q.moveTo(0.0f, i9 + 114);
        this.f37082q.cubicTo(30.0f, i9 + 106, 196.0f, i9 + 97, 240.0f, i9 + 104);
        float f7 = i6;
        this.f37082q.lineTo(240.0f, f7 / this.f37087v);
        this.f37082q.lineTo(0.0f, f7 / this.f37087v);
        this.f37082q.close();
        this.f37082q.transform(this.f37085t);
    }

    private void e(float f6, boolean z5) {
        int i6;
        if (f6 != this.f37090y || z5) {
            Interpolator a6 = a.a(0.8f, (-0.5f) * f6);
            float f7 = f6 * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i7 = 0;
            float f8 = 0.0f;
            float f9 = 200.0f;
            while (true) {
                if (i7 > 25) {
                    break;
                }
                fArr[i7] = (a6.getInterpolation(f8) * f7) + 50.0f;
                fArr2[i7] = f9;
                f9 -= 8.0f;
                f8 += 0.04f;
                i7++;
            }
            this.f37083r.reset();
            this.f37083r.moveTo(45.0f, 200.0f);
            int i8 = (int) (17 * 0.5f);
            float f10 = 17 - i8;
            for (int i9 = 0; i9 < 17; i9++) {
                if (i9 < i8) {
                    this.f37083r.lineTo(fArr[i9] - 5.0f, fArr2[i9]);
                } else {
                    this.f37083r.lineTo(fArr[i9] - (((17 - i9) * 5.0f) / f10), fArr2[i9]);
                }
            }
            for (int i10 = 16; i10 >= 0; i10--) {
                if (i10 < i8) {
                    this.f37083r.lineTo(fArr[i10] + 5.0f, fArr2[i10]);
                } else {
                    this.f37083r.lineTo(fArr[i10] + (((17 - i10) * 5.0f) / f10), fArr2[i10]);
                }
            }
            this.f37083r.close();
            this.f37084s.reset();
            float f11 = 15;
            this.f37084s.moveTo(fArr[10] - 20.0f, fArr2[10]);
            Path path = this.f37084s;
            float f12 = fArr[10];
            float f13 = fArr2[10];
            path.addArc(new RectF(f12 - 20.0f, f13 - 20.0f, f12 + 20.0f, f13 + 20.0f), 0.0f, 180.0f);
            for (int i11 = 10; i11 <= 25; i11++) {
                float f14 = (i11 - 10) / f11;
                this.f37084s.lineTo((fArr[i11] - 20.0f) + (f14 * f14 * 20.0f), fArr2[i11]);
            }
            for (i6 = 25; i6 >= 10; i6--) {
                float f15 = (i6 - 10) / f11;
                this.f37084s.lineTo((fArr[i6] + 20.0f) - ((f15 * f15) * 20.0f), fArr2[i6]);
            }
        }
    }

    public void d(float f6) {
        this.f37089x = f6;
        float max = Math.max(0.0f, f6);
        this.f37088w = Math.max(0.0f, this.f37089x);
        int measuredHeight = getMeasuredHeight();
        float f7 = this.f37088w;
        if (measuredHeight <= 0) {
            measuredHeight = 180;
        }
        c(f7, measuredHeight);
        e(max, false);
    }

    public void setPrimaryColor(@ColorInt int i6) {
        this.f37066a = i6;
        this.f37067b = com.scwang.smartrefresh.layout.util.a.t(-1711276033, i6);
        this.f37068c = com.scwang.smartrefresh.layout.util.a.t(-1724083556, i6);
        this.f37069d = com.scwang.smartrefresh.layout.util.a.t(-868327565, i6);
        this.f37070e = com.scwang.smartrefresh.layout.util.a.t(1428124023, i6);
        this.f37071f = com.scwang.smartrefresh.layout.util.a.t(-871612856, i6);
        this.f37072g = com.scwang.smartrefresh.layout.util.a.t(1429506191, i6);
        this.f37073h = com.scwang.smartrefresh.layout.util.a.t(-870620823, i6);
        this.f37074i = com.scwang.smartrefresh.layout.util.a.t(1431810478, i6);
        this.f37075j = com.scwang.smartrefresh.layout.util.a.t(-865950547, i6);
    }

    private void a(Canvas canvas, float f6, float f7, float f8, int i6, int i7) {
        canvas.save();
        canvas.translate(f7 - ((100.0f * f6) / 2.0f), f8 - (200.0f * f6));
        canvas.scale(f6, f6);
        this.f37078m.setColor(i7);
        canvas.drawPath(this.f37084s, this.f37078m);
        this.f37077l.setColor(i6);
        canvas.drawPath(this.f37083r, this.f37077l);
        this.f37079n.setColor(i6);
        canvas.drawPath(this.f37084s, this.f37079n);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f37066a);
        this.f37076k.setColor(this.f37067b);
        canvas.drawPath(this.f37080o, this.f37076k);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, getWidth() / 2, 0.0f);
        float f6 = this.f37086u;
        a(canvas, 0.12f * f6, f6 * 180.0f, ((this.f37088w * 20.0f) + 93.0f) * this.f37087v, this.f37075j, this.f37074i);
        float f7 = this.f37086u;
        a(canvas, 0.1f * f7, 200.0f * f7, this.f37087v * ((this.f37088w * 20.0f) + 96.0f), this.f37075j, this.f37074i);
        canvas.restore();
        this.f37076k.setColor(this.f37068c);
        canvas.drawPath(this.f37081p, this.f37076k);
        float f8 = this.f37086u;
        a(canvas, 0.2f * f8, f8 * 160.0f, ((this.f37088w * 30.0f) + 105.0f) * this.f37087v, this.f37071f, this.f37070e);
        float f9 = this.f37086u;
        a(canvas, 0.14f * f9, f9 * 180.0f, this.f37087v * ((this.f37088w * 30.0f) + 105.0f), this.f37073h, this.f37072g);
        float f10 = this.f37086u;
        a(canvas, 0.16f * f10, 140.0f * f10, this.f37087v * ((this.f37088w * 30.0f) + 105.0f), this.f37073h, this.f37072g);
        this.f37076k.setColor(this.f37069d);
        canvas.drawPath(this.f37082q, this.f37076k);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f37086u = (measuredWidth * 1.0f) / 240.0f;
        int i8 = this.f37091z;
        if (i8 <= 0) {
            i8 = measuredHeight;
        }
        this.f37087v = (i8 * 1.0f) / 180.0f;
        c(this.f37088w, measuredHeight);
        e(this.f37088w, true);
    }

    public MountanScenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37066a = Color.parseColor("#7ECEC9");
        this.f37067b = Color.parseColor("#86DAD7");
        this.f37068c = Color.parseColor("#3C929C");
        this.f37069d = Color.parseColor("#3E5F73");
        this.f37070e = Color.parseColor("#1F7177");
        this.f37071f = Color.parseColor("#0C3E48");
        this.f37072g = Color.parseColor("#34888F");
        this.f37073h = Color.parseColor("#1B6169");
        this.f37074i = Color.parseColor("#57B1AE");
        this.f37075j = Color.parseColor("#62A4AD");
        this.f37076k = new Paint();
        this.f37077l = new Paint();
        this.f37078m = new Paint();
        this.f37079n = new Paint();
        this.f37080o = new Path();
        this.f37081p = new Path();
        this.f37082q = new Path();
        this.f37083r = new Path();
        this.f37084s = new Path();
        this.f37085t = new Matrix();
        this.f37086u = 5.0f;
        this.f37087v = 5.0f;
        this.f37088w = 0.0f;
        this.f37089x = 1.0f;
        this.f37090y = Float.MAX_VALUE;
        this.f37091z = 0;
        b(context, attributeSet, 0);
    }

    public MountanScenceView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37066a = Color.parseColor("#7ECEC9");
        this.f37067b = Color.parseColor("#86DAD7");
        this.f37068c = Color.parseColor("#3C929C");
        this.f37069d = Color.parseColor("#3E5F73");
        this.f37070e = Color.parseColor("#1F7177");
        this.f37071f = Color.parseColor("#0C3E48");
        this.f37072g = Color.parseColor("#34888F");
        this.f37073h = Color.parseColor("#1B6169");
        this.f37074i = Color.parseColor("#57B1AE");
        this.f37075j = Color.parseColor("#62A4AD");
        this.f37076k = new Paint();
        this.f37077l = new Paint();
        this.f37078m = new Paint();
        this.f37079n = new Paint();
        this.f37080o = new Path();
        this.f37081p = new Path();
        this.f37082q = new Path();
        this.f37083r = new Path();
        this.f37084s = new Path();
        this.f37085t = new Matrix();
        this.f37086u = 5.0f;
        this.f37087v = 5.0f;
        this.f37088w = 0.0f;
        this.f37089x = 1.0f;
        this.f37090y = Float.MAX_VALUE;
        this.f37091z = 0;
        b(context, attributeSet, i6);
    }

    @RequiresApi(21)
    public MountanScenceView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f37066a = Color.parseColor("#7ECEC9");
        this.f37067b = Color.parseColor("#86DAD7");
        this.f37068c = Color.parseColor("#3C929C");
        this.f37069d = Color.parseColor("#3E5F73");
        this.f37070e = Color.parseColor("#1F7177");
        this.f37071f = Color.parseColor("#0C3E48");
        this.f37072g = Color.parseColor("#34888F");
        this.f37073h = Color.parseColor("#1B6169");
        this.f37074i = Color.parseColor("#57B1AE");
        this.f37075j = Color.parseColor("#62A4AD");
        this.f37076k = new Paint();
        this.f37077l = new Paint();
        this.f37078m = new Paint();
        this.f37079n = new Paint();
        this.f37080o = new Path();
        this.f37081p = new Path();
        this.f37082q = new Path();
        this.f37083r = new Path();
        this.f37084s = new Path();
        this.f37085t = new Matrix();
        this.f37086u = 5.0f;
        this.f37087v = 5.0f;
        this.f37088w = 0.0f;
        this.f37089x = 1.0f;
        this.f37090y = Float.MAX_VALUE;
        this.f37091z = 0;
        b(context, attributeSet, i6);
    }
}
