package com.kwad.components.core.t;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private Set<b> YJ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static c YK = new c(0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onPageClose();
    }

    /* synthetic */ c(byte b6) {
        this();
    }

    private c() {
        this.YJ = new HashSet();
    }

    public final void a(b bVar) {
        this.YJ.add(bVar);
    }

    public final void b(b bVar) {
        this.YJ.remove(bVar);
    }

    public final void ta() {
        if (this.YJ.size() == 0) {
            return;
        }
        Iterator<b> it = this.YJ.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }

    public static c sZ() {
        return a.YK;
    }
}
