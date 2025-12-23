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
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class WrappedCompositeByteBuf extends CompositeByteBuf {
    private final CompositeByteBuf wrapped;

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        this.wrapped.addComponent(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        this.wrapped.addComponents(byteBufArr);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(byte b6) {
        return this.wrapped.bytesBefore(b6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate() {
        this.wrapped.consolidate();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.wrapped.copy();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return this.wrapped.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return this.wrapped.forEachByteDesc(byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        return this.wrapped.isReadable();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean isWritable() {
        return this.wrapped.isWritable();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.wrapped.nioBuffer();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        return this.wrapped.nioBuffers(i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        return this.wrapped.order(byteOrder);
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        return this.wrapped.release();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.wrapped.retainedSlice();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.wrapped.slice();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return this.wrapped.toString(charset);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final byte _getByte(int i6) {
        return this.wrapped._getByte(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getInt(int i6) {
        return this.wrapped._getInt(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getIntLE(int i6) {
        return this.wrapped._getIntLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final long _getLong(int i6) {
        return this.wrapped._getLong(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final long _getLongLE(int i6) {
        return this.wrapped._getLongLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final short _getShort(int i6) {
        return this.wrapped._getShort(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final short _getShortLE(int i6) {
        return this.wrapped._getShortLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMedium(int i6) {
        return this.wrapped._getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMediumLE(int i6) {
        return this.wrapped._getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setByte(int i6, int i7) {
        this.wrapped._setByte(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setInt(int i6, int i7) {
        this.wrapped._setInt(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setIntLE(int i6, int i7) {
        this.wrapped._setIntLE(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setLong(int i6, long j6) {
        this.wrapped._setLong(i6, j6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setLongLE(int i6, long j6) {
        this.wrapped._setLongLE(i6, j6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setMedium(int i6, int i7) {
        this.wrapped._setMedium(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setMediumLE(int i6, int i7) {
        this.wrapped._setMediumLE(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setShort(int i6, int i7) {
        this.wrapped._setShort(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setShortLE(int i6, int i7) {
        this.wrapped._setShortLE(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(int i6, ByteBuf byteBuf) {
        this.wrapped.addComponent(i6, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        this.wrapped.addComponents(iterable);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addFlattenedComponents(boolean z5, ByteBuf byteBuf) {
        this.wrapped.addFlattenedComponents(z5, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.wrapped.alloc();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final byte[] array() {
        return this.wrapped.array();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.wrapped.arrayOffset();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.wrapped.asReadOnly();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, byte b6) {
        return this.wrapped.bytesBefore(i6, b6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.wrapped.capacity();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf clear() {
        this.wrapped.clear();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf, java.lang.Comparable
    public final int compareTo(ByteBuf byteBuf) {
        return this.wrapped.compareTo(byteBuf);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final ByteBuf component(int i6) {
        return this.wrapped.component(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final ByteBuf componentAtOffset(int i6) {
        return this.wrapped.componentAtOffset(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate(int i6, int i7) {
        this.wrapped.consolidate(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        return this.wrapped.copy(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
    public final void deallocate() {
        this.wrapped.deallocate();
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public List<ByteBuf> decompose(int i6, int i7) {
        return this.wrapped.decompose(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        this.wrapped.discardReadBytes();
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardReadComponents() {
        this.wrapped.discardReadComponents();
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        this.wrapped.discardSomeReadBytes();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.wrapped.duplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int ensureWritable(int i6, boolean z5) {
        return this.wrapped.ensureWritable(i6, z5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean equals(Object obj) {
        return this.wrapped.equals(obj);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        return this.wrapped.forEachByte(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        return this.wrapped.forEachByteDesc(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean getBoolean(int i6) {
        return this.wrapped.getBoolean(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        return this.wrapped.getByte(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public char getChar(int i6) {
        return this.wrapped.getChar(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i6, int i7, Charset charset) {
        return this.wrapped.getCharSequence(i6, i7, charset);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public double getDouble(int i6) {
        return this.wrapped.getDouble(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public float getFloat(int i6) {
        return this.wrapped.getFloat(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        return this.wrapped.getInt(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        return this.wrapped.getIntLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        return this.wrapped.getLong(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        return this.wrapped.getLongLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getMedium(int i6) {
        return this.wrapped.getMedium(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getMediumLE(int i6) {
        return this.wrapped.getMediumLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        return this.wrapped.getShort(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        return this.wrapped.getShortLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i6) {
        return this.wrapped.getUnsignedByte(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i6) {
        return this.wrapped.getUnsignedInt(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i6) {
        return this.wrapped.getUnsignedIntLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        return this.wrapped.getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        return this.wrapped.getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i6) {
        return this.wrapped.getUnsignedShort(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i6) {
        return this.wrapped.getUnsignedShortLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return this.wrapped.hasArray();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return this.wrapped.hasMemoryAddress();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int indexOf(int i6, int i7, byte b6) {
        return this.wrapped.indexOf(i6, i7, b6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final ByteBuf internalComponent(int i6) {
        return this.wrapped.internalComponent(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final ByteBuf internalComponentAtOffset(int i6) {
        return this.wrapped.internalComponentAtOffset(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        return this.wrapped.internalNioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf
    final boolean isAccessible() {
        return this.wrapped.isAccessible();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.wrapped.isDirect();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.wrapped.isReadOnly();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean isReadable(int i6) {
        return this.wrapped.isReadable(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean isWritable(int i6) {
        return this.wrapped.isWritable(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, java.lang.Iterable
    public Iterator<ByteBuf> iterator() {
        return this.wrapped.iterator();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf markReaderIndex() {
        this.wrapped.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf markWriterIndex() {
        this.wrapped.markWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return this.wrapped.maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.wrapped.maxFastWritableBytes();
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final int maxNumComponents() {
        return this.wrapped.maxNumComponents();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return this.wrapped.maxWritableBytes();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        return this.wrapped.memoryAddress();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected SwappedByteBuf newSwappedByteBuf() {
        return this.wrapped.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        return this.wrapped.nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.wrapped.nioBufferCount();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.wrapped.nioBuffers();
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final int numComponents() {
        return this.wrapped.numComponents();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.wrapped.order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.wrapped.readBoolean();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.wrapped.readByte();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public char readChar() {
        return this.wrapped.readChar();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i6, Charset charset) {
        return this.wrapped.readCharSequence(i6, charset);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public double readDouble() {
        return this.wrapped.readDouble();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public float readFloat() {
        return this.wrapped.readFloat();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readInt() {
        return this.wrapped.readInt();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readIntLE() {
        return this.wrapped.readIntLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readLong() {
        return this.wrapped.readLong();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readLongLE() {
        return this.wrapped.readLongLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readMedium() {
        return this.wrapped.readMedium();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readMediumLE() {
        return this.wrapped.readMediumLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        return this.wrapped.readRetainedSlice(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short readShort() {
        return this.wrapped.readShort();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short readShortLE() {
        return this.wrapped.readShortLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        return this.wrapped.readSlice(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.wrapped.readUnsignedByte();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return this.wrapped.readUnsignedInt();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return this.wrapped.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        return this.wrapped.readUnsignedMedium();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        return this.wrapped.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return this.wrapped.readUnsignedShort();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return this.wrapped.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readableBytes() {
        return this.wrapped.readableBytes();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return this.wrapped.readerIndex();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.wrapped.refCnt();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.wrapped.release(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponent(int i6) {
        this.wrapped.removeComponent(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponents(int i6, int i7) {
        this.wrapped.removeComponents(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf resetReaderIndex() {
        this.wrapped.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf resetWriterIndex() {
        this.wrapped.resetWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.wrapped.retainedDuplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        return this.wrapped.retainedSlice(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int i6, boolean z5) {
        this.wrapped.setBoolean(i6, z5);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i6, int i7) {
        this.wrapped.setByte(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i6, int i7) {
        this.wrapped.setChar(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int setCharSequence(int i6, CharSequence charSequence, Charset charset) {
        return this.wrapped.setCharSequence(i6, charSequence, charset);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i6, double d6) {
        this.wrapped.setDouble(i6, d6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i6, float f6) {
        this.wrapped.setFloat(i6, f6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf setIndex(int i6, int i7) {
        this.wrapped.setIndex(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i6, int i7) {
        this.wrapped.setInt(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        return this.wrapped.setIntLE(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i6, long j6) {
        this.wrapped.setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        return this.wrapped.setLongLE(i6, j6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i6, int i7) {
        this.wrapped.setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        return this.wrapped.setMediumLE(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i6, int i7) {
        this.wrapped.setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        return this.wrapped.setShortLE(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i6, int i7) {
        this.wrapped.setZero(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i6) {
        this.wrapped.skipBytes(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        return this.wrapped.slice(i6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final int toByteIndex(int i6) {
        return this.wrapped.toByteIndex(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public final int toComponentIndex(int i6) {
        return this.wrapped.toComponentIndex(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString(int i6, int i7, Charset charset) {
        return this.wrapped.toString(i6, i7, charset);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return this.wrapped;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return this.wrapped.writableBytes();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z5) {
        this.wrapped.writeBoolean(z5);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i6) {
        this.wrapped.writeByte(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i6) {
        this.wrapped.writeChar(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.wrapped.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d6) {
        this.wrapped.writeDouble(d6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f6) {
        this.wrapped.writeFloat(f6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i6) {
        this.wrapped.writeInt(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i6) {
        return this.wrapped.writeIntLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j6) {
        this.wrapped.writeLong(j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j6) {
        return this.wrapped.writeLongLE(j6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i6) {
        this.wrapped.writeMedium(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i6) {
        return this.wrapped.writeMediumLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i6) {
        this.wrapped.writeShort(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i6) {
        return this.wrapped.writeShortLE(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i6) {
        this.wrapped.writeZero(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return this.wrapped.writerIndex();
    }

    WrappedCompositeByteBuf(CompositeByteBuf compositeByteBuf) {
        super(compositeByteBuf.alloc());
        this.wrapped = compositeByteBuf;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean z5, ByteBuf byteBuf) {
        this.wrapped.addComponent(z5, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int i6, ByteBuf... byteBufArr) {
        this.wrapped.addComponents(i6, byteBufArr);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, int i7, byte b6) {
        return this.wrapped.bytesBefore(i6, i7, b6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i6) {
        this.wrapped.capacity(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i6) {
        this.wrapped.ensureWritable(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf readerIndex(int i6) {
        this.wrapped.readerIndex(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final String toString() {
        return this.wrapped.toString();
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final CompositeByteBuf writerIndex(int i6) {
        this.wrapped.writerIndex(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean z5, int i6, ByteBuf byteBuf) {
        this.wrapped.addComponent(z5, i6, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int i6, Iterable<ByteBuf> iterable) {
        this.wrapped.addComponents(i6, iterable);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean z5, ByteBuf... byteBufArr) {
        this.wrapped.addComponents(z5, byteBufArr);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i6) {
        this.wrapped.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        this.wrapped.touch();
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean z5, Iterable<ByteBuf> iterable) {
        this.wrapped.addComponents(z5, iterable);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        this.wrapped.retain();
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        this.wrapped.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        this.wrapped.setBytes(i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i6) throws IOException {
        return this.wrapped.writeBytes(inputStream, i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        this.wrapped.getBytes(i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i6) {
        return this.wrapped.readBytes(i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        this.wrapped.setBytes(i6, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i6) throws IOException {
        return this.wrapped.writeBytes(scatteringByteChannel, i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        this.wrapped.getBytes(i6, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        return this.wrapped.readBytes(gatheringByteChannel, i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        this.wrapped.setBytes(i6, byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        return this.wrapped.writeBytes(fileChannel, j6, i6);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        this.wrapped.getBytes(i6, byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        this.wrapped.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        return this.wrapped.setBytes(i6, inputStream, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        this.wrapped.writeBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        return this.wrapped.getBytes(i6, gatheringByteChannel, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i6) {
        this.wrapped.readBytes(byteBuf, i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        return this.wrapped.setBytes(i6, scatteringByteChannel, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i6) {
        this.wrapped.writeBytes(byteBuf, i6);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        this.wrapped.getBytes(i6, outputStream, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i6, int i7) {
        this.wrapped.readBytes(byteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf) {
        this.wrapped.setBytes(i6, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7) {
        this.wrapped.writeBytes(byteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf) {
        this.wrapped.getBytes(i6, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        this.wrapped.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf, int i7) {
        this.wrapped.setBytes(i6, byteBuf, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        this.wrapped.writeBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf, int i7) {
        this.wrapped.getBytes(i6, byteBuf, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i6, int i7) {
        this.wrapped.readBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, byte[] bArr) {
        this.wrapped.setBytes(i6, bArr);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i6, int i7) {
        this.wrapped.writeBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, byte[] bArr) {
        this.wrapped.getBytes(i6, bArr);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        this.wrapped.readBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return this.wrapped.setBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.wrapped.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return this.wrapped.getBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        this.wrapped.readBytes(outputStream, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        return this.wrapped.readBytes(fileChannel, j6, i6);
    }
}
