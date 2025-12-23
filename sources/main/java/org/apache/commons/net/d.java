package org.apache.commons.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends SocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final Proxy f50550a;

    public d() {
        this(null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return this.f50550a != null ? new Socket(this.f50550a) : new Socket();
    }

    public d(Proxy proxy) {
        this.f50550a = proxy;
    }

    public ServerSocket a(int i6) throws IOException {
        return new ServerSocket(i6);
    }

    public ServerSocket b(int i6, int i7) throws IOException {
        return new ServerSocket(i6, i7);
    }

    public ServerSocket c(int i6, int i7, InetAddress inetAddress) throws IOException {
        return new ServerSocket(i6, i7, inetAddress);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws UnknownHostException, IOException {
        if (this.f50550a != null) {
            Socket socket = new Socket(this.f50550a);
            socket.connect(new InetSocketAddress(str, i6));
            return socket;
        }
        return new Socket(str, i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        if (this.f50550a != null) {
            Socket socket = new Socket(this.f50550a);
            socket.connect(new InetSocketAddress(inetAddress, i6));
            return socket;
        }
        return new Socket(inetAddress, i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws UnknownHostException, IOException {
        if (this.f50550a != null) {
            Socket socket = new Socket(this.f50550a);
            socket.bind(new InetSocketAddress(inetAddress, i7));
            socket.connect(new InetSocketAddress(str, i6));
            return socket;
        }
        return new Socket(str, i6, inetAddress, i7);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        if (this.f50550a != null) {
            Socket socket = new Socket(this.f50550a);
            socket.bind(new InetSocketAddress(inetAddress2, i7));
            socket.connect(new InetSocketAddress(inetAddress, i6));
            return socket;
        }
        return new Socket(inetAddress, i6, inetAddress2, i7);
    }
}
