package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy implements ae<PressInteractView> {

    /* renamed from: j, reason: collision with root package name */
    private PressInteractView f25755j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25755j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PressInteractView cw() {
        return this.f25755j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25755j.xt();
    }

    public jy(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.f25755j = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 20.0f);
        this.f25755j.setLayoutParams(layoutParams);
        this.f25755j.setGuideText(aeVar.q());
    }
}
