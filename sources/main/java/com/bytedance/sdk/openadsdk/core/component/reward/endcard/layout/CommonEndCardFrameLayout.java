package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.xt.xt;
import com.bytedance.sdk.openadsdk.res.up;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {
    private SSWebView cw;

    /* renamed from: m, reason: collision with root package name */
    private RewardLpBottomView f28261m;

    /* renamed from: r, reason: collision with root package name */
    private SSWebView f28262r;
    private FrameLayout up;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.f28262r;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.up;
    }

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void j() {
        setId(2114387548);
        if (!TextUtils.isEmpty(ln.tl(this.xt))) {
            SSWebView sSWebView = new SSWebView(this.f28260j);
            sSWebView.setMaterialMeta(rn.j(this.xt));
            sSWebView.setId(2114387703);
            sSWebView.setLayerType(2, null);
            sSWebView.setVisibility(4);
            this.cw = sSWebView;
            addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        }
        LinearLayout linearLayout = new LinearLayout(this.f28260j);
        linearLayout.setId(2114387547);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.f28260j);
        playableEndcardFrameLayout.setId(2114387681);
        SSWebView sSWebView2 = new SSWebView(this.f28260j);
        sSWebView2.setMaterialMeta(rn.j(this.xt));
        sSWebView2.setId(2114387865);
        sSWebView2.setLayerType(2, null);
        sSWebView2.setVisibility(4);
        this.f28262r = sSWebView2;
        playableEndcardFrameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this.f28260j);
        frameLayout.setId(2114387925);
        frameLayout.setVisibility(8);
        playableEndcardFrameLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        View xt = up.xt(this.f28260j);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2236963, -1});
        gradientDrawable.setShape(0);
        xt.setBackground(gradientDrawable);
        playableEndcardFrameLayout.addView(xt, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.f28260j);
        rewardLpBottomView.setId(2114387830);
        rewardLpBottomView.setVisibility(8);
        this.f28261m = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        playableEndcardFrameLayout.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(playableEndcardFrameLayout, layoutParams2);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.f28260j);
        frameLayout2.setId(2114387804);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.up = frameLayout2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void xt() {
        super.xt();
        RewardLpBottomView rewardLpBottomView = this.f28261m;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.xt();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(xt xtVar) {
    }
}
