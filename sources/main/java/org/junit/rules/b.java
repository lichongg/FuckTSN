package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.junit.runners.model.MultipleFailureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends p {

    /* renamed from: a, reason: collision with root package name */
    private List<Throwable> f51453a = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callable<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f51454a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f51455b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.hamcrest.j f51456c;

        a(String str, Object obj, org.hamcrest.j jVar) {
            this.f51454a = str;
            this.f51455b = obj;
            this.f51456c = jVar;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            org.junit.a.X(this.f51454a, this.f51455b, this.f51456c);
            return this.f51455b;
        }
    }

    @Override // org.junit.rules.p
    protected void b() throws Throwable {
        MultipleFailureException.assertEmpty(this.f51453a);
    }

    public void c(Throwable th) {
        this.f51453a.add(th);
    }

    public <T> void e(T t5, org.hamcrest.j<T> jVar) {
        f("", t5, jVar);
    }

    public <T> void f(String str, T t5, org.hamcrest.j<T> jVar) {
        d(new a(str, t5, jVar));
    }

    public <T> T d(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable th) {
            c(th);
            return null;
        }
    }
}
