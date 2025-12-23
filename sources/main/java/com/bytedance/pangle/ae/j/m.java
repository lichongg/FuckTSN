package com.bytedance.pangle.ae.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private int[] f25382j;
    private int[] xt;

    public static m j(xt xtVar) throws IOException {
        xtVar.xt(1835009);
        int xt = xtVar.xt();
        int xt2 = xtVar.xt();
        int xt3 = xtVar.xt();
        xtVar.xt();
        int xt4 = xtVar.xt();
        int xt5 = xtVar.xt();
        m mVar = new m();
        mVar.f25382j = xtVar.j(xt2);
        if (xt3 != 0) {
            xtVar.j(xt3);
        }
        int i6 = (xt5 == 0 ? xt : xt5) - xt4;
        if (i6 % 4 != 0) {
            throw new IOException();
        }
        mVar.xt = xtVar.j(i6 / 4);
        if (xt5 == 0) {
            return mVar;
        }
        int i7 = xt - xt5;
        if (i7 % 4 != 0) {
            throw new IOException();
        }
        xtVar.j(i7 / 4);
        return mVar;
    }

    private m() {
    }

    public String j(int i6) {
        int[] iArr;
        if (i6 < 0 || (iArr = this.f25382j) == null || i6 >= iArr.length) {
            return null;
        }
        int i7 = iArr[i6];
        int j6 = j(this.xt, i7);
        StringBuilder sb = new StringBuilder(j6);
        while (j6 != 0) {
            i7 += 2;
            sb.append((char) j(this.xt, i7));
            j6--;
        }
        return sb.toString();
    }

    private static final int j(int[] iArr, int i6) {
        int i7 = iArr[i6 / 4];
        return (i6 % 4) / 2 == 0 ? i7 & 65535 : i7 >>> 16;
    }
}
