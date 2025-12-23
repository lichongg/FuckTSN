package okhttp3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okhttp3.internal._HostnamesCommonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Route {

    @NotNull
    private final Address address;

    @NotNull
    private final Proxy proxy;

    @NotNull
    private final InetSocketAddress socketAddress;

    public Route(@NotNull Address address, @NotNull Proxy proxy, @NotNull InetSocketAddress socketAddress) {
        g0.p(address, "address");
        g0.p(proxy, "proxy");
        g0.p(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "address", imports = {}))
    @JvmName(name = "-deprecated_address")
    @NotNull
    /* renamed from: -deprecated_address, reason: not valid java name */
    public final Address m284deprecated_address() {
        return this.address;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))
    @JvmName(name = "-deprecated_proxy")
    @NotNull
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m285deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketAddress", imports = {}))
    @JvmName(name = "-deprecated_socketAddress")
    @NotNull
    /* renamed from: -deprecated_socketAddress, reason: not valid java name */
    public final InetSocketAddress m286deprecated_socketAddress() {
        return this.socketAddress;
    }

    @JvmName(name = "address")
    @NotNull
    public final Address address() {
        return this.address;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return g0.g(route.address, this.address) && g0.g(route.proxy, this.proxy) && g0.g(route.socketAddress, this.socketAddress);
    }

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    @JvmName(name = "proxy")
    @NotNull
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        if (this.proxy.type() != Proxy.Type.HTTP) {
            return false;
        }
        return this.address.sslSocketFactory() != null || this.address.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE);
    }

    @JvmName(name = "socketAddress")
    @NotNull
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @NotNull
    public String toString() {
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        String host = this.address.url().host();
        InetAddress address = this.socketAddress.getAddress();
        String canonicalHost = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : _HostnamesCommonKt.toCanonicalHost(hostAddress);
        if (u.k3(host, ':', false, 2, null)) {
            sb.append("[");
            sb.append(host);
            sb.append("]");
        } else {
            sb.append(host);
        }
        if (this.address.url().port() != this.socketAddress.getPort() || g0.g(host, canonicalHost)) {
            sb.append(":");
            sb.append(this.address.url().port());
        }
        if (!g0.g(host, canonicalHost)) {
            if (g0.g(this.proxy, Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (canonicalHost == null) {
                sb.append("<unresolved>");
            } else if (u.k3(canonicalHost, ':', false, 2, null)) {
                sb.append("[");
                sb.append(canonicalHost);
                sb.append("]");
            } else {
                sb.append(canonicalHost);
            }
            sb.append(":");
            sb.append(this.socketAddress.getPort());
        }
        return sb.toString();
    }
}
