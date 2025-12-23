package com.bxkj.base.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f16556a;

        a(View view) {
            this.f16556a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f16556a.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f16558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f16559b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f16558a = true;
        }

        b(View view) {
            this.f16559b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f16558a) {
                return;
            }
            this.f16559b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f16559b.setVisibility(0);
            this.f16558a = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, int i6, int i7, int i8, int i9) {
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, i6, i7, i8, i9);
        if (i7 > 10 && floatingActionButton.getVisibility() == 0) {
            hide(floatingActionButton);
        } else {
            if (i7 >= -10 || floatingActionButton.getVisibility() == 0) {
                return;
            }
            show(floatingActionButton);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, View view2, int i6) {
        return i6 == 2 || super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, view2, i6);
    }

    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
    }

    private void hide(View view) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(new FastOutLinearInInterpolator()).setListener(new b(view));
    }

    private void show(View view) {
        view.animate().cancel();
        view.setAlpha(0.0f);
        view.setScaleY(0.0f);
        view.setScaleX(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new a(view));
    }
}
