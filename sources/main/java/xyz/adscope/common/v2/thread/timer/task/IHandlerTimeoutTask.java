package xyz.adscope.common.v2.thread.timer.task;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import xyz.adscope.common.v2.handle.WeakReferenceHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IHandlerTimeoutTask extends ICommonTimeoutTask {
    public static final int SCHEDULE_TIMEOUT_MSG = 1001;
    public static final int TIMEOUT_INIT_CONFIG = 10000;
    public static final int TIMEOUT_REQUEST_AD_DEFAULT = 10000;
    private final Handler mTaskHandler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.thread.timer.task.IHandlerTimeoutTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TimeoutHandler extends WeakReferenceHandler {
        private final IHandlerTimeoutTask task;

        /* synthetic */ TimeoutHandler(Context context, IHandlerTimeoutTask iHandlerTimeoutTask, AnonymousClass1 anonymousClass1) {
            this(context, iHandlerTimeoutTask);
        }

        private TimeoutHandler(Context context, IHandlerTimeoutTask iHandlerTimeoutTask) {
            super(context);
            this.task = iHandlerTimeoutTask;
        }

        @Override // xyz.adscope.common.v2.handle.WeakReferenceHandler
        public void scopeHandleMessage(Message message) {
            IHandlerTimeoutTask iHandlerTimeoutTask;
            if (message == null || message.what != 1001 || (iHandlerTimeoutTask = this.task) == null) {
                return;
            }
            iHandlerTimeoutTask.handleMessageExecute();
            this.task.cancelCountDown();
        }
    }

    protected abstract void handleMessageExecute();

    @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
    public void cancelCountDown() {
        Handler handler = this.mTaskHandler;
        if (handler != null && handler.hasMessages(1001)) {
            this.mTaskHandler.removeMessages(1001);
        }
        super.cancelCountDown();
    }

    @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
    protected void onScheduleTimeout() {
        this.mTaskHandler.sendEmptyMessage(1001);
    }

    public IHandlerTimeoutTask(Context context, long j6) {
        super(j6);
        this.mTaskHandler = new TimeoutHandler(context, this, null);
    }
}
