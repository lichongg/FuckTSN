package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class qv implements com.ss.android.socialbase.downloader.downloader.vl {

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.ae.cw> f38854j = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> xt = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.qv.g>> cw = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f38854j.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.f38854j.size(); i6++) {
            com.ss.android.socialbase.downloader.ae.cw cwVar = this.f38854j.get(this.f38854j.keyAt(i6));
            if (cwVar != null && !TextUtils.isEmpty(cwVar.xw()) && cwVar.xw().equals(str) && cwVar.i() == -3) {
                arrayList.add(cwVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, int i8, int i9) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized void jy(int i6) {
        this.cw.remove(i6);
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> m() {
        return this.xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean r() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean up() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized Map<Long, com.ss.android.socialbase.downloader.qv.g> vl(int i6) {
        return this.cw.get(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.qv.g> ws(int i6) {
        Map<Long, com.ss.android.socialbase.downloader.qv.g> map = this.cw.get(i6);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
    }

    public SparseArray<com.ss.android.socialbase.downloader.ae.cw> j() {
        return this.f38854j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean m(int i6) {
        up(i6);
        r(i6);
        jy(i6);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f38854j.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.f38854j.size(); i6++) {
            com.ss.android.socialbase.downloader.ae.cw cwVar = this.f38854j.get(this.f38854j.keyAt(i6));
            if (cwVar != null && !TextUtils.isEmpty(cwVar.xw()) && cwVar.xw().equals(str) && com.ss.android.socialbase.downloader.xt.m.m(cwVar.i())) {
                arrayList.add(cwVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized boolean up(int i6) {
        this.f38854j.remove(i6);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(com.ss.android.socialbase.downloader.ae.xt xtVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw ae(int i6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.r(2);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw g(int i6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.r(1);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.f38854j.size();
            for (int i6 = 0; i6 < size; i6++) {
                com.ss.android.socialbase.downloader.ae.cw valueAt = this.f38854j.valueAt(i6);
                if (str != null && str.equals(valueAt.oq())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw oq(int i6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.r(-7);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.r(5);
            xt.g(false);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized com.ss.android.socialbase.downloader.ae.cw xt(int i6) {
        com.ss.android.socialbase.downloader.ae.cw cwVar;
        try {
            cwVar = this.f38854j.get(i6);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            cwVar = null;
        }
        return cwVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f38854j.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.f38854j.size(); i6++) {
            com.ss.android.socialbase.downloader.ae.cw cwVar = this.f38854j.get(this.f38854j.keyAt(i6));
            if (cwVar != null && !TextUtils.isEmpty(cwVar.xw()) && cwVar.xw().equals(str) && com.ss.android.socialbase.downloader.xt.m.ae(cwVar.i())) {
                arrayList.add(cwVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        int qv = xtVar.qv();
        List<com.ss.android.socialbase.downloader.ae.xt> list = this.xt.get(qv);
        if (list == null) {
            list = new ArrayList<>();
            this.xt.put(qv, list);
        }
        list.add(xtVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.ae.xt> cw(int i6) {
        return this.xt.get(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized void cw() {
        this.f38854j.clear();
        this.xt.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized void j(int i6, int i7, long j6) {
        List<com.ss.android.socialbase.downloader.ae.xt> cw = cw(i6);
        if (cw == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.ae.xt xtVar : cw) {
            if (xtVar != null && xtVar.mi() == i7) {
                xtVar.xt(j6);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized void r(int i6) {
        this.xt.remove(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw r(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.j(j6, false);
            xt.r(-2);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw cw(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.j(j6, false);
            xt.r(-3);
            xt.g(false);
            xt.oq(false);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized List<com.ss.android.socialbase.downloader.ae.cw> xt() {
        if (this.f38854j.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f38854j.size());
        for (int i6 = 0; i6 < this.f38854j.size(); i6++) {
            com.ss.android.socialbase.downloader.ae.cw valueAt = this.f38854j.valueAt(i6);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r0.ae() == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        r3 = r0.ae().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r5 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r5.mi() != r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        r5.xt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0051, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.vl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void j(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.cw(r3)     // Catch: java.lang.Throwable -> L4e
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L52
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4e
            com.ss.android.socialbase.downloader.ae.xt r0 = (com.ss.android.socialbase.downloader.ae.xt) r0     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto Ld
            int r1 = r0.mi()     // Catch: java.lang.Throwable -> L4e
            if (r1 != r5) goto Ld
            boolean r1 = r0.m()     // Catch: java.lang.Throwable -> L4e
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.ae()     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L52
            java.util.List r3 = r0.ae()     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
        L35:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L50
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4e
            com.ss.android.socialbase.downloader.ae.xt r5 = (com.ss.android.socialbase.downloader.ae.xt) r5     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L35
            int r0 = r5.mi()     // Catch: java.lang.Throwable -> L4e
            if (r0 != r4) goto L35
            r5.xt(r6)     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r2)
            return
        L4e:
            r3 = move-exception
            goto L54
        L50:
            monitor-exit(r2)
            return
        L52:
            monitor-exit(r2)
            return
        L54:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.qv.j(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.j(j6, false);
            xt.r(-1);
            xt.g(false);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        j(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized com.ss.android.socialbase.downloader.ae.cw j(int i6, int i7) {
        com.ss.android.socialbase.downloader.ae.cw xt;
        xt = xt(i6);
        if (xt != null) {
            xt.up(i7);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        boolean z5 = true;
        if (cwVar == null) {
            return true;
        }
        if (this.f38854j.get(cwVar.ae()) == null) {
            z5 = false;
        }
        this.f38854j.put(cwVar.ae(), cwVar);
        return z5;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6, String str, String str2) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.ae(j6);
            xt.up(str);
            if (TextUtils.isEmpty(xt.tl()) && !TextUtils.isEmpty(str2)) {
                xt.m(str2);
            }
            xt.r(3);
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6) {
        com.ss.android.socialbase.downloader.ae.cw xt = xt(i6);
        if (xt != null) {
            xt.j(j6, false);
            if (xt.i() != -3 && xt.i() != -2 && !com.ss.android.socialbase.downloader.xt.m.ae(xt.i()) && xt.i() != -4) {
                xt.r(4);
            }
        }
        return xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        if (list == null) {
            return;
        }
        r(i6);
        for (com.ss.android.socialbase.downloader.ae.xt xtVar : list) {
            if (xtVar != null) {
                j(xtVar);
                if (xtVar.m()) {
                    Iterator<com.ss.android.socialbase.downloader.ae.xt> it = xtVar.ae().iterator();
                    while (it.hasNext()) {
                        j(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public synchronized boolean j(int i6, Map<Long, com.ss.android.socialbase.downloader.qv.g> map) {
        this.cw.put(i6, map);
        return false;
    }
}
