package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ck;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static int f41164a = Integer.MAX_VALUE;

    public static void a(int i6) {
        f41164a = i6;
    }

    public static void a(cq cqVar, byte b6) throws bx {
        a(cqVar, b6, f41164a);
    }

    public static void a(cq cqVar, byte b6, int i6) throws bx {
        if (i6 > 0) {
            int i7 = 0;
            switch (b6) {
                case 2:
                    cqVar.t();
                    return;
                case 3:
                    cqVar.u();
                    return;
                case 4:
                    cqVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    cqVar.v();
                    return;
                case 8:
                    cqVar.w();
                    return;
                case 10:
                    cqVar.x();
                    return;
                case 11:
                    cqVar.A();
                    return;
                case 12:
                    cqVar.j();
                    while (true) {
                        byte b7 = cqVar.l().f41141b;
                        if (b7 == 0) {
                            cqVar.k();
                            return;
                        } else {
                            a(cqVar, b7, i6 - 1);
                            cqVar.m();
                        }
                    }
                case 13:
                    cn n6 = cqVar.n();
                    while (i7 < n6.f41147c) {
                        int i8 = i6 - 1;
                        a(cqVar, n6.f41145a, i8);
                        a(cqVar, n6.f41146b, i8);
                        i7++;
                    }
                    cqVar.o();
                    return;
                case 14:
                    cu r5 = cqVar.r();
                    while (i7 < r5.f41166b) {
                        a(cqVar, r5.f41165a, i6 - 1);
                        i7++;
                    }
                    cqVar.s();
                    return;
                case 15:
                    cm p5 = cqVar.p();
                    while (i7 < p5.f41144b) {
                        a(cqVar, p5.f41143a, i6 - 1);
                        i7++;
                    }
                    cqVar.q();
                    return;
            }
        } else {
            throw new bx("Maximum skip depth exceeded");
        }
    }

    public static cs a(byte[] bArr, cs csVar) {
        if (bArr[0] > 16) {
            return new ck.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? csVar : new ck.a();
    }
}
