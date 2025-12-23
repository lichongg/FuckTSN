package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private final List<f> PY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private static final g PZ = new g(0);
    }

    /* synthetic */ g(byte b6) {
        this();
    }

    private g() {
        this.PY = new CopyOnWriteArrayList();
    }

    public final void a(f fVar) {
        this.PY.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.PY.remove(fVar);
        }
    }

    public final void pZ() {
        Iterator<f> it = this.PY.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void qa() {
        Iterator<f> it = this.PY.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }

    public static g pY() {
        return a.PZ;
    }
}
