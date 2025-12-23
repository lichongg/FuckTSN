package com.kwad.components.core.o.b.a;

import android.app.Activity;
import android.os.Bundle;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILifeCycleListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g implements ILifeCycle {
    private final AtomicInteger RJ = new AtomicInteger(1);
    private final Map<Integer, com.kwad.sdk.core.c.d> RK = new HashMap();

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final int registerLifeCycleListener(final ILifeCycleListener iLifeCycleListener) {
        com.kwad.sdk.core.c.d dVar = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.o.b.a.g.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityCreated(activity, bundle);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityDestroyed(activity);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityPaused */
            public final void c(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityPaused(activity);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityResumed */
            public final void d(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityResumed(activity);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onBackToBackground();
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onBackToForeground();
                }
            }
        };
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(dVar);
        int incrementAndGet = this.RJ.incrementAndGet();
        this.RK.put(Integer.valueOf(incrementAndGet), dVar);
        return incrementAndGet;
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final void unregisterLifeCycleListener(int i6) {
        com.kwad.sdk.core.c.d dVar = this.RK.get(Integer.valueOf(i6));
        if (dVar != null) {
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) dVar);
        }
        this.RK.remove(Integer.valueOf(i6));
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final Activity getCurrentActivity() {
        com.kwad.sdk.core.c.b.Ho();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final boolean isAppOnForeground() {
        com.kwad.sdk.core.c.b.Ho();
        return com.kwad.sdk.core.c.b.isAppOnForeground();
    }
}
