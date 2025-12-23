package com.ss.android.socialbase.downloader.qv;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.g.cw;
import com.ss.android.socialbase.downloader.ws.up;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.d;

/* loaded from: D:\Downloads\app\classes6.dex */
public class qv implements cw.j, m {

    /* renamed from: a, reason: collision with root package name */
    private int f38939a;
    private int av;
    private long ch;
    private final xt cw;

    /* renamed from: i, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.up.j f38943i;

    /* renamed from: j, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ae.cw f38944j;
    private long jy;
    private final com.ss.android.socialbase.downloader.az.up kt;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f38945l;
    private com.ss.android.socialbase.downloader.ae.m oq;
    private com.ss.android.socialbase.downloader.ae.m qv;

    /* renamed from: r, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ws.m f38948r;

    /* renamed from: s, reason: collision with root package name */
    private float f38949s;
    private final com.ss.android.socialbase.downloader.ws.up tj;
    private final ae up;

    /* renamed from: v, reason: collision with root package name */
    private long f38950v;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f38951w;

    /* renamed from: x, reason: collision with root package name */
    private long f38952x;
    private final ws xt;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38946m = false;
    private volatile boolean ae = false;
    private final List<jy> tl = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final List<i> f38941g = new ArrayList();
    private volatile boolean vl = true;
    private final LinkedList<g> ws = new LinkedList<>();
    private final List<g> az = new ArrayList();
    private final Object mi = new Object();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f38940f = false;

    /* renamed from: p, reason: collision with root package name */
    private final up.xt f38947p = new up.xt() { // from class: com.ss.android.socialbase.downloader.qv.qv.1
        private int xt;

        @Override // com.ss.android.socialbase.downloader.ws.up.xt
        public long j() {
            if (qv.this.f38946m || qv.this.ae) {
                return -1L;
            }
            synchronized (qv.this) {
                try {
                    if (qv.this.oq == null && qv.this.qv == null) {
                        long j6 = qv.this.f38950v;
                        if (j6 <= 0) {
                            return -1L;
                        }
                        this.xt++;
                        jy j7 = qv.this.j(false, System.currentTimeMillis(), j6);
                        if (j7 == null) {
                            return j6;
                        }
                        com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        qv.this.cw(j7);
                        j7.m();
                        return ((this.xt / qv.this.f38941g.size()) + 1) * j6;
                    }
                    return -1L;
                } finally {
                }
            }
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private final up.xt f38942h = new up.xt() { // from class: com.ss.android.socialbase.downloader.qv.qv.2
        @Override // com.ss.android.socialbase.downloader.ws.up.xt
        public long j() {
            return qv.this.w();
        }
    };

    private g av() {
        g i6;
        qv qvVar;
        int i7 = 0;
        while (true) {
            i6 = i();
            if (i6 != null) {
                jy jyVar = i6.f38914j;
                if (jyVar == null) {
                    break;
                }
                if (i6.oq() >= 2) {
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                xt(currentTimeMillis);
                if (currentTimeMillis - jyVar.f38931m > 2000) {
                    qvVar = this;
                    if (qvVar.j(jyVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                        if (qvVar.f38945l) {
                            com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + i6 + ", owner.threadIndex = " + jyVar.cw);
                            return i6;
                        }
                    }
                } else {
                    qvVar = this;
                }
                int i8 = i7 + 1;
                if (i7 <= 2) {
                    try {
                        synchronized (this) {
                            wait(500L);
                        }
                        i7 = i8;
                    } catch (InterruptedException unused) {
                        return null;
                    }
                } else if (qvVar.f38945l) {
                    com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(i6)));
                }
            } else {
                return null;
            }
        }
        return i6;
    }

    private i oq() {
        i iVar;
        synchronized (this) {
            try {
                int size = this.av % this.f38941g.size();
                if (this.xt.xt()) {
                    this.av++;
                }
                iVar = this.f38941g.get(size);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    private void ae() {
        ws wsVar = this.xt;
        this.f38950v = wsVar.oq();
        this.f38952x = wsVar.qv();
        this.f38949s = wsVar.az();
        int i6 = this.f38939a;
        if (i6 > 0) {
            this.tj.j(this.f38947p, i6);
        }
    }

    private long az() {
        Iterator<jy> it = this.tl.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().xt();
        }
        return j6;
    }

    private void cw() throws com.ss.android.socialbase.downloader.up.j, InterruptedException {
        com.ss.android.socialbase.downloader.up.j jVar;
        synchronized (this.mi) {
            try {
                if (this.oq == null && this.qv == null) {
                    this.mi.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.oq == null && this.qv == null && (jVar = this.f38943i) != null) {
            throw jVar;
        }
    }

    private void g() {
        List<String> ja;
        int vl = this.xt.vl();
        if (vl <= 0) {
            this.vl = false;
            up();
            return;
        }
        com.ss.android.socialbase.downloader.g.cw j6 = com.ss.android.socialbase.downloader.g.cw.j();
        j6.j(this.f38944j.oq(), this, 2000L);
        if (vl <= 2 || (ja = this.f38944j.ja()) == null) {
            return;
        }
        for (String str : ja) {
            if (!TextUtils.isEmpty(str)) {
                j6.j(str, this, 2000L);
            }
        }
    }

    private g i() {
        int oq;
        g gVar = null;
        int i6 = Integer.MAX_VALUE;
        for (g gVar2 : this.az) {
            if (j(gVar2) > 0 && (oq = gVar2.oq()) < i6) {
                gVar = gVar2;
                i6 = oq;
            }
        }
        return gVar;
    }

    private void jy() {
        int size;
        if (this.jy > 0 && (size = this.az.size()) > 1) {
            ArrayList<g> arrayList = null;
            int i6 = 0;
            for (int i7 = 1; i7 < size; i7++) {
                g gVar = this.az.get(i6);
                g gVar2 = this.az.get(i7);
                if (gVar.up() > gVar2.cw() && gVar2.j() <= 0 && gVar2.f38914j == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(gVar2);
                    if (this.f38945l) {
                        com.bytedance.sdk.component.utils.vl.xt("SegmentDispatcher", "clearCovered, covered = " + gVar2 + ", prev = " + gVar);
                    }
                } else if (gVar2.up() > gVar.up()) {
                    i6++;
                }
            }
            if (arrayList != null) {
                for (g gVar3 : arrayList) {
                    this.az.remove(gVar3);
                    for (jy jyVar : this.tl) {
                        if (jyVar.f38929j == gVar3) {
                            if (this.f38945l) {
                                com.bytedance.sdk.component.utils.vl.xt("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + gVar3 + ", threadIndex = " + jyVar.cw);
                            }
                            jyVar.j(true);
                        }
                    }
                }
            }
        }
    }

    private void m() {
        this.f38941g.add(new i(this.f38944j.oq(), true));
        List<String> ja = this.f38944j.ja();
        if (ja != null) {
            for (String str : ja) {
                if (!TextUtils.isEmpty(str)) {
                    this.f38941g.add(new i(str, false));
                }
            }
        }
        this.xt.j(this.f38941g.size());
    }

    private void qv() {
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "onComplete");
        this.cw.cw();
        synchronized (this.mi) {
            this.mi.notify();
        }
    }

    private void r() throws com.ss.android.socialbase.downloader.up.j {
        try {
            this.up.j((r) this.cw);
        } catch (av unused) {
        } catch (com.ss.android.socialbase.downloader.up.j e6) {
            com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e6)));
            j(e6);
            throw e6;
        }
        if (this.ae || this.f38946m) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.ws.isEmpty()) {
                    try {
                        g poll = this.ws.poll();
                        if (poll != null) {
                            j(this.az, poll, true);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                cw(this.az);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.j(th2);
        }
        if (!this.f38940f || this.f38943i == null) {
            if (this.f38944j.uq() != this.f38944j.ka()) {
                com.ss.android.socialbase.downloader.tl.j.j(this.f38944j, this.az);
            }
            com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "dispatchSegments::download finished");
        } else {
            com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.f38943i);
            throw this.f38943i;
        }
    }

    private void tl() {
        if (this.f38952x > 0) {
            this.ch = System.currentTimeMillis();
            this.tj.j(this.f38942h, 0L);
        }
    }

    private void up() {
        int i6;
        if (this.jy <= 0 || this.vl) {
            i6 = 1;
        } else {
            i6 = this.xt.j();
            int tl = (int) (this.jy / this.xt.tl());
            if (i6 > tl) {
                i6 = tl;
            }
        }
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.jy + ", threadCount = " + i6);
        int i7 = i6 > 0 ? i6 : 1;
        synchronized (this) {
            do {
                try {
                    if (this.tl.size() >= i7) {
                        break;
                    }
                    if (!this.ae && !this.f38946m) {
                        j(oq());
                    }
                    return;
                } finally {
                }
            } while (!this.xt.m());
        }
    }

    private boolean vl() {
        Iterator<jy> it = this.tl.iterator();
        while (it.hasNext()) {
            if (!it.next().ae()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long w() {
        if (this.f38946m || this.ae) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                xt(currentTimeMillis);
                long qv = this.xt.qv();
                if (qv > 0) {
                    long j6 = this.ch;
                    if (j6 > 0 && currentTimeMillis - j6 > qv && j(currentTimeMillis, qv)) {
                        this.ch = currentTimeMillis;
                        this.f38939a++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 2000L;
    }

    private boolean ws() {
        long j6 = this.jy;
        if (j6 <= 0) {
            this.f38951w = false;
            return false;
        }
        synchronized (this) {
            try {
                long j7 = az.j(this.az);
                com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(j7)));
                if (j7 >= j6) {
                    this.f38951w = true;
                    return true;
                }
                this.f38951w = false;
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void xt(List<g> list) {
        long ka = this.f38944j.ka();
        this.jy = ka;
        if (ka <= 0) {
            this.jy = this.f38944j.wq();
            com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.jy);
        }
        synchronized (this) {
            try {
                this.ws.clear();
                if (list != null && !list.isEmpty()) {
                    Iterator<g> it = list.iterator();
                    while (it.hasNext()) {
                        j((List<g>) this.ws, new g(it.next()), false);
                    }
                    r(this.ws);
                    cw(this.ws);
                    com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "initSegments: totalLength = " + this.jy);
                }
                j((List<g>) this.ws, new g(0L, -1L), false);
                com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "initSegments: totalLength = " + this.jy);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public qv(@NonNull com.ss.android.socialbase.downloader.ae.cw cwVar, @NonNull ws wsVar, com.ss.android.socialbase.downloader.ws.m mVar) {
        this.f38944j = cwVar;
        this.xt = wsVar;
        xt xtVar = new xt(wsVar.r(), wsVar.up());
        this.cw = xtVar;
        this.f38948r = mVar;
        this.up = new ae(cwVar, mVar, xtVar);
        this.tj = new com.ss.android.socialbase.downloader.ws.up();
        this.kt = new com.ss.android.socialbase.downloader.az.up();
        this.f38945l = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).xt("debug") == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        if (r6.f38946m == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean j(java.util.List<com.ss.android.socialbase.downloader.qv.g> r7) throws com.ss.android.socialbase.downloader.up.j, java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.String r0 = "finally pause"
            java.lang.String r1 = "SegmentDispatcher"
            r6.m()     // Catch: java.lang.Throwable -> L54
            r6.xt(r7)     // Catch: java.lang.Throwable -> L54
            r6.up()     // Catch: java.lang.Throwable -> L54
            r6.ae()     // Catch: java.lang.Throwable -> L54
            r6.g()     // Catch: java.lang.Throwable -> L54
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L54
            r6.cw()     // Catch: java.lang.Throwable -> L5f
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L54
            long r4 = r4 - r2
            com.ss.android.socialbase.downloader.ae.cw r7 = r6.f38944j     // Catch: java.lang.Throwable -> L54
            r7.xt(r4)     // Catch: java.lang.Throwable -> L54
            com.ss.android.socialbase.downloader.ae.cw r7 = r6.f38944j     // Catch: java.lang.Throwable -> L54
            r7.j(r4)     // Catch: java.lang.Throwable -> L54
            boolean r7 = r6.ae     // Catch: java.lang.Throwable -> L54
            r2 = 1
            if (r7 != 0) goto L56
            boolean r7 = r6.f38946m     // Catch: java.lang.Throwable -> L54
            if (r7 == 0) goto L33
            goto L56
        L33:
            com.ss.android.socialbase.downloader.ws.m r7 = r6.f38948r     // Catch: java.lang.Throwable -> L54
            long r3 = r6.jy     // Catch: java.lang.Throwable -> L54
            r7.j(r3)     // Catch: java.lang.Throwable -> L54
            r6.tl()     // Catch: java.lang.Throwable -> L54
            r6.r()     // Catch: java.lang.Throwable -> L54
            boolean r7 = r6.ae
            if (r7 != 0) goto L4e
            boolean r7 = r6.f38946m
            if (r7 != 0) goto L4e
        L48:
            com.ss.android.socialbase.downloader.m.j.cw(r1, r0)
            r6.xt()
        L4e:
            com.ss.android.socialbase.downloader.ws.up r7 = r6.tj
            r7.xt()
            return r2
        L54:
            r7 = move-exception
            goto L70
        L56:
            boolean r7 = r6.ae
            if (r7 != 0) goto L4e
            boolean r7 = r6.f38946m
            if (r7 != 0) goto L4e
            goto L48
        L5f:
            r7 = move-exception
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L54
            long r4 = r4 - r2
            com.ss.android.socialbase.downloader.ae.cw r2 = r6.f38944j     // Catch: java.lang.Throwable -> L54
            r2.xt(r4)     // Catch: java.lang.Throwable -> L54
            com.ss.android.socialbase.downloader.ae.cw r2 = r6.f38944j     // Catch: java.lang.Throwable -> L54
            r2.j(r4)     // Catch: java.lang.Throwable -> L54
            throw r7     // Catch: java.lang.Throwable -> L54
        L70:
            boolean r2 = r6.ae
            if (r2 != 0) goto L7e
            boolean r2 = r6.f38946m
            if (r2 != 0) goto L7e
            com.ss.android.socialbase.downloader.m.j.cw(r1, r0)
            r6.xt()
        L7e:
            com.ss.android.socialbase.downloader.ws.up r0 = r6.tj
            r0.xt()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.qv.qv.j(java.util.List):boolean");
    }

    private void cw(List<g> list) {
        long xt = az.xt(list);
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f38944j.uq() + ", totalBytes = " + this.f38944j.ka() + ", downloadedBytes = " + xt);
        if (xt > this.f38944j.ka() && this.f38944j.ka() > 0) {
            xt = this.f38944j.ka();
        }
        if (this.f38944j.uq() == this.f38944j.ka() || this.f38944j.uq() == xt) {
            return;
        }
        this.f38944j.up(xt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
    
        if ((r19.up() - r23.up()) < (r13 / 2)) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void up(com.ss.android.socialbase.downloader.qv.jy r22, com.ss.android.socialbase.downloader.qv.g r23) throws com.ss.android.socialbase.downloader.qv.oq {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.qv.qv.up(com.ss.android.socialbase.downloader.qv.jy, com.ss.android.socialbase.downloader.qv.g):void");
    }

    private void xt(String str, List<i> list) {
        int j6;
        if (this.f38945l) {
            Iterator<i> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int vl = this.xt.vl();
        if ((vl == 1 || vl == 3) && (j6 = j(str)) >= 0 && j6 < this.f38941g.size()) {
            this.f38941g.addAll(j6 + 1, list);
        } else {
            this.f38941g.addAll(list);
        }
    }

    private List<i> cw(String str, List<InetAddress> list) {
        boolean z5;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i6 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.f38945l) {
                            com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        i iVar = new i(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(iVar.cw);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(iVar.cw, linkedList);
                        }
                        linkedList.add(iVar);
                        i6++;
                    }
                }
            }
            if (i6 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z5 = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((i) linkedList2.pollFirst());
                            i6--;
                            z5 = true;
                        }
                    }
                    if (i6 <= 0) {
                        break;
                    }
                } while (z5);
                return arrayList;
            }
        }
        return null;
    }

    private void r(List<g> list) {
        g gVar = list.get(0);
        long cw = gVar.cw();
        if (cw > 0) {
            g gVar2 = new g(0L, cw - 1);
            com.bytedance.sdk.component.utils.vl.xt("SegmentDispatcher", "fixSegmentsLocked: first = " + gVar + ", add new first = " + gVar2);
            j(list, gVar2, true);
        }
        Iterator<g> it = list.iterator();
        if (it.hasNext()) {
            g next = it.next();
            while (it.hasNext()) {
                g next2 = it.next();
                if (next.m() < next2.cw() - 1) {
                    com.ss.android.socialbase.downloader.m.j.r("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.cw() - 1));
                    next.cw(next2.cw() - 1);
                }
                next = next2;
            }
        }
        g gVar3 = list.get(list.size() - 1);
        long ka = this.f38944j.ka();
        if (ka <= 0 || (gVar3.m() != -1 && gVar3.m() < ka - 1)) {
            com.ss.android.socialbase.downloader.m.j.r("SegmentDispatcher", "fixSegment: last segment = " + gVar3 + ", new end=-1");
            gVar3.cw(-1L);
        }
    }

    private g xt(jy jyVar, i iVar) {
        while (!this.ws.isEmpty()) {
            g poll = this.ws.poll();
            if (poll != null) {
                j(this.az, poll, true);
                if (j(poll) > 0 || this.jy <= 0) {
                    return poll;
                }
            }
        }
        jy();
        g cw = cw(jyVar, iVar);
        if (cw != null && j(cw) > 0) {
            j(this.az, cw, true);
            return cw;
        }
        g av = av();
        if (av != null) {
            return av;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.g.cw.j
    public void j(String str, List<InetAddress> list) {
        List<i> list2;
        if (this.ae || this.f38946m) {
            return;
        }
        try {
            list2 = cw(str, list);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            list2 = null;
        }
        synchronized (this) {
            if (list2 != null) {
                try {
                    xt(str, list2);
                } finally {
                }
            }
            this.vl = false;
            this.xt.j(this.f38941g.size());
            com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            up();
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void xt(jy jyVar, g gVar) throws com.ss.android.socialbase.downloader.up.j {
        synchronized (this) {
            up(jyVar, gVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void xt(jy jyVar) {
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "onReaderExit: threadIndex = " + jyVar.cw);
        synchronized (this) {
            try {
                jyVar.cw(true);
                this.tl.remove(jyVar);
                jy();
                if (!this.tl.isEmpty()) {
                    if (ws()) {
                        com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                        Iterator<jy> it = this.tl.iterator();
                        while (it.hasNext()) {
                            it.next().up();
                        }
                    }
                }
                qv();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void cw(jy jyVar, g gVar) {
        synchronized (this) {
            try {
                if (gVar.f38914j == jyVar) {
                    com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(gVar)));
                    gVar.r(jyVar.r());
                    gVar.f38914j = null;
                    jyVar.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int j(String str) {
        int size = this.f38941g.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (TextUtils.equals(this.f38941g.get(i6).f38918j, str)) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public up r(jy jyVar, g gVar) throws com.ss.android.socialbase.downloader.up.j {
        up j6;
        synchronized (this) {
            vl vlVar = new vl(this.f38944j, this.cw, gVar);
            this.up.j(vlVar);
            j6 = vlVar.j();
        }
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(jy jyVar) {
        synchronized (this) {
            try {
                i r5 = r(jyVar);
                if (r5 == null) {
                    return false;
                }
                return jyVar.j(r5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(List<g> list, g gVar, boolean z5) {
        long cw = gVar.cw();
        int size = list.size();
        int i6 = 0;
        while (i6 < size && cw >= list.get(i6).cw()) {
            i6++;
        }
        list.add(i6, gVar);
        if (z5) {
            gVar.j(size);
        }
    }

    private i r(jy jyVar) {
        i iVar;
        Iterator<i> it = this.f38941g.iterator();
        i iVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            iVar = it.next();
            if (iVar != jyVar.xt && !iVar.r()) {
                if (iVar2 == null) {
                    iVar2 = iVar;
                }
                if (iVar.j() <= 0) {
                    break;
                }
            }
        }
        if (this.xt.xt()) {
            if (iVar != null) {
                return iVar;
            }
            if (this.xt.cw()) {
                return null;
            }
        }
        return iVar2;
    }

    private void xt(jy jyVar, g gVar, i iVar, com.ss.android.socialbase.downloader.ae.m mVar) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        jy jyVar2 = gVar.f38914j;
        if (jyVar2 != null && jyVar2 != jyVar) {
            throw new oq(1, "segment already has an owner");
        }
        if (jyVar.tl() == gVar.up()) {
            if (!mVar.xt()) {
                if (gVar.up() <= 0) {
                    com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + gVar.up());
                    if (!mVar.j()) {
                        throw new com.ss.android.socialbase.downloader.up.cw(1004, mVar.cw, "2: response code error : " + mVar.cw + " segment=" + gVar);
                    }
                } else {
                    throw new com.ss.android.socialbase.downloader.up.cw(1004, mVar.cw, "1: response code error : " + mVar.cw + " segment=" + gVar);
                }
            }
            if (iVar.f38920r) {
                if (this.oq == null) {
                    this.oq = mVar;
                    synchronized (this.mi) {
                        this.mi.notify();
                    }
                    com.ss.android.socialbase.downloader.ws.m mVar2 = this.f38948r;
                    if (mVar2 != null) {
                        mVar2.j(iVar.f38918j, mVar.xt, gVar.up());
                    }
                    long oq = mVar.oq();
                    if (oq > 0) {
                        for (g gVar2 : this.az) {
                            if (gVar2.m() <= 0 || gVar2.m() > oq - 1) {
                                gVar2.cw(oq - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j(mVar);
            if (this.qv == null) {
                this.qv = mVar;
                if (this.f38944j.ka() <= 0) {
                    long oq2 = mVar.oq();
                    com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "checkSegmentHttpResponse:len=" + oq2 + ",url=" + iVar.f38918j);
                    this.f38944j.ae(oq2);
                }
                synchronized (this.mi) {
                    this.mi.notify();
                }
                return;
            }
            return;
        }
        throw new oq(5, "applySegment");
    }

    private g cw(jy jyVar, i iVar) {
        String str;
        int size = this.az.size();
        long j6 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < size; i7++) {
            long j7 = j(i7, size);
            if (j7 > j6) {
                i6 = i7;
                j6 = j7;
            }
        }
        long ae = this.xt.ae();
        long g6 = this.xt.g();
        if (i6 < 0 || j6 <= ae) {
            return null;
        }
        g gVar = this.az.get(i6);
        int ws = this.az.size() < this.tl.size() ? 2 : this.xt.ws();
        if (ws == 1) {
            jy jyVar2 = gVar.f38914j;
            if (jyVar2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j8 = currentTimeMillis - d.f50003r;
                long j9 = jyVar2.j(j8, currentTimeMillis);
                long j10 = jyVar.j(j8, currentTimeMillis);
                float f6 = (j9 <= 0 || j10 <= 0) ? -1.0f : j10 / (j9 + j10);
                if (f6 == -1.0f) {
                    long xt = jyVar2.xt();
                    long xt2 = jyVar.xt();
                    if (xt > 0 && xt2 > 0) {
                        f6 = xt2 / (xt + xt2);
                    }
                }
                if (f6 > 0.0f) {
                    float f7 = f6 * 0.9f;
                    long j11 = (long) (j6 * f7);
                    if (j11 < ae) {
                        j11 = ae;
                    }
                    long j12 = (g6 <= 0 || j11 <= g6) ? j11 : g6;
                    long j13 = ae / 2;
                    long j14 = j6 - j13;
                    if (j12 > j14) {
                        j12 = j14;
                    } else if (j12 < j13) {
                        j12 = j13;
                    }
                    g gVar2 = new g(gVar.up() + (j6 - j12), gVar.m());
                    com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "obtainSegment: parent = " + gVar + ", child = " + gVar2 + ", maxRemainBytes = " + j6 + ", childLength = " + j12 + ", ratio = " + f7 + ", threadIndex = " + jyVar.cw);
                    return gVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            str = "SegmentDispatcher";
            if (ws == 2) {
                long uq = this.jy - this.f38944j.uq();
                float r5 = r(jyVar, iVar);
                long j15 = (long) (uq * r5);
                if (j15 < ae) {
                    j15 = ae;
                }
                if (g6 > 0 && j15 > g6) {
                    j15 = g6;
                }
                long j16 = ae / 2;
                long j17 = j6 - j16;
                if (j15 > j17) {
                    j15 = j17;
                } else if (j15 < j16) {
                    j15 = j16;
                }
                g gVar3 = new g(gVar.up() + (j6 - j15), gVar.m());
                com.ss.android.socialbase.downloader.m.j.cw(str, "obtainSegment: parent = " + gVar + ", child = " + gVar3 + ", maxRemainBytes = " + j6 + ", childLength = " + j15 + ", ratio = " + r5 + ", threadIndex = " + jyVar.cw);
                return gVar3;
            }
        }
        g gVar4 = new g(gVar.up() + (j6 / 2), gVar.m());
        com.ss.android.socialbase.downloader.m.j.cw(str, "obtainSegment: parent = " + gVar + ",child = " + gVar4);
        return gVar4;
    }

    private void j(i iVar) {
        jy jyVar = new jy(this.f38944j, this, this.cw, iVar, this.tl.size());
        this.tl.add(jyVar);
        jyVar.j(com.ss.android.socialbase.downloader.downloader.cw.av().submit(jyVar));
    }

    private float r(jy jyVar, i iVar) {
        long xt = jyVar.xt();
        int size = this.tl.size();
        if (size <= 1) {
            size = this.xt.j();
        }
        float f6 = 1.0f;
        if (xt <= 0) {
            float jy = this.xt.jy();
            if (jy <= 0.0f || jy >= 1.0f) {
                jy = 1.0f / size;
            }
            if (jyVar.cw == 0) {
                return jy;
            }
            if (size > 1) {
                f6 = 1.0f - jy;
                size--;
            }
        } else {
            long az = az();
            if (az > xt) {
                return xt / az;
            }
        }
        return f6 / size;
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void j(jy jyVar) {
        if (this.f38945l) {
            com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "onReaderRun, threadIndex = " + jyVar.cw);
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public g j(jy jyVar, i iVar) {
        if (this.f38946m || this.ae) {
            return null;
        }
        synchronized (this) {
            try {
                g xt = xt(jyVar, iVar);
                if (xt != null) {
                    xt.tl();
                    if (xt.oq() > 1) {
                        return new g(xt);
                    }
                }
                return xt;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void j(jy jyVar, g gVar) {
        synchronized (this) {
            gVar.g();
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void j(jy jyVar, g gVar, i iVar, com.ss.android.socialbase.downloader.ae.m mVar) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        synchronized (this) {
            try {
                if (!this.f38946m && !this.ae) {
                    xt(jyVar, gVar, iVar, mVar);
                    jyVar.xt(false);
                    if (this.jy <= 0) {
                        long ka = this.f38944j.ka();
                        this.jy = ka;
                        if (ka <= 0) {
                            this.jy = mVar.oq();
                        }
                        up();
                    } else if (this.xt.m()) {
                        up();
                    }
                } else {
                    throw new av("connected");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void j(jy jyVar, i iVar, g gVar, com.ss.android.socialbase.downloader.up.j jVar, int i6, int i7) {
        boolean xt = com.ss.android.socialbase.downloader.az.m.xt(jVar);
        int j6 = jVar.j();
        if (j6 == 1047 || j6 == 1074 || j6 == 1055) {
            xt = true;
        }
        if (xt || i6 >= i7) {
            cw(jyVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.m
    public void j(jy jyVar, i iVar, g gVar, com.ss.android.socialbase.downloader.up.j jVar) {
        synchronized (this) {
            try {
                com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", "onSegmentFailed: segment = " + gVar + ", e = " + jVar);
                jyVar.xt(true);
                if (jyVar.cw == 0) {
                    this.f38943i = jVar;
                }
                if (vl()) {
                    if (this.f38943i == null) {
                        this.f38943i = jVar;
                    }
                    this.f38940f = true;
                    j(this.f38943i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xt() {
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "pause1");
        this.ae = true;
        synchronized (this) {
            try {
                Iterator<jy> it = this.tl.iterator();
                while (it.hasNext()) {
                    it.next().up();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.up.xt();
        this.cw.cw();
    }

    private void xt(long j6) {
        this.kt.j(this.f38944j.uq(), j6);
        Iterator<jy> it = this.tl.iterator();
        while (it.hasNext()) {
            it.next().xt(j6);
        }
    }

    private void j(com.ss.android.socialbase.downloader.up.j jVar) {
        com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", "onError, e = ".concat(String.valueOf(jVar)));
        this.f38943i = jVar;
        this.cw.cw();
        synchronized (this) {
            try {
                Iterator<jy> it = this.tl.iterator();
                while (it.hasNext()) {
                    it.next().up();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(com.ss.android.socialbase.downloader.ae.m mVar) throws com.ss.android.socialbase.downloader.up.j {
        com.ss.android.socialbase.downloader.ae.m mVar2 = this.oq;
        if (mVar2 == null && (mVar2 = this.qv) == null) {
            return;
        }
        long oq = mVar.oq();
        long oq2 = mVar2.oq();
        if (oq != oq2) {
            String str = "total len not equals,len=" + oq + ",sLen=" + oq2 + ",code=" + mVar.cw + ",sCode=" + mVar2.cw + ",range=" + mVar.up() + ",sRange = " + mVar2.up() + ",url = " + mVar.f38619j + ",sUrl=" + mVar2.f38619j;
            com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", str);
            if (oq > 0 && oq2 > 0) {
                throw new com.ss.android.socialbase.downloader.up.j(1074, str);
            }
        }
        String cw = mVar.cw();
        String cw2 = mVar2.cw();
        if (TextUtils.equals(cw, cw2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + cw + ", mainEtag = " + cw2;
        com.ss.android.socialbase.downloader.m.j.up("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(cw) && !TextUtils.isEmpty(cw2) && !cw.equalsIgnoreCase(cw2)) {
            throw new com.ss.android.socialbase.downloader.up.j(1074, str2);
        }
    }

    public void j() {
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", CommonNetImpl.CANCEL);
        this.f38946m = true;
        synchronized (this) {
            try {
                Iterator<jy> it = this.tl.iterator();
                while (it.hasNext()) {
                    it.next().up();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.up.j();
        this.cw.cw();
    }

    private int j(long j6) {
        int size = this.az.size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.az.get(i6);
            if (gVar.cw() == j6) {
                return i6;
            }
            if (gVar.cw() > j6) {
                return -1;
            }
        }
        return -1;
    }

    private long j(int i6, int i7) {
        g gVar = this.az.get(i6);
        long j6 = j(gVar);
        int i8 = i6 + 1;
        g gVar2 = i8 < i7 ? this.az.get(i8) : null;
        if (gVar2 == null) {
            return j6;
        }
        long cw = gVar2.cw() - gVar.up();
        return j6 == -1 ? cw : Math.min(j6, cw);
    }

    private long j(g gVar) {
        long xt = gVar.xt();
        if (xt == -1) {
            long j6 = this.jy;
            if (j6 > 0) {
                return j6 - gVar.up();
            }
        }
        return xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public jy j(boolean z5, long j6, long j7) {
        jy jyVar = null;
        for (jy jyVar2 : this.tl) {
            if (jyVar2.cw != 0 || z5) {
                if (jyVar2.f38933r > 0 && jyVar2.up <= 0 && j6 - jyVar2.f38933r > j7 && (jyVar == null || jyVar2.f38933r < jyVar.f38933r)) {
                    jyVar = jyVar2;
                }
            }
        }
        return jyVar;
    }

    private boolean j(jy jyVar, long j6, long j7, long j8, double d6) {
        if (jyVar.f38931m <= 0) {
            return false;
        }
        long xt = this.kt.xt(j6, j7);
        int size = this.tl.size();
        long j9 = size > 0 ? xt / size : xt;
        long j10 = jyVar.j(j6, j7);
        if (j10 >= j8 && j10 >= j9 * d6) {
            return false;
        }
        com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + xt + ", threadAvgSpeed = " + j9 + ", poorSpeed = " + j8 + ", speed = " + j10 + ",threadIndex = " + jyVar.cw);
        return true;
    }

    private boolean j(long j6, long j7) {
        long j8 = j6 - j7;
        long xt = this.kt.xt(j8, j6);
        int size = this.tl.size();
        if (size > 0) {
            xt /= size;
        }
        jy j9 = j(j8, j6, (long) Math.max(10.0f, xt * this.f38949s), size / 2);
        if (j9 != null) {
            cw(j9);
            com.ss.android.socialbase.downloader.m.j.r("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + j9.cw);
            j9.m();
            return true;
        }
        jy j10 = j(true, j6, j7);
        if (j10 == null) {
            return false;
        }
        cw(j10);
        com.ss.android.socialbase.downloader.m.j.r("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + j10.cw);
        j10.m();
        return true;
    }

    private jy j(long j6, long j7, long j8, int i6) {
        long j9 = Long.MAX_VALUE;
        int i7 = 0;
        jy jyVar = null;
        for (jy jyVar2 : this.tl) {
            if (jyVar2.f38931m > 0) {
                int i8 = i7 + 1;
                if (jyVar2.f38931m < j6) {
                    long j10 = jyVar2.j(j6, j7);
                    if (this.f38945l) {
                        com.bytedance.sdk.component.utils.vl.j("SegmentDispatcher", "findPoorReadThread: speed = " + j10 + ", threadIndex = " + jyVar2.cw);
                    }
                    if (j10 >= 0 && j10 < j9) {
                        j9 = j10;
                        jyVar = jyVar2;
                    }
                }
                i7 = i8;
            }
        }
        if (jyVar == null || i7 < i6 || j9 >= j8) {
            return null;
        }
        com.ss.android.socialbase.downloader.m.j.cw("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j9 + ", threadIndex = " + jyVar.cw);
        return jyVar;
    }
}
