package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private k Wc;
    private Set<c> Wd = new HashSet();

    private c b(Activity activity) {
        for (c cVar : this.Wd) {
            if (cVar.c(activity)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        this.Wd.add(new c(activity));
    }

    public b(k kVar) {
        this.Wc = kVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        c b6 = b(activity);
        if (b6 != null) {
            b6.a(Lifecycle.Event.ON_CREATE);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.a(b6);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityCreated : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull Activity activity) {
        c b6 = b(activity);
        if (b6 != null) {
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.f(b6);
            }
            this.Wd.remove(b6);
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityDestroyed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull Activity activity) {
        c b6 = b(activity);
        if (b6 != null) {
            b6.a(Lifecycle.Event.ON_PAUSE);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.d(b6);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityPaused : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull Activity activity) {
        c b6 = b(activity);
        if (b6 != null) {
            b6.a(Lifecycle.Event.ON_RESUME);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.c(b6);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityResumed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
        c b6 = b(activity);
        if (b6 != null) {
            b6.a(Lifecycle.Event.ON_START);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.b(b6);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStarted : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
        c b6 = b(activity);
        if (b6 != null) {
            b6.a(Lifecycle.Event.ON_STOP);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.e(b6);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStopped : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
