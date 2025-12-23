package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;
import android.widget.Toast;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32278a = "HuaweiUtils";

    public static void a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (g.e() == 3.1d) {
                h.a(context).startActivityForResult(intent, 1);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                h.a(context).startActivityForResult(intent, 1);
            }
        } catch (ActivityNotFoundException e6) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            h.a(context).startActivityForResult(intent2, 1);
            e6.printStackTrace();
            Log.getStackTraceString(e6);
        } catch (SecurityException e7) {
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            h.a(context).startActivityForResult(intent3, 1);
            Log.getStackTraceString(e7);
        } catch (Exception e8) {
            Toast.makeText(context, "进入设置页面失败，请手动设置", 1).show();
            Log.getStackTraceString(e8);
        }
    }

    public static boolean b(Context context) {
        return c(context, 24);
    }

    @TargetApi(19)
    private static boolean c(Context context, int i6) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i6), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            return false;
        }
    }
}
