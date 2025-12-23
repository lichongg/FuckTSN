package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.h;
import com.ss.android.socialbase.downloader.r.wq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r f38765j;
    private volatile SparseArray<Boolean> xt = new SparseArray<>();
    private Handler cw = new Handler(Looper.getMainLooper());

    /* renamed from: r, reason: collision with root package name */
    private volatile List<Object> f38766r = new ArrayList();

    public static r j() {
        if (f38765j == null) {
            synchronized (r.class) {
                f38765j = new r();
            }
        }
        return f38765j;
    }

    public az cw(int i6) {
        return com.ss.android.socialbase.downloader.impls.vl.j(j(i6) == 1 && !com.ss.android.socialbase.downloader.az.m.cw());
    }

    public void r(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        cw.j(i6);
    }

    public void xt() {
        synchronized (this.f38766r) {
            try {
                Iterator<Object> it = this.f38766r.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void cw(int i6, boolean z5) {
        if (!com.ss.android.socialbase.downloader.az.m.j()) {
            az cw = cw(i6);
            if (cw != null) {
                cw.j(i6, z5);
            }
            com.ss.android.socialbase.downloader.impls.vl.j(true).j(2, i6);
            return;
        }
        if (com.ss.android.socialbase.downloader.az.j.j(8388608)) {
            az j6 = com.ss.android.socialbase.downloader.impls.vl.j(true);
            if (j6 != null) {
                j6.j(i6, z5);
            }
            az j7 = com.ss.android.socialbase.downloader.impls.vl.j(false);
            if (j7 != null) {
                j7.j(i6, z5);
                return;
            }
            return;
        }
        az j8 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        if (j8 != null) {
            j8.j(i6, z5);
        }
        az j9 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        if (j9 != null) {
            j9.j(i6, z5);
        }
    }

    public void ws(int i6) {
        if (i6 == 0) {
            return;
        }
        xt(i6, true);
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        if (j6 == null) {
            return;
        }
        j6.startService();
    }

    public void ae(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        cw.r(i6);
    }

    public com.ss.android.socialbase.downloader.r.tj az(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return null;
        }
        return cw.mi(i6);
    }

    public boolean g(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return false;
        }
        return cw.ae(i6);
    }

    public boolean jy(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return false;
        }
        return cw.vl(i6);
    }

    public void m(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        cw.cw(i6);
    }

    public com.ss.android.socialbase.downloader.ae.cw oq(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return null;
        }
        return cw.tl(i6);
    }

    public h qv(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return null;
        }
        return cw.i(i6);
    }

    public void r(int i6, boolean z5) {
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        cw.xt(i6, z5);
    }

    public int tl(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return 0;
        }
        return cw.m(i6);
    }

    public boolean up(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return false;
        }
        return cw.xt(i6);
    }

    public wq vl(int i6) {
        az cw = cw(i6);
        if (cw == null) {
            return null;
        }
        return cw.w(i6);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray = new SparseArray<>();
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        List<com.ss.android.socialbase.downloader.ae.cw> up = j6 != null ? j6.up(str) : null;
        az j7 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        return j(up, j7 != null ? j7.up(str) : null, sparseArray);
    }

    public void j(int i6, boolean z5) {
        xt(i6, z5);
        if (cw.hl() && !com.ss.android.socialbase.downloader.az.m.cw() && com.ss.android.socialbase.downloader.impls.vl.j(true).ae()) {
            com.ss.android.socialbase.downloader.impls.vl.j(true).cw(i6, z5);
        }
        if (cw.xt() || com.ss.android.socialbase.downloader.az.m.cw() || com.ss.android.socialbase.downloader.az.m.j()) {
            return;
        }
        try {
            Intent intent = new Intent(cw.nd(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i6);
            cw.nd().startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public synchronized void xt(int i6, boolean z5) {
        try {
            this.xt.put(i6, z5 ? Boolean.TRUE : Boolean.FALSE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int xt(int i6) {
        if (this.xt.get(i6) == null) {
            return -1;
        }
        return this.xt.get(i6).booleanValue() ? 1 : 0;
    }

    private az xt(com.ss.android.socialbase.downloader.ae.r rVar) {
        com.ss.android.socialbase.downloader.ae.cw j6;
        List<com.ss.android.socialbase.downloader.ae.xt> g6;
        if (rVar == null || (j6 = rVar.j()) == null) {
            return null;
        }
        boolean xp = j6.xp();
        if (com.ss.android.socialbase.downloader.az.m.cw() || !com.ss.android.socialbase.downloader.az.m.j()) {
            xp = true;
        }
        int j7 = j(j6.ae());
        if (j7 >= 0 && j7 != xp) {
            try {
                if (j7 == 1) {
                    if (com.ss.android.socialbase.downloader.az.m.j()) {
                        com.ss.android.socialbase.downloader.impls.vl.j(true).j(j6.ae());
                        com.ss.android.socialbase.downloader.ae.cw tl = com.ss.android.socialbase.downloader.impls.vl.j(true).tl(j6.ae());
                        if (tl != null) {
                            com.ss.android.socialbase.downloader.impls.vl.j(false).xt(tl);
                        }
                        if (tl.kj() > 1 && (g6 = com.ss.android.socialbase.downloader.impls.vl.j(true).g(j6.ae())) != null) {
                            com.ss.android.socialbase.downloader.impls.vl.j(false).j(j6.ae(), com.ss.android.socialbase.downloader.az.m.j(g6));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.az.m.j()) {
                    com.ss.android.socialbase.downloader.impls.vl.j(false).j(j6.ae());
                    List<com.ss.android.socialbase.downloader.ae.xt> g7 = com.ss.android.socialbase.downloader.impls.vl.j(false).g(j6.ae());
                    if (g7 != null) {
                        com.ss.android.socialbase.downloader.impls.vl.j(true).j(j6.ae(), com.ss.android.socialbase.downloader.az.m.j(g7));
                    }
                } else {
                    rVar.j(true);
                    com.ss.android.socialbase.downloader.impls.vl.j(true).j(1, j6.ae());
                }
            } catch (Throwable unused) {
            }
        }
        j(j6.ae(), xp);
        return com.ss.android.socialbase.downloader.impls.vl.j(xp);
    }

    public void cw() {
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        if (j6 != null) {
            j6.j();
        }
        az j7 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        if (j7 != null) {
            j7.j();
        }
    }

    public int j(int i6) {
        if (!cw.hl()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.az.m.cw() && com.ss.android.socialbase.downloader.impls.vl.j(true).ae()) {
            return com.ss.android.socialbase.downloader.impls.vl.j(true).jy(i6);
        }
        return xt(i6);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray = new SparseArray<>();
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        List<com.ss.android.socialbase.downloader.ae.cw> r5 = j6 != null ? j6.r(str) : null;
        az j7 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        return j(r5, j7 != null ? j7.r(str) : null, sparseArray);
    }

    public int j(String str, String str2) {
        return cw.j(str, str2);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        List<com.ss.android.socialbase.downloader.ae.cw> j6 = com.ss.android.socialbase.downloader.impls.vl.j(false).j(str);
        List<com.ss.android.socialbase.downloader.ae.cw> j7 = com.ss.android.socialbase.downloader.impls.vl.j(true).j(str);
        if (j6 == null && j7 == null) {
            return null;
        }
        if (j6 == null || j7 == null) {
            return j6 != null ? j6 : j7;
        }
        ArrayList arrayList = new ArrayList(j6);
        arrayList.addAll(j7);
        return arrayList;
    }

    private List<com.ss.android.socialbase.downloader.ae.cw> j(List<com.ss.android.socialbase.downloader.ae.cw> list, List<com.ss.android.socialbase.downloader.ae.cw> list2, SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.ss.android.socialbase.downloader.ae.cw cwVar : list) {
                if (cwVar != null && sparseArray.get(cwVar.ae()) == null) {
                    sparseArray.put(cwVar.ae(), cwVar);
                }
            }
        }
        if (list2 != null) {
            for (com.ss.android.socialbase.downloader.ae.cw cwVar2 : list2) {
                if (cwVar2 != null && sparseArray.get(cwVar2.ae()) == null) {
                    sparseArray.put(cwVar2.ae(), cwVar2);
                }
            }
        }
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i6)));
        }
        return arrayList;
    }

    public com.ss.android.socialbase.downloader.ae.cw xt(String str, String str2) {
        int j6 = j(str, str2);
        az cw = cw(j6);
        if (cw == null) {
            return null;
        }
        return cw.tl(j6);
    }

    public void j(List<String> list) {
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        if (j6 != null) {
            j6.j(list);
        }
        az j7 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        if (j7 != null) {
            j7.j(list);
        }
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray = new SparseArray<>();
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        List<com.ss.android.socialbase.downloader.ae.cw> cw = j6 != null ? j6.cw(str) : null;
        az j7 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        return j(cw, j7 != null ? j7.cw(str) : null, sparseArray);
    }

    public void j(int i6, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        int hashCode;
        a aVar2;
        com.ss.android.socialbase.downloader.xt.tl tlVar2;
        boolean z6;
        int i7;
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        if (aVar == null) {
            hashCode = 0;
            i7 = i6;
            aVar2 = aVar;
            tlVar2 = tlVar;
            z6 = z5;
        } else {
            hashCode = aVar.hashCode();
            aVar2 = aVar;
            tlVar2 = tlVar;
            z6 = z5;
            i7 = i6;
        }
        cw.xt(i7, hashCode, aVar2, tlVar2, z6);
    }

    public void j(int i6, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5, boolean z6) {
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        cw.j(i6, aVar.hashCode(), aVar, tlVar, z5, z6);
    }

    public void xt(List<String> list) {
        az j6 = com.ss.android.socialbase.downloader.impls.vl.j(false);
        if (j6 != null) {
            j6.xt(list);
        }
        az j7 = com.ss.android.socialbase.downloader.impls.vl.j(true);
        if (j7 != null) {
            j7.xt(list);
        }
    }

    public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        az cw;
        if (cwVar == null || (cw = cw(cwVar.ae())) == null) {
            return false;
        }
        return cw.j(cwVar);
    }

    public void j(final com.ss.android.socialbase.downloader.ae.r rVar) {
        final az xt = xt(rVar);
        if (xt == null) {
            if (rVar != null) {
                com.ss.android.socialbase.downloader.tl.j.j(rVar.up(), rVar.j(), new com.ss.android.socialbase.downloader.up.j(1003, "tryDownload but getDownloadHandler failed"), rVar.j() != null ? rVar.j().i() : 0);
            }
        } else if (rVar.xt()) {
            this.cw.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.r.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.j(rVar);
                }
            }, 500L);
        } else {
            xt.j(rVar);
        }
    }

    public void xt(int i6, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        az cw = cw(i6);
        if (cw == null) {
            return;
        }
        cw.j(i6, aVar.hashCode(), aVar, tlVar, z5);
    }

    public void j(com.ss.android.socialbase.downloader.r.vl vlVar) {
        cw.j(vlVar);
    }
}
