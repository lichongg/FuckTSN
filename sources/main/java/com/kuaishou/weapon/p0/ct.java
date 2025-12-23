package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static int f35927a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f35928b;

    private int a(Method method) {
        try {
            int i6 = f35927a;
            if (i6 <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i6, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || f35928b) {
            return;
        }
        boolean b6 = cr.b();
        int i6 = Build.VERSION.SDK_INT;
        if (b6 && i6 < 29 && i6 > 22) {
            f35927a = Engine.off();
        }
        f35928b = true;
    }

    private boolean c() {
        return f35928b && f35927a > 1;
    }

    public ct() {
        b();
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dh.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i6, Class cls, String str, Object... objArr) {
        Method a6;
        try {
            if (!c() || (a6 = dh.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a6, i6);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long a6 = cq.f35916b.a();
        long a7 = cq.f35915a.a();
        if (f35927a == a6) {
            return (int) a7;
        }
        return -1;
    }
}
