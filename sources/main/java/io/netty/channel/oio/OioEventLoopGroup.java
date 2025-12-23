package io.netty.channel.oio;

import io.netty.channel.ThreadPerChannelEventLoopGroup;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class OioEventLoopGroup extends ThreadPerChannelEventLoopGroup {
    public OioEventLoopGroup() {
        this(0);
    }

    public OioEventLoopGroup(int i6) {
        this(i6, Executors.defaultThreadFactory());
    }

    public OioEventLoopGroup(int i6, Executor executor) {
        super(i6, executor, new Object[0]);
    }

    public OioEventLoopGroup(int i6, ThreadFactory threadFactory) {
        super(i6, threadFactory, new Object[0]);
    }
}
