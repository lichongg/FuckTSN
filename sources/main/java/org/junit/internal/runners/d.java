package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import junit.framework.AssertionFailedError;
import junit.framework.k;
import org.junit.runner.Description;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends org.junit.runner.g implements org.junit.runner.manipulation.b, org.junit.runner.manipulation.c {

    /* renamed from: a, reason: collision with root package name */
    private volatile junit.framework.f f51397a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements junit.framework.i {

        /* renamed from: a, reason: collision with root package name */
        private final org.junit.runner.notification.a f51398a;

        /* synthetic */ b(org.junit.runner.notification.a aVar, a aVar2) {
            this(aVar);
        }

        private b(org.junit.runner.notification.a aVar) {
            this.f51398a = aVar;
        }

        private Description e(junit.framework.f fVar) {
            return fVar instanceof org.junit.runner.b ? ((org.junit.runner.b) fVar).getDescription() : Description.createTestDescription(f(fVar), g(fVar));
        }

        private String g(junit.framework.f fVar) {
            return fVar instanceof junit.framework.g ? ((junit.framework.g) fVar).P() : fVar.toString();
        }

        @Override // junit.framework.i
        public void a(junit.framework.f fVar, Throwable th) {
            this.f51398a.f(new Failure(e(fVar), th));
        }

        @Override // junit.framework.i
        public void c(junit.framework.f fVar) {
            this.f51398a.h(e(fVar));
        }

        @Override // junit.framework.i
        public void d(junit.framework.f fVar) {
            this.f51398a.l(e(fVar));
        }

        private Class<? extends junit.framework.f> f(junit.framework.f fVar) {
            return fVar.getClass();
        }

        @Override // junit.framework.i
        public void b(junit.framework.f fVar, AssertionFailedError assertionFailedError) {
            a(fVar, assertionFailedError);
        }
    }

    public d(Class<?> cls) {
        this(new k(cls.asSubclass(junit.framework.g.class)));
    }

    public d(junit.framework.f fVar) {
        j(fVar);
    }

    private junit.framework.f h() {
        return this.f51397a;
    }

    private static Description i(junit.framework.f fVar) {
        if (fVar instanceof junit.framework.g) {
            junit.framework.g gVar = (junit.framework.g) fVar;
            return Description.createTestDescription(gVar.getClass(), gVar.P(), g(gVar));
        }
        if (!(fVar instanceof k)) {
            return fVar instanceof org.junit.runner.b ? ((org.junit.runner.b) fVar).getDescription() : fVar instanceof junit.extensions.c ? i(((junit.extensions.c) fVar).P()) : Description.createSuiteDescription(fVar.getClass());
        }
        k kVar = (k) fVar;
        Description createSuiteDescription = Description.createSuiteDescription(kVar.i() == null ? f(kVar) : kVar.i(), new Annotation[0]);
        int q5 = kVar.q();
        for (int i6 = 0; i6 < q5; i6++) {
            createSuiteDescription.addChild(i(kVar.o(i6)));
        }
        return createSuiteDescription;
    }

    private void j(junit.framework.f fVar) {
        this.f51397a = fVar;
    }

    @Override // org.junit.runner.g
    public void a(org.junit.runner.notification.a aVar) {
        junit.framework.j jVar = new junit.framework.j();
        jVar.c(e(aVar));
        h().a(jVar);
    }

    public junit.framework.i e(org.junit.runner.notification.a aVar) {
        return new b(aVar, null);
    }

    private static String f(k kVar) {
        String format;
        int c6 = kVar.c();
        if (c6 == 0) {
            format = "";
        } else {
            format = String.format(" [example: %s]", kVar.o(0));
        }
        return String.format("TestSuite with %s tests%s", Integer.valueOf(c6), format);
    }

    private static Annotation[] g(junit.framework.g gVar) {
        try {
            return gVar.getClass().getMethod(gVar.P(), null).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    @Override // org.junit.runner.manipulation.b
    public void b(org.junit.runner.manipulation.a aVar) throws NoTestsRemainException {
        if (h() instanceof org.junit.runner.manipulation.b) {
            ((org.junit.runner.manipulation.b) h()).b(aVar);
            return;
        }
        if (h() instanceof k) {
            k kVar = (k) h();
            k kVar2 = new k(kVar.i());
            int q5 = kVar.q();
            for (int i6 = 0; i6 < q5; i6++) {
                junit.framework.f o5 = kVar.o(i6);
                if (aVar.e(i(o5))) {
                    kVar2.b(o5);
                }
            }
            j(kVar2);
            if (kVar2.q() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.manipulation.c
    public void d(org.junit.runner.manipulation.d dVar) {
        if (h() instanceof org.junit.runner.manipulation.c) {
            ((org.junit.runner.manipulation.c) h()).d(dVar);
        }
    }

    @Override // org.junit.runner.g, org.junit.runner.b
    public Description getDescription() {
        return i(h());
    }
}
