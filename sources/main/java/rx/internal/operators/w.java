package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends rx.e<? extends T>> f53646a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f53647a;

        a(d dVar) {
            this.f53647a = dVar;
        }

        @Override // rx.functions.a
        public void call() {
            c<T> cVar = this.f53647a.get();
            if (cVar != null) {
                cVar.unsubscribe();
            }
            w.j(this.f53647a.f53654a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f53649a;

        b(d dVar) {
            this.f53649a = dVar;
        }

        @Override // rx.g
        public void request(long j6) {
            c<T> cVar = this.f53649a.get();
            if (cVar != null) {
                cVar.s(j6);
                return;
            }
            for (c<T> cVar2 : this.f53649a.f53654a) {
                if (!cVar2.isUnsubscribed()) {
                    if (this.f53649a.get() == cVar2) {
                        cVar2.s(j6);
                        return;
                    }
                    cVar2.s(j6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f53651a;

        /* renamed from: b, reason: collision with root package name */
        private final d<T> f53652b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f53653c;

        private boolean j() {
            if (this.f53653c) {
                return true;
            }
            if (this.f53652b.get() == this) {
                this.f53653c = true;
                return true;
            }
            if (!this.f53652b.compareAndSet(null, this)) {
                this.f53652b.a();
                return false;
            }
            this.f53652b.b(this);
            this.f53653c = true;
            return true;
        }

        c(long j6, rx.l<? super T> lVar, d<T> dVar) {
            this.f53651a = lVar;
            this.f53652b = dVar;
            request(j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(long j6) {
            request(j6);
        }

        @Override // rx.f
        public void onCompleted() {
            if (j()) {
                this.f53651a.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (j()) {
                this.f53651a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (j()) {
                this.f53651a.onNext(t5);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> extends AtomicReference<c<T>> {

        /* renamed from: a, reason: collision with root package name */
        final Collection<c<T>> f53654a = new ConcurrentLinkedQueue();

        public void b(c<T> cVar) {
            for (c<T> cVar2 : this.f53654a) {
                if (cVar2 != cVar) {
                    cVar2.unsubscribe();
                }
            }
            this.f53654a.clear();
        }

        d() {
        }

        public void a() {
            c<T> cVar = get();
            if (cVar != null) {
                b(cVar);
            }
        }
    }

    public static <T> e.a<T> h(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6, rx.e<? extends T> eVar7, rx.e<? extends T> eVar8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        return a(arrayList);
    }

    public static <T> e.a<T> i(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6, rx.e<? extends T> eVar7, rx.e<? extends T> eVar8, rx.e<? extends T> eVar9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        arrayList.add(eVar9);
        return a(arrayList);
    }

    public static <T> e.a<T> a(Iterable<? extends rx.e<? extends T>> iterable) {
        return new w(iterable);
    }

    public static <T> e.a<T> b(rx.e<? extends T> eVar, rx.e<? extends T> eVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        return a(arrayList);
    }

    public static <T> e.a<T> c(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        return a(arrayList);
    }

    public static <T> e.a<T> d(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        return a(arrayList);
    }

    public static <T> e.a<T> e(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        return a(arrayList);
    }

    public static <T> e.a<T> f(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        return a(arrayList);
    }

    public static <T> e.a<T> g(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6, rx.e<? extends T> eVar7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        return a(arrayList);
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        d dVar = new d();
        lVar.add(rx.subscriptions.f.a(new a(dVar)));
        for (rx.e<? extends T> eVar : this.f53646a) {
            if (lVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar = new c<>(0L, lVar, dVar);
            dVar.f53654a.add(cVar);
            c<T> cVar2 = dVar.get();
            if (cVar2 != null) {
                dVar.b(cVar2);
                return;
            }
            eVar.J6(cVar);
        }
        if (lVar.isUnsubscribed()) {
            j(dVar.f53654a);
        }
        lVar.setProducer(new b(dVar));
    }

    private w(Iterable<? extends rx.e<? extends T>> iterable) {
        this.f53646a = iterable;
    }

    static <T> void j(Collection<c<T>> collection) {
        if (!collection.isEmpty()) {
            Iterator<c<T>> it = collection.iterator();
            while (it.hasNext()) {
                it.next().unsubscribe();
            }
            collection.clear();
        }
    }
}
