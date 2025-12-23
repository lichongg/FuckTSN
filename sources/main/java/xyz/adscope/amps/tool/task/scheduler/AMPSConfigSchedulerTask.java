package xyz.adscope.amps.tool.task.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import xyz.adscope.amps.config.AMPSConfigManager;
import xyz.adscope.amps.config.AMPSConfigResponseInfo;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.tool.task.inter.ISchedulerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSConfigSchedulerTask implements ISchedulerTask {
    private static final long INITIAL_DELAY_TIME = 10000;
    private static final int UPDATE_THREAD_COUNT = 2;
    private AMPSConfigManager adConfigManager;
    private AMPSGlobalModel ampsGlobalModel;
    private long heartbeatTime = 60000;
    private boolean isStart = false;
    private ScheduledExecutorService mHeartTask = Executors.newScheduledThreadPool(2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class ConfigTaskRunnable implements Runnable {
        ConfigTaskRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AMPSConfigSchedulerTask.this.adConfigManager == null || !AMPSConfigSchedulerTask.this.adConfigManager.checkConfig()) {
                return;
            }
            AMPSConfigSchedulerTask.this.adConfigManager.requestConfigureFile(AMPSConfigSchedulerTask.this.ampsGlobalModel, null);
        }
    }

    public void setAdScopeGlobalModel(AMPSGlobalModel aMPSGlobalModel) {
        this.ampsGlobalModel = aMPSGlobalModel;
    }

    @Override // xyz.adscope.amps.tool.task.inter.ISchedulerTask
    public void startSchedulerTask() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        this.heartbeatTime = Math.max(this.heartbeatTime, AMPSConfigResponseInfo.getInstance().getCheckTime());
        this.mHeartTask.scheduleWithFixedDelay(new ConfigTaskRunnable(), 10000L, this.heartbeatTime, TimeUnit.MILLISECONDS);
    }

    @Override // xyz.adscope.amps.tool.task.inter.ISchedulerTask
    public void stopSchedulerTask() {
        ScheduledExecutorService scheduledExecutorService = this.mHeartTask;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public AMPSConfigSchedulerTask(AMPSConfigManager aMPSConfigManager) {
        this.adConfigManager = aMPSConfigManager;
    }
}
