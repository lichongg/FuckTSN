package com.ss.android.socialbase.downloader.g;

import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw {
    private final Handler cw;

    /* renamed from: j, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.az.tl<String, xt> f38796j;
    private final Handler xt;

    /* renamed from: com.ss.android.socialbase.downloader.g.cw$cw, reason: collision with other inner class name */
    private static class C0782cw {

        /* renamed from: j, reason: collision with root package name */
        private static final cw f38801j = new cw();
    }

    public interface j {
        void j(String str, List<InetAddress> list);
    }

    private static class xt {

        /* renamed from: j, reason: collision with root package name */
        List<InetAddress> f38802j;
        long xt;

        private xt() {
        }
    }

    private cw() {
        this.f38796j = new com.ss.android.socialbase.downloader.az.tl<>(4, 16, false);
        this.xt = new Handler(com.ss.android.socialbase.downloader.g.j.xt.j());
        this.cw = new Handler(com.ss.android.socialbase.downloader.ws.up.j());
    }

    public static cw j() {
        return C0782cw.f38801j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|a|(2:8|(1:(2:11|12)(1:14)))|15|(6:19|20|(3:36|37|38)|(3:28|29|(2:31|32)(1:33))|29|(0)(0))|45|(1:22)|36|37|38|(4:25|28|29|(0)(0))|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
    
        r10 = r2.f38802j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0076, code lost:
    
        com.bytedance.sdk.component.utils.vl.j(r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0035, B:15:0x003d, B:17:0x0054, B:22:0x0066, B:25:0x007b, B:28:0x0082, B:29:0x008a, B:31:0x0091, B:35:0x0088, B:36:0x006c, B:41:0x0076, B:44:0x0060, B:49:0x0097, B:38:0x0070, B:5:0x000b, B:6:0x0013, B:20:0x005a), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void xt(final java.lang.String r8, final com.ss.android.socialbase.downloader.g.cw.j r9, long r10) {
        /*
            r7 = this;
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.az.tl<java.lang.String, com.ss.android.socialbase.downloader.g.cw$xt> r1 = r7.f38796j     // Catch: java.lang.Throwable -> L3b
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.az.tl<java.lang.String, com.ss.android.socialbase.downloader.g.cw$xt> r2 = r7.f38796j     // Catch: java.lang.Throwable -> L95
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L95
            com.ss.android.socialbase.downloader.g.cw$xt r2 = (com.ss.android.socialbase.downloader.g.cw.xt) r2     // Catch: java.lang.Throwable -> L95
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L3d
            com.ss.android.socialbase.downloader.jy.j r1 = com.ss.android.socialbase.downloader.jy.j.cw()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "dns_expire_min"
            r4 = 10
            int r1 = r1.j(r3, r4)     // Catch: java.lang.Throwable -> L3b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3b
            long r5 = r2.xt     // Catch: java.lang.Throwable -> L3b
            long r3 = r3 - r5
            r5 = 60000(0xea60, float:8.4078E-41)
            int r1 = r1 * r5
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L3b
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3d
            if (r9 == 0) goto L94
            java.util.List<java.net.InetAddress> r10 = r2.f38802j     // Catch: java.lang.Throwable -> L3b
            r9.j(r8, r10)     // Catch: java.lang.Throwable -> L3b
            return
        L3b:
            r8 = move-exception
            goto L98
        L3d:
            com.ss.android.socialbase.downloader.g.cw$2 r1 = new com.ss.android.socialbase.downloader.g.cw$2     // Catch: java.lang.Throwable -> L3b
            r1.<init>()     // Catch: java.lang.Throwable -> L3b
            android.os.Handler r3 = r7.cw     // Catch: java.lang.Throwable -> L3b
            r3.postDelayed(r1, r10)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.jy.j r10 = com.ss.android.socialbase.downloader.jy.j.cw()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r11 = "use_host_dns"
            r3 = 1
            int r10 = r10.j(r11, r3)     // Catch: java.lang.Throwable -> L3b
            if (r10 != r3) goto L63
            com.ss.android.socialbase.downloader.g.m r10 = com.ss.android.socialbase.downloader.downloader.cw.tj()     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L63
            java.util.List r10 = r10.j(r0)     // Catch: java.lang.Throwable -> L5f
            goto L64
        L5f:
            r10 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r10)     // Catch: java.lang.Throwable -> L3b
        L63:
            r10 = 0
        L64:
            if (r10 == 0) goto L6c
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L79
        L6c:
            com.ss.android.socialbase.downloader.g.m r11 = com.ss.android.socialbase.downloader.downloader.cw.f()     // Catch: java.lang.Throwable -> L3b
            java.util.List r10 = r11.j(r0)     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r11 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r11)     // Catch: java.lang.Throwable -> L3b
        L79:
            if (r10 == 0) goto L86
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L82
            goto L86
        L82:
            r7.j(r0, r10)     // Catch: java.lang.Throwable -> L3b
            goto L8a
        L86:
            if (r2 == 0) goto L8a
            java.util.List<java.net.InetAddress> r10 = r2.f38802j     // Catch: java.lang.Throwable -> L3b
        L8a:
            android.os.Handler r11 = r7.cw     // Catch: java.lang.Throwable -> L3b
            r11.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L94
            r9.j(r8, r10)     // Catch: java.lang.Throwable -> L3b
        L94:
            return
        L95:
            r8 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L95
            throw r8     // Catch: java.lang.Throwable -> L3b
        L98:
            com.bytedance.sdk.component.utils.vl.j(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.g.cw.xt(java.lang.String, com.ss.android.socialbase.downloader.g.cw$j, long):void");
    }

    public void j(final String str, final j jVar, final long j6) {
        this.xt.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.g.cw.1
            @Override // java.lang.Runnable
            public void run() {
                cw.this.xt(str, jVar, j6);
            }
        });
    }

    private void j(String str, List<InetAddress> list) {
        synchronized (this.f38796j) {
            try {
                xt xtVar = this.f38796j.get(str);
                if (xtVar == null) {
                    xtVar = new xt();
                    this.f38796j.put(str, xtVar);
                }
                xtVar.f38802j = list;
                xtVar.xt = System.currentTimeMillis();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
