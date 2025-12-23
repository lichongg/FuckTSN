package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PreferredDirectByteBufAllocator implements ByteBufAllocator {
    private ByteBufAllocator allocator;

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.allocator.directBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return this.allocator.compositeHeapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return this.allocator.directBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return this.allocator.heapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return this.allocator.directBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i6) {
        return this.allocator.directBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i6, int i7) {
        return this.allocator.calculateNewCapacity(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i6) {
        return this.allocator.compositeDirectBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i6) {
        return this.allocator.compositeDirectBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i6) {
        return this.allocator.compositeHeapBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i6) {
        return this.allocator.directBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i6) {
        return this.allocator.heapBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i6) {
        return this.allocator.directBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.allocator.isDirectBufferPooled();
    }

    public void updateAllocator(ByteBufAllocator byteBufAllocator) {
        this.allocator = byteBufAllocator;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i6, int i7) {
        return this.allocator.directBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i6, int i7) {
        return this.allocator.directBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i6, int i7) {
        return this.allocator.heapBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i6, int i7) {
        return this.allocator.directBuffer(i6, i7);
    }
}
