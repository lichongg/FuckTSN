package com.huawei.secure.android.common.util;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.content.PermissionChecker;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35274a = "PermissionUtil";

    public static boolean a(Context context, String str, String str2) throws NoPermissionCheckerException {
        if (Binder.getCallingPid() == Process.myPid()) {
            return false;
        }
        return b(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static boolean b(Context context, String str, int i6, int i7, String str2) throws NoPermissionCheckerException {
        try {
            if (context.getApplicationInfo().targetSdkVersion > 23) {
                if (context.checkPermission(str, i6, i7) != 0) {
                    return false;
                }
                return true;
            }
            if (PermissionChecker.checkPermission(context, str, i6, i7, str2) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.getMessage();
            throw new NoPermissionCheckerException("you should implementation support library or androidx library");
        }
    }

    public static boolean c(Context context, String str) throws NoPermissionCheckerException {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
