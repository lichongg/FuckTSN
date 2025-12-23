package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.acse.ottn.u;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardLpBottomView extends LinearLayout {
    private RewardLandingPageAppInfoView cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28464j;
    private SlideUpLoadMoreArrow xt;

    public void xt() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.xt) != null) {
            slideUpLoadMoreArrow.xt();
            this.xt.setVisibility(8);
        }
    }

    private void cw() {
        this.xt = new SlideUpLoadMoreArrow(getContext(), this.f28464j ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.xt, layoutParams);
    }

    private void r() {
        if (this.cw == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.cw == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.cw.getMeasuredHeight();
                View findViewById = RewardLpBottomView.this.getRootView().findViewById(2114387664);
                if (findViewById == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = measuredHeight;
                    findViewById.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    public void j(n nVar, String str) {
        if (nVar == null) {
            return;
        }
        this.f28464j = j(nVar);
        cw();
        if (!kt.cw(nVar)) {
            xt(nVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, u.f5359f}));
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.cw;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }

    public RewardLpBottomView(Context context) {
        super(context);
        this.f28464j = false;
    }

    private void xt(n nVar, String str) {
        if (this.f28464j) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.cw = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.j(nVar, str);
            addView(this.cw, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private boolean j(n nVar) {
        return nVar.jl() == 4;
    }

    public void j() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.xt;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.j();
        }
        r();
    }
}
