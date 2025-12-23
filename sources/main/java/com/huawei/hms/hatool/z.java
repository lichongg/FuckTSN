package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class z {
    public static String b(Context context, String str, String str2) {
        if (str2.equals("oper")) {
            return d(context, str, str2);
        }
        if (str2.equals("maint")) {
            return d(context, str, str2);
        }
        if (str2.equals("diffprivacy")) {
            return d(context, str, str2);
        }
        if (str2.equals("preins")) {
            return d(context, str, str2);
        }
        j1.m("hmsSdk", "getChannel(): Invalid type: " + str2);
        return "";
    }

    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(r1.a(str, str2))) {
            return r1.a(str, str2);
        }
        j1.h("hmsSdk", "getAndroidId(): to getConfigByType()");
        return c(context, str, str2);
    }

    private static String c(Context context, String str, String str2) {
        if (r1.b(str, str2)) {
            if (TextUtils.isEmpty(y0.g())) {
                d1.e().d().e(s0.d(context));
            }
            return y0.g();
        }
        return "";
    }

    private static String d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(c.e(str, str2))) {
            return c.e(str, str2);
        }
        u d6 = d1.e().d();
        if (TextUtils.isEmpty(d6.p())) {
            String h6 = s0.h(context);
            if (!n.c("channel", h6, 256)) {
                h6 = "";
            }
            d6.m(h6);
        }
        return d6.p();
    }
}
