package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class j<T> implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11039b = "BaseTask";

    /* renamed from: c, reason: collision with root package name */
    private static final int f11040c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f11041d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f11042e = 3;

    /* renamed from: j, reason: collision with root package name */
    private static b f11043j;

    /* renamed from: a, reason: collision with root package name */
    protected Future<T> f11044a;

    /* renamed from: f, reason: collision with root package name */
    private String f11045f;

    /* renamed from: g, reason: collision with root package name */
    private long f11046g;

    /* renamed from: h, reason: collision with root package name */
    private long f11047h;

    /* renamed from: i, reason: collision with root package name */
    private long f11048i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i6 = message.what;
            if (i6 == 1) {
                aVar.f11049a.a((j) aVar.f11050b);
            } else if (i6 == 2) {
                aVar.f11049a.a((Throwable) aVar.f11050b);
            } else {
                if (i6 != 3) {
                    return;
                }
                aVar.f11049a.j();
            }
        }

        public b(Looper looper) {
            super(looper);
        }
    }

    public j() {
        this.f11045f = "default";
    }

    protected void a(T t5) {
    }

    public void b() {
        a(false);
    }

    protected abstract T i();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        final j f11049a;

        /* renamed from: b, reason: collision with root package name */
        final T f11050b;

        a(j jVar, T t5) {
            this.f11049a = jVar;
            this.f11050b = t5;
        }
    }

    private static Handler k() {
        b bVar;
        synchronized (j.class) {
            try {
                if (f11043j == null) {
                    f11043j = new b(Looper.getMainLooper());
                }
                bVar = f11043j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    protected void a(Throwable th) {
    }

    public boolean c() {
        Future<T> future = this.f11044a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f11044a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f11047h - this.f11046g;
    }

    public long f() {
        return this.f11048i - this.f11046g;
    }

    public long g() {
        return this.f11048i - this.f11047h;
    }

    public j(String str) {
        this.f11045f = str;
    }

    public String a() {
        return this.f11045f;
    }

    public j h() {
        try {
            this.f11047h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Future future) {
        this.f11044a = future;
    }

    public void a(long j6) {
        this.f11046g = j6;
    }

    public void a(boolean z5) {
        Future<T> future = this.f11044a;
        if (future != null) {
            future.cancel(z5);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }

    protected void j() {
    }
}
