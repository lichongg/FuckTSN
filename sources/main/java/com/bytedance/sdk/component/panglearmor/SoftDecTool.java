package com.bytedance.sdk.component.panglearmor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.work.PeriodicWorkRequest;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.vl;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.SystemPropertiesUtil;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SoftDecTool {
    public static final String SP_NAME = "softdec";

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f26674a = false;
    public static volatile double acs = -1.0d;
    public static volatile long act = 0;
    private static volatile boolean cw = true;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f26675f;

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f26676h;

    /* renamed from: j, reason: collision with root package name */
    private static SharedPreferences f26677j;
    private static volatile int xt;

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
    
        if (r3 == null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @com.bytedance.component.sdk.annotation.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b() {
        /*
            java.lang.String r0 = com.bytedance.sdk.component.panglearmor.m.m()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Lc
            r0 = 1
            return r0
        Lc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/apk/base-1.apk"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 11
            r2 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r3.getEntry(r0)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.io.InputStream r0 = r3.getInputStream(r0)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r4 = j(r0)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            r5.<init>()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            int r6 = r4.length()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            int r6 = r6 / 2
            java.lang.String r6 = r4.substring(r6)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            r5.append(r6)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            int r6 = r4.length()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            int r6 = r6 / 2
            r7 = 0
            java.lang.String r4 = r4.substring(r7, r6)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            r5.append(r4)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            java.lang.String r5 = "assets/pangle_vp_config.db"
            java.util.zip.ZipEntry r5 = r3.getEntry(r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            if (r5 == 0) goto L80
            java.io.InputStream r2 = r3.getInputStream(r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            int r5 = r2.available()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            r2.read(r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            boolean r1 = r6.equals(r4)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            goto L80
        L76:
            r1 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L9c
        L7b:
            r8 = r2
            r2 = r0
            r0 = r8
            goto Lb2
        L80:
            if (r0 == 0) goto L87
            r0.close()     // Catch: java.io.IOException -> L86
            goto L87
        L86:
        L87:
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L8c
        L8c:
            r3.close()     // Catch: java.io.IOException -> Lc3
            goto Lc3
        L90:
            r1 = move-exception
            r0 = r2
            goto L9c
        L93:
            r0 = r2
            goto Lb2
        L96:
            r1 = move-exception
            r0 = r2
            r3 = r0
            goto L9c
        L9a:
            goto Lb0
        L9c:
            if (r2 == 0) goto La3
            r2.close()     // Catch: java.io.IOException -> La2
            goto La3
        La2:
        La3:
            if (r0 == 0) goto Laa
            r0.close()     // Catch: java.io.IOException -> La9
            goto Laa
        La9:
        Laa:
            if (r3 == 0) goto Laf
            r3.close()     // Catch: java.io.IOException -> Laf
        Laf:
            throw r1
        Lb0:
            r0 = r2
            r3 = r0
        Lb2:
            if (r2 == 0) goto Lb9
            r2.close()     // Catch: java.io.IOException -> Lb8
            goto Lb9
        Lb8:
        Lb9:
            if (r0 == 0) goto Lc0
            r0.close()     // Catch: java.io.IOException -> Lbf
            goto Lc0
        Lbf:
        Lc0:
            if (r3 == 0) goto Lc3
            goto L8c
        Lc3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglearmor.SoftDecTool.b():int");
    }

    @HungeonFlag
    public static native Object b(int i6, Object[] objArr);

    public static native byte[] bc(int i6, byte[] bArr);

    @DungeonFlag
    private static String j(InputStream inputStream) {
        int i6;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b6 : digest) {
                int i7 = b6 & 255;
                if (i7 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i7));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("UnsupportedEncodingException", e6);
        } catch (IOException e7) {
            vl.j(e7);
            return "";
        } catch (NoSuchAlgorithmException e8) {
            throw new RuntimeException("NoSuchAlgorithmException", e8);
        }
    }

    public static void ua() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            acs = sharedPreferences.getFloat("acs", -1.0f);
            act = sharedPreferences.getLong(SocialConstants.PARAM_ACT, 0L);
        }
    }

    @DungeonFlag
    public static synchronized Object cn(int i6, Object[] objArr) {
        synchronized (SoftDecTool.class) {
            if (!g.xt()) {
                return null;
            }
            return b(i6, objArr);
        }
    }

    @DungeonFlag
    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong(bi.aL, System.currentTimeMillis()).apply();
        }
    }

    @DungeonFlag
    public static String dgb() {
        StringBuilder sb = new StringBuilder();
        sb.append(j(Build.BOARD, "ro.product.board"));
        sb.append(j(Build.MODEL, "ro.product.model"));
        sb.append(j(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(j(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(j(Build.DISPLAY, "ro.build.display.id"));
        long j6 = Build.TIME;
        long parseLong = Long.parseLong(m.j(SystemPropertiesUtil.PROP_UTC, "-1"));
        if (j6 == -1000 || parseLong == -1) {
            sb.append("00");
        } else {
            if (String.valueOf(j6).length() >= 10) {
                sb.append(Long.parseLong(String.valueOf(j6).substring(0, 10)) == parseLong ? 0 : 1);
            } else {
                sb.append(1);
            }
            sb.append(j6 == parseLong * 1000 ? 0 : 1);
        }
        return sb.toString();
    }

    @DungeonFlag
    public static String dn() {
        try {
            return !cw ? "no_collection_allowed" : Settings.Secure.getString(m.r().getContentResolver(), "bluetooth_name");
        } catch (Throwable unused) {
            return "-1";
        }
    }

    @DungeonFlag
    public static long fr() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences == null) {
            return 0L;
        }
        long j6 = sharedPreferences.getLong("frt", 0L);
        if (j6 != 0) {
            return j6;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        sharedPreferences.edit().putLong("frt", currentTimeMillis).apply();
        return currentTimeMillis;
    }

    @DungeonFlag
    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j6 = sharedPreferences.getLong(bi.aL, 0L);
            if (j6 != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j6 <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                return string;
            }
        }
        return "";
    }

    @DungeonFlag
    public static JSONObject gdh() {
        List<Sensor> sensorList;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || m.r() == null || j(m.r().getPackageManager().getPackageInfo(m.r().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            SensorManager sensorManager = (SensorManager) m.r().getSystemService(bi.ac);
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        treeSet.add(String.format(Locale.getDefault(), "%s###%s###%d", sensor.getName(), sensor.getVendor(), Integer.valueOf(sensor.getType())));
                    }
                }
            }
            String j6 = m.j("gsm.version.baseband", "");
            String j7 = m.j("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sensors", treeSet);
            jSONObject.put("radio", j6);
            jSONObject.put("fp", j7);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", m.j("ro.build.display.id", ""));
            jSONObject.put("build_id", m.j("ro.build.id", ""));
            jSONObject.put("incremental", m.j("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", m.j(SystemPropertiesUtil.PROP_UTC, ""));
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences(String str) {
        Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (f26677j == null) {
            try {
                Context r5 = m.r();
                if (r5 != null && str != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        createDeviceProtectedStorageContext = r5.createDeviceProtectedStorageContext();
                        moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(r5, str);
                        if (!moveSharedPreferencesFrom) {
                            vl.xt("HARLOG", "Failed to move shared preferences.");
                        }
                        r5 = createDeviceProtectedStorageContext;
                    }
                    f26677j = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(r5, str, 0);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return f26677j;
    }

    @DungeonFlag
    public static synchronized int h(String str, boolean z5) {
        synchronized (SoftDecTool.class) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
                int i6 = sharedPreferences.getInt(str, 0);
                if (!z5) {
                    return i6;
                }
                int i7 = i6 + 1;
                sharedPreferences.edit().putInt(str, i7).apply();
                return i7;
            } catch (Throwable th) {
                vl.j(th);
                return -1;
            }
        }
    }

    @DungeonFlag
    public static int hv() {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) m.r().getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            return connectivityManager.getNetworkCapabilities(activeNetwork).hasCapability(15) ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @DungeonFlag
    public static String i() {
        int i6 = xt + 1;
        xt = i6;
        if (i6 != 2) {
            return "2";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) m.r().getSystemService("accessibility");
            TreeSet treeSet = new TreeSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getInstalledAccessibilityServiceList()) {
                treeSet.add(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
            }
            JSONArray jSONArray = new JSONArray((Collection) treeSet);
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            String jSONArray2 = jSONArray.toString();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String string = sharedPreferences.getString("iacba", "");
            String string2 = sharedPreferences.getString("date", "1970-01-01");
            if (string.equals(jSONArray.toString()) && format.equals(string2)) {
                return "2";
            }
            sharedPreferences.edit().putString("iacba", jSONArray2).apply();
            sharedPreferences.edit().putString("date", format).apply();
            return jSONArray2;
        } catch (Throwable th) {
            vl.j(th);
            return "-1";
        }
    }

    @DungeonFlag
    public static String kv() {
        return System.getProperty("os.version");
    }

    @DungeonFlag
    public static String prx() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        return (TextUtils.isEmpty(property) && TextUtils.isEmpty(property2)) ? "" : String.format("%s:%s", property, property2);
    }

    public static void setBlt(boolean z5) {
        cw = z5;
    }

    @DungeonFlag
    public static long fi() {
        try {
            return m.r().getPackageManager().getPackageInfo(m.r().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException e6) {
            vl.j(e6);
            return 0L;
        }
    }

    @DungeonFlag
    public static String p() {
        return com.bytedance.sdk.openadsdk.api.plugin.xt.j(m.r()).getPath();
    }

    @DungeonFlag
    public static void rsd(final String str) {
        com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.SoftDecTool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    tl ae = m.ae();
                    if (ae != null) {
                        JSONObject gdh = SoftDecTool.gdh();
                        if (gdh == null && !TextUtils.isEmpty(str)) {
                            gdh = new JSONObject();
                        }
                        if (gdh != null) {
                            if (!TextUtils.isEmpty(str)) {
                                gdh.put("rd2", str);
                            }
                            ae.j("device_hardware", gdh);
                        }
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }, 20000L);
    }

    @DungeonFlag
    public static long tft() {
        return m.tl();
    }

    @DungeonFlag
    public static int trc() {
        return m.g();
    }

    @DungeonFlag
    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) m.r().getSystemService("usb")).getAccessoryList();
        if (accessoryList == null || accessoryList.length == 0) {
            return 0;
        }
        return 1;
    }

    public static void ua(double d6, long j6) {
        acs = d6;
        act = j6;
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat("acs", (float) d6).putLong(SocialConstants.PARAM_ACT, j6).apply();
        }
    }

    private static boolean j(long j6, long j7) {
        long j8 = j7 - j6;
        return j8 < 86400000 && j8 > -86400000 && j(j6) == j(j7);
    }

    private static long j(long j6) {
        return (j6 + TimeZone.getDefault().getOffset(j6)) / 86400000;
    }

    @DungeonFlag
    private static int j(String str, String str2) {
        String j6 = m.j(str2, "unknown");
        return (str.equals("unknown") || j6.equals("unknown") || str.equals(j6)) ? 0 : 1;
    }
}
