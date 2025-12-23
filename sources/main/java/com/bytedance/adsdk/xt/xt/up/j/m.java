package com.bytedance.adsdk.xt.xt.up.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private static Object j(int i6, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i6 % number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(i6 % number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i6 % number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(i6 % number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object j(long j6, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(j6 % number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(j6 % number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(j6 % number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return Long.valueOf(j6 % number.intValue());
    }

    private static Object j(float f6, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Float.valueOf(f6 % number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(f6 % number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(f6 % number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return Float.valueOf(f6 % number.intValue());
    }

    private static Object j(double d6, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Double.valueOf(d6 % number.longValue());
            }
            if (number instanceof Float) {
                return Double.valueOf(d6 % number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(d6 % number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return Double.valueOf(d6 % number.intValue());
    }

    public static Object j(Number number, Number number2) {
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
