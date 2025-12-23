package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35241a = "f";

    public static String a(String str) {
        Context a6 = c.a();
        if (a6 == null) {
            return "";
        }
        try {
            return a6.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e6) {
            h.d(f35241a, "getVersion NameNotFoundException : " + e6.getMessage());
            return "";
        } catch (Exception e7) {
            h.d(f35241a, "getVersion: " + e7.getMessage());
            return "";
        } catch (Throwable unused) {
            h.d(f35241a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context a6 = c.a();
        if (a6 == null) {
            return 0;
        }
        try {
            return a6.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            h.d(f35241a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e6) {
            h.d(f35241a, "getVersion: " + e6.getMessage());
            return 0;
        }
    }
}
