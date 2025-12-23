package com.kwad.components.core.t;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method Zb;
    private static Method Zc;
    private static Field Zd;

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z5) {
        try {
            int intValue = ((Integer) z.getField(layoutParams, str)).intValue();
            int intValue2 = ((Integer) z.getField(layoutParams, "meizuFlags")).intValue();
            int i6 = z5 ? intValue | intValue2 : (~intValue) & intValue2;
            if (intValue2 == i6) {
                return false;
            }
            z.a(layoutParams, "meizuFlags", Integer.valueOf(i6));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Activity activity, boolean z5) {
        a(activity, true, true);
    }

    static {
        try {
            Zb = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        }
        try {
            Zc = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e7) {
            e7.printStackTrace();
        }
        try {
            Zd = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e8) {
            e8.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) z.c(View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    private static void g(View view, boolean z5) {
        int i6;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z5) {
            i6 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i6 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i6 != systemUiVisibility) {
            view.setSystemUiVisibility(i6);
        }
    }

    private static void setStatusBarColor(Window window, int i6) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = Zd;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    Zd.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            }
        }
    }

    private static void a(Window window, boolean z5) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z5);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            g(decorView, z5);
            setStatusBarColor(window, 0);
        }
    }

    private static void a(Activity activity, boolean z5, boolean z6) {
        Method method = Zc;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z5));
                return;
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
                return;
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
                return;
            }
        }
        a(activity.getWindow(), z5);
    }
}
