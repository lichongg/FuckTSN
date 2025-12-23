package com.acse.ottn.service;

import android.R;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.acse.ottn.c2;
import com.acse.ottn.m0;
import com.acse.ottn.n;
import com.acse.ottn.widget.CustomWebView;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WebViewService extends Service {

    /* renamed from: f, reason: collision with root package name */
    public static View f5148f = null;

    /* renamed from: g, reason: collision with root package name */
    public static WindowManager f5149g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f5150h = "WebViewService";

    /* renamed from: i, reason: collision with root package name */
    public static TimerTask f5151i;

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f5152a;

    /* renamed from: b, reason: collision with root package name */
    public CustomWebView f5153b;

    /* renamed from: c, reason: collision with root package name */
    public d f5154c;

    /* renamed from: d, reason: collision with root package name */
    public int f5155d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5156e = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.service.WebViewService$a$a, reason: collision with other inner class name */
        public class RunnableC0083a implements Runnable {
            public RunnableC0083a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebViewService.c();
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(WebViewService.f5150h, "结束了");
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0083a(), 0L);
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

        public /* synthetic */ d(WebViewService webViewService, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            super.onProgressChanged(webView, i6);
        }
    }

    static {
        StubApp.interface11(9614);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        this.f5152a = new WindowManager.LayoutParams();
        f5149g = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5152a.type = 2038;
        } else {
            this.f5152a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f5152a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

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

    public static void a(int i6) {
        f5151i = m0.a().b(i6, 1000, new a());
    }

    public static void c() {
        try {
            View view = f5148f;
            if (view != null) {
                view.setVisibility(8);
            }
            f5149g.removeView(f5148f);
        } catch (Exception e6) {
            c2.a(f5150h, "dismiss e=" + e6.getMessage());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        try {
            String stringExtra = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                b(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("shortLink");
            if (!TextUtils.isEmpty(stringExtra2)) {
                n.c().a(this, stringExtra2);
            }
        } catch (Exception e6) {
            c2.a(f5150h, "Exception =" + e6.getMessage());
        }
        return super.onStartCommand(intent, i6, i7);
    }

    public static int a(Context context, int i6) {
        return (int) (i6 * context.getResources().getDisplayMetrics().density);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c2.c(f5150h, "MainService Created");
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            com.acse.ottn.service.a.b();
            com.acse.ottn.service.a.d();
            View view = f5148f;
            if (view != null) {
                f5149g.removeView(view);
            }
        } catch (Exception e6) {
            c2.c(f5150h, "onDestroy e=" + e6.getMessage());
        }
        super.onDestroy();
    }

    public final void a(String str) {
        c2.a(f5150h, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.f5153b;
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
            this.f5154c = dVar;
            this.f5153b.setWebChromeClient(dVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f5153b.setWebViewClient(new b());
            this.f5153b.loadUrl(str);
        } catch (IllegalArgumentException e6) {
            c2.a(f5150h, "IllegalArgumentException=" + e6.getMessage());
            e6.printStackTrace();
        } catch (Exception e7) {
            c2.a(f5150h, "Exception=" + e7.getMessage());
            e7.printStackTrace();
        }
    }

    public final void b(String str) {
        c2.a(f5150h, "webview悬浮窗");
        b(com.acse.ottn.R.layout.webview_service);
        this.f5153b = (CustomWebView) f5148f.findViewById(com.acse.ottn.R.id.dwebView);
        this.f5152a.height = -1;
        a(str);
        try {
            f5149g.addView(f5148f, this.f5152a);
        } catch (Exception e6) {
            c2.a(f5150h, "添加失败 e=" + e6.getMessage());
        }
        a(5000);
    }

    public final void b(int i6) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i6, (ViewGroup) null);
            f5148f = inflate;
            inflate.measure(0, 0);
        } catch (Exception e6) {
            c2.a(f5150h, "setLayoutView e = " + e6.getMessage());
        }
    }
}
