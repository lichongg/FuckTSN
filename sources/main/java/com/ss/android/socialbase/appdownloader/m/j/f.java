package com.ss.android.socialbase.appdownloader.m.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ss.android.socialbase.downloader.az.j;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:107:0x0142
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    public static android.content.pm.PackageInfo b(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.m.j.f.b(java.io.File):android.content.pm.PackageInfo");
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i6) {
        if (j.j(268435456) && Build.VERSION.SDK_INT < 26) {
            try {
                return b(file);
            } catch (Throwable th) {
                f("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return g(context, file, i6);
    }

    private static String c(int i6) {
        return (i6 >>> 24) == 1 ? "android:" : "";
    }

    public static String d(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e6) {
            f("getPackageInfo::fail_load_label", e6.getMessage());
            return null;
        }
    }

    private static String e(c cVar, int i6) {
        int k6 = cVar.k(i6);
        int b6 = cVar.b(i6);
        if (k6 == 3) {
            return cVar.f(i6);
        }
        if (k6 == 2) {
            return String.format("?%s%08X", c(b6), Integer.valueOf(b6));
        }
        if (k6 >= 16 && k6 <= 31) {
            return String.valueOf(b6);
        }
        return String.format("<0x%X, type 0x%02X>", Integer.valueOf(b6), Integer.valueOf(k6));
    }

    private static void f(@NonNull String str, @NonNull String str2) {
        if (com.ss.android.socialbase.downloader.downloader.cw.m() != null) {
            try {
                new JSONObject().put(CrashHianalyticsData.MESSAGE, str2);
            } catch (JSONException unused) {
            }
        }
    }

    private static PackageInfo g(@NonNull Context context, @NonNull File file, int i6) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            f("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i6);
        } catch (Throwable th) {
            f("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }
}
