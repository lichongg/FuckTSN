package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    TextView ae;
    TextView cw;

    /* renamed from: g, reason: collision with root package name */
    private n f28445g;

    /* renamed from: j, reason: collision with root package name */
    LinearLayout f28446j;

    /* renamed from: m, reason: collision with root package name */
    TextView f28447m;
    private int oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    TTRatingBar f28448r;
    private final TTBaseVideoActivity tl;
    TextView up;
    TTRoundRectImageView xt;

    public void j(n nVar) {
        if (this.qv) {
            return;
        }
        this.qv = true;
        this.f28445g = nVar;
        this.oq = nVar.zw();
        up();
        xt();
        j(r());
        m();
    }

    private void m() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.oq == 1 && (tTRoundRectImageView = this.xt) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, ed.cw(this.tl, 50.0f), 0, 0);
            this.xt.setLayoutParams(layoutParams);
        }
    }

    private void up() {
        this.f28446j = (LinearLayout) this.tl.findViewById(2114387745);
        this.xt = (TTRoundRectImageView) this.tl.findViewById(2114387779);
        this.cw = (TextView) this.tl.findViewById(2114387651);
        this.f28448r = (TTRatingBar) this.tl.findViewById(2114387785);
        this.up = (TextView) this.tl.findViewById(2114387788);
        this.f28447m = (TextView) this.tl.findViewById(2114387870);
        this.ae = (TextView) this.tl.findViewById(2114387715);
        TTRatingBar tTRatingBar = this.f28448r;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.f28448r.setStarFillNum(4);
            this.f28448r.setStarImageWidth(ed.cw(this.tl, 16.0f));
            this.f28448r.setStarImageHeight(ed.cw(this.tl, 16.0f));
            this.f28448r.setStarImagePadding(ed.cw(this.tl, 4.0f));
            this.f28448r.j();
        }
    }

    public void cw() {
        ed.j((View) this.f28446j, 8);
    }

    protected String r() {
        n nVar = this.f28445g;
        return nVar == null ? "立即下载" : TextUtils.isEmpty(nVar.sf()) ? this.f28445g.jl() != 4 ? "查看详情" : "立即下载" : this.f28445g.sf();
    }

    public void xt() {
        String valueOf;
        if (this.xt != null) {
            h ig = this.f28445g.ig();
            if (ig == null || TextUtils.isEmpty(ig.j())) {
                kt.j((Context) this.tl, "tt_ad_logo_small", (ImageView) this.xt);
            } else {
                com.bytedance.sdk.openadsdk.g.xt.j(ig).j(this.xt);
            }
        }
        if (this.cw != null) {
            if (this.f28445g.by() == null || TextUtils.isEmpty(this.f28445g.by().cw())) {
                this.cw.setText(this.f28445g.hw());
            } else {
                this.cw.setText(this.f28445g.by().cw());
            }
        }
        if (this.up != null) {
            int m6 = this.f28445g.by() != null ? this.f28445g.by().m() : 6870;
            String j6 = kt.j(this.tl, "tt_comment_num_backup");
            if (m6 > 10000) {
                valueOf = (m6 / 10000) + "万";
            } else {
                valueOf = String.valueOf(m6);
            }
            this.up.setText(String.format(j6, valueOf));
        }
        TextView textView = this.ae;
        if (textView != null) {
            ed.j(textView, this.f28445g);
        }
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity) {
        this.tl = tTBaseVideoActivity;
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        ed.j(this.f28446j, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.f28447m;
        if (textView != null) {
            textView.setOnClickListener(xtVar);
            this.f28447m.setOnTouchListener(xtVar);
        }
    }

    public void j() {
        ed.j((View) this.f28446j, 0);
    }

    public void j(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.f28447m) == null) {
            return;
        }
        textView.setText(str);
    }
}
