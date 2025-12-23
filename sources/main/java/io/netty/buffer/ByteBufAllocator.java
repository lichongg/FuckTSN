package io.netty.buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer();

    ByteBuf buffer(int i6);

    ByteBuf buffer(int i6, int i7);

    int calculateNewCapacity(int i6, int i7);

    CompositeByteBuf compositeBuffer();

    CompositeByteBuf compositeBuffer(int i6);

    CompositeByteBuf compositeDirectBuffer();

    CompositeByteBuf compositeDirectBuffer(int i6);

    CompositeByteBuf compositeHeapBuffer();

    CompositeByteBuf compositeHeapBuffer(int i6);

    ByteBuf directBuffer();

    ByteBuf directBuffer(int i6);

    ByteBuf directBuffer(int i6, int i7);

    ByteBuf heapBuffer();

    ByteBuf heapBuffer(int i6);

    ByteBuf heapBuffer(int i6, int i7);

    ByteBuf ioBuffer();

    ByteBuf ioBuffer(int i6);

    ByteBuf ioBuffer(int i6, int i7);

    boolean isDirectBufferPooled();
}
