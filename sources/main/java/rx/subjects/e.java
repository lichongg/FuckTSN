package rx.subjects;

import rx.e;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e<T, R> extends f<T, R> {

    /* renamed from: b, reason: collision with root package name */
    private final rx.observers.f<T> f54543b;

    /* renamed from: c, reason: collision with root package name */
    private final f<T, R> f54544c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e.a<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f54545a;

        a(f fVar) {
            this.f54545a = fVar;
        }

        @Override // rx.functions.b
        public void call(l<? super R> lVar) {
            this.f54545a.J6(lVar);
        }
    }

    public e(f<T, R> fVar) {
        super(new a(fVar));
        this.f54544c = fVar;
        this.f54543b = new rx.observers.f<>(fVar);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f54543b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54543b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54543b.onNext(t5);
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54544c.w7();
    }
}
