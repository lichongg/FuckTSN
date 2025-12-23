package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DnsNameResolverTimeoutException extends DnsNameResolverException {
    private static final long serialVersionUID = -8826717969627131854L;

    public DnsNameResolverTimeoutException(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, String str) {
        super(inetSocketAddress, dnsQuestion, str);
    }
}
