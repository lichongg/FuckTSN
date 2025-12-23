package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.idl.face.platform.FaceEnvironment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private static DisplayMetrics f10702a;

    /* renamed from: b, reason: collision with root package name */
    private static float f10703b;

    public static Rect a(Context context) {
        DisplayMetrics f6 = f(context);
        try {
            return f6.widthPixels > f6.heightPixels ? new Rect(0, 0, f6.heightPixels, f6.widthPixels) : new Rect(0, 0, f6.widthPixels, f6.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static float e(Context context) {
        if (f10703b < 0.01d) {
            f10703b = f(context).density;
        }
        return f10703b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = f10702a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bn.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f10702a = displayMetrics2;
        } catch (Throwable th) {
            f10702a = new DisplayMetrics();
            bu.a().a(th);
        }
        return f10702a;
    }

    public static int b(Context context, int i6) {
        try {
            return (int) (i6 * e(context));
        } catch (Exception unused) {
            return i6;
        }
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f6 = f(context);
        return new Rect(0, 0, f6.widthPixels, f6.heightPixels);
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS));
    }

    public static int b(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i6) {
        try {
            return (int) (i6 / e(context));
        } catch (Exception unused) {
            return i6;
        }
    }

    public static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
