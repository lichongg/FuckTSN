package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private final String aca;
    private final int amZ;
    private final f anW;
    private final int anY;
    private final long anh;
    long ani;
    private final long anj;
    private final com.kwad.framework.filedownloader.b.a ano;
    private final boolean anw;
    private final c aoo;
    private final com.kwad.framework.filedownloader.a.b aop;
    private com.kwad.framework.filedownloader.e.a aoq;
    private volatile long aor;
    private volatile long aos;
    private final long contentLength;
    private volatile boolean nf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        String aca;
        Boolean anT;
        f anW;
        Integer anf;
        com.kwad.framework.filedownloader.download.a ang;
        Integer aoa;
        com.kwad.framework.filedownloader.a.b aop;
        c aot;

        public final a a(c cVar) {
            this.aot = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.anW = fVar;
            return this;
        }

        public final a bv(String str) {
            this.aca = str;
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.ang = aVar;
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.aop = bVar;
            return this;
        }

        public final e yG() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.anT == null || (bVar = this.aop) == null || (aVar = this.ang) == null || this.anW == null || this.aca == null || (num = this.anf) == null || this.aoa == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.aot, num.intValue(), this.aoa.intValue(), this.anT.booleanValue(), this.anW, this.aca, (byte) 0);
        }

        public final a bO(int i6) {
            this.aoa = Integer.valueOf(i6);
            return this;
        }

        public final a bP(int i6) {
            this.anf = Integer.valueOf(i6);
            return this;
        }

        public final a bi(boolean z5) {
            this.anT = Boolean.valueOf(z5);
            return this;
        }
    }

    /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i6, int i7, boolean z5, f fVar, String str, byte b6) {
        this(bVar, aVar, cVar, i6, i7, z5, fVar, str);
    }

    public final void pause() {
        this.nf = true;
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i6, int i7, boolean z5, f fVar, String str) {
        this.aor = 0L;
        this.aos = 0L;
        this.anW = fVar;
        this.aca = str;
        this.aop = bVar;
        this.anw = z5;
        this.aoo = cVar;
        this.anY = i7;
        this.amZ = i6;
        this.ano = b.yc().ye();
        this.anh = aVar.anh;
        this.anj = aVar.anj;
        this.ani = aVar.ani;
        this.contentLength = aVar.contentLength;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0141, code lost:
    
        if (r5 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0143, code lost:
    
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0146, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.b.closeQuietly(r5);
        r4 = r19.ani - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0153, code lost:
    
        if (r2 == (-1)) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0157, code lost:
    
        if (r2 != r4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015a, code lost:
    
        r4 = java.lang.Long.valueOf(r4);
        r2 = java.lang.Long.valueOf(r2);
        r3 = java.lang.Long.valueOf(r19.anh);
        r5 = java.lang.Long.valueOf(r19.anj);
        r9 = java.lang.Long.valueOf(r19.ani);
        r6 = java.lang.Long.valueOf(r6);
        r7 = new java.lang.Object[6];
        r7[0] = r4;
        r7[r15] = r2;
        r7[2] = r3;
        r7[r17] = r5;
        r7[r18] = r9;
        r7[r14] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0194, code lost:
    
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0195, code lost:
    
        r19.anW.a(r19.aoo, r19.anh, r19.anj);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a0, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.e.run():void");
    }

    private void sync() {
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aoq.zw();
            if (this.aoo != null) {
                this.ano.a(this.amZ, this.anY, this.ani);
            } else {
                this.anW.yo();
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.amZ), Integer.valueOf(this.anY), Long.valueOf(this.ani), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        } catch (IOException e6) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e6);
            }
        }
    }

    private void yF() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.ani - this.aor, elapsedRealtime - this.aos)) {
            sync();
            this.aor = this.ani;
            this.aos = elapsedRealtime;
        }
    }
}
