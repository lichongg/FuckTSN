package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.w.r;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.l.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class EcMallWebView extends SSWebView {
    private r ae;

    /* renamed from: m, reason: collision with root package name */
    private final n f29456m;
    rn up;

    public EcMallWebView(final Context context, n nVar, final int i6) {
        super(context);
        this.f29456m = nVar;
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.j(context, i6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, int i6) {
        this.up = new rn(context);
        final String j6 = uf.j(i6);
        this.ae = new r() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.2
            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void j() {
                if (EcMallWebView.this.f29456m != null) {
                    com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar = (com.bytedance.sdk.openadsdk.i.cw.j.xt) x.j(EcMallWebView.this.f29456m.uv(), com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
                    if (xtVar != null) {
                        xtVar.j(2, null);
                    }
                } else {
                    vl.j("EcMallWebView", "onSendReward failed meta null");
                }
                com.bytedance.sdk.openadsdk.core.jy.cw.j(j6, EcMallWebView.this.f29456m);
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void cw() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void xt() {
            }
        };
        this.up.xt(this).j(this.f29456m).xt(this.f29456m.fs()).cw(this.f29456m.os()).cw(i6).r(uf.av(this.f29456m)).j((SSWebView) this).j(j6).j(this.ae).j(true);
        setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(context, this.up, this.f29456m.fs(), new com.bytedance.sdk.openadsdk.core.jy.r(this.f29456m, this).xt(true)));
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.up));
        String m6 = kt.m(this.f29456m);
        if (TextUtils.isEmpty(m6)) {
            m6 = this.f29456m.yb();
        }
        if (TextUtils.isEmpty(m6)) {
            return;
        }
        loadUrl(m6);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, android.view.View, com.bytedance.sdk.component.jy.cw
    public void setVisibility(int i6) {
        boolean z5;
        super.setVisibility(i6);
        if (i6 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        rn rnVar = this.up;
        if (rnVar != null) {
            rnVar.qv(z5);
        }
    }
}
