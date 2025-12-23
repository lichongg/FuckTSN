package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class BiDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    private final DnsQueryLifecycleObserver f43082a;

    /* renamed from: b, reason: collision with root package name */
    private final DnsQueryLifecycleObserver f43083b;

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        try {
            this.f43082a.queryCNAMEd(dnsQuestion);
            return this;
        } finally {
            this.f43083b.queryCNAMEd(dnsQuestion);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryCancelled(int i6) {
        try {
            this.f43082a.queryCancelled(i6);
        } finally {
            this.f43083b.queryCancelled(i6);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryFailed(Throwable th) {
        try {
            this.f43082a.queryFailed(th);
        } finally {
            this.f43083b.queryFailed(th);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        try {
            this.f43082a.queryNoAnswer(dnsResponseCode);
            return this;
        } finally {
            this.f43083b.queryNoAnswer(dnsResponseCode);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        try {
            this.f43082a.queryRedirected(list);
            return this;
        } finally {
            this.f43083b.queryRedirected(list);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void querySucceed() {
        try {
            this.f43082a.querySucceed();
        } finally {
            this.f43083b.querySucceed();
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        try {
            this.f43082a.queryWritten(inetSocketAddress, channelFuture);
        } finally {
            this.f43083b.queryWritten(inetSocketAddress, channelFuture);
        }
    }

    public BiDnsQueryLifecycleObserver(DnsQueryLifecycleObserver dnsQueryLifecycleObserver, DnsQueryLifecycleObserver dnsQueryLifecycleObserver2) {
        this.f43082a = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver, "a");
        this.f43083b = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver2, "b");
    }
}
