package com.kwad.sdk.commercial.model;

import android.os.Looper;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class SDKInitMsg extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final int CHILD_PROCESS = 2;
    private static final int DYNAMIC_DISABLE = 2;
    private static final int DYNAMIC_ENABLE = 1;
    public static final int FAIL = 2;
    public static final int FINISH = 1;
    private static final int MAIN_PROCESS = 1;
    private static final int MAIN_THREAD = 1;
    public static final int NEW_FINISH = 3;
    public static final int NEW_FINISH_MODULE = 6;
    public static final int START = 0;
    public static final int START_BEGIN = 4;
    public static final int START_FINISH = 5;
    private static final int WORK_THREAD = 2;
    private static final long serialVersionUID = 368743526206619387L;
    public String errorReason;
    public int initCount;
    public int initProcess;
    public int initStatus;
    public int initThread;
    public int intBuildNumber;
    public int intDynamicSDK;
    public long launchIntervalTime;
    public long totalDurationTime;

    public SDKInitMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public SDKInitMsg setInitCount(int i6) {
        this.initCount = i6;
        return this;
    }

    public SDKInitMsg setInitStatus(int i6) {
        this.initStatus = i6;
        return this;
    }

    public SDKInitMsg setLaunchIntervalTime(long j6) {
        this.launchIntervalTime = j6;
        return this;
    }

    public SDKInitMsg setTotalDurationTime(long j6) {
        this.totalDurationTime = j6;
        return this;
    }

    public SDKInitMsg() {
        int i6;
        int i7;
        if (ay.isInMainProcess(ServiceProvider.Pp())) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        this.initProcess = i6;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            i7 = 1;
        } else {
            i7 = 2;
        }
        this.initThread = i7;
        this.intDynamicSDK = com.kwad.framework.a.a.akY.booleanValue() ? 1 : 2;
        this.intBuildNumber = 214;
    }
}
