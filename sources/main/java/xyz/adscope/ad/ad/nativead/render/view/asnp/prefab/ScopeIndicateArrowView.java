package xyz.adscope.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ScopeIndicateArrowView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final int f54813a;

    /* renamed from: b, reason: collision with root package name */
    private final int f54814b;

    /* renamed from: c, reason: collision with root package name */
    private int f54815c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f54816d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f54817e;

    /* renamed from: f, reason: collision with root package name */
    private double f54818f;

    /* renamed from: g, reason: collision with root package name */
    private double f54819g;

    /* renamed from: h, reason: collision with root package name */
    private int f54820h;

    /* renamed from: i, reason: collision with root package name */
    private int f54821i;

    public ScopeIndicateArrowView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.f54816d = paint;
        paint.setAntiAlias(true);
        this.f54816d.setDither(true);
        this.f54816d.setStrokeWidth(this.f54815c);
        this.f54816d.setColor(this.f54813a);
        this.f54816d.setStyle(Paint.Style.STROKE);
        this.f54816d.setStrokeCap(Paint.Cap.ROUND);
    }

    private void b() {
        Paint paint = new Paint();
        this.f54817e = paint;
        paint.setAntiAlias(true);
        this.f54817e.setDither(true);
        this.f54817e.setStrokeWidth(this.f54815c);
        this.f54817e.setColor(this.f54814b);
        this.f54817e.setStyle(Paint.Style.STROKE);
        this.f54817e.setStrokeCap(Paint.Cap.ROUND);
    }

    public ScopeIndicateArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setArrowDirection(int i6) {
        this.f54820h = i6;
    }

    public void setCurrentProgress(double d6) {
        this.f54819g = d6 * 100.0d;
        invalidate();
    }

    public void setLineRadius(int i6) {
        this.f54821i = i6;
    }

    public void setLineWidth(int i6) {
        try {
            this.f54815c = i6;
            Paint paint = this.f54816d;
            if (paint != null) {
                paint.setStrokeWidth(i6);
            }
            Paint paint2 = this.f54817e;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.f54815c);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setMaxProgress(double d6) {
        this.f54818f = d6 * 100.0d;
    }

    public ScopeIndicateArrowView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f54813a = Color.parseColor("#CACCCA");
        this.f54814b = Color.parseColor("#FFFFFF");
        this.f54815c = 8;
        this.f54818f = -1.0d;
        this.f54819g = -1.0d;
        this.f54820h = 0;
        this.f54821i = 2;
        a();
        b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            float f6 = this.f54815c / 2.0f;
            RectF rectF = new RectF(f6, f6, getWidth() - (this.f54815c / 2.0f), getHeight() - (this.f54815c / 2.0f));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.f54816d);
            double d6 = this.f54819g;
            if (d6 >= 0.0d) {
                double d7 = this.f54818f;
                if (d7 > 0.0d) {
                    if (d6 >= d7) {
                        this.f54819g = d7;
                    }
                    float f7 = (float) (((float) this.f54819g) / d7);
                    int i6 = this.f54820h;
                    if (i6 == 1) {
                        canvas.drawArc(rectF, 215.0f, 110.0f * f7, false, this.f54817e);
                    } else if (i6 == 2) {
                        canvas.drawArc(rectF, 325.0f, 110.0f * (-f7), false, this.f54817e);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f7) * 55.0f, false, this.f54817e);
                        canvas.drawArc(rectF, 270.0f, f7 * 55.0f, false, this.f54817e);
                    }
                }
            }
            int parseColor = Color.parseColor("#CACCCA");
            if (this.f54819g == this.f54818f) {
                parseColor = Color.parseColor("#FFFFFF");
            }
            int i7 = parseColor;
            int width = getWidth();
            int height = getHeight();
            int min = (Math.min(width, height) / 2) + (this.f54815c * this.f54821i);
            int i8 = width / 2;
            int i9 = height / 2;
            float cos = (float) Math.cos(Math.toRadians(45.0d));
            int i10 = this.f54820h;
            if (i10 == 1) {
                b(canvas, i8, i9, cos, min, i7);
            } else {
                if (i10 == 2) {
                    a(canvas, i8, i9, cos, min, i7);
                    return;
                }
                float f8 = min;
                a(canvas, i8, i9, cos, f8, i7);
                b(canvas, i8, i9, cos, f8, i7);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6) + (this.f54815c * 2);
        int size2 = View.MeasureSpec.getSize(i7) + (this.f54815c * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    private void a(Canvas canvas, int i6, int i7, float f6, float f7, int i8) {
        double d6 = i6 / 2;
        double d7 = f6 * f7;
        float f8 = (float) (d6 - (0.4d * d7));
        int i9 = i7 / 2;
        double d8 = d7 * 0.2d;
        float f9 = i9;
        a(canvas, true, f8, (float) (i9 - d8), (float) (d6 - d8), f9, f8, f9, i8);
    }

    private void b(Canvas canvas, int i6, int i7, float f6, float f7, int i8) {
        double d6 = i6 * 1.5d;
        double d7 = f6 * f7;
        float f8 = (float) ((0.4d * d7) + d6);
        int i9 = i7 / 2;
        double d8 = d7 * 0.2d;
        float f9 = i9;
        a(canvas, true, f8, (float) (i9 - d8), (float) (d6 + d8), f9, f8, f9, i8);
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
