package com.autonavi.aps.amapapi.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.baidu.mobads.sdk.internal.by;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    static WifiManager f10276a;

    /* renamed from: b, reason: collision with root package name */
    private static int f10277b;

    /* renamed from: c, reason: collision with root package name */
    private static String[] f10278c;

    /* renamed from: d, reason: collision with root package name */
    private static String f10279d;

    public static float a(float f6) {
        return (float) (((long) (f6 * 100.0d)) / 100.0d);
    }

    public static double b(double d6) {
        return ((long) (d6 * 1000000.0d)) / 1000000.0d;
    }

    public static double c(double d6) {
        return ((long) (d6 * 100.0d)) / 100.0d;
    }

    private static boolean d(Context context, String str) throws Throwable {
        return ((Integer) f.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) f.a(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static String e() {
        try {
            return j4.f("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean f(Context context) {
        int i6;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            i6 = f.b(((Application) context).getBaseContext(), "checkSelfPermission", com.autonavi.aps.amapapi.b.E);
        } catch (Throwable unused) {
            i6 = 0;
        }
        return i6 == 0;
    }

    @SuppressLint({"NewApi"})
    public static boolean g(Context context) {
        boolean z5;
        if (context == null) {
            return true;
        }
        if (f10276a == null) {
            f10276a = (WifiManager) a(context, "wifi");
        }
        try {
            if (c(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                z5 = f10276a.isWifiEnabled();
            } else {
                b.a(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z5 = false;
            }
            try {
                d.b();
            } catch (Throwable unused) {
                d.c();
                return z5 ? z5 : z5;
            }
        } catch (Throwable unused2) {
            z5 = false;
        }
        if (z5 && c() > 17) {
            try {
                return "true".equals(String.valueOf(f.a(f10276a, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused3) {
                return z5;
            }
        }
    }

    public static String h(Context context) {
        NetworkInfo c6 = c(context);
        if (c6 == null || !c6.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c6.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = c6.getSubtypeName();
        switch (c6.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                return "GSM".equalsIgnoreCase(subtypeName) ? "2G" : ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
        }
    }

    public static boolean m(Context context) {
        try {
            if (p(context) || o(context)) {
                return true;
            }
            return n(context);
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean p(Context context) {
        int checkSelfPermission;
        int checkSelfPermission2;
        try {
            if (Build.VERSION.SDK_INT >= 31 && context != null) {
                checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36047g);
                if (checkSelfPermission != 0) {
                    checkSelfPermission2 = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36048h);
                    if (checkSelfPermission2 == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean q(Context context) {
        try {
            int i6 = Build.VERSION.SDK_INT;
            int i7 = context.getApplicationInfo().targetSdkVersion;
            return ((i6 == 30) && (i7 >= 23)) || ((i6 == 31) && (i7 <= 30 && i7 >= 23));
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        if (r8 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
    
        if (r8 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean r(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = r8.getPackageName()     // Catch: java.lang.Throwable -> L42
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L42
            java.lang.String r8 = "content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L42
            java.lang.String r8 = "package_name"
            java.lang.String r4 = "selected_fuzzy"
            java.lang.String[] r4 = new java.lang.String[]{r8, r4}     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "package_name=?"
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L42
            r7 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L42
            r1 = 0
        L23:
            if (r8 == 0) goto L3c
            boolean r2 = r8.moveToNext()     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L3c
            java.lang.String r2 = r8.getString(r0)     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L23
            r2 = 1
            int r3 = r8.getInt(r2)     // Catch: java.lang.Throwable -> L3a
            if (r3 != r2) goto L23
            r1 = 1
            goto L23
        L3a:
            r0 = r1
            goto L43
        L3c:
            if (r8 == 0) goto L41
            r8.close()
        L41:
            return r1
        L42:
            r8 = 0
        L43:
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Throwable -> L4c
            if (r8 == 0) goto L4f
        L48:
            r8.close()
            goto L4f
        L4c:
            if (r8 == 0) goto L4f
            goto L48
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.j.r(android.content.Context):boolean");
    }

    private static boolean s(Context context) {
        int checkSelfPermission;
        try {
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    return context != null && context.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") == 0;
                }
                if (context != null) {
                    checkSelfPermission = context.checkSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION");
                    if (checkSelfPermission == 0) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                d.b();
                return false;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static boolean a(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar == null || "8".equals(aVar.d()) || "5".equals(aVar.d()) || "6".equals(aVar.d())) {
            return false;
        }
        return b(aVar);
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static int c() {
        int i6 = f10277b;
        if (i6 > 0) {
            return i6;
        }
        try {
            try {
                return f.b("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return Integer.parseInt(f.a("android.os.Build$VERSION", "SDK").toString());
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean j(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static String l(Context context) {
        if (f10279d == null) {
            f10279d = com.autonavi.aps.amapapi.security.a.a(by.f10823a, f4.g(context));
        }
        return f10279d;
    }

    private static boolean n(Context context) {
        return h("huawei") && q(context) && s(context);
    }

    private static boolean o(Context context) {
        return h("vivo") && q(context) && r(context);
    }

    public static String i(Context context) {
        String I = i4.I();
        if (TextUtils.isEmpty(I) || I.equals("00:00:00:00:00:00")) {
            I = i.a(context);
        }
        if (TextUtils.isEmpty(I)) {
            return "00:00:00:00:00:00";
        }
        return I;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(b.f10243j)) {
            return b.f10243j;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(f4.g(context), 64);
        } catch (Throwable th) {
            b.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(b.f10244k)) {
                b.f10244k = null;
            }
        } catch (Throwable th2) {
            b.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            CharSequence loadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
            if (loadLabel != null) {
                sb.append(loadLabel.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String g6 = f4.g(context);
        if (!TextUtils.isEmpty(g6)) {
            sb.append(",");
            sb.append(g6);
        }
        if (!TextUtils.isEmpty(b.f10244k)) {
            sb.append(",");
            sb.append(b.f10244k);
        }
        String sb2 = sb.toString();
        b.f10243j = sb2;
        return sb2;
    }

    public static int f(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static boolean e(Context context) {
        int i6;
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : com.autonavi.aps.amapapi.b.D) {
                try {
                    i6 = f.b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i6 = 0;
                }
                if (i6 != 0) {
                    return false;
                }
            }
        } else {
            for (String str2 : com.autonavi.aps.amapapi.b.D) {
                if (context.checkCallingOrSelfPermission(str2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static NetworkInfo c(Context context) {
        try {
            return i4.O(context);
        } catch (Throwable th) {
            b.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i6;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i7 = 0;
            while (i7 < charArray.length && Character.isDigit(charArray[i7])) {
                i7++;
            }
            strArr2[1] = networkOperator.substring(3, i7 + 3);
        }
        try {
            i6 = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            b.a(th, "Utils", "getMccMnc");
            i6 = 0;
        }
        if (i6 == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = f10278c) != null) ? strArr : strArr2;
        }
        f10278c = strArr2;
        return strArr2;
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static double c(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo c6 = c(context);
            if (c6 != null) {
                if (c6.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static FileOutputStream c(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        }
        return new FileOutputStream(file, false);
    }

    public static float d(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static byte g(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static int e(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    private static boolean h(String str) {
        try {
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
            return str3.toLowerCase().contains(str);
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        int checkSelfPermission;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return context != null && context.checkCallingOrSelfPermission(q4.u(str)) == 0;
            }
            if (context != null) {
                checkSelfPermission = context.checkSelfPermission(q4.u(str));
                if (checkSelfPermission == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (c() < 17) {
                return d(context, "android.provider.Settings$System");
            }
            return d(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] b(int i6, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i7 = 0; i7 < bArr.length; i7++) {
            bArr[i7] = (byte) ((i6 >> (i7 * 8)) & 255);
        }
        return bArr;
    }

    public static int b(byte[] bArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 2; i7++) {
            i6 |= (bArr[i7] & 255) << ((1 - i7) * 8);
        }
        return i6;
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static ArrayList<String> b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i6 = 0; i6 < split.length; i6++) {
                if (split[i6].contains(",nb") || split[i6].contains(",access")) {
                    arrayList.add(split[i6]);
                }
            }
        }
        return arrayList;
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    private static FileInputStream b(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(str);
        } catch (Throwable th) {
            b.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        return q4.t(bArr);
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return q4.m(jSONObject, str);
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || "00:00:00:00:00:00".equals(str) || "02:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static String a(ConnectivityManager connectivityManager) {
        int i6 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    i6 = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused) {
            }
        }
        switch (i6) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static byte[] a(long j6) {
        byte[] bArr = new byte[8];
        for (int i6 = 0; i6 < 8; i6++) {
            bArr[i6] = (byte) ((j6 >> (i6 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(int i6, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i6 & 255);
        bArr[1] = (byte) ((i6 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(long r4, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L8
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
        L8:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L17
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L17
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L17
            r1.applyPattern(r6)     // Catch: java.lang.Throwable -> L14
            goto L20
        L14:
            r6 = move-exception
            r0 = r1
            goto L18
        L17:
            r6 = move-exception
        L18:
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.autonavi.aps.amapapi.utils.b.a(r6, r1, r2)
            r1 = r0
        L20:
            r2 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L2a
            long r4 = a()
        L2a:
            if (r1 != 0) goto L2f
            java.lang.String r4 = "NULL"
            return r4
        L2f:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = r1.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.j.a(long, java.lang.String):java.lang.String");
    }

    public static double a(double d6) {
        return b(d6);
    }

    public static String a(int i6) {
        if (i6 != 33) {
            switch (i6) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                default:
                    switch (i6) {
                    }
            }
            return "其他错误";
        }
        return "补偿定位失败，未命中缓存";
    }

    public static boolean a(Location location, int i6) {
        boolean z5;
        Bundle extras;
        try {
            z5 = location.isFromMockProvider();
        } catch (Throwable unused) {
            z5 = false;
        }
        if (z5) {
            return true;
        }
        try {
            extras = location.getExtras();
        } catch (Throwable unused2) {
        }
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        if (i6 == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f) {
            if (location.getSpeed() == 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        boolean z5 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    cursor = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + replace + "'", null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                if (cursor.getInt(0) > 0) {
                                    z5 = true;
                                }
                            }
                        } catch (Throwable unused) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            return true;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z5;
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> b6 = b(str);
            String[] split = str2.toString().split("#");
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < split.length; i8++) {
                if (split[i8].contains(",nb") || split[i8].contains(",access")) {
                    i6++;
                    if (b6.contains(split[i8])) {
                        i7++;
                    }
                }
            }
            if (i7 * 2 >= (b6.size() + i6) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static List<String> a(File file) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = b(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    arrayList.add(readLine);
                                } else {
                                    bufferedReader2.close();
                                    inputStreamReader.close();
                                    fileInputStream.close();
                                    return arrayList;
                                }
                            } catch (Throwable unused) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return arrayList;
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    inputStreamReader = null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = c(file);
                    if (str != null) {
                        fileOutputStream.write(str.getBytes());
                    }
                    fileOutputStream.close();
                } catch (Throwable th) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }
}
