package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements com.bytedance.sdk.openadsdk.res.layout.j {
    protected RelativeLayout j(Context context, int i6) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i6 != 0) {
            relativeLayout.setId(i6);
        }
        return relativeLayout;
    }

    protected View xt(Context context, int i6) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387917);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ed.cw(context, 66.0f), ed.cw(context, 66.0f));
        layoutParams.addRule(14);
        if (i6 != 0) {
            layoutParams.setMargins(0, ed.cw(context, i6), 0, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        kt.j(context, "tt_live_avatar_bg", relativeLayout);
        View roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387837);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ed.cw(context, 65.0f), ed.cw(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(roundImageView);
        View imageView = new ImageView(context);
        imageView.setId(2114387614);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ed.cw(context, 42.0f), ed.cw(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        kt.j(context, "tt_live_ad_status_icon", imageView);
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    protected View j(Context context, int i6, int i7) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387699);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ed.cw(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(ed.cw(context, 40.0f), 0, ed.cw(context, 40.0f), ed.cw(context, i6));
        relativeLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(ed.cw(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(17);
        View imageView = new ImageView(context);
        imageView.setId(2114387882);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ed.cw(context, 14.0f), ed.cw(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, ed.cw(context, i7), 0);
        imageView.setLayoutParams(layoutParams2);
        kt.j(context, "tt_live_ad_loading_btn_status", imageView);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387758);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387882);
        layoutParams3.addRule(17, 2114387882);
        layoutParams3.addRule(15);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText(kt.j(context, "tt_live_loading_btn"));
        textView.setTextColor(-1);
        relativeLayout.addView(textView);
        View imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ed.cw(context, 14.0f), ed.cw(context, 16.0f));
        layoutParams4.addRule(1, 2114387758);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, 0, ed.cw(context, 6.0f), 0);
        imageView2.setLayoutParams(layoutParams4);
        kt.j(context, "tt_splash_click_bar_go", imageView2);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
