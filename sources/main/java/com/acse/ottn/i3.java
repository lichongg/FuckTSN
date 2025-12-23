package com.acse.ottn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i3 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4638a = "QikuUtils";

    public static boolean a(Context context) {
        return a(context, 24);
    }

    @TargetApi(19)
    public static boolean a(Context context, int i6) {
        if ("".equals(k0.f4687w)) {
            return false;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i6), Integer.valueOf(Binder.getCallingUid()), k0.f4687w)).intValue() == 0;
        } catch (Exception e6) {
            c2.b(f4638a, Log.getStackTraceString(e6));
            return false;
        }
    }

    public static void a(Activity activity, int i6) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i6);
            return;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i6);
        } else {
            c2.b(f4638a, "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
        }
    }

    public static boolean a(Intent intent, Context context) {
        return (intent == null || context == null || context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }
}
