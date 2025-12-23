package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ReplayingDecoderByteBuf extends ByteBuf {
    static final ReplayingDecoderByteBuf EMPTY_BUFFER;
    private static final Signal REPLAY = ReplayingDecoder.REPLAY;
    private ByteBuf buffer;
    private SwappedByteBuf swapped;
    private boolean terminated;

    ReplayingDecoderByteBuf() {
    }

    private void checkIndex(int i6, int i7) {
        if (i6 + i7 > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b6) {
        int bytesBefore = this.buffer.bytesBefore(b6);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        if (this.terminated) {
            return this.buffer.capacity();
        }
        return Integer.MAX_VALUE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        int forEachByte = this.buffer.forEachByte(byteProcessor);
        if (forEachByte >= 0) {
            return forEachByte;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        if (this.terminated) {
            return this.buffer.forEachByteDesc(byteProcessor);
        }
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i6) {
        checkIndex(i6, 1);
        return this.buffer.getBoolean(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        checkIndex(i6, 1);
        return this.buffer.getByte(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkIndex(i6, i8);
        this.buffer.getBytes(i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i6) {
        checkIndex(i6, 2);
        return this.buffer.getChar(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i6) {
        checkIndex(i6, 4);
        return this.buffer.getFloat(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        checkIndex(i6, 4);
        return this.buffer.getInt(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        checkIndex(i6, 4);
        return this.buffer.getIntLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i6) {
        checkIndex(i6, 3);
        return this.buffer.getMedium(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i6) {
        checkIndex(i6, 3);
        return this.buffer.getMediumLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        checkIndex(i6, 2);
        return this.buffer.getShort(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        checkIndex(i6, 2);
        return this.buffer.getShortLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i6) {
        checkIndex(i6, 1);
        return this.buffer.getUnsignedByte(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i6) {
        checkIndex(i6, 4);
        return this.buffer.getUnsignedInt(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i6) {
        checkIndex(i6, 4);
        return this.buffer.getUnsignedIntLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        checkIndex(i6, 3);
        return this.buffer.getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        checkIndex(i6, 3);
        return this.buffer.getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i6) {
        checkIndex(i6, 2);
        return this.buffer.getUnsignedShort(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i6) {
        checkIndex(i6, 2);
        return this.buffer.getUnsignedShortLE(i6);
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
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return !this.terminated || this.buffer.isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.buffer.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        checkReadableBytes(1);
        return this.buffer.readBoolean();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes(1);
        return this.buffer.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i6, int i7) {
        checkReadableBytes(i7);
        this.buffer.readBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        checkReadableBytes(2);
        return this.buffer.readChar();
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        checkReadableBytes(4);
        return this.buffer.readFloat();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes(4);
        return this.buffer.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        checkReadableBytes(4);
        return this.buffer.readIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        checkReadableBytes(3);
        return this.buffer.readMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        checkReadableBytes(3);
        return this.buffer.readMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        checkReadableBytes(2);
        return this.buffer.readShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        checkReadableBytes(1);
        return this.buffer.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.buffer.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        throw reject();
    }

    void terminate() {
        this.terminated = true;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i6, int i7, Charset charset) {
        checkIndex(i6, i7);
        return this.buffer.toString(i6, i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.buffer.writerIndex();
    }

    static {
        ReplayingDecoderByteBuf replayingDecoderByteBuf = new ReplayingDecoderByteBuf(Unpooled.EMPTY_BUFFER);
        EMPTY_BUFFER = replayingDecoderByteBuf;
        replayingDecoderByteBuf.terminate();
    }

    ReplayingDecoderByteBuf(ByteBuf byteBuf) {
        setCumulation(byteBuf);
    }

    private void checkReadableBytes(int i6) {
        if (this.buffer.readableBytes() < i6) {
            throw REPLAY;
        }
    }

    private static UnsupportedOperationException reject() {
        return new UnsupportedOperationException("not a replayable operation");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buffer.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        return this.buffer.copy(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i6, boolean z5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i6) {
        checkIndex(i6, 8);
        return this.buffer.getDouble(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        checkIndex(i6, 8);
        return this.buffer.getLong(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        checkIndex(i6, 8);
        return this.buffer.getLongLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i6, int i7, byte b6) {
        if (i6 == i7) {
            return -1;
        }
        if (Math.max(i6, i7) <= this.buffer.writerIndex()) {
            return this.buffer.indexOf(i6, i7, b6);
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i6) {
        return !this.terminated || this.buffer.isReadable(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i6) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.buffer.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return this.buffer.nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buffer.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        checkIndex(i6, i7);
        return this.buffer.nioBuffers(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swapped;
        if (swappedByteBuf != null) {
            return swappedByteBuf;
        }
        SwappedByteBuf swappedByteBuf2 = new SwappedByteBuf(this);
        this.swapped = swappedByteBuf2;
        return swappedByteBuf2;
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        checkReadableBytes(8);
        return this.buffer.readDouble();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes(8);
        return this.buffer.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        checkReadableBytes(8);
        return this.buffer.readLongLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.terminated ? this.buffer.readableBytes() : Integer.MAX_VALUE - this.buffer.readerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i6) {
        this.buffer.readerIndex(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.buffer.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        this.buffer.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        checkIndex(i6, i7);
        return this.buffer.slice(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr) {
        throw reject();
    }

    void setCumulation(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        checkIndex(i6, i7);
        return this.buffer.slice(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, byte b6) {
        return bytesBefore(this.buffer.readerIndex(), i6, b6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        int writerIndex = this.buffer.writerIndex();
        if (i6 >= writerIndex) {
            throw REPLAY;
        }
        if (i6 <= writerIndex - i7) {
            return this.buffer.forEachByte(i6, i7, byteProcessor);
        }
        int forEachByte = this.buffer.forEachByte(i6, writerIndex - i6, byteProcessor);
        if (forEachByte >= 0) {
            return forEachByte;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr) {
        checkIndex(i6, bArr.length);
        this.buffer.getBytes(i6, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i6, int i7, Charset charset) {
        checkIndex(i6, i7);
        return this.buffer.getCharSequence(i6, i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return this.buffer.internalNioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        checkReadableBytes(bArr.length);
        this.buffer.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i6, Charset charset) {
        checkReadableBytes(i6);
        return this.buffer.readCharSequence(i6, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        checkReadableBytes(i6);
        return this.buffer.readRetainedSlice(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        checkReadableBytes(i6);
        return this.buffer.readSlice(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i6, boolean z5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i6, CharSequence charSequence, Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i6, double d6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i6, float f6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i6) {
        checkReadableBytes(i6);
        this.buffer.skipBytes(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.buffer.touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, int i7, byte b6) {
        int writerIndex = this.buffer.writerIndex();
        if (i6 >= writerIndex) {
            throw REPLAY;
        }
        if (i6 <= writerIndex - i7) {
            return this.buffer.bytesBefore(i6, i7, b6);
        }
        int bytesBefore = this.buffer.bytesBefore(i6, writerIndex - i6, b6);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        if (i6 + i7 <= this.buffer.writerIndex()) {
            return this.buffer.forEachByteDesc(i6, i7, byteProcessor);
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return StringUtil.simpleClassName(this) + "(ridx=" + readerIndex() + ", widx=" + writerIndex() + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buffer.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkIndex(i6, i8);
        this.buffer.getBytes(i6, byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i6, int i7) {
        checkReadableBytes(i7);
        this.buffer.readBytes(byteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        checkReadableBytes(byteBuf.writableBytes());
        this.buffer.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j6, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j6, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i6) {
        checkReadableBytes(i6);
        return this.buffer.readBytes(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i6) {
        throw reject();
    }
}
