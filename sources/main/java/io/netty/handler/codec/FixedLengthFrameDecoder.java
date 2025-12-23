package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
    private final int frameLength;

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public FixedLengthFrameDecoder(int i6) {
        ObjectUtil.checkPositive(i6, "frameLength");
        this.frameLength = i6;
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        int i6 = this.frameLength;
        if (readableBytes < i6) {
            return null;
        }
        return byteBuf.readRetainedSlice(i6);
    }
}
