package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w3<T> implements e.b<List<T>, T> {

    /* renamed from: c, reason: collision with root package name */
    private static final Comparator f53761c = new c();

    /* renamed from: a, reason: collision with root package name */
    final Comparator<? super T> f53762a;

    /* renamed from: b, reason: collision with root package name */
    final int f53763b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.q f53764a;

        a(rx.functions.q qVar) {
            this.f53764a = qVar;
        }

        @Override // java.util.Comparator
        public int compare(T t5, T t6) {
            return ((Integer) this.f53764a.call(t5, t6)).intValue();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        List<T> f53766a;

        /* renamed from: b, reason: collision with root package name */
        boolean f53767b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f53768c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.l f53769d;

        b(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f53768c = singleDelayedProducer;
            this.f53769d = lVar;
            this.f53766a = new ArrayList(w3.this.f53763b);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53767b) {
                return;
            }
            this.f53767b = true;
            List<T> list = this.f53766a;
            this.f53766a = null;
            try {
                Collections.sort(list, w3.this.f53762a);
                this.f53768c.setValue(list);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53769d.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53767b) {
                return;
            }
            this.f53766a.add(t5);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }

        c() {
        }
    }

    public w3(int i6) {
        this.f53762a = f53761c;
        this.f53763b = i6;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        b bVar = new b(singleDelayedProducer, lVar);
        lVar.add(bVar);
        lVar.setProducer(singleDelayedProducer);
        return bVar;
    }

    public w3(rx.functions.q<? super T, ? super T, Integer> qVar, int i6) {
        this.f53763b = i6;
        this.f53762a = new a(qVar);
    }
}
