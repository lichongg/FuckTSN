package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r0 extends g5 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f34727a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static boolean a(r rVar, int i6, int i7) {
        return rVar.a(i6, i7, false, false);
    }

    private static float b(r rVar, int[] iArr, int i6) {
        int[] iArr2 = new int[7];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i7 : iArr) {
            i6 += i7;
        }
        boolean z5 = true;
        int i8 = 0;
        while (z5 && i6 < rVar.e()) {
            if (rVar.b(i6)) {
                i8++;
                i6++;
            } else {
                iArr2[6] = i8;
                z5 = false;
            }
        }
        int[][] iArr3 = f34727a;
        return g5.a(iArr2, iArr3[iArr3.length - 1], 0.7f);
    }

    private int[] c(StringBuilder sb, int[] iArr) throws a {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = iArr[0];
        int i12 = iArr[1] != 1 ? 0 : 1;
        int i13 = iArr[2] != 1 ? 0 : 1;
        int i14 = iArr[3] == 1 ? 1 : 0;
        int i15 = iArr[4];
        if (iArr[5] == 1) {
            i6 = i15;
            i7 = 1;
        } else {
            i6 = i15;
            i7 = 0;
        }
        int i16 = iArr[6] == 1 ? 1 : 0;
        if (i11 >= 100) {
            int i17 = i11 == 106 ? i14 : 0;
            if (i11 != 106) {
                switch (i11) {
                    case 100:
                        i10 = i16;
                        i8 = i17;
                        i9 = 100;
                        break;
                    case 101:
                        i10 = i16;
                        i8 = i17;
                        i9 = 101;
                        break;
                    case 102:
                        i8 = i17;
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i8 = i17;
                i9 = i6;
                i10 = 1;
            }
            return new int[]{i11, i12, i13, i8, i9, i7, i10};
        }
        if (i11 < 10) {
            sb.append('0');
        }
        sb.append(i11);
        i8 = i14;
        i9 = i6;
        i10 = i16;
        return new int[]{i11, i12, i13, i8, i9, i7, i10};
    }

    private static int[] a(r rVar) throws a {
        int e6 = rVar.e();
        int c6 = rVar.c(0);
        int[] iArr = new int[6];
        int i6 = c6;
        boolean z5 = false;
        int i7 = 0;
        while (c6 < e6) {
            if (rVar.b(c6) != z5) {
                iArr[i7] = iArr[i7] + 1;
            } else {
                if (i7 == 5) {
                    int i8 = -1;
                    float f6 = 0.25f;
                    for (int i9 = 103; i9 <= 105; i9++) {
                        float a6 = g5.a(iArr, f34727a[i9], 0.7f);
                        if (a6 < f6) {
                            i8 = i9;
                            f6 = a6;
                        }
                    }
                    if (i8 >= 0) {
                        return new int[]{i6, c6, i8};
                    }
                    i6 += iArr[0] + iArr[1];
                    int i10 = i7 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i10);
                    iArr[i10] = 0;
                    iArr[i7] = 0;
                    i7--;
                } else {
                    i7++;
                }
                iArr[i7] = 1;
                z5 = !z5;
            }
            c6++;
        }
        throw a.a();
    }

    private int[] b(StringBuilder sb, int[] iArr) throws a {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = iArr[0];
        int i12 = 1;
        int i13 = iArr[1] == 1 ? 1 : 0;
        int i14 = iArr[2] == 1 ? 1 : 0;
        int i15 = iArr[3] == 1 ? 1 : 0;
        int i16 = iArr[4];
        int i17 = iArr[5] == 1 ? 1 : 0;
        int i18 = iArr[6] == 1 ? 1 : 0;
        if (i11 >= 96) {
            if (i11 != 106) {
                i15 = 0;
            }
            if (i11 != 106) {
                switch (i11) {
                    case 96:
                    case 97:
                    case 102:
                        i12 = i13;
                        i6 = i14;
                        i7 = i15;
                        i8 = i16;
                        i9 = i17;
                        break;
                    case 98:
                        i10 = i18;
                        i12 = i13;
                        i6 = i14;
                        i7 = i15;
                        i8 = 101;
                        i9 = 1;
                        break;
                    case 99:
                        i12 = i13;
                        i6 = i14;
                        i7 = i15;
                        i9 = i17;
                        i8 = 99;
                        break;
                    case 100:
                        if (i14 == 0 && i13 != 0) {
                            i7 = i15;
                            i8 = i16;
                            i9 = i17;
                            i12 = 0;
                            i6 = 1;
                            break;
                        } else {
                            if (i14 != 0 && i13 != 0) {
                                i7 = i15;
                                i8 = i16;
                                i9 = i17;
                                i12 = 0;
                                i6 = 0;
                                break;
                            }
                            i6 = i14;
                            i7 = i15;
                            i8 = i16;
                            i9 = i17;
                            break;
                        }
                    case 101:
                        i12 = i13;
                        i6 = i14;
                        i7 = i15;
                        i9 = i17;
                        i8 = 101;
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i12 = i13;
                i6 = i14;
                i7 = i15;
                i8 = i16;
                i9 = i17;
                i10 = 1;
            }
            return new int[]{i11, i12, i6, i7, i8, i9, i10};
        }
        if (i13 == i14) {
            sb.append((char) (i11 + 32));
        } else {
            sb.append((char) (i11 + 160));
        }
        i6 = i14;
        i7 = i15;
        i8 = i16;
        i9 = i17;
        i12 = 0;
        i10 = i18;
        return new int[]{i11, i12, i6, i7, i8, i9, i10};
    }

    private static int a(r rVar, int[] iArr, int i6) throws a {
        float a6;
        g5.a(rVar, i6, iArr);
        float f6 = 0.25f;
        int i7 = -1;
        int i8 = 0;
        while (true) {
            int[][] iArr2 = f34727a;
            if (i8 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i8];
            if (i8 == iArr2.length - 1) {
                a6 = b(rVar, iArr, i6);
            } else {
                a6 = g5.a(iArr, iArr3, 0.7f);
            }
            if (a6 < f6) {
                i7 = i8;
                f6 = a6;
            }
            i8++;
        }
        if (i7 >= 0) {
            return i7;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        r rVar2;
        int[] a6 = a(rVar);
        int i7 = a6[0];
        int i8 = i7 - (((a6[1] - i7) / 11) * 10);
        if (i8 <= 0 || i8 >= i7) {
            rVar2 = rVar;
        } else {
            rVar2 = rVar;
            if (!a(rVar2, i8, i7)) {
                throw a.a();
            }
        }
        int i9 = a6[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i9));
        int i10 = i9 == 103 ? 101 : i9 == 104 ? 100 : i9 == 105 ? 99 : 0;
        if (i10 != 0) {
            int i11 = i10;
            StringBuilder sb = new StringBuilder(20);
            int[] iArr = new int[7];
            iArr[6] = i11;
            a(sb, a6, iArr, i9, rVar2, arrayList);
            int i12 = iArr[0];
            int i13 = iArr[1];
            int i14 = iArr[2];
            int i15 = iArr[3];
            int i16 = iArr[4];
            boolean z5 = iArr[5] == 1;
            int i17 = iArr[6];
            int i18 = i13 - i12;
            if ((i15 - (i16 * i14)) % 103 == i14) {
                int length = sb.length();
                if (length != 0) {
                    if (length > 0 && z5) {
                        if (i17 == 99) {
                            sb.delete(length - 2, length);
                        } else {
                            sb.delete(length - 1, length);
                        }
                    }
                    float f6 = a6[0];
                    float f7 = i12 + ((i18 * 13) / 11);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i19 = 0; i19 < size; i19++) {
                        bArr[i19] = arrayList.get(i19).byteValue();
                    }
                    float f8 = i6;
                    return new s6(sb.toString(), bArr, new u6[]{new u6(f6, f8), new u6(f7, f8)}, BarcodeFormat.CODE_128);
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private void a(StringBuilder sb, int[] iArr, int[] iArr2, int i6, r rVar, List<Byte> list) throws a {
        int i7;
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = 6;
        int[] iArr3 = new int[6];
        int i11 = iArr2[6];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        boolean z5 = false;
        int i18 = 0;
        int i19 = i9;
        int i20 = i8;
        int i21 = i6;
        while (i12 == 0) {
            int a6 = a(rVar, iArr3, i19);
            list.add(Byte.valueOf((byte) a6));
            if (a6 != 106) {
                i14++;
                i21 += i14 * a6;
                i15 = 1;
            }
            int i22 = i19;
            for (int i23 = 0; i23 < i10; i23++) {
                i22 += iArr3[i23];
            }
            if (a6 != 105) {
                int[] iArr4 = new int[7];
                iArr4[0] = a6;
                iArr4[1] = i16;
                iArr4[2] = i17;
                iArr4[3] = i15;
                iArr4[4] = i11;
                iArr4[5] = 0;
                iArr4[i10] = i12;
                if (i11 == 101) {
                    iArr4 = a(sb, iArr4);
                } else if (i11 == 100) {
                    iArr4 = b(sb, iArr4);
                } else if (i11 == 99) {
                    iArr4 = c(sb, iArr4);
                }
                int i24 = iArr4[0];
                int i25 = iArr4[1] == 1 ? 1 : 0;
                i17 = iArr4[2] == 1 ? 1 : 0;
                int i26 = iArr4[3] == 1 ? 1 : 0;
                boolean z6 = iArr4[5] == 1;
                i12 = iArr4[6] == 1 ? 1 : 0;
                if (z5) {
                    i7 = iArr4[4] == 101 ? 100 : 101;
                } else {
                    i7 = iArr4[4];
                }
                int i27 = i18;
                i18 = i24;
                i11 = i7;
                i13 = i27;
                z5 = z6;
                i16 = i25;
                i10 = 6;
                i15 = i26;
                i20 = i19;
                i19 = i22;
            } else {
                throw a.a();
            }
        }
        iArr2[0] = i20;
        iArr2[1] = i19;
        iArr2[2] = i13;
        iArr2[3] = i21;
        iArr2[4] = i14;
        iArr2[5] = i15;
        iArr2[6] = i11;
    }

    private int[] a(StringBuilder sb, int[] iArr) throws a {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = iArr[0];
        int i12 = 1;
        int i13 = iArr[1] == 1 ? 1 : 0;
        int i14 = iArr[2] == 1 ? 1 : 0;
        int i15 = iArr[3] == 1 ? 1 : 0;
        int i16 = iArr[4];
        int i17 = iArr[5] == 1 ? 1 : 0;
        int i18 = iArr[6] == 1 ? 1 : 0;
        if (i11 < 64) {
            if (i13 == i14) {
                sb.append((char) (i11 + 32));
            } else {
                sb.append((char) (i11 + 160));
            }
        } else {
            if (i11 >= 96) {
                if (i11 != 106) {
                    i15 = 0;
                }
                if (i11 != 106) {
                    switch (i11) {
                        case 96:
                        case 97:
                        case 102:
                            i12 = i13;
                            i6 = i14;
                            i7 = i15;
                            i8 = i16;
                            i9 = i17;
                            i10 = i18;
                            break;
                        case 98:
                            i10 = i18;
                            i12 = i13;
                            i6 = i14;
                            i7 = i15;
                            i8 = 100;
                            i9 = 1;
                            break;
                        case 99:
                            i12 = i13;
                            i6 = i14;
                            i7 = i15;
                            i9 = i17;
                            i8 = 99;
                            i10 = i18;
                            break;
                        case 100:
                            i12 = i13;
                            i6 = i14;
                            i7 = i15;
                            i9 = i17;
                            i8 = 100;
                            i10 = i18;
                            break;
                        case 101:
                            if (i14 != 0 || i13 == 0) {
                                if (i14 != 0 && i13 != 0) {
                                    i7 = i15;
                                    i8 = i16;
                                    i9 = i17;
                                    i12 = 0;
                                    i6 = 0;
                                }
                                i6 = i14;
                                i7 = i15;
                                i8 = i16;
                                i9 = i17;
                            } else {
                                i7 = i15;
                                i8 = i16;
                                i9 = i17;
                                i12 = 0;
                                i6 = 1;
                            }
                            i10 = i18;
                            break;
                        default:
                            throw a.a();
                    }
                } else {
                    i12 = i13;
                    i6 = i14;
                    i7 = i15;
                    i8 = i16;
                    i9 = i17;
                    i10 = 1;
                }
                return new int[]{i11, i12, i6, i7, i8, i9, i10};
            }
            if (i13 == i14) {
                sb.append((char) (i11 - 64));
            } else {
                sb.append((char) (i11 + 64));
            }
        }
        i6 = i14;
        i7 = i15;
        i8 = i16;
        i9 = i17;
        i12 = 0;
        i10 = i18;
        return new int[]{i11, i12, i6, i7, i8, i9, i10};
    }
}
