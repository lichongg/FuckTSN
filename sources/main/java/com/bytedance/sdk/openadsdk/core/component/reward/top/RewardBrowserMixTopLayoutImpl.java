package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements j<RewardBrowserMixTopLayoutImpl> {
    private xt cw;

    /* renamed from: j, reason: collision with root package name */
    private View f28406j;

    /* renamed from: r, reason: collision with root package name */
    private n f28407r;
    private Context up;
    private View xt;

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void j(boolean z5, String str, String str2, boolean z6, boolean z7) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void xt() {
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void r() {
        ed.j(this.f28406j, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.cw);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                ws.j().j(RewardBrowserMixTopLayoutImpl.this.f28407r, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.cw != null) {
                    RewardBrowserMixTopLayoutImpl.this.cw.j(view);
                }
            }
        }, "top_skip_border");
        ed.j(this.xt, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.cw != null) {
                    RewardBrowserMixTopLayoutImpl.this.cw.cw(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void cw() {
        View view = this.xt;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public View getCloseButton() {
        return this.f28406j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public boolean getSkipOrCloseVisible() {
        return ed.r(this.f28406j);
    }

    public xt getTopListener() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setListener(xt xtVar) {
        this.cw = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setVisible(boolean z5) {
        setVisibility(z5 ? 0 : 8);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.up = context;
    }

    public RewardBrowserMixTopLayoutImpl j(n nVar) {
        this.f28407r = nVar;
        addView(com.bytedance.sdk.openadsdk.res.up.ae(getContext()));
        this.f28406j = findViewById(2114387875);
        View findViewById = findViewById(2114387459);
        this.xt = findViewById(2114387460);
        if (kt.jy(nVar)) {
            this.f28406j = findViewById(2114387875);
            this.xt.setVisibility(8);
            findViewById.setVisibility(8);
            com.bytedance.sdk.component.utils.kt.j(this.up, "tt_ad_skip_btn_bg", this.f28406j);
        } else if (kt.ws(nVar)) {
            findViewById(2114387744).setVisibility(8);
            this.f28406j = findViewById(2114387875);
        } else {
            this.f28406j = findViewById(2114387719);
            this.xt.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if (this.f28406j != null) {
            if (nVar.az()) {
                this.f28406j.setVisibility(8);
            } else {
                this.f28406j.setVisibility(0);
                this.f28406j.setEnabled(true);
                this.f28406j.setClickable(true);
            }
        }
        r();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void j() {
        View view = this.f28406j;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setDislikeLeft(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowAgain(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowBack(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowDislike(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowSound(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setSoundMute(boolean z5) {
    }
}
