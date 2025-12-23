package com.tencent.connect.auth;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.work.WorkRequest;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.stub.StubApp;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private String f40255a;

    /* renamed from: b, reason: collision with root package name */
    private b f40256b;

    /* renamed from: c, reason: collision with root package name */
    private IUiListener f40257c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f40258d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f40259e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f40260f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f40261g;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f40262h;

    /* renamed from: i, reason: collision with root package name */
    private String f40263i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.open.c.d f40264j;

    /* renamed from: k, reason: collision with root package name */
    private Context f40265k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.open.web.security.b f40266l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f40267m;

    /* renamed from: n, reason: collision with root package name */
    private int f40268n;

    /* renamed from: o, reason: collision with root package name */
    private String f40269o;

    /* renamed from: p, reason: collision with root package name */
    private String f40270p;

    /* renamed from: q, reason: collision with root package name */
    private long f40271q;

    /* renamed from: r, reason: collision with root package name */
    private long f40272r;

    /* renamed from: s, reason: collision with root package name */
    private HashMap<String, Runnable> f40273s;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    private class C0808a extends WebViewClient {
        private C0808a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f40261g.setVisibility(0);
            a.this.f40271q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.f40269o)) {
                a.this.f40258d.removeCallbacks((Runnable) a.this.f40273s.remove(a.this.f40269o));
            }
            a.this.f40269o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.f40269o);
            a.this.f40273s.put(str, dVar);
            a.this.f40258d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c6 = m.c(str);
                a aVar = a.this;
                aVar.f40267m = aVar.e();
                if (!a.this.f40267m) {
                    if (c6.optString("fail_cb", null) != null) {
                        a.this.a(c6.optString("fail_cb"), "");
                    } else if (c6.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.this.f40255a);
                        sb.append(a.this.f40255a.indexOf("?") > -1 ? ContainerUtils.FIELD_DELIMITER : "?");
                        aVar2.f40255a = sb.toString();
                        a.this.f40255a = a.this.f40255a + "browser_error=1";
                        a.this.f40264j.loadUrl(a.this.f40255a);
                    } else {
                        String optString = c6.optString("redir", null);
                        if (optString != null) {
                            a.this.f40264j.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f40256b.onComplete(m.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f40256b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(268435456);
                    a.this.f40265k.startActivity(intent);
                } catch (Exception e6) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e6);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.f40270p = pathSegments2.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.f40266l.a(a.this.f40264j, str)) {
                    return true;
                }
                SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                pathSegments = Uri.parse(str).getPathSegments();
            } catch (Exception unused2) {
            }
            if (pathSegments.isEmpty()) {
                return true;
            }
            int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
            if (intValue == 0) {
                a.this.f40261g.setVisibility(8);
                a.this.f40264j.setVisibility(0);
            } else if (intValue == 1) {
                a.this.f40261g.setVisibility(0);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f40261g.setVisibility(8);
            if (a.this.f40264j != null) {
                a.this.f40264j.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                a.this.f40258d.removeCallbacks((Runnable) a.this.f40273s.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i6, String str, String str2) {
            super.onReceivedError(webView, i6, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i6 + " | description: " + str);
            if (!m.b(a.this.f40265k)) {
                a.this.f40256b.onError(new UiError(ErrorCode.PrivateError.LOAD_FAIL, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (!a.this.f40269o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f40271q;
                if (a.this.f40268n < 1 && elapsedRealtime < a.this.f40272r) {
                    a.m(a.this);
                    a.this.f40258d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.f40264j.loadUrl(a.this.f40269o);
                        }
                    }, 500L);
                    return;
                } else {
                    a.this.f40264j.loadUrl(a.this.a());
                    return;
                }
            }
            a.this.f40256b.onError(new UiError(i6, str, str2));
            a.this.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f40280a;

        /* renamed from: b, reason: collision with root package name */
        String f40281b;

        /* renamed from: d, reason: collision with root package name */
        private String f40283d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f40284e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f40283d = str;
            this.f40280a = str2;
            this.f40281b = str3;
            this.f40284e = iUiListener;
        }

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
            IUiListener iUiListener = this.f40284e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f40284e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f40283d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f40280a, false);
            IUiListener iUiListener = this.f40284e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f40284e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f40280a;
            } else {
                str = this.f40280a;
            }
            String str2 = str;
            h.a().a(this.f40283d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str2, false);
            a.this.a(str2);
            IUiListener iUiListener = this.f40284e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f40284e = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private b f40286b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f40286b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 1) {
                this.f40286b.a((String) message.obj);
            } else if (i6 == 2) {
                this.f40286b.onCancel();
            } else {
                if (i6 != 3) {
                    return;
                }
                a.b(a.this.f40265k, (String) message.obj);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f40287a;

        public d(String str) {
            this.f40287a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f40287a + " | mRetryUrl: " + a.this.f40269o);
            if (this.f40287a.equals(a.this.f40269o)) {
                a.this.f40256b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", a.this.f40269o));
                a.this.dismiss();
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.f40273s = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b a6 = com.tencent.connect.auth.b.a();
        String c6 = a6.c();
        b.a aVar = new b.a();
        aVar.f40294a = this.f40257c;
        aVar.f40295b = this;
        aVar.f40296c = c6;
        String a7 = a6.a(aVar);
        String str = this.f40255a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b6 = m.b(this.f40255a);
        b6.putString("token_key", c6);
        b6.putString("serial", a7);
        b6.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b6);
        this.f40255a = str2;
        return m.a(this.f40265k, str2);
    }

    static /* synthetic */ int m(a aVar) {
        int i6 = aVar.f40268n;
        aVar.f40268n = i6 + 1;
        return i6;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f40273s.clear();
        this.f40258d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f40265k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e6);
        }
        com.tencent.open.c.d dVar = this.f40264j;
        if (dVar != null) {
            dVar.destroy();
            this.f40264j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f40267m) {
            this.f40256b.onCancel();
        }
        super.onBackPressed();
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f40267m = false;
        this.f40271q = 0L;
        this.f40272r = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f40265k = context;
        this.f40255a = str2;
        this.f40256b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f40258d = new c(this.f40256b, context.getMainLooper());
        this.f40257c = iUiListener;
        this.f40263i = str;
        this.f40266l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    private void b() {
        try {
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.c.d dVar = new com.tencent.open.c.d(this.f40265k);
            this.f40264j = dVar;
            dVar.setLayerType(1, null);
            this.f40264j.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f40265k);
            cVar.setLayoutParams(layoutParams);
            cVar.addView(this.f40264j);
            FrameLayout frameLayout = new FrameLayout(this.f40265k);
            this.f40259e = frameLayout;
            frameLayout.addView(cVar);
            this.f40259e.setBackgroundColor(-1);
            this.f40259e.addView(this.f40261g);
            String string = m.b(this.f40255a).getString(ResIdentify.RES_TYPE_STYLE);
            if (string != null && "qr".equals(string)) {
                a(this.f40259e);
            }
            setContentView(this.f40259e);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.AuthDialog", "onCreateView exception", e6);
            com.tencent.open.a.a(this, this.f40258d);
        }
    }

    private void c() {
        TextView textView;
        this.f40262h = new ProgressBar(this.f40265k);
        this.f40262h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f40260f = new LinearLayout(this.f40265k);
        if (this.f40263i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f40265k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f40260f.setLayoutParams(layoutParams2);
        this.f40260f.addView(this.f40262h);
        if (textView != null) {
            this.f40260f.addView(textView);
        }
        this.f40261g = new FrameLayout(this.f40265k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f40261g.setLayoutParams(layoutParams3);
        this.f40261g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f40261g.addView(this.f40260f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f40264j.setVerticalScrollBarEnabled(false);
        this.f40264j.setHorizontalScrollBarEnabled(false);
        this.f40264j.setWebViewClient(new C0808a());
        this.f40264j.setWebChromeClient(new WebChromeClient());
        this.f40264j.clearFormData();
        this.f40264j.clearSslPreferences();
        this.f40264j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f40264j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action == 0 || action == 1) && !view.hasFocus()) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        WebSettings settings = this.f40264j.getSettings();
        com.tencent.open.web.a.a(this.f40264j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f40265k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f40255a);
        String str = this.f40255a;
        this.f40269o = str;
        this.f40264j.loadUrl(str);
        this.f40264j.setVisibility(4);
        this.f40266l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f40270p) && this.f40270p.length() >= 4) {
            String str2 = this.f40270p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f40255a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f40265k);
        int a6 = com.tencent.connect.avatar.a.a(this.f40265k, 15.6f);
        int a7 = com.tencent.connect.avatar.a.a(this.f40265k, 25.2f);
        int a8 = com.tencent.connect.avatar.a.a(this.f40265k, 10.0f);
        int i6 = a8 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a6 + i6, a7 + i6);
        layoutParams.leftMargin = a8;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(a8, a8, a8, a8);
        imageView.setImageDrawable(m.a("h5_qr_back.png", this.f40265k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f40267m || a.this.f40256b == null) {
                    return;
                }
                a.this.f40256b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d6 = m.d(str);
            int i6 = d6.getInt("type");
            Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), d6.getString("msg"), i6).show();
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f40264j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
