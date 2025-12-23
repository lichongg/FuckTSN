package cn.jpush.android.local;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;

@TargetApi(14)
/* loaded from: D:\Downloads\app\classes2.dex */
public class ActivityLifeCallBack implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityLifeCallBack";
    public static int activityTaskCount;
    private String lastActivity = "";

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "destroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "paused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "resumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "started");
        if (activityTaskCount == 0) {
            Logger.d(TAG, "is Foreground");
            if (activity != null) {
                JPushConstants.changeForegroudStat(StubApp.getOrigApplicationContext(activity.getApplicationContext()), true);
            }
        }
        activityTaskCount++;
        this.lastActivity = activity.getClass().getCanonicalName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "stopped");
        int i6 = activityTaskCount;
        if (i6 > 0) {
            activityTaskCount = i6 - 1;
        }
        if (activityTaskCount == 0 && activity != null) {
            if (TextUtils.equals(this.lastActivity, activity.getClass().getCanonicalName())) {
                Logger.d(TAG, "is not Foreground");
                JPushConstants.changeForegroudStat(StubApp.getOrigApplicationContext(activity.getApplicationContext()), false);
            } else {
                activityTaskCount++;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
