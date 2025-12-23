package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> Fl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    /* synthetic */ AdVideoPlayerViewCache(byte b6) {
        this();
    }

    private AdVideoPlayerViewCache() {
        this.Fl = new HashMap<>(1);
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.Fl.put(str, new WeakReference<>(aVar));
    }

    public final a eF(String str) {
        WeakReference<a> weakReference = this.Fl.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.Fl.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.Fl.remove(str);
    }
}
