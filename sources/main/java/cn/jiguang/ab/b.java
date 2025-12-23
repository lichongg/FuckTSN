package cn.jiguang.ab;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1467a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1468b;

    /* renamed from: c, reason: collision with root package name */
    private static b f1469c;

    /* renamed from: d, reason: collision with root package name */
    private static a f1470d;

    /* renamed from: e, reason: collision with root package name */
    private static Object f1471e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static HandlerThread f1472f;

    /* renamed from: g, reason: collision with root package name */
    private static Handler f1473g;

    /* renamed from: h, reason: collision with root package name */
    private static String f1474h;

    /* renamed from: i, reason: collision with root package name */
    private static String f1475i;

    /* renamed from: j, reason: collision with root package name */
    private static String f1476j;

    /* renamed from: k, reason: collision with root package name */
    private static String f1477k;

    public static b a(Context context) {
        if (f1469c == null) {
            f1469c = new b();
            f1467a = context;
            e();
            f1470d = new a(f1467a);
            b(f1467a);
        }
        return f1469c;
    }

    public String b() {
        if (!a()) {
            return null;
        }
        String str = f1475i;
        if (str != null) {
            return str;
        }
        a(0);
        return f1475i;
    }

    private void b(int i6) {
        String str;
        Message obtainMessage = f1473g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        if (i6 == 0) {
            str = "ggTIEepvzybHoO4C7/s5eQ==";
        } else {
            if (i6 != 1) {
                if (i6 == 2) {
                    str = "bRmfYSLDPlLJ9XQro1+/dQ==";
                }
                obtainMessage.setData(bundle);
                f1473g.sendMessage(obtainMessage);
            }
            str = "QlAKJNz4iTmDadRoCSAs4A==";
        }
        bundle.putString("type", cn.jiguang.d.a.c(str));
        obtainMessage.setData(bundle);
        f1473g.sendMessage(obtainMessage);
    }

    private static void e() {
        HandlerThread handlerThread = new HandlerThread("jg_mzdb_thread");
        f1472f = handlerThread;
        handlerThread.start();
        f1473g = new Handler(f1472f.getLooper()) { // from class: cn.jiguang.ab.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    f.c("MeizuIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.f1474h = b.f1470d.a(message.getData().getString("type"));
                } catch (Throwable th) {
                    String unused2 = b.f1474h = "";
                    f.c("MeizuIdManager", "getID exception, " + th.getMessage());
                }
                synchronized (b.f1471e) {
                    b.f1471e.notify();
                }
            }
        };
    }

    private b() {
    }

    public static void b(Context context) {
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            String c6 = cn.jiguang.d.a.c("rIjLIWp9yd1+l2BByOWYjPjGCBlvF2tDounrABnhodw=");
            if (packageManager != null && packageManager.resolveContentProvider(c6, 0) != null) {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse(cn.jiguang.d.a.c("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO")), null, null, new String[]{"supported"}, null);
                    if (query != null) {
                        query.moveToFirst();
                        int columnIndex = query.getColumnIndex("value");
                        if (columnIndex >= 0) {
                            f1468b = "0".equals(query.getString(columnIndex));
                        } else {
                            f1468b = false;
                        }
                        query.close();
                    }
                } catch (Throwable unused) {
                    f.c("MeizuIdManager", "mz not support");
                }
                f.c("MeizuIdManager", "check meizu supported:" + f1468b);
            }
        }
        f1468b = false;
        f.c("MeizuIdManager", "check meizu supported:" + f1468b);
    }

    public void a(int i6) {
        String str;
        String str2;
        StringBuilder sb;
        synchronized (f1471e) {
            b(i6);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f1471e.wait(2000L);
            } catch (InterruptedException e6) {
                f.i("MeizuIdManager", "lock wait err: " + e6.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i6 == 0) {
                    f1475i = f1474h;
                    f1474h = null;
                    str = "MeizuIdManager";
                    sb = new StringBuilder();
                    sb.append("query aaid: ");
                    sb.append(f1475i);
                } else if (i6 == 1) {
                    String str3 = f1474h;
                    if (str3 == null) {
                        str = "MeizuIdManager";
                        str2 = "get ids-va failed";
                    } else {
                        f1476j = str3;
                        f1474h = null;
                        str = "MeizuIdManager";
                        sb = new StringBuilder();
                        sb.append("query aaid: ");
                        sb.append(f1476j);
                    }
                } else if (i6 == 2) {
                    String str4 = f1474h;
                    if (str4 == null) {
                        str = "MeizuIdManager";
                        str2 = "get ids-aa failed";
                    } else {
                        f1477k = str4;
                        f1474h = null;
                        str = "MeizuIdManager";
                        sb = new StringBuilder();
                        sb.append("query aaid: ");
                        sb.append(f1477k);
                    }
                }
                str2 = sb.toString();
            } else {
                str = "MeizuIdManager";
                str2 = "query timeout";
            }
            f.c(str, str2);
        }
    }

    public boolean a() {
        return f1468b;
    }
}
