package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends i<ClickSlideUpView> {
    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.f25724j = new ClickSlideUpView(this.xt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.xt, aeVar.z());
        this.f25724j.setLayoutParams(layoutParams);
        this.f25724j.setSlideText(this.f25725r.q());
        SlideUpView slideUpView = this.f25724j;
        if (slideUpView instanceof ClickSlideUpView) {
            ((ClickSlideUpView) slideUpView).setButtonText(this.f25725r.oq());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.i, com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25724j.xt();
    }

    public r(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        super(context, dynamicBaseWidget, aeVar);
        j(aeVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.i, com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25724j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.i
    protected void r() {
    }
}
