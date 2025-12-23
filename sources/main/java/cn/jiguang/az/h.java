package cn.jiguang.az;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f1865a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f1866b;

    public static String a(Context context) {
        Bundle bundle;
        if (TextUtils.isEmpty(f1865a)) {
            f1865a = f.c();
        }
        if (TextUtils.isEmpty(f1865a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a6 = a(bundle, "JPUSH_APPKEY");
                        f1865a = a6;
                        if (!TextUtils.isEmpty(a6)) {
                            f1865a = f1865a.toLowerCase(Locale.getDefault());
                        }
                    }
                } else {
                    cn.jiguang.ay.b.b("MetaInfoFetcher", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f1865a;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static String b(Context context) {
        StringBuilder sb;
        Bundle bundle;
        if (f1866b == null && context != null) {
            try {
                String d6 = f.d(context);
                f1866b = d6;
                if (d6 != null) {
                    sb = new StringBuilder();
                    sb.append("get option channel - ");
                    sb.append(f1866b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a6 = a(bundle, "JPUSH_CHANNEL");
                        f1866b = a6;
                        if (!TextUtils.isEmpty(a6)) {
                            f1866b = j.b(f1866b);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("manifest:channel - ");
                    sb.append(f1866b);
                }
                cn.jiguang.ay.b.c("MetaInfoFetcher", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f1866b;
    }
}
