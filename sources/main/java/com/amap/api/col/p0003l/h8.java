package com.amap.api.col.p0003l;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h8 extends e8 {

    /* renamed from: c, reason: collision with root package name */
    private static h8 f6436c = new h8();

    public final byte[] c(byte[] bArr, byte[] bArr2, List<? extends l8> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int c6 = o8.c(this.f6006a, bArr);
            int[] iArr = new int[size];
            for (int i6 = 0; i6 < size; i6++) {
                l8 l8Var = list.get(i6);
                iArr[i6] = t8.b(this.f6006a, (byte) l8Var.a(), t8.c(this.f6006a, l8Var.b()));
            }
            this.f6006a.w(o8.b(this.f6006a, c6, bArr2 != null ? o8.f(this.f6006a, bArr2) : 0, o8.d(this.f6006a, iArr)));
            return this.f6006a.z();
        } catch (Throwable th) {
            o9.a(th);
            return null;
        }
    }

    private h8() {
        super(5120);
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public static h8 d() {
        return f6436c;
    }

    public final byte[] e() {
        super.a();
        try {
            this.f6006a.w(n9.b(this.f6006a, m9.a(), this.f6006a.b(m9.m()), this.f6006a.b(m9.g()), (byte) m9.A(), this.f6006a.b(m9.s()), this.f6006a.b(m9.q()), this.f6006a.b(b(m9.o())), this.f6006a.b(b(m9.u())), l9.a(m9.C()), this.f6006a.b(m9.y()), this.f6006a.b(m9.w()), this.f6006a.b(m9.i()), this.f6006a.b(m9.k())));
            return this.f6006a.z();
        } catch (Exception e6) {
            o9.a(e6);
            return null;
        }
    }
}
