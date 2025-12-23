package com.bxkj.student.v2.retrofit;

import com.bxkj.base.BaseApp;
import com.google.gson.GsonBuilder;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import kotlin.jvm.internal.g0;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.d0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f21288a = new e();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final OkHttpClient f21289b;

    /* renamed from: c, reason: collision with root package name */
    private static d0 f21290c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static b f21291d;

    static {
        OkHttpClient.Builder proxy = new OkHttpClient.Builder().proxy(Proxy.NO_PROXY);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = proxy.readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).connectTimeout(30L, timeUnit).addInterceptor(new z.b()).addInterceptor(new z.d()).addInterceptor(new z.c()).addInterceptor(new z.a());
        com.bxkj.base.v2.http.d dVar = com.bxkj.base.v2.http.d.f17080a;
        OkHttpClient.Builder sslSocketFactory = addInterceptor.sslSocketFactory(dVar.a(), dVar.b());
        HostnameVerifier a6 = com.bxkj.base.v2.http.e.a();
        g0.o(a6, "getHostnameVerifier(...)");
        OkHttpClient build = sslSocketFactory.hostnameVerifier(a6).addInterceptor(new h2.b(BaseApp.c())).addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.bxkj.student.v2.retrofit.d
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                e.d(str);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        f21289b = build;
        d0 f6 = new d0.b().j(build).c(com.bxkj.base.v2.data.b.f16998d.a().M()).b(retrofit2.converter.gson.a.c(new GsonBuilder().setLenient().create())).f();
        f21290c = f6;
        Object g6 = f6.g(b.class);
        g0.o(g6, "create(...)");
        f21291d = (b) g6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String message) {
        g0.p(message, "message");
    }

    public final void b() {
        d0 f6 = new d0.b().j(f21289b).c(com.bxkj.base.v2.data.b.f16998d.a().M()).b(retrofit2.converter.gson.a.c(new GsonBuilder().setLenient().create())).f();
        f21290c = f6;
        Object g6 = f6.g(b.class);
        g0.o(g6, "create(...)");
        f21291d = (b) g6;
        com.bxkj.base.v2.http.c.f17076a.a();
    }

    @NotNull
    public final b c() {
        return f21291d;
    }

    public final void e(@NotNull b bVar) {
        g0.p(bVar, "<set-?>");
        f21291d = bVar;
    }

    private e() {
    }
}
