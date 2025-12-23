package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t1 {

    /* renamed from: b, reason: collision with root package name */
    private z7 f34824b = null;

    /* renamed from: a, reason: collision with root package name */
    private final p6 f34823a = new p6(o3.f34650m);

    public w1 a(s sVar, Map<l1, ?> map) throws a {
        v vVar = new v(sVar);
        z7 a6 = vVar.a();
        this.f34824b = a6;
        e1[] a7 = e1.a(vVar.b(), a6);
        int i6 = 0;
        for (e1 e1Var : a7) {
            i6 += e1Var.b();
        }
        byte[] bArr = new byte[i6];
        int length = a7.length;
        for (int i7 = 0; i7 < length; i7++) {
            e1 e1Var2 = a7[i7];
            byte[] a8 = e1Var2.a();
            int b6 = e1Var2.b();
            a(a8, b6);
            for (int i8 = 0; i8 < b6; i8++) {
                bArr[(i8 * length) + i7] = a8[i8];
            }
        }
        return o1.a(bArr, map);
    }

    private void a(byte[] bArr, int i6) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        try {
            this.f34823a.a(iArr, bArr.length - i6);
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) iArr[i8];
            }
        } catch (a unused) {
            throw a.a();
        }
    }

    public z7 a() {
        return this.f34824b;
    }
}
