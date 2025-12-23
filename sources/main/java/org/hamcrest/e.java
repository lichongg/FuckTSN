package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class e<T> extends b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f51299a;

    @Override // org.hamcrest.l
    public final void describeTo(g gVar) {
        gVar.b(this.f51299a);
    }

    public e(String str) {
        if (str != null) {
            this.f51299a = str;
            return;
        }
        throw new IllegalArgumentException("Description should be non null!");
    }
}
