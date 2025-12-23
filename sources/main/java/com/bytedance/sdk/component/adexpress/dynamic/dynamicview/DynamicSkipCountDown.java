package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicSkipCountDown extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.cw {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        if (i6 != 0) {
            ((TextView) this.az).setText(" | " + String.format(kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_reward_full_skip_count_down"), Integer.valueOf(i6)));
        } else if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        requestLayout();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ae, this.tl);
        int i6 = this.f25656g;
        layoutParams.leftMargin = i6;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(i6);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (TextUtils.isEmpty(((TextView) this.az).getText())) {
            setMeasuredDimension(0, this.tl);
        }
    }
}
