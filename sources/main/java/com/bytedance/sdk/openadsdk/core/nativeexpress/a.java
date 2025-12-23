package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.gq;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.uf;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a implements SSWebView.xt {
    private rn cw;

    /* renamed from: j, reason: collision with root package name */
    private SSWebView f29640j;
    private n xt;

    private boolean j() {
        SSWebView sSWebView = this.f29640j;
        if (sSWebView == null) {
            return false;
        }
        return uf.xt(sSWebView, 50, com.bytedance.sdk.openadsdk.core.rn.uf.tl(this.xt));
    }

    public a(SSWebView sSWebView, rn rnVar, n nVar) {
        this.f29640j = sSWebView;
        this.xt = nVar;
        this.cw = rnVar;
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.xt
    public void j(final int i6) {
        boolean j6 = j();
        com.bytedance.sdk.component.utils.vl.xt("xeasy", "wv:".concat(String.valueOf(j6)));
        if (j6) {
            if (com.bytedance.sdk.openadsdk.core.v.xt().oq()) {
                SSWebView sSWebView = this.f29640j;
                if (sSWebView != null) {
                    gq.j((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.bytedance.sdk.openadsdk.core.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.1
                        @Override // com.bytedance.sdk.openadsdk.core.xt.cw
                        public void j() {
                            if (a.this.cw != null) {
                                a.this.cw.j(i6);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            rn rnVar = this.cw;
            if (rnVar != null) {
                rnVar.j(i6);
            }
        }
    }
}
