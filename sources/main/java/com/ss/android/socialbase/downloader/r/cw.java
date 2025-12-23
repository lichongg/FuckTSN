package com.ss.android.socialbase.downloader.r;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class cw implements a {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38964j = "cw";

    @Override // com.ss.android.socialbase.downloader.r.a
    public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (!com.ss.android.socialbase.downloader.m.j.j() || cwVar == null || cwVar.ka() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38964j, String.format("onProgress %s %.2f%%", cwVar.tl(), Float.valueOf((cwVar.uq() / cwVar.ka()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (!com.ss.android.socialbase.downloader.m.j.j() || cwVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onPrepare -- " + cwVar.tl());
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (!com.ss.android.socialbase.downloader.m.j.j() || cwVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onStart -- " + cwVar.tl());
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void g(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.m.j.j() && cwVar != null) {
            com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onFirstSuccess -- " + cwVar.tl());
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        if (!com.ss.android.socialbase.downloader.m.j.j() || cwVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38964j, String.format("onFailed on %s because of : %s", cwVar.tl(), jVar != null ? jVar.xt() : "unkown"));
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void m(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.m.j.j() && cwVar != null) {
            com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onCanceled -- " + cwVar.tl());
        }
    }

    public void oq(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.m.j.j() && cwVar != null) {
            com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onIntercept -- " + cwVar.tl());
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void r(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.m.j.j() && cwVar != null) {
            com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onPause -- " + cwVar.tl());
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void tl(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.m.j.j() && cwVar != null) {
            com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onFirstStart -- " + cwVar.tl());
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void up(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.m.j.j() && cwVar != null) {
            com.ss.android.socialbase.downloader.m.j.xt(f38964j, " onSuccessed -- " + cwVar.tl() + " " + cwVar.t());
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        if (!com.ss.android.socialbase.downloader.m.j.j() || cwVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38964j, String.format("onRetry on %s because of : %s", cwVar.tl(), jVar != null ? jVar.xt() : "unkown"));
    }

    @Override // com.ss.android.socialbase.downloader.r.a
    public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        if (!com.ss.android.socialbase.downloader.m.j.j() || cwVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38964j, String.format("onRetryDelay on %s because of : %s", cwVar.tl(), jVar != null ? jVar.xt() : "unkown"));
    }
}
