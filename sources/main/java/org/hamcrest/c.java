package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final C0981c<Object> f51277a = new C0981c<>(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b<T> extends c<T> {

        /* renamed from: b, reason: collision with root package name */
        private final T f51278b;

        /* renamed from: c, reason: collision with root package name */
        private final g f51279c;

        /* synthetic */ b(Object obj, g gVar, a aVar) {
            this(obj, gVar);
        }

        private b(T t5, g gVar) {
            super(null);
            this.f51278b = t5;
            this.f51279c = gVar;
        }

        @Override // org.hamcrest.c
        public <U> c<U> a(d<? super T, U> dVar) {
            return dVar.a(this.f51278b, this.f51279c);
        }

        @Override // org.hamcrest.c
        public boolean d(j<T> jVar, String str) {
            if (jVar.c(this.f51278b)) {
                return true;
            }
            this.f51279c.b(str);
            jVar.b(this.f51278b, this.f51279c);
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.hamcrest.c$c, reason: collision with other inner class name */
    private static final class C0981c<T> extends c<T> {
        private C0981c() {
            super(null);
        }

        @Override // org.hamcrest.c
        public boolean d(j<T> jVar, String str) {
            return false;
        }

        /* synthetic */ C0981c(a aVar) {
            this();
        }

        @Override // org.hamcrest.c
        public <U> c<U> a(d<? super T, U> dVar) {
            return c.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d<I, O> {
        c<O> a(I i6, g gVar);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public abstract <U> c<U> a(d<? super T, U> dVar);

    public abstract boolean d(j<T> jVar, String str);

    private c() {
    }

    public static <T> c<T> b(T t5, g gVar) {
        return new b(t5, gVar, null);
    }

    public static <T> c<T> e() {
        return f51277a;
    }

    public final boolean c(j<T> jVar) {
        return d(jVar, "");
    }

    public final <U> c<U> f(d<? super T, U> dVar) {
        return a(dVar);
    }
}
