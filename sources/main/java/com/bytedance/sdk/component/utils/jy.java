package com.bytedance.sdk.component.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy {
    public static long j(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long j() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
