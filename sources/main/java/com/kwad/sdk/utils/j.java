package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.acse.ottn.l3;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    private static String aYL = Build.BRAND;
    private static String aYM = "OPPO";
    private static String aYN = "vivo";
    private static String aYO = "Xiaomi";
    private static String aYP = "Meizu";
    private static String aYQ = "HUAWEI";
    private static String aYR = "HONOR";

    private static Intent N(Context context, String str) {
        if ("V5".equals(str)) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
        if ("V6".equals(str) || "V7".equals(str)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        return intent2;
    }

    private static boolean PH() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return str.toLowerCase().contains("flyme");
    }

    private static boolean PI() {
        String str = Build.MANUFACTURER;
        return "QIKU".equals(str.toUpperCase()) || "360".equals(str.toUpperCase());
    }

    private static boolean PJ() {
        return aYL.equalsIgnoreCase(aYO);
    }

    public static boolean PK() {
        return aYL.equalsIgnoreCase(aYQ);
    }

    public static boolean PL() {
        return aYL.equalsIgnoreCase(aYR);
    }

    private static boolean PM() {
        return aYL.equalsIgnoreCase(aYM);
    }

    private static boolean PN() {
        return aYL.equalsIgnoreCase(aYN);
    }

    private static String PO() {
        return ap("ro.miui.ui.version.name", "");
    }

    private static String ap(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static void cA(Context context) {
        Intent cB;
        if (context == null || (cB = cB(context)) == null) {
            return;
        }
        try {
            context.startActivity(cB);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    private static Intent cB(Context context) {
        if (PJ()) {
            return N(context, PO());
        }
        if (!PK() && !PL()) {
            if (PH()) {
                Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, context.getPackageName());
                return intent;
            }
            if (!PM() && !PN()) {
                if (PI()) {
                    Intent intent2 = new Intent("android.intent.action.MAIN");
                    intent2.setFlags(268435456);
                    intent2.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, context.getPackageName());
                    intent2.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
                    return intent2;
                }
                Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.setData(Uri.parse("package:" + context.getPackageName()));
                return intent3;
            }
            Intent intent4 = new Intent();
            intent4.setFlags(268435456);
            intent4.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, context.getPackageName());
            intent4.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            return intent4;
        }
        Intent intent5 = new Intent();
        intent5.setFlags(268435456);
        intent5.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, context.getPackageName());
        intent5.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent5;
    }
}
