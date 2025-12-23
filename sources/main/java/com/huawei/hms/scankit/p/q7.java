package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class q7 extends g5 {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f34717c = {1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f34718d = {1, 1, 1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f34719e = {1, 1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    public static final int[][] f34720f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f34721g;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f34722a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final p7 f34723b = new p7();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f34720f = iArr;
        int[][] iArr2 = new int[20][];
        f34721g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i6 = 10; i6 < 20; i6++) {
            int[] iArr3 = f34720f[i6 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i7 = 0; i7 < iArr3.length; i7++) {
                iArr4[i7] = iArr3[(iArr3.length - i7) - 1];
            }
            f34721g[i6] = iArr4;
        }
    }

    static int[] a(r rVar) throws a {
        return b(rVar, 0);
    }

    static ArrayList<int[]> b(r rVar) throws a {
        int e6 = rVar.e() / 2;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i6 = 0;
        while (i6 < e6) {
            try {
                int[] b6 = b(rVar, i6);
                arrayList.add(b6);
                i6 = b6[0] + 1;
            } catch (a unused) {
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw a.a();
    }

    protected abstract int a(r rVar, int[] iArr, StringBuilder sb) throws a;

    abstract BarcodeFormat a();

    abstract boolean a(int i6, int i7, r rVar);

    abstract boolean a(int[] iArr, int[] iArr2) throws a;

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        return a(i6, rVar, a(rVar), map);
    }

    protected q7() {
    }

    public s6 a(int i6, r rVar, int[] iArr, Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.f34512j);
        if (v6Var != null) {
            v6Var.a(new u6((iArr[0] + iArr[1]) / 2.0f, i6));
        }
        StringBuilder sb = this.f34722a;
        sb.setLength(0);
        int a6 = a(rVar, iArr, sb);
        if (v6Var != null) {
            v6Var.a(new u6(a6, i6));
        }
        int[] a7 = a(rVar, a6);
        if (a7[0] - a6 <= 1) {
            if (v6Var != null) {
                v6Var.a(new u6((a7[0] + a7[1]) / 2.0f, i6));
            }
            if (a(iArr, a7)) {
                int i7 = a7[1];
                if ((i7 - a7[0]) + i7 < rVar.e() && a(a7[0], i7, rVar)) {
                    String sb2 = sb.toString();
                    if (sb2.length() >= 8) {
                        if (a(sb2)) {
                            float f6 = i6;
                            s6 s6Var = new s6(sb2, null, new u6[]{new u6(iArr[0], f6), new u6(a7[1], f6)}, a());
                            a(s6Var, a7, i6, rVar, map);
                            return s6Var;
                        }
                        throw a.a();
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    static int[] b(r rVar, int i6) throws a {
        int[] iArr = new int[f34717c.length];
        int[] iArr2 = null;
        boolean z5 = false;
        while (!z5) {
            int[] iArr3 = f34717c;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = a(rVar, i6, false, iArr3, iArr);
            int i7 = iArr2[0];
            int i8 = iArr2[1];
            int i9 = i7 - (i8 - i7);
            int i10 = i9 + 3;
            while (i9 <= i10 && (i9 < 0 || !(z5 = rVar.a(i9, i7, false, true)))) {
                i9++;
            }
            i6 = i8;
        }
        return iArr2;
    }

    public static int b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        int i6 = 0;
        for (int i7 = length - 1; i7 >= 0; i7 -= 2) {
            int charAt = charSequence.charAt(i7) - '0';
            if (charAt < 0 || charAt > 9) {
                throw a.a();
            }
            i6 += charAt;
        }
        int i8 = i6 * 3;
        for (int i9 = length - 2; i9 >= 0; i9 -= 2) {
            int charAt2 = charSequence.charAt(i9) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw a.a();
            }
            i8 += charAt2;
        }
        return (1000 - i8) % 10;
    }

    private void a(s6 s6Var, int[] iArr, int i6, r rVar, Map<l1, ?> map) throws a {
        int i7;
        try {
            s6 a6 = this.f34723b.a(i6, rVar, iArr[1]);
            s6Var.a(a6.j());
            i7 = a6.k().length();
        } catch (a unused) {
            i7 = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(l1.f34513k);
        if (iArr2 != null) {
            for (int i8 : iArr2) {
                if (i7 == i8) {
                    return;
                }
            }
            throw a.a();
        }
    }

    boolean a(String str) throws a {
        return a((CharSequence) str);
    }

    public static boolean a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i6 = length - 1;
        return b(charSequence.subSequence(0, i6)) == Character.digit(charSequence.charAt(i6), 10);
    }

    int[] a(r rVar, int i6) throws a {
        return a(rVar, i6, false, f34717c);
    }

    static int[] a(r rVar, int i6, boolean z5, int[] iArr) throws a {
        return a(rVar, i6, z5, iArr, new int[iArr.length]);
    }

    private static int[] a(r rVar, int i6, boolean z5, int[] iArr, int[] iArr2) throws a {
        int e6 = rVar.e();
        int d6 = z5 ? rVar.d(i6) : rVar.c(i6);
        int length = iArr.length;
        boolean z6 = z5;
        int i7 = 0;
        int i8 = d6;
        while (d6 < e6) {
            if (rVar.b(d6) != z6) {
                if (i7 >= 0 && i7 < iArr2.length) {
                    iArr2[i7] = iArr2[i7] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (g5.a(iArr2, iArr, 0.8f) < 0.46f) {
                        return new int[]{i8, d6};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z6 = !z6;
            }
            d6++;
        }
        throw a.a();
    }

    static int a(r rVar, int[] iArr, int i6, int[][] iArr2) throws a {
        g5.a(rVar, i6, iArr);
        int length = iArr2.length;
        float f6 = 0.46f;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            float a6 = g5.a(iArr, iArr2[i8], 0.8f);
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
}
