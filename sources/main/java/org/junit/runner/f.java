package org.junit.runner;

import java.util.Comparator;
import org.junit.runners.model.InitializationError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f51505a;

        a(g gVar) {
            this.f51505a = gVar;
        }

        @Override // org.junit.runner.f
        public g h() {
            return this.f51505a;
        }
    }

    public abstract g h();

    public static f a(Class<?> cls) {
        return new h5.a(cls);
    }

    public static f b(Class<?> cls) {
        return new h5.a(cls, false);
    }

    public static f c(org.junit.runner.a aVar, Class<?>... clsArr) {
        try {
            return j(aVar.b(new org.junit.internal.builders.a(true), clsArr));
        } catch (InitializationError unused) {
            throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
        }
    }

    public static f e(Class<?> cls, Throwable th) {
        return j(new org.junit.internal.runners.b(cls, th));
    }

    public static f j(g gVar) {
        return new a(gVar);
    }

    public f g(org.junit.runner.manipulation.a aVar) {
        return new h5.b(this, aVar);
    }

    public f k(Comparator<Description> comparator) {
        return new h5.c(this, comparator);
    }

    public static f d(Class<?>... clsArr) {
        return c(e.b(), clsArr);
    }

    public static f i(Class<?> cls, String str) {
        return a(cls).f(Description.createTestDescription(cls, str));
    }

    public f f(Description description) {
        return g(org.junit.runner.manipulation.a.d(description));
    }
}
