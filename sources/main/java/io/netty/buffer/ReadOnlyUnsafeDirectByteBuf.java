package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkIndex(i6, i8);
        if (byteBuf == null) {
            throw new NullPointerException("dst");
        }
        if (i7 < 0 || i7 > byteBuf.capacity() - i8) {
            throw new IndexOutOfBoundsException("dstIndex: " + i7);
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(addr(i6), i7 + byteBuf.memoryAddress(), i8);
            return this;
        }
        if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(addr(i6), byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        byteBuf.setBytes(i7, this, i6, i8);
        return this;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    private long addr(int i6) {
        return this.memoryAddress + i6;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.memoryAddress;
    }

    ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = PlatformDependent.directBufferAddress(this.buffer);
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return UnsafeByteBufUtil.getByte(addr(i6));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return UnsafeByteBufUtil.getInt(addr(i6));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return UnsafeByteBufUtil.getLong(addr(i6));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return UnsafeByteBufUtil.getShort(addr(i6));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i6));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        ByteBuf directBuffer = alloc().directBuffer(i7, maxCapacity());
        if (i7 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i6), directBuffer.memoryAddress(), i7);
                directBuffer.setIndex(0, i7);
                return directBuffer;
            }
            directBuffer.writeBytes(this, i6, i7);
        }
        return directBuffer;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkIndex(i6, i8);
        if (bArr != null) {
            if (i7 < 0 || i7 > bArr.length - i8) {
                throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(bArr.length)));
            }
            if (i8 != 0) {
                PlatformDependent.copyMemory(addr(i6), bArr, i7, i8);
            }
            return this;
        }
        throw new NullPointerException("dst");
    }
}
