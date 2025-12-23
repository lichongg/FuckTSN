package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> implements Iterable<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f52612a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.e f52613b;

        a(Object obj, rx.e eVar) {
            this.f52612a = obj;
            this.f52613b = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            b bVar = new b(this.f52612a);
            this.f52613b.r5(bVar);
            return bVar.g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        volatile Object f52614a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Iterator<T> {

            /* renamed from: a, reason: collision with root package name */
            private Object f52615a;

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f52615a == null) {
                        this.f52615a = b.this.f52614a;
                    }
                    if (v.f(this.f52615a)) {
                        throw new NoSuchElementException();
                    }
                    if (v.g(this.f52615a)) {
                        throw rx.exceptions.a.c(v.d(this.f52615a));
                    }
                    T t5 = (T) v.e(this.f52615a);
                    this.f52615a = null;
                    return t5;
                } catch (Throwable th) {
                    this.f52615a = null;
                    throw th;
                }
            }

            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f52615a = b.this.f52614a;
                return !v.f(r0);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public Iterator<T> g() {
            return new a();
        }

        b(T t5) {
            this.f52614a = v.j(t5);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52614a = v.b();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52614a = v.c(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52614a = v.j(t5);
        }
    }

    public static <T> Iterable<T> a(rx.e<? extends T> eVar, T t5) {
        return new a(t5, eVar);
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }
}
