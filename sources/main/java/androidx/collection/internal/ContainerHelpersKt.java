package androidx.collection.internal;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ContainerHelpersKt {

    @JvmField
    @NotNull
    public static final int[] EMPTY_INTS = new int[0];

    @JvmField
    @NotNull
    public static final long[] EMPTY_LONGS = new long[0];

    @JvmField
    @NotNull
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(@NotNull int[] array, int i6, int i7) {
        g0.p(array, "array");
        int i8 = i6 - 1;
        int i9 = 0;
        while (i9 <= i8) {
            int i10 = (i9 + i8) >>> 1;
            int i11 = array[i10];
            if (i11 < i7) {
                i9 = i10 + 1;
            } else {
                if (i11 <= i7) {
                    return i10;
                }
                i8 = i10 - 1;
            }
        }
        return ~i9;
    }

    public static final int idealByteArraySize(int i6) {
        for (int i7 = 4; i7 < 32; i7++) {
            int i8 = (1 << i7) - 12;
            if (i6 <= i8) {
                return i8;
            }
        }
        return i6;
    }

    public static final int binarySearch(@NotNull long[] array, int i6, long j6) {
        g0.p(array, "array");
        int i7 = i6 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            long j7 = array[i9];
            if (j7 < j6) {
                i8 = i9 + 1;
            } else {
                if (j7 <= j6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static final int idealIntArraySize(int i6) {
        return idealByteArraySize(i6 * 4) / 4;
    }

    public static final int idealLongArraySize(int i6) {
        return idealByteArraySize(i6 * 8) / 8;
    }

    public static final boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return g0.g(obj, obj2);
    }
}
