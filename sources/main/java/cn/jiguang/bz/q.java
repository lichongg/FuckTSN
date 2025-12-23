package cn.jiguang.bz;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class q {
    public static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean a(Context context, String str) {
        String permissionToOp;
        int noteProxyOpNoThrow;
        int checkSelfPermission;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            if (context.getApplicationInfo().targetSdkVersion >= 23) {
                checkSelfPermission = context.checkSelfPermission(str);
                return checkSelfPermission == 0;
            }
            permissionToOp = AppOpsManager.permissionToOp(str);
            if (permissionToOp == null) {
                return true;
            }
            noteProxyOpNoThrow = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(permissionToOp, context.getPackageName());
            return noteProxyOpNoThrow == 0;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("PermissionUtils", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            PackageInfo a6 = p.a(context, 4096);
            if (a6 != null) {
                for (String str2 : a6.requestedPermissions) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("PermissionUtils", "hasPermissionDefined error:" + th.getMessage());
        }
        return false;
    }
}
