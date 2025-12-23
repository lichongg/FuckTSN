package com.scwang.smartrefresh.header.waterdrop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WaterDropView extends View {

    /* renamed from: g, reason: collision with root package name */
    private static int f37200g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static final int f37201h = 180;

    /* renamed from: a, reason: collision with root package name */
    private com.scwang.smartrefresh.header.waterdrop.a f37202a;

    /* renamed from: b, reason: collision with root package name */
    private com.scwang.smartrefresh.header.waterdrop.a f37203b;

    /* renamed from: c, reason: collision with root package name */
    private Path f37204c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f37205d;

    /* renamed from: e, reason: collision with root package name */
    private int f37206e;

    /* renamed from: f, reason: collision with root package name */
    private int f37207f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        b(context, null);
    }

    public Animator a() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new a());
        return duration;
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f37202a = new com.scwang.smartrefresh.header.waterdrop.a();
        this.f37203b = new com.scwang.smartrefresh.header.waterdrop.a();
        this.f37204c = new Path();
        Paint paint = new Paint();
        this.f37205d = paint;
        paint.setColor(-7829368);
        this.f37205d.setAntiAlias(true);
        this.f37205d.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.f37205d;
        int b6 = c.b(0.5f);
        f37200g = b6;
        paint2.setStrokeWidth(b6);
        this.f37205d.setShadowLayer(f37200g, 0.0f, 0.0f, -872415232);
        setLayerType(1, null);
        int i6 = f37200g * 4;
        setPadding(i6, i6, i6, i6);
        this.f37205d.setColor(-7829368);
        int b7 = c.b(20.0f);
        this.f37206e = b7;
        this.f37207f = b7 / 5;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f37202a;
        aVar.f37211c = b7;
        com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f37203b;
        aVar2.f37211c = b7;
        int i7 = f37200g;
        aVar.f37209a = i7 + b7;
        aVar.f37210b = i7 + b7;
        aVar2.f37209a = i7 + b7;
        aVar2.f37210b = i7 + b7;
    }

    private void c() {
        this.f37204c.reset();
        Path path = this.f37204c;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f37202a;
        float f6 = aVar.f37209a;
        float f7 = aVar.f37210b;
        float f8 = aVar.f37211c;
        Path.Direction direction = Path.Direction.CCW;
        path.addCircle(f6, f7, f8, direction);
        if (this.f37203b.f37210b > this.f37202a.f37210b + c.b(1.0f)) {
            Path path2 = this.f37204c;
            com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f37203b;
            path2.addCircle(aVar2.f37209a, aVar2.f37210b, aVar2.f37211c, direction);
            double angle = getAngle();
            com.scwang.smartrefresh.header.waterdrop.a aVar3 = this.f37202a;
            float cos = (float) (aVar3.f37209a - (aVar3.f37211c * Math.cos(angle)));
            com.scwang.smartrefresh.header.waterdrop.a aVar4 = this.f37202a;
            float sin = (float) (aVar4.f37210b + (aVar4.f37211c * Math.sin(angle)));
            com.scwang.smartrefresh.header.waterdrop.a aVar5 = this.f37202a;
            float cos2 = (float) (aVar5.f37209a + (aVar5.f37211c * Math.cos(angle)));
            com.scwang.smartrefresh.header.waterdrop.a aVar6 = this.f37203b;
            float cos3 = (float) (aVar6.f37209a - (aVar6.f37211c * Math.cos(angle)));
            com.scwang.smartrefresh.header.waterdrop.a aVar7 = this.f37203b;
            float sin2 = (float) (aVar7.f37210b + (aVar7.f37211c * Math.sin(angle)));
            com.scwang.smartrefresh.header.waterdrop.a aVar8 = this.f37203b;
            float cos4 = (float) (aVar8.f37209a + (aVar8.f37211c * Math.cos(angle)));
            Path path3 = this.f37204c;
            com.scwang.smartrefresh.header.waterdrop.a aVar9 = this.f37202a;
            path3.moveTo(aVar9.f37209a, aVar9.f37210b);
            this.f37204c.lineTo(cos, sin);
            Path path4 = this.f37204c;
            com.scwang.smartrefresh.header.waterdrop.a aVar10 = this.f37203b;
            path4.quadTo(aVar10.f37209a - aVar10.f37211c, (aVar10.f37210b + this.f37202a.f37210b) / 2.0f, cos3, sin2);
            this.f37204c.lineTo(cos4, sin2);
            Path path5 = this.f37204c;
            com.scwang.smartrefresh.header.waterdrop.a aVar11 = this.f37203b;
            path5.quadTo(aVar11.f37209a + aVar11.f37211c, (aVar11.f37210b + sin) / 2.0f, cos2, sin);
        }
        this.f37204c.close();
    }

    private double getAngle() {
        if (this.f37203b.f37211c <= this.f37202a.f37211c) {
            return Math.asin((r3 - r1) / (r0.f37210b - r2.f37210b));
        }
        throw new IllegalStateException("bottomCircle's radius must be less than the topCircle's");
    }

    public void d(float f6) {
        int i6 = this.f37206e;
        float f7 = (float) (i6 - ((f6 * 0.25d) * i6));
        float f8 = ((this.f37207f - i6) * f6) + i6;
        float f9 = f6 * 4.0f * i6;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f37202a;
        aVar.f37211c = f7;
        com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f37203b;
        aVar2.f37211c = f8;
        aVar2.f37210b = aVar.f37210b + f9;
    }

    public com.scwang.smartrefresh.header.waterdrop.a getBottomCircle() {
        return this.f37203b;
    }

    public int getIndicatorColor() {
        return this.f37205d.getColor();
    }

    public int getMaxCircleRadius() {
        return this.f37206e;
    }

    public com.scwang.smartrefresh.header.waterdrop.a getTopCircle() {
        return this.f37202a;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8 = this.f37206e;
        int i9 = f37200g;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f37203b;
        setMeasuredDimension(((i8 + i9) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil(aVar.f37210b + aVar.f37211c + (i9 * 2))) + getPaddingTop() + getPaddingBottom(), i7));
    }

    public void setIndicatorColor(@ColorInt int i6) {
        this.f37205d.setColor(i6);
    }

    public WaterDropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public void e(int i6) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = this.f37206e;
        if (i6 < (i7 * 2) + paddingTop + paddingBottom) {
            com.scwang.smartrefresh.header.waterdrop.a aVar = this.f37202a;
            aVar.f37211c = i7;
            com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f37203b;
            aVar2.f37211c = i7;
            aVar2.f37210b = aVar.f37210b;
            return;
        }
        float pow = (float) ((i7 - this.f37207f) * (1.0d - Math.pow(100.0d, (-Math.max(0.0f, r4 - r3)) / c.b(200.0f))));
        com.scwang.smartrefresh.header.waterdrop.a aVar3 = this.f37202a;
        int i8 = this.f37206e;
        aVar3.f37211c = i8 - (pow / 4.0f);
        com.scwang.smartrefresh.header.waterdrop.a aVar4 = this.f37203b;
        float f6 = i8 - pow;
        aVar4.f37211c = f6;
        aVar4.f37210b = ((i6 - paddingTop) - paddingBottom) - f6;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f6 = height;
        float f7 = this.f37202a.f37211c;
        float f8 = paddingTop;
        float f9 = paddingBottom;
        if (f6 <= (f7 * 2.0f) + f8 + f9) {
            canvas.translate(paddingLeft, (f6 - (f7 * 2.0f)) - f9);
            com.scwang.smartrefresh.header.waterdrop.a aVar = this.f37202a;
            canvas.drawCircle(aVar.f37209a, aVar.f37210b, aVar.f37211c, this.f37205d);
        } else {
            canvas.translate(paddingLeft, f8);
            c();
            canvas.drawPath(this.f37204c, this.f37205d);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        e(getHeight());
    }

    public WaterDropView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        b(context, attributeSet);
    }

    public void f(int i6, int i7) {
    }
}
