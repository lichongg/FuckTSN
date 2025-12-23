package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ResourceLeakTracker;
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
final class AdvancedLeakAwareCompositeByteBuf extends SimpleLeakAwareCompositeByteBuf {
    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(byteBufArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(byte b6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(b6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.consolidate();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(byteProcessor);
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    protected /* bridge */ /* synthetic */ SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker resourceLeakTracker) {
        return newLeakAwareByteBuf(byteBuf, byteBuf2, (ResourceLeakTracker<ByteBuf>) resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        this.leak.record();
        return super.release();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(charset);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addFlattenedComponents(boolean z5, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addFlattenedComponents(z5, byteBuf);
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.asReadOnly();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public List<ByteBuf> decompose(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.decompose(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardReadComponents() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadComponents();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.duplicate();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean getBoolean(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBoolean(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public char getChar(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getChar(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i6, int i7, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getCharSequence(i6, i7, charset);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public double getDouble(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getDouble(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public float getFloat(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getFloat(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getIntLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLongLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getMedium(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMedium(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getMediumLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMediumLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShortLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedIntLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShort(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShortLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int indexOf(int i6, int i7, byte b6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.indexOf(i6, i7, b6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.isReadOnly();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, java.lang.Iterable
    public Iterator<ByteBuf> iterator() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.iterator();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    protected AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new AdvancedLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.order(byteOrder);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBoolean();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte readByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readByte();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public char readChar() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readChar();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i6, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readCharSequence(i6, charset);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public double readDouble() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readDouble();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public float readFloat() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readFloat();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readIntLE();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readLong() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLong();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readLongLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLongLE();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMedium();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMediumLE();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readRetainedSlice(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short readShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short readShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShortLE();
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readSlice(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMedium();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponent(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.removeComponent(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponents(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.removeComponents(i6, i7);
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedDuplicate();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int i6, boolean z5) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(i6, z5);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int setCharSequence(int i6, CharSequence charSequence, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setCharSequence(i6, charSequence, charset);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i6, double d6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(i6, d6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i6, float f6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(i6, f6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setIntLE(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i6, long j6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(i6, j6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLongLE(i6, j6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMediumLE(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShortLE(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z5) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(z5);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(d6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeIntLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(j6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLongLE(j6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMediumLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShortLE(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(i6);
    }

    AdvancedLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(compositeByteBuf, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(int i6, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(i6, byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(iterable);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, byte b6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(i6, b6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.consolidate(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(i6, i7);
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        this.leak.record();
        return super.release(i6);
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice(i6, i7);
    }

    @Override // io.netty.buffer.SimpleLeakAwareCompositeByteBuf, io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice(i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString(int i6, int i7, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(i6, i7, charset);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int ensureWritable(int i6, boolean z5) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i6, z5);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean z5, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(z5, byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int i6, ByteBuf... byteBufArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(i6, byteBufArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, int i7, byte b6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(i6, i7, b6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        this.leak.record();
        return super.retain();
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        this.leak.record();
        return this;
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        this.leak.record(obj);
        return this;
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean z5, int i6, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(z5, i6, byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int i6, Iterable<ByteBuf> iterable) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(i6, iterable);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i6) {
        this.leak.record();
        return super.retain(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean z5, ByteBuf... byteBufArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(z5, byteBufArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, byteBuf, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, byteBuf, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean z5, Iterable<ByteBuf> iterable) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(z5, iterable);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, byteBuf, i7, i8);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, byteBuf, i7, i8);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i6) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, byte[] bArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, bArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, byte[] bArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, bArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, bArr, i7, i8);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr, i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, bArr, i7, i8);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(bArr);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, byteBuffer);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, byteBuffer);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i6, int i7) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(bArr, i6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, inputStream, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i6) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, outputStream, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, scatteringByteChannel, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i6) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, gatheringByteChannel, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(fileChannel, j6, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.CompositeByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel, i6);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(fileChannel, j6, i6);
    }
}
