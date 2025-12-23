package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ObjectArrays {
    @CanIgnoreReturnValue
    static Object[] checkElementsNotNull(Object... objArr) {
        return checkElementsNotNull(objArr, objArr.length);
    }

    @GwtIncompatible
    public static <T> T[] concat(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] tArr3 = (T[]) newArray(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    @GwtIncompatible
    public static <T> T[] newArray(Class<T> cls, int i6) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i6));
    }

    static <T> T[] toArrayImpl(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) newArray(tArr, size);
        }
        fillArray(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    @CanIgnoreReturnValue
    static Object checkElementNotNull(Object obj, int i6) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i6);
    }

    @CanIgnoreReturnValue
    static Object[] checkElementsNotNull(Object[] objArr, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            checkElementNotNull(objArr[i7], i7);
        }
        return objArr;
    }

    static Object[] copyAsObjectArray(Object[] objArr, int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, objArr.length);
        if (i7 == 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[i7];
        System.arraycopy(objArr, i6, objArr2, 0, i7);
        return objArr2;
    }

    public static <T> T[] newArray(T[] tArr, int i6) {
        return (T[]) Platform.newArray(tArr, i6);
    }

    static void swap(Object[] objArr, int i6, int i7) {
        Object obj = objArr[i6];
        objArr[i6] = objArr[i7];
        objArr[i7] = obj;
    }

    private ObjectArrays() {
    }

    @CanIgnoreReturnValue
    private static Object[] fillArray(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return objArr;
    }

    public static <T> T[] concat(@NullableDecl T t5, T[] tArr) {
        T[] tArr2 = (T[]) newArray(tArr, tArr.length + 1);
        tArr2[0] = t5;
        System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] concat(T[] tArr, @NullableDecl T t5) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t5;
        return tArr2;
    }

    static <T> T[] toArrayImpl(Object[] objArr, int i6, int i7, T[] tArr) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, objArr.length);
        if (tArr.length < i7) {
            tArr = (T[]) newArray(tArr, i7);
        } else if (tArr.length > i7) {
            tArr[i7] = null;
        }
        System.arraycopy(objArr, i6, tArr, 0, i7);
        return tArr;
    }

    static Object[] toArrayImpl(Collection<?> collection) {
        return fillArray(collection, new Object[collection.size()]);
    }
}
