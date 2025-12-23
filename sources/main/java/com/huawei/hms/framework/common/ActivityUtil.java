package com.huawei.hms.framework.common;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ActivityUtil {

    /* renamed from: d, reason: collision with root package name */
    private static final String f33259d = "ActivityUtil";

    /* renamed from: e, reason: collision with root package name */
    private static volatile ActivityUtil f33260e = null;

    /* renamed from: f, reason: collision with root package name */
    private static final int f33261f = 20;

    /* renamed from: b, reason: collision with root package name */
    private boolean f33263b;

    /* renamed from: a, reason: collision with root package name */
    private List<OnAppStatusListener> f33262a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f33264c = new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.hms.framework.common.ActivityUtil.1

        /* renamed from: a, reason: collision with root package name */
        private int f33265a = 0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i6 = this.f33265a + 1;
            this.f33265a = i6;
            if (i6 == 1) {
                ActivityUtil.this.f33263b = true;
                Logger.d(ActivityUtil.f33259d, "onActivityStarted");
                for (int i7 = 0; i7 < ActivityUtil.this.f33262a.size(); i7++) {
                    ((OnAppStatusListener) ActivityUtil.this.f33262a.get(i7)).onFront();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i6 = this.f33265a - 1;
            this.f33265a = i6;
            if (i6 == 0) {
                Logger.d(ActivityUtil.f33259d, "onActivityStopped");
                ActivityUtil.this.f33263b = false;
                for (int i7 = 0; i7 < ActivityUtil.this.f33262a.size(); i7++) {
                    ((OnAppStatusListener) ActivityUtil.this.f33262a.get(i7)).onBack();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnAppStatusListener {
        void onBack();

        void onFront();
    }

    public static PendingIntent getActivities(Context context, int i6, Intent[] intentArr, int i7) {
        if (context == null) {
            Logger.w(f33259d, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i6, intentArr, i7);
        } catch (RuntimeException e6) {
            Logger.e(f33259d, "dealType rethrowFromSystemServer:", e6);
            return null;
        }
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return getInstance().isForeground();
    }

    public static ActivityUtil getInstance() {
        if (f33260e == null) {
            synchronized (ActivityUtil.class) {
                try {
                    if (f33260e == null) {
                        f33260e = new ActivityUtil();
                    }
                } finally {
                }
            }
        }
        return f33260e;
    }

    public boolean isForeground() {
        return this.f33263b;
    }

    public void setOnAppStatusListener(OnAppStatusListener onAppStatusListener) {
        if (onAppStatusListener == null) {
            Logger.w(f33259d, "onAppStatusListener is null");
        } else if (this.f33262a.size() >= 20) {
            Logger.w(f33259d, "onAppStatusListener of count is max");
        } else {
            this.f33262a.add(onAppStatusListener);
        }
    }

    private ActivityUtil() {
    }

    public void register() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).registerActivityLifecycleCallbacks(this.f33264c);
        } else {
            Logger.w(f33259d, "context is not application, register background fail");
        }
    }

    public void unRegister() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).unregisterActivityLifecycleCallbacks(this.f33264c);
        } else {
            Logger.w(f33259d, "context is not application, unRegister background fail");
        }
    }
}
