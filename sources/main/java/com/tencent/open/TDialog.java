package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TDialog extends c {

    /* renamed from: c, reason: collision with root package name */
    static final FrameLayout.LayoutParams f40465c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    static Toast f40466d = null;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<ProgressDialog> f40467f;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f40468e;

    /* renamed from: g, reason: collision with root package name */
    private String f40469g;

    /* renamed from: h, reason: collision with root package name */
    private OnTimeListener f40470h;

    /* renamed from: i, reason: collision with root package name */
    private IUiListener f40471i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f40472j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.open.c.b f40473k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f40474l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f40475m;

    /* renamed from: n, reason: collision with root package name */
    private QQToken f40476n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) TDialog.this.f40468e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f40470h.onComplete(m.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f40470h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(268435456);
                if (TDialog.this.f40468e != null && TDialog.this.f40468e.get() != null) {
                    ((Context) TDialog.this.f40468e.get()).startActivity(intent);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f40473k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i6, String str, String str2) {
            super.onReceivedError(webView, i6, str, str2);
            TDialog.this.f40470h.onError(new UiError(i6, str, str2));
            if (TDialog.this.f40468e != null && TDialog.this.f40468e.get() != null) {
                Toast.makeText((Context) TDialog.this.f40468e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class JsListener extends b.C0813b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f40474l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CommonNetImpl.CANCEL);
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f40474l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onLoad(String str) {
            TDialog.this.f40474l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f40474l.obtainMessage(3, str).sendToTarget();
        }

        public void onInvite(String str) {
            onComplete(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f40480a;

        /* renamed from: b, reason: collision with root package name */
        String f40481b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f40482c;

        /* renamed from: d, reason: collision with root package name */
        private String f40483d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f40484e;

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
            IUiListener iUiListener = this.f40484e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f40484e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f40483d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f40480a, false);
            IUiListener iUiListener = this.f40484e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f40484e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f40480a;
            } else {
                str = this.f40480a;
            }
            String str2 = str;
            h.a().a(this.f40483d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str2, false);
            IUiListener iUiListener = this.f40484e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f40484e = null;
            }
        }

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f40482c = new WeakReference<>(context);
            this.f40483d = str;
            this.f40480a = str2;
            this.f40481b = str3;
            this.f40484e = iUiListener;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class THandler extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private OnTimeListener f40486b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f40486b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i6 = message.what;
            if (i6 == 1) {
                this.f40486b.a((String) message.obj);
                return;
            }
            if (i6 == 2) {
                this.f40486b.onCancel();
                return;
            }
            if (i6 == 3) {
                if (TDialog.this.f40468e == null || TDialog.this.f40468e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.f40468e.get(), (String) message.obj);
                return;
            }
            if (i6 != 5 || TDialog.this.f40468e == null || TDialog.this.f40468e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.f40468e.get(), (String) message.obj);
        }
    }

    @Override // com.tencent.open.c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a.a(getWindow());
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d6 = m.d(str);
            int i6 = d6.getInt("type");
            String string = d6.getString("msg");
            if (i6 == 0) {
                Toast toast = f40466d;
                if (toast == null) {
                    f40466d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f40466d.setText(string);
                    f40466d.setDuration(0);
                }
                f40466d.show();
                return;
            }
            if (i6 == 1) {
                Toast toast2 = f40466d;
                if (toast2 == null) {
                    f40466d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f40466d.setText(string);
                    f40466d.setDuration(1);
                }
                f40466d.show();
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        WeakReference<ProgressDialog> weakReference;
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d6 = m.d(str);
            int i6 = d6.getInt(com.umeng.ccg.a.f41544t);
            String string = d6.getString("msg");
            if (i6 != 1) {
                if (i6 != 0 || (weakReference = f40467f) == null || weakReference.get() == null || !f40467f.get().isShowing()) {
                    return;
                }
                f40467f.get().dismiss();
                f40467f = null;
                return;
            }
            WeakReference<ProgressDialog> weakReference2 = f40467f;
            if (weakReference2 != null && weakReference2.get() != null) {
                f40467f.get().setMessage(string);
                if (f40467f.get().isShowing()) {
                    return;
                }
                f40467f.get().show();
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(string);
            f40467f = new WeakReference<>(progressDialog);
            progressDialog.show();
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f40470h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f40475m = false;
        this.f40476n = null;
        this.f40468e = new WeakReference<>(context);
        this.f40469g = str2;
        this.f40470h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f40474l = new THandler(this.f40470h, context.getMainLooper());
        this.f40471i = iUiListener;
        this.f40476n = qQToken;
    }

    private void a() {
        try {
            new TextView(this.f40468e.get()).setText("test");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f40468e.get());
            this.f40473k = bVar;
            bVar.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f40468e.get());
            this.f40472j = cVar;
            cVar.setLayoutParams(layoutParams);
            this.f40472j.setBackgroundColor(-1);
            this.f40472j.addView(this.f40473k);
            setContentView(this.f40472j);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.TDialog", "onCreateView exception", th);
            a.a(this, this.f40474l);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f40473k.setVerticalScrollBarEnabled(false);
        this.f40473k.setHorizontalScrollBarEnabled(false);
        this.f40473k.setWebViewClient(new FbWebViewClient());
        this.f40473k.setWebChromeClient(this.f40551b);
        this.f40473k.clearFormData();
        WebSettings settings = this.f40473k.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f40473k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f40468e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f40468e.get().getApplicationContext()).getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f40550a.a(new JsListener(), "sdk_js_if");
        this.f40473k.loadUrl(this.f40469g);
        this.f40473k.setLayoutParams(f40465c);
        this.f40473k.setVisibility(4);
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f40550a.a(this.f40473k, str);
        } catch (Exception unused) {
        }
    }
}
