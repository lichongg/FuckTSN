package com.acse.ottn.activity;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.acse.ottn.c2;
import com.acse.ottn.widget.CustomWebView;
import com.acse.ottn.z;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SeedWebViewActivity extends z {

    /* renamed from: g, reason: collision with root package name */
    public static final String f4156g = "SeedWebViewActivity";

    /* renamed from: e, reason: collision with root package name */
    public CustomWebView f4157e;

    /* renamed from: f, reason: collision with root package name */
    public d f4158f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SeedWebViewActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d extends WebChromeClient {
        public d() {
        }

        public /* synthetic */ d(SeedWebViewActivity seedWebViewActivity, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            super.onProgressChanged(webView, i6);
        }
    }

    static {
        StubApp.interface11(9029);
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends FrameLayout {
        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        public c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(R.color.black));
        }
    }

    public final void a(String str) {
        c2.a(f4156g, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.f4157e;
            if (customWebView == null) {
                return;
            }
            WebSettings settings = customWebView.getSettings();
            settings.setTextZoom(100);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setMixedContentMode(0);
            d dVar = new d(this, null);
            this.f4158f = dVar;
            this.f4157e.setWebChromeClient(dVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f4157e.setWebViewClient(new b());
            this.f4157e.loadUrl(str);
        } catch (IllegalArgumentException e6) {
            c2.a(f4156g, "IllegalArgumentException=" + e6.getMessage());
            e6.printStackTrace();
        } catch (Exception e7) {
            c2.a(f4156g, "Exception=" + e7.getMessage());
            e7.printStackTrace();
        }
    }
}
