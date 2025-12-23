package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.stub.StubApp;
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
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    public static final X509HostnameVerifier f35144i = new BrowserCompatHostnameVerifier();

    /* renamed from: j, reason: collision with root package name */
    public static final X509HostnameVerifier f35145j = new StrictHostnameVerifier();

    /* renamed from: k, reason: collision with root package name */
    private static final String f35146k = g.class.getSimpleName();

    /* renamed from: l, reason: collision with root package name */
    private static volatile g f35147l = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f35148a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f35149b;

    /* renamed from: c, reason: collision with root package name */
    private Context f35150c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f35151d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f35152e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f35153f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f35154g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f35155h;

    private g(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f35149b = null;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35146k, "createSocket: socket host port autoClose");
        Socket createSocket = this.f35148a.getSocketFactory().createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35149b = sSLSocket;
            this.f35151d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void a(Socket socket) {
        boolean z5;
        boolean z6 = true;
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35155h)) {
            z5 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35146k, "set protocols");
            f.h((SSLSocket) socket, this.f35155h);
            z5 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35154g) && com.huawei.secure.android.common.ssl.util.d.a(this.f35153f)) {
            z6 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35146k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.d.a(this.f35154g)) {
                f.e(sSLSocket, this.f35153f);
            } else {
                f.l(sSLSocket, this.f35154g);
            }
        }
        if (!z5) {
            com.huawei.secure.android.common.ssl.util.h.e(f35146k, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z6) {
            return;
        }
        com.huawei.secure.android.common.ssl.util.h.e(f35146k, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    @Deprecated
    static void b(X509TrustManager x509TrustManager) {
        com.huawei.secure.android.common.ssl.util.h.e(f35146k, "sasf update socket factory trust manager");
        try {
            f35147l = new g(null, x509TrustManager);
        } catch (IOException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "IOException");
        } catch (KeyManagementException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "CertificateException");
        }
    }

    static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        com.huawei.secure.android.common.ssl.util.h.e(f35146k, "sasf update socket factory trust manager");
        try {
            f35147l = new g((KeyStore) null, x509TrustManager, secureRandom);
        } catch (IOException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "IOException");
        } catch (KeyManagementException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "CertificateException");
        }
    }

    public String[] d() {
        return this.f35153f;
    }

    public X509Certificate[] e() {
        X509TrustManager x509TrustManager = this.f35152e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f35150c;
    }

    public String[] h() {
        return this.f35155h;
    }

    public SSLContext i() {
        return this.f35148a;
    }

    public SSLSocket j() {
        return this.f35149b;
    }

    public String[] k() {
        String[] strArr = this.f35151d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] l() {
        return this.f35154g;
    }

    public X509TrustManager m() {
        return this.f35152e;
    }

    public void n(String[] strArr) {
        this.f35153f = strArr;
    }

    public void p(String[] strArr) {
        this.f35155h = strArr;
    }

    public void q(SSLContext sSLContext) {
        this.f35148a = sSLContext;
    }

    public void r(SSLSocket sSLSocket) {
        this.f35149b = sSLSocket;
    }

    public void s(String[] strArr) {
        this.f35154g = strArr;
    }

    public void t(X509TrustManager x509TrustManager) {
        this.f35152e = x509TrustManager;
    }

    private g(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f35149b = null;
        if (context == null) {
            com.huawei.secure.android.common.ssl.util.h.d(f35146k, "SecureSSLSocketFactory: context is null");
            return;
        }
        o(context);
        q(f.i());
        k a6 = j.a(context);
        this.f35152e = a6;
        this.f35148a.init(null, new X509TrustManager[]{a6}, secureRandom);
    }

    @Deprecated
    public static g f(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35147l == null) {
            synchronized (g.class) {
                try {
                    if (f35147l == null) {
                        f35147l = new g(keyStore, context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        return f35147l;
    }

    public static g g(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35147l == null) {
            synchronized (g.class) {
                try {
                    if (f35147l == null) {
                        f35147l = new g(keyStore, context, secureRandom);
                    }
                } finally {
                }
            }
        }
        return f35147l;
    }

    public void o(Context context) {
        this.f35150c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35146k, "createSocket: ");
        Socket createSocket = this.f35148a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35149b = sSLSocket;
            this.f35151d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Deprecated
    public g(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f35149b = null;
        this.f35148a = f.i();
        a aVar = new a(inputStream, str);
        t(aVar);
        this.f35148a.init(null, new X509TrustManager[]{aVar}, null);
    }

    public g(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f35149b = null;
        this.f35148a = f.i();
        a aVar = new a(inputStream, str);
        t(aVar);
        this.f35148a.init(null, new X509TrustManager[]{aVar}, secureRandom);
    }

    @Deprecated
    public g(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f35149b = null;
        this.f35148a = f.i();
        t(x509TrustManager);
        this.f35148a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public g(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f35149b = null;
        this.f35148a = f.i();
        t(x509TrustManager);
        this.f35148a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
