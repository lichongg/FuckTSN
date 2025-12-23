package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.text.u;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConnectPlan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectPlan.kt\nokhttp3/internal/connection/ConnectPlan\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,564:1\n1#2:565\n63#3:566\n1563#4:567\n1634#4,3:568\n*S KotlinDebug\n*F\n+ 1 ConnectPlan.kt\nokhttp3/internal/connection/ConnectPlan\n*L\n508#1:566\n393#1:567\n393#1:568,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int MAX_TUNNEL_ATTEMPTS = 21;

    @NotNull
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final int attempt;

    @NotNull
    private final RealCall call;
    private volatile boolean canceled;

    @Nullable
    private RealConnection connection;

    @NotNull
    private final RealConnectionPool connectionPool;
    private final int connectionSpecIndex;

    @Nullable
    private Handshake handshake;
    private final boolean isTlsFallback;

    @Nullable
    private Socket javaNetSocket;
    private final int pingIntervalMillis;

    @Nullable
    private Protocol protocol;

    @Nullable
    private Socket rawSocket;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @NotNull
    private final Route route;

    @NotNull
    private final RealRoutePlanner routePlanner;

    @Nullable
    private final List<Route> routes;
    private BufferedSocket socket;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;

    @NotNull
    private final TaskRunner taskRunner;

    @Nullable
    private final Request tunnelRequest;
    private final int writeTimeoutMillis;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo289cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectPlan(@NotNull TaskRunner taskRunner, @NotNull RealConnectionPool connectionPool, int i6, int i7, int i8, int i9, int i10, boolean z5, @NotNull RealCall call, @NotNull RealRoutePlanner routePlanner, @NotNull Route route, @Nullable List<Route> list, int i11, @Nullable Request request, int i12, boolean z6) {
        g0.p(taskRunner, "taskRunner");
        g0.p(connectionPool, "connectionPool");
        g0.p(call, "call");
        g0.p(routePlanner, "routePlanner");
        g0.p(route, "route");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i6;
        this.writeTimeoutMillis = i7;
        this.socketConnectTimeoutMillis = i8;
        this.socketReadTimeoutMillis = i9;
        this.pingIntervalMillis = i10;
        this.retryOnConnectionFailure = z5;
        this.call = call;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = i11;
        this.tunnelRequest = request;
        this.connectionSpecIndex = i12;
        this.isTlsFallback = z6;
    }

    private final ConnectPlan copy(int i6, Request request, int i7, boolean z5) {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, getRoute(), this.routes, i6, request, i7, z5);
    }

    static /* synthetic */ ConnectPlan copy$default(ConnectPlan connectPlan, int i6, Request request, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = connectPlan.attempt;
        }
        if ((i8 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        if ((i8 & 4) != 0) {
            i7 = connectPlan.connectionSpecIndex;
        }
        if ((i8 & 8) != 0) {
            z5 = connectPlan.isTlsFallback;
        }
        return connectPlan.copy(i6, request, i7, z5);
    }

    private final Request createTunnel() throws IOException {
        Request request = this.tunnelRequest;
        g0.m(request);
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(getRoute().address().url(), true) + " HTTP/1.1";
        while (true) {
            BufferedSocket bufferedSocket = this.socket;
            if (bufferedSocket == null) {
                g0.S("socket");
                bufferedSocket = null;
            }
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, bufferedSocket);
            BufferedSocket bufferedSocket2 = this.socket;
            if (bufferedSocket2 == null) {
                g0.S("socket");
                bufferedSocket2 = null;
            }
            Timeout timeout = bufferedSocket2.getSource().timeout();
            long j6 = this.readTimeoutMillis;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            timeout.timeout(j6, timeUnit);
            BufferedSocket bufferedSocket3 = this.socket;
            if (bufferedSocket3 == null) {
                g0.S("socket");
                bufferedSocket3 = null;
            }
            bufferedSocket3.getSink().timeout().timeout(this.writeTimeoutMillis, timeUnit);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            g0.m(readResponseHeaders);
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code == 200) {
                return null;
            }
            if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
            Request authenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), build);
            if (authenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (u.a2("close", Response.header$default(build, "Connection", null, 2, null), true)) {
                return authenticate;
            }
            request = authenticate;
        }
    }

    public final void closeQuietly() {
        Socket socket = this.javaNetSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @org.jetbrains.annotations.NotNull
    /* renamed from: connectTcp */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RoutePlanner.ConnectResult mo293connectTcp() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.mo293connectTcp():okhttp3.internal.connection.RoutePlanner$ConnectResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01d8  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @org.jetbrains.annotations.NotNull
    /* renamed from: connectTlsEtc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RoutePlanner.ConnectResult mo294connectTlsEtc() {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.mo294connectTlsEtc():okhttp3.internal.connection.RoutePlanner$ConnectResult");
    }

    public final int getConnectionSpecIndex$okhttp() {
        return this.connectionSpecIndex;
    }

    @Nullable
    public final Socket getJavaNetSocket$okhttp() {
        return this.javaNetSocket;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    public Route getRoute() {
        return this.route;
    }

    @Nullable
    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: handleSuccess */
    public RealConnection mo290handleSuccess() {
        this.call.getClient().getRouteDatabase$okhttp().connected(getRoute());
        RealConnection realConnection = this.connection;
        g0.m(realConnection);
        realConnection.getConnectionListener$okhttp().connectEnd(realConnection, getRoute(), this.call);
        ReusePlan planReusePooledConnection$okhttp = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp.getConnection();
        }
        synchronized (realConnection) {
            this.connectionPool.put(realConnection);
            this.call.acquireConnectionNoEvents(realConnection);
            n1 n1Var = n1.f44123a;
        }
        this.call.getEventListener$okhttp().connectionAcquired(this.call, realConnection);
        realConnection.getConnectionListener$okhttp().connectionAcquired(realConnection, this.call);
        return realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.protocol != null;
    }

    public final boolean isTlsFallback$okhttp() {
        return this.isTlsFallback;
    }

    @Nullable
    public final ConnectPlan nextConnectionSpec$okhttp(@NotNull List<ConnectionSpec> connectionSpecs, @NotNull SSLSocket sslSocket) {
        g0.p(connectionSpecs, "connectionSpecs");
        g0.p(sslSocket, "sslSocket");
        int i6 = this.connectionSpecIndex + 1;
        int size = connectionSpecs.size();
        for (int i7 = i6; i7 < size; i7++) {
            if (connectionSpecs.get(i7).isCompatible(sslSocket)) {
                return copy$default(this, 0, null, i7, this.connectionSpecIndex != -1, 3, null);
            }
        }
        return null;
    }

    @NotNull
    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(@NotNull List<ConnectionSpec> connectionSpecs, @NotNull SSLSocket sslSocket) throws IOException {
        g0.p(connectionSpecs, "connectionSpecs");
        g0.p(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan nextConnectionSpec$okhttp = nextConnectionSpec$okhttp(connectionSpecs, sslSocket);
        if (nextConnectionSpec$okhttp != null) {
            return nextConnectionSpec$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isTlsFallback);
        sb.append(", modes=");
        sb.append(connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        g0.m(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        g0.o(arrays, "toString(...)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: retry */
    public RoutePlanner.Plan mo291retry() {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void setJavaNetSocket$okhttp(@Nullable Socket socket) {
        this.javaNetSocket = socket;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(@NotNull RealCall call, @Nullable IOException iOException) {
        g0.p(call, "call");
    }

    private final void connectSocket() throws IOException {
        int i6;
        Socket createSocket;
        Proxy.Type type = getRoute().proxy().type();
        if (type == null) {
            i6 = -1;
        } else {
            i6 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i6 != 1 && i6 != 2) {
            createSocket = new Socket(getRoute().proxy());
        } else {
            createSocket = getRoute().address().socketFactory().createSocket();
            g0.m(createSocket);
        }
        this.rawSocket = createSocket;
        if (!this.canceled) {
            createSocket.setSoTimeout(this.socketReadTimeoutMillis);
            try {
                Platform.Companion.get().connectSocket(createSocket, getRoute().socketAddress(), this.socketConnectTimeoutMillis);
                try {
                    this.socket = BufferedSocketKt.asBufferedSocket(createSocket);
                    return;
                } catch (NullPointerException e6) {
                    if (!g0.g(e6.getMessage(), NPE_THROW_WITH_NULL)) {
                        return;
                    } else {
                        throw new IOException(e6);
                    }
                }
            } catch (ConnectException e7) {
                ConnectException connectException = new ConnectException("Failed to connect to " + getRoute().socketAddress());
                connectException.initCause(e7);
                throw connectException;
            }
        }
        throw new IOException("canceled");
    }

    private final void connectTls(SSLSocket sSLSocket, ConnectionSpec connectionSpec) throws IOException {
        Protocol protocol;
        final Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Handshake.Companion companion = Handshake.Companion;
            g0.m(session);
            final Handshake handshake = companion.get(session);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            g0.m(hostnameVerifier);
            boolean verify = hostnameVerifier.verify(address.url().host(), session);
            String str = null;
            if (!verify) {
                List<Certificate> peerCertificates = handshake.peerCertificates();
                if (!peerCertificates.isEmpty()) {
                    Certificate certificate = peerCertificates.get(0);
                    g0.n(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    throw new SSLPeerUnverifiedException(u.x("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.Companion.pin(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate) + "\n            ", null, 1, null));
                }
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            final CertificatePinner certificatePinner = address.certificatePinner();
            g0.m(certificatePinner);
            final Handshake handshake2 = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new Function0() { // from class: okhttp3.internal.connection.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List connectTls$lambda$0;
                    connectTls$lambda$0 = ConnectPlan.connectTls$lambda$0(CertificatePinner.this, handshake, address);
                    return connectTls$lambda$0;
                }
            });
            this.handshake = handshake2;
            certificatePinner.check$okhttp(address.url().host(), new Function0() { // from class: okhttp3.internal.connection.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List connectTls$lambda$1;
                    connectTls$lambda$1 = ConnectPlan.connectTls$lambda$1(Handshake.this);
                    return connectTls$lambda$1;
                }
            });
            if (connectionSpec.supportsTlsExtensions()) {
                str = Platform.Companion.get().getSelectedProtocol(sSLSocket);
            }
            this.javaNetSocket = sSLSocket;
            this.socket = BufferedSocketKt.asBufferedSocket(sSLSocket);
            if (str != null) {
                protocol = Protocol.Companion.get(str);
            } else {
                protocol = Protocol.HTTP_1_1;
            }
            this.protocol = protocol;
            Platform.Companion.get().afterHandshake(sSLSocket);
        } catch (Throwable th) {
            Platform.Companion.get().afterHandshake(sSLSocket);
            _UtilJvmKt.closeQuietly(sSLSocket);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List connectTls$lambda$0(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        CertificateChainCleaner certificateChainCleaner$okhttp = certificatePinner.getCertificateChainCleaner$okhttp();
        g0.m(certificateChainCleaner$okhttp);
        return certificateChainCleaner$okhttp.clean(handshake.peerCertificates(), address.url().host());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List connectTls$lambda$1(Handshake handshake) {
        List<Certificate> peerCertificates = handshake.peerCertificates();
        ArrayList arrayList = new ArrayList(f0.d0(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            g0.n(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    @NotNull
    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request createTunnel = createTunnel();
        if (createTunnel == null) {
            return new RoutePlanner.ConnectResult(this, null, null, 6, null);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int i6 = this.attempt + 1;
        if (i6 < 21) {
            this.call.getEventListener$okhttp().connectEnd(this.call, getRoute().socketAddress(), getRoute().proxy(), null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, i6, createTunnel, 0, false, 12, null), null, 4, null);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        this.call.getEventListener$okhttp().connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, protocolException);
        this.connectionPool.getConnectionListener$okhttp().connectFailed(getRoute(), this.call, protocolException);
        return new RoutePlanner.ConnectResult(this, null, protocolException, 2, null);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
    }
}
