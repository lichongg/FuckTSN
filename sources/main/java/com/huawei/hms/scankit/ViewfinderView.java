package com.huawei.hms.scankit;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.scankit.p.u6;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ViewfinderView extends View {
    private int[] A;
    private float[] B;
    private Rect C;
    private boolean D;
    Point E;
    private boolean F;

    /* renamed from: a, reason: collision with root package name */
    private Paint f33759a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f33760b;

    /* renamed from: c, reason: collision with root package name */
    private int f33761c;

    /* renamed from: d, reason: collision with root package name */
    private int f33762d;

    /* renamed from: e, reason: collision with root package name */
    private int f33763e;

    /* renamed from: f, reason: collision with root package name */
    private int f33764f;

    /* renamed from: g, reason: collision with root package name */
    private int f33765g;

    /* renamed from: h, reason: collision with root package name */
    private float f33766h;

    /* renamed from: i, reason: collision with root package name */
    private c f33767i;

    /* renamed from: j, reason: collision with root package name */
    private String f33768j;

    /* renamed from: k, reason: collision with root package name */
    private int f33769k;

    /* renamed from: l, reason: collision with root package name */
    private float f33770l;

    /* renamed from: m, reason: collision with root package name */
    public int f33771m;

    /* renamed from: n, reason: collision with root package name */
    public int f33772n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f33773o;

    /* renamed from: p, reason: collision with root package name */
    private int f33774p;

    /* renamed from: q, reason: collision with root package name */
    private int f33775q;

    /* renamed from: r, reason: collision with root package name */
    private int f33776r;

    /* renamed from: s, reason: collision with root package name */
    private int f33777s;

    /* renamed from: t, reason: collision with root package name */
    private b f33778t;

    /* renamed from: u, reason: collision with root package name */
    private int f33779u;

    /* renamed from: v, reason: collision with root package name */
    private int f33780v;

    /* renamed from: w, reason: collision with root package name */
    private Rect f33781w;

    /* renamed from: x, reason: collision with root package name */
    private int f33782x;

    /* renamed from: y, reason: collision with root package name */
    private ValueAnimator f33783y;

    /* renamed from: z, reason: collision with root package name */
    Paint f33784z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewfinderView.this.f33771m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewfinderView.this.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);


        /* renamed from: a, reason: collision with root package name */
        private int f33790a;

        b(int i6) {
            this.f33790a = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(int i6) {
            for (b bVar : values()) {
                if (bVar.f33790a == i6) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    public void a(u6 u6Var) {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum c {
        TOP(0),
        BOTTOM(1);


        /* renamed from: a, reason: collision with root package name */
        private int f33794a;

        c(int i6) {
            this.f33794a = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(int i6) {
            for (c cVar : values()) {
                if (cVar.f33794a == i6) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        this.f33761c = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_maskColor, b(context, R.color.scankit_viewfinder_mask));
        this.f33762d = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_frameColor, b(context, R.color.scankit_viewfinder_frame));
        this.f33764f = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_cornerColor, b(context, R.color.scankit_viewfinder_corner));
        this.f33763e = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_laserColor, b(context, R.color.scankit_viewfinder_lasers));
        this.f33765g = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_resultPointColor, b(context, R.color.scankit_viewfinder_result_point_color));
        this.f33768j = obtainStyledAttributes.getString(R.styleable.ViewfinderView_scankit_labelText);
        this.f33769k = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_labelTextColor, b(context, R.color.scankit_viewfinder_text_color));
        this.f33770l = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f33766h = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.f33767i = c.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_labelTextLocation, 0));
        this.f33773o = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_showResultPoint, false);
        this.f33776r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameWidth, 0);
        this.f33777s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameHeight, 0);
        this.f33778t = b.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_laserStyle, b.LINE.f33790a));
        this.f33779u = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_gridColumn, 20);
        this.f33780v = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.F = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_line_anim, true);
        obtainStyledAttributes.recycle();
        this.f33759a = new Paint(1);
        this.f33760b = new TextPaint(1);
        this.f33782x = a(context, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH);
        this.f33775q = getDisplayMetrics().heightPixels;
        this.f33774p = getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i6) {
        int color;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return context.getResources().getColor(i6);
            }
            color = context.getColor(i6);
            return color;
        } catch (Resources.NotFoundException | Exception unused) {
            return 16777215;
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.F) {
            canvas.save();
            String str = Build.DEVICE;
            a(canvas, "HWTAH".equals(str) || str.equals("HWTAH-C"));
            canvas.restore();
        }
        a(canvas);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f33771m = 0;
        this.f33772n = 0;
        this.f33781w = new Rect();
        this.f33784z = new Paint();
        this.A = new int[]{Color.parseColor("#FFFFFFFF"), Color.parseColor("#72FFFFFF"), Color.parseColor("#58FFFFFF"), Color.parseColor("#40FFFFFF"), Color.parseColor("#28FFFFFF"), Color.parseColor("#13FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.B = new float[]{0.0f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
        this.D = true;
        this.F = true;
        a(context, attributeSet);
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f33783y;
        if (valueAnimator != null) {
            valueAnimator.pause();
            this.f33783y.removeAllListeners();
            this.f33783y.cancel();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f33774p = i6;
        this.f33775q = i7;
        a();
    }

    private void a(Canvas canvas, boolean z5) {
        this.f33759a.setStyle(Paint.Style.FILL);
        this.f33759a.setColor(this.f33763e);
        if (!e.f33916z && !z5) {
            Rect rect = this.f33781w;
            rect.left = 0;
            int i6 = this.f33771m;
            rect.top = i6;
            rect.bottom = i6 + this.f33782x;
            rect.right = this.f33774p;
        } else {
            Rect rect2 = this.f33781w;
            int i7 = this.f33774p / 2;
            rect2.left = i7 - 540;
            int i8 = this.f33771m;
            rect2.top = i8;
            rect2.bottom = i8 + this.f33782x;
            rect2.right = i7 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON;
        }
        float f6 = this.f33774p / 2;
        float f7 = this.f33781w.bottom + 500;
        this.f33759a.setShader(new RadialGradient(f6, f7, 690, this.A, this.B, Shader.TileMode.CLAMP));
        this.f33759a.setStrokeWidth(10.0f);
        Rect rect3 = this.f33781w;
        float f8 = rect3.left;
        float f9 = rect3.bottom;
        canvas.drawLine(f8, f9, rect3.right, f9, this.f33759a);
        canvas.clipRect(this.f33781w);
        canvas.drawCircle(f6, f7, r12 + 200, this.f33759a);
    }

    public void a() {
        if (e.f33916z) {
            this.f33772n = this.f33775q;
        } else {
            this.f33772n = this.f33775q - a(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f33772n - this.f33782x);
        this.f33783y = ofInt;
        ofInt.setDuration(3000L);
        this.f33783y.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f33783y.setRepeatMode(1);
        this.f33783y.setRepeatCount(-1);
        this.f33783y.addUpdateListener(new a());
        this.f33783y.start();
    }

    public void a(Rect rect, boolean z5, Point point) {
        this.D = z5;
        this.E = point;
        if (this.C == null) {
            this.C = rect;
            invalidate();
        }
    }

    public static int a(Context context, int i6) {
        return (int) ((i6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(Canvas canvas) {
        Point point;
        int i6;
        int i7;
        int i8;
        if (this.C == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.D) {
            Point point2 = this.E;
            point = new Point(point2.y, point2.x);
        } else {
            Point point3 = this.E;
            point = new Point(point3.x, point3.y);
        }
        int i9 = point.x;
        float f6 = width / i9;
        int i10 = point.y;
        float f7 = height / i10;
        int i11 = (int) (i10 * 0.1d);
        int i12 = (int) ((i9 * 0.15d) / 2.0d);
        RectF rectF = new RectF();
        if (this.D) {
            if (f6 > f7) {
                i7 = (int) (point.y * f6);
                canvas.translate(0.0f, (height / 2) - (i7 / 2));
                i8 = width;
            } else {
                i6 = (int) (point.x * f7);
                canvas.translate((width / 2) - (i6 / 2), 0.0f);
                i8 = i6;
                i7 = height;
            }
        } else if (f6 > f7) {
            i7 = (int) (point.y * f6);
            canvas.translate(0.0f, (height / 2) - (i7 / 2));
            i8 = width;
        } else {
            i6 = (int) (point.x * f7);
            canvas.translate((width / 2) - (i6 / 2), 0.0f);
            i8 = i6;
            i7 = height;
        }
        Rect rect = this.C;
        float f8 = rect.left + i12;
        float f9 = point.x;
        float f10 = rect.top + i11;
        float f11 = point.y;
        float f12 = f10 / f11;
        float f13 = (rect.bottom + i11) / f11;
        float f14 = i8;
        float f15 = (f8 / f9) * f14;
        rectF.left = f15;
        float f16 = ((rect.right + i12) / f9) * f14;
        rectF.right = f16;
        float f17 = i7;
        float f18 = f12 * f17;
        rectF.top = f18;
        float f19 = f13 * f17;
        rectF.bottom = f19;
        float f20 = (f15 + f16) / 2.0f;
        float f21 = (f18 + f19) / 2.0f;
        this.f33784z.setStyle(Paint.Style.FILL);
        this.f33784z.setColor(-1);
        canvas.drawCircle(f20, f21, ((int) ((getDisplayMetrics().density * 24.0f) + 0.5d)) / 2, this.f33784z);
        this.f33784z.setColor(Color.parseColor("#007DFF"));
        canvas.drawCircle(f20, f21, ((int) ((getDisplayMetrics().density * 22.0f) + 0.5d)) / 2, this.f33784z);
        if (this.D) {
            if (f6 > f7) {
                canvas.translate(0.0f, (i7 / 2) - (height / 2));
                return;
            } else {
                canvas.translate((i8 / 2) - (width / 2), 0.0f);
                return;
            }
        }
        if (f6 > f7) {
            canvas.translate(0.0f, (i7 / 2) - (height / 2));
        } else {
            canvas.translate((i8 / 2) - (width / 2), 0.0f);
        }
    }
}
