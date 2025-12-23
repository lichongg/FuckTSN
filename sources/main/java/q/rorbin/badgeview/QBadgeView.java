package q.rorbin.badgeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import q.rorbin.badgeview.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QBadgeView extends View implements q.rorbin.badgeview.a {
    protected PointF A;
    protected PointF B;
    protected PointF C;
    protected PointF D;
    protected List<PointF> E;
    protected View F;
    protected int G;
    protected int H;
    protected TextPaint I;
    protected Paint J;
    protected Paint K;
    protected b L;
    protected a.InterfaceC1003a M;
    protected ViewGroup N;

    /* renamed from: a, reason: collision with root package name */
    protected int f51914a;

    /* renamed from: b, reason: collision with root package name */
    protected int f51915b;

    /* renamed from: c, reason: collision with root package name */
    protected int f51916c;

    /* renamed from: d, reason: collision with root package name */
    protected Drawable f51917d;

    /* renamed from: e, reason: collision with root package name */
    protected Bitmap f51918e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f51919f;

    /* renamed from: g, reason: collision with root package name */
    protected float f51920g;

    /* renamed from: h, reason: collision with root package name */
    protected float f51921h;

    /* renamed from: i, reason: collision with root package name */
    protected float f51922i;

    /* renamed from: j, reason: collision with root package name */
    protected int f51923j;

    /* renamed from: k, reason: collision with root package name */
    protected String f51924k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f51925l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f51926m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f51927n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f51928o;

    /* renamed from: p, reason: collision with root package name */
    protected int f51929p;

    /* renamed from: q, reason: collision with root package name */
    protected float f51930q;

    /* renamed from: r, reason: collision with root package name */
    protected float f51931r;

    /* renamed from: s, reason: collision with root package name */
    protected float f51932s;

    /* renamed from: t, reason: collision with root package name */
    protected float f51933t;

    /* renamed from: u, reason: collision with root package name */
    protected int f51934u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f51935v;

    /* renamed from: w, reason: collision with root package name */
    protected RectF f51936w;

    /* renamed from: x, reason: collision with root package name */
    protected RectF f51937x;

    /* renamed from: y, reason: collision with root package name */
    protected Path f51938y;

    /* renamed from: z, reason: collision with root package name */
    protected Paint.FontMetrics f51939z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends ViewGroup {
        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i6, int i7) {
            View view = null;
            View view2 = null;
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt = getChildAt(i8);
                if (childAt instanceof QBadgeView) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i6, i7);
                return;
            }
            view.measure(i6, i7);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            if (!(getParent() instanceof RelativeLayout)) {
                super.dispatchRestoreInstanceState(sparseArray);
            }
        }
    }

    public QBadgeView(Context context) {
        this(context, null);
    }

    private void H() {
        setLayerType(1, null);
        this.f51936w = new RectF();
        this.f51937x = new RectF();
        this.f51938y = new Path();
        this.A = new PointF();
        this.B = new PointF();
        this.C = new PointF();
        this.D = new PointF();
        this.E = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.I = textPaint;
        textPaint.setAntiAlias(true);
        this.I.setSubpixelText(true);
        this.I.setFakeBoldText(true);
        this.I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.J = paint;
        paint.setAntiAlias(true);
        this.J.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.K = paint2;
        paint2.setAntiAlias(true);
        this.K.setStyle(Paint.Style.STROKE);
        this.f51914a = -1552832;
        this.f51916c = -1;
        this.f51921h = d.a(getContext(), 11.0f);
        this.f51922i = d.a(getContext(), 5.0f);
        this.f51923j = 0;
        this.f51929p = 8388661;
        this.f51930q = d.a(getContext(), 1.0f);
        this.f51931r = d.a(getContext(), 1.0f);
        this.f51933t = d.a(getContext(), 90.0f);
        this.f51928o = true;
        this.f51919f = false;
        setTranslationZ(1000.0f);
    }

    private void J() {
        getLocationOnScreen(new int[2]);
        PointF pointF = this.C;
        PointF pointF2 = this.A;
        pointF.x = pointF2.x + r0[0];
        pointF.y = pointF2.y + r0[1];
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a w(Drawable drawable) {
        return m(drawable, false);
    }

    private QBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        if (this.f51924k != null && this.f51919f) {
            Bitmap bitmap = this.f51918e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f51918e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (!this.f51924k.isEmpty() && this.f51924k.length() != 1) {
                this.f51918e = Bitmap.createBitmap((int) (this.f51936w.width() + (this.f51922i * 2.0f)), (int) (this.f51936w.height() + this.f51922i), Bitmap.Config.ARGB_4444);
                new Canvas(this.f51918e).drawRoundRect(0.0f, 0.0f, r3.getWidth(), r3.getHeight(), r3.getHeight() / 2.0f, r3.getHeight() / 2.0f, this.J);
            } else {
                int i6 = ((int) badgeCircleRadius) * 2;
                this.f51918e = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_4444);
                new Canvas(this.f51918e).drawCircle(r0.getWidth() / 2.0f, r0.getHeight() / 2.0f, r0.getWidth() / 2.0f, this.J);
            }
        }
    }

    private void B(Canvas canvas, PointF pointF, float f6) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.f51924k.isEmpty() || this.f51924k.length() == 1) {
            RectF rectF = this.f51937x;
            float f7 = pointF.x;
            float f8 = (int) f6;
            rectF.left = f7 - f8;
            float f9 = pointF.y;
            rectF.top = f9 - f8;
            rectF.right = f7 + f8;
            rectF.bottom = f8 + f9;
            if (this.f51917d != null) {
                C(canvas);
            } else {
                canvas.drawCircle(f7, f9, f6, this.J);
                if (this.f51915b != 0 && this.f51920g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f6, this.K);
                }
            }
        } else {
            this.f51937x.left = pointF.x - ((this.f51936w.width() / 2.0f) + this.f51922i);
            this.f51937x.top = pointF.y - ((this.f51936w.height() / 2.0f) + (this.f51922i * 0.5f));
            this.f51937x.right = pointF.x + (this.f51936w.width() / 2.0f) + this.f51922i;
            this.f51937x.bottom = pointF.y + (this.f51936w.height() / 2.0f) + (this.f51922i * 0.5f);
            float height = this.f51937x.height() / 2.0f;
            if (this.f51917d != null) {
                C(canvas);
            } else {
                canvas.drawRoundRect(this.f51937x, height, height, this.J);
                if (this.f51915b != 0 && this.f51920g > 0.0f) {
                    canvas.drawRoundRect(this.f51937x, height, height, this.K);
                }
            }
        }
        if (this.f51924k.isEmpty()) {
            return;
        }
        String str = this.f51924k;
        float f10 = pointF.x;
        RectF rectF2 = this.f51937x;
        float f11 = rectF2.bottom + rectF2.top;
        Paint.FontMetrics fontMetrics = this.f51939z;
        canvas.drawText(str, f10, ((f11 - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.I);
    }

    private void C(Canvas canvas) {
        Canvas canvas2;
        this.J.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        RectF rectF = this.f51937x;
        int i6 = (int) rectF.left;
        int i7 = (int) rectF.top;
        int i8 = (int) rectF.right;
        int i9 = (int) rectF.bottom;
        if (this.f51919f) {
            i8 = i6 + this.f51918e.getWidth();
            i9 = this.f51918e.getHeight() + i7;
            canvas2 = canvas;
            canvas2.saveLayer(i6, i7, i8, i9, null, 31);
        } else {
            canvas2 = canvas;
        }
        this.f51917d.setBounds(i6, i7, i8, i9);
        this.f51917d.draw(canvas2);
        if (!this.f51919f) {
            canvas2.drawRect(this.f51937x, this.K);
            return;
        }
        this.J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas2.drawBitmap(this.f51918e, i6, i7, this.J);
        canvas2.restore();
        this.J.setXfermode(null);
        if (this.f51924k.isEmpty() || this.f51924k.length() == 1) {
            canvas2.drawCircle(this.f51937x.centerX(), this.f51937x.centerY(), this.f51937x.width() / 2.0f, this.K);
        } else {
            RectF rectF2 = this.f51937x;
            canvas2.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.f51937x.height() / 2.0f, this.K);
        }
    }

    private void D(Canvas canvas, float f6, float f7) {
        float f8;
        float f9;
        float f10;
        Double valueOf = Double.valueOf(0.0d);
        PointF pointF = this.B;
        float f11 = pointF.y;
        PointF pointF2 = this.C;
        float f12 = f11 - pointF2.y;
        float f13 = pointF.x - pointF2.x;
        this.E.clear();
        if (f13 != 0.0f) {
            double d6 = (-1.0d) / (f12 / f13);
            e.a(this.B, f7, Double.valueOf(d6), this.E);
            e.a(this.C, f6, Double.valueOf(d6), this.E);
        } else {
            e.a(this.B, f7, valueOf, this.E);
            e.a(this.C, f6, valueOf, this.E);
        }
        this.f51938y.reset();
        Path path = this.f51938y;
        PointF pointF3 = this.C;
        float f14 = pointF3.x;
        float f15 = pointF3.y;
        int i6 = this.f51934u;
        path.addCircle(f14, f15, f6, (i6 == 1 || i6 == 2) ? Path.Direction.CCW : Path.Direction.CW);
        PointF pointF4 = this.D;
        PointF pointF5 = this.C;
        float f16 = pointF5.x;
        PointF pointF6 = this.B;
        pointF4.x = (f16 + pointF6.x) / 2.0f;
        pointF4.y = (pointF5.y + pointF6.y) / 2.0f;
        this.f51938y.moveTo(this.E.get(2).x, this.E.get(2).y);
        Path path2 = this.f51938y;
        PointF pointF7 = this.D;
        path2.quadTo(pointF7.x, pointF7.y, this.E.get(0).x, this.E.get(0).y);
        this.f51938y.lineTo(this.E.get(1).x, this.E.get(1).y);
        Path path3 = this.f51938y;
        PointF pointF8 = this.D;
        path3.quadTo(pointF8.x, pointF8.y, this.E.get(3).x, this.E.get(3).y);
        this.f51938y.lineTo(this.E.get(2).x, this.E.get(2).y);
        this.f51938y.close();
        canvas.drawPath(this.f51938y, this.J);
        if (this.f51915b == 0 || this.f51920g <= 0.0f) {
            return;
        }
        this.f51938y.reset();
        this.f51938y.moveTo(this.E.get(2).x, this.E.get(2).y);
        Path path4 = this.f51938y;
        PointF pointF9 = this.D;
        path4.quadTo(pointF9.x, pointF9.y, this.E.get(0).x, this.E.get(0).y);
        this.f51938y.moveTo(this.E.get(1).x, this.E.get(1).y);
        Path path5 = this.f51938y;
        PointF pointF10 = this.D;
        path5.quadTo(pointF10.x, pointF10.y, this.E.get(3).x, this.E.get(3).y);
        int i7 = this.f51934u;
        if (i7 == 1 || i7 == 2) {
            float f17 = this.E.get(2).x;
            PointF pointF11 = this.C;
            f8 = f17 - pointF11.x;
            f9 = pointF11.y;
            f10 = this.E.get(2).y;
        } else {
            float f18 = this.E.get(3).x;
            PointF pointF12 = this.C;
            f8 = f18 - pointF12.x;
            f9 = pointF12.y;
            f10 = this.E.get(3).y;
        }
        double atan = Math.atan((f9 - f10) / f8);
        int i8 = this.f51934u;
        float e6 = 360.0f - ((float) e.e(e.d(atan, i8 + (-1) == 0 ? 4 : i8 - 1)));
        Path path6 = this.f51938y;
        PointF pointF13 = this.C;
        float f19 = pointF13.x;
        float f20 = pointF13.y;
        path6.addArc(f19 - f6, f20 - f6, f19 + f6, f20 + f6, e6, 180.0f);
        canvas.drawPath(this.f51938y, this.K);
    }

    private void F() {
        float height = this.f51936w.height() > this.f51936w.width() ? this.f51936w.height() : this.f51936w.width();
        switch (this.f51929p) {
            case 17:
                PointF pointF = this.A;
                pointF.x = this.G / 2.0f;
                pointF.y = this.H / 2.0f;
                break;
            case 49:
                PointF pointF2 = this.A;
                pointF2.x = this.G / 2.0f;
                pointF2.y = this.f51931r + this.f51922i + (this.f51936w.height() / 2.0f);
                break;
            case 81:
                PointF pointF3 = this.A;
                pointF3.x = this.G / 2.0f;
                pointF3.y = this.H - ((this.f51931r + this.f51922i) + (this.f51936w.height() / 2.0f));
                break;
            case 8388627:
                PointF pointF4 = this.A;
                pointF4.x = this.f51930q + this.f51922i + (height / 2.0f);
                pointF4.y = this.H / 2.0f;
                break;
            case 8388629:
                PointF pointF5 = this.A;
                pointF5.x = this.G - ((this.f51930q + this.f51922i) + (height / 2.0f));
                pointF5.y = this.H / 2.0f;
                break;
            case 8388659:
                PointF pointF6 = this.A;
                float f6 = this.f51930q;
                float f7 = this.f51922i;
                pointF6.x = f6 + f7 + (height / 2.0f);
                pointF6.y = this.f51931r + f7 + (this.f51936w.height() / 2.0f);
                break;
            case 8388661:
                PointF pointF7 = this.A;
                float f8 = this.G;
                float f9 = this.f51930q;
                float f10 = this.f51922i;
                pointF7.x = f8 - ((f9 + f10) + (height / 2.0f));
                pointF7.y = this.f51931r + f10 + (this.f51936w.height() / 2.0f);
                break;
            case 8388691:
                PointF pointF8 = this.A;
                float f11 = this.f51930q;
                float f12 = this.f51922i;
                pointF8.x = f11 + f12 + (height / 2.0f);
                pointF8.y = this.H - ((this.f51931r + f12) + (this.f51936w.height() / 2.0f));
                break;
            case 8388693:
                PointF pointF9 = this.A;
                float f13 = this.G;
                float f14 = this.f51930q;
                float f15 = this.f51922i;
                pointF9.x = f13 - ((f14 + f15) + (height / 2.0f));
                pointF9.y = this.H - ((this.f51931r + f15) + (this.f51936w.height() / 2.0f));
                break;
        }
        J();
    }

    private void I() {
        O(this.f51928o);
        this.J.setColor(this.f51914a);
        this.K.setColor(this.f51915b);
        this.K.setStrokeWidth(this.f51920g);
        this.I.setColor(this.f51916c);
        this.I.setTextAlign(Paint.Align.CENTER);
    }

    private void K() {
        RectF rectF = this.f51936w;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.f51924k)) {
            RectF rectF2 = this.f51936w;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
        } else {
            this.I.setTextSize(this.f51921h);
            this.f51936w.right = this.I.measureText(this.f51924k);
            Paint.FontMetrics fontMetrics = this.I.getFontMetrics();
            this.f51939z = fontMetrics;
            this.f51936w.bottom = fontMetrics.descent - fontMetrics.ascent;
        }
        A();
    }

    private void L() {
        if (this.f51935v) {
            y(this.B);
            P(5);
        } else {
            M();
            P(4);
        }
    }

    private void P(int i6) {
        a.InterfaceC1003a interfaceC1003a = this.M;
        if (interfaceC1003a != null) {
            interfaceC1003a.a(i6, this, this.F);
        }
    }

    private float getBadgeCircleRadius() {
        return this.f51924k.isEmpty() ? this.f51922i : this.f51924k.length() == 1 ? this.f51936w.height() > this.f51936w.width() ? (this.f51936w.height() / 2.0f) + (this.f51922i * 0.5f) : (this.f51936w.width() / 2.0f) + (this.f51922i * 0.5f) : this.f51937x.height() / 2.0f;
    }

    public void M() {
        PointF pointF = this.B;
        pointF.x = -1000.0f;
        pointF.y = -1000.0f;
        this.f51934u = 4;
        N(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    @Override // q.rorbin.badgeview.a
    public float a(boolean z5) {
        return z5 ? d.b(getContext(), this.f51921h) : this.f51921h;
    }

    @Override // q.rorbin.badgeview.a
    public float b(boolean z5) {
        return z5 ? d.b(getContext(), this.f51930q) : this.f51930q;
    }

    @Override // q.rorbin.badgeview.a
    public float c(boolean z5) {
        return z5 ? d.b(getContext(), this.f51931r) : this.f51931r;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a d(int i6) {
        this.f51914a = i6;
        if (i6 == 0) {
            this.I.setXfermode(null);
        } else {
            this.I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public void e(boolean z5) {
        if (!z5 || this.N == null) {
            h(0);
        } else {
            J();
            y(this.C);
        }
    }

    @Override // q.rorbin.badgeview.a
    public boolean f() {
        return this.f51927n;
    }

    @Override // q.rorbin.badgeview.a
    public Drawable getBadgeBackground() {
        return this.f51917d;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeBackgroundColor() {
        return this.f51914a;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeGravity() {
        return this.f51929p;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeNumber() {
        return this.f51923j;
    }

    @Override // q.rorbin.badgeview.a
    public String getBadgeText() {
        return this.f51924k;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeTextColor() {
        return this.f51916c;
    }

    @Override // q.rorbin.badgeview.a
    public PointF getDragCenter() {
        if (this.f51925l && this.f51926m) {
            return this.B;
        }
        return null;
    }

    @Override // q.rorbin.badgeview.a
    public View getTargetView() {
        return this.F;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a h(int i6) {
        this.f51923j = i6;
        if (i6 < 0) {
            this.f51924k = "";
        } else if (i6 > 99) {
            this.f51924k = this.f51927n ? String.valueOf(i6) : "99+";
        } else if (i6 > 0 && i6 <= 99) {
            this.f51924k = String.valueOf(i6);
        } else if (i6 == 0) {
            this.f51924k = null;
        }
        K();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a i(float f6, float f7, boolean z5) {
        if (z5) {
            f6 = d.a(getContext(), f6);
        }
        this.f51930q = f6;
        if (z5) {
            f7 = d.a(getContext(), f7);
        }
        this.f51931r = f7;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a j(boolean z5) {
        this.f51928o = z5;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a k(boolean z5) {
        this.f51927n = z5;
        int i6 = this.f51923j;
        if (i6 > 99) {
            h(i6);
        }
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a l(float f6, boolean z5) {
        if (z5) {
            f6 = d.a(getContext(), f6);
        }
        this.f51922i = f6;
        A();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a m(Drawable drawable, boolean z5) {
        this.f51919f = z5;
        this.f51917d = drawable;
        A();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public boolean n() {
        return this.f51928o;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a o(View view) {
        if (view == null) {
            throw new IllegalStateException("targetView can not be null");
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("targetView must have a parent");
        }
        this.F = view;
        if (parent instanceof a) {
            ((a) parent).addView(this);
            return this;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        viewGroup.removeView(view);
        a aVar = new a(getContext());
        if (viewGroup instanceof RelativeLayout) {
            aVar.setId(view.getId());
        }
        viewGroup.addView(aVar, indexOfChild, layoutParams);
        aVar.addView(view);
        aVar.addView(this);
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b bVar = this.L;
        if (bVar != null && bVar.isRunning()) {
            this.L.b(canvas);
            return;
        }
        if (this.f51924k != null) {
            I();
            float badgeCircleRadius = getBadgeCircleRadius();
            float b6 = this.f51932s * (1.0f - (e.b(this.C, this.B) / this.f51933t));
            if (!this.f51925l || !this.f51926m) {
                F();
                B(canvas, this.A, badgeCircleRadius);
                return;
            }
            this.f51934u = e.c(this.B, this.C);
            O(this.f51928o);
            boolean z5 = b6 < ((float) d.a(getContext(), 1.5f));
            this.f51935v = z5;
            if (z5) {
                P(3);
                B(canvas, this.B, badgeCircleRadius);
            } else {
                P(2);
                D(canvas, b6, badgeCircleRadius);
                B(canvas, this.B, badgeCircleRadius);
            }
        }
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a p(String str) {
        this.f51924k = str;
        this.f51923j = 1;
        K();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public boolean q() {
        return this.f51925l;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a r(a.InterfaceC1003a interfaceC1003a) {
        this.f51925l = interfaceC1003a != null;
        this.M = interfaceC1003a;
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public float s(boolean z5) {
        return z5 ? d.b(getContext(), this.f51922i) : this.f51922i;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a t(int i6) {
        this.f51916c = i6;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a u(int i6, float f6, boolean z5) {
        this.f51915b = i6;
        if (z5) {
            f6 = d.a(getContext(), f6);
        }
        this.f51920g = f6;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a x(float f6, boolean z5) {
        if (z5) {
            f6 = d.a(getContext(), f6);
        }
        this.f51921h = f6;
        K();
        invalidate();
        return this;
    }

    protected void y(PointF pointF) {
        if (this.f51924k == null) {
            return;
        }
        b bVar = this.L;
        if (bVar == null || !bVar.isRunning()) {
            N(true);
            b bVar2 = new b(z(), pointF, this);
            this.L = bVar2;
            bVar2.start();
            h(0);
        }
    }

    protected Bitmap z() {
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.f51937x.width()) + d.a(getContext(), 3.0f), ((int) this.f51937x.height()) + d.a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        B(new Canvas(createBitmap), new PointF(r1.getWidth() / 2.0f, r1.getHeight() / 2.0f), getBadgeCircleRadius());
        return createBitmap;
    }

    private QBadgeView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        H();
    }

    private void E(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            E((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.N = (ViewGroup) view;
        }
    }

    private void G(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        this.N = viewGroup;
        if (viewGroup == null) {
            E(view);
        }
    }

    private void O(boolean z5) {
        float f6;
        int a6 = d.a(getContext(), 1.0f);
        int a7 = d.a(getContext(), 1.5f);
        int i6 = this.f51934u;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4) {
                        a6 = d.a(getContext(), 1.0f);
                        a7 = d.a(getContext(), 1.5f);
                    }
                } else {
                    a6 = d.a(getContext(), -1.0f);
                    a7 = d.a(getContext(), 1.5f);
                }
            } else {
                a6 = d.a(getContext(), -1.0f);
                a7 = d.a(getContext(), -1.5f);
            }
        } else {
            a6 = d.a(getContext(), 1.0f);
            a7 = d.a(getContext(), -1.5f);
        }
        Paint paint = this.J;
        if (z5) {
            f6 = d.a(getContext(), 2.0f);
        } else {
            f6 = 0.0f;
        }
        paint.setShadowLayer(f6, a6, a7, 855638016);
    }

    protected void N(boolean z5) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z5) {
            this.N.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            o(this.F);
        }
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a g(float f6, boolean z5) {
        return i(f6, f6, z5);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.N == null) {
            G(this.F);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.G = i6;
        this.H = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 6) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ac  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L45
            if (r0 == r2) goto L31
            r3 = 2
            if (r0 == r3) goto L18
            r3 = 3
            if (r0 == r3) goto L31
            r3 = 5
            if (r0 == r3) goto L45
            r3 = 6
            if (r0 == r3) goto L31
            goto La8
        L18:
            boolean r0 = r6.f51926m
            if (r0 == 0) goto La8
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawX()
            r0.x = r3
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawY()
            r0.y = r3
            r6.invalidate()
            goto La8
        L31:
            int r0 = r7.getActionIndex()
            int r0 = r7.getPointerId(r0)
            if (r0 != 0) goto La8
            boolean r0 = r6.f51926m
            if (r0 == 0) goto La8
            r6.f51926m = r1
            r6.L()
            goto La8
        L45:
            float r0 = r7.getX()
            float r3 = r7.getY()
            boolean r4 = r6.f51925l
            if (r4 == 0) goto La8
            int r4 = r7.getActionIndex()
            int r4 = r7.getPointerId(r4)
            if (r4 != 0) goto La8
            android.graphics.RectF r4 = r6.f51937x
            float r5 = r4.left
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 <= 0) goto La8
            float r5 = r4.right
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto La8
            float r0 = r4.top
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto La8
            float r0 = r4.bottom
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto La8
            java.lang.String r0 = r6.f51924k
            if (r0 == 0) goto La8
            r6.J()
            r6.f51926m = r2
            r6.P(r2)
            android.content.Context r0 = r6.getContext()
            r3 = 1088421888(0x40e00000, float:7.0)
            int r0 = q.rorbin.badgeview.d.a(r0, r3)
            float r0 = (float) r0
            r6.f51932s = r0
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            r6.N(r2)
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawX()
            r0.x = r3
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawY()
            r0.y = r3
        La8:
            boolean r0 = r6.f51926m
            if (r0 != 0) goto Lb4
            boolean r7 = super.onTouchEvent(r7)
            if (r7 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r1
        Lb4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.rorbin.badgeview.QBadgeView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a v(int i6) {
        if (i6 != 8388659 && i6 != 8388661 && i6 != 8388691 && i6 != 8388693 && i6 != 17 && i6 != 49 && i6 != 81 && i6 != 8388627 && i6 != 8388629) {
            throw new IllegalStateException("only support Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP , Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM , Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END");
        }
        this.f51929p = i6;
        invalidate();
        return this;
    }
}
