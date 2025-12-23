package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKAnnotatedElements.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/Java8RepeatableContainerLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44214a = new a();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static C0871a f44215b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.full.a$a, reason: collision with other inner class name */
    public static final class C0871a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final Class<? extends Annotation> f44216a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Method f44217b;

        @Nullable
        public final Class<? extends Annotation> a() {
            return this.f44216a;
        }

        @Nullable
        public final Method b() {
            return this.f44217b;
        }

        public C0871a(@Nullable Class<? extends Annotation> cls, @Nullable Method method) {
            this.f44216a = cls;
            this.f44217b = method;
        }
    }

    private final C0871a a() {
        try {
            Class<?> cls = Class.forName("java.lang.annotation.Repeatable");
            g0.n(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
            return new C0871a(cls, cls.getMethod("value", null));
        } catch (ClassNotFoundException unused) {
            return new C0871a(null, null);
        }
    }

    @Nullable
    public final Class<? extends Annotation> b(@NotNull Class<? extends Annotation> klass) {
        Annotation annotation;
        Method b6;
        g0.p(klass, "klass");
        C0871a c0871a = f44215b;
        if (c0871a == null) {
            synchronized (this) {
                c0871a = f44215b;
                if (c0871a == null) {
                    c0871a = f44214a.a();
                    f44215b = c0871a;
                }
            }
        }
        Class a6 = c0871a.a();
        if (a6 == null || (annotation = klass.getAnnotation(a6)) == null || (b6 = c0871a.b()) == null) {
            return null;
        }
        Object invoke = b6.invoke(annotation, null);
        g0.n(invoke, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        return (Class) invoke;
    }

    private a() {
    }
}
