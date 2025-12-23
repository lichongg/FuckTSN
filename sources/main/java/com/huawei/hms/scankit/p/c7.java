package com.huawei.hms.scankit.p;

import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class c7 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34090a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f34091b;

    public static String a(byte[] bArr, Map<l1, ?> map) {
        int i6;
        int[] iArr;
        boolean z5;
        if (map != null) {
            l1 l1Var = l1.f34510h;
            if (map.containsKey(l1Var)) {
                return map.get(l1Var).toString();
            }
        }
        int[] iArr2 = new int[15];
        iArr2[0] = bArr.length;
        iArr2[1] = 1;
        iArr2[2] = 1;
        iArr2[3] = 1;
        boolean z6 = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
        int i7 = 0;
        while (true) {
            i6 = iArr2[0];
            if (i7 >= i6 || !(iArr2[1] == 1 || iArr2[2] == 1 || iArr2[3] == 1)) {
                break;
            }
            int i8 = bArr[i7] & 255;
            c(i8, iArr2);
            b(i8, iArr2);
            a(i8, iArr2);
            i7++;
        }
        if (iArr2[3] == 1) {
            iArr = iArr2;
            z5 = true;
        } else {
            iArr = iArr2;
            z5 = false;
        }
        return a(bArr, z5, iArr[2] == 1, iArr[1] == 1, iArr[4], iArr[8], z6, iArr[5], iArr[6], iArr[7], iArr[12], iArr[13], iArr[9], iArr[14], i6);
    }

    private static void b(int i6, int[] iArr) {
        if (iArr[2] == 1) {
            int i7 = iArr[8];
            if (i7 > 0) {
                if (i6 < 64 || i6 == 127 || i6 > 252) {
                    iArr[2] = 0;
                    return;
                } else {
                    iArr[8] = i7 - 1;
                    return;
                }
            }
            if (i6 == 128 || i6 == 160 || i6 > 239) {
                iArr[2] = 0;
                return;
            }
            if (i6 > 160 && i6 < 224) {
                iArr[9] = iArr[9] + 1;
                iArr[11] = 0;
                int i8 = iArr[10] + 1;
                iArr[10] = i8;
                if (i8 > iArr[12]) {
                    iArr[12] = i8;
                    return;
                }
                return;
            }
            if (i6 <= 127) {
                iArr[10] = 0;
                iArr[11] = 0;
                return;
            }
            iArr[8] = i7 + 1;
            iArr[10] = 0;
            int i9 = iArr[11] + 1;
            iArr[11] = i9;
            if (i9 > iArr[13]) {
                iArr[13] = i9;
            }
        }
    }

    private static void c(int i6, int[] iArr) {
        if (iArr[3] == 1) {
            int i7 = iArr[4];
            if (i7 > 0) {
                if ((i6 & 128) == 0) {
                    iArr[3] = 0;
                    return;
                } else {
                    iArr[4] = i7 - 1;
                    return;
                }
            }
            if ((i6 & 128) != 0) {
                if ((i6 & 64) == 0) {
                    iArr[3] = 0;
                    return;
                }
                iArr[4] = i7 + 1;
                if ((i6 & 32) == 0) {
                    iArr[5] = iArr[5] + 1;
                    return;
                }
                iArr[4] = i7 + 2;
                if ((i6 & 16) == 0) {
                    iArr[6] = iArr[6] + 1;
                    return;
                }
                iArr[4] = i7 + 3;
                if ((i6 & 8) == 0) {
                    iArr[7] = iArr[7] + 1;
                } else {
                    iArr[3] = 0;
                }
            }
        }
    }

    static {
        boolean z5;
        String name = Charset.defaultCharset().name();
        f34090a = name;
        if (!"SJIS".equalsIgnoreCase(name) && !"EUC_JP".equalsIgnoreCase(name)) {
            z5 = false;
        } else {
            z5 = true;
        }
        f34091b = z5;
    }

    private static void a(int i6, int[] iArr) {
        if (iArr[1] == 1) {
            if (i6 > 127 && i6 < 160) {
                iArr[1] = 0;
                return;
            }
            if (i6 > 159) {
                if (i6 < 192 || i6 == 215 || i6 == 247) {
                    iArr[14] = iArr[14] + 1;
                }
            }
        }
    }

    public static String a(byte[] bArr, boolean z5, boolean z6, boolean z7, int i6, int i7, boolean z8, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        if (z5 && i6 > 0) {
            z5 = false;
        }
        if (z6 && i7 > 0) {
            z6 = false;
        }
        if (z5 && (z8 || i8 + i9 + i10 > 0)) {
            return "UTF8";
        }
        if (a(bArr).booleanValue()) {
            return "GBK";
        }
        if (z6 && (f34091b || i11 >= 3 || i12 >= 3)) {
            return "SJIS";
        }
        if (z7 && z6) {
            return (!(i11 == 2 && i13 == 2) && i14 * 10 < i15) ? "ISO8859_1" : "SJIS";
        }
        if (z7 && i14 * 10 < i15) {
            return "ISO8859_1";
        }
        if (z6) {
            return "SJIS";
        }
        if (z5) {
            return "UTF8";
        }
        if (!z5 && "UTF-8".equals(f34090a)) {
            return "GB2312";
        }
        return f34090a;
    }

    public static Boolean a(byte[] bArr) {
        int length = bArr.length;
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                z5 = true;
                break;
            }
            byte b6 = bArr[i6];
            if ((b6 & 128) != 0) {
                int i7 = b6 & 255;
                if ((i7 < 170 && i7 > 160) || (i7 < 248 && i7 > 175)) {
                    i6++;
                    if (i6 >= length) {
                        break;
                    }
                    byte b7 = bArr[i6];
                    if ((b7 & 255) >= 255 || (b7 & 255) <= 160 || (b7 & 255) == 127) {
                        break;
                    }
                } else if (i7 < 161 && i7 > 128) {
                    i6++;
                    if (i6 >= length) {
                        break;
                    }
                    byte b8 = bArr[i6];
                    if ((b8 & 255) >= 255 || (b8 & 255) <= 63 || (b8 & 255) == 127) {
                        break;
                    }
                } else {
                    if (((i7 >= 255 || i7 <= 169) && (i7 >= 170 || i7 <= 167)) || (i6 = i6 + 1) >= length) {
                        break;
                    }
                    byte b9 = bArr[i6];
                    if ((b9 & 255) >= 161 || (b9 & 255) <= 63 || (b9 & 255) == 127) {
                        break;
                    }
                }
            }
            i6++;
        }
        return Boolean.valueOf(z5);
    }
}
