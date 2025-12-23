package com.kuaishou.weapon.p0;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f35828a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f35829b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f35830c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35831d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35832e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final int f35833f = 16;

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f35834g = true;

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f35835h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    static class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f35838c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f35839d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private static final int f35840e = -1;

        /* renamed from: f, reason: collision with root package name */
        private static final int f35841f = -2;

        /* renamed from: g, reason: collision with root package name */
        private int f35842g;

        /* renamed from: h, reason: collision with root package name */
        private int f35843h;

        /* renamed from: i, reason: collision with root package name */
        private final int[] f35844i;

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i6) {
            return ((i6 * 3) / 4) + 10;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public boolean a(byte[] bArr, int i6, int i7, boolean z5) {
            int i8 = this.f35842g;
            if (i8 == 6) {
                return false;
            }
            int i9 = i7 + i6;
            int i10 = this.f35843h;
            byte[] bArr2 = this.f35836a;
            int[] iArr = this.f35844i;
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
                                this.f35842g = 6;
                                return false;
                            }
                        }
                        i11 = (i11 << 6) | i17;
                        i13++;
                    } else if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 == 4) {
                                if (i17 != -2) {
                                    if (i17 != -1) {
                                        this.f35842g = 6;
                                        return false;
                                    }
                                }
                                i13++;
                            } else if (i13 == 5 && i17 != -1) {
                                this.f35842g = 6;
                                return false;
                            }
                        } else if (i17 >= 0) {
                            i11 = (i11 << 6) | i17;
                            bArr2[i12 + 2] = (byte) i11;
                            bArr2[i12 + 1] = (byte) (i11 >> 8);
                            bArr2[i12] = (byte) (i11 >> 16);
                            i12 += 3;
                            i14 = i16;
                            i13 = 0;
                        } else if (i17 == -2) {
                            bArr2[i12 + 1] = (byte) (i11 >> 2);
                            bArr2[i12] = (byte) (i11 >> 10);
                            i12 += 2;
                            i14 = i16;
                            i13 = 5;
                        } else if (i17 != -1) {
                            this.f35842g = 6;
                            return false;
                        }
                    } else if (i17 >= 0) {
                        i11 = (i11 << 6) | i17;
                        i13++;
                    } else if (i17 == -2) {
                        bArr2[i12] = (byte) (i11 >> 4);
                        i12++;
                        i14 = i16;
                        i13 = 4;
                    } else if (i17 != -1) {
                        this.f35842g = 6;
                        return false;
                    }
                } else if (i17 >= 0) {
                    i13++;
                    i11 = i17;
                } else if (i17 != -1) {
                    this.f35842g = 6;
                    return false;
                }
                i14 = i16;
            }
            if (!z5) {
                this.f35842g = i13;
                this.f35843h = i11;
                this.f35837b = i12;
                return true;
            }
            if (i13 == 1) {
                this.f35842g = 6;
                return false;
            }
            if (i13 == 2) {
                bArr2[i12] = (byte) (i11 >> 4);
                i12++;
            } else if (i13 == 3) {
                int i18 = i12 + 1;
                bArr2[i12] = (byte) (i11 >> 10);
                i12 += 2;
                bArr2[i18] = (byte) (i11 >> 2);
            } else if (i13 == 4) {
                this.f35842g = 6;
                return false;
            }
            this.f35842g = i13;
            this.f35837b = i12;
            return true;
        }

        public b(int i6, byte[] bArr) {
            int[] iArr;
            this.f35836a = bArr;
            if ((i6 & 8) == 0) {
                iArr = f35838c;
            } else {
                iArr = f35839d;
            }
            this.f35844i = iArr;
            this.f35842g = 0;
            this.f35843h = 0;
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.c$c, reason: collision with other inner class name */
    static class C0549c extends a {

        /* renamed from: c, reason: collision with root package name */
        public static final int f35845c = 19;

        /* renamed from: h, reason: collision with root package name */
        static final /* synthetic */ boolean f35846h = true;

        /* renamed from: i, reason: collision with root package name */
        private static final byte[] f35847i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f35848j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: d, reason: collision with root package name */
        int f35849d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f35850e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f35851f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f35852g;

        /* renamed from: k, reason: collision with root package name */
        private final byte[] f35853k;

        /* renamed from: l, reason: collision with root package name */
        private int f35854l;

        /* renamed from: m, reason: collision with root package name */
        private final byte[] f35855m;

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i6) {
            return ((i6 * 8) / 5) + 10;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01d2 A[ADDED_TO_REGION] */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 522
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.C0549c.a(byte[], int, int, boolean):boolean");
        }

        public C0549c(int i6, byte[] bArr) {
            boolean z5;
            boolean z6;
            byte[] bArr2;
            int i7;
            this.f35836a = bArr;
            if ((i6 & 1) == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f35850e = z5;
            if ((i6 & 2) == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f35851f = z6;
            this.f35852g = (i6 & 4) != 0;
            if ((i6 & 8) == 0) {
                bArr2 = f35847i;
            } else {
                bArr2 = f35848j;
            }
            this.f35855m = bArr2;
            this.f35853k = new byte[2];
            this.f35849d = 0;
            if (z6) {
                i7 = 19;
            } else {
                i7 = -1;
            }
            this.f35854l = i7;
        }
    }

    public static byte[] a(String str, int i6) {
        return a(str.getBytes(), i6);
    }

    public static String b(String str, int i6) {
        try {
            return new String(a(str.getBytes(), i6));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] c(byte[] bArr, int i6) {
        try {
            return c(bArr, 0, bArr.length, i6);
        } catch (Throwable unused) {
            return null;
        }
    }

    static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f35836a;

        /* renamed from: b, reason: collision with root package name */
        public int f35837b;

        public abstract int a(int i6);

        public abstract boolean a(byte[] bArr, int i6, int i7, boolean z5);

        a() {
        }
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(byte[] bArr, int i6, int i7, int i8) {
        C0549c c0549c = new C0549c(i8, null);
        int i9 = (i7 / 3) * 4;
        if (!c0549c.f35850e) {
            int i10 = i7 % 3;
            if (i10 == 1) {
                i9 += 2;
            } else if (i10 == 2) {
                i9 += 3;
            }
        } else if (i7 % 3 > 0) {
            i9 += 4;
        }
        if (c0549c.f35851f && i7 > 0) {
            i9 += (((i7 - 1) / 57) + 1) * (c0549c.f35852g ? 2 : 1);
        }
        c0549c.f35836a = new byte[i9];
        c0549c.a(bArr, i6, i7, true);
        if (f35834g || c0549c.f35837b == i9) {
            return c0549c.f35836a;
        }
        throw new AssertionError();
    }

    private c() {
    }

    public static byte[] a(byte[] bArr, int i6) {
        return a(bArr, 0, bArr.length, i6);
    }

    public static String b(byte[] bArr, int i6) {
        try {
            return new String(c(bArr, i6), "US-ASCII");
        } catch (UnsupportedEncodingException e6) {
            throw new AssertionError(e6);
        }
    }

    public static byte[] a(byte[] bArr, int i6, int i7, int i8) {
        b bVar = new b(i8, new byte[(i7 * 3) / 4]);
        if (bVar.a(bArr, i6, i7, true)) {
            int i9 = bVar.f35837b;
            byte[] bArr2 = bVar.f35836a;
            if (i9 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i9];
            System.arraycopy(bArr2, 0, bArr3, 0, i9);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String b(byte[] bArr, int i6, int i7, int i8) {
        try {
            return new String(c(bArr, i6, i7, i8), "US-ASCII");
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(c(bArr, 0), str);
        } catch (UnsupportedEncodingException e6) {
            throw new AssertionError(e6);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    return f35835h.matcher(str).matches();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
