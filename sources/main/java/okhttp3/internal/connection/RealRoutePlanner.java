package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.Address;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealRoutePlanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealRoutePlanner.kt\nokhttp3/internal/connection/RealRoutePlanner\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,348:1\n63#2:349\n63#2:350\n*S KotlinDebug\n*F\n+ 1 RealRoutePlanner.kt\nokhttp3/internal/connection/RealRoutePlanner\n*L\n100#1:349\n327#1:350\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RealRoutePlanner implements RoutePlanner {

    @NotNull
    private final Address address;

    @NotNull
    private final RealCall call;

    @NotNull
    private final RealConnectionPool connectionPool;

    @NotNull
    private final m<RoutePlanner.Plan> deferredPlans;
    private final boolean doExtensiveHealthChecks;
    private final boolean fastFallback;

    @Nullable
    private Route nextRouteToTry;
    private final int pingIntervalMillis;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @NotNull
    private final RouteDatabase routeDatabase;

    @Nullable
    private RouteSelector.Selection routeSelection;

    @Nullable
    private RouteSelector routeSelector;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;

    @NotNull
    private final TaskRunner taskRunner;
    private final int writeTimeoutMillis;

    private final Route retryRoute(RealConnection realConnection) {
        Route route;
        synchronized (realConnection) {
            route = null;
            if (realConnection.getRouteFailureCount$okhttp() == 0 && realConnection.getNoNewExchanges() && _UtilJvmKt.canReuseConnectionFor(realConnection.route().address().url(), getAddress().url())) {
                route = realConnection.route();
            }
        }
        return route;
    }

    public RealRoutePlanner(@NotNull TaskRunner taskRunner, @NotNull RealConnectionPool connectionPool, int i6, int i7, int i8, int i9, int i10, boolean z5, boolean z6, @NotNull Address address, @NotNull RouteDatabase routeDatabase, @NotNull RealCall call, @NotNull Request request) {
        g0.p(taskRunner, "taskRunner");
        g0.p(connectionPool, "connectionPool");
        g0.p(address, "address");
        g0.p(routeDatabase, "routeDatabase");
        g0.p(call, "call");
        g0.p(request, "request");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i6;
        this.writeTimeoutMillis = i7;
        this.socketConnectTimeoutMillis = i8;
        this.socketReadTimeoutMillis = i9;
        this.pingIntervalMillis = i10;
        this.retryOnConnectionFailure = z5;
        this.fastFallback = z6;
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.doExtensiveHealthChecks = !g0.g(request.method(), "GET");
        this.deferredPlans = new m<>();
    }

    private final Request createTunnelRequest(Route route) throws IOException {
        Request build = new Request.Builder().url(route.address().url()).method("CONNECT", null).header("Host", _UtilJvmKt.toHostHeader(route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", _UtilCommonKt.USER_AGENT).build();
        Request authenticate = route.address().proxyAuthenticator().authenticate(route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConnectPlan planConnectToRoute$okhttp$default(RealRoutePlanner realRoutePlanner, Route route, List list, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planConnectToRoute$okhttp(route, list);
    }

    private final ReusePlan planReuseCallConnection() {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z5;
        RealConnection connection = this.call.getConnection();
        if (connection == null) {
            return null;
        }
        boolean isHealthy = connection.isHealthy(this.doExtensiveHealthChecks);
        synchronized (connection) {
            try {
                if (isHealthy) {
                    if (!connection.getNoNewExchanges() && sameHostAndPort(connection.route().address().url())) {
                        releaseConnectionNoEvents$okhttp = null;
                        z5 = false;
                    }
                    releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
                    z5 = false;
                } else {
                    z5 = !connection.getNoNewExchanges();
                    connection.setNoNewExchanges(true);
                    releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
                }
            } finally {
            }
        }
        if (this.call.getConnection() != null) {
            if (releaseConnectionNoEvents$okhttp == null) {
                return new ReusePlan(connection);
            }
            throw new IllegalStateException("Check failed.");
        }
        if (releaseConnectionNoEvents$okhttp != null) {
            _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
        }
        this.call.getEventListener$okhttp().connectionReleased(this.call, connection);
        connection.getConnectionListener$okhttp().connectionReleased(connection, this.call);
        if (releaseConnectionNoEvents$okhttp != null) {
            connection.getConnectionListener$okhttp().connectionClosed(connection);
        } else if (z5) {
            connection.getConnectionListener$okhttp().noNewExchanges(connection);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReusePlan planReusePooledConnection$okhttp$default(RealRoutePlanner realRoutePlanner, ConnectPlan connectPlan, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            connectPlan = null;
        }
        if ((i6 & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planReusePooledConnection$okhttp(connectPlan, list);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public Address getAddress() {
        return this.address;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public m<RoutePlanner.Plan> getDeferredPlans() {
        return this.deferredPlans;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean isCanceled() {
        return this.call.isCanceled();
    }

    @NotNull
    public final ConnectPlan planConnect$okhttp() throws IOException {
        Route route = this.nextRouteToTry;
        if (route != null) {
            this.nextRouteToTry = null;
            return planConnectToRoute$okhttp$default(this, route, null, 2, null);
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            return planConnectToRoute$okhttp$default(this, selection.next(), null, 2, null);
        }
        RouteSelector routeSelector = this.routeSelector;
        if (routeSelector == null) {
            routeSelector = new RouteSelector(getAddress(), this.routeDatabase, this.call, this.fastFallback);
            this.routeSelector = routeSelector;
        }
        if (!routeSelector.hasNext()) {
            throw new IOException("exhausted all routes");
        }
        RouteSelector.Selection next = routeSelector.next();
        this.routeSelection = next;
        if (isCanceled()) {
            throw new IOException("Canceled");
        }
        return planConnectToRoute$okhttp(next.next(), next.getRoutes());
    }

    @NotNull
    public final ConnectPlan planConnectToRoute$okhttp(@NotNull Route route, @Nullable List<Route> list) throws IOException {
        g0.p(route, "route");
        if (route.address().sslSocketFactory() == null) {
            if (!route.address().connectionSpecs().contains(ConnectionSpec.CLEARTEXT)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String host = route.address().url().host();
            if (!Platform.Companion.get().isCleartextTrafficPermitted(host)) {
                throw new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy");
            }
        } else if (route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this, route, list, 0, route.requiresTunnel() ? createTunnelRequest(route) : null, -1, false);
    }

    @Nullable
    public final ReusePlan planReusePooledConnection$okhttp(@Nullable ConnectPlan connectPlan, @Nullable List<Route> list) {
        RealConnection callAcquirePooledConnection$okhttp = this.connectionPool.callAcquirePooledConnection$okhttp(this.doExtensiveHealthChecks, getAddress(), this.call, list, connectPlan != null && connectPlan.isReady());
        if (callAcquirePooledConnection$okhttp == null) {
            return null;
        }
        if (connectPlan != null) {
            this.nextRouteToTry = connectPlan.getRoute();
            connectPlan.closeQuietly();
        }
        this.call.getEventListener$okhttp().connectionAcquired(this.call, callAcquirePooledConnection$okhttp);
        callAcquirePooledConnection$okhttp.getConnectionListener$okhttp().connectionAcquired(callAcquirePooledConnection$okhttp, this.call);
        return new ReusePlan(callAcquirePooledConnection$okhttp);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean sameHostAndPort(@NotNull HttpUrl url) {
        g0.p(url, "url");
        HttpUrl url2 = getAddress().url();
        return url.port() == url2.port() && g0.g(url.host(), url2.host());
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean hasNext(@Nullable RealConnection realConnection) {
        RouteSelector routeSelector;
        Route retryRoute;
        if (!getDeferredPlans().isEmpty() || this.nextRouteToTry != null) {
            return true;
        }
        if (realConnection != null && (retryRoute = retryRoute(realConnection)) != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection != null && selection.hasNext()) || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public RoutePlanner.Plan plan() throws IOException {
        ReusePlan planReuseCallConnection = planReuseCallConnection();
        if (planReuseCallConnection != null) {
            return planReuseCallConnection;
        }
        ReusePlan planReusePooledConnection$okhttp$default = planReusePooledConnection$okhttp$default(this, null, null, 3, null);
        if (planReusePooledConnection$okhttp$default != null) {
            return planReusePooledConnection$okhttp$default;
        }
        if (!getDeferredPlans().isEmpty()) {
            return getDeferredPlans().removeFirst();
        }
        ConnectPlan planConnect$okhttp = planConnect$okhttp();
        ReusePlan planReusePooledConnection$okhttp = planReusePooledConnection$okhttp(planConnect$okhttp, planConnect$okhttp.getRoutes$okhttp());
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp;
        }
        return planConnect$okhttp;
    }
}
