package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CircleSkipView extends KSFrameLayout implements b {
    private int JA;
    private ValueAnimator JB;
    private boolean JC;
    private SkipView.a JD;
    private long JE;
    private float JF;
    private float Jy;
    private float Jz;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean vX;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void nl() {
        this.JC = true;
        ValueAnimator valueAnimator = this.JB;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.JE);
            this.JB.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm() {
        this.JC = false;
        ValueAnimator valueAnimator = this.JB;
        if (valueAnimator != null) {
            this.JE = valueAnimator.getCurrentPlayTime();
            this.JB.cancel();
        }
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void O(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        af(context);
        addView(ag(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.JD != null) {
                    CircleSkipView.this.JD.me();
                }
            }
        });
    }

    private void af(Context context) {
        this.JA = com.kwad.sdk.c.a.a.a(context, 2.0f);
        int a6 = com.kwad.sdk.c.a.a.a(context, 32.0f);
        int i6 = this.JA;
        this.radius = a6 - i6;
        this.padding = i6 / 2;
        int i7 = this.padding;
        int i8 = this.radius;
        this.mRectF = new RectF(i7, i7, i8 + i7, i8 + i7);
    }

    private static TextView ag(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i6) {
        SkipView.a aVar = this.JD;
        if (aVar != null) {
            aVar.am(i6);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // java.lang.Runnable
            public final void run() {
                CircleSkipView.this.nm();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(SkipView.a aVar) {
        this.JD = aVar;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPaint = new Paint();
        this.Jy = 270.0f;
        this.Jz = 360.0f;
        this.radius = 0;
        this.JA = 0;
        this.JC = false;
        this.JE = 0L;
        this.JF = 0.0f;
        this.padding = 0;
        this.vX = true;
        O(context);
    }

    private void c(final int i6, final boolean z5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.JB = ofFloat;
        ofFloat.setDuration(i6);
        this.JB.setInterpolator(new LinearInterpolator());
        this.JB.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.JF != 1.0f || CircleSkipView.this.JD == null) {
                    return;
                }
                CircleSkipView.this.JD.mf();
            }
        });
        this.JB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.JF = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.al((int) ((i6 / 1000) * circleSkipView.JF));
                if (z5) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f6 = floatValue * 360.0f;
                    CircleSkipView.this.Jy = 270.0f - f6;
                    CircleSkipView.this.Jz = 360.0f - f6;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.JA);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.JA);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        nl();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ao(int i6) {
        getLayoutParams().height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void cq() {
        nm();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.JA, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.JC) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.Jy, -this.Jz, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z5) {
        circleSkipView.JC = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.vX = com.kwad.sdk.core.response.b.a.cD(adInfo);
        boolean cE = com.kwad.sdk.core.response.b.a.cE(adInfo);
        if (this.vX) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, cE);
    }
}
