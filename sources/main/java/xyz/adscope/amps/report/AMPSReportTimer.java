package xyz.adscope.amps.report;

import android.text.TextUtils;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSReportTimer {
    private AMPSReportTimerListener reportTimerListener;
    private long time;
    private TimerTask timeTask;
    private Timer timer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface AMPSReportTimerListener {
        void onTrigger();
    }

    public void buildReportTimerTask() {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        if (this.timeTask == null) {
            this.timeTask = new TimerTask() { // from class: xyz.adscope.amps.report.AMPSReportTimer.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        if (AMPSReportTimer.this.reportTimerListener != null) {
                            AMPSReportTimer.this.reportTimerListener.onTrigger();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            };
        }
        this.timer.schedule(this.timeTask, this.time);
    }

    public void cancelTimerTask() {
        TimerTask timerTask = this.timeTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timeTask = null;
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        this.reportTimerListener = null;
    }

    public AMPSReportTimer(AMPSReportTimerListener aMPSReportTimerListener, String str) {
        this.time = 5000L;
        this.reportTimerListener = aMPSReportTimerListener;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.time = Long.parseLong(str);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }
}
