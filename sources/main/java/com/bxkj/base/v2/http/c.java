package com.bxkj.base.v2.http;

import com.bxkj.base.BaseApp;
import com.google.gson.GsonBuilder;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import kotlin.jvm.internal.g0;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.d0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f17076a = new c();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final OkHttpClient f17077b;

    /* renamed from: c, reason: collision with root package name */
    private static d0 f17078c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static b f17079d;

    static {
        OkHttpClient.Builder proxy = new OkHttpClient.Builder().proxy(Proxy.NO_PROXY);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = proxy.readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).connectTimeout(30L, timeUnit).addInterceptor(new z.b()).addInterceptor(new z.d()).addInterceptor(new z.c()).addInterceptor(new z.a());
        d dVar = d.f17080a;
        OkHttpClient.Builder sslSocketFactory = addInterceptor.sslSocketFactory(dVar.a(), dVar.b());
        HostnameVerifier a6 = e.a();
        g0.o(a6, "getHostnameVerifier(...)");
        OkHttpClient build = sslSocketFactory.hostnameVerifier(a6).addInterceptor(new h2.b(BaseApp.c())).build();
        f17077b = build;
        d0 f6 = new d0.b().j(build).c(com.bxkj.base.v2.data.b.f16998d.a().M()).b(retrofit2.converter.gson.a.c(new GsonBuilder().setLenient().create())).f();
        f17078c = f6;
        Object g6 = f6.g(b.class);
        g0.o(g6, "create(...)");
        f17079d = (b) g6;
    }

    public final void a() {
        d0 f6 = new d0.b().j(f17077b).c(com.bxkj.base.v2.data.b.f16998d.a().M()).b(retrofit2.converter.gson.a.c(new GsonBuilder().setLenient().create())).f();
        f17078c = f6;
        Object g6 = f6.g(b.class);
        g0.o(g6, "create(...)");
        f17079d = (b) g6;
    }

    @NotNull
    public final b b() {
        return f17079d;
    }

    public final void c(@NotNull b bVar) {
        g0.p(bVar, "<set-?>");
        f17079d = bVar;
    }

    private c() {
    }
}
