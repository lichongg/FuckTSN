package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.stub.StubApp;
import java.io.IOException;
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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f35124i = "d";

    /* renamed from: j, reason: collision with root package name */
    private static volatile d f35125j;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f35126a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f35127b;

    /* renamed from: c, reason: collision with root package name */
    private Context f35128c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f35129d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f35130e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f35131f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f35132g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f35133h;

    private d(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f35126a = null;
        this.f35127b = null;
        if (context == null) {
            com.huawei.secure.android.common.ssl.util.h.d(f35124i, "SecureSSLSocketFactory: context is null");
            return;
        }
        n(context);
        p(f.i());
        k a6 = e.a(context);
        this.f35130e = a6;
        this.f35126a.init(null, new X509TrustManager[]{a6}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35124i, "createSocket: host , port");
        Socket createSocket = this.f35126a.getSocketFactory().createSocket(str, i6);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35127b = sSLSocket;
            this.f35129d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
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
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35133h)) {
            z5 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35124i, "set protocols");
            f.h((SSLSocket) socket, this.f35133h);
            z5 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35132g) && com.huawei.secure.android.common.ssl.util.d.a(this.f35131f)) {
            z6 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35124i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.d.a(this.f35132g)) {
                f.e(sSLSocket, this.f35131f);
            } else {
                f.l(sSLSocket, this.f35132g);
            }
        }
        if (!z5) {
            com.huawei.secure.android.common.ssl.util.h.e(f35124i, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z6) {
            return;
        }
        com.huawei.secure.android.common.ssl.util.h.e(f35124i, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    @Deprecated
    static void b(X509TrustManager x509TrustManager) {
        com.huawei.secure.android.common.ssl.util.h.e(f35124i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f35125j = new d(x509TrustManager);
        } catch (KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35124i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35124i, "NoSuchAlgorithmException");
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35124i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        com.huawei.secure.android.common.ssl.util.h.e(f35124i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f35125j = new d(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.h.d(f35124i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            com.huawei.secure.android.common.ssl.util.h.d(f35124i, "NoSuchAlgorithmException");
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35124i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public String[] d() {
        return this.f35131f;
    }

    public X509Certificate[] e() {
        X509TrustManager x509TrustManager = this.f35130e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f35128c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f35129d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] h() {
        return this.f35133h;
    }

    public SSLContext i() {
        return this.f35126a;
    }

    public SSLSocket j() {
        return this.f35127b;
    }

    public String[] k() {
        return this.f35132g;
    }

    public X509TrustManager l() {
        return this.f35130e;
    }

    public void m(String[] strArr) {
        this.f35131f = strArr;
    }

    public void o(String[] strArr) {
        this.f35133h = strArr;
    }

    public void p(SSLContext sSLContext) {
        this.f35126a = sSLContext;
    }

    public void q(String[] strArr) {
        this.f35132g = strArr;
    }

    public void r(X509TrustManager x509TrustManager) {
        this.f35130e = x509TrustManager;
    }

    @Deprecated
    public static d f(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35125j == null) {
            synchronized (d.class) {
                try {
                    if (f35125j == null) {
                        f35125j = new d(context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        if (f35125j.f35128c == null && context != null) {
            f35125j.n(context);
        }
        return f35125j;
    }

    public static d g(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35125j == null) {
            synchronized (d.class) {
                try {
                    if (f35125j == null) {
                        f35125j = new d(context, secureRandom);
                    }
                } finally {
                }
            }
        }
        if (f35125j.f35128c == null && context != null) {
            f35125j.n(context);
        }
        return f35125j;
    }

    public void n(Context context) {
        this.f35128c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws IOException, UnknownHostException {
        return createSocket(str, i6);
    }

    @Deprecated
    public d(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f35126a = null;
        this.f35127b = null;
        this.f35126a = f.i();
        r(x509TrustManager);
        this.f35126a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35124i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.f35126a.getSocketFactory().createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35127b = sSLSocket;
            this.f35129d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public d(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f35126a = null;
        this.f35127b = null;
        this.f35126a = f.i();
        r(x509TrustManager);
        this.f35126a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
