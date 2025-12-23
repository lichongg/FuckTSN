package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.helper.Logger;
import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private final cn.jpush.android.d.d f3885a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3886b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3887c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f3888d = "";

    /* renamed from: f, reason: collision with root package name */
    private boolean f3890f = false;

    /* renamed from: e, reason: collision with root package name */
    private Queue<String> f3889e = new PriorityQueue();

    public void a(boolean z5) {
        this.f3890f = z5;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i6, String str, String str2) {
        super.onReceivedError(webView, i6, str, str2);
    }

    private boolean a(String str) {
        boolean z5 = false;
        try {
            Intent a6 = str.startsWith("android-app://") ? Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.ad.a.a(str, 2) : null : cn.jpush.android.ad.a.a(str, 1);
            Context context = this.f3886b;
            if (context != null && a6 != null) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && packageManager.resolveActivity(a6, 0) == null) {
                    Logger.w("JPushWebViewClient", "open deeplink intent can be not resolved, url: " + str);
                    return true;
                }
                a6.addCategory("android.intent.category.BROWSABLE");
                if (!str.startsWith("android-app://")) {
                    a6.setComponent(null);
                }
                Intent a7 = cn.jpush.android.ad.a.a(str, 0);
                a7.setFlags(268435456);
                this.f3886b.startActivity(a7);
                Logger.d("JPushWebViewClient", "h5 open deeplink success, url: " + str);
            }
            z5 = true;
        } catch (Throwable th) {
            Logger.w("JPushWebViewClient", "[openDeeplink] Bad URI " + str + ": " + th.getMessage());
        }
        long j6 = z5 ? 976L : 977L;
        cn.jpush.android.d.d dVar = this.f3885a;
        byte b6 = dVar.ai;
        if (b6 == 0) {
            cn.jpush.android.helper.c.a(dVar.f3588d, j6, this.f3886b);
        } else {
            cn.jpush.android.helper.c.a(dVar.f3588d, "", b6, j6, this.f3886b);
        }
        return z5;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Logger.ww("JPushWebViewClient", "onReceivedSslError stop show:" + webView.getUrl());
        sslErrorHandler.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x016b A[Catch: all -> 0x01aa, TryCatch #0 {all -> 0x01aa, blocks: (B:3:0x0023, B:6:0x0045, B:9:0x005b, B:11:0x0063, B:14:0x006d, B:16:0x0075, B:18:0x0086, B:20:0x0090, B:22:0x0096, B:24:0x009e, B:25:0x00b0, B:27:0x00b6, B:30:0x00be, B:32:0x00c4, B:34:0x00ca, B:35:0x00d4, B:36:0x00e7, B:37:0x00dc, B:38:0x00ea, B:40:0x0124, B:42:0x012e, B:44:0x016b, B:45:0x016e, B:47:0x0174, B:49:0x017c, B:51:0x018e, B:53:0x0193), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0174 A[Catch: all -> 0x01aa, TryCatch #0 {all -> 0x01aa, blocks: (B:3:0x0023, B:6:0x0045, B:9:0x005b, B:11:0x0063, B:14:0x006d, B:16:0x0075, B:18:0x0086, B:20:0x0090, B:22:0x0096, B:24:0x009e, B:25:0x00b0, B:27:0x00b6, B:30:0x00be, B:32:0x00c4, B:34:0x00ca, B:35:0x00d4, B:36:0x00e7, B:37:0x00dc, B:38:0x00ea, B:40:0x0124, B:42:0x012e, B:44:0x016b, B:45:0x016e, B:47:0x0174, B:49:0x017c, B:51:0x018e, B:53:0x0193), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017c A[Catch: all -> 0x01aa, TryCatch #0 {all -> 0x01aa, blocks: (B:3:0x0023, B:6:0x0045, B:9:0x005b, B:11:0x0063, B:14:0x006d, B:16:0x0075, B:18:0x0086, B:20:0x0090, B:22:0x0096, B:24:0x009e, B:25:0x00b0, B:27:0x00b6, B:30:0x00be, B:32:0x00c4, B:34:0x00ca, B:35:0x00d4, B:36:0x00e7, B:37:0x00dc, B:38:0x00ea, B:40:0x0124, B:42:0x012e, B:44:0x016b, B:45:0x016e, B:47:0x0174, B:49:0x017c, B:51:0x018e, B:53:0x0193), top: B:2:0x0023 }] */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ui.a.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public a(cn.jpush.android.d.d dVar, Context context) {
        this.f3885a = dVar;
        this.f3886b = context;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f3888d = str;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }
}
