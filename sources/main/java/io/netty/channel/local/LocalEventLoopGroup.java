package io.netty.channel.local;

import io.netty.channel.DefaultEventLoopGroup;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class LocalEventLoopGroup extends DefaultEventLoopGroup {
    public LocalEventLoopGroup() {
    }

    public LocalEventLoopGroup(int i6) {
        super(i6);
    }

    public LocalEventLoopGroup(int i6, ThreadFactory threadFactory) {
        super(i6, threadFactory);
    }
}
