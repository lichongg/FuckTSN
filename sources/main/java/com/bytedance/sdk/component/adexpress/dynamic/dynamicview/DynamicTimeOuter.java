package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.r.qv;
import com.bytedance.sdk.component.adexpress.r.ae;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.cw {

    /* renamed from: j, reason: collision with root package name */
    private boolean f25699j;
    private boolean kt;
    private boolean xt;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        if (z6 || this.kt) {
            ((TextView) this.az).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z5 && this.ws.getRenderRequest().cw() && ae.xt(this.ws.getRenderRequest().m())) {
            if (com.bytedance.sdk.component.adexpress.r.j()) {
                ((TextView) this.az).setText(i6 + "s");
            } else {
                ((TextView) this.az).setText(String.format(kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_reward_full_skip"), Integer.valueOf(i6)));
            }
            this.f25699j = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.r.j() && !"open_ad".equals(this.ws.getRenderRequest().m()) && this.ws.getRenderRequest().cw()) {
            this.kt = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.jy.oq().getType())) {
            ((TextView) this.az).setText(charSequence);
            return;
        }
        ((TextView) this.az).setText(((Object) charSequence) + "s");
        this.xt = true;
        if (this.f25699j) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (qv.xt(((TextView) this.az).getText() != null ? r5.toString() : "", this.vl.up(), true)[0] + tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw() + this.vl.r())), this.tl);
            layoutParams.gravity = 8388629;
            this.az.setLayoutParams(layoutParams);
            this.f25699j = false;
            requestLayout();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.jy.oq().getType()) && !TextUtils.equals("skip-with-time-countdown", this.jy.oq().getType())) {
            super.up();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ae, this.tl);
        layoutParams.gravity = 8388627;
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            layoutParams.leftMargin = this.f25656g;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        super(context, dynamicRootView, tlVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(tlVar.oq().getType())) {
            dynamicRootView.setTimedown(this.tl);
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
        if (ae.xt(this.ws.getRenderRequest().m())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.jy.oq().getType())) {
            ((TextView) this.az).setText(String.valueOf((int) Double.parseDouble(this.vl.oq())));
            return true;
        }
        ((TextView) this.az).setText(((int) Double.parseDouble(this.vl.oq())) + "s");
        return true;
    }
}
