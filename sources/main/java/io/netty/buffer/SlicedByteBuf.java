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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class SlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    private int length;

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf capacity(int i6) {
        return super.capacity(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return super.getBytes(i6, fileChannel, j6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        return super.setBytes(i6, inputStream, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        return super.getBytes(i6, gatheringByteChannel, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    final void initLength(int i6) {
        this.length = i6;
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    final int length() {
        return this.length;
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return super.setBytes(i6, fileChannel, j6, i7);
    }

    public SlicedByteBuf(ByteBuf byteBuf, int i6, int i7) {
        super(byteBuf, i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBufAllocator alloc() {
        return super.alloc();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte[] array() {
        return super.array();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int arrayOffset() {
        return super.arrayOffset();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf copy(int i6, int i7) {
        return super.copy(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf duplicate() {
        return super.duplicate();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        return super.forEachByte(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        return super.forEachByteDesc(i6, i7, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte getByte(int i6) {
        return super.getByte(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        return super.getBytes(i6, byteBuf, i7, i8);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ CharSequence getCharSequence(int i6, int i7, Charset charset) {
        return super.getCharSequence(i6, i7, charset);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getInt(int i6) {
        return super.getInt(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getIntLE(int i6) {
        return super.getIntLE(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLong(int i6) {
        return super.getLong(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLongLE(int i6) {
        return super.getLongLE(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShort(int i6) {
        return super.getShort(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShortLE(int i6) {
        return super.getShortLE(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMedium(int i6) {
        return super.getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMediumLE(int i6) {
        return super.getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean hasArray() {
        return super.hasArray();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean hasMemoryAddress() {
        return super.hasMemoryAddress();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean isDirect() {
        return super.isDirect();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long memoryAddress() {
        return super.memoryAddress();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer nioBuffer(int i6, int i7) {
        return super.nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int nioBufferCount() {
        return super.nioBufferCount();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer[] nioBuffers(int i6, int i7) {
        return super.nioBuffers(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    @Deprecated
    public /* bridge */ /* synthetic */ ByteOrder order() {
        return super.order();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setByte(int i6, int i7) {
        return super.setByte(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        return super.setBytes(i6, scatteringByteChannel, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setInt(int i6, int i7) {
        return super.setInt(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setIntLE(int i6, int i7) {
        return super.setIntLE(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLong(int i6, long j6) {
        return super.setLong(i6, j6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLongLE(int i6, long j6) {
        return super.setLongLE(i6, j6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMedium(int i6, int i7) {
        return super.setMedium(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMediumLE(int i6, int i7) {
        return super.setMediumLE(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShort(int i6, int i7) {
        return super.setShort(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShortLE(int i6, int i7) {
        return super.setShortLE(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf slice(int i6, int i7) {
        return super.slice(i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf unwrap() {
        return super.unwrap();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        return super.getBytes(i6, outputStream, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        return super.setBytes(i6, byteBuf, i7, i8);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        return super.getBytes(i6, byteBuffer);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        return super.setBytes(i6, byteBuffer);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        return super.getBytes(i6, bArr, i7, i8);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        return super.setBytes(i6, bArr, i7, i8);
    }
}
