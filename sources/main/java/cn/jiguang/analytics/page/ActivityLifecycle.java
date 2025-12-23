package cn.jiguang.analytics.page;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;
import cn.jiguang.by.b;
import cn.jiguang.by.d;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@TargetApi(14)
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final String SAVE_KEY = "save_key";
    private static final String TAG = "ActivityLifecycle";
    public static final long WAKE_VIOLATION_COUNT = 5;
    public static final long WAKE_VIOLATION_DURATION = 50;
    private static final AtomicInteger activityTaskCount = new AtomicInteger(0);
    public static long lastWakeTime = 0;
    private WeakReference<Activity> mWeakReference;
    private List<Application.ActivityLifecycleCallbacks> mActivityCallbacks = new ArrayList();
    private boolean isFromSync = false;
    private boolean aidlBuildSuccess = false;

    public void sendCurrentState() {
        Activity activity;
        try {
            this.aidlBuildSuccess = true;
            Context appContext = JConstants.getAppContext();
            AtomicInteger atomicInteger = activityTaskCount;
            JCoreManager.onEvent(appContext, JConstants.SDK_TYPE, 66, null, null, Integer.valueOf(atomicInteger.get() == 0 ? 0 : 1));
            if (atomicInteger.get() <= 0) {
                return;
            }
            WeakReference<Activity> weakReference = this.mWeakReference;
            if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                this.isFromSync = true;
                onActivityCreated(activity, null);
                onActivityStarted(activity);
                onActivityResumed(activity);
                this.isFromSync = false;
            }
            clearLocal();
        } catch (Throwable unused) {
        }
    }

    private void cacheBeforeInit(Activity activity) {
        try {
            if (this.aidlBuildSuccess) {
                clearLocal();
            } else {
                clearLocal();
                this.mWeakReference = new WeakReference<>(activity);
            }
        } catch (Throwable unused) {
        }
    }

    private void clearLocal() {
        WeakReference<Activity> weakReference = this.mWeakReference;
        if (weakReference != null) {
            weakReference.clear();
            this.mWeakReference = null;
        }
    }

    private boolean isTranslucentNotitleTheme(Activity activity) {
        try {
            TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowNoTitle, R.attr.windowContentOverlay, R.attr.windowBackground, R.attr.windowIsTranslucent, R.attr.colorBackgroundCacheHint});
            boolean z5 = obtainStyledAttributes.getBoolean(0, false);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            int color = obtainStyledAttributes.getColor(2, -1);
            boolean z6 = obtainStyledAttributes.getBoolean(3, false);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(4);
            f.c(TAG, "notitle:" + z5 + ", overlay:" + drawable + ", color:" + color + ", translucent:" + z6 + "background:" + drawable2);
            obtainStyledAttributes.recycle();
            if (z5 && z6 && drawable == null && drawable2 == null) {
                if (color == activity.getResources().getColor(R.color.transparent)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            f.i(TAG, "check TranslucentNotitleTheme failed :" + th);
        }
        return false;
    }

    private boolean isWakeActivity(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            if (activity.getIntent() == null || TextUtils.isEmpty(activity.getIntent().getAction())) {
                return false;
            }
            return "cn.jpush.android.intent.DActivity".equals(activity.getIntent().getAction());
        } catch (Throwable unused) {
            return false;
        }
    }

    private void reportWakeViolation(final Context context) {
        d.a("FUTURE_TASK", new b() { // from class: cn.jiguang.analytics.page.ActivityLifecycle.1
            @Override // cn.jiguang.by.b
            public void a() {
                try {
                    cn.jiguang.be.b.a(context, new JSONObject(), "wake_violation");
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void addActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            try {
                if (this.mActivityCallbacks == null) {
                    this.mActivityCallbacks = new ArrayList();
                }
                this.mActivityCallbacks.add(activityLifecycleCallbacks);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            if (JConstants.jAnalyticsAction != null && JConstants.isCallInit.get()) {
                JConstants.jAnalyticsAction.dispatchStatus(activity, "onCreate");
            }
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivityCreated(activity, bundle);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivityDestroyed(activity);
                }
            }
            if (activityTaskCount.get() == 0 && activity != null && JConstants.isCallInit.get()) {
                JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JConstants.SDK_TYPE, 110, null, null, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            if (JConstants.jAnalyticsAction != null && JConstants.isCallInit.get()) {
                JConstants.jAnalyticsAction.dispatchPause(activity);
            }
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivityPaused(activity);
                }
            }
            if (JConstants.isInstrumentationHookFailed || !JConstants.isCallInit.get()) {
                return;
            }
            PushSA.getInstance().onPause(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            if (JConstants.jAnalyticsAction != null && JConstants.isCallInit.get()) {
                JConstants.jAnalyticsAction.dispatchResume(activity);
            }
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivityResumed(activity);
                }
            }
            if (JConstants.isInstrumentationHookFailed || !JConstants.isCallInit.get()) {
                return;
            }
            PushSA.getInstance().onResume(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        try {
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivitySaveInstanceState(activity, bundle);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            if (JConstants.jAnalyticsAction != null && JConstants.isCallInit.get()) {
                JConstants.jAnalyticsAction.dispatchStatus(activity, "onStart");
            }
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStarted(activity);
                }
            }
            cacheBeforeInit(activity);
            AtomicInteger atomicInteger = activityTaskCount;
            if (atomicInteger.get() == 0) {
                f.c(TAG, "isForeground");
                if (activity != null && JConstants.isCallInit.get()) {
                    JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JConstants.SDK_TYPE, 66, null, null, 1);
                }
            }
            if (this.isFromSync) {
                return;
            }
            atomicInteger.set(atomicInteger.get() + 1);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            if (this.aidlBuildSuccess) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStopped(activity);
                }
            }
            AtomicInteger atomicInteger = activityTaskCount;
            if (atomicInteger.get() > 0) {
                atomicInteger.set(atomicInteger.get() - 1);
            }
            f.c(TAG, "onActivityStopped activityTaskCount:" + atomicInteger);
            if (atomicInteger.get() == 0 && JConstants.isCallInit.get()) {
                f.c(TAG, "is not Foreground");
                JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JConstants.SDK_TYPE, 66, null, null, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void removeActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            try {
                this.mActivityCallbacks.remove(activityLifecycleCallbacks);
            } catch (Throwable unused) {
            }
        }
    }
}
