package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\Downloads\app\classes4.dex */
public class LayoutVideoDetail extends RelativeLayout {
    private View ae(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, kt.tl(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387659);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ed.cw(context, 1.5f));
        layoutParams.addRule(12);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setBackground(null);
        tTProgressBar.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float cw = ed.cw(context, 1.0f);
        gradientDrawable.setCornerRadius(cw);
        int cw2 = ed.cw(context, 2.0f);
        gradientDrawable.setSize(-1, cw2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(cw);
        gradientDrawable2.setSize(-1, cw2);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(cw);
        gradientDrawable3.setSize(-1, cw2);
        com.bytedance.sdk.openadsdk.res.m.j(tTProgressBar, new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar.setVisibility(8);
        return tTProgressBar;
    }

    private View cw(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387632);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        kt.j(context, "tt_play_movebar_textpage", imageView);
        imageView.setVisibility(8);
        return imageView;
    }

    private View g(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387765);
        textView.setBackgroundColor(0);
        textView.setMinHeight(ed.cw(context, 44.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ed.cw(context, 12.0f);
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawablesWithIntrinsicBounds(oq(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(oq(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText("关闭");
        return textView;
    }

    private View m(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387611);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387903);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = ed.cw(context, 12.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.j jVar = new com.bytedance.sdk.openadsdk.res.j(48);
        jVar.j(parseColor);
        float cw = ed.cw(context, 2.0f);
        jVar.j(cw);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.j jVar2 = new com.bytedance.sdk.openadsdk.res.j(48);
        jVar2.j(parseColor2);
        jVar2.j(cw);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, jVar);
        stateListDrawable.addState(new int[0], jVar2);
        imageView.setImageDrawable(stateListDrawable);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387712);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        int cw2 = ed.cw(context, 15.0f);
        textView.setPadding(cw2, 0, cw2, 0);
        relativeLayout.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387803);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(cw2, 0, cw2, 0);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387852);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(-1);
        linearLayout.addView(textView2);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private StateListDrawable oq(Context context) {
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.j jVar = new com.bytedance.sdk.openadsdk.res.j(48);
        jVar.j(parseColor);
        float cw = ed.cw(context, 2.0f);
        jVar.j(cw);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.j jVar2 = new com.bytedance.sdk.openadsdk.res.j(48);
        jVar2.j(parseColor2);
        jVar2.j(cw);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, jVar);
        stateListDrawable.addState(new int[0], jVar2);
        return stateListDrawable;
    }

    private View r(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387684);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(ed.cw(context, 4.0f));
        imageView.setBackground(gradientDrawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.j jVar = new com.bytedance.sdk.openadsdk.res.j(48);
        jVar.j(parseColor);
        float cw = ed.cw(context, 2.0f);
        jVar.j(cw);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.j jVar2 = new com.bytedance.sdk.openadsdk.res.j(48);
        jVar2.j(parseColor2);
        jVar2.j(cw);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, jVar);
        stateListDrawable.addState(new int[0], jVar2);
        imageView.setImageDrawable(stateListDrawable);
        int cw2 = ed.cw(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cw2, cw2);
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        int cw3 = ed.cw(context, 7.0f);
        layoutParams.setMargins(0, cw3, cw3, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private View tl(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387634);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ed.cw(context, 40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387817);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(ed.cw(context, 16.0f), 0, ed.cw(context, 12.0f), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setText("00:00");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        linearLayout.addView(textView);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(2114387878);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.gravity = 16;
        seekBar.setLayoutParams(layoutParams3);
        seekBar.setBackground(null);
        seekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            seekBar.setMaxHeight(ed.cw(context, 4.0f));
            seekBar.setMinHeight(ed.cw(context, 4.0f));
        } else {
            layoutParams3.height = ed.cw(context, 4.0f);
        }
        seekBar.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float cw = ed.cw(context, 1.0f);
        gradientDrawable.setCornerRadius(cw);
        int cw2 = ed.cw(context, 2.0f);
        gradientDrawable.setSize(-1, cw2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(cw);
        gradientDrawable2.setSize(-1, cw2);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(cw);
        gradientDrawable3.setSize(-1, cw2);
        seekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int cw3 = ed.cw(context, 15.0f);
        shapeDrawable.setIntrinsicWidth(cw3);
        shapeDrawable.setIntrinsicHeight(cw3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ed.cw(context, 1.0f));
        paint.setColor(Color.parseColor("#1E000000"));
        seekBar.setThumb(shapeDrawable);
        seekBar.setThumbOffset(0);
        linearLayout.addView(seekBar);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387674);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(ed.cw(context, 12.0f), 0, ed.cw(context, 16.0f), 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("00:00");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 10.0f);
        linearLayout.addView(textView2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387667);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.setMargins(ed.cw(context, 16.0f), 0, ed.cw(context, 16.0f), 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setVisibility(8);
        kt.j(context, "tt_enlarge_video", imageView);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private View up(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387736);
        textView.setGravity(8388659);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(false);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        textView.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        textView.setBackground(gradientDrawable);
        int cw = ed.cw(context, 15.0f);
        textView.setPadding(cw, ed.cw(context, 14.0f), cw, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View xt(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387906);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387657);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387637);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ed.cw(context, 60.0f), ed.cw(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setIndeterminateDrawable(kt.cw(context, "tt_video_loading_progress_bar"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387829);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setVisibility(8);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387624);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        kt.j(context, "tt_refreshing_video_textpage", imageView2);
        TextView textView = new TextView(context);
        textView.setId(2114387866);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(kt.j(context, "tt_video_retry_des_txt"));
        textView.setTextColor(kt.oq(context, "tt_heise3"));
        linearLayout.addView(imageView2);
        linearLayout.addView(textView);
        relativeLayout.addView(imageView);
        relativeLayout.addView(tTProgressBar);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    public LayoutVideoDetail(Context context) {
        super(context);
        j(context);
    }

    private void j(Context context) {
        setId(2114387720);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        addView(xt(context));
        addView(new r().xt(context));
        addView(cw(context));
        addView(r(context));
        addView(up(context));
        addView(m(context));
        addView(ae(context));
        addView(tl(context));
        TTViewStub tTViewStub = new TTViewStub(context, new m());
        tTViewStub.setId(2114387750);
        tTViewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new xt());
        tTViewStub2.setId(2114387672);
        tTViewStub2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub2);
        addView(g(context));
    }
}
