package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.b8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class d1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34116a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f34117b;

    static d1[] a(byte[] bArr, b8 b8Var, b3 b3Var) {
        if (bArr.length != b8Var.e()) {
            throw new IllegalArgumentException();
        }
        b8.b a6 = b8Var.a(b3Var);
        b8.a[] a7 = a6.a();
        int i6 = 0;
        for (b8.a aVar : a7) {
            i6 += aVar.a();
        }
        d1[] d1VarArr = new d1[i6];
        int i7 = 0;
        for (b8.a aVar2 : a7) {
            int i8 = 0;
            while (i8 < aVar2.a()) {
                int b6 = aVar2.b();
                d1VarArr[i7] = new d1(b6, new byte[a6.b() + b6]);
                i8++;
                i7++;
            }
        }
        int length = d1VarArr[0].f34117b.length;
        int i9 = i6 - 1;
        while (i9 >= 0 && d1VarArr[i9].f34117b.length != length) {
            i9--;
        }
        return a(d1VarArr, bArr, length, a6, i7, i9 + 1);
    }

    int b() {
        return this.f34116a;
    }

    private d1(int i6, byte[] bArr) {
        this.f34116a = i6;
        this.f34117b = bArr;
    }

    private static d1[] a(d1[] d1VarArr, byte[] bArr, int i6, b8.b bVar, int i7, int i8) {
        int b6 = i6 - bVar.b();
        int i9 = 0;
        for (int i10 = 0; i10 < b6; i10++) {
            int i11 = 0;
            while (i11 < i7) {
                d1VarArr[i11].f34117b[i10] = bArr[i9];
                i11++;
                i9++;
            }
        }
        int i12 = i8;
        while (i12 < i7) {
            d1VarArr[i12].f34117b[b6] = bArr[i9];
            i12++;
            i9++;
        }
        int length = d1VarArr[0].f34117b.length;
        while (b6 < length) {
            int i13 = 0;
            while (i13 < i7) {
                int i14 = i13 < i8 ? b6 : b6 + 1;
                if (i13 >= 0 && i13 < d1VarArr.length && w7.a(d1VarArr[i13].f34117b, i14) && w7.a(bArr, i9)) {
                    d1VarArr[i13].f34117b[i14] = bArr[i9];
                    i13++;
                    i9++;
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            b6++;
        }
        return d1VarArr;
    }

    byte[] a() {
        return this.f34117b;
    }
}
