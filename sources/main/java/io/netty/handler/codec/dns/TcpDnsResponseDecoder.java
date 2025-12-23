package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class TcpDnsResponseDecoder extends LengthFieldBasedFrameDecoder {
    private final DnsResponseDecoder<SocketAddress> responseDecoder;

    public TcpDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT, 65536);
    }

    public TcpDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder, int i6) {
        super(i6, 0, 2, 0, 2);
        this.responseDecoder = new DnsResponseDecoder<SocketAddress>(dnsRecordDecoder) { // from class: io.netty.handler.codec.dns.TcpDnsResponseDecoder.1
            @Override // io.netty.handler.codec.dns.DnsResponseDecoder
            protected DnsResponse newResponse(SocketAddress socketAddress, SocketAddress socketAddress2, int i7, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DefaultDnsResponse(i7, dnsOpCode, dnsResponseCode);
            }
        };
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        try {
            return this.responseDecoder.decode(channelHandlerContext.channel().remoteAddress(), channelHandlerContext.channel().localAddress(), byteBuf2.slice());
        } finally {
            byteBuf2.release();
        }
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    protected ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, int i7) {
        return byteBuf.copy(i6, i7);
    }
}
