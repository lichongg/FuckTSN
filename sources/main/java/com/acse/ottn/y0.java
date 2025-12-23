package com.acse.ottn;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.widget.CustomWebView;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class y0 {

    /* renamed from: d, reason: collision with root package name */
    public static y0 f5511d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f5512e = "ExcessActivity";

    /* renamed from: a, reason: collision with root package name */
    public Activity f5513a;

    /* renamed from: b, reason: collision with root package name */
    public CustomWebView f5514b;

    /* renamed from: c, reason: collision with root package name */
    public c f5515c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5516a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5517b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5518c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f5519d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f5520e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.y0$a$a, reason: collision with other inner class name */
        public class RunnableC0086a implements Runnable {
            public RunnableC0086a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y0.this.f5513a.finishAndRemoveTask();
            }
        }

        public a(String str, String str2, String str3, String str4, int i6) {
            this.f5516a = str;
            this.f5517b = str2;
            this.f5518c = str3;
            this.f5519d = str4;
            this.f5520e = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f5516a)) {
                AccessiblityModel accessiblityModel = new AccessiblityModel();
                accessiblityModel.getData().setSpop_deeplink(this.f5516a);
                accessiblityModel.getData().setSpop_link(this.f5517b);
                accessiblityModel.getData().setPackage_name(this.f5518c);
                accessiblityModel.getData().setJump_type(this.f5519d);
                h4.c().a(y0.this.f5513a, accessiblityModel);
            }
            new Handler().postDelayed(new RunnableC0086a(), this.f5520e);
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
    public class c extends WebChromeClient {
        public c() {
        }

        public /* synthetic */ c(y0 y0Var, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            super.onProgressChanged(webView, i6);
        }
    }

    public static y0 a() {
        if (f5511d == null) {
            synchronized (y0.class) {
                try {
                    if (f5511d == null) {
                        f5511d = new y0();
                    }
                } finally {
                }
            }
        }
        return f5511d;
    }

    public final Object b() throws ObjectStreamException {
        return f5511d;
    }

    public void a(Activity activity) {
        this.f5513a = activity;
        this.f5514b = (CustomWebView) activity.findViewById(R.id.dwebView);
        String stringExtra = this.f5513a.getIntent().getStringExtra("password");
        String stringExtra2 = this.f5513a.getIntent().getStringExtra("link");
        String stringExtra3 = this.f5513a.getIntent().getStringExtra("deeplink");
        String stringExtra4 = this.f5513a.getIntent().getStringExtra("origin_url");
        String stringExtra5 = this.f5513a.getIntent().getStringExtra("jump_type");
        String stringExtra6 = this.f5513a.getIntent().getStringExtra(CommonNetImpl.NAME);
        int intExtra = this.f5513a.getIntent().getIntExtra("time", 100);
        int intExtra2 = this.f5513a.getIntent().getIntExtra("dissmiss_time", 0);
        if (!TextUtils.isEmpty(stringExtra)) {
            n.c().a(this.f5513a, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra4)) {
            c2.a(f5512e, "loadH5Url = " + stringExtra4);
            a(stringExtra4);
        } else {
            c2.a(f5512e, "origin_url is null");
        }
        new Handler().postDelayed(new a(stringExtra3, stringExtra2, stringExtra6, stringExtra5, intExtra2), intExtra);
    }

    public final void a(String str) {
        try {
            CustomWebView customWebView = this.f5514b;
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
            c cVar = new c(this, null);
            this.f5515c = cVar;
            this.f5514b.setWebChromeClient(cVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f5514b.setWebViewClient(new b());
            this.f5514b.loadUrl(str);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}
