package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements up {

    /* renamed from: j, reason: collision with root package name */
    ObjectAnimator f25649j;
    private int kt;
    private Runnable tj;
    ObjectAnimator xt;

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final View childAt = getChildAt(this.kt);
        final View childAt2 = getChildAt((this.kt + 1) % getChildCount());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.tl + getChildAt(this.kt).getHeight())) / 2);
        this.f25649j = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f25649j.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.tl + childAt2.getHeight()) / 2, 0.0f);
        this.xt = ofFloat2;
        ofFloat2.setInterpolator(new LinearInterpolator());
        this.xt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.f25649j.setDuration(500L);
        this.xt.setDuration(500L);
        this.f25649j.start();
        this.xt.start();
        int i6 = this.kt + 1;
        this.kt = i6;
        this.kt = i6 % getChildCount();
        postDelayed(this.tj, 2000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up
    public void xt() {
        removeCallbacks(this.tj);
        ObjectAnimator objectAnimator = this.f25649j;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f25649j.cancel();
        }
        ObjectAnimator objectAnimator2 = this.xt;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.xt.cancel();
        }
        super.xt();
    }

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.kt = 0;
        this.tj = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseScrollWidgetImp.this.g();
            }
        };
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.tl - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i6 != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.tj, 2500L);
    }
}
