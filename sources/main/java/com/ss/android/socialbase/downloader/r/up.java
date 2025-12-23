package com.ss.android.socialbase.downloader.r;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class up extends cw implements kt {
    protected abstract com.ss.android.socialbase.downloader.notification.j j();

    @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        super.j(cwVar);
        qv(cwVar);
        j(1, cwVar, null, true);
    }

    private void qv(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || !cwVar.oy()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.j up = com.ss.android.socialbase.downloader.notification.xt.j().up(cwVar.ae());
        if (up != null) {
            up.j(cwVar);
        } else {
            com.ss.android.socialbase.downloader.notification.xt.j().j(j());
        }
    }

    private void vl(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar != null && cwVar.oy() && cwVar.i() == 4) {
            com.ss.android.socialbase.downloader.notification.j up = com.ss.android.socialbase.downloader.notification.xt.j().up(cwVar.ae());
            if (up == null) {
                up = j();
            }
            up.j(cwVar.uq(), cwVar.ka());
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.kt
    public void ae(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || cwVar.qe()) {
            return;
        }
        j(11, cwVar, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        super.cw(cwVar);
        vl(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void r(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        super.r(cwVar);
        j(-2, cwVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void up(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        super.up(cwVar);
        j(-3, cwVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        super.xt(cwVar);
        j(2, cwVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        super.j(cwVar, jVar);
        j(-1, cwVar, jVar, false);
    }

    private void j(int i6, com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        if (cwVar == null || !cwVar.oy() || i6 == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.j up = com.ss.android.socialbase.downloader.notification.xt.j().up(cwVar.ae());
        if (up == null) {
            up = j();
        }
        up.xt(cwVar.ka());
        if (i6 == -3) {
            up.j(cwVar.ka());
        } else {
            up.j(cwVar.uq());
        }
        up.j(i6, jVar, z5);
    }
}
