package org.junit.internal.matchers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.hamcrest.Factory;
import org.hamcrest.g;
import org.hamcrest.j;
import org.hamcrest.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a<T extends Throwable> extends o<T> {

    /* renamed from: c, reason: collision with root package name */
    private final j<T> f51387c;

    @Factory
    public static <T extends Exception> j<T> g(j<T> jVar) {
        return new a(jVar);
    }

    @Factory
    public static <T extends Throwable> j<T> h(j<T> jVar) {
        return new a(jVar);
    }

    private String j(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // org.hamcrest.l
    public void describeTo(g gVar) {
        this.f51387c.describeTo(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(T t5, g gVar) {
        this.f51387c.b(t5, gVar);
        gVar.b("\nStacktrace was: ");
        gVar.b(j(t5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.o
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean e(T t5) {
        return this.f51387c.c(t5);
    }

    public a(j<T> jVar) {
        this.f51387c = jVar;
    }
}
