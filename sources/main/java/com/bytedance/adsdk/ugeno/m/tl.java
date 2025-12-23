package com.bytedance.adsdk.ugeno.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.TypedValue;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {
    private static TypedValue cw;
    private static final Object xt = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static Handler f23711j = new Handler(Looper.getMainLooper());

    public static float j(Context context, String str) {
        float f6;
        float f7 = context.getResources().getDisplayMetrics().density;
        try {
            f6 = Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            f6 = 0.0f;
        }
        return (f6 * f7) + 0.5f;
    }

    public static int xt(Context context, float f6) {
        float f7 = context.getResources().getDisplayMetrics().density;
        if (f7 <= 0.0f) {
            f7 = 1.0f;
        }
        return (int) ((f6 / f7) + 0.5f);
    }

    public static float j(Context context, float f6) {
        return (f6 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int j(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static Bitmap j(Context context, Bitmap bitmap, int i6) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return null;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            if (create == null) {
                return null;
            }
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(i6);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return createBitmap;
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    public static Drawable j(Context context, int i6) {
        return context.getDrawable(i6);
    }

    public static boolean j() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void j(Runnable runnable) {
        if (j()) {
            runnable.run();
        } else {
            f23711j.post(runnable);
        }
    }
}
