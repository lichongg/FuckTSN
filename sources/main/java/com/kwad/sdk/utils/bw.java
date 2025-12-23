package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bw {
    private static final Handler bbE = new Handler(Looper.getMainLooper());
    private static long nA = 400;

    public static void a(Runnable runnable, Object obj, long j6) {
        Handler handler = bbE;
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = null;
        handler.sendMessageDelayed(obtain, j6);
    }

    public static void b(Runnable runnable) {
        bbE.postAtFrontOfQueue(runnable);
    }

    public static void c(Runnable runnable) {
        bbE.removeCallbacks(runnable);
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || au.at(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        bbE.post(runnable);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j6) {
        bbE.postDelayed(runnable, j6);
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j6) {
        VibrationEffect createOneShot;
        if (vibrator != null) {
            try {
                if (au.at(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT < 26) {
                        vibrator.vibrate(j6);
                    } else {
                        createOneShot = VibrationEffect.createOneShot(j6, -1);
                        vibrator.vibrate(createOneShot);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    public static void e(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception unused) {
        }
    }

    public static boolean hA(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains(" ") && URLUtil.isNetworkUrl(str)) {
            return false;
        }
        return true;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            bbE.post(runnable);
        }
    }

    public static String s(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            if (TextUtils.isEmpty(stackTraceString)) {
                return th.toString();
            }
            return stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, nA);
    }
}
