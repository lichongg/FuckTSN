package l5;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.g;
import rx.l;
import rx.observers.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a<T> extends l<T> implements rx.observers.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final j<T> f49689a;

    public static <T> a<T> g(long j6) {
        j jVar = new j(j6);
        a<T> aVar = new a<>(jVar);
        aVar.add(jVar);
        return aVar;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> C(Class<? extends Throwable> cls) {
        this.f49689a.j(cls);
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> D() {
        this.f49689a.H();
        return this;
    }

    @Override // rx.observers.a
    public final int E() {
        return this.f49689a.E();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> F() {
        this.f49689a.g();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> I() {
        this.f49689a.G();
        return this;
    }

    @Override // rx.observers.a
    public List<T> J() {
        return this.f49689a.J();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> K(int i6) {
        this.f49689a.T(i6);
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> L(long j6, TimeUnit timeUnit) {
        this.f49689a.Y(j6, timeUnit);
        return this;
    }

    @Override // rx.observers.a
    public final rx.observers.a<T> M(Class<? extends Throwable> cls, T... tArr) {
        this.f49689a.U(tArr);
        this.f49689a.j(cls);
        this.f49689a.N();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> c() {
        this.f49689a.X();
        return this;
    }

    @Override // rx.observers.a
    public final rx.observers.a<T> h(T t5, T... tArr) {
        this.f49689a.V(t5, tArr);
        return this;
    }

    @Override // rx.observers.a
    public final rx.observers.a<T> i(T... tArr) {
        this.f49689a.U(tArr);
        this.f49689a.B();
        this.f49689a.g();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> k() {
        this.f49689a.Q();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> l() {
        this.f49689a.B();
        return this;
    }

    @Override // rx.observers.a
    public List<Throwable> m() {
        return this.f49689a.m();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> n(long j6, TimeUnit timeUnit) {
        this.f49689a.Z(j6, timeUnit);
        return this;
    }

    @Override // rx.observers.a
    public final rx.observers.a<T> o(int i6, long j6, TimeUnit timeUnit) {
        if (this.f49689a.a0(i6, j6, timeUnit)) {
            return this;
        }
        throw new AssertionError("Did not receive enough values in time. Expected: " + i6 + ", Actual: " + this.f49689a.E());
    }

    @Override // rx.f
    public void onCompleted() {
        this.f49689a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f49689a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f49689a.onNext(t5);
    }

    @Override // rx.l
    public void onStart() {
        this.f49689a.onStart();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> p() {
        this.f49689a.N();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> q(List<T> list) {
        this.f49689a.P(list);
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> r(Throwable th) {
        this.f49689a.s(th);
        return this;
    }

    @Override // rx.l, rx.observers.a
    public void setProducer(g gVar) {
        this.f49689a.setProducer(gVar);
    }

    @Override // rx.observers.a
    public rx.observers.a<T> t(T t5) {
        this.f49689a.S(t5);
        return this;
    }

    public String toString() {
        return this.f49689a.toString();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> u() {
        this.f49689a.R();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> v(T... tArr) {
        this.f49689a.U(tArr);
        return this;
    }

    @Override // rx.observers.a
    public final int w() {
        return this.f49689a.w();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> x(long j6) {
        this.f49689a.h0(j6);
        return this;
    }

    @Override // rx.observers.a
    public final rx.observers.a<T> y(Class<? extends Throwable> cls, String str, T... tArr) {
        this.f49689a.U(tArr);
        this.f49689a.j(cls);
        this.f49689a.N();
        String message = this.f49689a.m().get(0).getMessage();
        if (message == str || (str != null && str.equals(message))) {
            return this;
        }
        throw new AssertionError("Error message differs. Expected: '" + str + "', Received: '" + message + "'");
    }

    @Override // rx.observers.a
    public Thread z() {
        return this.f49689a.z();
    }

    public a(j<T> jVar) {
        this.f49689a = jVar;
    }

    @Override // rx.observers.a
    public final rx.observers.a<T> O(rx.functions.a aVar) {
        aVar.call();
        return this;
    }
}
