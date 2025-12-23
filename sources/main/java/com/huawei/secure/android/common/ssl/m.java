package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class m extends Thread {

    /* renamed from: i, reason: collision with root package name */
    private static final String f35189i = "m";

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f35190a;

    /* renamed from: b, reason: collision with root package name */
    private HostnameVerifier f35191b;

    /* renamed from: c, reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f35192c;

    /* renamed from: d, reason: collision with root package name */
    private X509HostnameVerifier f35193d;

    /* renamed from: e, reason: collision with root package name */
    private SslErrorHandler f35194e;

    /* renamed from: f, reason: collision with root package name */
    private String f35195f;

    /* renamed from: g, reason: collision with root package name */
    private a f35196g;

    /* renamed from: h, reason: collision with root package name */
    private Context f35197h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(Context context, String str);

        void b(Context context, String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f35198a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f35199b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f35200c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f35201d;

        b(a aVar, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f35198a = aVar;
            this.f35199b = context;
            this.f35200c = str;
            this.f35201d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            com.huawei.secure.android.common.ssl.util.h.d(m.f35189i, "onFailure , IO Exception : " + iOException.getMessage());
            a aVar = this.f35198a;
            if (aVar != null) {
                aVar.a(this.f35199b, this.f35200c);
            } else {
                this.f35201d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            com.huawei.secure.android.common.ssl.util.h.d(m.f35189i, "onResponse . proceed");
            a aVar = this.f35198a;
            if (aVar != null) {
                aVar.b(this.f35199b, this.f35200c);
            } else {
                this.f35201d.proceed();
            }
        }
    }

    public m() {
    }

    public static void d(SslErrorHandler sslErrorHandler, String str, Context context) {
        e(sslErrorHandler, str, context, null);
    }

    public m(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        r(sslErrorHandler);
        t(str);
        p(context);
        s(new i(new o(context)));
        q(new f2.b());
        try {
            n(new g(null, new o(context)));
        } catch (UnrecoverableKeyException e6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35189i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e6.getMessage());
        }
        m(g.f35145j);
    }

    private void b() {
        String str = f35189i;
        com.huawei.secure.android.common.ssl.util.h.e(str, "callbackCancel: ");
        a aVar = this.f35196g;
        if (aVar != null) {
            aVar.a(this.f35197h, this.f35195f);
        } else if (this.f35194e != null) {
            com.huawei.secure.android.common.ssl.util.h.e(str, "callbackCancel 2: ");
            this.f35194e.cancel();
        }
    }

    private void c() {
        com.huawei.secure.android.common.ssl.util.h.e(f35189i, "callbackProceed: ");
        a aVar = this.f35196g;
        if (aVar != null) {
            aVar.b(this.f35197h, this.f35195f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f35194e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void e(SslErrorHandler sslErrorHandler, String str, Context context, a aVar) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            com.huawei.secure.android.common.ssl.util.h.d(f35189i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            i iVar = new i(new o(context));
            iVar.l(context);
            builder.sslSocketFactory(iVar, new o(context));
            builder.hostnameVerifier(new f2.b());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new b(aVar, context, str, sslErrorHandler));
        } catch (Exception e6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35189i, "checkServerCertificateWithOK: exception : " + e6.getMessage());
            sslErrorHandler.cancel();
        }
    }

    public X509HostnameVerifier f() {
        return this.f35193d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory g() {
        return this.f35192c;
    }

    public Context getContext() {
        return this.f35197h;
    }

    public a h() {
        return this.f35196g;
    }

    public HostnameVerifier i() {
        return this.f35191b;
    }

    public SslErrorHandler j() {
        return this.f35194e;
    }

    public SSLSocketFactory k() {
        return this.f35190a;
    }

    public String l() {
        return this.f35195f;
    }

    public void m(X509HostnameVerifier x509HostnameVerifier) {
        this.f35193d = x509HostnameVerifier;
    }

    public void n(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f35192c = sSLSocketFactory;
    }

    public void o(a aVar) {
        this.f35196g = aVar;
    }

    public void p(Context context) {
        this.f35197h = context;
    }

    public void q(HostnameVerifier hostnameVerifier) {
        this.f35191b = hostnameVerifier;
    }

    public void r(SslErrorHandler sslErrorHandler) {
        this.f35194e = sslErrorHandler;
    }

    public void s(SSLSocketFactory sSLSocketFactory) {
        this.f35190a = sSLSocketFactory;
    }

    public void t(String str) {
        this.f35195f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0149  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.m.run():void");
    }

    @Deprecated
    public m(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        r(sslErrorHandler);
        t(str);
        s(sSLSocketFactory);
        q(hostnameVerifier);
    }

    @Deprecated
    public m(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        r(sslErrorHandler);
        t(str);
        n(sSLSocketFactory);
        m(x509HostnameVerifier);
    }

    @Deprecated
    public m(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, a aVar, Context context) {
        this.f35194e = sslErrorHandler;
        this.f35195f = str;
        this.f35192c = sSLSocketFactory;
        this.f35193d = x509HostnameVerifier;
        this.f35196g = aVar;
        this.f35197h = context;
    }
}
