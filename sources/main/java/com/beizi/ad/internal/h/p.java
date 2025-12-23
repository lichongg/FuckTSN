package com.beizi.ad.internal.h;

import com.acse.ottn.l3;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static Method f12117a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f12118b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f12119c;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    f12117a = method;
                } else if (name.equals(l3.f4738h)) {
                    f12119c = method;
                } else if (name.equals(l3.f4736f)) {
                    f12118b = method;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) f12118b.invoke(null, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
