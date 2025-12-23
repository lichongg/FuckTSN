package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class WrappedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    @Override // io.netty.buffer.UnpooledDirectByteBuf
    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeMemory(this.memoryAddress);
    }

    WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, long j6, int i6, boolean z5) {
        super(byteBufAllocator, PlatformDependent.directBuffer(j6, i6), i6, z5);
    }
}
