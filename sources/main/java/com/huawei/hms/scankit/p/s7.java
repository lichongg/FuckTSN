package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s7 extends q7 {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f34811i = {1, 1, 1, 1, 1, 1};

    /* renamed from: j, reason: collision with root package name */
    public static final int[][] f34812j = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: h, reason: collision with root package name */
    private final int[] f34813h = new int[4];

    private int b(r rVar, int[] iArr, int i6, int[][] iArr2) throws a {
        g5.a(rVar, i6, iArr);
        int length = iArr2.length;
        float f6 = 0.45f;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            float a6 = g5.a(iArr, iArr2[i8], 0.7f);
            if (a6 < f6) {
                i7 = i8;
                f6 = a6;
            }
        }
        if (i7 >= 0) {
            return i7;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int i6, int i7, r rVar) {
        return rVar.a(i7, (i7 - i6) + i7, false, true);
    }

    @Override // com.huawei.hms.scankit.p.q7
    protected int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.f34813h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e6 = rVar.e();
        int i6 = iArr[1];
        float f6 = 10000.0f;
        int i7 = 0;
        float f7 = 0.0f;
        for (int i8 = 0; i8 < 6 && i6 < e6; i8++) {
            int b6 = b(rVar, iArr2, i6, q7.f34721g);
            sb.append((char) ((b6 % 10) + 48));
            int i9 = 0;
            float f8 = 0.0f;
            while (true) {
                if (i9 >= q7.f34721g[b6].length) {
                    break;
                }
                f8 += r4[i9];
                i9++;
            }
            float f9 = (((iArr2[0] + iArr2[1]) + iArr2[2]) + iArr2[3]) / f8;
            if (f9 > f7) {
                f7 = f9;
            }
            if (f9 < f6) {
                f6 = f9;
            }
            for (int i10 : iArr2) {
                i6 += i10;
            }
            if (b6 >= 10) {
                i7 |= 1 << (5 - i8);
            }
        }
        if (f7 / f6 > 2.89d) {
            throw a.a();
        }
        a(sb, i7);
        return i6;
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c6 = cArr[5];
        switch (c6) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c6);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c6);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    @Override // com.huawei.hms.scankit.p.q7
    protected int[] a(r rVar, int i6) throws a {
        return q7.a(rVar, i6, true, f34811i);
    }

    @Override // com.huawei.hms.scankit.p.q7
    protected boolean a(String str) throws a {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i6) throws a {
        for (int i7 = 0; i7 <= 1; i7++) {
            for (int i8 = 0; i8 < 10; i8++) {
                if (i6 == f34812j[i7][i8]) {
                    sb.insert(0, (char) (i7 + 48));
                    sb.append((char) (i8 + 48));
                    return;
                }
            }
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    BarcodeFormat a() {
        return BarcodeFormat.UPC_E;
    }

    @Override // com.huawei.hms.scankit.p.q7
    boolean a(int[] iArr, int[] iArr2) throws a {
        int i6 = iArr[1];
        int i7 = iArr[0];
        double d6 = (i6 - i7) / 3.0d;
        int i8 = iArr2[1];
        int i9 = iArr2[0];
        return ((double) Math.abs(((int) Math.round(((double) (i8 - i7)) / (((double) ((i8 - i9) + (i6 - i7))) / 9.0d))) + (-51))) <= 10.200000000000001d && Math.abs(1.0d - (d6 / (((double) (i8 - i9)) / 6.0d))) < 0.2d;
    }
}
