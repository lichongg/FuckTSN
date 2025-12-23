package io.netty.channel;

import io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FixedRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    private final int bufferSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private final int bufferSize;

        HandleImpl(int i6) {
            super();
            this.bufferSize = i6;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.bufferSize;
        }
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.bufferSize);
    }

    @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public FixedRecvByteBufAllocator respectMaybeMoreData(boolean z5) {
        super.respectMaybeMoreData(z5);
        return this;
    }

    public FixedRecvByteBufAllocator(int i6) {
        ObjectUtil.checkPositive(i6, "bufferSize");
        this.bufferSize = i6;
    }
}
