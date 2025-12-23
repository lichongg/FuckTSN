package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface Dns {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final Dns SYSTEM = new Companion.DnsSystem();

    @NotNull
    List<InetAddress> lookup(@NotNull String str) throws UnknownHostException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            @NotNull
            public List<InetAddress> lookup(@NotNull String hostname) {
                g0.p(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    g0.o(allByName, "getAllByName(...)");
                    return n.dz(allByName);
                } catch (NullPointerException e6) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e6);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }
}
