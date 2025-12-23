package xyz.adscope.common.network.ssl;

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
public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f56724b;

    /* renamed from: c, reason: collision with root package name */
    private static final X509TrustManager f56725c;

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f56726a;

    public TLSSocketFactory() {
        try {
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            sSLContext.init(null, new TrustManager[]{f56725c}, new SecureRandom());
            this.f56726a = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) {
        Socket createSocket = this.f56726a.createSocket(socket, str, i6, z5);
        a(createSocket);
        return createSocket;
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f56724b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            f56724b = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        }
        f56725c = new X509TrustManager() { // from class: xyz.adscope.common.network.ssl.TLSSocketFactory.1
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

    private static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f56724b);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f56726a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f56726a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) {
        Socket createSocket = this.f56726a.createSocket(str, i6);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) {
        Socket createSocket = this.f56726a.createSocket(str, i6, inetAddress, i7);
        a(createSocket);
        return createSocket;
    }

    public TLSSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f56726a = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) {
        Socket createSocket = this.f56726a.createSocket(inetAddress, i6);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) {
        Socket createSocket = this.f56726a.createSocket(inetAddress, i6, inetAddress2, i7);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        Socket createSocket = this.f56726a.createSocket();
        a(createSocket);
        return createSocket;
    }
}
