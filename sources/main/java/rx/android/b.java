package rx.android;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class b implements m {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f52248a = new AtomicBoolean();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {
        a() {
        }

        @Override // rx.functions.a
        public void call() {
            b.this.a();
        }
    }

    protected abstract void a();

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f52248a.get();
    }

    @Override // rx.m
    public final void unsubscribe() {
        if (this.f52248a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                rx.android.schedulers.a.b().a().d(new a());
            }
        }
    }

    public static void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }
}
