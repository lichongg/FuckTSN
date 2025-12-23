package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.MathUtil;
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
abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        checkIndex0(i6, 1);
        return unwrap().getByte(idx(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkIndex0(i6, i8);
        unwrap().getBytes(idx(i6), byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        checkIndex0(i6, 4);
        return unwrap().getInt(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        checkIndex0(i6, 4);
        return unwrap().getIntLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        checkIndex0(i6, 2);
        return unwrap().getShort(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        checkIndex0(i6, 2);
        return unwrap().getShortLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        checkIndex0(i6, 3);
        return unwrap().getUnsignedMedium(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        checkIndex0(i6, 3);
        return unwrap().getUnsignedMediumLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        checkIndex0(i6, 1);
        unwrap().setByte(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        checkIndex0(i6, i8);
        unwrap().setBytes(idx(i6), bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        checkIndex0(i6, 4);
        unwrap().setInt(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        checkIndex0(i6, 4);
        unwrap().setIntLE(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        checkIndex0(i6, 3);
        unwrap().setMedium(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        checkIndex0(i6, 3);
        unwrap().setMediumLE(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        checkIndex0(i6, 2);
        unwrap().setShort(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        checkIndex0(i6, 2);
        unwrap().setShortLE(idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i6) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        checkIndex0(i6, 8);
        return unwrap().getLong(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        checkIndex0(i6, 8);
        return unwrap().getLongLE(idx(i6));
    }

    final int idx(int i6) {
        return i6 + this.adjustment;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        checkIndex0(i6, 8);
        unwrap().setLong(idx(i6), j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        checkIndex0(i6, 8);
        unwrap().setLongLE(idx(i6), j6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf, int i6, int i7) {
        super(i7);
        checkSliceOutOfBounds(i6, i7, byteBuf);
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            AbstractUnpooledSlicedByteBuf abstractUnpooledSlicedByteBuf = (AbstractUnpooledSlicedByteBuf) byteBuf;
            this.buffer = abstractUnpooledSlicedByteBuf.buffer;
            this.adjustment = abstractUnpooledSlicedByteBuf.adjustment + i6;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i6;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i6;
        }
        initLength(i7);
        writerIndex(i7);
    }

    static void checkSliceOutOfBounds(int i6, int i7, ByteBuf byteBuf) {
        if (!MathUtil.isOutOfBounds(i6, i7, byteBuf.capacity())) {
            return;
        }
        throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i6 + ", " + i7 + ')');
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return unwrap().getByte(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return unwrap().getInt(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return unwrap().getIntLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return unwrap().getLong(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return unwrap().getLongLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return unwrap().getShort(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return unwrap().getShortLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return unwrap().getUnsignedMedium(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return unwrap().getUnsignedMediumLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        unwrap().setByte(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        unwrap().setInt(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        unwrap().setIntLE(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        unwrap().setLong(idx(i6), j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        unwrap().setLongLE(idx(i6), j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        unwrap().setMedium(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        unwrap().setMediumLE(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        unwrap().setShort(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        unwrap().setShortLE(idx(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex0(i6, i7);
        return unwrap().copy(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return unwrap().duplicate().setIndex(idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        checkIndex0(i6, i7);
        int forEachByte = unwrap().forEachByte(idx(i6), i7, byteProcessor);
        int i8 = this.adjustment;
        if (forEachByte >= i8) {
            return forEachByte - i8;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        checkIndex0(i6, i7);
        int forEachByteDesc = unwrap().forEachByteDesc(idx(i6), i7, byteProcessor);
        int i8 = this.adjustment;
        if (forEachByteDesc >= i8) {
            return forEachByteDesc - i8;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkIndex0(i6, i8);
        unwrap().getBytes(idx(i6), bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i6, int i7, Charset charset) {
        checkIndex0(i6, i7);
        return unwrap().getCharSequence(idx(i6), i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    int length() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + this.adjustment;
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        checkIndex0(i6, i7);
        return unwrap().nioBuffer(idx(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        checkIndex0(i6, i7);
        return unwrap().nioBuffers(idx(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkIndex0(i6, i8);
        unwrap().setBytes(idx(i6), byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        checkIndex0(i6, i7);
        return unwrap().slice(idx(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        checkIndex0(i6, byteBuffer.remaining());
        unwrap().getBytes(idx(i6), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        checkIndex0(i6, byteBuffer.remaining());
        unwrap().setBytes(idx(i6), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        checkIndex0(i6, i7);
        unwrap().getBytes(idx(i6), outputStream, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        checkIndex0(i6, i7);
        return unwrap().setBytes(idx(i6), inputStream, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        checkIndex0(i6, i7);
        return unwrap().getBytes(idx(i6), gatheringByteChannel, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        checkIndex0(i6, i7);
        return unwrap().setBytes(idx(i6), scatteringByteChannel, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        checkIndex0(i6, i7);
        return unwrap().getBytes(idx(i6), fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        checkIndex0(i6, i7);
        return unwrap().setBytes(idx(i6), fileChannel, j6, i7);
    }

    void initLength(int i6) {
    }
}
