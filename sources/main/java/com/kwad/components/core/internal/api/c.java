package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {

    @NonNull
    private List<b> Ri = new CopyOnWriteArrayList();
    private boolean Rj = false;
    private boolean Rk = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Ri.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Ri.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.Rk);
        if (this.Rk) {
            return;
        }
        Iterator<b> it = this.Ri.iterator();
        while (it.hasNext()) {
            it.next().c(aVar);
        }
        this.Rk = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.Rj);
        if (this.Rj) {
            return;
        }
        Iterator<b> it = this.Ri.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        this.Rj = true;
    }
}
