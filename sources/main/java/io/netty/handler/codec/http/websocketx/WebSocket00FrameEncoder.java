package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocket00FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final ByteBuf _0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(0));
    private static final ByteBuf _0XFF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(-1));
    private static final ByteBuf _0XFF_0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2, 2).writeByte(-1).writeByte(0));

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            ByteBuf content = webSocketFrame.content();
            list.add(_0X00.duplicate());
            list.add(content.retain());
            list.add(_0XFF.duplicate());
            return;
        }
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            list.add(_0XFF_0X00.duplicate());
            return;
        }
        ByteBuf content2 = webSocketFrame.content();
        int readableBytes = content2.readableBytes();
        ByteBuf buffer = channelHandlerContext.alloc().buffer(5);
        try {
            buffer.writeByte(-128);
            int i6 = (readableBytes >>> 28) & 127;
            int i7 = (readableBytes >>> 14) & 127;
            int i8 = (readableBytes >>> 7) & 127;
            int i9 = readableBytes & 127;
            if (i6 != 0) {
                buffer.writeByte(i6 | 128);
                buffer.writeByte(i7 | 128);
                buffer.writeByte(i8 | 128);
                buffer.writeByte(i9);
            } else if (i7 != 0) {
                buffer.writeByte(i7 | 128);
                buffer.writeByte(i8 | 128);
                buffer.writeByte(i9);
            } else if (i8 == 0) {
                buffer.writeByte(i9);
            } else {
                buffer.writeByte(i8 | 128);
                buffer.writeByte(i9);
            }
            list.add(buffer);
            list.add(content2.retain());
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }
}
