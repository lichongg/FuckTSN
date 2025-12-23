package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.ReferenceCountUtil;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DnsRecordResolveContext extends DnsResolveContext<DnsRecord> {
    DnsRecordResolveContext(DnsNameResolver dnsNameResolver, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        this(dnsNameResolver, dnsQuestion.name(), dnsQuestion.dnsClass(), new DnsRecordType[]{dnsQuestion.type()}, dnsRecordArr, dnsServerAddressStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, DnsRecord dnsRecord2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public boolean isCompleteEarly(DnsRecord dnsRecord) {
        return false;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    boolean isDuplicateAllowed() {
        return true;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public DnsRecord convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop) {
        return (DnsRecord) ReferenceCountUtil.retain(dnsRecord);
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    DnsResolveContext<DnsRecord> newResolverContext(DnsNameResolver dnsNameResolver, String str, int i6, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        return new DnsRecordResolveContext(dnsNameResolver, str, i6, dnsRecordTypeArr, dnsRecordArr, dnsServerAddressStream);
    }

    private DnsRecordResolveContext(DnsNameResolver dnsNameResolver, String str, int i6, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        super(dnsNameResolver, str, i6, dnsRecordTypeArr, dnsRecordArr, dnsServerAddressStream);
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    List<DnsRecord> filterResults(List<DnsRecord> list) {
        return list;
    }
}
