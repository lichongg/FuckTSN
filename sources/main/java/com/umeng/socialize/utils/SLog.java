package com.umeng.socialize.utils;

import android.os.Bundle;
import com.snail.antifake.deviceid.e;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SLog {
    private static boolean DEBUG = true;
    private static final int E = 0;
    private static final int I = 2;
    private static final String PRIVATE = "priviteSocial";
    private static final String TAG = "Social";

    public static void error(Throwable th) {
        if (UMConfigure.umDebugLog != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i6 = 2;
            String[] strArr = new String[stackTrace.length + 2];
            strArr[0] = "错误信息如下:";
            strArr[1] = "错误类型:" + th.getMessage();
            for (StackTraceElement stackTraceElement : stackTrace) {
                strArr[i6] = "        at\t " + stackTraceElement.toString();
                i6++;
            }
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(TAG, 0, strArr);
        }
    }

    public static void AQ(String str, String str2) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.aq(TAG, 0, str, str2);
    }

    public static void BUNDLE(Bundle bundle) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.bundle(TAG, 2, bundle);
        }
    }

    public static void E(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split(e.f37542d);
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(TAG, 0, split);
        }
    }

    public static void I(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split(e.f37542d);
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(TAG, 2, split);
        }
    }

    public static void JARRY(JSONArray jSONArray) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.jsonArry(TAG, jSONArray);
        }
    }

    public static void JSON(JSONObject jSONObject) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.jsonObject(TAG, jSONObject);
        }
    }

    public static void TE(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split(e.f37542d);
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social_" + str, 0, split);
        }
    }

    public static void TI(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split(e.f37542d);
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social_" + str, 2, split);
        }
    }

    public static void debug(String str) {
        if (UMConfigure.umDebugLog == null || !DEBUG) {
            return;
        }
        UMLog.mutlInfo(PRIVATE, 2, "[private log]  " + str);
    }

    public static boolean isDebug() {
        if (UMConfigure.umDebugLog != null) {
            return UMConfigure.isDebugLog();
        }
        return false;
    }

    public static void mutlE(String... strArr) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo(TAG, 0, strArr);
    }

    public static void mutlI(String... strArr) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.mutlInfo(TAG, 2, strArr);
        }
    }

    public static void runtimePrint(String str) {
        UMRTLog.e(PRIVATE, str);
    }

    public static void welcome() {
        UMConfigure.isDebugLog();
    }

    public static void error(String str, Throwable th) {
        if (UMConfigure.umDebugLog == null || th == null) {
            return;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i6 = 2;
        String[] strArr = new String[stackTrace.length + 2];
        strArr[0] = str;
        strArr[1] = "错误类型:" + th.getMessage();
        for (StackTraceElement stackTraceElement : stackTrace) {
            strArr[i6] = "        at\t " + stackTraceElement.toString();
            i6++;
        }
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo(TAG, 0, strArr);
    }

    public static void selfLog(String str) {
    }
}
