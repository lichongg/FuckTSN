package okhttp3;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Protocol {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ Protocol[] $VALUES;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private final String protocol;
    public static final Protocol HTTP_1_0 = new Protocol("HTTP_1_0", 0, "http/1.0");
    public static final Protocol HTTP_1_1 = new Protocol("HTTP_1_1", 1, ApplicationProtocolNames.HTTP_1_1);

    @Deprecated(message = "OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.")
    public static final Protocol SPDY_3 = new Protocol("SPDY_3", 2, ApplicationProtocolNames.SPDY_3_1);
    public static final Protocol HTTP_2 = new Protocol("HTTP_2", 3, ApplicationProtocolNames.HTTP_2);
    public static final Protocol H2_PRIOR_KNOWLEDGE = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
    public static final Protocol QUIC = new Protocol("QUIC", 5, LiveConfigKey.QUIC);
    public static final Protocol HTTP_3 = new Protocol("HTTP_3", 6, "h3");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String protocol) throws IOException {
            g0.p(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (g0.g(protocol, protocol2.protocol)) {
                return protocol2;
            }
            Protocol protocol3 = Protocol.HTTP_1_1;
            if (g0.g(protocol, protocol3.protocol)) {
                return protocol3;
            }
            Protocol protocol4 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (g0.g(protocol, protocol4.protocol)) {
                return protocol4;
            }
            Protocol protocol5 = Protocol.HTTP_2;
            if (g0.g(protocol, protocol5.protocol)) {
                return protocol5;
            }
            Protocol protocol6 = Protocol.SPDY_3;
            if (g0.g(protocol, protocol6.protocol)) {
                return protocol6;
            }
            Protocol protocol7 = Protocol.QUIC;
            if (g0.g(protocol, protocol7.protocol)) {
                return protocol7;
            }
            Protocol protocol8 = Protocol.HTTP_3;
            if (u.H2(protocol, protocol8.protocol, false, 2, null)) {
                return protocol8;
            }
            throw new IOException("Unexpected protocol: " + protocol);
        }
    }

    private static final /* synthetic */ Protocol[] $values() {
        return new Protocol[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2, H2_PRIOR_KNOWLEDGE, QUIC, HTTP_3};
    }

    static {
        Protocol[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new Companion(null);
    }

    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String str) throws IOException {
        return Companion.get(str);
    }

    @NotNull
    public static kotlin.enums.a<Protocol> getEntries() {
        return $ENTRIES;
    }

    public static Protocol valueOf(String str) {
        return (Protocol) Enum.valueOf(Protocol.class, str);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.protocol;
    }

    private Protocol(String str, int i6, String str2) {
        this.protocol = str2;
    }
}
