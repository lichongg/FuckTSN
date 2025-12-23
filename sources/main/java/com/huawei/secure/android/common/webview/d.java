package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.e;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35314a = "UriUtil";

    public static boolean c(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            e.l(f35314a, "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (d(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            e.l(f35314a, "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (f(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            e.l(f35314a, "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (g(str, str2)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(9)
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            e.r(f35314a, "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            e.l(f35314a, "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e6) {
            e.l(f35314a, "getHostByURI error  MalformedURLException : " + e6.getMessage());
            return "";
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            e.r(f35314a, "whiteListUrl is null");
            return null;
        }
        if (!URLUtil.isNetworkUrl(str)) {
            return str;
        }
        return b(str);
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.contains("..") || str.contains("@")) {
            return false;
        }
        if (!str2.equals(str)) {
            if (!str.startsWith(str2 + "?")) {
                if (!str.startsWith(str2 + "#")) {
                    if (!str2.endsWith("/")) {
                        return false;
                    }
                    if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                        return false;
                    }
                    return str.startsWith(str2);
                }
            }
        }
        return true;
    }

    public static boolean f(String str, String str2) {
        String b6 = b(str);
        if (!TextUtils.isEmpty(b6) && !TextUtils.isEmpty(str2)) {
            String a6 = a(str2);
            if (TextUtils.isEmpty(a6)) {
                return false;
            }
            if (a6.equals(b6)) {
                return true;
            }
            if (b6.endsWith(a6)) {
                try {
                    String substring = b6.substring(0, b6.length() - a6.length());
                    if (!substring.endsWith(".")) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e6) {
                    e.l(f35314a, "IndexOutOfBoundsException" + e6.getMessage());
                } catch (Exception e7) {
                    e.l(f35314a, "Exception : " + e7.getMessage());
                    return false;
                }
            }
            return false;
        }
        e.l(f35314a, "url or whitelist is null");
        return false;
    }

    public static boolean g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(b(str), a(str2));
        }
        return false;
    }
}
