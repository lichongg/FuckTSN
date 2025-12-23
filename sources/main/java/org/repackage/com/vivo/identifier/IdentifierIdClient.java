package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.acse.ottn.l3;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IdentifierIdClient {
    private static int A = 13;
    private static IdentifierIdObserver B = null;
    private static IdentifierIdObserver C = null;
    private static IdentifierIdObserver D = null;
    private static IdentifierIdObserver E = null;
    private static HandlerThread F = null;
    private static Handler G = null;
    private static String H = null;
    private static String I = null;
    private static String J = null;
    private static String K = null;
    private static String L = null;
    private static String M = null;
    private static String N = null;
    private static volatile IdentifierIdClient O = null;
    private static volatile DataBaseOperation P = null;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final String f51642a = "persist.sys.identifierid";
    private static int aa = 0;
    private static int ab = 0;
    private static int ac = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final String f51643b = "VMS_SDK_Client";

    /* renamed from: c, reason: collision with root package name */
    private static final String f51644c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d, reason: collision with root package name */
    private static final String f51645d = "persist.sys.identifierid.supported";

    /* renamed from: e, reason: collision with root package name */
    private static final String f51646e = "com.vivo.vms";

    /* renamed from: f, reason: collision with root package name */
    private static final String f51647f = "appid";

    /* renamed from: g, reason: collision with root package name */
    private static final String f51648g = "type";

    /* renamed from: h, reason: collision with root package name */
    private static final String f51649h = "OAID";

    /* renamed from: i, reason: collision with root package name */
    private static final String f51650i = "VAID";

    /* renamed from: j, reason: collision with root package name */
    private static final String f51651j = "OAIDSTATUS";

    /* renamed from: k, reason: collision with root package name */
    private static Object f51652k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static final int f51653l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static final int f51654m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static final int f51655n = 2;

    /* renamed from: o, reason: collision with root package name */
    private static final int f51656o = 3;

    /* renamed from: p, reason: collision with root package name */
    private static final int f51657p = 4;

    /* renamed from: q, reason: collision with root package name */
    private static final int f51658q = 5;

    /* renamed from: r, reason: collision with root package name */
    private static final int f51659r = 6;

    /* renamed from: s, reason: collision with root package name */
    private static final int f51660s = 7;

    /* renamed from: t, reason: collision with root package name */
    private static final int f51661t = 8;

    /* renamed from: u, reason: collision with root package name */
    private static final int f51662u = 9;

    /* renamed from: v, reason: collision with root package name */
    private static final int f51663v = 10;

    /* renamed from: w, reason: collision with root package name */
    private static final int f51664w = 11;

    /* renamed from: x, reason: collision with root package name */
    private static final int f51665x = 2000;

    /* renamed from: y, reason: collision with root package name */
    private static Context f51666y;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f51667z;
    private final int Q;

    private void C() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (IdentifierIdClient.R + IdentifierIdClient.S + IdentifierIdClient.X + IdentifierIdClient.aa + IdentifierIdClient.T + IdentifierIdClient.U + IdentifierIdClient.Z + IdentifierIdClient.aa + IdentifierIdClient.V + IdentifierIdClient.W + IdentifierIdClient.ab + IdentifierIdClient.ac > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("oaid", IdentifierIdClient.this.a(IdentifierIdClient.R, IdentifierIdClient.S, IdentifierIdClient.X, IdentifierIdClient.Y));
                    contentValues.put("vaid", IdentifierIdClient.this.a(IdentifierIdClient.T, IdentifierIdClient.U, IdentifierIdClient.Z, IdentifierIdClient.aa));
                    contentValues.put("aaid", IdentifierIdClient.this.a(IdentifierIdClient.V, IdentifierIdClient.W, IdentifierIdClient.ab, IdentifierIdClient.ac));
                    IdentifierIdClient.P.a(7, "vivo", new ContentValues[]{contentValues});
                    int unused = IdentifierIdClient.R = IdentifierIdClient.S = IdentifierIdClient.T = IdentifierIdClient.U = IdentifierIdClient.V = IdentifierIdClient.W = 0;
                    int unused2 = IdentifierIdClient.X = IdentifierIdClient.Y = IdentifierIdClient.Z = IdentifierIdClient.aa = IdentifierIdClient.ab = IdentifierIdClient.ac = 0;
                }
            }
        }, 600L, 600L, TimeUnit.SECONDS);
    }

    private static void D() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        F = handlerThread;
        handlerThread.start();
        G = new Handler(F.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    int i6 = message.getData().getInt("type");
                    try {
                        String a6 = IdentifierIdClient.P.a(i6, message.getData().getString("appid"));
                        if (i6 == 0) {
                            String unused = IdentifierIdClient.H = a6;
                            IdentifierIdClient.c(8, IdentifierIdClient.H);
                        } else if (i6 == 1) {
                            if (a6 != null) {
                                String unused2 = IdentifierIdClient.I = a6;
                            }
                            IdentifierIdClient.c(9, IdentifierIdClient.I);
                        } else if (i6 == 2) {
                            if (a6 != null) {
                                String unused3 = IdentifierIdClient.J = a6;
                            }
                            IdentifierIdClient.c(10, IdentifierIdClient.J);
                        } else if (i6 != 3) {
                            if (i6 == 4) {
                                String unused4 = IdentifierIdClient.L = a6;
                            } else if (i6 == 5 && a6 != null) {
                                String unused5 = IdentifierIdClient.M = a6;
                            }
                        } else if (a6 != null) {
                            String unused6 = IdentifierIdClient.K = a6;
                        }
                    } catch (Exception e6) {
                        e6.toString();
                    }
                    synchronized (IdentifierIdClient.f51652k) {
                        IdentifierIdClient.f51652k.notify();
                    }
                }
            }
        };
    }

    private static void E() {
        f51667z = "1".equals(a(f51645d, "0")) || "1".equals(a(f51642a, "0"));
    }

    String g() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        e(2, "vivo");
        if (D == null) {
            a(f51666y, 2, "vivo");
        }
        c(2, J);
        return J;
    }

    String h() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        d(2, "vivo");
        if (D == null) {
            a(f51666y, 2, "vivo");
        }
        c(2, J);
        return J;
    }

    String i() {
        e(4, null);
        return L;
    }

    String j() {
        String str = M;
        if (str != null) {
            return str;
        }
        e(5, "vivo");
        return M;
    }

    String k() {
        String str = M;
        if (str != null) {
            return str;
        }
        d(5, "vivo");
        return M;
    }

    private IdentifierIdClient() {
        D();
        P = new DataBaseOperation(f51666y);
        this.Q = c(f51666y);
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f51646e, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    String d() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        d(0, null);
        if (B == null) {
            a(f51666y, 0, null);
        }
        c(0, H);
        return H;
    }

    String e() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        e(1, "vivo");
        if (C == null) {
            a(f51666y, 1, "vivo");
        }
        c(1, I);
        return I;
    }

    String f() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        d(1, "vivo");
        if (C == null) {
            a(f51666y, 1, "vivo");
        }
        c(1, I);
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i6, int i7, int i8, int i9) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i6);
        stringBuffer.append(",");
        stringBuffer.append(i7);
        stringBuffer.append(";");
        stringBuffer.append(i8);
        stringBuffer.append(",");
        stringBuffer.append(i9);
        return stringBuffer.toString();
    }

    static IdentifierIdClient b(Context context) {
        if (a()) {
            return a(context);
        }
        return null;
    }

    static IdentifierIdClient a(Context context) {
        if (f51666y == null) {
            if (context == null) {
                return null;
            }
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext != null) {
                context = origApplicationContext;
            }
            f51666y = context;
        }
        if (O == null) {
            synchronized (IdentifierIdClient.class) {
                try {
                    if (O == null) {
                        O = new IdentifierIdClient();
                        O.C();
                    }
                } finally {
                }
            }
        }
        return O;
    }

    String b() {
        String str = K;
        if (str != null) {
            return str;
        }
        e(3, null);
        return K;
    }

    String c() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        e(0, null);
        if (B == null) {
            a(f51666y, 0, null);
        }
        c(0, H);
        return H;
    }

    List b(List<String> list) {
        if (this.Q >= A && list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String[] split = list.get(i6).split(":");
                    if (split.length == 2) {
                        arrayList.add(Boolean.valueOf(P.a(6, "vivo", split[0], split[1])));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void d(int i6, String str) {
        a(i6, str);
    }

    private void e(int i6, String str) {
        synchronized (f51652k) {
            a(i6, str);
            SystemClock.uptimeMillis();
            try {
                f51652k.wait(2000L);
            } catch (InterruptedException unused) {
            }
            SystemClock.uptimeMillis();
        }
    }

    static boolean a() {
        if (!f51667z) {
            E();
        }
        return f51667z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i6, String str) {
        if (i6 == 0) {
            if (str == null) {
                S++;
                return;
            } else {
                R++;
                return;
            }
        }
        if (i6 == 1) {
            if (str == null) {
                U++;
                return;
            } else {
                T++;
                return;
            }
        }
        if (i6 == 2) {
            if (str == null) {
                W++;
                return;
            } else {
                V++;
                return;
            }
        }
        switch (i6) {
            case 8:
                if (str != null) {
                    X++;
                    break;
                } else {
                    Y++;
                    break;
                }
            case 9:
                if (str != null) {
                    Z++;
                    break;
                } else {
                    aa++;
                    break;
                }
            case 10:
                if (str != null) {
                    ab++;
                    break;
                } else {
                    ac++;
                    break;
                }
        }
    }

    boolean a(List<String> list) {
        if (this.Q >= A && list != null && list.size() != 0) {
            try {
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ContentValues contentValues = new ContentValues();
                    String[] split = list.get(i6).split(":");
                    if (split.length != 2) {
                        return false;
                    }
                    String str = split[0];
                    String str2 = split[1];
                    contentValues.put(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, str);
                    contentValues.put("uid", str2);
                    contentValues.put("value", format);
                    contentValuesArr[i6] = contentValues;
                }
                return P.a(6, "vivo", contentValuesArr);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    void a(int i6, String str) {
        Message obtainMessage = G.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i6);
        if (i6 == 1 || i6 == 2 || i6 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        G.sendMessage(obtainMessage);
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e6) {
                e6.getMessage();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static synchronized void a(Context context, int i6, String str) {
        synchronized (IdentifierIdClient.class) {
            try {
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 == 2) {
                            if (D == null) {
                                D = new IdentifierIdObserver(O, 2, str);
                                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, D);
                            }
                        }
                    } else if (C == null) {
                        C = new IdentifierIdObserver(O, 1, str);
                        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, C);
                    }
                } else if (B == null) {
                    B = new IdentifierIdObserver(O, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, B);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
