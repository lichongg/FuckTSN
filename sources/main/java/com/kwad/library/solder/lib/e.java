package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c aqp;
    private final com.kwad.library.solder.lib.a.c aqr;
    private final com.kwad.library.solder.lib.a.f aqs;
    private final com.kwad.library.solder.lib.a.b aqt;
    private final com.kwad.library.solder.lib.ext.a aqu;
    private Map<String, b> aqv;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        private final com.kwad.library.solder.lib.a.e aqA;
        private final Future<com.kwad.library.solder.lib.a.e> aqB;

        public final void cancel() {
            this.aqA.cancel();
            this.aqB.cancel(true);
        }

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.aqA = eVar;
            this.aqB = future;
        }
    }

    @Nullable
    private synchronized b bQ(String str) {
        Map<String, b> d6 = d(this.aqv);
        this.aqv = d6;
        if (str == null) {
            return null;
        }
        return d6.get(str);
    }

    public final com.kwad.library.solder.lib.a.e a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        if (eVar.zZ() == null) {
            eVar.a(this);
        }
        eVar.Ad();
        eVar.Aa();
        aVar.j(eVar);
        return eVar;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {
        final com.kwad.library.solder.lib.a.d aqz;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        static class C0665a extends a {
            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aqz.zN().g(eVar);
            }

            C0665a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class b extends a {
            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aqz.zO().k(eVar);
            }

            b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }
        }

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i6) {
            return i6 != 1 ? new C0665a(dVar) : new b(dVar);
        }

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.aqz = dVar;
        }
    }

    private static Map<String, b> d(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c zM() {
        return this.aqp;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c zN() {
        return this.aqr;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f zO() {
        return this.aqs;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b zP() {
        return this.aqt;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a zQ() {
        return this.aqu;
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.aqr = cVar;
        this.aqs = fVar;
        this.aqt = bVar;
        this.aqp = cVar2;
        this.aqu = aVar;
    }

    private b b(@NonNull final com.kwad.library.solder.lib.a.e eVar, @NonNull final a aVar) {
        b bQ = bQ(eVar.Ad());
        if (bQ != null) {
            bQ.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.aqp.Aw().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: zR, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.Ad(), bVar);
        return bVar;
    }

    public final void i(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        b bQ = bQ(eVar.Ad());
        if (bQ != null) {
            bQ.cancel();
        }
        a(eVar.Ad(), (b) null);
    }

    public final b a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull int i6) {
        return b(eVar, a.a(this, 16));
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> d6 = d(this.aqv);
        this.aqv = d6;
        if (str != null) {
            d6.put(str, bVar);
        }
    }
}
