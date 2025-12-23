package com.google.common.hash;

import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class LittleEndianByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.hash.LittleEndianByteArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i6) {
                return Longs.fromBytes(bArr[i6 + 7], bArr[i6 + 6], bArr[i6 + 5], bArr[i6 + 4], bArr[i6 + 3], bArr[i6 + 2], bArr[i6 + 1], bArr[i6]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i6, long j6) {
                long j7 = 255;
                for (int i7 = 0; i7 < 8; i7++) {
                    bArr[i6 + i7] = (byte) ((j6 & j7) >> (i7 * 8));
                    j7 <<= 8;
                }
            }
        };

        /* synthetic */ JavaLittleEndianBytes(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface LittleEndianBytes {
        long getLongLittleEndian(byte[] bArr, int i6);

        void putLongLittleEndian(byte[] bArr, int i6, long j6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i6) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, i6 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i6, long j6) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i6 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j6);
            }
        },
        UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i6) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, i6 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i6, long j6) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i6 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j6));
            }
        };

        private static final int BYTE_ARRAY_BASE_OFFSET;
        private static final Unsafe theUnsafe;

        static {
            Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            if (unsafe.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        /* synthetic */ UnsafeByteArray(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static Unsafe getUnsafe() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.3
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

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        byteArray = littleEndianBytes;
    }

    static int load32(byte[] bArr, int i6) {
        return ((bArr[i6 + 3] & 255) << 24) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
    }

    static long load64(byte[] bArr, int i6) {
        return byteArray.getLongLittleEndian(bArr, i6);
    }

    static long load64Safely(byte[] bArr, int i6, int i7) {
        long j6 = 0;
        for (int i8 = 0; i8 < Math.min(i7, 8); i8++) {
            j6 |= (bArr[i6 + i8] & 255) << (i8 * 8);
        }
        return j6;
    }

    static void store64(byte[] bArr, int i6, long j6) {
        byteArray.putLongLittleEndian(bArr, i6, j6);
    }

    static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }

    private LittleEndianByteArray() {
    }
}
