package com.bytedance.sdk.openadsdk.az;

import android.os.Build;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static void j(com.bytedance.sdk.component.jy.cw cwVar) {
        xt(cwVar);
        try {
            cwVar.setJavaScriptEnabled(true);
            cwVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            ae.j("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            cwVar.setSupportZoom(false);
        } catch (Throwable th2) {
            ae.j("WebViewSettings", "setSupportZoom error", th2);
        }
        cwVar.setLoadWithOverviewMode(true);
        cwVar.setUseWideViewPort(true);
        cwVar.setDomStorageEnabled(true);
        cwVar.setAllowFileAccess(false);
        cwVar.setBlockNetworkImage(false);
        cwVar.setDisplayZoomControls(false);
        int i6 = Build.VERSION.SDK_INT;
        cwVar.setAllowFileAccessFromFileURLs(false);
        cwVar.setAllowUniversalAccessFromFileURLs(false);
        cwVar.setSavePassword(false);
        boolean z5 = i6 >= 28;
        try {
        } catch (Throwable th3) {
            ae.j("WebViewSettings", "setLayerType error", th3);
        }
        if (z5) {
            if (z5) {
                cwVar.setLayerType(2, null);
            }
            cwVar.setMixedContentMode(0);
        }
        cwVar.setLayerType(0, null);
        cwVar.setMixedContentMode(0);
    }

    private static void xt(com.bytedance.sdk.component.jy.cw cwVar) {
        try {
            cwVar.removeJavascriptInterface("searchBoxJavaBridge_");
            cwVar.removeJavascriptInterface("accessibility");
            cwVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            ae.j("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }
}
