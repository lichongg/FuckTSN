package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static Context aHU;

    @WorkerThread
    private static boolean b(Context context, long j6) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        edit.putLong("crashseq", j6);
        return edit.commit();
    }

    @WorkerThread
    public static long ID() {
        long bE = bE(aHU);
        b(aHU, 1 + bE);
        return bE;
    }

    @WorkerThread
    private static long bE(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    public static void init(Context context) {
        aHU = context;
    }
}
