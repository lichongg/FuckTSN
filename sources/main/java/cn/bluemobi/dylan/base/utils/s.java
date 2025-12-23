package cn.bluemobi.dylan.base.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s {
    public static boolean b(Window window, boolean z5) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i6 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z5) {
                    method.invoke(window, Integer.valueOf(i6), Integer.valueOf(i6));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i6));
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void c(Activity activity, int i6) {
        if (i6 == 1) {
            b(activity.getWindow(), false);
        } else if (i6 == 2) {
            a(activity.getWindow(), false);
        } else if (i6 == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public static void e(Activity activity, int i6) {
        if (i6 == 1) {
            b(activity.getWindow(), true);
        } else if (i6 == 2) {
            a(activity.getWindow(), true);
        } else if (i6 == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
        }
    }

    public static boolean a(Window window, boolean z5) {
        if (window == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i6 = declaredField.getInt(null);
            int i7 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z5 ? i7 | i6 : (~i6) & i7);
            window.setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int d(Activity activity) {
        int i6 = Build.VERSION.SDK_INT;
        if (b(activity.getWindow(), true)) {
            return 1;
        }
        if (a(activity.getWindow(), true)) {
            return 2;
        }
        if (i6 < 23) {
            return 0;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(8448);
        return 3;
    }

    public static void f(Activity activity, int i6) {
        activity.getWindow().setStatusBarColor(activity.getResources().getColor(i6));
    }

    @TargetApi(19)
    public static void g(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f35648o);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
