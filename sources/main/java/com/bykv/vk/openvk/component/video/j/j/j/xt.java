package com.bykv.vk.openvk.component.video.j.j.j;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements cw {

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, xt> f22988j = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private long f22990m;
    private RandomAccessFile oq;
    private final r qv;

    /* renamed from: r, reason: collision with root package name */
    private File f22991r;
    private File up;
    private xt vl;
    private volatile long xt;
    private final Object cw = new Object();
    private volatile long ae = -1;
    private volatile boolean tl = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f22989g = false;

    private boolean ae() {
        String m6 = m();
        synchronized (xt.class) {
            try {
                HashMap<String, xt> hashMap = f22988j;
                xt xtVar = hashMap.get(m6);
                this.vl = xtVar;
                if (xtVar != null) {
                    return false;
                }
                hashMap.put(m6, this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private long g() {
        return tl() ? this.up.length() : this.f22991r.length();
    }

    private String m() {
        r rVar = this.qv;
        return rVar == null ? "" : rVar.i();
    }

    private boolean tl() {
        return this.up.exists() && this.up.length() > 0;
    }

    private boolean up() {
        RandomAccessFile randomAccessFile = this.oq;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            if (tryLock == null) {
                if (tryLock != null) {
                    try {
                        tryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            try {
                tryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    @Override // com.bykv.vk.openvk.component.video.j.j.j.cw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cw() {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r4.tl     // Catch: java.lang.Throwable -> Lb
            if (r1 != 0) goto Ld
            java.io.RandomAccessFile r1 = r4.oq     // Catch: java.lang.Throwable -> Lb
            r1.close()     // Catch: java.lang.Throwable -> Lb
            goto Ld
        Lb:
            r1 = move-exception
            goto L27
        Ld:
            java.io.File r1 = r4.f22991r     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb
            r1.setLastModified(r2)     // Catch: java.lang.Throwable -> Lb
        L18:
            java.io.File r1 = r4.up     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto L23
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb
            r1.setLastModified(r2)     // Catch: java.lang.Throwable -> Lb
        L23:
            r4.j(r0)
            goto L2f
        L27:
            java.lang.String r2 = "CSJ_MediaDLPlay"
            java.lang.String r3 = "close error"
            com.bykv.vk.openvk.component.video.api.m.cw.xt(r2, r3, r1)     // Catch: java.lang.Throwable -> L3a
            goto L23
        L2f:
            java.lang.Object r1 = r4.cw
            monitor-enter(r1)
            r0 = 1
            r4.tl = r0     // Catch: java.lang.Throwable -> L37
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            return
        L37:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            throw r0
        L3a:
            r1 = move-exception
            r4.j(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.j.j.xt.cw():void");
    }

    @Override // com.bykv.vk.openvk.component.video.j.j.j.cw
    public long r() throws IOException {
        if (!tl()) {
            synchronized (this.cw) {
                int i6 = 0;
                do {
                    try {
                        if (this.xt == -2147483648L) {
                            try {
                                xt xtVar = this.vl;
                                if (xtVar != null) {
                                    this.xt = xtVar.j();
                                }
                                i6 += 15;
                                this.cw.wait(5L);
                            } catch (InterruptedException e6) {
                                vl.j(e6);
                                throw new IOException("total length InterruptException");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } while (i6 <= 10000);
                return -1L;
            }
        }
        this.xt = this.up.length();
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.xt));
        return this.xt;
    }

    public xt(Context context, r rVar) {
        this.xt = -2147483648L;
        this.f22990m = 0L;
        this.oq = null;
        this.qv = rVar;
        try {
            this.f22991r = com.bykv.vk.openvk.component.video.j.up.cw.xt(rVar.up(), rVar.i());
            this.up = com.bykv.vk.openvk.component.video.j.up.cw.cw(rVar.up(), rVar.i());
            if (tl()) {
                this.oq = new RandomAccessFile(this.up, t.f36150k);
            } else {
                this.oq = new RandomAccessFile(this.f22991r, "rw");
            }
            if (!tl()) {
                this.f22990m = this.f22991r.length();
                if (!up()) {
                    com.bykv.vk.openvk.component.video.api.m.cw.xt("CSJ_MediaDLPlay", "no process lock, no download " + m());
                    return;
                }
                synchronized (xt.class) {
                    try {
                        if (ae()) {
                            xt();
                        } else {
                            xt xtVar = this.vl;
                            if (xtVar != null) {
                                this.xt = xtVar.j();
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.m.cw.xt("CSJ_MediaDLPlay", "Error using file ", rVar.av(), " as disc cache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5) {
        String m6 = m();
        synchronized (xt.class) {
            try {
                if (z5) {
                    f22988j.remove(m6);
                } else {
                    HashMap<String, xt> hashMap = f22988j;
                    if (hashMap.get(m6) == this) {
                        hashMap.remove(m6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xt() {
        vl.j jVar;
        if (com.bykv.vk.openvk.component.video.api.cw.cw() != null) {
            jVar = com.bykv.vk.openvk.component.video.api.cw.cw().xt();
        } else {
            jVar = new vl.j("v_cache");
        }
        long mi = this.qv.mi();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        jVar.j(mi, timeUnit).xt(this.qv.kt(), timeUnit).cw(this.qv.tj(), timeUnit);
        com.bytedance.sdk.component.xt.j.vl j6 = jVar.j();
        this.qv.i();
        j6.j(new ws.j().j("RANGE", "bytes=" + this.f22990m + "-").j(this.qv.av()).j().xt()).j(new com.bytedance.sdk.component.xt.j.cw() { // from class: com.bykv.vk.openvk.component.video.j.j.j.xt.1
            /* JADX WARN: Code restructure failed: missing block: B:100:0x0185, code lost:
            
                r4 = r18.f22992j.cw;
             */
            /* JADX WARN: Code restructure failed: missing block: B:101:0x018b, code lost:
            
                monitor-enter(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x0192, code lost:
            
                if (r18.f22992j.tl == false) goto L108;
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x01ff, code lost:
            
                if (com.bykv.vk.openvk.component.video.j.up.cw.j(r18.f22992j.oq, r0, r7, r11) == false) goto L217;
             */
            /* JADX WARN: Code restructure failed: missing block: B:107:0x0201, code lost:
            
                r7 = r7 + r11;
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x0203, code lost:
            
                monitor-exit(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x0208, code lost:
            
                com.bytedance.sdk.component.utils.vl.xt("CSJ_MediaDLPlay", "append error, try again：" + r7 + "  offset = " + r11 + " key= " + r18.f22992j.qv.i() + " fb: " + r10.valid() + " channel " + r9.isOpen());
             */
            /* JADX WARN: Code restructure failed: missing block: B:112:0x024d, code lost:
            
                monitor-exit(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x024e, code lost:
            
                r3.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x0251, code lost:
            
                if (r6 == null) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0253, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:117:0x0259, code lost:
            
                r20.close();
                r2 = r18.f22992j.f22991r.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x026c, code lost:
            
                if (r18.f22992j.f22989g == false) goto L232;
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x0276, code lost:
            
                if (r2 != r18.f22992j.xt) goto L233;
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x027a, code lost:
            
                if (r2 <= r16) goto L234;
             */
            /* JADX WARN: Code restructure failed: missing block: B:123:0x027c, code lost:
            
                r0 = r18.f22992j;
                r0.j(r0.xt);
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0285, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:126:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x0257, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:131:0x0286, code lost:
            
                com.bykv.vk.openvk.component.video.api.m.cw.xt("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:132:0x028d, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:134:0x0194, code lost:
            
                com.bykv.vk.openvk.component.video.api.m.cw.xt("CSJ_MediaDLPlay", "close stream " + r18.f22992j.qv.i());
             */
            /* JADX WARN: Code restructure failed: missing block: B:135:0x01b1, code lost:
            
                monitor-exit(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:137:0x01b2, code lost:
            
                r3.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:138:0x01b5, code lost:
            
                if (r6 == null) goto L96;
             */
            /* JADX WARN: Code restructure failed: missing block: B:139:0x01b7, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:140:0x01bd, code lost:
            
                r20.close();
                r2 = r18.f22992j.f22991r.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:141:0x01d0, code lost:
            
                if (r18.f22992j.f22989g == false) goto L229;
             */
            /* JADX WARN: Code restructure failed: missing block: B:143:0x01da, code lost:
            
                if (r2 != r18.f22992j.xt) goto L230;
             */
            /* JADX WARN: Code restructure failed: missing block: B:145:0x01de, code lost:
            
                if (r2 <= r16) goto L231;
             */
            /* JADX WARN: Code restructure failed: missing block: B:146:0x01e0, code lost:
            
                r0 = r18.f22992j;
                r0.j(r0.xt);
             */
            /* JADX WARN: Code restructure failed: missing block: B:147:0x01e9, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:150:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:151:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:152:0x01bb, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:154:0x01ea, code lost:
            
                com.bykv.vk.openvk.component.video.api.m.cw.xt("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:155:0x01f1, code lost:
            
                return;
             */
            /* JADX WARN: Removed duplicated region for block: B:164:0x0323 A[Catch: all -> 0x02cc, TRY_ENTER, TryCatch #8 {all -> 0x02cc, blocks: (B:164:0x0323, B:166:0x0328, B:167:0x032b, B:169:0x0340, B:173:0x034e, B:174:0x02fc, B:207:0x02c8, B:209:0x02d0, B:210:0x02d3, B:212:0x02e8, B:216:0x02f6), top: B:4:0x0008 }] */
            /* JADX WARN: Removed duplicated region for block: B:166:0x0328 A[Catch: all -> 0x02cc, TryCatch #8 {all -> 0x02cc, blocks: (B:164:0x0323, B:166:0x0328, B:167:0x032b, B:169:0x0340, B:173:0x034e, B:174:0x02fc, B:207:0x02c8, B:209:0x02d0, B:210:0x02d3, B:212:0x02e8, B:216:0x02f6), top: B:4:0x0008 }] */
            @Override // com.bytedance.sdk.component.xt.j.cw
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.xt.j.xt r19, com.bytedance.sdk.component.xt.j.av r20) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 942
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.j.j.xt.AnonymousClass1.onResponse(com.bytedance.sdk.component.xt.j.xt, com.bytedance.sdk.component.xt.j.av):void");
            }

            @Override // com.bytedance.sdk.component.xt.j.cw
            public void onFailure(com.bytedance.sdk.component.xt.j.xt xtVar, IOException iOException) {
                xt.this.f22989g = false;
                xt.this.xt = -1L;
                xt.this.j(true);
            }
        });
    }

    public long j() {
        return this.xt;
    }

    @Override // com.bykv.vk.openvk.component.video.j.j.j.cw
    public int j(long j6, byte[] bArr, int i6, int i7) throws IOException {
        try {
            if (j6 == this.xt) {
                return -1;
            }
            int i8 = 0;
            int i9 = 0;
            while (!this.tl) {
                synchronized (this.cw) {
                    try {
                        if (j6 < g()) {
                            this.oq.seek(j6);
                            i9 = this.oq.read(bArr, i6, i7);
                        } else {
                            i8 += 33;
                            this.cw.wait(33L);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i9 > 0) {
                    return i9;
                }
                if (i8 >= 10000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th2) {
            if (th2 instanceof IOException) {
                throw th2;
            }
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6) throws IOException {
        synchronized (this.cw) {
            if (this.up.exists() && this.up.length() >= j6) {
                this.qv.av();
                this.qv.i();
                return;
            }
            try {
            } finally {
                return;
            }
            if (this.f22991r.renameTo(this.up)) {
                RandomAccessFile randomAccessFile = this.oq;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.tl) {
                    this.oq = new RandomAccessFile(this.up, "rw");
                }
                this.qv.i();
                this.qv.av();
                return;
            }
            throw new IOException("Error renaming file " + this.f22991r + " to " + this.up + " for completion!");
        }
    }
}
