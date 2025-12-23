package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class LoggingEventListener extends EventListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Factory implements EventListener.Factory {

        @NotNull
        private final HttpLoggingInterceptor.Logger logger;

        @JvmOverloads
        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @JvmOverloads
        public Factory(@NotNull HttpLoggingInterceptor.Logger logger) {
            g0.p(logger, "logger");
            this.logger = logger;
        }

        @Override // okhttp3.EventListener.Factory
        @NotNull
        public EventListener create(@NotNull Call call) {
            g0.p(call, "call");
            return new LoggingEventListener(this.logger, null);
        }

        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i6, v vVar) {
            this((i6 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, v vVar) {
        this(logger);
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        this.logger.log('[' + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
        g0.p(call, "call");
        g0.p(cachedResponse, "cachedResponse");
        logWithTime("cacheConditionalHit: " + cachedResponse);
    }

    @Override // okhttp3.EventListener
    public void cacheHit(@NotNull Call call, @NotNull Response response) {
        g0.p(call, "call");
        g0.p(response, "response");
        logWithTime("cacheHit: " + response);
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("cacheMiss");
    }

    @Override // okhttp3.EventListener
    public void callEnd(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(ioe, "ioe");
        logWithTime("callFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public void callStart(@NotNull Call call) {
        g0.p(call, "call");
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    @Override // okhttp3.EventListener
    public void canceled(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("canceled");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        g0.p(call, "call");
        g0.p(inetSocketAddress, "inetSocketAddress");
        g0.p(proxy, "proxy");
        logWithTime("connectEnd: " + protocol);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(inetSocketAddress, "inetSocketAddress");
        g0.p(proxy, "proxy");
        g0.p(ioe, "ioe");
        logWithTime("connectFailed: " + protocol + ' ' + ioe);
    }

    @Override // okhttp3.EventListener
    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        g0.p(call, "call");
        g0.p(inetSocketAddress, "inetSocketAddress");
        g0.p(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        g0.p(call, "call");
        g0.p(connection, "connection");
        logWithTime("connectionAcquired: " + connection);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        g0.p(call, "call");
        g0.p(connection, "connection");
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dispatcherQueueEnd(@NotNull Call call, @NotNull Dispatcher dispatcher) {
        g0.p(call, "call");
        g0.p(dispatcher, "dispatcher");
        logWithTime("dispatcherQueueEnd: " + call + " queuedCallsCount=" + dispatcher.queuedCallsCount());
    }

    @Override // okhttp3.EventListener
    public void dispatcherQueueStart(@NotNull Call call, @NotNull Dispatcher dispatcher) {
        g0.p(call, "call");
        g0.p(dispatcher, "dispatcher");
        logWithTime("dispatcherQueueStart: " + call + " queuedCallsCount=" + dispatcher.queuedCallsCount());
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<? extends InetAddress> inetAddressList) {
        g0.p(call, "call");
        g0.p(domainName, "domainName");
        g0.p(inetAddressList, "inetAddressList");
        logWithTime("dnsEnd: " + inetAddressList);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        g0.p(call, "call");
        g0.p(domainName, "domainName");
        logWithTime("dnsStart: " + domainName);
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<? extends Proxy> proxies) {
        g0.p(call, "call");
        g0.p(url, "url");
        g0.p(proxies, "proxies");
        logWithTime("proxySelectEnd: " + proxies);
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        g0.p(call, "call");
        g0.p(url, "url");
        logWithTime("proxySelectStart: " + url);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(@NotNull Call call, long j6) {
        g0.p(call, "call");
        logWithTime("requestBodyEnd: byteCount=" + j6);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(ioe, "ioe");
        logWithTime("requestFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        g0.p(call, "call");
        g0.p(request, "request");
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@NotNull Call call, long j6) {
        g0.p(call, "call");
        logWithTime("responseBodyEnd: byteCount=" + j6);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(ioe, "ioe");
        logWithTime("responseFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        g0.p(call, "call");
        g0.p(response, "response");
        logWithTime("responseHeadersEnd: " + response);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
        g0.p(call, "call");
        g0.p(response, "response");
        logWithTime("satisfactionFailure: " + response);
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        g0.p(call, "call");
        logWithTime("secureConnectEnd: " + handshake);
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(@NotNull Call call) {
        g0.p(call, "call");
        logWithTime("secureConnectStart");
    }
}
