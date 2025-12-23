package com.bytedance.sdk.openadsdk.core.jy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.core.oq;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    public interface j {
        void j();

        void j(String str);

        void j(boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.bytedance.sdk.openadsdk.core.rn.j r5 = oq.i().r();
        if (r5 == null) {
            return;
        }
        r5.j((Application.ActivityLifecycleCallbacks) null);
    }

    public void j(final j jVar) {
        com.bytedance.sdk.openadsdk.core.rn.j r5;
        if (jVar == null || (r5 = oq.i().r()) == null) {
            return;
        }
        r5.j(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.openadsdk.core.jy.ae.1
            private WeakReference<Object> cw;

            private boolean j(@ForbidWrapParam Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.cw) == null || activity != weakReference.get()) ? false : true;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
                ae.this.j();
                jVar.j("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
                ae.this.j();
                jVar.j("destroy");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@ForbidWrapParam Activity activity) {
                this.cw = new WeakReference<>(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@ForbidWrapParam Activity activity) {
                ae.this.j();
                jVar.j();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@ForbidWrapParam Activity activity) {
                ae.this.j();
                jVar.j("start");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@ForbidWrapParam Activity activity) {
                ae.this.j();
                jVar.j(j(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
            }
        });
    }
}
