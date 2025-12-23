package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.cw {

    /* renamed from: j, reason: collision with root package name */
    private int[] f25695j;
    private int kt;
    private int xt;

    private void g() {
        int j6 = (int) tl.j(this.qv, this.vl.up());
        this.xt = ((this.tl - j6) / 2) - this.vl.j();
        this.kt = 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ae, this.tl);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        super(context, dynamicRootView, tlVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    @SuppressLint({"SetTextI18n"})
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        String j6 = kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_reward_screen_skip_tx");
        if (i6 == 0) {
            this.az.setVisibility(0);
            ((TextView) this.az).setText("| ".concat(String.valueOf(j6)));
            this.az.measure(-2, -2);
            this.f25695j = new int[]{this.az.getMeasuredWidth() + 1, this.az.getMeasuredHeight()};
            View view = this.az;
            int[] iArr = this.f25695j;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.az).setGravity(17);
            ((TextView) this.az).setIncludeFontPadding(false);
            g();
            this.az.setPadding(this.vl.cw(), this.xt, this.vl.r(), this.kt);
        }
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (TextUtils.isEmpty(((TextView) this.az).getText())) {
            setMeasuredDimension(0, this.tl);
        } else {
            setMeasuredDimension(this.ae, this.tl);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        ((TextView) this.az).setText("");
        return true;
    }
}
