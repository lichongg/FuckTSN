package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RouteSelector {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Address address;

    @NotNull
    private final RealCall call;
    private final boolean fastFallback;

    @NotNull
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;

    @NotNull
    private final List<Route> postponedRoutes;

    @NotNull
    private List<? extends Proxy> proxies;

    @NotNull
    private final RouteDatabase routeDatabase;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress inetSocketAddress) {
            g0.p(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                g0.o(hostName, "getHostName(...)");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            g0.o(hostAddress, "getHostAddress(...)");
            return hostAddress;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Selection {
        private int nextRouteIndex;

        @NotNull
        private final List<Route> routes;

        public Selection(@NotNull List<Route> routes) {
            g0.p(routes, "routes");
            this.routes = routes;
        }

        @NotNull
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        @NotNull
        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i6 = this.nextRouteIndex;
                this.nextRouteIndex = i6 + 1;
                return list.get(i6);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(@NotNull Address address, @NotNull RouteDatabase routeDatabase, @NotNull RealCall call, boolean z5) {
        g0.p(address, "address");
        g0.p(routeDatabase, "routeDatabase");
        g0.p(call, "call");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.fastFallback = z5;
        this.proxies = f0.J();
        this.inetSocketAddresses = f0.J();
        this.postponedRoutes = new ArrayList();
        resetNextProxy(address.url(), address.proxy());
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        List<InetAddress> lookup;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.url().host();
            port = this.address.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            host = Companion.getSocketHost(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (1 > port || port >= 65536) {
            throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
            return;
        }
        if (_HostnamesCommonKt.canParseAsIpAddress(host)) {
            lookup = f0.l(InetAddress.getByName(host));
        } else {
            this.call.getEventListener$okhttp().dnsStart(this.call, host);
            lookup = this.address.dns().lookup(host);
            if (lookup.isEmpty()) {
                throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
            }
            this.call.getEventListener$okhttp().dnsEnd(this.call, host, lookup);
        }
        if (this.fastFallback) {
            lookup = InetAddressOrderKt.reorderForHappyEyeballs(lookup);
        }
        Iterator<InetAddress> it = lookup.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), port));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        this.call.getEventListener$okhttp().proxySelectStart(this.call, httpUrl);
        this.proxies = resetNextProxy$selectProxies(proxy, httpUrl, this);
        this.nextProxyIndex = 0;
        this.call.getEventListener$okhttp().proxySelectEnd(this.call, httpUrl, this.proxies);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy proxy, HttpUrl httpUrl, RouteSelector routeSelector) {
        if (proxy != null) {
            return f0.l(proxy);
        }
        URI uri = httpUrl.uri();
        if (uri.getHost() == null) {
            return _UtilJvmKt.immutableListOf(Proxy.NO_PROXY);
        }
        List<Proxy> select = routeSelector.address.proxySelector().select(uri);
        List<Proxy> list = select;
        return (list == null || list.isEmpty()) ? _UtilJvmKt.immutableListOf(Proxy.NO_PROXY) : _UtilJvmKt.toImmutableList(select);
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<? extends Proxy> list = this.proxies;
            int i6 = this.nextProxyIndex;
            this.nextProxyIndex = i6 + 1;
            Proxy proxy = list.get(i6);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    public final boolean hasNext() {
        if (!hasNextProxy() && this.postponedRoutes.isEmpty()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                Iterator<? extends InetSocketAddress> it = this.inetSocketAddresses.iterator();
                while (it.hasNext()) {
                    Route route = new Route(this.address, nextProxy, it.next());
                    if (this.routeDatabase.shouldPostpone(route)) {
                        this.postponedRoutes.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                f0.s0(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
