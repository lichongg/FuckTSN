package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistance;
    private final float maxScaleYDistance;

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        if (super.onUpdateBackProgress(backEventCompat) == null) {
            return;
        }
        updateBackProgress(backEventCompat.getProgress());
    }

    private Animator createResetScaleAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v5 = this.view;
        if (v5 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v5;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i6), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        return animatorSet;
    }

    public void finishBackProgressNotPersistent(@NonNull BackEventCompat backEventCompat, @Nullable Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_Y, this.view.getHeight() * this.view.getScaleY());
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.getProgress()));
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialBottomContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MaterialBottomContainerBackHelper.this.view.setTranslationY(0.0f);
                MaterialBottomContainerBackHelper.this.updateBackProgress(0.0f);
            }
        });
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public MaterialBottomContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistance = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        Animator createResetScaleAnimator = createResetScaleAnimator();
        createResetScaleAnimator.setDuration(this.cancelDuration);
        createResetScaleAnimator.start();
    }

    public void finishBackProgressPersistent(@NonNull BackEventCompat backEventCompat, @Nullable Animator.AnimatorListener animatorListener) {
        Animator createResetScaleAnimator = createResetScaleAnimator();
        createResetScaleAnimator.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.getProgress()));
        if (animatorListener != null) {
            createResetScaleAnimator.addListener(animatorListener);
        }
        createResetScaleAnimator.start();
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        super.onStartBackProgress(backEventCompat);
    }

    @VisibleForTesting
    public void updateBackProgress(float f6) {
        float interpolateProgress = interpolateProgress(f6);
        float width = this.view.getWidth();
        float height = this.view.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f7 = this.maxScaleXDistance / width;
        float f8 = this.maxScaleYDistance / height;
        float lerp = 1.0f - AnimationUtils.lerp(0.0f, f7, interpolateProgress);
        float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, f8, interpolateProgress);
        this.view.setScaleX(lerp);
        this.view.setPivotY(height);
        this.view.setScaleY(lerp2);
        V v5 = this.view;
        if (v5 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v5;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                View childAt = viewGroup.getChildAt(i6);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(lerp2 != 0.0f ? lerp / lerp2 : 1.0f);
            }
        }
    }
}
