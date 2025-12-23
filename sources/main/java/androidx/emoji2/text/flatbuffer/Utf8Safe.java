package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Utf8Safe extends Utf8 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i6, int i7) {
            super("Unpaired surrogate at index " + i6 + " of " + i7);
        }
    }

    public static String decodeUtf8Array(byte[] bArr, int i6, int i7) {
        if ((i6 | i7 | ((bArr.length - i6) - i7)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        int i8 = i6 + i7;
        char[] cArr = new char[i7];
        int i9 = 0;
        while (i6 < i8) {
            byte b6 = bArr[i6];
            if (!Utf8.DecodeUtil.isOneByte(b6)) {
                break;
            }
            i6++;
            Utf8.DecodeUtil.handleOneByte(b6, cArr, i9);
            i9++;
        }
        int i10 = i9;
        while (i6 < i8) {
            int i11 = i6 + 1;
            byte b7 = bArr[i6];
            if (Utf8.DecodeUtil.isOneByte(b7)) {
                int i12 = i10 + 1;
                Utf8.DecodeUtil.handleOneByte(b7, cArr, i10);
                while (i11 < i8) {
                    byte b8 = bArr[i11];
                    if (!Utf8.DecodeUtil.isOneByte(b8)) {
                        break;
                    }
                    i11++;
                    Utf8.DecodeUtil.handleOneByte(b8, cArr, i12);
                    i12++;
                }
                i10 = i12;
                i6 = i11;
            } else if (Utf8.DecodeUtil.isTwoBytes(b7)) {
                if (i11 >= i8) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i6 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b7, bArr[i11], cArr, i10);
                i10++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b7)) {
                if (i11 >= i8 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i13 = i6 + 2;
                i6 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b7, bArr[i11], bArr[i13], cArr, i10);
                i10++;
            } else {
                if (i11 >= i8 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b9 = bArr[i11];
                int i14 = i6 + 3;
                byte b10 = bArr[i6 + 2];
                i6 += 4;
                Utf8.DecodeUtil.handleFourBytes(b7, b9, b10, bArr[i14], cArr, i10);
                i10 += 2;
            }
        }
        return new String(cArr, 0, i10);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i6, int i7) {
        if ((i6 | i7 | ((byteBuffer.limit() - i6) - i7)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        int i8 = i6 + i7;
        char[] cArr = new char[i7];
        int i9 = 0;
        while (i6 < i8) {
            byte b6 = byteBuffer.get(i6);
            if (!Utf8.DecodeUtil.isOneByte(b6)) {
                break;
            }
            i6++;
            Utf8.DecodeUtil.handleOneByte(b6, cArr, i9);
            i9++;
        }
        int i10 = i9;
        while (i6 < i8) {
            int i11 = i6 + 1;
            byte b7 = byteBuffer.get(i6);
            if (Utf8.DecodeUtil.isOneByte(b7)) {
                int i12 = i10 + 1;
                Utf8.DecodeUtil.handleOneByte(b7, cArr, i10);
                while (i11 < i8) {
                    byte b8 = byteBuffer.get(i11);
                    if (!Utf8.DecodeUtil.isOneByte(b8)) {
                        break;
                    }
                    i11++;
                    Utf8.DecodeUtil.handleOneByte(b8, cArr, i12);
                    i12++;
                }
                i10 = i12;
                i6 = i11;
            } else if (Utf8.DecodeUtil.isTwoBytes(b7)) {
                if (i11 >= i8) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i6 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b7, byteBuffer.get(i11), cArr, i10);
                i10++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b7)) {
                if (i11 >= i8 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i13 = i6 + 2;
                i6 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b7, byteBuffer.get(i11), byteBuffer.get(i13), cArr, i10);
                i10++;
            } else {
                if (i11 >= i8 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b9 = byteBuffer.get(i11);
                int i14 = i6 + 3;
                byte b10 = byteBuffer.get(i6 + 2);
                i6 += 4;
                Utf8.DecodeUtil.handleFourBytes(b7, b9, b10, byteBuffer.get(i14), cArr, i10);
                i10 += 2;
            }
        }
        return new String(cArr, 0, i10);
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length && charSequence.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 < length) {
                char charAt = charSequence.charAt(i6);
                if (charAt < 2048) {
                    i7 += (127 - charAt) >>> 31;
                    i6++;
                } else {
                    i7 += encodedLengthGeneral(charSequence, i6);
                    break;
                }
            } else {
                break;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i7 + IjkMediaMeta.AV_CH_WIDE_RIGHT));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r9 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int encodeUtf8Array(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.flatbuffer.Utf8Safe.encodeUtf8Array(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i6 = 0;
        while (i6 < length) {
            try {
                char charAt = charSequence.charAt(i6);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i6, (byte) charAt);
                i6++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i6 == length) {
            byteBuffer.position(position + i6);
            return;
        }
        position += i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                int i7 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                    byteBuffer.put(i7, (byte) ((charAt2 & '?') | 128));
                    position = i7;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i7;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                }
            } else {
                if (charAt2 >= 55296 && 57343 >= charAt2) {
                    int i8 = i6 + 1;
                    if (i8 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i8);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i9 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    int i10 = position + 2;
                                    try {
                                        byteBuffer.put(i9, (byte) (((codePoint >>> 12) & 63) | 128));
                                        position += 3;
                                        byteBuffer.put(i10, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                        i6 = i8;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        i6 = i8;
                                        position = i10;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                                    }
                                } catch (IndexOutOfBoundsException unused4) {
                                    position = i9;
                                    i6 = i8;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i6 = i8;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new UnpairedSurrogateException(i6, length);
                }
                int i11 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                position += 2;
                byteBuffer.put(i11, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            }
            i6++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = 0;
        while (i6 < length) {
            char charAt = charSequence.charAt(i6);
            if (charAt < 2048) {
                i7 += (127 - charAt) >>> 31;
            } else {
                i7 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i6) >= 65536) {
                        i6++;
                    } else {
                        throw new UnpairedSurrogateException(i6, length);
                    }
                }
            }
            i6++;
        }
        return i7;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i6, int i7) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i6, i7);
        }
        return decodeUtf8Buffer(byteBuffer, i6, i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else {
            encodeUtf8Buffer(charSequence, byteBuffer);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
