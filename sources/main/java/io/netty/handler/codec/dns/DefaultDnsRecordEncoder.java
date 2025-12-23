package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsRecordEncoder implements DnsRecordEncoder {
    private static final int PREFIX_MASK = 7;

    static int calculateEcsAddressLength(int i6, int i7) {
        return (i6 >>> 3) + (i7 != 0 ? 1 : 0);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordEncoder
    public void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception {
        if (dnsRecord instanceof DnsQuestion) {
            encodeQuestion((DnsQuestion) dnsRecord, byteBuf);
            return;
        }
        if (dnsRecord instanceof DnsPtrRecord) {
            encodePtrRecord((DnsPtrRecord) dnsRecord, byteBuf);
            return;
        }
        if (dnsRecord instanceof DnsOptEcsRecord) {
            encodeOptEcsRecord((DnsOptEcsRecord) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsOptPseudoRecord) {
            encodeOptPseudoRecord((DnsOptPseudoRecord) dnsRecord, byteBuf);
        } else {
            if (!(dnsRecord instanceof DnsRawRecord)) {
                throw new UnsupportedMessageTypeException(StringUtil.simpleClassName(dnsRecord));
            }
            encodeRawRecord((DnsRawRecord) dnsRecord, byteBuf);
        }
    }

    protected DefaultDnsRecordEncoder() {
    }

    private void encodeOptEcsRecord(DnsOptEcsRecord dnsOptEcsRecord, ByteBuf byteBuf) throws Exception {
        InternetProtocolFamily internetProtocolFamily;
        encodeRecord0(dnsOptEcsRecord, byteBuf);
        int sourcePrefixLength = dnsOptEcsRecord.sourcePrefixLength();
        int scopePrefixLength = dnsOptEcsRecord.scopePrefixLength();
        int i6 = sourcePrefixLength & 7;
        byte[] address = dnsOptEcsRecord.address();
        int length = address.length << 3;
        if (length >= sourcePrefixLength && sourcePrefixLength >= 0) {
            if (address.length == 4) {
                internetProtocolFamily = InternetProtocolFamily.IPv4;
            } else {
                internetProtocolFamily = InternetProtocolFamily.IPv6;
            }
            short addressNumber = (short) internetProtocolFamily.addressNumber();
            int calculateEcsAddressLength = calculateEcsAddressLength(sourcePrefixLength, i6);
            byteBuf.writeShort(calculateEcsAddressLength + 8);
            byteBuf.writeShort(8);
            byteBuf.writeShort(calculateEcsAddressLength + 4);
            byteBuf.writeShort(addressNumber);
            byteBuf.writeByte(sourcePrefixLength);
            byteBuf.writeByte(scopePrefixLength);
            if (i6 > 0) {
                int i7 = calculateEcsAddressLength - 1;
                byteBuf.writeBytes(address, 0, i7);
                byteBuf.writeByte(padWithZeros(address[i7], i6));
                return;
            }
            byteBuf.writeBytes(address, 0, calculateEcsAddressLength);
            return;
        }
        throw new IllegalArgumentException(sourcePrefixLength + ": " + sourcePrefixLength + " (expected: 0 >= " + length + ')');
    }

    private void encodeOptPseudoRecord(DnsOptPseudoRecord dnsOptPseudoRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsOptPseudoRecord, byteBuf);
        byteBuf.writeShort(0);
    }

    private void encodePtrRecord(DnsPtrRecord dnsPtrRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsPtrRecord, byteBuf);
        encodeName(dnsPtrRecord.hostname(), byteBuf);
    }

    private void encodeRawRecord(DnsRawRecord dnsRawRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsRawRecord, byteBuf);
        ByteBuf content = dnsRawRecord.content();
        int readableBytes = content.readableBytes();
        byteBuf.writeShort(readableBytes);
        byteBuf.writeBytes(content, content.readerIndex(), readableBytes);
    }

    private void encodeRecord0(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception {
        encodeName(dnsRecord.name(), byteBuf);
        byteBuf.writeShort(dnsRecord.type().intValue());
        byteBuf.writeShort(dnsRecord.dnsClass());
        byteBuf.writeInt((int) dnsRecord.timeToLive());
    }

    private static byte padWithZeros(byte b6, int i6) {
        int i7;
        switch (i6) {
            case 0:
                return (byte) 0;
            case 1:
                i7 = b6 & 128;
                break;
            case 2:
                i7 = b6 & 192;
                break;
            case 3:
                i7 = b6 & 224;
                break;
            case 4:
                i7 = b6 & 240;
                break;
            case 5:
                i7 = b6 & 248;
                break;
            case 6:
                i7 = b6 & 252;
                break;
            case 7:
                i7 = b6 & 254;
                break;
            case 8:
                return b6;
            default:
                throw new IllegalArgumentException("lowOrderBitsToPreserve: " + i6);
        }
        return (byte) i7;
    }

    protected void encodeName(String str, ByteBuf byteBuf) throws Exception {
        DnsCodecUtil.encodeDomainName(str, byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordEncoder
    public final void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) throws Exception {
        encodeName(dnsQuestion.name(), byteBuf);
        byteBuf.writeShort(dnsQuestion.type().intValue());
        byteBuf.writeShort(dnsQuestion.dnsClass());
    }
}
