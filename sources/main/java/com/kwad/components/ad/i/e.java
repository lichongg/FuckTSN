package com.kwad.components.ad.i;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private final AtomicBoolean qY;
    private final List<com.kwad.components.ad.b.a.b> qZ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final e ra = new e(0);
    }

    /* synthetic */ e(byte b6) {
        this();
    }

    private e() {
        this.qY = new AtomicBoolean();
        this.qZ = new CopyOnWriteArrayList();
    }

    public final boolean T() {
        return this.qY.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.qZ.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.qZ.remove(bVar);
        }
    }

    public final void ga() {
        this.qY.set(true);
        Iterator<com.kwad.components.ad.b.a.b> it = this.qZ.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    public final void gc() {
        this.qY.set(false);
        Iterator<com.kwad.components.ad.b.a.b> it = this.qZ.iterator();
        while (it.hasNext()) {
            it.next().V();
        }
    }

    public static e ge() {
        return a.ra;
    }
}
