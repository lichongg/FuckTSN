package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NameServerComparator implements Comparator<InetSocketAddress>, Serializable {
    private static final long serialVersionUID = 8372151874317596185L;
    private final Class<? extends InetAddress> preferredAddressType;

    @Override // java.util.Comparator
    public int compare(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress.equals(inetSocketAddress2)) {
            return 0;
        }
        if (!inetSocketAddress.isUnresolved() && !inetSocketAddress2.isUnresolved()) {
            if (inetSocketAddress.getAddress().getClass() == inetSocketAddress2.getAddress().getClass()) {
                return 0;
            }
            return this.preferredAddressType.isAssignableFrom(inetSocketAddress.getAddress().getClass()) ? -1 : 1;
        }
        if (inetSocketAddress.isUnresolved() && inetSocketAddress2.isUnresolved()) {
            return 0;
        }
        return inetSocketAddress.isUnresolved() ? 1 : -1;
    }

    public NameServerComparator(Class<? extends InetAddress> cls) {
        this.preferredAddressType = (Class) ObjectUtil.checkNotNull(cls, "preferredAddressType");
    }
}
