package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32280a = "MiuiUtils";

    private static boolean i(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
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

    public static int d() {
        String g6 = g.g("ro.miui.ui.version.name");
        if (g6 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(g6.substring(1));
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            return -1;
        }
    }

    public static void f(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        }
    }

    public static void g(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        }
    }

    public static void h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent, context)) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent2, context)) {
            h.a(context).startActivityForResult(intent2, 1);
        }
    }

    public static void a(Context context) {
        int d6 = d();
        if (d6 == 5) {
            e(context);
            return;
        }
        if (d6 == 6) {
            f(context);
        } else if (d6 == 7) {
            g(context);
        } else if (d6 == 8) {
            h(context);
        }
    }

    public static void e(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, packageName, null));
        if (i(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        }
    }
}
