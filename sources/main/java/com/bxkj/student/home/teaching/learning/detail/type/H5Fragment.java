package com.bxkj.student.home.teaching.learning.detail.type;

import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.umeng.socialize.utils.ContextUtil;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class H5Fragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private String f18643j;

    /* renamed from: k, reason: collision with root package name */
    private SmartWebView f18644k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends WebViewClient {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.learning.detail.type.H5Fragment$a$a, reason: collision with other inner class name */
        class C0226a implements ValueCallback<String> {
            C0226a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String value) {
            }
        }

        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            view.evaluateJavascript("(function(){var meta = document.createElement('meta');meta.content = 'width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=no';meta.name = 'viewport';document.getElementsByTagName('head')[0].appendChild(meta);var body = document.getElementsByTagName('body')[0];body.style.cssText = 'width:100%;overflow-x:hidden;font-size:14px;margin:0;padding:10px;box-sizing:border-box;';var tb = document.getElementsByTagName('table');for (var k = 0; k < tb.length; k++){var nd = tb[k];nd.style.cssText += ';color:#101010;font-size: 14px;width:100%;overflow-x:hidden;';};var ps = document.getElementsByTagName('p');for (var j = 0; j < ps.length; j++){var nd = ps[j];var str = nd.innerHTML;str = str.replace(/&nbsp;/g, '');nd.innerHTML = str;nd.style.cssText += ';color:#101010;font-size: 14px;width:100%;overflow-x:hidden;';}})()", new C0226a());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!url.startsWith(JPushConstants.HTTP_PRE) && !url.startsWith(JPushConstants.HTTPS_PRE)) {
                return "bilibili".equalsIgnoreCase(Uri.parse(url).getScheme());
            }
            view.loadUrl(url);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }

    private int N() {
        try {
            return this.f1096g.getPackageManager().getPackageInfo(ContextUtil.getPackageName(), 0).versionCode;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        String str;
        if (getArguments().containsKey("url")) {
            this.f18643j = getArguments().getString("url");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, LoginUser.getLoginUser().getToken());
        hashMap.put("channel", "Android");
        hashMap.put("version", String.valueOf(N()));
        if (LoginUser.getLoginUser().getUserType() == 2) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("type", str);
        if (this.f18643j.startsWith("https://player.bilibili.com/player.html")) {
            this.f18644k.getWebView().getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        }
        this.f18644k.getWebView().loadUrl(this.f18643j, hashMap);
        this.f18644k.getWebView().setWebViewClient(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18644k = (SmartWebView) c(2131298538);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.ac_learn_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
