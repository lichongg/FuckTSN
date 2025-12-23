package com.umeng.commonsdk.statistics;

import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AnalyticsConstants {
    public static final String CFG_FIELD_KEY = "cfgfd";
    public static boolean CHECK_DEVICE = true;
    public static final String LOG_TAG = "MobclickAgent";
    public static final String OS = "Android";
    public static final String SDK_TYPE = "Android";
    public static boolean SUB_PROCESS_EVENT = false;
    public static final String ZERO_RESPONSE_FLAG = "iscfg";
    public static String[] APPLOG_URL_LIST = {UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    public static final boolean UM_DEBUG = ULog.DEBUG;
    private static int commonDeviceType = 1;

    public static synchronized int getDeviceType() {
        int i6;
        synchronized (AnalyticsConstants.class) {
            i6 = commonDeviceType;
        }
        return i6;
    }

    public static void setDeviceType(int i6) {
        commonDeviceType = i6;
    }
}
