package org.junit.rules;

import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements l {

    /* renamed from: a, reason: collision with root package name */
    private final d f51458a = new d();

    /* renamed from: b, reason: collision with root package name */
    private String f51459b = "Expected test to throw %s";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends org.junit.runners.model.h {

        /* renamed from: a, reason: collision with root package name */
        private final org.junit.runners.model.h f51460a;

        public a(org.junit.runners.model.h hVar) {
            this.f51460a = hVar;
        }

        @Override // org.junit.runners.model.h
        public void a() throws Throwable {
            try {
                this.f51460a.a();
                if (c.this.n()) {
                    c.this.j();
                }
            } catch (Throwable th) {
                c.this.m(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return this.f51458a.f();
    }

    private String o() {
        return String.format(this.f51459b, org.hamcrest.m.o(this.f51458a.c()));
    }

    public static c p() {
        return new c();
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        return new a(hVar);
    }

    public void f(org.hamcrest.j<?> jVar) {
        this.f51458a.a(jVar);
    }

    public c q(String str) {
        this.f51459b = str;
        return this;
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws AssertionError {
        org.junit.a.d0(o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Throwable th) throws Throwable {
        if (n()) {
            org.junit.a.W(th, this.f51458a.c());
            return;
        }
        throw th;
    }

    public void e(Class<? extends Throwable> cls) {
        f(org.hamcrest.d.C(cls));
    }

    public void g(org.hamcrest.j<? extends Throwable> jVar) {
        f(org.junit.internal.matchers.b.g(jVar));
    }

    public void h(String str) {
        i(org.hamcrest.d.s(str));
    }

    public void i(org.hamcrest.j<String> jVar) {
        f(org.junit.internal.matchers.c.g(jVar));
    }

    @Deprecated
    public c k() {
        return this;
    }

    @Deprecated
    public c l() {
        return this;
    }
}
