package com.amap.api.col.p0003l;

import android.os.SystemClock;
import com.amap.api.col.p0003l.i8;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f8 extends e8 {
    public f8() {
        super(2048);
    }

    private int b(long j6, List<l9> list) {
        g(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            l9 l9Var = list.get(i6);
            int b6 = this.f6006a.b(l9Var.f6746b);
            long j7 = l9Var.f6745a;
            iArr[i6] = c9.b(this.f6006a, j7 == j6 && j7 != -1, j7, (short) l9Var.f6747c, b6, l9Var.f6751g, (short) l9Var.f6748d);
        }
        return b9.b(this.f6006a, b9.c(this.f6006a, iArr));
    }

    private int c(i8.a aVar) {
        int i6;
        int i7;
        int i8;
        byte b6;
        int i9;
        e(aVar.f6531f);
        int size = aVar.f6531f.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            ko koVar = aVar.f6531f.get(i10);
            if (koVar instanceof kq) {
                kq kqVar = (kq) koVar;
                i9 = !kqVar.f6707i ? w8.b(this.f6006a, kqVar.f6713j, kqVar.f6714k, kqVar.f6701c, kqVar.f6715l) : w8.c(this.f6006a, kqVar.b(), kqVar.c(), kqVar.f6713j, kqVar.f6714k, kqVar.f6701c, kqVar.f6716m, kqVar.f6717n, kqVar.f6702d, kqVar.f6715l);
                i8 = -1;
                b6 = 1;
            } else if (koVar instanceof kr) {
                kr krVar = (kr) koVar;
                i9 = x8.b(this.f6006a, krVar.b(), krVar.c(), krVar.f6719j, krVar.f6720k, krVar.f6721l, krVar.f6701c, krVar.f6722m, krVar.f6702d);
                i8 = -1;
                b6 = 3;
            } else if (koVar instanceof kp) {
                kp kpVar = (kp) koVar;
                i9 = !kpVar.f6707i ? p8.b(this.f6006a, kpVar.f6708j, kpVar.f6709k, kpVar.f6710l, kpVar.f6711m, kpVar.f6712n, kpVar.f6701c) : p8.c(this.f6006a, kpVar.f6708j, kpVar.f6709k, kpVar.f6710l, kpVar.f6711m, kpVar.f6712n, kpVar.f6701c, kpVar.f6702d);
                i8 = -1;
                b6 = 2;
            } else if (koVar instanceof ks) {
                ks ksVar = (ks) koVar;
                i9 = a9.b(this.f6006a, ksVar.b(), ksVar.c(), ksVar.f6724j, ksVar.f6725k, ksVar.f6726l, ksVar.f6701c, ksVar.f6727m, ksVar.f6702d);
                i8 = -1;
                b6 = 4;
            } else {
                i8 = -1;
                b6 = 0;
                i9 = -1;
            }
            if (i9 == i8) {
                return -1;
            }
            iArr[i10] = s8.b(this.f6006a, koVar.f6706h ? (byte) 1 : (byte) 0, koVar.f6707i ? (byte) 1 : (byte) 0, (short) koVar.f6705g, b6, i9);
        }
        int b7 = this.f6006a.b(aVar.f6527b);
        int c6 = q8.c(this.f6006a, iArr);
        int size2 = aVar.f6532g.size();
        int[] iArr2 = new int[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            ko koVar2 = aVar.f6532g.get(i11);
            long elapsedRealtime = (SystemClock.elapsedRealtime() - koVar2.f6703e) / 1000;
            if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                elapsedRealtime = 32767;
            }
            if (koVar2 instanceof kq) {
                kq kqVar2 = (kq) koVar2;
                i6 = z8.a(this.f6006a, kqVar2.f6713j, kqVar2.f6714k, (short) elapsedRealtime);
            } else if (koVar2 instanceof kr) {
                kr krVar2 = (kr) koVar2;
                i6 = z8.a(this.f6006a, krVar2.f6719j, krVar2.f6720k, (short) elapsedRealtime);
            } else {
                if (koVar2 instanceof kp) {
                    kp kpVar2 = (kp) koVar2;
                    i6 = y8.a(this.f6006a, kpVar2.f6708j, kpVar2.f6709k, kpVar2.f6710l, (short) elapsedRealtime);
                    i7 = 2;
                } else if (koVar2 instanceof ks) {
                    ks ksVar2 = (ks) koVar2;
                    i6 = z8.a(this.f6006a, ksVar2.f6724j, ksVar2.f6725k, (short) elapsedRealtime);
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                iArr2[i11] = r8.b(this.f6006a, (byte) i7, i6);
            }
            i7 = 1;
            iArr2[i11] = r8.b(this.f6006a, (byte) i7, i6);
        }
        return q8.b(this.f6006a, b7, aVar.f6526a, c6, q8.f(this.f6006a, iArr2));
    }

    private int d(k9 k9Var) {
        return v8.b(this.f6006a, k9Var.f6655c, k9Var.f6697k, (int) (k9Var.f6657e * 1000000.0d), (int) (k9Var.f6656d * 1000000.0d), (int) k9Var.f6658f, (int) k9Var.f6661i, (int) k9Var.f6659g, (short) k9Var.f6660h, k9Var.f6698l);
    }

    private static void e(List<ko> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ko koVar : list) {
            if (koVar instanceof kq) {
                kq kqVar = (kq) koVar;
                koVar.f6705g = f9.b(f9.a(kqVar.f6713j, kqVar.f6714k));
            } else if (koVar instanceof kr) {
                kr krVar = (kr) koVar;
                koVar.f6705g = f9.b(f9.a(krVar.f6719j, krVar.f6720k));
            } else if (koVar instanceof ks) {
                ks ksVar = (ks) koVar;
                koVar.f6705g = f9.b(f9.a(ksVar.f6724j, ksVar.f6725k));
            } else if (koVar instanceof kp) {
                kp kpVar = (kp) koVar;
                koVar.f6705g = f9.b(f9.a(kpVar.f6709k, kpVar.f6710l));
            }
        }
    }

    private static void g(List<l9> list) {
        for (l9 l9Var : list) {
            l9Var.f6751g = f9.d(l9Var.f6745a);
        }
    }

    public final byte[] f(k9 k9Var, i8.a aVar, long j6, List<l9> list) {
        int i6;
        List<ko> list2;
        super.a();
        try {
            int d6 = d(k9Var);
            int i7 = -1;
            if (aVar != null && (list2 = aVar.f6531f) != null && list2.size() > 0) {
                i6 = c(aVar);
            } else {
                i6 = -1;
            }
            if (list != null && list.size() > 0) {
                i7 = b(j6, list);
            }
            n8.a(this.f6006a);
            n8.b(this.f6006a, d6);
            if (i6 > 0) {
                n8.e(this.f6006a, i6);
            }
            if (i7 > 0) {
                n8.d(this.f6006a, i7);
            }
            this.f6006a.w(n8.c(this.f6006a));
            return this.f6006a.z();
        } catch (Throwable th) {
            o9.a(th);
            return null;
        }
    }
}
