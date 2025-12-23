package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.os.Looper;
import android.webkit.WebView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    private static final j f26893j = new xt(null);

    /* renamed from: com.bytedance.sdk.component.utils.qv$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {
        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void j(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            qv.xt(new Runnable() { // from class: com.bytedance.sdk.component.utils.qv.j.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @TargetApi(19)
    private static class xt extends j {
        private xt() {
            super(null);
        }

        /* synthetic */ xt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.sdk.component.utils.qv.j
        public void j(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            qv.xt(new Runnable() { // from class: com.bytedance.sdk.component.utils.qv.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            return;
                        } catch (Throwable th) {
                            boolean z5 = th instanceof IllegalStateException;
                        }
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Deprecated
    public static void j(WebView webView, String str) {
        f26893j.j(webView, str);
    }

    public static void j(com.bytedance.sdk.component.jy.cw cwVar, String str) {
        f26893j.j(cwVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            tl.xt().post(runnable);
        }
    }
}
