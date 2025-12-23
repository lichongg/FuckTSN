package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardGuideSlideUp extends RelativeLayout {
    private final AnimatorSet ae;
    private ImageView cw;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f28191j;

    /* renamed from: m, reason: collision with root package name */
    private final AnimatorSet f28192m;

    /* renamed from: r, reason: collision with root package name */
    private AnimatorSet f28193r;
    private final AnimatorSet up;
    private ImageView xt;

    private void j(Context context) {
        if (context == null) {
            context = v.getContext();
        }
        addView(com.bytedance.sdk.openadsdk.res.up.oq(context));
        this.f28191j = (ImageView) findViewById(2114387650);
        this.xt = (ImageView) findViewById(2114387945);
        this.cw = (ImageView) findViewById(2114387645);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f28193r;
    }

    public void xt() {
        try {
            AnimatorSet animatorSet = this.f28193r;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f28192m;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.up;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.ae;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable th) {
            vl.cw(th.getMessage());
        }
    }

    public RewardGuideSlideUp(Context context) {
        super(context);
        this.up = new AnimatorSet();
        this.f28192m = new AnimatorSet();
        this.ae = new AnimatorSet();
        j(context);
    }

    public void j() {
        this.f28193r = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f28191j, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f28191j, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f28191j, "translationY", 0.0f, ed.cw(getContext(), -110.0f));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ed.cw(getContext(), 110.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RewardGuideSlideUp.this.xt.getLayoutParams();
                layoutParams.height = num.intValue();
                RewardGuideSlideUp.this.xt.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.xt, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.xt, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.cw, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.cw, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.cw, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.cw, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.cw, "translationY", 0.0f, ed.cw(getContext(), -110.0f));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.up.setDuration(50L);
        this.ae.setDuration(3000L);
        this.f28192m.setDuration(50L);
        this.up.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.f28192m.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.ae.playTogether(ofFloat3, ofInt, ofFloat10);
        this.f28193r.playSequentially(this.f28192m, this.ae, this.up);
    }
}
