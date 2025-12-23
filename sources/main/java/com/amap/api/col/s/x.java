package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    static g3 f8606a;

    private static String a(AMapException aMapException) {
        if (aMapException == null) {
            return null;
        }
        if (aMapException.getErrorLevel() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(aMapException.getErrorCode());
            return sb.toString();
        }
        int errorCode = aMapException.getErrorCode();
        if (errorCode == 0) {
            return "4";
        }
        int pow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
        return String.valueOf((errorCode % pow) + (pow * 4));
    }

    private static String b(String str, long j6, boolean z5) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j6 + ",\"Success\":" + z5 + "}";
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    private static String c(String str, boolean z5) {
        String str2;
        try {
            str2 = "";
            int indexOf = str.indexOf("?");
            int length = str.length();
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i6 = indexOf + 1;
                str2 = i6 < length ? str.substring(i6) : "";
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z5 + "}";
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void f(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String a6 = a(aMapException);
            if (a6 == null || a6.length() <= 0) {
                return;
            }
            g2.i(i4.a(true), str, errorType, str2, a6);
        }
    }

    public static void d(Context context, String str, long j6, boolean z5) {
        try {
            String b6 = b(str, j6, z5);
            if (b6 != null && b6.length() > 0) {
                if (f8606a == null) {
                    f8606a = new g3(context, "sea", "9.7.0", "O002");
                }
                f8606a.a(b6);
                h3.d(f8606a, context);
            }
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void e(Context context, String str, boolean z5) {
        try {
            String c6 = c(str, z5);
            if (c6 != null && c6.length() > 0) {
                g3 g3Var = new g3(context, "sea", "9.7.0", "O006");
                g3Var.a(c6);
                h3.d(g3Var, context);
            }
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "recordResponseAction");
        }
    }
}
