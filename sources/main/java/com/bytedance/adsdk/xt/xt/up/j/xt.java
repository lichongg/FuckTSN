package com.bytedance.adsdk.xt.xt.up.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private static boolean j(int i6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return i6 == number.intValue();
        }
        if (number instanceof Long) {
            return ((long) i6) == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) i6) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) i6) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static boolean j(long j6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return j6 == ((long) number.intValue());
        }
        if (number instanceof Long) {
            return j6 == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) j6) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) j6) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static boolean j(float f6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return f6 == ((float) number.intValue());
        }
        if (number instanceof Long) {
            return f6 == ((float) number.longValue());
        }
        if (number instanceof Float) {
            return f6 == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) f6) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static boolean j(double d6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return d6 == ((double) number.intValue());
        }
        if (number instanceof Long) {
            return d6 == ((double) number.longValue());
        }
        if (number instanceof Float) {
            return d6 == ((double) number.floatValue());
        }
        if (number instanceof Double) {
            return d6 == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static boolean j(Number number, Number number2) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return j(number.longValue(), number2);
            }
            if (number instanceof Float) {
                return j(number.floatValue(), number2);
            }
            if (number instanceof Double) {
                return j(number.doubleValue(), number2);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return j(number.intValue(), number2);
    }
}
