package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl implements ae {

    /* renamed from: j, reason: collision with root package name */
    private PressButtonInteractView f25763j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25763j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PressButtonInteractView cw() {
        return this.f25763j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25763j.xt();
    }

    public vl(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.f25763j = new PressButtonInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 8388629;
        this.f25763j.setLayoutParams(layoutParams);
    }
}
