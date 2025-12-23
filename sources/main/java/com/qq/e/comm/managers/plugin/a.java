package com.qq.e.comm.managers.plugin;

import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f36775a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f36776b;

    private static void a(Throwable th) throws Throwable {
        if (f36776b) {
            return;
        }
        if (f36775a == null) {
            Method declaredMethod = CrashReport.class.getDeclaredMethod("postCatchedException", Throwable.class);
            f36775a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        f36775a.invoke(null, th);
    }

    public static void a(Throwable th, String str) {
        try {
            a(new Exception("插件错误：" + str, th));
        } catch (Throwable unused) {
            f36776b = true;
        }
    }
}
