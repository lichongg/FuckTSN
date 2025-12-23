package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsRecordDecoder implements DnsRecordDecoder {
    static final String ROOT = ".";

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf) throws Exception {
        int readerIndex = byteBuf.readerIndex();
        String decodeName = decodeName(byteBuf);
        int writerIndex = byteBuf.writerIndex();
        if (writerIndex - readerIndex < 10) {
            byteBuf.readerIndex(readerIndex);
            return null;
        }
        DnsRecordType valueOf = DnsRecordType.valueOf(byteBuf.readUnsignedShort());
        int readUnsignedShort = byteBuf.readUnsignedShort();
        long readUnsignedInt = byteBuf.readUnsignedInt();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        int readerIndex2 = byteBuf.readerIndex();
        if (writerIndex - readerIndex2 < readUnsignedShort2) {
            byteBuf.readerIndex(readerIndex);
            return null;
        }
        T t5 = (T) decodeRecord(decodeName, valueOf, readUnsignedShort, readUnsignedInt, byteBuf, readerIndex2, readUnsignedShort2);
        byteBuf.readerIndex(readerIndex2 + readUnsignedShort2);
        return t5;
    }

    protected DefaultDnsRecordDecoder() {
    }

    public static String decodeName(ByteBuf byteBuf) {
        return DnsCodecUtil.decodeDomainName(byteBuf);
    }

    protected String decodeName0(ByteBuf byteBuf) {
        return decodeName(byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final DnsQuestion decodeQuestion(ByteBuf byteBuf) throws Exception {
        return new DefaultDnsQuestion(decodeName(byteBuf), DnsRecordType.valueOf(byteBuf.readUnsignedShort()), byteBuf.readUnsignedShort());
    }

    protected DnsRecord decodeRecord(String str, DnsRecordType dnsRecordType, int i6, long j6, ByteBuf byteBuf, int i7, int i8) throws Exception {
        if (dnsRecordType == DnsRecordType.PTR) {
            return new DefaultDnsPtrRecord(str, i6, j6, decodeName0(byteBuf.duplicate().setIndex(i7, i8 + i7)));
        }
        if (dnsRecordType != DnsRecordType.CNAME && dnsRecordType != DnsRecordType.NS) {
            return new DefaultDnsRawRecord(str, dnsRecordType, i6, j6, byteBuf.retainedDuplicate().setIndex(i7, i8 + i7));
        }
        return new DefaultDnsRawRecord(str, dnsRecordType, i6, j6, DnsCodecUtil.decompressDomainName(byteBuf.duplicate().setIndex(i7, i8 + i7)));
    }
}
