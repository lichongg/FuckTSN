package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.stub.StubApp;
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
import java.security.cert.X509Certificate;
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
public class h extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final X509HostnameVerifier f35156i = new BrowserCompatHostnameVerifier();

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final X509HostnameVerifier f35157j = new StrictHostnameVerifier();

    /* renamed from: k, reason: collision with root package name */
    private static final String f35158k = h.class.getSimpleName();

    /* renamed from: l, reason: collision with root package name */
    private static volatile h f35159l = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f35160a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f35161b;

    /* renamed from: c, reason: collision with root package name */
    private Context f35162c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f35163d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f35164e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f35165f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f35166g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f35167h;

    @Deprecated
    public h(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f35160a = null;
        this.f35161b = null;
        this.f35160a = f.i();
        a aVar = new a(inputStream, str);
        r(aVar);
        this.f35160a.init(null, new X509TrustManager[]{aVar}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35158k, "createSocket: host , port");
        Socket createSocket = this.f35160a.getSocketFactory().createSocket(str, i6);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35161b = sSLSocket;
            this.f35163d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    private void a(Socket socket) {
        boolean z5;
        boolean z6 = true;
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35167h)) {
            z5 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35158k, "set protocols");
            f.h((SSLSocket) socket, this.f35167h);
            z5 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35166g) && com.huawei.secure.android.common.ssl.util.d.a(this.f35165f)) {
            z6 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35158k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.d.a(this.f35166g)) {
                f.e(sSLSocket, this.f35165f);
            } else {
                f.l(sSLSocket, this.f35166g);
            }
        }
        if (!z5) {
            com.huawei.secure.android.common.ssl.util.h.e(f35158k, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z6) {
            return;
        }
        com.huawei.secure.android.common.ssl.util.h.e(f35158k, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    @Deprecated
    static void b(X509TrustManager x509TrustManager) {
        com.huawei.secure.android.common.ssl.util.h.e(f35158k, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f35159l = new h(x509TrustManager);
        } catch (KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35158k, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35158k, "NoSuchAlgorithmException");
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35158k, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        com.huawei.secure.android.common.ssl.util.h.e(f35158k, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f35159l = new h(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35158k, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35158k, "NoSuchAlgorithmException");
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35158k, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public String[] d() {
        return this.f35165f;
    }

    public X509Certificate[] e() {
        X509TrustManager x509TrustManager = this.f35164e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f35162c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f35163d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] h() {
        return this.f35167h;
    }

    public SSLContext i() {
        return this.f35160a;
    }

    public SSLSocket j() {
        return this.f35161b;
    }

    public String[] k() {
        return this.f35166g;
    }

    public X509TrustManager l() {
        return this.f35164e;
    }

    public void m(String[] strArr) {
        this.f35165f = strArr;
    }

    public void o(String[] strArr) {
        this.f35167h = strArr;
    }

    public void p(SSLContext sSLContext) {
        this.f35160a = sSLContext;
    }

    public void q(String[] strArr) {
        this.f35166g = strArr;
    }

    public void r(X509TrustManager x509TrustManager) {
        this.f35164e = x509TrustManager;
    }

    @Deprecated
    public static h f(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35159l == null) {
            synchronized (h.class) {
                try {
                    if (f35159l == null) {
                        f35159l = new h(context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        if (f35159l.f35162c == null && context != null) {
            f35159l.n(context);
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35158k, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f35159l;
    }

    public static h g(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35159l == null) {
            synchronized (h.class) {
                try {
                    if (f35159l == null) {
                        f35159l = new h(context, secureRandom);
                    }
                } finally {
                }
            }
        }
        if (f35159l.f35162c == null && context != null) {
            f35159l.n(context);
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35158k, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f35159l;
    }

    public void n(Context context) {
        this.f35162c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    public h(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f35160a = null;
        this.f35161b = null;
        this.f35160a = f.i();
        a aVar = new a(inputStream, str);
        r(aVar);
        this.f35160a.init(null, new X509TrustManager[]{aVar}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws IOException, UnknownHostException {
        return createSocket(str, i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35158k, "createSocket s host port autoClose");
        Socket createSocket = this.f35160a.getSocketFactory().createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35161b = sSLSocket;
            this.f35163d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private h(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f35160a = null;
        this.f35161b = null;
        if (context == null) {
            com.huawei.secure.android.common.ssl.util.h.d(f35158k, "SecureSSLSocketFactory: context is null");
            return;
        }
        n(context);
        p(f.i());
        k a6 = j.a(context);
        this.f35164e = a6;
        this.f35160a.init(null, new X509TrustManager[]{a6}, secureRandom);
    }

    @Deprecated
    public h(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f35160a = null;
        this.f35161b = null;
        this.f35160a = f.i();
        r(x509TrustManager);
        this.f35160a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public h(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f35160a = null;
        this.f35161b = null;
        this.f35160a = f.i();
        r(x509TrustManager);
        this.f35160a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
