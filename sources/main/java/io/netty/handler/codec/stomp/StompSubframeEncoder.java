package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.AsciiHeadersEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class StompSubframeEncoder extends MessageToMessageEncoder<StompSubframe> {
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, StompSubframe stompSubframe, List list) throws Exception {
        encode2(channelHandlerContext, stompSubframe, (List<Object>) list);
    }

    private static ByteBuf encodeContent(StompContentSubframe stompContentSubframe, ChannelHandlerContext channelHandlerContext) {
        if (!(stompContentSubframe instanceof LastStompContentSubframe)) {
            return stompContentSubframe.content().retain();
        }
        ByteBuf buffer = channelHandlerContext.alloc().buffer(stompContentSubframe.content().readableBytes() + 1);
        buffer.writeBytes(stompContentSubframe.content());
        buffer.writeByte(0);
        return buffer;
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, StompSubframe stompSubframe, List<Object> list) throws Exception {
        if (stompSubframe instanceof StompFrame) {
            StompFrame stompFrame = (StompFrame) stompSubframe;
            list.add(encodeFrame(stompFrame, channelHandlerContext));
            list.add(encodeContent(stompFrame, channelHandlerContext));
        } else if (stompSubframe instanceof StompHeadersSubframe) {
            list.add(encodeFrame((StompHeadersSubframe) stompSubframe, channelHandlerContext));
        } else if (stompSubframe instanceof StompContentSubframe) {
            list.add(encodeContent((StompContentSubframe) stompSubframe, channelHandlerContext));
        }
    }

    private static ByteBuf encodeFrame(StompHeadersSubframe stompHeadersSubframe, ChannelHandlerContext channelHandlerContext) {
        ByteBuf buffer = channelHandlerContext.alloc().buffer();
        buffer.writeCharSequence(stompHeadersSubframe.command().toString(), CharsetUtil.US_ASCII);
        buffer.writeByte(10);
        AsciiHeadersEncoder asciiHeadersEncoder = new AsciiHeadersEncoder(buffer, AsciiHeadersEncoder.SeparatorType.COLON, AsciiHeadersEncoder.NewlineType.LF);
        Iterator<Map.Entry<CharSequence, CharSequence>> it = stompHeadersSubframe.headers().iterator();
        while (it.hasNext()) {
            asciiHeadersEncoder.encode(it.next());
        }
        buffer.writeByte(10);
        return buffer;
    }
}
