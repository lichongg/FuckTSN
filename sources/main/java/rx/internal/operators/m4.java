package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f53191a;

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        try {
            kVar.d(this.f53191a.call());
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.onError(th);
        }
    }

    public m4(Callable<? extends T> callable) {
        this.f53191a = callable;
    }
}
