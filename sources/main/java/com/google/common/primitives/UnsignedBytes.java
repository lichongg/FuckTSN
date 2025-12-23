package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class LexicographicalComparatorHolder {
        static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
        static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i6 = 0; i6 < min; i6++) {
                    int compare = UnsignedBytes.compare(bArr[i6], bArr2[i6]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @VisibleForTesting
        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            static {
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int arrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i6 = min & (-8);
                int i7 = 0;
                while (i7 < i6) {
                    Unsafe unsafe = theUnsafe;
                    int i8 = BYTE_ARRAY_BASE_OFFSET;
                    long j6 = i7;
                    long j7 = unsafe.getLong(bArr, i8 + j6);
                    long j8 = unsafe.getLong(bArr2, i8 + j6);
                    if (j7 != j8) {
                        if (BIG_ENDIAN) {
                            return UnsignedLongs.compare(j7, j8);
                        }
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j7 ^ j8) & (-8);
                        return ((int) ((j7 >>> numberOfTrailingZeros) & 255)) - ((int) ((j8 >>> numberOfTrailingZeros) & 255));
                    }
                    i7 += 8;
                }
                while (i7 < min) {
                    int compare = UnsignedBytes.compare(bArr[i7], bArr2[i7]);
                    if (compare != 0) {
                        return compare;
                    }
                    i7++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            private static Unsafe getUnsafe() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (SecurityException unused) {
                        return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
                            @Override // java.security.PrivilegedExceptionAction
                            public Unsafe run() throws Exception {
                                for (Field field : Unsafe.class.getDeclaredFields()) {
                                    field.setAccessible(true);
                                    Object obj = field.get(null);
                                    if (Unsafe.class.isInstance(obj)) {
                                        return (Unsafe) Unsafe.class.cast(obj);
                                    }
                                }
                                throw new NoSuchFieldError("the Unsafe");
                            }
                        });
                    }
                } catch (PrivilegedActionException e6) {
                    throw new RuntimeException("Could not initialize intrinsics", e6.getCause());
                }
            }
        }

        static Comparator<byte[]> getBestComparator() {
            try {
                return (Comparator) Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
            } catch (Throwable unused) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }

        LexicographicalComparatorHolder() {
        }
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i6 = toInt(bArr[0]);
        for (int i7 = 1; i7 < bArr.length; i7++) {
            int i8 = toInt(bArr[i7]);
            if (i8 > i6) {
                i6 = i8;
            }
        }
        return (byte) i6;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i6 = toInt(bArr[0]);
        for (int i7 = 1; i7 < bArr.length; i7++) {
            int i8 = toInt(bArr[i7]);
            if (i8 < i6) {
                i6 = i8;
            }
        }
        return (byte) i6;
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte saturatedCast(long j6) {
        if (j6 > toInt((byte) -1)) {
            return (byte) -1;
        }
        if (j6 < 0) {
            return (byte) 0;
        }
        return (byte) j6;
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    @Beta
    public static String toString(byte b6) {
        return toString(b6, 10);
    }

    @CanIgnoreReturnValue
    public static byte checkedCast(long j6) {
        Preconditions.checkArgument((j6 >> 8) == 0, "out of range: %s", j6);
        return (byte) j6;
    }

    private static byte flip(byte b6) {
        return (byte) (b6 ^ 128);
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str, int i6) {
        int parseInt = Integer.parseInt((String) Preconditions.checkNotNull(str), i6);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException("out of range: " + parseInt);
    }

    public static int toInt(byte b6) {
        return b6 & 255;
    }

    @Beta
    public static String toString(byte b6, int i6) {
        Preconditions.checkArgument(i6 >= 2 && i6 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i6);
        return Integer.toString(toInt(b6), i6);
    }

    private UnsignedBytes() {
    }

    public static int compare(byte b6, byte b7) {
        return toInt(b6) - toInt(b7);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(toInt(bArr[0]));
        for (int i6 = 1; i6 < bArr.length; i6++) {
            sb.append(str);
            sb.append(toString(bArr[i6]));
        }
        return sb.toString();
    }

    public static void sort(byte[] bArr, int i6, int i7) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i6, i7, bArr.length);
        for (int i8 = i6; i8 < i7; i8++) {
            bArr[i8] = flip(bArr[i8]);
        }
        Arrays.sort(bArr, i6, i7);
        while (i6 < i7) {
            bArr[i6] = flip(bArr[i6]);
            i6++;
        }
    }

    public static void sortDescending(byte[] bArr, int i6, int i7) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i6, i7, bArr.length);
        for (int i8 = i6; i8 < i7; i8++) {
            bArr[i8] = (byte) (bArr[i8] ^ Byte.MAX_VALUE);
        }
        Arrays.sort(bArr, i6, i7);
        while (i6 < i7) {
            bArr[i6] = (byte) (bArr[i6] ^ Byte.MAX_VALUE);
            i6++;
        }
    }
}
