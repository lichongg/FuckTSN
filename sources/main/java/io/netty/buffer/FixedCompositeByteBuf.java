package io.netty.buffer;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY = {Unpooled.EMPTY_BUFFER};
    private final ByteBufAllocator allocator;
    private final ByteBuf[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Component extends WrappedByteBuf {
        private final int endOffset;
        private final int index;
        private final int offset;

        Component(int i6, int i7, ByteBuf byteBuf) {
            super(byteBuf);
            this.index = i6;
            this.offset = i7;
            this.endOffset = i7 + byteBuf.readableBytes();
        }
    }

    private Component findComponent(int i6) {
        Component component;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            ByteBuf[] byteBufArr = this.buffers;
            if (i7 >= byteBufArr.length) {
                throw new IllegalStateException();
            }
            ByteBuf byteBuf = byteBufArr[i7];
            if (byteBuf instanceof Component) {
                Component component2 = (Component) byteBuf;
                component = component2;
                byteBuf = component2.buf;
            } else {
                component = null;
            }
            i8 += byteBuf.readableBytes();
            if (i6 < i8) {
                if (component != null) {
                    return component;
                }
                Component component3 = new Component(i7, i8 - byteBuf.readableBytes(), byteBuf);
                this.buffers[i7] = component3;
                return component3;
            }
            i7++;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        for (int i6 = 0; i6 < this.buffers.length; i6++) {
            buffer(i6).release();
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkDstIndex(i6, i8, i7, bArr.length);
        if (i8 != 0) {
            Component findComponent = findComponent(i6);
            int i9 = findComponent.index;
            int i10 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i11 = i6 - i10;
                int min = Math.min(i8, byteBuf.readableBytes() - i11);
                byteBuf.getBytes(i11, bArr, i7, min);
                i6 += min;
                i7 += min;
                i8 -= min;
                i10 += byteBuf.readableBytes();
                if (i8 <= 0) {
                    break;
                }
                i9++;
                byteBuf = buffer(i9);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    private ByteBuf buffer(int i6) {
        ByteBuf byteBuf = this.buffers[i6];
        return byteBuf instanceof Component ? ((Component) byteBuf).buf : byteBuf;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int length = this.buffers.length;
        if (length == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (length == 1) {
            return buffer(0).array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int length = this.buffers.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return buffer(0).arrayOffset();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int length = this.buffers.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        if (this.buffers.length == 1) {
            return buffer(0).internalNioBuffer(i6, i7);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.direct;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable(int i6) {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (length == 1) {
            return buffer(0).memoryAddress();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        throw new ReadOnlyBufferException();
    }

    FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf... byteBufArr) {
        super(Integer.MAX_VALUE);
        if (byteBufArr.length == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = false;
        } else {
            ByteBuf byteBuf = byteBufArr[0];
            this.buffers = byteBufArr;
            int nioBufferCount = byteBuf.nioBufferCount();
            int readableBytes = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean z5 = true;
            for (int i6 = 1; i6 < byteBufArr.length; i6++) {
                ByteBuf byteBuf2 = byteBufArr[i6];
                if (byteBuf2.order() == this.order) {
                    nioBufferCount += byteBuf2.nioBufferCount();
                    readableBytes += byteBuf2.readableBytes();
                    if (!byteBuf2.isDirect()) {
                        z5 = false;
                    }
                } else {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
            }
            this.nioBufferCount = nioBufferCount;
            this.capacity = readableBytes;
            this.direct = z5;
        }
        setIndex(0, capacity());
        this.allocator = byteBufAllocator;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        Component findComponent = findComponent(i6);
        return findComponent.buf.getByte(i6 - findComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 4 <= findComponent.endOffset) {
            return findComponent.buf.getInt(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i6 + 2) & j1.f43986d) | ((_getShort(i6) & j1.f43986d) << 16);
        }
        return ((_getShort(i6 + 2) & j1.f43986d) << 16) | (_getShort(i6) & j1.f43986d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 4 <= findComponent.endOffset) {
            return findComponent.buf.getIntLE(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i6 + 2) & j1.f43986d) << 16) | (_getShortLE(i6) & j1.f43986d);
        }
        return (_getShortLE(i6 + 2) & j1.f43986d) | ((_getShortLE(i6) & j1.f43986d) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLong(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i6) & 4294967295L) << 32) | (4294967295L & _getInt(i6 + 4));
        }
        return (_getInt(i6) & 4294967295L) | ((4294967295L & _getInt(i6 + 4)) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLongLE(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getIntLE(i6) & 4294967295L) | ((4294967295L & _getIntLE(i6 + 4)) << 32);
        }
        return ((_getIntLE(i6) & 4294967295L) << 32) | (4294967295L & _getIntLE(i6 + 4));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShort(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i6 + 1) & 255) | ((_getByte(i6) & 255) << 8));
        }
        return (short) (((_getByte(i6 + 1) & 255) << 8) | (_getByte(i6) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShortLE(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i6 + 1) & 255) << 8) | (_getByte(i6) & 255));
        }
        return (short) ((_getByte(i6 + 1) & 255) | ((_getByte(i6) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMedium(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i6 + 2) & 255) | ((_getShort(i6) & j1.f43986d) << 8);
        }
        return ((_getByte(i6 + 2) & 255) << 16) | (_getShort(i6) & j1.f43986d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        Component findComponent = findComponent(i6);
        if (i6 + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMediumLE(i6 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i6 + 2) & 255) << 16) | (_getShortLE(i6) & j1.f43986d);
        }
        return (_getByte(i6 + 2) & 255) | ((_getShortLE(i6) & j1.f43986d) << 8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        ByteBuf buffer = alloc().buffer(i7);
        try {
            buffer.writeBytes(this, i6, i7);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        return _getByte(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        if (this.buffers.length == 1) {
            ByteBuf buffer = buffer(0);
            if (buffer.nioBufferCount() == 1) {
                return buffer.nioBuffer(i6, i7);
            }
        }
        ByteBuffer order = ByteBuffer.allocate(i7).order(order());
        for (ByteBuffer byteBuffer : nioBuffers(i6, i7)) {
            order.put(byteBuffer);
        }
        order.flip();
        return order;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        checkIndex(i6, i7);
        if (i7 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(this.buffers.length);
        try {
            Component findComponent = findComponent(i6);
            int i8 = findComponent.index;
            int i9 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i10 = i6 - i9;
                int min = Math.min(i7, byteBuf.readableBytes() - i10);
                int nioBufferCount = byteBuf.nioBufferCount();
                if (nioBufferCount != 0) {
                    if (nioBufferCount != 1) {
                        Collections.addAll(newInstance, byteBuf.nioBuffers(i10, min));
                    } else {
                        newInstance.add(byteBuf.nioBuffer(i10, min));
                    }
                    i6 += min;
                    i7 -= min;
                    i9 += byteBuf.readableBytes();
                    if (i7 <= 0) {
                        ByteBuffer[] byteBufferArr = (ByteBuffer[]) newInstance.toArray(new ByteBuffer[0]);
                        newInstance.recycle();
                        return byteBufferArr;
                    }
                    i8++;
                    byteBuf = buffer(i8);
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        } catch (Throwable th) {
            newInstance.recycle();
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        return super.toString().substring(0, r0.length() - 1) + ", components=" + this.buffers.length + ')';
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i6, remaining);
        if (remaining == 0) {
            return this;
        }
        try {
            Component findComponent = findComponent(i6);
            int i7 = findComponent.index;
            int i8 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i9 = i6 - i8;
                int min = Math.min(remaining, byteBuf.readableBytes() - i9);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.getBytes(i9, byteBuffer);
                i6 += min;
                remaining -= min;
                i8 += byteBuf.readableBytes();
                if (remaining <= 0) {
                    return this;
                }
                i7++;
                byteBuf = buffer(i7);
            }
        } finally {
            byteBuffer.limit(limit);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkDstIndex(i6, i8, i7, byteBuf.capacity());
        if (i8 != 0) {
            Component findComponent = findComponent(i6);
            int i9 = findComponent.index;
            int i10 = findComponent.offset;
            ByteBuf byteBuf2 = findComponent.buf;
            while (true) {
                int i11 = i6 - i10;
                int min = Math.min(i8, byteBuf2.readableBytes() - i11);
                byteBuf2.getBytes(i11, byteBuf, i7, min);
                i6 += min;
                i7 += min;
                i8 -= min;
                i10 += byteBuf2.readableBytes();
                if (i8 <= 0) {
                    break;
                }
                i9++;
                byteBuf2 = buffer(i9);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i6, i7));
        }
        long write = gatheringByteChannel.write(nioBuffers(i6, i7));
        if (write > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) write;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i6, i7), j6);
        }
        long j7 = 0;
        for (int i8 = 0; i8 < nioBuffers(i6, i7).length; i8++) {
            j7 += fileChannel.write(r7[i8], j6 + j7);
        }
        if (j7 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j7;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        checkIndex(i6, i7);
        if (i7 != 0) {
            Component findComponent = findComponent(i6);
            int i8 = findComponent.index;
            int i9 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i10 = i6 - i9;
                int min = Math.min(i7, byteBuf.readableBytes() - i10);
                byteBuf.getBytes(i10, outputStream, min);
                i6 += min;
                i7 -= min;
                i9 += byteBuf.readableBytes();
                if (i7 <= 0) {
                    break;
                }
                i8++;
                byteBuf = buffer(i8);
            }
        }
        return this;
    }
}
