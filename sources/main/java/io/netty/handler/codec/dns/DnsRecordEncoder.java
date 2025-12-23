package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsRecordEncoder {
    public static final DnsRecordEncoder DEFAULT = new DefaultDnsRecordEncoder();

    void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) throws Exception;

    void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception;
}
