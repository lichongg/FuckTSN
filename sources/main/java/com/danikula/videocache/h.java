package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class h extends o {

    /* renamed from: n, reason: collision with root package name */
    private static final float f32179n = 0.2f;

    /* renamed from: k, reason: collision with root package name */
    private final k f32180k;

    /* renamed from: l, reason: collision with root package name */
    private final com.danikula.videocache.file.b f32181l;

    /* renamed from: m, reason: collision with root package name */
    private e f32182m;

    private String p(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean q(g gVar) throws ProxyCacheException {
        long length = this.f32180k.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && gVar.f32178c && ((float) gVar.f32177b) > ((float) this.f32181l.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String r(g gVar) throws IOException, ProxyCacheException {
        String d6 = this.f32180k.d();
        boolean isEmpty = TextUtils.isEmpty(d6);
        long available = this.f32181l.isCompleted() ? this.f32181l.available() : this.f32180k.length();
        boolean z5 = available >= 0;
        boolean z6 = gVar.f32178c;
        long j6 = z6 ? available - gVar.f32177b : available;
        boolean z7 = z5 && z6;
        StringBuilder sb = new StringBuilder();
        sb.append(gVar.f32178c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z5 ? p("Content-Length: %d\n", Long.valueOf(j6)) : "");
        sb.append(z7 ? p("Content-Range: bytes %d-%d/%d\n", Long.valueOf(gVar.f32177b), Long.valueOf(available - 1), Long.valueOf(available)) : "");
        sb.append(isEmpty ? "" : p("Content-Type: %s\n", d6));
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        return sb.toString();
    }

    private void u(OutputStream outputStream, long j6) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int j7 = j(bArr, j6, 8192);
            if (j7 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, j7);
                j6 += j7;
            }
        }
    }

    private void v(OutputStream outputStream, long j6) throws ProxyCacheException, IOException {
        k kVar = new k(this.f32180k);
        try {
            kVar.a((int) j6);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = kVar.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    kVar.close();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            kVar.close();
            throw th;
        }
    }

    @Override // com.danikula.videocache.o
    protected void g(int i6) {
        e eVar = this.f32182m;
        if (eVar != null) {
            eVar.a(this.f32181l.f32164b, this.f32180k.e(), i6);
        }
    }

    public void s(g gVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(r(gVar).getBytes("UTF-8"));
        long j6 = gVar.f32177b;
        if (q(gVar)) {
            u(bufferedOutputStream, j6);
        } else {
            v(bufferedOutputStream, j6);
        }
    }

    public void t(e eVar) {
        this.f32182m = eVar;
    }

    public h(k kVar, com.danikula.videocache.file.b bVar) {
        super(kVar, bVar);
        this.f32181l = bVar;
        this.f32180k = kVar;
    }
}
