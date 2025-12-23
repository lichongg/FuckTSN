package androidx.core.content.res;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class GrowingArrayUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public static <T> T[] append(T[] tArr, int i6, T t5) {
        if (i6 + 1 > tArr.length) {
            ?? r02 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i6));
            System.arraycopy(tArr, 0, r02, 0, i6);
            tArr = r02;
        }
        tArr[i6] = t5;
        return tArr;
    }

    public static int growSize(int i6) {
        if (i6 <= 4) {
            return 8;
        }
        return i6 * 2;
    }

    public static <T> T[] insert(T[] tArr, int i6, int i7, T t5) {
        if (i6 + 1 <= tArr.length) {
            System.arraycopy(tArr, i7, tArr, i7 + 1, i6 - i7);
            tArr[i7] = t5;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i6)));
        System.arraycopy(tArr, 0, tArr2, 0, i7);
        tArr2[i7] = t5;
        System.arraycopy(tArr, i7, tArr2, i7 + 1, tArr.length - i7);
        return tArr2;
    }

    private GrowingArrayUtils() {
    }

    public static int[] append(int[] iArr, int i6, int i7) {
        if (i6 + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i6)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            iArr = iArr2;
        }
        iArr[i6] = i7;
        return iArr;
    }

    public static int[] insert(int[] iArr, int i6, int i7, int i8) {
        if (i6 + 1 <= iArr.length) {
            System.arraycopy(iArr, i7, iArr, i7 + 1, i6 - i7);
            iArr[i7] = i8;
            return iArr;
        }
        int[] iArr2 = new int[growSize(i6)];
        System.arraycopy(iArr, 0, iArr2, 0, i7);
        iArr2[i7] = i8;
        System.arraycopy(iArr, i7, iArr2, i7 + 1, iArr.length - i7);
        return iArr2;
    }

    public static long[] append(long[] jArr, int i6, long j6) {
        if (i6 + 1 > jArr.length) {
            long[] jArr2 = new long[growSize(i6)];
            System.arraycopy(jArr, 0, jArr2, 0, i6);
            jArr = jArr2;
        }
        jArr[i6] = j6;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i6, boolean z5) {
        if (i6 + 1 > zArr.length) {
            boolean[] zArr2 = new boolean[growSize(i6)];
            System.arraycopy(zArr, 0, zArr2, 0, i6);
            zArr = zArr2;
        }
        zArr[i6] = z5;
        return zArr;
    }

    public static long[] insert(long[] jArr, int i6, int i7, long j6) {
        if (i6 + 1 <= jArr.length) {
            System.arraycopy(jArr, i7, jArr, i7 + 1, i6 - i7);
            jArr[i7] = j6;
            return jArr;
        }
        long[] jArr2 = new long[growSize(i6)];
        System.arraycopy(jArr, 0, jArr2, 0, i7);
        jArr2[i7] = j6;
        System.arraycopy(jArr, i7, jArr2, i7 + 1, jArr.length - i7);
        return jArr2;
    }

    public static boolean[] insert(boolean[] zArr, int i6, int i7, boolean z5) {
        if (i6 + 1 <= zArr.length) {
            System.arraycopy(zArr, i7, zArr, i7 + 1, i6 - i7);
            zArr[i7] = z5;
            return zArr;
        }
        boolean[] zArr2 = new boolean[growSize(i6)];
        System.arraycopy(zArr, 0, zArr2, 0, i7);
        zArr2[i7] = z5;
        System.arraycopy(zArr, i7, zArr2, i7 + 1, zArr.length - i7);
        return zArr2;
    }
}
