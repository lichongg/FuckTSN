package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\Downloads\app\classes4.dex */
public class LayoutVideoPlayLayoutForLive extends RelativeLayout {
    private void j(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387720);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(2114387906);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
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
        relativeLayout2.addView(imageView);
        relativeLayout2.addView(tTProgressBar);
        relativeLayout.addView(relativeLayout2);
        View xt = new cw().xt(context);
        xt.setId(2114387894);
        relativeLayout.addView(xt);
        View xt2 = new r().xt(context);
        xt2.setId(2114387694);
        relativeLayout.addView(xt2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387632);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        kt.j(context, "tt_play_movebar_textpage", imageView2);
        imageView2.setVisibility(8);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, kt.tl(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar2.setId(2114387659);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ed.cw(context, 1.5f));
        layoutParams2.addRule(12);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        tTProgressBar2.setMax(100);
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
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        relativeLayout.addView(tTProgressBar2, layoutParams2);
        View tTViewStub = new TTViewStub(context, new m());
        tTViewStub.setId(2114387750);
        tTViewStub.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new xt());
        tTViewStub2.setId(2114387672);
        tTViewStub2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new ae());
        tTViewStub3.setId(2114387834);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        tTViewStub3.setLayoutParams(layoutParams3);
        relativeLayout.addView(tTViewStub3);
        addView(relativeLayout);
    }

    public LayoutVideoPlayLayoutForLive(Context context) {
        super(context);
        j(context);
    }
}
