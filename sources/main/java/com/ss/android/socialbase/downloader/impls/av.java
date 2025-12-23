package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.h;
import com.ss.android.socialbase.downloader.r.n;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.socialbase.downloader.r.wq;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class av implements com.ss.android.socialbase.downloader.downloader.az {
    private final com.ss.android.socialbase.downloader.downloader.i cw;

    /* renamed from: j, reason: collision with root package name */
    private final j f38835j;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f38836r;
    private final com.ss.android.socialbase.downloader.downloader.vl xt;

    public av() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean ae(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.j(i6);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void cw(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.m(i6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.up(i6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public int m(int i6) {
        com.ss.android.socialbase.downloader.ae.cw r5;
        j jVar = this.f38835j;
        if (jVar == null || (r5 = jVar.r(i6)) == null) {
            return 0;
        }
        return r5.i();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void r(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.ae(i6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public long up(int i6) {
        com.ss.android.socialbase.downloader.ae.cw xt;
        com.ss.android.socialbase.downloader.downloader.vl vlVar = this.xt;
        if (vlVar == null || (xt = vlVar.xt(i6)) == null) {
            return 0L;
        }
        int kj = xt.kj();
        if (kj <= 1) {
            return xt.uq();
        }
        List<com.ss.android.socialbase.downloader.ae.xt> cw = this.xt.cw(i6);
        if (cw == null || cw.size() != kj) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.az.m.xt(cw);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean xt(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.ws(i6);
        }
        return false;
    }

    public av(boolean z5) {
        this.f38835j = com.ss.android.socialbase.downloader.downloader.cw.p();
        this.xt = com.ss.android.socialbase.downloader.downloader.cw.x();
        if (z5) {
            this.cw = com.ss.android.socialbase.downloader.downloader.cw.s();
        } else {
            this.cw = com.ss.android.socialbase.downloader.downloader.cw.ch();
        }
        this.f38836r = com.ss.android.socialbase.downloader.jy.j.cw().xt("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean av(int i6) {
        return this.xt.m(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void az(int i6) {
        this.xt.r(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.xt> g(int i6) {
        return this.xt.cw(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public h i(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.g(i6);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public tj mi(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.oq(i6);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void oq(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.jy(i6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.r(i6);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean vl(int i6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.qv(i6);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public wq w(int i6) {
        j jVar = this.f38835j;
        wq tl = jVar != null ? jVar.tl(i6) : null;
        return tl == null ? com.ss.android.socialbase.downloader.downloader.cw.ed() : tl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean ws(int i6) {
        return this.xt.up(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean ae() {
        com.ss.android.socialbase.downloader.downloader.i iVar;
        return this.f38836r && (iVar = this.cw) != null && iVar.j();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        com.ss.android.socialbase.downloader.downloader.vl vlVar = this.xt;
        if (vlVar != null) {
            return vlVar.cw(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, boolean z5) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.j(i6, z5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public int jy(int i6) {
        return com.ss.android.socialbase.downloader.downloader.r.j().j(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void qv(int i6) {
        com.ss.android.socialbase.downloader.m.j.j(i6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> r() {
        com.ss.android.socialbase.downloader.downloader.vl vlVar = this.xt;
        if (vlVar != null) {
            return vlVar.xt();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        com.ss.android.socialbase.downloader.downloader.vl vlVar = this.xt;
        if (vlVar != null) {
            return vlVar.xt(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void m() {
        this.xt.cw();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean cw() {
        return com.ss.android.socialbase.downloader.downloader.cw.rh();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j() {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.xt();
        }
    }

    public void r(int i6, boolean z5) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.cw(i6, z5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(List<String> list) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.xt(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void cw(int i6, boolean z5) {
        com.ss.android.socialbase.downloader.downloader.r.j().j(i6, z5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        return this.xt.j(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(List<String> list) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.j(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        com.ss.android.socialbase.downloader.downloader.vl vlVar = this.xt;
        if (vlVar != null) {
            return vlVar.r(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public com.ss.android.socialbase.downloader.ae.cw xt(String str, String str2) {
        return tl(com.ss.android.socialbase.downloader.downloader.cw.j(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> up(String str) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.xt(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        j jVar = this.f38835j;
        if (jVar != null) {
            return jVar.j(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(int i6, boolean z5) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.xt(i6, z5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean up() {
        return this.xt.r();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public int j(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.cw.j(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.j(i6, i7, aVar, tlVar, z5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.xt(i6, i7, aVar, tlVar, z5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean xt() {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.cw;
        if (iVar != null) {
            return iVar.xt();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5, boolean z6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.j(i6, i7, aVar, tlVar, z5, z6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(com.ss.android.socialbase.downloader.ae.r rVar) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.cw;
        if (iVar != null) {
            iVar.cw(rVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return false;
        }
        boolean j6 = com.ss.android.socialbase.downloader.az.m.j(cwVar.i(), cwVar.qv(), cwVar.tl());
        if (j6) {
            if (com.ss.android.socialbase.downloader.az.j.j(CommonNetImpl.FLAG_SHARE_JUMP)) {
                xt(cwVar.ae(), true);
                return j6;
            }
            r(cwVar.ae(), true);
        }
        return j6;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        this.xt.xt(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        this.xt.xt(i6, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.cw;
        if (iVar != null) {
            iVar.j(i6, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(boolean z5, boolean z6) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.cw;
        if (iVar != null) {
            iVar.j(z6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(com.ss.android.socialbase.downloader.ae.r rVar) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.cw;
        if (iVar != null) {
            iVar.xt(rVar);
        } else if (rVar != null) {
            com.ss.android.socialbase.downloader.tl.j.j(rVar.up(), rVar.j(), new com.ss.android.socialbase.downloader.up.j(1003, "downloadServiceHandler is null"), rVar.j() != null ? rVar.j().i() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        this.xt.j(i6, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        this.xt.j(xtVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, long j6) {
        this.xt.j(i6, i7, j6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, int i8, long j6) {
        this.xt.j(i6, i7, i8, j6);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, int i8, int i9) {
        this.xt.j(i6, i7, i8, i9);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(n nVar) {
        com.ss.android.socialbase.downloader.downloader.cw.j(nVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7) {
        if (com.ss.android.socialbase.downloader.downloader.cw.r() != null) {
            for (n nVar : com.ss.android.socialbase.downloader.downloader.cw.r()) {
                if (nVar != null) {
                    nVar.j(i7, i6);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, h hVar) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.j(i6, hVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, long j6) {
        j jVar = this.f38835j;
        if (jVar != null) {
            jVar.xt(i6, j6);
        }
    }
}
