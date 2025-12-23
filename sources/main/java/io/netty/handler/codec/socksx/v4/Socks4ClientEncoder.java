package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.NetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Socks4ClientEncoder extends MessageToByteEncoder<Socks4CommandRequest> {
    public static final Socks4ClientEncoder INSTANCE = new Socks4ClientEncoder();
    private static final byte[] IPv4_DOMAIN_MARKER = {0, 0, 0, 1};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks4CommandRequest socks4CommandRequest, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(socks4CommandRequest.version().byteValue());
        byteBuf.writeByte(socks4CommandRequest.type().byteValue());
        byteBuf.writeShort(socks4CommandRequest.dstPort());
        if (NetUtil.isValidIpV4Address(socks4CommandRequest.dstAddr())) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(socks4CommandRequest.dstAddr()));
            ByteBufUtil.writeAscii(byteBuf, socks4CommandRequest.userId());
            byteBuf.writeByte(0);
        } else {
            byteBuf.writeBytes(IPv4_DOMAIN_MARKER);
            ByteBufUtil.writeAscii(byteBuf, socks4CommandRequest.userId());
            byteBuf.writeByte(0);
            ByteBufUtil.writeAscii(byteBuf, socks4CommandRequest.dstAddr());
            byteBuf.writeByte(0);
        }
    }

    private Socks4ClientEncoder() {
    }
}
