package org.apache.commons.net.bsd;

import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.net.io.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends b {
    public static final int A = 1023;

    /* renamed from: y, reason: collision with root package name */
    public static final int f50544y = 514;

    /* renamed from: z, reason: collision with root package name */
    public static final int f50545z = 512;

    public void j0(String str, String str2, String str3) throws IOException {
        k0(str, str2, str3, false);
    }

    @Override // org.apache.commons.net.bsd.b
    InputStream Z() throws IOException {
        ServerSocket serverSocket;
        int i6 = 1023;
        while (true) {
            if (i6 < 512) {
                serverSocket = null;
                break;
            }
            try {
                serverSocket = this.f50807k.createServerSocket(i6, 1, x());
                break;
            } catch (SocketException unused) {
                i6--;
            }
        }
        if (serverSocket == null) {
            throw new BindException("All ports in use.");
        }
        this.f50805i.write(Integer.toString(serverSocket.getLocalPort()).getBytes("UTF-8"));
        this.f50805i.write(0);
        this.f50805i.flush();
        Socket accept = serverSocket.accept();
        serverSocket.close();
        if (!d0() || Y(accept)) {
            return new h(accept, accept.getInputStream());
        }
        accept.close();
        throw new IOException("Security violation: unexpected connection attempt by " + accept.getInetAddress().getHostAddress());
    }

    @Override // org.apache.commons.net.g
    public void i(String str, int i6, InetAddress inetAddress, int i7) throws SocketException, IOException, IllegalArgumentException, UnknownHostException {
        if (i7 >= 512 && i7 <= 1023) {
            super.i(str, i6, inetAddress, i7);
            return;
        }
        throw new IllegalArgumentException("Invalid port number " + i7);
    }

    public void i0(InetAddress inetAddress, int i6, InetAddress inetAddress2) throws SocketException, BindException, IOException {
        int i7 = 1023;
        while (i7 >= 512) {
            try {
                this.f50801e = this.f50806j.createSocket(inetAddress, i6, inetAddress2, i7);
                break;
            } catch (BindException | SocketException unused) {
                i7--;
            }
        }
        if (i7 < 512) {
            throw new BindException("All ports in use or insufficient permssion.");
        }
        b();
    }

    @Override // org.apache.commons.net.g
    public void l(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws SocketException, IOException, IllegalArgumentException {
        if (i7 >= 512 && i7 <= 1023) {
            super.l(inetAddress, i6, inetAddress2, i7);
            return;
        }
        throw new IllegalArgumentException("Invalid port number " + i7);
    }

    public a() {
        N(514);
    }

    @Override // org.apache.commons.net.g
    public void h(String str, int i6) throws SocketException, IOException, UnknownHostException {
        i0(InetAddress.getByName(str), i6, InetAddress.getLocalHost());
    }

    public void h0(String str, int i6, InetAddress inetAddress) throws SocketException, IOException {
        i0(InetAddress.getByName(str), i6, inetAddress);
    }

    @Override // org.apache.commons.net.g
    public void k(InetAddress inetAddress, int i6) throws SocketException, IOException {
        i0(inetAddress, i6, InetAddress.getLocalHost());
    }

    public void k0(String str, String str2, String str3, boolean z5) throws IOException {
        f0(str, str2, str3, z5);
    }
}
