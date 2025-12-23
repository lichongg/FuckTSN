package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t9 {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f7311a = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends a {

        /* renamed from: f, reason: collision with root package name */
        private static final int[] f7314f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g, reason: collision with root package name */
        private static final int[] f7315g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c, reason: collision with root package name */
        private int f7316c;

        /* renamed from: d, reason: collision with root package name */
        private int f7317d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f7318e;

        public final boolean a(byte[] bArr, int i6) {
            int i7 = this.f7316c;
            if (i7 == 6) {
                return false;
            }
            int i8 = this.f7317d;
            byte[] bArr2 = this.f7312a;
            int[] iArr = this.f7318e;
            int i9 = 0;
            int i10 = 0;
            while (i9 < i6) {
                if (i7 == 0) {
                    while (true) {
                        int i11 = i9 + 4;
                        if (i11 > i6 || (i8 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i10 + 2] = (byte) i8;
                        bArr2[i10 + 1] = (byte) (i8 >> 8);
                        bArr2[i10] = (byte) (i8 >> 16);
                        i10 += 3;
                        i9 = i11;
                    }
                    if (i9 >= i6) {
                        break;
                    }
                }
                int i12 = i9 + 1;
                int i13 = iArr[bArr[i9] & 255];
                if (i7 != 0) {
                    if (i7 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.f7316c = 6;
                                return false;
                            }
                        }
                        i8 = (i8 << 6) | i13;
                        i7++;
                    } else if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 4) {
                                if (i13 != -2) {
                                    if (i13 != -1) {
                                        this.f7316c = 6;
                                        return false;
                                    }
                                }
                                i7++;
                            } else if (i7 == 5 && i13 != -1) {
                                this.f7316c = 6;
                                return false;
                            }
                        } else if (i13 >= 0) {
                            i8 = (i8 << 6) | i13;
                            bArr2[i10 + 2] = (byte) i8;
                            bArr2[i10 + 1] = (byte) (i8 >> 8);
                            bArr2[i10] = (byte) (i8 >> 16);
                            i10 += 3;
                            i9 = i12;
                            i7 = 0;
                        } else if (i13 == -2) {
                            bArr2[i10 + 1] = (byte) (i8 >> 2);
                            bArr2[i10] = (byte) (i8 >> 10);
                            i10 += 2;
                            i9 = i12;
                            i7 = 5;
                        } else if (i13 != -1) {
                            this.f7316c = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        i8 = (i8 << 6) | i13;
                        i7++;
                    } else if (i13 == -2) {
                        bArr2[i10] = (byte) (i8 >> 4);
                        i10++;
                        i9 = i12;
                        i7 = 4;
                    } else if (i13 != -1) {
                        this.f7316c = 6;
                        return false;
                    }
                } else if (i13 >= 0) {
                    i7++;
                    i8 = i13;
                } else if (i13 != -1) {
                    this.f7316c = 6;
                    return false;
                }
                i9 = i12;
            }
            if (i7 == 1) {
                this.f7316c = 6;
                return false;
            }
            if (i7 == 2) {
                bArr2[i10] = (byte) (i8 >> 4);
                i10++;
            } else if (i7 == 3) {
                int i14 = i10 + 1;
                bArr2[i10] = (byte) (i8 >> 10);
                i10 += 2;
                bArr2[i14] = (byte) (i8 >> 2);
            } else if (i7 == 4) {
                this.f7316c = 6;
                return false;
            }
            this.f7316c = i7;
            this.f7313b = i10;
            return true;
        }

        public b(byte[] bArr) {
            this.f7312a = bArr;
            this.f7318e = f7314f;
            this.f7316c = 0;
            this.f7317d = 0;
        }
    }

    public static byte[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f7312a;

        /* renamed from: b, reason: collision with root package name */
        public int f7313b;

        a() {
        }
    }

    private static byte[] b(byte[] bArr, int i6) {
        b bVar = new b(new byte[(i6 * 3) / 4]);
        if (!bVar.a(bArr, i6)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i7 = bVar.f7313b;
        byte[] bArr2 = bVar.f7312a;
        if (i7 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr3, 0, i7);
        return bArr3;
    }

    private t9() {
    }
}
