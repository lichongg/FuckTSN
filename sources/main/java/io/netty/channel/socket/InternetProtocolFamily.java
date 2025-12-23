package io.netty.channel.socket;

import io.netty.util.NetUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum InternetProtocolFamily {
    IPv4(Inet4Address.class, 1, NetUtil.LOCALHOST4),
    IPv6(Inet6Address.class, 2, NetUtil.LOCALHOST6);

    private final int addressNumber;
    private final Class<? extends InetAddress> addressType;
    private final InetAddress localHost;

    public static InternetProtocolFamily of(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return IPv4;
        }
        if (inetAddress instanceof Inet6Address) {
            return IPv6;
        }
        throw new IllegalArgumentException("address " + inetAddress + " not supported");
    }

    public int addressNumber() {
        return this.addressNumber;
    }

    public Class<? extends InetAddress> addressType() {
        return this.addressType;
    }

    public InetAddress localhost() {
        return this.localHost;
    }

    InternetProtocolFamily(Class cls, int i6, InetAddress inetAddress) {
        this.addressType = cls;
        this.addressNumber = i6;
        this.localHost = inetAddress;
    }
}
