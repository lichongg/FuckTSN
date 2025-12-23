package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33356a = "Utils";

    public static long getCurrentTime(boolean z5) {
        return z5 ? SystemClock.elapsedRealtime() : System.currentTimeMillis();
    }

    public static boolean is64Bit(Context context) {
        boolean is64Bit;
        if (context == null) {
            Logger.e(f33356a, "Null context, please check it.");
            return false;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext()) == null ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            return origApplicationContext.getPackageManager().getApplicationInfo(origApplicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.e(f33356a, "Get application info failed: name not found, try to get baseContext.");
            if (!(context instanceof ContextWrapper)) {
                return false;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == null) {
                Logger.w(f33356a, "Get baseContext failed: null. Return default: is64-bit.");
                return true;
            }
            try {
                return baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
            } catch (PackageManager.NameNotFoundException unused2) {
                Logger.e(f33356a, "Get baseContext application info failed: name not found");
                return true;
            }
        }
    }
}
