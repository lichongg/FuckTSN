package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v3<T> implements e.b<List<T>, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53633a;

        /* renamed from: b, reason: collision with root package name */
        List<T> f53634b = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f53635c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.l f53636d;

        a(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f53635c = singleDelayedProducer;
            this.f53636d = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53633a) {
                return;
            }
            this.f53633a = true;
            try {
                ArrayList arrayList = new ArrayList(this.f53634b);
                this.f53634b = null;
                this.f53635c.setValue(arrayList);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53636d.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53633a) {
                return;
            }
            this.f53634b.add(t5);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final v3<Object> f53638a = new v3<>();

        b() {
        }
    }

    public static <T> v3<T> a() {
        return (v3<T>) b.f53638a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        a aVar = new a(singleDelayedProducer, lVar);
        lVar.add(aVar);
        lVar.setProducer(singleDelayedProducer);
        return aVar;
    }

    v3() {
    }
}
