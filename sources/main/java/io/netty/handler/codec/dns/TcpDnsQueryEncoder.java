package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public final class TcpDnsQueryEncoder extends MessageToByteEncoder<DnsQuery> {
    private final DnsQueryEncoder encoder;

    public TcpDnsQueryEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    public TcpDnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = new DnsQueryEncoder(dnsRecordEncoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, DnsQuery dnsQuery, boolean z5) {
        return z5 ? channelHandlerContext.alloc().ioBuffer(1024) : channelHandlerContext.alloc().heapBuffer(1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, DnsQuery dnsQuery, ByteBuf byteBuf) throws Exception {
        byteBuf.writerIndex(byteBuf.writerIndex() + 2);
        this.encoder.encode(dnsQuery, byteBuf);
        byteBuf.setShort(0, byteBuf.readableBytes() - 2);
    }
}
