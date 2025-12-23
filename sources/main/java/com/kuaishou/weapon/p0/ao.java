package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ao {
    public boolean a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(an.f35735b).getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean b() {
        try {
            throw new Exception("");
        } catch (Exception e6) {
            for (StackTraceElement stackTraceElement : e6.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(an.f35735b)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean c() {
        return a(an.f35736c);
    }

    public String e() {
        try {
            return System.getProperty("vxp");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean f() {
        try {
            String str = System.getenv("CLASSPATH");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("XposedBridge");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean g() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", null).getModifiers());
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public boolean d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.f35734a).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        }
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.f35735b).newInstance();
            } catch (ClassNotFoundException unused3) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused4) {
            }
        }
        return true;
    }

    private boolean a(String str) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(str).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
            }
        }
        return true;
    }
}
