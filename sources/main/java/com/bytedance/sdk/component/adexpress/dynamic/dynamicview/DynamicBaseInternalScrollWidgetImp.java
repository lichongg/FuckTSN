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
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements up {

    /* renamed from: f, reason: collision with root package name */
    private Runnable f25644f;

    /* renamed from: j, reason: collision with root package name */
    ObjectAnimator f25645j;
    private int kt;
    private boolean tj;
    ObjectAnimator xt;

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final View childAt;
        final View childAt2 = getChildAt(this.kt);
        int i6 = this.kt;
        if (i6 == 0) {
            this.tj = false;
        }
        if (i6 + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.kt + 1)).getChildCount() <= 0) {
            this.tj = true;
            childAt = getChildAt(this.kt - 1);
            this.f25645j = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.ae + getChildAt(this.kt).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.kt + 1);
            this.f25645j = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.ae + getChildAt(this.kt).getWidth())) / 2);
        }
        this.f25645j.setInterpolator(new LinearInterpolator());
        this.f25645j.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
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
            this.xt = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.ae + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.xt = ObjectAnimator.ofFloat(childAt, "translationX", (this.ae + childAt.getWidth()) / 2, 0.0f);
        }
        this.xt.setInterpolator(new LinearInterpolator());
        this.xt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
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
        this.f25645j.setDuration(500L);
        this.xt.setDuration(500L);
        this.f25645j.start();
        this.xt.start();
        if (this.tj) {
            this.kt--;
        } else {
            this.kt++;
        }
        postDelayed(this.f25644f, 2000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up
    public void xt() {
        removeCallbacks(this.f25644f);
        ObjectAnimator objectAnimator = this.f25645j;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f25645j.cancel();
        }
        ObjectAnimator objectAnimator2 = this.xt;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.xt.cancel();
        }
        super.xt();
    }

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.kt = 0;
        this.tj = false;
        this.f25644f = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.g();
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
        postDelayed(this.f25644f, 2500L);
    }
}
