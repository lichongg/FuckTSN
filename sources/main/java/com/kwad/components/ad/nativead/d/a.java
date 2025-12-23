package com.kwad.components.ad.nativead.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends KSFrameLayout {
    private Animator qc;
    private boolean qd;
    private ImageView qe;
    private ImageView qf;
    private ImageView qg;

    public a(@NonNull Context context) {
        this(context, null, 0);
    }

    private a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, null, 0);
        this.qd = false;
        O(context);
    }

    private void O(@NonNull Context context) {
        View a6 = m.a(context, R.layout.ksad_native_rotate_layout, this, true);
        this.qg = (ImageView) a6.findViewById(R.id.rotate_line);
        this.qe = (ImageView) a6.findViewById(R.id.rotate_phone);
        this.qf = (ImageView) a6.findViewById(R.id.rotate_alpha_phone);
    }

    private Animator fN() {
        View interactionView = getInteractionView();
        final View alphaView = getAlphaView();
        if (interactionView == null || alphaView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        AnimatorSet animatorSet3 = new AnimatorSet();
        AnimatorSet animatorSet4 = new AnimatorSet();
        alphaView.setPivotX(0.0f);
        alphaView.setPivotY(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotationY", 0.0f, 30.0f).setDuration(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.0f).setDuration(10L).setStartDelay(600L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.0f, 0.9f).setDuration(300L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(alphaView, "scaleY", 1.0f, 1.0f).setDuration(300L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotationY", 30.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.9f, 0.0f).setDuration(300L);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotationY", 0.0f, 0.0f).setDuration(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 0.0f, 1.0f).setDuration(10L).setStartDelay(280L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotationY", 0.0f, -30.0f).setDuration(300L);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.03f, 0.9f).setDuration(300L);
        duration8.setStartDelay(300L);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(interactionView, "rotationY", -30.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration10 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.9f, 0.0f).setDuration(300L);
        ObjectAnimator duration11 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration12 = ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.0f).setDuration(10L);
        duration12.setStartDelay(600L);
        ObjectAnimator duration13 = ObjectAnimator.ofFloat(interactionView, "rotationX", 0.0f, 30.0f).setDuration(300L);
        ObjectAnimator duration14 = ObjectAnimator.ofFloat(alphaView, "scaleX", -1.0f, -0.95f).setDuration(300L);
        duration14.setStartDelay(300L);
        ObjectAnimator duration15 = ObjectAnimator.ofFloat(alphaView, "scaleY", 0.02f, 0.87f).setDuration(300L);
        duration15.setStartDelay(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 0.0f, 1.0f).setDuration(10L);
        duration12.setStartDelay(280L);
        ObjectAnimator duration16 = ObjectAnimator.ofFloat(interactionView, "rotationX", 30.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration17 = ObjectAnimator.ofFloat(alphaView, "scaleX", -0.95f, -1.0f).setDuration(300L);
        ObjectAnimator duration18 = ObjectAnimator.ofFloat(alphaView, "scaleY", 0.87f, 0.02f).setDuration(300L);
        ObjectAnimator duration19 = ObjectAnimator.ofFloat(interactionView, "rotationX", 0.0f, 0.0f).setDuration(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.0f).setDuration(10L).setStartDelay(600L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 1.0f).setDuration(10L);
        animatorSet.playSequentially(duration, duration4, duration6, duration7, duration9, duration11, duration13, duration16, duration19);
        animatorSet2.playSequentially(duration2, duration5);
        animatorSet3.playSequentially(duration3);
        animatorSet4.playTogether(animatorSet, animatorSet2, animatorSet3);
        final AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.playSequentially(duration8, duration10);
        duration5.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.nativead.d.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                alphaView.setPivotX(r2.getWidth());
                alphaView.setPivotY(r2.getHeight());
                animatorSet5.start();
            }
        });
        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.playSequentially(duration15, duration18);
        AnimatorSet animatorSet7 = new AnimatorSet();
        animatorSet7.playSequentially(duration14, duration17);
        final AnimatorSet animatorSet8 = new AnimatorSet();
        animatorSet8.playTogether(animatorSet6, animatorSet7);
        duration10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.nativead.d.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                alphaView.setPivotX(r3.getWidth() / 2.0f);
                alphaView.setPivotY(r3.getHeight());
                animatorSet8.start();
            }
        });
        return animatorSet4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAlphaView() {
        return this.qf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getInteractionView() {
        return this.qe;
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
            fN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.nativead.d.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (a.this.qd) {
                        return;
                    }
                    a.this.getInteractionView().postDelayed(new bg() { // from class: com.kwad.components.ad.nativead.d.a.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (a.this.qc != null) {
                                a.this.getAlphaView().setPivotX(0.0f);
                                a.this.getAlphaView().setPivotY(0.0f);
                                a.this.qc.start();
                            }
                        }
                    }, a.this.getAnimationDelayTime());
                }
            });
            this.qc.start();
        }
    }

    protected final int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        try {
            getChildCount();
            int i10 = (i8 - i6) / 2;
            int i11 = (i9 - i7) / 2;
            int i12 = 0;
            View childAt = getChildAt(0);
            if (childAt instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) childAt;
                frameLayout.getChildCount();
                View childAt2 = frameLayout.getChildAt(0);
                if (childAt2 != null) {
                    i12 = childAt2.getMeasuredWidth();
                    childAt2.getMeasuredHeight();
                }
                int i13 = i12 / 100;
                View childAt3 = frameLayout.getChildAt(1);
                if (childAt3 != null) {
                    childAt3.getMeasuredWidth();
                    childAt3.getMeasuredHeight();
                    int i14 = i13 * 40;
                    childAt3.layout(i10 - i14, i11 - (i13 * 30), i14 + i10, i11 - (i13 * 10));
                }
                View childAt4 = frameLayout.getChildAt(2);
                if (childAt4 != null) {
                    childAt4.getMeasuredWidth();
                    childAt4.getMeasuredHeight();
                    int i15 = i13 * 14;
                    childAt4.layout(i10 - i15, i11 - i15, i15 + i10, (i13 * 30) + i11);
                }
                View childAt5 = frameLayout.getChildAt(3);
                if (childAt5 != null) {
                    childAt5.getMeasuredWidth();
                    childAt5.getMeasuredHeight();
                    int i16 = i13 * 14;
                    childAt5.layout(i10 - i16, i11 - i16, i10 + i16, i11 + (i13 * 30));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
