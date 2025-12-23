package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.c;
import com.bytedance.sdk.openadsdk.core.tl.cw;
import com.bytedance.sdk.openadsdk.g.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {

    /* renamed from: j, reason: collision with root package name */
    private TextView f28468j;

    private void j(Context context, c.xt xtVar) {
        if (xtVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout j6 = j(context);
        ImageView imageView = new ImageView(context);
        try {
            xt.j(cw.j("saas_reward_coupon_bg.webp")).j(imageView);
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        j6.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387808);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = ed.cw(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        j6.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387467);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.f28468j = textView2;
        textView2.setId(2114387466);
        this.f28468j.setText(String.valueOf(xtVar.j()));
        this.f28468j.setTextColor(Color.parseColor("#F93F3F"));
        this.f28468j.setTextSize(2, 60.0f);
        linearLayout.addView(this.f28468j, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        j6.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387465);
        textView4.setText("满" + xtVar.xt() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = ed.cw(context, -4.0f);
        j6.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = ed.cw(context, 8.0f);
        j6.addView(textView5, layoutParams4);
        j(context, "一键关联抖音领取", j6);
        addView(j6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void xt() {
        setVisibility(8);
        super.xt();
    }

    public SaasAuthCouponEnvelope(@NonNull Context context, c.xt xtVar) {
        super(context);
        j(context, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void j() {
        setVisibility(0);
    }
}
