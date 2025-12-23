package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final char f51747a = '{';

    /* renamed from: b, reason: collision with root package name */
    static final char f51748b = '}';

    /* renamed from: c, reason: collision with root package name */
    static final String f51749c = "{}";

    /* renamed from: d, reason: collision with root package name */
    private static final char f51750d = '\\';

    public static final c i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final c j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    static final Throwable k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    static final boolean m(String str, int i6) {
        return i6 >= 2 && str.charAt(i6 - 2) == '\\';
    }

    static final boolean n(String str, int i6) {
        return i6 != 0 && str.charAt(i6 - 1) == '\\';
    }

    public static final c b(String str, Object[] objArr, Throwable th) {
        int i6;
        if (str == null) {
            return new c(null, objArr, th);
        }
        if (objArr == null) {
            return new c(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i7 = 0;
        int i8 = 0;
        while (i7 < objArr.length) {
            int indexOf = str.indexOf(f51749c, i8);
            if (indexOf == -1) {
                if (i8 == 0) {
                    return new c(str, objArr, th);
                }
                sb.append((CharSequence) str, i8, str.length());
                return new c(sb.toString(), objArr, th);
            }
            if (!n(str, indexOf)) {
                sb.append((CharSequence) str, i8, indexOf);
                f(sb, objArr[i7], new HashMap());
            } else if (m(str, indexOf)) {
                sb.append((CharSequence) str, i8, indexOf - 1);
                f(sb, objArr[i7], new HashMap());
            } else {
                i7--;
                sb.append((CharSequence) str, i8, indexOf - 1);
                sb.append(f51747a);
                i6 = indexOf + 1;
                i8 = i6;
                i7++;
            }
            i6 = indexOf + 2;
            i8 = i6;
            i7++;
        }
        sb.append((CharSequence) str, i8, str.length());
        return new c(sb.toString(), objArr, th);
    }

    private static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(zArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append((int) bArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(cArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void f(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            q(sb, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            e(sb, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            r(sb, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            l(sb, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            o(sb, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            p(sb, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(dArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(fArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void l(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(iArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void o(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(jArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void p(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (map.containsKey(objArr)) {
            sb.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                f(sb, objArr[i6], map);
                if (i6 != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        }
        sb.append(']');
    }

    private static void r(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append((int) sArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static Object[] s(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    public static final c a(String str, Object[] objArr) {
        Throwable k6 = k(objArr);
        if (k6 != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, k6);
    }

    private static void q(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            j.d("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }
}
