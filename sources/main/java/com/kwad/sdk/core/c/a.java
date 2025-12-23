package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a implements Application.ActivityLifecycleCallbacks {
    private final List<WeakReference<Activity>> aDT;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mEnable;
    private boolean mIsInBackground;
    private final List<c> mListeners;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.c.a$a, reason: collision with other inner class name */
    static final class C0676a {
        static final a aDU = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (Hn()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().a(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.aDT = new ArrayList();
        this.mEnable = false;
    }

    public static a Hm() {
        return C0676a.aDU;
    }

    private void h(Activity activity) {
        Iterator<WeakReference<Activity>> it = this.aDT.iterator();
        while (it.hasNext()) {
            if (it.next().get() == activity) {
                return;
            }
        }
        this.aDT.add(new WeakReference<>(activity));
    }

    private void i(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.aDT.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(@NonNull Context context) {
        try {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    private boolean Hn() {
        if (!b.Hp() && this.mEnable) {
            return false;
        }
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (!Hn()) {
            try {
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().b(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!Hn()) {
            try {
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().c(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (!Hn()) {
            try {
                this.currentActivity = new WeakReference<>(activity);
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().d(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (!Hn()) {
            try {
                h(activity);
                if (this.aDT.size() == 1) {
                    this.mIsInBackground = false;
                    Iterator<c> it = this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onBackToForeground();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (!Hn()) {
            try {
                i(activity);
                if (this.aDT.size() == 0) {
                    this.mIsInBackground = true;
                    Iterator<c> it = this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onBackToBackground();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
