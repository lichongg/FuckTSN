package io.netty.buffer;

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
public class UnpooledDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    private ByteBuffer tmpNioBuf;

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        super(i7);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        ObjectUtil.checkPositiveOrZero(i6, "initialCapacity");
        ObjectUtil.checkPositiveOrZero(i7, "maxCapacity");
        if (i6 > i7) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        this.alloc = byteBufAllocator;
        setByteBuffer(allocateDirect(i6), false);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        setByte(i6, (byte) i7);
        setByte(i6 + 1, (byte) (i7 >>> 8));
        setByte(i6 + 2, (byte) (i7 >>> 16));
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkDstIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.setBytes(i7, this, i6, i8);
            return this;
        }
        ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i7, i8);
        for (ByteBuffer byteBuffer : nioBuffers) {
            int remaining = byteBuffer.remaining();
            getBytes(i6, byteBuffer);
            i6 += remaining;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
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
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i6, int i7) {
        checkReadableBytes(i7);
        getBytes(this.readerIndex, bArr, i6, i7, true);
        this.readerIndex += i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.getBytes(i7, this, i6, i8);
            return this;
        }
        ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i7, i8);
        for (ByteBuffer byteBuffer : nioBuffers) {
            int remaining = byteBuffer.remaining();
            setBytes(i6, byteBuffer);
            i6 += remaining;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return this.buffer.get(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return this.buffer.getInt(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return ByteBufUtil.swapInt(this.buffer.getInt(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return this.buffer.getLong(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return ByteBufUtil.swapLong(this.buffer.getLong(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return this.buffer.getShort(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return ByteBufUtil.swapShort(this.buffer.getShort(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        this.buffer.put(i6, (byte) i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        this.buffer.putInt(i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        this.buffer.putInt(i6, ByteBufUtil.swapInt(i7));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        this.buffer.putLong(i6, j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        this.buffer.putLong(i6, ByteBufUtil.swapLong(j6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        setByte(i6, (byte) (i7 >>> 16));
        setByte(i6 + 1, (byte) (i7 >>> 8));
        setByte(i6 + 2, (byte) i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        this.buffer.putShort(i6, (short) i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        this.buffer.putShort(i6, ByteBufUtil.swapShort((short) i7));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        checkNewCapacity(i6);
        int readerIndex = readerIndex();
        int writerIndex = writerIndex();
        int i7 = this.capacity;
        if (i6 > i7) {
            ByteBuffer byteBuffer = this.buffer;
            ByteBuffer allocateDirect = allocateDirect(i6);
            byteBuffer.position(0).limit(byteBuffer.capacity());
            allocateDirect.position(0).limit(byteBuffer.capacity());
            allocateDirect.put(byteBuffer);
            allocateDirect.clear();
            setByteBuffer(allocateDirect, true);
            return this;
        }
        if (i6 < i7) {
            ByteBuffer byteBuffer2 = this.buffer;
            ByteBuffer allocateDirect2 = allocateDirect(i6);
            if (readerIndex < i6) {
                if (writerIndex > i6) {
                    writerIndex(i6);
                } else {
                    i6 = writerIndex;
                }
                byteBuffer2.position(readerIndex).limit(i6);
                allocateDirect2.position(readerIndex).limit(i6);
                allocateDirect2.put(byteBuffer2);
                allocateDirect2.clear();
            } else {
                setIndex(i6, i6);
            }
            setByteBuffer(allocateDirect2, true);
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return;
        }
        this.buffer = null;
        if (this.doNotFree) {
            return;
        }
        freeDirect(byteBuffer);
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    void setByteBuffer(ByteBuffer byteBuffer, boolean z5) {
        ByteBuffer byteBuffer2;
        if (z5 && (byteBuffer2 = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer duplicate = this.buffer.duplicate();
        this.tmpNioBuf = duplicate;
        return duplicate;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return (getByte(i6 + 2) & 255) | ((getByte(i6) & 255) << 16) | ((getByte(i6 + 1) & 255) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return ((getByte(i6 + 2) & 255) << 16) | (getByte(i6) & 255) | ((getByte(i6 + 1) & 255) << 8);
    }

    protected ByteBuffer allocateDirect(int i6) {
        return ByteBuffer.allocateDirect(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        ensureAccessible();
        try {
            return alloc().directBuffer(i7, maxCapacity()).writeBytes((ByteBuffer) this.buffer.duplicate().clear().position(i6).limit(i6 + i7));
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (i6 + i7));
        }
    }

    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
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
    public long getLong(int i6) {
        ensureAccessible();
        return _getLong(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        ensureAccessible();
        return _getShort(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        ensureAccessible();
        return _getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return ((ByteBuffer) this.buffer.duplicate().position(i6).limit(i6 + i7)).slice();
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
    public ByteBuf setLong(int i6, long j6) {
        ensureAccessible();
        _setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        ensureAccessible();
        _setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        ensureAccessible();
        _setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, bArr.length);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i6).limit(i6 + i8);
        internalNioBuffer.put(bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        checkReadableBytes(i6);
        getBytes(this.readerIndex, outputStream, i6, true);
        this.readerIndex += i6;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        getBytes(i6, bArr, i7, i8, false);
        return this;
    }

    protected UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i6) {
        this(byteBufAllocator, byteBuffer, i6, false, true);
    }

    void getBytes(int i6, byte[] bArr, int i7, int i8, boolean z5) {
        ByteBuffer duplicate;
        checkDstIndex(i6, i8, i7, bArr.length);
        if (z5) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i6).limit(i6 + i8);
        duplicate.get(bArr, i7, i8);
    }

    UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i6, boolean z5, boolean z6) {
        super(i6);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (byteBuffer != null) {
            if (byteBuffer.isDirect()) {
                if (!byteBuffer.isReadOnly()) {
                    int remaining = byteBuffer.remaining();
                    if (remaining <= i6) {
                        this.alloc = byteBufAllocator;
                        this.doNotFree = !z5;
                        setByteBuffer((z6 ? byteBuffer.slice() : byteBuffer).order(ByteOrder.BIG_ENDIAN), false);
                        writerIndex(remaining);
                        return;
                    }
                    throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(remaining), Integer.valueOf(i6)));
                }
                throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
            }
            throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
        }
        throw new NullPointerException("initialBuffer");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        checkReadableBytes(i6);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i6, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        internalNioBuffer.clear().position(i6).limit(i6 + byteBuffer.remaining());
        internalNioBuffer.put(byteBuffer);
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
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        getBytes(i6, byteBuffer, false);
        return this;
    }

    void getBytes(int i6, ByteBuffer byteBuffer, boolean z5) {
        ByteBuffer duplicate;
        checkIndex(i6, byteBuffer.remaining());
        if (z5) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i6).limit(i6 + byteBuffer.remaining());
        byteBuffer.put(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        ensureAccessible();
        if (this.buffer.hasArray()) {
            return inputStream.read(this.buffer.array(), this.buffer.arrayOffset() + i6, i7);
        }
        byte[] threadLocalTempArray = ByteBufUtil.threadLocalTempArray(i7);
        int read = inputStream.read(threadLocalTempArray, 0, i7);
        if (read <= 0) {
            return read;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i6);
        internalNioBuffer.put(threadLocalTempArray, 0, read);
        return read;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        getBytes(i6, outputStream, i7, false);
        return this;
    }

    void getBytes(int i6, OutputStream outputStream, int i7, boolean z5) throws IOException {
        ensureAccessible();
        if (i7 == 0) {
            return;
        }
        ByteBufUtil.readBytes(alloc(), z5 ? internalNioBuffer() : this.buffer.duplicate(), i6, i7, outputStream);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        return getBytes(i6, gatheringByteChannel, i7, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i6).limit(i6 + i7);
        try {
            return scatteringByteChannel.read(internalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    private int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7, boolean z5) throws IOException {
        ByteBuffer duplicate;
        ensureAccessible();
        if (i7 == 0) {
            return 0;
        }
        if (z5) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i6).limit(i6 + i7);
        return gatheringByteChannel.write(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i6).limit(i6 + i7);
        try {
            return fileChannel.read(internalNioBuffer, j6);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return getBytes(i6, fileChannel, j6, i7, false);
    }

    private int getBytes(int i6, FileChannel fileChannel, long j6, int i7, boolean z5) throws IOException {
        ensureAccessible();
        if (i7 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = z5 ? internalNioBuffer() : this.buffer.duplicate();
        internalNioBuffer.clear().position(i6).limit(i6 + i7);
        return fileChannel.write(internalNioBuffer, j6);
    }
}
