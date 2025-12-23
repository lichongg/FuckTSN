package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.h;
import rx.m;
import rx.subscriptions.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c extends h {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f52255a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends h.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f52256a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.android.plugins.b f52257b = rx.android.plugins.a.a().b();

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f52258c;

        @Override // rx.m
        public void unsubscribe() {
            this.f52258c = true;
            this.f52256a.removeCallbacksAndMessages(this);
        }

        @Override // rx.h.a
        public m d(rx.functions.a aVar) {
            return e(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.h.a
        public m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            if (this.f52258c) {
                return f.e();
            }
            b bVar = new b(this.f52257b.c(aVar), this.f52256a);
            Message obtain = Message.obtain(this.f52256a, bVar);
            obtain.obj = this;
            this.f52256a.sendMessageDelayed(obtain, timeUnit.toMillis(j6));
            if (!this.f52258c) {
                return bVar;
            }
            this.f52256a.removeCallbacks(bVar);
            return f.e();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f52258c;
        }

        a(Handler handler) {
            this.f52256a = handler;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Runnable, m {

        /* renamed from: a, reason: collision with root package name */
        private final rx.functions.a f52259a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f52260b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f52261c;

        @Override // rx.m
        public void unsubscribe() {
            this.f52261c = true;
            this.f52260b.removeCallbacks(this);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f52261c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f52259a.call();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                rx.plugins.f.c().b().a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        b(rx.functions.a aVar, Handler handler) {
            this.f52259a = aVar;
            this.f52260b = handler;
        }
    }

    c(Looper looper) {
        this.f52255a = new Handler(looper);
    }

    @Override // rx.h
    public h.a a() {
        return new a(this.f52255a);
    }

    c(Handler handler) {
        this.f52255a = handler;
    }
}
