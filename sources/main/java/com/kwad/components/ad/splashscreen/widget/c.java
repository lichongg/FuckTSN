package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c extends KSFrameLayout {
    private Animator qc;
    private boolean qd;

    public c(@NonNull Context context) {
        this(context, null, 0);
    }

    protected void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
    }

    protected abstract Animator fN();

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected abstract void nu();

    protected abstract void nv();

    public final void nw() {
        this.qd = true;
        Animator animator = this.qc;
        if (animator != null) {
            animator.cancel();
        }
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @MainThread
    public final void fM() {
        Animator animator = this.qc;
        if (animator != null) {
            animator.cancel();
            this.qc = null;
        }
        Animator fN = fN();
        this.qc = fN;
        if (fN != null) {
            fN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.nv();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.qd) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (c.this.qc != null) {
                                c.this.qc.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }
            });
            this.qc.start();
        }
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.qd = false;
        a(context, attributeSet, i6);
        nu();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        Animator animator = this.qc;
        if (animator != null) {
            animator.cancel();
        }
    }
}
