package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbli {
    private static boolean b(String... strArr) {
        boolean z5;
        boolean z6 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z5 = true;
            } catch (Throwable unused) {
                z5 = false;
            }
            z6 &= z5;
            if (!z6) {
                break;
            }
        }
        return z6;
    }

    public static boolean a() {
        return b((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b84a93", new byte[]{112, 53, 74, 91, 4, 61, 117, 28, 97, 48, 125, 57, 66, 91, 0, 54, 96, 20, 114, 62, 97, 49, 9, 22, 9, 54, 100, 87, 118, 53, 120, 55, 72, Ascii.ESC, 15, 48, 110, 11, 43, 1, 116, 54, 116, 49, 45, 9, 110, 23, 108, 37, 124, 40, 114, 1, 15, 40, 114}));
    }
}
