package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import io.netty.util.Attribute;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class GlobalChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private static final float DEFAULT_ACCELERATION = -0.1f;
    private static final float DEFAULT_DEVIATION = 0.1f;
    private static final float DEFAULT_SLOWDOWN = 0.4f;
    private static final float MAX_DEVIATION = 0.4f;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) GlobalChannelTrafficShapingHandler.class);
    private volatile float accelerationFactor;
    final ConcurrentMap<Integer, PerChannel> channelQueues;
    private final AtomicLong cumulativeReadBytes;
    private final AtomicLong cumulativeWrittenBytes;
    private volatile float maxDeviation;
    volatile long maxGlobalWriteSize;
    private final AtomicLong queuesSize;
    private volatile long readChannelLimit;
    private volatile boolean readDeviationActive;
    private volatile float slowDownFactor;
    private volatile long writeChannelLimit;
    private volatile boolean writeDeviationActive;

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

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6, long j7, long j8, long j9, long j10, long j11) {
        super(j6, j7, j10, j11);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
        this.writeChannelLimit = j8;
        this.readChannelLimit = j9;
    }

    private long computeBalancedWait(float f6, float f7, long j6) {
        float f8;
        if (f7 != 0.0f) {
            float f9 = f6 / f7;
            if (f9 <= this.maxDeviation) {
                f8 = this.accelerationFactor;
            } else if (f9 >= 1.0f - this.maxDeviation) {
                f8 = this.slowDownFactor;
                if (j6 < 10) {
                    j6 = 10;
                }
            }
            return (long) (j6 * f8);
        }
        return j6;
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
                        perChannel.channelTrafficCounter.bytesRealWriteFlowControl(j7);
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
        return 3;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PerChannel {
        TrafficCounter channelTrafficCounter;
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        PerChannel() {
        }
    }

    private void computeDeviationCumulativeBytes() {
        long j6 = 0;
        long j7 = Long.MAX_VALUE;
        long j8 = Long.MAX_VALUE;
        long j9 = 0;
        for (PerChannel perChannel : this.channelQueues.values()) {
            long cumulativeWrittenBytes = perChannel.channelTrafficCounter.cumulativeWrittenBytes();
            if (j6 < cumulativeWrittenBytes) {
                j6 = cumulativeWrittenBytes;
            }
            if (j7 > cumulativeWrittenBytes) {
                j7 = cumulativeWrittenBytes;
            }
            long cumulativeReadBytes = perChannel.channelTrafficCounter.cumulativeReadBytes();
            if (j9 < cumulativeReadBytes) {
                j9 = cumulativeReadBytes;
            }
            if (j8 > cumulativeReadBytes) {
                j8 = cumulativeReadBytes;
            }
        }
        boolean z5 = false;
        boolean z6 = this.channelQueues.size() > 1;
        this.readDeviationActive = z6 && j8 < j9 / 2;
        if (z6 && j7 < j6 / 2) {
            z5 = true;
        }
        this.writeDeviationActive = z5;
        this.cumulativeWrittenBytes.set(j6);
        this.cumulativeReadBytes.set(j9);
    }

    public float accelerationFactor() {
        return this.accelerationFactor;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        ChannelHandlerContext channelHandlerContext2;
        long j6;
        long j7;
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long readTimeToWait = this.trafficCounter.readTimeToWait(calculateSize, getReadLimit(), this.maxTime, milliSecondFromNano);
            PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
            if (perChannel != null) {
                long readTimeToWait2 = perChannel.channelTrafficCounter.readTimeToWait(calculateSize, this.readChannelLimit, this.maxTime, milliSecondFromNano);
                if (this.readDeviationActive) {
                    long cumulativeReadBytes = perChannel.channelTrafficCounter.cumulativeReadBytes();
                    long j8 = this.cumulativeReadBytes.get();
                    r1 = cumulativeReadBytes > 0 ? cumulativeReadBytes : 0L;
                    if (j8 < r1) {
                        j8 = r1;
                    }
                    r1 = computeBalancedWait(r1, j8, readTimeToWait2);
                } else {
                    r1 = readTimeToWait2;
                }
            }
            if (r1 < readTimeToWait) {
                j6 = readTimeToWait;
                channelHandlerContext2 = channelHandlerContext;
                j7 = milliSecondFromNano;
            } else {
                j6 = r1;
                j7 = milliSecondFromNano;
                channelHandlerContext2 = channelHandlerContext;
            }
            long checkWaitReadTime = checkWaitReadTime(channelHandlerContext2, j6, j7);
            milliSecondFromNano = j7;
            if (checkWaitReadTime >= 10) {
                Channel channel = channelHandlerContext2.channel();
                ChannelConfig config = channel.config();
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Read Suspend: " + checkWaitReadTime + ':' + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext2));
                }
                if (config.isAutoRead() && AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext2)) {
                    config.setAutoRead(false);
                    channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.TRUE);
                    Attribute attr = channel.attr(AbstractTrafficShapingHandler.REOPEN_TASK);
                    Runnable runnable = (Runnable) attr.get();
                    if (runnable == null) {
                        runnable = new AbstractTrafficShapingHandler.ReopenReadTimerTask(channelHandlerContext2);
                        attr.set(runnable);
                    }
                    channelHandlerContext2.executor().schedule(runnable, checkWaitReadTime, TimeUnit.MILLISECONDS);
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Suspend final status => " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext2) + " will reopened at: " + checkWaitReadTime);
                    }
                }
            }
        } else {
            channelHandlerContext2 = channelHandlerContext;
        }
        informReadOperation(channelHandlerContext2, milliSecondFromNano);
        channelHandlerContext.fireChannelRead(obj);
    }

    public Collection<TrafficCounter> channelTrafficCounters() {
        return new AbstractCollection<TrafficCounter>() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<TrafficCounter> iterator() {
                return new Iterator<TrafficCounter>() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1.1
                    final Iterator<PerChannel> iter;

                    {
                        this.iter = GlobalChannelTrafficShapingHandler.this.channelQueues.values().iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public TrafficCounter next() {
                        return this.iter.next().channelTrafficCounter;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return GlobalChannelTrafficShapingHandler.this.channelQueues.size();
            }
        };
    }

    public void configureChannel(long j6, long j7) {
        this.writeChannelLimit = j6;
        this.readChannelLimit = j7;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        Iterator<PerChannel> it = this.channelQueues.values().iterator();
        while (it.hasNext()) {
            it.next().channelTrafficCounter.resetAccounting(milliSecondFromNano);
        }
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    public long getReadChannelLimit() {
        return this.readChannelLimit;
    }

    public long getWriteChannelLimit() {
        return this.writeChannelLimit;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.trafficCounter.resetCumulativeTime();
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
                            remove.channelTrafficCounter.bytesRealWriteFlowControl(calculateSize);
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

    public float maxDeviation() {
        return this.maxDeviation;
    }

    protected long maximumCumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    protected long maximumCumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxGlobalWriteSize(long j6) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxGlobalWriteSize must be positive");
        }
        this.maxGlobalWriteSize = j6;
    }

    public void setReadChannelLimit(long j6) {
        this.readChannelLimit = j6;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        Iterator<PerChannel> it = this.channelQueues.values().iterator();
        while (it.hasNext()) {
            it.next().channelTrafficCounter.resetAccounting(milliSecondFromNano);
        }
    }

    public void setWriteChannelLimit(long j6) {
        this.writeChannelLimit = j6;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        Iterator<PerChannel> it = this.channelQueues.values().iterator();
        while (it.hasNext()) {
            it.next().channelTrafficCounter.resetAccounting(milliSecondFromNano);
        }
    }

    public float slowDownFactor() {
        return this.slowDownFactor;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j6, long j7, long j8, ChannelPromise channelPromise) {
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
                        perChannel2.channelTrafficCounter.bytesRealWriteFlowControl(j6);
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
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    GlobalChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext, perChannel2, j11);
                }
            }, j10, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public String toString() {
        StringBuilder sb = new StringBuilder(340);
        sb.append(super.toString());
        sb.append(" Write Channel Limit: ");
        sb.append(this.writeChannelLimit);
        sb.append(" Read Channel Limit: ");
        sb.append(this.readChannelLimit);
        return sb.toString();
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        long j6;
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            j6 = milliSecondFromNano;
            long writeTimeToWait = this.trafficCounter.writeTimeToWait(calculateSize, getWriteLimit(), this.maxTime, j6);
            PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
            if (perChannel != null) {
                long writeTimeToWait2 = perChannel.channelTrafficCounter.writeTimeToWait(calculateSize, this.writeChannelLimit, this.maxTime, j6);
                if (this.writeDeviationActive) {
                    long cumulativeWrittenBytes = perChannel.channelTrafficCounter.cumulativeWrittenBytes();
                    long j7 = this.cumulativeWrittenBytes.get();
                    r12 = cumulativeWrittenBytes > 0 ? cumulativeWrittenBytes : 0L;
                    r12 = computeBalancedWait(r12, j7 < r12 ? r12 : j7, writeTimeToWait2);
                } else {
                    r12 = writeTimeToWait2;
                }
            }
            if (r12 >= writeTimeToWait) {
                writeTimeToWait = r12;
            }
            if (writeTimeToWait >= 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Write suspend: " + writeTimeToWait + ':' + channelHandlerContext.channel().config().isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext));
                }
                submitWrite(channelHandlerContext, obj, calculateSize, writeTimeToWait, j6, channelPromise);
                return;
            }
        } else {
            j6 = milliSecondFromNano;
        }
        submitWrite(channelHandlerContext, obj, calculateSize, 0L, j6, channelPromise);
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer valueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(valueOf);
        if (perChannel == null) {
            PerChannel perChannel2 = new PerChannel();
            perChannel2.messagesQueue = new ArrayDeque<>();
            perChannel2.channelTrafficCounter = new TrafficCounter(this, null, "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
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
    protected long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j6, long j7) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null && j6 > this.maxTime && (j7 + j6) - perChannel.lastReadTimestamp > this.maxTime) {
            return this.maxTime;
        }
        return j6;
    }

    void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        setMaxDeviation(0.1f, 0.4f, DEFAULT_ACCELERATION);
        if (scheduledExecutorService != null) {
            GlobalChannelTrafficCounter globalChannelTrafficCounter = new GlobalChannelTrafficCounter(this, scheduledExecutorService, "GlobalChannelTC", this.checkInterval);
            setTrafficCounter(globalChannelTrafficCounter);
            globalChannelTrafficCounter.start();
            return;
        }
        throw new IllegalArgumentException("Executor must not be null");
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void doAccounting(TrafficCounter trafficCounter) {
        computeDeviationCumulativeBytes();
        super.doAccounting(trafficCounter);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        getOrSetPerChannel(channelHandlerContext);
        this.trafficCounter.resetCumulativeTime();
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void informReadOperation(ChannelHandlerContext channelHandlerContext, long j6) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j6;
        }
    }

    public void setMaxDeviation(float f6, float f7, float f8) {
        if (f6 <= 0.4f) {
            if (f7 >= 0.0f) {
                if (f8 <= 0.0f) {
                    this.maxDeviation = f6;
                    this.accelerationFactor = f8 + 1.0f;
                    this.slowDownFactor = f7 + 1.0f;
                    return;
                }
                throw new IllegalArgumentException("accelerationFactor must be <= 0");
            }
            throw new IllegalArgumentException("slowDownFactor must be >= 0");
        }
        throw new IllegalArgumentException("maxDeviation must be <= 0.4");
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6, long j7, long j8, long j9, long j10) {
        super(j6, j7, j10);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        this.writeChannelLimit = j8;
        this.readChannelLimit = j9;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6, long j7, long j8, long j9) {
        super(j6, j7);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        this.writeChannelLimit = j8;
        this.readChannelLimit = j9;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j6) {
        super(j6);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }
}
