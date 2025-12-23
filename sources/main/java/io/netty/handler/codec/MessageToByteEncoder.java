package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.TypeParameterMatcher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    protected MessageToByteEncoder() {
        this(true);
    }

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i6, ByteBuf byteBuf) throws Exception;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        ReferenceCounted referenceCounted = null;
        try {
            try {
                if (!acceptOutboundMessage(obj)) {
                    channelHandlerContext.write(obj, channelPromise);
                    return;
                }
                ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, obj, this.preferDirect);
                try {
                    encode(channelHandlerContext, obj, allocateBuffer);
                    ReferenceCountUtil.release(obj);
                    if (allocateBuffer.isReadable()) {
                        channelHandlerContext.write(allocateBuffer, channelPromise);
                    } else {
                        allocateBuffer.release();
                        channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
                    }
                } catch (Throwable th) {
                    ReferenceCountUtil.release(obj);
                    throw th;
                }
            } catch (EncoderException e6) {
                throw e6;
            } catch (Throwable th2) {
                throw new EncoderException(th2);
            }
        } catch (Throwable th3) {
            if (0 != 0) {
                referenceCounted.release();
            }
            throw th3;
        }
    }

    protected MessageToByteEncoder(Class<? extends I> cls) {
        this(cls, true);
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, I i6, boolean z5) throws Exception {
        return z5 ? channelHandlerContext.alloc().ioBuffer() : channelHandlerContext.alloc().heapBuffer();
    }

    protected boolean isPreferDirect() {
        return this.preferDirect;
    }

    protected MessageToByteEncoder(boolean z5) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = z5;
    }

    protected MessageToByteEncoder(Class<? extends I> cls, boolean z5) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.preferDirect = z5;
    }
}
