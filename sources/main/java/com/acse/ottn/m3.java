package com.acse.ottn;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.d0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class m3 {

    /* renamed from: e, reason: collision with root package name */
    public static final String f4828e = "RetrofitServiceManager";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4829f = "";

    /* renamed from: a, reason: collision with root package name */
    public String[] f4830a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", com.kuaishou.weapon.p0.t.f36143d, com.kuaishou.weapon.p0.t.f36152m, "n", "o", "p", "q", com.kuaishou.weapon.p0.t.f36150k, "s", bi.aL, "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", bi.aG};

    /* renamed from: b, reason: collision with root package name */
    public final HttpLoggingInterceptor f4831b;

    /* renamed from: c, reason: collision with root package name */
    public final Interceptor f4832c;

    /* renamed from: d, reason: collision with root package name */
    public final OkHttpClient f4833d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements HttpLoggingInterceptor.Logger {
        public a() {
        }

        @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
        public void log(String str) {
            c2.a(m3.f4828e, str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Interceptor {
        public b() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder newBuilder = chain.request().newBuilder();
            newBuilder.addHeader("Accept", "application/json,utf-8");
            newBuilder.addHeader("Content-Type", "application/json;utf-8");
            return chain.proceed(newBuilder.build());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public c() {
        }
    }

    public abstract String b();

    public m3() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new a());
        this.f4831b = httpLoggingInterceptor;
        b bVar = new b();
        this.f4832c = bVar;
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(bVar).addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f4833d = addInterceptor.connectTimeout(10L, timeUnit).readTimeout(20L, timeUnit).retryOnConnectionFailure(true).sslSocketFactory(t3.b(), t3.d()).hostnameVerifier(new c()).build();
    }

    public retrofit2.d0 a() {
        this.f4831b.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new d0.b().j(this.f4833d).b(z0.a()).a(retrofit2.adapter.rxjava.h.f(rx.schedulers.c.e())).c(b() == null ? "" : b()).f();
    }
}
