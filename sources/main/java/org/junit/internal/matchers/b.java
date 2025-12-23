package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Factory;
import org.hamcrest.g;
import org.hamcrest.j;
import org.hamcrest.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b<T extends Throwable> extends o<T> {

    /* renamed from: c, reason: collision with root package name */
    private final j<? extends Throwable> f51388c;

    @Factory
    public static <T extends Throwable> j<T> g(j<? extends Throwable> jVar) {
        return new b(jVar);
    }

    @Override // org.hamcrest.l
    public void describeTo(g gVar) {
        gVar.b("exception with cause ");
        gVar.f(this.f51388c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(T t5, g gVar) {
        gVar.b("cause ");
        this.f51388c.b(t5.getCause(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean e(T t5) {
        return this.f51388c.c(t5.getCause());
    }

    public b(j<? extends Throwable> jVar) {
        this.f51388c = jVar;
    }
}
