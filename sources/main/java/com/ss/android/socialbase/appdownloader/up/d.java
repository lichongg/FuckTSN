package com.ss.android.socialbase.appdownloader.up;

import android.content.Context;
import com.ss.android.socialbase.appdownloader.m.f;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.notification.j;
import com.ss.android.socialbase.downloader.r.up;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends up {

    /* renamed from: a, reason: collision with root package name */
    private Context f38543a;

    /* renamed from: b, reason: collision with root package name */
    private int f38544b;

    /* renamed from: c, reason: collision with root package name */
    private String f38545c;

    /* renamed from: d, reason: collision with root package name */
    private String f38546d;

    /* renamed from: e, reason: collision with root package name */
    private String f38547e;

    /* renamed from: f, reason: collision with root package name */
    private String f38548f;

    /* renamed from: g, reason: collision with root package name */
    private j f38549g;

    public d(Context context, int i6, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f38543a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.f38543a = cw.nd();
        }
        this.f38544b = i6;
        this.f38545c = str;
        this.f38546d = str2;
        this.f38547e = str3;
        this.f38548f = str4;
    }

    @Override // com.ss.android.socialbase.downloader.r.up
    public j j() {
        Context context;
        j jVar = this.f38549g;
        return (jVar != null || (context = this.f38543a) == null) ? jVar : new b(context, this.f38544b, this.f38545c, this.f38546d, this.f38547e, this.f38548f);
    }

    @Override // com.ss.android.socialbase.downloader.r.up, com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || cwVar.qe()) {
            return;
        }
        super.cw(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.r.up, com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void r(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || cwVar.qe()) {
            return;
        }
        super.r(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.r.up, com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void up(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || this.f38543a == null) {
            return;
        }
        if (cwVar.oy() && (!cwVar.qe() || !cwVar.px())) {
            super.up(cwVar);
        }
        if (cwVar.px()) {
            f.a(cwVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.up, com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || cwVar.qe()) {
            return;
        }
        super.xt(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.r.up, com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || cwVar.qe()) {
            return;
        }
        super.j(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.r.up, com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        if (cwVar == null || this.f38543a == null || !cwVar.oy() || cwVar.qe()) {
            return;
        }
        super.j(cwVar, jVar);
    }

    public d(j jVar) {
        this.f38543a = cw.nd();
        this.f38549g = jVar;
    }
}
