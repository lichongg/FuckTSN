package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ViewPagerIndicator extends View {
    private float lA;
    private Paint lB;
    private float lC;
    private float lD;
    private float lE;
    private int lF;
    private Paint lG;
    private float lH;
    private a lI;
    private ValueAnimator lJ;
    private int lr;
    private int lw;
    private int lx;
    private int ly;
    private float lz;
    private final Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void I(int i6);
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(final int i6) {
        if (this.lF <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.lE, this.lD);
        this.lJ = ofFloat;
        ofFloat.setDuration(this.lF * 1000);
        this.lJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.lH = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.lJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (ViewPagerIndicator.this.lI != null) {
                    ViewPagerIndicator.this.lI.I(i6);
                }
            }
        });
        this.lJ.start();
    }

    private void dE() {
        Paint paint = new Paint(1);
        this.lB = paint;
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        this.lB.setStrokeWidth(1.0f);
        this.lB.setColor(this.lx);
        Paint paint2 = new Paint(1);
        this.lG = paint2;
        paint2.setStyle(style);
        this.lG.setStrokeWidth(1.0f);
        this.lG.setColor(this.lw);
    }

    @RequiresApi(api = 19)
    public final void dF() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void dG() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    public void setAdShowTime(int i6) {
        this.lF = i6;
    }

    public void setPlayProgressListener(a aVar) {
        this.lI = aVar;
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i6);
        dE();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                size2 = (int) this.lC;
            } else {
                size2 = 0;
            }
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                if (this.ly > 1) {
                    size = (int) (this.lD + ((r6 - 1) * (this.lA + this.lE)));
                } else {
                    size = (int) this.lD;
                }
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            this.ly = count;
            if (count <= 1) {
                return;
            }
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageScrolled(int i6, float f6, int i7) {
                    ViewPagerIndicator.this.lH = 0.0f;
                    ViewPagerIndicator.this.lr = i6;
                    ViewPagerIndicator.this.lz = f6;
                    ViewPagerIndicator.this.invalidate();
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageSelected(int i6) {
                    ViewPagerIndicator.this.lr = i6;
                    ViewPagerIndicator.this.lz = 1.0f;
                    ViewPagerIndicator.this.invalidate();
                    if (i6 < ViewPagerIndicator.this.ly - 1) {
                        ViewPagerIndicator.this.K(i6);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageScrollStateChanged(int i6) {
                }
            });
            K(this.lr);
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i6, 0);
        this.lA = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.a.a.a(this.mContext, 5.0f));
        this.lC = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.lD = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.a.a.a(this.mContext, 50.0f));
        this.lE = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.lx = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.lw = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        obtainStyledAttributes.recycle();
    }

    private void b(Canvas canvas) {
        if (this.lH > 0.0f) {
            int i6 = this.lr;
            float f6 = this.lA;
            float f7 = this.lE;
            RectF rectF = new RectF(i6 * (f6 + f7), 0.0f, (i6 * (f6 + f7)) + this.lH, this.lC);
            float f8 = this.lC;
            canvas.drawRoundRect(rectF, f8 / 2.0f, f8 / 2.0f, this.lG);
        }
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i6 = 0; i6 < this.ly; i6++) {
            int i7 = this.lr;
            if (i6 < i7 && i6 != i7 - 1) {
                float f6 = this.lA;
                float f7 = this.lE;
                float f8 = i6 * (f6 + f7);
                rectF.left = f8;
                rectF.right = f8 + f7;
                this.lB.setColor(this.lx);
            } else if (i6 == i7 - 1) {
                float f9 = this.lA;
                float f10 = this.lE;
                float f11 = i6 * (f9 + f10);
                rectF.left = f11;
                rectF.right = f11 + f10 + ((this.lD - f10) * (1.0f - this.lz));
                this.lB.setColor(this.lx);
            } else if (i6 == i7) {
                float f12 = i7 != 0 ? this.lz : 1.0f;
                float f13 = this.lA;
                float f14 = this.lE;
                float f15 = this.lD;
                float f16 = ((i6 - 1) * (f13 + f14)) + f14 + ((f15 - f14) * (1.0f - f12)) + f13;
                rectF.left = f16;
                rectF.right = f16 + (f12 * (f15 - f14)) + f14;
                this.lB.setColor(this.lx);
            } else {
                float f17 = this.lA;
                float f18 = this.lE;
                float f19 = ((i6 - 1) * (f17 + f18)) + f17 + this.lD;
                rectF.left = f19;
                rectF.right = f19 + f18;
                this.lB.setColor(this.lx);
            }
            rectF.top = 0.0f;
            float f20 = this.lC;
            rectF.bottom = 0.0f + f20;
            canvas.drawRoundRect(rectF, f20 / 2.0f, f20 / 2.0f, this.lB);
        }
    }
}
