package com.bytedance.sdk.component.cw.j;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
final class i extends m {
    final transient int[] ae;

    /* renamed from: m, reason: collision with root package name */
    final transient byte[][] f26090m;

    i(cw cwVar, int i6) {
        super(null);
        tj.j(cwVar.xt, 0L, i6);
        az azVar = cwVar.f26087j;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = azVar.cw;
            int i11 = azVar.xt;
            if (i10 == i11) {
                throw new AssertionError("s.limit == s.pos");
            }
            i8 += i10 - i11;
            i9++;
            azVar = azVar.f26085m;
        }
        this.f26090m = new byte[i9][];
        this.ae = new int[i9 * 2];
        az azVar2 = cwVar.f26087j;
        int i12 = 0;
        while (i7 < i6) {
            byte[][] bArr = this.f26090m;
            bArr[i12] = azVar2.f26084j;
            int i13 = azVar2.cw;
            int i14 = azVar2.xt;
            i7 += i13 - i14;
            if (i7 > i6) {
                i7 = i6;
            }
            int[] iArr = this.ae;
            iArr[i12] = i7;
            iArr[bArr.length + i12] = i14;
            azVar2.f26086r = true;
            i12++;
            azVar2 = azVar2.f26085m;
        }
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.ae() == ae() && j(0, mVar, 0, ae())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public String j() {
        return g().j();
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public String xt() {
        return g().xt();
    }

    private m g() {
        return new m(tl());
    }

    private int xt(int i6) {
        int binarySearch = Arrays.binarySearch(this.ae, 0, this.f26090m.length, i6 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public int ae() {
        return this.ae[this.f26090m.length - 1];
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public int hashCode() {
        int i6 = this.f26100r;
        if (i6 != 0) {
            return i6;
        }
        int length = this.f26090m.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        while (i7 < length) {
            byte[] bArr = this.f26090m[i7];
            int[] iArr = this.ae;
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
        this.f26100r = i9;
        return i9;
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public m j(int i6, int i7) {
        return g().j(i6, i7);
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public byte[] tl() {
        int[] iArr = this.ae;
        byte[][] bArr = this.f26090m;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int[] iArr2 = this.ae;
            int i8 = iArr2[length + i6];
            int i9 = iArr2[i6];
            System.arraycopy(this.f26090m[i6], i8, bArr2, i7, i9 - i7);
            i6++;
            i7 = i9;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public m cw() {
        return g().cw();
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public byte j(int i6) {
        tj.j(this.ae[this.f26090m.length - 1], i6, 1L);
        int xt = xt(i6);
        int i7 = xt == 0 ? 0 : this.ae[xt - 1];
        int[] iArr = this.ae;
        byte[][] bArr = this.f26090m;
        return bArr[xt][(i6 - i7) + iArr[bArr.length + xt]];
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public m m() {
        return g().m();
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public m r() {
        return g().r();
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public String toString() {
        return g().toString();
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public String up() {
        return g().up();
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    void j(cw cwVar) {
        int length = this.f26090m.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int[] iArr = this.ae;
            int i8 = iArr[length + i6];
            int i9 = iArr[i6];
            az azVar = new az(this.f26090m[i6], i8, (i8 + i9) - i7, true, false);
            az azVar2 = cwVar.f26087j;
            if (azVar2 == null) {
                azVar.ae = azVar;
                azVar.f26085m = azVar;
                cwVar.f26087j = azVar;
            } else {
                azVar2.ae.j(azVar);
            }
            i6++;
            i7 = i9;
        }
        cwVar.xt += i7;
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public boolean j(int i6, m mVar, int i7, int i8) {
        if (i6 < 0 || i6 > ae() - i8) {
            return false;
        }
        int xt = xt(i6);
        while (i8 > 0) {
            int i9 = xt == 0 ? 0 : this.ae[xt - 1];
            int min = Math.min(i8, ((this.ae[xt] - i9) + i9) - i6);
            int[] iArr = this.ae;
            byte[][] bArr = this.f26090m;
            if (!mVar.j(i7, bArr[xt], (i6 - i9) + iArr[bArr.length + xt], min)) {
                return false;
            }
            i6 += min;
            i7 += min;
            i8 -= min;
            xt++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.cw.j.m
    public boolean j(int i6, byte[] bArr, int i7, int i8) {
        if (i6 < 0 || i6 > ae() - i8 || i7 < 0 || i7 > bArr.length - i8) {
            return false;
        }
        int xt = xt(i6);
        while (i8 > 0) {
            int i9 = xt == 0 ? 0 : this.ae[xt - 1];
            int min = Math.min(i8, ((this.ae[xt] - i9) + i9) - i6);
            int[] iArr = this.ae;
            byte[][] bArr2 = this.f26090m;
            if (!tj.j(bArr2[xt], (i6 - i9) + iArr[bArr2.length + xt], bArr, i7, min)) {
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
