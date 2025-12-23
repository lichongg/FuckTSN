package com.bxkj.base.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.orhanobut.logger.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ViewSwitcher extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private static final int f17201d = 500;

    /* renamed from: e, reason: collision with root package name */
    private static final String f17202e = "translationY";

    /* renamed from: f, reason: collision with root package name */
    private static final int f17203f = 60;

    /* renamed from: a, reason: collision with root package name */
    private Context f17204a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f17205b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnClickListener f17206c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17207a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f17208b;

        a(int i6, View view) {
            this.f17207a = i6;
            this.f17208b = view;
        }

        public void a(int i6) {
            ObjectAnimator ofFloat;
            j.c("onClickFirstCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = ViewSwitcher.this.getChildAt(i8);
                if (childAt.getVisibility() == 0) {
                    if (i7 == i6) {
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f17202e, ViewSwitcher.f(ViewSwitcher.this.f17204a, (ViewSwitcher.this.getRealChildCount() - 1) * (-60)), 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.g(i7, this.f17208b, childCount));
                    } else {
                        float f6 = ViewSwitcher.f(ViewSwitcher.this.f17204a, (i7 - 1) * 60);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f17202e, childAt.getY() - f6, (childAt.getY() - f6) - ViewSwitcher.f(ViewSwitcher.this.f17204a, 60.0f));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i7++;
                }
            }
            animatorSet.start();
        }

        public void b() {
            ObjectAnimator ofFloat;
            j.c("onClickFirstCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = ViewSwitcher.this.getChildAt(i7);
                if (childAt.getVisibility() == 0) {
                    if (i6 == 0) {
                        float f6 = ViewSwitcher.f(ViewSwitcher.this.f17204a, (ViewSwitcher.this.getRealChildCount() - 1) * (-60));
                        j.c("onClickFirstCard-downFactor=" + f6);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f17202e, f6, 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.g(i6, this.f17208b, childCount));
                    } else {
                        float f7 = ViewSwitcher.f(ViewSwitcher.this.f17204a, (i6 - 1) * 60);
                        j.c("onClickFirstCard-upFactor=" + f7);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f17202e, childAt.getY() - f7, (childAt.getY() - f7) - ((float) ViewSwitcher.f(ViewSwitcher.this.f17204a, 60.0f)));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i6++;
                }
            }
            animatorSet.start();
        }

        public void c(int i6, View view) {
            ObjectAnimator ofFloat;
            j.c("onClickOtherCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i7 = 0;
            for (int i8 = i6; i8 < childCount; i8++) {
                View childAt = ViewSwitcher.this.getChildAt(i8);
                if (childAt.getVisibility() == 0) {
                    if (i7 == i6) {
                        float f6 = ViewSwitcher.f(ViewSwitcher.this.f17204a, ((ViewSwitcher.this.getRealChildCount() - i7) - 1) * (-60));
                        j.c("onClickOtherCard-downFactor=" + f6);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f17202e, f6, 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.g(i7, view, childCount));
                    } else {
                        float f7 = ViewSwitcher.f(ViewSwitcher.this.f17204a, (i7 - 1) * 60);
                        j.c("onClickOtherCard-upFactor=" + f7);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f17202e, childAt.getY() - f7, (childAt.getY() - f7) - ((float) ViewSwitcher.f(ViewSwitcher.this.f17204a, 60.0f)));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i7++;
                }
            }
            animatorSet.start();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewSwitcher.this.f17205b) {
                return;
            }
            if (this.f17207a != ViewSwitcher.this.getRealChildCount() - 1) {
                ViewSwitcher.this.f17205b = true;
                a(this.f17207a);
            } else if (ViewSwitcher.this.f17206c != null) {
                ViewSwitcher.this.f17206c.onClick(this.f17208b);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f17210a;

        b(View view) {
            this.f17210a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewSwitcher.this.f17205b = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ViewSwitcher.this.removeView(this.f17210a);
            ViewSwitcher.this.addView(this.f17210a);
        }

        private void a(View view) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public ViewSwitcher(Context context) {
        this(context, null);
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener g(int i6, View view, int i7) {
        return new b(view);
    }

    private View.OnClickListener h(View view, int i6) {
        return new a(i6, view);
    }

    public View.OnClickListener getClickListener() {
        return this.f17206c;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f17206c = onClickListener;
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f17204a = context;
    }

    public static int f(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getRealChildCount() {
        int childCount = super.getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null && childAt.getVisibility() == 0) {
                i6++;
            }
        }
        return i6;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0) {
                measureChild(childAt, i6, i7);
                int measuredHeight = childAt.getMeasuredHeight();
                if (i9 != 0) {
                    measuredHeight = f(this.f17204a, 60.0f);
                }
                i8 += measuredHeight;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, f(this.f17204a, i10), 0, 0);
                childAt.setLayoutParams(layoutParams);
                childAt.setOnClickListener(h(childAt, i9));
                i9++;
                i10 += 60;
            }
        }
        super.onMeasure(i6, i8);
    }
}
