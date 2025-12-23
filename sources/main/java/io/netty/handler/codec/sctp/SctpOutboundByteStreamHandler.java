package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SctpOutboundByteStreamHandler extends MessageToMessageEncoder<ByteBuf> {
    private final int protocolIdentifier;
    private final int streamIdentifier;
    private final boolean unordered;

    public SctpOutboundByteStreamHandler(int i6, int i7) {
        this(i6, i7, false);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public SctpOutboundByteStreamHandler(int i6, int i7, boolean z5) {
        this.streamIdentifier = i6;
        this.protocolIdentifier = i7;
        this.unordered = z5;
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(new SctpMessage(this.protocolIdentifier, this.streamIdentifier, this.unordered, byteBuf.retain()));
    }
}
