package com.bxkj.student.v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TrackProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f21041a;

    /* renamed from: b, reason: collision with root package name */
    private int f21042b;

    /* renamed from: c, reason: collision with root package name */
    private int f21043c;

    /* renamed from: d, reason: collision with root package name */
    private int f21044d;

    /* renamed from: e, reason: collision with root package name */
    private int f21045e;

    /* renamed from: f, reason: collision with root package name */
    private int f21046f;

    /* renamed from: g, reason: collision with root package name */
    private int f21047g;

    /* renamed from: h, reason: collision with root package name */
    private int f21048h;

    /* renamed from: i, reason: collision with root package name */
    private int f21049i;

    /* renamed from: j, reason: collision with root package name */
    private int f21050j;

    /* renamed from: k, reason: collision with root package name */
    private String f21051k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f21052l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f21053m;

    /* renamed from: n, reason: collision with root package name */
    private float f21054n;

    /* renamed from: o, reason: collision with root package name */
    private int f21055o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f21056p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f21057q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f21058r;

    /* renamed from: s, reason: collision with root package name */
    private Paint f21059s;

    /* renamed from: t, reason: collision with root package name */
    private List<a> f21060t;

    /* renamed from: u, reason: collision with root package name */
    private Path f21061u;

    /* renamed from: v, reason: collision with root package name */
    private List<a> f21062v;

    /* renamed from: w, reason: collision with root package name */
    private Path f21063w;

    /* renamed from: x, reason: collision with root package name */
    private Path f21064x;

    /* renamed from: y, reason: collision with root package name */
    private int f21065y;

    /* renamed from: z, reason: collision with root package name */
    private int f21066z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private float f21067a;

        /* renamed from: b, reason: collision with root package name */
        private float f21068b;

        public float a() {
            return this.f21067a;
        }

        public float b() {
            return this.f21068b;
        }

        public a(float x5, float y5) {
            this.f21067a = x5;
            this.f21068b = y5;
        }
    }

    public TrackProgressView(Context context) {
        this(context, null);
    }

    public void c() {
        this.f21055o = 0;
        this.f21049i = 0;
        this.f21064x = new Path();
        a aVar = this.f21062v.get(0);
        this.f21064x.moveTo(aVar.a(), aVar.b());
        invalidate();
    }

    public void setProgress(int progress) {
        d(progress, true);
    }

    public TrackProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void a() {
        for (int i6 = AMapEngineUtils.MIN_LONGITUDE_DEGREE; i6 <= 180; i6++) {
            int i7 = this.f21042b;
            double d6 = this.f21043c + i7;
            double d7 = i6;
            float cos = (float) ((i7 * Math.cos(Math.toRadians(d7))) + d6);
            float sin = (float) ((this.f21042b * Math.sin(Math.toRadians(d7))) + d6);
            float cos2 = (float) (((this.f21042b + (this.f21043c / 2)) * Math.cos(Math.toRadians(d7))) + d6);
            float sin2 = (float) (d6 + ((this.f21042b + (this.f21043c / 2)) * Math.sin(Math.toRadians(d7))));
            if (i6 >= -180 && i6 <= -90) {
                if (i6 == -90) {
                    for (int i8 = 0; i8 <= this.f21041a; i8++) {
                        float f6 = i8;
                        this.f21060t.add(new a(cos + f6, sin));
                        this.f21062v.add(new a(f6 + cos2, sin2));
                    }
                } else {
                    this.f21060t.add(new a(cos, sin));
                    this.f21062v.add(new a(cos2, sin2));
                }
            }
            if (i6 >= -90 && i6 <= 0) {
                this.f21060t.add(new a(this.f21041a + cos, sin));
                this.f21062v.add(new a(this.f21041a + cos2, sin2));
            }
            if (i6 >= 0 && i6 <= 90) {
                if (i6 == 90) {
                    for (int i9 = this.f21041a; i9 >= 0; i9--) {
                        float f7 = i9;
                        this.f21060t.add(new a(cos + f7, sin));
                        this.f21062v.add(new a(f7 + cos2, sin2));
                    }
                } else {
                    this.f21060t.add(new a(this.f21041a + cos, sin));
                    this.f21062v.add(new a(this.f21041a + cos2, sin2));
                }
            }
            if (i6 >= 90 && i6 <= 180) {
                this.f21060t.add(new a(cos, sin));
                this.f21062v.add(new a(cos2, sin2));
            }
        }
    }

    private void b() {
        this.f21056p.setColor(this.f21044d);
        this.f21056p.setFlags(1);
        this.f21057q.setColor(this.f21045e);
        this.f21057q.setFlags(1);
        Paint paint = this.f21057q;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f21057q.setStrokeWidth(this.f21043c);
        this.f21058r.setColor(this.f21046f);
        this.f21058r.setFlags(1);
        this.f21058r.setStyle(style);
        this.f21058r.setStrokeWidth(this.f21043c);
        this.f21059s.setColor(this.f21047g);
        this.f21059s.setFlags(33);
        this.f21059s.setTextSize(this.f21050j);
    }

    private void d(int progress, boolean refresh) {
        int i6 = this.f21048h;
        if (progress > i6) {
            this.f21049i = i6;
        } else {
            this.f21049i = progress;
        }
        if (progress == 0) {
            c();
            return;
        }
        this.f21058r.setColor(this.f21046f);
        int i7 = (int) (this.f21049i * this.f21054n);
        if (i7 >= this.f21062v.size()) {
            i7 = this.f21062v.size() - 1;
        }
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i8 = this.f21055o; i8 <= i7; i8++) {
            a aVar = this.f21062v.get(i8);
            if (i8 == this.f21055o) {
                f6 = aVar.a();
                f7 = aVar.b();
                this.f21064x.moveTo(f6, f7);
            }
            this.f21064x.quadTo(f6, f7, aVar.a(), aVar.b());
            f6 = aVar.a();
            f7 = aVar.b();
        }
        this.f21055o = i7;
        if (refresh) {
            invalidate();
        }
    }

    public void setMaxProgress(int maxProgress) {
        this.f21048h = maxProgress;
        this.f21054n = ((this.f21062v.size() * 1.0f) / this.f21048h) * 1.0f;
        this.f21055o = 0;
    }

    public void setShowText(boolean showText) {
        this.f21052l = showText;
        invalidate();
    }

    public void setShowTips(boolean showTips) {
        this.f21053m = showTips;
        invalidate();
    }

    public void setTipsText(String tipsText) {
        this.f21051k = tipsText;
        invalidate();
    }

    public TrackProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f21041a = 100;
        this.f21042b = 50;
        this.f21043c = 20;
        this.f21044d = 0;
        this.f21045e = 0;
        this.f21046f = 0;
        this.f21047g = 0;
        this.f21048h = 100;
        this.f21049i = 10;
        this.f21050j = 0;
        this.f21051k = "未来3天预约率";
        this.f21052l = true;
        this.f21053m = true;
        float f6 = 0.0f;
        this.f21054n = 0.0f;
        this.f21055o = 0;
        this.f21056p = new Paint();
        this.f21057q = new Paint();
        this.f21058r = new Paint();
        this.f21059s = new Paint();
        this.f21060t = new ArrayList();
        this.f21061u = new Path();
        this.f21062v = new ArrayList();
        this.f21063w = new Path();
        this.f21064x = new Path();
        this.f21065y = 0;
        this.f21066z = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TrackProgressView, defStyleAttr, 0);
        this.f21044d = obtainStyledAttributes.getColor(0, getResources().getColor(2131099718));
        this.f21042b = obtainStyledAttributes.getDimensionPixelSize(6, 50);
        this.f21041a = obtainStyledAttributes.getDimensionPixelSize(2, 100);
        int i6 = getResources().getDisplayMetrics().widthPixels;
        this.f21043c = obtainStyledAttributes.getDimensionPixelSize(13, 20);
        this.f21041a = (i6 - ((this.f21042b + this.f21043c) * 2)) - obtainStyledAttributes.getDimensionPixelSize(3, 20);
        this.f21045e = obtainStyledAttributes.getColor(12, getResources().getColor(2131099734));
        this.f21046f = obtainStyledAttributes.getColor(5, getResources().getColor(2131100716));
        this.f21048h = obtainStyledAttributes.getInteger(4, 100);
        this.f21049i = obtainStyledAttributes.getInteger(1, 10);
        this.f21050j = obtainStyledAttributes.getDimensionPixelSize(10, 20);
        this.f21047g = obtainStyledAttributes.getColor(9, getResources().getColor(2131100716));
        this.f21052l = obtainStyledAttributes.getBoolean(7, true);
        this.f21053m = obtainStyledAttributes.getBoolean(8, true);
        String string = obtainStyledAttributes.getString(11);
        this.f21051k = string;
        if (TextUtils.isEmpty(string)) {
            this.f21051k = "未来3天预约率";
        }
        obtainStyledAttributes.recycle();
        b();
        a();
        float f7 = 0.0f;
        for (int i7 = 0; i7 < this.f21060t.size(); i7++) {
            a aVar = this.f21060t.get(i7);
            if (i7 == 0) {
                f6 = aVar.a();
                f7 = aVar.b();
                this.f21061u.moveTo(f6, f7);
            }
            this.f21061u.quadTo(f6, f7, aVar.a(), aVar.b());
            f6 = aVar.a();
            f7 = aVar.b();
        }
        for (int i8 = 0; i8 < this.f21062v.size(); i8++) {
            a aVar2 = this.f21062v.get(i8);
            if (i8 == 0) {
                f6 = aVar2.a();
                f7 = aVar2.b();
                this.f21063w.moveTo(f6, f7);
            }
            this.f21063w.quadTo(f6, f7, aVar2.a(), aVar2.b());
            f6 = aVar2.a();
            f7 = aVar2.b();
        }
        setMaxProgress(this.f21048h);
        d(this.f21049i, false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f21061u, this.f21056p);
        canvas.drawPath(this.f21063w, this.f21057q);
        this.f21058r.setColor(this.f21046f);
        canvas.drawPath(this.f21064x, this.f21058r);
        if (this.f21052l) {
            Rect rect = new Rect();
            String str = String.format("%.2f", Double.valueOf(((this.f21049i * 1.0f) / this.f21048h) * 100.0d)) + "%";
            this.f21059s.setTextSize(this.f21050j);
            this.f21059s.getTextBounds(str, 0, str.length(), rect);
            if (this.f21053m) {
                canvas.drawText(str, this.f21065y - (rect.width() / 2), this.f21066z, this.f21059s);
            } else {
                canvas.drawText(str, this.f21065y - (rect.width() / 2), this.f21066z + (rect.height() / 2), this.f21059s);
            }
        }
        if (this.f21053m) {
            this.f21059s.setTextSize(this.f21050j / 2);
            Rect rect2 = new Rect();
            Paint paint = this.f21059s;
            String str2 = this.f21051k;
            paint.getTextBounds(str2, 0, str2.length(), rect2);
            if (this.f21052l) {
                canvas.drawText(this.f21051k, this.f21065y - (rect2.width() / 2), this.f21066z + ((int) (rect2.height() * 1.5d)), this.f21059s);
            } else {
                canvas.drawText(this.f21051k, this.f21065y - (rect2.width() / 2), this.f21066z + (rect2.height() / 2), this.f21059s);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i6 = this.f21042b + this.f21043c;
        if (mode != 1073741824) {
            size = getPaddingLeft() + this.f21041a + (i6 * 2) + getPaddingRight();
            this.f21065y = size / 2;
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + (i6 * 2) + getPaddingBottom();
            this.f21066z = size2 / 2;
        }
        setMeasuredDimension(size, size2);
    }
}
