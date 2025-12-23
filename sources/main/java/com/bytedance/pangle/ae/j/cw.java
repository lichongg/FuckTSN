package com.bytedance.pangle.ae.j;

/* loaded from: D:\Downloads\app\classes3.dex */
class cw {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int[] f25377j = new int[32];
    private int xt;

    public final void j() {
        this.xt = 0;
        this.cw = 0;
    }

    private void ae() {
        int[] iArr = this.f25377j;
        int length = iArr.length;
        int i6 = this.xt;
        int i7 = length - i6;
        if (i7 <= 2) {
            int[] iArr2 = new int[(iArr.length + i7) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f25377j = iArr2;
        }
    }

    public final void cw() {
        int[] iArr;
        int i6;
        int i7 = this.xt;
        if (i7 == 0 || (i6 = (iArr = this.f25377j)[i7 - 1]) == 0) {
            return;
        }
        int i8 = i6 - 1;
        int i9 = i7 - 3;
        iArr[i9] = i8;
        iArr[i9 - ((i8 * 2) + 1)] = i8;
        this.xt = i7 - 2;
    }

    public final void m() {
        int i6 = this.xt;
        if (i6 != 0) {
            int i7 = this.f25377j[i6 - 1] * 2;
            if ((i6 - 2) - i7 != 0) {
                this.xt = i6 - (i7 + 2);
                this.cw--;
            }
        }
    }

    public final int r() {
        return this.cw;
    }

    public final int xt() {
        int i6 = this.xt;
        if (i6 == 0) {
            return 0;
        }
        return this.f25377j[i6 - 1];
    }

    public final void j(int i6, int i7) {
        if (this.cw == 0) {
            up();
        }
        ae();
        int i8 = this.xt;
        int i9 = i8 - 1;
        int[] iArr = this.f25377j;
        int i10 = iArr[i9];
        int i11 = (i8 - 2) - (i10 * 2);
        int i12 = i10 + 1;
        iArr[i11] = i12;
        iArr[i9] = i6;
        iArr[i8] = i7;
        iArr[i8 + 1] = i12;
        this.xt = i8 + 2;
    }

    public final void up() {
        ae();
        int i6 = this.xt;
        int[] iArr = this.f25377j;
        iArr[i6] = 0;
        iArr[i6 + 1] = 0;
        this.xt = i6 + 2;
        this.cw++;
    }
}
