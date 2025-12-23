package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32281a = "QikuUtils";

    private static boolean d(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        if (d(intent, context)) {
            context.startActivity(intent);
            return;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        if (d(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
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
