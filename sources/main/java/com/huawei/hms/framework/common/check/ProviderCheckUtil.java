package com.huawei.hms.framework.common.check;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ProviderCheckUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33357a = "ProviderCheckUtil";

    public static boolean isValid(Uri uri) {
        ApplicationInfo applicationInfo;
        if (uri == null) {
            return false;
        }
        PackageManager packageManager = ContextHolder.getAppContext().getPackageManager();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (resolveContentProvider == null || (applicationInfo = resolveContentProvider.applicationInfo) == null) {
            Logger.w(f33357a, "Invalid param");
            return false;
        }
        String str = applicationInfo.packageName;
        Logger.v(f33357a, "Target provider service's package name is : " + str);
        if (str != null) {
            return a(packageManager, str);
        }
        Logger.w(f33357a, "Invalid packageName");
        return false;
    }

    private static boolean a(PackageManager packageManager, String str) {
        if (packageManager.checkSignatures("com.huawei.hwid", str) == 0) {
            Logger.v(f33357a, "Valid Provider");
            return true;
        }
        if (packageManager.checkSignatures("com.huawei.hwid.tv", str) != 0) {
            return false;
        }
        Logger.v(f33357a, "Valid Provider in tv");
        return true;
    }
}
