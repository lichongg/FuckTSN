package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public static int f50295a;

    /* renamed from: b, reason: collision with root package name */
    public static int f50296b;

    public static String a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f50295a = point.x;
            f50296b = point.y;
        } catch (Throwable unused) {
        }
        return f50295a + "*" + f50296b;
    }
}
