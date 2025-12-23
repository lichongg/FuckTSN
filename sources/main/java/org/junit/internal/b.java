package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class b {
    protected abstract void c(Object obj, Object obj2);

    private int b(Object obj, Object obj2, String str) {
        if (obj == null) {
            org.junit.a.d0(str + "expected array was null");
        }
        if (obj2 == null) {
            org.junit.a.d0(str + "actual array was null");
        }
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj);
        if (length != length2) {
            org.junit.a.d0(str + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
        }
        return length2;
    }

    private boolean d(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    public void a(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        if (obj != obj2) {
            if (Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
                return;
            }
            String str2 = str == null ? "" : str + ": ";
            int b6 = b(obj, obj2, str2);
            for (int i6 = 0; i6 < b6; i6++) {
                Object obj3 = Array.get(obj, i6);
                Object obj4 = Array.get(obj2, i6);
                if (d(obj3) && d(obj4)) {
                    try {
                        a(str, obj3, obj4);
                    } catch (ArrayComparisonFailure e6) {
                        e6.addDimension(i6);
                        throw e6;
                    }
                } else {
                    try {
                        c(obj3, obj4);
                    } catch (AssertionError e7) {
                        throw new ArrayComparisonFailure(str2, e7, i6);
                    }
                }
            }
        }
    }
}
