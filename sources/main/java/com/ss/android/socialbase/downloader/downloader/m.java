package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.c;
import com.ss.android.socialbase.downloader.r.l;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes6.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38757j = "m";
    private SparseArray<a> ae;
    private com.ss.android.socialbase.downloader.r.az av;
    private long az;
    private com.ss.android.socialbase.downloader.ae.cw cw;

    /* renamed from: g, reason: collision with root package name */
    private SparseArray<a> f38758g;

    /* renamed from: i, reason: collision with root package name */
    private l f38759i;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.ae.r f38760m;

    /* renamed from: r, reason: collision with root package name */
    private final vl f38761r;
    private SparseArray<a> tl;
    private final Handler up;
    private int ws;
    private final boolean xt;
    private boolean oq = false;
    private volatile long qv = 0;
    private final AtomicLong vl = new AtomicLong();
    private boolean jy = false;

    private void jy() throws com.ss.android.socialbase.downloader.up.j {
        List<com.ss.android.socialbase.downloader.r.ws> tj = this.f38760m.tj();
        if (tj.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.ae.cw cwVar = this.cw;
        j(11, (com.ss.android.socialbase.downloader.up.j) null);
        this.f38761r.j(cwVar);
        for (com.ss.android.socialbase.downloader.r.ws wsVar : tj) {
            try {
                if (wsVar.xt(cwVar)) {
                    wsVar.j(cwVar);
                    this.f38761r.j(cwVar);
                }
            } catch (com.ss.android.socialbase.downloader.up.j e6) {
                throw e6;
            } catch (Throwable th) {
                throw new com.ss.android.socialbase.downloader.up.j(1071, th);
            }
        }
    }

    private void oq() {
        com.ss.android.socialbase.downloader.ae.r rVar = this.f38760m;
        if (rVar != null) {
            this.cw = rVar.j();
            this.ae = this.f38760m.j(com.ss.android.socialbase.downloader.xt.tl.MAIN);
            this.f38758g = this.f38760m.j(com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION);
            this.tl = this.f38760m.j(com.ss.android.socialbase.downloader.xt.tl.SUB);
            this.av = this.f38760m.r();
            this.f38759i = this.f38760m.up();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
        try {
            com.ss.android.socialbase.downloader.m.j.xt(f38757j, "saveFileAsTargetName onSuccess");
            try {
                jy();
                this.cw.oq(false);
                this.cw.tl(false);
                j(-3, (com.ss.android.socialbase.downloader.up.j) null);
                this.f38761r.cw(this.cw.ae(), this.cw.ka());
                this.f38761r.r(this.cw.ae());
                this.f38761r.jy(this.cw.ae());
            } catch (com.ss.android.socialbase.downloader.up.j e6) {
                j(e6);
            }
        } catch (Throwable th) {
            j(new com.ss.android.socialbase.downloader.up.j(1008, com.ss.android.socialbase.downloader.az.m.xt(th, "onCompleted")));
        }
    }

    public void ae() throws com.ss.android.socialbase.downloader.up.j {
        if (!this.xt) {
            jy();
            com.ss.android.socialbase.downloader.m.j.xt(f38757j, "onCompleteForFileExist");
            this.cw.tl(true);
            j(-3, (com.ss.android.socialbase.downloader.up.j) null);
            this.f38761r.cw(this.cw.ae(), this.cw.ka());
            this.f38761r.r(this.cw.ae());
            this.f38761r.jy(this.cw.ae());
            return;
        }
        jy();
        com.ss.android.socialbase.downloader.m.j.xt(f38757j, "onCompleteForFileExist");
        this.cw.tl(true);
        j(-3, (com.ss.android.socialbase.downloader.up.j) null);
        this.f38761r.cw(this.cw.ae(), this.cw.ka());
        this.f38761r.r(this.cw.ae());
        this.f38761r.j(this.cw);
        this.f38761r.jy(this.cw.ae());
    }

    public void cw() {
        j(-4, (com.ss.android.socialbase.downloader.up.j) null);
    }

    public void m() {
        this.cw.g(false);
        if (!this.cw.nt() && this.cw.uq() != this.cw.ka()) {
            com.ss.android.socialbase.downloader.m.j.xt(f38757j, this.cw.r());
            j(new com.ss.android.socialbase.downloader.up.ae(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.cw.ik()));
            return;
        }
        if (this.cw.uq() <= 0) {
            com.ss.android.socialbase.downloader.m.j.xt(f38757j, this.cw.r());
            j(new com.ss.android.socialbase.downloader.up.ae(1026, "curBytes is 0, bytes changed with process : " + this.cw.ik()));
            return;
        }
        if (!this.cw.nt() && this.cw.ka() <= 0) {
            com.ss.android.socialbase.downloader.m.j.xt(f38757j, this.cw.r());
            j(new com.ss.android.socialbase.downloader.up.ae(1044, "TotalBytes is 0, bytes changed with process : " + this.cw.ik()));
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38757j, this.cw.tl() + " onCompleted start save file as target name");
        l lVar = this.f38759i;
        com.ss.android.socialbase.downloader.ae.r rVar = this.f38760m;
        if (rVar != null) {
            lVar = rVar.up();
        }
        com.ss.android.socialbase.downloader.az.m.j(this.cw, lVar, new c() { // from class: com.ss.android.socialbase.downloader.downloader.m.2
            @Override // com.ss.android.socialbase.downloader.r.c
            public void j() {
                m.this.vl();
            }

            @Override // com.ss.android.socialbase.downloader.r.c
            public void j(com.ss.android.socialbase.downloader.up.j jVar) {
                String str = m.f38757j;
                StringBuilder sb = new StringBuilder("saveFileAsTargetName onFailed : ");
                sb.append(jVar != null ? jVar.xt() : "");
                com.ss.android.socialbase.downloader.m.j.xt(str, sb.toString());
                m.this.j(jVar);
            }
        });
    }

    public void r() {
        this.cw.r(-2);
        try {
            this.f38761r.r(this.cw.ae(), this.cw.uq());
        } catch (SQLiteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        j(-2, (com.ss.android.socialbase.downloader.up.j) null);
    }

    public void tl() {
        this.cw.r(8);
        this.cw.j(com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.j p5 = cw.p();
        if (p5 != null) {
            p5.j(this.cw.ae(), this.f38760m.vl(), 8);
        }
    }

    public void up() {
        this.cw.r(-7);
        try {
            this.f38761r.oq(this.cw.ae());
        } catch (SQLiteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        j(-7, (com.ss.android.socialbase.downloader.up.j) null);
    }

    public void xt() {
        if (this.cw.ig()) {
            this.cw.yb();
            return;
        }
        this.f38761r.ae(this.cw.ae());
        if (this.cw.fz()) {
            j(6, (com.ss.android.socialbase.downloader.up.j) null);
        }
        j(2, (com.ss.android.socialbase.downloader.up.j) null);
    }

    public m(com.ss.android.socialbase.downloader.ae.r rVar, Handler handler) {
        this.f38760m = rVar;
        oq();
        this.up = handler;
        this.f38761r = cw.x();
        com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
        if (j6 != null) {
            this.xt = com.ss.android.socialbase.downloader.jy.j.j(j6.ae()).j("fix_start_with_file_exist_update_error");
        } else {
            this.xt = false;
        }
    }

    private com.ss.android.socialbase.downloader.up.j cw(com.ss.android.socialbase.downloader.up.j jVar) {
        Context nd;
        if (com.ss.android.socialbase.downloader.jy.j.j(this.cw.ae()).j("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.az.m.g(jVar) || (nd = cw.nd()) == null || com.ss.android.socialbase.downloader.az.m.cw(nd)) {
            return jVar;
        }
        return new com.ss.android.socialbase.downloader.up.j(this.cw.x() ? 1013 : 1049, jVar.xt());
    }

    private void qv() {
        ExecutorService qv = cw.qv();
        if (qv != null) {
            qv.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.f38761r.g(m.this.cw.ae());
                    m.this.j(1, (com.ss.android.socialbase.downloader.up.j) null);
                }
            });
        }
    }

    public void j() {
        if (this.cw.ig()) {
            return;
        }
        this.cw.r(1);
        qv();
    }

    public void j(long j6, String str, String str2) {
        long j7;
        this.cw.ae(j6);
        this.cw.up(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.cw.tl())) {
            this.cw.m(str2);
        }
        try {
            j7 = j6;
        } catch (Exception e6) {
            e = e6;
            j7 = j6;
        }
        try {
            this.f38761r.j(this.cw.ae(), j7, str, str2);
        } catch (Exception e7) {
            e = e7;
            com.bytedance.sdk.component.utils.vl.j(e);
            j(3, (com.ss.android.socialbase.downloader.up.j) null);
            this.az = this.cw.tl(j7);
            this.ws = this.cw.by();
            this.oq = true;
            com.ss.android.socialbase.downloader.impls.w.j().up();
        }
        j(3, (com.ss.android.socialbase.downloader.up.j) null);
        this.az = this.cw.tl(j7);
        this.ws = this.cw.by();
        this.oq = true;
        com.ss.android.socialbase.downloader.impls.w.j().up();
    }

    private void xt(com.ss.android.socialbase.downloader.up.j jVar) {
        Log.getStackTraceString(new Throwable());
        if (jVar != null && jVar.getCause() != null && (jVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.f38761r.m(this.cw.ae());
            } catch (SQLiteException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        } else {
            try {
                try {
                    this.f38761r.xt(this.cw.ae(), this.cw.uq());
                } catch (SQLiteException unused) {
                    this.f38761r.m(this.cw.ae());
                }
            } catch (SQLiteException e7) {
                com.bytedance.sdk.component.utils.vl.j(e7);
            }
        }
        com.ss.android.socialbase.downloader.up.j cw = cw(jVar);
        this.cw.j(cw);
        j(cw instanceof com.ss.android.socialbase.downloader.up.m ? -2 : -1, cw);
        if (com.ss.android.socialbase.downloader.jy.j.j(this.cw.ae()).j("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.w.j().j(this.cw);
        }
    }

    public boolean j(long j6) {
        this.vl.addAndGet(j6);
        this.cw.m(j6);
        long uptimeMillis = SystemClock.uptimeMillis();
        return j(uptimeMillis, xt(uptimeMillis));
    }

    private boolean xt(long j6) {
        boolean z5 = true;
        if (!this.jy) {
            this.jy = true;
            return true;
        }
        long j7 = j6 - this.qv;
        if (this.vl.get() < this.az && j7 < this.ws) {
            z5 = false;
        }
        if (z5) {
            this.qv = j6;
            this.vl.set(0L);
        }
        return z5;
    }

    public void j(com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        this.cw.g(false);
        this.vl.set(0L);
        xt(jVar, z5);
    }

    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar, com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        this.cw.g(false);
        this.vl.set(0L);
        this.f38761r.tl(this.cw.ae());
        j(z5 ? 10 : 9, jVar, true);
    }

    private void xt(com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        this.f38761r.tl(this.cw.ae());
        j(z5 ? 7 : 5, jVar);
    }

    public void j(com.ss.android.socialbase.downloader.up.j jVar) {
        this.cw.g(false);
        xt(jVar);
    }

    public void j(String str) throws com.ss.android.socialbase.downloader.up.j {
        com.ss.android.socialbase.downloader.m.j.xt(f38757j, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.cw.tl());
        if (this.xt) {
            com.ss.android.socialbase.downloader.az.m.j(this.cw, str);
            jy();
            this.cw.tl(true);
            j(-3, (com.ss.android.socialbase.downloader.up.j) null);
            this.f38761r.j(this.cw);
            return;
        }
        this.f38761r.j(this.cw);
        com.ss.android.socialbase.downloader.az.m.j(this.cw, str);
        this.cw.tl(true);
        jy();
        j(-3, (com.ss.android.socialbase.downloader.up.j) null);
    }

    private boolean j(long j6, boolean z5) {
        boolean z6 = false;
        if (this.cw.uq() == this.cw.ka()) {
            try {
                this.f38761r.j(this.cw.ae(), this.cw.uq());
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            return false;
        }
        if (this.oq) {
            this.oq = false;
            this.cw.r(4);
        }
        if (this.cw.sf() && z5) {
            z6 = true;
        }
        j(4, (com.ss.android.socialbase.downloader.up.j) null, z6);
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, com.ss.android.socialbase.downloader.up.j jVar) {
        j(i6, jVar, true);
    }

    private void j(int i6, com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        SparseArray<a> sparseArray;
        SparseArray<a> sparseArray2;
        int i7 = this.cw.i();
        if (i7 == -3 && i6 == 4) {
            return;
        }
        oq();
        if (i6 != 4 && com.ss.android.socialbase.downloader.xt.m.up(i6)) {
            this.cw.ae(false);
            if (com.ss.android.socialbase.downloader.xt.m.r(i6)) {
                this.cw.pz();
            }
        }
        if (!this.cw.uc()) {
            com.ss.android.socialbase.downloader.tl.j.j(this.f38760m, jVar, i6);
        }
        if (i6 == 6) {
            this.cw.r(2);
        } else if (i6 == -6) {
            this.cw.r(-3);
        } else {
            this.cw.r(i6);
        }
        if (i7 == -3 || i7 == -1) {
            if (this.cw.rs() == com.ss.android.socialbase.downloader.xt.g.DELAY_RETRY_DOWNLOADING) {
                this.cw.j(com.ss.android.socialbase.downloader.xt.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.cw.jl() == com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_DOWNLOADING) {
                this.cw.j(com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.cw.ik() == com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.cw.j(com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.az.cw.j(i6, this.tl, true, this.cw, jVar);
        if (i6 == -4) {
            return;
        }
        if (z5 && this.up != null && (((sparseArray = this.ae) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f38758g) != null && sparseArray2.size() > 0 && (this.cw.oy() || this.cw.qe())))) {
            this.up.obtainMessage(i6, this.cw.ae(), this.f38760m.vl(), jVar).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.j p5 = cw.p();
        if (p5 != null) {
            p5.j(this.cw.ae(), this.f38760m.vl(), i6);
        }
    }
}
