package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements up {

    /* renamed from: f, reason: collision with root package name */
    private Runnable f25704f;

    /* renamed from: j, reason: collision with root package name */
    ObjectAnimator f25705j;
    private int kt;
    private boolean tj;
    ObjectAnimator xt;

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final View view;
        final View childAt = getChildAt(this.kt);
        int i6 = this.kt;
        if (i6 == 0) {
            this.tj = false;
        }
        boolean z5 = i6 + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.kt + 1)).getChildCount() <= 0;
        if (this.jy.oq().up().j() || !z5) {
            View childAt2 = z5 ? getChildAt((this.kt + 2) % getChildCount()) : getChildAt((this.kt + 1) % getChildCount());
            this.f25705j = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.tl + getChildAt(this.kt).getHeight())) / 2);
            if (z5) {
                this.kt++;
            }
            view = childAt2;
        } else {
            this.tj = true;
            view = getChildAt(this.kt - 1);
            this.f25705j = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (this.tl + getChildAt(this.kt).getHeight()) / 2);
        }
        this.f25705j.setInterpolator(new LinearInterpolator());
        this.f25705j.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.2
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
        if (this.tj) {
            this.xt = ObjectAnimator.ofFloat(view, "translationY", (-(this.tl + view.getHeight())) / 2, 0.0f);
        } else {
            this.xt = ObjectAnimator.ofFloat(view, "translationY", (this.tl + view.getHeight()) / 2, 0.0f);
        }
        this.xt.setInterpolator(new LinearInterpolator());
        this.xt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setVisibility(0);
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
        this.f25705j.setDuration(500L);
        this.xt.setDuration(500L);
        this.f25705j.start();
        this.xt.start();
        if (this.tj) {
            this.kt--;
        } else {
            int i7 = this.kt + 1;
            this.kt = i7;
            this.kt = i7 % getChildCount();
        }
        postDelayed(this.f25704f, 3000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up
    public void xt() {
        removeCallbacks(this.f25704f);
        ObjectAnimator objectAnimator = this.f25705j;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f25705j.cancel();
        }
        ObjectAnimator objectAnimator2 = this.xt;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.xt.cancel();
        }
        super.xt();
    }

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.kt = 0;
        this.tj = false;
        this.f25704f = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.g();
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
        postDelayed(this.f25704f, 2500L);
    }
}
