package com.ss.android.socialbase.downloader.j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.az.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {
    private volatile boolean ae;
    private final List<InterfaceC0786j> cw;

    /* renamed from: j, reason: collision with root package name */
    private Application f38876j;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f38877m;

    /* renamed from: r, reason: collision with root package name */
    private int f38878r;
    private final Application.ActivityLifecycleCallbacks tl;
    private WeakReference<Activity> up;
    private cw xt;

    public interface cw {
    }

    /* renamed from: com.ss.android.socialbase.downloader.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0786j {
        @MainThread
        void cw();

        @MainThread
        void xt();
    }

    private static class xt {

        /* renamed from: j, reason: collision with root package name */
        private static final j f38880j = new j();
    }

    private boolean ae() {
        try {
            Application application = this.f38876j;
            if (application == null) {
                return false;
            }
            application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), m.r(application));
        } catch (Throwable th) {
            vl.j(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f38877m = 0;
        Object[] r5 = r();
        if (r5 != null) {
            for (Object obj : r5) {
                ((InterfaceC0786j) obj).cw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        this.f38877m = 1;
        Object[] r5 = r();
        if (r5 != null) {
            for (Object obj : r5) {
                ((InterfaceC0786j) obj).xt();
            }
        }
    }

    private j() {
        this.cw = new ArrayList();
        this.f38877m = -1;
        this.ae = false;
        this.tl = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.j.j.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == j.this.f38878r) {
                    j.this.f38878r = 0;
                    j.this.m();
                }
                j.this.ae = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                j.this.ae = true;
                if (j.this.f38878r != 0 || activity == null) {
                    return;
                }
                j.this.f38878r = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i6 = j.this.f38878r;
                j.this.ae = false;
                j.this.f38878r = activity != null ? activity.hashCode() : i6;
                if (i6 == 0) {
                    j.this.up();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                j.this.up = new WeakReference(activity);
                int i6 = j.this.f38878r;
                j.this.f38878r = activity != null ? activity.hashCode() : i6;
                j.this.ae = false;
                if (i6 == 0) {
                    j.this.up();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }
        };
    }

    private Object[] r() {
        Object[] array;
        synchronized (this.cw) {
            try {
                array = this.cw.size() > 0 ? this.cw.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array;
    }

    public boolean cw() {
        return xt() && !this.ae;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public boolean xt() {
        int i6 = this.f38877m;
        int i7 = i6;
        if (i6 == -1) {
            ?? ae = ae();
            this.f38877m = ae;
            i7 = ae;
        }
        return i7 == 1;
    }

    public static j j() {
        return xt.f38880j;
    }

    public void xt(InterfaceC0786j interfaceC0786j) {
        synchronized (this.cw) {
            this.cw.remove(interfaceC0786j);
        }
    }

    public void j(Context context) {
        if (this.f38876j == null && (context instanceof Application)) {
            synchronized (this) {
                try {
                    if (this.f38876j == null) {
                        Application application = (Application) context;
                        this.f38876j = application;
                        application.registerActivityLifecycleCallbacks(this.tl);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void j(cw cwVar) {
        this.xt = cwVar;
    }

    public void j(InterfaceC0786j interfaceC0786j) {
        if (interfaceC0786j == null) {
            return;
        }
        synchronized (this.cw) {
            try {
                if (!this.cw.contains(interfaceC0786j)) {
                    this.cw.add(interfaceC0786j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
