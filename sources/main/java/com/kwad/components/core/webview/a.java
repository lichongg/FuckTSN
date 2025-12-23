package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.cc;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private WebView Ta;
    private final Map<String, com.kwad.sdk.core.webview.c.a> abG = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.c.a abH = new d();
    private boolean abI;

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2) {
        if (this.abI) {
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback is empty");
                return;
            }
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.Ta;
            if (webView == null) {
                return;
            }
            cc.a(webView, str, str2);
        }
    }

    private void um() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new ab());
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.abG.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.abG.put(aVar.getKey(), aVar);
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.abG.get(bVar.aNF);
            if (aVar == null) {
                aVar = this.abH;
            }
            WebView webView = this.Ta;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.aNF, bVar.data);
            }
            if (aVar != null) {
                aVar.a(bVar.data, !TextUtils.isEmpty(bVar.aNG) ? new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                        a.this.o(bVar.aNG, new f(bVar2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void onError(int i6, String str2) {
                        a.this.o(bVar.aNG, new e(i6, str2).toJson().toString());
                    }
                } : new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void onError(int i6, String str2) {
                    }
                });
            } else {
                com.kwad.sdk.core.d.c.e("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "callAdBridge JSONException:" + e6);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.d.c.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.c.a>> it = this.abG.entrySet().iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.webview.c.a value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.abI = true;
    }

    public a(WebView webView) {
        this.Ta = webView;
        um();
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (!TextUtils.isEmpty(aVar.getKey())) {
            this.abG.put(aVar.getKey(), aVar);
        } else {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        }
    }
}
