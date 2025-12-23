package io.netty.resolver.dns;

import com.baidu.mobads.sdk.internal.bu;
import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class TraceDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {
    private InetSocketAddress dnsServerAddress;
    private final InternalLogLevel level;
    private final InternalLogger logger;
    private final DnsQuestion question;

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        this.logger.log(this.level, "from {} : {} CNAME question {}", this.dnsServerAddress, this.question, dnsQuestion);
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryCancelled(int i6) {
        InetSocketAddress inetSocketAddress = this.dnsServerAddress;
        if (inetSocketAddress != null) {
            this.logger.log(this.level, "from {} : {} cancelled with {} queries remaining", inetSocketAddress, this.question, Integer.valueOf(i6));
        } else {
            this.logger.log(this.level, "{} query never written and cancelled with {} queries remaining", this.question, Integer.valueOf(i6));
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryFailed(Throwable th) {
        InetSocketAddress inetSocketAddress = this.dnsServerAddress;
        if (inetSocketAddress != null) {
            this.logger.log(this.level, "from {} : {} failure", inetSocketAddress, this.question, th);
        } else {
            this.logger.log(this.level, "{} query never written and failed", this.question, th);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        this.logger.log(this.level, "from {} : {} no answer {}", this.dnsServerAddress, this.question, dnsResponseCode);
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        this.logger.log(this.level, "from {} : {} redirected", this.dnsServerAddress, this.question);
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        this.dnsServerAddress = inetSocketAddress;
    }

    TraceDnsQueryLifecycleObserver(DnsQuestion dnsQuestion, InternalLogger internalLogger, InternalLogLevel internalLogLevel) {
        this.question = (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
        this.logger = (InternalLogger) ObjectUtil.checkNotNull(internalLogger, bu.f10800a);
        this.level = (InternalLogLevel) ObjectUtil.checkNotNull(internalLogLevel, "level");
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void querySucceed() {
    }
}
