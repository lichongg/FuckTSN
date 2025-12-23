package io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.MessageNano;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class ProtobufDecoderNano extends MessageToMessageDecoder<ByteBuf> {
    private final Class<? extends MessageNano> clazz;

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6;
        byte[] bytes;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bytes = byteBuf.array();
            i6 = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            i6 = 0;
            bytes = ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), readableBytes, false);
        }
        list.add(MessageNano.mergeFrom(this.clazz.getConstructor(null).newInstance(null), bytes, i6, readableBytes));
    }

    public ProtobufDecoderNano(Class<? extends MessageNano> cls) {
        this.clazz = (Class) ObjectUtil.checkNotNull(cls, "You must provide a Class");
    }
}
