package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class s2 implements v2 {
    public int a() {
        return 4;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            a(y2Var.c(), sb);
            y2Var.f35037f++;
            if (sb.length() >= 4) {
                y2Var.a(a(sb, 0));
                sb.delete(0, 4);
                if (d4.a(y2Var.d(), y2Var.f35037f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(y2Var, sb);
    }

    s2() {
    }

    private static void a(y2 y2Var, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z5 = true;
            if (length == 1) {
                y2Var.l();
                int a6 = y2Var.g().a() - y2Var.a();
                int f6 = y2Var.f();
                if (f6 > a6) {
                    y2Var.c(y2Var.a() + 1);
                    a6 = y2Var.g().a() - y2Var.a();
                }
                if (f6 <= a6 && a6 <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i6 = length - 1;
                String a7 = a(charSequence, 0);
                if (y2Var.i() || i6 > 2) {
                    z5 = false;
                }
                if (i6 <= 2) {
                    y2Var.c(y2Var.a() + i6);
                    if (y2Var.g().a() - y2Var.a() >= 3) {
                        y2Var.c(y2Var.a() + a7.length());
                        z5 = false;
                    }
                }
                if (z5) {
                    y2Var.k();
                    y2Var.f35037f -= i6;
                } else {
                    y2Var.a(a7);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            y2Var.b(0);
        }
    }

    private static void a(char c6, StringBuilder sb) {
        if (c6 >= ' ' && c6 <= '?') {
            sb.append(c6);
        } else if (c6 >= '@' && c6 <= '^') {
            sb.append((char) (c6 - '@'));
        } else {
            d4.a(c6);
        }
    }

    private static String a(CharSequence charSequence, int i6) {
        int length = charSequence.length() - i6;
        if (length != 0) {
            int charAt = (charSequence.charAt(i6) << 18) + ((length >= 2 ? charSequence.charAt(i6 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i6 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i6 + 3) : (char) 0);
            char c6 = (char) ((charAt >> 16) & 255);
            char c7 = (char) ((charAt >> 8) & 255);
            char c8 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c6);
            if (length >= 2) {
                sb.append(c7);
            }
            if (length >= 3) {
                sb.append(c8);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
