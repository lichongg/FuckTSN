package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ScaleAnimSeekBar extends View {
    private Paint aLU;
    private int aLV;
    private int aLW;
    private int aLX;
    private int aLY;
    private int aLZ;
    private boolean aMA;
    private ValueAnimator aMB;
    private ValueAnimator aMC;
    private ValueAnimator aMD;
    private float aME;
    private float aMF;
    private float aMG;
    private float aMH;
    private int aMI;
    private boolean aMJ;
    private int aMa;
    private int aMb;
    private int aMc;
    private boolean aMd;
    private int aMe;
    private int aMf;
    private int aMg;
    private int aMh;
    private int aMi;
    private int aMj;
    private int aMk;
    private GradientDrawable aMl;
    private GradientDrawable aMm;
    private GradientDrawable aMn;
    private Rect aMo;
    private Rect aMp;
    private Rect aMq;
    private Rect aMr;
    private Drawable aMs;
    private boolean aMt;
    private boolean aMu;
    private boolean aMv;
    private boolean aMw;
    private boolean aMx;
    private WeakReference<a> aMy;
    private boolean aMz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z5);

        void wd();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bS(Context context) {
        this.aMz = true;
        this.aMI = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.aLY = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.aMf = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.aMs = null;
        this.aMA = false;
        this.aMc = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.aMb = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.aLV = 654311423;
        this.aLW = -1;
        this.aLX = 1090519039;
        this.aLZ = 0;
        this.aMa = 100;
        this.aMd = false;
    }

    private void i(boolean z5, int i6) {
        if (!z5) {
            this.aMg = i6;
            i(j(dQ(i6)));
            return;
        }
        float j6 = j(dQ(this.aMg));
        float j7 = j(dQ(i6));
        ValueAnimator valueAnimator = this.aMD;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aMD = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.aMD.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f6) {
                    float f7 = f6 - 1.0f;
                    return (f7 * f7 * f7) + 1.0f;
                }
            });
            this.aMD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.aMg = scaleAnimSeekBar.dR((int) floatValue);
                    ScaleAnimSeekBar.this.i(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aMD.setFloatValues(j6, j7);
        this.aMD.start();
    }

    public void setProgress(int i6) {
        a(i6, false, false);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void bw(boolean z5) {
        if (this.aMz) {
            if (z5) {
                bx(true);
                by(true);
            } else {
                bx(false);
                by(false);
            }
        }
    }

    private void bx(boolean z5) {
        float f6 = this.aME;
        float f7 = z5 ? this.aMF : 1.0f;
        ValueAnimator valueAnimator = this.aMB;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aMB = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aMB.setInterpolator(new LinearInterpolator());
            this.aMB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aME = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aMB.setFloatValues(f6, f7);
        this.aMB.start();
    }

    private void by(boolean z5) {
        float f6 = this.aMG;
        float f7 = z5 ? this.aMH : 1.0f;
        ValueAnimator valueAnimator = this.aMC;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aMC = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aMC.setInterpolator(new LinearInterpolator());
            this.aMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aMG = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aMC.setFloatValues(f6, f7);
        this.aMC.start();
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aMs;
        if (drawable != null) {
            drawable.setBounds(this.aMr);
            this.aMs.draw(canvas);
        } else {
            this.aLU.setColor(this.aLW);
            canvas.drawCircle(this.aMr.centerX(), this.aMr.centerY(), (this.aMr.width() * this.aME) / 2.0f, this.aLU);
        }
        canvas.restore();
    }

    private boolean d(float f6, float f7) {
        int i6;
        int i7;
        Rect rect = this.aMo;
        int i8 = rect.left;
        int i9 = rect.right;
        if (i8 >= i9 || (i6 = rect.top) >= (i7 = rect.bottom)) {
            return false;
        }
        float f8 = this.aMG;
        int i10 = this.aMf;
        return f6 >= (((float) i8) * f8) - ((float) i10) && f6 <= (((float) i9) * f8) + ((float) i10) && f7 >= (((float) i6) * f8) - ((float) i10) && f7 <= (((float) i7) * f8) + ((float) i10);
    }

    private float dQ(int i6) {
        int i7 = this.aMe;
        int i8 = this.aLZ;
        return ((i7 * (i6 - i8)) / (this.aMa - i8)) - (i7 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dR(int i6) {
        int i7 = this.aMe;
        return i6 > i7 / 2 ? this.aMa : i6 < (-i7) / 2 ? this.aLZ : Math.round(((i6 + (i7 / 2.0f)) * (this.aMa - this.aLZ)) / i7) + this.aLZ;
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aMy;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bS(context);
        }
        Paint paint = new Paint();
        this.aLU = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aLU.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aMl = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aMl.setColor(this.aLV);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aMm = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aMm.setColor(this.aLW);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aMn = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aMn.setColor(this.aLX);
        this.aMo = new Rect();
        this.aMp = new Rect();
        this.aMr = new Rect();
        this.aMq = new Rect();
        this.aMg = this.aLZ;
    }

    private float j(float f6) {
        float f7 = this.aMe / 2;
        if (f6 > f7) {
            return f7;
        }
        float f8 = -f7;
        return f6 < f8 ? f8 : f6;
    }

    private void y(int i6, int i7) {
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        if (this.aMz) {
            this.aMe = (int) (i6 - ((this.aMI * 2) * (this.aMF - this.aME)));
        } else {
            this.aMe = i6 - (this.aMI * 2);
        }
        Rect rect = this.aMo;
        int i8 = this.aMc;
        int i9 = -i8;
        rect.top = i9;
        rect.bottom = -i9;
        boolean z5 = this.aMd;
        rect.left = (z5 ? -i6 : -this.aMe) / 2;
        rect.right = z5 ? i6 / 2 : this.aMe / 2;
        Rect rect2 = this.aMp;
        int i10 = -i8;
        rect2.top = i10;
        rect2.bottom = -i10;
        rect2.left = (z5 ? -i6 : -this.aMe) / 2;
        int i11 = this.aMe;
        rect2.right = (-i11) / 2;
        Rect rect3 = this.aMq;
        rect3.top = -i8;
        rect3.bottom = -rect2.top;
        rect3.left = (z5 ? -i6 : -i11) / 2;
        rect3.right = (-i11) / 2;
        Rect rect4 = this.aMr;
        int i12 = this.aLY;
        rect4.top = -i12;
        rect4.bottom = i12;
        rect4.left = ((-i11) / 2) - i12;
        rect4.right = ((-i11) / 2) + i12;
        setThumbDrawable(this.aMs);
        setProgress(this.aMg);
        setSecondaryProgress(this.aMi);
    }

    public final void bv(boolean z5) {
        this.aMJ = z5;
        bw(z5);
    }

    public int getMaxProgress() {
        return this.aMa;
    }

    public int getProgress() {
        return this.aMg;
    }

    public int getProgressLength() {
        return this.aMe;
    }

    public int getSecondaryProgress() {
        return this.aMi;
    }

    public void setMaxProgress(int i6) {
        this.aMa = i6;
    }

    public void setMinProgress(int i6) {
        this.aLZ = i6;
        if (this.aMg < i6) {
            this.aMg = i6;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aMy = new WeakReference<>(aVar);
    }

    public void setProgressBackgroundColor(@ColorInt int i6) {
        this.aLV = i6;
        this.aMl.setColor(i6);
    }

    public void setProgressColor(@ColorInt int i6) {
        this.aLW = i6;
        this.aMm.setColor(i6);
    }

    public void setSecondaryProgress(int i6) {
        int i7 = this.aLZ;
        if (i6 <= i7 || i6 >= (i7 = this.aMa)) {
            i6 = i7;
        }
        this.aMi = i6;
        this.aMq.right = (int) j(dQ(i6));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i6) {
        this.aLX = i6;
        this.aMn.setColor(i6);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aMs = drawable;
    }

    public void setThumbEnable(boolean z5) {
        this.aMw = z5;
    }

    public void setThumbScale(float f6) {
        this.aME = f6;
    }

    public void setThumbTouchOffset(int i6) {
        this.aMf = i6;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.aMa = 100;
        this.aMd = false;
        this.aMs = null;
        this.aMt = false;
        this.aMu = false;
        this.aMv = false;
        this.aMw = true;
        this.aMz = true;
        this.aMA = false;
        this.aME = 1.0f;
        this.aMF = 1.34f;
        this.aMG = 1.0f;
        this.aMH = 2.0f;
        init(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f6 = rect.top;
        float f7 = this.aMG;
        rect2.top = (int) (f6 * f7);
        rect2.bottom = (int) (rect.bottom * f7);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aMb * this.aMG);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    public int getProgressX() {
        return (int) (getX() + (this.aLY * this.aMF));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aMk / 2, this.aMj / 2);
        a(canvas, this.aMo, this.aMl);
        a(canvas, this.aMq, this.aMn);
        a(canvas, this.aMp, this.aMm);
        if (this.aMJ) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        if (mode == 1073741824) {
            this.aMk = size;
        } else {
            this.aMk = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aMj = size2;
        } else {
            this.aMj = getHeight();
        }
        y(this.aMk, this.aMj);
        setMeasuredDimension(this.aMk, this.aMj);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x5 = motionEvent.getX() - (this.aMk / 2);
        float y5 = motionEvent.getY() - (this.aMj / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aMt || this.aMu)) {
                    a(dR((int) x5), false, true);
                }
            } else {
                this.aMx = false;
                if (this.aMu || this.aMt) {
                    this.aMu = false;
                    this.aMt = false;
                    a(dR((int) x5), this.aMA, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            if (!this.aMw) {
                return super.onTouchEvent(motionEvent);
            }
            if (c(x5, y5)) {
                bw(true);
                this.aMt = true;
                this.aMx = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.wd();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (d(x5, y5)) {
                bw(true);
                this.aMu = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.wd();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    private boolean c(float f6, float f7) {
        int i6;
        int i7;
        Rect rect = this.aMr;
        int i8 = rect.left;
        int i9 = rect.right;
        if (i8 >= i9 || (i6 = rect.top) >= (i7 = rect.bottom)) {
            return false;
        }
        float f8 = this.aME;
        int i10 = this.aMf;
        return f6 >= (((float) i8) * f8) - ((float) i10) && f6 <= (((float) i9) * f8) + ((float) i10) && f7 >= (((float) i6) * f8) - ((float) i10) && f7 <= (((float) i7) * f8) + ((float) i10);
    }

    private void a(int i6, boolean z5, boolean z6) {
        int i7 = this.aLZ;
        if (i6 <= i7 || i6 >= (i7 = this.aMa)) {
            i6 = i7;
        }
        i(z5, i6);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aMh != this.aMg) {
            this.aMv = z6;
            onSeekBarChangedListener.a(this, z6);
            this.aMv = false;
        }
        this.aMh = this.aMg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f6) {
        Rect rect = this.aMr;
        int i6 = this.aLY;
        rect.left = (int) (f6 - i6);
        rect.right = (int) (i6 + f6);
        this.aMp.right = (int) f6;
        invalidate();
    }
}
