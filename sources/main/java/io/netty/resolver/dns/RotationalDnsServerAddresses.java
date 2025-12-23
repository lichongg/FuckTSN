package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class RotationalDnsServerAddresses extends DefaultDnsServerAddresses {
    private static final AtomicIntegerFieldUpdater<RotationalDnsServerAddresses> startIdxUpdater = AtomicIntegerFieldUpdater.newUpdater(RotationalDnsServerAddresses.class, "startIdx");
    private volatile int startIdx;

    RotationalDnsServerAddresses(List<InetSocketAddress> list) {
        super("rotational", list);
    }

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        int i6;
        int i7;
        do {
            i6 = this.startIdx;
            i7 = i6 + 1;
            if (i7 >= this.addresses.size()) {
                i7 = 0;
            }
        } while (!startIdxUpdater.compareAndSet(this, i6, i7));
        return new SequentialDnsServerAddressStream(this.addresses, i6);
    }
}
