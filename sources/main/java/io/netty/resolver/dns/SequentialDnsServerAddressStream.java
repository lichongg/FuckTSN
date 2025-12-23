package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SequentialDnsServerAddressStream implements DnsServerAddressStream {
    private final List<? extends InetSocketAddress> addresses;

    /* renamed from: i, reason: collision with root package name */
    private int f43087i;

    public String toString() {
        return toString("sequential", this.f43087i, this.addresses);
    }

    static String toString(String str, int i6, Collection<? extends InetSocketAddress> collection) {
        StringBuilder sb = new StringBuilder(str.length() + 2 + (collection.size() * 16));
        sb.append(str);
        sb.append("(index: ");
        sb.append(i6);
        sb.append(", addrs: (");
        Iterator<? extends InetSocketAddress> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("))");
        return sb.toString();
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public SequentialDnsServerAddressStream duplicate() {
        return new SequentialDnsServerAddressStream(this.addresses, this.f43087i);
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i6 = this.f43087i;
        InetSocketAddress inetSocketAddress = this.addresses.get(i6);
        int i7 = i6 + 1;
        if (i7 < this.addresses.size()) {
            this.f43087i = i7;
            return inetSocketAddress;
        }
        this.f43087i = 0;
        return inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public int size() {
        return this.addresses.size();
    }

    SequentialDnsServerAddressStream(List<? extends InetSocketAddress> list, int i6) {
        this.addresses = list;
        this.f43087i = i6;
    }
}
