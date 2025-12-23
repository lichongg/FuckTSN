package org.apache.commons.net.ftp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class o extends ServerSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final SSLContext f50727a;

    public ServerSocket a(ServerSocket serverSocket) {
        ((SSLServerSocket) serverSocket).setUseClientMode(true);
        return serverSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket() throws IOException {
        return a(this.f50727a.getServerSocketFactory().createServerSocket());
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i6) throws IOException {
        return a(this.f50727a.getServerSocketFactory().createServerSocket(i6));
    }

    public o(SSLContext sSLContext) {
        this.f50727a = sSLContext;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i6, int i7) throws IOException {
        return a(this.f50727a.getServerSocketFactory().createServerSocket(i6, i7));
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i6, int i7, InetAddress inetAddress) throws IOException {
        return a(this.f50727a.getServerSocketFactory().createServerSocket(i6, i7, inetAddress));
    }
}
