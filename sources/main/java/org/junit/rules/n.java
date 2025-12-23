package org.junit.rules;

import org.junit.internal.AssumptionViolatedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class n implements f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends org.junit.runners.model.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.d f51478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.h f51479b;

        a(org.junit.runners.model.d dVar, org.junit.runners.model.h hVar) throws Throwable {
            this.f51478a = dVar;
            this.f51479b = hVar;
        }

        @Override // org.junit.runners.model.h
        public void a() throws Throwable {
            n.this.d(this.f51478a);
            try {
                try {
                    try {
                        this.f51479b.a();
                        n.this.e(this.f51478a);
                        n.this.c(this.f51478a);
                    } catch (Throwable th) {
                        n.this.b(th, this.f51478a);
                        throw th;
                    }
                } catch (AssumptionViolatedException e6) {
                    throw e6;
                }
            } catch (Throwable th2) {
                n.this.c(this.f51478a);
                throw th2;
            }
        }
    }

    @Override // org.junit.rules.f
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, org.junit.runners.model.d dVar, Object obj) {
        return new a(dVar, hVar);
    }

    public void c(org.junit.runners.model.d dVar) {
    }

    public void d(org.junit.runners.model.d dVar) {
    }

    public void e(org.junit.runners.model.d dVar) {
    }

    public void b(Throwable th, org.junit.runners.model.d dVar) {
    }
}
