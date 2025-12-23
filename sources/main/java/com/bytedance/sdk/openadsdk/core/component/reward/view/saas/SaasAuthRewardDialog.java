package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.c;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tl.cw;
import com.bytedance.sdk.openadsdk.g.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    private static boolean oq;
    private n ae;
    private ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private int f28470g;

    /* renamed from: j, reason: collision with root package name */
    private SaasAuthEnvelope f28471j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28472m;

    /* renamed from: r, reason: collision with root package name */
    private RotateAnimation f28473r;
    private String tl;
    private ScaleAnimation up;
    private BaseSaasEnvelope xt;

    private static class j implements av {
        private j() {
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(2)
        public void j(int i6, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(1)
        public void j(qv qvVar) {
        }
    }

    private void cw() {
        try {
            if (oq) {
                return;
            }
            j jVar = new j();
            xt.j(cw.j("saas_light_shine.webp")).j(jVar);
            xt.j(cw.j("saas_red_envelope.webp")).j(jVar);
            xt.j(cw.j("saas_reward_goods_bg.webp")).j(jVar);
            xt.j(cw.j("saas_reward_coupon_bg.webp")).j(jVar);
            xt.j(cw.j("saas_reward_title.webp")).j(jVar);
            oq = true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        this.f28472m = true;
        c yx = this.ae.yx();
        if (yx.oq() != null) {
            this.xt = new SaasAuthCouponEnvelope(getContext(), yx.oq());
        } else if (yx.qv() != null) {
            this.xt = new SaasAuthProductEnvelope(getContext(), yx.qv());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.xt;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.xt.j();
            com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(getContext(), this.ae, this.tl, this.f28470g);
            setTag(67108864, 2917);
            com.bytedance.sdk.component.qv.up.j.j().j(this.ae.hashCode() + this.ae.ej()).put("live_saas_interaction_type", 101);
            setOnClickListener(jVar);
            this.xt.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.j();
                }
            });
            this.xt.setOnButtonClickListener(jVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.f28471j;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.xt();
        }
        removeView(this.f28471j);
    }

    public SaasAuthRewardDialog(@NonNull Context context) {
        super(context);
        this.f28472m = false;
        j(context);
    }

    public void j(n nVar, String str, int i6) {
        if (nVar != null && com.bytedance.sdk.openadsdk.core.live.xt.j().cw() == 2) {
            c yx = nVar.yx();
            if (yx != null && ((yx.qv() != null || yx.oq() != null) && yx.g())) {
                this.ae = nVar;
                this.tl = str;
                this.f28470g = i6;
                setBackgroundColor(Color.parseColor("#aa000000"));
                tl.xt().postDelayed(this, 5000L);
                j(getContext());
                cw();
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rn.xt(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() != 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.up = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.up.setFillAfter(true);
            this.up.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SaasAuthRewardDialog.this.f28473r = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                    SaasAuthRewardDialog.this.f28473r.setDuration(5000L);
                    SaasAuthRewardDialog.this.f28473r.setRepeatCount(-1);
                    SaasAuthRewardDialog.this.f28473r.setFillAfter(true);
                    SaasAuthRewardDialog.this.f28473r.setInterpolator(new LinearInterpolator());
                    SaasAuthRewardDialog.this.cw.startAnimation(SaasAuthRewardDialog.this.f28473r);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.cw.startAnimation(this.up);
            rn.xt(true);
            setVisibility(0);
            this.f28471j.j();
            tl.xt().postDelayed(this, 2000L);
            return;
        }
        if (!this.f28472m) {
            tl.xt().postDelayed(this, 5000L);
            xt();
        } else {
            setVisibility(8);
        }
    }

    private void j(Context context) {
        this.cw = new ImageView(context);
        try {
            xt.j(cw.j("saas_light_shine.webp")).j(this.cw);
            this.cw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int r5 = ed.r(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r5, r5);
        layoutParams.addRule(13);
        addView(this.cw, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.f28471j = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387470);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.f28471j, layoutParams2);
        this.f28471j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.xt();
                tl.xt().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.f28471j.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.j();
            }
        });
    }

    public void j() {
        SaasAuthEnvelope saasAuthEnvelope = this.f28471j;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.xt();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.xt;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.xt();
        }
        RotateAnimation rotateAnimation = this.f28473r;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.f28473r = null;
        }
        ScaleAnimation scaleAnimation = this.up;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.up = null;
        }
        tl.xt().removeCallbacks(this);
        setVisibility(8);
        rn.xt(false);
    }
}
