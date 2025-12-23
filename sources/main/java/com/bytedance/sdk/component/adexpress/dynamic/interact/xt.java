package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements ae {

    /* renamed from: j, reason: collision with root package name */
    private CircleLongPressView f25769j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25769j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public CircleLongPressView cw() {
        return this.f25769j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25769j.xt();
    }

    public xt(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.f25769j = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 180.0f));
        layoutParams.gravity = 17;
        this.f25769j.setLayoutParams(layoutParams);
        this.f25769j.setGuideText(aeVar.q());
    }
}
