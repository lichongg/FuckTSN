package com.scwang.smartrefresh.layout.footer.ballpulse;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BallPulseView extends View {

    /* renamed from: i, reason: collision with root package name */
    public static final int f37346i = 50;

    /* renamed from: a, reason: collision with root package name */
    private Paint f37347a;

    /* renamed from: b, reason: collision with root package name */
    private int f37348b;

    /* renamed from: c, reason: collision with root package name */
    private int f37349c;

    /* renamed from: d, reason: collision with root package name */
    private float f37350d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f37351e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f37352f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<ValueAnimator> f37353g;

    /* renamed from: h, reason: collision with root package name */
    private Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f37354h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37355a;

        a(int i6) {
            this.f37355a = i6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseView.this.f37351e[this.f37355a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BallPulseView.this.postInvalidate();
        }
    }

    public BallPulseView(Context context) {
        this(context, null);
    }

    public BallPulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        this.f37353g = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (int i6 = 0; i6 < 3; i6++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i6]);
            this.f37354h.put(ofFloat, new a(i6));
            this.f37353g.add(ofFloat);
        }
    }

    private boolean c() {
        return this.f37352f;
    }

    public void d() {
        if (this.f37353g == null) {
            b();
        }
        if (this.f37353g == null || c()) {
            return;
        }
        for (int i6 = 0; i6 < this.f37353g.size(); i6++) {
            ValueAnimator valueAnimator = this.f37353g.get(i6);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f37354h.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.f37352f = true;
        setIndicatorColor(this.f37349c);
    }

    public void e() {
        ArrayList<ValueAnimator> arrayList = this.f37353g;
        if (arrayList != null && this.f37352f) {
            this.f37352f = false;
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
            this.f37351e = new float[]{1.0f, 1.0f, 1.0f};
        }
        setIndicatorColor(this.f37348b);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int b6 = c.b(50.0f);
        setMeasuredDimension(View.resolveSize(b6, i6), View.resolveSize(b6, i7));
    }

    public void setAnimatingColor(@ColorInt int i6) {
        this.f37349c = i6;
    }

    public void setIndicatorColor(@ColorInt int i6) {
        this.f37347a.setColor(i6);
    }

    public void setNormalColor(@ColorInt int i6) {
        this.f37348b = i6;
    }

    public BallPulseView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37348b = -1118482;
        this.f37349c = -1615546;
        this.f37351e = new float[]{1.0f, 1.0f, 1.0f};
        this.f37352f = false;
        this.f37354h = new HashMap();
        this.f37350d = c.b(4.0f);
        Paint paint = new Paint();
        this.f37347a = paint;
        paint.setColor(-1);
        this.f37347a.setStyle(Paint.Style.FILL);
        this.f37347a.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f37353g != null) {
            for (int i6 = 0; i6 < this.f37353g.size(); i6++) {
                this.f37353g.get(i6).cancel();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float min = (Math.min(getWidth(), getHeight()) - (this.f37350d * 2.0f)) / 6.0f;
        float f6 = 2.0f * min;
        float width = (getWidth() / 2) - (this.f37350d + f6);
        float height = getHeight() / 2;
        for (int i6 = 0; i6 < 3; i6++) {
            canvas.save();
            float f7 = i6;
            canvas.translate((f6 * f7) + width + (this.f37350d * f7), height);
            float f8 = this.f37351e[i6];
            canvas.scale(f8, f8);
            canvas.drawCircle(0.0f, 0.0f, min, this.f37347a);
            canvas.restore();
        }
    }
}
