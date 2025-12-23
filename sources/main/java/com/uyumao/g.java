package com.uyumao;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static HandlerThread f42585a;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f42586b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<Integer, a> f42587c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(Object obj, int i6);
    }

    public static void a(Context context, int i6, int i7, a aVar, Object obj, long j6) {
        if (context == null || aVar == null) {
            return;
        }
        if (f42587c == null) {
            f42587c = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i7 / 100);
        if (!f42587c.containsKey(valueOf)) {
            f42587c.put(valueOf, aVar);
        }
        if (f42585a == null || f42586b == null) {
            synchronized (g.class) {
                try {
                    if (f42585a == null) {
                        HandlerThread handlerThread = new HandlerThread("yumao_ccg");
                        f42585a = handlerThread;
                        handlerThread.start();
                        if (f42586b == null) {
                            f42586b = new f(f42585a.getLooper());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        try {
            Handler handler = f42586b;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i6;
                obtainMessage.arg1 = i7;
                obtainMessage.obj = obj;
                f42586b.sendMessageDelayed(obtainMessage, j6);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(Context context, int i6, a aVar, Object obj) {
        a(context, 256, i6, aVar, obj, 0L);
    }
}
