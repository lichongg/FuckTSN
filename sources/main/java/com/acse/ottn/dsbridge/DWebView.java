package com.acse.ottn.dsbridge;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.c2;
import com.acse.ottn.l0;
import com.acse.ottn.z2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DWebView extends WebView {

    /* renamed from: l, reason: collision with root package name */
    public static final String f4446l = "_dsbridge";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4447m = "dsBridge";

    /* renamed from: n, reason: collision with root package name */
    public static boolean f4448n;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Object> f4449a;

    /* renamed from: b, reason: collision with root package name */
    public String f4450b;

    /* renamed from: c, reason: collision with root package name */
    public int f4451c;

    /* renamed from: d, reason: collision with root package name */
    public WebChromeClient f4452d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f4453e;

    /* renamed from: f, reason: collision with root package name */
    public g f4454f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<e> f4455g;

    /* renamed from: h, reason: collision with root package name */
    public InnerJavascriptInterface f4456h;

    /* renamed from: i, reason: collision with root package name */
    public Handler f4457i;

    /* renamed from: j, reason: collision with root package name */
    public Map<Integer, z2> f4458j;

    /* renamed from: k, reason: collision with root package name */
    public WebChromeClient f4459k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class InnerJavascriptInterface {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements l0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f4473a;

            @Override // com.acse.ottn.l0
            public void a() {
                a(null, true);
            }

            @Override // com.acse.ottn.l0
            public void b(Object obj) {
                a(obj, true);
            }

            public a(String str) {
                this.f4473a = str;
            }

            @Override // com.acse.ottn.l0
            public void a(Object obj) {
                a(obj, false);
            }

            public final void a(Object obj, boolean z5) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("data", obj);
                    String str = this.f4473a;
                    if (str != null) {
                        String format = String.format("%s(%s.data);", str, jSONObject.toString());
                        if (z5) {
                            format = format + "delete window." + this.f4473a;
                        }
                        DWebView.this.b(format);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }

        public InnerJavascriptInterface() {
        }

        public final void a(String str) {
            c2.a(DWebView.f4447m, str);
            if (DWebView.f4448n) {
                DWebView.this.b(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
        @android.webkit.JavascriptInterface
        @androidx.annotation.Keep
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call(java.lang.String r14, java.lang.String r15) {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.dsbridge.DWebView.InnerJavascriptInterface.call(java.lang.String, java.lang.String):java.lang.String");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4475a;

        public a(String str) {
            this.f4475a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.a(this.f4475a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4477a;

        public b(String str) {
            this.f4477a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f4477a;
            if (str != null && str.startsWith("javascript:")) {
                DWebView.super.loadUrl(this.f4477a);
                return;
            }
            DWebView.this.f4455g = new ArrayList();
            DWebView.super.loadUrl(this.f4477a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4479a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f4480b;

        public c(String str, Map map) {
            this.f4479a = str;
            this.f4480b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f4479a;
            if (str != null && str.startsWith("javascript:")) {
                DWebView.super.loadUrl(this.f4479a, this.f4480b);
                return;
            }
            DWebView.this.f4455g = new ArrayList();
            DWebView.super.loadUrl(this.f4479a, this.f4480b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.f4455g = new ArrayList();
            DWebView.super.reload();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f4483a;

        /* renamed from: b, reason: collision with root package name */
        public int f4484b;

        /* renamed from: c, reason: collision with root package name */
        public String f4485c;

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.f4485c);
                jSONObject.put("callbackId", this.f4484b);
                jSONObject.put("data", this.f4483a);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            return jSONObject.toString();
        }

        public e(String str, int i6, Object[] objArr) {
            this.f4483a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.f4484b = i6;
            this.f4485c = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Deprecated
    public interface f {
        @TargetApi(11)
        void a(ValueCallback valueCallback, String str);

        @TargetApi(16)
        void a(ValueCallback<Uri> valueCallback, String str, String str2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        boolean onClose();
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4449a = new HashMap();
        this.f4451c = 0;
        this.f4453e = true;
        this.f4454f = null;
        this.f4456h = new InnerJavascriptInterface();
        this.f4457i = new Handler(Looper.getMainLooper());
        this.f4458j = new HashMap();
        this.f4459k = new WebChromeClient() { // from class: com.acse.ottn.dsbridge.DWebView.6

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$6$a */
            public class a implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f4465a;

                public a(JsResult jsResult) {
                    this.f4465a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    dialogInterface.dismiss();
                    if (DWebView.this.f4453e) {
                        this.f4465a.confirm();
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$6$b */
            public class b implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f4467a;

                public b(JsResult jsResult) {
                    this.f4467a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    if (DWebView.this.f4453e) {
                        if (i6 == -1) {
                            this.f4467a.confirm();
                        } else {
                            this.f4467a.cancel();
                        }
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$6$c */
            public class c implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsPromptResult f4469a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ EditText f4470b;

                public c(JsPromptResult jsPromptResult, EditText editText) {
                    this.f4469a = jsPromptResult;
                    this.f4470b = editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    if (DWebView.this.f4453e) {
                        if (i6 == -1) {
                            this.f4469a.confirm(this.f4470b.getText().toString());
                        } else {
                            this.f4469a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i6, String str2) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onConsoleMessage(str, i6, str2);
                } else {
                    super.onConsoleMessage(str, i6, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (DWebView.this.f4452d instanceof f) {
                    ((f) DWebView.this.f4452d).a(valueCallback, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z5, boolean z6, Message message) {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onCreateWindow(webView, z5, z6, message) : super.onCreateWindow(webView, z5, z6, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j6, long j7, long j8, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onExceededDatabaseQuota(str, str2, j6, j7, j8, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j6, j7, j8, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f4453e) {
                    jsResult.confirm();
                }
                if (DWebView.this.f4452d != null && DWebView.this.f4452d.onJsAlert(webView, str, str2, jsResult)) {
                    return true;
                }
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new a(jsResult)).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f4453e) {
                    jsResult.confirm();
                }
                if (DWebView.this.f4452d != null && DWebView.this.f4452d.onJsConfirm(webView, str, str2, jsResult)) {
                    return true;
                }
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                String str4;
                String str5;
                JsPromptResult jsPromptResult2;
                if (!DWebView.this.f4453e) {
                    jsPromptResult.confirm();
                }
                if (DWebView.this.f4452d != null) {
                    str4 = str2;
                    str5 = str3;
                    jsPromptResult2 = jsPromptResult;
                    if (DWebView.this.f4452d.onJsPrompt(webView, str, str4, str5, jsPromptResult2)) {
                        return true;
                    }
                } else {
                    str4 = str2;
                    str5 = str3;
                    jsPromptResult2 = jsPromptResult;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str5);
                if (str5 != null) {
                    editText.setSelection(str5.length());
                }
                float f6 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult2, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str4).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i6 = (int) (16.0f * f6);
                layoutParams.setMargins(i6, 0, i6, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i7 = (int) (15.0f * f6);
                editText.setPadding(i7 - ((int) (f6 * 5.0f)), i7, i7, i7);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i6) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onProgressChanged(webView, i6);
                } else {
                    super.onProgressChanged(webView, i6);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z5) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onReceivedTouchIconUrl(webView, str, z5);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z5);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (DWebView.this.f4452d instanceof f) {
                    ((f) DWebView.this.f4452d).a(valueCallback, str, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.f4452d != null) {
                    return DWebView.this.f4452d.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i6, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onShowCustomView(view, i6, customViewCallback);
                } else {
                    super.onShowCustomView(view, i6, customViewCallback);
                }
            }
        };
        c();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(new b(str));
    }

    @Keep
    private void addInternalJavascriptObject() {
        a(new Object() { // from class: com.acse.ottn.dsbridge.DWebView.1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$1$a */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DWebView.this.f4454f == null || DWebView.this.f4454f.onClose()) {
                        Context context = DWebView.this.getContext();
                        if (context instanceof Activity) {
                            ((Activity) context).onBackPressed();
                        }
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$1$b */
            public class b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Object f4462a;

                public b(Object obj) {
                    this.f4462a = obj;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = (JSONObject) this.f4462a;
                    try {
                        int i6 = jSONObject.getInt("id");
                        boolean z5 = jSONObject.getBoolean("complete");
                        z2 z2Var = DWebView.this.f4458j.get(Integer.valueOf(i6));
                        Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
                        if (z2Var != null) {
                            z2Var.a(obj);
                            if (z5) {
                                DWebView.this.f4458j.remove(Integer.valueOf(i6));
                            }
                        }
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                }
            }

            @JavascriptInterface
            @Keep
            public String closePage(Object obj) throws JSONException {
                DWebView.this.a(new a());
                return null;
            }

            @JavascriptInterface
            @Keep
            public void disableJavascriptDialogBlock(Object obj) throws JSONException {
                DWebView.this.f4453e = !((JSONObject) obj).getBoolean("disable");
            }

            @JavascriptInterface
            @Keep
            public void dsinit(Object obj) {
                DWebView.this.b();
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0053  */
            @android.webkit.JavascriptInterface
            @androidx.annotation.Keep
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean hasNativeMethod(java.lang.Object r9) throws org.json.JSONException {
                /*
                    r8 = this;
                    java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                    org.json.JSONObject r9 = (org.json.JSONObject) r9
                    java.lang.String r1 = "name"
                    java.lang.String r1 = r9.getString(r1)
                    java.lang.String r1 = r1.trim()
                    java.lang.String r2 = "type"
                    java.lang.String r9 = r9.getString(r2)
                    java.lang.String r9 = r9.trim()
                    com.acse.ottn.dsbridge.DWebView r2 = com.acse.ottn.dsbridge.DWebView.this
                    java.lang.String[] r1 = com.acse.ottn.dsbridge.DWebView.c(r2, r1)
                    com.acse.ottn.dsbridge.DWebView r2 = com.acse.ottn.dsbridge.DWebView.this
                    java.util.Map r2 = com.acse.ottn.dsbridge.DWebView.d(r2)
                    r3 = 0
                    r4 = r1[r3]
                    java.lang.Object r2 = r2.get(r4)
                    if (r2 == 0) goto L7b
                    java.lang.Class r2 = r2.getClass()
                    r4 = 1
                    r5 = r1[r4]     // Catch: java.lang.Exception -> L43
                    r6 = 2
                    java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L43
                    r6[r3] = r0     // Catch: java.lang.Exception -> L43
                    java.lang.Class<com.acse.ottn.l0> r7 = com.acse.ottn.l0.class
                    r6[r4] = r7     // Catch: java.lang.Exception -> L43
                    java.lang.reflect.Method r0 = r2.getMethod(r5, r6)     // Catch: java.lang.Exception -> L43
                    r1 = 1
                    goto L51
                L43:
                    r1 = r1[r4]     // Catch: java.lang.Exception -> L4f
                    java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L4f
                    r5[r3] = r0     // Catch: java.lang.Exception -> L4f
                    java.lang.reflect.Method r0 = r2.getMethod(r1, r5)     // Catch: java.lang.Exception -> L4f
                L4d:
                    r1 = 0
                    goto L51
                L4f:
                    r0 = 0
                    goto L4d
                L51:
                    if (r0 == 0) goto L7b
                    java.lang.Class<android.webkit.JavascriptInterface> r2 = android.webkit.JavascriptInterface.class
                    java.lang.annotation.Annotation r0 = r0.getAnnotation(r2)
                    android.webkit.JavascriptInterface r0 = (android.webkit.JavascriptInterface) r0
                    if (r0 != 0) goto L5e
                    return r3
                L5e:
                    java.lang.String r0 = "all"
                    boolean r0 = r0.equals(r9)
                    if (r0 != 0) goto L7a
                    if (r1 == 0) goto L70
                    java.lang.String r0 = "asyn"
                    boolean r0 = r0.equals(r9)
                    if (r0 != 0) goto L7a
                L70:
                    if (r1 != 0) goto L7b
                    java.lang.String r0 = "syn"
                    boolean r9 = r0.equals(r9)
                    if (r9 == 0) goto L7b
                L7a:
                    return r4
                L7b:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.dsbridge.DWebView.AnonymousClass1.hasNativeMethod(java.lang.Object):boolean");
            }

            @JavascriptInterface
            @Keep
            public void returnValue(Object obj) {
                DWebView.this.a(new b(obj));
            }
        }, "_dsb");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        a(new c(str, map));
    }

    @Override // android.webkit.WebView
    public void reload() {
        a(new d());
    }

    public void setJavascriptCloseWindowListener(g gVar) {
        this.f4454f = gVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f4452d = webChromeClient;
    }

    public static void setWebContentsDebuggingEnabled(boolean z5) {
        WebView.setWebContentsDebuggingEnabled(z5);
        f4448n = z5;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public final void c() {
        this.f4450b = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        settings.setMixedContentMode(0);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.f4459k);
        addInternalJavascriptObject();
        super.addJavascriptInterface(this.f4456h, f4446l);
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z5) {
        super.clearCache(z5);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        File file = new File(this.f4450b);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            a(file2);
        }
        if (file.exists()) {
            a(file);
        }
    }

    public void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f4449a.remove(str);
    }

    public void b(String str) {
        a(new a(str));
    }

    public final synchronized void b() {
        try {
            ArrayList<e> arrayList = this.f4455g;
            if (arrayList != null) {
                Iterator<e> it = arrayList.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.f4455g = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(String str) {
        super.evaluateJavascript(str, null);
    }

    public void b(String str, z2<Boolean> z2Var) {
        a("_hasJavascriptMethod", new Object[]{str}, z2Var);
    }

    public final void a(e eVar) {
        b(String.format("window._handleMessageFromNative(%s)", eVar.toString()));
    }

    public DWebView(Context context) {
        super(context);
        this.f4449a = new HashMap();
        this.f4451c = 0;
        this.f4453e = true;
        this.f4454f = null;
        this.f4456h = new InnerJavascriptInterface();
        this.f4457i = new Handler(Looper.getMainLooper());
        this.f4458j = new HashMap();
        this.f4459k = new WebChromeClient() { // from class: com.acse.ottn.dsbridge.DWebView.6

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$6$a */
            public class a implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f4465a;

                public a(JsResult jsResult) {
                    this.f4465a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    dialogInterface.dismiss();
                    if (DWebView.this.f4453e) {
                        this.f4465a.confirm();
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$6$b */
            public class b implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f4467a;

                public b(JsResult jsResult) {
                    this.f4467a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    if (DWebView.this.f4453e) {
                        if (i6 == -1) {
                            this.f4467a.confirm();
                        } else {
                            this.f4467a.cancel();
                        }
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.dsbridge.DWebView$6$c */
            public class c implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsPromptResult f4469a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ EditText f4470b;

                public c(JsPromptResult jsPromptResult, EditText editText) {
                    this.f4469a = jsPromptResult;
                    this.f4470b = editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    if (DWebView.this.f4453e) {
                        if (i6 == -1) {
                            this.f4469a.confirm(this.f4470b.getText().toString());
                        } else {
                            this.f4469a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i6, String str2) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onConsoleMessage(str, i6, str2);
                } else {
                    super.onConsoleMessage(str, i6, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (DWebView.this.f4452d instanceof f) {
                    ((f) DWebView.this.f4452d).a(valueCallback, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z5, boolean z6, Message message) {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onCreateWindow(webView, z5, z6, message) : super.onCreateWindow(webView, z5, z6, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j6, long j7, long j8, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onExceededDatabaseQuota(str, str2, j6, j7, j8, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j6, j7, j8, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f4453e) {
                    jsResult.confirm();
                }
                if (DWebView.this.f4452d != null && DWebView.this.f4452d.onJsAlert(webView, str, str2, jsResult)) {
                    return true;
                }
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new a(jsResult)).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f4453e) {
                    jsResult.confirm();
                }
                if (DWebView.this.f4452d != null && DWebView.this.f4452d.onJsConfirm(webView, str, str2, jsResult)) {
                    return true;
                }
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                String str4;
                String str5;
                JsPromptResult jsPromptResult2;
                if (!DWebView.this.f4453e) {
                    jsPromptResult.confirm();
                }
                if (DWebView.this.f4452d != null) {
                    str4 = str2;
                    str5 = str3;
                    jsPromptResult2 = jsPromptResult;
                    if (DWebView.this.f4452d.onJsPrompt(webView, str, str4, str5, jsPromptResult2)) {
                        return true;
                    }
                } else {
                    str4 = str2;
                    str5 = str3;
                    jsPromptResult2 = jsPromptResult;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str5);
                if (str5 != null) {
                    editText.setSelection(str5.length());
                }
                float f6 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult2, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str4).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i6 = (int) (16.0f * f6);
                layoutParams.setMargins(i6, 0, i6, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i7 = (int) (15.0f * f6);
                editText.setPadding(i7 - ((int) (f6 * 5.0f)), i7, i7, i7);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i6) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onProgressChanged(webView, i6);
                } else {
                    super.onProgressChanged(webView, i6);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z5) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onReceivedTouchIconUrl(webView, str, z5);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z5);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return DWebView.this.f4452d != null ? DWebView.this.f4452d.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (DWebView.this.f4452d instanceof f) {
                    ((f) DWebView.this.f4452d).a(valueCallback, str, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.f4452d != null) {
                    return DWebView.this.f4452d.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i6, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f4452d != null) {
                    DWebView.this.f4452d.onShowCustomView(view, i6, customViewCallback);
                } else {
                    super.onShowCustomView(view, i6, customViewCallback);
                }
            }
        };
        c();
    }

    public synchronized <T> void a(String str, Object[] objArr, z2<T> z2Var) {
        try {
            int i6 = this.f4451c + 1;
            this.f4451c = i6;
            e eVar = new e(str, i6, objArr);
            if (z2Var != null) {
                this.f4458j.put(Integer.valueOf(eVar.f4484b), z2Var);
            }
            ArrayList<e> arrayList = this.f4455g;
            if (arrayList != null) {
                arrayList.add(eVar);
            } else {
                a(eVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(String str, Object[] objArr) {
        a(str, objArr, (z2) null);
    }

    public final String[] c(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            str = str.substring(lastIndexOf + 1);
        } else {
            str2 = "";
        }
        return new String[]{str2, str};
    }

    public <T> void a(String str, z2<T> z2Var) {
        a(str, (Object[]) null, z2Var);
    }

    public void a(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.f4449a.put(str, obj);
        }
    }

    public void a(boolean z5) {
        this.f4453e = !z5;
    }

    public void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
            }
            file.delete();
            return;
        }
        c2.b("Webview", "delete file no exists " + file.getAbsolutePath());
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f4457i.post(runnable);
        }
    }
}
