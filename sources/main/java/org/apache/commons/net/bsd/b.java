package org.apache.commons.net.bsd;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.commons.net.g;
import org.apache.commons.net.io.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends g {

    /* renamed from: w, reason: collision with root package name */
    protected static final char f50546w = 0;

    /* renamed from: x, reason: collision with root package name */
    public static final int f50547x = 512;

    /* renamed from: u, reason: collision with root package name */
    private boolean f50548u;

    /* renamed from: v, reason: collision with root package name */
    protected InputStream f50549v = null;

    public void e0(String str, String str2, String str3) throws IOException {
        f0(str, str2, str3, false);
    }

    public void f0(String str, String str2, String str3, boolean z5) throws IOException {
        if (z5) {
            this.f50549v = Z();
        } else {
            this.f50805i.write(0);
        }
        this.f50805i.write(str.getBytes(q()));
        this.f50805i.write(0);
        this.f50805i.write(str2.getBytes(q()));
        this.f50805i.write(0);
        this.f50805i.write(str3.getBytes(q()));
        this.f50805i.write(0);
        this.f50805i.flush();
        int read = this.f50804h.read();
        if (read <= 0) {
            if (read < 0) {
                throw new IOException("Server closed connection.");
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read2 = this.f50804h.read();
            if (read2 == -1 || read2 == 10) {
                break;
            } else {
                sb.append((char) read2);
            }
        }
        throw new IOException(sb.toString());
    }

    InputStream Z() throws IOException {
        ServerSocket createServerSocket = this.f50807k.createServerSocket(0, 1, x());
        this.f50805i.write(Integer.toString(createServerSocket.getLocalPort()).getBytes("UTF-8"));
        this.f50805i.write(0);
        this.f50805i.flush();
        Socket accept = createServerSocket.accept();
        createServerSocket.close();
        if (!this.f50548u || Y(accept)) {
            return new h(accept, accept.getInputStream());
        }
        accept.close();
        throw new IOException("Security violation: unexpected connection attempt by " + accept.getInetAddress().getHostAddress());
    }

    public InputStream a0() {
        return this.f50549v;
    }

    public InputStream b0() {
        return this.f50804h;
    }

    public OutputStream c0() {
        return this.f50805i;
    }

    public final boolean d0() {
        return this.f50548u;
    }

    public final void g0(boolean z5) {
        this.f50548u = z5;
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        InputStream inputStream = this.f50549v;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f50549v = null;
        super.n();
    }

    public b() {
        N(512);
    }
}
