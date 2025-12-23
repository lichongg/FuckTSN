package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ObjectDecoder extends LengthFieldBasedFrameDecoder {
    private final ClassResolver classResolver;

    public ObjectDecoder(ClassResolver classResolver) {
        this(1048576, classResolver);
    }

    public ObjectDecoder(int i6, ClassResolver classResolver) {
        super(i6, 0, 4, 0, 4);
        this.classResolver = classResolver;
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        CompactObjectInputStream compactObjectInputStream = new CompactObjectInputStream(new ByteBufInputStream(byteBuf2, true), this.classResolver);
        try {
            return compactObjectInputStream.readObject();
        } finally {
            compactObjectInputStream.close();
        }
    }
}
