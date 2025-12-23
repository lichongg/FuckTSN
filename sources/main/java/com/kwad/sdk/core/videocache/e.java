package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class e extends k {
    private final p aKV;
    private final com.kwad.sdk.core.videocache.a.b aKW;
    private b aKX;

    private String b(d dVar) {
        String Ku = this.aKV.Ku();
        boolean isEmpty = TextUtils.isEmpty(Ku);
        long Kk = this.aKW.isCompleted() ? this.aKW.Kk() : this.aKV.length();
        boolean z5 = Kk >= 0;
        boolean z6 = dVar.aKU;
        long j6 = z6 ? Kk - dVar.aKT : Kk;
        boolean z7 = z5 && z6;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.aKU ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z5 ? format("Content-Length: %d\n", Long.valueOf(j6)) : "");
        sb.append(z7 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aKT), Long.valueOf(Kk - 1), Long.valueOf(Kk)) : "");
        sb.append(isEmpty ? "" : format("Content-Type: %s\n", Ku));
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        return sb.toString();
    }

    public final void a(b bVar) {
        this.aKX = bVar;
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j6 = dVar.aKT;
        if (a(dVar)) {
            a(bufferedOutputStream, j6);
        } else {
            b(bufferedOutputStream, j6);
        }
    }

    @Override // com.kwad.sdk.core.videocache.k
    protected final void dM(int i6) {
        b bVar = this.aKX;
        if (bVar != null) {
            bVar.a(this.aKW.file, i6);
        }
    }

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.aKW = bVar;
        this.aKV = pVar;
    }

    private boolean a(d dVar) {
        long length = this.aKV.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.aKU && ((float) dVar.aKT) > ((float) this.aKW.Kk()) + (((float) length) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j6) {
        byte[] bArr = new byte[1024];
        while (true) {
            int a6 = a(bArr, j6, 1024);
            if (a6 == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, a6);
                j6 += a6;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[Catch: all -> 0x0030, LOOP:0: B:8:0x0024->B:10:0x002b, LOOP_END, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x001d, B:8:0x0024, B:10:0x002b, B:12:0x0032), top: B:6:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.io.OutputStream r3, long r4) {
        /*
            r2 = this;
            com.kwad.sdk.core.videocache.p r0 = r2.aKV
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.h
            if (r1 == 0) goto Lf
            com.kwad.sdk.core.videocache.h r1 = new com.kwad.sdk.core.videocache.h
            com.kwad.sdk.core.videocache.h r0 = (com.kwad.sdk.core.videocache.h) r0
            r1.<init>(r0)
        Ld:
            r0 = r1
            goto L1b
        Lf:
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.j
            if (r1 == 0) goto L1b
            com.kwad.sdk.core.videocache.j r1 = new com.kwad.sdk.core.videocache.j
            com.kwad.sdk.core.videocache.j r0 = (com.kwad.sdk.core.videocache.j) r0
            r1.<init>(r0)
            goto Ld
        L1b:
            int r5 = (int) r4
            long r4 = (long) r5
            r0.aK(r4)     // Catch: java.lang.Throwable -> L30
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L30
        L24:
            int r5 = r0.read(r4)     // Catch: java.lang.Throwable -> L30
            r1 = -1
            if (r5 == r1) goto L32
            r1 = 0
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L30
            goto L24
        L30:
            r3 = move-exception
            goto L39
        L32:
            r3.flush()     // Catch: java.lang.Throwable -> L30
            r0.close()
            return
        L39:
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.e.b(java.io.OutputStream, long):void");
    }
}
