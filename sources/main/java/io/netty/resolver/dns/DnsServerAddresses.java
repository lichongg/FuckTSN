package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class DnsServerAddresses {
    public static DnsServerAddresses rotational(Iterable<? extends InetSocketAddress> iterable) {
        return rotational0(sanitize(iterable));
    }

    private static List<InetSocketAddress> sanitize(Iterable<? extends InetSocketAddress> iterable) {
        InetSocketAddress next;
        if (iterable == null) {
            throw new NullPointerException("addresses");
        }
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList(4);
        Iterator<? extends InetSocketAddress> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.isUnresolved()) {
                throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + next);
            }
            arrayList.add(next);
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("empty addresses");
        }
        return arrayList;
    }

    public static DnsServerAddresses sequential(Iterable<? extends InetSocketAddress> iterable) {
        return sequential0(sanitize(iterable));
    }

    public static DnsServerAddresses shuffled(Iterable<? extends InetSocketAddress> iterable) {
        return shuffled0(sanitize(iterable));
    }

    public abstract DnsServerAddressStream stream();

    public static DnsServerAddresses rotational(InetSocketAddress... inetSocketAddressArr) {
        return rotational0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses sequential(InetSocketAddress... inetSocketAddressArr) {
        return sequential0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses shuffled(InetSocketAddress... inetSocketAddressArr) {
        return shuffled0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses singleton(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            throw new NullPointerException("address");
        }
        if (!inetSocketAddress.isUnresolved()) {
            return new SingletonDnsServerAddresses(inetSocketAddress);
        }
        throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
    }

    @Deprecated
    public static List<InetSocketAddress> defaultAddressList() {
        return DefaultDnsServerAddressStreamProvider.defaultAddressList();
    }

    @Deprecated
    public static DnsServerAddresses defaultAddresses() {
        return DefaultDnsServerAddressStreamProvider.defaultAddresses();
    }

    private static DnsServerAddresses rotational0(List<InetSocketAddress> list) {
        if (list.size() == 1) {
            return singleton(list.get(0));
        }
        return new RotationalDnsServerAddresses(list);
    }

    private static DnsServerAddresses sequential0(List<InetSocketAddress> list) {
        if (list.size() == 1) {
            return singleton(list.get(0));
        }
        return new DefaultDnsServerAddresses("sequential", list) { // from class: io.netty.resolver.dns.DnsServerAddresses.1
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new SequentialDnsServerAddressStream(this.addresses, 0);
            }
        };
    }

    private static DnsServerAddresses shuffled0(List<InetSocketAddress> list) {
        if (list.size() == 1) {
            return singleton(list.get(0));
        }
        return new DefaultDnsServerAddresses("shuffled", list) { // from class: io.netty.resolver.dns.DnsServerAddresses.2
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new ShuffledDnsServerAddressStream(this.addresses);
            }
        };
    }

    private static List<InetSocketAddress> sanitize(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr != null) {
            ArrayList arrayList = new ArrayList(inetSocketAddressArr.length);
            for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
                if (inetSocketAddress == null) {
                    break;
                }
                if (!inetSocketAddress.isUnresolved()) {
                    arrayList.add(inetSocketAddress);
                } else {
                    throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
                }
            }
            return arrayList.isEmpty() ? DefaultDnsServerAddressStreamProvider.defaultAddressList() : arrayList;
        }
        throw new NullPointerException("addresses");
    }
}
