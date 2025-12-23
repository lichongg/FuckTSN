package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.kuaishou.weapon.p0.g;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    public static boolean a(Context context) {
        try {
            if (b(context) && a(context, Class.forName(CustomPkgConstants.getADActivityName())) && a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) && a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                if (b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.e("检查AndroidManifest.xml时发生异常", th);
            return false;
        }
    }

    private static boolean b(Context context) {
        String[] strArr = {g.f36041a, g.f36042b};
        for (int i6 = 0; i6 < 2; i6++) {
            try {
                String str = strArr[i6];
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查权限时发生异常", th);
                return false;
            }
        }
        return true;
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i6 = 0; i6 < clsArr.length; i6++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i6]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i6].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context, Class<?>... clsArr) {
        try {
            for (Class<?> cls : clsArr) {
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s]需要在AndroidManifest.xml中声明", cls.getName()));
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            GDTLogger.e("检查Service时发生异常", th);
            return false;
        }
    }
}
