package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s {
    private static boolean aZc;
    private static boolean aZd;

    public static boolean PS() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(2L)) & aZc;
    }

    public static boolean PT() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(4L)) & aZc;
    }

    public static boolean PU() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(2048L)) & aZc;
    }

    public static boolean PV() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bw() && aZc;
    }

    public static boolean PW() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(16L)) & aZc;
    }

    public static boolean PX() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(4096L)) & aZc;
    }

    public static boolean PY() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1L)) & aZc;
    }

    public static boolean PZ() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(128L)) & aZc;
    }

    public static boolean Qa() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(128L)) & aZc;
    }

    public static synchronized void cb(boolean z5) {
        synchronized (s.class) {
            if (aZd) {
                return;
            }
            aZd = true;
            aZc = true;
            GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.sdk.utils.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).Bg();
                }
            });
        }
    }
}
