package com.beizi.fusion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.beizi.fusion.c.b;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.e;
import com.beizi.fusion.tool.v;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JSView extends WebView {

    /* renamed from: a, reason: collision with root package name */
    private static String f13887a = "JSView";

    /* renamed from: b, reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f13888b;

    /* renamed from: c, reason: collision with root package name */
    private int f13889c;

    /* renamed from: d, reason: collision with root package name */
    private Context f13890d;

    /* renamed from: e, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f13891e;

    public JSView(Context context) {
        this(context, null);
    }

    public JSView(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this(context, null, 0);
        this.f13890d = context;
        this.f13888b = backTaskArrayBean;
        this.f13889c = backTaskArrayBean.getRepeatCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        EventCar.getInstance(this.f13890d).goRoad(new EventBean(b.f13294b, "", "510.500", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            EventCar.getInstance(this.f13890d).goRoad(new EventBean(b.f13294b, "", "510.200", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            clearCache(true);
            clearHistory();
            clearFormData();
            destroy();
            Handler handler = this.f13891e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void load() {
        TaskBean.BackTaskArrayBean backTaskArrayBean = this.f13888b;
        if (backTaskArrayBean == null || TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            return;
        }
        loadUrl(this.f13888b.getContentUrl());
        this.f13889c--;
    }

    public void init() {
        WebSettings settings = getSettings();
        settings.setSavePassword(false);
        WebView.setWebContentsDebuggingEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        setWebChromeClient(new WebChromeClient() { // from class: com.beizi.fusion.widget.JSView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i6) {
            }
        });
        setWebViewClient(new WebViewClient() { // from class: com.beizi.fusion.widget.JSView.3
            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 19)
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                List<String> action = JSView.this.f13888b.getAction();
                if (action != null && action.size() > 0) {
                    for (int i6 = 0; i6 < action.size(); i6++) {
                        if (!TextUtils.isEmpty(action.get(i6))) {
                            JSView.this.evaluateJavascript("javascript:" + action.get(i6) + "()", new ValueCallback<String>() { // from class: com.beizi.fusion.widget.JSView.3.1
                                @Override // android.webkit.ValueCallback
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public void onReceiveValue(String str2) {
                                }
                            });
                        }
                    }
                }
                e.b().e().execute(new Runnable() { // from class: com.beizi.fusion.widget.JSView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> report;
                        if (JSView.this.f13888b == null || (report = JSView.this.f13888b.getReport()) == null || report.size() <= 0) {
                            return;
                        }
                        for (int i7 = 0; i7 < report.size(); i7++) {
                            if (!TextUtils.isEmpty(report.get(i7))) {
                                if (v.a(ao.a(JSView.this.f13890d, report.get(i7), null), JSView.this.f13888b.getUserAgent()) != null) {
                                    EventCar.getInstance(JSView.this.f13890d).goRoadWithoutThread(new EventBean(b.f13294b, "", "520.200", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                } else {
                                    EventCar.getInstance(JSView.this.f13890d).goRoadWithoutThread(new EventBean(b.f13294b, "", "520.500", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                }
                                try {
                                    Thread.sleep(JSView.this.f13888b.getSleepTime());
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                    }
                });
                JSView.this.f13891e.sendEmptyMessageDelayed(1, JSView.this.f13888b.getShowTime());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                JSView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                JSView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                JSView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    public JSView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13889c = 1;
        this.f13891e = new Handler() { // from class: com.beizi.fusion.widget.JSView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                if (JSView.this.f13889c <= 0) {
                    JSView.this.b();
                } else {
                    JSView.this.load();
                }
            }
        };
        try {
            init();
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
