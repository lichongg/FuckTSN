package com.bxkj.base.v2.http;

import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f17080a = new d();

    @NotNull
    public final SSLSocketFactory a() {
        SSLContext sSLContext = SSLContext.getInstance(org.apache.commons.net.imap.b.Q);
        sSLContext.init(null, new X509TrustManager[]{b()}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        g0.o(socketFactory, "getSocketFactory(...)");
        return socketFactory;
    }

    private d() {
    }

    @NotNull
    public final X509TrustManager b() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager trustManager = trustManagerFactory.getTrustManagers()[0];
        g0.n(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        return (X509TrustManager) trustManager;
    }
}
