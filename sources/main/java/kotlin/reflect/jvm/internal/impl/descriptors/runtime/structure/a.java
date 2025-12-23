package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44980a = new a();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static C0881a f44981b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a$a, reason: collision with other inner class name */
    public static final class C0881a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final Method f44982a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Method f44983b;

        @Nullable
        public final Method a() {
            return this.f44983b;
        }

        @Nullable
        public final Method b() {
            return this.f44982a;
        }

        public C0881a(@Nullable Method method, @Nullable Method method2) {
            this.f44982a = method;
            this.f44983b = method2;
        }
    }

    private final C0881a b(Object obj) {
        C0881a c0881a = f44981b;
        if (c0881a != null) {
            return c0881a;
        }
        C0881a a6 = a(obj);
        f44981b = a6;
        return a6;
    }

    @Nullable
    public final Method c(@NotNull Object recordComponent) {
        kotlin.jvm.internal.g0.p(recordComponent, "recordComponent");
        Method a6 = b(recordComponent).a();
        if (a6 == null) {
            return null;
        }
        Object invoke = a6.invoke(recordComponent, null);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) invoke;
    }

    @Nullable
    public final Class<?> d(@NotNull Object recordComponent) {
        kotlin.jvm.internal.g0.p(recordComponent, "recordComponent");
        Method b6 = b(recordComponent).b();
        if (b6 == null) {
            return null;
        }
        Object invoke = b6.invoke(recordComponent, null);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) invoke;
    }

    private a() {
    }

    private final C0881a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0881a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new C0881a(null, null);
        }
    }
}
