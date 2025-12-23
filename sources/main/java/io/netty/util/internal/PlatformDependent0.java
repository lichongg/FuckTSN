package io.netty.util.internal;

import com.google.common.base.Ascii;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PlatformDependent0 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final Object INTERNAL_UNSAFE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    private static final int JAVA_VERSION;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static void copyMemory(long j6, long j7, long j8) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(j6, j7, j8);
        } else {
            UNSAFE.copyMemory(j6, j7, j8);
        }
    }

    private static void copyMemoryWithSafePointPolling(long j6, long j7, long j8) {
        long j9 = j6;
        long j10 = j7;
        while (j8 > 0) {
            long min = Math.min(j8, 1048576L);
            UNSAFE.copyMemory(j9, j10, min);
            j8 -= min;
            j9 += min;
            j10 += min;
        }
    }

    static byte getByte(long j6) {
        return UNSAFE.getByte(j6);
    }

    static int getInt(Object obj, long j6) {
        return UNSAFE.getInt(obj, j6);
    }

    private static long getLong(Object obj, long j6) {
        return UNSAFE.getLong(obj, j6);
    }

    static short getShort(long j6) {
        return UNSAFE.getShort(j6);
    }

    static int hashCodeAsciiSanitize(byte b6) {
        return b6 & Ascii.US;
    }

    static void putByte(long j6, byte b6) {
        UNSAFE.putByte(j6, b6);
    }

    static void putInt(long j6, int i6) {
        UNSAFE.putInt(j6, i6);
    }

    static void putLong(long j6, long j7) {
        UNSAFE.putLong(j6, j7);
    }

    static void putShort(long j6, short s5) {
        UNSAFE.putShort(j6, s5);
    }

    static void setMemory(long j6, long j7, byte b6) {
        UNSAFE.setMemory(j6, j7, b6);
    }

    static {
        final ByteBuffer allocateDirect;
        final Unsafe unsafe;
        Field field;
        long j6;
        Constructor<?> constructor;
        boolean matches;
        Method method;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent0.class);
        logger = internalLoggerFactory;
        Throwable explicitNoUnsafeCause0 = explicitNoUnsafeCause0();
        EXPLICIT_NO_UNSAFE_CAUSE = explicitNoUnsafeCause0;
        JAVA_VERSION = javaVersion0();
        IS_ANDROID = isAndroid0();
        IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = explicitTryReflectionSetAccessible0();
        Method method2 = null;
        if (explicitNoUnsafeCause0 != null) {
            allocateDirect = null;
            unsafe = null;
            field = null;
        } else {
            allocateDirect = ByteBuffer.allocateDirect(1);
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField, false);
                        return trySetAccessible != null ? trySetAccessible : declaredField.get(null);
                    } catch (IllegalAccessException | NoClassDefFoundError | NoSuchFieldException | SecurityException e6) {
                        return e6;
                    }
                }
            });
            if (doPrivileged instanceof Throwable) {
                explicitNoUnsafeCause0 = (Throwable) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: unavailable", explicitNoUnsafeCause0);
                unsafe = null;
            } else {
                unsafe = (Unsafe) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: available");
            }
            if (unsafe != null) {
                Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = unsafe.getClass();
                            Class<?> cls2 = Long.TYPE;
                            cls.getDeclaredMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                            return null;
                        } catch (NoSuchMethodException | SecurityException e6) {
                            return e6;
                        }
                    }
                });
                if (doPrivileged2 == null) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: available");
                } else {
                    explicitNoUnsafeCause0 = (Throwable) doPrivileged2;
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: unavailable", explicitNoUnsafeCause0);
                    unsafe = null;
                }
            }
            if (unsafe != null) {
                Object doPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Field declaredField = Buffer.class.getDeclaredField("address");
                            if (unsafe.getLong(allocateDirect, unsafe.objectFieldOffset(declaredField)) == 0) {
                                return null;
                            }
                            return declaredField;
                        } catch (NoSuchFieldException | SecurityException e6) {
                            return e6;
                        }
                    }
                });
                if (doPrivileged3 instanceof Field) {
                    field = (Field) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: available");
                } else {
                    Throwable th = (Throwable) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: unavailable", th);
                    unsafe = null;
                    explicitNoUnsafeCause0 = th;
                    field = null;
                }
            } else {
                field = null;
            }
            if (unsafe != null) {
                long arrayIndexScale = unsafe.arrayIndexScale(byte[].class);
                if (arrayIndexScale != 1) {
                    internalLoggerFactory.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", Long.valueOf(arrayIndexScale));
                    explicitNoUnsafeCause0 = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                    unsafe = null;
                }
            }
        }
        UNSAFE_UNAVAILABILITY_CAUSE = explicitNoUnsafeCause0;
        UNSAFE = unsafe;
        if (unsafe == null) {
            ADDRESS_FIELD_OFFSET = -1L;
            BYTE_ARRAY_BASE_OFFSET = -1L;
            UNALIGNED = false;
            DIRECT_BUFFER_CONSTRUCTOR = null;
            ALLOCATE_ARRAY_METHOD = null;
        } else {
            try {
                Object doPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.4
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Constructor<?> declaredConstructor = allocateDirect.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredConstructor, true);
                            return trySetAccessible != null ? trySetAccessible : declaredConstructor;
                        } catch (NoSuchMethodException | SecurityException e6) {
                            return e6;
                        }
                    }
                });
                if (doPrivileged4 instanceof Constructor) {
                    j6 = unsafe.allocateMemory(1L);
                    try {
                        ((Constructor) doPrivileged4).newInstance(Long.valueOf(j6), 1);
                        constructor = (Constructor) doPrivileged4;
                        internalLoggerFactory.debug("direct buffer constructor: available");
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        constructor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (j6 != -1) {
                            UNSAFE.freeMemory(j6);
                        }
                        throw th;
                    }
                } else {
                    internalLoggerFactory.debug("direct buffer constructor: unavailable", (Throwable) doPrivileged4);
                    constructor = null;
                    j6 = -1;
                }
                if (j6 != -1) {
                    UNSAFE.freeMemory(j6);
                }
                DIRECT_BUFFER_CONSTRUCTOR = constructor;
                ADDRESS_FIELD_OFFSET = objectFieldOffset(field);
                BYTE_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
                Object doPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.5
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader());
                            int javaVersion = PlatformDependent0.javaVersion();
                            if (javaVersion >= 9) {
                                try {
                                    Field declaredField = cls.getDeclaredField(javaVersion >= 11 ? "UNALIGNED" : "unaligned");
                                    if (declaredField.getType() == Boolean.TYPE) {
                                        Unsafe unsafe2 = PlatformDependent0.UNSAFE;
                                        return Boolean.valueOf(unsafe2.getBoolean(unsafe2.staticFieldBase(declaredField), unsafe2.staticFieldOffset(declaredField)));
                                    }
                                } catch (NoSuchFieldException unused2) {
                                }
                            }
                            Method declaredMethod = cls.getDeclaredMethod("unaligned", null);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredMethod, true);
                            return trySetAccessible != null ? trySetAccessible : declaredMethod.invoke(null, null);
                        } catch (ClassNotFoundException e6) {
                            return e6;
                        } catch (IllegalAccessException e7) {
                            return e7;
                        } catch (NoSuchMethodException e8) {
                            return e8;
                        } catch (SecurityException e9) {
                            return e9;
                        } catch (InvocationTargetException e10) {
                            return e10;
                        }
                    }
                });
                if (doPrivileged5 instanceof Boolean) {
                    Boolean bool = (Boolean) doPrivileged5;
                    matches = bool.booleanValue();
                    logger.debug("java.nio.Bits.unaligned: available, {}", bool);
                } else {
                    matches = SystemPropertyUtil.get("os.arch", "").matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                    logger.debug("java.nio.Bits.unaligned: unavailable {}", Boolean.valueOf(matches), (Throwable) doPrivileged5);
                }
                UNALIGNED = matches;
                if (javaVersion() >= 9) {
                    final Object doPrivileged6 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.6
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                return PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe").getDeclaredMethod("getUnsafe", null).invoke(null, null);
                            } catch (Throwable th3) {
                                return th3;
                            }
                        }
                    });
                    if (doPrivileged6 instanceof Throwable) {
                        method = null;
                    } else {
                        Object e6 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.7
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                try {
                                    return doPrivileged6.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, Integer.TYPE);
                                } catch (NoSuchMethodException | SecurityException e7) {
                                    return e7;
                                }
                            }
                        });
                        if (e6 instanceof Method) {
                            try {
                                Method method3 = (Method) e6;
                                doPrivileged6 = e6;
                                method = doPrivileged6;
                                method2 = method3;
                            } catch (IllegalAccessException e7) {
                                e6 = e7;
                            } catch (InvocationTargetException e8) {
                                e6 = e8;
                            }
                        }
                        doPrivileged6 = e6;
                        method = doPrivileged6;
                    }
                    if (doPrivileged6 instanceof Throwable) {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable", (Throwable) doPrivileged6);
                    } else {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available");
                    }
                } else {
                    logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
                    method = null;
                }
                ALLOCATE_ARRAY_METHOD = method2;
                method2 = method;
            } catch (Throwable th3) {
                th = th3;
                j6 = -1;
            }
        }
        INTERNAL_UNSAFE = method2;
        logger.debug("java.nio.DirectByteBuffer.<init>(long, int): {}", DIRECT_BUFFER_CONSTRUCTOR != null ? "available" : "unavailable");
    }

    static int addressSize() {
        return UNSAFE.addressSize();
    }

    static ByteBuffer allocateDirectNoCleaner(int i6) {
        return newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, i6)), i6);
    }

    static long allocateMemory(long j6) {
        return UNSAFE.allocateMemory(j6);
    }

    static byte[] allocateUninitializedArray(int i6) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(i6));
        } catch (IllegalAccessException e6) {
            throw new Error(e6);
        } catch (InvocationTargetException e7) {
            throw new Error(e7);
        }
    }

    static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    static boolean equals(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        boolean z5;
        int i9 = i8 & 7;
        long j6 = BYTE_ARRAY_BASE_OFFSET + i6;
        long j7 = i7 - i6;
        if (i8 >= 8) {
            long j8 = i9 + j6;
            long j9 = 8;
            z5 = false;
            long j10 = (j6 - 8) + i8;
            while (j10 >= j8) {
                Unsafe unsafe = UNSAFE;
                long j11 = j9;
                if (unsafe.getLong(bArr, j10) != unsafe.getLong(bArr2, j10 + j7)) {
                    return false;
                }
                j10 -= j11;
                j9 = j11;
            }
        } else {
            z5 = false;
        }
        if (i9 >= 4) {
            i9 -= 4;
            long j12 = i9 + j6;
            Unsafe unsafe2 = UNSAFE;
            if (unsafe2.getInt(bArr, j12) != unsafe2.getInt(bArr2, j12 + j7)) {
                return z5;
            }
        }
        long j13 = j7 + j6;
        if (i9 < 2) {
            if (i9 != 0) {
                Unsafe unsafe3 = UNSAFE;
                if (unsafe3.getByte(bArr, j6) != unsafe3.getByte(bArr2, j13)) {
                    return z5;
                }
            }
            return true;
        }
        Unsafe unsafe4 = UNSAFE;
        if (unsafe4.getChar(bArr, j6) == unsafe4.getChar(bArr2, j13) && (i9 == 2 || unsafe4.getByte(bArr, j6 + 2) == unsafe4.getByte(bArr2, j13 + 2))) {
            return true;
        }
        return z5;
    }

    static int equalsConstantTime(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        long j6 = i8 & 7;
        long j7 = BYTE_ARRAY_BASE_OFFSET + i6;
        long j8 = j7 + j6;
        long j9 = i7 - i6;
        long j10 = 0;
        for (long j11 = (j7 - 8) + i8; j11 >= j8; j11 -= 8) {
            Unsafe unsafe = UNSAFE;
            j10 |= unsafe.getLong(bArr, j11) ^ unsafe.getLong(bArr2, j11 + j9);
        }
        if (j6 >= 4) {
            Unsafe unsafe2 = UNSAFE;
            j10 |= unsafe2.getInt(bArr2, j7 + j9) ^ unsafe2.getInt(bArr, j7);
            j6 -= 4;
        }
        if (j6 >= 2) {
            long j12 = j8 - j6;
            Unsafe unsafe3 = UNSAFE;
            j10 |= unsafe3.getChar(bArr2, j12 + j9) ^ unsafe3.getChar(bArr, j12);
            j6 -= 2;
        }
        if (j6 == 1) {
            long j13 = j8 - 1;
            Unsafe unsafe4 = UNSAFE;
            j10 |= unsafe4.getByte(bArr, j13) ^ unsafe4.getByte(bArr2, j13 + j9);
        }
        return ConstantTimeUtils.equalsConstantTime(j10, 0L);
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean z5 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z5));
        if (z5) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        String str = SystemPropertyUtil.contains("io.netty.tryUnsafe") ? "io.netty.tryUnsafe" : "org.jboss.netty.tryUnsafe";
        if (SystemPropertyUtil.getBoolean(str, true)) {
            return null;
        }
        String str2 = "sun.misc.Unsafe: unavailable (" + str + ")";
        internalLogger.debug(str2);
        return new UnsupportedOperationException(str2);
    }

    static void freeMemory(long j6) {
        UNSAFE.freeMemory(j6);
    }

    static byte getByte(byte[] bArr, int i6) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + i6);
    }

    static int getInt(long j6) {
        return UNSAFE.getInt(j6);
    }

    static long getLong(long j6) {
        return UNSAFE.getLong(j6);
    }

    static Object getObject(Object obj, long j6) {
        return UNSAFE.getObject(obj, j6);
    }

    static short getShort(byte[] bArr, int i6) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + i6);
    }

    static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    static int hashCodeAscii(byte[] bArr, int i6, int i7) {
        int i8;
        long j6 = BYTE_ARRAY_BASE_OFFSET + i6;
        int i9 = i7 & 7;
        long j7 = i9 + j6;
        int i10 = HASH_CODE_ASCII_SEED;
        for (long j8 = (j6 - 8) + i7; j8 >= j7; j8 -= 8) {
            i10 = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j8), i10);
        }
        if (i9 == 0) {
            return i10;
        }
        boolean z5 = (i9 != 2) & (i9 != 4) & (i9 != 6);
        int i11 = HASH_CODE_C2;
        if (z5) {
            i10 = (i10 * (-862048943)) + hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j6));
            j6++;
            i8 = HASH_CODE_C2;
        } else {
            i8 = -862048943;
        }
        if ((i9 != 5) & (i9 != 1) & (i9 != 4)) {
            i10 = (i10 * i8) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j6));
            if (i8 != -862048943) {
                i11 = -862048943;
            }
            j6 += 2;
            i8 = i11;
        }
        return i9 >= 4 ? (i10 * i8) + hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j6)) : i10;
    }

    static int hashCodeAsciiSanitize(int i6) {
        return i6 & 522133279;
    }

    static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean equals = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (equals) {
            logger.debug("Platform: Android");
        }
        return equals;
    }

    static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    static boolean isUnaligned() {
        return UNALIGNED;
    }

    static boolean isZero(byte[] bArr, int i6, int i7) {
        if (i7 <= 0) {
            return true;
        }
        long j6 = BYTE_ARRAY_BASE_OFFSET + i6;
        int i8 = i7 & 7;
        long j7 = i8 + j6;
        for (long j8 = (j6 - 8) + i7; j8 >= j7; j8 -= 8) {
            if (UNSAFE.getLong(bArr, j8) != 0) {
                return false;
            }
        }
        if (i8 >= 4) {
            i8 -= 4;
            if (UNSAFE.getInt(bArr, i8 + j6) != 0) {
                return false;
            }
        }
        return i8 >= 2 ? UNSAFE.getChar(bArr, j6) == 0 && (i8 == 2 || bArr[i6 + 2] == 0) : bArr[i6] == 0;
    }

    static int javaVersion() {
        return JAVA_VERSION;
    }

    static int majorVersion(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i6 = 0; i6 < split.length; i6++) {
            iArr[i6] = Integer.parseInt(split[i6]);
        }
        int i7 = iArr[0];
        return i7 == 1 ? iArr[1] : i7;
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", cn.bluemobi.dylan.photoview.a.f1297f));
    }

    static ByteBuffer newDirectBuffer(long j6, int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j6), Integer.valueOf(i6));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    static void putByte(byte[] bArr, int i6, byte b6) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + i6, b6);
    }

    static void putInt(byte[] bArr, int i6, int i7) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + i6, i7);
    }

    static void putLong(byte[] bArr, int i6, long j6) {
        UNSAFE.putLong(bArr, BYTE_ARRAY_BASE_OFFSET + i6, j6);
    }

    static void putObject(Object obj, long j6, Object obj2) {
        UNSAFE.putObject(obj, j6, obj2);
    }

    static void putShort(byte[] bArr, int i6, short s5) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + i6, s5);
    }

    static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i6) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i6), i6);
    }

    static long reallocateMemory(long j6, long j7) {
        return UNSAFE.reallocateMemory(j6, j7);
    }

    static void setMemory(Object obj, long j6, long j7, byte b6) {
        UNSAFE.setMemory(obj, j6, j7, b6);
    }

    static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    static boolean unalignedAccess() {
        return UNALIGNED;
    }

    private PlatformDependent0() {
    }

    private static void copyMemoryWithSafePointPolling(Object obj, long j6, Object obj2, long j7, long j8) {
        long j9 = j6;
        long j10 = j7;
        long j11 = j8;
        while (j11 > 0) {
            long min = Math.min(j11, 1048576L);
            UNSAFE.copyMemory(obj, j9, obj2, j10, min);
            j11 -= min;
            j9 += min;
            j10 += min;
        }
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        boolean z5;
        if (javaVersion() < 9) {
            z5 = true;
        } else {
            z5 = false;
        }
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", z5);
    }

    static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    static int getInt(byte[] bArr, int i6) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + i6);
    }

    static long getLong(byte[] bArr, int i6) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + i6);
    }

    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int hashCodeAsciiCompute(long j6, int i6) {
        return (i6 * (-862048943)) + (hashCodeAsciiSanitize((int) j6) * HASH_CODE_C2) + ((int) ((j6 & 2242545357458243584L) >>> 32));
    }

    static int hashCodeAsciiSanitize(short s5) {
        return s5 & 7967;
    }

    private static int javaVersion0() {
        int majorVersionFromJavaSpecificationVersion;
        if (isAndroid0()) {
            majorVersionFromJavaSpecificationVersion = 6;
        } else {
            majorVersionFromJavaSpecificationVersion = majorVersionFromJavaSpecificationVersion();
        }
        logger.debug("Java version: {}", Integer.valueOf(majorVersionFromJavaSpecificationVersion));
        return majorVersionFromJavaSpecificationVersion;
    }

    static void copyMemory(Object obj, long j6, Object obj2, long j7, long j8) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(obj, j6, obj2, j7, j8);
        } else {
            UNSAFE.copyMemory(obj, j6, obj2, j7, j8);
        }
    }
}
