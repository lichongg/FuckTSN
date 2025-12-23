package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    private final p6 f34841a = new p6(o3.f34649l);

    public w1 a(s sVar, Map<l1, ?> map) throws a {
        t tVar = new t(sVar);
        try {
            try {
                return a(tVar, map);
            } catch (a unused) {
                tVar.e();
                tVar.a(true);
                tVar.d();
                tVar.c();
                tVar.a();
                w1 a6 = a(tVar, map);
                a6.a(new l6(true));
                return a6;
            }
        } catch (a unused2) {
            throw a.a();
        }
    }

    private w1 a(t tVar, Map<l1, ?> map) throws a {
        a8 d6 = tVar.d();
        c3 a6 = tVar.c().a();
        c1[] a7 = c1.a(tVar.b(), d6, a6);
        int i6 = 0;
        for (c1 c1Var : a7) {
            i6 += c1Var.b();
        }
        byte[] bArr = new byte[i6];
        int i7 = 0;
        for (c1 c1Var2 : a7) {
            byte[] a8 = c1Var2.a();
            int b6 = c1Var2.b();
            a(a8, b6);
            int i8 = 0;
            while (i8 < b6) {
                bArr[i7] = a8[i8];
                i8++;
                i7++;
            }
        }
        return p1.a(bArr, d6, a6, map);
    }

    private void a(byte[] bArr, int i6) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        try {
            this.f34841a.a(iArr, bArr.length - i6);
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) iArr[i8];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}
