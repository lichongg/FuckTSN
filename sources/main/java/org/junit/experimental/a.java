package org.junit.experimental;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.runners.d;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.f;
import org.junit.runners.model.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends org.junit.runner.a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f51334a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f51335b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.experimental.a$a, reason: collision with other inner class name */
    static class C0982a implements g {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f51336a = Executors.newCachedThreadPool();

        @Override // org.junit.runners.model.g
        public void a(Runnable runnable) {
            this.f51336a.submit(runnable);
        }

        @Override // org.junit.runners.model.g
        public void b() {
            try {
                this.f51336a.shutdown();
                this.f51336a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e6) {
                e6.printStackTrace(System.err);
            }
        }

        C0982a() {
        }
    }

    public static org.junit.runner.a d() {
        return new a(true, false);
    }

    public static org.junit.runner.a e() {
        return new a(false, true);
    }

    private static org.junit.runner.g f(org.junit.runner.g gVar) {
        if (gVar instanceof d) {
            ((d) gVar).x(new C0982a());
        }
        return gVar;
    }

    public a(boolean z5, boolean z6) {
        this.f51334a = z5;
        this.f51335b = z6;
    }

    @Override // org.junit.runner.a
    protected org.junit.runner.g a(f fVar, Class<?> cls) throws Throwable {
        org.junit.runner.g a6 = super.a(fVar, cls);
        if (this.f51335b) {
            return f(a6);
        }
        return a6;
    }

    @Override // org.junit.runner.a
    public org.junit.runner.g b(f fVar, Class<?>[] clsArr) throws InitializationError {
        org.junit.runner.g b6 = super.b(fVar, clsArr);
        if (this.f51334a) {
            return f(b6);
        }
        return b6;
    }
}
