package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = new BiPredicate<Object, Object>() { // from class: io.reactivex.internal.functions.ObjectHelper.1
        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.equals(obj, obj2);
        }
    };

    public static int compare(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 > i7 ? 1 : 0;
    }

    public static int verifyPositive(int i6, String str) {
        if (i6 > 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i6);
    }

    public static int compare(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 > j7 ? 1 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return (BiPredicate<T, T>) EQUALS;
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static <T> T requireNonNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static long verifyPositive(long j6, String str) {
        if (j6 > 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j6);
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }
}
