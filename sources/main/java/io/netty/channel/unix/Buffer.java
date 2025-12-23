package io.netty.channel.unix;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Buffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static native int addressSize0();

    private static native long memoryAddress0(ByteBuffer byteBuffer);

    private Buffer() {
    }

    public static int addressSize() {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.addressSize();
        }
        return addressSize0();
    }

    public static ByteBuffer allocateDirectWithNativeOrder(int i6) {
        ByteOrder byteOrder;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i6);
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        return allocateDirect.order(byteOrder);
    }

    public static void free(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    public static long memoryAddress(ByteBuffer byteBuffer) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.directBufferAddress(byteBuffer);
        }
        return memoryAddress0(byteBuffer);
    }
}
