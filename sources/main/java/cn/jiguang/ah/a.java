package cn.jiguang.ah;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static boolean a() {
        String property = System.getProperty("ro.build.freeme.label");
        return !TextUtils.isEmpty(property) && property.equalsIgnoreCase("FREEMEOS");
    }

    public static boolean b() {
        String property = System.getProperty("ro.ssui.product");
        return (TextUtils.isEmpty(property) || property.equalsIgnoreCase("unknown")) ? false : true;
    }
}
