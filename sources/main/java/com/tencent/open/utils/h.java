package com.tencent.open.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f40655a;

    public static String a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return b(context, str, "com.tencent.mobileqq");
            }
            if (Constants.PACKAGE_TIM.equals(str2)) {
                return b(context, str, Constants.PACKAGE_TIM);
            }
        }
        return null;
    }

    private static String b(Context context, String str, String str2) {
        if (!f40655a) {
            return null;
        }
        try {
            Cursor c6 = c(context, str, str2);
            if (c6 == null) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                return null;
            }
            if (c6.getCount() <= 0) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                return null;
            }
            c6.moveToFirst();
            String string = c6.getString(0);
            c6.close();
            SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
            return a(string) ? string : "UNKNOWN";
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e6);
            return null;
        }
    }

    private static Cursor c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().query(Uri.parse("content://" + str2 + ".openapi.provider/query_app_version?appid" + ContainerUtils.KEY_VALUE_DELIMITER + str + ContainerUtils.FIELD_DELIMITER + "pkgName" + ContainerUtils.KEY_VALUE_DELIMITER + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e6);
            return null;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return false;
        }
        for (String str2 : split) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }
}
