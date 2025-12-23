package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.k;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends ProxyActivityAction {

    /* renamed from: a, reason: collision with root package name */
    public static cn.jpush.android.webview.bridge.d f3895a;

    /* renamed from: c, reason: collision with root package name */
    private cn.jpush.android.d.d f3897c;

    /* renamed from: e, reason: collision with root package name */
    private String f3899e;

    /* renamed from: g, reason: collision with root package name */
    private WebView f3901g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f3902h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f3903i;

    /* renamed from: j, reason: collision with root package name */
    private ImageButton f3904j;

    /* renamed from: k, reason: collision with root package name */
    private ProgressBar f3905k;

    /* renamed from: l, reason: collision with root package name */
    private a f3906l;

    /* renamed from: b, reason: collision with root package name */
    private int f3896b = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3898d = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3900f = false;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f3907m = new View.OnClickListener() { // from class: cn.jpush.android.ui.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.getContext() == null || !(view.getContext() instanceof Activity)) {
                        return;
                    }
                    ((Activity) view.getContext()).onBackPressed();
                } catch (Throwable unused) {
                }
            }
        }
    };

    private void b() {
        try {
            k.a(this.f3901g, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f3895a, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("PushActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i6, KeyEvent keyEvent) {
        return false;
    }

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d b6 = cn.jpush.android.x.b.b(activity, activity.getIntent());
        if (b6 != null) {
            return b6;
        }
        Logger.dd("PushActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        Logger.d("PushActivityImpl", "content:" + uri);
        return cn.jpush.android.ac.d.a(activity, uri, "");
    }

    private void b(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                if (cn.jpush.android.x.b.a(activity, activity.getIntent())) {
                    this.f3898d = activity.getIntent().getBooleanExtra(PushActivity.FROM_OTHER_WAY, false);
                    cn.jpush.android.d.d a6 = a(activity, activity.getIntent());
                    this.f3897c = a6;
                    if (a6 == null) {
                        Logger.ww("PushActivityImpl", "Warning，null message entity! Close PushActivity!");
                        activity.finish();
                        return;
                    } else {
                        this.f3899e = a6.f3588d;
                        this.f3900f = !TextUtils.isEmpty(a6.bh);
                        a(activity, this.f3897c);
                        cn.jpush.android.k.a.a(activity, this.f3897c);
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PushActivityImpl", "Extra data is not serializable!" + th);
            }
        } else {
            Logger.ww("PushActivityImpl", "PushActivity get NULL intent!");
        }
        activity.finish();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        Activity activity2;
        byte b6;
        WebView webView = this.f3901g;
        if (webView != null && webView.canGoBack()) {
            this.f3901g.goBack();
            return;
        }
        cn.jpush.android.d.d dVar = this.f3897c;
        if (dVar == null || (b6 = dVar.ai) == 0) {
            activity2 = activity;
            cn.jpush.android.helper.c.a(this.f3899e, 1006L, activity2);
        } else {
            activity2 = activity;
            cn.jpush.android.helper.c.a(this.f3899e, "", b6, 1006L, activity2);
        }
        a(activity2);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f3901g;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent != null) {
                Logger.d("PushActivityImpl", "webview parent view " + parent.toString());
                ((ViewGroup) parent).removeView(this.f3901g);
            }
            this.f3901g.getSettings().setJavaScriptEnabled(false);
            this.f3901g.clearCache(true);
            this.f3901g.clearHistory();
            this.f3901g.clearView();
            this.f3901g.removeAllViews();
            this.f3901g.clearSslPreferences();
            this.f3901g.destroy();
            this.f3901g = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f3901g;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        WebView webView = this.f3901g;
        if (webView != null) {
            webView.onResume();
            HostJsScope.setWebViewHelper(f3895a);
        }
    }

    private void b(Activity activity, cn.jpush.android.d.d dVar) {
        String str;
        Logger.i("PushActivityImpl", "Action: processShow");
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else {
            if (dVar.ae != 0) {
                return;
            }
            this.f3896b = dVar.ac;
            int identifier = activity.getResources().getIdentifier("jpush_webview_layout", ResIdentify.RES_TYPE_LAYOUT, activity.getPackageName());
            if (identifier == 0) {
                str = "Please add layout resource jpush_webview_layout.xml to res/layout !";
            } else {
                activity.setContentView(identifier);
                String str2 = dVar.Z;
                if (cn.jpush.android.ad.a.c(str2)) {
                    String str3 = dVar.ab;
                    if (dVar.f3603s) {
                        int identifier2 = activity.getResources().getIdentifier("actionbarLayoutId", "id", activity.getPackageName());
                        if (identifier2 == 0) {
                            str = "Please use default code in jpush_webview_layout.xml!";
                        } else {
                            View findViewById = activity.findViewById(identifier2);
                            if (findViewById != null) {
                                a(activity, findViewById, dVar);
                                if (TextUtils.isEmpty(str3) || !new File(str3.replace("file://", "")).exists() || this.f3898d) {
                                    this.f3901g.loadUrl(str2);
                                } else {
                                    this.f3901g.loadUrl(str3);
                                }
                            }
                        }
                    }
                    if (this.f3898d || this.f3900f) {
                        return;
                    }
                    byte b6 = dVar.ai;
                    if (b6 == 0) {
                        cn.jpush.android.helper.c.a(this.f3899e, 1000L, activity);
                        return;
                    } else {
                        cn.jpush.android.helper.c.a(dVar.f3588d, "", b6, 1000L, activity);
                        return;
                    }
                }
                cn.jpush.android.x.b.c(activity, dVar);
            }
            Logger.ee("PushActivityImpl", str);
        }
        activity.finish();
    }

    private void c(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags &= -1025;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().clearFlags(512);
        } catch (Throwable unused) {
            Logger.w("PushActivityImpl", "quitFullScreen errno");
        }
    }

    public void a() {
        try {
            RelativeLayout relativeLayout = this.f3902h;
            if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
                return;
            }
            this.f3902h.setVisibility(0);
            c((Activity) this.f3902h.getContext());
            this.f3904j.setOnClickListener(this.f3907m);
            WebView webView = this.f3901g;
            if (webView != null) {
                webView.postDelayed(new f("PushActivityImpl#showTitleBar") { // from class: cn.jpush.android.ui.c.3
                    @Override // cn.jpush.android.ad.f
                    public void a() {
                        try {
                            if (c.this.f3901g != null) {
                                c.this.f3901g.clearHistory();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, 1000L);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.ad.a.e(activity);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && str.equals("push_show_titlebar")) {
            activity.runOnUiThread(new f("PushActivityImpl#onEvent") { // from class: cn.jpush.android.ui.c.1
                @Override // cn.jpush.android.ad.f
                public void a() {
                    c.this.a();
                }
            });
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
        activity.setIntent(intent);
        b(activity);
    }

    public void a(Activity activity) {
        ComponentName componentName;
        ComponentName componentName2;
        activity.finish();
        if (1 == this.f3896b) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService(TTDownloadField.TT_ACTIVITY);
                componentName = activityManager.getRunningTasks(1).get(0).baseActivity;
                componentName2 = activityManager.getRunningTasks(1).get(0).topActivity;
                Logger.d("PushActivityImpl", "baseActivity  = " + componentName.toString());
                Logger.d("PushActivityImpl", "topActivity  = " + componentName2.toString());
                if (componentName2.toString().equals(componentName.toString())) {
                    cn.jpush.android.ad.a.f(activity);
                }
            } catch (Throwable unused) {
                Logger.ww("PushActivityImpl", "Get running tasks failed.");
                cn.jpush.android.ad.a.f(activity);
            }
        }
    }

    public void a(Activity activity, View view, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.aa;
            view.setFocusable(true);
            int identifier = activity.getResources().getIdentifier("fullWebView", "id", activity.getPackageName());
            if (identifier > 0) {
                ((LinearLayout) view).removeView(activity.findViewById(identifier));
            }
            WebView webView = new WebView(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
            this.f3901g = webView;
            webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f3901g.setBackgroundColor(Color.parseColor("#000000"));
            ((LinearLayout) view).addView(this.f3901g);
            this.f3902h = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlRichpushTitleBar", "id", activity.getPackageName()));
            this.f3903i = (TextView) activity.findViewById(activity.getResources().getIdentifier("tvRichpushTitle", "id", activity.getPackageName()));
            this.f3904j = (ImageButton) activity.findViewById(activity.getResources().getIdentifier("imgRichpushBtnBack", "id", activity.getPackageName()));
            this.f3905k = (ProgressBar) activity.findViewById(activity.getResources().getIdentifier("pushPrograssBar", "id", activity.getPackageName()));
            if (this.f3901g == null || this.f3902h == null || this.f3903i == null || this.f3904j == null) {
                Logger.ee("PushActivityImpl", "Please use default code in jpush_webview_layout.xml!");
                activity.finish();
            }
            if (1 == dVar.ad) {
                this.f3902h.setVisibility(8);
                activity.getWindow().setFlags(1024, 1024);
            } else {
                this.f3903i.setText(str);
                this.f3904j.setOnClickListener(this.f3907m);
                m.a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), this.f3904j, true, 10, 6, 10, 6);
            }
            this.f3901g.setScrollbarFadingEnabled(true);
            this.f3901g.setScrollBarStyle(CommonNetImpl.FLAG_SHARE_JUMP);
            WebSettings settings = this.f3901g.getSettings();
            cn.jpush.android.ad.a.c(settings);
            cn.jpush.android.ad.a.a(this.f3901g);
            cn.jpush.android.ad.a.a(settings);
            settings.setSavePassword(false);
            f3895a = new cn.jpush.android.webview.bridge.d(activity, dVar);
            Logger.dd("PushActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            Logger.d("PushActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            b();
            this.f3901g.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, this.f3905k, this.f3903i));
            a aVar = new a(dVar, activity);
            this.f3906l = aVar;
            aVar.a(this.f3900f);
            this.f3901g.setWebViewClient(this.f3906l);
            HostJsScope.setWebViewHelper(f3895a);
        } catch (Throwable unused) {
        }
    }

    private void a(Activity activity, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
            activity.finish();
        } else {
            if (dVar.f3602r == 0) {
                activity.setRequestedOrientation(1);
                b(activity, dVar);
                return;
            }
            Logger.w("PushActivityImpl", "Invalid msg type to show - " + dVar.f3602r);
            cn.jpush.android.x.b.c(activity, dVar);
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
    public void onStart(Activity activity, Intent intent) {
    }
}
