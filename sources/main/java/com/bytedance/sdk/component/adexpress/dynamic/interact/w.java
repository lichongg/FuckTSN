package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class w implements ae<DynamicUnlockView> {

    /* renamed from: j, reason: collision with root package name */
    private final DynamicUnlockView f25764j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        DynamicUnlockView dynamicUnlockView = this.f25764j;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.j();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView cw() {
        return this.f25764j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        DynamicUnlockView dynamicUnlockView = this.f25764j;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.xt();
        }
    }

    public w(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        int i6;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.f25764j = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (aeVar.z() > 0) {
            i6 = aeVar.z();
        } else if (com.bytedance.sdk.component.adexpress.r.j()) {
            i6 = 0;
        } else {
            i6 = 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, i6);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(aeVar.q());
    }
}
