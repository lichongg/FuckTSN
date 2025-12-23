package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    @Override // com.bytedance.sdk.openadsdk.res.layout.j
    public View xt(Context context) {
        RelativeLayout j6 = j(context, 2114387622);
        j6.addView(xt(context, 159));
        j6.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387748);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387917);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, ed.cw(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        j6.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387813);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387748);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, ed.cw(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText(kt.j(context, "tt_live_loading_text"));
        j6.addView(textView2);
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, kt.tl(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387689);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ed.cw(context, 32.0f), ed.cw(context, 32.0f));
        layoutParams3.addRule(3, 2114387813);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, ed.cw(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(kt.cw(context, "tt_live_video_loading_progress"));
        j6.addView(tTProgressBar);
        j6.addView(j(context, 158, 6));
        return j6;
    }
}
