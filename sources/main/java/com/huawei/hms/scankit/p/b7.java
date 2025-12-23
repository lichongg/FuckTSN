package com.huawei.hms.scankit.p;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class b7 {

    /* renamed from: e, reason: collision with root package name */
    static final b7 f34042e = new b7(i7.f34411b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f34043a;

    /* renamed from: b, reason: collision with root package name */
    private final i7 f34044b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34045c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34046d;

    int a() {
        return this.f34045c;
    }

    int b() {
        return this.f34046d;
    }

    b7 a(int i6, int i7) {
        int i8 = this.f34046d;
        i7 i7Var = this.f34044b;
        int i9 = this.f34043a;
        if (i6 != i9) {
            int i10 = c4.f34083c[i9][i6];
            int i11 = 65535 & i10;
            int i12 = i10 >> 16;
            i7Var = i7Var.a(i11, i12);
            i8 += i12;
        }
        int i13 = i6 == 2 ? 4 : 5;
        return new b7(i7Var.a(i7, i13), i6, 0, i8 + i13);
    }

    b7 b(int i6, int i7) {
        i7 i7Var = this.f34044b;
        int i8 = this.f34043a;
        int i9 = i8 == 2 ? 4 : 5;
        if (i8 >= 0) {
            int[][] iArr = c4.f34085e;
            if (i8 < iArr.length && i6 > 0) {
                int[] iArr2 = iArr[i8];
                if (i6 < iArr2.length) {
                    i7Var = i7Var.a(iArr2[i6], i9);
                }
            }
        }
        return new b7(i7Var.a(i7, 5), this.f34043a, 0, this.f34046d + i9 + 5);
    }

    int c() {
        return this.f34043a;
    }

    public String toString() {
        String[] strArr = c4.f34082b;
        if (w7.a(strArr, this.f34043a)) {
            return String.format(Locale.ENGLISH, "%s bits=%d bytes=%d", strArr[this.f34043a], Integer.valueOf(this.f34046d), Integer.valueOf(this.f34045c));
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private b7(i7 i7Var, int i6, int i7, int i8) {
        this.f34044b = i7Var;
        this.f34043a = i6;
        this.f34045c = i7;
        this.f34046d = i8;
    }

    b7 a(int i6) {
        i7 i7Var = this.f34044b;
        int i7 = this.f34043a;
        int i8 = this.f34046d;
        if (i7 == 4 || i7 == 2) {
            int i9 = c4.f34083c[i7][0];
            int i10 = 65535 & i9;
            int i11 = i9 >> 16;
            i7Var = i7Var.a(i10, i11);
            i8 += i11;
            i7 = 0;
        }
        int i12 = this.f34045c;
        b7 b7Var = new b7(i7Var, i7, i12 + 1, i8 + ((i12 == 0 || i12 == 31) ? 18 : i12 == 62 ? 9 : 8));
        return b7Var.f34045c == 2078 ? b7Var.b(i6 + 1) : b7Var;
    }

    b7 b(int i6) {
        int i7 = this.f34045c;
        return i7 == 0 ? this : new b7(this.f34044b.b(i6 - i7, i7), this.f34043a, 0, this.f34046d);
    }

    boolean a(b7 b7Var) {
        int i6;
        int i7 = this.f34046d + (c4.f34083c[this.f34043a][b7Var.f34043a] >> 16);
        int i8 = b7Var.f34045c;
        if (i8 > 0 && ((i6 = this.f34045c) == 0 || i6 > i8)) {
            i7 += 10;
        }
        return i7 <= b7Var.f34046d;
    }

    r a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (i7 i7Var = b(bArr.length).f34044b; i7Var != null; i7Var = i7Var.a()) {
            linkedList.addFirst(i7Var);
        }
        r rVar = new r();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((i7) it.next()).a(rVar, bArr);
        }
        return rVar;
    }
}
