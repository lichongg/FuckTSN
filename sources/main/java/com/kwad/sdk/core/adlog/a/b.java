package com.kwad.sdk.core.adlog.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private final c axv;
    private final List<com.kwad.sdk.core.adlog.a.a> axw;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final b axy = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    @Nullable
    private synchronized com.kwad.sdk.core.adlog.a.a EC() {
        if (ap.L(this.axw)) {
            return null;
        }
        return this.axw.remove(0);
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        int i6 = aVar.awx;
        return i6 == 1 || i6 == 2;
    }

    public final void a(@Nullable com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i6, String str2) {
        try {
            if (EE()) {
                return;
            }
            if (!EF() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        a.C0675a c0675a = aVar2.EL() == null ? new a.C0675a() : aVar2.EL();
                        c0675a.awU = 1;
                        aVar2.a(c0675a);
                        aa.putValue(jSONObject, "clientExtData", aVar2.Pk.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.Ez().dm(str).i(jSONObject).c(aVar2).as(System.currentTimeMillis());
                }
                aVar.cK(i6).dn(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.axv, this.axw.size());
                int i7 = aVar.retryCount;
                c cVar = this.axv;
                if (i7 >= cVar.axA) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.axw.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.axw.size() >= this.axv.axC) {
                    com.kwad.sdk.core.adlog.a.a EC = EC();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.axw.size() + ", remove log：" + EC);
                    com.kwad.sdk.core.adlog.b.a.e(EC, this.axv, this.axw.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.axw.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.axv, this.axw.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b() {
        this.axw = new CopyOnWriteArrayList();
        this.axv = (c) aa.b(((h) ServiceProvider.get(h.class)).BW(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            private static c EG() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ c Ef() {
                return EG();
            }
        });
    }

    private boolean EE() {
        c cVar = this.axv;
        return cVar == null || !cVar.axz;
    }

    private boolean EF() {
        c cVar = this.axv;
        return cVar != null && cVar.axD;
    }

    public static b EA() {
        return a.axy;
    }

    public final void EB() {
        try {
            if (EE() || ap.L(this.axw)) {
                return;
            }
            bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.Ex();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    public final com.kwad.sdk.core.adlog.a.a ED() {
        com.kwad.sdk.core.adlog.a.a EC = EC();
        if (EC == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(EC, this.axv, this.axw.size());
        long currentTimeMillis = System.currentTimeMillis() - EC.axs;
        c cVar = this.axv;
        if (currentTimeMillis > cVar.axB * 1000) {
            com.kwad.sdk.core.adlog.b.a.b(EC, cVar, this.axw.size(), currentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + currentTimeMillis + ", adLogCache：" + EC);
            return null;
        }
        EC.retryCount++;
        com.kwad.sdk.core.adlog.b.a.a(EC, cVar, this.axw.size(), currentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + EC);
        return EC;
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.axw.add(aVar);
    }
}
