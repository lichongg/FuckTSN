package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0653a> amz = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0653a interfaceC0653a) {
        return !this.amz.isEmpty() && this.amz.contains(interfaceC0653a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0653a interfaceC0653a) {
        if (this.amz.isEmpty()) {
            return;
        }
        synchronized (this.amz) {
            this.amz.remove(interfaceC0653a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0653a interfaceC0653a) {
        r.xI();
        if (!r.xK()) {
            synchronized (this.amz) {
                try {
                    r.xI();
                    if (!r.xK()) {
                        if (com.kwad.framework.filedownloader.f.d.apD) {
                            com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0653a.wR().getId()));
                        }
                        n.xA().aG(com.kwad.framework.filedownloader.f.c.zz());
                        if (!this.amz.contains(interfaceC0653a)) {
                            interfaceC0653a.free();
                            this.amz.add(interfaceC0653a);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        e(interfaceC0653a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void xk() {
        w xL = r.xI().xL();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.amz) {
            try {
                List<a.InterfaceC0653a> list = (List) this.amz.clone();
                this.amz.clear();
                ArrayList arrayList = new ArrayList(xL.xP());
                for (a.InterfaceC0653a interfaceC0653a : list) {
                    int wT = interfaceC0653a.wT();
                    if (xL.bA(wT)) {
                        interfaceC0653a.wR().wA().wZ();
                        if (!arrayList.contains(Integer.valueOf(wT))) {
                            arrayList.add(Integer.valueOf(wT));
                        }
                    } else {
                        interfaceC0653a.wX();
                    }
                }
                xL.q(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void xl() {
        if (xm() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w xL = r.xI().xL();
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.xp().size()));
            }
            if (h.xp().size() > 0) {
                synchronized (this.amz) {
                    try {
                        h.xp().p(this.amz);
                        Iterator<a.InterfaceC0653a> it = this.amz.iterator();
                        while (it.hasNext()) {
                            it.next().free();
                        }
                        xL.xO();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                r.xI().xJ();
                return;
            }
            return;
        }
        if (h.xp().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.xp().size()));
        }
    }
}
