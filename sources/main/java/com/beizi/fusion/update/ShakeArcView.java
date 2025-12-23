package com.beizi.fusion.update;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.tool.aa;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ShakeArcView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f13796a;

    /* renamed from: b, reason: collision with root package name */
    private int f13797b;

    /* renamed from: c, reason: collision with root package name */
    private int f13798c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f13799d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f13800e;

    /* renamed from: f, reason: collision with root package name */
    private double f13801f;

    /* renamed from: g, reason: collision with root package name */
    private double f13802g;

    /* renamed from: h, reason: collision with root package name */
    private int f13803h;

    /* renamed from: i, reason: collision with root package name */
    private int f13804i;

    public ShakeArcView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.f13799d = paint;
        paint.setAntiAlias(true);
        this.f13799d.setDither(true);
        this.f13799d.setStrokeWidth(this.f13798c);
        this.f13799d.setColor(this.f13796a);
        this.f13799d.setStyle(Paint.Style.STROKE);
        this.f13799d.setStrokeCap(Paint.Cap.ROUND);
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        Paint paint = new Paint();
        this.f13800e = paint;
        paint.setAntiAlias(true);
        this.f13800e.setDither(true);
        this.f13800e.setStrokeWidth(this.f13798c);
        this.f13800e.setColor(this.f13797b);
        this.f13800e.setStyle(Paint.Style.STROKE);
        this.f13800e.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int i6 = this.f13798c;
            RectF rectF = new RectF(i6 / 2, i6 / 2, getWidth() - (this.f13798c / 2), getHeight() - (this.f13798c / 2));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.f13799d);
            double d6 = this.f13802g;
            if (d6 >= 0.0d) {
                double d7 = this.f13801f;
                if (d7 > 0.0d) {
                    if (d6 >= d7) {
                        this.f13802g = d7;
                    }
                    float f6 = (float) (((float) this.f13802g) / d7);
                    aa.c("sweepAngle", "sweepAngle:" + f6 + ",mMaxProgress:" + this.f13801f + ",mCurrentProgress:" + this.f13802g);
                    int i7 = this.f13803h;
                    if (i7 == 1) {
                        canvas.drawArc(rectF, 215.0f, f6 * 110.0f, false, this.f13800e);
                    } else if (i7 == 2) {
                        canvas.drawArc(rectF, 325.0f, (-f6) * 110.0f, false, this.f13800e);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f6) * 55.0f, false, this.f13800e);
                        canvas.drawArc(rectF, 270.0f, f6 * 55.0f, false, this.f13800e);
                    }
                }
            }
            int parseColor = Color.parseColor("#CACCCA");
            if (this.f13802g == this.f13801f) {
                parseColor = Color.parseColor("#FFFFFF");
            }
            int i8 = parseColor;
            int width = getWidth();
            int height = getHeight();
            int min = (Math.min(width, height) / 2) + (this.f13798c * this.f13804i);
            int i9 = width / 2;
            int i10 = height / 2;
            float cos = (float) Math.cos(Math.toRadians(45.0d));
            int i11 = this.f13803h;
            if (i11 == 1) {
                double d8 = i9 * 1.5d;
                double d9 = cos * min;
                float f7 = (float) ((0.4d * d9) + d8);
                double d10 = d9 * 0.2d;
                float f8 = i10 / 2;
                a(canvas, true, f7, (float) ((i10 / 2) - d10), (float) (d8 + d10), f8, f7, f8, i8);
                return;
            }
            if (i11 == 2) {
                double d11 = cos * min;
                float f9 = (float) ((i9 / 2) - (0.4d * d11));
                double d12 = d11 * 0.2d;
                float f10 = i10 / 2;
                a(canvas, true, f9, (float) ((i10 / 2) - d12), (float) ((i9 / 2) - d12), f10, f9, f10, i8);
                return;
            }
            double d13 = cos * min;
            double d14 = d13 * 0.4d;
            float f11 = (float) ((i9 / 2) - d14);
            double d15 = 0.2d * d13;
            float f12 = i10 / 2;
            a(canvas, true, f11, (float) ((i10 / 2) - d15), (float) ((i9 / 2) - d15), f12, f11, f12, i8);
            double d16 = i9 * 1.5d;
            float f13 = (float) (d16 + d14);
            float f14 = i10 / 2;
            a(canvas, true, f13, (float) ((i10 / 2) - d15), (float) (d16 + d15), f14, f13, f14, i8);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public ShakeArcView setArrowDirection(int i6) {
        this.f13803h = i6;
        return this;
    }

    public ShakeArcView setCurrentProgress(double d6) {
        this.f13802g = d6 * 100.0d;
        invalidate();
        return this;
    }

    public void setLineRadius(int i6) {
        this.f13804i = i6;
    }

    public void setLineWidth(int i6) {
        try {
            this.f13798c = i6;
            Paint paint = this.f13799d;
            if (paint != null) {
                paint.setStrokeWidth(i6);
            }
            Paint paint2 = this.f13800e;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.f13798c);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public ShakeArcView setMaxProgress(double d6) {
        this.f13801f = d6 * 100.0d;
        return this;
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13796a = Color.parseColor("#CACCCA");
        this.f13797b = Color.parseColor("#FFFFFF");
        this.f13798c = 6;
        this.f13801f = -1.0d;
        this.f13802g = -1.0d;
        this.f13803h = 0;
        this.f13804i = 2;
        a();
        b();
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6) + (this.f13798c * 2);
        int size2 = View.MeasureSpec.getSize(i7) + (this.f13798c * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    private void a(Canvas canvas, boolean z5, float f6, float f7, float f8, float f9, float f10, float f11, int i6) {
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i6);
            if (z5) {
                paint.setStyle(Paint.Style.FILL);
            } else {
                paint.setStyle(Paint.Style.STROKE);
            }
            Path path = new Path();
            path.moveTo(f6, f7);
            path.lineTo(f8, f9);
            path.lineTo(f10, f11);
            path.lineTo(f6, f7);
            path.close();
            canvas.drawPath(path, paint);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
