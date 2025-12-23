package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.stub.StubApp;
import java.io.IOException;
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
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f35114i = "c";

    /* renamed from: j, reason: collision with root package name */
    private static volatile c f35115j;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f35116a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f35117b;

    /* renamed from: c, reason: collision with root package name */
    private Context f35118c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f35119d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f35120e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f35121f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f35122g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f35123h;

    private c(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f35117b = null;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35114i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f35116a.getSocketFactory().createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35117b = sSLSocket;
            this.f35119d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void a(Socket socket) {
        boolean z5;
        boolean z6 = true;
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35123h)) {
            z5 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35114i, "set protocols");
            f.h((SSLSocket) socket, this.f35123h);
            z5 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35122g) && com.huawei.secure.android.common.ssl.util.d.a(this.f35121f)) {
            z6 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35114i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.d.a(this.f35122g)) {
                f.e(sSLSocket, this.f35121f);
            } else {
                f.l(sSLSocket, this.f35122g);
            }
        }
        if (!z5) {
            com.huawei.secure.android.common.ssl.util.h.e(f35114i, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z6) {
            return;
        }
        com.huawei.secure.android.common.ssl.util.h.e(f35114i, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    @Deprecated
    static void b(X509TrustManager x509TrustManager) {
        com.huawei.secure.android.common.ssl.util.h.e(f35114i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f35115j = new c(null, x509TrustManager);
        } catch (KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "UnrecoverableKeyException");
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35114i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        com.huawei.secure.android.common.ssl.util.h.e(f35114i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f35115j = new c((KeyStore) null, x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "UnrecoverableKeyException");
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35114i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public String[] d() {
        return this.f35121f;
    }

    public X509Certificate[] e() {
        X509TrustManager x509TrustManager = this.f35120e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f35118c;
    }

    public String[] h() {
        return this.f35123h;
    }

    public SSLContext i() {
        return this.f35116a;
    }

    public SSLSocket j() {
        return this.f35117b;
    }

    public String[] k() {
        String[] strArr = this.f35119d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] l() {
        return this.f35122g;
    }

    public X509TrustManager m() {
        return this.f35120e;
    }

    public void n(String[] strArr) {
        this.f35121f = strArr;
    }

    public void p(String[] strArr) {
        this.f35123h = strArr;
    }

    public void q(SSLContext sSLContext) {
        this.f35116a = sSLContext;
    }

    public void r(SSLSocket sSLSocket) {
        this.f35117b = sSLSocket;
    }

    public void s(String[] strArr) {
        this.f35122g = strArr;
    }

    public void t(X509TrustManager x509TrustManager) {
        this.f35120e = x509TrustManager;
    }

    private c(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f35117b = null;
        if (context == null) {
            com.huawei.secure.android.common.ssl.util.h.d(f35114i, "SecureSSLSocketFactory: context is null");
            return;
        }
        o(context);
        q(f.i());
        k a6 = e.a(context);
        this.f35120e = a6;
        this.f35116a.init(null, new X509TrustManager[]{a6}, secureRandom);
    }

    @Deprecated
    public static c f(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35115j == null) {
            synchronized (g.class) {
                try {
                    if (f35115j == null) {
                        f35115j = new c(keyStore, context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        return f35115j;
    }

    public static c g(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35115j == null) {
            synchronized (g.class) {
                try {
                    if (f35115j == null) {
                        f35115j = new c(keyStore, context, secureRandom);
                    }
                } finally {
                }
            }
        }
        return f35115j;
    }

    public void o(Context context) {
        this.f35118c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35114i, "createSocket: ");
        Socket createSocket = this.f35116a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35117b = sSLSocket;
            this.f35119d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Deprecated
    public c(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f35117b = null;
        this.f35116a = f.i();
        t(x509TrustManager);
        this.f35116a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public c(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f35117b = null;
        this.f35116a = f.i();
        t(x509TrustManager);
        this.f35116a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
