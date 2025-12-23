package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends xt {
    private TextView av;
    private TextView az;

    /* renamed from: i, reason: collision with root package name */
    private TextView f28334i;
    private RatioImageView jy;
    private UpieImageView kt;
    private TextView mi;

    /* renamed from: w, reason: collision with root package name */
    private TTRatingBar f28335w;
    private TTRoundRectImageView ws;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        super.j();
        this.f28349g = (FrameLayout) this.ae.findViewById(2114387648);
        this.jy = (RatioImageView) this.ae.findViewById(2114387772);
        this.ws = (TTRoundRectImageView) this.ae.findViewById(2114387728);
        this.az = (TextView) this.ae.findViewById(2114387708);
        this.av = (TextView) this.ae.findViewById(2114387940);
        this.f28334i = (TextView) this.ae.findViewById(2114387795);
        this.mi = (TextView) this.ae.findViewById(2114387962);
        this.f28335w = (TTRatingBar) this.ae.findViewById(2114387793);
        if (com.bytedance.sdk.openadsdk.up.j.r(this.cw)) {
            UpieImageView upieImageView = new UpieImageView(this.jy.getContext(), com.bytedance.sdk.openadsdk.up.j.g(this.cw), com.bytedance.sdk.openadsdk.up.j.oq(this.cw));
            this.kt = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        xt();
    }

    private void cw() {
        TTRatingBar tTRatingBar = this.f28335w;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.f28335w.setStarFillNum(4);
        this.f28335w.setStarImageWidth(ed.cw(this.xt, 16.0f));
        this.f28335w.setStarImageHeight(ed.cw(this.xt, 16.0f));
        this.f28335w.setStarImagePadding(ed.cw(this.xt, 4.0f));
        this.f28335w.j();
    }

    private void r() {
        String valueOf;
        if (this.f28334i == null) {
            return;
        }
        int m6 = this.cw.by() != null ? this.cw.by().m() : 6870;
        String j6 = kt.j(this.xt, "tt_comment_num_backup");
        if (m6 > 10000) {
            valueOf = (m6 / 10000) + "万";
        } else {
            valueOf = String.valueOf(m6);
        }
        this.f28334i.setText(String.format(j6, valueOf));
    }

    private void xt() {
        h ig;
        ed.j((TextView) this.xt.findViewById(2114387664), this.cw);
        if (this.jy != null) {
            int ve = this.cw.ve();
            if (ve == 3) {
                this.jy.setRatio(1.91f);
            } else if (ve != 33) {
                this.jy.setRatio(0.56f);
            } else {
                this.jy.setRatio(1.0f);
            }
            j(this.jy, this.kt);
        }
        if (this.ws != null && (ig = this.cw.ig()) != null) {
            com.bytedance.sdk.openadsdk.g.xt.j(ig).j(this.ws);
        }
        TextView textView = this.az;
        if (textView != null) {
            textView.setText(ws());
        }
        TextView textView2 = this.av;
        if (textView2 != null) {
            textView2.setText(az());
        }
        cw();
        r();
    }

    public m(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
        j(this.jy, xtVar, xtVar);
        j(this.ws, xtVar, xtVar);
        j(this.az, xtVar, xtVar);
        j(this.av, xtVar, xtVar);
        j(this.mi, xtVar, xtVar);
        j(this.f28334i, xtVar, xtVar);
        j(this.f28335w, xtVar, xtVar);
        j(this.kt, xtVar, xtVar);
    }

    protected void j(View view, com.bytedance.sdk.openadsdk.core.xt.xt xtVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.xt == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(xtVar);
    }
}
