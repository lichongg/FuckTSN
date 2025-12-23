package com.huawei.hms.scankit.p;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class n implements v2 {
    public int a() {
        return 5;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            sb.append(y2Var.c());
            y2Var.f35037f++;
            if (d4.a(y2Var.d(), y2Var.f35037f, a()) != a()) {
                y2Var.b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a6 = y2Var.a() + length + 1;
        y2Var.c(a6);
        boolean z5 = y2Var.g().a() - a6 > 0;
        if (y2Var.i() || z5) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i6 = 0; i6 < length2; i6++) {
            y2Var.a(a(sb.charAt(i6), y2Var.a() + 1));
        }
    }

    n() {
    }

    private static char a(char c6, int i6) {
        int i7 = c6 + ((i6 * Opcodes.FCMPL) % 255) + 1;
        return i7 <= 255 ? (char) i7 : (char) (i7 + InputDeviceCompat.SOURCE_ANY);
    }
}
