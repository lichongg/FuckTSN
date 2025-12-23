package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.stub.StubApp;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m {
    public static String aYT = null;
    private static int aYU = -1;
    public static String aYV;

    /* JADX WARN: Multi-variable type inference failed */
    public static int cI(Context context) {
        float f6;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i6;
        int i7;
        int i8 = 0;
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (Build.VERSION.SDK_INT >= 35) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics.getBounds();
                windowInsets = currentWindowMetrics.getWindowInsets();
                systemBars = WindowInsets.Type.systemBars();
                insets = windowInsets.getInsets(systemBars);
                int width = bounds.width();
                i6 = insets.left;
                i7 = insets.right;
                f6 = (width - i6) - i7;
                i8 = displayMetrics.density;
            } else {
                f6 = displayMetrics.widthPixels;
                i8 = displayMetrics.density;
            }
            return (int) (f6 / (i8 == true ? 1.0f : 0.0f));
        } catch (Exception unused) {
            return i8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int cJ(Context context) {
        float f6;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i6;
        int i7;
        int i8 = 0;
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (Build.VERSION.SDK_INT >= 35) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics.getBounds();
                windowInsets = currentWindowMetrics.getWindowInsets();
                systemBars = WindowInsets.Type.systemBars();
                insets = windowInsets.getInsets(systemBars);
                int height = bounds.height();
                i6 = insets.top;
                i7 = insets.bottom;
                f6 = (height - i6) - i7;
                i8 = displayMetrics.density;
            } else {
                f6 = displayMetrics.heightPixels;
                i8 = displayMetrics.density;
            }
            return (int) (f6 / (i8 == true ? 1.0f : 0.0f));
        } catch (Exception unused) {
            return i8;
        }
    }

    public static float cK(Context context) {
        if (context == null) {
            return 0.0f;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.density;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static String cE(Context context) {
        if (!TextUtils.isEmpty(aYT)) {
            return aYT;
        }
        try {
            PackageInfo packageInfo = y.getPackageInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()), context.getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            String str = packageInfo.versionName;
            aYT = str;
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String cF(Context context) {
        if (!TextUtils.isEmpty(aYV)) {
            return aYV;
        }
        try {
            PackageInfo packageInfo = y.getPackageInfo(context, context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            String string = context.getResources().getString(packageInfo.applicationInfo.labelRes);
            aYV = string;
            return string;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static int cG(Context context) {
        int i6 = aYU;
        if (i6 > 0) {
            return i6;
        }
        try {
            PackageInfo packageInfo = y.getPackageInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()), context.getPackageName(), 64);
            if (packageInfo == null) {
                return 0;
            }
            int i7 = packageInfo.versionCode;
            aYU = i7;
            return i7;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int cH(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public static int getScreenHeight(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i6;
        int i7;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int height = bounds.height();
            i6 = insets.top;
            i7 = insets.bottom;
            return (height - i6) - i7;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i6;
        int i7;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int width = bounds.width();
            i6 = insets.left;
            i7 = insets.right;
            return (width - i6) - i7;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String O(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageInfo packageInfo = y.getPackageInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, 64);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }
}
