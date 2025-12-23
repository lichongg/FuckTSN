package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class d4 {
    private static char a(char c6, int i6) {
        int i7 = c6 + ((i6 * Opcodes.FCMPL) % 253) + 1;
        if (i7 > 254) {
            i7 -= 254;
        }
        return (char) i7;
    }

    private static boolean h(char c6) {
        return false;
    }

    public static String a(String str, e7 e7Var, l2 l2Var, l2 l2Var2) {
        int i6 = 0;
        v2[] v2VarArr = {new b(), new d0(), new g7(), new n8(), new s2(), new n()};
        y2 y2Var = new y2(str);
        y2Var.a(e7Var);
        y2Var.a(l2Var, l2Var2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            y2Var.a((char) 236);
            y2Var.a(2);
            y2Var.f35037f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            y2Var.a((char) 237);
            y2Var.a(2);
            y2Var.f35037f += 7;
        }
        while (y2Var.i()) {
            if (i6 >= 0 && i6 < 6) {
                v2VarArr[i6].a(y2Var);
            }
            if (y2Var.e() >= 0) {
                i6 = y2Var.e();
                y2Var.j();
            }
        }
        int a6 = y2Var.a();
        y2Var.l();
        int a7 = y2Var.g().a();
        if (a6 < a7 && i6 != 0 && i6 != 5 && i6 != 4) {
            y2Var.a((char) 254);
        }
        StringBuilder b6 = y2Var.b();
        if (b6.length() < a7) {
            b6.append((char) 129);
        }
        while (b6.length() < a7) {
            b6.append(a((char) 129, b6.length() + 1));
        }
        return y2Var.b().toString();
    }

    static boolean b(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    static boolean c(char c6) {
        return c6 >= 128 && c6 <= 255;
    }

    private static boolean d(char c6) {
        if (c6 == ' ') {
            return true;
        }
        if (c6 < '0' || c6 > '9') {
            return c6 >= 'A' && c6 <= 'Z';
        }
        return true;
    }

    private static boolean e(char c6) {
        return c6 >= ' ' && c6 <= '^';
    }

    private static boolean f(char c6) {
        if (c6 == ' ') {
            return true;
        }
        if (c6 < '0' || c6 > '9') {
            return c6 >= 'a' && c6 <= 'z';
        }
        return true;
    }

    private static boolean i(char c6) {
        return c6 == '\r' || c6 == '*' || c6 == '>';
    }

    private static boolean g(char c6) {
        if (!i(c6) && c6 != ' ') {
            if (c6 < '0' || c6 > '9') {
                if (c6 < 'A' || c6 > 'Z') {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0200, code lost:
    
        return 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int a(java.lang.CharSequence r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.d4.a(java.lang.CharSequence, int, int):int");
    }

    private static int a(float[] fArr, int[] iArr, int i6, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i7 = 0; i7 < 6; i7++) {
            int ceil = (int) Math.ceil(fArr[i7]);
            iArr[i7] = ceil;
            if (i6 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i6 = ceil;
            }
            if (i6 == ceil) {
                bArr[i7] = (byte) (bArr[i7] + 1);
            }
        }
        return i6;
    }

    private static int a(byte[] bArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 6; i7++) {
            i6 += bArr[i7];
        }
        return i6;
    }

    public static int a(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = 0;
        if (i6 < length) {
            char charAt = charSequence.charAt(i6);
            while (b(charAt) && i6 < length) {
                i7++;
                i6++;
                if (i6 < length) {
                    charAt = charSequence.charAt(i6);
                }
            }
        }
        return i7;
    }

    static void a(char c6) {
        String hexString = Integer.toHexString(c6);
        throw new IllegalArgumentException("Illegal character: " + c6 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
