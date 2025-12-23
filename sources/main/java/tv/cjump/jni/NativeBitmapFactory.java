package tv.cjump.jni;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NativeBitmapFactory {

    /* renamed from: a, reason: collision with root package name */
    static Field f54649a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f54650b;

    /* renamed from: c, reason: collision with root package name */
    static boolean f54651c;

    private static native Bitmap createBitmap(int i6, int i7, int i8, boolean z5);

    private static native Bitmap createBitmap19(int i6, int i7, int i8, boolean z5);

    public static int d(Bitmap.Config config) {
        try {
            Field field = f54649a;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e7) {
            e7.printStackTrace();
            return 0;
        }
    }

    private static native boolean init();

    private static native boolean release();

    public static Bitmap a(int i6, int i7, Bitmap.Config config) {
        return b(i6, i7, config, config.equals(Bitmap.Config.ARGB_4444) || config.equals(Bitmap.Config.ARGB_8888));
    }

    public static synchronized Bitmap b(int i6, int i7, Bitmap.Config config, boolean z5) {
        synchronized (NativeBitmapFactory.class) {
            if (f54650b && f54649a != null) {
                return c(i6, i7, config, z5);
            }
            return Bitmap.createBitmap(i6, i7, config);
        }
    }

    static void e() {
        try {
            Field declaredField = Bitmap.Config.class.getDeclaredField("nativeInt");
            f54649a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e6) {
            f54649a = null;
            e6.printStackTrace();
        }
    }

    public static boolean f() {
        return f54650b && f54649a != null;
    }

    public static void g() {
        if (f54651c) {
            return;
        }
        if (!DeviceUtils.h() && !DeviceUtils.i()) {
            f54651c = true;
            f54650b = false;
            return;
        }
        if (f54650b) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                System.loadLibrary("ndkbitmap");
                f54650b = true;
            } else {
                f54651c = true;
                f54650b = false;
            }
        } catch (Error e6) {
            e6.printStackTrace();
            f54651c = true;
            f54650b = false;
        } catch (Exception e7) {
            e7.printStackTrace();
            f54651c = true;
            f54650b = false;
        }
        if (f54650b) {
            if (!init()) {
                release();
                f54651c = true;
                f54650b = false;
            } else {
                e();
                if (j()) {
                    return;
                }
                release();
                f54651c = true;
                f54650b = false;
            }
        }
    }

    public static synchronized void i() {
        synchronized (NativeBitmapFactory.class) {
            boolean z5 = f54650b;
            f54649a = null;
            f54650b = false;
            if (z5) {
                release();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean j() {
        if (f54649a == null) {
            return false;
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = c(2, 2, Bitmap.Config.ARGB_8888, true);
                boolean z5 = bitmap != null && bitmap.getWidth() == 2 && bitmap.getHeight() == 2;
                if (z5) {
                    if (!bitmap.isPremultiplied()) {
                        bitmap.setPremultiplied(true);
                    }
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint();
                    paint.setColor(SupportMenu.CATEGORY_MASK);
                    paint.setTextSize(20.0f);
                    canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), paint);
                    canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                    z5 = bitmap.isPremultiplied();
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return z5;
            } catch (Error unused) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            } catch (Exception e6) {
                e6.toString();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            }
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    private static Bitmap c(int i6, int i7, Bitmap.Config config, boolean z5) {
        return createBitmap(i6, i7, d(config), z5);
    }

    public static void h(Bitmap bitmap) {
        bitmap.recycle();
    }
}
