package xyz.adscope.amps.tool.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSTimerOutTask {
    private static final int AD_REQUEST_TIME_OUT_MESSAGE = 100010;
    private static final int CONFIG_TIME_OUT = 10000;
    private static final int CONFIG_TIME_OUT_MESSAGE = 100012;
    private static final int INIT_ASYNC_TIME_OUT = 5000;
    private static final int INIT_SYNC_TIME_OUT = 3000;
    private static final int INIT_TIME_OUT_MESSAGE = 100011;
    private static final String TAG = "TimerOutTask";
    private AMPSGlobalModel adScopeCycleModel;
    private long configTimeOut;
    private TimerTask configTimeOutTask;
    private Timer configTimer;
    private IAMPSInitCallback initCallback;
    private long initTimeOut;
    private TimerTask initTimeTask;
    private Timer initTimer;
    private boolean isExecuteConfig;
    private boolean isExecuteInit;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.amps.tool.task.AMPSTimerOutTask.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case AMPSTimerOutTask.INIT_TIME_OUT_MESSAGE /* 100011 */:
                    LogUtil.i(AMPSTimerOutTask.TAG, "init request time out isExecuteInit : " + AMPSTimerOutTask.this.isExecuteInit);
                    if (!AMPSTimerOutTask.this.isExecuteInit && AMPSTimerOutTask.this.initCallback != null) {
                        IAMPSInitCallback iAMPSInitCallback = AMPSTimerOutTask.this.initCallback;
                        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_INIT_TIME_OUT;
                        iAMPSInitCallback.failCallback(new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg()));
                    }
                    AMPSTimerOutTask.this.cancelTimerTask();
                    break;
                case AMPSTimerOutTask.CONFIG_TIME_OUT_MESSAGE /* 100012 */:
                    LogUtil.i(AMPSTimerOutTask.TAG, "config request time out isExecuteConfig : " + AMPSTimerOutTask.this.isExecuteConfig);
                    if (!AMPSTimerOutTask.this.isExecuteConfig && AMPSTimerOutTask.this.initCallback != null) {
                        IAMPSInitCallback iAMPSInitCallback2 = AMPSTimerOutTask.this.initCallback;
                        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum2 = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_REQUEST_TIME_OUT;
                        iAMPSInitCallback2.failCallback(new AMPSError(aSMPLogicErrorEnum2.getErrorCode(), aSMPLogicErrorEnum2.getErrorMsg()));
                    }
                    AMPSTimerOutTask.this.cancelTimerTask();
                    break;
            }
        }
    };

    public void buildConfigTimerTask() {
        if (this.configTimer == null) {
            this.configTimer = new Timer();
        }
        if (this.configTimeOutTask == null) {
            this.configTimeOutTask = new TimerTask() { // from class: xyz.adscope.amps.tool.task.AMPSTimerOutTask.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    AMPSTimerOutTask.this.mHandler.sendEmptyMessage(AMPSTimerOutTask.CONFIG_TIME_OUT_MESSAGE);
                }
            };
        }
        this.configTimeOut = 10000L;
        this.configTimer.schedule(this.configTimeOutTask, 10000L);
    }

    public void buildInitTimerTask(boolean z5) {
        if (this.initTimer == null) {
            this.initTimer = new Timer();
        }
        if (this.initTimeTask == null) {
            this.initTimeTask = new TimerTask() { // from class: xyz.adscope.amps.tool.task.AMPSTimerOutTask.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    AMPSTimerOutTask.this.mHandler.sendEmptyMessage(AMPSTimerOutTask.INIT_TIME_OUT_MESSAGE);
                }
            };
        }
        if (z5) {
            this.initTimeOut = 3000L;
        } else {
            this.initTimeOut = 5000L;
        }
        this.initTimer.schedule(this.initTimeTask, this.initTimeOut);
    }

    public void cancelTimerTask() {
        TimerTask timerTask = this.initTimeTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.initTimeTask = null;
        }
        Timer timer = this.initTimer;
        if (timer != null) {
            timer.cancel();
            this.initTimer = null;
        }
        TimerTask timerTask2 = this.configTimeOutTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.configTimeOutTask = null;
        }
        Timer timer2 = this.configTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.configTimer = null;
        }
    }

    public void setIsExecuteConfig(boolean z5) {
        this.isExecuteConfig = z5;
    }
}
