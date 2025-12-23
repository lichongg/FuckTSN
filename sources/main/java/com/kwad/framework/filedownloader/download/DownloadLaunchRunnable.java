package com.kwad.framework.filedownloader.download;

import com.kuaishou.weapon.p0.g;
import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor anE = com.kwad.framework.filedownloader.f.b.bA("ConnectionBlock");
    private final boolean anA;
    private final ArrayList<c> anB;
    private e anC;
    private boolean anD;
    private boolean anF;
    private boolean anG;
    private boolean anH;
    private final AtomicBoolean anI;
    private volatile boolean anJ;
    private volatile Exception anK;
    private String anL;
    private long anM;
    private long anN;
    private long anO;
    private long anP;
    private final com.kwad.framework.filedownloader.b.a ano;
    private final d anr;
    private final int ans;
    private final com.kwad.framework.filedownloader.d.c ant;
    private final com.kwad.framework.filedownloader.d.b anu;
    private final boolean anv;
    private final boolean anw;
    private final y anx;
    private boolean any;
    int anz;
    private volatile boolean nf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private Integer anQ;
        private Integer anR;
        private Boolean anS;
        private Boolean anT;
        private Integer anU;
        private com.kwad.framework.filedownloader.d.b ana;
        private com.kwad.framework.filedownloader.d.c ant;
        private y anx;

        public final a a(y yVar) {
            this.anx = yVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.ana = bVar;
            return this;
        }

        public final a a(Boolean bool) {
            this.anS = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.anT = bool;
            return this;
        }

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.ant = cVar;
            return this;
        }

        public final a f(Integer num) {
            this.anQ = num;
            return this;
        }

        public final a g(Integer num) {
            this.anR = num;
            return this;
        }

        public final a h(Integer num) {
            this.anU = num;
            return this;
        }

        public final DownloadLaunchRunnable ys() {
            if (this.ant == null || this.anx == null || this.anQ == null || this.anR == null || this.anS == null || this.anT == null || this.anU == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.ant, this.ana, this.anx, this.anQ.intValue(), this.anR.intValue(), this.anS.booleanValue(), this.anT.booleanValue(), this.anU.intValue(), (byte) 0);
        }
    }

    /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i6, int i7, boolean z5, boolean z6, int i8, byte b6) {
        this(cVar, bVar, yVar, i6, i7, z5, z6, i8);
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) {
        int id = this.ant.getId();
        int responseCode = bVar.getResponseCode();
        this.anG = responseCode == 206 || responseCode == 1;
        boolean z5 = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String za = this.ant.za();
        String a6 = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (responseCode != 412 && ((za == null || za.equals(a6) || !(z5 || this.anG)) && (!(responseCode == 201 && connectTask.xY()) && (responseCode != 416 || this.ant.yZ() <= 0)))) {
            this.anL = connectTask.xZ();
            if (!this.anG && !z5) {
                throw new FileDownloadHttpException(responseCode, map, bVar.xR());
            }
            long b6 = com.kwad.framework.filedownloader.f.f.b(id, bVar);
            String a7 = this.ant.wF() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.ant.getUrl()) : null;
            boolean z6 = b6 == -1;
            this.anH = z6;
            if (!z6) {
                b6 += this.ant.yZ();
            }
            this.anr.a(this.anF && this.anG, b6, a6, a7);
            return;
        }
        if (this.anF) {
            com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), za, a6, Integer.valueOf(responseCode));
        }
        this.ano.bF(this.ant.getId());
        com.kwad.framework.filedownloader.f.f.C(this.ant.getTargetFilePath(), this.ant.yr());
        this.anF = false;
        if (za != null && za.equals(a6)) {
            com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", za, a6, Integer.valueOf(responseCode), Integer.valueOf(id));
            a6 = null;
        }
        this.ant.Z(0L);
        this.ant.ab(0L);
        this.ant.bx(a6);
        this.ant.zd();
        this.ano.a(id, this.ant.za(), this.ant.yZ(), this.ant.getTotal(), this.ant.zc());
        throw new RetryDirectly();
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j6) {
        int id = this.ant.getId();
        String za = this.ant.za();
        String str = this.anL;
        if (str == null) {
            str = this.ant.getUrl();
        }
        String yr = this.ant.yr();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j6));
        }
        boolean z5 = this.anF;
        long j7 = 0;
        long j8 = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            long yV = aVar.yW() == j7 ? j6 - aVar.yV() : (aVar.yW() - aVar.yV()) + 1;
            j8 += aVar.yV() - aVar.getStartOffset();
            if (yV != j7) {
                c yt = new c.a().bM(id).i(Integer.valueOf(aVar.getIndex())).a(this).bs(str).bt(z5 ? za : null).c(this.anu).bg(this.anw).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.yV(), aVar.yW(), yV)).bu(yr).yt();
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.anB.add(yt);
            } else if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
            }
            j7 = 0;
        }
        if (j8 != this.ant.yZ()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.ant.yZ()), Long.valueOf(j8));
            this.ant.Z(j8);
        }
        ArrayList arrayList = new ArrayList(this.anB.size());
        Iterator<c> it = this.anB.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.nf) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.nf) {
            this.ant.d((byte) -2);
            return;
        }
        List<Future> invokeAll = anE.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            for (Future future : invokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    public final void pause() {
        this.nf = true;
        e eVar = this.anC;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.anB.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i6, int i7, boolean z5, boolean z6, int i8) {
        this.ans = 5;
        this.anB = new ArrayList<>(5);
        this.anM = 0L;
        this.anN = 0L;
        this.anO = 0L;
        this.anP = 0L;
        this.anI = new AtomicBoolean(true);
        this.nf = false;
        this.any = false;
        this.ant = cVar;
        this.anu = bVar;
        this.anv = z5;
        this.anw = z6;
        this.ano = b.yc().ye();
        this.anA = b.yc().yg();
        this.anx = yVar;
        this.anz = i8;
        this.anr = new d(cVar, i8, i6, i7);
    }

    private void d(long j6, int i6) {
        long j7 = j6 / i6;
        int id = this.ant.getId();
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        long j8 = 0;
        while (i7 < i6) {
            long j9 = i7 == i6 + (-1) ? 0L : (j8 + j7) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i7);
            aVar.setStartOffset(j8);
            aVar.X(j8);
            aVar.Y(j9);
            arrayList.add(aVar);
            this.ano.a(aVar);
            j8 += j7;
            i7++;
        }
        this.ant.bW(i6);
        this.ano.t(id, i6);
        b(arrayList, j6);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.framework.filedownloader.download.a r(java.util.List<com.kwad.framework.filedownloader.d.a> r21) {
        /*
            r20 = this;
            r0 = r20
            com.kwad.framework.filedownloader.d.c r1 = r0.ant
            int r1 = r1.zc()
            com.kwad.framework.filedownloader.d.c r2 = r0.ant
            java.lang.String r2 = r2.yr()
            com.kwad.framework.filedownloader.d.c r3 = r0.ant
            java.lang.String r3 = r3.getTargetFilePath()
            r4 = 0
            r5 = 1
            if (r1 <= r5) goto L1a
            r6 = 1
            goto L1b
        L1a:
            r6 = 0
        L1b:
            r7 = 0
            if (r6 == 0) goto L23
            boolean r9 = r0.anA
            if (r9 == 0) goto L54
        L23:
            com.kwad.framework.filedownloader.d.c r9 = r0.ant
            int r9 = r9.getId()
            com.kwad.framework.filedownloader.d.c r10 = r0.ant
            boolean r9 = com.kwad.framework.filedownloader.f.f.b(r9, r10)
            if (r9 == 0) goto L54
            boolean r9 = r0.anA
            if (r9 != 0) goto L40
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            long r9 = r1.length()
        L3e:
            r14 = r9
            goto L55
        L40:
            if (r6 == 0) goto L4d
            int r6 = r21.size()
            if (r1 != r6) goto L54
            long r9 = com.kwad.framework.filedownloader.d.a.s(r21)
            goto L3e
        L4d:
            com.kwad.framework.filedownloader.d.c r1 = r0.ant
            long r9 = r1.yZ()
            goto L3e
        L54:
            r14 = r7
        L55:
            com.kwad.framework.filedownloader.d.c r1 = r0.ant
            r1.Z(r14)
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L5f
            r4 = 1
        L5f:
            r0.anF = r4
            if (r4 != 0) goto L71
            com.kwad.framework.filedownloader.b.a r1 = r0.ano
            com.kwad.framework.filedownloader.d.c r4 = r0.ant
            int r4 = r4.getId()
            r1.bF(r4)
            com.kwad.framework.filedownloader.f.f.C(r3, r2)
        L71:
            com.kwad.framework.filedownloader.download.a r11 = new com.kwad.framework.filedownloader.download.a
            com.kwad.framework.filedownloader.d.c r1 = r0.ant
            long r1 = r1.getTotal()
            long r18 = r1 - r14
            r12 = 0
            r16 = 0
            r11.<init>(r12, r14, r16, r18)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.r(java.util.List):com.kwad.framework.filedownloader.download.a");
    }

    private boolean yn() {
        return (!this.anF || this.ant.zc() > 1) && this.anG && this.anA && !this.anH;
    }

    private void yp() {
        if (this.anw && !com.kwad.framework.filedownloader.f.f.bH(g.f36042b)) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.ant.getId()), g.f36042b));
        }
        if (this.anw && com.kwad.framework.filedownloader.f.f.zG()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void yq() {
        int id = this.ant.getId();
        if (this.ant.wF()) {
            String targetFilePath = this.ant.getTargetFilePath();
            int B = com.kwad.framework.filedownloader.f.f.B(this.ant.getUrl(), targetFilePath);
            if (com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.anv, false)) {
                this.ano.bG(id);
                this.ano.bF(id);
                throw new DiscardSafely();
            }
            com.kwad.framework.filedownloader.d.c bD = this.ano.bD(B);
            if (bD != null) {
                if (com.kwad.framework.filedownloader.f.c.a(id, bD, this.anx, false)) {
                    this.ano.bG(id);
                    this.ano.bF(id);
                    throw new DiscardSafely();
                }
                List<com.kwad.framework.filedownloader.d.a> bE = this.ano.bE(B);
                this.ano.bG(B);
                this.ano.bF(B);
                com.kwad.framework.filedownloader.f.f.bL(this.ant.getTargetFilePath());
                if (com.kwad.framework.filedownloader.f.f.b(B, bD)) {
                    this.ant.Z(bD.yZ());
                    this.ant.ab(bD.getTotal());
                    this.ant.bx(bD.za());
                    this.ant.bW(bD.zc());
                    this.ano.b(this.ant);
                    if (bE != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : bE) {
                            aVar.setId(id);
                            this.ano.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwad.framework.filedownloader.f.c.a(id, this.ant.yZ(), this.ant.yr(), targetFilePath, this.anx)) {
                this.ano.bG(id);
                this.ano.bF(id);
                throw new DiscardSafely();
            }
        }
    }

    public final int getId() {
        return this.ant.getId();
    }

    public final boolean isAlive() {
        return this.anI.get() || this.anr.isAlive();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j6) {
        if (this.nf) {
            return;
        }
        this.anr.onProgress(j6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x00a0, code lost:
    
        if (com.kwad.framework.filedownloader.f.d.apD == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x00a2, code lost:
    
        com.kwad.framework.filedownloader.f.d.c(r15, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r15.ant.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00b3, code lost:
    
        r15.anr.yu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00ba, code lost:
    
        if (r15.nf == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00bf, code lost:
    
        if (r15.anJ == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00c2, code lost:
    
        r15.anr.yz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x00c8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0120, code lost:
    
        if (r15.nf == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0122, code lost:
    
        r15.ant.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0127, code lost:
    
        if (r7 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0129, code lost:
    
        r7.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012c, code lost:
    
        r15.anr.yu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0133, code lost:
    
        if (r15.nf == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0139, code lost:
    
        if (r15.anJ == false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013d, code lost:
    
        r15.anr.yz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0144, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015e, code lost:
    
        yq();
        r13 = r15.ant.getTotal();
        a(r13, r15.ant.yr());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0174, code lost:
    
        if (yn() == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0178, code lost:
    
        if (r15.anF == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017a, code lost:
    
        r8 = r15.ant.zc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x019d, code lost:
    
        if (r8 <= 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a1, code lost:
    
        if (r15.nf == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a3, code lost:
    
        r15.ant.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a8, code lost:
    
        if (r7 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01aa, code lost:
    
        r7.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ad, code lost:
    
        r15.anr.yu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b4, code lost:
    
        if (r15.nf == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ba, code lost:
    
        if (r15.anJ == false) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01be, code lost:
    
        r15.anr.yz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c8, code lost:
    
        if (r8 != 1) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ca, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01cd, code lost:
    
        r15.anD = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01cf, code lost:
    
        if (r9 == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d1, code lost:
    
        a(r6.ya(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0204, code lost:
    
        if (r7 == null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0206, code lost:
    
        r7.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d9, code lost:
    
        if (r7 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01db, code lost:
    
        r7.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e0, code lost:
    
        r15.anr.yx();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e7, code lost:
    
        if (r15.anF == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e9, code lost:
    
        a(r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0203, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0200, code lost:
    
        d(r13, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01df, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01cc, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0219, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.c("invalid connection count %d, the connection count must be larger than 0", r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0181, code lost:
    
        r8 = com.kwad.framework.filedownloader.download.b.yc().a(r15.ant.getId(), r15.ant.getUrl(), r15.ant.getPath(), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019c, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0251 A[Catch: all -> 0x01ed, TryCatch #2 {all -> 0x01ed, blocks: (B:36:0x00cf, B:87:0x01e0, B:89:0x01e9, B:91:0x0200, B:121:0x024b, B:123:0x0251, B:129:0x0259, B:111:0x021e), top: B:120:0x024b }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0264 A[Catch: all -> 0x0030, TryCatch #5 {all -> 0x0030, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:25:0x0034, B:26:0x0091, B:28:0x0095, B:30:0x009a, B:163:0x009e, B:165:0x00a2, B:32:0x00ca, B:42:0x0129, B:61:0x01aa, B:76:0x0206, B:135:0x0264, B:136:0x0267, B:101:0x022d, B:114:0x0226, B:131:0x025e), top: B:2:0x0003 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 688
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    public final void ym() {
        if (this.ant.zc() > 1) {
            List<com.kwad.framework.filedownloader.d.a> bE = this.ano.bE(this.ant.getId());
            if (this.ant.zc() == bE.size()) {
                this.ant.Z(com.kwad.framework.filedownloader.d.a.s(bE));
            } else {
                this.ant.Z(0L);
                this.ano.bF(this.ant.getId());
            }
        }
        this.anr.yv();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void yo() {
        this.ano.b(this.ant.getId(), this.ant.yZ());
    }

    public final String yr() {
        return this.ant.yr();
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) {
        if (!this.anG) {
            this.ant.Z(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.anj, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).bP(this.ant.getId()).bO(-1).bi(this.anw).d(bVar).c(aVar).bv(this.ant.yr());
        this.ant.bW(1);
        this.ano.t(this.ant.getId(), 1);
        this.anC = aVar2.yG();
        if (this.nf) {
            this.ant.d((byte) -2);
            this.anC.pause();
        } else {
            this.anC.run();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.anJ = true;
        this.anK = exc;
        if (this.nf) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.ant.getId()));
            }
        } else {
            Iterator it = ((ArrayList) this.anB.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.xy();
                }
            }
        }
    }

    private void a(int i6, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i6 > 1 && list.size() == i6) {
            b(list, this.ant.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j6, String str) {
        com.kwad.framework.filedownloader.e.a aVar = null;
        if (j6 != -1) {
            try {
                aVar = com.kwad.framework.filedownloader.f.f.bJ(this.ant.yr());
                long length = new File(str).length();
                long j7 = j6 - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes >= j7) {
                    if (!com.kwad.framework.filedownloader.f.e.zB().apJ) {
                        aVar.setLength(j6);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j7, length);
                }
            } finally {
            }
        }
        if (aVar != null) {
            aVar.close();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j6, long j7) {
        if (this.nf) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.ant.getId()));
                return;
            }
            return;
        }
        int i6 = cVar == null ? -1 : cVar.anY;
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(this.ant.getTotal()));
        }
        if (!this.anD) {
            synchronized (this.anB) {
                this.anB.remove(cVar);
            }
        } else {
            if (j6 == 0 || j7 == this.ant.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(this.ant.getTotal()), Integer.valueOf(this.ant.getId()));
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.anD && code == 416 && !this.any) {
                com.kwad.framework.filedownloader.f.f.C(this.ant.getTargetFilePath(), this.ant.yr());
                this.any = true;
                return true;
            }
        }
        return this.anz > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j6) {
        if (this.nf) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.ant.getId()));
            }
        } else {
            int i6 = this.anz;
            int i7 = i6 - 1;
            this.anz = i7;
            if (i6 < 0) {
                com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i7), Integer.valueOf(this.ant.getId()));
            }
            this.anr.a(exc, this.anz, j6);
        }
    }
}
