package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RippleView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f37395a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f37396b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f37397c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RippleView.this.f37395a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RippleView.this.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }

    public void b() {
        if (this.f37397c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) Math.sqrt(Math.pow(getHeight(), 2.0d) + Math.pow(getWidth(), 2.0d)));
            this.f37397c = ofInt;
            ofInt.setDuration(400L);
            this.f37397c.addUpdateListener(new a());
            this.f37397c.addListener(new b());
        }
        this.f37397c.start();
    }

    public void setFrontColor(@ColorInt int i6) {
        this.f37396b.setColor(i6);
    }

    public RippleView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f37396b = paint;
        paint.setAntiAlias(true);
        this.f37396b.setColor(-1);
        this.f37396b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f37395a, this.f37396b);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }
}
