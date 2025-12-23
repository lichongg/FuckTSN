package cn.jpush.android.s;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f3777a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<Activity> f3778b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f3779c = "";

    /* renamed from: e, reason: collision with root package name */
    private static AtomicLong f3780e = new AtomicLong(System.currentTimeMillis());

    /* renamed from: d, reason: collision with root package name */
    private String f3781d;

    public static long a() {
        return f3780e.get();
    }

    private static Activity b(Context context) {
        try {
            if (f3778b != null) {
                Logger.d("InAppLifeListener", "mActivity is null, try to user weakActivity: " + f3778b);
                Activity activity = f3778b.get();
                if (activity != null && !activity.isFinishing()) {
                    Logger.dd("InAppLifeListener", "use weak activity, " + f3778b.get().getLocalClassName());
                    return activity;
                }
            }
            Activity k6 = cn.jpush.android.ad.a.k(context);
            if (k6 == null || k6.isFinishing()) {
                return null;
            }
            Logger.dd("InAppLifeListener", "use current stack activity, " + k6.getLocalClassName());
            f3778b = new WeakReference<>(k6);
            return null;
        } catch (Throwable th) {
            Logger.w("InAppLifeListener", "getActivityInternal error, " + th.getMessage());
            return null;
        }
    }

    public static Activity a(Context context) {
        return b(context);
    }

    public void b(Activity activity) {
        String str;
        if (activity == null) {
            str = "onActivityStarted activity is null";
        } else {
            try {
                String name = activity.getClass().getName();
                Logger.d("InAppLifeListener", "[onActivityStarted], gLatestActivityName: " + f3779c + ", activityTaskCount: " + f3777a + " currentActivity: " + name);
                a(activity);
                Context appContext = JPushConstants.getAppContext(activity);
                String packageName = appContext.getPackageName();
                Logger.d("InAppLifeListener", "mLastPkg=" + this.f3781d + " currentPkg=" + packageName);
                if (f3777a != 0) {
                    if (!TextUtils.equals(name, f3779c) && TextUtils.equals(packageName, this.f3781d)) {
                        Logger.d("InAppLifeListener", "use enter new activity,show inapp message");
                    }
                    f3779c = name;
                    this.f3781d = packageName;
                    f3777a++;
                    return;
                }
                Logger.d("InAppLifeListener", "is foreground, change foreground state");
                f3780e.set(System.currentTimeMillis());
                cn.jpush.android.o.a.a().a(appContext, true, name);
                f3779c = name;
                this.f3781d = packageName;
                f3777a++;
                return;
            } catch (Throwable th) {
                str = "onActivityStarted error, " + th.getMessage();
            }
        }
        Logger.w("InAppLifeListener", str);
    }

    public void d(Activity activity) {
        String str;
        WeakReference<Activity> weakReference;
        if (activity == null || ((weakReference = f3778b) != null && weakReference.get() == null)) {
            str = "onActivityPaused activity is null";
        } else {
            try {
                WeakReference<Activity> weakReference2 = f3778b;
                if (weakReference2 == null || weakReference2.get() != activity) {
                    return;
                }
                f3778b = new WeakReference<>(null);
                return;
            } catch (Throwable th) {
                str = " onActivityDestroyed error, " + th.getMessage();
            }
        }
        Logger.w("InAppLifeListener", str);
    }

    public void e(Activity activity) {
        String str;
        if (activity == null) {
            str = "onActivityStopped activity is null";
        } else {
            try {
                String name = activity.getClass().getName();
                Logger.d("InAppLifeListener", "[onActivityStopped], curClzName: " + name + ", latestCurClzName: " + f3779c + ", activityTaskCount: " + f3777a);
                cn.jpush.android.o.a.a().a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), name);
                int i6 = f3777a;
                if (i6 > 0) {
                    f3777a = i6 - 1;
                }
                if (f3777a == 0 && !f3779c.equals(name)) {
                    f3777a++;
                    return;
                }
                return;
            } catch (Throwable th) {
                str = "onActivityStopped error, " + th.getMessage();
            }
        }
        Logger.w("InAppLifeListener", str);
    }

    public void f(Activity activity) {
        String str;
        Logger.d("InAppLifeListener", "[onActivityDestroyed]");
        if (activity == null) {
            str = "onActivityDestroyed activity is null";
        } else {
            try {
                cn.jpush.android.o.a.a().a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), activity.getClass().getCanonicalName());
                return;
            } catch (Throwable th) {
                str = "onActivityDestroyed error, " + th.getMessage();
            }
        }
        Logger.w("InAppLifeListener", str);
    }

    public void a(Activity activity) {
        f3778b = new WeakReference<>(activity);
    }

    public void c(Activity activity) {
        a(activity);
    }
}
