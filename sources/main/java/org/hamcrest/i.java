package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class i<T, U> extends n<T> {

    /* renamed from: f, reason: collision with root package name */
    private static final org.hamcrest.internal.b f51302f = new org.hamcrest.internal.b("featureValueOf", 1, 0);

    /* renamed from: c, reason: collision with root package name */
    private final j<? super U> f51303c;

    /* renamed from: d, reason: collision with root package name */
    private final String f51304d;

    /* renamed from: e, reason: collision with root package name */
    private final String f51305e;

    protected abstract U e(T t5);

    public i(j<? super U> jVar, String str, String str2) {
        super(f51302f);
        this.f51303c = jVar;
        this.f51304d = str;
        this.f51305e = str2;
    }

    @Override // org.hamcrest.l
    public final void describeTo(g gVar) {
        gVar.b(this.f51304d).b(" ").f(this.f51303c);
    }

    @Override // org.hamcrest.n
    protected boolean d(T t5, g gVar) {
        U e6 = e(t5);
        if (!this.f51303c.c(e6)) {
            gVar.b(this.f51305e).b(" ");
            this.f51303c.b(e6, gVar);
            return false;
        }
        return true;
    }
}
