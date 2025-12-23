package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class DatagramDnsQueryEncoder extends MessageToMessageEncoder<AddressedEnvelope<DnsQuery, InetSocketAddress>> {
    private final DnsQueryEncoder encoder;

    public DatagramDnsQueryEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> addressedEnvelope, List list) throws Exception {
        encode2(channelHandlerContext, addressedEnvelope, (List<Object>) list);
    }

    public DatagramDnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = new DnsQueryEncoder(dnsRecordEncoder);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> addressedEnvelope, List<Object> list) throws Exception {
        InetSocketAddress recipient = addressedEnvelope.recipient();
        DnsQuery content = addressedEnvelope.content();
        ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, addressedEnvelope);
        try {
            this.encoder.encode(content, allocateBuffer);
            list.add(new DatagramPacket(allocateBuffer, recipient, null));
        } catch (Throwable th) {
            allocateBuffer.release();
            throw th;
        }
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> addressedEnvelope) throws Exception {
        return channelHandlerContext.alloc().ioBuffer(1024);
    }
}
