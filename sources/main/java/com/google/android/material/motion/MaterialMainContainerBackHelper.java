package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private static final float MIN_SCALE = 0.9f;

    @Nullable
    private Integer expandedCornerSize;

    @Nullable
    private Rect initialHideFromClipBounds;

    @Nullable
    private Rect initialHideToClipBounds;
    private float initialTouchY;
    private final float maxTranslationY;
    private final float minEdgeGap;

    private boolean isAtTopOfScreen() {
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private void resetInitialValues() {
        this.initialTouchY = 0.0f;
        this.initialHideToClipBounds = null;
        this.initialHideFromClipBounds = null;
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat, @Nullable View view) {
        super.onStartBackProgress(backEventCompat);
        startBackProgress(backEventCompat.getTouchY(), view);
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat, @Nullable View view, float f6) {
        if (super.onUpdateBackProgress(backEventCompat) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, backEventCompat.getTouchY(), f6);
    }

    @NonNull
    private AnimatorSet createResetScaleAndTranslationAnimator(@Nullable final View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialMainContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view2 = view;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r0 = r4.view.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getMaxDeviceCornerRadius() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 0
            if (r0 < r1) goto L2f
            V extends android.view.View r0 = r4.view
            android.view.WindowInsets r0 = com.bytedance.sdk.openadsdk.core.i.j.b.a(r0)
            if (r0 == 0) goto L2f
            int r1 = r4.getRoundedCornerRadius(r0, r2)
            r2 = 1
            int r2 = r4.getRoundedCornerRadius(r0, r2)
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 3
            int r2 = r4.getRoundedCornerRadius(r0, r2)
            r3 = 2
            int r0 = r4.getRoundedCornerRadius(r0, r3)
            int r0 = java.lang.Math.max(r2, r0)
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        L2f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.motion.MaterialMainContainerBackHelper.getMaxDeviceCornerRadius():int");
    }

    public int getExpandedCornerSize() {
        if (this.expandedCornerSize == null) {
            this.expandedCornerSize = Integer.valueOf(isAtTopOfScreen() ? getMaxDeviceCornerRadius() : 0);
        }
        return this.expandedCornerSize.intValue();
    }

    @Nullable
    public Rect getInitialHideFromClipBounds() {
        return this.initialHideFromClipBounds;
    }

    @Nullable
    public Rect getInitialHideToClipBounds() {
        return this.initialHideToClipBounds;
    }

    public MaterialMainContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.minEdgeGap = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.maxTranslationY = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    @NonNull
    private ValueAnimator createCornerAnimator(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), getExpandedCornerSize());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.motion.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClippableRoundedCornerLayout.this.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    @RequiresApi(31)
    private int getRoundedCornerRadius(WindowInsets windowInsets, int i6) {
        RoundedCorner roundedCorner;
        int radius;
        roundedCorner = windowInsets.getRoundedCorner(i6);
        if (roundedCorner != null) {
            radius = roundedCorner.getRadius();
            return radius;
        }
        return 0;
    }

    public void cancelBackProgress(@Nullable View view) {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet createResetScaleAndTranslationAnimator = createResetScaleAndTranslationAnimator(view);
        V v5 = this.view;
        if (v5 instanceof ClippableRoundedCornerLayout) {
            createResetScaleAndTranslationAnimator.playTogether(createCornerAnimator((ClippableRoundedCornerLayout) v5));
        }
        createResetScaleAndTranslationAnimator.setDuration(this.cancelDuration);
        createResetScaleAndTranslationAnimator.start();
        resetInitialValues();
    }

    public void finishBackProgress(long j6, @Nullable View view) {
        AnimatorSet createResetScaleAndTranslationAnimator = createResetScaleAndTranslationAnimator(view);
        createResetScaleAndTranslationAnimator.setDuration(j6);
        createResetScaleAndTranslationAnimator.start();
        resetInitialValues();
    }

    @VisibleForTesting
    public void startBackProgress(float f6, @Nullable View view) {
        this.initialHideToClipBounds = ViewUtils.calculateRectFromBounds(this.view);
        if (view != null) {
            this.initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(this.view, view);
        }
        this.initialTouchY = f6;
    }

    @VisibleForTesting
    public void updateBackProgress(float f6, boolean z5, float f7, float f8) {
        float width = this.view.getWidth();
        float height = this.view.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float lerp = AnimationUtils.lerp(1.0f, 0.9f, f6);
        float lerp2 = AnimationUtils.lerp(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.minEdgeGap), f6) * (z5 ? 1 : -1);
        float min = Math.min(Math.max(0.0f, ((height - (lerp * height)) / 2.0f) - this.minEdgeGap), this.maxTranslationY);
        float f9 = f7 - this.initialTouchY;
        float lerp3 = AnimationUtils.lerp(0.0f, min, Math.abs(f9) / height) * Math.signum(f9);
        this.view.setScaleX(lerp);
        this.view.setScaleY(lerp);
        this.view.setTranslationX(lerp2);
        this.view.setTranslationY(lerp3);
        V v5 = this.view;
        if (v5 instanceof ClippableRoundedCornerLayout) {
            ((ClippableRoundedCornerLayout) v5).updateCornerRadius(AnimationUtils.lerp(getExpandedCornerSize(), f8, f6));
        }
    }
}
