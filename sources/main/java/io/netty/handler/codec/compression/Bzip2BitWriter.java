package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    void flush(ByteBuf byteBuf) {
        int i6 = this.bitCount;
        if (i6 > 0) {
            long j6 = this.bitBuffer;
            int i7 = 64 - i6;
            if (i6 <= 8) {
                byteBuf.writeByte((int) ((j6 >>> i7) << (8 - i6)));
                return;
            }
            if (i6 <= 16) {
                byteBuf.writeShort((int) ((j6 >>> i7) << (16 - i6)));
            } else if (i6 <= 24) {
                byteBuf.writeMedium((int) ((j6 >>> i7) << (24 - i6)));
            } else {
                byteBuf.writeInt((int) ((j6 >>> i7) << (32 - i6)));
            }
        }
    }

    void writeBits(ByteBuf byteBuf, int i6, long j6) {
        if (i6 < 0 || i6 > 32) {
            throw new IllegalArgumentException("count: " + i6 + " (expected: 0-32)");
        }
        int i7 = this.bitCount;
        long j7 = ((j6 << (64 - i6)) >>> i7) | this.bitBuffer;
        int i8 = i7 + i6;
        if (i8 >= 32) {
            byteBuf.writeInt((int) (j7 >>> 32));
            j7 <<= 32;
            i8 -= 32;
        }
        this.bitBuffer = j7;
        this.bitCount = i8;
    }

    void writeBoolean(ByteBuf byteBuf, boolean z5) {
        int i6 = this.bitCount + 1;
        long j6 = 0;
        long j7 = this.bitBuffer | (z5 ? 1 << (64 - i6) : 0L);
        if (i6 == 32) {
            byteBuf.writeInt((int) (j7 >>> 32));
            i6 = 0;
        } else {
            j6 = j7;
        }
        this.bitBuffer = j6;
        this.bitCount = i6;
    }

    void writeInt(ByteBuf byteBuf, int i6) {
        writeBits(byteBuf, 32, i6);
    }

    void writeUnary(ByteBuf byteBuf, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("value: " + i6 + " (expected 0 or more)");
        }
        while (true) {
            int i7 = i6 - 1;
            if (i6 <= 0) {
                writeBoolean(byteBuf, false);
                return;
            } else {
                writeBoolean(byteBuf, true);
                i6 = i7;
            }
        }
    }

    Bzip2BitWriter() {
    }
}
