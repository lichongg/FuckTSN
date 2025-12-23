package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends WebView {
    protected void a() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        SLog.i("openSDK_LOG.OpenWebView", "removeJSInterface");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setBuiltInZoomControls(true);
            getSettings().setDisplayZoomControls(false);
            setVisibility(8);
            SLog.i("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e6);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        try {
            Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this, "searchBoxJavaBridge_");
                method.invoke(this, "accessibility");
                method.invoke(this, "accessibilityTraversal");
                SLog.i("openSDK_LOG.OpenWebView", "remove js interface");
            }
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.OpenWebView", "remove js interface.e:" + e6.toString());
        }
    }

    public b(Context context) {
        super(context);
        a();
    }
}
