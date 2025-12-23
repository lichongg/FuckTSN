package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> Fl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache(0);

        final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    /* synthetic */ SplashPlayModuleCache(byte b6) {
        this();
    }

    private SplashPlayModuleCache() {
        this.Fl = new HashMap<>(1);
    }
}
