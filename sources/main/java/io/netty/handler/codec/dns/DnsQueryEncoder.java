package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DnsQueryEncoder {
    private final DnsRecordEncoder recordEncoder;

    private void encodeQuestions(DnsQuery dnsQuery, ByteBuf byteBuf) throws Exception {
        int count = dnsQuery.count(DnsSection.QUESTION);
        for (int i6 = 0; i6 < count; i6++) {
            this.recordEncoder.encodeQuestion((DnsQuestion) dnsQuery.recordAt(DnsSection.QUESTION, i6), byteBuf);
        }
    }

    DnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.recordEncoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "recordEncoder");
    }

    private static void encodeHeader(DnsQuery dnsQuery, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsQuery.id());
        int byteValue = (dnsQuery.opCode().byteValue() & 255) << 14;
        if (dnsQuery.isRecursionDesired()) {
            byteValue |= 256;
        }
        byteBuf.writeShort(byteValue);
        byteBuf.writeShort(dnsQuery.count(DnsSection.QUESTION));
        byteBuf.writeShort(0);
        byteBuf.writeShort(0);
        byteBuf.writeShort(dnsQuery.count(DnsSection.ADDITIONAL));
    }

    private void encodeRecords(DnsQuery dnsQuery, DnsSection dnsSection, ByteBuf byteBuf) throws Exception {
        int count = dnsQuery.count(dnsSection);
        for (int i6 = 0; i6 < count; i6++) {
            this.recordEncoder.encodeRecord(dnsQuery.recordAt(dnsSection, i6), byteBuf);
        }
    }

    void encode(DnsQuery dnsQuery, ByteBuf byteBuf) throws Exception {
        encodeHeader(dnsQuery, byteBuf);
        encodeQuestions(dnsQuery, byteBuf);
        encodeRecords(dnsQuery, DnsSection.ADDITIONAL, byteBuf);
    }
}
