package cn.jpush.android.webview.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static String f3975d;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f3976a;

    /* renamed from: b, reason: collision with root package name */
    private final cn.jpush.android.d.d f3977b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3978c;

    @JavascriptInterface
    public void download(String str) {
        if (this.f3976a.get() == null) {
            return;
        }
        Logger.d("WebViewHelper", "Web callback:download - " + str);
    }

    @JavascriptInterface
    public void click(String str, String str2, String str3) {
        Logger.d("WebViewHelper", "Web callback:click - actionId:" + str + ", shouldClose:" + str2 + ", shouldCancelNotification:" + str3);
        try {
            a(str);
            boolean parseBoolean = Boolean.parseBoolean(str2);
            if (Boolean.parseBoolean(str3)) {
                cn.jpush.android.x.b.c(JPushConstants.mApplicationContext, this.f3977b);
            }
            if (!parseBoolean || this.f3976a.get() == null) {
                return;
            }
            this.f3976a.get().finish();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void close() {
        if (this.f3976a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:close");
            this.f3976a.get().finish();
        }
    }

    @JavascriptInterface
    public void download(String str, String str2) {
        if (this.f3976a.get() == null) {
            return;
        }
        a(str);
        download(str2);
        cn.jpush.android.x.b.c(JPushConstants.mApplicationContext, this.f3977b);
        this.f3976a.get().finish();
    }

    @JavascriptInterface
    public String getDevInfo() {
        return "";
    }

    @JavascriptInterface
    public String getNotificationInfo() {
        return "";
    }

    @JavascriptInterface
    public String getTplData() {
        if (this.f3977b == null) {
            Logger.w("WebViewHelper", "[getTplData] entity is null");
            return "";
        }
        Logger.d("WebViewHelper", "[getTplData] js get template data: " + this.f3977b.bl);
        return this.f3977b.bl;
    }

    @JavascriptInterface
    public String getTplExtraData() {
        return "";
    }

    @JavascriptInterface
    public void inAppClick(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Logger.d("WebViewHelper", "h5 click, actionType: " + jSONObject.optInt("actionType") + ", actionKey: " + jSONObject.optString("param") + ", param: " + str);
            cn.jpush.android.o.a.a().d(JPushConstants.mApplicationContext, this.f3977b);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "h5 click failed, " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void onLoadCallback(String str) {
        try {
            Logger.d("WebViewHelper", "onLoadCallback : " + str);
            if (this.f3978c) {
                Logger.d("WebViewHelper", "js callback already, param: " + str);
                return;
            }
            boolean z5 = true;
            this.f3978c = true;
            Context context = JPushConstants.mApplicationContext;
            if (context == null && this.f3976a.get() != null) {
                context = StubApp.getOrigApplicationContext(this.f3976a.get().getApplicationContext());
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("statusCode");
            String optString = jSONObject.optString("msg");
            if (optInt != 0) {
                Logger.ww("WebViewHelper", "msg tpl load failed, code: " + optInt + ", errMsg: " + optString);
            }
            cn.jpush.android.o.a a6 = cn.jpush.android.o.a.a();
            cn.jpush.android.d.d dVar = this.f3977b;
            if (optInt != 0) {
                z5 = false;
            }
            a6.a(context, dVar, z5);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "[onLoadCallback] parse param error. " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void showTitleBar() {
        try {
            if (this.f3976a.get() == null || !(this.f3976a.get() instanceof PushActivity)) {
                return;
            }
            ((PushActivity) this.f3976a.get()).showTitleBar();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (this.f3976a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:showToast - " + str);
            Toast.makeText(this.f3976a.get(), str, 1).show();
        }
    }

    @JavascriptInterface
    public void startActivityByIntent(String str, String str2) {
        Context context = JPushConstants.mApplicationContext;
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable unused) {
            Logger.ee("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public void startActivityByName(String str, String str2) {
        Logger.d("WebViewHelper", "activityName = " + str);
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.ee("WebViewHelper", "The activity name is null or empty, Give up..");
            }
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return;
            }
            try {
                Intent intent = new Intent(context, Class.forName(str));
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                Logger.ee("WebViewHelper", "The activity name is invalid, Give up..");
            }
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void startMainActivity(String str) {
        Activity activity = this.f3976a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.ad.a.b(activity, str);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public void startPushActivity(String str) {
        try {
            Logger.d("WebViewHelper", "[startPushActivity]:" + str + ",activity:" + this.f3976a.get());
            if (this.f3976a.get() == null || !(this.f3976a.get() instanceof PopWinActivity)) {
                return;
            }
            ((PopWinActivity) this.f3976a.get()).startPushActivity(str);
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void triggerNativeAction(String str) {
        this.f3976a.get();
    }

    public d(Context context, cn.jpush.android.d.d dVar) {
        this.f3978c = false;
        this.f3976a = new WeakReference<>((Activity) context);
        this.f3977b = dVar;
        this.f3978c = false;
    }

    private void a(String str) {
        long j6;
        try {
            try {
                j6 = Long.parseLong(str);
            } catch (Exception unused) {
                Logger.e("WebViewHelper", "Invalid actionId from Web - " + str);
                j6 = 1100;
            }
            cn.jpush.android.helper.c.a(this.f3977b.f3588d, j6, JPushConstants.mApplicationContext);
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void download(String str, String str2, String str3) {
        Logger.v("WebViewHelper", "msgType from web: " + str3);
        download(str, str2);
    }

    @JavascriptInterface
    public void executeMsgMessage(String str) {
    }

    @JavascriptInterface
    public void reportData(String str) {
    }

    @JavascriptInterface
    public void createShortcut(String str, String str2, String str3) {
    }
}
