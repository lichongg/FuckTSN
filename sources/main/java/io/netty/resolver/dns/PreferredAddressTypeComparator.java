package io.netty.resolver.dns;

import io.netty.channel.socket.InternetProtocolFamily;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PreferredAddressTypeComparator implements Comparator<InetAddress> {
    private static final PreferredAddressTypeComparator IPv4 = new PreferredAddressTypeComparator(Inet4Address.class);
    private static final PreferredAddressTypeComparator IPv6 = new PreferredAddressTypeComparator(Inet6Address.class);
    private final Class<? extends InetAddress> preferredAddressType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.resolver.dns.PreferredAddressTypeComparator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static PreferredAddressTypeComparator comparator(InternetProtocolFamily internetProtocolFamily) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamily.ordinal()];
        if (i6 == 1) {
            return IPv4;
        }
        if (i6 == 2) {
            return IPv6;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.Comparator
    public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
        if (inetAddress.getClass() == inetAddress2.getClass()) {
            return 0;
        }
        return this.preferredAddressType.isAssignableFrom(inetAddress.getClass()) ? -1 : 1;
    }

    private PreferredAddressTypeComparator(Class<? extends InetAddress> cls) {
        this.preferredAddressType = cls;
    }
}
