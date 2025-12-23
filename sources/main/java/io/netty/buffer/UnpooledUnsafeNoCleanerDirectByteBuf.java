package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        super(byteBufAllocator, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    protected ByteBuffer allocateDirect(int i6) {
        return PlatformDependent.allocateDirectNoCleaner(i6);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        checkNewCapacity(i6);
        int capacity = capacity();
        if (i6 == capacity) {
            return this;
        }
        ByteBuffer reallocateDirect = reallocateDirect(this.buffer, i6);
        if (i6 < capacity) {
            if (readerIndex() < i6) {
                if (writerIndex() > i6) {
                    writerIndex(i6);
                }
            } else {
                setIndex(i6, i6);
            }
        }
        setByteBuffer(reallocateDirect, false);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }

    ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i6) {
        return PlatformDependent.reallocateDirectNoCleaner(byteBuffer, i6);
    }
}
