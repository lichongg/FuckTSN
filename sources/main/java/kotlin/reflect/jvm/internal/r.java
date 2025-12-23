package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class r {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRuntimeTypeMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,302:1\n6482#2:303\n*S KotlinDebug\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor\n*L\n88#1:303\n*E\n"})
    public static final class a extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Class<?> f47568a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<Method> f47569b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor\n*L\n1#1,328:1\n88#2:329\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.r$a$a, reason: collision with other inner class name */
        public static final class C0926a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return kotlin.comparisons.a.l(((Method) t5).getName(), ((Method) t6).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Class<?> jClass) {
            super(null);
            kotlin.jvm.internal.g0.p(jClass, "jClass");
            this.f47568a = jClass;
            Method[] declaredMethods = jClass.getDeclaredMethods();
            kotlin.jvm.internal.g0.o(declaredMethods, "getDeclaredMethods(...)");
            this.f47569b = kotlin.collections.n.fw(declaredMethods, new C0926a());
        }

        @Override // kotlin.reflect.jvm.internal.r
        @NotNull
        public String a() {
            return kotlin.collections.f0.r3(this.f47569b, "", "<init>(", ")V", 0, null, q.f47560a, 24, null);
        }

        @NotNull
        public final List<Method> d() {
            return this.f47569b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence c(Method method) {
            Class<?> returnType = method.getReturnType();
            kotlin.jvm.internal.g0.o(returnType, "getReturnType(...)");
            return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(returnType);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Constructor<?> f47570a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Constructor<?> constructor) {
            super(null);
            kotlin.jvm.internal.g0.p(constructor, "constructor");
            this.f47570a = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.r
        @NotNull
        public String a() {
            Class<?>[] parameterTypes = this.f47570a.getParameterTypes();
            kotlin.jvm.internal.g0.o(parameterTypes, "getParameterTypes(...)");
            return kotlin.collections.n.Eh(parameterTypes, "", "<init>(", ")V", 0, null, s.f47579a, 24, null);
        }

        @NotNull
        public final Constructor<?> d() {
            return this.f47570a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence c(Class cls) {
            kotlin.jvm.internal.g0.m(cls);
            return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(cls);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Method f47571a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull Method method) {
            super(null);
            kotlin.jvm.internal.g0.p(method, "method");
            this.f47571a = method;
        }

        @Override // kotlin.reflect.jvm.internal.r
        @NotNull
        public String a() {
            String d6;
            d6 = m3.d(this.f47571a);
            return d6;
        }

        @NotNull
        public final Method b() {
            return this.f47571a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final d.b f47572a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f47573b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull d.b signature) {
            super(null);
            kotlin.jvm.internal.g0.p(signature, "signature");
            this.f47572a = signature;
            this.f47573b = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.r
        @NotNull
        public String a() {
            return this.f47573b;
        }

        @NotNull
        public final String b() {
            return this.f47572a.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final d.b f47574a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f47575b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull d.b signature) {
            super(null);
            kotlin.jvm.internal.g0.p(signature, "signature");
            this.f47574a = signature;
            this.f47575b = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.r
        @NotNull
        public String a() {
            return this.f47575b;
        }

        @NotNull
        public final String b() {
            return this.f47574a.d();
        }

        @NotNull
        public final String c() {
            return this.f47574a.e();
        }
    }

    public /* synthetic */ r(kotlin.jvm.internal.v vVar) {
        this();
    }

    @NotNull
    public abstract String a();

    private r() {
    }
}
