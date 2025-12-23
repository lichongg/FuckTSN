package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class SwappedByteBuf extends ByteBuf {
    private final ByteBuf buf;
    private final ByteOrder order;

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b6) {
        return this.buf.bytesBefore(b6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.buf.capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.buf.copy().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i6) {
        this.buf.ensureWritable(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return this.buf.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf) {
        this.buf.getBytes(i6, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.buf.isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return this.buf.isWritable();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        ByteBuffer[] nioBuffers = this.buf.nioBuffers();
        for (int i6 = 0; i6 < nioBuffers.length; i6++) {
            nioBuffers[i6] = nioBuffers[i6].order(this.order);
        }
        return nioBuffers;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i6) {
        return this.buf.readBytes(i6).order(order());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.buf.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.buf.release();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf) {
        this.buf.setBytes(i6, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.buf.slice().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return this.buf.toString(charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.buf.writerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, byte b6) {
        return this.buf.bytesBefore(i6, b6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        this.buf.capacity(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        return this.buf.copy(i6, i7).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        this.buf.discardReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.buf.duplicate().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i6, boolean z5) {
        return this.buf.ensureWritable(i6, z5);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ByteBuf) {
            return ByteBufUtil.equals(this, (ByteBuf) obj);
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        return this.buf.forEachByte(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i6) {
        return this.buf.getBoolean(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        return this.buf.getByte(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7) {
        this.buf.getBytes(i6, byteBuf, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i6, int i7, Charset charset) {
        return this.buf.getCharSequence(i6, i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        return ByteBufUtil.swapInt(this.buf.getInt(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        return this.buf.getInt(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        return ByteBufUtil.swapLong(this.buf.getLong(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        return this.buf.getLong(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i6) {
        return ByteBufUtil.swapMedium(this.buf.getMedium(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i6) {
        return this.buf.getMedium(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        return ByteBufUtil.swapShort(this.buf.getShort(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        return this.buf.getShort(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i6) {
        return this.buf.getUnsignedByte(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return this.buf.hashCode();
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i6, int i7, byte b6) {
        return this.buf.indexOf(i6, i7, b6);
    }

    @Override // io.netty.buffer.ByteBuf
    final boolean isAccessible() {
        return this.buf.isAccessible();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buf.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i6) {
        return this.buf.isReadable(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i6) {
        return this.buf.isWritable(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        this.buf.markWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.buf.maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.buf.maxFastWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.buf.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        return this.buf.nioBuffer(i6, i7).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder != null) {
            return byteOrder == this.order ? this : this.buf;
        }
        throw new NullPointerException("endianness");
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.buf.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.buf.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i6, Charset charset) {
        return this.buf.readCharSequence(i6, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        return ByteBufUtil.swapInt(this.buf.readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        return this.buf.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        return ByteBufUtil.swapLong(this.buf.readLong());
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        return this.buf.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        return ByteBufUtil.swapMedium(this.buf.readMedium());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        return this.buf.readMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        return this.buf.readRetainedSlice(i6).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        return ByteBufUtil.swapShort(this.buf.readShort());
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        return this.buf.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        return this.buf.readSlice(i6).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i6) {
        this.buf.readerIndex(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.buf.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.buf.release(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        this.buf.resetWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        return this.buf.retainedSlice(i6, i7).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i6, boolean z5) {
        this.buf.setBoolean(i6, z5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        this.buf.setByte(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7) {
        this.buf.setBytes(i6, byteBuf, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i6, CharSequence charSequence, Charset charset) {
        return this.buf.setCharSequence(i6, charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i6, int i7) {
        this.buf.setIndex(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        this.buf.setInt(i6, ByteBufUtil.swapInt(i7));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        this.buf.setInt(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        this.buf.setLong(i6, ByteBufUtil.swapLong(j6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        this.buf.setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        this.buf.setMedium(i6, ByteBufUtil.swapMedium(i7));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        this.buf.setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        this.buf.setShort(i6, ByteBufUtil.swapShort((short) i7));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        this.buf.setShort(i6, (short) i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i6, int i7) {
        this.buf.setZero(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i6) {
        this.buf.skipBytes(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        return this.buf.slice(i6, i7).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i6, int i7, Charset charset) {
        return this.buf.toString(i6, i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return this.buf.writableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z5) {
        this.buf.writeBoolean(z5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i6) {
        this.buf.writeByte(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i6) {
        this.buf.writeBytes(byteBuf, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.buf.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i6) {
        this.buf.writeInt(ByteBufUtil.swapInt(i6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i6) {
        this.buf.writeInt(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j6) {
        this.buf.writeLong(ByteBufUtil.swapLong(j6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j6) {
        this.buf.writeLong(j6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i6) {
        this.buf.writeMedium(ByteBufUtil.swapMedium(i6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i6) {
        this.buf.writeMedium(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i6) {
        this.buf.writeShort(ByteBufUtil.swapShort((short) i6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i6) {
        this.buf.writeShort((short) i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i6) {
        this.buf.writeZero(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i6) {
        this.buf.writerIndex(i6);
        return this;
    }

    public SwappedByteBuf(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.buf = byteBuf;
            ByteOrder order = byteBuf.order();
            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
            if (order == byteOrder) {
                this.order = ByteOrder.LITTLE_ENDIAN;
                return;
            } else {
                this.order = byteOrder;
                return;
            }
        }
        throw new NullPointerException("buf");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, int i7, byte b6) {
        return this.buf.bytesBefore(i6, i7, b6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        this.buf.getBytes(i6, byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i6) {
        return (char) getShort(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i6) {
        return Double.longBitsToDouble(getLong(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i6) {
        return Float.intBitsToFloat(getInt(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i6) {
        return getInt(i6) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i6) {
        return getIntLE(i6) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        return getMedium(i6) & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        return getMediumLE(i6) & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i6) {
        return getShort(i6) & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i6) {
        return getShortLE(i6) & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        return nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i6) {
        this.buf.readBytes(byteBuf, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        return (char) readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return readInt() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return readIntLE() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        return readMedium() & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        return readMediumLE() & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return readShortLE() & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        this.buf.setBytes(i6, byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i6, int i7) {
        setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i6, double d6) {
        setLong(i6, Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i6, float f6) {
        setInt(i6, Float.floatToRawIntBits(f6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return "Swapped(" + this.buf + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.buf.touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7) {
        this.buf.writeBytes(byteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i6) {
        writeShort(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d6) {
        writeLong(Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f6) {
        writeInt(Float.floatToRawIntBits(f6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr) {
        this.buf.getBytes(i6, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        ByteBuffer[] nioBuffers = this.buf.nioBuffers(i6, i7);
        for (int i8 = 0; i8 < nioBuffers.length; i8++) {
            nioBuffers[i8] = nioBuffers[i8].order(this.order);
        }
        return nioBuffers;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i6, int i7) {
        this.buf.readBytes(byteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i6) {
        this.buf.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr) {
        this.buf.setBytes(i6, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buf.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        this.buf.writeBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        this.buf.getBytes(i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        this.buf.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        this.buf.setBytes(i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i6, int i7) {
        this.buf.writeBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        this.buf.getBytes(i6, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i6, int i7) {
        this.buf.readBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        this.buf.setBytes(i6, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.buf.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        this.buf.getBytes(i6, outputStream, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        return this.buf.setBytes(i6, inputStream, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i6) throws IOException {
        return this.buf.writeBytes(inputStream, i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        return this.buf.getBytes(i6, gatheringByteChannel, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        this.buf.readBytes(outputStream, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        return this.buf.setBytes(i6, scatteringByteChannel, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i6) throws IOException {
        return this.buf.writeBytes(scatteringByteChannel, i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return this.buf.getBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        return this.buf.readBytes(gatheringByteChannel, i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return this.buf.setBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        return this.buf.writeBytes(fileChannel, j6, i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        return this.buf.readBytes(fileChannel, j6, i6);
    }
}
