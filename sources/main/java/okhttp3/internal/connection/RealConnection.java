package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.FlowControlListener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.Buffer;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealConnection.kt\nokhttp3/internal/connection/RealConnection\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,463:1\n63#2:464\n63#2:465\n63#2:466\n55#2,4:467\n55#2,4:474\n49#2,4:478\n63#2:482\n63#2:483\n63#2:484\n1761#3,3:471\n*S KotlinDebug\n*F\n+ 1 RealConnection.kt\nokhttp3/internal/connection/RealConnection\n*L\n133#1:464\n141#1:465\n147#1:466\n185#1:467,4\n241#1:474,4\n301#1:478,4\n318#1:482\n337#1:483\n372#1:484\n234#1:471,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection, ExchangeCodec.Carrier, Lockable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private int allocationLimit;

    @NotNull
    private final List<Reference<RealCall>> calls;

    @NotNull
    private final ConnectionListener connectionListener;

    @NotNull
    private final RealConnectionPool connectionPool;

    @Nullable
    private final Handshake handshake;

    @Nullable
    private Http2Connection http2Connection;
    private long idleAtNs;

    @NotNull
    private final Socket javaNetSocket;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private final int pingIntervalMillis;

    @NotNull
    private final Protocol protocol;

    @NotNull
    private final Socket rawSocket;
    private int refusedStreamCount;

    @NotNull
    private final Route route;
    private int routeFailureCount;

    @NotNull
    private final BufferedSocket socket;
    private int successCount;

    @NotNull
    private final TaskRunner taskRunner;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final RealConnection newTestConnection(@NotNull TaskRunner taskRunner, @NotNull RealConnectionPool connectionPool, @NotNull Route route, @NotNull Socket socket, long j6) {
            g0.p(taskRunner, "taskRunner");
            g0.p(connectionPool, "connectionPool");
            g0.p(route, "route");
            g0.p(socket, "socket");
            RealConnection realConnection = new RealConnection(taskRunner, connectionPool, route, new Socket(), socket, null, Protocol.HTTP_2, new BufferedSocket() { // from class: okhttp3.internal.connection.RealConnection$Companion$newTestConnection$bufferedSocket$1
                private final Buffer sink = new Buffer();
                private final Buffer source = new Buffer();

                @Override // okio.Socket
                public Buffer getSink() {
                    return this.sink;
                }

                @Override // okio.Socket
                public Buffer getSource() {
                    return this.source;
                }

                @Override // okio.Socket
                public void cancel() {
                }
            }, 0, ConnectionListener.Companion.getNONE());
            realConnection.setIdleAtNs(j6);
            return realConnection;
        }
    }

    public final void incrementSuccessCount$okhttp() {
        synchronized (this) {
            this.successCount++;
        }
    }

    public final void noCoalescedConnections$okhttp() {
        synchronized (this) {
            this.noCoalescedConnections = true;
            n1 n1Var = n1.f44123a;
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
        synchronized (this) {
            this.noNewExchanges = true;
            n1 n1Var = n1.f44123a;
        }
        this.connectionListener.noNewExchanges(this);
    }

    public RealConnection(@NotNull TaskRunner taskRunner, @NotNull RealConnectionPool connectionPool, @NotNull Route route, @NotNull Socket rawSocket, @NotNull Socket javaNetSocket, @Nullable Handshake handshake, @NotNull Protocol protocol, @NotNull BufferedSocket socket, int i6, @NotNull ConnectionListener connectionListener) {
        g0.p(taskRunner, "taskRunner");
        g0.p(connectionPool, "connectionPool");
        g0.p(route, "route");
        g0.p(rawSocket, "rawSocket");
        g0.p(javaNetSocket, "javaNetSocket");
        g0.p(protocol, "protocol");
        g0.p(socket, "socket");
        g0.p(connectionListener, "connectionListener");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.route = route;
        this.rawSocket = rawSocket;
        this.javaNetSocket = javaNetSocket;
        this.handshake = handshake;
        this.protocol = protocol;
        this.socket = socket;
        this.pingIntervalMillis = i6;
        this.connectionListener = connectionListener;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    private final boolean routeMatchesAny(List<Route> list) {
        List<Route> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (Route route : list2) {
            Proxy.Type type = route.proxy().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && getRoute().proxy().type() == type2 && g0.g(getRoute().socketAddress(), route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final void startHttp2() throws IOException {
        this.javaNetSocket.setSoTimeout(0);
        Object obj = this.connectionListener;
        FlowControlListener flowControlListener = obj instanceof FlowControlListener ? (FlowControlListener) obj : null;
        if (flowControlListener == null) {
            flowControlListener = FlowControlListener.None.INSTANCE;
        }
        Http2Connection build = new Http2Connection.Builder(true, this.taskRunner).socket(this.socket, getRoute().address().url().host()).listener(this).pingIntervalMillis(this.pingIntervalMillis).flowControlListener(flowControlListener).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, 1, null);
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(this)) {
            HttpUrl url = getRoute().address().url();
            if (httpUrl.port() != url.port()) {
                return false;
            }
            if (g0.g(httpUrl.host(), url.host())) {
                return true;
            }
            return (this.noCoalescedConnections || (handshake = this.handshake) == null || !certificateSupportHost(httpUrl, handshake)) ? false : true;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo289cancel() {
        _UtilJvmKt.closeQuietly(this.rawSocket);
    }

    public final void connectFailed$okhttp(@NotNull OkHttpClient client, @NotNull Route failedRoute, @NotNull IOException failure) {
        g0.p(client, "client");
        g0.p(failedRoute, "failedRoute");
        g0.p(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase$okhttp().failed(failedRoute);
    }

    public final int getAllocationLimit$okhttp() {
        return this.allocationLimit;
    }

    @NotNull
    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    @NotNull
    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    @NotNull
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    public Route getRoute() {
        return this.route;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    @NotNull
    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    @Override // okhttp3.Connection
    @Nullable
    public Handshake handshake() {
        return this.handshake;
    }

    public final boolean isEligible$okhttp(@NotNull Address address, @Nullable List<Route> list) {
        g0.p(address, "address");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !getRoute().address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (g0.g(address.url().host(), route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            g0.m(certificatePinner);
            String host = address.url().host();
            Handshake handshake = handshake();
            g0.m(handshake);
            certificatePinner.check(host, handshake.peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean isHealthy(boolean z5) {
        long j6;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long nanoTime = System.nanoTime();
        if (this.rawSocket.isClosed() || this.javaNetSocket.isClosed() || this.javaNetSocket.isInputShutdown() || this.javaNetSocket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(nanoTime);
        }
        synchronized (this) {
            j6 = nanoTime - this.idleAtNs;
        }
        if (j6 < IDLE_CONNECTION_HEALTHY_NS || !z5) {
            return true;
        }
        return _UtilJvmKt.isHealthy(this.javaNetSocket, this.socket.getSource());
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    @NotNull
    public final ExchangeCodec newCodec$okhttp(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) throws SocketException {
        g0.p(client, "client");
        g0.p(chain, "chain");
        BufferedSocket bufferedSocket = this.socket;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        this.javaNetSocket.setSoTimeout(chain.readTimeoutMillis());
        Timeout timeout = bufferedSocket.getSource().timeout();
        long readTimeoutMillis$okhttp = chain.getReadTimeoutMillis$okhttp();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        bufferedSocket.getSink().timeout().timeout(chain.getWriteTimeoutMillis$okhttp(), timeUnit);
        return new Http1ExchangeCodec(client, this, bufferedSocket);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
        g0.p(connection, "connection");
        g0.p(settings, "settings");
        synchronized (this) {
            this.allocationLimit = settings.getMaxConcurrentStreams();
            n1 n1Var = n1.f44123a;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(@NotNull Http2Stream stream) throws IOException {
        g0.p(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    @NotNull
    public Protocol protocol() {
        return this.protocol;
    }

    public final void setIdleAtNs(long j6) {
        this.idleAtNs = j6;
    }

    public final void setNoNewExchanges(boolean z5) {
        this.noNewExchanges = z5;
    }

    public final void setRouteFailureCount$okhttp(int i6) {
        this.routeFailureCount = i6;
    }

    @Override // okhttp3.Connection
    @NotNull
    public Socket socket() {
        return this.javaNetSocket;
    }

    @NotNull
    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(getRoute().address().url().host());
        sb.append(':');
        sb.append(getRoute().address().url().port());
        sb.append(", proxy=");
        sb.append(getRoute().proxy());
        sb.append(" hostAddress=");
        sb.append(getRoute().socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (obj = handshake.cipherSuite()) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(@NotNull RealCall call, @Nullable IOException iOException) {
        boolean z5;
        g0.p(call, "call");
        synchronized (this) {
            try {
                if (!(iOException instanceof StreamResetException)) {
                    if (isMultiplexed$okhttp()) {
                        if (iOException instanceof ConnectionShutdownException) {
                        }
                        z5 = false;
                        n1 n1Var = n1.f44123a;
                    }
                    boolean z6 = !this.noNewExchanges;
                    this.noNewExchanges = true;
                    if (this.successCount == 0) {
                        if (iOException != null) {
                            connectFailed$okhttp(call.getClient(), getRoute(), iOException);
                        }
                        this.routeFailureCount++;
                    }
                    z5 = z6;
                    n1 n1Var2 = n1.f44123a;
                } else if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i6 = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i6;
                    if (i6 > 1) {
                        z5 = !this.noNewExchanges;
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                        n1 n1Var22 = n1.f44123a;
                    }
                    z5 = false;
                    n1 n1Var222 = n1.f44123a;
                } else {
                    if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !call.isCanceled()) {
                        z5 = !this.noNewExchanges;
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                        n1 n1Var2222 = n1.f44123a;
                    }
                    z5 = false;
                    n1 n1Var22222 = n1.f44123a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            this.connectionListener.noNewExchanges(this);
        }
    }

    public final void useAsSocket$okhttp() {
        this.javaNetSocket.setSoTimeout(0);
        noNewExchanges();
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake) {
        List<Certificate> peerCertificates = handshake.peerCertificates();
        if (!peerCertificates.isEmpty()) {
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
            String host = httpUrl.host();
            Certificate certificate = peerCertificates.get(0);
            g0.n(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (okHostnameVerifier.verify(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.Connection
    @NotNull
    public Route route() {
        return getRoute();
    }

    public final void start() throws IOException {
        this.idleAtNs = System.nanoTime();
        Protocol protocol = this.protocol;
        if (protocol != Protocol.HTTP_2 && protocol != Protocol.H2_PRIOR_KNOWLEDGE) {
            return;
        }
        startHttp2();
    }
}
