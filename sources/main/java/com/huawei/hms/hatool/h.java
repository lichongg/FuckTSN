package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class h {
    public static boolean b(Context context, String str) {
        int checkSelfPermission;
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            j1.m("hmsSdk", "not have read phone permission!");
            return true;
        }
        checkSelfPermission = context.checkSelfPermission(str);
        if (checkSelfPermission == 0) {
            return false;
        }
        j1.m("hmsSdk", "not have read phone permission!");
        return true;
    }

    public static boolean a(Context context) {
        return System.currentTimeMillis() - l.a(context, "Privacy_MY", "flashKeyTime", -1L) > 43200000;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean c(Context context, String str, int i6) {
        String str2 = l.h(context, str) + ".xml";
        File file = new File(context.getFilesDir(), "../shared_prefs/" + str2);
        if (!file.exists()) {
            String str3 = context.getPackageName() + "_" + str2;
            file = new File(context.getFilesDir(), "../../shared_prefs/" + str3);
        }
        long length = file.length();
        if (length <= i6) {
            return false;
        }
        j1.h("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i6)));
        return true;
    }

    public static boolean d(String str, long j6, long j7) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            if (j6 - Long.parseLong(str) > j7) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            j1.m("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
