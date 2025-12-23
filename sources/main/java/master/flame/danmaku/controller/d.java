package master.flame.danmaku.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Paint f49873a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Paint f49874b = null;

    /* renamed from: c, reason: collision with root package name */
    public static RectF f49875c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f49876d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f49877e = true;

    public static void e(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    static {
        Paint paint = new Paint();
        f49873a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        f49873a.setColor(0);
        f49875c = new RectF();
    }

    public static void a(Canvas canvas) {
        if (!f49876d) {
            f49875c.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            c(canvas, f49875c);
        } else if (f49877e) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } else {
            canvas.drawColor(0);
        }
    }

    public static void b(Canvas canvas, float f6, float f7, float f8, float f9) {
        f49875c.set(f6, f7, f8, f9);
        c(canvas, f49875c);
    }

    public static void d(Canvas canvas, String str) {
        if (f49874b == null) {
            Paint paint = new Paint();
            f49874b = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            f49874b.setTextSize(30.0f);
        }
        int height = canvas.getHeight();
        b(canvas, 10.0f, height - 100, (int) (f49874b.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height - 50, f49874b);
    }

    public static void f(boolean z5, boolean z6) {
        f49876d = z5;
        f49877e = z6;
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, f49873a);
        }
    }
}
