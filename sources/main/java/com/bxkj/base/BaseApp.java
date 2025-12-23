package com.bxkj.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.MessageManager;
import com.bxkj.base.intercept.e;
import com.bxkj.base.user.LoginUser;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import okhttp3.logging.HttpLoggingInterceptor;
import x.f;
import z.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseApp extends Application {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f16361a = true;

    /* renamed from: b, reason: collision with root package name */
    private static BaseApp f16362b;

    public boolean f() {
        try {
            String d6 = d(StubApp.getOrigApplicationContext(getApplicationContext()), Process.myPid());
            if (TextUtils.isEmpty(d6)) {
                return true;
            }
            return getPackageName().equalsIgnoreCase(d6);
        } catch (Exception e6) {
            e6.printStackTrace();
            return true;
        }
    }

    public abstract void i(Context context);

    public static BaseApp c() {
        return f16362b;
    }

    public static boolean g() {
        return f16361a;
    }

    public static void h(boolean z5) {
        f16361a = z5;
    }

    public String d(Context context, int i6) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == i6) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private void b() {
        Http.getHttp().addInterceptor(new d());
        Http.getHttp().addInterceptor(new com.bxkj.base.intercept.a());
        Http.getHttp().addInterceptor(new z.b());
        Http.getHttp().addInterceptor(new h2.b(c()));
        Http.getHttp().addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.bxkj.base.b
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                BaseApp.a(str);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));
        Http.getHttp().setResponseInterceptor(new e());
    }

    private void e() {
        Http.getHttp().init(f.class, LoginUser.getLoginUser().getServerUrl(), "returnCode", "data", "returnMsg", 200);
        Http.getHttp().setShowMessageModel(MessageManager.MessageModel.All);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f16362b = this;
        if (f()) {
            b();
            e();
        }
    }

    public static /* synthetic */ void a(String str) {
    }
}
