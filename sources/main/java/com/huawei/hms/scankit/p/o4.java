package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class o4 {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f34660a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    private static Throwable a(Throwable th) {
        return th;
    }

    private static String a(String str, boolean z5) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z5) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        c(str2, str3);
    }

    public static void a(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, false);
        a(th);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i6 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i7 = 0; i7 < length; i7++) {
            char charAt = str.charAt(i7);
            if (f34660a.matcher(String.valueOf(charAt)).matches()) {
                if (i6 % 2 == 0) {
                    charAt = '*';
                }
                i6++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
