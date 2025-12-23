package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.DatagramChannel;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.NameResolver;
import io.netty.resolver.RoundRobinInetAddressResolver;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class RoundRobinDnsAddressResolverGroup extends DnsAddressResolverGroup {
    public RoundRobinDnsAddressResolverGroup(DnsNameResolverBuilder dnsNameResolverBuilder) {
        super(dnsNameResolverBuilder);
    }

    public RoundRobinDnsAddressResolverGroup(Class<? extends DatagramChannel> cls, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        super(cls, dnsServerAddressStreamProvider);
    }

    @Override // io.netty.resolver.dns.DnsAddressResolverGroup
    protected final AddressResolver<InetSocketAddress> newAddressResolver(EventLoop eventLoop, NameResolver<InetAddress> nameResolver) throws Exception {
        return new RoundRobinInetAddressResolver(eventLoop, nameResolver).asAddressResolver();
    }

    public RoundRobinDnsAddressResolverGroup(ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        super(channelFactory, dnsServerAddressStreamProvider);
    }
}
