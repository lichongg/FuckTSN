package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends i<ClickSlideUpView> {
    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.f25724j = new ClickSlideUpView2(this.xt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f25724j.setLayoutParams(layoutParams);
        SlideUpView slideUpView = this.f25724j;
        if (slideUpView instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) slideUpView).setButtonText(this.f25725r.q());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.i, com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25724j.xt();
    }

    public up(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
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
