package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.c;
import com.bytedance.sdk.openadsdk.core.tl.cw;
import com.bytedance.sdk.openadsdk.g.xt;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void j() {
    }

    private void j(Context context, c.j jVar) {
        if (jVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout j6 = j(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            xt.j(cw.j("saas_reward_goods_bg.webp")).j(imageView);
        } catch (Error unused) {
        }
        j6.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387808);
        layoutParams.topMargin = ed.cw(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        j6.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = ed.cw(context, 20.0f);
        textView2.setId(2114387468);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(ed.cw(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(jVar.j());
        textView2.setTextColor(Color.parseColor("#161823"));
        j6.addView(textView2);
        int cw = ed.cw(context, 80.0f);
        int cw2 = ed.cw(context, 10.0f);
        ImageView tTRoundRectImageView = new TTRoundRectImageView(context, cw2, cw2);
        tTRoundRectImageView.setId(2114387462);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(cw, cw);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = ed.cw(context, 12.0f);
        xt.j(jVar.xt()).j(cw).xt(cw).j(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        j6.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387463);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = ed.cw(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double r5 = jVar.r();
        int floor = (int) Math.floor(r5);
        int i6 = (int) ((r5 - floor) * 100.0d);
        TextView textView4 = new TextView(context);
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(null, 1);
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setText(String.valueOf(floor));
        linearLayout.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(2, 11.0f);
        textView5.setTypeface(null, 1);
        textView5.setTextColor(Color.parseColor("#F93F3F"));
        StringBuilder sb = new StringBuilder(".");
        sb.append(i6);
        sb.append(i6 >= 10 ? "" : "0");
        textView5.setText(sb.toString());
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + jVar.cw());
        linearLayout.addView(textView6);
        j6.addView(linearLayout);
        j(context, "一键关联抖音购买", j6);
        addView(j6);
    }

    public SaasAuthProductEnvelope(@NonNull Context context, c.j jVar) {
        super(context);
        j(context, jVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void xt() {
        super.xt();
    }
}
