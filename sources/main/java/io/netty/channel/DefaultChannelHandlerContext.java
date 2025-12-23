package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandler handler() {
        return this.handler;
    }

    DefaultChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, ChannelHandler channelHandler) {
        super(defaultChannelPipeline, eventExecutor, str, channelHandler.getClass());
        this.handler = channelHandler;
    }
}
