package com.beizi.ad.internal.i;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class e extends l {

    /* renamed from: a, reason: collision with root package name */
    private final h f12216a;

    /* renamed from: b, reason: collision with root package name */
    private final com.beizi.ad.internal.i.a.b f12217b;

    /* renamed from: c, reason: collision with root package name */
    private b f12218c;

    private String b(d dVar) throws IOException, m {
        String c6 = this.f12216a.c();
        boolean isEmpty = TextUtils.isEmpty(c6);
        int a6 = this.f12217b.d() ? this.f12217b.a() : this.f12216a.a();
        boolean z5 = a6 >= 0;
        boolean z6 = dVar.f12215c;
        long j6 = a6;
        if (z6) {
            j6 -= dVar.f12214b;
        }
        boolean z7 = z5 && z6;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f12215c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z5 ? String.format("Content-Length: %d\n", Long.valueOf(j6)) : "");
        sb.append(z7 ? String.format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f12214b), Integer.valueOf(a6 - 1), Integer.valueOf(a6)) : "");
        sb.append(isEmpty ? "" : String.format("Content-Type: %s\n", c6));
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        return sb.toString();
    }

    public void a(b bVar) {
        this.f12218c = bVar;
    }

    public void a(d dVar, Socket socket) throws IOException, m {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j6 = dVar.f12214b;
        if (a(dVar)) {
            a(bufferedOutputStream, j6);
        } else {
            b(bufferedOutputStream, j6);
        }
    }

    public e(h hVar, com.beizi.ad.internal.i.a.b bVar) {
        super(hVar, bVar);
        this.f12217b = bVar;
        this.f12216a = hVar;
    }

    private boolean a(d dVar) throws m {
        int a6 = this.f12216a.a();
        return ((a6 > 0) && dVar.f12215c && ((float) dVar.f12214b) > ((float) this.f12217b.a()) + (((float) a6) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j6) throws m, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int a6 = a(bArr, j6, 8192);
            if (a6 != -1) {
                outputStream.write(bArr, 0, a6);
                j6 += a6;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void b(OutputStream outputStream, long j6) throws m, IOException {
        h hVar = new h(this.f12216a);
        try {
            hVar.a((int) j6);
            byte[] bArr = new byte[8192];
            while (true) {
                int a6 = hVar.a(bArr);
                if (a6 != -1) {
                    outputStream.write(bArr, 0, a6);
                } else {
                    outputStream.flush();
                    hVar.b();
                    return;
                }
            }
        } catch (Throwable th) {
            hVar.b();
            throw th;
        }
    }

    @Override // com.beizi.ad.internal.i.l
    protected void a(int i6) {
        b bVar = this.f12218c;
        if (bVar != null) {
            bVar.a(this.f12217b.f12199a, this.f12216a.d(), i6);
        }
    }
}
