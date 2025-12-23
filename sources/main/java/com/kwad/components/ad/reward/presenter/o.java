package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o extends b implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private static long vU = 300;
    private ImageView ig;
    private ViewGroup vV;
    private TextView vW;
    private boolean vX;
    private float vY;
    private WeakReference<View> vZ;
    private r wa;
    private boolean wb = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            o.this.hide();
        }
    };

    private synchronized void iI() {
        if (this.wb) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.tm.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().df(192).aw(this.tm.rE.getPlayDuration()));
        this.wb = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator iJ() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.vV, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.ig.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.vW, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(vU);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.vV;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.ig = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.vW = (TextView) this.vV.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.vV.setOnClickListener(this);
    }

    public final void I(boolean z5) {
        ViewGroup viewGroup = this.vV;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        iI();
        WeakReference<View> weakReference = this.vZ;
        if (weakReference != null && weakReference.get() != null) {
            a(this.vZ.get().getLayoutParams());
        }
        this.vV.setVisibility(0);
        if (z5) {
            this.vV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.iJ().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.vZ = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        com.kwad.sdk.core.d.c.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    public final void hide() {
        ViewGroup viewGroup = this.vV;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.vV;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.a.gg().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.adlog.c.e(this.tm.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(192).aw(this.tm.rE.getPlayDuration()));
    }

    public o(r rVar) {
        this.wa = rVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.vV == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            if (viewStub != null) {
                this.vV = (ViewGroup) viewStub.inflate();
            } else {
                this.vV = (ViewGroup) findViewById(R.id.ksad_playable_pre_tips_root);
            }
            initView();
        }
        if (this.tm.gO()) {
            a(new ViewGroup.LayoutParams(-1, this.vV.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.tm.rG.a(this);
        }
        this.tm.b(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        boolean z5;
        super.onCreate();
        this.vY = com.kwad.components.ad.reward.a.b.hF();
        if (!com.kwad.components.ad.reward.a.b.hH() && com.kwad.components.ad.reward.a.b.hG()) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.vX = z5;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this.mPlayEndPageListener);
        this.tm.rG.b(this);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.vV.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.vV.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.vV.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.vZ;
                    View view = weakReference != null ? weakReference.get() : null;
                    int i6 = marginLayoutParams2.height;
                    if (i6 <= 0 && view != null) {
                        i6 = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i6 + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.vV.setLayoutParams(marginLayoutParams);
        }
    }
}
