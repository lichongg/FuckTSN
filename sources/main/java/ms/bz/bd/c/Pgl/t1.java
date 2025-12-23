package ms.bz.bd.c.Pgl;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
final class t1 extends SSLSocketFactory {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f50387b = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "0dab2f", new byte[]{21, 74, BinaryMemcacheOpcodes.SASL_AUTH, 0, 92, Utf8.REPLACEMENT_BYTE, 97})};

    /* renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f50388a;

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i6) throws IOException, UnknownHostException {
        Socket createSocket = this.f50388a.createSocket(str, i6);
        if (createSocket instanceof SSLSocket) {
            ((SSLSocket) createSocket).setEnabledProtocols(f50387b);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws IOException, UnknownHostException {
        Socket createSocket = this.f50388a.createSocket(str, i6, inetAddress, i7);
        if (createSocket instanceof SSLSocket) {
            ((SSLSocket) createSocket).setEnabledProtocols(f50387b);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f50388a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f50388a.getSupportedCipherSuites();
    }

    public t1(SSLSocketFactory sSLSocketFactory) {
        this.f50388a = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        Socket createSocket = this.f50388a.createSocket(inetAddress, i6);
        if (createSocket instanceof SSLSocket) {
            ((SSLSocket) createSocket).setEnabledProtocols(f50387b);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        Socket createSocket = this.f50388a.createSocket(inetAddress, i6, inetAddress2, i7);
        if (createSocket instanceof SSLSocket) {
            ((SSLSocket) createSocket).setEnabledProtocols(f50387b);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        Socket createSocket = this.f50388a.createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            ((SSLSocket) createSocket).setEnabledProtocols(f50387b);
        }
        return createSocket;
    }
}
