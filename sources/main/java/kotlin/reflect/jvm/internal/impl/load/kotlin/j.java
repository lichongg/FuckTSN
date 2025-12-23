package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ndescriptorBasedTypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorBasedTypeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/DescriptorBasedTypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,198:1\n1#2:199\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {
    @NotNull
    public static final String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d klass, @NotNull g0<?> typeMappingConfiguration) {
        kotlin.jvm.internal.g0.p(klass, "klass");
        kotlin.jvm.internal.g0.p(typeMappingConfiguration, "typeMappingConfiguration");
        String d6 = typeMappingConfiguration.d(klass);
        if (d6 != null) {
            return d6;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = klass.b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        String identifier = kotlin.reflect.jvm.internal.impl.name.h.b(klass.getName()).getIdentifier();
        kotlin.jvm.internal.g0.o(identifier, "getIdentifier(...)");
        if (b6 instanceof l0) {
            kotlin.reflect.jvm.internal.impl.name.c d7 = ((l0) b6).d();
            if (d7.c()) {
                return identifier;
            }
            return kotlin.text.u.w2(d7.a(), '.', '/', false, 4, null) + '/' + identifier;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b6 : null;
        if (dVar == null) {
            throw new IllegalArgumentException("Unexpected container: " + b6 + " for " + klass);
        }
        String b7 = typeMappingConfiguration.b(dVar);
        if (b7 == null) {
            b7 = a(dVar, typeMappingConfiguration);
        }
        return b7 + v0.f47959c + identifier;
    }

    public static /* synthetic */ String b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, g0 g0Var, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            g0Var = h0.f45915a;
        }
        return a(dVar, g0Var);
    }

    public static final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a descriptor) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
            return true;
        }
        t0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        if (!kotlin.reflect.jvm.internal.impl.builtins.j.D0(returnType)) {
            return false;
        }
        t0 returnType2 = descriptor.getReturnType();
        kotlin.jvm.internal.g0.m(returnType2);
        return (j2.l(returnType2) || (descriptor instanceof x0)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v31, types: [T, java.lang.Object] */
    @NotNull
    public static final <T> T d(@NotNull t0 kotlinType, @NotNull t<T> factory, @NotNull i0 mode, @NotNull g0<? extends T> typeMappingConfiguration, @Nullable q<T> qVar, @NotNull Function3<? super t0, ? super T, ? super i0, n1> writeGenericType) {
        T a6;
        t0 t0Var;
        Object d6;
        kotlin.jvm.internal.g0.p(kotlinType, "kotlinType");
        kotlin.jvm.internal.g0.p(factory, "factory");
        kotlin.jvm.internal.g0.p(mode, "mode");
        kotlin.jvm.internal.g0.p(typeMappingConfiguration, "typeMappingConfiguration");
        kotlin.jvm.internal.g0.p(writeGenericType, "writeGenericType");
        t0 c6 = typeMappingConfiguration.c(kotlinType);
        if (c6 != null) {
            return (T) d(c6, factory, mode, typeMappingConfiguration, qVar, writeGenericType);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.i.r(kotlinType)) {
            return (T) d(kotlin.reflect.jvm.internal.impl.builtins.p.a(kotlinType), factory, mode, typeMappingConfiguration, qVar, writeGenericType);
        }
        kotlin.reflect.jvm.internal.impl.types.checker.u uVar = kotlin.reflect.jvm.internal.impl.types.checker.u.f47196a;
        Object b6 = j0.b(uVar, kotlinType, factory, mode);
        if (b6 != null) {
            ?? r8 = (Object) j0.a(factory, b6, mode.d());
            writeGenericType.invoke(kotlinType, r8, mode);
            return r8;
        }
        w1 I0 = kotlinType.I0();
        if (I0 instanceof s0) {
            s0 s0Var = (s0) I0;
            t0 l6 = s0Var.l();
            if (l6 == null) {
                l6 = typeMappingConfiguration.f(s0Var.i());
            }
            return (T) d(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.E(l6), factory, mode, typeMappingConfiguration, qVar, writeGenericType);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c7 = I0.c();
        if (c7 == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        if (kotlin.reflect.jvm.internal.impl.types.error.i.m(c7)) {
            T t5 = (T) factory.f("error/NonExistentClass");
            typeMappingConfiguration.e(kotlinType, (kotlin.reflect.jvm.internal.impl.descriptors.d) c7);
            if (qVar != 0) {
                qVar.c(t5);
            }
            return t5;
        }
        boolean z5 = c7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
        if (z5 && kotlin.reflect.jvm.internal.impl.builtins.j.d0(kotlinType)) {
            if (kotlinType.G0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            c2 c2Var = kotlinType.G0().get(0);
            t0 type = c2Var.getType();
            kotlin.jvm.internal.g0.o(type, "getType(...)");
            if (c2Var.c() == Variance.IN_VARIANCE) {
                d6 = factory.f("java/lang/Object");
                if (qVar != 0) {
                    qVar.b();
                    qVar.c(d6);
                    qVar.a();
                }
            } else {
                if (qVar != 0) {
                    qVar.b();
                }
                Variance c8 = c2Var.c();
                kotlin.jvm.internal.g0.o(c8, "getProjectionKind(...)");
                d6 = d(type, factory, mode.f(c8, true), typeMappingConfiguration, qVar, writeGenericType);
                if (qVar != 0) {
                    qVar.a();
                }
            }
            return (T) factory.a('[' + factory.e(d6));
        }
        if (!z5) {
            if (!(c7 instanceof j1)) {
                if ((c7 instanceof i1) && mode.b()) {
                    return (T) d(((i1) c7).Z(), factory, mode, typeMappingConfiguration, qVar, writeGenericType);
                }
                throw new UnsupportedOperationException("Unknown type " + kotlinType);
            }
            t0 p5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.p((j1) c7);
            if (kotlinType.J0()) {
                p5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.C(p5);
            }
            T t6 = (T) d(p5, factory, mode, typeMappingConfiguration, null, kotlin.reflect.jvm.internal.impl.utils.i.l());
            if (qVar != 0) {
                kotlin.reflect.jvm.internal.impl.name.f name = c7.getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                qVar.e(name, t6);
            }
            return t6;
        }
        if (kotlin.reflect.jvm.internal.impl.resolve.j.b(c7) && !mode.c() && (t0Var = (t0) kotlin.reflect.jvm.internal.impl.types.j0.a(uVar, kotlinType)) != null) {
            return (T) d(t0Var, factory, mode.g(), typeMappingConfiguration, qVar, writeGenericType);
        }
        if (mode.e() && kotlin.reflect.jvm.internal.impl.builtins.j.m0((kotlin.reflect.jvm.internal.impl.descriptors.d) c7)) {
            a6 = (Object) factory.b();
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) c7;
            kotlin.reflect.jvm.internal.impl.descriptors.d a7 = dVar.a();
            kotlin.jvm.internal.g0.o(a7, "getOriginal(...)");
            a6 = typeMappingConfiguration.a(a7);
            if (a6 == null) {
                if (dVar.h() == ClassKind.ENUM_ENTRY) {
                    kotlin.reflect.jvm.internal.impl.descriptors.k b7 = dVar.b();
                    kotlin.jvm.internal.g0.n(b7, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b7;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.d a8 = dVar.a();
                kotlin.jvm.internal.g0.o(a8, "getOriginal(...)");
                a6 = (Object) factory.f(a(a8, typeMappingConfiguration));
            }
        }
        writeGenericType.invoke(kotlinType, a6, mode);
        return a6;
    }

    public static /* synthetic */ Object e(t0 t0Var, t tVar, i0 i0Var, g0 g0Var, q qVar, Function3 function3, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            function3 = kotlin.reflect.jvm.internal.impl.utils.i.l();
        }
        return d(t0Var, tVar, i0Var, g0Var, qVar, function3);
    }
}
