package io.netty.handler.traffic;

import io.netty.handler.traffic.GlobalChannelTrafficShapingHandler;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GlobalChannelTrafficCounter extends TrafficCounter {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MixedTrafficMonitoringTask implements Runnable {
        private final TrafficCounter counter;
        private final GlobalChannelTrafficShapingHandler trafficShapingHandler1;

        @Override // java.lang.Runnable
        public void run() {
            if (this.counter.monitorActive) {
                long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
                this.counter.resetAccounting(milliSecondFromNano);
                Iterator<GlobalChannelTrafficShapingHandler.PerChannel> it = this.trafficShapingHandler1.channelQueues.values().iterator();
                while (it.hasNext()) {
                    it.next().channelTrafficCounter.resetAccounting(milliSecondFromNano);
                }
                this.trafficShapingHandler1.doAccounting(this.counter);
            }
        }

        MixedTrafficMonitoringTask(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler, TrafficCounter trafficCounter) {
            this.trafficShapingHandler1 = globalChannelTrafficShapingHandler;
            this.counter = trafficCounter;
        }
    }

    @Override // io.netty.handler.traffic.TrafficCounter
    public synchronized void start() {
        if (this.monitorActive) {
            return;
        }
        this.lastTime.set(TrafficCounter.milliSecondFromNano());
        long j6 = this.checkInterval.get();
        if (j6 > 0) {
            this.monitorActive = true;
            MixedTrafficMonitoringTask mixedTrafficMonitoringTask = new MixedTrafficMonitoringTask((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler, this);
            this.monitor = mixedTrafficMonitoringTask;
            this.scheduledFuture = this.executor.scheduleAtFixedRate(mixedTrafficMonitoringTask, 0L, j6, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.TrafficCounter
    public synchronized void stop() {
        if (this.monitorActive) {
            this.monitorActive = false;
            resetAccounting(TrafficCounter.milliSecondFromNano());
            this.trafficShapingHandler.doAccounting(this);
            if (this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }

    @Override // io.netty.handler.traffic.TrafficCounter
    public void resetCumulativeTime() {
        Iterator<GlobalChannelTrafficShapingHandler.PerChannel> it = ((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler).channelQueues.values().iterator();
        while (it.hasNext()) {
            it.next().channelTrafficCounter.resetCumulativeTime();
        }
        super.resetCumulativeTime();
    }

    public GlobalChannelTrafficCounter(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j6) {
        super(globalChannelTrafficShapingHandler, scheduledExecutorService, str, j6);
        if (scheduledExecutorService != null) {
        } else {
            throw new IllegalArgumentException("Executor must not be null");
        }
    }
}
