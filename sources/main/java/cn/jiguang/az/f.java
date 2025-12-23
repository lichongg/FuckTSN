package cn.jiguang.az;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Long f1851a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f1852b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f1853c;

    /* renamed from: d, reason: collision with root package name */
    private static String f1854d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile Class<?> f1855e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile Method f1856f;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f1858h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile Class<?> f1859i;

    /* renamed from: k, reason: collision with root package name */
    private static LinkedList<String> f1861k;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f1857g = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f1860j = new Object();

    public static long a(Context context) {
        Long l6 = f1851a;
        if (l6 != null) {
            return l6.longValue();
        }
        Object a6 = a(context, null, 20, null, null, new Object[0]);
        if (a6 instanceof Long) {
            Long l7 = (Long) a6;
            if (l7.longValue() > 0) {
                f1851a = l7;
                return l7.longValue();
            }
        }
        return 0L;
    }

    public static int b() {
        try {
            Field declaredField = f().getDeclaredField("SDK_VERSION_INT");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JCoreBridge", "error occured when getJCoreSDKVersion." + th.getMessage());
            return 0;
        }
    }

    public static String c() {
        try {
            Field declaredField = f().getDeclaredField("APP_KEY");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JCoreBridge", "error occured when getJCoreSDKVersion." + th.getMessage());
            return "";
        }
    }

    public static String d(Context context) {
        String str = f1854d;
        if (str != null) {
            return str;
        }
        Object a6 = a(context, null, 6, null, null, new Object[0]);
        if (!(a6 instanceof String)) {
            return null;
        }
        String str2 = (String) a6;
        f1854d = str2;
        return str2;
    }

    public static LinkedList<String> e() {
        try {
            LinkedList<String> linkedList = f1861k;
            if (linkedList != null && linkedList.size() > 0) {
                return f1861k;
            }
            Field declaredField = f().getDeclaredField("TUU");
            declaredField.setAccessible(true);
            LinkedList<String> linkedList2 = (LinkedList) declaredField.get(null);
            f1861k = linkedList2;
            return linkedList2;
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JCoreBridge", "error occured when isDebugModel." + th.getMessage());
            return null;
        }
    }

    public static PackageInfo a(Context context, Object... objArr) {
        Object a6 = a(context, null, 98, null, null, objArr);
        if (a6 instanceof PackageInfo) {
            return (PackageInfo) a6;
        }
        return null;
    }

    public static boolean b(Context context) {
        Boolean bool = f1852b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object a6 = a(context, null, 123, null, null, new Object[0]);
        if (!(a6 instanceof Boolean)) {
            return false;
        }
        Boolean bool2 = (Boolean) a6;
        f1852b = bool2;
        return bool2.booleanValue();
    }

    public static boolean c(Context context) {
        Boolean bool = f1853c;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object a6 = a(context, null, 121, null, null, new Object[0]);
        if (!(a6 instanceof Boolean)) {
            return false;
        }
        Boolean bool2 = (Boolean) a6;
        f1853c = bool2;
        return bool2.booleanValue();
    }

    public static boolean d() {
        try {
            Boolean bool = f1858h;
            if (bool == null) {
                Field field = f().getField("INTERNAL_USE");
                field.setAccessible(true);
                Object obj = field.get(null);
                if (obj instanceof Boolean) {
                    f1858h = (Boolean) obj;
                }
                bool = f1858h;
            }
            return bool.booleanValue();
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JCoreBridge", "error occured when isInternalUse." + th.getMessage());
            return false;
        }
    }

    private static Class<?> f() {
        try {
            if (f1859i == null) {
                synchronized (f1860j) {
                    try {
                        if (f1859i == null) {
                            f1859i = Class.forName("cn.jiguang.internal.JConstants");
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ay.b.e("JCoreBridge", "error occured when getJConstants." + th.getMessage());
        }
        return f1859i;
    }

    public static Object a(Context context, String str, int i6, String str2, Bundle bundle, Object... objArr) {
        try {
            if (f1855e == null) {
                synchronized (f1857g) {
                    try {
                        if (f1855e == null) {
                            f1855e = Class.forName("cn.jiguang.api.JCoreManager");
                        }
                    } finally {
                    }
                }
            }
            if (f1856f == null) {
                f1856f = f1855e.getDeclaredMethod("onEvent", Context.class, String.class, Integer.TYPE, String.class, Bundle.class, Object[].class);
            }
            if (f1856f != null) {
                return f1856f.invoke(null, context, str, Integer.valueOf(i6), str2, bundle, objArr);
            }
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JCoreBridge", "error occured when invokeOnEvent." + th.getMessage());
        }
        return null;
    }

    public static Map<Integer, Bundle> a() {
        try {
            Class<?> cls = Class.forName("cn.jiguang.internal.ActionManager");
            Object invoke = cls.getDeclaredMethod("loadPInfo", null).invoke(cls.getDeclaredMethod("getInstance", null).invoke(null, null), null);
            if (invoke instanceof Map) {
                return (Map) invoke;
            }
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JCoreBridge", "error occured when getUid." + th.getMessage());
        }
        return null;
    }

    public static void a(Context context, String str, long j6, int i6) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("type", "dy");
        bundle.putLong("req", j6);
        bundle.putLong("res", i6);
        a(context, null, 122, null, bundle, new Object[0]);
    }
}
