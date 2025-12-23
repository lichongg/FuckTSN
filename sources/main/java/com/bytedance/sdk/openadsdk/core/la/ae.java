package com.bytedance.sdk.openadsdk.core.la;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends j {
    private static final String[] xt = {"TLSv1.2"};
    private final xt cw;

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return j(this.f29435j.createSocket());
    }

    private Socket j(Socket socket) {
        this.cw.j("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        return j(this.f29435j.createSocket(socket, str, i6, z5));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f29435j.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f29435j.getSupportedCipherSuites();
    }

    public String toString() {
        return "Tls12SocketFactory";
    }

    public ae(SSLSocketFactory sSLSocketFactory, xt xtVar) {
        this.f29435j = sSLSocketFactory;
        this.cw = xtVar;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws IOException {
        return j(this.f29435j.createSocket(str, i6));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws IOException {
        return j(this.f29435j.createSocket(str, i6, inetAddress, i7));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        return j(this.f29435j.createSocket(inetAddress, i6));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        return j(this.f29435j.createSocket(inetAddress, i6, inetAddress2, i7));
    }
}
