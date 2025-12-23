package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultChannelId implements ChannelId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelId.class);
    private static final AtomicInteger nextSequence = new AtomicInteger();
    private static final long serialVersionUID = 3884076183504074063L;
    private final byte[] data;
    private final int hashCode;
    private transient String longValue;
    private transient String shortValue;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int defaultProcessId() {
        /*
            r0 = 1
            r1 = 0
            java.lang.Class<io.netty.channel.DefaultChannelId> r2 = io.netty.channel.DefaultChannelId.class
            java.lang.ClassLoader r2 = io.netty.util.internal.PlatformDependent.getClassLoader(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "java.lang.management.ManagementFactory"
            java.lang.Class r3 = java.lang.Class.forName(r3, r0, r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "java.lang.management.RuntimeMXBean"
            java.lang.Class r4 = java.lang.Class.forName(r4, r0, r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = "getRuntimeMXBean"
            java.lang.Class<?>[] r6 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Method r3 = r3.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r5 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = r3.invoke(r1, r5)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r4 = r4.getMethod(r7, r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L2f
            goto L5d
        L2f:
            r3 = move-exception
            goto L33
        L31:
            r3 = move-exception
            r2 = r1
        L33:
            io.netty.util.internal.logging.InternalLogger r4 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r5 = "Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?"
            r4.debug(r5, r3)
            java.lang.String r3 = "android.os.Process"
            java.lang.Class r0 = java.lang.Class.forName(r3, r0, r2)     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "myPid"
            java.lang.Class<?>[] r3 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L53
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Throwable -> L53
            java.lang.Object[] r2 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L53
            goto L5d
        L53:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r2 = "Could not invoke Process.myPid(); not Android?"
            r1.debug(r2, r0)
            java.lang.String r3 = ""
        L5d:
            r0 = 64
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L6a
            r1 = 0
            java.lang.String r3 = r3.substring(r1, r0)
        L6a:
            int r0 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L6f
            goto L70
        L6f:
            r0 = -1
        L70:
            if (r0 >= 0) goto L85
            java.util.Random r0 = io.netty.util.internal.PlatformDependent.threadLocalRandom()
            int r0 = r0.nextInt()
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r2 = "Failed to find the current process ID from '{}'; using a random value: {}"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r1.warn(r2, r3, r4)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.DefaultChannelId.defaultProcessId():int");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId defaultChannelId = (DefaultChannelId) obj;
        return this.hashCode == defaultChannelId.hashCode && Arrays.equals(this.data, defaultChannelId.data);
    }

    static {
        int i6;
        String str = SystemPropertyUtil.get("io.netty.processId");
        int i7 = -1;
        if (str != null) {
            try {
                i6 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i6 = -1;
            }
            if (i6 < 0) {
                logger.warn("-Dio.netty.processId: {} (malformed)", str);
            } else {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i6));
                }
                i7 = i6;
            }
        }
        if (i7 < 0) {
            i7 = defaultProcessId();
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(i7));
            }
        }
        PROCESS_ID = i7;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        byte[] bArr = null;
        if (str2 != null) {
            try {
                bArr = MacAddressUtil.parseMAC(str2);
            } catch (Exception e6) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2, e6);
            }
            if (bArr != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            }
        }
        if (bArr == null) {
            bArr = MacAddressUtil.defaultMachineId();
            InternalLogger internalLogger3 = logger;
            if (internalLogger3.isDebugEnabled()) {
                internalLogger3.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(bArr));
            }
        }
        MACHINE_ID = bArr;
    }

    private int appendHexDumpField(StringBuilder sb, int i6, int i7) {
        sb.append(ByteBufUtil.hexDump(this.data, i6, i7));
        sb.append('-');
        return i6 + i7;
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    private String newLongValue() {
        StringBuilder sb = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, 0, MACHINE_ID.length), 4), 4), 8), 4);
        return sb.substring(0, sb.length() - 1);
    }

    private int writeInt(int i6, int i7) {
        byte[] bArr = this.data;
        bArr[i6] = (byte) (i7 >>> 24);
        bArr[i6 + 1] = (byte) (i7 >>> 16);
        int i8 = i6 + 3;
        bArr[i6 + 2] = (byte) (i7 >>> 8);
        int i9 = i6 + 4;
        bArr[i8] = (byte) i7;
        return i9;
    }

    private int writeLong(int i6, long j6) {
        byte[] bArr = this.data;
        bArr[i6] = (byte) (j6 >>> 56);
        bArr[i6 + 1] = (byte) (j6 >>> 48);
        bArr[i6 + 2] = (byte) (j6 >>> 40);
        bArr[i6 + 3] = (byte) (j6 >>> 32);
        bArr[i6 + 4] = (byte) (j6 >>> 24);
        bArr[i6 + 5] = (byte) (j6 >>> 16);
        int i7 = i6 + 7;
        bArr[i6 + 6] = (byte) (j6 >>> 8);
        int i8 = i6 + 8;
        bArr[i7] = (byte) j6;
        return i8;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        String str = this.longValue;
        if (str != null) {
            return str;
        }
        String newLongValue = newLongValue();
        this.longValue = newLongValue;
        return newLongValue;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        String str = this.shortValue;
        if (str != null) {
            return str;
        }
        byte[] bArr = this.data;
        String hexDump = ByteBufUtil.hexDump(bArr, bArr.length - 4, 4);
        this.shortValue = hexDump;
        return hexDump;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (this == channelId) {
            return 0;
        }
        if (!(channelId instanceof DefaultChannelId)) {
            return asLongText().compareTo(channelId.asLongText());
        }
        byte[] bArr = ((DefaultChannelId) channelId).data;
        int length = this.data.length;
        int length2 = bArr.length;
        int min = Math.min(length, length2);
        for (int i6 = 0; i6 < min; i6++) {
            byte b6 = this.data[i6];
            byte b7 = bArr[i6];
            if (b6 != b7) {
                return (b6 & 255) - (b7 & 255);
            }
        }
        return length - length2;
    }

    public int hashCode() {
        return this.hashCode;
    }

    private DefaultChannelId() {
        byte[] bArr = MACHINE_ID;
        byte[] bArr2 = new byte[bArr.length + 20];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        writeInt(writeLong(writeInt(writeInt(bArr.length, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        this.hashCode = Arrays.hashCode(bArr2);
    }

    public String toString() {
        return asShortText();
    }
}
