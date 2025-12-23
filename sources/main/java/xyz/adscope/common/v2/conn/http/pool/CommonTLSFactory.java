package xyz.adscope.common.v2.conn.http.pool;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.net.imap.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class CommonTLSFactory extends SSLSocketFactory {
    private static final X509TrustManager DEFAULT_TRUST_MANAGERS;
    private static final String[] PROTOCOL_ARRAY;
    private final SSLSocketFactory delegate;

    CommonTLSFactory() {
        try {
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            sSLContext.init(null, new TrustManager[]{DEFAULT_TRUST_MANAGERS}, new SecureRandom());
            this.delegate = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) {
        Socket createSocket = this.delegate.createSocket(socket, str, i6, z5);
        setSupportProtocolAndCipherSuites(createSocket);
        return createSocket;
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            PROTOCOL_ARRAY = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            PROTOCOL_ARRAY = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        }
        DEFAULT_TRUST_MANAGERS = new X509TrustManager() { // from class: xyz.adscope.common.v2.conn.http.pool.CommonTLSFactory.1
            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }
        };
    }

    private static void setSupportProtocolAndCipherSuites(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(PROTOCOL_ARRAY);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) {
        Socket createSocket = this.delegate.createSocket(str, i6);
        setSupportProtocolAndCipherSuites(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) {
        Socket createSocket = this.delegate.createSocket(str, i6, inetAddress, i7);
        setSupportProtocolAndCipherSuites(createSocket);
        return createSocket;
    }

    CommonTLSFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) {
        Socket createSocket = this.delegate.createSocket(inetAddress, i6);
        setSupportProtocolAndCipherSuites(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) {
        Socket createSocket = this.delegate.createSocket(inetAddress, i6, inetAddress2, i7);
        setSupportProtocolAndCipherSuites(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        Socket createSocket = this.delegate.createSocket();
        setSupportProtocolAndCipherSuites(createSocket);
        return createSocket;
    }
}
