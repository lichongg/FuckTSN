package org.repackage.com.miui.deviceid;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IdentifierManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51609a = "IdentifierManager";

    /* renamed from: b, reason: collision with root package name */
    private static Object f51610b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f51611c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f51612d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f51613e;

    /* renamed from: f, reason: collision with root package name */
    private static Method f51614f;

    /* renamed from: g, reason: collision with root package name */
    private static Method f51615g;

    public static boolean a() {
        return (f51611c == null || f51610b == null) ? false : true;
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f51611c = cls;
            f51610b = cls.newInstance();
            f51612d = f51611c.getMethod("getUDID", Context.class);
            f51613e = f51611c.getMethod("getOAID", Context.class);
            f51614f = f51611c.getMethod("getVAID", Context.class);
            f51615g = f51611c.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static String a(Context context) {
        return a(context, f51612d);
    }

    public static String b(Context context) {
        return a(context, f51613e);
    }

    public static String c(Context context) {
        return a(context, f51614f);
    }

    public static String d(Context context) {
        return a(context, f51615g);
    }

    private static String a(Context context, Method method) {
        Object obj = f51610b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
