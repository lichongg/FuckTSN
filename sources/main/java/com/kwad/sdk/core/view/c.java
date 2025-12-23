package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private List<b> aML = new CopyOnWriteArrayList();

    private boolean c(b bVar) {
        if (bVar != null) {
            return this.aML.contains(bVar);
        }
        return false;
    }

    public final void b(b bVar) {
        this.aML.remove(bVar);
    }

    public final void j(View view, boolean z5) {
        Iterator<b> it = this.aML.iterator();
        while (it.hasNext()) {
            it.next().i(view, z5);
        }
    }

    public final void a(b bVar) {
        if (!c(bVar)) {
            this.aML.add(bVar);
        }
    }
}
