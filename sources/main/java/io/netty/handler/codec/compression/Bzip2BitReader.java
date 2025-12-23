package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;
    private ByteBuf in;

    boolean readBoolean() {
        return readBits(1) != 0;
    }

    boolean hasReadableBits(int i6) {
        if (i6 >= 0) {
            return this.bitCount >= i6 || ((this.in.readableBytes() << 3) & Integer.MAX_VALUE) >= i6 - this.bitCount;
        }
        throw new IllegalArgumentException("count: " + i6 + " (expected value greater than 0)");
    }

    boolean isReadable() {
        return this.bitCount > 0 || this.in.isReadable();
    }

    int readBits(int i6) {
        long readUnsignedByte;
        int i7;
        if (i6 < 0 || i6 > 32) {
            throw new IllegalArgumentException("count: " + i6 + " (expected: 0-32 )");
        }
        int i8 = this.bitCount;
        long j6 = this.bitBuffer;
        if (i8 < i6) {
            int readableBytes = this.in.readableBytes();
            if (readableBytes == 1) {
                readUnsignedByte = this.in.readUnsignedByte();
                i7 = 8;
            } else if (readableBytes == 2) {
                readUnsignedByte = this.in.readUnsignedShort();
                i7 = 16;
            } else if (readableBytes != 3) {
                readUnsignedByte = this.in.readUnsignedInt();
                i7 = 32;
            } else {
                readUnsignedByte = this.in.readUnsignedMedium();
                i7 = 24;
            }
            j6 = (j6 << i7) | readUnsignedByte;
            i8 += i7;
            this.bitBuffer = j6;
        }
        int i9 = i8 - i6;
        this.bitCount = i9;
        return (int) ((j6 >>> i9) & (i6 != 32 ? (1 << i6) - 1 : 4294967295L));
    }

    int readInt() {
        return readBits(32);
    }

    void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | this.in.readUnsignedByte();
        this.bitCount += 8;
    }

    void setByteBuf(ByteBuf byteBuf) {
        this.in = byteBuf;
    }

    Bzip2BitReader() {
    }

    boolean hasReadableBytes(int i6) {
        if (i6 >= 0 && i6 <= MAX_COUNT_OF_READABLE_BYTES) {
            return hasReadableBits(i6 << 3);
        }
        throw new IllegalArgumentException("count: " + i6 + " (expected: 0-" + MAX_COUNT_OF_READABLE_BYTES + ')');
    }
}
