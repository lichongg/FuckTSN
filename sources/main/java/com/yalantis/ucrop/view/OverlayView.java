package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.util.g;
import f3.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class OverlayView extends View {
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 2;
    public static final boolean F = true;
    public static final boolean G = true;
    public static final boolean H = false;
    public static final int I = 0;
    public static final int J = 2;
    public static final int K = 2;
    private d A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    private final RectF f42845a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f42846b;

    /* renamed from: c, reason: collision with root package name */
    protected int f42847c;

    /* renamed from: d, reason: collision with root package name */
    protected int f42848d;

    /* renamed from: e, reason: collision with root package name */
    protected float[] f42849e;

    /* renamed from: f, reason: collision with root package name */
    protected float[] f42850f;

    /* renamed from: g, reason: collision with root package name */
    private int f42851g;

    /* renamed from: h, reason: collision with root package name */
    private int f42852h;

    /* renamed from: i, reason: collision with root package name */
    private float f42853i;

    /* renamed from: j, reason: collision with root package name */
    private float[] f42854j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f42855k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f42856l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f42857m;

    /* renamed from: n, reason: collision with root package name */
    private int f42858n;

    /* renamed from: o, reason: collision with root package name */
    private Path f42859o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f42860p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f42861q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f42862r;

    /* renamed from: s, reason: collision with root package name */
    private Paint f42863s;

    /* renamed from: t, reason: collision with root package name */
    private int f42864t;

    /* renamed from: u, reason: collision with root package name */
    private float f42865u;

    /* renamed from: v, reason: collision with root package name */
    private float f42866v;

    /* renamed from: w, reason: collision with root package name */
    private int f42867w;

    /* renamed from: x, reason: collision with root package name */
    private int f42868x;

    /* renamed from: y, reason: collision with root package name */
    private int f42869y;

    /* renamed from: z, reason: collision with root package name */
    private int f42870z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int c(float f6, float f7) {
        double d6 = this.f42868x;
        int i6 = -1;
        for (int i7 = 0; i7 < 8; i7 += 2) {
            double sqrt = Math.sqrt(Math.pow(f6 - this.f42849e[i7], 2.0d) + Math.pow(f7 - this.f42849e[i7 + 1], 2.0d));
            if (sqrt < d6) {
                i6 = i7 / 2;
                d6 = sqrt;
            }
        }
        if (this.f42864t == 1 && i6 < 0 && this.f42845a.contains(f6, f7)) {
            return 4;
        }
        return i6;
    }

    private void e(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.f42862r.setStrokeWidth(dimensionPixelSize);
        this.f42862r.setColor(color);
        Paint paint = this.f42862r;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f42863s.setStrokeWidth(dimensionPixelSize * 3);
        this.f42863s.setColor(color);
        this.f42863s.setStyle(style);
    }

    private void f(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.f42861q.setStrokeWidth(dimensionPixelSize);
        this.f42861q.setColor(color);
        this.f42851g = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.f42852h = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void j(float f6, float f7) {
        this.f42846b.set(this.f42845a);
        int i6 = this.f42867w;
        if (i6 == 0) {
            RectF rectF = this.f42846b;
            RectF rectF2 = this.f42845a;
            rectF.set(f6, f7, rectF2.right, rectF2.bottom);
        } else if (i6 == 1) {
            RectF rectF3 = this.f42846b;
            RectF rectF4 = this.f42845a;
            rectF3.set(rectF4.left, f7, f6, rectF4.bottom);
        } else if (i6 == 2) {
            RectF rectF5 = this.f42846b;
            RectF rectF6 = this.f42845a;
            rectF5.set(rectF6.left, rectF6.top, f6, f7);
        } else if (i6 == 3) {
            RectF rectF7 = this.f42846b;
            RectF rectF8 = this.f42845a;
            rectF7.set(f6, rectF8.top, rectF8.right, f7);
        } else if (i6 == 4) {
            this.f42846b.offset(f6 - this.f42865u, f7 - this.f42866v);
            if (this.f42846b.left <= getLeft() || this.f42846b.top <= getTop() || this.f42846b.right >= getRight() || this.f42846b.bottom >= getBottom()) {
                return;
            }
            this.f42845a.set(this.f42846b);
            k();
            postInvalidate();
            return;
        }
        boolean z5 = this.f42846b.height() >= ((float) this.f42869y);
        boolean z6 = this.f42846b.width() >= ((float) this.f42869y);
        RectF rectF9 = this.f42845a;
        rectF9.set(z6 ? this.f42846b.left : rectF9.left, z5 ? this.f42846b.top : rectF9.top, z6 ? this.f42846b.right : rectF9.right, z5 ? this.f42846b.bottom : rectF9.bottom);
        if (z5 || z6) {
            k();
            postInvalidate();
        }
    }

    private void k() {
        this.f42849e = g.b(this.f42845a);
        this.f42850f = g.a(this.f42845a);
        this.f42854j = null;
        this.f42859o.reset();
        this.f42859o.addCircle(this.f42845a.centerX(), this.f42845a.centerY(), Math.min(this.f42845a.width(), this.f42845a.height()) / 2.0f, Path.Direction.CW);
    }

    protected void a(@NonNull Canvas canvas) {
        if (this.f42856l) {
            if (this.f42854j == null && !this.f42845a.isEmpty()) {
                this.f42854j = new float[(this.f42851g * 4) + (this.f42852h * 4)];
                int i6 = 0;
                for (int i7 = 0; i7 < this.f42851g; i7++) {
                    float[] fArr = this.f42854j;
                    RectF rectF = this.f42845a;
                    fArr[i6] = rectF.left;
                    float f6 = i7 + 1.0f;
                    float height = rectF.height() * (f6 / (this.f42851g + 1));
                    RectF rectF2 = this.f42845a;
                    fArr[i6 + 1] = height + rectF2.top;
                    float[] fArr2 = this.f42854j;
                    int i8 = i6 + 3;
                    fArr2[i6 + 2] = rectF2.right;
                    i6 += 4;
                    fArr2[i8] = (rectF2.height() * (f6 / (this.f42851g + 1))) + this.f42845a.top;
                }
                for (int i9 = 0; i9 < this.f42852h; i9++) {
                    float[] fArr3 = this.f42854j;
                    float f7 = i9 + 1.0f;
                    float width = this.f42845a.width() * (f7 / (this.f42852h + 1));
                    RectF rectF3 = this.f42845a;
                    fArr3[i6] = width + rectF3.left;
                    float[] fArr4 = this.f42854j;
                    fArr4[i6 + 1] = rectF3.top;
                    int i10 = i6 + 3;
                    float width2 = rectF3.width() * (f7 / (this.f42852h + 1));
                    RectF rectF4 = this.f42845a;
                    fArr4[i6 + 2] = width2 + rectF4.left;
                    i6 += 4;
                    this.f42854j[i10] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f42854j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f42861q);
            }
        }
        if (this.f42855k) {
            canvas.drawRect(this.f42845a, this.f42862r);
        }
        if (this.f42864t != 0) {
            canvas.save();
            this.f42846b.set(this.f42845a);
            this.f42846b.inset(this.f42870z, -r1);
            RectF rectF5 = this.f42846b;
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF5, op);
            this.f42846b.set(this.f42845a);
            this.f42846b.inset(-r2, this.f42870z);
            canvas.clipRect(this.f42846b, op);
            canvas.drawRect(this.f42845a, this.f42863s);
            canvas.restore();
        }
    }

    @Deprecated
    public boolean g() {
        return this.f42864t == 1;
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f42845a;
    }

    public int getFreestyleCropMode() {
        return this.f42864t;
    }

    public d getOverlayViewChangeListener() {
        return this.A;
    }

    protected void h(@NonNull TypedArray typedArray) {
        this.f42857m = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.f42858n = color;
        this.f42860p.setColor(color);
        this.f42860p.setStyle(Paint.Style.STROKE);
        this.f42860p.setStrokeWidth(1.0f);
        e(typedArray);
        this.f42855k = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        f(typedArray);
        this.f42856l = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void i() {
        int i6 = this.f42847c;
        float f6 = this.f42853i;
        int i7 = (int) (i6 / f6);
        int i8 = this.f42848d;
        if (i7 > i8) {
            int i9 = (i6 - ((int) (i8 * f6))) / 2;
            this.f42845a.set(getPaddingLeft() + i9, getPaddingTop(), getPaddingLeft() + r1 + i9, getPaddingTop() + this.f42848d);
        } else {
            int i10 = (i8 - i7) / 2;
            this.f42845a.set(getPaddingLeft(), getPaddingTop() + i10, getPaddingLeft() + this.f42847c, getPaddingTop() + i7 + i10);
        }
        d dVar = this.A;
        if (dVar != null) {
            dVar.a(this.f42845a);
        }
        k();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f42845a.isEmpty() && this.f42864t != 0) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int c6 = c(x5, y5);
                this.f42867w = c6;
                boolean z5 = c6 != -1;
                if (!z5) {
                    this.f42865u = -1.0f;
                    this.f42866v = -1.0f;
                    return z5;
                }
                if (this.f42865u < 0.0f) {
                    this.f42865u = x5;
                    this.f42866v = y5;
                }
                return z5;
            }
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f42867w != -1) {
                float min = Math.min(Math.max(x5, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y5, getPaddingTop()), getHeight() - getPaddingBottom());
                j(min, min2);
                this.f42865u = min;
                this.f42866v = min2;
                return true;
            }
            if ((motionEvent.getAction() & 255) == 1) {
                this.f42865u = -1.0f;
                this.f42866v = -1.0f;
                this.f42867w = -1;
                d dVar = this.A;
                if (dVar != null) {
                    dVar.a(this.f42845a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z5) {
        this.f42857m = z5;
    }

    public void setCropFrameColor(@ColorInt int i6) {
        this.f42862r.setColor(i6);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i6) {
        this.f42862r.setStrokeWidth(i6);
    }

    public void setCropGridColor(@ColorInt int i6) {
        this.f42861q.setColor(i6);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i6) {
        this.f42852h = i6;
        this.f42854j = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i6) {
        this.f42851g = i6;
        this.f42854j = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i6) {
        this.f42861q.setStrokeWidth(i6);
    }

    public void setDimmedColor(@ColorInt int i6) {
        this.f42858n = i6;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z5) {
        this.f42864t = z5 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i6) {
        this.f42864t = i6;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(d dVar) {
        this.A = dVar;
    }

    public void setShowCropFrame(boolean z5) {
        this.f42855k = z5;
    }

    public void setShowCropGrid(boolean z5) {
        this.f42856l = z5;
    }

    public void setTargetAspectRatio(float f6) {
        this.f42853i = f6;
        if (this.f42847c <= 0) {
            this.B = true;
        } else {
            i();
            postInvalidate();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42845a = new RectF();
        this.f42846b = new RectF();
        this.f42854j = null;
        this.f42859o = new Path();
        this.f42860p = new Paint(1);
        this.f42861q = new Paint(1);
        this.f42862r = new Paint(1);
        this.f42863s = new Paint(1);
        this.f42864t = 0;
        this.f42865u = -1.0f;
        this.f42866v = -1.0f;
        this.f42867w = -1;
        this.f42868x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.f42869y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.f42870z = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        d();
    }

    protected void b(@NonNull Canvas canvas) {
        canvas.save();
        if (this.f42857m) {
            canvas.clipPath(this.f42859o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f42845a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f42858n);
        canvas.restore();
        if (this.f42857m) {
            canvas.drawCircle(this.f42845a.centerX(), this.f42845a.centerY(), Math.min(this.f42845a.width(), this.f42845a.height()) / 2.0f, this.f42860p);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f42847c = width - paddingLeft;
            this.f42848d = height - paddingTop;
            if (this.B) {
                this.B = false;
                setTargetAspectRatio(this.f42853i);
            }
        }
    }

    protected void d() {
    }
}
