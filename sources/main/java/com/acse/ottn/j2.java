package com.acse.ottn;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4661a = "MeizuUtils";

    public static boolean a(Context context) {
        return a(context, 24);
    }

    public static void a(AppCompatActivity appCompatActivity, int i6) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, k0.f4687w);
            intent.setFlags(268435456);
            appCompatActivity.startActivityForResult(intent, i6);
        } catch (Exception e6) {
            try {
                c2.b(f4661a, "获取悬浮窗权限, 打开AppSecActivity失败, " + Log.getStackTraceString(e6));
                d1.e(appCompatActivity, i6);
            } catch (Exception e7) {
                c2.b(f4661a, "获取悬浮窗权限失败, 通用获取方法失败, " + Log.getStackTraceString(e7));
            }
        }
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
            c2.b(f4661a, Log.getStackTraceString(e6));
            return false;
        }
    }
}
