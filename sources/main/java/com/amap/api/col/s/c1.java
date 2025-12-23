package com.amap.api.col.s;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c1 {
    private static String A = "";
    private static String B = "";
    private static boolean C = false;
    static int D = -1;
    static String E = "";
    private static boolean F = false;
    static String G = "";
    private static String H = "";
    private static boolean I = false;
    private static boolean J = false;
    private static long K = 0;
    private static int L = 0;
    private static String M = null;
    private static String N = "";
    private static boolean O = true;
    private static boolean P = false;
    private static String Q = "";
    private static boolean R = false;
    private static int S = -1;
    private static boolean T = false;
    private static int U = -1;
    private static boolean V = false;
    private static volatile d W = null;

    /* renamed from: a, reason: collision with root package name */
    static String f7894a = "";

    /* renamed from: b, reason: collision with root package name */
    static String f7895b = "";

    /* renamed from: c, reason: collision with root package name */
    static volatile boolean f7896c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f7897d = false;

    /* renamed from: e, reason: collision with root package name */
    static String f7898e = "";

    /* renamed from: f, reason: collision with root package name */
    static boolean f7899f = false;

    /* renamed from: g, reason: collision with root package name */
    private static String f7900g = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f7901h = false;

    /* renamed from: i, reason: collision with root package name */
    private static String f7902i = "";

    /* renamed from: j, reason: collision with root package name */
    public static c f7903j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f7904k = false;

    /* renamed from: l, reason: collision with root package name */
    private static String f7905l = "";

    /* renamed from: m, reason: collision with root package name */
    private static boolean f7906m = false;

    /* renamed from: n, reason: collision with root package name */
    private static String f7907n = null;

    /* renamed from: o, reason: collision with root package name */
    private static IBinder f7908o = null;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f7909p = false;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f7910q = false;

    /* renamed from: r, reason: collision with root package name */
    private static String f7911r = "";

    /* renamed from: s, reason: collision with root package name */
    private static String f7912s = "";

    /* renamed from: t, reason: collision with root package name */
    private static boolean f7913t = false;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f7914u = false;

    /* renamed from: v, reason: collision with root package name */
    private static String f7915v = "";

    /* renamed from: w, reason: collision with root package name */
    private static boolean f7916w = false;

    /* renamed from: x, reason: collision with root package name */
    private static String f7917x = "";

    /* renamed from: y, reason: collision with root package name */
    private static boolean f7918y = false;

    /* renamed from: z, reason: collision with root package name */
    private static String f7919z = "";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7920b;

        a(Context context) {
            this.f7920b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                Map<String, String> b6 = c1.f7903j.b();
                String b7 = c1.f7903j.b(c1.y(this.f7920b), "", "", c1.M());
                if (TextUtils.isEmpty(b7)) {
                    return;
                }
                u2.b();
                String a6 = c1.f7903j.a(this.f7920b, new String(u2.d(c1.f7903j.a(b7.getBytes(), b6)).f7876a));
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
                c1.f7895b = a6;
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7921b;

        b(Context context) {
            this.f7921b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            c1.Z(this.f7921b);
            c1.U();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        dz a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String b(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static Context f7922a;

        /* renamed from: b, reason: collision with root package name */
        private static BroadcastReceiver f7923b;

        /* renamed from: c, reason: collision with root package name */
        private static ConnectivityManager f7924c;

        /* renamed from: d, reason: collision with root package name */
        private static NetworkRequest f7925d;

        /* renamed from: e, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f7926e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (j1.t("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    c1.S();
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b extends ConnectivityManager.NetworkCallback {
            b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                c1.S();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                c1.S();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f7923b != null) {
                    return;
                }
                f7923b = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(j1.t("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f7923b, intentFilter);
                return;
            }
            if (c1.q(context, j1.t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f7924c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f7924c = connectivityManager;
                if (connectivityManager != null) {
                    f7925d = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    b bVar = new b();
                    f7926e = bVar;
                    f7924c.registerNetworkCallback(f7925d, bVar);
                    f7922a = context;
                }
            }
        }
    }

    public static void S() {
        S = -1;
        T = false;
        U = -1;
        V = false;
        Q = "";
        R = false;
        f7917x = "";
        f7918y = false;
    }

    static /* synthetic */ boolean U() {
        f7909p = true;
        return true;
    }

    private static String V(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (j1.l(context, com.kuaishou.weapon.p0.g.f36049i) && "mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z5 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z5 = false;
                            } else if (eventType == 4 && z5) {
                                String text = newPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable unused) {
                                }
                                return text;
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i6 = 0; i6 < attributeCount; i6++) {
                                String attributeValue = newPullParser.getAttributeValue(i6);
                                if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                    z5 = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                    return "";
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String X(Context context) {
        try {
            Class<?> cls = Class.forName(j1.t("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(j1.t("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f7905l = str;
                return str;
            }
        } catch (Throwable th) {
            d2.e(th, "oa", "xm");
            f7906m = true;
        }
        return f7905l;
    }

    private static String f(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(j1.t("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(j1.t("MZ2V0Vm9sdW1lTGlzdA"), null);
            Method method2 = cls.getMethod(j1.t("FZ2V0UGF0aA"), null);
            Method method3 = cls.getMethod(j1.t("DaXNSZW1vdmFibGU"), null);
            Object invoke = method.invoke(storageManager, null);
            int length = Array.getLength(invoke);
            for (int i6 = 0; i6 < length; i6++) {
                Object obj = Array.get(invoke, i6);
                String str = (String) method2.invoke(obj, null);
                if (!((Boolean) method3.invoke(obj, null)).booleanValue()) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Finally extract failed */
    private static String k(Context context, int i6) {
        try {
            Intent intent = new Intent();
            if (i6 == 2) {
                intent.setAction(j1.t("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(j1.t("UY29tLmh1YXdlaS5od2lk"));
            } else if (i6 == 4) {
                intent.setClassName(j1.t("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), j1.t("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i6 != 5) {
                    f7906m = true;
                    return f7905l;
                }
                intent.setClassName(j1.t("YY29tLmhleXRhcC5vcGVuaWQ"), j1.t("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(j1.t("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            e eVar = new e();
            if (context.bindService(intent, eVar, 1)) {
                int i7 = 0;
                while (i7 < 100 && TextUtils.isEmpty(f7905l)) {
                    i7++;
                    if (f7908o != null) {
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        if (i6 == 2) {
                            obtain.writeInterfaceToken(j1.t("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                        } else if (i6 != 4) {
                            if (i6 == 5) {
                                try {
                                    obtain.writeInterfaceToken(j1.t("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                                    obtain.writeString(context.getPackageName());
                                    obtain.writeString(W(context));
                                    obtain.writeString(j1.t("IT1VJRA"));
                                } catch (Throwable th) {
                                    try {
                                        d2.e(th, "oac", String.valueOf(i6));
                                    } catch (Throwable th2) {
                                        obtain2.recycle();
                                        obtain.recycle();
                                        throw th2;
                                    }
                                }
                            }
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            obtain.writeInterfaceToken(j1.t("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                        }
                        f7908o.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        f7905l = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                    Thread.sleep(15L);
                }
                context.unbindService(eVar);
                f7908o = null;
            }
            return f7905l;
        } catch (Throwable th3) {
            d2.e(th3, "oa", String.valueOf(i6));
            f7906m = true;
            return f7905l;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = c1.f7908o = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    static String A(Context context) {
        TelephonyManager b6;
        if (f7918y) {
            return f7917x;
        }
        try {
            g(context);
            b6 = b(context);
        } catch (Throwable unused) {
        }
        if (b6 == null) {
            return f7917x;
        }
        String networkOperator = b6.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f7917x = networkOperator.substring(3);
            f7918y = true;
            return f7917x;
        }
        f7918y = true;
        return f7917x;
    }

    public static String C() {
        return f7915v;
    }

    static String[] E() {
        return new String[]{"", ""};
    }

    public static String F() {
        return E;
    }

    static String G(Context context) {
        String str;
        String str2;
        try {
            str = f7919z;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f7919z;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i6 = displayMetrics.widthPixels;
        int i7 = displayMetrics.heightPixels;
        if (i7 > i6) {
            str2 = i6 + "*" + i7;
        } else {
            str2 = i7 + "*" + i6;
        }
        f7919z = str2;
        return f7919z;
    }

    public static String H() {
        return A;
    }

    public static String I(Context context) {
        ConnectivityManager d02;
        NetworkInfo activeNetworkInfo;
        try {
            return (!q(context, j1.t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (d02 = d0(context)) == null || (activeNetworkInfo = d02.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String J() {
        return "";
    }

    public static int L(Context context) {
        int i6 = L;
        if (i6 != 0) {
            return i6;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i7 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        L = i7;
        return i7;
    }

    public static String M() {
        return "";
    }

    public static long N() {
        long j6 = K;
        if (j6 != 0) {
            return j6;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            K = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } catch (Throwable unused) {
        }
        return K;
    }

    public static String P() {
        if (!TextUtils.isEmpty(M)) {
            return M;
        }
        String property = System.getProperty("os.arch");
        M = property;
        return property;
    }

    public static String Q(Context context) {
        try {
            if (TextUtils.isEmpty(f7902i)) {
                f7902i = q1.a(context);
            }
        } catch (Throwable unused) {
        }
        return f7902i;
    }

    private static String T(Context context) {
        try {
            String o5 = j2.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(o5) ? j2.o(context, "Alvin2", "UTDID", "") : o5;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String W(Context context) {
        try {
            if (!TextUtils.isEmpty(f7907n)) {
                return f7907n;
            }
            byte[] digest = MessageDigest.getInstance(j1.t("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                stringBuffer.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f7907n = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Z(Context context) {
        String t5 = j1.t("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!t5.equalsIgnoreCase(str)) {
            String t6 = j1.t("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!t6.equalsIgnoreCase(str2) && !j1.t("IUkVETUk=").equalsIgnoreCase(str) && !j1.t("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (j1.t("Idml2bw").equalsIgnoreCase(str) || j1.t("Idml2bw").equalsIgnoreCase(str2)) {
                    return Y(context);
                }
                if (j1.t("IaHVhd2Vp").equalsIgnoreCase(str) || j1.t("IaHVhd2Vp").equalsIgnoreCase(str2) || j1.t("ISE9OT1I=").equalsIgnoreCase(str)) {
                    return k(context, 2);
                }
                if (j1.t("Mc2Ftc3VuZw").equalsIgnoreCase(str) || j1.t("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                    return k(context, 4);
                }
                if (j1.t("IT1BQTw").equalsIgnoreCase(str) || j1.t("IT1BQTw").equalsIgnoreCase(str2) || j1.t("MT25lUGx1cw").equalsIgnoreCase(str) || j1.t("MT25lUGx1cw").equalsIgnoreCase(str2) || j1.t("IUkVBTE1F").equalsIgnoreCase(str2)) {
                    return k(context, 5);
                }
                f7906m = true;
                return f7905l;
            }
        }
        return X(context);
    }

    private static int a(Context context) {
        if (V) {
            return U;
        }
        g(context);
        if (!q(context, j1.t("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return U;
        }
        TelephonyManager b6 = b(context);
        if (b6 == null) {
            return U;
        }
        int networkType = b6.getNetworkType();
        U = networkType;
        V = true;
        return networkType;
    }

    private static String a0(Context context) {
        if (!TextUtils.isEmpty(H)) {
            return H;
        }
        try {
            String o5 = j2.o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(o5)) {
                H = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor c6 = j2.c(context, "open_common");
                j2.j(c6, "a1", j1.q(H));
                j2.f(c6);
            } else {
                H = j1.t(o5);
            }
            return H;
        } catch (Throwable unused) {
            return H;
        }
    }

    private static TelephonyManager b(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String b0(Context context) {
        if (R) {
            return Q;
        }
        g(context);
        if (!q(context, j1.t("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return Q;
        }
        TelephonyManager b6 = b(context);
        if (b6 == null) {
            return Q;
        }
        String simOperatorName = b6.getSimOperatorName();
        Q = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            Q = b6.getNetworkOperatorName();
        }
        R = true;
        return Q;
    }

    private static String c(Context context) {
        String str;
        if (!f7896c) {
            return "";
        }
        try {
            str = d(context);
        } catch (Throwable unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            f7896c = false;
            return "";
        }
        try {
            byte[] bytes = j1.t("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(d1.e(j1.t("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), d1.g(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            f7896c = false;
            return "";
        }
    }

    private static int c0(Context context) {
        if (T) {
            return S;
        }
        g(context);
        if (context == null || !q(context, j1.t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return S;
        }
        ConnectivityManager d02 = d0(context);
        if (d02 == null) {
            return S;
        }
        NetworkInfo activeNetworkInfo = d02.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            T = true;
            return S;
        }
        int type = activeNetworkInfo.getType();
        S = type;
        T = true;
        return type;
    }

    private static String d(Context context) {
        String str;
        try {
            str = e(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(j1.t("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(g1.a(j1.t("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static ConnectivityManager d0(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String e(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (!q(context, j1.t("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String a6 = g1.a(j1.t("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String f6 = f(context);
        if (TextUtils.isEmpty(f6)) {
            return "";
        }
        File file = new File(f6 + File.separator + j1.t("KYmFja3Vwcw"), j1.t("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, com.kuaishou.weapon.p0.t.f36150k);
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            m(byteArrayOutputStream2);
                            m(randomAccessFile);
                            return "";
                        }
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
            }
            if (!TextUtils.isEmpty(str) && str.contains(j1.t("SIw")) && (split = str.split(j1.t("SIw"))) != null && split.length == 2 && TextUtils.equals(a6, split[0])) {
                String str2 = split[1];
                m(byteArrayOutputStream);
                m(randomAccessFile);
                return str2;
            }
            m(byteArrayOutputStream);
            m(randomAccessFile);
        }
        return "";
    }

    private static synchronized d g(Context context) {
        synchronized (c1.class) {
            try {
                if (W == null) {
                    if (context == null) {
                        return null;
                    }
                    d dVar = new d();
                    W = dVar;
                    dVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                return W;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String i() {
        return f7900g;
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(f7895b)) {
            return f7895b;
        }
        if (context == null) {
            return "";
        }
        String c6 = c(context);
        f7895b = c6;
        if (!TextUtils.isEmpty(c6)) {
            return f7895b;
        }
        if (s() == null || f7904k) {
            return "";
        }
        f7904k = true;
        y3.e().c(new a(context));
        return "";
    }

    public static void l(c cVar) {
        if (f7903j == null) {
            f7903j = cVar;
        }
    }

    private static void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String o() {
        try {
            if (!TextUtils.isEmpty(f7898e)) {
                return f7898e;
            }
            c cVar = f7903j;
            return cVar == null ? "" : cVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static c s() {
        return f7903j;
    }

    public static String u() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String M2 = M();
            return M2.length() < 5 ? "" : M2.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String v() {
        return "";
    }

    public static String w(Context context) {
        if (f7906m) {
            return "";
        }
        if (!TextUtils.isEmpty(f7905l)) {
            return f7905l;
        }
        if (f7909p) {
            return f7905l;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            y3.e().c(new b(context));
            return f7905l;
        }
        f7909p = true;
        return Z(context);
    }

    public static String x() {
        return "";
    }

    public static String y(Context context) {
        String str;
        if (f7910q) {
            String str2 = f7894a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f7894a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f7894a;
        }
        if (q(context, j1.t("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f7894a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f7894a)) {
            f7910q = true;
            return f7894a;
        }
        try {
            String T2 = T(context);
            f7894a = T2;
            if (!TextUtils.isEmpty(T2)) {
                f7910q = true;
                return f7894a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f7894a = V(context);
            f7910q = true;
        } catch (Throwable unused3) {
        }
        String str3 = f7894a;
        return str3 == null ? "" : str3;
    }

    public static String z() {
        return "";
    }

    public static int B(Context context) {
        try {
            return a(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int D(Context context) {
        try {
            return c0(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String K(Context context) {
        try {
            String H2 = H();
            try {
                if (TextUtils.isEmpty(H2)) {
                    H2 = j(context);
                }
                if (TextUtils.isEmpty(H2)) {
                    H2 = y(context);
                }
                if (TextUtils.isEmpty(H2)) {
                    H2 = w(context);
                }
                if (TextUtils.isEmpty(H2)) {
                    H2 = z();
                }
                if (TextUtils.isEmpty(H2)) {
                    return a0(context);
                }
                return H2;
            } catch (Throwable unused) {
                return H2;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    static String O(Context context) {
        try {
            return b0(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String Y(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(j1.t("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= columnCount) {
                            break;
                        }
                        if (j1.t("IdmFsdWU").equals(query.getColumnName(i6))) {
                            f7905l = query.getString(i6);
                            break;
                        }
                        i6++;
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f7906m = true;
            d2.e(th, "oa", "vivo");
        }
        return f7905l;
    }

    public static String p(Context context) {
        try {
            return b0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int r(Context context) {
        try {
            return a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int t(Context context) {
        try {
            return c0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
