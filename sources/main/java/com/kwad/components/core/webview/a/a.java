package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.cc;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private com.kwad.components.core.e.d.c Pc;
    private WebView Ta;
    private boolean abI;
    private KsAppDownloadListener abU;
    private int abV = -100;
    private int abW = 0;
    private com.kwad.sdk.core.webview.b eQ;
    private AdTemplate mAdTemplate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    public static final class C0636a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    private synchronized void p(String str, String str2) {
        this.Pc = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.abU == null) {
            KsAppDownloadListener uz = uz();
            this.abU = uz;
            this.Pc.b(uz);
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void destroy() {
        this.abI = true;
        com.kwad.components.core.e.d.c cVar = this.Pc;
        if (cVar != null) {
            cVar.c(this.abU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str) {
        try {
            C0636a c0636a = new C0636a();
            c0636a.parseJson(new JSONObject(str));
            if (q(c0636a.url, c0636a.packageName)) {
                return;
            }
            if (this.Pc == null) {
                p(c0636a.url, c0636a.packageName);
            }
            a.C0616a at = new a.C0616a(this.eQ.Ta.getContext()).aq(true).ar(false).aB(this.mAdTemplate).at(false);
            if (this.Pc.s(at)) {
                return;
            }
            this.Pc.d(this.abU);
            this.Pc.r(at);
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    private void o(String str, String str2) {
        WebView webView;
        if (this.abI || TextUtils.isEmpty(str) || (webView = this.Ta) == null) {
            return;
        }
        cc.a(webView, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i6, int i7) {
        this.abW = i7;
        if (this.abV != i6) {
            this.abV = i6;
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            o("onDownLoadStatusCallback", sb.toString());
        }
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.q(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.q(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                a.this.q(4, i6);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                if (i6 == 0) {
                    a.this.q(1, 0);
                } else {
                    a.this.q(2, i6);
                }
            }
        };
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.aQ(str);
            }
        });
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.Ta = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.eQ = bVar;
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.Pc == null) {
            p(str, str2);
        }
        return this.Pc.pB();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.Pc == null) {
            p(str, str2);
        }
        return this.abW;
    }
}
