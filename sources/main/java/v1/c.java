package v1;

import android.content.Context;
import com.huawei.secure.android.common.ssl.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends SSLSocketFactory {

    /* renamed from: c, reason: collision with root package name */
    public static final X509HostnameVerifier f54696c = new BrowserCompatHostnameVerifier();

    /* renamed from: d, reason: collision with root package name */
    public static final X509HostnameVerifier f54697d = new StrictHostnameVerifier();

    /* renamed from: e, reason: collision with root package name */
    private static volatile c f54698e = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f54699a;

    /* renamed from: b, reason: collision with root package name */
    private Context f54700b;

    private c(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        Socket createSocket = this.f54699a.getSocketFactory().createSocket(socket, str, i6, z5);
        a(createSocket);
        return createSocket;
    }

    private c(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        super(keyStore);
        this.f54700b = context;
        this.f54699a = f.i();
        this.f54699a.init(null, new X509TrustManager[]{new e(this.f54700b)}, secureRandom);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        f.g(sSLSocket);
        f.f(sSLSocket);
    }

    @Deprecated
    public static c b(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f54698e == null) {
            synchronized (c.class) {
                try {
                    if (f54698e == null) {
                        f54698e = new c(keyStore, context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        return f54698e;
    }

    @Deprecated
    public static c c(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f54698e == null) {
            synchronized (c.class) {
                try {
                    if (f54698e == null) {
                        f54698e = new c(keyStore, context, secureRandom);
                    }
                } finally {
                }
            }
        }
        return f54698e;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        Socket createSocket = this.f54699a.getSocketFactory().createSocket();
        a(createSocket);
        return createSocket;
    }

    @Deprecated
    public c(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(keyStore);
        this.f54699a = f.i();
        this.f54699a.init(null, new X509TrustManager[]{new a(inputStream, str)}, null);
    }

    @Deprecated
    public c(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(keyStore);
        this.f54699a = f.i();
        this.f54699a.init(null, new X509TrustManager[]{new a(inputStream, str)}, secureRandom);
    }
}
