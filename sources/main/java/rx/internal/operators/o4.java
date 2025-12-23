package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final Future<? extends T> f53309a;

    /* renamed from: b, reason: collision with root package name */
    final long f53310b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f53311c;

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        Future<? extends T> future = this.f53309a;
        kVar.b(rx.subscriptions.f.c(future));
        try {
            long j6 = this.f53310b;
            kVar.d(j6 == 0 ? future.get() : future.get(j6, this.f53311c));
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.onError(th);
        }
    }

    public o4(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        this.f53309a = future;
        this.f53310b = j6;
        this.f53311c = timeUnit;
    }
}
