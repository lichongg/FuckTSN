package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends s implements View.OnClickListener {
    private TextView ko;
    private com.kwad.components.ad.reward.g tm;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void iG();
    }

    public final void a(final a aVar, long j6) {
        final Animator s5 = s(this.vV);
        if (s5 == null) {
            aVar.iG();
        } else {
            s5.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.g.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.iG();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.iG();
                    }
                }
            });
            this.vV.postDelayed(new bg() { // from class: com.kwad.components.ad.reward.n.g.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    s5.start();
                }
            }, 500L);
        }
    }

    private static Animator s(View view) {
        if (view == null) {
            return null;
        }
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_card_tips_animation_y);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", -dimensionPixelSize).setDuration(500L);
        duration.setInterpolator(create);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(2500L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f).setDuration(500L);
        duration3.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_card_tips_view, R.id.ksad_card_tips_root);
        if (this.ko == null) {
            this.ko = (TextView) this.vV.findViewById(R.id.ksad_card_tips_title);
        }
        this.vV.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.s, com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.vV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.vV)) {
            com.kwad.components.ad.reward.g gVar = this.tm;
            gVar.a(1, gVar.mContext, 1, 1);
        }
    }

    public g(com.kwad.components.ad.reward.g gVar) {
        this.tm = gVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        String str;
        TextView textView;
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate == null || (str = com.kwad.sdk.core.response.b.b.dt(adTemplate).title) == null || (textView = this.ko) == null) {
            return;
        }
        textView.setText(str);
    }
}
