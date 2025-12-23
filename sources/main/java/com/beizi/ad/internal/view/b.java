package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.lance.a.j;
import com.beizi.fusion.R;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.open.SocialConstants;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class b {
    static void a(AdWebView adWebView, String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if ("GotoPage".equals(host)) {
            a(adWebView, parse);
            return;
        }
        if ("SendMsg".equals(host)) {
            b(adWebView, parse);
            return;
        }
        if ("CallNo".equals(host)) {
            c(adWebView, parse);
            return;
        }
        if ("ClosePage".equals(host)) {
            d(adWebView, parse);
            return;
        }
        if ("GetDeviceID".equals(host)) {
            d((WebView) adWebView, parse);
            return;
        }
        if ("Download".equals(host)) {
            e(adWebView, parse);
            return;
        }
        if ("PingClick".equals(host)) {
            f(adWebView, parse);
            return;
        }
        if ("PingConvertion".equals(host)) {
            g(adWebView, parse);
            return;
        }
        if ("GetCommonInfo".equals(host)) {
            return;
        }
        if ("MayDeepLink".equals(host)) {
            a((WebView) adWebView, parse);
            return;
        }
        if ("DeepLink".equals(host)) {
            if (adWebView.getUserInteraction()) {
                b((WebView) adWebView, parse);
                return;
            }
            return;
        }
        if ("ExternalBrowser".equals(host)) {
            if (adWebView.getUserInteraction()) {
                c((WebView) adWebView, parse);
            }
        } else if ("InternalBrowser".equals(host)) {
            if (adWebView.getUserInteraction()) {
                h(adWebView, parse);
            }
        } else if ("RecordEvent".equals(host)) {
            i(adWebView, parse);
        } else if ("DispatchAppEvent".equals(host)) {
            j(adWebView, parse);
        } else if ("GetDeviceID".equals(host)) {
            d((WebView) adWebView, parse);
        }
    }

    private static void b(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        uri.getQueryParameter("msg");
        uri.getQueryParameter(SocialConstants.PARAM_RECEIVER);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "SendMsg"));
        linkedList.add(new Pair("success", String.valueOf(false)));
        a(adWebView, queryParameter, linkedList);
    }

    private static void c(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        uri.getQueryParameter(SocialConstants.PARAM_RECEIVER);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "CallNo"));
        linkedList.add(new Pair("success", String.valueOf(false)));
        a(adWebView, queryParameter, linkedList);
    }

    private static void d(final AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        adWebView.adViewImpl.getMyHandler().post(new Runnable() { // from class: com.beizi.ad.internal.view.b.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                try {
                    if (!AdWebView.this.adViewImpl.e()) {
                        AdWebView.this.d();
                        return;
                    }
                    AdWebView.this.adViewImpl.getAdDispatcher().b();
                    if (!(AdWebView.this.getContextFromMutableContext() instanceof Activity) || (activity = (Activity) AdWebView.this.getContextFromMutableContext()) == null || activity.isFinishing()) {
                        return;
                    }
                    activity.finish();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "ClosePage"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        a(adWebView, queryParameter, linkedList);
    }

    private static void e(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter)));
            intent.setFlags(268435456);
            if (adWebView != null) {
                adWebView.getContext().startActivity(intent);
            }
        } catch (Exception unused) {
            Toast.makeText(adWebView.getContext(), R.string.beizi_action_cant_be_completed, 0).show();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "Download"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        a(adWebView, queryParameter2, linkedList);
    }

    private static void f(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        adWebView.adViewImpl.pingClick(queryParameter);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "PingClick"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        a(adWebView, queryParameter2, linkedList);
    }

    private static void g(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        adWebView.adViewImpl.pingConvert(queryParameter);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "PingConvertion"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        a(adWebView, queryParameter2, linkedList);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private static void h(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (adWebView.getContext() == null || queryParameter == null || !queryParameter.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            return;
        }
        String decode = Uri.decode(queryParameter);
        Intent intent = new Intent(adWebView.getContext(), (Class<?>) AdActivity.a());
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        WebView webView = new WebView(adWebView.getContext());
        x.a(webView);
        com.beizi.ad.internal.activity.a.f11616a.add(webView);
        webView.loadUrl(decode, j.a());
        if (adWebView.adViewImpl.getBrowserStyle() != null) {
            String str = "" + webView.hashCode();
            intent.putExtra("bridgeid", str);
            AdViewImpl.c.f12530a.add(new Pair<>(str, adWebView.adViewImpl.getBrowserStyle()));
        }
        try {
            adWebView.getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(adWebView.getContext(), R.string.beizi_action_cant_be_completed, 0).show();
            com.beizi.ad.internal.activity.a.f11616a.remove();
        }
    }

    private static void i(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (queryParameter == null || !queryParameter.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            return;
        }
        WebView webView = new WebView(adWebView.getContext());
        webView.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.view.b.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
                if (cookieSyncManager != null) {
                    cookieSyncManager.sync();
                }
            }
        });
        webView.loadUrl(queryParameter, j.a());
        webView.setVisibility(8);
        adWebView.addView(webView);
    }

    private static void j(AdWebView adWebView, Uri uri) {
        adWebView.adViewImpl.getAdDispatcher().a(uri.getQueryParameter("event"), uri.getQueryParameter("data"));
    }

    private static void c(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (webView.getContext() == null || queryParameter == null || !queryParameter.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter)));
            intent.setFlags(268435456);
            webView.getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(webView.getContext(), R.string.beizi_action_cant_be_completed, 0).show();
        }
    }

    private static void d(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GetDeviceID"));
        linkedList.add(new Pair("idname", "imei"));
        a(webView, queryParameter, linkedList);
    }

    private static void b(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        String queryParameter2 = uri.getQueryParameter("url");
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "DeepLink"));
        if (webView.getContext() != null && queryParameter2 != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter2)));
                intent.setFlags(268435456);
                webView.getContext().startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                a(webView, queryParameter, linkedList);
                return;
            }
        }
        a(webView, queryParameter, linkedList);
    }

    private static void a(AdWebView adWebView, Uri uri) {
        boolean z5;
        String queryParameter = uri.getQueryParameter("cb");
        if (adWebView.loadAdAt(Integer.parseInt(uri.getQueryParameter("index")))) {
            AdViewImpl adViewImpl = adWebView.adViewImpl;
            if (adViewImpl instanceof InterstitialAdViewImpl) {
                ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) adViewImpl).getAdImplementation()).g();
            }
            z5 = true;
        } else {
            z5 = false;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GotoPage"));
        linkedList.add(new Pair("success", String.valueOf(z5)));
        a(adWebView, queryParameter, linkedList);
    }

    private static void a(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        String queryParameter2 = uri.getQueryParameter("url");
        boolean z5 = false;
        if (webView.getContext() != null && webView.getContext().getPackageManager() != null && queryParameter2 != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter2)));
            intent.setFlags(268435456);
            if (intent.resolveActivity(webView.getContext().getPackageManager()) != null) {
                z5 = true;
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "MayDeepLink"));
        linkedList.add(new Pair("mayDeepLink", String.valueOf(z5)));
        a(webView, queryParameter, linkedList);
    }

    private static void a(WebView webView, String str, List<Pair<String, String>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cb=");
        if (str == null) {
            str = "-1";
        }
        sb.append(str);
        if (list != null) {
            for (Pair<String, String> pair : list) {
                if (pair.first != null && pair.second != null) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append((String) pair.first);
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(Uri.encode((String) pair.second));
                }
            }
        }
        webView.evaluateJavascript(String.format("javascript:window.sdkjs.client.result(\"%s\")", sb.toString()), null);
    }
}
