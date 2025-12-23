package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements a.c, x, x.a, x.b {
    private t alD;
    private final a alE;
    private volatile long alG;
    private final s.b alI;
    private final s.a alJ;
    private long alK;
    private long alL;
    private int alM;
    private boolean alN;
    private boolean alO;
    private String alP;
    private final Object alz;
    private volatile byte alF = 0;
    private Throwable alH = null;
    private boolean alQ = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void setFileName(String str);

        com.kwad.framework.filedownloader.d.b xe();

        a.InterfaceC0653a xf();

        ArrayList<Object> xg();
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte wJ = wJ();
        byte wJ2 = messageSnapshot.wJ();
        if (-2 == wJ && com.kwad.framework.filedownloader.d.d.bZ(wJ2)) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (com.kwad.framework.filedownloader.d.d.v(wJ, wJ2)) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.alF), Byte.valueOf(wJ()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot g(Throwable th) {
        b((byte) -1);
        this.alH = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), xj(), th);
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.alH = null;
        this.alP = null;
        this.alO = false;
        this.alM = 0;
        this.alQ = false;
        this.alN = false;
        this.alK = 0L;
        this.alL = 0L;
        this.alI.reset();
        if (com.kwad.framework.filedownloader.d.d.bY(this.alF)) {
            this.alD.xy();
            this.alD = new k(this.alE.xf(), this);
        } else {
            this.alD.b(this.alE.xf(), this);
        }
        b((byte) 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        com.kwad.framework.filedownloader.a wR = this.alE.xf().wR();
        byte wJ = messageSnapshot.wJ();
        b(wJ);
        this.alN = messageSnapshot.wP();
        if (wJ == -4) {
            this.alI.reset();
            int bs = h.xp().bs(wR.getId());
            if (bs + ((bs > 1 || !wR.wF()) ? 0 : h.xp().bs(com.kwad.framework.filedownloader.f.f.B(wR.getUrl(), wR.getTargetFilePath()))) <= 1) {
                byte bx = n.xA().bx(wR.getId());
                com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(wR.getId()), Integer.valueOf(bx));
                if (com.kwad.framework.filedownloader.d.d.bZ(bx)) {
                    b((byte) 1);
                    this.alL = messageSnapshot.yO();
                    long yQ = messageSnapshot.yQ();
                    this.alK = yQ;
                    this.alI.start(yQ);
                    this.alD.f(((MessageSnapshot.a) messageSnapshot).yS());
                    return;
                }
            }
            h.xp().a(this.alE.xf(), messageSnapshot);
            return;
        }
        if (wJ == -3) {
            this.alQ = messageSnapshot.yP();
            this.alK = messageSnapshot.yO();
            this.alL = messageSnapshot.yO();
            h.xp().a(this.alE.xf(), messageSnapshot);
            return;
        }
        if (wJ == -1) {
            this.alH = messageSnapshot.yR();
            this.alK = messageSnapshot.yQ();
            h.xp().a(this.alE.xf(), messageSnapshot);
            return;
        }
        if (wJ == 1) {
            this.alK = messageSnapshot.yQ();
            this.alL = messageSnapshot.yO();
            this.alD.f(messageSnapshot);
            return;
        }
        if (wJ == 2) {
            this.alL = messageSnapshot.yO();
            this.alO = messageSnapshot.yE();
            this.alP = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (wR.getFilename() != null) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", wR.getFilename(), fileName);
                }
                this.alE.setFileName(fileName);
            }
            this.alI.start(this.alK);
            this.alD.h(messageSnapshot);
            return;
        }
        if (wJ == 3) {
            this.alK = messageSnapshot.yQ();
            this.alI.U(messageSnapshot.yQ());
            this.alD.i(messageSnapshot);
        } else if (wJ != 5) {
            if (wJ != 6) {
                return;
            }
            this.alD.g(messageSnapshot);
        } else {
            this.alK = messageSnapshot.yQ();
            this.alH = messageSnapshot.yR();
            this.alM = messageSnapshot.wN();
            this.alI.reset();
            this.alD.k(messageSnapshot);
        }
    }

    private int getId() {
        return this.alE.xf().wR().getId();
    }

    private void prepare() {
        File file;
        com.kwad.framework.filedownloader.a wR = this.alE.xf().wR();
        if (wR.getPath() == null) {
            wR.bk(com.kwad.framework.filedownloader.f.f.bB(wR.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", wR.getPath());
            }
        }
        if (wR.wF()) {
            file = new File(wR.getPath());
        } else {
            String bF = com.kwad.framework.filedownloader.f.f.bF(wR.getPath());
            if (bF == null) {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.c("the provided mPath[%s] is invalid, can't find its directory", wR.getPath()));
            }
            file = new File(bF);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.c("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.alE.xf().wR())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.alE.xf().wR().wF() || messageSnapshot.wJ() != -4 || wJ() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.alJ.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.alG;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.alL;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(wJ()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.alF != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
            return;
        }
        a.InterfaceC0653a xf = this.alE.xf();
        com.kwad.framework.filedownloader.a wR = xf.wR();
        v xM = r.xI().xM();
        try {
            if (xM.f(xf)) {
                return;
            }
            synchronized (this.alz) {
                try {
                    if (this.alF != 10) {
                        com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
                        return;
                    }
                    b((byte) 11);
                    h.xp().b(xf);
                    if (com.kwad.framework.filedownloader.f.c.a(wR.getId(), wR.getTargetFilePath(), wR.wK(), true)) {
                        return;
                    }
                    boolean a6 = n.xA().a(wR.getUrl(), wR.getPath(), wR.wF(), wR.wD(), wR.wE(), wR.wM(), wR.wK(), this.alE.xe(), wR.wQ());
                    if (this.alF == -2) {
                        com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                        if (a6) {
                            n.xA().bw(getId());
                            return;
                        }
                        return;
                    }
                    if (a6) {
                        xM.e(xf);
                        return;
                    }
                    if (xM.f(xf)) {
                        return;
                    }
                    MessageSnapshot g6 = g(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.xp().a(xf)) {
                        xM.e(xf);
                        h.xp().b(xf);
                    }
                    h.xp().a(xf, g6);
                } finally {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.xp().a(xf, g(th));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte wJ() {
        return this.alF;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable wL() {
        return this.alH;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int wN() {
        return this.alM;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean wP() {
        return this.alN;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void xa() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(wJ()));
        }
        this.alI.end(this.alK);
        if (this.alE.xg() != null) {
            ArrayList arrayList = (ArrayList) this.alE.xg().clone();
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                arrayList.get(i6);
            }
        }
        r.xI().xM().e(this.alE.xf());
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t xh() {
        return this.alD;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void xi() {
        synchronized (this.alz) {
            try {
                if (this.alF != 0) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
                    return;
                }
                b((byte) 10);
                a.InterfaceC0653a xf = this.alE.xf();
                com.kwad.framework.filedownloader.a wR = xf.wR();
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", wR.getUrl(), wR.getPath(), wR.wG(), wR.getTag());
                }
                try {
                    prepare();
                    q.xG().a(this);
                } catch (Throwable th) {
                    h.xp().b(xf);
                    h.xp().a(xf, g(th));
                }
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long xj() {
        return this.alK;
    }

    d(a aVar, Object obj) {
        this.alz = obj;
        this.alE = aVar;
        b bVar = new b();
        this.alI = bVar;
        this.alJ = bVar;
        this.alD = new k(aVar.xf(), this);
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.u(wJ(), messageSnapshot.wJ())) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.alF), Byte.valueOf(wJ()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.bY(wJ())) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(wJ()), Integer.valueOf(this.alE.xf().wR().getId()));
            }
            return false;
        }
        b((byte) -2);
        a.InterfaceC0653a xf = this.alE.xf();
        com.kwad.framework.filedownloader.a wR = xf.wR();
        q.xG().b(this);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.xI();
        if (!r.xK()) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(wR.getId()));
            }
        } else {
            n.xA().bw(wR.getId());
        }
        h.xp().b(xf);
        h.xp().a(xf, com.kwad.framework.filedownloader.message.f.e(wR));
        r.xI().xM().e(xf);
        return true;
    }

    private void b(byte b6) {
        this.alF = b6;
        this.alG = System.currentTimeMillis();
    }
}
