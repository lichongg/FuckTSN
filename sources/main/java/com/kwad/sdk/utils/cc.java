package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cc {
    public static void a(WebView webView, String str, String str2) {
        a(webView, "javascript:" + str + "(" + JSONObject.quote(str2) + ")", (ValueCallback<String>) null);
    }

    private static void a(final WebView webView, final String str, ValueCallback<String> valueCallback) {
        final ValueCallback valueCallback2 = null;
        runOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.cc.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    webView.evaluateJavascript(str, valueCallback2);
                } catch (Exception unused) {
                }
            }
        });
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
