package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s1<T, TOpening, TClosing> implements e.b<List<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends TOpening> f53481a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super TOpening, ? extends rx.e<? extends TClosing>> f53482b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<TOpening> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53483a;

        a(b bVar) {
            this.f53483a = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53483a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53483a.onError(th);
        }

        @Override // rx.f
        public void onNext(TOpening topening) {
            this.f53483a.j(topening);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53485a;

        /* renamed from: b, reason: collision with root package name */
        final List<List<T>> f53486b = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        boolean f53487c;

        /* renamed from: d, reason: collision with root package name */
        final rx.subscriptions.b f53488d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<TClosing> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f53490a;

            a(List list) {
                this.f53490a = list;
            }

            @Override // rx.f
            public void onCompleted() {
                b.this.f53488d.f(this);
                b.this.g(this.f53490a);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                b.this.onError(th);
            }

            @Override // rx.f
            public void onNext(TClosing tclosing) {
                b.this.f53488d.f(this);
                b.this.g(this.f53490a);
            }
        }

        void g(List<T> list) {
            boolean z5;
            synchronized (this) {
                try {
                    if (this.f53487c) {
                        return;
                    }
                    Iterator<List<T>> it = this.f53486b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z5 = false;
                            break;
                        } else if (it.next() == list) {
                            it.remove();
                            z5 = true;
                            break;
                        }
                    }
                    if (z5) {
                        this.f53485a.onNext(list);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        if (this.f53487c) {
                            return;
                        }
                        this.f53487c = true;
                        LinkedList linkedList = new LinkedList(this.f53486b);
                        this.f53486b.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.f53485a.onNext((List) it.next());
                        }
                        this.f53485a.onCompleted();
                        unsubscribe();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f53485a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    if (this.f53487c) {
                        return;
                    }
                    this.f53487c = true;
                    this.f53486b.clear();
                    this.f53485a.onError(th);
                    unsubscribe();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            synchronized (this) {
                try {
                    Iterator<List<T>> it = this.f53486b.iterator();
                    while (it.hasNext()) {
                        it.next().add(t5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public b(rx.l<? super List<T>> lVar) {
            this.f53485a = lVar;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f53488d = bVar;
            add(bVar);
        }

        void j(TOpening topening) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                try {
                    if (this.f53487c) {
                        return;
                    }
                    this.f53486b.add(arrayList);
                    try {
                        rx.e<? extends TClosing> call = s1.this.f53482b.call(topening);
                        a aVar = new a(arrayList);
                        this.f53488d.a(aVar);
                        call.J6(aVar);
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        b bVar = new b(new rx.observers.g(lVar));
        a aVar = new a(bVar);
        lVar.add(aVar);
        lVar.add(bVar);
        this.f53481a.J6(aVar);
        return bVar;
    }

    public s1(rx.e<? extends TOpening> eVar, rx.functions.p<? super TOpening, ? extends rx.e<? extends TClosing>> pVar) {
        this.f53481a = eVar;
        this.f53482b = pVar;
    }
}
