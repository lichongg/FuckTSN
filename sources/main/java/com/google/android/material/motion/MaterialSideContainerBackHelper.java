package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat, @GravityInt int i6) {
        if (super.onUpdateBackProgress(backEventCompat) == null) {
            return;
        }
        updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, i6);
    }

    private boolean checkAbsoluteGravity(@GravityInt int i6, @GravityInt int i7) {
        return (GravityCompat.getAbsoluteGravity(i6, ViewCompat.getLayoutDirection(this.view)) & i7) == i7;
    }

    private int getEdgeMargin(boolean z5) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z5 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public MaterialSideContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistanceShrink = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v5 = this.view;
        if (v5 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v5;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i6), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.cancelDuration);
        animatorSet.start();
    }

    public void finishBackProgress(@NonNull BackEventCompat backEventCompat, @GravityInt final int i6, @Nullable Animator.AnimatorListener animatorListener, @Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z5;
        if (backEventCompat.getSwipeEdge() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i6, 3);
        float width = (this.view.getWidth() * this.view.getScaleX()) + getEdgeMargin(checkAbsoluteGravity);
        V v5 = this.view;
        Property property = View.TRANSLATION_X;
        if (checkAbsoluteGravity) {
            width = -width;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v5, (Property<V, Float>) property, width);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.getProgress()));
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialSideContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper.this.view.setTranslationX(0.0f);
                MaterialSideContainerBackHelper.this.updateBackProgress(0.0f, z5, i6);
            }
        });
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        super.onStartBackProgress(backEventCompat);
    }

    @VisibleForTesting
    public void updateBackProgress(float f6, boolean z5, @GravityInt int i6) {
        int i7;
        float interpolateProgress = interpolateProgress(f6);
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i6, 3);
        boolean z6 = z5 == checkAbsoluteGravity;
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        float f7 = width;
        if (f7 > 0.0f) {
            float f8 = height;
            if (f8 <= 0.0f) {
                return;
            }
            float f9 = this.maxScaleXDistanceShrink / f7;
            float f10 = this.maxScaleXDistanceGrow / f7;
            float f11 = this.maxScaleYDistance / f8;
            V v5 = this.view;
            if (checkAbsoluteGravity) {
                f7 = 0.0f;
            }
            v5.setPivotX(f7);
            if (!z6) {
                f10 = -f9;
            }
            float lerp = AnimationUtils.lerp(0.0f, f10, interpolateProgress);
            float f12 = lerp + 1.0f;
            this.view.setScaleX(f12);
            float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, f11, interpolateProgress);
            this.view.setScaleY(lerp2);
            V v6 = this.view;
            if (v6 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v6;
                for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                    View childAt = viewGroup.getChildAt(i8);
                    if (checkAbsoluteGravity) {
                        i7 = (width - childAt.getRight()) + childAt.getWidth();
                    } else {
                        i7 = -childAt.getLeft();
                    }
                    childAt.setPivotX(i7);
                    childAt.setPivotY(-childAt.getTop());
                    float f13 = z6 ? 1.0f - lerp : 1.0f;
                    float f14 = lerp2 != 0.0f ? (f12 / lerp2) * f13 : 1.0f;
                    childAt.setScaleX(f13);
                    childAt.setScaleY(f14);
                }
            }
        }
    }
}
