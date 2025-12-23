package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ChannelHealthChecker {
    public static final ChannelHealthChecker ACTIVE = new ChannelHealthChecker() { // from class: io.netty.channel.pool.ChannelHealthChecker.1
        @Override // io.netty.channel.pool.ChannelHealthChecker
        public Future<Boolean> isHealthy(Channel channel) {
            Boolean bool;
            EventLoop eventLoop = channel.eventLoop();
            if (channel.isActive()) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            return eventLoop.newSucceededFuture(bool);
        }
    };

    Future<Boolean> isHealthy(Channel channel);
}
