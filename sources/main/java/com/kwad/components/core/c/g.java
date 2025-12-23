package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g {
    private static volatile g NM;
    private ConcurrentHashMap<String, WeakReference<Object>> NL = new ConcurrentHashMap<>();

    @NonNull
    public static g om() {
        if (NM == null) {
            synchronized (g.class) {
                try {
                    if (NM == null) {
                        NM = new g();
                    }
                } finally {
                }
            }
        }
        return NM;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.NL.put(aw(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    private static String aw(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.ee(adTemplate) + "-" + com.kwad.sdk.core.response.b.e.ev(adTemplate);
    }

    private static String b(h hVar) {
        return hVar.og() + "-" + hVar.os();
    }

    public final boolean a(h hVar) {
        String b6 = b(hVar);
        com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains key: " + b6);
        boolean z5 = false;
        if (!this.NL.containsKey(b6)) {
            return false;
        }
        WeakReference<Object> weakReference = this.NL.get(b6);
        if (weakReference != null && weakReference.get() != null) {
            z5 = true;
        }
        if (z5) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z5;
    }

    public final void av(AdTemplate adTemplate) {
        this.NL.remove(aw(adTemplate));
    }
}
