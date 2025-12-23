package cn.jpush.android.helper;

import androidx.work.WorkRequest;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Long, String> f3686a;

    private static long a(byte b6) {
        switch (b6) {
            case 1:
                return 11000000L;
            case 2:
                return 12000000L;
            case 3:
                return 13000000L;
            case 4:
                return 14000000L;
            case 5:
                return 15000000L;
            case 6:
                return 16000000L;
            case 7:
                return 17000000L;
            case 8:
                return WorkRequest.MAX_BACKOFF_MILLIS;
            default:
                return 10000000L;
        }
    }

    static {
        HashMap<Long, String> hashMap = new HashMap<>();
        f3686a = hashMap;
        hashMap.put(1060L, "need not show notification by foreground");
        hashMap.put(1061L, "need not show notification by isNeedShowNotification return false");
        hashMap.put(1032L, "MSG already cancle");
        hashMap.put(1033L, "overide msg already cancle");
        hashMap.put(1034L, "MSG already end");
        hashMap.put(1035L, "msg delay show");
        hashMap.put(1036L, "notification disabled");
        hashMap.put(1037L, "notification channel disabled");
        hashMap.put(972L, "Deep link set small icon failed");
        hashMap.put(973L, "Deep link set large icon failed");
        hashMap.put(976L, "Deep link jump success");
        hashMap.put(977L, "Deep link jump failed");
        hashMap.put(978L, "Fail Deep link jump success");
        hashMap.put(979L, "Fail Deep link jump failed");
        hashMap.put(993L, "target app uninstall,not found target app small icon");
        hashMap.put(986L, "Message is not in push time");
        hashMap.put(988L, "Deep link target app uninstalled");
        hashMap.put(995L, "Message JSON parsing succeed");
        hashMap.put(996L, "Message JSON parsing failed");
        hashMap.put(1000L, "User clicked and opened the Message");
        hashMap.put(1028L, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        hashMap.put(1068L, "User clear the JPush Notification from JPushReportHelper.reportMsgResult");
        hashMap.put(1069L, "User clear the OS Push Notification from JPushReportHelper.reportThirdSDKMsgActionResult");
        hashMap.put(1006L, "User clicked 'Cancel'");
        hashMap.put(1100L, "Invalid param or unexpected result.");
        hashMap.put(1014L, "Failed to preload required resource");
        hashMap.put(1016L, "User clicked the webview's url");
        hashMap.put(1018L, "The Message show in the status bar");
        hashMap.put(1020L, "Down image failed");
        hashMap.put(1021L, "Down html failed");
        hashMap.put(1075L, "Open WX miniprogram failed");
        hashMap.put(1080L, "show notification make unknown error");
        hashMap.put(1106L, "the custom message show");
    }

    public static long a(byte b6, int i6, long j6) {
        return a(b6) + a(i6) + j6;
    }

    private static long a(int i6) {
        if (i6 == 1) {
            return 100000L;
        }
        if (i6 == 2) {
            return 110000L;
        }
        if (i6 != 3) {
            return i6 != 4 ? -1L : 130000L;
        }
        return 120000L;
    }

    public static long a(int i6, long j6) {
        return a((byte) 0, i6, j6);
    }

    public static String a(long j6) {
        HashMap<Long, String> hashMap = f3686a;
        if (hashMap.get(Long.valueOf(j6)) != null) {
            return hashMap.get(Long.valueOf(j6));
        }
        Logger.d("StatusCode", "Unknown report code - " + j6);
        return "";
    }
}
