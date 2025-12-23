package io.netty.handler.traffic;

import com.bykv.vk.component.ttvideo.player.C;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TrafficCounter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) TrafficCounter.class);
    final ScheduledExecutorService executor;
    private long lastCumulativeTime;
    private volatile long lastReadBytes;
    private long lastReadThroughput;
    private volatile long lastReadingTime;
    private long lastWriteThroughput;
    private volatile long lastWritingTime;
    private volatile long lastWrittenBytes;
    Runnable monitor;
    volatile boolean monitorActive;
    final String name;
    private long readingTime;
    private long realWriteThroughput;
    volatile ScheduledFuture<?> scheduledFuture;
    final AbstractTrafficShapingHandler trafficShapingHandler;
    private long writingTime;
    private final AtomicLong currentWrittenBytes = new AtomicLong();
    private final AtomicLong currentReadBytes = new AtomicLong();
    private final AtomicLong cumulativeWrittenBytes = new AtomicLong();
    private final AtomicLong cumulativeReadBytes = new AtomicLong();
    final AtomicLong lastTime = new AtomicLong();
    private final AtomicLong realWrittenBytes = new AtomicLong();
    final AtomicLong checkInterval = new AtomicLong(1000);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.traffic.TrafficCounter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class TrafficMonitoringTask implements Runnable {
        private TrafficMonitoringTask() {
        }

        /* synthetic */ TrafficMonitoringTask(TrafficCounter trafficCounter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TrafficCounter.this.monitorActive) {
                TrafficCounter.this.resetAccounting(TrafficCounter.milliSecondFromNano());
                TrafficCounter trafficCounter = TrafficCounter.this;
                AbstractTrafficShapingHandler abstractTrafficShapingHandler = trafficCounter.trafficShapingHandler;
                if (abstractTrafficShapingHandler != null) {
                    abstractTrafficShapingHandler.doAccounting(trafficCounter);
                }
            }
        }
    }

    public TrafficCounter(ScheduledExecutorService scheduledExecutorService, String str, long j6) {
        if (str == null) {
            throw new NullPointerException(CommonNetImpl.NAME);
        }
        this.trafficShapingHandler = null;
        this.executor = scheduledExecutorService;
        this.name = str;
        init(j6);
    }

    @Deprecated
    public long readTimeToWait(long j6, long j7, long j8) {
        return readTimeToWait(j6, j7, j8, milliSecondFromNano());
    }

    synchronized void resetAccounting(long j6) {
        try {
            long andSet = j6 - this.lastTime.getAndSet(j6);
            if (andSet == 0) {
                return;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled() && andSet > (checkInterval() << 1)) {
                internalLogger.debug("Acct schedule not ok: " + andSet + " > 2*" + checkInterval() + " from " + this.name);
            }
            this.lastReadBytes = this.currentReadBytes.getAndSet(0L);
            this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0L);
            this.lastReadThroughput = (this.lastReadBytes * 1000) / andSet;
            this.lastWriteThroughput = (this.lastWrittenBytes * 1000) / andSet;
            this.realWriteThroughput = (this.realWrittenBytes.getAndSet(0L) * 1000) / andSet;
            this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
            this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void start() {
        if (this.monitorActive) {
            return;
        }
        this.lastTime.set(milliSecondFromNano());
        long j6 = this.checkInterval.get();
        if (j6 > 0 && this.executor != null) {
            this.monitorActive = true;
            TrafficMonitoringTask trafficMonitoringTask = new TrafficMonitoringTask(this, null);
            this.monitor = trafficMonitoringTask;
            this.scheduledFuture = this.executor.scheduleAtFixedRate(trafficMonitoringTask, 0L, j6, TimeUnit.MILLISECONDS);
        }
    }

    public synchronized void stop() {
        try {
            if (this.monitorActive) {
                this.monitorActive = false;
                resetAccounting(milliSecondFromNano());
                AbstractTrafficShapingHandler abstractTrafficShapingHandler = this.trafficShapingHandler;
                if (abstractTrafficShapingHandler != null) {
                    abstractTrafficShapingHandler.doAccounting(this);
                }
                if (this.scheduledFuture != null) {
                    this.scheduledFuture.cancel(true);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public long writeTimeToWait(long j6, long j7, long j8) {
        return writeTimeToWait(j6, j7, j8, milliSecondFromNano());
    }

    void bytesRealWriteFlowControl(long j6) {
        this.realWrittenBytes.addAndGet(j6);
    }

    void bytesRecvFlowControl(long j6) {
        this.currentReadBytes.addAndGet(j6);
        this.cumulativeReadBytes.addAndGet(j6);
    }

    void bytesWriteFlowControl(long j6) {
        this.currentWrittenBytes.addAndGet(j6);
        this.cumulativeWrittenBytes.addAndGet(j6);
    }

    public long checkInterval() {
        return this.checkInterval.get();
    }

    public void configure(long j6) {
        long j7 = (j6 / 10) * 10;
        if (this.checkInterval.getAndSet(j7) != j7) {
            if (j7 <= 0) {
                stop();
                this.lastTime.set(milliSecondFromNano());
            } else {
                stop();
                start();
            }
        }
    }

    public long cumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long cumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long currentReadBytes() {
        return this.currentReadBytes.get();
    }

    public long currentWrittenBytes() {
        return this.currentWrittenBytes.get();
    }

    public long getRealWriteThroughput() {
        return this.realWriteThroughput;
    }

    public AtomicLong getRealWrittenBytes() {
        return this.realWrittenBytes;
    }

    public long lastCumulativeTime() {
        return this.lastCumulativeTime;
    }

    public long lastReadBytes() {
        return this.lastReadBytes;
    }

    public long lastReadThroughput() {
        return this.lastReadThroughput;
    }

    public long lastTime() {
        return this.lastTime.get();
    }

    public long lastWriteThroughput() {
        return this.lastWriteThroughput;
    }

    public long lastWrittenBytes() {
        return this.lastWrittenBytes;
    }

    public String name() {
        return this.name;
    }

    public long readTimeToWait(long j6, long j7, long j8, long j9) {
        bytesRecvFlowControl(j6);
        if (j6 == 0 || j7 == 0) {
            return 0L;
        }
        long j10 = this.lastTime.get();
        long j11 = this.currentReadBytes.get();
        long j12 = this.readingTime;
        long j13 = this.lastReadBytes;
        long j14 = j9 - j10;
        long max = Math.max(this.lastReadingTime - j10, 0L);
        if (j14 > 10) {
            long j15 = (((1000 * j11) / j7) - j14) + max;
            if (j15 <= 10) {
                this.readingTime = Math.max(j12, j9);
                return 0L;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Time: " + j15 + ':' + j11 + ':' + j14 + ':' + max);
            }
            if (j15 > j8 && (j9 + j15) - j12 > j8) {
                j15 = j8;
            }
            this.readingTime = Math.max(j12, j9 + j15);
            return j15;
        }
        long j16 = j11 + j13;
        long j17 = j14 + this.checkInterval.get();
        long j18 = (((1000 * j16) / j7) - j17) + max;
        if (j18 <= 10) {
            this.readingTime = Math.max(j12, j9);
            return 0L;
        }
        InternalLogger internalLogger2 = logger;
        if (internalLogger2.isDebugEnabled()) {
            internalLogger2.debug("Time: " + j18 + ':' + j16 + ':' + j17 + ':' + max);
        }
        if (j18 > j8 && (j9 + j18) - j12 > j8) {
            j18 = j8;
        }
        this.readingTime = Math.max(j12, j9 + j18);
        return j18;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(165);
        sb.append("Monitor ");
        sb.append(this.name);
        sb.append(" Current Speed Read: ");
        sb.append(this.lastReadThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Asked Write: ");
        sb.append(this.lastWriteThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Real Write: ");
        sb.append(this.realWriteThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Current Read: ");
        sb.append(this.currentReadBytes.get() >> 10);
        sb.append(" KB, ");
        sb.append("Current asked Write: ");
        sb.append(this.currentWrittenBytes.get() >> 10);
        sb.append(" KB, ");
        sb.append("Current real Write: ");
        sb.append(this.realWrittenBytes.get() >> 10);
        sb.append(" KB");
        return sb.toString();
    }

    public long writeTimeToWait(long j6, long j7, long j8, long j9) {
        bytesWriteFlowControl(j6);
        if (j6 == 0 || j7 == 0) {
            return 0L;
        }
        long j10 = this.lastTime.get();
        long j11 = this.currentWrittenBytes.get();
        long j12 = this.lastWrittenBytes;
        long j13 = this.writingTime;
        long max = Math.max(this.lastWritingTime - j10, 0L);
        long j14 = j9 - j10;
        if (j14 > 10) {
            long j15 = (((1000 * j11) / j7) - j14) + max;
            if (j15 <= 10) {
                this.writingTime = Math.max(j13, j9);
                return 0L;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Time: " + j15 + ':' + j11 + ':' + j14 + ':' + max);
            }
            if (j15 > j8 && (j9 + j15) - j13 > j8) {
                j15 = j8;
            }
            this.writingTime = Math.max(j13, j9 + j15);
            return j15;
        }
        long j16 = j11 + j12;
        long j17 = j14 + this.checkInterval.get();
        long j18 = (((1000 * j16) / j7) - j17) + max;
        if (j18 <= 10) {
            this.writingTime = Math.max(j13, j9);
            return 0L;
        }
        InternalLogger internalLogger2 = logger;
        if (internalLogger2.isDebugEnabled()) {
            internalLogger2.debug("Time: " + j18 + ':' + j16 + ':' + j17 + ':' + max);
        }
        if (j18 > j8 && (j9 + j18) - j13 > j8) {
            j18 = j8;
        }
        this.writingTime = Math.max(j13, j9 + j18);
        return j18;
    }

    private void init(long j6) {
        this.lastCumulativeTime = System.currentTimeMillis();
        long milliSecondFromNano = milliSecondFromNano();
        this.writingTime = milliSecondFromNano;
        this.readingTime = milliSecondFromNano;
        this.lastWritingTime = milliSecondFromNano;
        this.lastReadingTime = this.writingTime;
        configure(j6);
    }

    public static long milliSecondFromNano() {
        return System.nanoTime() / C.MICROS_PER_SECOND;
    }

    public void resetCumulativeTime() {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.cumulativeReadBytes.set(0L);
        this.cumulativeWrittenBytes.set(0L);
    }

    public TrafficCounter(AbstractTrafficShapingHandler abstractTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j6) {
        if (abstractTrafficShapingHandler == null) {
            throw new IllegalArgumentException("trafficShapingHandler");
        }
        if (str != null) {
            this.trafficShapingHandler = abstractTrafficShapingHandler;
            this.executor = scheduledExecutorService;
            this.name = str;
            init(j6);
            return;
        }
        throw new NullPointerException(CommonNetImpl.NAME);
    }
}
