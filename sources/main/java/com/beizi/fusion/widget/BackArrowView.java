package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BackArrowView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f13828a;

    /* renamed from: b, reason: collision with root package name */
    private int f13829b;

    /* renamed from: c, reason: collision with root package name */
    private float f13830c;

    /* renamed from: d, reason: collision with root package name */
    private float f13831d;

    /* renamed from: e, reason: collision with root package name */
    private int f13832e;

    /* renamed from: f, reason: collision with root package name */
    private float f13833f;

    /* renamed from: g, reason: collision with root package name */
    private int f13834g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f13835h;

    /* renamed from: i, reason: collision with root package name */
    private Path f13836i;

    public BackArrowView(Context context) {
        this(context, null);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i6) {
        b(context, attributeSet, i6);
        Paint paint = new Paint();
        this.f13835h = paint;
        paint.setColor(this.f13832e);
        this.f13835h.setStyle(Paint.Style.STROKE);
        this.f13835h.setAntiAlias(true);
        this.f13835h.setStrokeWidth(this.f13833f);
        this.f13835h.setStrokeJoin(Paint.Join.ROUND);
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Context context, @Nullable AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BeiZi_BackArrowView, i6, 0);
        this.f13832e = obtainStyledAttributes.getColor(R.styleable.BeiZi_BackArrowView_beizi_bav_color, Color.argb(255, 0, 0, 0));
        this.f13833f = obtainStyledAttributes.getDimension(R.styleable.BeiZi_BackArrowView_beizi_bav_stroke_width, dip2px(context, 2.0f));
        this.f13834g = obtainStyledAttributes.getInt(R.styleable.BeiZi_BackArrowView_beizi_bav_arrow_style, 1);
        obtainStyledAttributes.recycle();
    }

    public void setViewColor(int i6) {
        Paint paint = this.f13835h;
        if (paint != null) {
            paint.setColor(i6);
            invalidate();
        }
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a(context, attributeSet, i6);
    }

    public static int dip2px(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((this.f13828a / 2.0f) - this.f13830c, this.f13829b / 2);
        canvas.rotate(45.0f);
        if (this.f13836i == null) {
            this.f13836i = new Path();
        }
        this.f13836i.reset();
        this.f13836i.lineTo(0.0f, this.f13831d);
        this.f13836i.moveTo(0.0f, 0.0f);
        this.f13836i.lineTo(-this.f13831d, 0.0f);
        if (this.f13834g == 1) {
            this.f13836i.moveTo(0.0f, 0.0f);
            Path path = this.f13836i;
            float f6 = this.f13831d;
            path.lineTo(f6, -f6);
        }
        this.f13836i.close();
        canvas.drawPath(this.f13836i, this.f13835h);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        setMeasuredDimension(a(i6), a(i7));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f13828a = i6;
        this.f13829b = i7;
        float min = Math.min(i6, i7) / 2.0f;
        int i10 = this.f13834g;
        if (i10 == 1) {
            this.f13830c = min / 3.0f;
        } else if (i10 == 2) {
            this.f13830c = min / 4.0f;
        }
        this.f13831d = min * 0.63f;
    }

    private int a(int i6) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(150, size);
        }
        return 150;
    }
}
