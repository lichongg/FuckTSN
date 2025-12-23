package cn.jpush.android.m;

import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f3708a = 570;

    /* renamed from: b, reason: collision with root package name */
    public static String f3709b = "5.7.0";

    /* renamed from: c, reason: collision with root package name */
    public static final int f3710c = JConstants.SDK_VERSION_INT;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3711d = false;

    public static boolean a() {
        try {
            return JPushConstants.THIRD_ENABLE;
        } catch (Throwable unused) {
            return true;
        }
    }
}
