package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.statements.f;
import org.junit.rules.l;
import org.junit.runner.Description;
import org.junit.runner.g;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.h;
import org.junit.runners.model.i;
import org.junit.validator.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class d<T> extends g implements org.junit.runner.manipulation.b, org.junit.runner.manipulation.c {

    /* renamed from: e, reason: collision with root package name */
    private static final List<e> f51539e = Arrays.asList(new org.junit.validator.c(), new org.junit.validator.d());

    /* renamed from: b, reason: collision with root package name */
    private final i f51541b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f51540a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private volatile Collection<T> f51542c = null;

    /* renamed from: d, reason: collision with root package name */
    private volatile org.junit.runners.model.g f51543d = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements org.junit.runners.model.g {
        a() {
        }

        @Override // org.junit.runners.model.g
        public void a(Runnable runnable) {
            runnable.run();
        }

        @Override // org.junit.runners.model.g
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.a f51545a;

        b(org.junit.runner.notification.a aVar) {
            this.f51545a = aVar;
        }

        @Override // org.junit.runners.model.h
        public void a() {
            d.this.v(this.f51545a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f51547a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.a f51548b;

        c(Object obj, org.junit.runner.notification.a aVar) {
            this.f51547a = obj;
            this.f51548b = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            d.this.u(this.f51547a, this.f51548b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.runners.d$d, reason: collision with other inner class name */
    class C0995d implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.manipulation.d f51550a;

        C0995d(org.junit.runner.manipulation.d dVar) {
            this.f51550a = dVar;
        }

        @Override // java.util.Comparator
        public int compare(T t5, T t6) {
            return this.f51550a.compare(d.this.n(t5), d.this.n(t6));
        }
    }

    protected abstract Description n(T t5);

    protected abstract List<T> o();

    protected boolean t(T t5) {
        return false;
    }

    protected abstract void u(T t5, org.junit.runner.notification.a aVar);

    private void A(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f51420d.i(s(), list);
        org.junit.internal.runners.rules.a.f51422f.i(s(), list);
    }

    private Comparator<? super T> l(org.junit.runner.manipulation.d dVar) {
        return new C0995d(dVar);
    }

    private Collection<T> p() {
        if (this.f51542c == null) {
            synchronized (this.f51540a) {
                try {
                    if (this.f51542c == null) {
                        this.f51542c = Collections.unmodifiableCollection(o());
                    }
                } finally {
                }
            }
        }
        return this.f51542c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(org.junit.runner.notification.a aVar) {
        org.junit.runners.model.g gVar = this.f51543d;
        try {
            Iterator<T> it = p().iterator();
            while (it.hasNext()) {
                gVar.a(new c(it.next(), aVar));
            }
        } finally {
            gVar.b();
        }
    }

    private void z() throws InitializationError {
        ArrayList arrayList = new ArrayList();
        k(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InitializationError(arrayList);
        }
    }

    protected h C(h hVar) {
        List<org.junit.runners.model.d> i6 = this.f51541b.i(AfterClass.class);
        return i6.isEmpty() ? hVar : new org.junit.internal.runners.statements.e(hVar, i6, null);
    }

    protected h D(h hVar) {
        List<org.junit.runners.model.d> i6 = this.f51541b.i(BeforeClass.class);
        return i6.isEmpty() ? hVar : new f(hVar, i6, null);
    }

    @Override // org.junit.runner.g
    public void a(org.junit.runner.notification.a aVar) {
        org.junit.internal.runners.model.a aVar2 = new org.junit.internal.runners.model.a(aVar, getDescription());
        try {
            i(aVar).a();
        } catch (AssumptionViolatedException e6) {
            aVar2.a(e6);
        } catch (StoppedByUserException e7) {
            throw e7;
        } catch (Throwable th) {
            aVar2.b(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.b
    public void b(org.junit.runner.manipulation.a aVar) throws NoTestsRemainException {
        synchronized (this.f51540a) {
            ArrayList arrayList = new ArrayList(p());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (y(aVar, next)) {
                    try {
                        aVar.a(next);
                    } catch (NoTestsRemainException unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.f51542c = Collections.unmodifiableCollection(arrayList);
            if (this.f51542c.isEmpty()) {
                throw new NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.manipulation.c
    public void d(org.junit.runner.manipulation.d dVar) {
        synchronized (this.f51540a) {
            try {
                Iterator<T> it = p().iterator();
                while (it.hasNext()) {
                    dVar.a(it.next());
                }
                ArrayList arrayList = new ArrayList(p());
                Collections.sort(arrayList, l(dVar));
                this.f51542c = Collections.unmodifiableCollection(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected h h(org.junit.runner.notification.a aVar) {
        return new b(aVar);
    }

    protected List<l> j() {
        List<l> g6 = this.f51541b.g(null, ClassRule.class, l.class);
        g6.addAll(this.f51541b.c(null, ClassRule.class, l.class));
        return g6;
    }

    protected void k(List<Throwable> list) {
        B(BeforeClass.class, true, list);
        B(AfterClass.class, true, list);
        A(list);
        f(list);
    }

    protected i m(Class<?> cls) {
        return new i(cls);
    }

    protected String q() {
        return this.f51541b.k();
    }

    protected Annotation[] r() {
        return this.f51541b.getAnnotations();
    }

    public final i s() {
        return this.f51541b;
    }

    protected final void w(h hVar, Description description, org.junit.runner.notification.a aVar) {
        org.junit.internal.runners.model.a aVar2 = new org.junit.internal.runners.model.a(aVar, description);
        aVar2.f();
        try {
            try {
                try {
                    hVar.a();
                    aVar2.d();
                } catch (Throwable th) {
                    aVar2.b(th);
                    aVar2.d();
                }
            } catch (AssumptionViolatedException e6) {
                aVar2.a(e6);
                aVar2.d();
            }
        } catch (Throwable th2) {
            aVar2.d();
            throw th2;
        }
    }

    public void x(org.junit.runners.model.g gVar) {
        this.f51543d = gVar;
    }

    protected d(Class<?> cls) throws InitializationError {
        this.f51541b = m(cls);
        z();
    }

    private h E(h hVar) {
        List<l> j6 = j();
        if (j6.isEmpty()) {
            return hVar;
        }
        return new org.junit.rules.h(hVar, j6, getDescription());
    }

    private void f(List<Throwable> list) {
        if (s().j() != null) {
            Iterator<e> it = f51539e.iterator();
            while (it.hasNext()) {
                list.addAll(it.next().a(s()));
            }
        }
    }

    private boolean g() {
        Iterator<T> it = p().iterator();
        while (it.hasNext()) {
            if (!t(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean y(org.junit.runner.manipulation.a aVar, T t5) {
        return aVar.e(n(t5));
    }

    protected void B(Class<? extends Annotation> cls, boolean z5, List<Throwable> list) {
        Iterator<org.junit.runners.model.d> it = s().i(cls).iterator();
        while (it.hasNext()) {
            it.next().q(z5, list);
        }
    }

    @Override // org.junit.runner.g, org.junit.runner.b
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(q(), r());
        Iterator<T> it = p().iterator();
        while (it.hasNext()) {
            createSuiteDescription.addChild(n(it.next()));
        }
        return createSuiteDescription;
    }

    protected h i(org.junit.runner.notification.a aVar) {
        h h6 = h(aVar);
        if (!g()) {
            return E(C(D(h6)));
        }
        return h6;
    }
}
