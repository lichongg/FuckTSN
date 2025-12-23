package com.kwad.sdk.m.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private final List<b> aWS = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.aWS.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i6) {
        if (bVar != null) {
            this.aWS.add(i6, bVar);
        }
    }

    public final boolean onBackPressed() {
        Iterator<b> it = this.aWS.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.aWS.remove(bVar);
        }
    }
}
