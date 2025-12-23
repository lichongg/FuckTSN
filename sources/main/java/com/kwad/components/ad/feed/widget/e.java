package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends FrameLayout {

    /* renamed from: if, reason: not valid java name */
    private View f3if;
    private ImageView ig;

    @Nullable
    private Animator ih;
    private com.kwad.sdk.widget.d ij;

    public e(@NonNull Context context) {
        this(context, null);
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animator c(final View view, int i6) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i6 / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.h(view, e.this.ij);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator cB() {
        View view = this.f3if;
        if (view == null || this.ig == null || view.getWidth() + this.f3if.getHeight() == 0 || this.ig.getWidth() + this.ig.getHeight() == 0) {
            return null;
        }
        Animator cC = cC();
        Animator a6 = a(this.ig, 100L, 16.0f);
        Animator cD = cD();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(cC, a6, cD);
        return animatorSet;
    }

    private Animator cC() {
        Animator c6 = c(this.f3if, com.kwad.sdk.c.a.a.a(getContext(), 128.0f));
        Animator c7 = c(this.ig, com.kwad.sdk.c.a.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(c6, c7);
        return animatorSet;
    }

    private Animator cD() {
        Animator g6 = g(this.f3if);
        Animator g7 = g(this.ig);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(g6, g7);
        return animatorSet;
    }

    private Animator g(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.o.m.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.f3if = findViewById(R.id.ksad_feed_shake_bg);
        this.ig = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.d dVar) {
        this.ij = dVar;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, 0);
        init(context);
    }

    @MainThread
    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
            this.ih = null;
        }
        this.ig.post(new bg() { // from class: com.kwad.components.ad.feed.widget.e.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                e eVar = e.this;
                eVar.ih = eVar.cB();
                if (e.this.ih == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                } else {
                    e.this.ih.addListener(animatorListenerAdapter);
                    e.this.ih.start();
                }
            }
        });
    }

    private Animator a(View view, long j6, float f6) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.ig.setPivotX(view.getWidth());
        this.ig.setPivotY(view.getHeight());
        Animator a6 = com.kwad.components.core.t.o.a(view, create, 100L, 16.0f);
        Animator a7 = com.kwad.components.core.t.o.a(view, create, 100L, 16.0f);
        Animator a8 = com.kwad.components.core.t.o.a(view, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a6, a7, a8);
        return animatorSet;
    }
}
