package org.hamcrest;

import org.hamcrest.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class n<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    private static final org.hamcrest.internal.b f51314b = new org.hamcrest.internal.b("matchesSafely", 2, 0);

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51315a;

    protected n(Class<?> cls) {
        this.f51315a = cls;
    }

    protected abstract boolean d(T t5, g gVar);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.b, org.hamcrest.j
    public final void b(Object obj, g gVar) {
        if (obj == 0 || !this.f51315a.isInstance(obj)) {
            super.b(obj, gVar);
        } else {
            d(obj, gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.j
    public final boolean c(Object obj) {
        return obj != 0 && this.f51315a.isInstance(obj) && d(obj, new g.a());
    }

    protected n(org.hamcrest.internal.b bVar) {
        this.f51315a = bVar.c(getClass());
    }

    protected n() {
        this(f51314b);
    }
}
