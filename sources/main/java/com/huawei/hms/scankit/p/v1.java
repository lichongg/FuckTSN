package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    private final p6 f34890a = new p6(o3.f34649l);

    public w1 a(s sVar, Map<l1, ?> map) throws a {
        u uVar = new u(sVar);
        try {
            return a(uVar, map);
        } catch (a e6) {
            try {
                uVar.e();
                uVar.a(true);
                uVar.d();
                uVar.c();
                uVar.a();
                w1 a6 = a(uVar, map);
                a6.a(new i6(true));
                return a6;
            } catch (a unused) {
                throw e6;
            }
        }
    }

    private w1 a(u uVar, Map<l1, ?> map) throws a {
        b8 d6 = uVar.d();
        b3 b6 = uVar.c().b();
        d1[] a6 = d1.a(uVar.b(), d6, b6);
        int i6 = 0;
        for (d1 d1Var : a6) {
            i6 += d1Var.b();
        }
        byte[] bArr = new byte[i6];
        int i7 = 0;
        for (d1 d1Var2 : a6) {
            byte[] a7 = d1Var2.a();
            int b7 = d1Var2.b();
            a(a7, b7);
            int i8 = 0;
            while (i8 < b7) {
                bArr[i7] = a7[i8];
                i8++;
                i7++;
            }
        }
        return r1.a(bArr, d6, b6, map);
    }

    private void a(byte[] bArr, int i6) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        try {
            this.f34890a.a(iArr, bArr.length - i6);
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) iArr[i8];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}
