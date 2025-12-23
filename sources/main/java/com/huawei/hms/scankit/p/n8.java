package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class n8 extends d0 {
    @Override // com.huawei.hms.scankit.p.d0
    public int a() {
        return 3;
    }

    @Override // com.huawei.hms.scankit.p.d0, com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c6 = y2Var.c();
            y2Var.f35037f++;
            a(c6, sb);
            if (sb.length() % 3 == 0) {
                d0.b(y2Var, sb);
                if (d4.a(y2Var.d(), y2Var.f35037f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            }
        }
        a(y2Var, sb);
    }

    n8() {
    }

    @Override // com.huawei.hms.scankit.p.d0
    int a(char c6, StringBuilder sb) {
        if (c6 == '\r') {
            sb.append((char) 0);
        } else if (c6 == ' ') {
            sb.append((char) 3);
        } else if (c6 == '*') {
            sb.append((char) 1);
        } else if (c6 == '>') {
            sb.append((char) 2);
        } else if (c6 >= '0' && c6 <= '9') {
            sb.append((char) (c6 - ','));
        } else if (c6 >= 'A' && c6 <= 'Z') {
            sb.append((char) (c6 - '3'));
        } else {
            d4.a(c6);
        }
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.d0
    void a(y2 y2Var, StringBuilder sb) {
        y2Var.l();
        int a6 = y2Var.g().a() - y2Var.a();
        y2Var.f35037f -= sb.length();
        if (y2Var.f() > 1 || a6 > 1 || y2Var.f() != a6) {
            y2Var.a((char) 254);
        }
        if (y2Var.e() < 0) {
            y2Var.b(0);
        }
    }
}
