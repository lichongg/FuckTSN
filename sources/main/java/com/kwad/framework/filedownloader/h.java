package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    private final ArrayList<a.InterfaceC0653a> alT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final h alU = new h(0);
    }

    /* synthetic */ h(byte b6) {
        this();
    }

    final boolean a(a.InterfaceC0653a interfaceC0653a) {
        return this.alT.isEmpty() || !this.alT.contains(interfaceC0653a);
    }

    private h() {
        this.alT = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0653a interfaceC0653a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte wJ = messageSnapshot.wJ();
        synchronized (this.alT) {
            remove = this.alT.remove(interfaceC0653a);
        }
        if (com.kwad.framework.filedownloader.f.d.apD && this.alT.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0653a, Byte.valueOf(wJ), Integer.valueOf(this.alT.size()));
        }
        if (!remove) {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0653a, Byte.valueOf(wJ));
            return remove;
        }
        t xh = interfaceC0653a.wS().xh();
        if (wJ == -4) {
            xh.l(messageSnapshot);
            return remove;
        }
        if (wJ == -3) {
            xh.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            return remove;
        }
        if (wJ == -2) {
            xh.n(messageSnapshot);
            return remove;
        }
        if (wJ != -1) {
            return remove;
        }
        xh.m(messageSnapshot);
        return remove;
    }

    final int bs(int i6) {
        int i7;
        synchronized (this.alT) {
            try {
                Iterator<a.InterfaceC0653a> it = this.alT.iterator();
                i7 = 0;
                while (it.hasNext()) {
                    if (it.next().br(i6)) {
                        i7++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i7;
    }

    final List<a.InterfaceC0653a> bt(int i6) {
        byte wJ;
        ArrayList arrayList = new ArrayList();
        synchronized (this.alT) {
            try {
                Iterator<a.InterfaceC0653a> it = this.alT.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0653a next = it.next();
                    if (next.br(i6) && !next.isOver() && (wJ = next.wR().wJ()) != 0 && wJ != 10) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    final List<a.InterfaceC0653a> bu(int i6) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.alT) {
            try {
                Iterator<a.InterfaceC0653a> it = this.alT.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0653a next = it.next();
                    if (next.br(i6) && !next.isOver()) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    final void p(List<a.InterfaceC0653a> list) {
        synchronized (this.alT) {
            try {
                Iterator<a.InterfaceC0653a> it = this.alT.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0653a next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.alT.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final int size() {
        return this.alT.size();
    }

    public static h xp() {
        return a.alU;
    }

    final void b(a.InterfaceC0653a interfaceC0653a) {
        if (!interfaceC0653a.wR().wC()) {
            interfaceC0653a.wU();
        }
        if (interfaceC0653a.wS().xh().xu()) {
            c(interfaceC0653a);
        }
    }

    final void c(a.InterfaceC0653a interfaceC0653a) {
        if (interfaceC0653a.wV()) {
            return;
        }
        synchronized (this.alT) {
            try {
                if (this.alT.contains(interfaceC0653a)) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0653a);
                } else {
                    interfaceC0653a.wW();
                    this.alT.add(interfaceC0653a);
                    if (com.kwad.framework.filedownloader.f.d.apD) {
                        com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0653a, Byte.valueOf(interfaceC0653a.wR().wJ()), Integer.valueOf(this.alT.size()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
