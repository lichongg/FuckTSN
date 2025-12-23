package com.huawei.hms.framework.common;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SystemPropUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33355a = "SystemPropUtils";

    public static String getProperty(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                Class<?> cls = Class.forName(str3);
                return (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
            } catch (Exception e6) {
                Logger.e(f33355a, "getProperty catch exception: ", e6);
                return str4;
            }
        }
        Logger.w(f33355a, "reflect class for method has exception.");
        return str4;
    }
}
