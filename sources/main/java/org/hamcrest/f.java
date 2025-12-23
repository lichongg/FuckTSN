package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class f<T> extends o<T> {

    /* renamed from: c, reason: collision with root package name */
    private final String f51300c;

    @Override // org.hamcrest.l
    public final void describeTo(g gVar) {
        gVar.b(this.f51300c);
    }

    public f(String str) {
        if (str != null) {
            this.f51300c = str;
            return;
        }
        throw new IllegalArgumentException("Description must be non null!");
    }
}
