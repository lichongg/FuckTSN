package cn.jiguang.api;

import android.content.Context;
import android.os.Bundle;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JDispatchAction {
    public static final int SDK_CUSTOM_GOOGLE_TYPE = 4;
    public static final int SDK_CUSTOM_PURE_TYPE = 5;
    public static final int SDK_CUSTOM_TYPE = 1;
    public static final int SDK_NORMAL_GOOGLE_TYPE = 2;
    public static final int SDK_NORMAL_PURE_TYPE = 3;
    public static final int SDK_NORMAL_TYPE = 0;

    public Object beforLogin(Context context, String str, int i6, String str2) {
        return null;
    }

    public Object beforRegister(Context context, String str, int i6, String str2) {
        return null;
    }

    public boolean checkAction(String str, int i6) {
        return true;
    }

    public abstract void dispatchMessage(Context context, String str, int i6, int i7, long j6, long j7, ByteBuffer byteBuffer);

    public Object getDataByAction(Context context, String str, String str2, Bundle bundle, Object obj) {
        return null;
    }

    public Object getDataByCmd(Context context, int i6) {
        return null;
    }

    public abstract short getLogPriority(String str);

    public abstract short getLoginFlag(String str);

    public Bundle getPInfo(String str) {
        return null;
    }

    public abstract short getRegFlag(String str);

    public abstract short getRegPriority(String str);

    public abstract String getReportVersionKey(String str);

    public int getSdkType() {
        return 0;
    }

    public abstract String getSdkVersion(String str);

    public abstract short getUserCtrlProperty(String str);

    public abstract boolean isSupportedCMD(String str, int i6);

    public Object onSendData(Context context, String str, long j6, int i6, int i7) {
        return null;
    }

    public void handleMessage(Context context, String str, Object obj) {
    }

    public void dispatchTimeOutMessage(Context context, String str, long j6, int i6) {
    }

    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
    }

    public void onEvent(Context context, String str, int i6, int i7, String str2) {
    }
}
