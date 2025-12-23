package com.bytedance.sdk.component.cw.xt.j.up;

import android.os.SystemClock;
import com.bytedance.sdk.component.cw.xt.j.up.tl;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    static final ExecutorService f26228j = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.cw.xt.j.cw.j("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean mi = true;
    int ae;
    final oq av;
    final Socket az;
    final xt cw;

    /* renamed from: f, reason: collision with root package name */
    private int f26229f;

    /* renamed from: g, reason: collision with root package name */
    final jy f26230g;

    /* renamed from: i, reason: collision with root package name */
    final cw f26231i;
    final ws jy;
    private final ExecutorService kt;

    /* renamed from: m, reason: collision with root package name */
    int f26232m;
    long qv;
    private Map<Integer, vl> tj;
    boolean tl;
    final String up;

    /* renamed from: w, reason: collision with root package name */
    final Set<Integer> f26234w;
    boolean ws;
    final boolean xt;

    /* renamed from: r, reason: collision with root package name */
    final Map<Integer, g> f26233r = new LinkedHashMap();
    long oq = 0;
    ws vl = new ws();

    class cw extends com.bytedance.sdk.component.cw.xt.j.xt implements tl.xt {

        /* renamed from: j, reason: collision with root package name */
        final tl f26251j;

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(boolean z5, int i6, com.bytedance.sdk.component.cw.j.up upVar, int i7) throws IOException {
            if (ae.this.r(i6)) {
                ae.this.j(i6, upVar, i7, z5);
                return;
            }
            g j6 = ae.this.j(i6);
            if (j6 == null) {
                ae.this.j(i6, com.bytedance.sdk.component.cw.xt.j.up.xt.PROTOCOL_ERROR);
                upVar.tl(i7);
            } else {
                j6.j(upVar, i7);
                if (z5) {
                    j6.g();
                }
            }
        }

        cw(tl tlVar) {
            super("OkHttp %s", ae.this.up);
            this.f26251j = tlVar;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.xt
        protected void cw() {
            com.bytedance.sdk.component.cw.xt.j.up.xt xtVar;
            ae aeVar;
            com.bytedance.sdk.component.cw.xt.j.up.xt xtVar2 = com.bytedance.sdk.component.cw.xt.j.up.xt.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f26251j.j(this);
                        while (this.f26251j.j(false, (tl.xt) this)) {
                        }
                    } catch (IOException unused) {
                    } catch (NullPointerException unused2) {
                    } catch (Throwable th) {
                        th = th;
                        try {
                            ae.this.j(xtVar2, xtVar2);
                        } catch (Exception unused3) {
                        }
                        com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26251j);
                        throw th;
                    }
                    try {
                        ae.this.j(com.bytedance.sdk.component.cw.xt.j.up.xt.NO_ERROR, com.bytedance.sdk.component.cw.xt.j.up.xt.CANCEL);
                    } catch (IOException unused4) {
                        xtVar = com.bytedance.sdk.component.cw.xt.j.up.xt.PROTOCOL_ERROR;
                        aeVar = ae.this;
                        aeVar.j(xtVar, xtVar);
                        com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26251j);
                    } catch (NullPointerException unused5) {
                        xtVar = com.bytedance.sdk.component.cw.xt.j.up.xt.PROTOCOL_ERROR;
                        aeVar = ae.this;
                        aeVar.j(xtVar, xtVar);
                        com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26251j);
                    }
                } catch (Exception unused6) {
                }
                com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26251j);
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(boolean z5, int i6, int i7, List<com.bytedance.sdk.component.cw.xt.j.up.cw> list) {
            if (ae.this.r(i6)) {
                ae.this.j(i6, list, z5);
                return;
            }
            synchronized (ae.this) {
                try {
                    g j6 = ae.this.j(i6);
                    if (j6 == null) {
                        ae aeVar = ae.this;
                        if (aeVar.tl) {
                            return;
                        }
                        if (i6 <= aeVar.f26232m) {
                            return;
                        }
                        if (i6 % 2 == aeVar.ae % 2) {
                            return;
                        }
                        final g gVar = new g(i6, ae.this, false, z5, list);
                        ae aeVar2 = ae.this;
                        aeVar2.f26232m = i6;
                        aeVar2.f26233r.put(Integer.valueOf(i6), gVar);
                        try {
                            ae.f26228j.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s stream %d", new Object[]{ae.this.up, Integer.valueOf(i6)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.cw.1
                                @Override // com.bytedance.sdk.component.cw.xt.j.xt
                                public void cw() {
                                    try {
                                        ae.this.cw.j(gVar);
                                    } catch (IOException e6) {
                                        com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(4, "Http2Connection.Listener failure for " + ae.this.up, e6);
                                        try {
                                            gVar.j(com.bytedance.sdk.component.cw.xt.j.up.xt.PROTOCOL_ERROR);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            });
                        } catch (Throwable unused) {
                        }
                        return;
                    }
                    j6.j(list);
                    if (z5) {
                        j6.g();
                    }
                } finally {
                }
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(int i6, com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) {
            if (ae.this.r(i6)) {
                ae.this.cw(i6, xtVar);
                return;
            }
            g xt = ae.this.xt(i6);
            if (xt != null) {
                xt.cw(xtVar);
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(boolean z5, ws wsVar) {
            g[] gVarArr;
            long j6;
            int i6;
            synchronized (ae.this) {
                try {
                    int r5 = ae.this.jy.r();
                    if (z5) {
                        ae.this.jy.j();
                    }
                    ae.this.jy.j(wsVar);
                    j(wsVar);
                    int r6 = ae.this.jy.r();
                    gVarArr = null;
                    if (r6 == -1 || r6 == r5) {
                        j6 = 0;
                    } else {
                        j6 = r6 - r5;
                        ae aeVar = ae.this;
                        if (!aeVar.ws) {
                            aeVar.j(j6);
                            ae.this.ws = true;
                        }
                        if (!ae.this.f26233r.isEmpty()) {
                            gVarArr = (g[]) ae.this.f26233r.values().toArray(new g[ae.this.f26233r.size()]);
                        }
                    }
                    try {
                        ae.f26228j.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s settings", ae.this.up) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.cw.2
                            @Override // com.bytedance.sdk.component.cw.xt.j.xt
                            public void cw() {
                                ae aeVar2 = ae.this;
                                aeVar2.cw.j(aeVar2);
                            }
                        });
                    } catch (Throwable unused) {
                    }
                } finally {
                }
            }
            if (gVarArr == null || j6 == 0) {
                return;
            }
            for (g gVar : gVarArr) {
                synchronized (gVar) {
                    gVar.j(j6);
                }
            }
        }

        private void j(final ws wsVar) {
            try {
                ae.f26228j.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s ACK Settings", new Object[]{ae.this.up}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.cw.3
                    @Override // com.bytedance.sdk.component.cw.xt.j.xt
                    public void cw() {
                        try {
                            ae.this.av.j(wsVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(boolean z5, int i6, int i7) {
            if (z5) {
                vl cw = ae.this.cw(i6);
                if (cw != null) {
                    cw.xt();
                    return;
                }
                return;
            }
            ae.this.j(true, i6, i7, (vl) null);
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(int i6, com.bytedance.sdk.component.cw.xt.j.up.xt xtVar, com.bytedance.sdk.component.cw.j.m mVar) {
            g[] gVarArr;
            synchronized (ae.this) {
                gVarArr = (g[]) ae.this.f26233r.values().toArray(new g[ae.this.f26233r.size()]);
                ae.this.tl = true;
            }
            for (g gVar : gVarArr) {
                if (gVar.j() > i6 && gVar.cw()) {
                    gVar.cw(com.bytedance.sdk.component.cw.xt.j.up.xt.REFUSED_STREAM);
                    ae.this.xt(gVar.j());
                }
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(int i6, long j6) {
            if (i6 == 0) {
                synchronized (ae.this) {
                    ae aeVar = ae.this;
                    aeVar.qv += j6;
                    aeVar.notifyAll();
                }
                return;
            }
            g j7 = ae.this.j(i6);
            if (j7 != null) {
                synchronized (j7) {
                    j7.j(j6);
                }
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.tl.xt
        public void j(int i6, int i7, List<com.bytedance.sdk.component.cw.xt.j.up.cw> list) {
            ae.this.j(i7, list);
        }
    }

    public static abstract class xt {

        /* renamed from: m, reason: collision with root package name */
        public static final xt f26258m = new xt() { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.xt.1
            @Override // com.bytedance.sdk.component.cw.xt.j.up.ae.xt
            public void j(g gVar) throws IOException {
                gVar.j(com.bytedance.sdk.component.cw.xt.j.up.xt.REFUSED_STREAM);
            }
        };

        public void j(ae aeVar) {
        }

        public abstract void j(g gVar) throws IOException;
    }

    synchronized vl cw(int i6) {
        Map<Integer, vl> map = this.tj;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i6));
    }

    synchronized g j(int i6) {
        return this.f26233r.get(Integer.valueOf(i6));
    }

    boolean r(int i6) {
        return i6 != 0 && (i6 & 1) == 0;
    }

    synchronized g xt(int i6) {
        g remove;
        remove = this.f26233r.remove(Integer.valueOf(i6));
        notifyAll();
        return remove;
    }

    public static class j {
        boolean ae;
        com.bytedance.sdk.component.cw.j.up cw;

        /* renamed from: j, reason: collision with root package name */
        Socket f26255j;

        /* renamed from: r, reason: collision with root package name */
        com.bytedance.sdk.component.cw.j.r f26257r;
        String xt;
        xt up = xt.f26258m;

        /* renamed from: m, reason: collision with root package name */
        jy f26256m = jy.f26273j;

        public j j(Socket socket, String str, com.bytedance.sdk.component.cw.j.up upVar, com.bytedance.sdk.component.cw.j.r rVar) {
            this.f26255j = socket;
            this.xt = str;
            this.cw = upVar;
            this.f26257r = rVar;
            return this;
        }

        public j(boolean z5) {
            this.ae = z5;
        }

        public j j(xt xtVar) {
            this.up = xtVar;
            return this;
        }

        public ae j() {
            return new ae(this);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j(com.bytedance.sdk.component.cw.xt.j.up.xt.NO_ERROR, com.bytedance.sdk.component.cw.xt.j.up.xt.CANCEL);
    }

    public void cw() throws IOException {
        j(true);
    }

    public synchronized int j() {
        return this.jy.cw(Integer.MAX_VALUE);
    }

    public synchronized boolean r() {
        return this.tl;
    }

    ae(j jVar) {
        int i6;
        ws wsVar = new ws();
        this.jy = wsVar;
        this.ws = false;
        this.f26234w = new LinkedHashSet();
        this.f26230g = jVar.f26256m;
        boolean z5 = jVar.ae;
        this.xt = z5;
        this.cw = jVar.up;
        if (z5) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        this.ae = i6;
        if (z5) {
            this.ae = i6 + 2;
        }
        this.f26229f = z5 ? 1 : 2;
        if (z5) {
            this.vl.j(7, 16777216);
        }
        String str = jVar.xt;
        this.up = str;
        this.kt = new com.bytedance.sdk.component.oq.r.r(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.cw.xt.j.cw.j(com.bytedance.sdk.component.cw.xt.j.cw.j("OkHttp %s Push Observer", str), true));
        wsVar.j(7, 65535);
        wsVar.j(5, 16384);
        this.qv = wsVar.r();
        this.az = jVar.f26255j;
        this.av = new oq(jVar.f26257r, z5);
        this.f26231i = new cw(new tl(jVar.cw, z5));
    }

    void cw(final int i6, final com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) {
        this.kt.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s Push Reset[%s]", new Object[]{this.up, Integer.valueOf(i6)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.7
            @Override // com.bytedance.sdk.component.cw.xt.j.xt
            public void cw() {
                synchronized (ae.this) {
                    ae.this.f26234w.remove(Integer.valueOf(i6));
                }
            }
        });
    }

    public g j(List<com.bytedance.sdk.component.cw.xt.j.up.cw> list, boolean z5) throws IOException {
        return xt(0, list, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[Catch: all -> 0x002b, TryCatch #3 {all -> 0x002b, blocks: (B:12:0x0015, B:14:0x001a, B:16:0x0022, B:20:0x002f, B:22:0x0035, B:23:0x003e, B:44:0x006e, B:39:0x0068, B:40:0x006d), top: B:4:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041 A[Catch: all -> 0x0047, TRY_ENTER, TryCatch #2 {all -> 0x0047, blocks: (B:25:0x0041, B:26:0x0053, B:31:0x004a, B:33:0x004e, B:34:0x005c, B:35:0x0063, B:49:0x0073, B:45:0x006f), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004a A[Catch: all -> 0x0047, TryCatch #2 {all -> 0x0047, blocks: (B:25:0x0041, B:26:0x0053, B:31:0x004a, B:33:0x004e, B:34:0x005c, B:35:0x0063, B:49:0x0073, B:45:0x006f), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.component.cw.xt.j.up.g xt(int r10, java.util.List<com.bytedance.sdk.component.cw.xt.j.up.cw> r11, boolean r12) throws java.io.IOException {
        /*
            r9 = this;
            r3 = r12 ^ 1
            com.bytedance.sdk.component.cw.xt.j.up.oq r6 = r9.av
            monitor-enter(r6)
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L70
            boolean r0 = r9.tl     // Catch: java.lang.Throwable -> L64
            if (r0 != 0) goto L67
            int r1 = r9.ae     // Catch: java.lang.Throwable -> L64
            int r0 = r1 + 2
            r9.ae = r0     // Catch: java.lang.Throwable -> L64
            com.bytedance.sdk.component.cw.xt.j.up.g r0 = new com.bytedance.sdk.component.cw.xt.j.up.g     // Catch: java.lang.Throwable -> L64
            r4 = 0
            r2 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2b
            if (r12 == 0) goto L2e
            long r11 = r2.qv     // Catch: java.lang.Throwable -> L2b
            r7 = 0
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 == 0) goto L2e
            long r11 = r0.xt     // Catch: java.lang.Throwable -> L2b
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 != 0) goto L29
            goto L2e
        L29:
            r11 = 0
            goto L2f
        L2b:
            r0 = move-exception
        L2c:
            r10 = r0
            goto L6e
        L2e:
            r11 = 1
        L2f:
            boolean r12 = r0.xt()     // Catch: java.lang.Throwable -> L2b
            if (r12 == 0) goto L3e
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.cw.xt.j.up.g> r12 = r2.f26233r     // Catch: java.lang.Throwable -> L2b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L2b
            r12.put(r4, r0)     // Catch: java.lang.Throwable -> L2b
        L3e:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L2b
            if (r10 != 0) goto L4a
            com.bytedance.sdk.component.cw.xt.j.up.oq r12 = r2.av     // Catch: java.lang.Throwable -> L47
            r12.j(r3, r1, r10, r5)     // Catch: java.lang.Throwable -> L47
            goto L53
        L47:
            r0 = move-exception
        L48:
            r10 = r0
            goto L73
        L4a:
            boolean r12 = r2.xt     // Catch: java.lang.Throwable -> L47
            if (r12 != 0) goto L5c
            com.bytedance.sdk.component.cw.xt.j.up.oq r12 = r2.av     // Catch: java.lang.Throwable -> L47
            r12.j(r10, r1, r5)     // Catch: java.lang.Throwable -> L47
        L53:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L47
            if (r11 == 0) goto L5b
            com.bytedance.sdk.component.cw.xt.j.up.oq r10 = r2.av
            r10.xt()
        L5b:
            return r0
        L5c:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L47
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L47
            throw r10     // Catch: java.lang.Throwable -> L47
        L64:
            r0 = move-exception
            r2 = r9
            goto L2c
        L67:
            r2 = r9
            com.bytedance.sdk.component.cw.xt.j.up.j r10 = new com.bytedance.sdk.component.cw.xt.j.up.j     // Catch: java.lang.Throwable -> L2b
            r10.<init>()     // Catch: java.lang.Throwable -> L2b
            throw r10     // Catch: java.lang.Throwable -> L2b
        L6e:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L2b
            throw r10     // Catch: java.lang.Throwable -> L47
        L70:
            r0 = move-exception
            r2 = r9
            goto L48
        L73:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L47
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.up.ae.xt(int, java.util.List, boolean):com.bytedance.sdk.component.cw.xt.j.up.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.av.cw());
        r6 = r3;
        r8.qv -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(int r9, boolean r10, com.bytedance.sdk.component.cw.j.cw r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            com.bytedance.sdk.component.cw.xt.j.up.oq r12 = r8.av
            r12.j(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.qv     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.cw.xt.j.up.g> r3 = r8.f26233r     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L5e
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            com.bytedance.sdk.component.cw.xt.j.up.oq r3 = r8.av     // Catch: java.lang.Throwable -> L28
            int r3 = r3.cw()     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.qv     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.qv = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.bytedance.sdk.component.cw.xt.j.up.oq r4 = r8.av
            if (r10 == 0) goto L53
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r4.j(r5, r9, r11, r3)
            goto Ld
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.up.ae.j(int, boolean, com.bytedance.sdk.component.cw.j.cw, long):void");
    }

    void j(long j6) {
        this.qv += j6;
        if (j6 > 0) {
            notifyAll();
        }
    }

    void j(final int i6, final com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) {
        try {
            f26228j.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s stream %d", new Object[]{this.up, Integer.valueOf(i6)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.1
                @Override // com.bytedance.sdk.component.cw.xt.j.xt
                public void cw() {
                    try {
                        ae.this.xt(i6, xtVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void j(final int i6, final long j6) {
        try {
            f26228j.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp Window Update %s stream %d", new Object[]{this.up, Integer.valueOf(i6)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.2
                @Override // com.bytedance.sdk.component.cw.xt.j.xt
                public void cw() {
                    try {
                        ae.this.av.j(i6, j6);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void j(final boolean z5, final int i6, final int i7, final vl vlVar) {
        try {
            f26228j.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s ping %08x%08x", new Object[]{this.up, Integer.valueOf(i6), Integer.valueOf(i7)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.3
                @Override // com.bytedance.sdk.component.cw.xt.j.xt
                public void cw() {
                    try {
                        ae.this.xt(z5, i6, i7, vlVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void xt(int i6, com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) throws IOException {
        this.av.j(i6, xtVar);
    }

    public void j(com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) throws IOException {
        synchronized (this.av) {
            synchronized (this) {
                if (this.tl) {
                    return;
                }
                this.tl = true;
                this.av.j(this.f26232m, xtVar, com.bytedance.sdk.component.cw.xt.j.cw.f26163j);
            }
        }
    }

    void xt(boolean z5, int i6, int i7, vl vlVar) throws IOException {
        synchronized (this.av) {
            if (vlVar != null) {
                try {
                    vlVar.j();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.av.j(z5, i6, i7);
        }
    }

    public void xt() throws IOException {
        this.av.xt();
    }

    void j(com.bytedance.sdk.component.cw.xt.j.up.xt xtVar, com.bytedance.sdk.component.cw.xt.j.up.xt xtVar2) throws IOException {
        g[] gVarArr;
        if (!mi && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        vl[] vlVarArr = null;
        try {
            j(xtVar);
            e = null;
        } catch (IOException e6) {
            e = e6;
        }
        synchronized (this) {
            try {
                if (this.f26233r.isEmpty()) {
                    gVarArr = null;
                } else {
                    gVarArr = (g[]) this.f26233r.values().toArray(new g[this.f26233r.size()]);
                    this.f26233r.clear();
                }
                Map<Integer, vl> map = this.tj;
                if (map != null) {
                    vl[] vlVarArr2 = (vl[]) map.values().toArray(new vl[this.tj.size()]);
                    this.tj = null;
                    vlVarArr = vlVarArr2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                try {
                    gVar.j(xtVar2);
                } catch (IOException e7) {
                    if (e != null) {
                        e = e7;
                    }
                }
            }
        }
        if (vlVarArr != null) {
            for (vl vlVar : vlVarArr) {
                vlVar.cw();
            }
        }
        try {
            this.av.close();
        } catch (IOException e8) {
            if (e == null) {
                e = e8;
            }
        }
        try {
            this.az.close();
        } catch (IOException e9) {
            e = e9;
        }
        if (e != null) {
            throw e;
        }
    }

    void j(boolean z5) throws IOException {
        if (z5) {
            this.av.j();
            this.av.xt(this.vl);
            if (this.vl.r() != 65535) {
                this.av.j(0, r5 - 65535);
            }
        }
        com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(this.f26231i, "Http2Connection");
        cwVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        cwVar.start();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:22:0x0047
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    void j(final int r8, final java.util.List<com.bytedance.sdk.component.cw.xt.j.up.cw> r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Set<java.lang.Integer> r0 = r7.f26234w     // Catch: java.lang.Throwable -> L42
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L42
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L18
            com.bytedance.sdk.component.cw.xt.j.up.xt r9 = com.bytedance.sdk.component.cw.xt.j.up.xt.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r7.j(r8, r9)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r8 = r0
            r2 = r7
            goto L45
        L18:
            java.util.Set<java.lang.Integer> r0 = r7.f26234w     // Catch: java.lang.Throwable -> L42
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L42
            r0.add(r1)     // Catch: java.lang.Throwable -> L42
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.ExecutorService r0 = r7.kt
            com.bytedance.sdk.component.cw.xt.j.up.ae$4 r1 = new com.bytedance.sdk.component.cw.xt.j.up.ae$4
            java.lang.String r3 = "OkHttp %s Push Request[%s]"
            java.lang.String r2 = r7.up
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r2
            r2 = 1
            r5[r2] = r4
            r2 = r7
            r6 = r9
            r4 = r5
            r5 = r8
            r1.<init>(r3, r4)
            r0.execute(r1)
            return
        L42:
            r0 = move-exception
            r2 = r7
        L44:
            r8 = r0
        L45:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L47
            throw r8
        L47:
            r0 = move-exception
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.up.ae.j(int, java.util.List):void");
    }

    void j(final int i6, final List<com.bytedance.sdk.component.cw.xt.j.up.cw> list, final boolean z5) {
        this.kt.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s Push Headers[%s]", new Object[]{this.up, Integer.valueOf(i6)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.5
            @Override // com.bytedance.sdk.component.cw.xt.j.xt
            public void cw() {
                boolean j6 = ae.this.f26230g.j(i6, list, z5);
                if (j6) {
                    try {
                        ae.this.av.j(i6, com.bytedance.sdk.component.cw.xt.j.up.xt.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (j6 || z5) {
                    synchronized (ae.this) {
                        ae.this.f26234w.remove(Integer.valueOf(i6));
                    }
                }
            }
        });
    }

    void j(final int i6, com.bytedance.sdk.component.cw.j.up upVar, final int i7, final boolean z5) throws IOException {
        final com.bytedance.sdk.component.cw.j.cw cwVar = new com.bytedance.sdk.component.cw.j.cw();
        long j6 = i7;
        upVar.j(j6);
        upVar.j(cwVar, j6);
        if (cwVar.xt() == j6) {
            this.kt.execute(new com.bytedance.sdk.component.cw.xt.j.xt("OkHttp %s Push Data[%s]", new Object[]{this.up, Integer.valueOf(i6)}) { // from class: com.bytedance.sdk.component.cw.xt.j.up.ae.6
                @Override // com.bytedance.sdk.component.cw.xt.j.xt
                public void cw() {
                    try {
                        boolean j7 = ae.this.f26230g.j(i6, cwVar, i7, z5);
                        if (j7) {
                            ae.this.av.j(i6, com.bytedance.sdk.component.cw.xt.j.up.xt.CANCEL);
                        }
                        if (j7 || z5) {
                            synchronized (ae.this) {
                                ae.this.f26234w.remove(Integer.valueOf(i6));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(cwVar.xt() + " != " + i7);
    }
}
