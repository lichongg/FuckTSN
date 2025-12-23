package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f41551a = 101;

    /* renamed from: b, reason: collision with root package name */
    public static final int f41552b = 102;

    /* renamed from: c, reason: collision with root package name */
    public static final int f41553c = 103;

    /* renamed from: d, reason: collision with root package name */
    public static final int f41554d = 104;

    /* renamed from: e, reason: collision with root package name */
    public static final int f41555e = 105;

    /* renamed from: f, reason: collision with root package name */
    public static final int f41556f = 106;

    /* renamed from: g, reason: collision with root package name */
    public static final int f41557g = 107;

    /* renamed from: h, reason: collision with root package name */
    public static final int f41558h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final int f41559i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f41560j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final int f41561k = 201;

    /* renamed from: l, reason: collision with root package name */
    public static final int f41562l = 202;

    /* renamed from: m, reason: collision with root package name */
    public static final int f41563m = 203;

    /* renamed from: n, reason: collision with root package name */
    public static final int f41564n = 301;

    /* renamed from: o, reason: collision with root package name */
    public static final int f41565o = 302;

    /* renamed from: p, reason: collision with root package name */
    public static final int f41566p = 303;

    /* renamed from: q, reason: collision with root package name */
    private static HandlerThread f41567q = null;

    /* renamed from: r, reason: collision with root package name */
    private static Handler f41568r = null;

    /* renamed from: s, reason: collision with root package name */
    private static HashMap<Integer, a> f41569s = null;

    /* renamed from: t, reason: collision with root package name */
    private static final int f41570t = 256;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(Object obj, int i6);
    }

    public static void a(Context context, int i6, int i7, a aVar, Object obj, long j6) {
        if (context == null || aVar == null) {
            return;
        }
        if (f41569s == null) {
            f41569s = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i7 / 100);
        if (!f41569s.containsKey(valueOf)) {
            f41569s.put(valueOf, aVar);
        }
        if (f41567q == null || f41568r == null) {
            a();
        }
        try {
            Handler handler = f41568r;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i6;
                obtainMessage.arg1 = i7;
                obtainMessage.obj = obj;
                f41568r.sendMessageDelayed(obtainMessage, j6);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i6 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i6 / 100);
        HashMap<Integer, a> hashMap = f41569s;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f41569s.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i6);
        }
    }

    private c() {
    }

    public static void a(Context context, int i6, a aVar, Object obj) {
        a(context, 256, i6, aVar, obj, 0L);
    }

    public static void a(Context context, int i6, a aVar, Object obj, long j6) {
        a(context, 256, i6, aVar, obj, j6);
    }

    private static synchronized void a() {
        synchronized (c.class) {
            try {
                if (f41567q == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    f41567q = handlerThread;
                    handlerThread.start();
                    if (f41568r == null) {
                        f41568r = new Handler(f41567q.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                c.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
