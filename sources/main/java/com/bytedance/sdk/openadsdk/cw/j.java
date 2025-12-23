package com.bytedance.sdk.openadsdk.cw;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f31366j;
    private volatile WeakReference<Activity> cw;

    /* renamed from: r, reason: collision with root package name */
    private InterfaceC0500j f31367r;
    private int xt = 0;

    /* renamed from: com.bytedance.sdk.openadsdk.cw.j$j, reason: collision with other inner class name */
    public interface InterfaceC0500j {
        void j();

        void xt();
    }

    public Boolean j() {
        return Boolean.valueOf(f31366j);
    }

    public void j(InterfaceC0500j interfaceC0500j) {
        this.f31367r = interfaceC0500j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.cw = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.xt++;
        f31366j = false;
        InterfaceC0500j interfaceC0500j = this.f31367r;
        if (interfaceC0500j != null) {
            interfaceC0500j.xt();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i6 = this.xt - 1;
        this.xt = i6;
        if (i6 == 0) {
            f31366j = true;
            InterfaceC0500j interfaceC0500j = this.f31367r;
            if (interfaceC0500j != null) {
                interfaceC0500j.j();
            }
        }
    }

    public Activity xt() {
        if (this.cw == null) {
            return null;
        }
        return this.cw.get();
    }

    j() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
