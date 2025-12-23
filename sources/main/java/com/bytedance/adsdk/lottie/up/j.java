package com.bytedance.adsdk.lottie.up;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j extends ValueAnimator {

    /* renamed from: j, reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f23555j = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> xt = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> cw = new CopyOnWriteArraySet();

    void j(boolean z5) {
        for (Animator.AnimatorListener animatorListener : this.xt) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z5);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    void xt(boolean z5) {
        for (Animator.AnimatorListener animatorListener : this.xt) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z5);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.xt.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.cw.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f23555j.add(animatorUpdateListener);
    }

    void cw() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f23555j.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    void r() {
        Iterator<Animator.AnimatorPauseListener> it = this.cw.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.xt.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f23555j.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.xt.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.cw.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f23555j.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j6) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j6) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    void up() {
        Iterator<Animator.AnimatorPauseListener> it = this.cw.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }

    void j() {
        Iterator<Animator.AnimatorListener> it = this.xt.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void xt() {
        Iterator<Animator.AnimatorListener> it = this.xt.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }
}
