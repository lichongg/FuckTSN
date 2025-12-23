package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z5) {
        this(z5, 1);
    }

    public ChannelMetadata(boolean z5, int i6) {
        ObjectUtil.checkPositive(i6, "defaultMaxMessagesPerRead");
        this.hasDisconnect = z5;
        this.defaultMaxMessagesPerRead = i6;
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }
}
