package io.netty.resolver.dns;

import io.netty.util.NetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private static final DnsServerAddresses DEFAULT_NAME_SERVERS;
    private static final List<InetSocketAddress> DEFAULT_NAME_SERVER_LIST;
    static final int DNS_PORT = 53;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultDnsServerAddressStreamProvider.class);
    public static final DefaultDnsServerAddressStreamProvider INSTANCE = new DefaultDnsServerAddressStreamProvider();

    static {
        ArrayList arrayList = new ArrayList(2);
        if (!PlatformDependent.isAndroid()) {
            DirContextUtils.addNameServers(arrayList, 53);
        }
        if (PlatformDependent.javaVersion() < 9 && arrayList.isEmpty()) {
            try {
                Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
                for (String str : (List) cls.getMethod("nameservers", null).invoke(cls.getMethod("open", null).invoke(null, null), null)) {
                    if (str != null) {
                        arrayList.add(new InetSocketAddress(SocketUtils.addressByName(str), 53));
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (arrayList.isEmpty()) {
            if (NetUtil.isIpV6AddressesPreferred() || ((NetUtil.LOCALHOST instanceof Inet6Address) && !NetUtil.isIpV4StackPreferred())) {
                Collections.addAll(arrayList, SocketUtils.socketAddress("2001:4860:4860::8888", 53), SocketUtils.socketAddress("2001:4860:4860::8844", 53));
            } else {
                Collections.addAll(arrayList, SocketUtils.socketAddress("8.8.8.8", 53), SocketUtils.socketAddress("8.8.4.4", 53));
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Default DNS servers: {} (Google Public DNS as a fallback)", arrayList);
            }
        } else {
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("Default DNS servers: {} (sun.net.dns.ResolverConfiguration)", arrayList);
            }
        }
        List<InetSocketAddress> unmodifiableList = Collections.unmodifiableList(arrayList);
        DEFAULT_NAME_SERVER_LIST = unmodifiableList;
        DEFAULT_NAME_SERVERS = DnsServerAddresses.sequential(unmodifiableList);
    }

    public static List<InetSocketAddress> defaultAddressList() {
        return DEFAULT_NAME_SERVER_LIST;
    }

    public static DnsServerAddresses defaultAddresses() {
        return DEFAULT_NAME_SERVERS;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public DnsServerAddressStream nameServerAddressStream(String str) {
        return DEFAULT_NAME_SERVERS.stream();
    }

    private DefaultDnsServerAddressStreamProvider() {
    }
}
