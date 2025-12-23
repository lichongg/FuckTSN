package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class d0 implements v2 {
    static void b(y2 y2Var, StringBuilder sb) {
        y2Var.a(a(sb, 0));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c6 = y2Var.c();
            y2Var.f35037f++;
            int a6 = a(c6, sb);
            int a7 = y2Var.a() + ((sb.length() / 3) * 2);
            y2Var.c(a7);
            int a8 = y2Var.g().a() - a7;
            if (!y2Var.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (a8 < 2 || a8 > 2)) {
                    a6 = a(y2Var, sb, sb2, a6);
                }
                while (sb.length() % 3 == 1 && ((a6 <= 3 && a8 != 1) || a6 > 3)) {
                    a6 = a(y2Var, sb, sb2, a6);
                }
            } else if (sb.length() % 3 == 0 && d4.a(y2Var.d(), y2Var.f35037f, a()) != a()) {
                y2Var.b(0);
                break;
            }
        }
        a(y2Var, sb);
    }

    d0() {
    }

    private int a(y2 y2Var, StringBuilder sb, StringBuilder sb2, int i6) {
        int length = sb.length();
        sb.delete(length - i6, length);
        y2Var.f35037f--;
        int a6 = a(y2Var.c(), sb2);
        y2Var.k();
        return a6;
    }

    void a(y2 y2Var, StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int a6 = y2Var.a() + length;
        y2Var.c(a6);
        int a7 = y2Var.g().a() - a6;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (y2Var.i()) {
                y2Var.a((char) 254);
            }
        } else if (a7 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (y2Var.i()) {
                y2Var.a((char) 254);
            }
            y2Var.f35037f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (a7 > 0 || y2Var.i()) {
                y2Var.a((char) 254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                o4.b("exception", "Exception");
            }
        }
        y2Var.b(0);
    }

    int a(char c6, StringBuilder sb) {
        if (c6 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c6 >= '0' && c6 <= '9') {
            sb.append((char) (c6 - ','));
            return 1;
        }
        if (c6 >= 'A' && c6 <= 'Z') {
            sb.append((char) (c6 - '3'));
            return 1;
        }
        if (c6 < ' ') {
            sb.append((char) 0);
            sb.append(c6);
            return 2;
        }
        if (c6 >= '!' && c6 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c6 - '!'));
            return 2;
        }
        if (c6 >= ':' && c6 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c6 - '+'));
            return 2;
        }
        if (c6 >= '[' && c6 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c6 - 'E'));
            return 2;
        }
        if (c6 >= '`' && c6 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c6 - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return a((char) (c6 - 128), sb) + 2;
    }

    private static String a(CharSequence charSequence, int i6) {
        int charAt = (charSequence.charAt(i6) * 1600) + (charSequence.charAt(i6 + 1) * '(') + charSequence.charAt(i6 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
