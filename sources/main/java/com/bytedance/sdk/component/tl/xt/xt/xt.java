package com.bytedance.sdk.component.tl.xt.xt;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.tl.j.g;
import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.tl.xt.xt.cw.cw;
import java.util.Comparator;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements g {
    private up ae;

    /* renamed from: m, reason: collision with root package name */
    private volatile Handler f26842m;
    private volatile cw up;

    /* renamed from: j, reason: collision with root package name */
    public static final com.bytedance.sdk.component.tl.xt.xt.j.j f26840j = new com.bytedance.sdk.component.tl.xt.xt.j.j();
    public static final long cw = System.currentTimeMillis();

    /* renamed from: r, reason: collision with root package name */
    public static long f26841r = 0;
    public volatile int xt = 0;
    private final Comparator<com.bytedance.sdk.component.tl.j.xt> tl = new Comparator<com.bytedance.sdk.component.tl.j.xt>() { // from class: com.bytedance.sdk.component.tl.xt.xt.xt.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.sdk.component.tl.j.xt xtVar, com.bytedance.sdk.component.tl.j.xt xtVar2) {
            return xt.this.j(xtVar, xtVar2);
        }
    };

    public boolean cw() {
        return this.xt == 1;
    }

    public boolean r() {
        return this.xt == 2;
    }

    public cw up() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.tl.j.g
    public void xt() {
        up upVar = this.ae;
        if (upVar == null || upVar.r() == null) {
            com.bytedance.sdk.component.tl.xt.cw.cw.xt("discard flush config is null", upVar);
            return;
        }
        com.bytedance.sdk.component.tl.xt.cw.cw.xt("flushMemoryAndDB", upVar);
        r r5 = upVar.r();
        final cw cwVar = this.up;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (cwVar != null) {
                cwVar.j(72, "start_child2");
                return;
            }
            return;
        }
        Executor tl = r5.tl();
        if (tl == null) {
            tl = r5.g();
        }
        if (tl == null) {
            com.bytedance.sdk.component.tl.xt.cw.cw.xt("discard flush executor is null", upVar);
        } else {
            tl.execute(new com.bytedance.sdk.component.tl.xt.up.xt("flush") { // from class: com.bytedance.sdk.component.tl.xt.xt.xt.3
                @Override // java.lang.Runnable
                public void run() {
                    cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(72, "start_child1");
                    }
                }
            });
        }
    }

    public xt(up upVar) {
        this.ae = upVar;
    }

    public void j(int i6) {
        this.xt = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(com.bytedance.sdk.component.tl.j.xt xtVar, com.bytedance.sdk.component.tl.j.xt xtVar2) {
        long j6;
        long j7;
        long j8;
        long j9;
        if (xtVar == null) {
            return xtVar2 == null ? 0 : -1;
        }
        if (xtVar2 == null) {
            return 1;
        }
        if (xtVar.up() == xtVar2.up()) {
            if (xtVar.j() != null) {
                j6 = xtVar.j().j();
                j7 = xtVar.j().xt();
            } else {
                j6 = 0;
                j7 = 0;
            }
            if (xtVar2.j() != null) {
                j9 = xtVar2.j().j();
                j8 = xtVar2.j().xt();
            } else {
                j8 = 0;
                j9 = 0;
            }
            if (j6 == 0 || j9 == 0) {
                return 0;
            }
            long j10 = j6 - j9;
            if (Math.abs(j10) > 2147483647L) {
                return 0;
            }
            if (j10 != 0) {
                return (int) j10;
            }
            if (j7 == 0 || j8 == 0) {
                return 0;
            }
            return (int) (j7 - j8);
        }
        return xtVar.up() - xtVar2.up();
    }

    @Override // com.bytedance.sdk.component.tl.j.g
    public void j() {
        up upVar = this.ae;
        if (upVar == null) {
            return;
        }
        j(upVar.up());
        xt();
    }

    public void j(Handler handler) {
        this.f26842m = handler;
    }

    public boolean j(String str) {
        try {
            if (this.up != null || com.bytedance.sdk.component.tl.xt.j.j(str) || this.ae == null) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.up != null) {
                        return false;
                    }
                    this.up = new cw(this.ae, this);
                    this.up.m();
                    return true;
                } finally {
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw(th.getMessage(), this.ae);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.g
    public void j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        up upVar;
        if (xtVar != null && (upVar = this.ae) != null) {
            String up = upVar.up();
            xtVar.j(System.currentTimeMillis());
            j(up);
            r r5 = this.ae.r();
            cw cwVar = this.up;
            if (cwVar != null) {
                j(r5, xtVar);
                cwVar.j(xtVar, xtVar.up() == 4);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.tl.xt.cw.cw.r("error : log config is null", this.ae);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: Exception -> 0x001a, TRY_LEAVE, TryCatch #0 {Exception -> 0x001a, blocks: (B:38:0x000a, B:40:0x0010, B:13:0x0027, B:21:0x0053), top: B:37:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[Catch: Exception -> 0x0069, TryCatch #1 {Exception -> 0x0069, blocks: (B:6:0x0002, B:14:0x002d, B:16:0x0043, B:19:0x004d, B:28:0x0059), top: B:5:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(final com.bytedance.sdk.component.tl.j.r r9, com.bytedance.sdk.component.tl.j.xt r10) {
        /*
            r8 = this;
            if (r9 == 0) goto L6c
            boolean r0 = r9.cw()     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L6c
            if (r10 == 0) goto L1e
            com.bytedance.sdk.component.tl.xt.r.j.xt r0 = r10.j()     // Catch: java.lang.Exception -> L1a
            if (r0 == 0) goto L1e
            com.bytedance.sdk.component.tl.xt.r.j.xt r10 = r10.j()     // Catch: java.lang.Exception -> L1a
            long r0 = r10.xt()     // Catch: java.lang.Exception -> L1a
        L18:
            r6 = r0
            goto L21
        L1a:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L74
        L1e:
            r0 = 0
            goto L18
        L21:
            r0 = 1
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 != 0) goto L2d
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L1a
            com.bytedance.sdk.component.tl.xt.xt.xt.f26841r = r0     // Catch: java.lang.Exception -> L1a
        L2d:
            com.bytedance.sdk.component.tl.xt.xt.j.j r10 = com.bytedance.sdk.component.tl.xt.xt.xt.f26840j     // Catch: java.lang.Exception -> L69
            java.util.concurrent.atomic.AtomicLong r10 = r10.i()     // Catch: java.lang.Exception -> L69
            com.bytedance.sdk.component.tl.j.up r0 = r8.ae     // Catch: java.lang.Exception -> L69
            r1 = 1
            com.bytedance.sdk.component.tl.xt.cw.xt.j(r10, r1, r0)     // Catch: java.lang.Exception -> L69
            long r0 = r10.get()     // Catch: java.lang.Exception -> L69
            r2 = 200(0xc8, double:9.9E-322)
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 != 0) goto L6c
            android.os.Looper r10 = android.os.Looper.getMainLooper()     // Catch: java.lang.Exception -> L69
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Exception -> L69
            if (r10 != r0) goto L6e
            java.util.concurrent.Executor r10 = r9.tl()     // Catch: java.lang.Exception -> L69
            if (r10 != 0) goto L57
            java.util.concurrent.Executor r10 = r9.g()     // Catch: java.lang.Exception -> L1a
        L57:
            if (r10 == 0) goto L6c
            com.bytedance.sdk.component.tl.xt.xt.xt$2 r2 = new com.bytedance.sdk.component.tl.xt.xt.xt$2     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "report"
            r3 = r8
            r5 = r9
            r2.<init>(r4)     // Catch: java.lang.Exception -> L66
            r10.execute(r2)     // Catch: java.lang.Exception -> L66
            return
        L66:
            r0 = move-exception
        L67:
            r9 = r0
            goto L74
        L69:
            r0 = move-exception
            r3 = r8
            goto L67
        L6c:
            r3 = r8
            goto L77
        L6e:
            r3 = r8
            r5 = r9
            r8.j(r5, r6)     // Catch: java.lang.Exception -> L66
            return
        L74:
            com.bytedance.sdk.component.utils.vl.j(r9)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.xt.xt.j(com.bytedance.sdk.component.tl.j.r, com.bytedance.sdk.component.tl.j.xt):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(r rVar, long j6) {
        cw cwVar = this.up;
        if (rVar == null || cwVar == null) {
            return;
        }
        com.bytedance.sdk.component.tl.xt.xt.j.j jVar = f26840j;
        cwVar.j(rVar.j(jVar.j(j6, this.ae)), true);
        jVar.m();
    }
}
