package com.ss.android.socialbase.appdownloader.m.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int[] f38519a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f38520b;

    private static final int a(int[] iArr, int i6) {
        int i7 = iArr[i6 / 4];
        return (i6 % 4) / 2 == 0 ? i7 & 65535 : i7 >>> 16;
    }

    public String c(int i6) {
        int[] iArr;
        if (i6 < 0 || (iArr = this.f38519a) == null || i6 >= iArr.length) {
            return null;
        }
        int i7 = iArr[i6];
        int a6 = a(this.f38520b, i7);
        StringBuilder sb = new StringBuilder(a6);
        while (a6 != 0) {
            i7 += 2;
            sb.append((char) a(this.f38520b, i7));
            a6--;
        }
        return sb.toString();
    }

    private d() {
    }

    public static d b(e eVar) throws IOException {
        int i6;
        g.a(eVar, 1835009);
        int g6 = eVar.g();
        int g7 = eVar.g();
        int g8 = eVar.g();
        eVar.g();
        int g9 = eVar.g();
        int g10 = eVar.g();
        d dVar = new d();
        dVar.f38519a = eVar.h(g7);
        if (g8 != 0) {
            eVar.h(g8);
        }
        if (g10 == 0) {
            i6 = g6;
        } else {
            i6 = g10;
        }
        int i7 = i6 - g9;
        if (i7 % 4 == 0) {
            dVar.f38520b = eVar.h(i7 / 4);
            if (g10 != 0) {
                int i8 = g6 - g10;
                if (i8 % 4 == 0) {
                    eVar.h(i8 / 4);
                    return dVar;
                }
                throw new IOException("Style data size is not multiple of 4 (" + i8 + ").");
            }
            return dVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i7 + ").");
    }
}
