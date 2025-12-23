package io.netty.channel;

import io.netty.util.concurrent.PromiseAggregator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ChannelPromiseAggregator extends PromiseAggregator<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseAggregator(ChannelPromise channelPromise) {
        super(channelPromise);
    }
}
