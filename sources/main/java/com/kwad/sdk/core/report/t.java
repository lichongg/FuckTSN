package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t {
    private static String aHS = IF();
    private static long aHT = 0;
    private static Context aHU;

    @WorkerThread
    private static boolean b(Context context, long j6) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong(RtspHeaders.Values.SEQ, j6);
        return edit.commit();
    }

    public static String IB() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String IF = IF();
        aHS = IF;
        return IF;
    }

    public static String IC() {
        return aHS;
    }

    @WorkerThread
    public static long ID() {
        long bE = bE(aHU);
        b(aHU, 1 + bE);
        return bE;
    }

    public static long IE() {
        return aHT;
    }

    @WorkerThread
    private static long bE(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(RtspHeaders.Values.SEQ, 1L);
    }

    public static void init(Context context) {
        aHU = context;
    }

    private static String IF() {
        return UUID.randomUUID().toString();
    }
}
