package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.up {

    /* renamed from: j, reason: collision with root package name */
    TextView f25709j;
    boolean kt;
    FrameLayout xt;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean r() {
        return true;
    }

    private void cw(View view) {
        if (view == this.f25709j || view == ((DynamicBaseWidgetImp) this).mi) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.j.f25774m)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i6 = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i6 >= viewGroup.getChildCount()) {
                return;
            }
            cw(viewGroup.getChildAt(i6));
            i6++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.up
    public void setTimeUpdate(int i6) {
        if (!this.jy.oq().up().na() || i6 <= 0 || this.kt) {
            this.kt = true;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                cw(getChildAt(i7));
            }
            this.f25709j.setVisibility(8);
            return;
        }
        String str = (i6 >= 60 ? "0" + (i6 / 60) : "00") + ":";
        int i8 = i6 % 60;
        this.f25709j.setText(i8 > 9 ? str + i8 : str + "0" + i8);
        this.f25709j.setVisibility(0);
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.kt = false;
        View view = new View(context);
        this.az = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.f25709j = new TextView(context);
        this.xt = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.f25709j.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f25709j.setBackground(gradientDrawable);
        this.f25709j.setTextSize(10.0f);
        this.f25709j.setGravity(17);
        this.f25709j.setTextColor(-1);
        this.f25709j.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            addView(this.xt, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.f25709j);
        addView(this.az, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.r.j()) {
            addView(this.xt, getWidgetLayoutParams());
        }
        dynamicRootView.cw = this.xt;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (tl tlVar = this.jy; tlVar != null; tlVar = tlVar.vl()) {
            d7 = (d7 + tlVar.m()) - tlVar.r();
            d6 = (d6 + tlVar.ae()) - tlVar.up();
        }
        try {
            float f6 = (float) d7;
            int j6 = (int) com.bytedance.sdk.component.adexpress.r.tl.j(getContext(), f6);
            int j7 = (int) com.bytedance.sdk.component.adexpress.r.tl.j(getContext(), f6 + this.up);
            if (com.bytedance.sdk.component.adexpress.r.cw.j(getContext())) {
                int dynamicWidth = ((DynamicRoot) this.ws.getChildAt(0)).getDynamicWidth();
                int i6 = dynamicWidth - j7;
                j7 = dynamicWidth - j6;
                j6 = i6;
            }
            if (!"open_ad".equals(this.ws.getRenderRequest().m())) {
                float f7 = (float) d6;
                ((DynamicRoot) this.ws.getChildAt(0)).f25688j.update(j6, (int) com.bytedance.sdk.component.adexpress.r.tl.j(getContext(), f7), j7, (int) com.bytedance.sdk.component.adexpress.r.tl.j(getContext(), f7 + this.f25659m));
            } else {
                this.ws.cw = this.xt;
            }
        } catch (Exception unused) {
        }
        this.ws.j(d7, d6, this.up, this.f25659m, this.vl.az());
        return true;
    }
}
