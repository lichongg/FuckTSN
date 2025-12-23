package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw<PageWebView> {

    /* renamed from: j, reason: collision with root package name */
    private String f30842j;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public PageWebView j() {
        return new PageWebView(this.xt);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        if (str.equals("src")) {
            this.f30842j = str2;
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        ((PageWebView) this.up).setMeta(com.bytedance.sdk.openadsdk.core.j.j(oq()));
        ((PageWebView) this.up).xt(oq());
        ((PageWebView) this.up).setUGenContext(this.f23861g);
        ((PageWebView) this.up).j();
        ((PageWebView) this.up).j(this.f30842j);
    }
}
