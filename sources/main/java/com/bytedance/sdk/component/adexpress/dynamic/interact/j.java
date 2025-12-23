package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.BluePressInteractView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements ae {

    /* renamed from: j, reason: collision with root package name */
    private BluePressInteractView f25726j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public ViewGroup cw() {
        return this.f25726j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25726j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25726j.xt();
    }

    public j(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        double zz = aeVar.zz();
        zz = zz == 0.0d ? 1.0d : zz;
        double kc = aeVar.kc();
        int dynamicWidth = (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * zz);
        int dynamicWidth2 = (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * (kc != 0.0d ? kc : 1.0d));
        this.f25726j = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, aeVar.ff() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, aeVar.ry() - 3);
        this.f25726j.setLayoutParams(layoutParams);
    }
}
