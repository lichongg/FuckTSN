package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends com.tencent.open.c implements a.InterfaceC0814a {

    /* renamed from: c, reason: collision with root package name */
    static Toast f40560c;

    /* renamed from: d, reason: collision with root package name */
    private String f40561d;

    /* renamed from: e, reason: collision with root package name */
    private IUiListener f40562e;

    /* renamed from: f, reason: collision with root package name */
    private c f40563f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f40564g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.open.c.a f40565h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.open.c.b f40566i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f40567j;

    /* renamed from: k, reason: collision with root package name */
    private int f40568k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) d.this.f40567j.get(), "auth://tauth.qq.com/"))) {
                d.this.f40563f.onComplete(m.c(str));
                d.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                d.this.f40563f.onCancel();
                d.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            d.this.dismiss();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.f40566i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i6, String str, String str2) {
            super.onReceivedError(webView, i6, str, str2);
            d.this.f40563f.onError(new UiError(i6, str, str2));
            if (d.this.f40567j != null && d.this.f40567j.get() != null) {
                Toast.makeText((Context) d.this.f40567j.get(), "网络连接异常或系统错误", 0).show();
            }
            d.this.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends b.C0813b {
        private b() {
        }

        /* synthetic */ b(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f40571a;

        /* renamed from: b, reason: collision with root package name */
        String f40572b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f40573c;

        /* renamed from: d, reason: collision with root package name */
        private String f40574d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f40575e;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e6) {
                e6.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f40575e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f40575e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f40574d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f40571a, false);
            IUiListener iUiListener = this.f40575e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f40575e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f40571a;
            } else {
                str = this.f40571a;
            }
            String str2 = str;
            h.a().a(this.f40574d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str2, false);
            IUiListener iUiListener = this.f40575e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f40575e = null;
            }
        }

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f40573c = new WeakReference<>(context);
            this.f40574d = str;
            this.f40571a = str2;
            this.f40572b = str3;
            this.f40575e = iUiListener;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.d$d, reason: collision with other inner class name */
    private class HandlerC0815d extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private c f40577b;

        public HandlerC0815d(c cVar, Looper looper) {
            super(looper);
            this.f40577b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i6 = message.what;
            if (i6 == 1) {
                this.f40577b.a((String) message.obj);
                return;
            }
            if (i6 == 2) {
                this.f40577b.onCancel();
                return;
            }
            if (i6 == 3) {
                if (d.this.f40567j == null || d.this.f40567j.get() == null) {
                    return;
                }
                d.c((Context) d.this.f40567j.get(), (String) message.obj);
                return;
            }
            if (i6 != 5 || d.this.f40567j == null || d.this.f40567j.get() == null) {
                return;
            }
            d.d((Context) d.this.f40567j.get(), (String) message.obj);
        }
    }

    @Override // com.tencent.open.c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f40566i.setVerticalScrollBarEnabled(false);
        this.f40566i.setHorizontalScrollBarEnabled(false);
        AnonymousClass1 anonymousClass1 = null;
        this.f40566i.setWebViewClient(new a(this, anonymousClass1));
        this.f40566i.setWebChromeClient(this.f40551b);
        this.f40566i.clearFormData();
        WebSettings settings = this.f40566i.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f40566i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f40567j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f40567j.get().getApplicationContext()).getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f40550a.a(new b(this, anonymousClass1), "sdk_js_if");
        this.f40566i.clearView();
        this.f40566i.loadUrl(this.f40561d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d6 = m.d(str);
            d6.getInt(com.umeng.ccg.a.f41544t);
            d6.getString("msg");
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f40567j = new WeakReference<>(context);
        this.f40561d = str2;
        this.f40563f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f40564g = new HandlerC0815d(this.f40563f, context.getMainLooper());
        this.f40562e = iUiListener;
        this.f40568k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f40568k);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.f40567j.get());
        this.f40565h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f40565h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f40567j.get());
        this.f40566i = bVar;
        bVar.setBackgroundColor(0);
        this.f40566i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f40566i, 1, new Paint());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f40568k);
        layoutParams.addRule(13, -1);
        this.f40566i.setLayoutParams(layoutParams);
        this.f40565h.addView(this.f40566i);
        this.f40565h.a(this);
        setContentView(this.f40565h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0814a
    public void a(int i6) {
        WeakReference<Context> weakReference = this.f40567j;
        if (weakReference != null && weakReference.get() != null) {
            if (i6 < this.f40568k && 2 == this.f40567j.get().getResources().getConfiguration().orientation) {
                this.f40566i.getLayoutParams().height = i6;
            } else {
                this.f40566i.getLayoutParams().height = this.f40568k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.c.a.InterfaceC0814a
    public void a() {
        this.f40566i.getLayoutParams().height = this.f40568k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f40550a.a(this.f40566i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d6 = m.d(str);
            int i6 = d6.getInt("type");
            String string = d6.getString("msg");
            if (i6 == 0) {
                Toast toast = f40560c;
                if (toast == null) {
                    f40560c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f40560c.setText(string);
                    f40560c.setDuration(0);
                }
                f40560c.show();
                return;
            }
            if (i6 == 1) {
                Toast toast2 = f40560c;
                if (toast2 == null) {
                    f40560c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f40560c.setText(string);
                    f40560c.setDuration(1);
                }
                f40560c.show();
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }
}
