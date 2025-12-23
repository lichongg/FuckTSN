package com.umeng.socialize.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CommonUtil {
    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSilentMode(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            r3 = 0
            java.lang.String r1 = "com.umeng.commonsdk.UMConfigure"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> Lc
            goto L11
        Lc:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r3
        L11:
            if (r1 == 0) goto L40
            java.lang.String r2 = "isSilentMode"
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch: java.lang.NoSuchMethodException -> L20
            r2 = 1
            r1.setAccessible(r2)     // Catch: java.lang.NoSuchMethodException -> L1e
            goto L25
        L1e:
            r2 = move-exception
            goto L22
        L20:
            r2 = move-exception
            r1 = r3
        L22:
            r2.printStackTrace()
        L25:
            if (r1 == 0) goto L40
            java.lang.Object r3 = r1.invoke(r3, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L34 java.lang.IllegalAccessException -> L36
            if (r3 == 0) goto L40
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.reflect.InvocationTargetException -> L34 java.lang.IllegalAccessException -> L36
            boolean r0 = r3.booleanValue()     // Catch: java.lang.reflect.InvocationTargetException -> L34 java.lang.IllegalAccessException -> L36
            goto L40
        L34:
            r3 = move-exception
            goto L38
        L36:
            r3 = move-exception
            goto L3c
        L38:
            r3.printStackTrace()
            goto L40
        L3c:
            r3.printStackTrace()
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.CommonUtil.isSilentMode(android.content.Context):boolean");
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT + str + ":"));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        if (queryIntentActivities.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String checkKeyHash(Context context) {
        return "";
    }

    public static String checkMD5Sign(Context context) {
        return "";
    }

    public static String checkSHA1(Context context) {
        return "";
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkResource(Context context, String str, String str2) {
        if (context.getResources().getIdentifier(str, str2, context.getPackageName()) <= 0) {
            return false;
        }
        return true;
    }
}
