package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Snappy {
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private static final int LITERAL = 0;
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int PREAMBLE_NOT_FULL = -1;
    private State state = State.READY;
    private byte tag;
    private int written;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        READY,
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    static int calculateChecksum(ByteBuf byteBuf) {
        return calculateChecksum(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static int findMatchingLength(ByteBuf byteBuf, int i6, int i7, int i8) {
        int i9 = 0;
        while (i7 <= i8 - 4 && byteBuf.getInt(i7) == byteBuf.getInt(i6 + i9)) {
            i7 += 4;
            i9 += 4;
        }
        while (i7 < i8 && byteBuf.getByte(i6 + i9) == byteBuf.getByte(i7)) {
            i7++;
            i9++;
        }
        return i9;
    }

    private static int readPreamble(ByteBuf byteBuf) {
        int i6 = 0;
        int i7 = 0;
        while (byteBuf.isReadable()) {
            short readUnsignedByte = byteBuf.readUnsignedByte();
            int i8 = i7 + 1;
            i6 |= (readUnsignedByte & 127) << (i7 * 7);
            if ((readUnsignedByte & 128) == 0) {
                return i6;
            }
            if (i8 >= 4) {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
            i7 = i8;
        }
        return 0;
    }

    static void validateChecksum(int i6, ByteBuf byteBuf) {
        validateChecksum(i6, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        encodeLiteral(r13, r14, r3 - r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r4 = findMatchingLength(r13, r10 + 4, r3 + 4, r15) + 4;
        r5 = r3 + r4;
        encodeCopy(r14, r3 - r10, r4);
        r13.readerIndex(r13.readerIndex() + r4);
        r3 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r5 < r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        r4 = r5 - r0;
        r1[hash(r13, r3, r2)] = (short) (r4 - 1);
        r3 = hash(r13, r5, r2);
        r10 = r0 + r1[r3];
        r1[r3] = (short) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0095, code lost:
    
        if (r13.getInt(r5) == r13.getInt(r10)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        r3 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.buffer.ByteBuf r13, io.netty.buffer.ByteBuf r14, int r15) {
        /*
            r12 = this;
            r0 = 0
        L1:
            int r1 = r0 * 7
            int r1 = r15 >>> r1
            r2 = r1 & (-128(0xffffffffffffff80, float:NaN))
            if (r2 == 0) goto L13
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r1 = r1 | 128(0x80, float:1.8E-43)
            r14.writeByte(r1)
            int r0 = r0 + 1
            goto L1
        L13:
            r14.writeByte(r1)
            int r0 = r13.readerIndex()
            short[] r1 = getHashTable(r15)
            int r2 = r1.length
            int r2 = java.lang.Integer.numberOfLeadingZeros(r2)
            int r2 = r2 + 1
            int r3 = r15 - r0
            r4 = 15
            if (r3 < r4) goto La6
            int r3 = r0 + 1
            int r4 = hash(r13, r3, r2)
            r5 = r0
        L32:
            r6 = 32
        L34:
            int r7 = r6 + 1
            int r6 = r6 >> 5
            int r6 = r6 + r3
            int r8 = r15 + (-4)
            if (r6 <= r8) goto L3f
        L3d:
            r0 = r5
            goto La6
        L3f:
            int r9 = hash(r13, r6, r2)
            short r10 = r1[r4]
            int r10 = r10 + r0
            int r11 = r3 - r0
            short r11 = (short) r11
            r1[r4] = r11
            int r4 = r13.getInt(r3)
            int r11 = r13.getInt(r10)
            if (r4 != r11) goto La2
            int r4 = r3 - r5
            encodeLiteral(r13, r14, r4)
        L5a:
            int r4 = r10 + 4
            int r5 = r3 + 4
            int r4 = findMatchingLength(r13, r4, r5, r15)
            int r4 = r4 + 4
            int r5 = r3 + r4
            int r3 = r3 - r10
            encodeCopy(r14, r3, r4)
            int r3 = r13.readerIndex()
            int r3 = r3 + r4
            r13.readerIndex(r3)
            int r3 = r5 + (-1)
            if (r5 < r8) goto L77
            goto L3d
        L77:
            int r3 = hash(r13, r3, r2)
            int r4 = r5 - r0
            int r6 = r4 + (-1)
            short r6 = (short) r6
            r1[r3] = r6
            int r3 = hash(r13, r5, r2)
            short r6 = r1[r3]
            int r10 = r0 + r6
            short r4 = (short) r4
            r1[r3] = r4
            int r3 = r13.getInt(r5)
            int r4 = r13.getInt(r10)
            if (r3 == r4) goto La0
            int r3 = r5 + 1
            int r4 = hash(r13, r3, r2)
            int r3 = r5 + 1
            goto L32
        La0:
            r3 = r5
            goto L5a
        La2:
            r3 = r6
            r6 = r7
            r4 = r9
            goto L34
        La6:
            if (r0 >= r15) goto Lac
            int r15 = r15 - r0
            encodeLiteral(r13, r14, r15)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.encode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf, int):void");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.Snappy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Snappy$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Snappy$State = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_PREAMBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_LITERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_COPY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static int calculateChecksum(ByteBuf byteBuf, int i6, int i7) {
        Crc32c crc32c = new Crc32c();
        try {
            crc32c.update(byteBuf, i6, i7);
            return maskChecksum((int) crc32c.getValue());
        } finally {
            crc32c.reset();
        }
    }

    private static void encodeCopy(ByteBuf byteBuf, int i6, int i7) {
        while (i7 >= 68) {
            encodeCopyWithOffset(byteBuf, i6, 64);
            i7 -= 64;
        }
        if (i7 > 64) {
            encodeCopyWithOffset(byteBuf, i6, 60);
            i7 -= 60;
        }
        encodeCopyWithOffset(byteBuf, i6, i7);
    }

    private static void encodeCopyWithOffset(ByteBuf byteBuf, int i6, int i7) {
        if (i7 < 12 && i6 < 2048) {
            byteBuf.writeByte(((i7 - 4) << 2) | 1 | ((i6 >> 8) << 5));
            byteBuf.writeByte(i6 & 255);
        } else {
            byteBuf.writeByte(((i7 - 1) << 2) | 2);
            byteBuf.writeByte(i6 & 255);
            byteBuf.writeByte((i6 >> 8) & 255);
        }
    }

    static void encodeLiteral(ByteBuf byteBuf, ByteBuf byteBuf2, int i6) {
        if (i6 < 61) {
            byteBuf2.writeByte((i6 - 1) << 2);
        } else {
            int i7 = i6 - 1;
            int bitsToEncode = bitsToEncode(i7) / 8;
            int i8 = bitsToEncode + 1;
            byteBuf2.writeByte((bitsToEncode + 60) << 2);
            for (int i9 = 0; i9 < i8; i9++) {
                byteBuf2.writeByte((i7 >> (i9 * 8)) & 255);
            }
        }
        byteBuf2.writeBytes(byteBuf, i6);
    }

    private static short[] getHashTable(int i6) {
        int i7 = 256;
        while (i7 < 16384 && i7 < i6) {
            i7 <<= 1;
        }
        return new short[i7];
    }

    static int maskChecksum(int i6) {
        return ((i6 << 17) | (i6 >> 15)) - 1568478504;
    }

    static void validateChecksum(int i6, ByteBuf byteBuf, int i7, int i8) {
        int calculateChecksum = calculateChecksum(byteBuf, i7, i8);
        if (calculateChecksum == i6) {
            return;
        }
        throw new DecompressionException("mismatching checksum: " + Integer.toHexString(calculateChecksum) + " (expected: " + Integer.toHexString(i6) + ')');
    }

    private static void validateOffset(int i6, int i7) {
        if (i6 == 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        }
        if (i6 < 0) {
            throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
        }
        if (i6 > i7) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    public void reset() {
        this.state = State.READY;
        this.tag = (byte) 0;
        this.written = 0;
    }

    private static int bitsToEncode(int i6) {
        int highestOneBit = Integer.highestOneBit(i6);
        int i7 = 0;
        while (true) {
            highestOneBit >>= 1;
            if (highestOneBit != 0) {
                i7++;
            } else {
                return i7;
            }
        }
    }

    private static int decodeCopyWith1ByteOffset(byte b6, ByteBuf byteBuf, ByteBuf byteBuf2, int i6) {
        if (!byteBuf.isReadable()) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i7 = ((b6 & 28) >> 2) + 4;
        int readUnsignedByte = (((b6 & 224) << 8) >> 5) | byteBuf.readUnsignedByte();
        validateOffset(readUnsignedByte, i6);
        byteBuf2.markReaderIndex();
        if (readUnsignedByte < i7) {
            for (int i8 = i7 / readUnsignedByte; i8 > 0; i8--) {
                byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                byteBuf2.readBytes(byteBuf2, readUnsignedByte);
            }
            int i9 = i7 % readUnsignedByte;
            if (i9 != 0) {
                byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                byteBuf2.readBytes(byteBuf2, i9);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readUnsignedByte);
            byteBuf2.readBytes(byteBuf2, i7);
        }
        byteBuf2.resetReaderIndex();
        return i7;
    }

    private static int decodeCopyWith2ByteOffset(byte b6, ByteBuf byteBuf, ByteBuf byteBuf2, int i6) {
        if (byteBuf.readableBytes() < 2) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i7 = ((b6 >> 2) & 63) + 1;
        int readUnsignedShortLE = byteBuf.readUnsignedShortLE();
        validateOffset(readUnsignedShortLE, i6);
        byteBuf2.markReaderIndex();
        if (readUnsignedShortLE < i7) {
            for (int i8 = i7 / readUnsignedShortLE; i8 > 0; i8--) {
                byteBuf2.readerIndex(writerIndex - readUnsignedShortLE);
                byteBuf2.readBytes(byteBuf2, readUnsignedShortLE);
            }
            int i9 = i7 % readUnsignedShortLE;
            if (i9 != 0) {
                byteBuf2.readerIndex(writerIndex - readUnsignedShortLE);
                byteBuf2.readBytes(byteBuf2, i9);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readUnsignedShortLE);
            byteBuf2.readBytes(byteBuf2, i7);
        }
        byteBuf2.resetReaderIndex();
        return i7;
    }

    private static int decodeCopyWith4ByteOffset(byte b6, ByteBuf byteBuf, ByteBuf byteBuf2, int i6) {
        if (byteBuf.readableBytes() < 4) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i7 = ((b6 >> 2) & 63) + 1;
        int readIntLE = byteBuf.readIntLE();
        validateOffset(readIntLE, i6);
        byteBuf2.markReaderIndex();
        if (readIntLE < i7) {
            for (int i8 = i7 / readIntLE; i8 > 0; i8--) {
                byteBuf2.readerIndex(writerIndex - readIntLE);
                byteBuf2.readBytes(byteBuf2, readIntLE);
            }
            int i9 = i7 % readIntLE;
            if (i9 != 0) {
                byteBuf2.readerIndex(writerIndex - readIntLE);
                byteBuf2.readBytes(byteBuf2, i9);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readIntLE);
            byteBuf2.readBytes(byteBuf2, i7);
        }
        byteBuf2.resetReaderIndex();
        return i7;
    }

    static int decodeLiteral(byte b6, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf.markReaderIndex();
        int i6 = (b6 >> 2) & 63;
        switch (i6) {
            case 60:
                if (!byteBuf.isReadable()) {
                    return -1;
                }
                i6 = byteBuf.readUnsignedByte();
                break;
            case 61:
                if (byteBuf.readableBytes() < 2) {
                    return -1;
                }
                i6 = byteBuf.readUnsignedShortLE();
                break;
            case 62:
                if (byteBuf.readableBytes() < 3) {
                    return -1;
                }
                i6 = byteBuf.readUnsignedMediumLE();
                break;
            case 63:
                if (byteBuf.readableBytes() < 4) {
                    return -1;
                }
                i6 = byteBuf.readIntLE();
                break;
        }
        int i7 = i6 + 1;
        if (byteBuf.readableBytes() < i7) {
            byteBuf.resetReaderIndex();
            return -1;
        }
        byteBuf2.writeBytes(byteBuf, i7);
        return i7;
    }

    private static int hash(ByteBuf byteBuf, int i6, int i7) {
        return (byteBuf.getInt(i6) * 506832829) >>> i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.buffer.ByteBuf r7, io.netty.buffer.ByteBuf r8) {
        /*
            r6 = this;
        L0:
            boolean r0 = r7.isReadable()
            if (r0 == 0) goto Lb1
            int[] r0 = io.netty.handler.codec.compression.Snappy.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Snappy$State
            io.netty.handler.codec.compression.Snappy$State r1 = r6.state
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            r3 = -1
            r4 = 3
            if (r0 == r2) goto L74
            if (r0 == r1) goto L78
            if (r0 == r4) goto L8d
            r5 = 4
            if (r0 == r5) goto L62
            r5 = 5
            if (r0 == r5) goto L21
            goto L0
        L21:
            byte r0 = r6.tag
            r5 = r0 & 3
            if (r5 == r2) goto L50
            if (r5 == r1) goto L3e
            if (r5 == r4) goto L2c
            goto L0
        L2c:
            int r1 = r6.written
            int r0 = decodeCopyWith4ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto Lb1
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L3e:
            int r1 = r6.written
            int r0 = decodeCopyWith2ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto Lb1
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L50:
            int r1 = r6.written
            int r0 = decodeCopyWith1ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto Lb1
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L62:
            byte r0 = r6.tag
            int r0 = decodeLiteral(r0, r7, r8)
            if (r0 == r3) goto Lb1
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L74:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_PREAMBLE
            r6.state = r0
        L78:
            int r0 = readPreamble(r7)
            if (r0 != r3) goto L7f
            goto Lb1
        L7f:
            if (r0 != 0) goto L86
            io.netty.handler.codec.compression.Snappy$State r7 = io.netty.handler.codec.compression.Snappy.State.READY
            r6.state = r7
            return
        L86:
            r8.ensureWritable(r0)
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r0
        L8d:
            boolean r0 = r7.isReadable()
            if (r0 != 0) goto L94
            goto Lb1
        L94:
            byte r0 = r7.readByte()
            r6.tag = r0
            r0 = r0 & r4
            if (r0 == 0) goto Lab
            if (r0 == r2) goto La5
            if (r0 == r1) goto La5
            if (r0 == r4) goto La5
            goto L0
        La5:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_COPY
            r6.state = r0
            goto L0
        Lab:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_LITERAL
            r6.state = r0
            goto L0
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.decode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }
}
