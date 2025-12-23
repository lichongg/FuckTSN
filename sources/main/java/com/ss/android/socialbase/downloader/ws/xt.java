package com.ss.android.socialbase.downloader.ws;

import com.ss.android.socialbase.downloader.downloader.vl;
import com.ss.android.socialbase.downloader.g.g;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    private static final String f39017j = "xt";
    private final m ae;
    private com.ss.android.socialbase.downloader.ae.xt cw;

    /* renamed from: g, reason: collision with root package name */
    private vl f39018g;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.ae.cw f39019m;
    private volatile boolean oq;
    private volatile boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.up f39020r;
    private g tl;
    private final com.ss.android.socialbase.downloader.ae.r up;
    private boolean vl;
    private com.ss.android.socialbase.downloader.ae.xt xt;

    public xt(com.ss.android.socialbase.downloader.ae.xt xtVar, com.ss.android.socialbase.downloader.ae.r rVar, m mVar) {
        this.vl = false;
        this.cw = xtVar;
        this.up = rVar;
        if (rVar != null) {
            this.f39019m = rVar.j();
        }
        this.ae = mVar;
        this.f39018g = com.ss.android.socialbase.downloader.downloader.cw.x();
        this.cw.j(this);
    }

    public void j(long j6, long j7) {
        com.ss.android.socialbase.downloader.downloader.up upVar = this.f39020r;
        if (upVar == null) {
            return;
        }
        upVar.j(j6, j7);
    }

    public void xt() {
        this.qv = true;
        com.ss.android.socialbase.downloader.downloader.up upVar = this.f39020r;
        if (upVar != null) {
            upVar.cw();
        }
    }

    private String cw() {
        return this.f39019m.ol();
    }

    private void r() {
        g gVar = this.tl;
        if (gVar != null) {
            gVar.r();
            this.tl = null;
        }
    }

    private boolean up() {
        return this.oq || this.qv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0017, code lost:
    
        r3.xt.j(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.ae.xt r0 = r3.cw
            r3.xt = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.ae.xt r1 = r3.xt     // Catch: java.lang.Throwable -> L1d
            r1.j(r3)     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.ae.xt r1 = r3.xt     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.j(r1)     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            com.ss.android.socialbase.downloader.ae.xt r1 = r3.xt     // Catch: java.lang.Throwable -> L1d
            r1.j(r0)     // Catch: java.lang.Throwable -> L1d
            goto L4d
        L1d:
            r1 = move-exception
            goto L5d
        L1f:
            com.ss.android.socialbase.downloader.ae.xt r1 = r3.xt     // Catch: java.lang.Throwable -> L1d
            r1.j(r0)     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.up()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.ws.m r1 = r3.ae     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.ae.xt r2 = r3.xt     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.mi()     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.ae.xt r1 = r1.j(r2)     // Catch: java.lang.Throwable -> L1d
            r3.xt = r1     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.up()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.ae.xt r1 = r3.xt     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L4d
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)     // Catch: java.lang.Throwable -> L1d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.ae.xt r1 = r3.xt
            if (r1 == 0) goto L54
            r1.j(r0)
        L54:
            r3.r()
            com.ss.android.socialbase.downloader.ws.m r0 = r3.ae
            r0.j(r3)
            return
        L5d:
            com.ss.android.socialbase.downloader.ae.xt r2 = r3.xt
            if (r2 == 0) goto L64
            r2.j(r0)
        L64:
            r3.r()
            com.ss.android.socialbase.downloader.ws.m r0 = r3.ae
            r0.j(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.xt.run():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0227, code lost:
    
        if (r2 < 0) goto L166;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0198 A[Catch: all -> 0x0169, j -> 0x016b, TRY_LEAVE, TryCatch #3 {all -> 0x0169, blocks: (B:55:0x013c, B:57:0x0145, B:61:0x0151, B:62:0x0157, B:64:0x016e, B:152:0x017e, B:153:0x018c, B:181:0x0194, B:183:0x0198, B:194:0x01ad, B:195:0x01b0), top: B:31:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[Catch: all -> 0x0169, j -> 0x016b, SYNTHETIC, TRY_LEAVE, TryCatch #3 {all -> 0x0169, blocks: (B:55:0x013c, B:57:0x0145, B:61:0x0151, B:62:0x0157, B:64:0x016e, B:152:0x017e, B:153:0x018c, B:181:0x0194, B:183:0x0198, B:194:0x01ad, B:195:0x01b0), top: B:31:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d8 A[Catch: all -> 0x01c1, TRY_ENTER, TryCatch #1 {all -> 0x01c1, blocks: (B:72:0x01ce, B:74:0x01d8, B:127:0x01de, B:76:0x01e7, B:78:0x01ef, B:108:0x01f5, B:81:0x0200, B:83:0x0204, B:85:0x020c, B:87:0x021d, B:89:0x0243, B:91:0x0249, B:92:0x0256, B:94:0x025e, B:99:0x0250, B:101:0x022c, B:103:0x0238, B:112:0x0269, B:114:0x0271, B:116:0x0279, B:118:0x0281, B:120:0x0289, B:123:0x0292, B:161:0x01b1, B:166:0x01bb, B:171:0x01c5), top: B:71:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0249 A[Catch: all -> 0x01c1, TryCatch #1 {all -> 0x01c1, blocks: (B:72:0x01ce, B:74:0x01d8, B:127:0x01de, B:76:0x01e7, B:78:0x01ef, B:108:0x01f5, B:81:0x0200, B:83:0x0204, B:85:0x020c, B:87:0x021d, B:89:0x0243, B:91:0x0249, B:92:0x0256, B:94:0x025e, B:99:0x0250, B:101:0x022c, B:103:0x0238, B:112:0x0269, B:114:0x0271, B:116:0x0279, B:118:0x0281, B:120:0x0289, B:123:0x0292, B:161:0x01b1, B:166:0x01bb, B:171:0x01c5), top: B:71:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025e A[Catch: all -> 0x01c1, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01c1, blocks: (B:72:0x01ce, B:74:0x01d8, B:127:0x01de, B:76:0x01e7, B:78:0x01ef, B:108:0x01f5, B:81:0x0200, B:83:0x0204, B:85:0x020c, B:87:0x021d, B:89:0x0243, B:91:0x0249, B:92:0x0256, B:94:0x025e, B:99:0x0250, B:101:0x022c, B:103:0x0238, B:112:0x0269, B:114:0x0271, B:116:0x0279, B:118:0x0281, B:120:0x0289, B:123:0x0292, B:161:0x01b1, B:166:0x01bb, B:171:0x01c5), top: B:71:0x01ce, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0250 A[Catch: all -> 0x01c1, TryCatch #1 {all -> 0x01c1, blocks: (B:72:0x01ce, B:74:0x01d8, B:127:0x01de, B:76:0x01e7, B:78:0x01ef, B:108:0x01f5, B:81:0x0200, B:83:0x0204, B:85:0x020c, B:87:0x021d, B:89:0x0243, B:91:0x0249, B:92:0x0256, B:94:0x025e, B:99:0x0250, B:101:0x022c, B:103:0x0238, B:112:0x0269, B:114:0x0271, B:116:0x0279, B:118:0x0281, B:120:0x0289, B:123:0x0292, B:161:0x01b1, B:166:0x01bb, B:171:0x01c5), top: B:71:0x01ce, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j(com.ss.android.socialbase.downloader.ae.xt r28) {
        /*
            Method dump skipped, instructions count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.xt.j(com.ss.android.socialbase.downloader.ae.xt):boolean");
    }

    public xt(com.ss.android.socialbase.downloader.ae.xt xtVar, com.ss.android.socialbase.downloader.ae.r rVar, g gVar, m mVar) {
        this(xtVar, rVar, mVar);
        this.tl = gVar;
    }

    private void j(com.ss.android.socialbase.downloader.ae.xt xtVar, long j6) {
        com.ss.android.socialbase.downloader.ae.xt up = xtVar.r() ? xtVar.up() : xtVar;
        if (up != null) {
            if (up.tl()) {
                this.f39018g.j(up.qv(), up.xt(), j6);
            }
            up.xt(j6);
            this.f39018g.j(up.qv(), up.mi(), up.xt(), j6);
            return;
        }
        if (xtVar.r()) {
            this.f39018g.j(xtVar.qv(), xtVar.mi(), j6);
        }
    }

    public void j() {
        this.oq = true;
        com.ss.android.socialbase.downloader.downloader.up upVar = this.f39020r;
        if (upVar != null) {
            upVar.xt();
        }
    }
}
