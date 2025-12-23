package com.tencent.bugly.crashreport;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BuglyLog {
    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z5 = p.f40122c;
        ao.a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z5 = p.f40122c;
        ao.a("D", str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z5 = p.f40122c;
        ao.a("I", str, str2);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z5 = p.f40122c;
        ao.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z5 = p.f40122c;
        ao.a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public static void setCache(int i6) {
        ao.a(i6);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        boolean z5 = p.f40122c;
        ao.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
