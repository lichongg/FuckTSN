package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f44984a = new b();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static a f44985b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final Method f44986a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Method f44987b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final Method f44988c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final Method f44989d;

        @Nullable
        public final Method a() {
            return this.f44987b;
        }

        @Nullable
        public final Method b() {
            return this.f44989d;
        }

        @Nullable
        public final Method c() {
            return this.f44988c;
        }

        @Nullable
        public final Method d() {
            return this.f44986a;
        }

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3, @Nullable Method method4) {
            this.f44986a = method;
            this.f44987b = method2;
            this.f44988c = method3;
            this.f44989d = method4;
        }
    }

    private final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    private final a b() {
        a aVar = f44985b;
        if (aVar != null) {
            return aVar;
        }
        a a6 = a();
        f44985b = a6;
        return a6;
    }

    @Nullable
    public final Class<?>[] c(@NotNull Class<?> clazz) {
        kotlin.jvm.internal.g0.p(clazz, "clazz");
        Method a6 = b().a();
        if (a6 == null) {
            return null;
        }
        Object invoke = a6.invoke(clazz, null);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) invoke;
    }

    @Nullable
    public final Object[] d(@NotNull Class<?> clazz) {
        kotlin.jvm.internal.g0.p(clazz, "clazz");
        Method b6 = b().b();
        if (b6 == null) {
            return null;
        }
        return (Object[]) b6.invoke(clazz, null);
    }

    @Nullable
    public final Boolean e(@NotNull Class<?> clazz) {
        kotlin.jvm.internal.g0.p(clazz, "clazz");
        Method c6 = b().c();
        if (c6 == null) {
            return null;
        }
        Object invoke = c6.invoke(clazz, null);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    @Nullable
    public final Boolean f(@NotNull Class<?> clazz) {
        kotlin.jvm.internal.g0.p(clazz, "clazz");
        Method d6 = b().d();
        if (d6 == null) {
            return null;
        }
        Object invoke = d6.invoke(clazz, null);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    private b() {
    }
}
