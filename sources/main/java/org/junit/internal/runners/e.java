package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends org.junit.runner.g implements org.junit.runner.manipulation.b, org.junit.runner.manipulation.c {

    /* renamed from: a, reason: collision with root package name */
    private final List<Method> f51399a = i();

    /* renamed from: b, reason: collision with root package name */
    private i f51400b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.a f51401a;

        a(org.junit.runner.notification.a aVar) {
            this.f51401a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.l(this.f51401a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Comparator<Method> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.manipulation.d f51403a;

        b(org.junit.runner.manipulation.d dVar) {
            this.f51403a = dVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            return this.f51403a.compare(e.this.k(method), e.this.k(method2));
        }
    }

    @Override // org.junit.runner.g
    public void a(org.junit.runner.notification.a aVar) {
        new org.junit.internal.runners.a(aVar, this.f51400b, getDescription(), new a(aVar)).d();
    }

    @Override // org.junit.runner.manipulation.b
    public void b(org.junit.runner.manipulation.a aVar) throws NoTestsRemainException {
        Iterator<Method> it = this.f51399a.iterator();
        while (it.hasNext()) {
            if (!aVar.e(k(it.next()))) {
                it.remove();
            }
        }
        if (this.f51399a.isEmpty()) {
            throw new NoTestsRemainException();
        }
    }

    @Override // org.junit.runner.manipulation.c
    public void d(org.junit.runner.manipulation.d dVar) {
        Collections.sort(this.f51399a, new b(dVar));
    }

    protected Annotation[] e() {
        return this.f51400b.e().getAnnotations();
    }

    protected i h() {
        return this.f51400b;
    }

    protected List<Method> i() {
        return this.f51400b.h();
    }

    protected void l(org.junit.runner.notification.a aVar) {
        Iterator<Method> it = this.f51399a.iterator();
        while (it.hasNext()) {
            j(it.next(), aVar);
        }
    }

    protected void p() throws InitializationError {
        g gVar = new g(this.f51400b);
        gVar.c();
        gVar.a();
    }

    protected j q(Method method) {
        return new j(method, this.f51400b);
    }

    public e(Class<?> cls) throws InitializationError {
        this.f51400b = new i(cls);
        p();
    }

    private void m(org.junit.runner.notification.a aVar, Description description, Throwable th) {
        aVar.l(description);
        aVar.f(new Failure(description, th));
        aVar.h(description);
    }

    protected Object f() throws Exception {
        return h().d().newInstance(null);
    }

    protected String g() {
        return h().f();
    }

    @Override // org.junit.runner.g, org.junit.runner.b
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(g(), e());
        Iterator<Method> it = this.f51399a.iterator();
        while (it.hasNext()) {
            createSuiteDescription.addChild(k(it.next()));
        }
        return createSuiteDescription;
    }

    protected void j(Method method, org.junit.runner.notification.a aVar) {
        Description k6 = k(method);
        try {
            new f(f(), q(method), aVar, k6).b();
        } catch (InvocationTargetException e6) {
            m(aVar, k6, e6.getCause());
        } catch (Exception e7) {
            m(aVar, k6, e7);
        }
    }

    protected Description k(Method method) {
        return Description.createTestDescription(h().e(), o(method), n(method));
    }

    protected Annotation[] n(Method method) {
        return method.getAnnotations();
    }

    protected String o(Method method) {
        return method.getName();
    }
}
