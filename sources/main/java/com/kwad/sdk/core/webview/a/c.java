package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a Mh;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private KsAdWebView.c TL;
        private int To;
        private KsAdWebView.e aNb;
        private KsAdWebView.d aNc;
        private boolean aNd;
        private boolean aNg;
        private KsAdWebView.b afR;
        private AdTemplate mAdTemplate;
        private Context mContext;
        private boolean aNe = true;
        private boolean aNf = true;
        private boolean aNa = true;
        private boolean aNh = false;
        private long aNi = 600;
        private long aNj = 0;

        public final a a(KsAdWebView.d dVar) {
            this.aNc = dVar;
            return this;
        }

        public final a bA(boolean z5) {
            this.aNd = true;
            return this;
        }

        public final a bD(boolean z5) {
            this.aNg = true;
            return this;
        }

        public final a bz(boolean z5) {
            this.aNh = true;
            return this;
        }

        public final void release() {
            this.afR = null;
            this.aNc = null;
            this.TL = null;
            this.aNb = null;
            this.mContext = null;
            this.mAdTemplate = null;
        }

        private boolean KL() {
            return this.aNh;
        }

        public final KsAdWebView.d KK() {
            return this.aNc;
        }

        public final boolean KM() {
            return this.aNf;
        }

        public final boolean KN() {
            return this.aNa;
        }

        public final boolean KO() {
            return this.aNe;
        }

        public final boolean KP() {
            return this.aNg;
        }

        public final boolean KR() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dw(e.el(adTemplate));
        }

        public final boolean KS() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dx(e.el(adTemplate));
        }

        public final a a(KsAdWebView.b bVar) {
            this.afR = bVar;
            return this;
        }

        public final void aM(long j6) {
            this.aNj = j6;
        }

        public final a b(KsAdWebView.e eVar) {
            this.aNb = eVar;
            return this;
        }

        public final a bB(boolean z5) {
            this.aNf = z5;
            return this;
        }

        public final a bC(boolean z5) {
            this.aNe = z5;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.TL = cVar;
            return this;
        }

        public final a dS(int i6) {
            this.To = i6;
            return this;
        }

        public final a eJ(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e ju() {
            return this.aNb;
        }

        public final KsAdWebView.b nK() {
            return this.afR;
        }

        public final KsAdWebView.c rm() {
            return this.TL;
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final boolean KQ() {
            if (!KL()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j6 = this.aNj;
            if (j6 > 0 && currentTimeMillis - j6 <= this.aNi) {
                return true;
            }
            return false;
        }

        public final com.kwad.sdk.core.adlog.c.a pq() {
            return com.kwad.sdk.core.adlog.c.a.EK().db(this.To).dc(this.aNd ? 1 : 0);
        }
    }

    private boolean eT(String str) {
        try {
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
        if (!str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) && !str.startsWith(master.flame.danmaku.danmaku.parser.b.f50155b)) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                a aVar = this.Mh;
                if (aVar != null) {
                    if (aVar.KM()) {
                        a(this.Mh, str);
                        return true;
                    }
                    if (eU(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.Mh;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    public final void R(String str) {
        this.mUniqueId = str;
    }

    public final void destroy() {
        a aVar = this.Mh;
        if (aVar != null) {
            aVar.release();
            this.Mh = null;
        }
    }

    public final a getClientConfig() {
        return this.Mh;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean didCrash;
        if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null) {
            didCrash = renderProcessGoneDetail.didCrash();
            if (didCrash) {
                return true;
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.Mh = aVar;
        setNeedHybridLoad(aVar.KN());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.Mh;
        if (aVar == null || !aVar.KQ() || ((this.Mh.KK() != null && this.Mh.KK().shouldOverrideUrlLoading(webView, str)) || eT(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public static int a(@NonNull a aVar, String str) {
        int F = com.kwad.sdk.core.download.a.b.F(aVar.getContext(), str);
        if (F == 1) {
            if (aVar.nK() != null) {
                aVar.nK().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
            return F;
        }
        if (aVar.nK() != null) {
            aVar.nK().onFailed();
        }
        if (F == -1) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), "", 2, null);
        }
        return F;
    }

    private static boolean eU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("hwfastapp://") && !str.startsWith("hap://app") && !str.startsWith("intent://hapjs.org/") && !str.startsWith("intent://")) {
            return false;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageFinished");
        a aVar = this.Mh;
        if (aVar != null && aVar.ju() != null) {
            this.Mh.ju().onPageFinished();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageStart");
        a aVar = this.Mh;
        if (aVar != null && aVar.ju() != null) {
            this.Mh.ju().onPageStart();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i6, String str, String str2) {
        super.onReceivedError(webView, i6, str, str2);
        com.kwad.sdk.core.d.c.d("KsAdWebViewClient", "onReceivedError " + i6);
        a aVar = this.Mh;
        if (aVar != null && aVar.ju() != null) {
            this.Mh.ju().onReceivedHttpError(i6, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ag(str2, str);
    }
}
