package v1;

import android.content.Context;
import com.huawei.secure.android.common.ssl.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends SSLSocketFactory {

    /* renamed from: c, reason: collision with root package name */
    public static final X509HostnameVerifier f54701c = new BrowserCompatHostnameVerifier();

    /* renamed from: d, reason: collision with root package name */
    public static final X509HostnameVerifier f54702d = new StrictHostnameVerifier();

    /* renamed from: e, reason: collision with root package name */
    private static volatile d f54703e = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f54704a;

    /* renamed from: b, reason: collision with root package name */
    private Context f54705b;

    private d(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalAccessException {
        this.f54704a = null;
        this.f54705b = context;
        this.f54704a = f.i();
        this.f54704a.init(null, new X509TrustManager[]{new e(this.f54705b)}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws IOException, UnknownHostException {
        Socket createSocket = this.f54704a.getSocketFactory().createSocket(str, i6);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        f.g(sSLSocket);
        f.f(sSLSocket);
    }

    @Deprecated
    public static d b(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f54703e == null) {
            synchronized (d.class) {
                try {
                    if (f54703e == null) {
                        f54703e = new d(context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        return f54703e;
    }

    @Deprecated
    public static d c(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f54703e == null) {
            synchronized (d.class) {
                try {
                    if (f54703e == null) {
                        f54703e = new d(context, secureRandom);
                    }
                } finally {
                }
            }
        }
        return f54703e;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws IOException, UnknownHostException {
        return createSocket(str, i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    @Deprecated
    public d(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f54704a = null;
        this.f54704a = f.i();
        this.f54704a.init(null, new X509TrustManager[]{new a(inputStream, str)}, null);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        Socket createSocket = this.f54704a.getSocketFactory().createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Deprecated
    public d(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f54704a = null;
        this.f54704a = f.i();
        this.f54704a.init(null, new X509TrustManager[]{new a(inputStream, str)}, secureRandom);
    }
}
