package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    abstract void cancelAnimatorImmediately();

    protected float getFractionInRange(int i6, int i7, int i8) {
        return (i6 - i7) / i8;
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    abstract void requestCancelAnimatorAfterCurrentCycle();

    abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();

    protected void registerDrawable(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    protected IndeterminateAnimatorDelegate(int i6) {
        this.segmentPositions = new float[i6 * 2];
        this.segmentColors = new int[i6];
    }
}
