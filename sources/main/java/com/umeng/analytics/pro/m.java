package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(14)
/* loaded from: D:\Downloads\app\classes7.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static m f41360a = new m();

    /* renamed from: b, reason: collision with root package name */
    private final int f41361b = 3000;

    /* renamed from: c, reason: collision with root package name */
    private boolean f41362c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f41363d = true;

    /* renamed from: e, reason: collision with root package name */
    private Handler f41364e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<n> f41365f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private a f41366g = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m.this.f41362c || !m.this.f41363d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            m.this.f41362c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i6 = 0; i6 < m.this.f41365f.size(); i6++) {
                ((n) m.this.f41365f.get(i6)).n();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f41363d = true;
        a aVar = this.f41366g;
        if (aVar != null) {
            this.f41364e.removeCallbacks(aVar);
            this.f41364e.postDelayed(this.f41366g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f41363d = false;
        this.f41362c = true;
        a aVar = this.f41366g;
        if (aVar != null) {
            this.f41364e.removeCallbacks(aVar);
        }
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i6 = 0; i6 < this.f41365f.size(); i6++) {
                try {
                    if (this.f41365f.get(i6) == nVar) {
                        this.f41365f.remove(i6);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private m() {
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f41360a);
        }
    }

    public static m a() {
        return f41360a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f41365f.add(nVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
