package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.cw {

    /* renamed from: j, reason: collision with root package name */
    private boolean f25703j;

    private String j(boolean z5) {
        String j6 = kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.jy.oq().getType())) {
            return j6;
        }
        if (com.bytedance.sdk.component.adexpress.r.j() && this.f25703j) {
            j6 = "X";
        }
        return z5 ? j6 : "| ".concat(String.valueOf(j6));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.jy.oq().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ae, this.tl);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.az.setTextAlignment(1);
            ((TextView) this.az).setGravity(17);
        } else {
            super.up();
        }
        if (!"skip-with-time-skip-btn".equals(this.jy.oq().getType())) {
            this.az.setTextAlignment(1);
            ((TextView) this.az).setGravity(17);
        }
        setVisibility(8);
    }

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f25703j = dynamicRootView.getRenderRequest().av();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (TextUtils.isEmpty(((TextView) this.az).getText())) {
            setMeasuredDimension(0, this.tl);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        if (TextUtils.equals(this.jy.oq().getType(), "skip-with-time-skip-btn")) {
            ((TextView) this.az).setText("");
            return true;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        int i7 = 0;
        if (z5) {
            ((TextView) this.az).setText(j(z6));
        } else {
            if (z6) {
                ((TextView) this.az).setText(j(z6));
            }
            if (!z6) {
                i7 = 8;
            }
        }
        setVisibility(i7);
    }
}
