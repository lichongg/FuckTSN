package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
interface MotionStrategy {
    void addAnimationListener(@NonNull Animator.AnimatorListener animatorListener);

    AnimatorSet createAnimator();

    MotionSpec getCurrentMotionSpec();

    @AnimatorRes
    int getDefaultMotionSpecResource();

    List<Animator.AnimatorListener> getListeners();

    @Nullable
    MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);

    void onChange(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void performNow();

    void removeAnimationListener(@NonNull Animator.AnimatorListener animatorListener);

    void setMotionSpec(@Nullable MotionSpec motionSpec);

    boolean shouldCancel();
}
