package com.huawei.secure.android.common.util;

import android.webkit.URLUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    static final String f35288a = "file:///android_res/";

    public static boolean j(String str) {
        return str != null && str.startsWith(f35288a);
    }

    public static boolean a(String str) {
        return URLUtil.isAboutUrl(str);
    }

    public static boolean b(String str) {
        return URLUtil.isAssetUrl(str);
    }

    public static boolean c(String str) {
        return URLUtil.isContentUrl(str);
    }

    public static boolean d(String str) {
        return URLUtil.isDataUrl(str);
    }

    public static boolean e(String str) {
        return URLUtil.isFileUrl(str);
    }

    public static boolean f(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public static boolean g(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    public static boolean h(String str) {
        return URLUtil.isJavaScriptUrl(str);
    }

    public static boolean i(String str) {
        return URLUtil.isNetworkUrl(str);
    }

    public static boolean k(String str) {
        return URLUtil.isValidUrl(str);
    }
}
