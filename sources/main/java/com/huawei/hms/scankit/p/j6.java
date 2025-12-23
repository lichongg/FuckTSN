package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j6 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private final v1 f34459a = new v1();

    public static void a(p4 p4Var) {
        int a6 = p4Var.a();
        if (a6 == p4Var.c() && a6 == 805) {
            r3.f34751v[0] = true;
        }
    }

    public static void a(p4 p4Var, s6 s6Var) {
        boolean z5;
        int a6 = p4Var.a();
        int c6 = p4Var.c();
        while (true) {
            if (r3.f34752w.size() == 0) {
                z5 = false;
                break;
            }
            int intValue = r3.f34752w.pop().intValue();
            if (intValue != 0 && a6 % intValue == 0) {
                z5 = true;
                break;
            }
        }
        if (a6 != c6 || !z5 || s6Var == null || s6Var.j() == null) {
            return;
        }
        float min = Math.min(Math.min(s6Var.j()[0].b(), s6Var.j()[1].b()), s6Var.j()[2].b());
        if ((Math.max(Math.max(s6Var.j()[0].b(), s6Var.j()[1].b()), s6Var.j()[2].b()) - min) * (Math.max(Math.max(s6Var.j()[0].c(), s6Var.j()[1].c()), s6Var.j()[2].c()) - Math.min(Math.min(s6Var.j()[0].c(), s6Var.j()[1].c()), s6Var.j()[2].c())) > a6 * c6 * 0.8d) {
            r3.f34751v[1] = true;
        }
    }

    @Override // com.huawei.hms.scankit.p.o6
    public final s6 a(p pVar, Map<l1, ?> map) throws a {
        w1 w1Var;
        boolean z5 = true;
        r3.f34739j++;
        try {
            j2 a6 = new g2(pVar.b()).a(map);
            boolean z6 = a(a6) > 0;
            try {
                w1Var = this.f34459a.a(a6.a(), map);
                z5 = false;
            } catch (Exception unused) {
                w1Var = null;
            }
            if (z5 && z6) {
                return new s6(null, null, a6.b(), BarcodeFormat.QR_CODE);
            }
            if (z5) {
                throw a.a();
            }
            if (w1Var == null) {
                return null;
            }
            u6[] d6 = a6.d();
            if (w1Var.b() instanceof i6) {
                ((i6) w1Var.b()).a(d6);
            }
            s6 s6Var = new s6(w1Var.d(), w1Var.c(), d6, BarcodeFormat.QR_CODE);
            s6Var.b(a6.b());
            return s6Var;
        } catch (a unused2) {
            throw a.a();
        }
    }

    private int a(j2 j2Var) {
        r3.f34738i = j2Var.c();
        s a6 = j2Var.a();
        int[] iArr = {3, a6.e() - 4, 3};
        int[] iArr2 = {3, 3, a6.c() - 4};
        int i6 = 0;
        for (int i7 = 0; i7 < 3; i7++) {
            if (a(a6, iArr[i7], iArr2[i7])) {
                i6++;
            }
        }
        return i6;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    private boolean a(s sVar, int i6, int i7) {
        if (sVar != null && sVar.c() >= 21 && sVar.e() >= 21) {
            ?? b6 = sVar.b(i6, i7);
            int i8 = b6;
            if (sVar.b(i6 + 1, i7)) {
                i8 = b6 + 1;
            }
            int i9 = i8;
            if (!sVar.b(i6 + 2, i7)) {
                i9 = i8 + 1;
            }
            int i10 = i9;
            if (sVar.b(i6 + 3, i7)) {
                i10 = i9 + 1;
            }
            int i11 = i10;
            if (sVar.b(i6 - 1, i7)) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (!sVar.b(i6 - 2, i7)) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (sVar.b(i6 - 3, i7)) {
                i13 = i12 + 1;
            }
            int i14 = i13;
            if (sVar.b(i6, i7 + 1)) {
                i14 = i13 + 1;
            }
            int i15 = i14;
            if (!sVar.b(i6, i7 + 2)) {
                i15 = i14 + 1;
            }
            int i16 = i15;
            if (sVar.b(i6, i7 + 3)) {
                i16 = i15 + 1;
            }
            int i17 = i16;
            if (sVar.b(i6, i7 - 1)) {
                i17 = i16 + 1;
            }
            int i18 = i17;
            if (!sVar.b(i6, i7 - 2)) {
                i18 = i17 + 1;
            }
            int i19 = i18;
            if (sVar.b(i6, i7 - 3)) {
                i19 = i18 + 1;
            }
            if (i19 > 10) {
                return true;
            }
        }
        return false;
    }
}
