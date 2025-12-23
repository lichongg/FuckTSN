package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import java.io.IOException;
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
public abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf> {
    public abstract ByteBufAllocator alloc();

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract ByteBuf asReadOnly();

    public abstract int bytesBefore(byte b6);

    public abstract int bytesBefore(int i6, byte b6);

    public abstract int bytesBefore(int i6, int i7, byte b6);

    public abstract int capacity();

    public abstract ByteBuf capacity(int i6);

    public abstract ByteBuf clear();

    @Override // java.lang.Comparable
    public abstract int compareTo(ByteBuf byteBuf);

    public abstract ByteBuf copy();

    public abstract ByteBuf copy(int i6, int i7);

    public abstract ByteBuf discardReadBytes();

    public abstract ByteBuf discardSomeReadBytes();

    public abstract ByteBuf duplicate();

    public abstract int ensureWritable(int i6, boolean z5);

    public abstract ByteBuf ensureWritable(int i6);

    public abstract boolean equals(Object obj);

    public abstract int forEachByte(int i6, int i7, ByteProcessor byteProcessor);

    public abstract int forEachByte(ByteProcessor byteProcessor);

    public abstract int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor);

    public abstract int forEachByteDesc(ByteProcessor byteProcessor);

    public abstract boolean getBoolean(int i6);

    public abstract byte getByte(int i6);

    public abstract int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException;

    public abstract int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException;

    public abstract ByteBuf getBytes(int i6, ByteBuf byteBuf);

    public abstract ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7);

    public abstract ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8);

    public abstract ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException;

    public abstract ByteBuf getBytes(int i6, ByteBuffer byteBuffer);

    public abstract ByteBuf getBytes(int i6, byte[] bArr);

    public abstract ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8);

    public abstract char getChar(int i6);

    public abstract CharSequence getCharSequence(int i6, int i7, Charset charset);

    public abstract double getDouble(int i6);

    public abstract float getFloat(int i6);

    public abstract int getInt(int i6);

    public abstract int getIntLE(int i6);

    public abstract long getLong(int i6);

    public abstract long getLongLE(int i6);

    public abstract int getMedium(int i6);

    public abstract int getMediumLE(int i6);

    public abstract short getShort(int i6);

    public abstract short getShortLE(int i6);

    public abstract short getUnsignedByte(int i6);

    public abstract long getUnsignedInt(int i6);

    public abstract long getUnsignedIntLE(int i6);

    public abstract int getUnsignedMedium(int i6);

    public abstract int getUnsignedMediumLE(int i6);

    public abstract int getUnsignedShort(int i6);

    public abstract int getUnsignedShortLE(int i6);

    public abstract boolean hasArray();

    public abstract boolean hasMemoryAddress();

    public abstract int hashCode();

    public abstract int indexOf(int i6, int i7, byte b6);

    public abstract ByteBuffer internalNioBuffer(int i6, int i7);

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract boolean isReadable();

    public abstract boolean isReadable(int i6);

    public abstract boolean isWritable();

    public abstract boolean isWritable(int i6);

    public abstract ByteBuf markReaderIndex();

    public abstract ByteBuf markWriterIndex();

    public abstract int maxCapacity();

    public abstract int maxWritableBytes();

    public abstract long memoryAddress();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int i6, int i7);

    public abstract int nioBufferCount();

    public abstract ByteBuffer[] nioBuffers();

    public abstract ByteBuffer[] nioBuffers(int i6, int i7);

    @Deprecated
    public abstract ByteBuf order(ByteOrder byteOrder);

    @Deprecated
    public abstract ByteOrder order();

    public abstract boolean readBoolean();

    public abstract byte readByte();

    public abstract int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException;

    public abstract int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException;

    public abstract ByteBuf readBytes(int i6);

    public abstract ByteBuf readBytes(ByteBuf byteBuf);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i6);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i6, int i7);

    public abstract ByteBuf readBytes(OutputStream outputStream, int i6) throws IOException;

    public abstract ByteBuf readBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf readBytes(byte[] bArr);

    public abstract ByteBuf readBytes(byte[] bArr, int i6, int i7);

    public abstract char readChar();

    public abstract CharSequence readCharSequence(int i6, Charset charset);

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract int readInt();

    public abstract int readIntLE();

    public abstract long readLong();

    public abstract long readLongLE();

    public abstract int readMedium();

    public abstract int readMediumLE();

    public abstract ByteBuf readRetainedSlice(int i6);

    public abstract short readShort();

    public abstract short readShortLE();

    public abstract ByteBuf readSlice(int i6);

    public abstract short readUnsignedByte();

    public abstract long readUnsignedInt();

    public abstract long readUnsignedIntLE();

    public abstract int readUnsignedMedium();

    public abstract int readUnsignedMediumLE();

    public abstract int readUnsignedShort();

    public abstract int readUnsignedShortLE();

    public abstract int readableBytes();

    public abstract int readerIndex();

    public abstract ByteBuf readerIndex(int i6);

    public abstract ByteBuf resetReaderIndex();

    public abstract ByteBuf resetWriterIndex();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain(int i6);

    public abstract ByteBuf retainedDuplicate();

    public abstract ByteBuf retainedSlice();

    public abstract ByteBuf retainedSlice(int i6, int i7);

    public abstract ByteBuf setBoolean(int i6, boolean z5);

    public abstract ByteBuf setByte(int i6, int i7);

    public abstract int setBytes(int i6, InputStream inputStream, int i7) throws IOException;

    public abstract int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException;

    public abstract int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException;

    public abstract ByteBuf setBytes(int i6, ByteBuf byteBuf);

    public abstract ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7);

    public abstract ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8);

    public abstract ByteBuf setBytes(int i6, ByteBuffer byteBuffer);

    public abstract ByteBuf setBytes(int i6, byte[] bArr);

    public abstract ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8);

    public abstract ByteBuf setChar(int i6, int i7);

    public abstract int setCharSequence(int i6, CharSequence charSequence, Charset charset);

    public abstract ByteBuf setDouble(int i6, double d6);

    public abstract ByteBuf setFloat(int i6, float f6);

    public abstract ByteBuf setIndex(int i6, int i7);

    public abstract ByteBuf setInt(int i6, int i7);

    public abstract ByteBuf setIntLE(int i6, int i7);

    public abstract ByteBuf setLong(int i6, long j6);

    public abstract ByteBuf setLongLE(int i6, long j6);

    public abstract ByteBuf setMedium(int i6, int i7);

    public abstract ByteBuf setMediumLE(int i6, int i7);

    public abstract ByteBuf setShort(int i6, int i7);

    public abstract ByteBuf setShortLE(int i6, int i7);

    public abstract ByteBuf setZero(int i6, int i7);

    public abstract ByteBuf skipBytes(int i6);

    public abstract ByteBuf slice();

    public abstract ByteBuf slice(int i6, int i7);

    public abstract String toString();

    public abstract String toString(int i6, int i7, Charset charset);

    public abstract String toString(Charset charset);

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch(Object obj);

    public abstract ByteBuf unwrap();

    public abstract int writableBytes();

    public abstract ByteBuf writeBoolean(boolean z5);

    public abstract ByteBuf writeByte(int i6);

    public abstract int writeBytes(InputStream inputStream, int i6) throws IOException;

    public abstract int writeBytes(FileChannel fileChannel, long j6, int i6) throws IOException;

    public abstract int writeBytes(ScatteringByteChannel scatteringByteChannel, int i6) throws IOException;

    public abstract ByteBuf writeBytes(ByteBuf byteBuf);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i6);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7);

    public abstract ByteBuf writeBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf writeBytes(byte[] bArr);

    public abstract ByteBuf writeBytes(byte[] bArr, int i6, int i7);

    public abstract ByteBuf writeChar(int i6);

    public abstract int writeCharSequence(CharSequence charSequence, Charset charset);

    public abstract ByteBuf writeDouble(double d6);

    public abstract ByteBuf writeFloat(float f6);

    public abstract ByteBuf writeInt(int i6);

    public abstract ByteBuf writeIntLE(int i6);

    public abstract ByteBuf writeLong(long j6);

    public abstract ByteBuf writeLongLE(long j6);

    public abstract ByteBuf writeMedium(int i6);

    public abstract ByteBuf writeMediumLE(int i6);

    public abstract ByteBuf writeShort(int i6);

    public abstract ByteBuf writeShortLE(int i6);

    public abstract ByteBuf writeZero(int i6);

    public abstract int writerIndex();

    public abstract ByteBuf writerIndex(int i6);

    public double getDoubleLE(int i6) {
        return Double.longBitsToDouble(getLongLE(i6));
    }

    public float getFloatLE(int i6) {
        return Float.intBitsToFloat(getIntLE(i6));
    }

    boolean isAccessible() {
        if (refCnt() != 0) {
            return true;
        }
        return false;
    }

    public int maxFastWritableBytes() {
        return writableBytes();
    }

    public double readDoubleLE() {
        return Double.longBitsToDouble(readLongLE());
    }

    public float readFloatLE() {
        return Float.intBitsToFloat(readIntLE());
    }

    public ByteBuf setDoubleLE(int i6, double d6) {
        return setLongLE(i6, Double.doubleToRawLongBits(d6));
    }

    public ByteBuf setFloatLE(int i6, float f6) {
        return setIntLE(i6, Float.floatToRawIntBits(f6));
    }

    public ByteBuf writeDoubleLE(double d6) {
        return writeLongLE(Double.doubleToRawLongBits(d6));
    }

    public ByteBuf writeFloatLE(float f6) {
        return writeIntLE(Float.floatToRawIntBits(f6));
    }
}
