package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, l<?>> f15352a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, l<?>> f15353b = new HashMap();

    private Map<com.bumptech.glide.load.c, l<?>> c(boolean z5) {
        return z5 ? this.f15353b : this.f15352a;
    }

    @VisibleForTesting
    Map<com.bumptech.glide.load.c, l<?>> b() {
        return Collections.unmodifiableMap(this.f15352a);
    }

    r() {
    }

    l<?> a(com.bumptech.glide.load.c cVar, boolean z5) {
        return c(z5).get(cVar);
    }

    void d(com.bumptech.glide.load.c cVar, l<?> lVar) {
        c(lVar.q()).put(cVar, lVar);
    }

    void e(com.bumptech.glide.load.c cVar, l<?> lVar) {
        Map<com.bumptech.glide.load.c, l<?>> c6 = c(lVar.q());
        if (lVar.equals(c6.get(cVar))) {
            c6.remove(cVar);
        }
    }
}
