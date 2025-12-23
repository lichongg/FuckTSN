package com.bytedance.adsdk.xt.xt.up.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static Object j(int i6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(i6 > number.intValue());
        }
        if (number instanceof Long) {
            return Boolean.valueOf(((long) i6) > number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) i6) > number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) i6) > number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object j(long j6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(j6 > ((long) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(j6 > number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) j6) > number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) j6) > number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object j(float f6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(f6 > ((float) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(f6 > ((float) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(f6 > number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) f6) > number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object j(double d6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(d6 > ((double) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(d6 > ((double) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(d6 > ((double) number.floatValue()));
        }
        if (number instanceof Double) {
            return Boolean.valueOf(d6 > number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static Object j(Object obj, Number number) {
        if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
            if (obj instanceof Long) {
                return j(((Long) obj).longValue(), number);
            }
            if (obj instanceof Float) {
                return j(((Float) obj).floatValue(), number);
            }
            if (obj instanceof Double) {
                return j(((Double) obj).doubleValue(), number);
            }
            if (obj instanceof String) {
                try {
                    return j(Float.parseFloat((String) obj), number);
                } catch (NumberFormatException unused) {
                    throw new UnsupportedOperationException(obj.getClass().getName() + "This type of addition operation is not supported");
                }
            }
            throw new UnsupportedOperationException(obj.getClass().getName() + "This type of addition operation is not supported");
        }
        return j(((Number) obj).intValue(), number);
    }
}
