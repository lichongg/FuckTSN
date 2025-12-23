package rx.subjects;

import java.util.ArrayList;
import rx.e;
import rx.internal.operators.v;
import rx.internal.producers.SingleProducer;
import rx.subjects.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class a<T> extends f<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g<T> f54495b;

    /* renamed from: c, reason: collision with root package name */
    volatile Object f54496c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.subjects.a$a, reason: collision with other inner class name */
    static class C1078a implements rx.functions.b<g.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f54497a;

        C1078a(g gVar) {
            this.f54497a = gVar;
        }

        @Override // rx.functions.b
        public void call(g.c<T> cVar) {
            Object c6 = this.f54497a.c();
            if (c6 == null || v.f(c6)) {
                cVar.onCompleted();
            } else if (v.g(c6)) {
                cVar.onError(v.d(c6));
            } else {
                cVar.f54558a.setProducer(new SingleProducer(cVar.f54558a, v.e(c6)));
            }
        }
    }

    public static <T> a<T> y7() {
        g gVar = new g();
        gVar.f54550e = new C1078a(gVar);
        return new a<>(gVar, gVar);
    }

    public T A7() {
        Object obj = this.f54496c;
        if (v.g(this.f54495b.c()) || !v.h(obj)) {
            return null;
        }
        return (T) v.e(obj);
    }

    public boolean B7() {
        Object c6 = this.f54495b.c();
        return (c6 == null || v.g(c6)) ? false : true;
    }

    public boolean C7() {
        return v.g(this.f54495b.c());
    }

    public boolean D7() {
        return !v.g(this.f54495b.c()) && v.h(this.f54496c);
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f54495b.f54547b) {
            Object obj = this.f54496c;
            if (obj == null) {
                obj = v.b();
            }
            for (g.c<T> cVar : this.f54495b.h(obj)) {
                if (obj == v.b()) {
                    cVar.onCompleted();
                } else {
                    cVar.f54558a.setProducer(new SingleProducer(cVar.f54558a, v.e(obj)));
                }
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f54495b.f54547b) {
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f54495b.h(v.c(th))) {
                try {
                    cVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54495b.e().length > 0;
    }

    public Throwable z7() {
        Object c6 = this.f54495b.c();
        if (v.g(c6)) {
            return v.d(c6);
        }
        return null;
    }

    protected a(e.a<T> aVar, g<T> gVar) {
        super(aVar);
        this.f54495b = gVar;
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54496c = v.j(t5);
    }
}
