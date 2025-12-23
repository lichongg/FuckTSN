package com.kuaishou.weapon.p0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import com.acse.ottn.l3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bl {
    public static String a() {
        try {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String b() {
        try {
            String str = Build.BRAND;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String c() {
        try {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String d() {
        try {
            String str = Build.HARDWARE;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String e() {
        try {
            String str = Build.PRODUCT;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String f() {
        try {
            String str = Build.DEVICE;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String g() {
        try {
            String str = Build.BOARD;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String h() {
        try {
            String str = Build.HOST;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String i() {
        try {
            String str = Build.USER;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String j() {
        try {
            String str = Build.TYPE;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String u() {
        Process process;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                inputStream = process.waitFor() == 0 ? process.getInputStream() : process.getErrorStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
                } catch (Throwable unused) {
                }
                try {
                    String readLine = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    process.destroy();
                    return readLine;
                } catch (Throwable unused4) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    if (process == null) {
                        return bi.f35771d;
                    }
                    process.destroy();
                    return bi.f35771d;
                }
            } catch (Throwable unused7) {
                inputStream = null;
            }
        } catch (Throwable unused8) {
            process = null;
            inputStream = null;
        }
    }

    public static String A() {
        try {
            String a6 = bh.a("persist.service.bdroid.bdaddr");
            return TextUtils.isEmpty(a6) ? bi.f35770c : a6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String B() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(l3.f4736f, String.class).invoke(cls, "gsm.version.baseband");
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String D() {
        try {
            return BigDecimal.valueOf((new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String E() {
        try {
            return BigDecimal.valueOf((new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String F() {
        return bi.f35771d;
    }

    public static String G() {
        return bi.f35771d;
    }

    public static long H() {
        BufferedReader bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        do {
            try {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                    }
                } catch (Throwable unused2) {
                    if (bufferedReader == null) {
                        return 0L;
                    }
                    bufferedReader.close();
                    return 0L;
                }
                bufferedReader.close();
                return 0L;
            } catch (IOException unused3) {
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return longValue;
    }

    public static String I() {
        try {
            return f.a(new File("/system/bin/app_process"));
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String J() {
        try {
            File file = new File("/system/bin/servicemanager");
            return (file.exists() && file.canRead()) ? f.a(file) : bi.f35771d;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String K() {
        try {
            File file = new File("/system/framework/framework.jar");
            return (file.exists() && file.canRead()) ? f.a(file) : bi.f35771d;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String k() {
        try {
            String str = Build.TAGS;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String l() {
        try {
            String str = Build.BOOTLOADER;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String m() {
        try {
            String str = Build.ID;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String n() {
        try {
            String str = Build.DISPLAY;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String o() {
        try {
            String str = Build.VERSION.CODENAME;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String p() {
        try {
            String a6 = bh.a("rild.libpath");
            return TextUtils.isEmpty(a6) ? bi.f35770c : a6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String q() {
        try {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String s() {
        try {
            String str = Build.FINGERPRINT;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String t() {
        try {
            String property = System.getProperty("http.agent");
            return TextUtils.isEmpty(property) ? bi.f35770c : property;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String v() {
        try {
            String str = Build.RADIO;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String w() {
        try {
            String a6 = bh.a("ro.build.description");
            return TextUtils.isEmpty(a6) ? bi.f35770c : a6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String x() {
        try {
            String str = Build.VERSION.INCREMENTAL;
            return TextUtils.isEmpty(str) ? bi.f35770c : str;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String y() {
        try {
            String a6 = bh.a("ro.product.name");
            return TextUtils.isEmpty(a6) ? bi.f35770c : a6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String z() {
        try {
            String a6 = bh.a("dalvik.vm.heapgrowthlimit");
            return TextUtils.isEmpty(a6) ? bi.f35770c : a6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String C() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfCameras);
            return sb.toString();
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String L() {
        return Build.getRadioVersion();
    }

    public static int a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getPhoneType();
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String b(Context context) {
        String property;
        try {
            try {
                property = WebSettings.getDefaultUserAgent(context);
            } catch (Throwable unused) {
                property = System.getProperty("http.agent");
            }
            return TextUtils.isEmpty(property) ? bi.f35770c : property;
        } catch (Throwable unused2) {
            return bi.f35771d;
        }
    }

    public static String c(Context context) {
        int i6;
        int i7;
        WindowMetrics maximumWindowMetrics;
        Rect bounds;
        Rect bounds2;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                bounds = maximumWindowMetrics.getBounds();
                i6 = bounds.width();
                bounds2 = maximumWindowMetrics.getBounds();
                i7 = bounds2.height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i6 = point.x;
                i7 = point.y;
            }
            float a6 = a(j(context));
            float b6 = b(j(context));
            if (a6 != 0.0f && b6 != 0.0f) {
                int round = Math.round((i6 / a6) * 2.54f) * 10;
                int round2 = Math.round((i7 / b6) * 2.54f) * 10;
                if (round > round2) {
                    return round2 + "mm * " + round + "mm";
                }
                return round + "mm * " + round2 + "mm";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String d(Context context) {
        int i6;
        int i7;
        WindowMetrics maximumWindowMetrics;
        Rect bounds;
        Rect bounds2;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                bounds = maximumWindowMetrics.getBounds();
                i6 = bounds.width();
                bounds2 = maximumWindowMetrics.getBounds();
                i7 = bounds2.height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i6 = point.x;
                i7 = point.y;
            }
            if (i6 > i7) {
                return i7 + "*" + i6;
            }
            return i6 + "*" + i7;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(Context context) {
        DisplayMetrics j6 = j(context);
        if (j6 != null) {
            return Integer.toString(j6.densityDpi);
        }
        return null;
    }

    public static String f(Context context) {
        Process process;
        InputStream inputStream = null;
        r7 = null;
        String str = null;
        inputStream = null;
        try {
            process = Runtime.getRuntime().exec("cat /proc/version");
            try {
                InputStream inputStream2 = process.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    int read = inputStream2.read(bArr);
                    if (read <= 0) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused) {
                        }
                        process.destroy();
                        return bi.f35770c;
                    }
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    String str2 = new String(bArr2, "utf-8");
                    int indexOf = str2.indexOf("version");
                    if (indexOf != -1) {
                        String[] split = str2.substring(indexOf).split(" ");
                        if (1 < split.length) {
                            str = split[1];
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused2) {
                        }
                        process.destroy();
                        return bi.f35770c;
                    }
                    try {
                        inputStream2.close();
                    } catch (Throwable unused3) {
                    }
                    process.destroy();
                    return str;
                } catch (Throwable unused4) {
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                        return bi.f35771d;
                    }
                    return bi.f35771d;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            process = null;
        }
    }

    public static int g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
        } catch (Exception unused) {
            return -2;
        }
    }

    public static int h(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getRingerMode();
        } catch (Exception unused) {
            return -2;
        }
    }

    public static int i(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), null)).booleanValue() ? 0 : 1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    private static DisplayMetrics j(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static float a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.xdpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    private static float b(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.ydpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
