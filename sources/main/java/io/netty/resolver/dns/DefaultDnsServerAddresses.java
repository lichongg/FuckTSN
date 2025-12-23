package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class DefaultDnsServerAddresses extends DnsServerAddresses {
    protected final List<InetSocketAddress> addresses;
    private final String strVal;

    public String toString() {
        return this.strVal;
    }

    DefaultDnsServerAddresses(String str, List<InetSocketAddress> list) {
        this.addresses = list;
        StringBuilder sb = new StringBuilder(str.length() + 2 + (list.size() * 16));
        sb.append(str);
        sb.append('(');
        Iterator<InetSocketAddress> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(')');
        this.strVal = sb.toString();
    }
}
