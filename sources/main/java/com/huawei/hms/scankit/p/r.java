package com.huawei.hms.scankit.p;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f34724a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f34725b;

    /* renamed from: c, reason: collision with root package name */
    private int f34726c;

    public r() {
        this.f34726c = 0;
        this.f34724a = new int[1];
    }

    private void a(int i6) {
        if (i6 > this.f34724a.length * 32) {
            int[] f6 = f(i6);
            int[] iArr = this.f34724a;
            System.arraycopy(iArr, 0, f6, 0, iArr.length);
            this.f34724a = f6;
        }
    }

    private int e(int i6) {
        int i7 = 0;
        while (i6 > 0) {
            i6 &= i6 - 1;
            i7++;
        }
        return i7;
    }

    public boolean b(int i6) {
        return ((1 << (i6 & 31)) & this.f34724a[i6 / 32]) != 0;
    }

    public void c() {
        this.f34725b = this.f34724a;
    }

    public int d(int i6) {
        int i7 = this.f34726c;
        if (i6 >= i7) {
            return i7;
        }
        int i8 = i6 / 32;
        if (!w7.a(this.f34724a, i8)) {
            return -1;
        }
        int i9 = (-(1 << (i6 & 31))) & (~this.f34724a[i8]);
        while (i9 == 0) {
            i8++;
            int[] iArr = this.f34724a;
            if (i8 == iArr.length) {
                return this.f34726c;
            }
            if (w7.a(iArr, i8)) {
                i9 = ~this.f34724a[i8];
            }
        }
        int numberOfTrailingZeros = (i8 * 32) + Integer.numberOfTrailingZeros(i9);
        int i10 = this.f34726c;
        return numberOfTrailingZeros > i10 ? i10 : numberOfTrailingZeros;
    }

    public int f() {
        return (this.f34726c + 7) / 8;
    }

    public void g() {
        this.f34724a = this.f34725b;
    }

    public void h(int i6) {
        int[] iArr = this.f34724a;
        int i7 = i6 / 32;
        iArr[i7] = iArr[i7] - (1 << (i6 & 31));
    }

    public void i() {
        for (int i6 = 0; i6 < this.f34726c - 1; i6++) {
            if (!b(i6) && b(i6 + 1)) {
                g(i6);
            }
        }
    }

    public void j() {
        for (int i6 = 0; i6 < this.f34726c - 1; i6++) {
            if (b(i6) && !b(i6 + 1)) {
                h(i6);
            }
        }
    }

    private static int[] f(int i6) {
        return new int[(i6 + 31) / 32];
    }

    public void b(int i6, int i7) {
        this.f34724a[i6 / 32] = i7;
    }

    public int c(int i6) {
        int i7 = this.f34726c;
        if (i6 >= i7) {
            return i7;
        }
        int i8 = i6 / 32;
        if (!w7.a(this.f34724a, i8)) {
            return -1;
        }
        int i9 = (-(1 << (i6 & 31))) & this.f34724a[i8];
        while (i9 == 0) {
            i8++;
            int[] iArr = this.f34724a;
            if (i8 == iArr.length) {
                return this.f34726c;
            }
            if (w7.a(iArr, i8)) {
                i9 = this.f34724a[i8];
            }
        }
        int numberOfTrailingZeros = (i8 * 32) + Integer.numberOfTrailingZeros(i9);
        int i10 = this.f34726c;
        return numberOfTrailingZeros > i10 ? i10 : numberOfTrailingZeros;
    }

    public int e() {
        return this.f34726c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f34726c == rVar.f34726c && Arrays.equals(this.f34724a, rVar.f34724a);
    }

    public void g(int i6) {
        int[] iArr = this.f34724a;
        int i7 = i6 / 32;
        iArr[i7] = (1 << (i6 & 31)) | iArr[i7];
    }

    public void h() {
        int[] iArr = new int[this.f34724a.length];
        int i6 = (this.f34726c - 1) / 32;
        int i7 = i6 + 1;
        for (int i8 = 0; i8 < i7; i8++) {
            long j6 = this.f34724a[i8];
            long j7 = ((j6 & 1431655765) << 1) | ((j6 >> 1) & 1431655765);
            long j8 = ((j7 & 858993459) << 2) | ((j7 >> 2) & 858993459);
            long j9 = ((j8 & 252645135) << 4) | ((j8 >> 4) & 252645135);
            long j10 = ((j9 & 16711935) << 8) | ((j9 >> 8) & 16711935);
            iArr[i6 - i8] = (int) (((j10 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j10 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i9 = this.f34726c;
        int i10 = i7 * 32;
        if (i9 != i10) {
            int i11 = i10 - i9;
            int i12 = iArr[0] >>> i11;
            for (int i13 = 1; i13 < i7; i13++) {
                int i14 = iArr[i13];
                iArr[i13 - 1] = i12 | (i14 << (32 - i11));
                i12 = i14 >>> i11;
            }
            iArr[i6] = i12;
        }
        this.f34724a = iArr;
    }

    public int hashCode() {
        return (this.f34726c * 31) + Arrays.hashCode(this.f34724a);
    }

    public String toString() {
        int i6 = this.f34726c;
        StringBuilder sb = new StringBuilder(i6 + (i6 / 8) + 1);
        for (int i7 = 0; i7 < this.f34726c; i7++) {
            if ((i7 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(b(i7) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void b(r rVar) {
        if (this.f34726c != rVar.f34726c) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i6 = 0;
        while (true) {
            int[] iArr = this.f34724a;
            if (i6 >= iArr.length) {
                return;
            }
            iArr[i6] = iArr[i6] ^ rVar.f34724a[i6];
            i6++;
        }
    }

    public r(int i6) {
        this.f34726c = i6;
        this.f34724a = f(i6);
    }

    public void a() {
        int length = this.f34724a.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f34724a[i6] = 0;
        }
    }

    r(int[] iArr, int i6) {
        this.f34724a = iArr;
        this.f34726c = i6;
    }

    public boolean a(int i6, int i7, boolean z5, boolean z6) {
        if (i7 < i6 || i6 < 0 || i7 > this.f34726c) {
            throw new IllegalArgumentException();
        }
        if (i7 == i6) {
            return true;
        }
        int i8 = i7 - 1;
        int i9 = i6 / 32;
        int i10 = i8 / 32;
        int i11 = i9;
        int i12 = 0;
        while (i11 <= i10) {
            int i13 = (2 << (i11 < i10 ? 31 : i8 & 31)) - (1 << (i11 > i9 ? 0 : i6 & 31));
            if (!z6 && (i12 = i12 + e(this.f34724a[i11] & i13)) > (i8 - i6) / 10) {
                return false;
            }
            if (z6) {
                int i14 = this.f34724a[i11] & i13;
                if (!z5) {
                    i13 = 0;
                }
                if (i14 != i13) {
                    return false;
                }
            }
            i11++;
        }
        return true;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r clone() {
        return new r((int[]) this.f34724a.clone(), this.f34726c);
    }

    public int[] d() {
        return this.f34724a;
    }

    public void c(int i6, int i7) {
        if (i7 < i6 || i6 < 0 || i7 > this.f34726c) {
            throw new IllegalArgumentException();
        }
        if (i7 == i6) {
            return;
        }
        int i8 = i7 - 1;
        int i9 = i6 / 32;
        int i10 = i8 / 32;
        int i11 = i9;
        while (i11 <= i10) {
            int i12 = 31;
            int i13 = i11 > i9 ? 0 : i6 & 31;
            if (i11 >= i10) {
                i12 = 31 & i8;
            }
            int i14 = (2 << i12) - (1 << i13);
            int[] iArr = this.f34724a;
            iArr[i11] = i14 | iArr[i11];
            i11++;
        }
    }

    public void a(boolean z5) {
        a(this.f34726c + 1);
        if (z5) {
            int[] iArr = this.f34724a;
            int i6 = this.f34726c;
            int i7 = i6 / 32;
            iArr[i7] = (1 << (i6 & 31)) | iArr[i7];
        }
        this.f34726c++;
    }

    public void a(int i6, int i7) {
        if (i7 >= 0 && i7 <= 32) {
            a(this.f34726c + i7);
            while (i7 > 0) {
                boolean z5 = true;
                if (((i6 >> (i7 - 1)) & 1) != 1) {
                    z5 = false;
                }
                a(z5);
                i7--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void a(r rVar) {
        int i6 = rVar.f34726c;
        a(this.f34726c + i6);
        for (int i7 = 0; i7 < i6; i7++) {
            a(rVar.b(i7));
        }
    }

    public void a(int i6, byte[] bArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = 0;
            for (int i11 = 0; i11 < 8; i11++) {
                if (b(i6)) {
                    i10 |= 1 << (7 - i11);
                }
                i6++;
            }
            bArr[i7 + i9] = (byte) i10;
        }
    }
}
