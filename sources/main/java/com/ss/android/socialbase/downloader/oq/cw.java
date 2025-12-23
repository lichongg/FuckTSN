package com.ss.android.socialbase.downloader.oq;

import com.ss.android.socialbase.downloader.az.m;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw implements xt {

    /* renamed from: j, reason: collision with root package name */
    private final InputStream f38901j;
    private final com.ss.android.socialbase.downloader.qv.j xt;

    @Override // com.ss.android.socialbase.downloader.oq.xt
    public void j(com.ss.android.socialbase.downloader.qv.j jVar) {
    }

    @Override // com.ss.android.socialbase.downloader.oq.xt
    public com.ss.android.socialbase.downloader.qv.j j() throws IOException {
        com.ss.android.socialbase.downloader.qv.j jVar = this.xt;
        jVar.cw = this.f38901j.read(jVar.f38921j);
        return this.xt;
    }

    @Override // com.ss.android.socialbase.downloader.oq.xt
    public void xt() {
        m.j(this.f38901j);
    }

    public cw(InputStream inputStream, int i6) {
        this.f38901j = inputStream;
        this.xt = new com.ss.android.socialbase.downloader.qv.j(i6);
    }
}
