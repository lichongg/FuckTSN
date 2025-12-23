package com.ss.android.socialbase.downloader.ae;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.kt;
import com.ss.android.socialbase.downloader.downloader.oq;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.az;
import com.ss.android.socialbase.downloader.r.ch;
import com.ss.android.socialbase.downloader.r.h;
import com.ss.android.socialbase.downloader.r.l;
import com.ss.android.socialbase.downloader.r.mi;
import com.ss.android.socialbase.downloader.r.s;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.socialbase.downloader.r.wq;
import com.ss.android.socialbase.downloader.r.ws;
import com.ss.android.socialbase.downloader.xt.tl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class r {
    private final SparseArray<a> ae;
    private kt av;
    private mi az;
    private oq cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f38621f;

    /* renamed from: g, reason: collision with root package name */
    private h f38622g;

    /* renamed from: i, reason: collision with root package name */
    private wq f38623i;

    /* renamed from: j, reason: collision with root package name */
    private cw f38624j;
    private cw.j jy;
    private final List<ws> kt;

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<a> f38625m;
    private tj mi;
    private s oq;
    private az qv;

    /* renamed from: r, reason: collision with root package name */
    private final Map<tl, a> f38626r;
    private int tj;
    private final SparseArray<a> tl;
    private final SparseArray<tl> up;
    private l vl;

    /* renamed from: w, reason: collision with root package name */
    private boolean f38627w;
    private ch ws;
    private g xt;

    public r() {
        this.f38626r = new ConcurrentHashMap();
        this.up = new SparseArray<>();
        this.f38627w = false;
        this.kt = new ArrayList();
        this.f38621f = true;
        this.jy = new cw.j();
        this.f38625m = new SparseArray<>();
        this.ae = new SparseArray<>();
        this.tl = new SparseArray<>();
    }

    public kt ae() {
        return this.av;
    }

    public r av(boolean z5) {
        this.jy.az(z5);
        return this;
    }

    public boolean az() {
        cw cwVar = this.f38624j;
        if (cwVar != null) {
            return cwVar.oy();
        }
        return false;
    }

    public s cw() {
        return this.oq;
    }

    public mi g() {
        return this.az;
    }

    public r i(boolean z5) {
        this.jy.av(z5);
        return this;
    }

    public cw j() {
        return this.f38624j;
    }

    public boolean jy() {
        return this.f38621f;
    }

    public oq m() {
        return this.cw;
    }

    public synchronized int mi() {
        try {
            a cw = cw(tl.MAIN);
            if (cw == null) {
                cw = cw(tl.SUB);
            }
            if (cw != null) {
                this.tj = cw.hashCode();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.tj;
    }

    public h oq() {
        return this.f38622g;
    }

    public wq qv() {
        return this.f38623i;
    }

    public az r() {
        return this.qv;
    }

    public ch tl() {
        return this.ws;
    }

    public l up() {
        return this.vl;
    }

    public int vl() {
        return this.tj;
    }

    public tj ws() {
        return this.mi;
    }

    public boolean xt() {
        return this.f38627w;
    }

    private void f() {
        if (this.f38624j.sh() > 0) {
            j(new oq() { // from class: com.ss.android.socialbase.downloader.ae.r.1
                @Override // com.ss.android.socialbase.downloader.downloader.oq
                public int j(long j6) {
                    return 1;
                }
            });
        }
    }

    public r ae(boolean z5) {
        this.jy.m(z5);
        return this;
    }

    public int av() {
        this.f38624j = this.jy.j();
        cw xt = com.ss.android.socialbase.downloader.downloader.cw.x().xt(this.f38624j.ae());
        if (xt == null) {
            this.f38624j.om();
            com.ss.android.socialbase.downloader.tl.j.j(this, (com.ss.android.socialbase.downloader.up.j) null, 0);
        } else {
            this.f38624j.j(xt);
        }
        f();
        com.ss.android.socialbase.downloader.downloader.r.j().j(this);
        cw cwVar = this.f38624j;
        if (cwVar == null) {
            return 0;
        }
        return cwVar.ae();
    }

    public r cw(int i6, a aVar) {
        if (aVar == null) {
            return this;
        }
        synchronized (this.tl) {
            this.tl.put(i6, aVar);
        }
        Map<tl, a> map = this.f38626r;
        tl tlVar = tl.NOTIFICATION;
        map.put(tlVar, aVar);
        synchronized (this.up) {
            this.up.put(i6, tlVar);
        }
        return this;
    }

    public r g(String str) {
        this.jy.oq(str);
        return this;
    }

    public int i() {
        cw cwVar = this.f38624j;
        if (cwVar == null) {
            return 0;
        }
        return cwVar.ae();
    }

    public void j(boolean z5) {
        this.f38627w = z5;
    }

    public r jy(boolean z5) {
        this.jy.qv(z5);
        return this;
    }

    public g kt() {
        return this.xt;
    }

    public r m(String str) {
        this.jy.ae(str);
        return this;
    }

    public r oq(boolean z5) {
        this.jy.oq(z5);
        return this;
    }

    public r qv(boolean z5) {
        this.jy.jy(z5);
        return this;
    }

    public r r(String str) {
        this.jy.up(str);
        return this;
    }

    @NonNull
    public List<ws> tj() {
        return this.kt;
    }

    public r tl(String str) {
        this.jy.g(str);
        return this;
    }

    public r up(String str) {
        this.jy.m(str);
        return this;
    }

    public r vl(boolean z5) {
        this.jy.tl(z5);
        return this;
    }

    public void w() {
        com.ss.android.socialbase.downloader.m.j.xt("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        cw cwVar = this.f38624j;
        if (cwVar != null && !cwVar.uc()) {
            this.f38624j.j(true);
        }
        r(tl.MAIN);
        r(tl.SUB);
        com.ss.android.socialbase.downloader.tl.j.j(this.vl, this.f38624j, new com.ss.android.socialbase.downloader.up.j(1003, "has another same task, add Listener to old task"), 0);
    }

    public r ws(boolean z5) {
        this.jy.vl(z5);
        return this;
    }

    public r xt(int i6, a aVar) {
        if (aVar == null) {
            return this;
        }
        synchronized (this.ae) {
            this.ae.put(i6, aVar);
        }
        Map<tl, a> map = this.f38626r;
        tl tlVar = tl.SUB;
        map.put(tlVar, aVar);
        synchronized (this.up) {
            this.up.put(i6, tlVar);
        }
        return this;
    }

    public r ae(String str) {
        this.jy.tl(str);
        return this;
    }

    public r az(boolean z5) {
        this.jy.ws(z5);
        return this;
    }

    public r g(boolean z5) {
        this.jy.ae(z5);
        return this;
    }

    public r j(oq oqVar) {
        this.cw = oqVar;
        return this;
    }

    public r m(boolean z5) {
        this.jy.up(z5);
        return this;
    }

    public r oq(String str) {
        this.jy.vl(str);
        return this;
    }

    public r qv(String str) {
        this.jy.r(str);
        return this;
    }

    public r r(int i6) {
        this.jy.r(i6);
        return this;
    }

    public r tl(boolean z5) {
        this.jy.g(z5);
        return this;
    }

    public r up(boolean z5) {
        this.jy.cw(z5);
        return this;
    }

    public r vl(String str) {
        this.jy.qv(str);
        return this;
    }

    public r j(g gVar) {
        this.xt = gVar;
        return this;
    }

    public ws m(int i6) {
        synchronized (this.kt) {
            try {
                if (i6 >= this.kt.size()) {
                    return null;
                }
                return this.kt.get(i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public r r(boolean z5) {
        this.jy.r(z5);
        return this;
    }

    public r up(int i6) {
        this.jy.up(i6);
        return this;
    }

    private void r(tl tlVar) {
        SparseArray<a> j6 = j(tlVar);
        synchronized (j6) {
            for (int i6 = 0; i6 < j6.size(); i6++) {
                try {
                    a aVar = j6.get(j6.keyAt(i6));
                    if (aVar != null) {
                        com.ss.android.socialbase.downloader.downloader.r.j().xt(i(), aVar, tlVar, false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public r j(kt ktVar) {
        this.av = ktVar;
        return this;
    }

    public r j(a aVar) {
        return aVar == null ? this : j(aVar.hashCode(), aVar);
    }

    public r j(int i6, a aVar) {
        if (aVar == null) {
            return this;
        }
        synchronized (this.f38625m) {
            this.f38625m.put(i6, aVar);
        }
        Map<tl, a> map = this.f38626r;
        tl tlVar = tl.MAIN;
        map.put(tlVar, aVar);
        synchronized (this.up) {
            this.up.put(i6, tlVar);
        }
        return this;
    }

    public r cw(String str) {
        this.jy.cw(str);
        return this;
    }

    public r xt(a aVar) {
        return aVar == null ? this : cw(aVar.hashCode(), aVar);
    }

    public r(cw cwVar) {
        this();
        this.f38624j = cwVar;
    }

    public r cw(boolean z5) {
        this.jy.xt(z5);
        return this;
    }

    public r xt(String str) {
        this.jy.xt(str);
        return this;
    }

    public r cw(int i6) {
        this.jy.cw(i6);
        return this;
    }

    public r xt(boolean z5) {
        this.jy.j(z5);
        return this;
    }

    public a cw(tl tlVar) {
        return this.f38626r.get(tlVar);
    }

    public r xt(int i6) {
        this.jy.xt(i6);
        return this;
    }

    private void cw(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i6 = 0; i6 < size; i6++) {
            sparseArray.remove(sparseArray2.keyAt(i6));
        }
    }

    public r xt(List<String> list) {
        this.jy.xt(list);
        return this;
    }

    public r j(h hVar) {
        this.f38622g = hVar;
        return this;
    }

    public r xt(long j6) {
        this.jy.xt(j6);
        return this;
    }

    public r j(s sVar) {
        this.oq = sVar;
        return this;
    }

    public int xt(tl tlVar) {
        int size;
        SparseArray<a> j6 = j(tlVar);
        if (j6 == null) {
            return 0;
        }
        synchronized (j6) {
            size = j6.size();
        }
        return size;
    }

    public r cw(List<ws> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<ws> it = list.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
        }
        return this;
    }

    public r j(az azVar) {
        this.qv = azVar;
        return this;
    }

    public r j(l lVar) {
        this.vl = lVar;
        return this;
    }

    public r j(wq wqVar) {
        this.f38623i = wqVar;
        return this;
    }

    public r j(ch chVar) {
        this.ws = chVar;
        return this;
    }

    public void xt(int i6, a aVar, tl tlVar, boolean z5) {
        Map<tl, a> map;
        if (aVar == null) {
            return;
        }
        if (z5 && (map = this.f38626r) != null) {
            map.put(tlVar, aVar);
            synchronized (this.up) {
                this.up.put(i6, tlVar);
            }
        }
        SparseArray<a> j6 = j(tlVar);
        if (j6 == null) {
            return;
        }
        synchronized (j6) {
            j6.put(i6, aVar);
        }
    }

    public r j(mi miVar) {
        this.az = miVar;
        return this;
    }

    public r j(String str) {
        this.jy.j(str);
        return this;
    }

    public r j(List<up> list) {
        this.jy.j(list);
        return this;
    }

    public r j(int i6) {
        this.jy.j(i6);
        return this;
    }

    public r j(long j6) {
        this.jy.j(j6);
        return this;
    }

    public r j(com.ss.android.socialbase.downloader.xt.ae aeVar) {
        this.jy.j(aeVar);
        return this;
    }

    public r j(tj tjVar) {
        this.mi = tjVar;
        return this;
    }

    public r j(JSONObject jSONObject) {
        this.jy.j(jSONObject);
        return this;
    }

    public r j(int[] iArr) {
        this.jy.j(iArr);
        return this;
    }

    public void xt(h hVar) {
        this.f38622g = hVar;
    }

    private void xt(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = sparseArray.keyAt(i6);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    public SparseArray<a> j(tl tlVar) {
        if (tlVar == tl.MAIN) {
            return this.f38625m;
        }
        if (tlVar == tl.SUB) {
            return this.ae;
        }
        if (tlVar == tl.NOTIFICATION) {
            return this.tl;
        }
        return null;
    }

    public a j(tl tlVar, int i6) {
        SparseArray<a> j6 = j(tlVar);
        if (j6 == null || i6 < 0) {
            return null;
        }
        synchronized (j6) {
            try {
                if (i6 >= j6.size()) {
                    return null;
                }
                return j6.get(j6.keyAt(i6));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(int i6, a aVar, tl tlVar, boolean z5) {
        int indexOfValue;
        SparseArray<a> j6 = j(tlVar);
        if (j6 == null) {
            if (z5 && this.f38626r.containsKey(tlVar)) {
                this.f38626r.remove(tlVar);
                return;
            }
            return;
        }
        synchronized (j6) {
            try {
                if (z5) {
                    if (this.f38626r.containsKey(tlVar)) {
                        aVar = this.f38626r.get(tlVar);
                        this.f38626r.remove(tlVar);
                    }
                    if (aVar != null && (indexOfValue = j6.indexOfValue(aVar)) >= 0 && indexOfValue < j6.size()) {
                        j6.removeAt(indexOfValue);
                    }
                } else {
                    j6.remove(i6);
                    synchronized (this.up) {
                        try {
                            tl tlVar2 = this.up.get(i6);
                            if (tlVar2 != null && this.f38626r.containsKey(tlVar2)) {
                                this.f38626r.remove(tlVar2);
                                this.up.remove(i6);
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(SparseArray<a> sparseArray, SparseArray<a> sparseArray2) {
        sparseArray.clear();
        for (int i6 = 0; i6 < sparseArray2.size(); i6++) {
            int keyAt = sparseArray2.keyAt(i6);
            a aVar = sparseArray2.get(keyAt);
            if (aVar != null) {
                sparseArray.put(keyAt, aVar);
            }
        }
    }

    public void j(SparseArray<a> sparseArray, tl tlVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (tlVar == tl.MAIN) {
                synchronized (this.f38625m) {
                    j(this.f38625m, sparseArray);
                }
                return;
            } else if (tlVar == tl.SUB) {
                synchronized (this.ae) {
                    j(this.ae, sparseArray);
                }
                return;
            } else {
                if (tlVar == tl.NOTIFICATION) {
                    synchronized (this.tl) {
                        j(this.tl, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        vl.j(th);
    }

    public void j(r rVar) {
        for (Map.Entry<tl, a> entry : rVar.f38626r.entrySet()) {
            if (entry != null && !this.f38626r.containsKey(entry.getKey())) {
                this.f38626r.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (rVar.f38625m.size() != 0) {
                synchronized (this.f38625m) {
                    cw(this.f38625m, rVar.f38625m);
                    xt(rVar.f38625m, this.f38625m);
                }
            }
            if (rVar.ae.size() != 0) {
                synchronized (this.ae) {
                    cw(this.ae, rVar.ae);
                    xt(rVar.ae, this.ae);
                }
            }
            if (rVar.tl.size() != 0) {
                synchronized (this.tl) {
                    cw(this.tl, rVar.tl);
                    xt(rVar.tl, this.tl);
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public r j(ws wsVar) {
        synchronized (this.kt) {
            if (wsVar != null) {
                try {
                    if (!this.kt.contains(wsVar)) {
                        this.kt.add(wsVar);
                        return this;
                    }
                } finally {
                }
            }
            return this;
        }
    }
}
