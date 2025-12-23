package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.NetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Socks4ServerEncoder extends MessageToByteEncoder<Socks4CommandResponse> {
    public static final Socks4ServerEncoder INSTANCE = new Socks4ServerEncoder();
    private static final byte[] IPv4_HOSTNAME_ZEROED = {0, 0, 0, 0};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks4CommandResponse socks4CommandResponse, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(0);
        byteBuf.writeByte(socks4CommandResponse.status().byteValue());
        byteBuf.writeShort(socks4CommandResponse.dstPort());
        byteBuf.writeBytes(socks4CommandResponse.dstAddr() == null ? IPv4_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(socks4CommandResponse.dstAddr()));
    }

    private Socks4ServerEncoder() {
    }
}
