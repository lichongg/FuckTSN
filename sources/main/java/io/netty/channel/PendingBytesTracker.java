package io.netty.channel;

import io.netty.channel.MessageSizeEstimator;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class PendingBytesTracker implements MessageSizeEstimator.Handle {
    private final MessageSizeEstimator.Handle estimatorHandle;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.PendingBytesTracker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ChannelOutboundBufferPendingBytesTracker extends PendingBytesTracker {
        private final ChannelOutboundBuffer buffer;

        ChannelOutboundBufferPendingBytesTracker(ChannelOutboundBuffer channelOutboundBuffer, MessageSizeEstimator.Handle handle) {
            super(handle, null);
            this.buffer = channelOutboundBuffer;
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j6) {
            this.buffer.decrementPendingOutboundBytes(j6);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j6) {
            this.buffer.incrementPendingOutboundBytes(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultChannelPipelinePendingBytesTracker extends PendingBytesTracker {
        private final DefaultChannelPipeline pipeline;

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j6) {
            this.pipeline.decrementPendingOutboundBytes(j6);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j6) {
            this.pipeline.incrementPendingOutboundBytes(j6);
        }

        DefaultChannelPipelinePendingBytesTracker(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline.estimatorHandle(), null);
            this.pipeline = defaultChannelPipeline;
        }
    }

    /* synthetic */ PendingBytesTracker(MessageSizeEstimator.Handle handle, AnonymousClass1 anonymousClass1) {
        this(handle);
    }

    public abstract void decrementPendingOutboundBytes(long j6);

    public abstract void incrementPendingOutboundBytes(long j6);

    private PendingBytesTracker(MessageSizeEstimator.Handle handle) {
        this.estimatorHandle = (MessageSizeEstimator.Handle) ObjectUtil.checkNotNull(handle, "estimatorHandle");
    }

    @Override // io.netty.channel.MessageSizeEstimator.Handle
    public final int size(Object obj) {
        return this.estimatorHandle.size(obj);
    }

    static PendingBytesTracker newTracker(Channel channel) {
        if (channel.pipeline() instanceof DefaultChannelPipeline) {
            return new DefaultChannelPipelinePendingBytesTracker((DefaultChannelPipeline) channel.pipeline());
        }
        ChannelOutboundBuffer outboundBuffer = channel.unsafe().outboundBuffer();
        MessageSizeEstimator.Handle newHandle = channel.config().getMessageSizeEstimator().newHandle();
        if (outboundBuffer == null) {
            return new NoopPendingBytesTracker(newHandle);
        }
        return new ChannelOutboundBufferPendingBytesTracker(outboundBuffer, newHandle);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NoopPendingBytesTracker extends PendingBytesTracker {
        NoopPendingBytesTracker(MessageSizeEstimator.Handle handle) {
            super(handle, null);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j6) {
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j6) {
        }
    }
}
