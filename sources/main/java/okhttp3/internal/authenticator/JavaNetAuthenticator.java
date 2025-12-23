package okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class JavaNetAuthenticator implements Authenticator {

    @NotNull
    private final Dns defaultDns;

    public JavaNetAuthenticator() {
        this(null, 1, 0 == true ? 1 : 0);
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JavaNetAuthenticator(@NotNull Dns defaultDns) {
        g0.p(defaultDns, "defaultDns");
        this.defaultDns = defaultDns;
    }

    @Override // okhttp3.Authenticator
    @Nullable
    public Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException {
        Proxy proxy;
        Dns dns;
        PasswordAuthentication requestPasswordAuthentication;
        Address address;
        g0.p(response, "response");
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        boolean z5 = response.code() == 407;
        if (route == null || (proxy = route.proxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge challenge : challenges) {
            if (u.a2("Basic", challenge.scheme(), true)) {
                if (route == null || (address = route.address()) == null || (dns = address.dns()) == null) {
                    dns = this.defaultDns;
                }
                if (z5) {
                    SocketAddress address2 = proxy.address();
                    g0.n(address2, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                    String hostName = inetSocketAddress.getHostName();
                    g0.m(proxy);
                    requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(hostName, connectToInetAddress(proxy, url, dns), inetSocketAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                } else {
                    String host = url.host();
                    g0.m(proxy);
                    requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(host, connectToInetAddress(proxy, url, dns), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    String str = z5 ? "Proxy-Authorization" : "Authorization";
                    String userName = requestPasswordAuthentication.getUserName();
                    g0.o(userName, "getUserName(...)");
                    char[] password = requestPasswordAuthentication.getPassword();
                    g0.o(password, "getPassword(...)");
                    return request.newBuilder().header(str, Credentials.basic(userName, new String(password), challenge.charset())).build();
                }
            }
        }
        return null;
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) throws IOException {
        int i6;
        Proxy.Type type = proxy.type();
        if (type == null) {
            i6 = -1;
        } else {
            i6 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i6 == 1) {
            return (InetAddress) f0.G2(dns.lookup(httpUrl.host()));
        }
        SocketAddress address = proxy.address();
        g0.n(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        g0.o(address2, "getAddress(...)");
        return address2;
    }

    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i6, v vVar) {
        this((i6 & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
