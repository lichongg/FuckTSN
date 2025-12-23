package com.ss.android.socialbase.downloader.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static int f38885j = 4;
    private static AbstractC0787j xt;

    /* renamed from: com.ss.android.socialbase.downloader.m.j$j, reason: collision with other inner class name */
    public static abstract class AbstractC0787j {
    }

    public static void cw(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f38885j <= 4) {
            vl.j(xt(str), str2);
        }
        if (xt != null) {
            xt(str);
        }
    }

    public static void j(int i6) {
        f38885j = i6;
    }

    public static String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static boolean j() {
        return f38885j <= 3;
    }

    public static void r(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f38885j <= 5) {
            vl.xt(xt(str), str2);
        }
        if (xt != null) {
            xt(str);
        }
    }

    public static void up(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f38885j <= 6) {
            vl.r(xt(str), str2);
        }
        if (xt != null) {
            xt(str);
        }
    }

    public static void j(String str, String str2) {
        if (str2 == null || xt == null) {
            return;
        }
        xt(str);
    }

    public static void xt(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f38885j <= 3) {
            xt(str);
        }
        if (xt != null) {
            xt(str);
        }
    }

    public static void cw(String str) {
        r("DownloaderLogger", str);
    }

    public static void j(String str) {
        xt("DownloaderLogger", str);
    }

    public static void j(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f38885j <= 3) {
            xt(str);
        }
        if (xt != null) {
            xt(str);
        }
    }

    public static void xt(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f38885j <= 6) {
            vl.cw(xt(str), str2, th);
        }
        if (xt != null) {
            xt(str);
        }
    }
}
