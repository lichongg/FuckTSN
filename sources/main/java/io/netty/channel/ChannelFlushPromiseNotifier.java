package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ChannelFlushPromiseNotifier {
    private final Queue<FlushCheckpoint> flushCheckpoints;
    private final boolean tryNotify;
    private long writeCounter;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DefaultFlushCheckpoint implements FlushCheckpoint {
        private long checkpoint;
        private final ChannelPromise future;

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public long flushCheckpoint() {
            return this.checkpoint;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public void flushCheckpoint(long j6) {
            this.checkpoint = j6;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public ChannelPromise promise() {
            return this.future;
        }

        DefaultFlushCheckpoint(long j6, ChannelPromise channelPromise) {
            this.checkpoint = j6;
            this.future = channelPromise;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface FlushCheckpoint {
        long flushCheckpoint();

        void flushCheckpoint(long j6);

        ChannelPromise promise();
    }

    public ChannelFlushPromiseNotifier(boolean z5) {
        this.flushCheckpoints = new ArrayDeque();
        this.tryNotify = z5;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, int i6) {
        return add(channelPromise, i6);
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures() {
        return notifyPromises();
    }

    public ChannelFlushPromiseNotifier notifyPromises() {
        notifyPromises0(null);
        return this;
    }

    private void notifyPromises0(Throwable th) {
        if (this.flushCheckpoints.isEmpty()) {
            this.writeCounter = 0L;
            return;
        }
        long j6 = this.writeCounter;
        while (true) {
            FlushCheckpoint peek = this.flushCheckpoints.peek();
            if (peek == null) {
                this.writeCounter = 0L;
                break;
            }
            if (peek.flushCheckpoint() <= j6) {
                this.flushCheckpoints.remove();
                ChannelPromise promise = peek.promise();
                if (th == null) {
                    if (this.tryNotify) {
                        promise.trySuccess();
                    } else {
                        promise.setSuccess();
                    }
                } else if (this.tryNotify) {
                    promise.tryFailure(th);
                } else {
                    promise.setFailure(th);
                }
            } else if (j6 > 0 && this.flushCheckpoints.size() == 1) {
                this.writeCounter = 0L;
                peek.flushCheckpoint(peek.flushCheckpoint() - j6);
            }
        }
        long j7 = this.writeCounter;
        if (j7 >= 549755813888L) {
            this.writeCounter = 0L;
            for (FlushCheckpoint flushCheckpoint : this.flushCheckpoints) {
                flushCheckpoint.flushCheckpoint(flushCheckpoint.flushCheckpoint() - j7);
            }
        }
    }

    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, long j6) {
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        ObjectUtil.checkPositiveOrZero(j6, "pendingDataSize");
        long j7 = this.writeCounter + j6;
        if (!(channelPromise instanceof FlushCheckpoint)) {
            this.flushCheckpoints.add(new DefaultFlushCheckpoint(j7, channelPromise));
            return this;
        }
        FlushCheckpoint flushCheckpoint = (FlushCheckpoint) channelPromise;
        flushCheckpoint.flushCheckpoint(j7);
        this.flushCheckpoints.add(flushCheckpoint);
        return this;
    }

    public ChannelFlushPromiseNotifier increaseWriteCounter(long j6) {
        ObjectUtil.checkPositiveOrZero(j6, "delta");
        this.writeCounter += j6;
        return this;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th) {
        return notifyPromises(th);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable th) {
        notifyPromises();
        while (true) {
            FlushCheckpoint poll = this.flushCheckpoints.poll();
            if (poll == null) {
                return this;
            }
            if (this.tryNotify) {
                poll.promise().tryFailure(th);
            } else {
                poll.promise().setFailure(th);
            }
        }
    }

    public long writeCounter() {
        return this.writeCounter;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th, Throwable th2) {
        return notifyPromises(th, th2);
    }

    public ChannelFlushPromiseNotifier() {
        this(false);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable th, Throwable th2) {
        notifyPromises0(th);
        while (true) {
            FlushCheckpoint poll = this.flushCheckpoints.poll();
            if (poll == null) {
                return this;
            }
            if (this.tryNotify) {
                poll.promise().tryFailure(th2);
            } else {
                poll.promise().setFailure(th2);
            }
        }
    }
}
