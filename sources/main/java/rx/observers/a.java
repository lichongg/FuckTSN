package rx.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface a<T> extends rx.f<T>, m {
    a<T> C(Class<? extends Throwable> cls);

    a<T> D();

    int E();

    a<T> F();

    a<T> I();

    List<T> J();

    a<T> K(int i6);

    a<T> L(long j6, TimeUnit timeUnit);

    a<T> M(Class<? extends Throwable> cls, T... tArr);

    a<T> O(rx.functions.a aVar);

    a<T> c();

    a<T> h(T t5, T... tArr);

    a<T> i(T... tArr);

    @Override // rx.m
    boolean isUnsubscribed();

    a<T> k();

    a<T> l();

    List<Throwable> m();

    a<T> n(long j6, TimeUnit timeUnit);

    a<T> o(int i6, long j6, TimeUnit timeUnit);

    void onStart();

    a<T> p();

    a<T> q(List<T> list);

    a<T> r(Throwable th);

    void setProducer(rx.g gVar);

    a<T> t(T t5);

    a<T> u();

    @Override // rx.m
    void unsubscribe();

    a<T> v(T... tArr);

    int w();

    a<T> x(long j6);

    a<T> y(Class<? extends Throwable> cls, String str, T... tArr);

    Thread z();
}
