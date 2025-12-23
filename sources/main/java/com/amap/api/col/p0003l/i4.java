package com.amap.api.col.p0003l;

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
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i4 {
    private static String A = "";
    private static String B = "";
    private static String C = "";
    private static boolean D = false;
    static int E = -1;
    static String F = "";
    private static boolean G = false;
    static String H = "";
    private static String I = "";
    private static boolean J = false;
    private static boolean K = false;
    private static long L = 0;
    private static int M = 0;
    private static String N = null;
    private static String O = "";
    private static boolean P = true;
    private static boolean Q = false;
    private static String R = "";
    private static boolean S = false;
    private static int T = -1;
    private static boolean U = false;
    private static int V = -1;
    private static boolean W = false;
    private static volatile d X = null;

    /* renamed from: a, reason: collision with root package name */
    static String f6464a = "";

    /* renamed from: b, reason: collision with root package name */
    static String f6465b = "";

    /* renamed from: c, reason: collision with root package name */
    static volatile boolean f6466c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f6467d = false;

    /* renamed from: e, reason: collision with root package name */
    static String f6468e = "";

    /* renamed from: f, reason: collision with root package name */
    static boolean f6469f = false;

    /* renamed from: g, reason: collision with root package name */
    private static String f6470g = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f6471h = false;

    /* renamed from: i, reason: collision with root package name */
    private static String f6472i = "";

    /* renamed from: j, reason: collision with root package name */
    public static c f6473j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f6474k = false;

    /* renamed from: l, reason: collision with root package name */
    private static String f6475l = "";

    /* renamed from: m, reason: collision with root package name */
    private static boolean f6476m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f6477n = true;

    /* renamed from: o, reason: collision with root package name */
    private static String f6478o = null;

    /* renamed from: p, reason: collision with root package name */
    private static IBinder f6479p = null;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f6480q = false;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f6481r = false;

    /* renamed from: s, reason: collision with root package name */
    private static String f6482s = "";

    /* renamed from: t, reason: collision with root package name */
    private static String f6483t = "";

    /* renamed from: u, reason: collision with root package name */
    private static boolean f6484u = false;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f6485v = false;

    /* renamed from: w, reason: collision with root package name */
    private static String f6486w = "";

    /* renamed from: x, reason: collision with root package name */
    private static boolean f6487x = false;

    /* renamed from: y, reason: collision with root package name */
    private static String f6488y = "";

    /* renamed from: z, reason: collision with root package name */
    private static boolean f6489z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f6490d;

        a(Context context) {
            this.f6490d = context;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                Map<String, String> b6 = i4.f6473j.b();
                String b7 = i4.f6473j.b(i4.F(this.f6490d), "", "", i4.U());
                if (TextUtils.isEmpty(b7)) {
                    return;
                }
                r6.b();
                String a6 = i4.f6473j.a(this.f6490d, new String(r6.d(i4.f6473j.a(b7.getBytes(), b6)).f7800a));
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
                i4.f6465b = a6;
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f6491d;

        b(Context context) {
            this.f6491d = context;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            i4.a(this.f6491d);
            i4.d0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        Cif a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String b(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static Context f6492a;

        /* renamed from: b, reason: collision with root package name */
        private static BroadcastReceiver f6493b;

        /* renamed from: c, reason: collision with root package name */
        private static ConnectivityManager f6494c;

        /* renamed from: d, reason: collision with root package name */
        private static NetworkRequest f6495d;

        /* renamed from: e, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f6496e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (q4.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    i4.b0();
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
                i4.b0();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                i4.b0();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f6493b != null) {
                    return;
                }
                f6493b = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(q4.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f6493b, intentFilter);
                return;
            }
            if (i4.x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f6494c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f6494c = connectivityManager;
                if (connectivityManager != null) {
                    f6495d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    b bVar = new b();
                    f6496e = bVar;
                    f6494c.registerNetworkCallback(f6495d, bVar);
                    f6492a = context;
                }
            }
        }
    }

    static String Q(Context context) {
        try {
            NetworkInfo O2 = O(context);
            if (O2 == null) {
                return null;
            }
            return O2.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b0() {
        T = -1;
        U = false;
        V = -1;
        W = false;
        R = "";
        S = false;
        f6488y = "";
        f6489z = false;
    }

    static /* synthetic */ boolean d0() {
        f6480q = true;
        return true;
    }

    private static String i0(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (q4.l(context, g.f36049i) && "mounted".equals(Environment.getExternalStorageState())) {
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

    private static String k0(Context context) {
        try {
            Class<?> cls = Class.forName(q4.u("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(q4.u("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f6475l = str;
                return str;
            }
        } catch (Throwable th) {
            r5.e(th, "oa", "xm");
            f6476m = true;
        }
        return f6475l;
    }

    /* JADX WARN: Finally extract failed */
    private static String p(Context context, int i6) {
        try {
            Intent intent = new Intent();
            if (i6 == 2) {
                intent.setAction(q4.u("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(q4.u("UY29tLmh1YXdlaS5od2lk"));
            } else if (i6 == 4) {
                intent.setClassName(q4.u("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), q4.u("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i6 != 5) {
                    f6476m = true;
                    return f6475l;
                }
                intent.setClassName(q4.u("YY29tLmhleXRhcC5vcGVuaWQ"), q4.u("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(q4.u("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            e eVar = new e();
            if (context.bindService(intent, eVar, 1)) {
                int i7 = 0;
                while (i7 < 100 && TextUtils.isEmpty(f6475l)) {
                    i7++;
                    if (f6479p != null) {
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        if (i6 == 2) {
                            obtain.writeInterfaceToken(q4.u("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                        } else if (i6 != 4) {
                            if (i6 == 5) {
                                try {
                                    obtain.writeInterfaceToken(q4.u("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                                    obtain.writeString(context.getPackageName());
                                    obtain.writeString(j0(context));
                                    obtain.writeString(q4.u("IT1VJRA"));
                                } catch (Throwable th) {
                                    try {
                                        r5.e(th, "oac", String.valueOf(i6));
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
                            obtain.writeInterfaceToken(q4.u("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                        }
                        f6479p.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        f6475l = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                    Thread.sleep(15L);
                }
                context.unbindService(eVar);
                f6479p = null;
            }
            return f6475l;
        } catch (Throwable th3) {
            r5.e(th3, "oa", String.valueOf(i6));
            f6476m = true;
            return f6475l;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = i4.f6479p = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String B() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String U2 = U();
            return U2.length() < 5 ? "" : U2.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String C() {
        return "";
    }

    public static String D(Context context) {
        if (!f6477n || f6476m) {
            return "";
        }
        if (!TextUtils.isEmpty(f6475l)) {
            return f6475l;
        }
        if (f6480q) {
            return f6475l;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a8.h().b(new b(context));
            return f6475l;
        }
        f6480q = true;
        return a(context);
    }

    public static String E() {
        return "";
    }

    public static String F(Context context) {
        String str;
        if (f6481r) {
            String str2 = f6464a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f6464a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f6464a;
        }
        if (x(context, q4.u("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f6464a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f6464a)) {
            f6481r = true;
            return f6464a;
        }
        try {
            String h02 = h0(context);
            f6464a = h02;
            if (!TextUtils.isEmpty(h02)) {
                f6481r = true;
                return f6464a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f6464a = i0(context);
            f6481r = true;
        } catch (Throwable unused3) {
        }
        String str3 = f6464a;
        return str3 == null ? "" : str3;
    }

    public static String G() {
        return "";
    }

    static String H(Context context) {
        TelephonyManager g6;
        try {
            g6 = g(context);
        } catch (Throwable unused) {
        }
        if (g6 == null) {
            return "";
        }
        String networkOperator = g6.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            return networkOperator.substring(0, 3);
        }
        return "";
    }

    public static String I() {
        return f6486w;
    }

    static String J(Context context) {
        TelephonyManager g6;
        if (f6489z) {
            return f6488y;
        }
        try {
            l(context);
            g6 = g(context);
        } catch (Throwable unused) {
        }
        if (g6 == null) {
            return f6488y;
        }
        String networkOperator = g6.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f6488y = networkOperator.substring(3);
            f6489z = true;
            return f6488y;
        }
        f6489z = true;
        return f6488y;
    }

    static String[] L() {
        return new String[]{"", ""};
    }

    public static String N() {
        return F;
    }

    public static NetworkInfo O(Context context) {
        ConnectivityManager e6;
        if (x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (e6 = e(context)) != null) {
            return e6.getActiveNetworkInfo();
        }
        return null;
    }

    public static String P() {
        return B;
    }

    public static String S() {
        return "";
    }

    static String T(Context context) {
        String str;
        String str2;
        try {
            str = A;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return A;
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
        A = str2;
        return A;
    }

    public static String U() {
        return "";
    }

    public static String V(Context context) {
        try {
            if (!x(context, q4.u("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O;
            }
            TelephonyManager g6 = g(context);
            return g6 == null ? "" : g6.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long W() {
        long j6 = L;
        if (j6 != 0) {
            return j6;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            L = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } catch (Throwable unused) {
        }
        return L;
    }

    public static String X(Context context) {
        ConnectivityManager e6;
        NetworkInfo activeNetworkInfo;
        try {
            return (!x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (e6 = e(context)) == null || (activeNetworkInfo = e6.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Y() {
        if (!TextUtils.isEmpty(N)) {
            return N;
        }
        String property = System.getProperty("os.arch");
        N = property;
        return property;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(Context context) {
        String u5 = q4.u("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!u5.equalsIgnoreCase(str)) {
            String u6 = q4.u("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!u6.equalsIgnoreCase(str2) && !q4.u("IUkVETUk=").equalsIgnoreCase(str) && !q4.u("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (q4.u("Idml2bw").equalsIgnoreCase(str) || q4.u("Idml2bw").equalsIgnoreCase(str2)) {
                    return l0(context);
                }
                if (q4.u("IaHVhd2Vp").equalsIgnoreCase(str) || q4.u("IaHVhd2Vp").equalsIgnoreCase(str2) || q4.u("ISE9OT1I=").equalsIgnoreCase(str)) {
                    return p(context, 2);
                }
                if (q4.u("Mc2Ftc3VuZw").equalsIgnoreCase(str) || q4.u("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                    return p(context, 4);
                }
                if (q4.u("IT1BQTw").equalsIgnoreCase(str) || q4.u("IT1BQTw").equalsIgnoreCase(str2) || q4.u("MT25lUGx1cw").equalsIgnoreCase(str) || q4.u("MT25lUGx1cw").equalsIgnoreCase(str2) || q4.u("IUkVBTE1F").equalsIgnoreCase(str2)) {
                    return p(context, 5);
                }
                f6476m = true;
                return f6475l;
            }
        }
        return k0(context);
    }

    public static String a0(Context context) {
        return P() + "#" + o(context) + "#" + Z(context);
    }

    private static String b(Context context) {
        if (!TextUtils.isEmpty(I)) {
            return I;
        }
        try {
            String o5 = g6.o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(o5)) {
                I = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor c6 = g6.c(context, "open_common");
                g6.j(c6, "a1", q4.q(I));
                g6.f(c6);
            } else {
                I = q4.u(o5);
            }
            return I;
        } catch (Throwable unused) {
            return I;
        }
    }

    private static String c(Context context) {
        if (S) {
            return R;
        }
        l(context);
        TelephonyManager g6 = g(context);
        if (g6 == null) {
            return R;
        }
        String simOperatorName = g6.getSimOperatorName();
        R = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            R = g6.getNetworkOperatorName();
        }
        S = true;
        return R;
    }

    public static int c0(Context context) {
        int i6 = M;
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
        M = i7;
        return i7;
    }

    private static int d(Context context) {
        if (U) {
            return T;
        }
        l(context);
        if (context == null || !x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return T;
        }
        ConnectivityManager e6 = e(context);
        if (e6 == null) {
            return T;
        }
        NetworkInfo activeNetworkInfo = e6.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            U = true;
            return T;
        }
        int type = activeNetworkInfo.getType();
        T = type;
        U = true;
        return type;
    }

    private static ConnectivityManager e(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int f(Context context) {
        if (W) {
            return V;
        }
        l(context);
        if (!x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return V;
        }
        ConnectivityManager e6 = e(context);
        if (e6 == null) {
            return V;
        }
        NetworkInfo activeNetworkInfo = e6.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            V = activeNetworkInfo.getSubtype();
            W = true;
        }
        return V;
    }

    public static String f0(Context context) {
        try {
            if (TextUtils.isEmpty(f6472i)) {
                f6472i = y4.a(context);
            }
        } catch (Throwable unused) {
        }
        return f6472i;
    }

    private static TelephonyManager g(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String h(Context context) {
        String str;
        if (!f6466c) {
            return "";
        }
        try {
            str = i(context);
        } catch (Throwable unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            f6466c = false;
            return "";
        }
        try {
            byte[] bytes = q4.u("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(j4.e(q4.u("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), j4.g(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            f6466c = false;
            return "";
        }
    }

    private static String h0(Context context) {
        try {
            String o5 = g6.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(o5) ? g6.o(context, "Alvin2", "UTDID", "") : o5;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String i(Context context) {
        String str;
        try {
            str = j(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(q4.u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(m4.d(q4.u("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String j(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (!x(context, q4.u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String d6 = m4.d(q4.u("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String k6 = k(context);
        if (TextUtils.isEmpty(k6)) {
            return "";
        }
        File file = new File(k6 + File.separator + q4.u("KYmFja3Vwcw"), q4.u("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, t.f36150k);
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
                            r(byteArrayOutputStream2);
                            r(randomAccessFile);
                            return "";
                        }
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
            }
            if (!TextUtils.isEmpty(str) && str.contains(q4.u("SIw")) && (split = str.split(q4.u("SIw"))) != null && split.length == 2 && TextUtils.equals(d6, split[0])) {
                String str2 = split[1];
                r(byteArrayOutputStream);
                r(randomAccessFile);
                return str2;
            }
            r(byteArrayOutputStream);
            r(randomAccessFile);
        }
        return "";
    }

    private static String j0(Context context) {
        try {
            if (!TextUtils.isEmpty(f6478o)) {
                return f6478o;
            }
            byte[] digest = MessageDigest.getInstance(q4.u("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                stringBuffer.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f6478o = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static synchronized d l(Context context) {
        synchronized (i4.class) {
            try {
                if (X == null) {
                    if (context == null) {
                        return null;
                    }
                    d dVar = new d();
                    X = dVar;
                    dVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                return X;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String n() {
        return f6470g;
    }

    public static String o(Context context) {
        if (!TextUtils.isEmpty(f6465b)) {
            return f6465b;
        }
        if (context == null) {
            return "";
        }
        String h6 = h(context);
        f6465b = h6;
        if (!TextUtils.isEmpty(h6)) {
            return f6465b;
        }
        if (z() == null || f6474k) {
            return "";
        }
        f6474k = true;
        a8.h().b(new a(context));
        return "";
    }

    public static void q(c cVar) {
        if (f6473j == null) {
            f6473j = cVar;
        }
    }

    private static void r(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void s(String str) {
        f6470g = str;
    }

    public static void t(boolean z5) {
        f6477n = z5;
    }

    public static String v() {
        try {
            if (!TextUtils.isEmpty(f6468e)) {
                return f6468e;
            }
            c cVar = f6473j;
            return cVar == null ? "" : cVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static c z() {
        return f6473j;
    }

    public static int A(Context context) {
        try {
            return d(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int K(Context context) {
        try {
            return f(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int M(Context context) {
        try {
            return d(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void R() {
        try {
            q5.a();
        } catch (Throwable unused) {
        }
    }

    public static String Z(Context context) {
        try {
            String P2 = P();
            try {
                if (TextUtils.isEmpty(P2)) {
                    P2 = o(context);
                }
                if (TextUtils.isEmpty(P2)) {
                    P2 = F(context);
                }
                if (TextUtils.isEmpty(P2)) {
                    P2 = D(context);
                }
                if (TextUtils.isEmpty(P2)) {
                    P2 = G();
                }
                if (TextUtils.isEmpty(P2)) {
                    return b(context);
                }
                return P2;
            } catch (Throwable unused) {
                return P2;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    static String e0(Context context) {
        try {
            return c(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String k(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String l0(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(q4.u("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= columnCount) {
                            break;
                        }
                        if (q4.u("IdmFsdWU").equals(query.getColumnName(i6))) {
                            f6475l = query.getString(i6);
                            break;
                        }
                        i6++;
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f6476m = true;
            r5.e(th, "oa", "vivo");
        }
        return f6475l;
    }

    public static String w(Context context) {
        try {
            return c(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int y(Context context) {
        try {
            return f(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
