package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class DatagramDnsResponseEncoder extends MessageToMessageEncoder<AddressedEnvelope<DnsResponse, InetSocketAddress>> {
    private final DnsRecordEncoder recordEncoder;

    public DatagramDnsResponseEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, List list) throws Exception {
        encode2(channelHandlerContext, addressedEnvelope, (List<Object>) list);
    }

    public DatagramDnsResponseEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.recordEncoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "recordEncoder");
    }

    private void encodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf) throws Exception {
        int count = dnsResponse.count(DnsSection.QUESTION);
        for (int i6 = 0; i6 < count; i6++) {
            this.recordEncoder.encodeQuestion((DnsQuestion) dnsResponse.recordAt(DnsSection.QUESTION, i6), byteBuf);
        }
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, List<Object> list) throws Exception {
        InetSocketAddress recipient = addressedEnvelope.recipient();
        DnsResponse content = addressedEnvelope.content();
        ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, addressedEnvelope);
        try {
            encodeHeader(content, allocateBuffer);
            encodeQuestions(content, allocateBuffer);
            encodeRecords(content, DnsSection.ANSWER, allocateBuffer);
            encodeRecords(content, DnsSection.AUTHORITY, allocateBuffer);
            encodeRecords(content, DnsSection.ADDITIONAL, allocateBuffer);
            list.add(new DatagramPacket(allocateBuffer, recipient, null));
        } catch (Throwable th) {
            allocateBuffer.release();
            throw th;
        }
    }

    private static void encodeHeader(DnsResponse dnsResponse, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsResponse.id());
        int byteValue = (dnsResponse.opCode().byteValue() & 255) << 11;
        int i6 = 32768 | byteValue;
        if (dnsResponse.isAuthoritativeAnswer()) {
            i6 = 33792 | byteValue;
        }
        if (dnsResponse.isTruncated()) {
            i6 |= 512;
        }
        if (dnsResponse.isRecursionDesired()) {
            i6 |= 256;
        }
        if (dnsResponse.isRecursionAvailable()) {
            i6 |= 128;
        }
        byteBuf.writeShort((dnsResponse.z() << 4) | i6 | dnsResponse.code().intValue());
        byteBuf.writeShort(dnsResponse.count(DnsSection.QUESTION));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ANSWER));
        byteBuf.writeShort(dnsResponse.count(DnsSection.AUTHORITY));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ADDITIONAL));
    }

    private void encodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf) throws Exception {
        int count = dnsResponse.count(dnsSection);
        for (int i6 = 0; i6 < count; i6++) {
            this.recordEncoder.encodeRecord(dnsResponse.recordAt(dnsSection, i6), byteBuf);
        }
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope) throws Exception {
        return channelHandlerContext.alloc().ioBuffer(1024);
    }
}
