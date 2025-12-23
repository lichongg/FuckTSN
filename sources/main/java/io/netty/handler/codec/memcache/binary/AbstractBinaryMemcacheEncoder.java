package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractBinaryMemcacheEncoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectEncoder<M> {
    private static final int MINIMUM_HEADER_SIZE = 24;

    protected abstract void encodeHeader(ByteBuf byteBuf, M m6);

    private static void encodeExtras(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 == null || !byteBuf2.isReadable()) {
            return;
        }
        byteBuf.writeBytes(byteBuf2);
    }

    private static void encodeKey(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 == null || !byteBuf2.isReadable()) {
            return;
        }
        byteBuf.writeBytes(byteBuf2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder
    public ByteBuf encodeMessage(ChannelHandlerContext channelHandlerContext, M m6) {
        ByteBuf buffer = channelHandlerContext.alloc().buffer(m6.extrasLength() + 24 + m6.keyLength());
        encodeHeader(buffer, m6);
        encodeExtras(buffer, m6.extras());
        encodeKey(buffer, m6.key());
        return buffer;
    }
}
