package com.bytedance.j.xt.tl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.j.xt.ae.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {
    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24230a;

        static {
            int[] iArr = new int[xt.EnumC0345xt.values().length];
            f24230a = iArr;
            try {
                iArr[xt.EnumC0345xt.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24230a[xt.EnumC0345xt.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24230a[xt.EnumC0345xt.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24230a[xt.EnumC0345xt.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24230a[xt.EnumC0345xt.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static xt.EnumC0345xt a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return xt.EnumC0345xt.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return xt.EnumC0345xt.WIFI;
                }
                if (type != 0) {
                    return xt.EnumC0345xt.MOBILE;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return xt.EnumC0345xt.MOBILE_3G;
                    case 4:
                    case 7:
                    case 11:
                    default:
                        return xt.EnumC0345xt.MOBILE;
                    case 13:
                        return xt.EnumC0345xt.MOBILE_4G;
                }
            }
            return xt.EnumC0345xt.NONE;
        } catch (Throwable unused) {
            return xt.EnumC0345xt.MOBILE;
        }
    }

    public static String c(xt.EnumC0345xt enumC0345xt) {
        try {
            int i6 = a.f24230a[enumC0345xt.ordinal()];
            return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 != 5 ? "" : "mobile" : "4g" : "3g" : "2g" : "wifi";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context) {
        return c(a(context));
    }
}
