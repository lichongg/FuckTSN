package io.netty.buffer;

import io.netty.buffer.CompositeByteBuf;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Unpooled {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBufAllocator ALLOC;
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN;

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static CompositeByteBuf compositeBuffer() {
        return compositeBuffer(16);
    }

    public static ByteBuf copiedBuffer(byte[] bArr) {
        return bArr.length == 0 ? EMPTY_BUFFER : wrappedBuffer((byte[]) bArr.clone());
    }

    public static ByteBuf copyBoolean(boolean z5) {
        ByteBuf buffer = buffer(1);
        buffer.writeBoolean(z5);
        return buffer;
    }

    public static ByteBuf copyDouble(double d6) {
        ByteBuf buffer = buffer(8);
        buffer.writeDouble(d6);
        return buffer;
    }

    public static ByteBuf copyFloat(float f6) {
        ByteBuf buffer = buffer(4);
        buffer.writeFloat(f6);
        return buffer;
    }

    public static ByteBuf copyInt(int i6) {
        ByteBuf buffer = buffer(4);
        buffer.writeInt(i6);
        return buffer;
    }

    public static ByteBuf copyLong(long j6) {
        ByteBuf buffer = buffer(8);
        buffer.writeLong(j6);
        return buffer;
    }

    public static ByteBuf copyMedium(int i6) {
        ByteBuf buffer = buffer(3);
        buffer.writeMedium(i6);
        return buffer;
    }

    public static ByteBuf copyShort(int i6) {
        ByteBuf buffer = buffer(2);
        buffer.writeShort(i6);
        return buffer;
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        ByteOrder order = byteBuf.order();
        ByteOrder byteOrder = BIG_ENDIAN;
        return order == byteOrder ? new ReadOnlyByteBuf(byteBuf) : new ReadOnlyByteBuf(byteBuf.order(byteOrder)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr) {
        return bArr.length == 0 ? EMPTY_BUFFER : new UnpooledHeapByteBuf(ALLOC, bArr, bArr.length);
    }

    public static ByteBuf wrappedUnmodifiableBuffer(ByteBuf... byteBufArr) {
        return wrappedUnmodifiableBuffer(false, byteBufArr);
    }

    static {
        UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
        ALLOC = unpooledByteBufAllocator;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        EMPTY_BUFFER = unpooledByteBufAllocator.buffer(0, 0);
    }

    public static ByteBuf buffer(int i6) {
        return ALLOC.heapBuffer(i6);
    }

    public static CompositeByteBuf compositeBuffer(int i6) {
        return new CompositeByteBuf(ALLOC, false, i6);
    }

    public static ByteBuf directBuffer(int i6) {
        return ALLOC.directBuffer(i6);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    private static ByteBuf wrappedUnmodifiableBuffer(boolean z5, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return byteBufArr[0].asReadOnly();
        }
        if (z5) {
            byteBufArr = (ByteBuf[]) Arrays.copyOf(byteBufArr, byteBufArr.length, ByteBuf[].class);
        }
        return new FixedCompositeByteBuf(ALLOC, byteBufArr);
    }

    private Unpooled() {
    }

    public static ByteBuf buffer(int i6, int i7) {
        return ALLOC.heapBuffer(i6, i7);
    }

    public static ByteBuf copyBoolean(boolean... zArr) {
        if (zArr != null && zArr.length != 0) {
            ByteBuf buffer = buffer(zArr.length);
            for (boolean z5 : zArr) {
                buffer.writeBoolean(z5);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyDouble(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            ByteBuf buffer = buffer(dArr.length * 8);
            for (double d6 : dArr) {
                buffer.writeDouble(d6);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyFloat(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            ByteBuf buffer = buffer(fArr.length * 4);
            for (float f6 : fArr) {
                buffer.writeFloat(f6);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyInt(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf buffer = buffer(iArr.length * 4);
            for (int i6 : iArr) {
                buffer.writeInt(i6);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyLong(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            ByteBuf buffer = buffer(jArr.length * 8);
            for (long j6 : jArr) {
                buffer.writeLong(j6);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyMedium(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf buffer = buffer(iArr.length * 3);
            for (int i6 : iArr) {
                buffer.writeMedium(i6);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyShort(short... sArr) {
        if (sArr != null && sArr.length != 0) {
            ByteBuf buffer = buffer(sArr.length * 2);
            for (short s5 : sArr) {
                buffer.writeShort(s5);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf directBuffer(int i6, int i7) {
        return ALLOC.directBuffer(i6, i7);
    }

    public static ByteBuf copiedBuffer(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i7);
        System.arraycopy(bArr, i6, allocateUninitializedArray, 0, i7);
        return wrappedBuffer(allocateUninitializedArray);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return EMPTY_BUFFER;
        }
        if (i6 == 0 && i7 == bArr.length) {
            return wrappedBuffer(bArr);
        }
        return wrappedBuffer(bArr).slice(i6, i7);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf... byteBufArr) {
        return wrappedUnmodifiableBuffer(true, byteBufArr);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(remaining);
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.get(allocateUninitializedArray);
        return wrappedBuffer(allocateUninitializedArray).order(duplicate.order());
    }

    public static ByteBuf copyShort(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf buffer = buffer(iArr.length * 2);
            for (int i6 : iArr) {
                buffer.writeShort(i6);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (!byteBuffer.isDirect() && byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()).order(byteBuffer.order());
        }
        if (PlatformDependent.hasUnsafe()) {
            if (byteBuffer.isReadOnly()) {
                if (byteBuffer.isDirect()) {
                    return new ReadOnlyUnsafeDirectByteBuf(ALLOC, byteBuffer);
                }
                return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
            }
            return new UnpooledUnsafeDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        }
        if (byteBuffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        }
        return new UnpooledDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > 0) {
            ByteBuf buffer = buffer(readableBytes);
            buffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(byte[]... bArr) {
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            int i6 = 0;
            for (byte[] bArr2 : bArr) {
                if (Integer.MAX_VALUE - i6 >= bArr2.length) {
                    i6 += bArr2.length;
                } else {
                    throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                }
            }
            if (i6 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i6);
            int i7 = 0;
            for (byte[] bArr3 : bArr) {
                System.arraycopy(bArr3, 0, allocateUninitializedArray, i7, bArr3.length);
                i7 += bArr3.length;
            }
            return wrappedBuffer(allocateUninitializedArray);
        }
        byte[] bArr4 = bArr[0];
        if (bArr4.length == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(bArr4);
    }

    public static ByteBuf wrappedBuffer(long j6, int i6, boolean z5) {
        return new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, j6, i6, z5);
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return byteBuf.slice();
        }
        byteBuf.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(bArr.length, bArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuf... byteBufArr) {
        return wrappedBuffer(byteBufArr.length, byteBufArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer... byteBufferArr) {
        return wrappedBuffer(byteBufferArr.length, byteBufferArr);
    }

    static <T> ByteBuf wrappedBuffer(int i6, CompositeByteBuf.ByteWrapper<T> byteWrapper, T[] tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                int length2 = tArr.length;
                for (int i7 = 0; i7 < length2; i7++) {
                    T t5 = tArr[i7];
                    if (t5 == null) {
                        return EMPTY_BUFFER;
                    }
                    if (!byteWrapper.isEmpty(t5)) {
                        return new CompositeByteBuf(ALLOC, false, i6, byteWrapper, tArr, i7);
                    }
                }
            } else if (!byteWrapper.isEmpty(tArr[0])) {
                return byteWrapper.wrap(tArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            ByteOrder byteOrder = null;
            int i6 = 0;
            for (ByteBuf byteBuf : byteBufArr) {
                int readableBytes = byteBuf.readableBytes();
                if (readableBytes > 0) {
                    if (Integer.MAX_VALUE - i6 < readableBytes) {
                        throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                    }
                    i6 += readableBytes;
                    if (byteOrder != null) {
                        if (!byteOrder.equals(byteBuf.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                    } else {
                        byteOrder = byteBuf.order();
                    }
                }
            }
            if (i6 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i6);
            int i7 = 0;
            for (ByteBuf byteBuf2 : byteBufArr) {
                int readableBytes2 = byteBuf2.readableBytes();
                byteBuf2.getBytes(byteBuf2.readerIndex(), allocateUninitializedArray, i7, readableBytes2);
                i7 += readableBytes2;
            }
            return wrappedBuffer(allocateUninitializedArray).order(byteOrder);
        }
        return copiedBuffer(byteBufArr[0]);
    }

    public static ByteBuf wrappedBuffer(int i6, byte[]... bArr) {
        return wrappedBuffer(i6, CompositeByteBuf.BYTE_ARRAY_WRAPPER, bArr);
    }

    public static ByteBuf wrappedBuffer(int i6, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length != 0) {
            if (length != 1) {
                for (int i7 = 0; i7 < byteBufArr.length; i7++) {
                    ByteBuf byteBuf = byteBufArr[i7];
                    if (byteBuf.isReadable()) {
                        return new CompositeByteBuf(ALLOC, false, i6, byteBufArr, i7);
                    }
                    byteBuf.release();
                }
            } else {
                ByteBuf byteBuf2 = byteBufArr[0];
                if (byteBuf2.isReadable()) {
                    return wrappedBuffer(byteBuf2.order(BIG_ENDIAN));
                }
                byteBuf2.release();
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            ByteOrder byteOrder = null;
            int i6 = 0;
            for (ByteBuffer byteBuffer : byteBufferArr) {
                int remaining = byteBuffer.remaining();
                if (remaining > 0) {
                    if (Integer.MAX_VALUE - i6 < remaining) {
                        throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                    }
                    i6 += remaining;
                    if (byteOrder != null) {
                        if (!byteOrder.equals(byteBuffer.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                    } else {
                        byteOrder = byteBuffer.order();
                    }
                }
            }
            if (i6 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i6);
            int i7 = 0;
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                ByteBuffer duplicate = byteBuffer2.duplicate();
                int remaining2 = duplicate.remaining();
                duplicate.get(allocateUninitializedArray, i7, remaining2);
                i7 += remaining2;
            }
            return wrappedBuffer(allocateUninitializedArray).order(byteOrder);
        }
        return copiedBuffer(byteBufferArr[0]);
    }

    public static ByteBuf wrappedBuffer(int i6, ByteBuffer... byteBufferArr) {
        return wrappedBuffer(i6, CompositeByteBuf.BYTE_BUFFER_WRAPPER, byteBufferArr);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, Charset charset) {
        if (charSequence != null) {
            if (charSequence instanceof CharBuffer) {
                return copiedBuffer((CharBuffer) charSequence, charset);
            }
            return copiedBuffer(CharBuffer.wrap(charSequence), charset);
        }
        throw new NullPointerException(ResIdentify.RES_TYPE_STRING);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, int i6, int i7, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException(ResIdentify.RES_TYPE_STRING);
        }
        if (i7 == 0) {
            return EMPTY_BUFFER;
        }
        if (charSequence instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) charSequence;
            if (charBuffer.hasArray()) {
                return copiedBuffer(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i6, i7, charset);
            }
            CharBuffer slice = charBuffer.slice();
            slice.limit(i7);
            slice.position(i6);
            return copiedBuffer(slice, charset);
        }
        return copiedBuffer(CharBuffer.wrap(charSequence, i6, i7 + i6), charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, Charset charset) {
        if (cArr != null) {
            return copiedBuffer(cArr, 0, cArr.length, charset);
        }
        throw new NullPointerException("array");
    }

    public static ByteBuf copiedBuffer(char[] cArr, int i6, int i7, Charset charset) {
        if (cArr == null) {
            throw new NullPointerException("array");
        }
        if (i7 == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(CharBuffer.wrap(cArr, i6, i7), charset);
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, charBuffer, charset, 0);
    }
}
