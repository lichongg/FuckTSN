package com.bykv.vk.component.ttvideo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: D:\Downloads\app\classes3.dex */
public class MemoryInfo {
    private static long[] mRomMemroy;
    private static long mTotalMemorySize;

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static long[] getRomMemroy() {
        if (mRomMemroy == null) {
            long totalInternalMemorySize = getTotalInternalMemorySize();
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mRomMemroy = new long[]{totalInternalMemorySize, statFs.getBlockSize() * statFs.getAvailableBlocks()};
        }
        return mRomMemroy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        if (r2 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getTolalMemory() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r0 = 8
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            if (r0 == 0) goto L16
            r1 = r0
        L16:
            r2.close()     // Catch: java.lang.Exception -> L1a
            goto L2e
        L1a:
            r0 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r0)
            goto L2e
        L1f:
            r0 = move-exception
            r1 = r2
            goto L4a
        L22:
            r0 = move-exception
            goto L28
        L24:
            r0 = move-exception
            goto L4a
        L26:
            r0 = move-exception
            r2 = r1
        L28:
            com.bytedance.sdk.component.utils.vl.j(r0)     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L2e
            goto L16
        L2e:
            r0 = 58
            int r0 = r1.indexOf(r0)
            r2 = 107(0x6b, float:1.5E-43)
            int r2 = r1.indexOf(r2)
            int r0 = r0 + 1
            java.lang.String r0 = r1.substring(r0, r2)
            java.lang.String r0 = r0.trim()
            int r0 = java.lang.Integer.parseInt(r0)
            long r0 = (long) r0
            return r0
        L4a:
            if (r1 == 0) goto L54
            r1.close()     // Catch: java.lang.Exception -> L50
            goto L54
        L50:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)
        L54:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.MemoryInfo.getTolalMemory():long");
    }

    public static long getTotalInternalMemorySize() {
        if (mTotalMemorySize == 0) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mTotalMemorySize = statFs.getBlockCount() * statFs.getBlockSize();
        }
        return mTotalMemorySize;
    }
}
