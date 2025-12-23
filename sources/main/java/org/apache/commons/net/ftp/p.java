package org.apache.commons.net.ftp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class p extends SocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final SSLContext f50728a;

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return this.f50728a.getSocketFactory().createSocket();
    }

    @Deprecated
    public ServerSocket d(ServerSocket serverSocket) throws IOException {
        ((SSLServerSocket) serverSocket).setUseClientMode(true);
        return serverSocket;
    }

    @Deprecated
    public ServerSocket a(int i6) throws IOException {
        return d(this.f50728a.getServerSocketFactory().createServerSocket(i6));
    }

    @Deprecated
    public ServerSocket b(int i6, int i7) throws IOException {
        return d(this.f50728a.getServerSocketFactory().createServerSocket(i6, i7));
    }

    @Deprecated
    public ServerSocket c(int i6, int i7, InetAddress inetAddress) throws IOException {
        return d(this.f50728a.getServerSocketFactory().createServerSocket(i6, i7, inetAddress));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws UnknownHostException, IOException {
        return this.f50728a.getSocketFactory().createSocket(str, i6);
    }

    public p(SSLContext sSLContext) {
        this.f50728a = sSLContext;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        return this.f50728a.getSocketFactory().createSocket(inetAddress, i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws UnknownHostException, IOException {
        return this.f50728a.getSocketFactory().createSocket(str, i6, inetAddress, i7);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        return this.f50728a.getSocketFactory().createSocket(inetAddress, i6, inetAddress2, i7);
    }
}
