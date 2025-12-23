package org.junit.runner;

import java.io.PrintStream;
import org.junit.internal.h;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final org.junit.runner.notification.a f51504a = new org.junit.runner.notification.a();

    static a b() {
        return new a();
    }

    public static void d(String... strArr) {
        System.exit(!new e().m(new org.junit.internal.g(), strArr).wasSuccessful() ? 1 : 0);
    }

    public static Result k(a aVar, Class<?>... clsArr) {
        return new e().g(aVar, clsArr);
    }

    public void a(RunListener runListener) {
        this.f51504a.d(runListener);
    }

    public void e(RunListener runListener) {
        this.f51504a.n(runListener);
    }

    public Result f(junit.framework.f fVar) {
        return i(new org.junit.internal.runners.d(fVar));
    }

    public Result i(g gVar) {
        Result result = new Result();
        RunListener createListener = result.createListener();
        this.f51504a.c(createListener);
        try {
            this.f51504a.k(gVar.getDescription());
            gVar.a(this.f51504a);
            this.f51504a.j(result);
            return result;
        } finally {
            e(createListener);
        }
    }

    public static Result l(Class<?>... clsArr) {
        return k(b(), clsArr);
    }

    public String c() {
        return junit.runner.c.a();
    }

    public Result g(a aVar, Class<?>... clsArr) {
        return h(f.c(aVar, clsArr));
    }

    public Result h(f fVar) {
        return i(fVar.h());
    }

    public Result j(Class<?>... clsArr) {
        return g(b(), clsArr);
    }

    Result m(org.junit.internal.e eVar, String... strArr) {
        PrintStream b6 = eVar.b();
        junit.runner.c.a();
        b6.getClass();
        JUnitCommandLineParseResult g6 = JUnitCommandLineParseResult.g(strArr);
        a(new h(eVar));
        return h(g6.c(b()));
    }
}
