package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    protected MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, I i6, List<Object> list) throws Exception;

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    protected MessageToMessageDecoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        int i6 = 0;
        try {
            try {
                try {
                    if (acceptInboundMessage(obj)) {
                        try {
                            decode(channelHandlerContext, obj, newInstance);
                            ReferenceCountUtil.release(obj);
                        } catch (Throwable th) {
                            ReferenceCountUtil.release(obj);
                            throw th;
                        }
                    } else {
                        newInstance.add(obj);
                    }
                    int size = newInstance.size();
                    while (i6 < size) {
                        channelHandlerContext.fireChannelRead(newInstance.getUnsafe(i6));
                        i6++;
                    }
                    newInstance.recycle();
                } catch (DecoderException e6) {
                    throw e6;
                }
            } catch (Exception e7) {
                throw new DecoderException(e7);
            }
        } catch (Throwable th2) {
            int size2 = newInstance.size();
            while (i6 < size2) {
                channelHandlerContext.fireChannelRead(newInstance.getUnsafe(i6));
                i6++;
            }
            newInstance.recycle();
            throw th2;
        }
    }
}
