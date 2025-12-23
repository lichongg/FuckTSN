package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p0 extends g5 {

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f34668e = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f34669f = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: g, reason: collision with root package name */
    private static final char[] f34670g = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f34671a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private int[] f34672b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    private int f34673c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f34674d;

    private int b() throws a {
        for (int i6 = 1; i6 < this.f34673c; i6 += 2) {
            int b6 = b(i6);
            if (b6 != -1 && a(f34670g, f34668e[b6])) {
                int i7 = 0;
                for (int i8 = i6; i8 < i6 + 7; i8++) {
                    i7 += this.f34672b[i8];
                }
                if (i6 == 1 || this.f34672b[i6 - 1] >= i7 / 2) {
                    return i6;
                }
            }
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        Arrays.fill(this.f34672b, 0);
        a(rVar);
        int[] a6 = a();
        int i7 = a6[0];
        int i8 = a6[1];
        for (int i9 = 0; i9 < this.f34671a.length(); i9++) {
            StringBuilder sb = this.f34671a;
            sb.setCharAt(i9, f34668e[sb.charAt(i9)]);
        }
        char charAt = this.f34671a.charAt(0);
        char[] cArr = f34670g;
        if (!a(cArr, charAt)) {
            throw a.a();
        }
        StringBuilder sb2 = this.f34671a;
        if (!a(cArr, sb2.charAt(sb2.length() - 1))) {
            throw a.a();
        }
        if (this.f34671a.length() <= 3) {
            throw a.a();
        }
        int i10 = this.f34674d;
        for (int i11 = 0; i11 < i7; i11++) {
            i10 += this.f34672b[i11];
        }
        float f6 = i10;
        while (i7 < i8 - 1) {
            i10 += this.f34672b[i7];
            i7++;
        }
        float f7 = i6;
        return new s6(this.f34671a.toString(), null, new u6[]{new u6(f6, f7), new u6(i10, f7)}, BarcodeFormat.CODABAR);
    }

    private void c(int i6) throws a {
        int[] iArr = new int[4];
        int i7 = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f34671a.length() - 1;
        int i8 = i6;
        int i9 = 0;
        while (true) {
            int i10 = f34669f[this.f34671a.charAt(i9)];
            for (int i11 = 6; i11 >= 0; i11--) {
                int i12 = (i11 & 1) + ((i10 & 1) * 2);
                iArr[i12] = iArr[i12] + this.f34672b[i8 + i11];
                iArr2[i12] = iArr2[i12] + 1;
                i10 >>= 1;
            }
            if (i9 >= length) {
                break;
            }
            i8 += 8;
            i9++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i13 = 0; i13 < 2; i13++) {
            fArr2[i13] = 0.0f;
            int i14 = i13 + 2;
            int i15 = iArr[i14];
            int i16 = iArr2[i14];
            float f6 = ((iArr[i13] / iArr2[i13]) + (i15 / i16)) / 2.0f;
            fArr2[i14] = f6;
            fArr[i13] = f6;
            fArr[i14] = ((i15 * 2.0f) + 1.5f) / i16;
        }
        int i17 = i6;
        loop3: while (true) {
            int i18 = f34669f[this.f34671a.charAt(i7)];
            for (int i19 = 6; i19 >= 0; i19--) {
                int i20 = (i19 & 1) + ((i18 & 1) * 2);
                float f7 = this.f34672b[i17 + i19];
                if (f7 < fArr2[i20] || f7 > fArr[i20]) {
                    break loop3;
                }
                i18 >>= 1;
            }
            if (i7 >= length) {
                return;
            }
            i17 += 8;
            i7++;
        }
        throw a.a();
    }

    private int b(int i6) {
        int i7 = i6 + 7;
        if (i7 >= this.f34673c) {
            return -1;
        }
        int[] iArr = this.f34672b;
        HashSet hashSet = new HashSet();
        for (int i8 = i6; i8 < i7; i8++) {
            hashSet.add(Integer.valueOf(iArr[i8]));
        }
        Iterator it = hashSet.iterator();
        int i9 = 0;
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Integer) it.next()).intValue();
        }
        if (hashSet.size() > 0) {
            int size = i10 / hashSet.size();
            int i11 = 128;
            int i12 = 0;
            for (int i13 = 0; i13 < 7; i13++) {
                i11 >>= 1;
                if (iArr[i6 + i13] > size) {
                    i12 |= i11;
                }
            }
            while (true) {
                int[] iArr2 = f34669f;
                if (i9 >= iArr2.length) {
                    break;
                }
                if (iArr2[i9] == i12) {
                    return i9;
                }
                i9++;
            }
        }
        return -1;
    }

    private int[] a() throws a {
        int i6;
        int b6 = b();
        int i7 = 0;
        this.f34671a.setLength(0);
        int i8 = b6;
        while (true) {
            int b7 = b(i8);
            if (b7 != -1) {
                this.f34671a.append((char) b7);
                i6 = i8 + 8;
                if ((this.f34671a.length() <= 1 || !a(f34670g, f34668e[b7])) && i6 < this.f34673c) {
                    i8 = i6;
                }
            } else {
                throw a.a();
            }
        }
        int i9 = this.f34672b[i8 + 7];
        for (int i10 = -8; i10 < -1; i10++) {
            i7 += this.f34672b[i6 + i10];
        }
        if (i6 < this.f34673c && i9 < i7 / 2) {
            throw a.a();
        }
        c(b6);
        return new int[]{b6, i6};
    }

    private void a(r rVar) throws a {
        int i6 = 0;
        this.f34673c = 0;
        int d6 = rVar.d(0);
        this.f34674d = d6;
        int e6 = rVar.e();
        if (d6 < e6) {
            boolean z5 = true;
            while (d6 < e6) {
                if (rVar.b(d6) != z5) {
                    i6++;
                } else {
                    a(i6);
                    z5 = !z5;
                    i6 = 1;
                }
                d6++;
            }
            a(i6);
            return;
        }
        throw a.a();
    }

    private void a(int i6) throws a {
        try {
            int[] iArr = this.f34672b;
            int i7 = this.f34673c;
            iArr[i7] = i6;
            int i8 = i7 + 1;
            this.f34673c = i8;
            if (i8 >= iArr.length) {
                int[] iArr2 = new int[i8 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i8);
                this.f34672b = iArr2;
            }
        } catch (NumberFormatException unused) {
            throw a.a();
        }
    }

    public static boolean a(char[] cArr, char c6) {
        if (cArr != null) {
            for (char c7 : cArr) {
                if (c7 == c6) {
                    return true;
                }
            }
        }
        return false;
    }
}
