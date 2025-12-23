package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class AnimatorTracker {

    @Nullable
    private Animator currentAnimator;

    public void clear() {
        this.currentAnimator = null;
    }

    public void cancelCurrent() {
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    AnimatorTracker() {
    }

    public void onNextAnimationStart(Animator animator) {
        cancelCurrent();
        this.currentAnimator = animator;
    }
}
