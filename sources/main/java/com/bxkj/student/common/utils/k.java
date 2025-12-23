package com.bxkj.student.common.utils;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.acse.ottn.l3;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final int f17814a = 0;

    private static boolean f() {
        return Integer.parseInt(((String) Class.forName("android.os.SystemProperties").getMethod(l3.f4736f, String.class).invoke(null, "ro.miui.ui.version.name")).replaceAll("[vV]", "")) >= 6;
    }

    public static void g(@NonNull Activity activity, @ColorInt int color) {
        h(activity, color, 0);
    }

    private static int a(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float f6 = 1.0f - (alpha / 255.0f);
        return ((int) (((color & 255) * f6) + 0.5d)) | (((int) ((((color >> 16) & 255) * f6) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((color >> 8) & 255) * f6) + 0.5d)) << 8);
    }

    @RequiresApi(23)
    private static void c(Window window, boolean dark) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(dark ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private static boolean e() {
        return Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find();
    }

    private static void l(Window window, boolean dark) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i6 = declaredField.getInt(null);
            int i7 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, dark ? i7 | i6 : (~i6) & i7);
            window.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    @TargetApi(23)
    private static void b(Window window, boolean dark) {
        if (e()) {
            l(window, dark);
        } else if (f()) {
            m(window, dark);
        }
        c(window, dark);
    }

    private static int d(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS));
    }

    public static void h(@NonNull Activity activity, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().setStatusBarColor(a(color, alpha));
    }

    public static void i(@NonNull Activity activity) {
        b(activity.getWindow(), true);
    }

    public static void j(@NonNull Activity activity, View view) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(R.id.custom);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        o(activity, false);
        q(activity);
        n(activity, view);
    }

    public static void k(@NonNull Activity activity) {
        b(activity.getWindow(), false);
    }

    private static void m(Window window, boolean dark) {
        int i6;
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i7 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            if (dark) {
                i6 = i7;
            } else {
                i6 = 0;
            }
            method.invoke(window, Integer.valueOf(i6), Integer.valueOf(i7));
        } catch (Exception unused) {
        }
    }

    public static void n(Context context, @NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0 && view.getPaddingTop() == 0) {
            layoutParams.height += d(context);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + d(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    private static void o(Activity activity, boolean fitSystemWindows) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(fitSystemWindows);
                ((ViewGroup) childAt).setClipToPadding(fitSystemWindows);
            }
        }
    }

    private static void p(ViewGroup viewGroup, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        int a6 = a(color, alpha);
        View findViewById = viewGroup.findViewById(R.id.custom);
        if (findViewById == null && a6 != 0) {
            findViewById = new View(viewGroup.getContext());
            findViewById.setId(R.id.custom);
            viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, d(viewGroup.getContext())));
        }
        if (findViewById != null) {
            findViewById.setBackgroundColor(a6);
        }
    }

    public static void q(@NonNull Activity activity) {
        activity.getWindow().setStatusBarColor(0);
        activity.getWindow().getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f35648o);
    }
}
