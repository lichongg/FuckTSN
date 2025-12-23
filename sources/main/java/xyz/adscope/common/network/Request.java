package xyz.adscope.common.network;

import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class Request {

    /* renamed from: a, reason: collision with root package name */
    private final RequestMethod f56512a;

    /* renamed from: b, reason: collision with root package name */
    private final Headers f56513b;

    /* renamed from: c, reason: collision with root package name */
    private final Proxy f56514c;

    /* renamed from: d, reason: collision with root package name */
    private final SSLSocketFactory f56515d;

    /* renamed from: e, reason: collision with root package name */
    private final HostnameVerifier f56516e;

    /* renamed from: f, reason: collision with root package name */
    private final int f56517f;

    /* renamed from: g, reason: collision with root package name */
    private final int f56518g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f56519h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Api<T extends Api<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final RequestMethod f56520a;

        /* renamed from: b, reason: collision with root package name */
        private final Headers f56521b;

        /* renamed from: c, reason: collision with root package name */
        private Proxy f56522c;

        /* renamed from: d, reason: collision with root package name */
        private SSLSocketFactory f56523d;

        /* renamed from: e, reason: collision with root package name */
        private HostnameVerifier f56524e;

        /* renamed from: f, reason: collision with root package name */
        private int f56525f;

        /* renamed from: g, reason: collision with root package name */
        private int f56526g;

        /* renamed from: h, reason: collision with root package name */
        private Object f56527h;

        public abstract T clearParams();

        public T connectTimeout(int i6, TimeUnit timeUnit) {
            this.f56525f = (int) Math.min(timeUnit.toMillis(i6), 2147483647L);
            return this;
        }

        public abstract T param(String str, char c6);

        public abstract T param(String str, double d6);

        public abstract T param(String str, float f6);

        public abstract T param(String str, int i6);

        public abstract T param(String str, long j6);

        public abstract T param(String str, String str2);

        public abstract T param(String str, List<String> list);

        public abstract T param(String str, short s5);

        public abstract T param(String str, boolean z5);

        public abstract T path(char c6);

        public abstract T path(double d6);

        public abstract T path(float f6);

        public abstract T path(int i6);

        public abstract T path(long j6);

        public abstract T path(String str);

        public abstract T path(boolean z5);

        public T readTimeout(int i6, TimeUnit timeUnit) {
            this.f56526g = (int) Math.min(timeUnit.toMillis(i6), 2147483647L);
            return this;
        }

        public abstract T removeParam(String str);

        public T addHeader(String str, String str2) {
            this.f56521b.add(str, str2);
            return this;
        }

        public T clearHeaders() {
            this.f56521b.clear();
            return this;
        }

        public T hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f56524e = hostnameVerifier;
            return this;
        }

        public T proxy(Proxy proxy) {
            this.f56522c = proxy;
            return this;
        }

        public T removeHeader(String str) {
            this.f56521b.remove(str);
            return this;
        }

        public T setHeader(String str, String str2) {
            this.f56521b.set(str, str2);
            return this;
        }

        public T setHeaders(Headers headers) {
            this.f56521b.set(headers);
            return this;
        }

        public T sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f56523d = sSLSocketFactory;
            return this;
        }

        public T tag(Object obj) {
            this.f56527h = obj;
            return this;
        }

        protected Api(RequestMethod requestMethod) {
            Headers headers = new Headers();
            this.f56521b = headers;
            this.f56522c = Kalle.getConfig().getProxy();
            this.f56523d = Kalle.getConfig().getSSLSocketFactory();
            this.f56524e = Kalle.getConfig().getHostnameVerifier();
            this.f56525f = Kalle.getConfig().getConnectTimeout();
            this.f56526g = Kalle.getConfig().getReadTimeout();
            this.f56520a = requestMethod;
            headers.add(Kalle.getConfig().getHeaders());
        }
    }

    public abstract RequestBody body();

    public abstract Params copyParams();

    public abstract Url url();

    public int connectTimeout() {
        return this.f56517f;
    }

    public Headers headers() {
        return this.f56513b;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f56516e;
    }

    public RequestMethod method() {
        return this.f56512a;
    }

    public Proxy proxy() {
        return this.f56514c;
    }

    public int readTimeout() {
        return this.f56518g;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f56515d;
    }

    public Object tag() {
        return this.f56519h;
    }

    protected <T extends Api<T>> Request(Api<T> api) {
        this.f56512a = ((Api) api).f56520a;
        this.f56513b = ((Api) api).f56521b;
        this.f56514c = ((Api) api).f56522c;
        this.f56515d = ((Api) api).f56523d;
        this.f56516e = ((Api) api).f56524e;
        this.f56517f = ((Api) api).f56525f;
        this.f56518g = ((Api) api).f56526g;
        this.f56519h = ((Api) api).f56527h;
    }
}
