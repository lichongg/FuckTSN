package com.bytedance.sdk.component.xt.j.xt;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
final class tl extends r {
    final transient byte[][] ae;
    final transient int[] tl;

    tl(j jVar, int i6) {
        super(null);
        oq.j(jVar.xt, 0L, i6);
        m mVar = jVar.f27321j;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = mVar.cw;
            int i11 = mVar.xt;
            if (i10 == i11) {
                throw new AssertionError("s.limit == s.pos");
            }
            i8 += i10 - i11;
            i9++;
            mVar = mVar.f27323m;
        }
        this.ae = new byte[i9][];
        this.tl = new int[i9 * 2];
        m mVar2 = jVar.f27321j;
        int i12 = 0;
        while (i7 < i6) {
            byte[][] bArr = this.ae;
            bArr[i12] = mVar2.f27322j;
            int i13 = mVar2.cw;
            int i14 = mVar2.xt;
            i7 += i13 - i14;
            if (i7 > i6) {
                i7 = i6;
            }
            int[] iArr = this.tl;
            iArr[i12] = i7;
            iArr[bArr.length + i12] = i14;
            mVar2.f27324r = true;
            i12++;
            mVar2 = mVar2.f27323m;
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.cw() == cw() && j(0, rVar, 0, cw())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public String j() {
        return up().j();
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public String xt() {
        return up().xt();
    }

    private r up() {
        return new r(r());
    }

    private int xt(int i6) {
        int binarySearch = Arrays.binarySearch(this.tl, 0, this.ae.length, i6 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public int cw() {
        return this.tl[this.ae.length - 1];
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public int hashCode() {
        int i6 = this.up;
        if (i6 != 0) {
            return i6;
        }
        int length = this.ae.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        while (i7 < length) {
            byte[] bArr = this.ae[i7];
            int[] iArr = this.tl;
            int i10 = iArr[length + i7];
            int i11 = iArr[i7];
            int i12 = (i11 - i8) + i10;
            while (i10 < i12) {
                i9 = (i9 * 31) + bArr[i10];
                i10++;
            }
            i7++;
            i8 = i11;
        }
        this.up = i9;
        return i9;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public r j(int i6, int i7) {
        return up().j(i6, i7);
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public byte[] r() {
        int[] iArr = this.tl;
        byte[][] bArr = this.ae;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int[] iArr2 = this.tl;
            int i8 = iArr2[length + i6];
            int i9 = iArr2[i6];
            System.arraycopy(this.ae[i6], i8, bArr2, i7, i9 - i7);
            i6++;
            i7 = i9;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public byte j(int i6) {
        oq.j(this.tl[this.ae.length - 1], i6, 1L);
        int xt = xt(i6);
        int i7 = xt == 0 ? 0 : this.tl[xt - 1];
        int[] iArr = this.tl;
        byte[][] bArr = this.ae;
        return bArr[xt][(i6 - i7) + iArr[bArr.length + xt]];
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public String toString() {
        return up().toString();
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public boolean j(int i6, r rVar, int i7, int i8) {
        if (i6 < 0 || i6 > cw() - i8) {
            return false;
        }
        int xt = xt(i6);
        while (i8 > 0) {
            int i9 = xt == 0 ? 0 : this.tl[xt - 1];
            int min = Math.min(i8, ((this.tl[xt] - i9) + i9) - i6);
            int[] iArr = this.tl;
            byte[][] bArr = this.ae;
            if (!rVar.j(i7, bArr[xt], (i6 - i9) + iArr[bArr.length + xt], min)) {
                return false;
            }
            i6 += min;
            i7 += min;
            i8 -= min;
            xt++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt.r
    public boolean j(int i6, byte[] bArr, int i7, int i8) {
        if (i6 < 0 || i6 > cw() - i8 || i7 < 0 || i7 > bArr.length - i8) {
            return false;
        }
        int xt = xt(i6);
        while (i8 > 0) {
            int i9 = xt == 0 ? 0 : this.tl[xt - 1];
            int min = Math.min(i8, ((this.tl[xt] - i9) + i9) - i6);
            int[] iArr = this.tl;
            byte[][] bArr2 = this.ae;
            if (!oq.j(bArr2[xt], (i6 - i9) + iArr[bArr2.length + xt], bArr, i7, min)) {
                return false;
            }
            i6 += min;
            i7 += min;
            i8 -= min;
            xt++;
        }
        return true;
    }
}
