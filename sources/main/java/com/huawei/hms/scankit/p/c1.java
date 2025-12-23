package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.a8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class c1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34064a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f34065b;

    static c1[] a(byte[] bArr, a8 a8Var, c3 c3Var) {
        if (bArr.length != a8Var.l()) {
            throw new IllegalArgumentException();
        }
        a8.b a6 = a8Var.a(c3Var);
        a8.a[] a7 = a6.a();
        int i6 = 0;
        for (a8.a aVar : a7) {
            i6 += aVar.a();
        }
        c1[] c1VarArr = new c1[i6];
        int i7 = 0;
        for (a8.a aVar2 : a7) {
            int i8 = 0;
            while (i8 < aVar2.a()) {
                int b6 = aVar2.b();
                c1VarArr[i7] = new c1(b6, new byte[a6.b() + b6]);
                i8++;
                i7++;
            }
        }
        int length = c1VarArr[0].f34065b.length;
        int i9 = i6 - 1;
        while (i9 >= 0 && c1VarArr[i9].f34065b.length != length) {
            i9--;
        }
        int i10 = i9 + 1;
        int b7 = length - a6.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b7; i12++) {
            int i13 = 0;
            while (i13 < i7) {
                c1VarArr[i13].f34065b[i12] = bArr[i11];
                i13++;
                i11++;
            }
        }
        int i14 = i10;
        while (i14 < i7) {
            c1VarArr[i14].f34065b[b7] = bArr[i11];
            i14++;
            i11++;
        }
        int length2 = c1VarArr[0].f34065b.length;
        while (b7 < length2) {
            int i15 = 0;
            while (i15 < i7) {
                c1VarArr[i15].f34065b[i15 < i10 ? b7 : b7 + 1] = bArr[i11];
                i15++;
                i11++;
            }
            b7++;
        }
        return c1VarArr;
    }

    int b() {
        return this.f34064a;
    }

    private c1(int i6, byte[] bArr) {
        this.f34064a = i6;
        this.f34065b = bArr;
    }

    byte[] a() {
        return this.f34065b;
    }
}
