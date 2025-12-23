package com.tencent.mm.opensdk.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Log {
    private static ILog logImpl;

    public static void d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.d(str, str2);
    }

    public static void e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.e(str, str2);
    }

    public static void i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.i(str, str2);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    public static void v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.v(str, str2);
    }

    public static void w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.w(str, str2);
    }
}
