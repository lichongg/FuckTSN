package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes6.dex */
public class up {
    private static String xt = "ResponseHandler";

    /* renamed from: a, reason: collision with root package name */
    private long f38780a;
    private vl ae;
    private long av;
    private long az;
    private final boolean ch;
    private final com.ss.android.socialbase.downloader.ae.cw cw;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f38781f;

    /* renamed from: g, reason: collision with root package name */
    private tj f38782g;

    /* renamed from: h, reason: collision with root package name */
    private long f38783h;

    /* renamed from: i, reason: collision with root package name */
    private volatile long f38784i;
    private volatile boolean jy;
    private final com.ss.android.socialbase.downloader.jy.j kt;

    /* renamed from: l, reason: collision with root package name */
    private long f38786l;

    /* renamed from: m, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.g.g f38787m;
    private final boolean mi;
    private com.ss.android.socialbase.downloader.ae.ae oq;

    /* renamed from: p, reason: collision with root package name */
    private long f38788p;
    private com.ss.android.socialbase.downloader.up.j qv;

    /* renamed from: r, reason: collision with root package name */
    private final String f38789r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f38790s;
    private final com.ss.android.socialbase.downloader.j.j tj;
    private com.ss.android.socialbase.downloader.impls.qv tl;
    private final com.ss.android.socialbase.downloader.ae.xt up;

    /* renamed from: v, reason: collision with root package name */
    private final long f38791v;
    private volatile boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private volatile long f38792w;
    private final com.ss.android.socialbase.downloader.ws.m ws;

    /* renamed from: x, reason: collision with root package name */
    private final long f38793x;

    /* renamed from: j, reason: collision with root package name */
    boolean f38785j = false;
    private volatile long la = 0;
    private volatile long gq = 0;

    private boolean xt(long j6, long j7) {
        return j6 > 65536 && j7 > 500;
    }

    private void ae() {
        ExecutorService qv;
        if (this.f38787m == null || (qv = cw.qv()) == null) {
            return;
        }
        qv.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.up.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.f38787m.r();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private boolean m() {
        return this.vl || this.jy;
    }

    private void tl() {
        long nanoTime = this.ch ? System.nanoTime() : 0L;
        try {
            this.oq.j();
            this.cw.ae(true);
            boolean z5 = this.cw.kj() > 1;
            az j6 = com.ss.android.socialbase.downloader.impls.vl.j(com.ss.android.socialbase.downloader.az.m.xt());
            if (z5) {
                j(this.f38782g);
                if (j6 != null) {
                    j6.cw(this.cw);
                } else {
                    this.f38782g.j(this.cw.ae(), this.cw.uq());
                }
            } else if (j6 != null) {
                j6.cw(this.cw);
            } else {
                this.f38782g.j(this.up.qv(), this.az);
            }
            this.la = this.az;
        } catch (Exception unused) {
        }
        if (this.ch) {
            this.f38788p += System.nanoTime() - nanoTime;
        }
    }

    public void cw() {
        if (this.jy) {
            return;
        }
        synchronized (this.ws) {
            this.jy = true;
        }
        ae();
    }

    public long j() {
        return this.az;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04bf A[Catch: all -> 0x049b, TRY_LEAVE, TryCatch #33 {all -> 0x049b, blocks: (B:269:0x0498, B:270:0x049a, B:150:0x04a6, B:152:0x04bf, B:188:0x0514, B:190:0x051a, B:191:0x051d, B:192:0x051f, B:234:0x0397), top: B:8:0x0028, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x051a A[Catch: all -> 0x049b, TryCatch #33 {all -> 0x049b, blocks: (B:269:0x0498, B:270:0x049a, B:150:0x04a6, B:152:0x04bf, B:188:0x0514, B:190:0x051a, B:191:0x051d, B:192:0x051f, B:234:0x0397), top: B:8:0x0028, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0388 A[Catch: all -> 0x0392, TRY_ENTER, TryCatch #27 {all -> 0x0392, blocks: (B:197:0x031e, B:230:0x0388, B:232:0x038e, B:234:0x0397), top: B:196:0x031e }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0530 A[Catch: all -> 0x054a, TryCatch #22 {all -> 0x054a, blocks: (B:279:0x052c, B:281:0x0530, B:282:0x0532, B:297:0x0549, B:298:0x054c, B:300:0x0555, B:284:0x0533, B:286:0x0537, B:288:0x0540, B:289:0x0546), top: B:278:0x052c, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x054c A[Catch: all -> 0x054a, TryCatch #22 {all -> 0x054a, blocks: (B:279:0x052c, B:281:0x0530, B:282:0x0532, B:297:0x0549, B:298:0x054c, B:300:0x0555, B:284:0x0533, B:286:0x0537, B:288:0x0540, B:289:0x0546), top: B:278:0x052c, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x042b  */
    /* JADX WARN: Type inference failed for: r33v1 */
    /* JADX WARN: Type inference failed for: r33v23 */
    /* JADX WARN: Type inference failed for: r33v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r() throws com.ss.android.socialbase.downloader.up.j {
        /*
            Method dump skipped, instructions count: 1452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.up.r():void");
    }

    public long up() {
        return this.la;
    }

    public void xt() {
        if (this.vl) {
            return;
        }
        this.vl = true;
        ae();
    }

    public up(com.ss.android.socialbase.downloader.ae.cw cwVar, String str, com.ss.android.socialbase.downloader.g.g gVar, com.ss.android.socialbase.downloader.ae.xt xtVar, com.ss.android.socialbase.downloader.ws.m mVar) {
        boolean z5;
        this.cw = cwVar;
        this.f38789r = str;
        vl x5 = cw.x();
        this.ae = x5;
        if (x5 instanceof com.ss.android.socialbase.downloader.impls.r) {
            com.ss.android.socialbase.downloader.impls.r rVar = (com.ss.android.socialbase.downloader.impls.r) x5;
            this.tl = rVar.j();
            this.f38782g = rVar.m();
        }
        this.f38787m = gVar;
        this.up = xtVar;
        this.ws = mVar;
        long ws = xtVar.ws();
        this.az = ws;
        this.av = ws;
        if (xtVar.r()) {
            this.f38792w = xtVar.i();
        } else {
            this.f38792w = xtVar.cw(false);
        }
        this.f38784i = xtVar.av();
        this.tj = com.ss.android.socialbase.downloader.j.j.j();
        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
        this.kt = j6;
        if (j6.j("sync_strategy", 0) == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f38781f = z5;
        if (z5) {
            long j7 = j6.j("sync_interval_ms_fg", 5000);
            long j8 = j6.j("sync_interval_ms_bg", 1000);
            this.f38791v = Math.max(j7, 500L);
            this.f38793x = Math.max(j8, 500L);
        } else {
            this.f38791v = 0L;
            this.f38793x = 0L;
        }
        this.ch = j6.xt("monitor_rw") == 1;
        this.mi = com.ss.android.socialbase.downloader.az.j.j(65536);
    }

    public void j(long j6, long j7, long j8) {
        this.az = j6;
        this.av = j6;
        this.f38784i = j7;
        this.f38792w = j8;
    }

    public void j(long j6, long j7) {
        this.f38784i = j6;
        this.f38792w = j7;
    }

    private com.ss.android.socialbase.downloader.oq.xt j(InputStream inputStream) {
        int wq = cw.wq();
        if (this.kt.j("rw_concurrent", 0) == 1 && this.cw.kj() == 1 && this.cw.ka() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.oq.j jVar = new com.ss.android.socialbase.downloader.oq.j(inputStream, wq, this.kt.j("rw_concurrent_max_buffer_count", 4));
                this.f38790s = true;
                return jVar;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
        com.ss.android.socialbase.downloader.oq.cw cwVar = new com.ss.android.socialbase.downloader.oq.cw(inputStream, wq);
        this.f38790s = false;
        return cwVar;
    }

    private void j(boolean z5) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j6 = uptimeMillis - this.gq;
        if (this.f38781f) {
            if (j6 <= (this.tj.xt() ? this.f38791v : this.f38793x)) {
                return;
            }
        } else {
            long j7 = this.az - this.la;
            if (!z5 && !xt(j7, j6)) {
                return;
            }
        }
        tl();
        this.gq = uptimeMillis;
    }

    private void j(vl vlVar) {
        az azVar;
        com.ss.android.socialbase.downloader.ae.xt xtVar;
        vl vlVar2;
        if (vlVar == null) {
            return;
        }
        boolean z5 = vlVar instanceof com.ss.android.socialbase.downloader.cw.up;
        if (z5) {
            azVar = com.ss.android.socialbase.downloader.impls.vl.j(com.ss.android.socialbase.downloader.az.m.xt());
            if (azVar == null) {
                return;
            }
        } else {
            azVar = null;
        }
        az azVar2 = azVar;
        if (this.up.r()) {
            xtVar = this.up.up();
        } else {
            xtVar = this.up;
        }
        if (xtVar != null) {
            xtVar.xt(this.az);
            if (z5 && azVar2 != null) {
                azVar2.j(xtVar.qv(), xtVar.mi(), xtVar.xt(), this.az);
                vlVar2 = vlVar;
            } else {
                vlVar2 = vlVar;
                vlVar2.j(xtVar.qv(), xtVar.mi(), xtVar.xt(), this.az);
            }
            if (xtVar.tl()) {
                if (xtVar.g()) {
                    long oq = xtVar.oq();
                    if (oq > this.az) {
                        if (z5 && azVar2 != null) {
                            azVar2.j(xtVar.qv(), xtVar.xt(), oq);
                            return;
                        } else {
                            vlVar2.j(xtVar.qv(), xtVar.xt(), oq);
                            return;
                        }
                    }
                }
                if (z5 && azVar2 != null) {
                    azVar2.j(xtVar.qv(), xtVar.xt(), this.az);
                    return;
                } else {
                    vlVar2.j(xtVar.qv(), xtVar.xt(), this.az);
                    return;
                }
            }
            return;
        }
        if (this.up.r()) {
            if (z5 && azVar2 != null) {
                azVar2.j(this.up.qv(), this.up.mi(), this.az);
            } else {
                vlVar.j(this.up.qv(), this.up.mi(), this.az);
            }
        }
    }
}
