package com.kwad.components.ad.i;

import com.kwad.components.core.proxy.f;
import com.kwad.components.core.proxy.l;
import com.kwad.components.core.proxy.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements com.kwad.components.core.internal.api.b {
    private static final Object qA = new Object();
    private static volatile b qB;
    private Set<Integer> qC = new HashSet();
    private List<c> qD = new ArrayList();
    private Map<com.kwad.components.core.internal.api.a, Object> qE = new WeakHashMap();
    private Map<f, Object> qF = new WeakHashMap();
    private m qG = new m() { // from class: com.kwad.components.ad.i.b.1
        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(f fVar) {
            super.d(fVar);
            b.this.qF.put(fVar, b.qA);
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(f fVar) {
            super.c(fVar);
            b.this.qF.remove(fVar);
            if (b.this.qF.isEmpty()) {
                b.this.fS();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fS() {
        boolean fT = fT();
        com.kwad.sdk.core.d.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + fT);
        if (fT) {
            Iterator<c> it = this.qD.iterator();
            while (it.hasNext()) {
                it.next().fX();
            }
        }
    }

    public final synchronized boolean fT() {
        Iterator<com.kwad.components.core.internal.api.a> it = this.qE.keySet().iterator();
        while (it.hasNext()) {
            if (J(it.next().getAdTemplate())) {
                return false;
            }
        }
        return this.qF.isEmpty();
    }

    private boolean J(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.qC.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.qE.put(aVar, qA);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.fV();
            this.qD.add(cVar);
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.qE.remove(aVar);
        Iterator<c> it = this.qD.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        if (J(aVar.getAdTemplate())) {
            fS();
        }
    }

    public static b fR() {
        if (qB == null) {
            synchronized (b.class) {
                try {
                    if (qB == null) {
                        qB = new b();
                    }
                } finally {
                }
            }
        }
        return qB;
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    private b() {
        l.rV().a(this.qG);
        this.qC.add(2);
        this.qC.add(3);
        this.qC.add(13);
        this.qC.add(6);
    }

    private static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (!aVar.supportPushAd()) {
            return false;
        }
        return com.kwad.sdk.core.response.b.a.da(com.kwad.sdk.core.response.b.e.el(aVar.getAdTemplate()));
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.qD.remove(cVar);
        }
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }
}
