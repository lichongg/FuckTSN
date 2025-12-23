package xyz.adscope.common.network;

import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.connect.ConnectFactory;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.network.connect.Network;
import xyz.adscope.common.network.cookie.CookieStore;
import xyz.adscope.common.network.simple.Converter;
import xyz.adscope.common.network.simple.cache.CacheStore;
import xyz.adscope.common.network.ssl.SSLUtils;
import xyz.adscope.common.network.urlconnect.URLConnectionFactory;
import xyz.adscope.common.network.util.MainExecutor;
import xyz.adscope.common.network.util.WorkExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class KalleConfig {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f56478a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f56479b;

    /* renamed from: c, reason: collision with root package name */
    private final Charset f56480c;

    /* renamed from: d, reason: collision with root package name */
    private final Headers f56481d;

    /* renamed from: e, reason: collision with root package name */
    private final Proxy f56482e;

    /* renamed from: f, reason: collision with root package name */
    private final SSLSocketFactory f56483f;

    /* renamed from: g, reason: collision with root package name */
    private final HostnameVerifier f56484g;

    /* renamed from: h, reason: collision with root package name */
    private final int f56485h;

    /* renamed from: i, reason: collision with root package name */
    private final int f56486i;

    /* renamed from: j, reason: collision with root package name */
    private final Params f56487j;

    /* renamed from: k, reason: collision with root package name */
    private final CacheStore f56488k;

    /* renamed from: l, reason: collision with root package name */
    private final Network f56489l;

    /* renamed from: m, reason: collision with root package name */
    private final ConnectFactory f56490m;

    /* renamed from: n, reason: collision with root package name */
    private final CookieStore f56491n;

    /* renamed from: o, reason: collision with root package name */
    private final List<Interceptor> f56492o;

    /* renamed from: p, reason: collision with root package name */
    private final Converter f56493p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.KalleConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Executor f56494a;

        /* renamed from: b, reason: collision with root package name */
        private Executor f56495b;

        /* renamed from: c, reason: collision with root package name */
        private Charset f56496c;

        /* renamed from: d, reason: collision with root package name */
        private Headers f56497d;

        /* renamed from: e, reason: collision with root package name */
        private Proxy f56498e;

        /* renamed from: f, reason: collision with root package name */
        private SSLSocketFactory f56499f;

        /* renamed from: g, reason: collision with root package name */
        private HostnameVerifier f56500g;

        /* renamed from: h, reason: collision with root package name */
        private int f56501h;

        /* renamed from: i, reason: collision with root package name */
        private int f56502i;

        /* renamed from: j, reason: collision with root package name */
        private Params.Builder f56503j;

        /* renamed from: k, reason: collision with root package name */
        private CacheStore f56504k;

        /* renamed from: l, reason: collision with root package name */
        private Network f56505l;

        /* renamed from: m, reason: collision with root package name */
        private ConnectFactory f56506m;

        /* renamed from: n, reason: collision with root package name */
        private CookieStore f56507n;

        /* renamed from: o, reason: collision with root package name */
        private List<Interceptor> f56508o;

        /* renamed from: p, reason: collision with root package name */
        private Converter f56509p;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder connectionTimeout(int i6, TimeUnit timeUnit) {
            this.f56501h = (int) Math.min(timeUnit.toMillis(i6), 2147483647L);
            return this;
        }

        public Builder readTimeout(int i6, TimeUnit timeUnit) {
            this.f56502i = (int) Math.min(timeUnit.toMillis(i6), 2147483647L);
            return this;
        }

        private Builder() {
            this.f56497d = new Headers();
            this.f56503j = Params.newBuilder();
            this.f56508o = new ArrayList();
            this.f56497d.set("Accept", "*/*");
            this.f56497d.set("Accept-Encoding", Headers.VALUE_ACCEPT_ENCODING);
            this.f56497d.set("Content-Type", "application/x-www-form-urlencoded");
            this.f56497d.set("Connection", "keep-alive");
            this.f56497d.set("User-Agent", Headers.VALUE_USER_AGENT);
            this.f56497d.set("Accept-Language", Headers.VALUE_ACCEPT_LANGUAGE);
        }

        public Builder addHeader(String str, String str2) {
            this.f56497d.add(str, str2);
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.f56508o.add(interceptor);
            return this;
        }

        public Builder addInterceptors(List<Interceptor> list) {
            this.f56508o.addAll(list);
            return this;
        }

        public Builder addParam(String str, String str2) {
            this.f56503j.add(str, str2);
            return this;
        }

        public KalleConfig build() {
            return new KalleConfig(this, null);
        }

        public Builder cacheStore(CacheStore cacheStore) {
            this.f56504k = cacheStore;
            return this;
        }

        public Builder charset(Charset charset) {
            this.f56496c = charset;
            return this;
        }

        public Builder connectFactory(ConnectFactory connectFactory) {
            this.f56506m = connectFactory;
            return this;
        }

        public Builder converter(Converter converter) {
            this.f56509p = converter;
            return this;
        }

        public Builder cookieStore(CookieStore cookieStore) {
            this.f56507n = cookieStore;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f56500g = hostnameVerifier;
            return this;
        }

        public Builder mainThreadExecutor(Executor executor) {
            this.f56495b = executor;
            return this;
        }

        public Builder network(Network network) {
            this.f56505l = network;
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.f56498e = proxy;
            return this;
        }

        public Builder setHeader(String str, String str2) {
            this.f56497d.set(str, str2);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f56499f = sSLSocketFactory;
            return this;
        }

        public Builder workThreadExecutor(Executor executor) {
            this.f56494a = executor;
            return this;
        }
    }

    /* synthetic */ KalleConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private KalleConfig(Builder builder) {
        this.f56478a = builder.f56494a == null ? new WorkExecutor() : builder.f56494a;
        this.f56479b = builder.f56495b == null ? new MainExecutor() : builder.f56495b;
        this.f56480c = builder.f56496c == null ? Charset.defaultCharset() : builder.f56496c;
        this.f56481d = builder.f56497d;
        this.f56482e = builder.f56498e;
        this.f56483f = builder.f56499f == null ? SSLUtils.SSL_SOCKET_FACTORY : builder.f56499f;
        this.f56484g = builder.f56500g == null ? SSLUtils.HOSTNAME_VERIFIER : builder.f56500g;
        this.f56485h = builder.f56501h <= 0 ? 10000 : builder.f56501h;
        this.f56486i = builder.f56502i > 0 ? builder.f56502i : 10000;
        this.f56487j = builder.f56503j.build();
        this.f56488k = builder.f56504k == null ? CacheStore.DEFAULT : builder.f56504k;
        this.f56489l = builder.f56505l == null ? Network.DEFAULT : builder.f56505l;
        this.f56490m = builder.f56506m == null ? URLConnectionFactory.newBuilder().build() : builder.f56506m;
        this.f56491n = builder.f56507n == null ? CookieStore.DEFAULT : builder.f56507n;
        this.f56492o = Collections.unmodifiableList(builder.f56508o);
        this.f56493p = builder.f56509p == null ? Converter.DEFAULT : builder.f56509p;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public CacheStore getCacheStore() {
        return this.f56488k;
    }

    public Charset getCharset() {
        return this.f56480c;
    }

    public ConnectFactory getConnectFactory() {
        return this.f56490m;
    }

    public int getConnectTimeout() {
        return this.f56485h;
    }

    public Converter getConverter() {
        return this.f56493p;
    }

    public CookieStore getCookieStore() {
        return this.f56491n;
    }

    public Headers getHeaders() {
        return this.f56481d;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f56484g;
    }

    public List<Interceptor> getInterceptor() {
        return this.f56492o;
    }

    public Executor getMainExecutor() {
        return this.f56479b;
    }

    public Network getNetwork() {
        return this.f56489l;
    }

    public Params getParams() {
        return this.f56487j;
    }

    public Proxy getProxy() {
        return this.f56482e;
    }

    public int getReadTimeout() {
        return this.f56486i;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f56483f;
    }

    public Executor getWorkExecutor() {
        return this.f56478a;
    }
}
