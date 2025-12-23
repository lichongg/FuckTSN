package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class o<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    private static final org.hamcrest.internal.b f51316b = new org.hamcrest.internal.b("matchesSafely", 1, 0);

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51317a;

    protected o() {
        this(f51316b);
    }

    protected abstract boolean e(T t5);

    protected o(Class<?> cls) {
        this.f51317a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.b, org.hamcrest.j
    public final void b(Object obj, g gVar) {
        if (obj == 0) {
            super.b(obj, gVar);
        } else if (this.f51317a.isInstance(obj)) {
            d(obj, gVar);
        } else {
            gVar.b("was a ").b(obj.getClass().getName()).b(" (").c(obj).b(")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.j
    public final boolean c(Object obj) {
        return obj != 0 && this.f51317a.isInstance(obj) && e(obj);
    }

    protected void d(T t5, g gVar) {
        super.b(t5, gVar);
    }

    protected o(org.hamcrest.internal.b bVar) {
        this.f51317a = bVar.c(getClass());
    }
}
