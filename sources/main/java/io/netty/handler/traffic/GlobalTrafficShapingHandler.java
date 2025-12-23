package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ConcurrentMap<Integer, PerChannel> channelQueues;
    long maxGlobalWriteSize;
    private final AtomicLong queuesSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PerChannel {
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        private PerChannel() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final long size;
        final Object toSend;

        private ToSend(long j6, Object obj, long j7, ChannelPromise channelPromise) {
            this.relativeTimeAction = j6;
            this.toSend = obj;
            this.size = j7;
            this.promise = channelPromise;
        }
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6, long j7, long j8, long j9) {
        super(j6, j7, j8, j9);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, PerChannel perChannel, long j6) {
        synchronized (perChannel) {
            try {
                ToSend pollFirst = perChannel.messagesQueue.pollFirst();
                while (true) {
                    if (pollFirst != null) {
                        if (pollFirst.relativeTimeAction > j6) {
                            perChannel.messagesQueue.addFirst(pollFirst);
                            break;
                        }
                        long j7 = pollFirst.size;
                        this.trafficCounter.bytesRealWriteFlowControl(j7);
                        perChannel.queueSize -= j7;
                        this.queuesSize.addAndGet(-j7);
                        channelHandlerContext.write(pollFirst.toSend, pollFirst.promise);
                        perChannel.lastWriteTimestamp = j6;
                        pollFirst = perChannel.messagesQueue.pollFirst();
                    } else {
                        break;
                    }
                }
                if (perChannel.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected int userDefinedWritabilityIndex() {
        return 2;
    }

    void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            throw new NullPointerException("executor");
        }
        TrafficCounter trafficCounter = new TrafficCounter(this, scheduledExecutorService, "GlobalTC", this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxGlobalWriteSize(long j6) {
        this.maxGlobalWriteSize = j6;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j6, long j7, long j8, ChannelPromise channelPromise) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel == null) {
            perChannel = getOrSetPerChannel(channelHandlerContext);
        }
        final PerChannel perChannel2 = perChannel;
        synchronized (perChannel2) {
            if (j7 == 0) {
                try {
                    if (perChannel2.messagesQueue.isEmpty()) {
                        this.trafficCounter.bytesRealWriteFlowControl(j6);
                        channelHandlerContext.write(obj, channelPromise);
                        perChannel2.lastWriteTimestamp = j8;
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
            long j9 = (j7 <= this.maxTime || (j8 + j7) - perChannel2.lastWriteTimestamp <= this.maxTime) ? j7 : this.maxTime;
            ToSend toSend = new ToSend(j9 + j8, obj, j6, channelPromise);
            perChannel2.messagesQueue.addLast(toSend);
            perChannel2.queueSize += j6;
            this.queuesSize.addAndGet(j6);
            long j10 = j9;
            checkWriteSuspend(channelHandlerContext, j10, perChannel2.queueSize);
            boolean z5 = this.queuesSize.get() > this.maxGlobalWriteSize;
            if (z5) {
                setUserDefinedWritability(channelHandlerContext, false);
            }
            final long j11 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.GlobalTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalTrafficShapingHandler.this.sendAllValid(channelHandlerContext, perChannel2, j11);
                }
            }, j10, TimeUnit.MILLISECONDS);
        }
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer valueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(valueOf);
        if (perChannel == null) {
            PerChannel perChannel2 = new PerChannel();
            perChannel2.messagesQueue = new ArrayDeque<>();
            perChannel2.queueSize = 0L;
            long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
            perChannel2.lastReadTimestamp = milliSecondFromNano;
            perChannel2.lastWriteTimestamp = milliSecondFromNano;
            this.channelQueues.put(valueOf, perChannel2);
            return perChannel2;
        }
        return perChannel;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j6, long j7) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null && j6 > this.maxTime && (j7 + j6) - perChannel.lastReadTimestamp > this.maxTime) {
            return this.maxTime;
        }
        return j6;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        getOrSetPerChannel(channelHandlerContext);
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channel channel = channelHandlerContext.channel();
        PerChannel remove = this.channelQueues.remove(Integer.valueOf(channel.hashCode()));
        if (remove != null) {
            synchronized (remove) {
                try {
                    if (channel.isActive()) {
                        Iterator<ToSend> it = remove.messagesQueue.iterator();
                        while (it.hasNext()) {
                            ToSend next = it.next();
                            long calculateSize = calculateSize(next.toSend);
                            this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                            remove.queueSize -= calculateSize;
                            this.queuesSize.addAndGet(-calculateSize);
                            channelHandlerContext.write(next.toSend, next.promise);
                        }
                    } else {
                        this.queuesSize.addAndGet(-remove.queueSize);
                        Iterator<ToSend> it2 = remove.messagesQueue.iterator();
                        while (it2.hasNext()) {
                            Object obj = it2.next().toSend;
                            if (obj instanceof ByteBuf) {
                                ((ByteBuf) obj).release();
                            }
                        }
                    }
                    remove.messagesQueue.clear();
                } finally {
                }
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    void informReadOperation(ChannelHandlerContext channelHandlerContext, long j6) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j6;
        }
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6, long j7, long j8) {
        super(j6, j7, j8);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6, long j7) {
        super(j6, j7);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6) {
        super(j6);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(EventExecutor eventExecutor) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(eventExecutor);
    }
}
