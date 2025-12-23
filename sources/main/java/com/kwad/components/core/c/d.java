package com.kwad.components.core.c;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {
    private static boolean NB = true;
    private static volatile d Nz;

    @NonNull
    private final SparseArray<c> Ny;

    static /* synthetic */ boolean a(d dVar) {
        return oe();
    }

    public static d od() {
        if (Nz == null) {
            synchronized (d.class) {
                try {
                    if (Nz == null) {
                        Nz = new d();
                    }
                } finally {
                }
            }
        }
        return Nz;
    }

    private static boolean oe() {
        if (!NB) {
            return false;
        }
        try {
        } catch (ClassNotFoundException unused) {
            NB = false;
        }
        if (com.kwad.sdk.components.g.df("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
            return false;
        }
        Class.forName("com.kwad.devTools.PosConfigFetcher");
        NB = true;
        return NB;
    }

    private d() {
        SparseArray<c> sparseArray = new SparseArray<>();
        this.Ny = sparseArray;
        sparseArray.append(0, new n());
        sparseArray.append(1, new m());
        sparseArray.append(2, new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.request.model.a aVar, c cVar) {
        String name = cVar.getName();
        name.getClass();
        if (name.equals("StrategyNetworkFirst")) {
            aVar.aE("network_first");
        } else if (!name.equals("StrategyLocalCacheFirst")) {
            aVar.aE("network_only");
        } else {
            aVar.aE("cache_first");
        }
    }

    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Ju().submit(new bg() { // from class: com.kwad.components.core.c.d.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                final e x5 = e.x(aVar.getPosId());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.c.d.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        b.b(x5);
                    }
                });
                c cVar = (d.a(d.this) || !(x5.isDefault() || x5.isEnable())) ? (c) d.this.Ny.get(0) : (c) d.this.Ny.get(x5.oh());
                if (cVar == null) {
                    cVar = (c) d.this.Ny.get(1);
                }
                com.kwad.components.core.request.j su = aVar.su();
                if (su != null) {
                    cVar.getName();
                    su.ah();
                }
                d dVar = d.this;
                d.a(aVar, cVar);
                com.kwad.components.core.request.model.a aVar2 = aVar;
                com.kwad.sdk.commercial.d.d.c(aVar2.Rw.adScene, aVar2.sv());
                cVar.d(aVar);
            }
        });
    }
}
