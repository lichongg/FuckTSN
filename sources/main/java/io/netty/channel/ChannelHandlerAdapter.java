package io.netty.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerMask;
import io.netty.util.internal.InternalThreadLocalMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    protected void ensureNotSharable() {
        if (!isSharable()) {
            return;
        }
        throw new IllegalStateException("ChannelHandler " + getClass().getName() + " is not allowed to be shared");
    }

    @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
    }

    public boolean isSharable() {
        Class<?> cls = getClass();
        Map<Class<?>, Boolean> handlerSharableCache = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean bool = handlerSharableCache.get(cls);
        if (bool == null) {
            bool = Boolean.valueOf(cls.isAnnotationPresent(ChannelHandler.Sharable.class));
            handlerSharableCache.put(cls, bool);
        }
        return bool.booleanValue();
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
    }
}
