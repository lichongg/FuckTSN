package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.z7;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class e1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34203a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f34204b;

    static e1[] a(byte[] bArr, z7 z7Var) {
        z7.c d6 = z7Var.d();
        z7.b[] a6 = d6.a();
        int i6 = 0;
        for (z7.b bVar : a6) {
            i6 += bVar.a();
        }
        e1[] e1VarArr = new e1[i6];
        int i7 = 0;
        for (z7.b bVar2 : a6) {
            int i8 = 0;
            while (i8 < bVar2.a()) {
                int b6 = bVar2.b();
                e1VarArr[i7] = new e1(b6, new byte[d6.b() + b6]);
                i8++;
                i7++;
            }
        }
        int length = e1VarArr[0].f34204b.length - d6.b();
        int i9 = length - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = 0;
            while (i12 < i7) {
                e1VarArr[i12].f34204b[i11] = bArr[i10];
                i12++;
                i10++;
            }
        }
        boolean z5 = z7Var.h() == 24;
        int i13 = z5 ? 8 : i7;
        int i14 = 0;
        while (i14 < i13) {
            e1VarArr[i14].f34204b[i9] = bArr[i10];
            i14++;
            i10++;
        }
        int length2 = e1VarArr[0].f34204b.length;
        while (length < length2) {
            int i15 = 0;
            while (i15 < i7) {
                int i16 = z5 ? (i15 + 8) % i7 : i15;
                e1VarArr[i16].f34204b[(!z5 || i16 <= 7) ? length : length - 1] = bArr[i10];
                i15++;
                i10++;
            }
            length++;
        }
        if (i10 == bArr.length) {
            return e1VarArr;
        }
        throw new IllegalArgumentException();
    }

    int b() {
        return this.f34203a;
    }

    private e1(int i6, byte[] bArr) {
        this.f34203a = i6;
        this.f34204b = bArr;
    }

    byte[] a() {
        return this.f34204b;
    }
}
