package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbll {

    /* renamed from: a, reason: collision with root package name */
    private static int f50340a;

    public static String a(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                f50340a = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + f50340a;
    }
}
