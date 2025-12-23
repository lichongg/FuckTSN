package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.g.xt;
import com.bytedance.sdk.openadsdk.res.up;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DownloadItemView extends FrameLayout {
    public void j(n nVar) {
        String valueOf;
        if (nVar == null) {
            return;
        }
        Context context = getContext();
        addView(up.rn(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387799);
        TextView textView = (TextView) findViewById(2114387881);
        TextView textView2 = (TextView) findViewById(2114387643);
        TextView textView3 = (TextView) findViewById(2114387836);
        TextView textView4 = (TextView) findViewById(2114387636);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387615);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(ed.cw(context, 12.0f));
            tTRatingBar.setStarImageHeight(ed.cw(context, 12.0f));
            tTRatingBar.setStarImagePadding(ed.cw(context, 4.0f));
            tTRatingBar.j();
        }
        if (textView4 != null) {
            int m6 = nVar.by() != null ? nVar.by().m() : 6870;
            String j6 = kt.j(context, "tt_comment_num");
            if (m6 > 10000) {
                valueOf = (m6 / 10000) + "万";
            } else {
                valueOf = String.valueOf(m6);
            }
            textView4.setText(String.format(j6, valueOf));
        }
        if (tTRoundRectImageView != null) {
            h ig = nVar.ig();
            if (ig == null || TextUtils.isEmpty(ig.j())) {
                kt.j(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            } else {
                xt.j(ig).j(tTRoundRectImageView);
            }
        }
        if (textView != null) {
            textView.setText(uf.i(nVar));
        }
        if (textView2 != null) {
            textView2.setText(uf.w(nVar));
        }
        if (textView3 != null) {
            textView3.setText(TextUtils.isEmpty(nVar.sf()) ? nVar.jl() != 4 ? "查看详情" : "立即下载" : nVar.sf());
        }
    }

    public DownloadItemView(Context context) {
        super(context);
    }
}
