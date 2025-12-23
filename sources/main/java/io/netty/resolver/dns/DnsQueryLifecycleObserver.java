package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsQueryLifecycleObserver {
    DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion);

    void queryCancelled(int i6);

    void queryFailed(Throwable th);

    DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode);

    DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list);

    void querySucceed();

    void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture);
}
