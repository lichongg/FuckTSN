package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h {
    private static volatile h aEG;
    private List<a> aEF = new CopyOnWriteArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(f fVar, int i6);
    }

    public static h Hy() {
        if (aEG == null) {
            synchronized (h.class) {
                try {
                    if (aEG == null) {
                        aEG = new h();
                    }
                } finally {
                }
            }
        }
        return aEG;
    }

    public final void a(a aVar) {
        this.aEF.add(aVar);
    }

    final void b(f fVar, int i6) {
        Iterator<a> it = this.aEF.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i6);
        }
    }

    private h() {
    }
}
