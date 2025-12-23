package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o2 extends q7 {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f34642j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    private String f34644i = "";

    /* renamed from: h, reason: collision with root package name */
    private final int[] f34643h = new int[4];

    @Override // com.huawei.hms.scankit.p.q7
    boolean a(int i6, int i7, r rVar) {
        return rVar.a(i7, (i7 - i6) + i7, false, false);
    }

    @Override // com.huawei.hms.scankit.p.q7
    protected int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.f34643h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e6 = rVar.e();
        int i6 = iArr[1];
        int i7 = 0;
        for (int i8 = 0; i8 < 6 && i6 < e6; i8++) {
            int a6 = q7.a(rVar, iArr2, i6, q7.f34721g);
            sb.append((char) ((a6 % 10) + 48));
            for (int i9 : iArr2) {
                i6 += i9;
            }
            if (a6 >= 10) {
                i7 |= 1 << (5 - i8);
            }
        }
        a(sb, i7);
        this.f34644i = sb.substring(0, 1);
        int i10 = q7.a(rVar, i6, true, q7.f34718d)[1];
        for (int i11 = 0; i11 < 6 && i10 < e6; i11++) {
            sb.append((char) (q7.a(rVar, iArr2, i10, q7.f34720f) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        if (a(sb)) {
            return i10;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    BarcodeFormat a() {
        return BarcodeFormat.EAN_13;
    }

    private static void a(StringBuilder sb, int i6) throws a {
        for (int i7 = 0; i7 < 10; i7++) {
            if (i6 == f34642j[i7]) {
                sb.insert(0, (char) (i7 + 48));
                return;
            }
        }
        throw a.a();
    }

    private static boolean a(StringBuilder sb) {
        int charAt = sb.charAt(sb.length() - 1) - '0';
        int i6 = 0;
        for (int i7 = 0; i7 < sb.length() - 1; i7++) {
            i6 += i7 % 2 == 0 ? sb.charAt(i7) - '0' : (sb.charAt(i7) - '0') * 3;
        }
        return (i6 + charAt) % 10 == 0;
    }

    @Override // com.huawei.hms.scankit.p.q7
    boolean a(int[] iArr, int[] iArr2) throws a {
        int i6 = iArr2[1] - iArr2[0];
        int i7 = iArr[1];
        int i8 = iArr[0];
        int round = (int) Math.round((r1 - i8) / ((i6 + (i7 - i8)) / 6.0d));
        return this.f34644i.equals("0") ? ((double) Math.abs(round + (-95))) <= 18.05d || ((double) Math.abs(round + (-113))) <= 21.47d : ((double) Math.abs(round + (-95))) <= 18.05d;
    }
}
