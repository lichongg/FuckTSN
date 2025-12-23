package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.r.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.huawei.hms.feature.dynamic.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends com.bytedance.sdk.openadsdk.core.widget.j.r {

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.az.tl f29642g;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<Integer> f29643j;
    private n oq;
    private boolean qv;
    private com.bytedance.sdk.component.adexpress.xt.jy vl;

    @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f31210m = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.ae = false;
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.component.adexpress.xt.jy jyVar = this.vl;
        if (jyVar == null || !jyVar.s()) {
            return;
        }
        com.bytedance.sdk.component.utils.qv.j(webView, "javascript:window.SDK_INJECT_DATA=" + this.vl.up());
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.cw("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r() {
        if (hh.m(this.oq) != null) {
            return hh.m(this.oq).qv();
        }
        if (hh.ae(this.oq) != null) {
            return b.f33222u;
        }
        return null;
    }

    public int j() {
        Iterator<Integer> it = this.f29643j.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() == 3 || next.intValue() == 2 || next.intValue() == -1) {
                return next.intValue();
            }
        }
        return TextUtils.isEmpty(r()) ? -1 : 1;
    }

    public ae(Context context, rn rnVar, n nVar, com.bytedance.sdk.openadsdk.core.jy.r rVar, boolean z5, com.bytedance.sdk.openadsdk.az.tl tlVar, com.bytedance.sdk.component.adexpress.xt.jy jyVar) {
        super(context, rnVar, nVar.fs(), rVar);
        this.f29643j = new ArrayList<>();
        this.oq = nVar;
        this.qv = z5;
        this.f29642g = tlVar;
        this.vl = jyVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|(4:1|2|(1:4)|5)|(2:7|(8:9|10|11|12|(1:16)|(4:20|(1:22)|23|24)|27|28))|33|10|11|12|(2:14|16)|(5:18|20|(0)|23|24)|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        com.bytedance.sdk.component.utils.vl.cw("ExpressClient", "shouldInterceptRequest error2", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057 A[Catch: all -> 0x0049, TryCatch #1 {all -> 0x0049, blocks: (B:12:0x002f, B:14:0x0034, B:16:0x003b, B:18:0x004d, B:20:0x0053, B:22:0x0057, B:23:0x005a), top: B:11:0x002f }] */
    @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r9, java.lang.String r10) {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.az.tl r0 = r8.f29642g     // Catch: java.lang.Throwable -> L8
            if (r0 == 0) goto Lc
            r0.tl(r10)     // Catch: java.lang.Throwable -> L8
            goto Lc
        L8:
            r0 = move-exception
            r1 = r8
            r6 = r10
            goto L5f
        Lc:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8
            com.bytedance.sdk.openadsdk.core.tj.n r0 = r8.oq     // Catch: java.lang.Throwable -> L8
            com.bytedance.sdk.openadsdk.core.nativeexpress.ae$1 r1 = new com.bytedance.sdk.openadsdk.core.nativeexpress.ae$1     // Catch: java.lang.Throwable -> L8
            r1.<init>()     // Catch: java.lang.Throwable -> L8
            com.bytedance.sdk.component.adexpress.j.xt.j r0 = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.j(r9, r0, r10, r1)     // Catch: java.lang.Throwable -> L8
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8
            if (r0 == 0) goto L2c
            android.webkit.WebResourceResponse r1 = r0.j()     // Catch: java.lang.Throwable -> L8
            if (r1 == 0) goto L2c
            r1 = 1
            r7 = 1
        L29:
            r1 = r8
            r6 = r10
            goto L2f
        L2c:
            r1 = 2
            r7 = 2
            goto L29
        L2f:
            r1.j(r2, r4, r6, r7)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L4b
            int r10 = r0.getType()     // Catch: java.lang.Throwable -> L49
            r2 = 5
            if (r10 == r2) goto L4b
            java.util.ArrayList<java.lang.Integer> r10 = r1.f29643j     // Catch: java.lang.Throwable -> L49
            int r2 = r0.getType()     // Catch: java.lang.Throwable -> L49
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L49
            r10.add(r2)     // Catch: java.lang.Throwable -> L49
            goto L4b
        L49:
            r0 = move-exception
            goto L5f
        L4b:
            if (r0 == 0) goto L66
            android.webkit.WebResourceResponse r10 = r0.j()     // Catch: java.lang.Throwable -> L49
            if (r10 == 0) goto L66
            com.bytedance.sdk.openadsdk.az.tl r10 = r1.f29642g     // Catch: java.lang.Throwable -> L49
            if (r10 == 0) goto L5a
            r10.g(r6)     // Catch: java.lang.Throwable -> L49
        L5a:
            android.webkit.WebResourceResponse r9 = r0.j()     // Catch: java.lang.Throwable -> L49
            return r9
        L5f:
            java.lang.String r10 = "ExpressClient"
            java.lang.String r2 = "shouldInterceptRequest error2"
            com.bytedance.sdk.component.utils.vl.cw(r10, r2, r0)
        L66:
            android.webkit.WebResourceResponse r9 = super.shouldInterceptRequest(r9, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.ae.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    private void j(long j6, long j7, String str, int i6) {
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        if (rVar == null || rVar.cw() == null) {
            return;
        }
        oq.j j8 = com.bytedance.sdk.component.adexpress.r.oq.j(str);
        if (j8 == oq.j.HTML) {
            this.up.cw().j(str, j6, j7, i6);
        } else if (j8 == oq.j.JS) {
            this.up.cw().xt(str, j6, j7, i6);
        }
    }
}
