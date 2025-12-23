package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    protected SimpleChannelInboundHandler() {
        this(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z5 = true;
        try {
            if (acceptInboundMessage(obj)) {
                channelRead0(channelHandlerContext, obj);
            } else {
                z5 = false;
                channelHandlerContext.fireChannelRead(obj);
            }
            if (this.autoRelease && z5) {
                ReferenceCountUtil.release(obj);
            }
        } catch (Throwable th) {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(obj);
            }
            throw th;
        }
    }

    protected abstract void channelRead0(ChannelHandlerContext channelHandlerContext, I i6) throws Exception;

    protected SimpleChannelInboundHandler(boolean z5) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = z5;
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    protected SimpleChannelInboundHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    protected SimpleChannelInboundHandler(Class<? extends I> cls, boolean z5) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z5;
    }
}
