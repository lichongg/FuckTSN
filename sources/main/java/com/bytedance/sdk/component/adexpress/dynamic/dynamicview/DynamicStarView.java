package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {

    /* renamed from: j, reason: collision with root package name */
    private int f25697j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ae, this.tl);
        layoutParams.topMargin = this.oq;
        int i6 = this.f25656g + this.f25697j;
        layoutParams.leftMargin = i6;
        layoutParams.setMarginStart(i6);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.f25697j = 0;
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context, null);
        this.az = tTRatingBar2;
        tTRatingBar2.setTag(Integer.valueOf(getClickArea()));
        addView(this.az, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int j6 = (int) ((com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.up()) * 5.0f) + com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw() + com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.r())));
        if (this.ae > j6 && 4 == this.vl.tl()) {
            this.f25697j = (this.ae - j6) / 2;
        }
        this.ae = j6;
        return new FrameLayout.LayoutParams(this.ae, this.tl);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        double d6;
        DynamicRootView dynamicRootView;
        super.tl();
        double jy = this.vl.jy();
        if (com.bytedance.sdk.component.adexpress.r.j() && (jy < 0.0d || jy > 5.0d || ((dynamicRootView = this.ws) != null && dynamicRootView.getRenderRequest() != null && this.ws.getRenderRequest().jy() != 4))) {
            this.az.setVisibility(8);
            return true;
        }
        if (jy >= 0.0d && jy <= 5.0d) {
            d6 = jy;
        } else {
            d6 = 5.0d;
        }
        this.az.setVisibility(0);
        ((TTRatingBar2) this.az).j(d6, this.vl.ae(), (int) this.vl.up(), ((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.xt())) + ((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.j())) + ((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.up())));
        return true;
    }
}
