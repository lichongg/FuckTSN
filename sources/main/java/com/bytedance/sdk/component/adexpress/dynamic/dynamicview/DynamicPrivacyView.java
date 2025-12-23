package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.ae;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {

    /* renamed from: f, reason: collision with root package name */
    private TextView f25685f;

    /* renamed from: j, reason: collision with root package name */
    private TextView f25686j;
    private TextView kt;
    private TextView tj;

    /* renamed from: v, reason: collision with root package name */
    private LinearLayout f25687v;
    private TextView xt;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected boolean cw() {
        this.f25686j.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.f25686j.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.xt.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.xt.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.kt.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.kt.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.ae, this.tl);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        this.kt.setText("功能");
        this.xt.setText("权限");
        this.tj.setText(" | ");
        this.f25685f.setText(" | ");
        this.f25686j.setText("隐私");
        ae aeVar = this.vl;
        if (aeVar != null) {
            this.kt.setTextColor(aeVar.ae());
            this.kt.setTextSize(this.vl.up());
            this.xt.setTextColor(this.vl.ae());
            this.xt.setTextSize(this.vl.up());
            this.tj.setTextColor(this.vl.ae());
            this.f25685f.setTextColor(this.vl.ae());
            this.f25686j.setTextColor(this.vl.ae());
            this.f25686j.setTextSize(this.vl.up());
            return false;
        }
        this.kt.setTextColor(-1);
        this.kt.setTextSize(12.0f);
        this.xt.setTextColor(-1);
        this.xt.setTextSize(12.0f);
        this.tj.setTextColor(-1);
        this.f25685f.setTextColor(-1);
        this.f25686j.setTextColor(-1);
        this.f25686j.setTextSize(12.0f);
        return false;
    }

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.f25686j = new TextView(this.qv);
        this.xt = new TextView(this.qv);
        this.kt = new TextView(this.qv);
        this.f25687v = new LinearLayout(this.qv);
        this.tj = new TextView(this.qv);
        this.f25685f = new TextView(this.qv);
        this.f25686j.setTag(9);
        this.xt.setTag(10);
        this.kt.setTag(12);
        this.f25687v.addView(this.kt);
        this.f25687v.addView(this.f25685f);
        this.f25687v.addView(this.xt);
        this.f25687v.addView(this.tj);
        this.f25687v.addView(this.f25686j);
        addView(this.f25687v, getWidgetLayoutParams());
    }
}
