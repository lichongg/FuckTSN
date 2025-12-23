package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class d1 {
    public static boolean a(String... strArr) {
        try {
            Context c6 = pblv.a().c();
            for (String str : strArr) {
                if (c6.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
