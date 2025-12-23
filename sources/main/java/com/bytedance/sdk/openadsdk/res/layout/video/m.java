package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.openadsdk.res.layout.j {
    private View cw(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387961);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387670);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ed.cw(context, 44.0f), ed.cw(context, 44.0f));
        layoutParams2.addRule(14);
        roundImageView.setLayoutParams(layoutParams2);
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        relativeLayout.addView(roundImageView);
        TextView textView = new TextView(context);
        textView.setId(2114387957);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ed.cw(context, 44.0f), ed.cw(context, 44.0f));
        layoutParams3.addRule(8, 2114387670);
        layoutParams3.addRule(19, 2114387670);
        layoutParams3.addRule(5, 2114387670);
        layoutParams3.addRule(7, 2114387670);
        layoutParams3.addRule(18, 2114387670);
        layoutParams3.addRule(14);
        textView.setLayoutParams(layoutParams3);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#E0E0E0"));
        textView.setBackground(shapeDrawable);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(2, 19.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387770);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2114387670);
        layoutParams4.addRule(14);
        layoutParams4.setMargins(0, ed.cw(context, 6.0f), 0, ed.cw(context, 20.0f));
        textView2.setLayoutParams(layoutParams4);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 12.0f);
        relativeLayout.addView(textView2);
        TextView textView3 = new TextView(context);
        textView3.setId(2114387692);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, ed.cw(context, 28.0f));
        layoutParams5.addRule(3, 2114387770);
        layoutParams5.addRule(14);
        layoutParams5.addRule(15);
        layoutParams5.setMargins(0, 0, 0, 0);
        textView3.setLayoutParams(layoutParams5);
        textView3.setMinWidth(ed.cw(context, 72.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        gradientDrawable.setCornerRadius(ed.cw(context, 6.0f));
        textView3.setBackground(gradientDrawable);
        textView3.setGravity(17);
        textView3.setPadding(ed.cw(context, 2.0f), ed.cw(context, 2.0f), ed.cw(context, 2.0f), ed.cw(context, 2.0f));
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 14.0f);
        textView3.setVisibility(8);
        relativeLayout.addView(textView3);
        return relativeLayout;
    }

    private View j(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387810);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int parseColor = Color.parseColor("#7f000000");
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_OVER;
        imageView.setColorFilter(parseColor, mode);
        imageView.setImageTintMode(mode);
        return imageView;
    }

    private View r(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387680);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387874);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(580, 98);
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
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
        layoutParams3.addRule(14);
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

    @Override // com.bytedance.sdk.openadsdk.res.layout.j
    public View xt(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387750);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(kt.oq(context, "tt_trans_half_black"));
        relativeLayout.addView(j(context));
        relativeLayout.addView(cw(context));
        relativeLayout.addView(r(context));
        return relativeLayout;
    }
}
