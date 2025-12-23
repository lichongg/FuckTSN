package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ShuffledDnsServerAddressStream implements DnsServerAddressStream {
    private final List<InetSocketAddress> addresses;

    /* renamed from: i, reason: collision with root package name */
    private int f43088i;

    ShuffledDnsServerAddressStream(List<InetSocketAddress> list) {
        this.addresses = list;
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(this.addresses, PlatformDependent.threadLocalRandom());
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public ShuffledDnsServerAddressStream duplicate() {
        return new ShuffledDnsServerAddressStream(this.addresses, this.f43088i);
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i6 = this.f43088i;
        InetSocketAddress inetSocketAddress = this.addresses.get(i6);
        int i7 = i6 + 1;
        if (i7 < this.addresses.size()) {
            this.f43088i = i7;
            return inetSocketAddress;
        }
        this.f43088i = 0;
        shuffle();
        return inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public int size() {
        return this.addresses.size();
    }

    public String toString() {
        return SequentialDnsServerAddressStream.toString("shuffled", this.f43088i, this.addresses);
    }

    private ShuffledDnsServerAddressStream(List<InetSocketAddress> list, int i6) {
        this.addresses = list;
        this.f43088i = i6;
    }
}
