package org.junit.runner;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.runner.a$a, reason: collision with other inner class name */
    class C0992a extends org.junit.runners.model.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.f f51500b;

        C0992a(org.junit.runners.model.f fVar) throws Throwable {
            this.f51500b = fVar;
        }

        @Override // org.junit.runners.model.f
        public g c(Class<?> cls) throws Throwable {
            return a.this.a(this.f51500b, cls);
        }
    }

    public static a c() {
        return new a();
    }

    public g b(org.junit.runners.model.f fVar, Class<?>[] clsArr) throws InitializationError {
        return new Suite(new C0992a(fVar), clsArr);
    }

    protected g a(org.junit.runners.model.f fVar, Class<?> cls) throws Throwable {
        return fVar.c(cls);
    }
}
