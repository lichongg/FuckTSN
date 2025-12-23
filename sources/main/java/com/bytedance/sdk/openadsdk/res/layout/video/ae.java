package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements com.bytedance.sdk.openadsdk.res.layout.j {
    @Override // com.bytedance.sdk.openadsdk.res.layout.j
    public View xt(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387680);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387874);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(580, 98);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.setMargins(0, ed.cw(context, 20.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#D33F57"));
        gradientDrawable.setCornerRadius(4.0f);
        textView.setBackground(gradientDrawable);
        textView.setGravity(17);
        textView.setPadding(ed.cw(context, 2.0f), ed.cw(context, 2.0f), ed.cw(context, 2.0f), ed.cw(context, 2.0f));
        textView.setTextColor(-1);
        textView.setTextSize(0, 34.0f);
        textView.setText(kt.j(context, "tt_download"));
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387848);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387874);
        layoutParams3.addRule(14, -1);
        layoutParams3.setMargins(0, 60, 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setText(kt.j(context, "tt_click_replay"));
        textView2.setTextColor(-1);
        textView2.setTextSize(0, 34.0f);
        relativeLayout.addView(textView2);
        return relativeLayout;
    }
}
