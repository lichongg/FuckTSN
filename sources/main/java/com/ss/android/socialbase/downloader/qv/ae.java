package com.ss.android.socialbase.downloader.qv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
class ae {
    private final cw ae;
    private final boolean av;
    private final long az;
    private final com.ss.android.socialbase.downloader.ae.cw cw;

    /* renamed from: i, reason: collision with root package name */
    private long f38909i;
    private final boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ws.m f38911m;
    private com.ss.android.socialbase.downloader.up.j tl;
    private final com.ss.android.socialbase.downloader.jy.j up;
    private final long ws;

    /* renamed from: j, reason: collision with root package name */
    private final List<vl> f38910j = new LinkedList();
    private final List<vl> xt = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f38908g = false;
    private volatile boolean oq = false;
    private volatile boolean qv = false;

    /* renamed from: w, reason: collision with root package name */
    private volatile long f38913w = 0;
    private volatile long mi = 0;

    /* renamed from: r, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.vl f38912r = com.ss.android.socialbase.downloader.downloader.cw.x();
    private final com.ss.android.socialbase.downloader.j.j vl = com.ss.android.socialbase.downloader.j.j.j();

    private void cw() throws IOException {
        boolean z5;
        boolean z6 = this.av;
        long nanoTime = z6 ? System.nanoTime() : 0L;
        com.ss.android.socialbase.downloader.ae.cw cwVar = this.cw;
        com.ss.android.socialbase.downloader.downloader.vl vlVar = this.f38912r;
        List<vl> list = this.f38910j;
        List<vl> list2 = this.xt;
        Map<Long, g> vl = vlVar.vl(cwVar.ae());
        if (vl == null) {
            vl = new HashMap<>(4);
        }
        synchronized (this) {
            try {
                j(list);
                try {
                    xt(list);
                    z5 = true;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                    z5 = false;
                }
                j(list, vl);
                if (list2.size() > 0) {
                    cw(list2);
                    list.removeAll(list2);
                    list2.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z5) {
            cwVar.ae(true);
            vlVar.j(cwVar.ae(), vl);
            vlVar.j(cwVar);
            this.f38913w = cwVar.uq();
        }
        if (z6) {
            this.f38909i += System.nanoTime() - nanoTime;
        }
    }

    private boolean j(long j6, long j7) {
        return j6 > 65536 && j7 > 500;
    }

    private void xt(List<vl> list) throws IOException {
        Iterator<vl> it = list.iterator();
        while (it.hasNext()) {
            it.next().cw();
        }
    }

    void j(vl vlVar) {
        synchronized (this) {
            this.f38910j.add(vlVar);
        }
    }

    ae(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.ws.m mVar, cw cwVar2) {
        boolean z5;
        this.cw = cwVar;
        this.f38911m = mVar;
        this.ae = cwVar2;
        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
        this.up = j6;
        if (j6.j("sync_strategy", 0) == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.jy = z5;
        if (z5) {
            long j7 = j6.j("sync_interval_ms_fg", 5000);
            long j8 = j6.j("sync_interval_ms_bg", 1000);
            this.ws = Math.max(j7, 500L);
            this.az = Math.max(j8, 500L);
        } else {
            this.ws = 0L;
            this.az = 0L;
        }
        this.av = j6.xt("monitor_rw") == 1;
    }

    public void xt() {
        this.oq = true;
        this.f38908g = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:312:0x00bf, code lost:
    
        if (r2 <= 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x00c2, code lost:
    
        r3.xt(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03c0 A[Catch: all -> 0x02b4, TryCatch #9 {all -> 0x02b4, blocks: (B:178:0x02b1, B:179:0x02b3, B:68:0x0333, B:70:0x033d, B:72:0x0341, B:115:0x03ba, B:117:0x03c0, B:118:0x03c3, B:119:0x03d4, B:133:0x0230), top: B:6:0x0024, inners: #32 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0209 A[Catch: all -> 0x02a8, TryCatch #2 {all -> 0x02a8, blocks: (B:125:0x0205, B:127:0x0209, B:129:0x0211, B:131:0x0221, B:133:0x0230), top: B:124:0x0205 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0405 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x033d A[Catch: all -> 0x02b4, TryCatch #9 {all -> 0x02b4, blocks: (B:178:0x02b1, B:179:0x02b3, B:68:0x0333, B:70:0x033d, B:72:0x0341, B:115:0x03ba, B:117:0x03c0, B:118:0x03c3, B:119:0x03d4, B:133:0x0230), top: B:6:0x0024, inners: #32 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0369 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.socialbase.downloader.ae.cw] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void j(com.ss.android.socialbase.downloader.qv.r r29) throws com.ss.android.socialbase.downloader.up.j {
        /*
            Method dump skipped, instructions count: 1108
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.qv.ae.j(com.ss.android.socialbase.downloader.qv.r):void");
    }

    private void cw(List<vl> list) {
        Iterator<vl> it = list.iterator();
        while (it.hasNext()) {
            it.next().r();
        }
    }

    private void j(long j6, boolean z5) throws IOException {
        long j7 = j6 - this.mi;
        if (this.jy) {
            if (j7 <= (this.vl.xt() ? this.ws : this.az)) {
                return;
            }
        } else {
            long uq = this.cw.uq() - this.f38913w;
            if (!z5 && !j(uq, j7)) {
                return;
            }
        }
        cw();
        this.mi = j6;
    }

    private void j(up upVar) {
        synchronized (this) {
            this.xt.add((vl) upVar);
        }
    }

    private void j(List<vl> list) throws IOException {
        Iterator<vl> it = list.iterator();
        while (it.hasNext()) {
            it.next().xt();
        }
    }

    private void j(List<vl> list, Map<Long, g> map) {
        Iterator<vl> it = list.iterator();
        while (it.hasNext()) {
            g up = it.next().up();
            g gVar = map.get(Long.valueOf(up.cw()));
            if (gVar == null) {
                map.put(Long.valueOf(up.cw()), new g(up));
            } else {
                gVar.j(up.r());
                gVar.cw(up.m());
            }
        }
    }

    public void j() {
        this.qv = true;
        this.f38908g = true;
    }
}
