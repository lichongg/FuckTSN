package xyz.adscope.common.v2.dev.info;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class PermissionUtil {
    public static final int PERMISSION_REQ_CODE = 100;

    public static boolean checkAlertWindowPermission(Context context) {
        boolean canDrawOverlays;
        boolean canDrawOverlays2;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 23) {
            return true;
        }
        if (i6 >= 27) {
            canDrawOverlays2 = Settings.canDrawOverlays(context);
            return canDrawOverlays2;
        }
        canDrawOverlays = Settings.canDrawOverlays(context);
        if (canDrawOverlays) {
            return true;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, i6 >= 26 ? 2038 : 2003, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        return Build.VERSION.SDK_INT >= 23 ? ContextCompat.checkSelfPermission(context, str) == 0 : isPermissionDeclare(context, str);
    }

    private PermissionUtil() {
    }

    private static boolean isPermissionDeclare(Context context, String str) {
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }
}
