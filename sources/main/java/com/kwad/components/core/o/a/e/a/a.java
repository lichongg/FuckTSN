package com.kwad.components.core.o.a.e.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> Rx = new HashMap();

    public static void a(int i6, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        Rx.put(Integer.valueOf(i6), new WeakReference<>(adResultData));
    }

    public static AdResultData aI(int i6) {
        WeakReference<AdResultData> weakReference = Rx.get(Integer.valueOf(i6));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}
