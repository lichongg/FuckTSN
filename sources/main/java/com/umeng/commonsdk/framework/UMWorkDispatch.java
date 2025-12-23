package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMWorkDispatch {
    public static final String GENERAL_CONTENT = "content";
    public static final String GENERAL_HEADER = "header";
    public static final String KEY_EXCEPTION = "exception";
    private static final int MSG_AUTO_PROCESS = 769;
    private static final int MSG_CHECKER_TIMER = 771;
    private static final int MSG_DELAY_PROCESS = 770;
    private static final int MSG_QUIT = 784;
    private static final int MSG_SEND_EVENT = 768;
    private static HandlerThread mNetTask;
    private static a mSender;
    private static Object mSenderInitLock = new Object();
    private static Handler mTaskHandler;

    public static synchronized boolean eventHasExist(int i6) {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return false;
            }
            return handler.hasMessages(i6);
        }
    }

    public static synchronized void removeEvent() {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(MSG_CHECKER_TIMER);
        }
    }

    public static void sendEvent(Context context, int i6, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        sendEventInternal(context, 768, i6, uMLogDataProtocol, obj, 0L);
    }

    public static void Quit() {
        Handler handler = mTaskHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = MSG_QUIT;
            mTaskHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delayProcess() {
        JSONObject jSONObject;
        JSONObject buildEnvelopeWithExtHeader;
        ULog.d("--->>> delayProcess Enter...");
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long maxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(maxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
                return;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
        JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
        if (jSONObject2 == null || jSONObject3 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(buildEnvelopeWithExtHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleEvent(Message message) {
        int i6 = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i6));
        if (callbackFromModuleName != null) {
            ULog.d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i6) + "]");
            callbackFromModuleName.workEvent(obj, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleQuit() {
        if (mSender == null || mNetTask == null) {
            return;
        }
        a.c();
        ULog.d("--->>> handleQuit: Quit dispatch thread.");
        mNetTask.quit();
        teardown();
    }

    private static synchronized void init() {
        synchronized (UMWorkDispatch.class) {
            ULog.d("--->>> Dispatch: init Enter...");
            try {
                if (mNetTask == null) {
                    HandlerThread handlerThread = new HandlerThread("work_thread");
                    mNetTask = handlerThread;
                    handlerThread.start();
                    if (mTaskHandler == null) {
                        mTaskHandler = new Handler(mNetTask.getLooper()) { // from class: com.umeng.commonsdk.framework.UMWorkDispatch.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                int i6 = message.what;
                                if (i6 == 768) {
                                    UMWorkDispatch.handleEvent(message);
                                    return;
                                }
                                if (i6 == UMWorkDispatch.MSG_QUIT) {
                                    UMWorkDispatch.handleQuit();
                                } else if (i6 == UMWorkDispatch.MSG_DELAY_PROCESS) {
                                    UMWorkDispatch.delayProcess();
                                } else {
                                    if (i6 != UMWorkDispatch.MSG_CHECKER_TIMER) {
                                        return;
                                    }
                                    UMWorkDispatch.handleEvent(message);
                                }
                            }
                        };
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
            ULog.d("--->>> Dispatch: init Exit...");
        }
    }

    public static void registerConnStateObserver(UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            a.a(uMSenderStateNotify);
        }
    }

    public static void sendDelayProcessMsg(long j6) {
        Handler handler = mTaskHandler;
        if (handler != null) {
            if (handler.hasMessages(MSG_DELAY_PROCESS)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message obtainMessage = mTaskHandler.obtainMessage();
            obtainMessage.what = MSG_DELAY_PROCESS;
            mTaskHandler.sendMessageDelayed(obtainMessage, j6);
        }
    }

    public static void sendEvent(Context context, int i6, UMLogDataProtocol uMLogDataProtocol, Object obj, long j6) {
        sendEventInternal(context, 768, i6, uMLogDataProtocol, obj, j6);
    }

    public static void sendEventEx(Context context, int i6, UMLogDataProtocol uMLogDataProtocol, Object obj, long j6) {
        sendEventInternal(context, MSG_CHECKER_TIMER, i6, uMLogDataProtocol, obj, j6);
    }

    public static void sendEventInternal(Context context, int i6, int i7, UMLogDataProtocol uMLogDataProtocol, Object obj, long j6) {
        if (context == null || uMLogDataProtocol == null) {
            ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        UMModuleRegister.registerAppContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        if (UMModuleRegister.registerCallback(i7, uMLogDataProtocol)) {
            if (mNetTask == null || mTaskHandler == null) {
                init();
            }
            try {
                if (mTaskHandler != null) {
                    if (UMUtils.isMainProgress(context)) {
                        synchronized (mSenderInitLock) {
                            try {
                                if (mSender == null) {
                                    UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                                    mSender = new a(context, mTaskHandler);
                                }
                            } finally {
                            }
                        }
                    }
                    Message obtainMessage = mTaskHandler.obtainMessage();
                    obtainMessage.what = i6;
                    obtainMessage.arg1 = i7;
                    obtainMessage.obj = obj;
                    mTaskHandler.sendMessageDelayed(obtainMessage, j6);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    private static void teardown() {
        if (mNetTask != null) {
            mNetTask = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler = null;
        }
        if (mSender != null) {
            mSender = null;
        }
    }

    private UMWorkDispatch() {
    }

    public static synchronized boolean eventHasExist() {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return false;
            }
            return handler.hasMessages(MSG_CHECKER_TIMER);
        }
    }

    public static synchronized void removeEvent(int i6) {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(i6);
        }
    }
}
