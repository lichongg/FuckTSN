package io.netty.util.internal.logging;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class MessageFormatter {
    private static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    static FormattingTuple arrayFormat(String str, Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return new FormattingTuple(str, null);
        }
        int length = objArr.length - 1;
        Object obj = objArr[length];
        Throwable th = obj instanceof Throwable ? (Throwable) obj : null;
        if (str == null) {
            return new FormattingTuple(null, th);
        }
        int indexOf = str.indexOf(DELIM_STR);
        if (indexOf == -1) {
            return new FormattingTuple(str, th);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i6 = 0;
        int i7 = 0;
        do {
            boolean z5 = indexOf == 0 || str.charAt(indexOf + (-1)) != '\\';
            if (z5) {
                sb.append((CharSequence) str, i6, indexOf);
            } else {
                sb.append((CharSequence) str, i6, indexOf - 1);
                z5 = indexOf >= 2 && str.charAt(indexOf + (-2)) == '\\';
            }
            i6 = indexOf + 2;
            if (z5) {
                deeplyAppendParameter(sb, objArr[i7], null);
                i7++;
                if (i7 > length) {
                    break;
                }
            } else {
                sb.append(DELIM_STR);
            }
            indexOf = str.indexOf(DELIM_STR, i6);
        } while (indexOf != -1);
        sb.append((CharSequence) str, i6, str.length());
        return new FormattingTuple(sb.toString(), i7 <= length ? th : null);
    }

    private static void booleanArrayAppend(StringBuilder sb, boolean[] zArr) {
        if (zArr.length == 0) {
            return;
        }
        sb.append(zArr[0]);
        for (int i6 = 1; i6 < zArr.length; i6++) {
            sb.append(", ");
            sb.append(zArr[i6]);
        }
    }

    private static void byteArrayAppend(StringBuilder sb, byte[] bArr) {
        if (bArr.length == 0) {
            return;
        }
        sb.append((int) bArr[0]);
        for (int i6 = 1; i6 < bArr.length; i6++) {
            sb.append(", ");
            sb.append((int) bArr[i6]);
        }
    }

    private static void charArrayAppend(StringBuilder sb, char[] cArr) {
        if (cArr.length == 0) {
            return;
        }
        sb.append(cArr[0]);
        for (int i6 = 1; i6 < cArr.length; i6++) {
            sb.append(", ");
            sb.append(cArr[i6]);
        }
    }

    private static void doubleArrayAppend(StringBuilder sb, double[] dArr) {
        if (dArr.length == 0) {
            return;
        }
        sb.append(dArr[0]);
        for (int i6 = 1; i6 < dArr.length; i6++) {
            sb.append(", ");
            sb.append(dArr[i6]);
        }
    }

    private static void floatArrayAppend(StringBuilder sb, float[] fArr) {
        if (fArr.length == 0) {
            return;
        }
        sb.append(fArr[0]);
        for (int i6 = 1; i6 < fArr.length; i6++) {
            sb.append(", ");
            sb.append(fArr[i6]);
        }
    }

    static FormattingTuple format(String str, Object obj) {
        return arrayFormat(str, new Object[]{obj});
    }

    private static void intArrayAppend(StringBuilder sb, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        sb.append(iArr[0]);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            sb.append(", ");
            sb.append(iArr[i6]);
        }
    }

    private static void longArrayAppend(StringBuilder sb, long[] jArr) {
        if (jArr.length == 0) {
            return;
        }
        sb.append(jArr[0]);
        for (int i6 = 1; i6 < jArr.length; i6++) {
            sb.append(", ");
            sb.append(jArr[i6]);
        }
    }

    private static void objectArrayAppend(StringBuilder sb, Object[] objArr, Set<Object[]> set) {
        if (objArr.length == 0) {
            return;
        }
        if (set == null) {
            set = new HashSet<>(objArr.length);
        }
        if (!set.add(objArr)) {
            sb.append("...");
            return;
        }
        deeplyAppendParameter(sb, objArr[0], set);
        for (int i6 = 1; i6 < objArr.length; i6++) {
            sb.append(", ");
            deeplyAppendParameter(sb, objArr[i6], set);
        }
        set.remove(objArr);
    }

    private static void shortArrayAppend(StringBuilder sb, short[] sArr) {
        if (sArr.length == 0) {
            return;
        }
        sb.append((int) sArr[0]);
        for (int i6 = 1; i6 < sArr.length; i6++) {
            sb.append(", ");
            sb.append((int) sArr[i6]);
        }
    }

    private static void deeplyAppendParameter(StringBuilder sb, Object obj, Set<Object[]> set) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            if (!Number.class.isAssignableFrom(cls)) {
                safeObjectAppend(sb, obj);
                return;
            }
            if (cls == Long.class) {
                sb.append(((Long) obj).longValue());
                return;
            }
            if (cls == Integer.class || cls == Short.class || cls == Byte.class) {
                sb.append(((Number) obj).intValue());
                return;
            }
            if (cls == Double.class) {
                sb.append(((Double) obj).doubleValue());
                return;
            } else if (cls == Float.class) {
                sb.append(((Float) obj).floatValue());
                return;
            } else {
                safeObjectAppend(sb, obj);
                return;
            }
        }
        sb.append('[');
        if (cls == boolean[].class) {
            booleanArrayAppend(sb, (boolean[]) obj);
        } else if (cls == byte[].class) {
            byteArrayAppend(sb, (byte[]) obj);
        } else if (cls == char[].class) {
            charArrayAppend(sb, (char[]) obj);
        } else if (cls == short[].class) {
            shortArrayAppend(sb, (short[]) obj);
        } else if (cls == int[].class) {
            intArrayAppend(sb, (int[]) obj);
        } else if (cls == long[].class) {
            longArrayAppend(sb, (long[]) obj);
        } else if (cls == float[].class) {
            floatArrayAppend(sb, (float[]) obj);
        } else if (cls == double[].class) {
            doubleArrayAppend(sb, (double[]) obj);
        } else {
            objectArrayAppend(sb, (Object[]) obj, set);
        }
        sb.append(']');
    }

    static FormattingTuple format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }

    private MessageFormatter() {
    }

    private static void safeObjectAppend(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            obj.getClass();
            printStream.getClass();
            th.printStackTrace();
            sb.append("[FAILED toString()]");
        }
    }
}
