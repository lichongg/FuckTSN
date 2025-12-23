package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.downloader.tj;
import com.ss.android.socialbase.downloader.ws.tl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import master.flame.danmaku.danmaku.model.android.d;

/* loaded from: D:\Downloads\app\classes6.dex */
public class r implements com.ss.android.socialbase.downloader.downloader.vl {
    private volatile boolean cw;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.ws.tl f38856m;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f38857r;
    private tj xt;
    private tl.j up = new tl.j() { // from class: com.ss.android.socialbase.downloader.impls.r.1
        @Override // com.ss.android.socialbase.downloader.ws.tl.j
        public void j(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            r.this.g();
                        } catch (Exception e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                });
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private final qv f38855j = new qv();

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        synchronized (this) {
            this.cw = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw ae(int i6) {
        com.ss.android.socialbase.downloader.ae.cw ae = this.f38855j.ae(i6);
        cw(ae);
        return ae;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        return this.f38855j.cw(str);
    }

    public void g() {
        List<String> list;
        ArrayList arrayList;
        com.ss.android.socialbase.downloader.ae.cw cwVar;
        com.ss.android.socialbase.downloader.ae.cw cwVar2;
        if (this.cw) {
            if (this.f38857r) {
                com.ss.android.socialbase.downloader.m.j.xt("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f38857r = true;
            if (com.ss.android.socialbase.downloader.az.m.j()) {
                com.ss.android.socialbase.downloader.downloader.ws v5 = com.ss.android.socialbase.downloader.downloader.cw.v();
                if (v5 != null) {
                    list = v5.j();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    try {
                        SparseArray<com.ss.android.socialbase.downloader.ae.cw> j6 = this.f38855j.j();
                        for (int i6 = 0; i6 < j6.size(); i6++) {
                            int keyAt = j6.keyAt(i6);
                            if (keyAt != 0 && (cwVar2 = j6.get(keyAt)) != null) {
                                sparseArray.put(keyAt, cwVar2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                    int keyAt2 = sparseArray.keyAt(i7);
                    if (keyAt2 != 0 && (cwVar = (com.ss.android.socialbase.downloader.ae.cw) sparseArray.get(keyAt2)) != null) {
                        int v6 = cwVar.v();
                        int cb = cwVar.cb();
                        if (cb > 0 && cb <= 11) {
                            com.ss.android.socialbase.downloader.tl.j.j(com.ss.android.socialbase.downloader.downloader.cw.m(), cwVar, (com.ss.android.socialbase.downloader.up.j) null, -5);
                        }
                        if (list != null && arrayList != null && cwVar.xw() != null && list.contains(cwVar.xw()) && (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).xt("enable_notification_ui") >= 2 || v6 != -2 || cwVar.qb())) {
                            cwVar.up(false);
                            arrayList.add(cwVar);
                        }
                    }
                }
                if (v5 == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                v5.j(arrayList, 1);
            }
        }
    }

    public tj m() {
        return this.xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean r() {
        return this.cw;
    }

    public void tl() {
        this.f38856m.sendMessageDelayed(this.f38856m.obtainMessage(1), com.ss.android.socialbase.downloader.jy.j.cw().j("task_resume_delay") ? d.f50003r : Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean up() {
        if (this.cw) {
            return true;
        }
        synchronized (this) {
            if (!this.cw) {
                com.ss.android.socialbase.downloader.m.j.r("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
                com.ss.android.socialbase.downloader.m.j.r("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.cw;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.xt> cw(int i6) {
        return this.f38855j.cw(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void jy(int i6) {
        this.f38855j.jy(i6);
        this.xt.jy(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean m(int i6) {
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.av(i6);
            } else {
                this.xt.m(i6);
            }
        } else {
            this.xt.m(i6);
        }
        return this.f38855j.m(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        return this.f38855j.r(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public Map<Long, com.ss.android.socialbase.downloader.qv.g> vl(int i6) {
        Map<Long, com.ss.android.socialbase.downloader.qv.g> vl = this.f38855j.vl(i6);
        if (vl != null && !vl.isEmpty()) {
            return vl;
        }
        Map<Long, com.ss.android.socialbase.downloader.qv.g> vl2 = this.xt.vl(i6);
        this.f38855j.j(i6, vl2);
        return vl2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.qv.g> ws(int i6) {
        List<com.ss.android.socialbase.downloader.qv.g> ws = this.f38855j.ws(i6);
        return (ws == null || ws.size() == 0) ? this.xt.ws(i6) : ws;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6) {
        return this.f38855j.xt(i6);
    }

    public r() {
        this.f38856m = null;
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_sigbus_downloader_db")) {
            if (!com.ss.android.socialbase.downloader.az.m.j() && com.ss.android.socialbase.downloader.downloader.cw.hl()) {
                this.xt = com.ss.android.socialbase.downloader.downloader.cw.b().j(new cw.j.InterfaceC0780j() { // from class: com.ss.android.socialbase.downloader.impls.r.2
                    @Override // com.ss.android.socialbase.downloader.downloader.cw.j.InterfaceC0780j
                    public void j() {
                        r.this.xt = new com.ss.android.socialbase.downloader.cw.up();
                        com.bytedance.sdk.component.utils.vl.r("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.xt = new com.ss.android.socialbase.downloader.cw.up();
            }
        } else {
            this.xt = new com.ss.android.socialbase.downloader.cw.up();
        }
        this.cw = false;
        this.f38856m = new com.ss.android.socialbase.downloader.ws.tl(Looper.getMainLooper(), this.up);
        ae();
    }

    public void ae() {
        List<com.ss.android.socialbase.downloader.ae.xt> list;
        com.ss.android.socialbase.downloader.ae.cw cwVar;
        com.ss.android.socialbase.downloader.downloader.cw.j(com.ss.android.socialbase.downloader.xt.r.SYNC_START);
        final SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> sparseArray2 = new SparseArray<>();
        synchronized (this.f38855j) {
            try {
                SparseArray<com.ss.android.socialbase.downloader.ae.cw> j6 = this.f38855j.j();
                for (int i6 = 0; i6 < j6.size(); i6++) {
                    int keyAt = j6.keyAt(i6);
                    if (keyAt != 0 && (cwVar = j6.get(keyAt)) != null) {
                        sparseArray.put(keyAt, cwVar);
                    }
                }
                SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> m6 = this.f38855j.m();
                for (int i7 = 0; i7 < m6.size(); i7++) {
                    int keyAt2 = m6.keyAt(i7);
                    if (keyAt2 != 0 && (list = m6.get(keyAt2)) != null) {
                        sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.xt.j(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.cw.r() { // from class: com.ss.android.socialbase.downloader.impls.r.3
            @Override // com.ss.android.socialbase.downloader.cw.r
            public void j() {
                synchronized (r.this.f38855j) {
                    try {
                        SparseArray<com.ss.android.socialbase.downloader.ae.cw> j7 = r.this.f38855j.j();
                        if (sparseArray != null) {
                            for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                                int keyAt3 = sparseArray.keyAt(i8);
                                if (keyAt3 != 0) {
                                    j7.put(keyAt3, (com.ss.android.socialbase.downloader.ae.cw) sparseArray.get(keyAt3));
                                }
                            }
                        }
                        SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> m7 = r.this.f38855j.m();
                        if (sparseArray2 != null) {
                            for (int i9 = 0; i9 < sparseArray2.size(); i9++) {
                                int keyAt4 = sparseArray2.keyAt(i9);
                                if (keyAt4 != 0) {
                                    m7.put(keyAt4, (List) sparseArray2.get(keyAt4));
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                r.this.oq();
                r.this.tl();
                com.ss.android.socialbase.downloader.downloader.cw.j(com.ss.android.socialbase.downloader.xt.r.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void cw() {
        try {
            this.f38855j.cw();
        } catch (SQLiteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.m();
                return;
            } else {
                this.xt.cw();
                return;
            }
        }
        this.xt.cw();
    }

    public qv j() {
        return this.f38855j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void r(int i6) {
        this.f38855j.r(i6);
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.az(i6);
                return;
            } else {
                this.xt.r(i6);
                return;
            }
        }
        this.xt.r(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        return this.f38855j.xt(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        return this.f38855j.j(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> xt() {
        return this.f38855j.xt();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        synchronized (this.f38855j) {
            this.f38855j.j(xtVar);
        }
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.j(xtVar);
                return;
            } else {
                this.xt.j(xtVar);
                return;
            }
        }
        this.xt.j(xtVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw oq(int i6) {
        com.ss.android.socialbase.downloader.ae.cw oq = this.f38855j.oq(i6);
        cw(oq);
        return oq;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        com.ss.android.socialbase.downloader.ae.cw tl = this.f38855j.tl(i6);
        cw(tl);
        return tl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.j(xtVar);
                return;
            } else {
                this.xt.j(xtVar);
                return;
            }
        }
        this.xt.j(xtVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw r(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw r5 = this.f38855j.r(i6, j6);
        xt(i6, (List<com.ss.android.socialbase.downloader.ae.xt>) null);
        return r5;
    }

    private void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        j(cwVar, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw xt = this.f38855j.xt(i6, j6);
        xt(i6, (List<com.ss.android.socialbase.downloader.ae.xt>) null);
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw cw(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw cw = this.f38855j.cw(i6, j6);
        xt(i6, (List<com.ss.android.socialbase.downloader.ae.xt>) null);
        return cw;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean up(int i6) {
        try {
            if (com.ss.android.socialbase.downloader.az.m.xt()) {
                com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
                if (j6 != null) {
                    j6.ws(i6);
                } else {
                    this.xt.up(i6);
                }
            } else {
                this.xt.up(i6);
            }
        } catch (SQLiteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return this.f38855j.up(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.f38855j.j(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        try {
            j(this.f38855j.xt(i6));
            if (list == null) {
                list = this.f38855j.cw(i6);
            }
            if (com.ss.android.socialbase.downloader.az.m.xt()) {
                com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
                if (j6 != null) {
                    j6.xt(i6, list);
                    return;
                } else {
                    this.xt.xt(i6, list);
                    return;
                }
            }
            this.xt.xt(i6, list);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, long j6) {
        this.f38855j.j(i6, i7, j6);
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j7 = vl.j(true);
            if (j7 != null) {
                j7.j(i6, i7, j6);
                return;
            } else {
                this.xt.j(i6, i7, j6);
                return;
            }
        }
        this.xt.j(i6, i7, j6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, int i8, long j6) {
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j7 = vl.j(true);
            if (j7 != null) {
                j7.j(i6, i7, i8, j6);
                return;
            } else {
                this.xt.j(i6, i7, i8, j6);
                return;
            }
        }
        this.xt.j(i6, i7, i8, j6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, int i8, int i9) {
        if (com.ss.android.socialbase.downloader.az.m.xt()) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.j(i6, i7, i8, i9);
                return;
            } else {
                this.xt.j(i6, i7, i8, i9);
                return;
            }
        }
        this.xt.j(i6, i7, i8, i9);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, int i7) {
        com.ss.android.socialbase.downloader.ae.cw j6 = this.f38855j.j(i6, i7);
        cw(j6);
        return j6;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return false;
        }
        boolean j6 = this.f38855j.j(cwVar);
        cw(cwVar);
        return j6;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6, String str, String str2) {
        com.ss.android.socialbase.downloader.ae.cw j7 = this.f38855j.j(i6, j6, str, str2);
        cw(j7);
        return j7;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw g(int i6) {
        com.ss.android.socialbase.downloader.ae.cw g6 = this.f38855j.g(i6);
        cw(g6);
        return g6;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw j7 = this.f38855j.j(i6, j6);
        j(j7, false);
        return j7;
    }

    private void j(com.ss.android.socialbase.downloader.ae.cw cwVar, boolean z5) {
        if (cwVar == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.az.m.xt()) {
            this.xt.j(cwVar);
            return;
        }
        if (z5) {
            com.ss.android.socialbase.downloader.downloader.az j6 = vl.j(true);
            if (j6 != null) {
                j6.cw(cwVar);
            } else {
                this.xt.j(cwVar);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f38855j.j(i6, list);
        if (com.ss.android.socialbase.downloader.az.m.cw()) {
            this.xt.xt(i6, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean j(int i6, Map<Long, com.ss.android.socialbase.downloader.qv.g> map) {
        this.f38855j.j(i6, map);
        this.xt.j(i6, map);
        return false;
    }
}
