package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicRoot extends DynamicBaseWidgetImp {

    /* renamed from: j, reason: collision with root package name */
    public xt f25688j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected xt j(Bitmap bitmap) {
        j jVar = new j(bitmap, this.f25688j);
        this.f25688j = jVar;
        return jVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable getDrawable() {
        xt xtVar = new xt();
        this.f25688j = xtVar;
        return xtVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable j(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        xt xtVar = new xt(orientation, iArr);
        this.f25688j = xtVar;
        return xtVar;
    }

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        return super.tl();
    }
}
