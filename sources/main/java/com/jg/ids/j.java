package com.jg.ids;

import android.content.Context;
import android.content.pm.PackageManager;
import com.acse.ottn.l3;
import java.lang.reflect.Constructor;

/* loaded from: D:\Downloads\app\classes10.dex */
public class j implements com.jg.ids.m.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f35549a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f35550b;

    /* renamed from: c, reason: collision with root package name */
    private Object f35551c;

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e6) {
            str3 = null;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception e6) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null;
        } catch (PackageManager.NameNotFoundException e6) {
            return false;
        }
    }

    public j(Context context) {
        this.f35549a = context;
        try {
            this.f35550b = Class.forName("android.app.ZteDeviceIdentifyManager");
            Constructor<?> declaredConstructor = this.f35550b.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            this.f35551c = declaredConstructor.newInstance(context);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.jg.ids.m.a
    public boolean a() {
        return this.f35551c != null;
    }

    @Override // com.jg.ids.m.a
    public String b() {
        if (this.f35549a == null || this.f35550b == null || this.f35551c == null) {
            return "";
        }
        try {
            String str = (String) this.f35550b.getMethod("getOAID", Context.class).invoke(this.f35551c, this.f35549a);
            if (str != null) {
                if (str.length() != 0) {
                    return str;
                }
            }
            return "";
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
