package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;
import kotlin.j1;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.base64.Base64$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Decoder implements ByteProcessor {

        /* renamed from: b4, reason: collision with root package name */
        private final byte[] f43060b4;
        private int b4Posn;
        private byte[] decodabet;
        private ByteBuf dest;
        private int outBuffPosn;
        private byte sbiCrop;
        private byte sbiDecode;

        private Decoder() {
            this.f43060b4 = new byte[4];
        }

        private static int decode4to3(byte[] bArr, ByteBuf byteBuf, int i6, byte[] bArr2) {
            int i7;
            int i8;
            int i9;
            byte b6 = bArr[0];
            byte b7 = bArr[1];
            byte b8 = bArr[2];
            if (b8 == 61) {
                try {
                    byteBuf.setByte(i6, ((bArr2[b6] & 255) << 2) | ((bArr2[b7] & 255) >>> 4));
                    return 1;
                } catch (IndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            byte b9 = bArr[3];
            if (b9 == 61) {
                byte b10 = bArr2[b7];
                try {
                    if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                        i9 = ((b10 & 15) << 4) | ((((bArr2[b6] & Utf8.REPLACEMENT_BYTE) << 2) | ((b10 & 240) >> 4)) << 8) | ((bArr2[b8] & 252) >>> 2);
                    } else {
                        i9 = ((((b10 & 15) << 4) | ((bArr2[b8] & 252) >>> 2)) << 8) | ((bArr2[b6] & Utf8.REPLACEMENT_BYTE) << 2) | ((b10 & 240) >> 4);
                    }
                    byteBuf.setShort(i6, i9);
                    return 2;
                } catch (IndexOutOfBoundsException unused2) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            try {
                if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                    i7 = ((bArr2[b6] & Utf8.REPLACEMENT_BYTE) << 18) | ((bArr2[b7] & 255) << 12) | ((bArr2[b8] & 255) << 6);
                    i8 = bArr2[b9] & 255;
                } else {
                    byte b11 = bArr2[b7];
                    byte b12 = bArr2[b8];
                    i7 = ((bArr2[b6] & Utf8.REPLACEMENT_BYTE) << 2) | ((b11 & 15) << 12) | ((b11 & 240) >>> 4) | ((b12 & 3) << 22) | ((b12 & 252) << 6);
                    i8 = (bArr2[b9] & 255) << 16;
                }
                byteBuf.setMedium(i6, i8 | i7);
                return 3;
            } catch (IndexOutOfBoundsException unused3) {
                throw new IllegalArgumentException("not encoded in Base64");
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            byte b7 = (byte) (b6 & Byte.MAX_VALUE);
            this.sbiCrop = b7;
            byte[] bArr = this.decodabet;
            byte b8 = bArr[b7];
            this.sbiDecode = b8;
            if (b8 < -5) {
                throw new IllegalArgumentException("invalid bad Base64 input character: " + ((int) ((short) (b6 & 255))) + " (decimal)");
            }
            if (b8 < -1) {
                return true;
            }
            byte[] bArr2 = this.f43060b4;
            int i6 = this.b4Posn;
            int i7 = i6 + 1;
            this.b4Posn = i7;
            bArr2[i6] = b7;
            if (i7 <= 3) {
                return true;
            }
            int i8 = this.outBuffPosn;
            this.outBuffPosn = i8 + decode4to3(bArr2, this.dest, i8, bArr);
            this.b4Posn = 0;
            return this.sbiCrop != 61;
        }

        /* synthetic */ Decoder(AnonymousClass1 anonymousClass1) {
            this();
        }

        ByteBuf decode(ByteBuf byteBuf, int i6, int i7, ByteBufAllocator byteBufAllocator, Base64Dialect base64Dialect) {
            this.dest = byteBufAllocator.buffer(Base64.decodedBufferSize(i7)).order(byteBuf.order());
            this.decodabet = Base64.decodabet(base64Dialect);
            try {
                byteBuf.forEachByte(i6, i7, this);
                return this.dest.slice(0, this.outBuffPosn);
            } catch (Throwable th) {
                this.dest.release();
                PlatformDependent.throwException(th);
                return null;
            }
        }
    }

    public static ByteBuf decode(ByteBuf byteBuf) {
        return decode(byteBuf, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf) {
        return encode(byteBuf, Base64Dialect.STANDARD);
    }

    private static void encode3to4BigEndian(int i6, int i7, ByteBuf byteBuf, int i8, byte[] bArr) {
        if (i7 == 1) {
            byteBuf.setInt(i8, (bArr[(i6 >>> 12) & 63] << 16) | (bArr[i6 >>> 18] << 24) | 15677);
        } else if (i7 == 2) {
            byteBuf.setInt(i8, (bArr[(i6 >>> 6) & 63] << 8) | (bArr[i6 >>> 18] << 24) | (bArr[(i6 >>> 12) & 63] << 16) | 61);
        } else {
            if (i7 != 3) {
                return;
            }
            byteBuf.setInt(i8, bArr[i6 & 63] | (bArr[i6 >>> 18] << 24) | (bArr[(i6 >>> 12) & 63] << 16) | (bArr[(i6 >>> 6) & 63] << 8));
        }
    }

    private static void encode3to4LittleEndian(int i6, int i7, ByteBuf byteBuf, int i8, byte[] bArr) {
        if (i7 == 1) {
            byteBuf.setInt(i8, (bArr[(i6 >>> 12) & 63] << 8) | bArr[i6 >>> 18] | 1027407872);
        } else if (i7 == 2) {
            byteBuf.setInt(i8, (bArr[(i6 >>> 6) & 63] << 16) | bArr[i6 >>> 18] | (bArr[(i6 >>> 12) & 63] << 8) | 1023410176);
        } else {
            if (i7 != 3) {
                return;
            }
            byteBuf.setInt(i8, (bArr[i6 & 63] << 24) | bArr[i6 >>> 18] | (bArr[(i6 >>> 12) & 63] << 8) | (bArr[(i6 >>> 6) & 63] << 16));
        }
    }

    static int encodedBufferSize(int i6, boolean z5) {
        long j6 = (i6 << 2) / 3;
        long j7 = (3 + j6) & (-4);
        if (z5) {
            j7 += j6 / 76;
        }
        if (j7 < 2147483647L) {
            return (int) j7;
        }
        return Integer.MAX_VALUE;
    }

    private static int toIntBE(int i6) {
        return i6 & 16777215;
    }

    private static int toIntLE(int i6) {
        return ((i6 & 16711680) >>> 16) | ((i6 & 255) << 16) | (65280 & i6);
    }

    private static byte[] alphabet(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.alphabet;
        }
        throw new NullPointerException("dialect");
    }

    private static boolean breakLines(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.breakLinesByDefault;
        }
        throw new NullPointerException("dialect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] decodabet(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.decodabet;
        }
        throw new NullPointerException("dialect");
    }

    public static ByteBuf decode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        ByteBuf decode = decode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return decode;
    }

    static int decodedBufferSize(int i6) {
        return i6 - (i6 >>> 2);
    }

    public static ByteBuf encode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        return encode(byteBuf, breakLines(base64Dialect), base64Dialect);
    }

    private static int toInt(byte b6) {
        return (b6 & 255) << 16;
    }

    private static int toIntBE(short s5) {
        return (s5 & j1.f43986d) << 8;
    }

    private static int toIntLE(short s5) {
        return (s5 & 65280) | ((s5 & 255) << 16);
    }

    private Base64() {
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z5) {
        return encode(byteBuf, z5, Base64Dialect.STANDARD);
    }

    private static void encode3to4(ByteBuf byteBuf, int i6, int i7, ByteBuf byteBuf2, int i8, byte[] bArr) {
        int i9 = 0;
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 > 0) {
                        i9 = toIntBE(byteBuf.getMedium(i6));
                    }
                } else {
                    i9 = toIntBE(byteBuf.getShort(i6));
                }
            } else {
                i9 = toInt(byteBuf.getByte(i6));
            }
            encode3to4BigEndian(i9, i7, byteBuf2, i8, bArr);
            return;
        }
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 > 0) {
                    i9 = toIntLE(byteBuf.getMedium(i6));
                }
            } else {
                i9 = toIntLE(byteBuf.getShort(i6));
            }
        } else {
            i9 = toInt(byteBuf.getByte(i6));
        }
        encode3to4LittleEndian(i9, i7, byteBuf2, i8, bArr);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z5, Base64Dialect base64Dialect) {
        if (byteBuf != null) {
            ByteBuf encode = encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), z5, base64Dialect);
            byteBuf.readerIndex(byteBuf.writerIndex());
            return encode;
        }
        throw new NullPointerException("src");
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i6, int i7) {
        return decode(byteBuf, i6, i7, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i6, int i7, Base64Dialect base64Dialect) {
        return decode(byteBuf, i6, i7, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i6, int i7, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        if (base64Dialect != null) {
            return new Decoder(null).decode(byteBuf, i6, i7, byteBufAllocator, base64Dialect);
        }
        throw new NullPointerException("dialect");
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i6, int i7) {
        return encode(byteBuf, i6, i7, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i6, int i7, Base64Dialect base64Dialect) {
        return encode(byteBuf, i6, i7, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i6, int i7, boolean z5) {
        return encode(byteBuf, i6, i7, z5, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i6, int i7, boolean z5, Base64Dialect base64Dialect) {
        return encode(byteBuf, i6, i7, z5, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i6, int i7, boolean z5, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        if (base64Dialect != null) {
            ByteBuf order = byteBufAllocator.buffer(encodedBufferSize(i7, z5)).order(byteBuf.order());
            byte[] alphabet = alphabet(base64Dialect);
            int i8 = i7 - 2;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i9 < i8) {
                ByteBuf byteBuf2 = byteBuf;
                encode3to4(byteBuf2, i9 + i6, 3, order, i10, alphabet);
                i11 += 4;
                if (z5 && i11 == 76) {
                    order.setByte(i10 + 4, 10);
                    i10++;
                    i11 = 0;
                }
                i9 += 3;
                i10 += 4;
                byteBuf = byteBuf2;
            }
            ByteBuf byteBuf3 = byteBuf;
            if (i9 < i7) {
                encode3to4(byteBuf3, i9 + i6, i7 - i9, order, i10, alphabet);
                i10 += 4;
            }
            if (i10 > 1 && order.getByte(i10 - 1) == 10) {
                i10--;
            }
            return order.slice(0, i10);
        }
        throw new NullPointerException("dialect");
    }
}
