package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.mi;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.h;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.socialbase.downloader.r.wq;
import com.ss.android.socialbase.downloader.ws.tl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class j implements tl.j {
    private final SparseArray<com.ss.android.socialbase.downloader.ae.r> xt = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.ae.r> cw = new SparseArray<>();

    /* renamed from: r, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.ae.r> f38844r = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.ae.r> up = new SparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.ae.r> f38843m = new SparseArray<>();
    private final SparseArray<SparseArray<com.ss.android.socialbase.downloader.ae.r>> ae = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.az.tl<Integer, com.ss.android.socialbase.downloader.ae.r> tl = new com.ss.android.socialbase.downloader.az.tl<>();

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray<Long> f38841g = new SparseArray<>();
    private final LinkedBlockingDeque<com.ss.android.socialbase.downloader.ae.r> oq = new LinkedBlockingDeque<>();

    /* renamed from: j, reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.ws.tl f38842j = new com.ss.android.socialbase.downloader.ws.tl(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.vl qv = com.ss.android.socialbase.downloader.downloader.cw.x();

    private void cw(com.ss.android.socialbase.downloader.ae.r rVar) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        if (rVar == null || (j6 = rVar.j()) == null) {
            return;
        }
        try {
            if (this.oq.isEmpty()) {
                j(rVar, true);
                this.oq.put(rVar);
                return;
            }
            if (j6.w() != com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_TAIL) {
                com.ss.android.socialbase.downloader.ae.r first = this.oq.getFirst();
                if (first.i() == rVar.i() && j(rVar.i())) {
                    return;
                }
                up(first.i());
                j(rVar, true);
                if (first.i() != rVar.i()) {
                    this.oq.putFirst(rVar);
                    return;
                }
                return;
            }
            if (this.oq.getFirst().i() == rVar.i() && j(rVar.i())) {
                return;
            }
            Iterator<com.ss.android.socialbase.downloader.ae.r> it = this.oq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.ss.android.socialbase.downloader.ae.r next = it.next();
                if (next != null && next.i() == rVar.i()) {
                    it.remove();
                    break;
                }
            }
            this.oq.put(rVar);
            new com.ss.android.socialbase.downloader.downloader.m(rVar, this.f38842j).j();
        } catch (InterruptedException unused) {
        }
    }

    public synchronized boolean ae(int i6) {
        try {
            com.ss.android.socialbase.downloader.ae.r rVar = this.f38844r.get(i6);
            if (rVar == null) {
                rVar = this.up.get(i6);
            }
            if (rVar == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
            if (j6 != null) {
                j6.up(false);
            }
            j(rVar);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    protected abstract com.ss.android.socialbase.downloader.ws.cw cw(int i6);

    public synchronized h g(int i6) {
        com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
        if (rVar != null) {
            return rVar.oq();
        }
        com.ss.android.socialbase.downloader.ae.r rVar2 = this.cw.get(i6);
        if (rVar2 != null) {
            return rVar2.oq();
        }
        com.ss.android.socialbase.downloader.ae.r rVar3 = this.f38844r.get(i6);
        if (rVar3 != null) {
            return rVar3.oq();
        }
        com.ss.android.socialbase.downloader.ae.r rVar4 = this.up.get(i6);
        if (rVar4 != null) {
            return rVar4.oq();
        }
        com.ss.android.socialbase.downloader.ae.r rVar5 = this.f38843m.get(i6);
        if (rVar5 == null) {
            return null;
        }
        return rVar5.oq();
    }

    protected abstract List<Integer> j();

    public abstract void j(int i6, long j6);

    protected abstract void j(int i6, com.ss.android.socialbase.downloader.ae.r rVar);

    public abstract void j(com.ss.android.socialbase.downloader.ws.cw cwVar);

    public abstract boolean j(int i6);

    public synchronized void jy(int i6) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
        if (rVar != null && (j6 = rVar.j()) != null) {
            j6.vl(true);
            j(rVar);
        }
    }

    public synchronized boolean m(int i6) {
        try {
            com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
            if (rVar != null) {
                com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
                if (j6 != null) {
                    j6.up(false);
                }
                j(rVar);
            } else {
                ae(i6);
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    public synchronized tj oq(int i6) {
        com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
        if (rVar != null) {
            return rVar.ws();
        }
        com.ss.android.socialbase.downloader.ae.r rVar2 = this.cw.get(i6);
        if (rVar2 != null) {
            return rVar2.ws();
        }
        com.ss.android.socialbase.downloader.ae.r rVar3 = this.f38844r.get(i6);
        if (rVar3 != null) {
            return rVar3.ws();
        }
        com.ss.android.socialbase.downloader.ae.r rVar4 = this.up.get(i6);
        if (rVar4 != null) {
            return rVar4.ws();
        }
        com.ss.android.socialbase.downloader.ae.r rVar5 = this.f38843m.get(i6);
        if (rVar5 == null) {
            return null;
        }
        return rVar5.ws();
    }

    public synchronized boolean qv(int i6) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        com.ss.android.socialbase.downloader.ae.r rVar = this.up.get(i6);
        if (rVar != null && (j6 = rVar.j()) != null) {
            if (j6.o()) {
                j(rVar, false);
            }
            return true;
        }
        com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
        if (xt != null && xt.o()) {
            j(new com.ss.android.socialbase.downloader.ae.r(xt), false);
        }
        return false;
    }

    public synchronized com.ss.android.socialbase.downloader.ae.cw r(int i6) {
        com.ss.android.socialbase.downloader.ae.cw xt;
        com.ss.android.socialbase.downloader.ae.r rVar;
        xt = this.qv.xt(i6);
        if (xt == null && (rVar = this.xt.get(i6)) != null) {
            xt = rVar.j();
        }
        return xt;
    }

    public synchronized wq tl(int i6) {
        com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
        if (rVar != null) {
            return rVar.qv();
        }
        com.ss.android.socialbase.downloader.ae.r rVar2 = this.cw.get(i6);
        if (rVar2 != null) {
            return rVar2.qv();
        }
        com.ss.android.socialbase.downloader.ae.r rVar3 = this.f38844r.get(i6);
        if (rVar3 != null) {
            return rVar3.qv();
        }
        com.ss.android.socialbase.downloader.ae.r rVar4 = this.up.get(i6);
        if (rVar4 != null) {
            return rVar4.qv();
        }
        com.ss.android.socialbase.downloader.ae.r rVar5 = this.f38843m.get(i6);
        if (rVar5 == null) {
            return null;
        }
        return rVar5.qv();
    }

    public synchronized boolean up(int i6) {
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "pause id=".concat(String.valueOf(i6)));
        com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
        if (xt != null && xt.i() == 11) {
            return false;
        }
        synchronized (this.xt) {
            xt(i6);
        }
        if (xt == null) {
            com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
            if (rVar != null) {
                new com.ss.android.socialbase.downloader.downloader.m(rVar, this.f38842j).r();
                return true;
            }
        } else {
            j(xt);
            if (xt.i() == 1) {
                com.ss.android.socialbase.downloader.ae.r rVar2 = this.xt.get(i6);
                if (rVar2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.m(rVar2, this.f38842j).r();
                    return true;
                }
            } else if (com.ss.android.socialbase.downloader.xt.m.xt(xt.i())) {
                xt.r(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean vl(int i6) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        com.ss.android.socialbase.downloader.ae.r rVar = this.f38843m.get(i6);
        if (rVar == null || (j6 = rVar.j()) == null) {
            return false;
        }
        if (j6.el()) {
            j(rVar);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r1.f38844r.get(r2) != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean ws(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L1b
            android.util.SparseArray<com.ss.android.socialbase.downloader.ae.r> r0 = r1.xt     // Catch: java.lang.Throwable -> L14
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L16
            android.util.SparseArray<com.ss.android.socialbase.downloader.ae.r> r0 = r1.f38844r     // Catch: java.lang.Throwable -> L14
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L1b
            goto L16
        L14:
            r2 = move-exception
            goto L19
        L16:
            monitor-exit(r1)
            r2 = 1
            return r2
        L19:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L14
            throw r2
        L1b:
            monitor-exit(r1)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.j.ws(int):boolean");
    }

    protected abstract void xt(int i6);

    private void av(int i6) {
        com.ss.android.socialbase.downloader.ae.r first;
        if (this.oq.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.ae.r first2 = this.oq.getFirst();
        if (first2 != null && first2.i() == i6) {
            this.oq.poll();
        }
        if (this.oq.isEmpty() || (first = this.oq.getFirst()) == null) {
            return;
        }
        j(first, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.ae.r az(int i6) {
        com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
        return (rVar == null && (rVar = this.f38844r.get(i6)) == null && (rVar = this.cw.get(i6)) == null && (rVar = this.up.get(i6)) == null) ? this.f38843m.get(i6) : rVar;
    }

    private void xt(com.ss.android.socialbase.downloader.ae.r rVar) {
        int vl = rVar.vl();
        if (vl == 0 && rVar.jy()) {
            vl = rVar.mi();
        }
        if (vl == 0) {
            return;
        }
        SparseArray<com.ss.android.socialbase.downloader.ae.r> sparseArray = this.ae.get(rVar.i());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.ae.put(rVar.i(), sparseArray);
        }
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + rVar.i() + " listener hasCode:" + vl);
        sparseArray.put(vl, rVar);
    }

    protected j() {
    }

    private void j(com.ss.android.socialbase.downloader.ae.r rVar, boolean z5) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        int i6;
        com.ss.android.socialbase.downloader.ae.cw j7;
        com.ss.android.socialbase.downloader.ae.r remove;
        if (rVar == null || (j6 = rVar.j()) == null) {
            return;
        }
        if (j6.yu()) {
            com.ss.android.socialbase.downloader.tl.j.j(rVar.up(), j6, new com.ss.android.socialbase.downloader.up.j(1003, "downloadInfo is Invalid, url is " + j6.oq() + " name is " + j6.tl() + " savePath is " + j6.qv()), j6.i());
            return;
        }
        boolean z6 = false;
        if (com.ss.android.socialbase.downloader.jy.j.j(j6.ae()).j("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.az.m.cw(com.ss.android.socialbase.downloader.downloader.cw.nd()) && !j6.fz()) {
            new com.ss.android.socialbase.downloader.downloader.m(rVar, this.f38842j).j(new com.ss.android.socialbase.downloader.up.j(1049, "network_not_available"));
            return;
        }
        int ae = j6.ae();
        if (z5) {
            j(j6);
        }
        if (this.f38844r.get(ae) != null) {
            this.f38844r.remove(ae);
        }
        if (this.cw.get(ae) != null) {
            this.cw.remove(ae);
        }
        if (this.up.get(ae) != null) {
            this.up.remove(ae);
        }
        if (this.f38843m.get(ae) != null) {
            this.f38843m.remove(ae);
        }
        if (j(ae) && !j6.el()) {
            com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            rVar.w();
            com.ss.android.socialbase.downloader.tl.j.j(rVar.up(), j6, new com.ss.android.socialbase.downloader.up.j(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), j6.i());
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(ae)));
        if (j6.el()) {
            j6.j(com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.az.j.j(32768) && (remove = this.tl.remove(Integer.valueOf(ae))) != null) {
            rVar.j(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        com.ss.android.socialbase.downloader.ae.r rVar2 = this.xt.get(ae);
        if (rVar2 == null || (j7 = rVar2.j()) == null) {
            i6 = 0;
        } else {
            i6 = j7.i();
            if (com.ss.android.socialbase.downloader.xt.m.xt(i6)) {
                z6 = true;
            }
        }
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "can add listener " + z6 + " , oldTaskStatus is :" + i6);
        if (z6) {
            rVar.w();
            return;
        }
        xt(rVar);
        this.xt.put(ae, rVar);
        this.f38841g.put(ae, Long.valueOf(uptimeMillis));
        j(ae, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i6, boolean z5) {
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i6 + " deleteTargetFile=" + z5);
        try {
            com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
            if (xt != null) {
                if (z5) {
                    com.ss.android.socialbase.downloader.az.m.j(xt);
                } else {
                    com.ss.android.socialbase.downloader.az.m.cw(xt.vl(), xt.jy());
                }
                xt.ot();
            }
            try {
                this.qv.m(i6);
            } catch (SQLiteException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            j(i6, 0, -4);
            if (this.f38844r.get(i6) != null) {
                this.f38844r.remove(i6);
            }
            if (this.cw.get(i6) != null) {
                this.cw.remove(i6);
            }
            this.tl.remove(Integer.valueOf(i6));
            com.ss.android.socialbase.downloader.jy.j.xt(i6);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public synchronized void xt(List<String> list) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        try {
            if (com.ss.android.socialbase.downloader.az.m.xt(com.ss.android.socialbase.downloader.downloader.cw.nd())) {
                for (int i6 = 0; i6 < this.xt.size(); i6++) {
                    com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(this.xt.keyAt(i6));
                    if (rVar != null && (j6 = rVar.j()) != null && j6.xw() != null && list.contains(j6.xw()) && xt(j6)) {
                        j6.xt(true);
                        j6.cw(true);
                        j(rVar);
                        j6.up(true);
                        mi xt = com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).xt();
                        if (xt != null) {
                            xt.j(j6, 5, 2);
                        }
                    }
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void cw(final int i6, final boolean z5) {
        com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
        if (xt != null) {
            j(xt);
        }
        this.f38842j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.j.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.xt.j().m(i6);
            }
        });
        com.ss.android.socialbase.downloader.downloader.cw.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.j.5
            @Override // java.lang.Runnable
            public void run() {
                j.this.cw(i6);
                j.this.up(i6, z5);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(int i6, boolean z5) {
        try {
            com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
            if (xt != null) {
                com.ss.android.socialbase.downloader.az.m.j(xt, z5);
                xt.ot();
            }
            try {
                this.qv.r(i6);
                this.qv.j(xt);
            } catch (SQLiteException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            if (this.f38844r.get(i6) != null) {
                this.f38844r.remove(i6);
            }
            if (this.cw.get(i6) != null) {
                this.cw.remove(i6);
            }
            this.tl.remove(Integer.valueOf(i6));
            com.ss.android.socialbase.downloader.jy.j.xt(i6);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar != null && cwVar.sm()) {
            return cwVar.qb();
        }
        return false;
    }

    public void xt() {
        List<Integer> j6 = j();
        if (j6 == null) {
            return;
        }
        Iterator<Integer> it = j6.iterator();
        while (it.hasNext()) {
            up(it.next().intValue());
        }
    }

    public void xt(final int i6, final boolean z5) {
        com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
        if (xt != null) {
            j(xt);
        }
        this.f38842j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.j.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.xt.j().m(i6);
            }
        });
        com.ss.android.socialbase.downloader.downloader.cw.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.j.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.ae.r az;
                if (j.this.cw(i6) == null && (az = j.this.az(i6)) != null) {
                    com.ss.android.socialbase.downloader.ae.cw j6 = az.j();
                    SparseArray<a> j7 = az.j(com.ss.android.socialbase.downloader.xt.tl.SUB);
                    if (j7 != null) {
                        synchronized (j7) {
                            for (int i7 = 0; i7 < j7.size(); i7++) {
                                try {
                                    a aVar = j7.get(j7.keyAt(i7));
                                    if (aVar != null) {
                                        aVar.m(j6);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                j.this.r(i6, z5);
            }
        }, false);
    }

    public synchronized void xt(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        j(i6, i7, aVar, tlVar, z5, true);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = j().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            com.ss.android.socialbase.downloader.ae.cw r5 = r(it.next().intValue());
            if (r5 != null && str.equals(r5.xw())) {
                arrayList.add(r5);
            }
        }
        return arrayList;
    }

    public synchronized void j(com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
        if (j6 == null) {
            return;
        }
        j6.up(false);
        if (j6.w() != com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE) {
            cw(rVar);
        } else {
            j(rVar, true);
        }
    }

    public void xt(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
        if (xt != null) {
            xt.qv(j6);
        }
        j(i6, j6);
    }

    public synchronized List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.ae.cw> j6 = this.qv.j(str);
        if (j6 != null && !j6.isEmpty()) {
            return j6;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.xt.size();
        for (int i6 = 0; i6 < size; i6++) {
            com.ss.android.socialbase.downloader.ae.r valueAt = this.xt.valueAt(i6);
            if (valueAt != null && valueAt.j() != null && str.equals(valueAt.j().oq())) {
                arrayList.add(valueAt.j());
            }
        }
        return arrayList;
    }

    public synchronized boolean j(int i6, boolean z5) {
        try {
            com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
            if (rVar == null && com.ss.android.socialbase.downloader.az.j.j(65536)) {
                rVar = az(i6);
            }
            if (rVar != null) {
                if (!com.ss.android.socialbase.downloader.jy.j.j(i6).xt("fix_on_cancel_call_twice", true)) {
                    new com.ss.android.socialbase.downloader.downloader.m(rVar, this.f38842j).cw();
                }
                final com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
                final SparseArray<a> j7 = rVar.j(com.ss.android.socialbase.downloader.xt.tl.MAIN);
                final SparseArray<a> j8 = rVar.j(com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION);
                this.f38842j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray sparseArray;
                        SparseArray sparseArray2 = j7;
                        if (sparseArray2 != null) {
                            synchronized (sparseArray2) {
                                for (int i7 = 0; i7 < j7.size(); i7++) {
                                    try {
                                        a aVar = (a) j7.get(j7.keyAt(i7));
                                        if (aVar != null) {
                                            aVar.m(j6);
                                        }
                                    } finally {
                                    }
                                }
                            }
                        }
                        com.ss.android.socialbase.downloader.ae.cw cwVar = j6;
                        if (cwVar == null || !cwVar.oy() || (sparseArray = j8) == null) {
                            return;
                        }
                        synchronized (sparseArray) {
                            for (int i8 = 0; i8 < j8.size(); i8++) {
                                try {
                                    a aVar2 = (a) j8.get(j8.keyAt(i8));
                                    if (aVar2 != null) {
                                        aVar2.m(j6);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                });
            }
            com.ss.android.socialbase.downloader.ae.cw xt = this.qv.xt(i6);
            if (com.ss.android.socialbase.downloader.az.j.j(65536)) {
                if (xt != null) {
                    xt.r(-4);
                }
            } else if (xt != null && com.ss.android.socialbase.downloader.xt.m.xt(xt.i())) {
                xt.r(-4);
            }
            xt(i6, z5);
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    private void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar != null) {
            try {
                if (cwVar.i() != 7 && cwVar.rs() == com.ss.android.socialbase.downloader.xt.g.DELAY_RETRY_NONE) {
                    return;
                }
                cwVar.r(5);
                cwVar.j(com.ss.android.socialbase.downloader.xt.g.DELAY_RETRY_NONE);
                com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "cancelAlarm");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    public synchronized void j(int i6, h hVar) {
        com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
        if (rVar != null) {
            rVar.xt(hVar);
        }
    }

    public synchronized void j(List<String> list) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        try {
            try {
                boolean xt = com.ss.android.socialbase.downloader.az.j.j(1048576) ? com.ss.android.socialbase.downloader.az.m.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()) : true;
                for (int i6 = 0; i6 < this.f38844r.size(); i6++) {
                    com.ss.android.socialbase.downloader.ae.r rVar = this.f38844r.get(this.f38844r.keyAt(i6));
                    if (rVar != null && (j6 = rVar.j()) != null && j6.xw() != null && list.contains(j6.xw()) && (!j6.x() || xt)) {
                        j6.xt(true);
                        j6.cw(true);
                        j(rVar);
                    }
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        try {
            com.ss.android.socialbase.downloader.ae.r az = az(i6);
            if (az == null) {
                az = this.tl.get(Integer.valueOf(i6));
            }
            if (az != null) {
                az.j(i7, aVar, tlVar, z5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(int i6, int i7, final a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5, boolean z6) {
        com.ss.android.socialbase.downloader.ae.cw xt;
        try {
            com.ss.android.socialbase.downloader.ae.r az = az(i6);
            if (az != null) {
                az.xt(i7, aVar, tlVar, z5);
                final com.ss.android.socialbase.downloader.ae.cw j6 = az.j();
                if (z6) {
                    if (j6 != null) {
                        if (!j(i6)) {
                            if (tlVar != com.ss.android.socialbase.downloader.xt.tl.MAIN) {
                                if (tlVar == com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION) {
                                }
                            }
                            if (tlVar != com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION || j6.oy()) {
                                this.f38842j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.j.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aVar != null) {
                                            if (j6.i() == -3) {
                                                aVar.up(j6);
                                            } else if (j6.i() == -1) {
                                                aVar.j(j6, new com.ss.android.socialbase.downloader.up.j(1000, "try add listener for failed task"));
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
                return;
            }
            if (com.ss.android.socialbase.downloader.az.j.j(32768) && (xt = this.qv.xt(i6)) != null && xt.i() != -3) {
                com.ss.android.socialbase.downloader.ae.r rVar = this.tl.get(Integer.valueOf(i6));
                if (rVar == null) {
                    rVar = new com.ss.android.socialbase.downloader.ae.r(xt);
                    this.tl.put(Integer.valueOf(i6), rVar);
                }
                rVar.xt(i7, aVar, tlVar, z5);
            }
        } finally {
        }
    }

    private void j(int i6, com.ss.android.socialbase.downloader.up.j jVar, com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar != null) {
            com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
            SparseArray<a> j7 = rVar.j(com.ss.android.socialbase.downloader.xt.tl.MAIN);
            SparseArray<a> j8 = rVar.j(com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION);
            boolean z5 = rVar.az() || j6.qe();
            com.ss.android.socialbase.downloader.az.cw.j(i6, j7, true, j6, jVar);
            com.ss.android.socialbase.downloader.az.cw.j(i6, j8, z5, j6, jVar);
        }
    }

    private void j(int i6, int i7) {
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "removeTask id: " + i6 + " listener hasCode: " + i7);
        if (i7 == 0) {
            this.xt.remove(i6);
            this.ae.remove(i6);
            return;
        }
        SparseArray<com.ss.android.socialbase.downloader.ae.r> sparseArray = this.ae.get(i6);
        if (sparseArray != null) {
            sparseArray.remove(i7);
            com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.xt.remove(i6);
                this.ae.remove(i6);
                return;
            }
            return;
        }
        this.xt.remove(i6);
    }

    public synchronized void j(int i6, int i7, int i8) {
        try {
            if (i8 != -7) {
                if (i8 != -6) {
                    if (i8 == -4) {
                        j(i6, i7);
                    } else if (i8 == -3) {
                        this.cw.put(i6, this.xt.get(i6));
                        j(i6, i7);
                    } else if (i8 != -1) {
                        if (i8 != 7) {
                            if (i8 == 8) {
                                com.ss.android.socialbase.downloader.ae.r rVar = this.xt.get(i6);
                                if (rVar != null && this.f38843m.get(i6) == null) {
                                    this.f38843m.put(i6, rVar);
                                }
                            }
                            return;
                        }
                        com.ss.android.socialbase.downloader.ae.r rVar2 = this.xt.get(i6);
                        if (rVar2 != null) {
                            if (this.up.get(i6) == null) {
                                this.up.put(i6, rVar2);
                            }
                            j(i6, i7);
                        }
                        av(i6);
                        return;
                    }
                    av(i6);
                    return;
                }
                this.cw.put(i6, this.xt.get(i6));
                j(i6, i7);
                return;
            }
            com.ss.android.socialbase.downloader.ae.r rVar3 = this.xt.get(i6);
            if (rVar3 != null) {
                if (this.f38844r.get(i6) == null) {
                    this.f38844r.put(i6, rVar3);
                }
                j(i6, i7);
            }
            av(i6);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ss.android.socialbase.downloader.ws.tl.j
    public void j(Message message) {
        int i6 = message.arg1;
        int i7 = message.arg2;
        com.ss.android.socialbase.downloader.m.j.xt("AbsDownloadEngine", "handleMsg id: " + i6 + " listener hasCode: " + i7);
        Object obj = message.obj;
        com.ss.android.socialbase.downloader.ae.r rVar = null;
        com.ss.android.socialbase.downloader.up.j jVar = obj instanceof Exception ? (com.ss.android.socialbase.downloader.up.j) obj : null;
        synchronized (this) {
            try {
                if (i7 == 0) {
                    rVar = this.xt.get(i6);
                } else {
                    SparseArray<com.ss.android.socialbase.downloader.ae.r> sparseArray = this.ae.get(i6);
                    if (sparseArray != null) {
                        rVar = sparseArray.get(i7);
                    }
                }
                if (rVar == null) {
                    return;
                }
                j(message.what, jVar, rVar);
                j(i6, i7, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
