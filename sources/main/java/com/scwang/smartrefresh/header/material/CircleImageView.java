package com.scwang.smartrefresh.header.material;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.annotation.ColorInt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CircleImageView extends ImageView {

    /* renamed from: c, reason: collision with root package name */
    private static final int f37180c = 503316480;

    /* renamed from: d, reason: collision with root package name */
    private static final int f37181d = 1023410176;

    /* renamed from: e, reason: collision with root package name */
    private static final float f37182e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private static final float f37183f = 1.75f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f37184g = 3.5f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f37185h = 4;

    /* renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f37186a;

    /* renamed from: b, reason: collision with root package name */
    int f37187b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends OvalShape {

        /* renamed from: a, reason: collision with root package name */
        private RadialGradient f37188a;

        /* renamed from: b, reason: collision with root package name */
        private Paint f37189b = new Paint();

        a(int i6) {
            CircleImageView.this.f37187b = i6;
            a((int) rect().width());
        }

        private void a(int i6) {
            float f6 = i6 / 2;
            RadialGradient radialGradient = new RadialGradient(f6, f6, CircleImageView.this.f37187b, new int[]{CircleImageView.f37181d, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f37188a = radialGradient;
            this.f37189b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f37189b);
            canvas.drawCircle(width, height, r0 - CircleImageView.this.f37187b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f6, float f7) {
            super.onResize(f6, f7);
            a((int) f6);
        }
    }

    private boolean a() {
        return true;
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f37186a = animationListener;
    }

    public CircleImageView(Context context, int i6) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f6 = getContext().getResources().getDisplayMetrics().density;
        int i7 = (int) (1.75f * f6);
        int i8 = (int) (0.0f * f6);
        this.f37187b = (int) (f37184g * f6);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            setElevation(f6 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this.f37187b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f37187b, i8, i7, f37180c);
            int i9 = this.f37187b;
            setPadding(i9, i9, i9, i9);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i6);
        setBackground(shapeDrawable);
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f37186a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f37186a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f37187b * 2), getMeasuredHeight() + (this.f37187b * 2));
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i6) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i6);
        }
    }

    public void setBackgroundColorRes(int i6) {
        int color;
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 23) {
            color = context.getResources().getColor(i6, context.getTheme());
            setBackgroundColor(color);
        } else {
            setBackgroundColor(context.getResources().getColor(i6));
        }
    }
}
