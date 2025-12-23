package com.bigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bigkoo.pickerview.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WheelView extends View {
    private static final int S = 5;
    private static final float T = 0.8f;
    int A;
    int B;
    private int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    private int K;
    private float L;
    long M;
    int N;
    private int O;
    private int P;
    private int Q;
    private float R;

    /* renamed from: a, reason: collision with root package name */
    private DividerType f14390a;

    /* renamed from: b, reason: collision with root package name */
    Context f14391b;

    /* renamed from: c, reason: collision with root package name */
    Handler f14392c;

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector f14393d;

    /* renamed from: e, reason: collision with root package name */
    p.c f14394e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14395f;

    /* renamed from: g, reason: collision with root package name */
    ScheduledExecutorService f14396g;

    /* renamed from: h, reason: collision with root package name */
    private ScheduledFuture<?> f14397h;

    /* renamed from: i, reason: collision with root package name */
    Paint f14398i;

    /* renamed from: j, reason: collision with root package name */
    Paint f14399j;

    /* renamed from: k, reason: collision with root package name */
    Paint f14400k;

    /* renamed from: l, reason: collision with root package name */
    o.c f14401l;

    /* renamed from: m, reason: collision with root package name */
    private String f14402m;

    /* renamed from: n, reason: collision with root package name */
    int f14403n;

    /* renamed from: o, reason: collision with root package name */
    int f14404o;

    /* renamed from: p, reason: collision with root package name */
    int f14405p;

    /* renamed from: q, reason: collision with root package name */
    float f14406q;

    /* renamed from: r, reason: collision with root package name */
    Typeface f14407r;

    /* renamed from: s, reason: collision with root package name */
    int f14408s;

    /* renamed from: t, reason: collision with root package name */
    int f14409t;

    /* renamed from: u, reason: collision with root package name */
    int f14410u;

    /* renamed from: v, reason: collision with root package name */
    float f14411v;

    /* renamed from: w, reason: collision with root package name */
    boolean f14412w;

    /* renamed from: x, reason: collision with root package name */
    float f14413x;

    /* renamed from: y, reason: collision with root package name */
    float f14414y;

    /* renamed from: z, reason: collision with root package name */
    float f14415z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public int d(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            i6 += (int) Math.ceil(r2[i7]);
        }
        return i6;
    }

    public void setLineSpacingMultiplier(float f6) {
        if (f6 != 0.0f) {
            this.f14411v = f6;
            g();
        }
    }

    public final void setTextSize(float f6) {
        if (f6 > 0.0f) {
            int i6 = (int) (this.f14391b.getResources().getDisplayMetrics().density * f6);
            this.f14403n = i6;
            this.f14398i.setTextSize(i6);
            this.f14399j.setTextSize(this.f14403n);
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14395f = false;
        this.f14396g = Executors.newSingleThreadScheduledExecutor();
        this.f14407r = Typeface.MONOSPACE;
        this.f14408s = -5723992;
        this.f14409t = -14013910;
        this.f14410u = -2763307;
        this.f14411v = 1.6f;
        this.F = 11;
        this.K = 0;
        this.L = 0.0f;
        this.M = 0L;
        this.O = 17;
        this.P = 0;
        this.Q = 0;
        this.f14403n = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f6 = getResources().getDisplayMetrics().density;
        if (f6 < 1.0f) {
            this.R = 2.4f;
        } else if (1.0f <= f6 && f6 < 2.0f) {
            this.R = 3.6f;
        } else if (1.0f <= f6 && f6 < 2.0f) {
            this.R = 4.5f;
        } else if (2.0f <= f6 && f6 < 3.0f) {
            this.R = 6.0f;
        } else if (f6 >= 3.0f) {
            this.R = f6 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.O = obtainStyledAttributes.getInt(R.styleable.pickerview_pickerview_gravity, 17);
            this.f14408s = obtainStyledAttributes.getColor(R.styleable.pickerview_pickerview_textColorOut, this.f14408s);
            this.f14409t = obtainStyledAttributes.getColor(R.styleable.pickerview_pickerview_textColorCenter, this.f14409t);
            this.f14410u = obtainStyledAttributes.getColor(R.styleable.pickerview_pickerview_dividerColor, this.f14410u);
            this.f14403n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_pickerview_textSize, this.f14403n);
            this.f14411v = obtainStyledAttributes.getFloat(R.styleable.pickerview_pickerview_lineSpacingMultiplier, this.f14411v);
            obtainStyledAttributes.recycle();
        }
        g();
        e(context);
    }

    private String b(Object obj) {
        return obj == null ? "" : obj instanceof q.a ? ((q.a) obj).a() : obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, (Integer) obj) : obj.toString();
    }

    private int c(int i6) {
        return i6 < 0 ? c(i6 + this.f14401l.a()) : i6 > this.f14401l.a() + (-1) ? c(i6 - this.f14401l.a()) : i6;
    }

    private void e(Context context) {
        this.f14391b = context;
        this.f14392c = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.f14393d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f14412w = true;
        this.A = 0;
        this.B = -1;
        f();
    }

    private void f() {
        Paint paint = new Paint();
        this.f14398i = paint;
        paint.setColor(this.f14408s);
        this.f14398i.setAntiAlias(true);
        this.f14398i.setTypeface(this.f14407r);
        this.f14398i.setTextSize(this.f14403n);
        Paint paint2 = new Paint();
        this.f14399j = paint2;
        paint2.setColor(this.f14409t);
        this.f14399j.setAntiAlias(true);
        this.f14399j.setTextScaleX(1.1f);
        this.f14399j.setTypeface(this.f14407r);
        this.f14399j.setTextSize(this.f14403n);
        Paint paint3 = new Paint();
        this.f14400k = paint3;
        paint3.setColor(this.f14410u);
        this.f14400k.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void g() {
        float f6 = this.f14411v;
        if (f6 < 1.2f) {
            this.f14411v = 1.2f;
        } else if (f6 > 2.0f) {
            this.f14411v = 2.0f;
        }
    }

    private void h() {
        Rect rect = new Rect();
        for (int i6 = 0; i6 < this.f14401l.a(); i6++) {
            String b6 = b(this.f14401l.getItem(i6));
            this.f14399j.getTextBounds(b6, 0, b6.length(), rect);
            int width = rect.width();
            if (width > this.f14404o) {
                this.f14404o = width;
            }
            this.f14399j.getTextBounds("星期", 0, 2, rect);
            this.f14405p = rect.height() + 2;
        }
        this.f14406q = this.f14411v * this.f14405p;
    }

    private void i(String str) {
        String str2;
        Rect rect = new Rect();
        this.f14399j.getTextBounds(str, 0, str.length(), rect);
        int i6 = this.O;
        if (i6 == 3) {
            this.P = 0;
            return;
        }
        if (i6 == 5) {
            this.P = (this.H - rect.width()) - ((int) this.R);
            return;
        }
        if (i6 != 17) {
            return;
        }
        if (this.f14395f || (str2 = this.f14402m) == null || str2.equals("")) {
            this.P = (int) ((this.H - rect.width()) * 0.5d);
        } else {
            this.P = (int) ((this.H - rect.width()) * 0.25d);
        }
    }

    private void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.f14398i.getTextBounds(str, 0, str.length(), rect);
        int i6 = this.O;
        if (i6 == 3) {
            this.Q = 0;
            return;
        }
        if (i6 == 5) {
            this.Q = (this.H - rect.width()) - ((int) this.R);
            return;
        }
        if (i6 != 17) {
            return;
        }
        if (this.f14395f || (str2 = this.f14402m) == null || str2.equals("")) {
            this.Q = (int) ((this.H - rect.width()) * 0.5d);
        } else {
            this.Q = (int) ((this.H - rect.width()) * 0.25d);
        }
    }

    private void l(String str) {
        Rect rect = new Rect();
        this.f14399j.getTextBounds(str, 0, str.length(), rect);
        int i6 = this.f14403n;
        for (int width = rect.width(); width > this.H; width = rect.width()) {
            i6--;
            this.f14399j.setTextSize(i6);
            this.f14399j.getTextBounds(str, 0, str.length(), rect);
        }
        this.f14398i.setTextSize(i6);
    }

    private void m() {
        if (this.f14401l == null) {
            return;
        }
        h();
        int i6 = (int) (this.f14406q * (this.F - 1));
        this.I = i6;
        this.G = (int) ((i6 * 2) / 3.141592653589793d);
        this.J = (int) (i6 / 3.141592653589793d);
        this.H = View.MeasureSpec.getSize(this.N);
        int i7 = this.G;
        float f6 = this.f14406q;
        this.f14413x = (i7 - f6) / 2.0f;
        float f7 = (i7 + f6) / 2.0f;
        this.f14414y = f7;
        this.f14415z = (f7 - ((f6 - this.f14405p) / 2.0f)) - this.R;
        if (this.B == -1) {
            if (this.f14412w) {
                this.B = (this.f14401l.a() + 1) / 2;
            } else {
                this.B = 0;
            }
        }
        this.D = this.B;
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.f14397h;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f14397h.cancel(true);
        this.f14397h = null;
    }

    public final o.c getAdapter() {
        return this.f14401l;
    }

    public final int getCurrentItem() {
        return this.C;
    }

    public int getItemsCount() {
        o.c cVar = this.f14401l;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    protected final void k() {
        if (this.f14394e != null) {
            postDelayed(new d(this), 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        int i6;
        o.c cVar = this.f14401l;
        if (cVar == null) {
            return;
        }
        Object[] objArr = new Object[this.F];
        int i7 = (int) (this.A / this.f14406q);
        this.E = i7;
        try {
            this.D = this.B + (i7 % cVar.a());
        } catch (ArithmeticException unused) {
        }
        if (this.f14412w) {
            if (this.D < 0) {
                this.D = this.f14401l.a() + this.D;
            }
            if (this.D > this.f14401l.a() - 1) {
                this.D -= this.f14401l.a();
            }
        } else {
            if (this.D < 0) {
                this.D = 0;
            }
            if (this.D > this.f14401l.a() - 1) {
                this.D = this.f14401l.a() - 1;
            }
        }
        int i8 = (int) (this.A % this.f14406q);
        int i9 = 0;
        while (true) {
            int i10 = this.F;
            if (i9 >= i10) {
                break;
            }
            int i11 = this.D - ((i10 / 2) - i9);
            if (this.f14412w) {
                objArr[i9] = this.f14401l.getItem(c(i11));
            } else if (i11 < 0) {
                objArr[i9] = "";
            } else if (i11 > this.f14401l.a() - 1) {
                objArr[i9] = "";
            } else {
                objArr[i9] = this.f14401l.getItem(i11);
            }
            i9++;
        }
        if (this.f14390a == DividerType.WRAP) {
            float f6 = (TextUtils.isEmpty(this.f14402m) ? (this.H - this.f14404o) / 2 : (this.H - this.f14404o) / 4) - 12;
            float f7 = f6 <= 0.0f ? 10.0f : f6;
            float f8 = this.H - f7;
            float f9 = this.f14413x;
            canvas2 = canvas;
            canvas2.drawLine(f7, f9, f8, f9, this.f14400k);
            float f10 = this.f14414y;
            canvas2.drawLine(f7, f10, f8, f10, this.f14400k);
        } else {
            float f11 = this.f14413x;
            canvas.drawLine(0.0f, f11, this.H, f11, this.f14400k);
            float f12 = this.f14414y;
            canvas2 = canvas;
            canvas2.drawLine(0.0f, f12, this.H, f12, this.f14400k);
        }
        if (!TextUtils.isEmpty(this.f14402m)) {
            canvas2.drawText(this.f14402m, (this.H - d(this.f14399j, this.f14402m)) - this.R, this.f14415z, this.f14399j);
        }
        int i12 = 0;
        while (i12 < this.F) {
            canvas2.save();
            double d6 = ((this.f14406q * i12) - i8) / this.J;
            float f13 = (float) (90.0d - ((d6 / 3.141592653589793d) * 180.0d));
            if (f13 >= 90.0f || f13 <= -90.0f) {
                i6 = i8;
                canvas2.restore();
            } else {
                String b6 = b(objArr[i12]);
                l(b6);
                i(b6);
                j(b6);
                i6 = i8;
                float cos = (float) ((this.J - (Math.cos(d6) * this.J)) - ((Math.sin(d6) * this.f14405p) / 2.0d));
                canvas2.translate(0.0f, cos);
                canvas2.scale(1.0f, (float) Math.sin(d6));
                float f14 = this.f14413x;
                if (cos > f14 || this.f14405p + cos < f14) {
                    float f15 = this.f14414y;
                    if (cos > f15 || this.f14405p + cos < f15) {
                        if (cos >= f14) {
                            int i13 = this.f14405p;
                            if (i13 + cos <= f15) {
                                canvas2.drawText(b6, this.P, i13 - this.R, this.f14399j);
                                this.C = this.f14401l.indexOf(objArr[i12]);
                            }
                        }
                        canvas2.save();
                        canvas2.clipRect(0, 0, this.H, (int) this.f14406q);
                        canvas2.scale(1.0f, ((float) Math.sin(d6)) * T);
                        canvas2.drawText(b6, this.Q, this.f14405p, this.f14398i);
                        canvas2.restore();
                        canvas2.restore();
                        this.f14399j.setTextSize(this.f14403n);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(0.0f, 0.0f, this.H, this.f14414y - cos);
                        canvas2.scale(1.0f, ((float) Math.sin(d6)) * 1.0f);
                        canvas2.drawText(b6, this.P, this.f14405p - this.R, this.f14399j);
                        canvas2.restore();
                        canvas2.save();
                        canvas2.clipRect(0.0f, this.f14414y - cos, this.H, (int) this.f14406q);
                        canvas2.scale(1.0f, ((float) Math.sin(d6)) * T);
                        canvas2.drawText(b6, this.Q, this.f14405p, this.f14398i);
                        canvas2.restore();
                    }
                } else {
                    canvas2.save();
                    canvas2.clipRect(0.0f, 0.0f, this.H, this.f14413x - cos);
                    canvas2.scale(1.0f, ((float) Math.sin(d6)) * T);
                    canvas2.drawText(b6, this.Q, this.f14405p, this.f14398i);
                    canvas2.restore();
                    canvas2.save();
                    canvas2.clipRect(0.0f, this.f14413x - cos, this.H, (int) this.f14406q);
                    canvas2.scale(1.0f, ((float) Math.sin(d6)) * 1.0f);
                    canvas2.drawText(b6, this.P, this.f14405p - this.R, this.f14399j);
                    canvas2.restore();
                }
                canvas2.restore();
                this.f14399j.setTextSize(this.f14403n);
            }
            i12++;
            i8 = i6;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        this.N = i6;
        m();
        setMeasuredDimension(this.H, this.G);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f14393d.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.M = System.currentTimeMillis();
            a();
            this.L = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.L - motionEvent.getRawY();
            this.L = motionEvent.getRawY();
            this.A = (int) (this.A + rawY);
            if (!this.f14412w) {
                float f6 = (-this.B) * this.f14406q;
                float a6 = (this.f14401l.a() - 1) - this.B;
                float f7 = this.f14406q;
                float f8 = a6 * f7;
                int i6 = this.A;
                if (i6 - (f7 * 0.3d) < f6) {
                    f6 = i6 - rawY;
                } else if (i6 + (f7 * 0.3d) > f8) {
                    f8 = i6 - rawY;
                }
                if (i6 < f6) {
                    this.A = (int) f6;
                } else if (i6 > f8) {
                    this.A = (int) f8;
                }
            }
        } else if (!onTouchEvent) {
            float y5 = motionEvent.getY();
            int i7 = this.J;
            double acos = Math.acos((i7 - y5) / i7) * this.J;
            float f9 = this.f14406q;
            this.K = (int) (((((int) ((acos + (f9 / 2.0f)) / f9)) - (this.F / 2)) * f9) - (((this.A % f9) + f9) % f9));
            if (System.currentTimeMillis() - this.M > 120) {
                o(ACTION.DAGGLE);
            } else {
                o(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void setAdapter(o.c cVar) {
        this.f14401l = cVar;
        m();
        invalidate();
    }

    public final void setCurrentItem(int i6) {
        this.B = i6;
        this.A = 0;
        invalidate();
    }

    public final void setCyclic(boolean z5) {
        this.f14412w = z5;
    }

    public void setDividerColor(int i6) {
        if (i6 != 0) {
            this.f14410u = i6;
            this.f14400k.setColor(i6);
        }
    }

    public void setDividerType(DividerType dividerType) {
        this.f14390a = dividerType;
    }

    public void setGravity(int i6) {
        this.O = i6;
    }

    public void setIsOptions(boolean z5) {
        this.f14395f = z5;
    }

    public void setLabel(String str) {
        this.f14402m = str;
    }

    public final void setOnItemSelectedListener(p.c cVar) {
        this.f14394e = cVar;
    }

    public void setTextColorCenter(int i6) {
        if (i6 != 0) {
            this.f14409t = i6;
            this.f14399j.setColor(i6);
        }
    }

    public void setTextColorOut(int i6) {
        if (i6 != 0) {
            this.f14408s = i6;
            this.f14398i.setColor(i6);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.f14407r = typeface;
        this.f14398i.setTypeface(typeface);
        this.f14399j.setTypeface(this.f14407r);
    }

    protected final void n(float f6) {
        a();
        this.f14397h = this.f14396g.scheduleWithFixedDelay(new a(this, f6), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    void o(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f6 = this.A;
            float f7 = this.f14406q;
            int i6 = (int) (((f6 % f7) + f7) % f7);
            this.K = i6;
            if (i6 > f7 / 2.0f) {
                this.K = (int) (f7 - i6);
            } else {
                this.K = -i6;
            }
        }
        this.f14397h = this.f14396g.scheduleWithFixedDelay(new e(this, this.K), 0L, 10L, TimeUnit.MILLISECONDS);
    }
}
