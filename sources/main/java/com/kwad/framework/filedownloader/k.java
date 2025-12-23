package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class k implements t {
    private a.InterfaceC0653a ame;
    private a.c amf;
    private Queue<MessageSnapshot> amg;
    private boolean amh = false;

    @Override // com.kwad.framework.filedownloader.t
    public final void xy() {
        this.amh = true;
    }

    private void a(a.InterfaceC0653a interfaceC0653a, a.c cVar) {
        this.ame = interfaceC0653a;
        this.amf = cVar;
        this.amg = new LinkedBlockingQueue();
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.ame);
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0653a interfaceC0653a = this.ame;
        if (interfaceC0653a == null) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.wJ()));
            }
        } else {
            if (!this.amh && interfaceC0653a.wR().wG() != null) {
                this.amg.offer(messageSnapshot);
                j.xr().a(this);
                return;
            }
            if ((l.isValid() || this.ame.wY()) && messageSnapshot.wJ() == 4) {
                this.amf.xa();
            }
            bv(messageSnapshot.wJ());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0653a interfaceC0653a, a.c cVar) {
        if (this.ame != null) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("the messenger is working, can't re-appointment for %s", interfaceC0653a));
        }
        a(interfaceC0653a, cVar);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.ame);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.ame);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.ame);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a wR = this.ame.wR();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", wR, Long.valueOf(wR.wH()), Long.valueOf(wR.wI()));
        }
        if (wR.wD() > 0) {
            p(messageSnapshot);
        } else if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.ame);
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.ame, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            a wR = this.ame.wR();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.ame, Integer.valueOf(wR.wM()), Integer.valueOf(wR.wN()), wR.wL());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.ame);
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            a.InterfaceC0653a interfaceC0653a = this.ame;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0653a, interfaceC0653a.wR().wL());
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.ame);
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    public final String toString() {
        a.InterfaceC0653a interfaceC0653a = this.ame;
        return com.kwad.framework.filedownloader.f.f.c("%d:%s", Integer.valueOf(interfaceC0653a == null ? -1 : interfaceC0653a.wR().getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean xu() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.ame);
        }
        if (this.ame == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.amg.size()));
            return false;
        }
        this.amf.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void xv() {
        if (this.amh) {
            return;
        }
        MessageSnapshot poll = this.amg.poll();
        byte wJ = poll.wJ();
        a.InterfaceC0653a interfaceC0653a = this.ame;
        if (interfaceC0653a == null) {
            return;
        }
        a wR = interfaceC0653a.wR();
        i wG = wR.wG();
        x.a wS = interfaceC0653a.wS();
        bv(wJ);
        if (wG == null) {
            return;
        }
        if (wJ == 4) {
            try {
                wG.b(wR);
                o(((com.kwad.framework.filedownloader.message.a) poll).yL());
                return;
            } catch (Throwable th) {
                m(wS.g(th));
                return;
            }
        }
        g gVar = wG instanceof g ? (g) wG : null;
        if (wJ == -4) {
            wG.d(wR);
            return;
        }
        if (wJ == -3) {
            wG.c(wR);
            return;
        }
        if (wJ == -2) {
            if (gVar == null) {
                wG.c(wR, poll.yM(), poll.yN());
                return;
            } else {
                poll.yQ();
                poll.yO();
                return;
            }
        }
        if (wJ == -1) {
            wG.a(wR, poll.yR());
            return;
        }
        if (wJ == 1) {
            if (gVar == null) {
                wG.a(wR, poll.yM(), poll.yN());
                return;
            } else {
                poll.yQ();
                poll.yO();
                return;
            }
        }
        if (wJ == 2) {
            if (gVar == null) {
                wG.a(wR, poll.getEtag(), poll.yE(), wR.getSmallFileSoFarBytes(), poll.yN());
                return;
            }
            poll.getEtag();
            poll.yE();
            poll.yO();
            return;
        }
        if (wJ == 3) {
            if (gVar != null) {
                poll.yQ();
                return;
            } else {
                wG.b(wR, poll.yM(), wR.getSmallFileTotalBytes());
                return;
            }
        }
        if (wJ != 5) {
            if (wJ != 6) {
                return;
            }
            wG.a(wR);
        } else if (gVar != null) {
            poll.yR();
            poll.wN();
            poll.yQ();
        } else {
            poll.yR();
            poll.wN();
            poll.yM();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean xw() {
        return this.ame.wR().wO();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean xx() {
        return this.amg.peek().wJ() == 4;
    }

    k(a.InterfaceC0653a interfaceC0653a, a.c cVar) {
        a(interfaceC0653a, cVar);
    }

    private void bv(int i6) {
        if (com.kwad.framework.filedownloader.d.d.bY(i6)) {
            if (!this.amg.isEmpty()) {
                MessageSnapshot peek = this.amg.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.amg.size()), Byte.valueOf(peek.wJ()));
            }
            this.ame = null;
        }
    }
}
