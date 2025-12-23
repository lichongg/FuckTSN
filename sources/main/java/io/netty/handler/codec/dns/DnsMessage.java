package io.netty.handler.codec.dns;

import io.netty.util.ReferenceCounted;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsMessage extends ReferenceCounted {
    DnsMessage addRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord);

    DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    DnsMessage clear();

    DnsMessage clear(DnsSection dnsSection);

    int count();

    int count(DnsSection dnsSection);

    int id();

    boolean isRecursionDesired();

    DnsOpCode opCode();

    <T extends DnsRecord> T recordAt(DnsSection dnsSection);

    <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i6);

    <T extends DnsRecord> T removeRecord(DnsSection dnsSection, int i6);

    @Override // io.netty.util.ReferenceCounted
    DnsMessage retain();

    @Override // io.netty.util.ReferenceCounted
    DnsMessage retain(int i6);

    DnsMessage setId(int i6);

    DnsMessage setOpCode(DnsOpCode dnsOpCode);

    DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    <T extends DnsRecord> T setRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord);

    DnsMessage setRecursionDesired(boolean z5);

    DnsMessage setZ(int i6);

    @Override // io.netty.util.ReferenceCounted
    DnsMessage touch();

    @Override // io.netty.util.ReferenceCounted
    DnsMessage touch(Object obj);

    int z();
}
