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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f35168i = "SSLFNew";

    /* renamed from: j, reason: collision with root package name */
    private static volatile i f35169j;

    /* renamed from: a, reason: collision with root package name */
    protected SSLContext f35170a;

    /* renamed from: b, reason: collision with root package name */
    protected SSLSocket f35171b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f35172c;

    /* renamed from: d, reason: collision with root package name */
    protected String[] f35173d;

    /* renamed from: e, reason: collision with root package name */
    protected X509TrustManager f35174e;

    /* renamed from: f, reason: collision with root package name */
    protected String[] f35175f;

    /* renamed from: g, reason: collision with root package name */
    protected String[] f35176g;

    /* renamed from: h, reason: collision with root package name */
    protected String[] f35177h;

    @Deprecated
    public i(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f35170a = null;
        this.f35171b = null;
        this.f35170a = f.i();
        a aVar = new a(inputStream, str);
        p(aVar);
        this.f35170a.init(null, new X509TrustManager[]{aVar}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i6) throws IOException {
        com.huawei.secure.android.common.ssl.util.h.e(f35168i, "createSocket: host , port");
        Socket createSocket = this.f35170a.getSocketFactory().createSocket(str, i6);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35171b = sSLSocket;
            this.f35173d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
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
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35177h)) {
            z5 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35168i, "set protocols");
            f.h((SSLSocket) socket, this.f35177h);
            z5 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.d.a(this.f35176g) && com.huawei.secure.android.common.ssl.util.d.a(this.f35175f)) {
            z6 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.h.e(f35168i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.d.a(this.f35176g)) {
                f.e(sSLSocket, this.f35175f);
            } else {
                f.l(sSLSocket, this.f35176g);
            }
        }
        if (!z5) {
            com.huawei.secure.android.common.ssl.util.h.e(f35168i, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z6) {
            return;
        }
        com.huawei.secure.android.common.ssl.util.h.e(f35168i, "set default cipher");
        f.f((SSLSocket) socket);
    }

    public String[] b() {
        return this.f35175f;
    }

    public X509Certificate[] c() {
        X509TrustManager x509TrustManager = this.f35174e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public String[] f() {
        return this.f35177h;
    }

    public SSLContext g() {
        return this.f35170a;
    }

    public Context getContext() {
        return this.f35172c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f35173d;
        return strArr != null ? strArr : new String[0];
    }

    public SSLSocket h() {
        return this.f35171b;
    }

    public String[] i() {
        return this.f35176g;
    }

    public X509TrustManager j() {
        return this.f35174e;
    }

    public void k(String[] strArr) {
        this.f35175f = strArr;
    }

    public void m(String[] strArr) {
        this.f35177h = strArr;
    }

    public void n(SSLContext sSLContext) {
        this.f35170a = sSLContext;
    }

    public void o(String[] strArr) {
        this.f35176g = strArr;
    }

    public void p(X509TrustManager x509TrustManager) {
        this.f35174e = x509TrustManager;
    }

    @Deprecated
    public static i d(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35169j == null) {
            synchronized (i.class) {
                try {
                    if (f35169j == null) {
                        f35169j = new i(context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        if (f35169j.f35172c == null && context != null) {
            f35169j.l(context);
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35168i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f35169j;
    }

    public static i e(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35169j == null) {
            synchronized (i.class) {
                try {
                    if (f35169j == null) {
                        f35169j = new i(context, secureRandom);
                    }
                } finally {
                }
            }
        }
        if (f35169j.f35172c == null && context != null) {
            f35169j.l(context);
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35168i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f35169j;
    }

    public void l(Context context) {
        this.f35172c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i6);
    }

    public i(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f35170a = null;
        this.f35171b = null;
        this.f35170a = f.i();
        a aVar = new a(inputStream, str);
        p(aVar);
        this.f35170a.init(null, new X509TrustManager[]{aVar}, secureRandom);
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
        com.huawei.secure.android.common.ssl.util.h.e(f35168i, "createSocket");
        Socket createSocket = this.f35170a.getSocketFactory().createSocket(socket, str, i6, z5);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f35171b = sSLSocket;
            this.f35173d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private i(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f35170a = null;
        this.f35171b = null;
        if (context == null) {
            com.huawei.secure.android.common.ssl.util.h.d(f35168i, "SecureSSLSocketFactory: context is null");
            return;
        }
        l(context);
        n(f.i());
        k a6 = j.a(context);
        this.f35174e = a6;
        this.f35170a.init(null, new X509TrustManager[]{a6}, secureRandom);
    }

    @Deprecated
    public i(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f35170a = null;
        this.f35171b = null;
        this.f35170a = f.i();
        p(x509TrustManager);
        this.f35170a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public i(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f35170a = null;
        this.f35171b = null;
        this.f35170a = f.i();
        p(x509TrustManager);
        this.f35170a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
