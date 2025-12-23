package okhttp3;

import com.umeng.analytics.pro.bi;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nOkHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1388:1\n2746#2,3:1389\n2746#2,3:1392\n1#3:1395\n*S KotlinDebug\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient\n*L\n278#1:1389,3\n340#1:1392,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class OkHttpClient implements Call.Factory, WebSocket.Factory {

    @NotNull
    private final Authenticator authenticator;

    @Nullable
    private final Cache cache;
    private final int callTimeoutMillis;

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;

    @NotNull
    private final ConnectionPool connectionPool;

    @NotNull
    private final List<ConnectionSpec> connectionSpecs;

    @NotNull
    private final CookieJar cookieJar;

    @NotNull
    private final Dispatcher dispatcher;

    @NotNull
    private final Dns dns;

    @NotNull
    private final EventListener.Factory eventListenerFactory;
    private final boolean fastFallback;
    private final boolean followRedirects;
    private final boolean followSslRedirects;

    @NotNull
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;

    @NotNull
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;

    @NotNull
    private final List<Protocol> protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @NotNull
    private final RouteDatabase routeDatabase;

    @NotNull
    private final SocketFactory socketFactory;

    @Nullable
    private final SSLSocketFactory sslSocketFactoryOrNull;

    @NotNull
    private final TaskRunner taskRunner;
    private final int webSocketCloseTimeout;
    private final int writeTimeoutMillis;

    @Nullable
    private final X509TrustManager x509TrustManager;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final List<Protocol> DEFAULT_PROTOCOLS = _UtilJvmKt.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);

    @NotNull
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = _UtilJvmKt.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nOkHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,1388:1\n1#2:1389\n242#3:1390\n*S KotlinDebug\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient$Builder\n*L\n1048#1:1390\n*E\n"})
    public static final class Builder {

        @NotNull
        private Authenticator authenticator;

        @Nullable
        private Cache cache;
        private int callTimeout;

        @Nullable
        private CertificateChainCleaner certificateChainCleaner;

        @NotNull
        private CertificatePinner certificatePinner;
        private int connectTimeout;

        @Nullable
        private ConnectionPool connectionPool;

        @NotNull
        private List<ConnectionSpec> connectionSpecs;

        @NotNull
        private CookieJar cookieJar;

        @NotNull
        private Dispatcher dispatcher;

        @NotNull
        private Dns dns;

        @NotNull
        private EventListener.Factory eventListenerFactory;
        private boolean fastFallback;
        private boolean followRedirects;
        private boolean followSslRedirects;

        @NotNull
        private HostnameVerifier hostnameVerifier;

        @NotNull
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;

        @NotNull
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;

        @NotNull
        private List<? extends Protocol> protocols;

        @Nullable
        private Proxy proxy;

        @NotNull
        private Authenticator proxyAuthenticator;

        @Nullable
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;

        @Nullable
        private RouteDatabase routeDatabase;

        @NotNull
        private SocketFactory socketFactory;

        @Nullable
        private SSLSocketFactory sslSocketFactoryOrNull;

        @Nullable
        private TaskRunner taskRunner;
        private int webSocketCloseTimeout;
        private int writeTimeout;

        @Nullable
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = _UtilJvmKt.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            this.fastFallback = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            g0.o(socketFactory, "getDefault(...)");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.webSocketCloseTimeout = 60000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        @NotNull
        public final Builder callTimeout(long j6, @NotNull TimeUnit unit) {
            g0.p(unit, "unit");
            this.callTimeout = _UtilJvmKt.checkDuration("timeout", j6, unit);
            return this;
        }

        @NotNull
        public final Builder connectTimeout(long j6, @NotNull TimeUnit unit) {
            g0.p(unit, "unit");
            this.connectTimeout = _UtilJvmKt.checkDuration("timeout", j6, unit);
            return this;
        }

        @NotNull
        public final Builder pingInterval(long j6, @NotNull TimeUnit unit) {
            g0.p(unit, "unit");
            this.pingInterval = _UtilJvmKt.checkDuration(bi.aX, j6, unit);
            return this;
        }

        @NotNull
        public final Builder readTimeout(long j6, @NotNull TimeUnit unit) {
            g0.p(unit, "unit");
            this.readTimeout = _UtilJvmKt.checkDuration("timeout", j6, unit);
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
            g0.p(sslSocketFactory, "sslSocketFactory");
            if (!g0.g(sslSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            Platform.Companion companion = Platform.Companion;
            X509TrustManager trustManager = companion.get().trustManager(sslSocketFactory);
            if (trustManager != null) {
                this.x509TrustManagerOrNull = trustManager;
                Platform platform = companion.get();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                g0.m(x509TrustManager);
                this.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        @NotNull
        public final Builder webSocketCloseTimeout(long j6, @NotNull TimeUnit unit) {
            g0.p(unit, "unit");
            this.webSocketCloseTimeout = _UtilJvmKt.checkDuration("webSocketCloseTimeout", j6, unit);
            return this;
        }

        @NotNull
        public final Builder writeTimeout(long j6, @NotNull TimeUnit unit) {
            g0.p(unit, "unit");
            this.writeTimeout = _UtilJvmKt.checkDuration("timeout", j6, unit);
            return this;
        }

        @JvmName(name = "-addInterceptor")
        @NotNull
        /* renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m258addInterceptor(@NotNull final Function1<? super Interceptor.Chain, Response> block) {
            g0.p(block, "block");
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$2
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    g0.p(chain, "chain");
                    return block.invoke(chain);
                }
            });
        }

        @JvmName(name = "-addNetworkInterceptor")
        @NotNull
        /* renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m259addNetworkInterceptor(@NotNull final Function1<? super Interceptor.Chain, Response> block) {
            g0.p(block, "block");
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$2
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    g0.p(chain, "chain");
                    return block.invoke(chain);
                }
            });
        }

        @NotNull
        public final Builder addInterceptor(@NotNull Interceptor interceptor) {
            g0.p(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder addNetworkInterceptor(@NotNull Interceptor interceptor) {
            g0.p(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder authenticator(@NotNull Authenticator authenticator) {
            g0.p(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        @NotNull
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @NotNull
        public final Builder cache(@Nullable Cache cache) {
            this.cache = cache;
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder callTimeout(@NotNull Duration duration) {
            long millis;
            g0.p(duration, "duration");
            millis = duration.toMillis();
            callTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        /* renamed from: callTimeout-LRDsOJo, reason: not valid java name */
        public final Builder m260callTimeoutLRDsOJo(long j6) {
            this.callTimeout = _UtilJvmKt.m288checkDurationHG0u8IE("duration", j6);
            return this;
        }

        @NotNull
        public final Builder certificatePinner(@NotNull CertificatePinner certificatePinner) {
            g0.p(certificatePinner, "certificatePinner");
            if (!g0.g(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder connectTimeout(@NotNull Duration duration) {
            long millis;
            g0.p(duration, "duration");
            millis = duration.toMillis();
            connectTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        /* renamed from: connectTimeout-LRDsOJo, reason: not valid java name */
        public final Builder m261connectTimeoutLRDsOJo(long j6) {
            this.connectTimeout = _UtilJvmKt.m288checkDurationHG0u8IE("duration", j6);
            return this;
        }

        @NotNull
        public final Builder connectionPool(@NotNull ConnectionPool connectionPool) {
            g0.p(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        @NotNull
        public final Builder connectionSpecs(@NotNull List<ConnectionSpec> connectionSpecs) {
            g0.p(connectionSpecs, "connectionSpecs");
            if (!g0.g(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = _UtilJvmKt.toImmutableList(connectionSpecs);
            return this;
        }

        @NotNull
        public final Builder cookieJar(@NotNull CookieJar cookieJar) {
            g0.p(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull Dispatcher dispatcher) {
            g0.p(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        @NotNull
        public final Builder dns(@NotNull Dns dns) {
            g0.p(dns, "dns");
            if (!g0.g(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener) {
            g0.p(eventListener, "eventListener");
            this.eventListenerFactory = _UtilJvmKt.asFactory(eventListener);
            return this;
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull EventListener.Factory eventListenerFactory) {
            g0.p(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        @NotNull
        public final Builder fastFallback(boolean z5) {
            this.fastFallback = z5;
            return this;
        }

        @NotNull
        public final Builder followRedirects(boolean z5) {
            this.followRedirects = z5;
            return this;
        }

        @NotNull
        public final Builder followSslRedirects(boolean z5) {
            this.followSslRedirects = z5;
            return this;
        }

        @NotNull
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @Nullable
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @Nullable
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @NotNull
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @Nullable
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @NotNull
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @NotNull
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @NotNull
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @NotNull
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @NotNull
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFastFallback$okhttp() {
            return this.fastFallback;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @NotNull
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @NotNull
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @NotNull
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @NotNull
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        @Nullable
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @NotNull
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @Nullable
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @Nullable
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @NotNull
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @Nullable
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        @Nullable
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final int getWebSocketCloseTimeout$okhttp() {
            return this.webSocketCloseTimeout;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @Nullable
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @NotNull
        public final Builder hostnameVerifier(@NotNull HostnameVerifier hostnameVerifier) {
            g0.p(hostnameVerifier, "hostnameVerifier");
            if (!g0.g(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @NotNull
        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        @NotNull
        public final Builder minWebSocketMessageToCompress(long j6) {
            if (j6 >= 0) {
                this.minWebSocketMessageToCompress = j6;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + j6).toString());
        }

        @NotNull
        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder pingInterval(@NotNull Duration duration) {
            long millis;
            g0.p(duration, "duration");
            millis = duration.toMillis();
            pingInterval(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        /* renamed from: pingInterval-LRDsOJo, reason: not valid java name */
        public final Builder m262pingIntervalLRDsOJo(long j6) {
            this.pingInterval = _UtilJvmKt.m288checkDurationHG0u8IE("duration", j6);
            return this;
        }

        @NotNull
        public final Builder protocols(@NotNull List<? extends Protocol> protocols) {
            g0.p(protocols, "protocols");
            List d6 = f0.d6(protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!d6.contains(protocol) && !d6.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + d6).toString());
            }
            if (d6.contains(protocol) && d6.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + d6).toString());
            }
            if (d6.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + d6).toString());
            }
            g0.n(d6, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if (d6.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            d6.remove(Protocol.SPDY_3);
            if (!g0.g(d6, this.protocols)) {
                this.routeDatabase = null;
            }
            List<? extends Protocol> unmodifiableList = Collections.unmodifiableList(d6);
            g0.o(unmodifiableList, "unmodifiableList(...)");
            this.protocols = unmodifiableList;
            return this;
        }

        @NotNull
        public final Builder proxy(@Nullable Proxy proxy) {
            if (!g0.g(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        @NotNull
        public final Builder proxyAuthenticator(@NotNull Authenticator proxyAuthenticator) {
            g0.p(proxyAuthenticator, "proxyAuthenticator");
            if (!g0.g(proxyAuthenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        @NotNull
        public final Builder proxySelector(@NotNull ProxySelector proxySelector) {
            g0.p(proxySelector, "proxySelector");
            if (!g0.g(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder readTimeout(@NotNull Duration duration) {
            long millis;
            g0.p(duration, "duration");
            millis = duration.toMillis();
            readTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        /* renamed from: readTimeout-LRDsOJo, reason: not valid java name */
        public final Builder m263readTimeoutLRDsOJo(long j6) {
            this.readTimeout = _UtilJvmKt.m288checkDurationHG0u8IE("duration", j6);
            return this;
        }

        @NotNull
        public final Builder retryOnConnectionFailure(boolean z5) {
            this.retryOnConnectionFailure = z5;
            return this;
        }

        public final void setAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            g0.p(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(@Nullable Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i6) {
            this.callTimeout = i6;
        }

        public final void setCertificateChainCleaner$okhttp(@Nullable CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(@NotNull CertificatePinner certificatePinner) {
            g0.p(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i6) {
            this.connectTimeout = i6;
        }

        public final void setConnectionPool$okhttp(@Nullable ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(@NotNull List<ConnectionSpec> list) {
            g0.p(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(@NotNull CookieJar cookieJar) {
            g0.p(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(@NotNull Dispatcher dispatcher) {
            g0.p(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(@NotNull Dns dns) {
            g0.p(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(@NotNull EventListener.Factory factory) {
            g0.p(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFastFallback$okhttp(boolean z5) {
            this.fastFallback = z5;
        }

        public final void setFollowRedirects$okhttp(boolean z5) {
            this.followRedirects = z5;
        }

        public final void setFollowSslRedirects$okhttp(boolean z5) {
            this.followSslRedirects = z5;
        }

        public final void setHostnameVerifier$okhttp(@NotNull HostnameVerifier hostnameVerifier) {
            g0.p(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j6) {
            this.minWebSocketMessageToCompress = j6;
        }

        public final void setPingInterval$okhttp(int i6) {
            this.pingInterval = i6;
        }

        public final void setProtocols$okhttp(@NotNull List<? extends Protocol> list) {
            g0.p(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(@Nullable Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            g0.p(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(@Nullable ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i6) {
            this.readTimeout = i6;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z5) {
            this.retryOnConnectionFailure = z5;
        }

        public final void setRouteDatabase$okhttp(@Nullable RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(@NotNull SocketFactory socketFactory) {
            g0.p(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@Nullable SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setTaskRunner$okhttp(@Nullable TaskRunner taskRunner) {
            this.taskRunner = taskRunner;
        }

        public final void setWebSocketCloseTimeout$okhttp(int i6) {
            this.webSocketCloseTimeout = i6;
        }

        public final void setWriteTimeout$okhttp(int i6) {
            this.writeTimeout = i6;
        }

        public final void setX509TrustManagerOrNull$okhttp(@Nullable X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @NotNull
        public final Builder socketFactory(@NotNull SocketFactory socketFactory) {
            g0.p(socketFactory, "socketFactory");
            if (socketFactory instanceof SSLSocketFactory) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
            }
            if (!g0.g(socketFactory, this.socketFactory)) {
                this.routeDatabase = null;
            }
            this.socketFactory = socketFactory;
            return this;
        }

        @NotNull
        public final Builder taskRunner$okhttp(@NotNull TaskRunner taskRunner) {
            g0.p(taskRunner, "taskRunner");
            this.taskRunner = taskRunner;
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder webSocketCloseTimeout(@NotNull Duration duration) {
            long millis;
            g0.p(duration, "duration");
            millis = duration.toMillis();
            webSocketCloseTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        /* renamed from: webSocketCloseTimeout-LRDsOJo, reason: not valid java name */
        public final Builder m264webSocketCloseTimeoutLRDsOJo(long j6) {
            this.webSocketCloseTimeout = _UtilJvmKt.m288checkDurationHG0u8IE("duration", j6);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder writeTimeout(@NotNull Duration duration) {
            long millis;
            g0.p(duration, "duration");
            millis = duration.toMillis();
            writeTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        /* renamed from: writeTimeout-LRDsOJo, reason: not valid java name */
        public final Builder m265writeTimeoutLRDsOJo(long j6) {
            this.writeTimeout = _UtilJvmKt.m288checkDurationHG0u8IE("duration", j6);
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory, @NotNull X509TrustManager trustManager) {
            g0.p(sslSocketFactory, "sslSocketFactory");
            g0.p(trustManager, "trustManager");
            if (!g0.g(sslSocketFactory, this.sslSocketFactoryOrNull) || !g0.g(trustManager, this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull OkHttpClient okHttpClient) {
            this();
            g0.p(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            f0.s0(this.interceptors, okHttpClient.interceptors());
            f0.s0(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.fastFallback = okHttpClient.fastFallback();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.webSocketCloseTimeout = okHttpClient.webSocketCloseTimeout();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase$okhttp();
            this.taskRunner = okHttpClient.getTaskRunner$okhttp();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        @NotNull
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }
    }

    public OkHttpClient(@NotNull Builder builder) {
        ProxySelector proxySelector$okhttp;
        g0.p(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.interceptors = _UtilJvmKt.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = _UtilJvmKt.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.fastFallback = builder.getFastFallback$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = NullProxySelector.INSTANCE;
        } else {
            proxySelector$okhttp = builder.getProxySelector$okhttp();
            if (proxySelector$okhttp == null && (proxySelector$okhttp = ProxySelector.getDefault()) == null) {
                proxySelector$okhttp = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.webSocketCloseTimeout = builder.getWebSocketCloseTimeout$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new RouteDatabase() : routeDatabase$okhttp;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp == null ? TaskRunner.INSTANCE : taskRunner$okhttp;
        ConnectionPool connectionPool$okhttp = builder.getConnectionPool$okhttp();
        if (connectionPool$okhttp == null) {
            connectionPool$okhttp = new ConnectionPool();
            builder.setConnectionPool$okhttp(connectionPool$okhttp);
        }
        this.connectionPool = connectionPool$okhttp;
        List<ConnectionSpec> list = connectionSpecs$okhttp;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).isTls()) {
                    if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
                        CertificateChainCleaner certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
                        g0.m(certificateChainCleaner$okhttp);
                        this.certificateChainCleaner = certificateChainCleaner$okhttp;
                        X509TrustManager x509TrustManagerOrNull$okhttp = builder.getX509TrustManagerOrNull$okhttp();
                        g0.m(x509TrustManagerOrNull$okhttp);
                        this.x509TrustManager = x509TrustManagerOrNull$okhttp;
                        this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(certificateChainCleaner$okhttp);
                    } else {
                        Platform.Companion companion = Platform.Companion;
                        X509TrustManager platformTrustManager = companion.get().platformTrustManager();
                        this.x509TrustManager = platformTrustManager;
                        this.sslSocketFactoryOrNull = companion.get().newSslSocketFactory(platformTrustManager);
                        CertificateChainCleaner certificateChainCleaner = CertificateChainCleaner.Companion.get(platformTrustManager);
                        this.certificateChainCleaner = certificateChainCleaner;
                        this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(certificateChainCleaner);
                    }
                    verifyClientState();
                }
            }
        }
        this.sslSocketFactoryOrNull = null;
        this.certificateChainCleaner = null;
        this.x509TrustManager = null;
        this.certificatePinner = CertificatePinner.DEFAULT;
        verifyClientState();
    }

    private final void verifyClientState() {
        List<Interceptor> list = this.interceptors;
        g0.n(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<Interceptor> list2 = this.networkInterceptors;
        g0.n(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<ConnectionSpec> list3 = this.connectionSpecs;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).isTls()) {
                    if (this.sslSocketFactoryOrNull == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.sslSocketFactoryOrNull != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.certificateChainCleaner != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!g0.g(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.");
        }
        n1 n1Var = n1.f44123a;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authenticator", imports = {}))
    @JvmName(name = "-deprecated_authenticator")
    @NotNull
    /* renamed from: -deprecated_authenticator, reason: not valid java name */
    public final Authenticator m232deprecated_authenticator() {
        return this.authenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cache", imports = {}))
    @JvmName(name = "-deprecated_cache")
    @Nullable
    /* renamed from: -deprecated_cache, reason: not valid java name */
    public final Cache m233deprecated_cache() {
        return this.cache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "callTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_callTimeoutMillis")
    /* renamed from: -deprecated_callTimeoutMillis, reason: not valid java name */
    public final int m234deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}))
    @JvmName(name = "-deprecated_certificatePinner")
    @NotNull
    /* renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m235deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_connectTimeoutMillis")
    /* renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name */
    public final int m236deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionPool", imports = {}))
    @JvmName(name = "-deprecated_connectionPool")
    @NotNull
    /* renamed from: -deprecated_connectionPool, reason: not valid java name */
    public final ConnectionPool m237deprecated_connectionPool() {
        return this.connectionPool;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}))
    @JvmName(name = "-deprecated_connectionSpecs")
    @NotNull
    /* renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m238deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cookieJar", imports = {}))
    @JvmName(name = "-deprecated_cookieJar")
    @NotNull
    /* renamed from: -deprecated_cookieJar, reason: not valid java name */
    public final CookieJar m239deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dispatcher", imports = {}))
    @JvmName(name = "-deprecated_dispatcher")
    @NotNull
    /* renamed from: -deprecated_dispatcher, reason: not valid java name */
    public final Dispatcher m240deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}))
    @JvmName(name = "-deprecated_dns")
    @NotNull
    /* renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m241deprecated_dns() {
        return this.dns;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "eventListenerFactory", imports = {}))
    @JvmName(name = "-deprecated_eventListenerFactory")
    @NotNull
    /* renamed from: -deprecated_eventListenerFactory, reason: not valid java name */
    public final EventListener.Factory m242deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followRedirects", imports = {}))
    @JvmName(name = "-deprecated_followRedirects")
    /* renamed from: -deprecated_followRedirects, reason: not valid java name */
    public final boolean m243deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followSslRedirects", imports = {}))
    @JvmName(name = "-deprecated_followSslRedirects")
    /* renamed from: -deprecated_followSslRedirects, reason: not valid java name */
    public final boolean m244deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}))
    @JvmName(name = "-deprecated_hostnameVerifier")
    @NotNull
    /* renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m245deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "interceptors", imports = {}))
    @JvmName(name = "-deprecated_interceptors")
    @NotNull
    /* renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m246deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkInterceptors", imports = {}))
    @JvmName(name = "-deprecated_networkInterceptors")
    @NotNull
    /* renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m247deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pingIntervalMillis", imports = {}))
    @JvmName(name = "-deprecated_pingIntervalMillis")
    /* renamed from: -deprecated_pingIntervalMillis, reason: not valid java name */
    public final int m248deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))
    @JvmName(name = "-deprecated_protocols")
    @NotNull
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m249deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))
    @JvmName(name = "-deprecated_proxy")
    @Nullable
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m250deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}))
    @JvmName(name = "-deprecated_proxyAuthenticator")
    @NotNull
    /* renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m251deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}))
    @JvmName(name = "-deprecated_proxySelector")
    @NotNull
    /* renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m252deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "readTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_readTimeoutMillis")
    /* renamed from: -deprecated_readTimeoutMillis, reason: not valid java name */
    public final int m253deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "retryOnConnectionFailure", imports = {}))
    @JvmName(name = "-deprecated_retryOnConnectionFailure")
    /* renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name */
    public final boolean m254deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}))
    @JvmName(name = "-deprecated_socketFactory")
    @NotNull
    /* renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m255deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "writeTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_writeTimeoutMillis")
    /* renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name */
    public final int m257deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @NotNull
    public final Address address(@NotNull HttpUrl url) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        g0.p(url, "url");
        if (url.isHttps()) {
            sSLSocketFactory = sslSocketFactory();
            hostnameVerifier = this.hostnameVerifier;
            certificatePinner = this.certificatePinner;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(url.host(), url.port(), this.dns, this.socketFactory, sSLSocketFactory, hostnameVerifier, certificatePinner, this.proxyAuthenticator, this.proxy, this.protocols, this.connectionSpecs, this.proxySelector);
    }

    @JvmName(name = "authenticator")
    @NotNull
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @JvmName(name = "cache")
    @Nullable
    public final Cache cache() {
        return this.cache;
    }

    @JvmName(name = "callTimeoutMillis")
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @JvmName(name = "certificateChainCleaner")
    @Nullable
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @JvmName(name = "certificatePinner")
    @NotNull
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @JvmName(name = "connectTimeoutMillis")
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @JvmName(name = "connectionPool")
    @NotNull
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @JvmName(name = "connectionSpecs")
    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName(name = "cookieJar")
    @NotNull
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @JvmName(name = "dispatcher")
    @NotNull
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @JvmName(name = "dns")
    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    @JvmName(name = "eventListenerFactory")
    @NotNull
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @JvmName(name = "fastFallback")
    public final boolean fastFallback() {
        return this.fastFallback;
    }

    @JvmName(name = "followRedirects")
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @JvmName(name = "followSslRedirects")
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @NotNull
    public final RouteDatabase getRouteDatabase$okhttp() {
        return this.routeDatabase;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @JvmName(name = "hostnameVerifier")
    @NotNull
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName(name = "interceptors")
    @NotNull
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @JvmName(name = "minWebSocketMessageToCompress")
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @JvmName(name = "networkInterceptors")
    @NotNull
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @NotNull
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    @NotNull
    public Call newCall(@NotNull Request request) {
        g0.p(request, "request");
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @NotNull
    public WebSocket newWebSocket(@NotNull Request request, @NotNull WebSocketListener listener) {
        g0.p(request, "request");
        g0.p(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(this.taskRunner, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress, this.webSocketCloseTimeout);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    @JvmName(name = "pingIntervalMillis")
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @JvmName(name = "protocols")
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName(name = "proxy")
    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName(name = "proxyAuthenticator")
    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName(name = "proxySelector")
    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName(name = "readTimeoutMillis")
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @JvmName(name = "retryOnConnectionFailure")
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @JvmName(name = "socketFactory")
    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName(name = "sslSocketFactory")
    @NotNull
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @JvmName(name = "webSocketCloseTimeout")
    public final int webSocketCloseTimeout() {
        return this.webSocketCloseTimeout;
    }

    @JvmName(name = "writeTimeoutMillis")
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @JvmName(name = "x509TrustManager")
    @Nullable
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}))
    @JvmName(name = "-deprecated_sslSocketFactory")
    @NotNull
    /* renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m256deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
