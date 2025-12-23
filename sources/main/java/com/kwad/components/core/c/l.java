package com.kwad.components.core.c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l implements c {
    private static void l(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.om().a(next)) {
                com.kwad.sdk.core.d.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.os());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }

    @Nullable
    @WorkerThread
    public static AdResultData e(com.kwad.components.core.request.model.a aVar) {
        a nZ = a.nZ();
        if (nZ == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> a6 = nZ.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.x(aVar.getPosId()).oi());
        if (com.kwad.sdk.core.config.e.FW()) {
            l(a6);
        }
        if (a6 == null || a6.size() <= 0) {
            return null;
        }
        Collections.sort(a6);
        return h.k(a6.subList(0, Math.min(a6.size(), adNum)));
    }

    @Override // com.kwad.components.core.c.c
    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Jt().submit(new bg() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdResultData e6 = l.e(aVar);
                if (e6 != null && !e6.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, e6, true);
                } else {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    n.a(aVar2, new j(aVar2));
                }
            }
        });
    }
}
