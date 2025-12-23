package com.ss.android.socialbase.downloader.qv;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes6.dex */
class vl implements up {
    private final up cw;

    /* renamed from: j, reason: collision with root package name */
    private final g f38956j;
    private final com.ss.android.socialbase.downloader.ae.ae xt;

    public up j() {
        return this.cw;
    }

    @Override // com.ss.android.socialbase.downloader.qv.up
    public void xt(@NonNull j jVar) throws IOException {
        this.xt.j(jVar.f38921j, 0, jVar.cw);
        this.f38956j.xt(jVar.cw);
    }

    private com.ss.android.socialbase.downloader.ae.ae j(com.ss.android.socialbase.downloader.ae.cw cwVar, g gVar) throws com.ss.android.socialbase.downloader.up.j {
        com.ss.android.socialbase.downloader.ae.ae j6 = com.ss.android.socialbase.downloader.az.m.j(cwVar, cwVar.vl(), cwVar.jy(), com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("flush_buffer_size_byte", -1));
        try {
            j6.j(gVar.up());
            return j6;
        } catch (IOException e6) {
            throw new com.ss.android.socialbase.downloader.up.j(1054, e6);
        }
    }

    public void cw() throws IOException {
        this.xt.cw();
    }

    public void r() {
        com.ss.android.socialbase.downloader.az.m.j(this.xt);
    }

    public g up() {
        return this.f38956j;
    }

    public vl(com.ss.android.socialbase.downloader.ae.cw cwVar, xt xtVar, g gVar) throws com.ss.android.socialbase.downloader.up.j {
        this.f38956j = gVar;
        this.xt = j(cwVar, gVar);
        this.cw = new tl(xtVar, this);
    }

    public void xt() throws IOException {
        this.xt.xt();
    }
}
