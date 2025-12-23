package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.d;
import org.junit.runners.model.h;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends org.junit.runners.b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends h {

        /* renamed from: b, reason: collision with root package name */
        private final d f51362b;

        /* renamed from: c, reason: collision with root package name */
        private final i f51363c;

        /* renamed from: a, reason: collision with root package name */
        private int f51361a = 0;

        /* renamed from: d, reason: collision with root package name */
        private List<AssumptionViolatedException> f51364d = new ArrayList();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: org.junit.experimental.theories.c$a$a, reason: collision with other inner class name */
        class C0986a extends org.junit.runners.b {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ org.junit.experimental.theories.internal.b f51365g;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: org.junit.experimental.theories.c$a$a$a, reason: collision with other inner class name */
            class C0987a extends h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ h f51367a;

                C0987a(h hVar) throws Throwable {
                    this.f51367a = hVar;
                }

                @Override // org.junit.runners.model.h
                public void a() throws Throwable {
                    try {
                        this.f51367a.a();
                        a.this.f();
                    } catch (AssumptionViolatedException e6) {
                        a.this.e(e6);
                    } catch (Throwable th) {
                        C0986a c0986a = C0986a.this;
                        a aVar = a.this;
                        aVar.i(th, c0986a.f51365g.g(aVar.h()));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0986a(Class cls, org.junit.experimental.theories.internal.b bVar) throws Throwable {
                super(cls);
                this.f51365g = bVar;
            }

            @Override // org.junit.runners.b
            public Object G() throws Exception {
                Object[] h6 = this.f51365g.h();
                if (!a.this.h()) {
                    org.junit.b.e(h6);
                }
                return s().l().newInstance(h6);
            }

            @Override // org.junit.runners.b
            protected h Q(d dVar, Object obj) {
                return a.this.g(dVar, this.f51365g, obj);
            }

            @Override // org.junit.runners.b
            public h P(d dVar) {
                return new C0987a(super.P(dVar));
            }

            @Override // org.junit.runners.b, org.junit.runners.d
            protected void k(List<Throwable> list) {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b extends h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ org.junit.experimental.theories.internal.b f51369a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f51370b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f51371c;

            b(org.junit.experimental.theories.internal.b bVar, d dVar, Object obj) throws Throwable {
                this.f51369a = bVar;
                this.f51370b = dVar;
                this.f51371c = obj;
            }

            @Override // org.junit.runners.model.h
            public void a() throws Throwable {
                Object[] j6 = this.f51369a.j();
                if (!a.this.h()) {
                    org.junit.b.e(j6);
                }
                this.f51370b.l(this.f51371c, j6);
            }
        }

        protected void i(Throwable th, Object... objArr) throws Throwable {
            if (objArr.length != 0) {
                throw new ParameterizedAssertionError(th, this.f51362b.c(), objArr);
            }
            throw th;
        }

        private i d() {
            return this.f51363c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public h g(d dVar, org.junit.experimental.theories.internal.b bVar, Object obj) {
            return new b(bVar, dVar, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h() {
            Theory theory = (Theory) this.f51362b.i().getAnnotation(Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        @Override // org.junit.runners.model.h
        public void a() throws Throwable {
            j(org.junit.experimental.theories.internal.b.a(this.f51362b.i(), d()));
            boolean z5 = this.f51362b.getAnnotation(Theory.class) != null;
            if (this.f51361a == 0 && z5) {
                org.junit.a.d0("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.f51364d);
            }
        }

        protected void e(AssumptionViolatedException assumptionViolatedException) {
            this.f51364d.add(assumptionViolatedException);
        }

        protected void f() {
            this.f51361a++;
        }

        protected void k(org.junit.experimental.theories.internal.b bVar) throws Throwable {
            new C0986a(d().j(), bVar).P(this.f51362b).a();
        }

        public a(d dVar, i iVar) {
            this.f51362b = dVar;
            this.f51363c = iVar;
        }

        protected void j(org.junit.experimental.theories.internal.b bVar) throws Throwable {
            if (!bVar.l()) {
                l(bVar);
            } else {
                k(bVar);
            }
        }

        protected void l(org.junit.experimental.theories.internal.b bVar) throws Throwable {
            Iterator<PotentialAssignment> it = bVar.n().iterator();
            while (it.hasNext()) {
                j(bVar.b(it.next()));
            }
        }
    }

    @Override // org.junit.runners.b
    protected List<d> F() {
        ArrayList arrayList = new ArrayList(super.F());
        List<d> i6 = s().i(Theory.class);
        arrayList.removeAll(i6);
        arrayList.addAll(i6);
        return arrayList;
    }

    @Override // org.junit.runners.b
    public h P(d dVar) {
        return new a(dVar, s());
    }

    public c(Class<?> cls) throws InitializationError {
        super(cls);
    }

    private void j0(List<Throwable> list) {
        for (Field field : s().j().getDeclaredFields()) {
            if (field.getAnnotation(DataPoint.class) != null || field.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    private void k0(List<Throwable> list) {
        for (Method method : s().j().getDeclaredMethods()) {
            if (method.getAnnotation(DataPoint.class) != null || method.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    private void l0(Class<? extends b> cls, List<Throwable> list) {
        Constructor<?>[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class<?>[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length != 0 && !parameterTypes[0].equals(i.class)) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
        }
    }

    @Override // org.junit.runners.b
    protected void V(List<Throwable> list) {
        a0(list);
    }

    @Override // org.junit.runners.b
    protected void b0(List<Throwable> list) {
        for (d dVar : F()) {
            if (dVar.getAnnotation(Theory.class) != null) {
                dVar.p(false, list);
                dVar.o(list);
            } else {
                dVar.q(false, list);
            }
            Iterator<org.junit.experimental.theories.a> it = org.junit.experimental.theories.a.l(dVar.i()).iterator();
            while (it.hasNext()) {
                ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) it.next().e(ParametersSuppliedBy.class);
                if (parametersSuppliedBy != null) {
                    l0(parametersSuppliedBy.value(), list);
                }
            }
        }
    }

    @Override // org.junit.runners.b, org.junit.runners.d
    protected void k(List<Throwable> list) {
        super.k(list);
        j0(list);
        k0(list);
    }
}
