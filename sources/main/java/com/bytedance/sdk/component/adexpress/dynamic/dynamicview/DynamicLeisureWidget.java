package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicLeisureWidget extends DynamicBaseWidgetImp {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        this.ae = 0;
        this.tl = 0;
        return super.getWidgetLayoutParams();
    }

    public DynamicLeisureWidget(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
    }
}
