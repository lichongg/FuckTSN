package com.bytedance.sdk.component.cw.xt.j.up;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ws {

    /* renamed from: j, reason: collision with root package name */
    private int f26301j;
    private final int[] xt = new int[10];

    int cw() {
        if ((this.f26301j & 2) != 0) {
            return this.xt[1];
        }
        return -1;
    }

    void j() {
        this.f26301j = 0;
        Arrays.fill(this.xt, 0);
    }

    int r(int i6) {
        return (this.f26301j & 32) != 0 ? this.xt[5] : i6;
    }

    int xt(int i6) {
        return this.xt[i6];
    }

    int cw(int i6) {
        return (this.f26301j & 16) != 0 ? this.xt[4] : i6;
    }

    int r() {
        if ((this.f26301j & 128) != 0) {
            return this.xt[7];
        }
        return 65535;
    }

    int xt() {
        return Integer.bitCount(this.f26301j);
    }

    ws j(int i6, int i7) {
        if (i6 >= 0) {
            int[] iArr = this.xt;
            if (i6 < iArr.length) {
                this.f26301j = (1 << i6) | this.f26301j;
                iArr[i6] = i7;
            }
        }
        return this;
    }

    boolean j(int i6) {
        return ((1 << i6) & this.f26301j) != 0;
    }

    void j(ws wsVar) {
        for (int i6 = 0; i6 < 10; i6++) {
            if (wsVar.j(i6)) {
                j(i6, wsVar.xt(i6));
            }
        }
    }
}
