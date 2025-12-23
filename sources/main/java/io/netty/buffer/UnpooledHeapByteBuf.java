package io.netty.buffer;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UnpooledHeapByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    byte[] array;
    private ByteBuffer tmpNioBuf;

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        super(i7);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        if (i6 > i7) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        this.alloc = byteBufAllocator;
        setArray(allocateArray(i6));
        setIndex(0, 0);
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.array.length;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkDstIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(this.array, i6, byteBuf.memoryAddress() + i7, i8);
            return this;
        }
        if (byteBuf.hasArray()) {
            getBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        byteBuf.setBytes(i7, this.array, i6, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return (ByteBuffer) internalNioBuffer().clear().position(i6).limit(i6 + i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        checkReadableBytes(i6);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i6, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + i7, this.array, i6, i8);
            return this;
        }
        if (byteBuf.hasArray()) {
            setBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        byteBuf.getBytes(i7, this.array, i6, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    private void setArray(byte[] bArr) {
        this.array = bArr;
        this.tmpNioBuf = null;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return HeapByteBufUtil.getByte(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return HeapByteBufUtil.getInt(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return HeapByteBufUtil.getIntLE(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return HeapByteBufUtil.getLong(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return HeapByteBufUtil.getLongLE(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return HeapByteBufUtil.getShort(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return HeapByteBufUtil.getShortLE(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return HeapByteBufUtil.getUnsignedMedium(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return HeapByteBufUtil.getUnsignedMediumLE(this.array, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        HeapByteBufUtil.setByte(this.array, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        HeapByteBufUtil.setInt(this.array, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        HeapByteBufUtil.setIntLE(this.array, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        HeapByteBufUtil.setLong(this.array, i6, j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        HeapByteBufUtil.setLongLE(this.array, i6, j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        HeapByteBufUtil.setMedium(this.array, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        HeapByteBufUtil.setMediumLE(this.array, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        HeapByteBufUtil.setShort(this.array, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        HeapByteBufUtil.setShortLE(this.array, i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    protected byte[] allocateArray(int i6) {
        return new byte[i6];
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        checkNewCapacity(i6);
        byte[] bArr = this.array;
        int length = bArr.length;
        if (i6 > length) {
            byte[] allocateArray = allocateArray(i6);
            System.arraycopy(bArr, 0, allocateArray, 0, bArr.length);
            setArray(allocateArray);
            freeArray(bArr);
            return this;
        }
        if (i6 < length) {
            byte[] allocateArray2 = allocateArray(i6);
            int readerIndex = readerIndex();
            if (readerIndex < i6) {
                int writerIndex = writerIndex();
                if (writerIndex > i6) {
                    writerIndex(i6);
                } else {
                    i6 = writerIndex;
                }
                System.arraycopy(bArr, readerIndex, allocateArray2, readerIndex, i6 - readerIndex);
            } else {
                setIndex(i6, i6);
            }
            setArray(allocateArray2);
            freeArray(bArr);
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        freeArray(this.array);
        this.array = EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.array);
        this.tmpNioBuf = wrap;
        return wrap;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        ensureAccessible();
        return this.array;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i7);
        System.arraycopy(this.array, i6, allocateUninitializedArray, 0, i7);
        return new UnpooledHeapByteBuf(alloc(), allocateUninitializedArray, maxCapacity());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        ensureAccessible();
        return _getByte(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        ensureAccessible();
        return _getInt(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        ensureAccessible();
        return _getIntLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        ensureAccessible();
        return _getLong(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        ensureAccessible();
        return _getLongLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        ensureAccessible();
        return _getShort(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        ensureAccessible();
        return _getShortLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        ensureAccessible();
        return _getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        ensureAccessible();
        return _getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        ensureAccessible();
        return ByteBuffer.wrap(this.array, i6, i7).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        return new ByteBuffer[]{nioBuffer(i6, i7)};
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        ensureAccessible();
        _setByte(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        ensureAccessible();
        _setInt(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        ensureAccessible();
        _setIntLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        ensureAccessible();
        _setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        ensureAccessible();
        _setLongLE(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        ensureAccessible();
        _setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        ensureAccessible();
        _setMediumLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        ensureAccessible();
        _setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        ensureAccessible();
        _setShortLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        checkReadableBytes(i6);
        int bytes = getBytes(this.readerIndex, fileChannel, j6, i6, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkDstIndex(i6, i8, i7, bArr.length);
        System.arraycopy(this.array, i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, bArr.length);
        System.arraycopy(bArr, i7, this.array, i6, i8);
        return this;
    }

    protected UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, byte[] bArr, int i6) {
        super(i6);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNull(bArr, "initialArray");
        if (bArr.length <= i6) {
            this.alloc = byteBufAllocator;
            setArray(bArr);
            setIndex(0, bArr.length);
            return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(bArr.length), Integer.valueOf(i6)));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.put(this.array, i6, byteBuffer.remaining());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.get(this.array, i6, byteBuffer.remaining());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        ensureAccessible();
        outputStream.write(this.array, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        ensureAccessible();
        return inputStream.read(this.array, i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        ensureAccessible();
        return getBytes(i6, gatheringByteChannel, i7, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        ensureAccessible();
        try {
            return scatteringByteChannel.read((ByteBuffer) internalNioBuffer().clear().position(i6).limit(i6 + i7));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        ensureAccessible();
        return getBytes(i6, fileChannel, j6, i7, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        ensureAccessible();
        try {
            return fileChannel.read((ByteBuffer) internalNioBuffer().clear().position(i6).limit(i6 + i7), j6);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    private int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7, boolean z5) throws IOException {
        ByteBuffer wrap;
        ensureAccessible();
        if (z5) {
            wrap = internalNioBuffer();
        } else {
            wrap = ByteBuffer.wrap(this.array);
        }
        return gatheringByteChannel.write((ByteBuffer) wrap.clear().position(i6).limit(i6 + i7));
    }

    private int getBytes(int i6, FileChannel fileChannel, long j6, int i7, boolean z5) throws IOException {
        ensureAccessible();
        return fileChannel.write((ByteBuffer) (z5 ? internalNioBuffer() : ByteBuffer.wrap(this.array)).clear().position(i6).limit(i6 + i7), j6);
    }

    protected void freeArray(byte[] bArr) {
    }
}
