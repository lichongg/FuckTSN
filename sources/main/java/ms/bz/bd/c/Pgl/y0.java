package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class y0 extends RuntimeException {
    public y0(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + ".");
    }
}
