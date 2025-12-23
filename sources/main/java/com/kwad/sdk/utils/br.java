package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class br {
    private static String baZ = null;
    private static String bba = "";
    private static boolean bbb = false;
    private static String bbc = "";
    private static String bbd = "";
    private static int bbe;
    private static boolean bbf;
    private static int bbg;
    private static boolean bbh;
    private static String bbm;
    private static String bbn;
    private static int bbv;
    private static long bbw;
    private static final String[] bbi = {"", ""};
    private static String bbj = "";
    private static String bbk = "";
    private static String bbl = "";
    private static int bbo = -1;
    private static boolean bbp = false;
    private static boolean bbq = false;
    private static boolean bbr = false;
    private static boolean bbs = false;
    private static boolean bbt = false;
    private static boolean bbu = false;
    private static String bbx = "";
    private static String bby = "";
    public static String bbz = "";
    private static final List<String> bbA = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long RN() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private static boolean ea(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static boolean ed(@NonNull Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 30 || Build.VERSION.SDK_INT < 30) {
            return context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36050j) == 0;
        }
        return false;
    }

    public static Pair<Boolean, Boolean> ee(Context context) {
        boolean z5;
        boolean z6;
        boolean z7 = false;
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            accessibilityManager.getEnabledAccessibilityServiceList(16);
            boolean isEnabled = accessibilityManager.isEnabled();
            try {
                z6 = !accessibilityManager.getEnabledAccessibilityServiceList(16).isEmpty();
            } catch (Throwable th) {
                th = th;
                z7 = isEnabled;
                z5 = false;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z7), Boolean.valueOf(z5));
            }
            try {
                return new Pair<>(Boolean.valueOf(isEnabled), Boolean.valueOf(z6));
            } catch (Throwable th2) {
                th = th2;
                z5 = z6;
                z7 = isEnabled;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z7), Boolean.valueOf(z5));
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean hx(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            try {
                if (str.charAt(i6) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static long RQ() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long RR() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory > 0) {
            return freeMemory;
        }
        return 0L;
    }

    public static int RS() {
        int i6 = bbv;
        if (i6 > 0) {
            return i6;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        bbv = availableProcessors;
        return availableProcessors;
    }

    public static String RT() {
        return Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:12:0x0021, B:14:0x0027, B:16:0x002d, B:17:0x0030, B:19:0x0036, B:21:0x0040, B:22:0x0043, B:24:0x0049, B:26:0x0053, B:27:0x0056, B:29:0x005c, B:31:0x0066, B:32:0x0069, B:34:0x006f), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized long RU() {
        /*
            java.lang.Class<com.kwad.sdk.utils.br> r0 = com.kwad.sdk.utils.br.class
            monitor-enter(r0)
            boolean r1 = com.kwad.sdk.utils.bc.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            java.lang.String r1 = com.kwad.sdk.utils.bc.getDevImei()     // Catch: java.lang.Throwable -> L1a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1c
            java.lang.String[] r1 = com.kwad.sdk.utils.bc.getDevImeis()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            goto L1c
        L1a:
            r1 = move-exception
            goto L7a
        L1c:
            r1 = 1
            goto L21
        L1f:
            r1 = 0
        L21:
            boolean r3 = com.kwad.sdk.utils.bc.readLocationDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            com.kwad.sdk.internal.api.a r3 = com.kwad.sdk.utils.bc.Ro()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            r3 = 64
            long r1 = r1 | r3
        L30:
            boolean r3 = com.kwad.sdk.utils.bc.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L43
            java.lang.String r3 = com.kwad.sdk.utils.bc.getDevAndroidId()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L43
            r3 = 2
            long r1 = r1 | r3
        L43:
            boolean r3 = com.kwad.sdk.utils.bc.useMacAddressDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L56
            java.lang.String r3 = com.kwad.sdk.utils.bc.getDevMacAddress()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L56
            r3 = 4
            long r1 = r1 | r3
        L56:
            boolean r3 = com.kwad.sdk.utils.bc.useOaidDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L69
            java.lang.String r3 = com.kwad.sdk.utils.bc.getDevOaid()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L69
            r3 = 2048(0x800, double:1.012E-320)
            long r1 = r1 | r3
        L69:
            boolean r3 = com.kwad.sdk.utils.bc.readInstalledPackagesDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            java.util.List r3 = com.kwad.sdk.utils.bc.getDevInstalledPackages()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            r3 = 16
            long r1 = r1 | r3
        L78:
            monitor-exit(r0)
            return r1
        L7a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.br.RU():long");
    }

    public static String RV() {
        return Build.BRAND;
    }

    public static String RW() {
        return Build.CPU_ABI;
    }

    public static synchronized long RX() {
        long elapsedRealtime;
        synchronized (br.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long RY() {
        long j6;
        synchronized (br.class) {
            j6 = Build.TIME;
        }
        return j6;
    }

    public static synchronized String RZ() {
        String str;
        synchronized (br.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String Sa() {
        synchronized (br.class) {
            if (!TextUtils.isEmpty(baZ)) {
                return baZ;
            }
            String radioVersion = Build.getRadioVersion();
            baZ = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String Sb() {
        String name;
        synchronized (br.class) {
            name = bb.getName();
        }
        return name;
    }

    public static synchronized String Sc() {
        String version;
        synchronized (br.class) {
            version = bb.getVersion();
        }
        return version;
    }

    public static String Sd() {
        return Build.MANUFACTURER;
    }

    public static int Se() {
        if (bbo == -1) {
            bbo = ea(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return bbo;
    }

    public static String Sf() {
        if (TextUtils.isEmpty(bbn)) {
            try {
                bbn = System.getProperty("os.arch");
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }
        return bbn;
    }

    public static int Sg() {
        return Build.VERSION.SDK_INT;
    }

    private static String Si() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String Sj() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String h6 = ag.h("ksadsdk_pref", SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, (String) null);
        ag.i(h6, "ksadsdk_pref", SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return h6;
    }

    private static String a(String str, int i6, char c6) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String cn(boolean z5) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String appOAID = com.kwad.sdk.core.e.a.getAppOAID(context);
        return (TextUtils.isEmpty(appOAID) && !z5 && TextUtils.isEmpty(dT(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BA() : appOAID;
    }

    public static long dO(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int dR(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long dS(Context context) {
        long j6 = bbw;
        if (j6 > 0) {
            return j6;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j7 = memoryInfo.totalMem;
            if (j7 <= 0) {
                j7 = RN();
            }
            bbw = j7;
            return j7;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String dT(@Nullable Context context) {
        boolean z5;
        synchronized (br.class) {
            if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
                return bc.getDevImei();
            }
            if (bbp) {
                return bbc;
            }
            if (TextUtils.isEmpty(bbc) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return bbc;
                }
                if (bc.usePhoneStateDisable()) {
                    return bbc;
                }
                if (!s.PY()) {
                    return bbc;
                }
                try {
                    z5 = SystemUtil.dN(context);
                    if (z5) {
                        try {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            bbc = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                bbp = true;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            if (z5) {
                                bbp = true;
                            }
                            return bbc;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    z5 = false;
                }
                return bbc;
            }
            return bbc;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dU(@Nullable Context context) {
        boolean z5;
        String meid;
        synchronized (br.class) {
            if (bbu) {
                return bbd;
            }
            if (TextUtils.isEmpty(bbd) && context != null) {
                if (bc.usePhoneStateDisable()) {
                    return bbd;
                }
                if (!s.PX()) {
                    return bbl;
                }
                try {
                    z5 = SystemUtil.dN(context);
                    if (z5) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    meid = telephonyManager.getMeid();
                                    bbd = meid;
                                    if (TextUtils.isEmpty(meid)) {
                                        bbu = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 2) {
                                    String deviceId = telephonyManager.getDeviceId();
                                    bbd = deviceId;
                                    if (TextUtils.isEmpty(deviceId)) {
                                        bbu = true;
                                    }
                                } else {
                                    bbd = null;
                                    bbu = true;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            if (z5) {
                                bbu = true;
                            }
                            return bbd;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    z5 = false;
                }
                return bbd;
            }
            return bbd;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] dV(@Nullable Context context) {
        String deviceId;
        String imei;
        synchronized (br.class) {
            if (bc.usePhoneStateDisable() && bc.getDevImeis() != null) {
                return bc.getDevImeis();
            }
            if (bbt) {
                return bbi;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 29) {
                return bbi;
            }
            String[] strArr = bbi;
            boolean z5 = false;
            if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
                if (bc.usePhoneStateDisable()) {
                    return strArr;
                }
                if (!s.PY()) {
                    return strArr;
                }
                try {
                    boolean dN = SystemUtil.dN(context);
                    if (dN) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (i6 >= 26) {
                                    int min = Math.min(dW(context), 2);
                                    for (int i7 = 0; i7 < min; i7++) {
                                        String[] strArr2 = bbi;
                                        imei = telephonyManager.getImei(i7);
                                        strArr2[i7] = imei;
                                    }
                                    String[] strArr3 = bbi;
                                    if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                        bbt = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 1) {
                                    if (i6 >= 23) {
                                        int min2 = Math.min(dW(context), 2);
                                        for (int i8 = 0; i8 < min2; i8++) {
                                            String[] strArr4 = bbi;
                                            deviceId = telephonyManager.getDeviceId(i8);
                                            strArr4[i8] = deviceId;
                                        }
                                    } else {
                                        strArr[0] = telephonyManager.getDeviceId();
                                        strArr[1] = null;
                                    }
                                    String[] strArr5 = bbi;
                                    if (TextUtils.isEmpty(strArr5[0]) && TextUtils.isEmpty(strArr5[1])) {
                                        bbt = true;
                                    }
                                } else {
                                    strArr[0] = null;
                                    strArr[1] = null;
                                    bbt = true;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            z5 = dN;
                            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            if (z5) {
                                bbt = true;
                            }
                            return bbi;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                }
                return bbi;
            }
            return strArr;
        }
    }

    public static synchronized int dW(Context context) {
        int phoneCount;
        synchronized (br.class) {
            if (bbf || bbe > 0 || Build.VERSION.SDK_INT < 23 || context == null || bc.usePhoneStateDisable()) {
                return bbe;
            }
            try {
                phoneCount = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                bbe = phoneCount;
            } catch (Exception unused) {
            }
            int i6 = bbe;
            bbf = i6 == 0;
            return i6;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int dX(Context context) {
        int activeSubscriptionInfoCount;
        if (context == null || bbg > 0 || bbh || Build.VERSION.SDK_INT < 22 || !SystemUtil.dN(context) || bc.usePhoneStateDisable()) {
            return bbg;
        }
        try {
            activeSubscriptionInfoCount = com.bytedance.sdk.openadsdk.core.d.a(context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            bbg = activeSubscriptionInfoCount;
        } catch (Throwable unused) {
        }
        int i6 = bbg;
        bbh = i6 != 0;
        return i6;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String dY(Context context) {
        if (!TextUtils.isEmpty(bbk) || context == null) {
            return bbk;
        }
        if (bbr) {
            return bbk;
        }
        if (bc.usePhoneStateDisable()) {
            return bbk;
        }
        if (!s.Qa()) {
            return bbk;
        }
        try {
            if (SystemUtil.dN(context)) {
                bbk = ((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            bbk = null;
        }
        if (TextUtils.isEmpty(bbk)) {
            bbr = true;
        }
        String str = TextUtils.isEmpty(bbk) ? "" : bbk;
        bbk = str;
        return str;
    }

    public static synchronized int dZ(Context context) {
        int ringerMode;
        synchronized (br.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Exception unused) {
                return -1;
            }
        }
        return ringerMode;
    }

    @SuppressLint({"HardwareIds"})
    public static String dp(Context context) {
        if (!TextUtils.isEmpty(bbl) || context == null || bbs) {
            return bbl;
        }
        if (bc.usePhoneStateDisable()) {
            return bc.getDevAndroidId();
        }
        if (!s.PS()) {
            return bbl;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            bbl = string;
            if (!hx(string)) {
                bbl = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(bbl)) {
            bbs = true;
        }
        return bbl;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dt(Context context) {
        synchronized (br.class) {
            if (context != null) {
                if (!bbq && TextUtils.isEmpty(bbj) && SystemUtil.dN(context) && !bc.usePhoneStateDisable() && s.PZ()) {
                    try {
                        bbj = ((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    bbq = TextUtils.isEmpty(bbj);
                    return bbj;
                }
            }
            return bbj;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String eb(@Nullable Context context) {
        synchronized (br.class) {
            if (TextUtils.isEmpty(bba) && context != null && !bbb) {
                if (bc.useMacAddressDisable()) {
                    String devMacAddress = bc.getDevMacAddress();
                    bba = devMacAddress;
                    return devMacAddress;
                }
                if (!s.PT()) {
                    return bba;
                }
                try {
                    WifiInfo connectionInfo = ((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        bba = connectionInfo.getMacAddress();
                    }
                    if (hv(bba)) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    for (byte b6 : hardwareAddress) {
                                        sb.append(String.format("%02X:", Byte.valueOf(b6)));
                                    }
                                    if (sb.length() > 0) {
                                        sb.deleteCharAt(sb.length() - 1);
                                    }
                                    bba = sb.toString();
                                }
                            }
                        }
                    }
                    if (hv(bba)) {
                        bba = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                    }
                    if (!hv(bba)) {
                        bba = bba.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                    bbb = true;
                }
                bbb = hv(bba);
                return bba;
            }
            return bba;
        }
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
        if (!TextUtils.isEmpty(bbm)) {
            return bbm;
        }
        String Sj = Sj();
        if (!TextUtils.isEmpty(Sj)) {
            String str = "ANDROID_" + Sj;
            bbm = str;
            return str;
        }
        String dp = dp(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(dp) && !hw(dp) && hx(dp)) {
            String str2 = "ANDROID_" + dp;
            bbm = str2;
            return str2;
        }
        String Si = Si();
        if (!TextUtils.isEmpty(Si)) {
            bbm = "ANDROID_" + Si;
            hy(Si);
            return bbm;
        }
        return "ANDROID_";
    }

    public static String getLocale() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
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

    private static boolean hw(String str) {
        return bbA.contains(str.toLowerCase(Locale.US));
    }

    private static void hy(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ag.a("ksadsdk_pref", SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, str, true);
    }

    public static String hz(String str) {
        StructStat stat;
        StructTimespec structTimespec;
        StructTimespec structTimespec2;
        long j6;
        StructTimespec structTimespec3;
        long j7;
        String valueOf;
        if (!TextUtils.isEmpty(bby) || TextUtils.isEmpty(str)) {
            return bby;
        }
        int i6 = Build.VERSION.SDK_INT;
        try {
            stat = Os.stat(str);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
        if (stat == null) {
            return bby;
        }
        String str2 = "";
        if (i6 >= 27) {
            structTimespec = stat.st_atim;
            if (structTimespec == null) {
                valueOf = "";
            } else {
                structTimespec2 = stat.st_atim;
                j6 = structTimespec2.tv_sec;
                str2 = String.valueOf(j6);
                structTimespec3 = stat.st_atim;
                j7 = structTimespec3.tv_nsec;
                valueOf = String.valueOf(j7);
            }
            bby = str2 + "." + valueOf;
        } else {
            long j8 = stat.st_atime;
            if (j8 != 0) {
                str2 = String.valueOf(j8);
            }
            bby = str2;
        }
        return bby;
    }

    public static long RP() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static String Sh() {
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(bbz)) {
            return bbz;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        bbz = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @Nullable
    public static List<String> ec(@NonNull Context context) {
        String[] list;
        if (d.cr(context)) {
            return new ArrayList();
        }
        if (!ed(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    private static boolean hv(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("02:00:00:00:00:00")) {
            return false;
        }
        return true;
    }

    public static String w(@Nullable Context context, boolean z5) {
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
            return bc.getDevImei();
        }
        String dT = dT(context);
        if (TextUtils.isEmpty(dT) && !z5 && TextUtils.isEmpty(com.kwad.sdk.core.e.a.getAppOAID(context))) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bz();
        }
        return dT;
    }
}
