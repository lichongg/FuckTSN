package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private Map<Integer, AdResultData> NI = new ConcurrentHashMap();
    private AtomicInteger NJ = new AtomicInteger(0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        static f NK = new f();
    }

    public static f ol() {
        return a.NK;
    }

    public final AdResultData d(int i6, boolean z5) {
        AdResultData adResultData = this.NI.get(Integer.valueOf(i6));
        this.NI.remove(Integer.valueOf(i6));
        return adResultData;
    }

    public final int l(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.NJ.incrementAndGet();
        this.NI.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}
