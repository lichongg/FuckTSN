package com.bytedance.sdk.component.widget.recycler.j.cw;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private static boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private static Field f27075j;

    /* renamed from: r, reason: collision with root package name */
    private static Field f27076r;
    private static boolean up;
    private static Method xt;

    private static float cw(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = xt) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, null)).intValue();
            } catch (Exception unused) {
                vl.j("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int j(View view) {
        return view.getLayoutDirection();
    }

    public static float xt(ViewConfiguration viewConfiguration, Context context) {
        float scaledVerticalScrollFactor;
        if (Build.VERSION.SDK_INT < 26) {
            return cw(viewConfiguration, context);
        }
        scaledVerticalScrollFactor = viewConfiguration.getScaledVerticalScrollFactor();
        return scaledVerticalScrollFactor;
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                xt = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
                vl.j("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static int g(View view) {
        int importantForAutofill;
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        importantForAutofill = view.getImportantForAutofill();
        return importantForAutofill;
    }

    public static void j(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int xt(View view) {
        return view.getImportantForAccessibility();
    }

    public static Display ae(View view) {
        return view.getDisplay();
    }

    public static void j(View view, Runnable runnable, long j6) {
        view.postOnAnimationDelayed(runnable, j6);
    }

    public static boolean m(View view) {
        return view.hasTransientState();
    }

    public static void oq(View view) {
        view.stopNestedScroll();
    }

    public static int r(View view) {
        return view.getMinimumWidth();
    }

    public static boolean tl(View view) {
        return view.isAttachedToWindow();
    }

    public static int up(View view) {
        return view.getMinimumHeight();
    }

    public static void xt(View view, int i6) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i6);
        }
    }

    public static float j(ViewConfiguration viewConfiguration, Context context) {
        float scaledHorizontalScrollFactor;
        if (Build.VERSION.SDK_INT < 26) {
            return cw(viewConfiguration, context);
        }
        scaledHorizontalScrollFactor = viewConfiguration.getScaledHorizontalScrollFactor();
        return scaledHorizontalScrollFactor;
    }

    public static void j(View view, int i6) {
        view.setImportantForAccessibility(i6);
    }

    public static void cw(View view) {
        view.postInvalidateOnAnimation();
    }

    public static boolean j(MotionEvent motionEvent, int i6) {
        return (motionEvent.getSource() & i6) == i6;
    }
}
