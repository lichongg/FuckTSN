package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.d0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;
import r3.a;
import r3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f45966b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f45967a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.k$a$a, reason: collision with other inner class name */
        public static final class C0899a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final k f45968a;

            /* renamed from: b, reason: collision with root package name */
            @NotNull
            private final n f45969b;

            public C0899a(@NotNull k deserializationComponentsForJava, @NotNull n deserializedDescriptorResolver) {
                kotlin.jvm.internal.g0.p(deserializationComponentsForJava, "deserializationComponentsForJava");
                kotlin.jvm.internal.g0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
                this.f45968a = deserializationComponentsForJava;
                this.f45969b = deserializedDescriptorResolver;
            }

            @NotNull
            public final k a() {
                return this.f45968a;
            }

            @NotNull
            public final n b() {
                return this.f45969b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final C0899a a(@NotNull v kotlinClassFinder, @NotNull v jvmBuiltInsKotlinClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.load.java.t javaClassFinder, @NotNull String moduleName, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.v errorReporter, @NotNull x3.b javaSourceElementFactory) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.j b6;
            kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.g0.p(jvmBuiltInsKotlinClassFinder, "jvmBuiltInsKotlinClassFinder");
            kotlin.jvm.internal.g0.p(javaClassFinder, "javaClassFinder");
            kotlin.jvm.internal.g0.p(moduleName, "moduleName");
            kotlin.jvm.internal.g0.p(errorReporter, "errorReporter");
            kotlin.jvm.internal.g0.p(javaSourceElementFactory, "javaSourceElementFactory");
            kotlin.reflect.jvm.internal.impl.storage.f fVar = new kotlin.reflect.jvm.internal.impl.storage.f("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(fVar, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            kotlin.reflect.jvm.internal.impl.name.f k6 = kotlin.reflect.jvm.internal.impl.name.f.k(v0.f47961e + moduleName + v0.f47962f);
            kotlin.jvm.internal.g0.o(k6, "special(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.f0 f0Var = new kotlin.reflect.jvm.internal.impl.descriptors.impl.f0(k6, fVar, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.F0(f0Var);
            jvmBuiltIns.N0(f0Var, true);
            n nVar = new n();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.o oVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.o();
            k0 k0Var = new k0(fVar, f0Var);
            b6 = l.b(javaClassFinder, f0Var, fVar, k0Var, kotlinClassFinder, nVar, errorReporter, javaSourceElementFactory, oVar, (r21 & 512) != 0 ? d0.a.f45875a : null);
            k a6 = l.a(f0Var, fVar, k0Var, b6, kotlinClassFinder, nVar, errorReporter, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c.f46236i);
            nVar.o(a6);
            kotlin.reflect.jvm.internal.impl.load.java.components.j EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.j.f45398a;
            kotlin.jvm.internal.g0.o(EMPTY, "EMPTY");
            kotlin.reflect.jvm.internal.impl.resolve.jvm.c cVar = new kotlin.reflect.jvm.internal.impl.resolve.jvm.c(b6, EMPTY);
            oVar.c(cVar);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.v vVar = new kotlin.reflect.jvm.internal.impl.builtins.jvm.v(fVar, jvmBuiltInsKotlinClassFinder, f0Var, k0Var, jvmBuiltIns.M0(), jvmBuiltIns.M0(), n.a.f47029a, kotlin.reflect.jvm.internal.impl.types.checker.p.f47188b.a(), new b4.b(fVar, kotlin.collections.f0.J()));
            f0Var.R0(f0Var);
            f0Var.J0(new kotlin.reflect.jvm.internal.impl.descriptors.impl.l(kotlin.collections.f0.Q(cVar.a(), vVar), "CompositeProvider@RuntimeModuleData for " + f0Var));
            return new C0899a(a6, nVar);
        }
    }

    public k(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 moduleDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.n configuration, @NotNull o classDataFinder, @NotNull h annotationAndConstantLoader, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.j packageFragmentProvider, @NotNull k0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.v errorReporter, @NotNull u3.c lookupTracker, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.l contractDeserializer, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.p kotlinTypeChecker, @NotNull d4.a typeAttributeTranslators) {
        r3.c M0;
        r3.a M02;
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.g0.p(configuration, "configuration");
        kotlin.jvm.internal.g0.p(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.g0.p(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.g0.p(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(errorReporter, "errorReporter");
        kotlin.jvm.internal.g0.p(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.g0.p(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.g0.p(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.g0.p(typeAttributeTranslators, "typeAttributeTranslators");
        kotlin.reflect.jvm.internal.impl.builtins.j p5 = moduleDescriptor.p();
        JvmBuiltIns jvmBuiltIns = p5 instanceof JvmBuiltIns ? (JvmBuiltIns) p5 : null;
        this.f45967a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.m(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, a0.a.f46814a, errorReporter, lookupTracker, p.f45980a, kotlin.collections.f0.J(), notFoundClasses, contractDeserializer, (jvmBuiltIns == null || (M02 = jvmBuiltIns.M0()) == null) ? a.C1006a.f51989a : M02, (jvmBuiltIns == null || (M0 = jvmBuiltIns.M0()) == null) ? c.b.f51991a : M0, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.a(), kotlinTypeChecker, new b4.b(storageManager, kotlin.collections.f0.J()), typeAttributeTranslators.a(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.f47086a);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m a() {
        return this.f45967a;
    }
}
