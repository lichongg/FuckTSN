package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class a {

    /* renamed from: e, reason: collision with root package name */
    private static final int f42089e = 1;

    /* renamed from: a, reason: collision with root package name */
    private final long f42090a;

    /* renamed from: b, reason: collision with root package name */
    private final long f42091b;

    /* renamed from: c, reason: collision with root package name */
    private long f42092c;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f42094f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f42095g;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42093d = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler.Callback f42096h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                try {
                    if (a.this.f42093d) {
                        return true;
                    }
                    long elapsedRealtime = a.this.f42092c - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        a.this.c();
                        if (a.this.f42094f != null) {
                            a.this.f42094f.quit();
                        }
                    } else if (elapsedRealtime < a.this.f42091b) {
                        a.this.f42095g.sendMessageDelayed(a.this.f42095g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.f42091b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += a.this.f42091b;
                        }
                        a.this.f42095g.sendMessageDelayed(a.this.f42095g.obtainMessage(1), elapsedRealtime3);
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public abstract void a(long j6);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f42093d = true;
        this.f42095g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f42093d = false;
        if (this.f42090a <= 0) {
            c();
            return this;
        }
        this.f42092c = SystemClock.elapsedRealtime() + this.f42090a;
        Handler handler = this.f42095g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public a(long j6, long j7) {
        this.f42090a = j6;
        this.f42091b = j7;
        if (!d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f42094f = handlerThread;
            handlerThread.start();
            this.f42095g = new Handler(this.f42094f.getLooper(), this.f42096h);
            return;
        }
        this.f42095g = new Handler(this.f42096h);
    }
}
