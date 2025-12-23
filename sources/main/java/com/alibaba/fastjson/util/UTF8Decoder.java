package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Surrogate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        public static char high(int i6) {
            return (char) ((((i6 - 65536) >> 10) & 1023) | 55296);
        }

        public static char low(int i6) {
            return (char) (((i6 - 65536) & 1023) | Utf8.LOG_SURROGATE_HEADER);
        }

        public static boolean neededFor(int i6) {
            return i6 >= 65536 && i6 <= 1114111;
        }

        private Surrogate() {
        }
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i6) {
        for (int i7 = 1; i7 < i6; i7++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i7);
            }
        }
        return CoderResult.malformedForLength(i6);
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i6) {
        int i7 = 1;
        if (i6 == 1) {
            byte b6 = byteBuffer.get();
            return (b6 >> 2) == -2 ? byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5) : (b6 >> 1) == -2 ? byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 6) : CoderResult.malformedForLength(1);
        }
        if (i6 == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i6 != 3) {
            if (i6 != 4) {
                throw new IllegalStateException();
            }
            int i8 = byteBuffer.get() & 255;
            byte b7 = byteBuffer.get();
            int i9 = b7 & 255;
            return (i8 > 244 || (i8 == 240 && (i9 < 144 || i9 > 191)) || ((i8 == 244 && (b7 & 240) != 128) || isNotContinuation(i9))) ? CoderResult.malformedForLength(1) : isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
        }
        byte b8 = byteBuffer.get();
        byte b9 = byteBuffer.get();
        if ((b8 != -32 || (b9 & 224) != 128) && !isNotContinuation(b9)) {
            i7 = 2;
        }
        return CoderResult.malformedForLength(i7);
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private static boolean isMalformed2(int i6, int i7) {
        return (i6 & 30) == 0 || (i7 & 192) != 128;
    }

    private static boolean isMalformed3(int i6, int i7, int i8) {
        return ((i6 != -32 || (i7 & 224) != 128) && (i7 & 192) == 128 && (i8 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i6, int i7, int i8) {
        return ((i6 & 192) == 128 && (i7 & 192) == 128 && (i8 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i6) {
        return (i6 & 192) != 128;
    }

    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        ByteBuffer byteBuffer2;
        int i6;
        CharBuffer charBuffer2;
        int i7;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int arrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] array2 = charBuffer.array();
        int arrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int arrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int min = Math.min(arrayOffset2 - arrayOffset, arrayOffset4 - arrayOffset3) + arrayOffset3;
        while (arrayOffset3 < min) {
            byte b6 = array[arrayOffset];
            if (b6 < 0) {
                break;
            }
            arrayOffset++;
            array2[arrayOffset3] = (char) b6;
            arrayOffset3++;
        }
        int i8 = arrayOffset;
        int i9 = arrayOffset3;
        while (i8 < arrayOffset2) {
            byte b7 = array[i8];
            if (b7 >= 0) {
                if (i9 >= arrayOffset4) {
                    return xflow(byteBuffer, i8, arrayOffset2, charBuffer, i9, 1);
                }
                int i10 = arrayOffset4;
                byteBuffer2 = byteBuffer;
                i6 = i10;
                charBuffer2 = charBuffer;
                array2[i9] = (char) b7;
                i8++;
                i9++;
            } else {
                int i11 = arrayOffset4;
                byteBuffer2 = byteBuffer;
                i6 = i11;
                charBuffer2 = charBuffer;
                if ((b7 >> 5) == -2) {
                    if (arrayOffset2 - i8 >= 2 && i9 < i6) {
                        byte b8 = array[i8 + 1];
                        if (isMalformed2(b7, b8)) {
                            return malformed(byteBuffer2, i8, charBuffer2, i9, 2);
                        }
                        i7 = i9 + 1;
                        array2[i9] = (char) ((b8 ^ (b7 << 6)) ^ Utf8.MASK_2BYTES);
                        i8 += 2;
                    } else {
                        return xflow(byteBuffer2, i8, arrayOffset2, charBuffer2, i9, 2);
                    }
                } else if ((b7 >> 4) == -2) {
                    if (arrayOffset2 - i8 >= 3 && i9 < i6) {
                        byte b9 = array[i8 + 1];
                        byte b10 = array[i8 + 2];
                        if (isMalformed3(b7, b9, b10)) {
                            return malformed(byteBuffer2, i8, charBuffer2, i9, 3);
                        }
                        i7 = i9 + 1;
                        array2[i9] = (char) ((((b9 << 6) ^ (b7 << 12)) ^ b10) ^ 8064);
                        i8 += 3;
                    } else {
                        return xflow(byteBuffer2, i8, arrayOffset2, charBuffer2, i9, 3);
                    }
                } else if ((b7 >> 3) == -2) {
                    if (arrayOffset2 - i8 >= 4 && i6 - i9 >= 2) {
                        byte b11 = array[i8 + 1];
                        byte b12 = array[i8 + 2];
                        byte b13 = array[i8 + 3];
                        int i12 = ((b7 & 7) << 18) | ((b11 & Utf8.REPLACEMENT_BYTE) << 12) | ((b12 & Utf8.REPLACEMENT_BYTE) << 6) | (b13 & Utf8.REPLACEMENT_BYTE);
                        if (!isMalformed4(b11, b12, b13) && Surrogate.neededFor(i12)) {
                            int i13 = i9 + 1;
                            array2[i9] = Surrogate.high(i12);
                            i9 += 2;
                            array2[i13] = Surrogate.low(i12);
                            i8 += 4;
                        } else {
                            return malformed(byteBuffer2, i8, charBuffer2, i9, 4);
                        }
                    } else {
                        return xflow(byteBuffer2, i8, arrayOffset2, charBuffer2, i9, 4);
                    }
                } else {
                    return malformed(byteBuffer2, i8, charBuffer2, i9, 1);
                }
                i9 = i7;
            }
            ByteBuffer byteBuffer3 = byteBuffer2;
            arrayOffset4 = i6;
            byteBuffer = byteBuffer3;
            charBuffer = charBuffer2;
        }
        return xflow(byteBuffer, i8, arrayOffset2, charBuffer, i9, 0);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i6, CharBuffer charBuffer, int i7, int i8) {
        byteBuffer.position(i6 - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i8);
        updatePositions(byteBuffer, i6, charBuffer, i7);
        return malformedN;
    }

    static void updatePositions(Buffer buffer, int i6, Buffer buffer2, int i7) {
        buffer.position(i6);
        buffer2.position(i7);
    }

    private static CoderResult xflow(Buffer buffer, int i6, int i7, Buffer buffer2, int i8, int i9) {
        updatePositions(buffer, i6, buffer2, i8);
        if (i9 != 0 && i7 - i6 >= i9) {
            return CoderResult.OVERFLOW;
        }
        return CoderResult.UNDERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
