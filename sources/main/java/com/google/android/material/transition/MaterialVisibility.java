package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders = new ArrayList();
    private final P primaryAnimatorProvider;

    @Nullable
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    @AttrRes
    int getDurationThemeAttrResId(boolean z5) {
        return 0;
    }

    @AttrRes
    int getEasingThemeAttrResId(boolean z5) {
        return 0;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    private static void addAnimatorIfNeeded(List<Animator> list, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z5) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        Animator createAppear = z5 ? visibilityAnimatorProvider.createAppear(viewGroup, view) : visibilityAnimatorProvider.createDisappear(viewGroup, view);
        if (createAppear != null) {
            list.add(createAppear);
        }
    }

    private Animator createAnimator(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z5) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z5);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z5);
        Iterator<VisibilityAnimatorProvider> it = this.additionalAnimatorProviders.iterator();
        while (it.hasNext()) {
            addAnimatorIfNeeded(arrayList, it.next(), viewGroup, view, z5);
        }
        maybeApplyThemeValues(viewGroup.getContext(), z5);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    @NonNull
    TimeInterpolator getDefaultEasingInterpolator(boolean z5) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    protected MaterialVisibility(P p5, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p5;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    private void maybeApplyThemeValues(@NonNull Context context, boolean z5) {
        TransitionUtils.maybeApplyThemeDuration(this, context, getDurationThemeAttrResId(z5));
        TransitionUtils.maybeApplyThemeInterpolator(this, context, getEasingThemeAttrResId(z5), getDefaultEasingInterpolator(z5));
    }
}
