package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av implements ae {
    private DynamicBaseWidget cw;

    /* renamed from: j, reason: collision with root package name */
    private SlideRightView f25721j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.cw.ae f25722r;
    private Context xt;

    private void r() {
        this.f25721j = new SlideRightView(this.xt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.xt, 120.0f));
        layoutParams.gravity = 17;
        this.f25721j.setLayoutParams(layoutParams);
        this.f25721j.setClipChildren(false);
        this.f25721j.setGuideText(this.f25722r.q());
        DynamicBaseWidget dynamicBaseWidget = this.cw;
        if (dynamicBaseWidget != null) {
            this.f25721j.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public ViewGroup cw() {
        return this.f25721j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        SlideRightView slideRightView = this.f25721j;
        if (slideRightView != null) {
            slideRightView.j();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        SlideRightView slideRightView = this.f25721j;
        if (slideRightView != null) {
            slideRightView.xt();
        }
    }

    public av(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this.xt = context;
        this.cw = dynamicBaseWidget;
        this.f25722r = aeVar;
        r();
    }
}
