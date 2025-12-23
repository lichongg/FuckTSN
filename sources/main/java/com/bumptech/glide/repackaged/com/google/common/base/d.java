package com.bumptech.glide.repackaged.com.google.common.base;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {
    private static String a(int i6, int i7, String str) {
        if (i6 < 0) {
            return p("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return p("%s (%s) must be less than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    private static String b(int i6, int i7, String str) {
        if (i6 < 0) {
            return p("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return p("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    private static String c(int i6, int i7, int i8) {
        return (i6 < 0 || i6 > i8) ? b(i6, i8, "start index") : (i7 < 0 || i7 > i8) ? b(i7, i8, "end index") : p("end index (%s) must not be less than start index (%s)", Integer.valueOf(i7), Integer.valueOf(i6));
    }

    public static void d(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z5, String str, Object... objArr) {
        if (!z5) {
            throw new IllegalArgumentException(p(str, objArr));
        }
    }

    public static int g(int i6, int i7) {
        return h(i6, i7, "index");
    }

    public static int h(int i6, int i7, String str) {
        if (i6 < 0 || i6 >= i7) {
            throw new IndexOutOfBoundsException(a(i6, i7, str));
        }
        return i6;
    }

    public static <T> T j(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int k(int i6, int i7) {
        return l(i6, i7, "index");
    }

    public static int l(int i6, int i7, String str) {
        if (i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException(b(i6, i7, str));
        }
        return i6;
    }

    public static void m(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            throw new IndexOutOfBoundsException(c(i6, i7, i8));
        }
    }

    public static void n(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void o(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T i(T t5) {
        t5.getClass();
        return t5;
    }

    static String p(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i6 = 0;
        int i7 = 0;
        while (i6 < objArr.length && (indexOf = valueOf.indexOf("%s", i7)) != -1) {
            sb.append(valueOf.substring(i7, indexOf));
            sb.append(objArr[i6]);
            i7 = indexOf + 2;
            i6++;
        }
        sb.append(valueOf.substring(i7));
        if (i6 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i8 = i6 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
