package org.junit.runners;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.e;
import org.junit.rules.f;
import org.junit.rules.l;
import org.junit.runner.Description;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends d<org.junit.runners.model.d> {

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<org.junit.runners.model.d, Description> f51537f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends org.junit.internal.runners.model.b {
        a() throws Exception {
        }

        @Override // org.junit.internal.runners.model.b
        protected Object b() throws Throwable {
            return b.this.G();
        }
    }

    private Class<? extends Throwable> J(Test test) {
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    private long M(Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    private void Y(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f51423g.i(s(), list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.d
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public Description n(org.junit.runners.model.d dVar) {
        Description description = this.f51537f.get(dVar);
        if (description != null) {
            return description;
        }
        Description createTestDescription = Description.createTestDescription(s().j(), U(dVar), dVar.getAnnotations());
        this.f51537f.putIfAbsent(dVar, createTestDescription);
        return createTestDescription;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.d
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public boolean t(org.junit.runners.model.d dVar) {
        return dVar.getAnnotation(Ignore.class) != null;
    }

    protected h P(org.junit.runners.model.d dVar) {
        try {
            Object a6 = new a().a();
            return h0(dVar, a6, d0(dVar, a6, e0(dVar, a6, g0(dVar, a6, R(dVar, a6, Q(dVar, a6))))));
        } catch (Throwable th) {
            return new org.junit.internal.runners.statements.b(th);
        }
    }

    protected h Q(org.junit.runners.model.d dVar, Object obj) {
        return new org.junit.internal.runners.statements.d(dVar, obj);
    }

    protected h R(org.junit.runners.model.d dVar, Object obj, h hVar) {
        Test test = (Test) dVar.getAnnotation(Test.class);
        return I(test) ? new org.junit.internal.runners.statements.a(hVar, J(test)) : hVar;
    }

    protected void W(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f51421e.i(s(), list);
    }

    @Deprecated
    protected void X(List<Throwable> list) {
        B(After.class, false, list);
        B(Before.class, false, list);
        b0(list);
        if (F().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    protected void b0(List<Throwable> list) {
        B(Test.class, false, list);
    }

    @Deprecated
    protected h g0(org.junit.runners.model.d dVar, Object obj, h hVar) {
        long M = M((Test) dVar.getAnnotation(Test.class));
        return M <= 0 ? hVar : org.junit.internal.runners.statements.c.c().f(M, TimeUnit.MILLISECONDS).d(hVar);
    }

    public b(Class<?> cls) throws InitializationError {
        super(cls);
        this.f51537f = new ConcurrentHashMap<>();
    }

    private boolean I(Test test) {
        if (J(test) != null) {
            return true;
        }
        return false;
    }

    private List<f> K(Object obj) {
        return S(obj);
    }

    private boolean N() {
        if (s().j().getConstructors().length == 1) {
            return true;
        }
        return false;
    }

    private h f0(org.junit.runners.model.d dVar, List<l> list, Object obj, h hVar) {
        for (f fVar : K(obj)) {
            if (!list.contains(fVar)) {
                hVar = fVar.a(hVar, dVar, obj);
            }
        }
        return hVar;
    }

    private h h0(org.junit.runners.model.d dVar, Object obj, h hVar) {
        List<l> L = L(obj);
        return i0(dVar, L, f0(dVar, L, obj, hVar));
    }

    private h i0(org.junit.runners.model.d dVar, List<l> list, h hVar) {
        if (list.isEmpty()) {
            return hVar;
        }
        return new org.junit.rules.h(hVar, list, n(dVar));
    }

    protected List<org.junit.runners.model.d> F() {
        return s().i(Test.class);
    }

    protected Object G() throws Exception {
        return s().l().newInstance(null);
    }

    protected List<l> L(Object obj) {
        List<l> g6 = s().g(obj, Rule.class, l.class);
        g6.addAll(s().c(obj, Rule.class, l.class));
        return g6;
    }

    protected List<f> S(Object obj) {
        List<f> g6 = s().g(obj, Rule.class, f.class);
        g6.addAll(s().c(obj, Rule.class, f.class));
        return g6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.d
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void u(org.junit.runners.model.d dVar, org.junit.runner.notification.a aVar) {
        Description n6 = n(dVar);
        if (t(dVar)) {
            aVar.i(n6);
        } else {
            w(P(dVar), n6, aVar);
        }
    }

    protected String U(org.junit.runners.model.d dVar) {
        return dVar.c();
    }

    protected void V(List<Throwable> list) {
        a0(list);
        c0(list);
    }

    protected void Z(List<Throwable> list) {
        if (s().o()) {
            list.add(new Exception("The inner class " + s().k() + " is not static."));
        }
    }

    protected void a0(List<Throwable> list) {
        if (!N()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    protected void c0(List<Throwable> list) {
        if (!s().o() && N() && s().l().getParameterTypes().length != 0) {
            list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
        }
    }

    protected h d0(org.junit.runners.model.d dVar, Object obj, h hVar) {
        List<org.junit.runners.model.d> i6 = s().i(After.class);
        if (i6.isEmpty()) {
            return hVar;
        }
        return new e(hVar, i6, obj);
    }

    protected h e0(org.junit.runners.model.d dVar, Object obj, h hVar) {
        List<org.junit.runners.model.d> i6 = s().i(Before.class);
        if (i6.isEmpty()) {
            return hVar;
        }
        return new org.junit.internal.runners.statements.f(hVar, i6, obj);
    }

    @Override // org.junit.runners.d
    protected void k(List<Throwable> list) {
        super.k(list);
        Z(list);
        V(list);
        X(list);
        W(list);
        Y(list);
    }

    @Override // org.junit.runners.d
    protected List<org.junit.runners.model.d> o() {
        return F();
    }
}
