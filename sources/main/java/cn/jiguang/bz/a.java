package cn.jiguang.bz;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.media.MediaDrm;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import cn.jiguang.internal.JConstants;
import cn.jiguang.q.d;
import cn.jiguang.q.e;
import cn.jpush.android.service.PushReceiver;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f2663a = null;

    /* renamed from: b, reason: collision with root package name */
    private static a f2664b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f2665c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f2666d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static String f2667e = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f2668g = "";
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;

    /* renamed from: f, reason: collision with root package name */
    private String f2669f;

    /* renamed from: h, reason: collision with root package name */
    private WifiInfo f2670h;

    /* renamed from: n, reason: collision with root package name */
    private int f2676n;

    /* renamed from: o, reason: collision with root package name */
    private int f2677o;

    /* renamed from: p, reason: collision with root package name */
    private String f2678p;

    /* renamed from: y, reason: collision with root package name */
    private String f2687y;

    /* renamed from: z, reason: collision with root package name */
    private String f2688z;

    /* renamed from: i, reason: collision with root package name */
    private final int f2671i = 600000;

    /* renamed from: j, reason: collision with root package name */
    private final int f2672j = 3;

    /* renamed from: k, reason: collision with root package name */
    private String f2673k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f2674l = "";

    /* renamed from: m, reason: collision with root package name */
    private String f2675m = "";

    /* renamed from: q, reason: collision with root package name */
    private String f2679q = "";

    /* renamed from: r, reason: collision with root package name */
    private String f2680r = "";

    /* renamed from: s, reason: collision with root package name */
    private String f2681s = "";

    /* renamed from: t, reason: collision with root package name */
    private String f2682t = "";

    /* renamed from: u, reason: collision with root package name */
    private Boolean f2683u = null;

    /* renamed from: v, reason: collision with root package name */
    private Boolean f2684v = null;

    /* renamed from: w, reason: collision with root package name */
    private String f2685w = "";

    /* renamed from: x, reason: collision with root package name */
    private String f2686x = "";

    private int a(int i6) {
        int d6 = cn.jiguang.g.a.a().d(i6);
        if (d6 <= 0) {
            return 600000;
        }
        return d6;
    }

    private static Intent b(String str) {
        return a(str, Build.VERSION.SDK_INT >= 22 ? 4 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(android.content.Context r9) {
        /*
            java.lang.String r1 = "AndroidUtil"
            r2 = -1
            if (r9 != 0) goto L6
            return r2
        L6:
            cn.jiguang.g.a r0 = cn.jiguang.g.a.a()
            r3 = 1200(0x4b0, float:1.682E-42)
            boolean r0 = r0.g(r3)
            if (r0 == 0) goto L13
            return r2
        L13:
            android.content.IntentFilter r5 = new android.content.IntentFilter
            java.lang.String r0 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            r0.<init>()     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            r0.append(r3)     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            java.lang.String r3 = cn.jiguang.a.a.f1443a     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            r0.append(r3)     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            r7 = 0
            r8 = 0
            r4 = 0
            r3 = r9
            android.content.Intent r9 = cn.jiguang.bz.s.a(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L38 java.lang.SecurityException -> L53
            goto L57
        L38:
            r0 = move-exception
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getChargedStatus unkown exception:"
            r0.append(r3)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
        L4f:
            cn.jiguang.bb.f.i(r1, r9)
            goto L56
        L53:
            java.lang.String r9 = "getChargedStatus SecurityException"
            goto L4f
        L56:
            r9 = 0
        L57:
            if (r9 != 0) goto L5a
            return r2
        L5a:
            java.lang.String r0 = "status"
            int r0 = r9.getIntExtra(r0, r2)
            r1 = 2
            if (r0 == r1) goto L68
            r1 = 5
            if (r0 != r1) goto L67
            goto L68
        L67:
            return r2
        L68:
            java.lang.String r0 = "plugged"
            int r9 = r9.getIntExtra(r0, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.a.c(android.content.Context):int");
    }

    public static String i() {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            cn.jiguang.bb.f.c("AndroidUtil", "Cannot read /proc/version, returning default version.");
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } finally {
            }
        } catch (IOException e6) {
            cn.jiguang.bb.f.a("AndroidUtil", "Exception while attempting to read kernel information", e6);
            return property;
        }
    }

    @TargetApi(19)
    public static String l(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(f2668g) && !k.a("getExternalSdPath", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                File externalFilesDir = d.a(context).getExternalFilesDir(null);
                Objects.requireNonNull(externalFilesDir);
                File a6 = a(externalFilesDir);
                if (a6 != null) {
                    f2668g = a6.getAbsolutePath();
                }
                cn.jiguang.bb.f.c("AndroidUtil", "get sd ex path: " + f2668g);
            }
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(f2668g) ? "/storage/emulated/0" : f2668g;
    }

    @SuppressLint({"MissingPermission"})
    public synchronized String d(Context context, String str) {
        return a(context, str, true);
    }

    public String e() {
        try {
            if (!k.a("getPhoneIp", a(AVMDLDataLoader.KeyIsIsGetChecksumInfo), 1)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            String hostAddress = nextElement.getHostAddress();
                            this.f2686x = hostAddress;
                            return hostAddress;
                        }
                    }
                }
            }
            return !TextUtils.isEmpty(this.f2686x) ? this.f2686x : "";
        } catch (Exception e6) {
            cn.jiguang.bb.f.i("AndroidUtil", "getPI:" + e6.getMessage());
            return "";
        }
    }

    public String f() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            try {
                str = bufferedReader.readLine();
                bufferedReader.close();
                return str;
            } finally {
            }
        } catch (IOException unused) {
            return str;
        }
    }

    public String k(final Context context) {
        if (context != null && context.getResources() != null) {
            Object b6 = cn.jiguang.q.d.b(context, GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP, true, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.1
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (displayMetrics == null) {
                        return "0*0";
                    }
                    return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.f2669f = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.f2669f;
                }
            });
            if (b6 instanceof String) {
                return (String) b6;
            }
        }
        return "0*0";
    }

    public synchronized int m(Context context) {
        try {
            if (cn.jiguang.g.a.a().e(1500) && cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                WifiInfo I = I(context);
                if (I != null && !k.a("getWifiRssi", a(AVMDLDataLoader.KeyIsIsEncryptVersion), 3)) {
                    this.f2676n = I.getRssi();
                    cn.jiguang.bb.f.c("AndroidUtil", "get rssi by api, value is: " + this.f2676n);
                }
                return this.f2676n;
            }
            return 0;
        } finally {
        }
    }

    public synchronized int n(Context context) {
        try {
            if (cn.jiguang.g.a.a().e(1500) && cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                WifiInfo I = I(context);
                if (I != null && !k.a("getWifiNetWorkId", a(AVMDLDataLoader.KeyIsIsEncryptVersion), 3)) {
                    this.f2677o = I.getNetworkId();
                    cn.jiguang.bb.f.c("AndroidUtil", "get net id by api, value is: " + this.f2677o);
                }
                return this.f2677o;
            }
            return -1;
        } finally {
        }
    }

    public String o(Context context) {
        return c(context, false);
    }

    @SuppressLint({"MissingPermission"})
    public String r(Context context) {
        String str = "";
        if (Build.VERSION.SDK_INT < 23 && q.a(context, com.kuaishou.weapon.p0.g.f36044d)) {
            try {
                str = J(context);
                cn.jiguang.bb.f.c("AndroidUtil", "mac address from WifiManager:" + str);
                return str;
            } catch (Exception e6) {
                cn.jiguang.bb.f.b("AndroidUtil", "get mac from wifiManager failed ", e6);
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        r3 = new java.lang.StringBuilder();
        r5 = r4.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        if (r6 >= r5) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        r3.append(java.lang.String.format(java.util.Locale.ENGLISH, "%02x:", java.lang.Byte.valueOf(r4[r6])));
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        if (r3.length() <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        r3.deleteCharAt(r3.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
    
        r2 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
    
        cn.jiguang.bb.f.c("AndroidUtil", "mac address from NetworkInterface:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a7, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a8, code lost:
    
        r3 = r13;
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
    
        cn.jiguang.bb.f.i("AndroidUtil", "get mac from NetworkInterface failed:" + r13.getMessage());
        r13 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String s(android.content.Context r13) {
        /*
            r12 = this;
            java.lang.String r0 = "AndroidUtil"
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r3 = "android.permission.ACCESS_WIFI_STATE"
            boolean r3 = cn.jiguang.bz.q.a(r13, r3)     // Catch: java.lang.Exception -> L23
            if (r3 == 0) goto L28
            android.content.Context r13 = r13.getApplicationContext()     // Catch: java.lang.Exception -> L23
            android.content.Context r13 = com.stub.StubApp.getOrigApplicationContext(r13)     // Catch: java.lang.Exception -> L23
            java.lang.String r3 = "wifi"
            java.lang.Object r13 = r13.getSystemService(r3)     // Catch: java.lang.Exception -> L23
            android.net.wifi.WifiManager r13 = (android.net.wifi.WifiManager) r13     // Catch: java.lang.Exception -> L23
            boolean r13 = r13.isWifiEnabled()     // Catch: java.lang.Exception -> L23
            goto L29
        L23:
            r13 = move-exception
            r2 = r1
            r3 = 0
            goto Lae
        L28:
            r13 = 0
        L29:
            if (r13 != 0) goto L37
            java.lang.String r2 = "not get mac address for wifi disabled"
            cn.jiguang.bb.f.c(r0, r2)     // Catch: java.lang.Exception -> L31
            return r1
        L31:
            r2 = move-exception
            r3 = r13
            r13 = r2
            r2 = r1
            goto Lae
        L37:
            java.util.Enumeration r3 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Exception -> L31
        L3b:
            boolean r4 = r3.hasMoreElements()     // Catch: java.lang.Exception -> L31
            if (r4 == 0) goto Lac
            java.lang.Object r4 = r3.nextElement()     // Catch: java.lang.Exception -> L31
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch: java.lang.Exception -> L31
            java.lang.String r5 = "wlan0"
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Exception -> L31
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Exception -> L31
            if (r5 == 0) goto L3b
            byte[] r4 = r4.getHardwareAddress()     // Catch: java.lang.Exception -> L31
            if (r4 == 0) goto L3b
            int r5 = r4.length     // Catch: java.lang.Exception -> L31
            if (r5 != 0) goto L5e
            goto L3b
        L5e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
            r3.<init>()     // Catch: java.lang.Exception -> L31
            int r5 = r4.length     // Catch: java.lang.Exception -> L31
            r6 = 0
        L65:
            r7 = 1
            if (r6 >= r5) goto L80
            r8 = r4[r6]     // Catch: java.lang.Exception -> L31
            java.util.Locale r9 = java.util.Locale.ENGLISH     // Catch: java.lang.Exception -> L31
            java.lang.String r10 = "%02x:"
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch: java.lang.Exception -> L31
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L31
            r7[r2] = r8     // Catch: java.lang.Exception -> L31
            java.lang.String r7 = java.lang.String.format(r9, r10, r7)     // Catch: java.lang.Exception -> L31
            r3.append(r7)     // Catch: java.lang.Exception -> L31
            int r6 = r6 + 1
            goto L65
        L80:
            int r2 = r3.length()     // Catch: java.lang.Exception -> L31
            if (r2 <= 0) goto L8e
            int r2 = r3.length()     // Catch: java.lang.Exception -> L31
            int r2 = r2 - r7
            r3.deleteCharAt(r2)     // Catch: java.lang.Exception -> L31
        L8e:
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La7
            r3.<init>()     // Catch: java.lang.Exception -> La7
            java.lang.String r4 = "mac address from NetworkInterface:"
            r3.append(r4)     // Catch: java.lang.Exception -> La7
            r3.append(r2)     // Catch: java.lang.Exception -> La7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> La7
            cn.jiguang.bb.f.c(r0, r3)     // Catch: java.lang.Exception -> La7
            goto Lc7
        La7:
            r3 = move-exception
            r11 = r3
            r3 = r13
            r13 = r11
            goto Lae
        Lac:
            r2 = r1
            goto Lc7
        Lae:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "get mac from NetworkInterface failed:"
            r4.append(r5)
            java.lang.String r13 = r13.getMessage()
            r4.append(r13)
            java.lang.String r13 = r4.toString()
            cn.jiguang.bb.f.i(r0, r13)
            r13 = r3
        Lc7:
            if (r13 != 0) goto Lde
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r3 = "mac address is dropped, which is "
            r13.append(r3)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            cn.jiguang.bb.f.c(r0, r13)
            goto Ldf
        Lde:
            r1 = r2
        Ldf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.a.s(android.content.Context):java.lang.String");
    }

    public String t(Context context) {
        Object b6 = cn.jiguang.q.d.b(context, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, true, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.2
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.c(Build.PRODUCT);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.f2687y = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.f2687y;
            }
        });
        if (b6 instanceof String) {
            this.f2687y = (String) b6;
        }
        return this.f2687y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String K(Context context) {
        String str = "";
        try {
            if (JConstants.isAndroidQ(context, false, "do not getImei") || !q.a(context, com.kuaishou.weapon.p0.g.f36043c)) {
                return "";
            }
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            cn.jiguang.bb.f.i("AndroidUtil", "imei is : " + str);
            return str;
        } catch (Exception e6) {
            cn.jiguang.bb.f.l("AndroidUtil", e6.getMessage());
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String L(Context context) {
        String str = "";
        try {
            if (!JConstants.isAndroidQ(context, false, "do not getImsi") && q.a(context, com.kuaishou.weapon.p0.g.f36043c)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                cn.jiguang.bb.f.i("AndroidUtil", "imsi is : " + str);
                return str;
            }
            return "";
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("AndroidUtil", "getImsi failed:" + th.getMessage());
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            try {
                cn.jiguang.bb.f.c("AndroidUtil", "android id is " + str);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return w.h(str) ? str : "";
    }

    public static long a(PackageInfo packageInfo) {
        if (packageInfo == null || !cn.jiguang.g.a.a().e(1034)) {
            return 0L;
        }
        return packageInfo.firstInstallTime;
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        fileInputStream.close();
                        return sb.toString();
                    }
                    for (int i6 = 0; i6 < read; i6++) {
                        byte b6 = bArr[i6];
                        if (b6 == 0) {
                            break;
                        }
                        sb.append((char) b6);
                    }
                }
            } finally {
            }
        } catch (IOException unused) {
            return "";
        }
    }

    public static String i(Context context) {
        Object invoke;
        String str = null;
        int i6 = -1;
        if (context != null) {
            try {
                Object systemService = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", null);
                    if (declaredMethod != null && (invoke = declaredMethod.invoke(systemService, null)) != null) {
                        String str2 = (String) invoke.getClass().getDeclaredMethod("getCountryIso", null).invoke(invoke, null);
                        try {
                            i6 = ((Integer) invoke.getClass().getDeclaredMethod("getSource", null).invoke(invoke, null)).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            cn.jiguang.bb.f.l("AndroidUtil", "getCountryCode failed, error :" + th);
                            cn.jiguang.bb.f.c("AndroidUtil", "get CountCode = " + str + " source = " + i6);
                            if (i6 != 0) {
                            }
                        }
                    }
                } else {
                    cn.jiguang.bb.f.c("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cn.jiguang.bb.f.c("AndroidUtil", "get CountCode = " + str + " source = " + i6);
        return (i6 != 0 || i6 == 1) ? str : "";
    }

    public static String j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i6 = applicationInfo.labelRes;
            if (i6 != 0) {
                return context.getString(i6);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            return charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Exception e6) {
            cn.jiguang.bb.f.a("AndroidUtil", "Error getting application name.", e6);
            return null;
        }
    }

    public String A(final Context context) {
        Object b6 = cn.jiguang.q.d.b(context, PluginError.ERROR_UPD_REQUEST, true, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.7
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.c(context.getResources().getConfiguration().locale.toString());
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.F = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.F;
            }
        });
        if (b6 instanceof String) {
            this.F = (String) b6;
        }
        return this.F;
    }

    public String B(Context context) {
        Object b6 = cn.jiguang.q.d.b(context, PluginError.ERROR_UPD_NO_DOWNLOADER, true, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.8
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.c(Build.MANUFACTURER);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.G = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.G;
            }
        });
        if (b6 instanceof String) {
            this.G = (String) b6;
        }
        return this.G;
    }

    public String C(Context context) {
        Object b6 = cn.jiguang.q.d.b(context, 2014, false, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.9
            /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
                java.util.ConcurrentModificationException
                	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
                	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
                	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
                	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
                	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
                	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
                */
            @Override // cn.jiguang.q.d.b
            public java.lang.Object a() {
                /*
                    r6 = this;
                    java.util.TimeZone r0 = java.util.TimeZone.getDefault()
                    int r0 = r0.getRawOffset()
                    long r0 = (long) r0
                    r2 = 3600000(0x36ee80, double:1.7786363E-317)
                    long r0 = r0 / r2
                    r2 = 0
                    java.lang.String r4 = "-"
                    int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    if (r5 <= 0) goto L27
                    r2.<init>()
                    java.lang.String r3 = "+"
                L1c:
                    r2.append(r3)
                L1f:
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    goto L36
                L27:
                    if (r5 >= 0) goto L30
                    r2.<init>()
                    r2.append(r4)
                    goto L1f
                L30:
                    r2.<init>()
                    java.lang.String r3 = ""
                    goto L1c
                L36:
                    java.lang.String r1 = "--"
                    java.lang.String r0 = r0.replace(r1, r4)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.a.AnonymousClass9.a():java.lang.Object");
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.H = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.H;
            }
        });
        if (b6 instanceof String) {
            this.H = (String) b6;
        }
        return this.H;
    }

    public String D(Context context) {
        Object a6 = cn.jiguang.q.d.a(context, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.bz.a.10
            @Override // cn.jiguang.q.d.b
            public Object a() {
                String format = String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
                if (TextUtils.isEmpty(format)) {
                    return null;
                }
                return format.trim();
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.I = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.I;
            }
        });
        if (a6 instanceof String) {
            this.I = (String) a6;
        }
        return this.I;
    }

    public String E(Context context) {
        try {
            Object a6 = cn.jiguang.q.d.a(context, 1030, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.bz.a.11
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return a.this.f();
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.J = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.J;
                }
            });
            if (a6 instanceof String) {
                this.J = (String) a6;
            }
        } catch (Throwable unused) {
        }
        return this.J;
    }

    @TargetApi(18)
    public String F(Context context) {
        try {
            Object a6 = cn.jiguang.q.d.a(context, 1031, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.bz.a.13
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return a.this.g();
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.K = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.K;
                }
            });
            if (a6 instanceof String) {
                this.K = (String) a6;
            }
        } catch (Throwable unused) {
        }
        return this.K;
    }

    public String G(Context context) {
        try {
            Object a6 = cn.jiguang.q.d.a(context, 1032, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.bz.a.14
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return a.this.h();
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.L = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.L;
                }
            });
            if (a6 instanceof String) {
                this.L = (String) a6;
            }
        } catch (Throwable unused) {
        }
        return this.L;
    }

    @SuppressLint({"MissingPermission"})
    public synchronized String e(final Context context, String str) {
        try {
            Object a6 = cn.jiguang.q.d.a(context, PluginError.ERROR_UPD_CAPACITY, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.bz.a.17
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return a.this.L(context);
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.f2681s = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.f2681s;
                }
            });
            String str2 = a6 instanceof String ? (String) a6 : "";
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }

    public String g() {
        MediaDrm mediaDrm = null;
        try {
            MediaDrm mediaDrm2 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
            try {
                byte[] propertyByteArray = mediaDrm2.getPropertyByteArray("deviceUniqueId");
                MessageDigest messageDigest = MessageDigest.getInstance(v.f2788c);
                messageDigest.update(propertyByteArray);
                String a6 = w.a(messageDigest.digest());
                if (Build.VERSION.SDK_INT >= 28) {
                    mediaDrm2.release();
                    return a6;
                }
                mediaDrm2.release();
                return a6;
            } catch (Exception unused) {
                mediaDrm = mediaDrm2;
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm == null) {
                        return "";
                    }
                    mediaDrm.release();
                    return "";
                }
                if (mediaDrm == null) {
                    return "";
                }
                mediaDrm.release();
                return "";
            } catch (Throwable th) {
                th = th;
                mediaDrm = mediaDrm2;
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } else if (mediaDrm != null) {
                    mediaDrm.release();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String h() {
        return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    public String u(Context context) {
        Object a6 = cn.jiguang.q.d.a(context, 1036, 1800000L, 86400000L, new d.a() { // from class: cn.jiguang.bz.a.3
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return d.a().getResources().getConfiguration().fontScale + "";
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.f2688z = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.f2688z;
            }
        });
        if (a6 instanceof String) {
            this.f2688z = (String) a6;
        }
        return this.f2688z;
    }

    public String v(Context context) {
        Object a6 = cn.jiguang.q.d.a(context, 1007, new d.a() { // from class: cn.jiguang.bz.a.4
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.c(Build.FINGERPRINT);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.A = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.A;
            }
        });
        if (a6 instanceof String) {
            this.A = (String) a6;
        }
        return this.A;
    }

    public String w(Context context) {
        if (!TextUtils.isEmpty(this.B)) {
            return this.B;
        }
        if (cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_NO_DOWNLOADER)) {
            this.B = c(Build.MANUFACTURER);
        }
        return this.B;
    }

    public String x(Context context) {
        if (!TextUtils.isEmpty(this.C)) {
            return this.C;
        }
        if (cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_FILE_NOT_FOUND)) {
            this.C = c(Build.MODEL);
        }
        return this.C;
    }

    public String y(Context context) {
        Object b6 = cn.jiguang.q.d.b(context, PluginError.ERROR_UPD_FILE_NOT_FOUND, true, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.5
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.c(Build.MODEL);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.D = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.D;
            }
        });
        if (b6 instanceof String) {
            this.D = (String) b6;
        }
        return this.D;
    }

    public String z(Context context) {
        Object b6 = cn.jiguang.q.d.b(context, 2002, true, false, (d.b) new d.a() { // from class: cn.jiguang.bz.a.6
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.c(String.format(Locale.ENGLISH, Build.BRAND, new Object[0]));
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.E = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.E;
            }
        });
        if (b6 instanceof String) {
            this.E = (String) b6;
        }
        return this.E;
    }

    private a() {
    }

    public static String H(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), bi.J);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WifiInfo I(Context context) {
        boolean g6 = cn.jiguang.g.a.a().g(1608);
        boolean g7 = cn.jiguang.g.a.a().g(1601);
        cn.jiguang.bb.f.c("AndroidUtil", "getConnectWifiInfo - disableSsid:" + g6 + " disableBssid=" + g7);
        if (!g6 && !g7) {
            if (!k.a("getConnectWifiInfo", a(AVMDLDataLoader.KeyIsIsEncryptVersion))) {
                try {
                    WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                    if (wifiManager != null && q.a(context, com.kuaishou.weapon.p0.g.f36044d)) {
                        this.f2670h = wifiManager.getConnectionInfo();
                        cn.jiguang.bb.f.c("AndroidUtil", "getConnectWifiInfo - wifiInfo:" + this.f2670h.toString());
                    }
                } catch (Throwable unused) {
                }
            }
            return this.f2670h;
        }
        return this.f2670h;
    }

    @SuppressLint({"HardwareIds"})
    private String J(Context context) {
        if (cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD) && cn.jiguang.g.a.a().e(1606)) {
            WifiInfo I = I(context);
            if (I != null && !k.a("getWifiMacAddressInternal", a(1606), 3)) {
                this.f2678p = I.getMacAddress();
                cn.jiguang.bb.f.c("AndroidUtil", "get mac addr by api, value is: " + this.f2678p);
            }
            return this.f2678p;
        }
        return "";
    }

    private static Intent a(PackageManager packageManager, String str) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.INFO");
        intent.setPackage(str);
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            intent.removeCategory("android.intent.category.INFO");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            resolveActivity = packageManager.resolveActivity(intent, 0);
        }
        if (resolveActivity == null) {
            return null;
        }
        Intent intent2 = new Intent(intent);
        intent2.setFlags(268435456);
        ActivityInfo activityInfo = resolveActivity.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(Context context, String str) {
        String r5 = r(context);
        if (!w.i(r5)) {
            r5 = s(context);
        }
        if (w.i(r5)) {
            str = r5;
        }
        cn.jiguang.bb.f.c("AndroidUtil", "getWifiMac:" + str);
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String c(Context context, String str) {
        return "";
    }

    public boolean p(final Context context) {
        Object a6 = cn.jiguang.q.e.a(context, 2500, new e.a() { // from class: cn.jiguang.bz.a.19
            @Override // cn.jiguang.q.e.b
            public Object a() {
                return a.this.f2683u;
            }

            @Override // cn.jiguang.q.e.b
            public void a(Object obj) {
                if (obj instanceof Boolean) {
                    a.this.f2683u = (Boolean) obj;
                }
            }

            @Override // cn.jiguang.q.e.b
            public Object b() {
                return Boolean.valueOf(new cn.jiguang.bu.b(context).a());
            }
        });
        if (a6 instanceof Boolean) {
            return ((Boolean) a6).booleanValue();
        }
        return false;
    }

    public boolean q(final Context context) {
        Object a6 = cn.jiguang.q.e.a(context, 1027, new e.a() { // from class: cn.jiguang.bz.a.20
            @Override // cn.jiguang.q.e.b
            public Object a() {
                return a.this.f2684v;
            }

            @Override // cn.jiguang.q.e.b
            public void a(Object obj) {
                if (obj instanceof Boolean) {
                    a.this.f2684v = (Boolean) obj;
                }
            }

            @Override // cn.jiguang.q.e.b
            public Object b() {
                return Boolean.valueOf(i.a(context).a(false).b(true).c(false).a());
            }
        });
        if (a6 instanceof Boolean) {
            return ((Boolean) a6).booleanValue();
        }
        return false;
    }

    public static Intent a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i6);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        parseUri.setSelector(null);
        return intent;
    }

    public static void f(Context context) {
        try {
            if (f2666d != 0) {
                ((NotificationManager) context.getSystemService("notification")).cancel(f2666d);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("AndroidUtil", "[canclePermanentNotification] failed:" + th.getMessage());
        }
    }

    public static boolean h(Context context) {
        String a6 = w.a("ro.product.brand", "");
        cn.jiguang.bb.f.c("AndroidUtil", "brand = " + a6);
        String a7 = w.a("ro.miui.ui.version.name", "");
        if (TextUtils.isEmpty(a6) || !"Xiaomi".equals(a6) || TextUtils.isEmpty(a7)) {
            return true;
        }
        String a8 = w.a("ro.build.version.incremental", "");
        if (TextUtils.isEmpty(a8) || !a8.startsWith("V7.1")) {
            return true;
        }
        cn.jiguang.bb.f.i("AndroidUtil", "7.1 will not get wifi list");
        return false;
    }

    public String b(final Context context, final String str, boolean z5) {
        Object a6;
        d.a aVar = new d.a() { // from class: cn.jiguang.bz.a.21
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.this.i(context, str);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    String unused = a.f2667e = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.f2667e;
            }
        };
        if (Build.VERSION.SDK_INT <= 28) {
            a6 = cn.jiguang.q.d.a(context, PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD, 1800000L, 864000000L, aVar);
        } else {
            a6 = cn.jiguang.q.d.a(context, PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD, z5, cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD) ? k.a("getWifiMac", a(PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD), 3) : false, aVar);
        }
        if (a6 != null && (a6 instanceof String)) {
            f2667e = (String) a6;
        }
        return f2667e;
    }

    public String c(final Context context, boolean z5) {
        try {
            d.a aVar = new d.a() { // from class: cn.jiguang.bz.a.18
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return a.this.M(context);
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.f2682t = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.f2682t;
                }
            };
            boolean b6 = cn.jiguang.ba.c.b();
            cn.jiguang.bb.f.c("AndroidUtil", "onlyVerifiSDK=" + b6);
            Object a6 = b6 ? cn.jiguang.q.d.a(context, 2000, 259200000L, z5, aVar) : cn.jiguang.q.d.a(context, 2000, 1800000L, 259200000L, aVar);
            return a6 instanceof String ? (String) a6 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i6;
        PackageInfo a6;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.bb.f.i("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            i6 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            a6 = p.a(context, str, i6);
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("AndroidUtil", "hasComponent error:" + th);
        }
        if (a6 == null) {
            return null;
        }
        ComponentInfo[] componentInfoArr = i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 8 ? null : a6.providers : a6.services : a6.receivers : a6.activities;
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static boolean d() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    public static boolean e(Context context) {
        String str;
        try {
            cn.jiguang.bb.f.c("AndroidUtil", "isDebug:" + ((context.getApplicationInfo().flags & 2) != 0));
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            PackageInfo a6 = p.a(context, 64);
            if (a6 == null) {
                return false;
            }
            Signature[] signatureArr = a6.signatures;
            CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f33254b);
            boolean z5 = false;
            for (Signature signature : signatureArr) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    z5 = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                    cn.jiguang.bb.f.c("AndroidUtil", "debuggable :" + z5);
                    if (z5) {
                        break;
                    }
                    try {
                        str = x509Certificate.getSubjectX500Principal().getName();
                    } catch (Exception unused) {
                        str = null;
                    }
                    cn.jiguang.bb.f.c("AndroidUtil", "certName:" + str);
                    if (str != null && str.contains(strArr[0]) && str.contains(strArr[1]) && str.contains(strArr[2])) {
                        return true;
                    }
                } catch (Throwable unused2) {
                }
            }
            return z5;
        } catch (Throwable unused3) {
            return false;
        }
    }

    public static boolean f(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null) {
                    if (packageManager.resolveActivity(launchIntentForPackage, 65536) != null) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean h(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.checkPermission(com.kuaishou.weapon.p0.g.f36041a, str) == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            if (packageManager.getApplicationInfo(str, 0) != null) {
                return true;
            }
        } catch (Throwable unused2) {
        }
        return a(packageManager, str) != null;
    }

    public synchronized String b(final Context context, boolean z5) {
        if (!cn.jiguang.g.a.a().e(1600)) {
            return "";
        }
        Object a6 = cn.jiguang.q.d.a(context, 1601, z5, cn.jiguang.g.a.a().e(1601) ? k.a("getWifiBssid", a(1601), 3) : false, new d.a() { // from class: cn.jiguang.bz.a.15
            @Override // cn.jiguang.q.d.b
            public Object a() {
                WifiInfo I = a.this.I(context);
                if (I != null) {
                    a.this.f2675m = I.getBSSID();
                    if (a.this.f2675m == null || a.this.f2675m.startsWith("02:00:00:")) {
                        a.this.f2675m = "";
                    }
                    cn.jiguang.bb.f.c("AndroidUtil", "get bssid by api, value is: " + a.this.f2675m);
                }
                return a.this.f2675m;
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.f2675m = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.f2675m;
            }
        });
        if (a6 instanceof String) {
            this.f2675m = (String) a6;
        }
        return this.f2675m;
    }

    public static ProviderInfo a(Context context, String str, String str2) {
        ProviderInfo[] providerInfoArr;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PackageInfo a6 = p.a(context, str, 8);
                if (a6 != null && (providerInfoArr = a6.providers) != null && providerInfoArr.length != 0) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean d(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (w.a(str)) {
            cn.jiguang.bb.f.l("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        cn.jiguang.bb.f.c("AndroidUtil", "Current pk installed path: " + str);
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
            return false;
        }
        cn.jiguang.bb.f.f("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }

    public static a a() {
        if (f2664b == null) {
            synchronized (a.class) {
                try {
                    if (f2664b == null) {
                        f2664b = new a();
                    }
                } finally {
                }
            }
        }
        return f2664b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    public static String g(Context context) {
        String l6 = l(context);
        if (TextUtils.isEmpty(l6)) {
            return l6;
        }
        return l6 + "/data/";
    }

    private static File a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return !parentFile.getName().equals("0") ? a(parentFile) : parentFile;
        }
        return null;
    }

    private static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str2 = activityInfo.name;
                    if (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0)) {
                        arrayList.add(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static synchronized void b() {
        synchronized (a.class) {
            f2664b = null;
            a();
        }
    }

    public static boolean g(Context context, String str) {
        PackageManager packageManager;
        String[] split;
        try {
            packageManager = context.getPackageManager();
            split = str.split("\\|");
        } catch (Throwable unused) {
        }
        if (split.length <= 1) {
            return false;
        }
        Intent b6 = b(split[1]);
        b6.setPackage(split[0]);
        return packageManager.resolveActivity(b6, 0) != null;
    }

    public static String a(Context context) {
        String b6;
        String processName;
        if (!TextUtils.isEmpty(f2663a)) {
            return f2663a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f2663a = processName;
                if (!TextUtils.isEmpty(processName)) {
                    return f2663a;
                }
            }
            b6 = t.b();
            f2663a = b6;
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(b6)) {
            f2663a = c();
            return f2663a;
        }
        return f2663a;
    }

    public static void b(Context context, Intent intent) {
        try {
            List<String> b6 = b(context, intent, (String) null);
            if (b6 == null || b6.isEmpty()) {
                cn.jiguang.bb.f.j("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str : b6) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str));
                    context.sendBroadcast(intent2);
                } catch (Exception e6) {
                    cn.jiguang.bb.f.j("AndroidUtil", "sendBroadcast failed again:" + e6.getMessage() + ", action:" + intent.getAction());
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("AndroidUtil", "tryAgainSendBrocast failed:" + th.getMessage());
        }
    }

    public static String a(Context context, Intent intent, String str) {
        try {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (serviceInfo == null) {
                return "";
            }
            String str2 = serviceInfo.name;
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            if (!TextUtils.isEmpty(str)) {
                if (packageManager.checkPermission(str, resolveService.activityInfo.packageName) != 0) {
                    return "";
                }
            }
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(Context context, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("data", str2);
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            cn.jiguang.bb.f.c("AndroidUtil", "send config  intent=" + intent);
            context.sendBroadcast(intent, context.getPackageName() + cn.jiguang.a.a.f1443a);
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        if (f2665c == null) {
            f2665c = Boolean.valueOf(context.getPackageName().equals(a(context)));
        }
        return f2665c.booleanValue();
    }

    public synchronized String a(final Context context, String str, final boolean z5) {
        try {
            Object a6 = cn.jiguang.q.d.a(context, PluginError.ERROR_UPD_EXTRACT, 1800000L, 864000000L, new d.a() { // from class: cn.jiguang.bz.a.16
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return z5 ? a.this.K(context) : "";
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        a.this.f2680r = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.this.f2680r;
                }
            });
            String str2 = a6 instanceof String ? (String) a6 : "";
            if (w.h(str2)) {
                str = str2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }

    public synchronized String a(final Context context, boolean z5) {
        if (!cn.jiguang.g.a.a().e(1600)) {
            cn.jiguang.bb.f.c("AndroidUtil", "getWifiSsid, not can get ssid");
            return "";
        }
        Object a6 = cn.jiguang.q.d.a(context, 1608, z5, cn.jiguang.g.a.a().e(1608) ? k.a("getWifiSsid", a(1608), 3) : false, new d.a() { // from class: cn.jiguang.bz.a.12
            @Override // cn.jiguang.q.d.b
            public Object a() {
                WifiInfo I = a.this.I(context);
                if (I != null) {
                    a.this.f2673k = I.getSSID();
                    cn.jiguang.bb.f.c("AndroidUtil", "get ssid by api, value is: " + a.this.f2673k);
                }
                return a.this.f2673k;
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    a.this.f2673k = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.a, cn.jiguang.q.d.b
            public void b(Object obj) {
                if (obj instanceof String) {
                    a.this.f2674l = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.this.f2673k;
            }
        });
        if (a6 instanceof String) {
            this.f2673k = (String) a6;
        }
        cn.jiguang.bb.f.c("AndroidUtil", "lastCacheWifiSSID=" + this.f2674l + " wifiSSID=" + this.f2673k + " isFromNetwork=" + z5);
        if (!TextUtils.isEmpty(this.f2674l) && !TextUtils.isEmpty(this.f2673k) && !TextUtils.equals(this.f2673k, this.f2674l) && Build.VERSION.SDK_INT >= 29 && z5) {
            cn.jiguang.bb.f.c("AndroidUtil", "ssid change,so update mac");
            b(context, "", true);
        }
        return this.f2673k;
    }

    public static String a(ApplicationInfo applicationInfo) {
        return (applicationInfo == null || !cn.jiguang.g.a.a().e(1033)) ? "" : applicationInfo.sourceDir;
    }

    public String a(boolean z5) {
        boolean e6;
        String a6;
        try {
            e6 = cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsGetChecksumInfo);
        } catch (Throwable unused) {
        }
        if (z5 || e6) {
            if (!k.a("getIpv6FromMethod", a(2800), 1)) {
                boolean b6 = o.b();
                boolean a7 = o.a();
                if (b6 || a7) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                        String lowerCase = networkInterface.getName().toLowerCase();
                        if ((b6 && (lowerCase.contains("rmnet") || lowerCase.contains("ccmni"))) || (a7 && lowerCase.contains("wlan0"))) {
                            List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
                            ArrayList arrayList3 = new ArrayList();
                            Iterator<InterfaceAddress> it = interfaceAddresses.iterator();
                            boolean z6 = false;
                            while (it.hasNext()) {
                                InetAddress address = it.next().getAddress();
                                if (!address.isLoopbackAddress()) {
                                    if (address instanceof Inet6Address) {
                                        arrayList3.add(address.getHostAddress());
                                    } else if (address instanceof Inet4Address) {
                                        z6 = true;
                                    }
                                }
                            }
                            if (z6) {
                                if (b6) {
                                    arrayList.addAll(arrayList3);
                                }
                                if (a7) {
                                    arrayList2.addAll(arrayList3);
                                }
                            }
                        }
                    }
                    if (b6 && !arrayList.isEmpty()) {
                        a6 = androidx.camera.core.processing.j0.a(ContainerUtils.FIELD_DELIMITER, arrayList);
                    } else if (a7 && !arrayList2.isEmpty()) {
                        a6 = androidx.camera.core.processing.j0.a(ContainerUtils.FIELD_DELIMITER, arrayList2);
                    }
                    this.f2685w = a6;
                }
            }
            return this.f2685w;
        }
        return this.f2685w;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("AndroidUtil", "send broadcast failed: " + th.getMessage());
            b(context, intent);
        }
    }

    public static void a(Context context, String str, int i6) {
        int i7;
        NotificationChannel notificationChannel;
        if (!e(context)) {
            cn.jiguang.bb.f.c("AndroidUtil", "not debuggable");
            return;
        }
        cn.jiguang.bb.f.c("AndroidUtil", "action:showPermanentNotification");
        Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
        intent.setAction("noti_open_proxy");
        intent.addCategory(context.getPackageName());
        intent.putExtra("debug_notification", true);
        intent.putExtra("toastText", str);
        intent.putExtra("type", i6);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        try {
            i7 = context.getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), 0).icon;
        } catch (Throwable th) {
            cn.jiguang.bb.f.e("AndroidUtil", "failed to get application info and icon.", th);
            i7 = R.drawable.ic_menu_share;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i8 = Build.VERSION.SDK_INT;
        Notification.Builder when = new Notification.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext())).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(broadcast).setSmallIcon(i7).setTicker(str).setWhen(currentTimeMillis);
        if (i8 >= 26) {
            notificationChannel = notificationManager.getNotificationChannel("JPush_Notification");
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(c0.a("JPush_Notification", "JPush_Notification", 3));
            }
            when.setChannelId("JPush_Notification");
        }
        Notification notification = when.getNotification();
        notification.flags = 34;
        f2666d = 10000;
        notificationManager.notify(10000, notification);
    }
}
