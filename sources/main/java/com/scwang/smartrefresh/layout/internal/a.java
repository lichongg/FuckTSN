package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends Drawable implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    private ValueAnimator f37442b;

    /* renamed from: d, reason: collision with root package name */
    private Paint f37444d;

    /* renamed from: a, reason: collision with root package name */
    private int f37441a = 0;

    /* renamed from: c, reason: collision with root package name */
    private Path f37443c = new Path();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.scwang.smartrefresh.layout.internal.a$a, reason: collision with other inner class name */
    class C0727a implements ValueAnimator.AnimatorUpdateListener {
        C0727a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f37441a = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
            a.this.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.f37442b = ofInt;
        ofInt.addUpdateListener(new C0727a());
        this.f37442b.setDuration(10000L);
        this.f37442b.setInterpolator(new LinearInterpolator());
        this.f37442b.setRepeatCount(-1);
        this.f37442b.setRepeatMode(1);
    }

    public void c(int i6) {
        this.f37444d.setColor(i6);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f37442b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f37444d.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f37444d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f37442b.isRunning()) {
            return;
        }
        this.f37442b.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f37442b.isRunning()) {
            this.f37442b.cancel();
        }
    }

    public a() {
        Paint paint = new Paint();
        this.f37444d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f37444d.setAntiAlias(true);
        this.f37444d.setColor(-5592406);
        d();
    }

    public int b() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.save();
        float f6 = width / 2;
        float f7 = height / 2;
        canvas.rotate(this.f37441a, f6, f7);
        int max = Math.max(1, width / 20);
        for (int i6 = 0; i6 < 12; i6++) {
            this.f37443c.reset();
            Path path = this.f37443c;
            float f8 = width - max;
            float f9 = max;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f8, f7, f9, direction);
            float f10 = width - (max * 5);
            this.f37443c.addRect(f10, r0 - max, f8, r0 + max, direction);
            this.f37443c.addCircle(f10, f7, f9, direction);
            this.f37444d.setAlpha((i6 + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f37443c, this.f37444d);
        }
        canvas.restore();
    }

    public int e() {
        return getBounds().width();
    }
}
