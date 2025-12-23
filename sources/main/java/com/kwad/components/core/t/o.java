package com.kwad.components.core.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o {
    public static Animator a(View view, @Nullable Interpolator interpolator, long j6, float f6) {
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = interpolator == null ? PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f) : interpolator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(300L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f6).setDuration(j6);
        float f7 = -f6;
        long j7 = j6 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f6, f7).setDuration(j7);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f7, f6).setDuration(j7);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f6, f7).setDuration(j7);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f7, 0.0f).setDuration(j6));
        return animatorSet;
    }

    public static ValueAnimator h(final View view, final boolean z5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(z5 ? 0.0f : 1.0f, z5 ? 1.0f : 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.0f, 0.6f, 1.0f));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.t.o.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.t.o.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!z5) {
                    view.setAlpha(0.0f);
                    view.setVisibility(8);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z5) {
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                }
            }
        });
        return ofFloat;
    }

    public static ValueAnimator b(final View view, int i6, final int i7) {
        k(view, i6);
        ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.t.o.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.k(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.t.o.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                o.k(view, i7);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                o.k(view, i7);
            }
        });
        return ofInt;
    }

    public static ValueAnimator c(final View view, int i6, int i7) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.t.o.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(View view, int i6) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i6;
        view.setLayoutParams(layoutParams);
    }

    public static Animator a(View view, @Nullable Interpolator interpolator, float f6, float f7) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", f6, f7);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(create);
        return ofFloat;
    }
}
