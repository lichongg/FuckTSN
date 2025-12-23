package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;
import master.flame.danmaku.danmaku.model.android.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractTrafficShapingHandler extends ChannelDuplexHandler {
    static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
    public static final long DEFAULT_CHECK_INTERVAL = 1000;
    static final long DEFAULT_MAX_SIZE = 4194304;
    public static final long DEFAULT_MAX_TIME = 15000;
    static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
    static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
    static final long MINIMAL_WAIT = 10;
    protected volatile long checkInterval;
    protected volatile long maxTime;
    volatile long maxWriteDelay;
    volatile long maxWriteSize;
    private volatile long readLimit;
    protected TrafficCounter trafficCounter;
    final int userDefinedWritabilityIndex;
    private volatile long writeLimit;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractTrafficShapingHandler.class);
    static final AttributeKey<Boolean> READ_SUSPENDED = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".READ_SUSPENDED");
    static final AttributeKey<Runnable> REOPEN_TASK = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".REOPEN_TASK");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ReopenReadTimerTask implements Runnable {
        final ChannelHandlerContext ctx;

        @Override // java.lang.Runnable
        public void run() {
            Channel channel = this.ctx.channel();
            ChannelConfig config = channel.config();
            if (config.isAutoRead() || !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    if (!config.isAutoRead() || AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                        if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                            AbstractTrafficShapingHandler.logger.debug("Normal unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                        }
                    } else if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                        AbstractTrafficShapingHandler.logger.debug("Unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    }
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
                config.setAutoRead(true);
                channel.read();
            } else {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    AbstractTrafficShapingHandler.logger.debug("Not unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
            }
            if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                AbstractTrafficShapingHandler.logger.debug("Unsuspend final status => " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            }
        }

        ReopenReadTimerTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }
    }

    protected AbstractTrafficShapingHandler(long j6, long j7, long j8, long j9) {
        this.maxTime = 15000L;
        this.checkInterval = 1000L;
        this.maxWriteDelay = d.f50003r;
        this.maxWriteSize = DEFAULT_MAX_SIZE;
        if (j9 <= 0) {
            throw new IllegalArgumentException("maxTime must be positive");
        }
        this.userDefinedWritabilityIndex = userDefinedWritabilityIndex();
        this.writeLimit = j6;
        this.readLimit = j7;
        this.checkInterval = j8;
        this.maxTime = j9;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        setUserDefinedWritability(channelHandlerContext, true);
        super.channelRegistered(channelHandlerContext);
    }

    public void configure(long j6, long j7, long j8) {
        configure(j6, j7);
        configure(j8);
    }

    void releaseWriteSuspended(ChannelHandlerContext channelHandlerContext) {
        setUserDefinedWritability(channelHandlerContext, true);
    }

    abstract void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j6, long j7, long j8, ChannelPromise channelPromise);

    @Deprecated
    protected void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j6, ChannelPromise channelPromise) {
        submitWrite(channelHandlerContext, obj, calculateSize(obj), j6, TrafficCounter.milliSecondFromNano(), channelPromise);
    }

    protected int userDefinedWritabilityIndex() {
        return 1;
    }

    protected long calculateSize(Object obj) {
        int readableBytes;
        if (obj instanceof ByteBuf) {
            readableBytes = ((ByteBuf) obj).readableBytes();
        } else {
            if (!(obj instanceof ByteBufHolder)) {
                return -1L;
            }
            readableBytes = ((ByteBufHolder) obj).content().readableBytes();
        }
        return readableBytes;
    }

    void checkWriteSuspend(ChannelHandlerContext channelHandlerContext, long j6, long j7) {
        if (j7 > this.maxWriteSize || j6 > this.maxWriteDelay) {
            setUserDefinedWritability(channelHandlerContext, false);
        }
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public long getMaxTimeWait() {
        return this.maxTime;
    }

    public long getMaxWriteDelay() {
        return this.maxWriteDelay;
    }

    public long getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public long getReadLimit() {
        return this.readLimit;
    }

    public long getWriteLimit() {
        return this.writeLimit;
    }

    public void setCheckInterval(long j6) {
        this.checkInterval = j6;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(j6);
        }
    }

    public void setMaxTimeWait(long j6) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxTime must be positive");
        }
        this.maxTime = j6;
    }

    public void setMaxWriteDelay(long j6) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxWriteDelay must be positive");
        }
        this.maxWriteDelay = j6;
    }

    public void setMaxWriteSize(long j6) {
        this.maxWriteSize = j6;
    }

    public void setReadLimit(long j6) {
        this.readLimit = j6;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    void setTrafficCounter(TrafficCounter trafficCounter) {
        this.trafficCounter = trafficCounter;
    }

    public void setWriteLimit(long j6) {
        this.writeLimit = j6;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(290);
        sb.append("TrafficShaping with Write Limit: ");
        sb.append(this.writeLimit);
        sb.append(" Read Limit: ");
        sb.append(this.readLimit);
        sb.append(" CheckInterval: ");
        sb.append(this.checkInterval);
        sb.append(" maxDelay: ");
        sb.append(this.maxWriteDelay);
        sb.append(" maxSize: ");
        sb.append(this.maxWriteSize);
        sb.append(" and Counter: ");
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            sb.append(trafficCounter);
        } else {
            sb.append("none");
        }
        return sb.toString();
    }

    public TrafficCounter trafficCounter() {
        return this.trafficCounter;
    }

    protected static boolean isHandlerActive(ChannelHandlerContext channelHandlerContext) {
        Boolean bool = (Boolean) channelHandlerContext.channel().attr(READ_SUSPENDED).get();
        if (bool != null && !Boolean.FALSE.equals(bool)) {
            return false;
        }
        return true;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        ChannelHandlerContext channelHandlerContext2;
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            channelHandlerContext2 = channelHandlerContext;
            long checkWaitReadTime = checkWaitReadTime(channelHandlerContext2, this.trafficCounter.readTimeToWait(calculateSize, this.readLimit, this.maxTime, milliSecondFromNano), milliSecondFromNano);
            if (checkWaitReadTime >= 10) {
                Channel channel = channelHandlerContext2.channel();
                ChannelConfig config = channel.config();
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Read suspend: " + checkWaitReadTime + ':' + config.isAutoRead() + ':' + isHandlerActive(channelHandlerContext2));
                }
                if (config.isAutoRead() && isHandlerActive(channelHandlerContext2)) {
                    config.setAutoRead(false);
                    channel.attr(READ_SUSPENDED).set(Boolean.TRUE);
                    Attribute attr = channel.attr(REOPEN_TASK);
                    Runnable runnable = (Runnable) attr.get();
                    if (runnable == null) {
                        runnable = new ReopenReadTimerTask(channelHandlerContext2);
                        attr.set(runnable);
                    }
                    channelHandlerContext2.executor().schedule(runnable, checkWaitReadTime, TimeUnit.MILLISECONDS);
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Suspend final status => " + config.isAutoRead() + ':' + isHandlerActive(channelHandlerContext2) + " will reopened at: " + checkWaitReadTime);
                    }
                }
            }
        } else {
            channelHandlerContext2 = channelHandlerContext;
        }
        informReadOperation(channelHandlerContext2, milliSecondFromNano);
        channelHandlerContext2.fireChannelRead(obj);
    }

    public void configure(long j6, long j7) {
        this.writeLimit = j6;
        this.readLimit = j7;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) {
        if (isHandlerActive(channelHandlerContext)) {
            channelHandlerContext.read();
        }
    }

    void releaseReadSuspended(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        channel.attr(READ_SUSPENDED).set(Boolean.FALSE);
        channel.config().setAutoRead(true);
    }

    void setUserDefinedWritability(ChannelHandlerContext channelHandlerContext, boolean z5) {
        ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (outboundBuffer != null) {
            outboundBuffer.setUserDefinedWritability(this.userDefinedWritabilityIndex, z5);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        ChannelHandlerContext channelHandlerContext2;
        Object obj2;
        ChannelPromise channelPromise2;
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long writeTimeToWait = this.trafficCounter.writeTimeToWait(calculateSize, this.writeLimit, this.maxTime, milliSecondFromNano);
            if (writeTimeToWait >= 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Write suspend: " + writeTimeToWait + ':' + channelHandlerContext.channel().config().isAutoRead() + ':' + isHandlerActive(channelHandlerContext));
                }
                submitWrite(channelHandlerContext, obj, calculateSize, writeTimeToWait, milliSecondFromNano, channelPromise);
                return;
            }
            calculateSize = calculateSize;
            channelPromise2 = channelPromise;
            channelHandlerContext2 = channelHandlerContext;
            obj2 = obj;
        } else {
            channelHandlerContext2 = channelHandlerContext;
            obj2 = obj;
            channelPromise2 = channelPromise;
        }
        submitWrite(channelHandlerContext2, obj2, calculateSize, 0L, milliSecondFromNano, channelPromise2);
    }

    public void configure(long j6) {
        this.checkInterval = j6;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(this.checkInterval);
        }
    }

    protected AbstractTrafficShapingHandler(long j6, long j7, long j8) {
        this(j6, j7, j8, 15000L);
    }

    protected AbstractTrafficShapingHandler(long j6, long j7) {
        this(j6, j7, 1000L, 15000L);
    }

    protected AbstractTrafficShapingHandler() {
        this(0L, 0L, 1000L, 15000L);
    }

    protected AbstractTrafficShapingHandler(long j6) {
        this(0L, 0L, j6, 15000L);
    }

    protected void doAccounting(TrafficCounter trafficCounter) {
    }

    void informReadOperation(ChannelHandlerContext channelHandlerContext, long j6) {
    }

    long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j6, long j7) {
        return j6;
    }
}
