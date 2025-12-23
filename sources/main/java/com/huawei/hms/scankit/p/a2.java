package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class a2 {

    /* renamed from: a, reason: collision with root package name */
    private final a0 f33973a;

    /* renamed from: b, reason: collision with root package name */
    private final x0[] f33974b;

    final void a(int i6, x0 x0Var) {
        this.f33974b[c(i6)] = x0Var;
    }

    final x0 b(int i6) {
        x0 x0Var;
        x0 x0Var2;
        x0 a6 = a(i6);
        if (a6 != null) {
            return a6;
        }
        for (int i7 = 1; i7 < 5; i7++) {
            int c6 = c(i6) - i7;
            if (c6 >= 0 && (x0Var2 = this.f33974b[c6]) != null) {
                return x0Var2;
            }
            int c7 = c(i6) + i7;
            x0[] x0VarArr = this.f33974b;
            if (c7 < x0VarArr.length && (x0Var = x0VarArr[c7]) != null) {
                return x0Var;
            }
        }
        return null;
    }

    final x0 a(int i6) {
        return this.f33974b[c(i6)];
    }

    final int c(int i6) {
        return i6 - this.f33973a.f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i6 = 0;
            for (x0 x0Var : this.f33974b) {
                if (x0Var == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i6));
                    i6++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i6), Integer.valueOf(x0Var.c()), Integer.valueOf(x0Var.e()));
                    i6++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    a2(a0 a0Var) {
        this.f33973a = new a0(a0Var);
        this.f33974b = new x0[(a0Var.d() - a0Var.f()) + 1];
    }

    final a0 a() {
        return this.f33973a;
    }

    final x0[] b() {
        return this.f33974b;
    }
}
