package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bh {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40956a = "OpenId";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40957b;

    public static void a(boolean z5) {
        f40957b = z5;
    }

    public static void a(String str, Object... objArr) {
        if (f40957b) {
            e(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f40957b) {
            e(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f40957b) {
            e(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (f40957b) {
            e(str, objArr);
        }
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "-";
        }
        int i6 = 0;
        sb.append(String.format("[%s] ", str));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i7 = i6 + 1;
                if (i7 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i6], objArr[i7]));
                if (i7 < length - 1) {
                    sb.append(",");
                }
                i6 += 2;
            }
            if (i6 == objArr.length - 1) {
                sb.append(objArr[i6]);
            }
        }
        return sb.toString();
    }

    private static String a(Object obj, Object obj2) {
        if (obj == null) {
            obj = "";
        }
        if (obj2 == null) {
            obj2 = "";
        }
        return String.format("%s:%s", obj, obj2);
    }
}
