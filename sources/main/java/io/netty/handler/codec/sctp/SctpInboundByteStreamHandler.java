package io.netty.handler.codec.sctp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SctpInboundByteStreamHandler extends MessageToMessageDecoder<SctpMessage> {
    private final int protocolIdentifier;
    private final int streamIdentifier;

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public final boolean acceptInboundMessage(Object obj) throws Exception {
        if (super.acceptInboundMessage(obj)) {
            return acceptInboundMessage((SctpMessage) obj);
        }
        return false;
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List list) throws Exception {
        decode2(channelHandlerContext, sctpMessage, (List<Object>) list);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List<Object> list) throws Exception {
        if (!sctpMessage.isComplete()) {
            throw new CodecException(String.format("Received SctpMessage is not complete, please add %s in the pipeline before this handler", SctpMessageCompletionHandler.class.getSimpleName()));
        }
        list.add(sctpMessage.content().retain());
    }

    public SctpInboundByteStreamHandler(int i6, int i7) {
        this.protocolIdentifier = i6;
        this.streamIdentifier = i7;
    }

    protected boolean acceptInboundMessage(SctpMessage sctpMessage) {
        return sctpMessage.protocolIdentifier() == this.protocolIdentifier && sctpMessage.streamIdentifier() == this.streamIdentifier;
    }
}
