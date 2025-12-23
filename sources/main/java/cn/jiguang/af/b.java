package cn.jiguang.af;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import cn.jiguang.bb.f;
import cn.jiguang.bz.w;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1493a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1494b;

    /* renamed from: c, reason: collision with root package name */
    private static b f1495c;

    /* renamed from: d, reason: collision with root package name */
    private static a f1496d;

    /* renamed from: e, reason: collision with root package name */
    private static Object f1497e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static HandlerThread f1498f;

    /* renamed from: g, reason: collision with root package name */
    private static Handler f1499g;

    /* renamed from: h, reason: collision with root package name */
    private static String f1500h;

    /* renamed from: i, reason: collision with root package name */
    private static String f1501i;

    /* renamed from: j, reason: collision with root package name */
    private static String f1502j;

    /* renamed from: k, reason: collision with root package name */
    private static String f1503k;

    public static b a(Context context) {
        if (f1495c == null) {
            f1495c = new b();
            f1493a = context;
            f();
            f1496d = new a(f1493a);
            a();
        }
        return f1495c;
    }

    private void b(int i6, String str) {
        Message obtainMessage = f1499g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i6);
        if (i6 == 1 || i6 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f1499g.sendMessage(obtainMessage);
    }

    private static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_vvdb_thread");
        f1498f = handlerThread;
        handlerThread.start();
        f1499g = new Handler(f1498f.getLooper()) { // from class: cn.jiguang.af.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    f.c("VivoIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.f1500h = b.f1496d.a(message.getData().getInt("type"), message.getData().getString("appid"));
                } catch (Throwable th) {
                    String unused2 = b.f1500h = "";
                    f.i("VivoIdManager", "vv getIds, exception" + th.getMessage());
                }
                synchronized (b.f1497e) {
                    b.f1497e.notify();
                }
            }
        };
    }

    public boolean b() {
        return f1494b;
    }

    private b() {
    }

    public static void a() {
        f1494b = "1".equals(w.a("persist.sys.identifierid.supported", "0"));
    }

    public String c() {
        if (!b()) {
            return null;
        }
        String str = f1501i;
        if (str != null) {
            return str;
        }
        a(0, null);
        return f1501i;
    }

    public void a(int i6, String str) {
        String str2;
        String str3;
        synchronized (f1497e) {
            b(i6, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f1497e.wait(2000L);
            } catch (InterruptedException e6) {
                f.i("VivoIdManager", "lock wait error: " + e6.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i6 == 0) {
                    f1501i = f1500h;
                } else if (i6 == 1) {
                    String str4 = f1500h;
                    if (str4 == null) {
                        str2 = "VivoIdManager";
                        str3 = "get vaid failed";
                    } else {
                        f1502j = str4;
                    }
                } else if (i6 == 2) {
                    String str5 = f1500h;
                    if (str5 == null) {
                        str2 = "VivoIdManager";
                        str3 = "get aaid failed";
                    } else {
                        f1503k = str5;
                    }
                }
                f1500h = null;
            } else {
                str2 = "VivoIdManager";
                str3 = "query timeout";
            }
            f.c(str2, str3);
        }
    }
}
