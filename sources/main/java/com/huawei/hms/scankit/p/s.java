package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final int f34758a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34759b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34760c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f34761d;

    public s(int i6) {
        this(i6, i6);
    }

    public void a(int i6, int i7) {
        int i8 = (i7 * this.f34760c) + (i6 / 32);
        if (w7.a(this.f34761d, i8)) {
            int[] iArr = this.f34761d;
            iArr[i8] = (1 << (i6 & 31)) ^ iArr[i8];
        }
    }

    public boolean b(int i6, int i7) {
        int i8 = (i7 * this.f34760c) + (i6 / 32);
        return w7.a(this.f34761d, i8) && ((this.f34761d[i8] >>> (i6 & 31)) & 1) != 0;
    }

    public void c(int i6, int i7) {
        int i8 = (i7 * this.f34760c) + (i6 / 32);
        if (w7.a(this.f34761d, i8)) {
            int[] iArr = this.f34761d;
            iArr[i8] = (1 << (i6 & 31)) | iArr[i8];
        }
    }

    public s(int i6, int i7) {
        if (i6 < 1 || i7 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f34758a = i6;
        this.f34759b = i7;
        int i8 = (i6 + 31) / 32;
        this.f34760c = i8;
        this.f34761d = new int[i8 * i7];
    }

    public s d() {
        int[] iArr = new int[this.f34761d.length];
        int i6 = 0;
        while (true) {
            int[] iArr2 = this.f34761d;
            if (i6 >= iArr2.length) {
                return new s(this.f34758a, this.f34759b, this.f34760c, iArr);
            }
            iArr[i6] = ~iArr2[i6];
            i6++;
        }
    }

    public int e() {
        return this.f34758a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f34758a == sVar.f34758a && this.f34759b == sVar.f34759b && this.f34760c == sVar.f34760c && Arrays.equals(this.f34761d, sVar.f34761d);
    }

    public int hashCode() {
        int i6 = this.f34758a;
        return (((((((i6 * 31) + i6) * 31) + this.f34759b) * 31) + this.f34760c) * 31) + Arrays.hashCode(this.f34761d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public void f() {
        int e6 = e();
        int c6 = c();
        r rVar = new r(e6);
        r rVar2 = new r(e6);
        for (int i6 = 0; i6 < (c6 + 1) / 2; i6++) {
            rVar = a(i6, rVar);
            int i7 = (c6 - 1) - i6;
            rVar2 = a(i7, rVar2);
            rVar.h();
            rVar2.h();
            b(i6, rVar2);
            b(i7, rVar);
        }
    }

    public void a() {
        int length = this.f34761d.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f34761d[i6] = 0;
        }
    }

    public void b(int i6, r rVar) {
        int[] d6 = rVar.d();
        int[] iArr = this.f34761d;
        int i7 = this.f34760c;
        System.arraycopy(d6, 0, iArr, i6 * i7, i7);
    }

    public int c() {
        return this.f34759b;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s clone() {
        return new s(this.f34758a, this.f34759b, this.f34760c, (int[]) this.f34761d.clone());
    }

    public void a(int i6, int i7, int i8, int i9) {
        if (i7 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i9 >= 1 && i8 >= 1) {
            int i10 = i8 + i6;
            int i11 = i9 + i7;
            if (i11 > this.f34759b || i10 > this.f34758a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i7 < i11) {
                int i12 = this.f34760c * i7;
                for (int i13 = i6; i13 < i10; i13++) {
                    int[] iArr = this.f34761d;
                    int i14 = (i13 / 32) + i12;
                    iArr[i14] = iArr[i14] | (1 << (i13 & 31));
                }
                i7++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public s(int i6, int i7, int i8, int[] iArr) {
        this.f34758a = i6;
        this.f34759b = i7;
        this.f34760c = i8;
        this.f34761d = iArr;
    }

    public r a(int i6, r rVar) {
        if (rVar != null && rVar.e() >= this.f34758a) {
            rVar.a();
        } else {
            rVar = new r(this.f34758a);
        }
        int i7 = i6 * this.f34760c;
        for (int i8 = 0; i8 < this.f34760c; i8++) {
            rVar.b(i8 * 32, this.f34761d[i7 + i8]);
        }
        return rVar;
    }

    public String a(String str, String str2) {
        return a(str, str2, com.snail.antifake.deviceid.e.f37542d);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f34759b * (this.f34758a + 1));
        for (int i6 = 0; i6 < this.f34759b; i6++) {
            for (int i7 = 0; i7 < this.f34758a; i7++) {
                sb.append(b(i7, i6) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
