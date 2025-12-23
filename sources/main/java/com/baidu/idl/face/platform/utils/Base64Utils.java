package com.baidu.idl.face.platform.utils;

import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Base64Utils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public int maxOutputSize(int i6) {
            return ((i6 * 3) / 4) + 10;
        }

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public boolean process(byte[] bArr, int i6, int i7, boolean z5) {
            int i8 = this.state;
            if (i8 == 6) {
                return false;
            }
            int i9 = i7 + i6;
            int i10 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i11 = i10;
            int i12 = 0;
            int i13 = i8;
            int i14 = i6;
            while (i14 < i9) {
                if (i13 == 0) {
                    while (true) {
                        int i15 = i14 + 4;
                        if (i15 > i9 || (i11 = (iArr[bArr[i14] & 255] << 18) | (iArr[bArr[i14 + 1] & 255] << 12) | (iArr[bArr[i14 + 2] & 255] << 6) | iArr[bArr[i14 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i12 + 2] = (byte) i11;
                        bArr2[i12 + 1] = (byte) (i11 >> 8);
                        bArr2[i12] = (byte) (i11 >> 16);
                        i12 += 3;
                        i14 = i15;
                    }
                    if (i14 >= i9) {
                        break;
                    }
                }
                int i16 = i14 + 1;
                int i17 = iArr[bArr[i14] & 255];
                if (i13 != 0) {
                    if (i13 == 1) {
                        if (i17 < 0) {
                            if (i17 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i17 |= i11 << 6;
                    } else if (i13 == 2) {
                        if (i17 < 0) {
                            if (i17 == -2) {
                                bArr2[i12] = (byte) (i11 >> 4);
                                i12++;
                                i13 = 4;
                            } else if (i17 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i17 |= i11 << 6;
                    } else if (i13 != 3) {
                        if (i13 != 4) {
                            if (i13 == 5 && i17 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i17 == -2) {
                            i13++;
                        } else if (i17 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i17 >= 0) {
                        int i18 = i17 | (i11 << 6);
                        bArr2[i12 + 2] = (byte) i18;
                        bArr2[i12 + 1] = (byte) (i18 >> 8);
                        bArr2[i12] = (byte) (i18 >> 16);
                        i12 += 3;
                        i11 = i18;
                        i13 = 0;
                    } else if (i17 == -2) {
                        bArr2[i12 + 1] = (byte) (i11 >> 2);
                        bArr2[i12] = (byte) (i11 >> 10);
                        i12 += 2;
                        i13 = 5;
                    } else if (i17 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i13++;
                    i11 = i17;
                } else {
                    if (i17 < 0) {
                        if (i17 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i13++;
                    i11 = i17;
                }
                i14 = i16;
            }
            if (!z5) {
                this.state = i13;
                this.value = i11;
                this.op = i12;
                return true;
            }
            if (i13 == 1) {
                this.state = 6;
                return false;
            }
            if (i13 == 2) {
                bArr2[i12] = (byte) (i11 >> 4);
                i12++;
            } else if (i13 == 3) {
                int i19 = i12 + 1;
                bArr2[i12] = (byte) (i11 >> 10);
                i12 += 2;
                bArr2[i19] = (byte) (i11 >> 2);
            } else if (i13 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i13;
            this.op = i12;
            return true;
        }

        public Decoder(int i6, byte[] bArr) {
            int[] iArr;
            this.output = bArr;
            if ((i6 & 8) == 0) {
                iArr = DECODE;
            } else {
                iArr = DECODE_WEBSAFE;
            }
            this.alphabet = iArr;
            this.state = 0;
            this.value = 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public int maxOutputSize(int i6) {
            return ((i6 * 8) / 5) + 10;
        }

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public boolean process(byte[] bArr, int i6, int i7, boolean z5) {
            int i8;
            int i9;
            int i10;
            int i11;
            byte b6;
            byte b7;
            byte b8;
            int i12;
            int i13;
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i14 = this.count;
            int i15 = i7 + i6;
            int i16 = this.tailLen;
            int i17 = 0;
            if (i16 != 1) {
                if (i16 == 2 && (i13 = i6 + 1) <= i15) {
                    byte[] bArr4 = this.tail;
                    i9 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i6] & 255);
                    this.tailLen = 0;
                    i8 = i13;
                }
                i8 = i6;
                i9 = -1;
            } else {
                if (i6 + 2 <= i15) {
                    i8 = i6 + 2;
                    i9 = (bArr[i6 + 1] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i6] & 255) << 8);
                    this.tailLen = 0;
                }
                i8 = i6;
                i9 = -1;
            }
            if (i9 != -1) {
                bArr3[0] = bArr2[(i9 >> 18) & 63];
                bArr3[1] = bArr2[(i9 >> 12) & 63];
                bArr3[2] = bArr2[(i9 >> 6) & 63];
                bArr3[3] = bArr2[i9 & 63];
                i14--;
                if (i14 == 0) {
                    if (this.do_cr) {
                        bArr3[4] = 13;
                        i12 = 5;
                    } else {
                        i12 = 4;
                    }
                    i10 = i12 + 1;
                    bArr3[i12] = 10;
                    i14 = 19;
                } else {
                    i10 = 4;
                }
            } else {
                i10 = 0;
            }
            while (true) {
                int i18 = i8 + 3;
                if (i18 > i15) {
                    break;
                }
                int i19 = ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8] & 255) << 16) | (bArr[i8 + 2] & 255);
                bArr3[i10] = bArr2[(i19 >> 18) & 63];
                bArr3[i10 + 1] = bArr2[(i19 >> 12) & 63];
                bArr3[i10 + 2] = bArr2[(i19 >> 6) & 63];
                bArr3[i10 + 3] = bArr2[i19 & 63];
                int i20 = i10 + 4;
                i14--;
                if (i14 == 0) {
                    if (this.do_cr) {
                        bArr3[i20] = 13;
                        i20 = i10 + 5;
                    }
                    i10 = i20 + 1;
                    bArr3[i20] = 10;
                    i8 = i18;
                    i14 = 19;
                } else {
                    i10 = i20;
                    i8 = i18;
                }
            }
            if (z5) {
                int i21 = this.tailLen;
                if (i8 - i21 == i15 - 1) {
                    if (i21 > 0) {
                        b8 = this.tail[0];
                        i17 = 1;
                    } else {
                        b8 = bArr[i8];
                    }
                    int i22 = (b8 & 255) << 4;
                    this.tailLen = i21 - i17;
                    bArr3[i10] = bArr2[(i22 >> 6) & 63];
                    int i23 = i10 + 2;
                    bArr3[i10 + 1] = bArr2[i22 & 63];
                    if (this.do_padding) {
                        bArr3[i23] = 61;
                        i23 = i10 + 4;
                        bArr3[i10 + 3] = 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i23] = 13;
                            i23++;
                        }
                        i11 = i23 + 1;
                        bArr3[i23] = 10;
                        i10 = i11;
                    } else {
                        i10 = i23;
                    }
                } else if (i8 - i21 == i15 - 2) {
                    if (i21 > 1) {
                        b6 = this.tail[0];
                        i17 = 1;
                    } else {
                        byte b9 = bArr[i8];
                        i8++;
                        b6 = b9;
                    }
                    int i24 = (b6 & 255) << 10;
                    if (i21 > 0) {
                        b7 = this.tail[i17];
                        i17++;
                    } else {
                        b7 = bArr[i8];
                    }
                    int i25 = i24 | ((b7 & 255) << 2);
                    this.tailLen = i21 - i17;
                    bArr3[i10] = bArr2[(i25 >> 12) & 63];
                    bArr3[i10 + 1] = bArr2[(i25 >> 6) & 63];
                    int i26 = i10 + 3;
                    bArr3[i10 + 2] = bArr2[i25 & 63];
                    if (this.do_padding) {
                        bArr3[i26] = 61;
                        i26 = i10 + 4;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i26] = 13;
                            i26++;
                        }
                        i11 = i26 + 1;
                        bArr3[i26] = 10;
                        i10 = i11;
                    } else {
                        i10 = i26;
                    }
                } else if (this.do_newline && i10 > 0 && i14 != 19) {
                    if (this.do_cr) {
                        bArr3[i10] = 13;
                        i10++;
                    }
                    i11 = i10 + 1;
                    bArr3[i10] = 10;
                    i10 = i11;
                }
            } else if (i8 == i15 - 1) {
                byte[] bArr5 = this.tail;
                int i27 = this.tailLen;
                this.tailLen = i27 + 1;
                bArr5[i27] = bArr[i8];
            } else if (i8 == i15 - 2) {
                byte[] bArr6 = this.tail;
                int i28 = this.tailLen;
                int i29 = i28 + 1;
                this.tailLen = i29;
                bArr6[i28] = bArr[i8];
                this.tailLen = i28 + 2;
                bArr6[i29] = bArr[i8 + 1];
            }
            this.op = i10;
            this.count = i14;
            return true;
        }

        public Encoder(int i6, byte[] bArr) {
            boolean z5;
            boolean z6;
            byte[] bArr2;
            int i7;
            this.output = bArr;
            if ((i6 & 1) == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.do_padding = z5;
            if ((i6 & 2) == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.do_newline = z6;
            this.do_cr = (i6 & 4) != 0;
            if ((i6 & 8) == 0) {
                bArr2 = ENCODE;
            } else {
                bArr2 = ENCODE_WEBSAFE;
            }
            this.alphabet = bArr2;
            this.tail = new byte[2];
            this.tailLen = 0;
            if (z6) {
                i7 = 19;
            } else {
                i7 = -1;
            }
            this.count = i7;
        }
    }

    public static byte[] decode(String str, int i6) throws IllegalArgumentException {
        return decode(str.getBytes(), i6);
    }

    public static byte[] encode(byte[] bArr, int i6) {
        return encode(bArr, 0, bArr.length, i6);
    }

    public static String encodeToString(byte[] bArr, int i6) {
        try {
            return new String(encode(bArr, i6), "US-ASCII");
        } catch (UnsupportedEncodingException e6) {
            throw new AssertionError(e6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i6);

        public abstract boolean process(byte[] bArr, int i6, int i7, boolean z5);

        Coder() {
        }
    }

    public static byte[] decode(byte[] bArr, int i6) throws IllegalArgumentException {
        return decode(bArr, 0, bArr.length, i6);
    }

    public static byte[] encode(byte[] bArr, int i6, int i7, int i8) {
        Encoder encoder = new Encoder(i8, null);
        int i9 = (i7 / 3) * 4;
        if (!encoder.do_padding) {
            int i10 = i7 % 3;
            if (i10 == 1) {
                i9 += 2;
            } else if (i10 == 2) {
                i9 += 3;
            }
        } else if (i7 % 3 > 0) {
            i9 += 4;
        }
        if (encoder.do_newline && i7 > 0) {
            i9 += (((i7 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i9];
        encoder.process(bArr, i6, i7, true);
        return encoder.output;
    }

    private Base64Utils() {
    }

    public static byte[] decode(byte[] bArr, int i6, int i7, int i8) throws IllegalArgumentException {
        Decoder decoder = new Decoder(i8, new byte[(i7 * 3) / 4]);
        if (decoder.process(bArr, i6, i7, true)) {
            int i9 = decoder.op;
            byte[] bArr2 = decoder.output;
            if (i9 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i9];
            System.arraycopy(bArr2, 0, bArr3, 0, i9);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String encodeToString(byte[] bArr, int i6, int i7, int i8) {
        try {
            return new String(encode(bArr, i6, i7, i8), "US-ASCII");
        } catch (UnsupportedEncodingException e6) {
            throw new AssertionError(e6);
        }
    }
}
