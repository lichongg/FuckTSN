package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.ad.k;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends ProxyActivityAction {

    /* renamed from: a, reason: collision with root package name */
    public static cn.jpush.android.webview.bridge.d f3891a;

    /* renamed from: b, reason: collision with root package name */
    private String f3892b;

    /* renamed from: c, reason: collision with root package name */
    private WebView f3893c;

    /* renamed from: d, reason: collision with root package name */
    private cn.jpush.android.d.d f3894d = null;

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d b6 = cn.jpush.android.x.b.b(StubApp.getOrigApplicationContext(activity.getApplicationContext()), activity.getIntent());
        if (b6 != null) {
            return b6;
        }
        Logger.dd("PopWinActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        return cn.jpush.android.ac.d.a(activity, uri, "");
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i6, KeyEvent keyEvent) {
        return false;
    }

    private void a() {
        try {
            k.a(this.f3893c, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f3891a, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("PopWinActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void c(Activity activity) {
        cn.jpush.android.d.d dVar = this.f3894d;
        String str = dVar.ab;
        String str2 = dVar.Z;
        Logger.d("PopWinActivityImpl", "showUrl = " + str2);
        if (TextUtils.isEmpty(str) || !new File(str.replace("file://", "")).exists()) {
            this.f3893c.loadUrl(str2);
        } else {
            this.f3893c.loadUrl(str);
        }
        cn.jpush.android.d.d dVar2 = this.f3894d;
        byte b6 = dVar2.ai;
        if (b6 == 0) {
            cn.jpush.android.helper.c.a(this.f3892b, 1000L, activity);
        } else {
            cn.jpush.android.helper.c.a(dVar2.f3588d, "", b6, 1000L, activity);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        byte b6;
        cn.jpush.android.d.d dVar = this.f3894d;
        if (dVar == null || (b6 = dVar.ai) == 0) {
            cn.jpush.android.helper.c.a(this.f3892b, 1006L, activity);
        } else {
            cn.jpush.android.helper.c.a(this.f3892b, "", b6, 1006L, activity);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f3893c;
        if (webView != null) {
            webView.removeAllViews();
            this.f3893c.destroy();
            this.f3893c = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f3893c;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        WebView webView = this.f3893c;
        if (webView != null) {
            webView.onResume();
            HostJsScope.setWebViewHelper(f3891a);
        }
    }

    private void a(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                if (cn.jpush.android.x.b.a(activity, activity.getIntent())) {
                    cn.jpush.android.d.d a6 = a(activity, activity.getIntent());
                    this.f3894d = a6;
                    if (a6 == null) {
                        Logger.ww("PopWinActivityImpl", "Warning，null message entity! Close PopWinActivity!");
                        activity.finish();
                        return;
                    } else {
                        this.f3892b = a6.f3588d;
                        b(activity);
                        c(activity);
                        cn.jpush.android.k.a.a(activity, this.f3894d);
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PopWinActivityImpl", "Extra data is not serializable!" + th);
            }
        } else {
            Logger.ww("PopWinActivityImpl", "PopWinActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity) {
        int identifier = activity.getResources().getIdentifier("jpush_popwin_layout", ResIdentify.RES_TYPE_LAYOUT, activity.getPackageName());
        if (identifier == 0) {
            Logger.ee("PopWinActivityImpl", "Please add layout resource jpush_popwin_layout.xml to res/layout !");
            activity.finish();
            return;
        }
        activity.setContentView(identifier);
        int identifier2 = activity.getResources().getIdentifier("wvPopwin", "id", activity.getPackageName());
        if (identifier2 == 0) {
            Logger.ee("PopWinActivityImpl", "Please use default code in jpush_popwin_layout.xml!");
            activity.finish();
            return;
        }
        WebView webView = (WebView) activity.findViewById(identifier2);
        this.f3893c = webView;
        if (webView == null) {
            Logger.ee("PopWinActivityImpl", "Can not get webView in layout file!");
            activity.finish();
            return;
        }
        webView.setScrollbarFadingEnabled(true);
        this.f3893c.setScrollBarStyle(CommonNetImpl.FLAG_SHARE_JUMP);
        WebSettings settings = this.f3893c.getSettings();
        settings.setDomStorageEnabled(true);
        cn.jpush.android.ad.a.c(settings);
        cn.jpush.android.ad.a.a(this.f3893c);
        cn.jpush.android.ad.a.a(settings);
        settings.setSavePassword(false);
        this.f3893c.setBackgroundColor(0);
        f3891a = new cn.jpush.android.webview.bridge.d(activity, this.f3894d);
        Logger.dd("PopWinActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
        a();
        this.f3893c.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
        this.f3893c.setWebViewClient(new a(this.f3894d, activity));
        HostJsScope.setWebViewHelper(f3891a);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.ad.a.e(activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && str.equals("start_push_activity") && this.f3894d != null && this.f3893c != null) {
            String string = bundle.getString("url");
            if (!TextUtils.isEmpty(string)) {
                this.f3894d.Z = string;
                Intent intent = new Intent(activity, (Class<?>) PushActivity.class);
                intent.putExtra("msg_data", this.f3894d.c());
                intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
                intent.setFlags(335544320);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }
}
