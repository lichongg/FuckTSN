package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv implements ae {

    /* renamed from: j, reason: collision with root package name */
    private HandLongPressView f25762j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public ViewGroup cw() {
        return this.f25762j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25762j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25762j.xt();
    }

    public qv(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.f25762j = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 180.0f));
        layoutParams.gravity = 17;
        this.f25762j.setLayoutParams(layoutParams);
        this.f25762j.setGuideText(aeVar.q());
    }
}
