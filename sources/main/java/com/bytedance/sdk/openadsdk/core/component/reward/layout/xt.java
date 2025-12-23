package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    protected ViewGroup ae;
    protected final n cw;

    /* renamed from: g, reason: collision with root package name */
    protected FrameLayout f28349g;

    /* renamed from: j, reason: collision with root package name */
    protected final String f28350j;

    /* renamed from: m, reason: collision with root package name */
    protected final boolean f28351m;
    protected TextView oq;
    protected RelativeLayout qv;

    /* renamed from: r, reason: collision with root package name */
    protected final int f28352r;
    protected RelativeLayout tl;
    protected final float up;
    protected int vl = 3;
    protected final TTBaseVideoActivity xt;

    public void cw(int i6) {
    }

    public void j(DownloadListener downloadListener) {
    }

    public void av() {
        n nVar = this.cw;
        String ek = nVar != null ? nVar.ek() : null;
        if (this.oq == null || !TextUtils.isEmpty(ek)) {
            return;
        }
        kt.j(this.xt, "tt_ad_logo_backup", this.oq);
    }

    protected String az() {
        return uf.w(this.cw);
    }

    public void cw(boolean z5) {
        this.xt.gq().getWidgetFrameContainer().setVisibility(z5 ? 0 : 8);
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
    }

    public RelativeLayout jy() {
        return this.tl;
    }

    public void m(int i6) {
        ed.j((View) this.tl, i6);
    }

    protected void qv() {
        if (this.f28351m) {
            int qa = this.cw.qa();
            this.vl = qa;
            if (qa == -200) {
                com.bytedance.sdk.openadsdk.core.p.oq xt = v.xt();
                StringBuilder sb = new StringBuilder();
                sb.append(uf.g(this.cw));
                this.vl = xt.vl(sb.toString());
            }
            if (this.vl == -1) {
                ed.j((View) this.tl, 0);
            }
        }
    }

    public void up(int i6) {
        ed.j((View) this.oq, i6);
    }

    public FrameLayout vl() {
        return this.f28349g;
    }

    protected String ws() {
        return uf.i(this.cw);
    }

    public xt(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        String str;
        this.xt = tTBaseVideoActivity;
        this.cw = nVar;
        this.f28352r = nVar.zw();
        this.up = nVar.uo();
        this.f28351m = z5;
        if (z5) {
            str = "rewarded_video";
        } else {
            str = "fullscreen_interstitial_ad";
        }
        this.f28350j = str;
    }

    public void j() {
        ViewGroup viewGroup = (ViewGroup) this.xt.findViewById(2114387959);
        this.ae = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    protected void j(ImageView imageView, UpieImageView upieImageView) {
        List<h> fp = this.cw.fp();
        if (fp == null || fp.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.g.xt.j(fp.get(0)).j(imageView);
        if (com.bytedance.sdk.openadsdk.up.j.r(this.cw)) {
            com.bytedance.sdk.openadsdk.up.j.j(imageView, upieImageView);
        }
    }

    public void oq() {
    }

    public void r(int i6) {
    }

    public void xt(int i6) {
    }
}
