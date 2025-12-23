package io.netty.util.internal;

import androidx.collection.ScatterMapKt;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscGrowableAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscUnboundedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.SpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Deque;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PlatformDependent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    public static final boolean BIG_ENDIAN_NATIVE_ORDER;
    private static final int BIT_MODE;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    private static final Cleaner CLEANER;
    private static final boolean DIRECT_BUFFER_PREFERRED;
    private static final AtomicLong DIRECT_MEMORY_COUNTER;
    private static final long DIRECT_MEMORY_LIMIT;
    private static final boolean IS_IVKVM_DOT_NET;
    private static final boolean IS_J9_JVM;
    private static final boolean IS_OSX;
    private static final boolean IS_WINDOWS;
    private static final int MAX_ALLOWED_MPSC_CAPACITY = 1073741824;
    private static final long MAX_DIRECT_MEMORY;
    private static final Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN;
    private static final boolean MAYBE_SUPER_USER;
    private static final int MIN_MAX_MPSC_CAPACITY = 2048;
    private static final int MPSC_CHUNK_SIZE = 1024;
    private static final Cleaner NOOP;
    private static final String NORMALIZED_ARCH;
    private static final String NORMALIZED_OS;
    private static final ThreadLocalRandomProvider RANDOM_PROVIDER;
    private static final File TMPDIR;
    private static final int UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final boolean USE_DIRECT_BUFFER_NO_CLEANER;
    private static final InternalLogger logger;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface ThreadLocalRandomProvider {
        Random current();
    }

    public static void copyMemory(long j6, long j7, long j8) {
        PlatformDependent0.copyMemory(j6, j7, j8);
    }

    private static boolean equalsSafe(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        int i9 = i8 + i6;
        while (i6 < i9) {
            if (bArr[i6] != bArr2[i7]) {
                return false;
            }
            i6++;
            i7++;
        }
        return true;
    }

    public static byte getByte(long j6) {
        return PlatformDependent0.getByte(j6);
    }

    public static int getInt(Object obj, long j6) {
        return PlatformDependent0.getInt(obj, j6);
    }

    public static long getLong(long j6) {
        return PlatformDependent0.getLong(j6);
    }

    public static short getShort(long j6) {
        return PlatformDependent0.getShort(j6);
    }

    public static int hashCodeAscii(byte[] bArr, int i6, int i7) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.hashCodeAscii(bArr, i6, i7) : hashCodeAsciiSafe(bArr, i6, i7);
    }

    private static boolean isZeroSafe(byte[] bArr, int i6, int i7) {
        int i8 = i7 + i6;
        while (i6 < i8) {
            if (bArr[i6] != 0) {
                return false;
            }
            i6++;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
    
        r5 = java.lang.Long.parseLong(r7.group(1));
        r0 = r7.group(2).charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
    
        if (r0 == 'G') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
    
        if (r0 == 'K') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
    
        if (r0 == 'M') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
    
        if (r0 == 'g') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        if (r0 == 'k') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
    
        if (r0 == 'm') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ae, code lost:
    
        r3 = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
    
        r5 = r5 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b4, code lost:
    
        r3 = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
    
        r3 = tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_STEREO_RIGHT;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long maxDirectMemory0() {
        /*
            r0 = 1
            r1 = 0
            r3 = 0
            java.lang.ClassLoader r4 = getSystemClassLoader()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r5 = "java.vm.name"
            java.lang.String r6 = ""
            java.lang.String r5 = io.netty.util.internal.SystemPropertyUtil.get(r5, r6)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r5 = r5.toLowerCase()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = "ibm j9"
            boolean r6 = r5.startsWith(r6)     // Catch: java.lang.Throwable -> L3b
            if (r6 != 0) goto L3f
            java.lang.String r6 = "eclipse openj9"
            boolean r5 = r5.startsWith(r6)     // Catch: java.lang.Throwable -> L3b
            if (r5 != 0) goto L3f
            java.lang.String r5 = "sun.misc.VM"
            java.lang.Class r5 = java.lang.Class.forName(r5, r0, r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = "maxDirectMemory"
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r5 = r5.invoke(r3, r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L3b
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L3b
            goto L40
        L3b:
            goto L3f
        L3d:
            r4 = r3
        L3f:
            r5 = r1
        L40:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L45
            return r5
        L45:
            java.lang.String r7 = "java.lang.management.ManagementFactory"
            java.lang.Class r7 = java.lang.Class.forName(r7, r0, r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r8 = "java.lang.management.RuntimeMXBean"
            java.lang.Class r4 = java.lang.Class.forName(r8, r0, r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r8 = "getRuntimeMXBean"
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r8, r3)     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r7 = r7.invoke(r3, r3)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r8 = "getInputArguments"
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r8, r3)     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r3 = r4.invoke(r7, r3)     // Catch: java.lang.Throwable -> Lbb
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> Lbb
            int r4 = r3.size()     // Catch: java.lang.Throwable -> Lbb
            int r4 = r4 - r0
        L6c:
            if (r4 < 0) goto Lbc
            java.util.regex.Pattern r7 = io.netty.util.internal.PlatformDependent.MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r8 = r3.get(r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch: java.lang.Throwable -> Lbb
            java.util.regex.Matcher r7 = r7.matcher(r8)     // Catch: java.lang.Throwable -> Lbb
            boolean r8 = r7.matches()     // Catch: java.lang.Throwable -> Lbb
            if (r8 != 0) goto L83
            int r4 = r4 + (-1)
            goto L6c
        L83:
            java.lang.String r0 = r7.group(r0)     // Catch: java.lang.Throwable -> Lbb
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lbb
            r0 = 2
            java.lang.String r0 = r7.group(r0)     // Catch: java.lang.Throwable -> Lbb
            r3 = 0
            char r0 = r0.charAt(r3)     // Catch: java.lang.Throwable -> Lbb
            r3 = 71
            if (r0 == r3) goto Lb7
            r3 = 75
            if (r0 == r3) goto Lb4
            r3 = 77
            if (r0 == r3) goto Lae
            r3 = 103(0x67, float:1.44E-43)
            if (r0 == r3) goto Lb7
            r3 = 107(0x6b, float:1.5E-43)
            if (r0 == r3) goto Lb4
            r3 = 109(0x6d, float:1.53E-43)
            if (r0 == r3) goto Lae
            goto Lbc
        Lae:
            r3 = 1048576(0x100000, double:5.180654E-318)
        Lb1:
            long r5 = r5 * r3
            goto Lbc
        Lb4:
            r3 = 1024(0x400, double:5.06E-321)
            goto Lb1
        Lb7:
            r3 = 1073741824(0x40000000, double:5.304989477E-315)
            goto Lb1
        Lbb:
        Lbc:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 > 0) goto Ld4
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            long r5 = r0.maxMemory()
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.PlatformDependent.logger
            java.lang.String r1 = "maxDirectMemory: {} bytes (maybe)"
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r0.debug(r1, r2)
            goto Ldf
        Ld4:
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.PlatformDependent.logger
            java.lang.String r1 = "maxDirectMemory: {} bytes"
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r0.debug(r1, r2)
        Ldf:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.maxDirectMemory0():long");
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap();
    }

    public static <T> Queue<T> newMpscQueue() {
        return Mpsc.newMpscQueue();
    }

    public static void putByte(long j6, byte b6) {
        PlatformDependent0.putByte(j6, b6);
    }

    public static void putInt(long j6, int i6) {
        PlatformDependent0.putInt(j6, i6);
    }

    public static void putLong(long j6, long j7) {
        PlatformDependent0.putLong(j6, j7);
    }

    public static void putShort(long j6, short s5) {
        PlatformDependent0.putShort(j6, s5);
    }

    public static void setMemory(byte[] bArr, int i6, long j6, byte b6) {
        PlatformDependent0.setMemory(bArr, BYTE_ARRAY_BASE_OFFSET + i6, j6, b6);
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            return file.getAbsoluteFile();
        } catch (Exception unused) {
            return file;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AtomicLongCounter extends AtomicLong implements LongCounter {
        private static final long serialVersionUID = 4074772784610639305L;

        private AtomicLongCounter() {
        }

        @Override // io.netty.util.internal.LongCounter
        public void add(long j6) {
            addAndGet(j6);
        }

        @Override // io.netty.util.internal.LongCounter
        public void decrement() {
            decrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public void increment() {
            incrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public long value() {
            return get();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Mpsc {
        private static final boolean USE_MPSC_CHUNKED_ARRAY_QUEUE;

        static <T> Queue<T> newMpscQueue(int i6) {
            int max = Math.max(Math.min(i6, 1073741824), 2048);
            return USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscChunkedArrayQueue(1024, max) : new MpscGrowableAtomicArrayQueue(1024, max);
        }

        static {
            Object obj;
            if (PlatformDependent.hasUnsafe()) {
                obj = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent.Mpsc.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        return UnsafeAccess.UNSAFE;
                    }
                });
            } else {
                obj = null;
            }
            if (obj == null) {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                USE_MPSC_CHUNKED_ARRAY_QUEUE = false;
            } else {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: available");
                USE_MPSC_CHUNKED_ARRAY_QUEUE = true;
            }
        }

        private Mpsc() {
        }

        static <T> Queue<T> newMpscQueue() {
            return USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscUnboundedArrayQueue(1024) : new MpscUnboundedAtomicArrayQueue(1024);
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent.class);
        logger = internalLoggerFactory;
        MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
        IS_WINDOWS = isWindows0();
        IS_OSX = isOsx0();
        IS_J9_JVM = isJ9Jvm0();
        IS_IVKVM_DOT_NET = isIkvmDotNet0();
        CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = !isAndroid();
        UNSAFE_UNAVAILABILITY_CAUSE = unsafeUnavailabilityCause0();
        long maxDirectMemory0 = maxDirectMemory0();
        MAX_DIRECT_MEMORY = maxDirectMemory0;
        BYTE_ARRAY_BASE_OFFSET = byteArrayBaseOffset0();
        TMPDIR = tmpdir0();
        BIT_MODE = bitMode0();
        NORMALIZED_ARCH = normalizeArch(SystemPropertyUtil.get("os.arch", ""));
        NORMALIZED_OS = normalizeOs(SystemPropertyUtil.get("os.name", ""));
        ADDRESS_SIZE = addressSize0();
        boolean z5 = false;
        BIG_ENDIAN_NATIVE_ORDER = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        Cleaner cleaner = new Cleaner() { // from class: io.netty.util.internal.PlatformDependent.1
            @Override // io.netty.util.internal.Cleaner
            public void freeDirectBuffer(ByteBuffer byteBuffer) {
            }
        };
        NOOP = cleaner;
        if (javaVersion() >= 7) {
            RANDOM_PROVIDER = new ThreadLocalRandomProvider() { // from class: io.netty.util.internal.PlatformDependent.2
                @Override // io.netty.util.internal.PlatformDependent.ThreadLocalRandomProvider
                public Random current() {
                    return java.util.concurrent.ThreadLocalRandom.current();
                }
            };
        } else {
            RANDOM_PROVIDER = new ThreadLocalRandomProvider() { // from class: io.netty.util.internal.PlatformDependent.3
                @Override // io.netty.util.internal.PlatformDependent.ThreadLocalRandomProvider
                public Random current() {
                    return ThreadLocalRandom.current();
                }
            };
        }
        long j6 = SystemPropertyUtil.getLong("io.netty.maxDirectMemory", -1L);
        if (j6 != 0 && hasUnsafe() && PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            USE_DIRECT_BUFFER_NO_CLEANER = true;
            if (j6 < 0) {
                if (maxDirectMemory0 <= 0) {
                    DIRECT_MEMORY_COUNTER = null;
                } else {
                    DIRECT_MEMORY_COUNTER = new AtomicLong();
                }
                j6 = maxDirectMemory0;
            } else {
                DIRECT_MEMORY_COUNTER = new AtomicLong();
            }
        } else {
            USE_DIRECT_BUFFER_NO_CLEANER = false;
            DIRECT_MEMORY_COUNTER = null;
        }
        internalLoggerFactory.debug("-Dio.netty.maxDirectMemory: {} bytes", Long.valueOf(j6));
        if (j6 >= 1) {
            maxDirectMemory0 = j6;
        }
        DIRECT_MEMORY_LIMIT = maxDirectMemory0;
        int i6 = SystemPropertyUtil.getInt("io.netty.uninitializedArrayAllocationThreshold", 1024);
        if (javaVersion() < 9 || !PlatformDependent0.hasAllocateArrayMethod()) {
            i6 = -1;
        }
        UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD = i6;
        internalLoggerFactory.debug("-Dio.netty.uninitializedArrayAllocationThreshold: {}", Integer.valueOf(i6));
        MAYBE_SUPER_USER = maybeSuperUser0();
        if (isAndroid()) {
            CLEANER = cleaner;
        } else if (javaVersion() >= 9) {
            CLEANER = CleanerJava9.isSupported() ? new CleanerJava9() : cleaner;
        } else {
            CLEANER = CleanerJava6.isSupported() ? new CleanerJava6() : cleaner;
        }
        Cleaner cleaner2 = CLEANER;
        if (cleaner2 != cleaner && !SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false)) {
            z5 = true;
        }
        DIRECT_BUFFER_PREFERRED = z5;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(true ^ z5));
        }
        if (cleaner2 != cleaner || PlatformDependent0.isExplicitNoUnsafe()) {
            return;
        }
        internalLoggerFactory.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.");
    }

    public static int addressSize() {
        return ADDRESS_SIZE;
    }

    public static byte[] allocateUninitializedArray(int i6) {
        int i7 = UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
        return (i7 < 0 || i7 > i6) ? new byte[i6] : PlatformDependent0.allocateUninitializedArray(i6);
    }

    public static int bitMode() {
        return BIT_MODE;
    }

    private static int bitMode0() {
        int i6 = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
        if (i6 > 0) {
            logger.debug("-Dio.netty.bitMode: {}", Integer.valueOf(i6));
            return i6;
        }
        int i7 = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
        if (i7 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", Integer.valueOf(i7));
            return i7;
        }
        int i8 = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
        if (i8 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", Integer.valueOf(i8));
            return i8;
        }
        String str = SystemPropertyUtil.get("os.arch", "");
        Locale locale = Locale.US;
        String trim = str.toLowerCase(locale).trim();
        if ("amd64".equals(trim) || "x86_64".equals(trim)) {
            i8 = 64;
        } else if ("i386".equals(trim) || "i486".equals(trim) || "i586".equals(trim) || "i686".equals(trim)) {
            i8 = 32;
        }
        if (i8 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(i8), trim);
        }
        Matcher matcher = Pattern.compile("([1-9][0-9]+)-?bit").matcher(SystemPropertyUtil.get("java.vm.name", "").toLowerCase(locale));
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 64;
    }

    public static boolean canEnableTcpNoDelayByDefault() {
        return CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    }

    public static void copyMemory(byte[] bArr, int i6, long j6, long j7) {
        PlatformDependent0.copyMemory(bArr, BYTE_ARRAY_BASE_OFFSET + i6, null, j6, j7);
    }

    private static void decrementMemoryCounter(int i6) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            atomicLong.addAndGet(-i6);
        }
    }

    public static boolean directBufferPreferred() {
        return DIRECT_BUFFER_PREFERRED;
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        CLEANER.freeDirectBuffer(byteBuffer);
    }

    public static byte getByte(byte[] bArr, int i6) {
        return PlatformDependent0.getByte(bArr, i6);
    }

    public static int getInt(long j6) {
        return PlatformDependent0.getInt(j6);
    }

    private static int getIntSafe(byte[] bArr, int i6) {
        int i7;
        int i8;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i7 = (bArr[i6] << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
            i8 = bArr[i6 + 3] & 255;
        } else {
            i7 = (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
            i8 = bArr[i6 + 3] << 24;
        }
        return i8 | i7;
    }

    public static long getLong(byte[] bArr, int i6) {
        return PlatformDependent0.getLong(bArr, i6);
    }

    private static long getLongSafe(byte[] bArr, int i6) {
        long j6;
        long j7;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            j6 = ((bArr[i6 + 6] & 255) << 8) | ((bArr[i6 + 5] & 255) << 16) | ((bArr[i6 + 3] & 255) << 32) | ((bArr[i6 + 1] & 255) << 48) | (bArr[i6] << 56) | ((bArr[i6 + 2] & 255) << 40) | ((bArr[i6 + 4] & 255) << 24);
            j7 = bArr[i6 + 7] & 255;
        } else {
            j6 = ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((bArr[i6 + 6] & 255) << 48);
            j7 = bArr[i6 + 7] << 56;
        }
        return j7 | j6;
    }

    public static short getShort(byte[] bArr, int i6) {
        return PlatformDependent0.getShort(bArr, i6);
    }

    private static short getShortSafe(byte[] bArr, int i6) {
        int i7;
        int i8;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i7 = bArr[i6] << 8;
            i8 = bArr[i6 + 1] & 255;
        } else {
            i7 = bArr[i6] & 255;
            i8 = bArr[i6 + 1] << 8;
        }
        return (short) (i8 | i7);
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    public static boolean hasUnsafe() {
        return UNSAFE_UNAVAILABILITY_CAUSE == null;
    }

    private static int hashCodeAsciiCompute(CharSequence charSequence, int i6, int i7) {
        int hashCodeAsciiSanitizeInt;
        int hashCodeAsciiSanitizeInt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            hashCodeAsciiSanitizeInt = (i7 * ScatterMapKt.MurmurHashC1) + (hashCodeAsciiSanitizeInt(charSequence, i6 + 4) * 461845907);
            hashCodeAsciiSanitizeInt2 = hashCodeAsciiSanitizeInt(charSequence, i6);
        } else {
            hashCodeAsciiSanitizeInt = (i7 * ScatterMapKt.MurmurHashC1) + (hashCodeAsciiSanitizeInt(charSequence, i6) * 461845907);
            hashCodeAsciiSanitizeInt2 = hashCodeAsciiSanitizeInt(charSequence, i6 + 4);
        }
        return hashCodeAsciiSanitizeInt + hashCodeAsciiSanitizeInt2;
    }

    static int hashCodeAsciiSafe(byte[] bArr, int i6, int i7) {
        int i8;
        int hashCodeAsciiSanitize;
        int i9 = i7 & 7;
        int i10 = i6 + i9;
        int i11 = -1028477387;
        for (int i12 = (i6 - 8) + i7; i12 >= i10; i12 -= 8) {
            i11 = PlatformDependent0.hashCodeAsciiCompute(getLongSafe(bArr, i12), i11);
        }
        switch (i9) {
            case 1:
                i8 = i11 * ScatterMapKt.MurmurHashC1;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(bArr[i6]);
                break;
            case 2:
                i8 = i11 * ScatterMapKt.MurmurHashC1;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i6));
                break;
            case 3:
                i8 = ((i11 * ScatterMapKt.MurmurHashC1) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i6])) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i6 + 1));
                break;
            case 4:
                i8 = i11 * ScatterMapKt.MurmurHashC1;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i6));
                break;
            case 5:
                i8 = ((i11 * ScatterMapKt.MurmurHashC1) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i6])) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i6 + 1));
                break;
            case 6:
                i8 = ((i11 * ScatterMapKt.MurmurHashC1) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i6))) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i6 + 2));
                break;
            case 7:
                i8 = ((((i11 * ScatterMapKt.MurmurHashC1) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i6])) * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i6 + 1))) * ScatterMapKt.MurmurHashC1;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i6 + 3));
                break;
            default:
                return i11;
        }
        return i8 + hashCodeAsciiSanitize;
    }

    private static int hashCodeAsciiSanitizeByte(char c6) {
        return c6 & 31;
    }

    private static int hashCodeAsciiSanitizeInt(CharSequence charSequence, int i6) {
        int charAt;
        int charAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            charAt = (charSequence.charAt(i6 + 3) & 31) | ((charSequence.charAt(i6 + 2) & 31) << 8) | ((charSequence.charAt(i6 + 1) & 31) << 16);
            charAt2 = (charSequence.charAt(i6) & 31) << 24;
        } else {
            charAt = ((charSequence.charAt(i6 + 3) & 31) << 24) | ((charSequence.charAt(i6 + 2) & 31) << 16) | ((charSequence.charAt(i6 + 1) & 31) << 8);
            charAt2 = charSequence.charAt(i6) & 31;
        }
        return charAt2 | charAt;
    }

    private static int hashCodeAsciiSanitizeShort(CharSequence charSequence, int i6) {
        int charAt;
        int charAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            charAt = charSequence.charAt(i6 + 1) & 31;
            charAt2 = (charSequence.charAt(i6) & 31) << 8;
        } else {
            charAt = (charSequence.charAt(i6 + 1) & 31) << 8;
            charAt2 = charSequence.charAt(i6) & 31;
        }
        return charAt2 | charAt;
    }

    private static void incrementMemoryCounter(int i6) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            long j6 = i6;
            long addAndGet = atomicLong.addAndGet(j6);
            long j7 = DIRECT_MEMORY_LIMIT;
            if (addAndGet <= j7) {
                return;
            }
            atomicLong.addAndGet(-i6);
            throw new OutOfDirectMemoryError("failed to allocate " + i6 + " byte(s) of direct memory (used: " + (addAndGet - j6) + ", max: " + j7 + ')');
        }
    }

    public static boolean isIkvmDotNet() {
        return IS_IVKVM_DOT_NET;
    }

    private static boolean isIkvmDotNet0() {
        return SystemPropertyUtil.get("java.vm.name", "").toUpperCase(Locale.US).equals("IKVM.NET");
    }

    public static boolean isJ9Jvm() {
        return IS_J9_JVM;
    }

    private static boolean isJ9Jvm0() {
        String lowerCase = SystemPropertyUtil.get("java.vm.name", "").toLowerCase();
        return lowerCase.startsWith("ibm j9") || lowerCase.startsWith("eclipse openj9");
    }

    public static boolean isOsx() {
        return IS_OSX;
    }

    private static boolean isOsx0() {
        String replaceAll = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
        boolean z5 = replaceAll.startsWith("macosx") || replaceAll.startsWith("osx");
        if (z5) {
            logger.debug("Platform: MacOS");
        }
        return z5;
    }

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    private static boolean isWindows0() {
        boolean contains = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).contains("win");
        if (contains) {
            logger.debug("Platform: Windows");
        }
        return contains;
    }

    public static long maxDirectMemory() {
        return DIRECT_MEMORY_LIMIT;
    }

    public static boolean maybeSuperUser() {
        return MAYBE_SUPER_USER;
    }

    private static boolean maybeSuperUser0() {
        String str = SystemPropertyUtil.get("user.name");
        return isWindows() ? "Administrator".equals(str) : "root".equals(str) || "toor".equals(str);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i6) {
        return new ConcurrentHashMap(i6);
    }

    public static <T> Queue<T> newMpscQueue(int i6) {
        return Mpsc.newMpscQueue(i6);
    }

    private static String normalize(String str) {
        return str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    public static String normalizedArch() {
        return NORMALIZED_ARCH;
    }

    public static String normalizedOs() {
        return NORMALIZED_OS;
    }

    public static void putByte(byte[] bArr, int i6, byte b6) {
        PlatformDependent0.putByte(bArr, i6, b6);
    }

    public static void putInt(byte[] bArr, int i6, int i7) {
        PlatformDependent0.putInt(bArr, i6, i7);
    }

    public static void putLong(byte[] bArr, int i6, long j6) {
        PlatformDependent0.putLong(bArr, i6, j6);
    }

    public static void putShort(byte[] bArr, int i6, short s5) {
        PlatformDependent0.putShort(bArr, i6, s5);
    }

    public static void setMemory(long j6, long j7, byte b6) {
        PlatformDependent0.setMemory(j6, j7, b6);
    }

    public static Random threadLocalRandom() {
        return RANDOM_PROVIDER.current();
    }

    public static File tmpdir() {
        return TMPDIR;
    }

    private static File tmpdir0() {
        File directory;
        try {
            directory = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
        } catch (Throwable unused) {
        }
        if (directory != null) {
            logger.debug("-Dio.netty.tmpdir: {}", directory);
            return directory;
        }
        File directory2 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
        if (directory2 != null) {
            logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", directory2);
            return directory2;
        }
        if (isWindows()) {
            File directory3 = toDirectory(System.getenv("TEMP"));
            if (directory3 != null) {
                logger.debug("-Dio.netty.tmpdir: {} (%TEMP%)", directory3);
                return directory3;
            }
            String str = System.getenv("USERPROFILE");
            if (str != null) {
                File directory4 = toDirectory(str + "\\AppData\\Local\\Temp");
                if (directory4 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", directory4);
                    return directory4;
                }
                File directory5 = toDirectory(str + "\\Local Settings\\Temp");
                if (directory5 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", directory5);
                    return directory5;
                }
            }
        } else {
            File directory6 = toDirectory(System.getenv("TMPDIR"));
            if (directory6 != null) {
                logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", directory6);
                return directory6;
            }
        }
        File file = isWindows() ? new File("C:\\Windows\\Temp") : new File("/tmp");
        logger.warn("Failed to get the temporary directory; falling back to: {}", file);
        return file;
    }

    public static boolean useDirectBufferNoCleaner() {
        return USE_DIRECT_BUFFER_NO_CLEANER;
    }

    public static long usedDirectMemory() {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return -1L;
    }

    private PlatformDependent() {
    }

    private static int addressSize0() {
        if (!hasUnsafe()) {
            return -1;
        }
        return PlatformDependent0.addressSize();
    }

    public static ByteBuffer allocateDirectNoCleaner(int i6) {
        incrementMemoryCounter(i6);
        try {
            return PlatformDependent0.allocateDirectNoCleaner(i6);
        } catch (Throwable th) {
            decrementMemoryCounter(i6);
            throwException(th);
            return null;
        }
    }

    public static long allocateMemory(long j6) {
        return PlatformDependent0.allocateMemory(j6);
    }

    private static long byteArrayBaseOffset0() {
        if (!hasUnsafe()) {
            return -1L;
        }
        return PlatformDependent0.byteArrayBaseOffset();
    }

    public static void copyMemory(long j6, byte[] bArr, int i6, long j7) {
        PlatformDependent0.copyMemory(null, j6, bArr, BYTE_ARRAY_BASE_OFFSET + i6, j7);
    }

    public static ByteBuffer directBuffer(long j6, int i6) {
        if (PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            return PlatformDependent0.newDirectBuffer(j6, i6);
        }
        throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent0.directBufferAddress(byteBuffer);
    }

    public static boolean equals(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        if (hasUnsafe() && PlatformDependent0.unalignedAccess()) {
            return PlatformDependent0.equals(bArr, i6, bArr2, i7, i8);
        }
        return equalsSafe(bArr, i6, bArr2, i7, i8);
    }

    public static int equalsConstantTime(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        if (hasUnsafe() && PlatformDependent0.unalignedAccess()) {
            return PlatformDependent0.equalsConstantTime(bArr, i6, bArr2, i7, i8);
        }
        return ConstantTimeUtils.equalsConstantTime(bArr, i6, bArr2, i7, i8);
    }

    public static void freeDirectNoCleaner(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        PlatformDependent0.freeMemory(PlatformDependent0.directBufferAddress(byteBuffer));
        decrementMemoryCounter(capacity);
    }

    public static void freeMemory(long j6) {
        PlatformDependent0.freeMemory(j6);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return PlatformDependent0.getClassLoader(cls);
    }

    public static ClassLoader getContextClassLoader() {
        return PlatformDependent0.getContextClassLoader();
    }

    public static int getInt(byte[] bArr, int i6) {
        return PlatformDependent0.getInt(bArr, i6);
    }

    public static Object getObject(Object obj, long j6) {
        return PlatformDependent0.getObject(obj, j6);
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static boolean hasDirectBufferNoCleanerConstructor() {
        return PlatformDependent0.hasDirectBufferNoCleanerConstructor();
    }

    public static boolean isAndroid() {
        return PlatformDependent0.isAndroid();
    }

    public static boolean isUnaligned() {
        return PlatformDependent0.isUnaligned();
    }

    public static boolean isZero(byte[] bArr, int i6, int i7) {
        if (hasUnsafe() && PlatformDependent0.unalignedAccess()) {
            return PlatformDependent0.isZero(bArr, i6, i7);
        }
        return isZeroSafe(bArr, i6, i7);
    }

    public static int javaVersion() {
        return PlatformDependent0.javaVersion();
    }

    public static <C> Deque<C> newConcurrentDeque() {
        if (javaVersion() < 7) {
            return new LinkedBlockingDeque();
        }
        return new ConcurrentLinkedDeque();
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i6, float f6) {
        return new ConcurrentHashMap(i6, f6);
    }

    public static <T> Queue<T> newFixedMpscQueue(int i6) {
        if (hasUnsafe()) {
            return new MpscArrayQueue(i6);
        }
        return new MpscAtomicArrayQueue(i6);
    }

    public static LongCounter newLongCounter() {
        if (javaVersion() >= 8) {
            return new LongAdderCounter();
        }
        return new AtomicLongCounter();
    }

    public static <T> Queue<T> newSpscQueue() {
        if (hasUnsafe()) {
            return new SpscLinkedQueue();
        }
        return new SpscLinkedAtomicQueue();
    }

    private static String normalizeArch(String str) {
        String normalize = normalize(str);
        if (normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return "x86_64";
        }
        if (normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            return "x86_32";
        }
        if (normalize.matches("^(ia64|itanium64)$")) {
            return "itanium_64";
        }
        if (normalize.matches("^(sparc|sparc32)$")) {
            return "sparc_32";
        }
        if (normalize.matches("^(sparcv9|sparc64)$")) {
            return "sparc_64";
        }
        if (normalize.matches("^(arm|arm32)$")) {
            return "arm_32";
        }
        if ("aarch64".equals(normalize)) {
            return "aarch_64";
        }
        if (normalize.matches("^(ppc|ppc32)$")) {
            return "ppc_32";
        }
        if ("ppc64".equals(normalize)) {
            return "ppc_64";
        }
        if ("ppc64le".equals(normalize)) {
            return "ppcle_64";
        }
        if ("s390".equals(normalize)) {
            return "s390_32";
        }
        if ("s390x".equals(normalize)) {
            return "s390_64";
        }
        return "unknown";
    }

    private static String normalizeOs(String str) {
        String normalize = normalize(str);
        if (normalize.startsWith("aix")) {
            return "aix";
        }
        if (normalize.startsWith("hpux")) {
            return "hpux";
        }
        if (normalize.startsWith("os400") && (normalize.length() <= 5 || !Character.isDigit(normalize.charAt(5)))) {
            return "os400";
        }
        if (normalize.startsWith("linux")) {
            return "linux";
        }
        String str2 = "osx";
        if (!normalize.startsWith("macosx") && !normalize.startsWith("osx")) {
            if (normalize.startsWith("freebsd")) {
                return "freebsd";
            }
            if (normalize.startsWith("openbsd")) {
                return "openbsd";
            }
            if (normalize.startsWith("netbsd")) {
                return "netbsd";
            }
            str2 = "sunos";
            if (!normalize.startsWith("solaris") && !normalize.startsWith("sunos")) {
                if (normalize.startsWith("windows")) {
                    return "windows";
                }
                return "unknown";
            }
        }
        return str2;
    }

    public static long objectFieldOffset(Field field) {
        return PlatformDependent0.objectFieldOffset(field);
    }

    public static void putObject(Object obj, long j6, Object obj2) {
        PlatformDependent0.putObject(obj, j6, obj2);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i6) {
        int capacity = i6 - byteBuffer.capacity();
        incrementMemoryCounter(capacity);
        try {
            return PlatformDependent0.reallocateDirectNoCleaner(byteBuffer, i6);
        } catch (Throwable th) {
            decrementMemoryCounter(capacity);
            throwException(th);
            return null;
        }
    }

    public static long reallocateMemory(long j6, long j7) {
        return PlatformDependent0.reallocateMemory(j6, j7);
    }

    public static void throwException(Throwable th) {
        if (hasUnsafe()) {
            PlatformDependent0.throwException(th);
        } else {
            throwException0(th);
        }
    }

    private static Throwable unsafeUnavailabilityCause0() {
        String str;
        if (isAndroid()) {
            logger.debug("sun.misc.Unsafe: unavailable (Android)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (Android)");
        }
        if (isIkvmDotNet()) {
            logger.debug("sun.misc.Unsafe: unavailable (IKVM.NET)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (IKVM.NET)");
        }
        Throwable unsafeUnavailabilityCause = PlatformDependent0.getUnsafeUnavailabilityCause();
        if (unsafeUnavailabilityCause != null) {
            return unsafeUnavailabilityCause;
        }
        try {
            boolean hasUnsafe = PlatformDependent0.hasUnsafe();
            InternalLogger internalLogger = logger;
            if (hasUnsafe) {
                str = "available";
            } else {
                str = "unavailable";
            }
            internalLogger.debug("sun.misc.Unsafe: {}", str);
            if (hasUnsafe) {
                return null;
            }
            return PlatformDependent0.getUnsafeUnavailabilityCause();
        } catch (Throwable th) {
            logger.trace("Could not determine if Unsafe is available", th);
            return new UnsupportedOperationException("Could not determine if Unsafe is available", th);
        }
    }

    public static int hashCodeAscii(CharSequence charSequence) {
        int i6;
        int length = charSequence.length();
        int i7 = length & 7;
        int i8 = -1028477387;
        if (length >= 32) {
            for (int i9 = length - 8; i9 >= i7; i9 -= 8) {
                i8 = hashCodeAsciiCompute(charSequence, i9, i8);
            }
        } else if (length >= 8) {
            i8 = hashCodeAsciiCompute(charSequence, length - 8, -1028477387);
            if (length >= 16) {
                i8 = hashCodeAsciiCompute(charSequence, length - 16, i8);
                if (length >= 24) {
                    i8 = hashCodeAsciiCompute(charSequence, length - 24, i8);
                }
            }
        }
        if (i7 == 0) {
            return i8;
        }
        boolean z5 = (i7 != 2) & (i7 != 4) & (i7 != 6);
        int i10 = ScatterMapKt.MurmurHashC1;
        if (z5) {
            i8 = (i8 * ScatterMapKt.MurmurHashC1) + hashCodeAsciiSanitizeByte(charSequence.charAt(0));
            i6 = 1;
        } else {
            i6 = 0;
        }
        if ((i7 != 1) & (i7 != 4) & (i7 != 5)) {
            i8 = (i8 * (i6 == 0 ? ScatterMapKt.MurmurHashC1 : 461845907)) + PlatformDependent0.hashCodeAsciiSanitize(hashCodeAsciiSanitizeShort(charSequence, i6));
            i6 += 2;
        }
        if (i7 < 4) {
            return i8;
        }
        if (!((i6 == 0) | (i6 == 3))) {
            i10 = 461845907;
        }
        return (i8 * i10) + hashCodeAsciiSanitizeInt(charSequence, i6);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i6, float f6, int i7) {
        return new ConcurrentHashMap(i6, f6, i7);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(Map<? extends K, ? extends V> map) {
        return new ConcurrentHashMap(map);
    }

    private static <E extends Throwable> void throwException0(Throwable th) throws Throwable {
        throw th;
    }
}
