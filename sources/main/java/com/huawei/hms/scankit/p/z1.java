package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Formatter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class z1 {

    /* renamed from: a, reason: collision with root package name */
    private final k f35062a;

    /* renamed from: b, reason: collision with root package name */
    private final a2[] f35063b;

    /* renamed from: c, reason: collision with root package name */
    private a0 f35064c;

    /* renamed from: d, reason: collision with root package name */
    private final int f35065d;

    private void a(a2 a2Var) throws a {
        if (a2Var != null) {
            try {
                ((b2) a2Var).a(this.f35062a);
            } catch (ClassCastException unused) {
                throw a.a();
            }
        }
    }

    private void c() {
        a2[] a2VarArr = this.f35063b;
        a2 a2Var = a2VarArr[0];
        if (a2Var == null || a2VarArr[this.f35065d + 1] == null) {
            return;
        }
        x0[] b6 = a2Var.b();
        x0[] b7 = this.f35063b[this.f35065d + 1].b();
        for (int i6 = 0; i6 < b6.length; i6++) {
            x0 x0Var = b6[i6];
            if (x0Var != null && b7[i6] != null && x0Var.c() == b7[i6].c()) {
                for (int i7 = 1; i7 <= this.f35065d; i7++) {
                    x0 x0Var2 = this.f35063b[i7].b()[i6];
                    if (x0Var2 != null) {
                        x0Var2.b(b6[i6].c());
                        if (!x0Var2.g()) {
                            this.f35063b[i7].b()[i6] = null;
                        }
                    }
                }
            }
        }
    }

    private int d() {
        a2 a2Var = this.f35063b[0];
        if (a2Var == null) {
            return 0;
        }
        x0[] b6 = a2Var.b();
        int i6 = 0;
        for (int i7 = 0; i7 < b6.length; i7++) {
            x0 x0Var = b6[i7];
            if (x0Var != null) {
                int c6 = x0Var.c();
                int i8 = 0;
                for (int i9 = 1; i9 < this.f35065d + 1 && i8 < 2; i9++) {
                    x0 x0Var2 = this.f35063b[i9].b()[i7];
                    if (x0Var2 != null) {
                        i8 = a(c6, i8, x0Var2);
                        if (!x0Var2.g()) {
                            i6++;
                        }
                    }
                }
            }
        }
        return i6;
    }

    private int e() {
        a2 a2Var = this.f35063b[this.f35065d + 1];
        if (a2Var == null) {
            return 0;
        }
        x0[] b6 = a2Var.b();
        int i6 = 0;
        for (int i7 = 0; i7 < b6.length; i7++) {
            x0 x0Var = b6[i7];
            if (x0Var != null) {
                int c6 = x0Var.c();
                int i8 = 0;
                for (int i9 = this.f35065d + 1; i9 > 0 && i8 < 2; i9--) {
                    x0 x0Var2 = this.f35063b[i9].b()[i7];
                    if (x0Var2 != null) {
                        i8 = a(c6, i8, x0Var2);
                        if (!x0Var2.g()) {
                            i6++;
                        }
                    }
                }
            }
        }
        return i6;
    }

    int f() {
        return this.f35065d;
    }

    int g() {
        return this.f35062a.b();
    }

    int h() {
        return this.f35062a.c();
    }

    a0 i() {
        return this.f35064c;
    }

    a2[] j() throws a {
        a(this.f35063b[0]);
        a(this.f35063b[this.f35065d + 1]);
        int i6 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW;
        while (true) {
            int a6 = a();
            if (a6 <= 0 || a6 >= i6) {
                break;
            }
            i6 = a6;
        }
        return this.f35063b;
    }

    public String toString() {
        a2[] a2VarArr = this.f35063b;
        a2 a2Var = a2VarArr[0];
        if (a2Var == null) {
            a2Var = a2VarArr[this.f35065d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i6 = 0; i6 < a2Var.b().length; i6++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i6));
                for (int i7 = 0; i7 < this.f35065d + 2; i7++) {
                    a2 a2Var2 = this.f35063b[i7];
                    if (a2Var2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        x0 x0Var = a2Var2.b()[i6];
                        if (x0Var == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(x0Var.c()), Integer.valueOf(x0Var.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    formatter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    z1(k kVar, a0 a0Var) {
        this.f35062a = kVar;
        int a6 = kVar.a();
        this.f35065d = a6;
        this.f35064c = a0Var;
        this.f35063b = new a2[a6 + 2];
    }

    private int b() {
        c();
        return d() + e();
    }

    private int a() {
        int b6 = b();
        if (b6 == 0) {
            return 0;
        }
        for (int i6 = 1; i6 < this.f35065d + 1; i6++) {
            x0[] b7 = this.f35063b[i6].b();
            for (int i7 = 0; i7 < b7.length; i7++) {
                x0 x0Var = b7[i7];
                if (x0Var != null && !x0Var.g()) {
                    a(i6, i7, b7);
                }
            }
        }
        return b6;
    }

    private static int a(int i6, int i7, x0 x0Var) {
        if (x0Var == null || x0Var.g()) {
            return i7;
        }
        if (!x0Var.a(i6)) {
            return i7 + 1;
        }
        x0Var.b(i6);
        return 0;
    }

    private void a(int i6, int i7, x0[] x0VarArr) {
        x0 x0Var = x0VarArr[i7];
        x0[] b6 = this.f35063b[i6 - 1].b();
        a2 a2Var = this.f35063b[i6 + 1];
        x0[] b7 = a2Var != null ? a2Var.b() : b6;
        x0[] x0VarArr2 = new x0[14];
        x0VarArr2[2] = b6[i7];
        x0VarArr2[3] = b7[i7];
        if (i7 > 0) {
            int i8 = i7 - 1;
            x0VarArr2[0] = x0VarArr[i8];
            x0VarArr2[4] = b6[i8];
            x0VarArr2[5] = b7[i8];
        }
        if (i7 > 1) {
            int i9 = i7 - 2;
            x0VarArr2[8] = x0VarArr[i9];
            x0VarArr2[10] = b6[i9];
            x0VarArr2[11] = b7[i9];
        }
        if (i7 < x0VarArr.length - 1) {
            int i10 = i7 + 1;
            x0VarArr2[1] = x0VarArr[i10];
            x0VarArr2[6] = b6[i10];
            x0VarArr2[7] = b7[i10];
        }
        if (i7 < x0VarArr.length - 2) {
            int i11 = i7 + 2;
            x0VarArr2[9] = x0VarArr[i11];
            x0VarArr2[12] = b6[i11];
            x0VarArr2[13] = b7[i11];
        }
        for (int i12 = 0; i12 < 14 && !a(x0Var, x0VarArr2[i12]); i12++) {
        }
    }

    private static boolean a(x0 x0Var, x0 x0Var2) {
        if (x0Var2 == null || !x0Var2.g() || x0Var2.a() != x0Var.a()) {
            return false;
        }
        x0Var.b(x0Var2.c());
        return true;
    }

    void a(a0 a0Var) {
        this.f35064c = a0Var;
    }

    void a(int i6, a2 a2Var) {
        this.f35063b[i6] = a2Var;
    }

    a2 a(int i6) {
        return this.f35063b[i6];
    }
}
