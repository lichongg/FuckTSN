package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ZlibCodecFactory {
    private static final int DEFAULT_JDK_MEM_LEVEL = 8;
    private static final int DEFAULT_JDK_WINDOW_SIZE = 15;
    private static final InternalLogger logger;
    private static final boolean noJdkZlibDecoder;
    private static final boolean noJdkZlibEncoder;
    private static final boolean supportsWindowSizeAndMemLevel;

    public static ZlibDecoder newZlibDecoder() {
        return (PlatformDependent.javaVersion() < 7 || noJdkZlibDecoder) ? new JZlibDecoder() : new JdkZlibDecoder(true);
    }

    public static ZlibEncoder newZlibEncoder(int i6) {
        return (PlatformDependent.javaVersion() < 7 || noJdkZlibEncoder) ? new JZlibEncoder(i6) : new JdkZlibEncoder(i6);
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ZlibCodecFactory.class);
        logger = internalLoggerFactory;
        boolean z5 = true;
        boolean z6 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", PlatformDependent.javaVersion() < 7);
        noJdkZlibDecoder = z6;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(z6));
        boolean z7 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
        noJdkZlibEncoder = z7;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(z7));
        if (!z6 && PlatformDependent.javaVersion() < 7) {
            z5 = false;
        }
        supportsWindowSizeAndMemLevel = z5;
    }

    public static boolean isSupportingWindowSizeAndMemLevel() {
        return supportsWindowSizeAndMemLevel;
    }

    private ZlibCodecFactory() {
    }

    public static ZlibDecoder newZlibDecoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(zlibWrapper, true);
        }
        return new JZlibDecoder(zlibWrapper);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper);
        }
        return new JZlibEncoder(zlibWrapper);
    }

    public static ZlibDecoder newZlibDecoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(bArr);
        }
        return new JZlibDecoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i6) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper, i6);
        }
        return new JZlibEncoder(zlibWrapper, i6);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i6, int i7, int i8) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i7 == 15 && i8 == 8) {
            return new JdkZlibEncoder(zlibWrapper, i6);
        }
        return new JZlibEncoder(zlibWrapper, i6, i7, i8);
    }

    public static ZlibEncoder newZlibEncoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(bArr);
        }
        return new JZlibEncoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i6, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(i6, bArr);
        }
        return new JZlibEncoder(i6, bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i6, int i7, int i8, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i7 == 15 && i8 == 8) {
            return new JdkZlibEncoder(i6, bArr);
        }
        return new JZlibEncoder(i6, i7, i8, bArr);
    }
}
