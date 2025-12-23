package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.cw {

    /* renamed from: j, reason: collision with root package name */
    private int f25696j;
    private int kt;
    private int xt;

    private void g() {
        List<tl> qv = this.jy.qv();
        if (qv == null || qv.size() <= 0) {
            return;
        }
        for (tl tlVar : qv) {
            if (tlVar.oq().j() == 21) {
                this.f25696j = (int) (this.ae - com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, tlVar.tl()));
            }
            if (tlVar.oq().j() == 20) {
                this.xt = (int) (this.ae - com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, tlVar.tl()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        this.kt = i6;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i6 = this.f25656g;
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = this.oq;
        layoutParams.setMarginStart(i6);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        g();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.kt == 0) {
            setMeasuredDimension(this.xt, this.tl);
        } else {
            setMeasuredDimension(this.f25696j, this.tl);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.xt()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.r()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.j()));
        return true;
    }
}
