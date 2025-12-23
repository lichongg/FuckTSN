package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j2 {

    /* renamed from: b, reason: collision with root package name */
    static byte[] f8182b;

    /* renamed from: c, reason: collision with root package name */
    static byte[] f8183c;

    /* renamed from: a, reason: collision with root package name */
    private String f8184a;

    public static int a(Context context, String str, String str2, int i6) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i6);
        } catch (Throwable th) {
            g2.o(th, "csp", "giv");
            return i6;
        }
    }

    public static long b(Context context, String str, String str2, long j6) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j6);
        } catch (Throwable th) {
            g2.o(th, "csp", "glv");
            return j6;
        }
    }

    public static SharedPreferences.Editor c(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                d2.e(th, "sp", "ge");
            }
        }
        return null;
    }

    public static boolean l(Context context, String str, String str2, boolean z5) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z5);
        } catch (Throwable th) {
            g2.o(th, "csp", "gbv");
            return z5;
        }
    }

    public static String d(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return j1.g(q(context, j1.x(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, j1.D(n(context, j1.o(str3))));
            f(edit);
        } catch (Throwable unused) {
        }
    }

    public static void f(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            d2.e(th, "sp", SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_COUNT);
        }
    }

    public static void g(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                d2.e(th, "sp", "rk");
            }
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, long j6) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j6);
        } catch (Throwable th) {
            g2.o(th, "csp", "plv");
        }
    }

    public static void j(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                d2.e(th, "sp", "ps");
            }
        }
    }

    private static byte[] m(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f8182b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = x0.i(context).getBytes();
        f8182b = bytes;
        return bytes;
    }

    public static String o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            g2.o(th, "csp", "gsv");
            return str3;
        }
    }

    private static byte[] p(Context context) {
        byte[] bArr = f8183c;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] copyOfRange = Arrays.copyOfRange(m(context), 0, m(context).length / 2);
        f8183c = copyOfRange;
        return copyOfRange;
    }

    public j2(String str) {
        this.f8184a = g1.a(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static void h(SharedPreferences.Editor editor, String str, int i6) {
        try {
            editor.putInt(str, i6);
        } catch (Throwable th) {
            g2.o(th, "csp", "putPrefsInt");
        }
    }

    public static void k(SharedPreferences.Editor editor, String str, boolean z5) {
        try {
            editor.putBoolean(str, z5);
        } catch (Throwable th) {
            g2.o(th, "csp", "setPrefsStr");
        }
    }

    public static byte[] n(Context context, byte[] bArr) {
        try {
            return d1.h(m(context), bArr, p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] q(Context context, byte[] bArr) {
        try {
            return d1.e(m(context), bArr, p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
