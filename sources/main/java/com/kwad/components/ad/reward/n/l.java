package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l extends s implements View.OnClickListener {
    private ImageView CF;
    private TextView CG;
    private View CH;
    private Set<ImageView> CI = new HashSet();
    private TextView CJ;
    private Animator CK;
    private TextView fu;
    private TextView fv;
    private TextView fw;
    private ImageView ig;
    private com.kwad.components.ad.reward.g tm;

    static /* synthetic */ Animator a(l lVar, View view) {
        return t(view);
    }

    private void initView() {
        ViewGroup viewGroup = this.vV;
        if (viewGroup == null) {
            return;
        }
        this.CG = (TextView) viewGroup.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.CF = (ImageView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.ig = (ImageView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.fu = (TextView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.fv = (TextView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.fw = (TextView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.CH = this.vV.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.CI.add(imageView);
        this.CI.add(imageView2);
        this.CI.add(imageView3);
        this.CJ = (TextView) this.vV.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.vV.setOnClickListener(this);
        this.fw.setOnClickListener(this);
    }

    private void lk() {
        this.CG.postDelayed(new bg() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                l lVar = l.this;
                lVar.CK = l.a(lVar, lVar.CG, 100L, 8.0f);
                l.this.CK.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.CK != null) {
                            l.this.CK.start();
                        }
                    }
                });
                l.this.CK.start();
            }
        }, 500L);
    }

    private void ll() {
        bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                l lVar = l.this;
                l.a(lVar, lVar.CH).start();
            }
        }, 2000L);
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.fw)) {
            this.tm.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.vV)) {
            this.tm.a(1, view.getContext(), 53, 2);
        }
    }

    public l(com.kwad.components.ad.reward.g gVar) {
        this.tm = gVar;
    }

    static /* synthetic */ Animator a(l lVar, View view, long j6, float f6) {
        return a(view, 100L, 8.0f);
    }

    private static Animator t(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void ac(boolean z5) {
        super.ac(z5);
        Context context = this.vV.getContext();
        if (!aq.QW()) {
            ViewGroup.LayoutParams layoutParams = this.vV.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.vV.setLayoutParams(layoutParams);
        }
    }

    public final void lj() {
        lk();
        ll();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.CK;
        if (animator != null) {
            animator.cancel();
            this.CK = null;
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.S(adTemplate));
        }
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.fu.setText(aVar.getTitle());
        this.fv.setText(aVar.ir());
        this.fw.setText(aVar.io());
        String ho = aVar.ho();
        Drawable drawable = this.ig.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.ig, ho, drawable);
        String aE = com.kwad.components.ad.e.b.aE();
        if (!bp.isNullString(aE)) {
            KSImageLoader.loadImage(this.CF, aE, aVar.ii());
        }
        if (aVar.ip()) {
            this.CH.setVisibility(0);
            String in = aVar.in();
            if (!TextUtils.isEmpty(in)) {
                this.CJ.setText(String.format("%s已预约直播", in));
            }
            if (aVar.iq() != null) {
                List<String> iq = aVar.iq();
                int i6 = 0;
                for (ImageView imageView : this.CI) {
                    if (i6 < iq.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, iq.get(i6), drawable);
                    }
                    i6++;
                }
                return;
            }
            return;
        }
        this.CH.setVisibility(8);
    }

    private static Animator a(View view, long j6, float f6) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f6).setDuration(j6);
        float f7 = -f6;
        long j7 = j6 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f6, f7).setDuration(j7);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f7, f6).setDuration(j7);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f6, f7).setDuration(j7);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f7, 0.0f).setDuration(j6));
        return animatorSet;
    }
}
