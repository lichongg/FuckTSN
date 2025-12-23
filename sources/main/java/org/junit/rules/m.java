package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class m implements l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends org.junit.runners.model.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Description f51475a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.h f51476b;

        a(Description description, org.junit.runners.model.h hVar) throws Exception {
            this.f51475a = description;
            this.f51476b = hVar;
        }

        @Override // org.junit.runners.model.h
        public void a() throws Throwable {
            ArrayList arrayList = new ArrayList();
            m.this.o(this.f51475a, arrayList);
            try {
                try {
                    this.f51476b.a();
                    m.this.q(this.f51475a, arrayList);
                } catch (AssumptionViolatedException e6) {
                    arrayList.add(e6);
                    m.this.m(e6, this.f51475a, arrayList);
                    m.this.j(this.f51475a, arrayList);
                    MultipleFailureException.assertEmpty(arrayList);
                } catch (Throwable th) {
                    arrayList.add(th);
                    m.this.h(th, this.f51475a, arrayList);
                    m.this.j(this.f51475a, arrayList);
                    MultipleFailureException.assertEmpty(arrayList);
                }
                m.this.j(this.f51475a, arrayList);
                MultipleFailureException.assertEmpty(arrayList);
            } catch (Throwable th2) {
                m.this.j(this.f51475a, arrayList);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AssumptionViolatedException assumptionViolatedException, Description description, List<Throwable> list) {
        try {
            if (assumptionViolatedException instanceof org.junit.AssumptionViolatedException) {
                k((org.junit.AssumptionViolatedException) assumptionViolatedException, description);
            } else {
                l(assumptionViolatedException, description);
            }
        } catch (Throwable th) {
            list.add(th);
        }
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        return new a(description, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th, Description description, List<Throwable> list) {
        try {
            g(th, description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Description description, List<Throwable> list) {
        try {
            i(description);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Description description, List<Throwable> list) {
        try {
            n(description);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Description description, List<Throwable> list) {
        try {
            p(description);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    protected void k(org.junit.AssumptionViolatedException assumptionViolatedException, Description description) {
        l(assumptionViolatedException, description);
    }

    protected void i(Description description) {
    }

    protected void n(Description description) {
    }

    protected void p(Description description) {
    }

    protected void g(Throwable th, Description description) {
    }

    @Deprecated
    protected void l(AssumptionViolatedException assumptionViolatedException, Description description) {
    }
}
