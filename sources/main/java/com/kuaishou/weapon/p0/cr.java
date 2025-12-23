package com.kuaishou.weapon.p0;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f35924a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f35925b = true;

    static {
        try {
            f35924a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", null).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", null).invoke(null, null), null)).booleanValue();
        } catch (Exception unused) {
            f35924a = false;
        }
        f35925b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f35924a;
    }

    public static boolean b() {
        return f35925b;
    }
}
