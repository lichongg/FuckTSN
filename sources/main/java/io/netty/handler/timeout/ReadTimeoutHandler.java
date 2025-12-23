package io.netty.handler.timeout;

import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ReadTimeoutHandler extends IdleStateHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean closed;

    public ReadTimeoutHandler(int i6) {
        this(i6, TimeUnit.SECONDS);
    }

    public ReadTimeoutHandler(long j6, TimeUnit timeUnit) {
        super(j6, 0L, 0L, timeUnit);
    }

    protected void readTimedOut(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.closed) {
            return;
        }
        channelHandlerContext.fireExceptionCaught((Throwable) ReadTimeoutException.INSTANCE);
        channelHandlerContext.close();
        this.closed = true;
    }

    @Override // io.netty.handler.timeout.IdleStateHandler
    protected final void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) throws Exception {
        readTimedOut(channelHandlerContext);
    }
}
