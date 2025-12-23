package ms.bz.bd.c.Pgl;

import android.os.Build;
import ms.bz.bd.c.Pgl.e1;

/* loaded from: D:\Downloads\app\classes8.dex */
final class s1 implements e1.pblb {
    public final String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
    }

    s1() {
    }
}
