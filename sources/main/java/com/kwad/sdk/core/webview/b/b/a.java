package com.kwad.sdk.core.webview.b.b;

import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.webview.b.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0693a {
        void c(com.kwad.sdk.h.a.b bVar);

        void d(com.kwad.sdk.h.a.b bVar);

        void e(com.kwad.sdk.h.a.b bVar);
    }

    public static void a(final com.kwad.sdk.h.a.b bVar, @NonNull final InterfaceC0693a interfaceC0693a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0693a.c(bVar);
        bVar.aQ(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.aH(m.Ta());
        r.xI();
        r.bm(bVar.packageUrl).f(bVar).bk(bVar.aRr).be(true).a(new com.kwad.framework.filedownloader.m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0693a.this.e((com.kwad.sdk.h.a.b) aVar.getTag());
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.wJ() == -3) {
                    InterfaceC0693a.this.d(bVar);
                    return;
                }
                InterfaceC0693a.this.e(bVar);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.wJ()));
            }
        }).start();
    }
}
