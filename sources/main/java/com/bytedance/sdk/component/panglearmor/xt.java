package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.bytedance.pangle.annotations.ForbidWrapParam;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Application.ActivityLifecycleCallbacks {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f26708j;
    private final cw xt;

    public static xt j(Application application) {
        if (f26708j == null) {
            synchronized (xt.class) {
                try {
                    if (f26708j == null) {
                        f26708j = new xt(application);
                        application.registerActivityLifecycleCallbacks(f26708j);
                    }
                } finally {
                }
            }
        }
        return f26708j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        j.j(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        j.j(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam Activity activity) {
        cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.j(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam Activity activity) {
        cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.xt(activity);
        }
    }

    private xt(Application application) {
        this.xt = cw.j(application);
    }

    public void xt(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public String j(String str, long j6, int i6, boolean z5) {
        cw cwVar = this.xt;
        if (cwVar != null) {
            return cwVar.j(str, j6, i6, z5);
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }
}
