package org.hamcrest.core;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class r extends org.hamcrest.o<String> {

    /* renamed from: c, reason: collision with root package name */
    protected final String f51298c;

    protected abstract boolean g(String str);

    protected abstract String i();

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("a string ").b(i()).b(" ").c(this.f51298c);
    }

    @Override // org.hamcrest.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(String str, org.hamcrest.g gVar) {
        gVar.b("was \"").b(str).b("\"");
    }

    protected r(String str) {
        this.f51298c = str;
    }

    @Override // org.hamcrest.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean e(String str) {
        return g(str);
    }
}
