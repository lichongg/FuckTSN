package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private final b aph;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        c.b yi();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        c.InterfaceC0659c api;
        Integer apj;
        c.e apk;
        c.b apl;
        a apm;
        c.a apn;
        c.d apo;

        public final b a(c.b bVar) {
            this.apl = bVar;
            return this;
        }

        public final b a(a aVar) {
            this.apm = aVar;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.c("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.api, this.apj, this.apk, this.apl, this.apn);
        }

        public final b ca(int i6) {
            this.apj = Integer.MAX_VALUE;
            return this;
        }
    }

    public c() {
        this.aph = null;
    }

    private static c.d zk() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static c.e zm() {
        return new b.a();
    }

    private static c.b zn() {
        return new c.b();
    }

    private static c.a zo() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public final int yf() {
        b bVar = this.aph;
        if (bVar == null) {
            return zl();
        }
        Integer num = bVar.apj;
        if (num == null) {
            return zl();
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return com.kwad.framework.filedownloader.f.e.ce(num.intValue());
    }

    public final com.kwad.framework.filedownloader.b.a zf() {
        c.InterfaceC0659c interfaceC0659c;
        b bVar = this.aph;
        if (bVar == null || (interfaceC0659c = bVar.api) == null) {
            return new com.kwad.framework.filedownloader.b.c();
        }
        com.kwad.framework.filedownloader.b.a zA = interfaceC0659c.zA();
        return zA != null ? zA : new com.kwad.framework.filedownloader.b.c();
    }

    public final c.e zg() {
        b bVar = this.aph;
        if (bVar == null) {
            return zm();
        }
        c.e eVar = bVar.apk;
        if (eVar == null) {
            return zm();
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
        }
        return eVar;
    }

    public final c.b zh() {
        c.b yi;
        b bVar = this.aph;
        if (bVar == null) {
            return zn();
        }
        a aVar = bVar.apm;
        return (aVar == null || (yi = aVar.yi()) == null) ? zn() : yi;
    }

    public final c.a zi() {
        b bVar = this.aph;
        if (bVar == null) {
            return zo();
        }
        c.a aVar = bVar.apn;
        if (aVar == null) {
            return zo();
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
        }
        return aVar;
    }

    public final c.d zj() {
        b bVar = this.aph;
        if (bVar == null) {
            return zk();
        }
        c.d dVar = bVar.apo;
        if (dVar == null) {
            return zk();
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
        }
        return dVar;
    }

    public c(b bVar) {
        this.aph = bVar;
    }

    private static int zl() {
        return com.kwad.framework.filedownloader.f.e.zB().apI;
    }
}
