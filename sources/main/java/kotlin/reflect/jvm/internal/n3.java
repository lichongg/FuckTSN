package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ntypeOfImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeOfImpl.kt\nkotlin/reflect/jvm/internal/TypeOfImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n3 {
    @NotNull
    public static final kotlin.reflect.r a(@NotNull kotlin.reflect.r type) {
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.types.t0 type2 = ((z2) type).getType();
        if (!(type2 instanceof kotlin.reflect.jvm.internal.impl.types.e1)) {
            throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + type).toString());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = type2.I0().c();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
        if (dVar != null) {
            kotlin.reflect.jvm.internal.impl.types.e1 e1Var = (kotlin.reflect.jvm.internal.impl.types.e1) type2;
            kotlin.reflect.jvm.internal.impl.types.w1 o5 = d(dVar).o();
            kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
            return new z2(kotlin.reflect.jvm.internal.impl.types.w0.l(e1Var, null, o5, null, false, 26, null), null, 2, null);
        }
        throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
    }

    @NotNull
    public static final kotlin.reflect.r b(@NotNull kotlin.reflect.r type) {
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.types.t0 type2 = ((z2) type).getType();
        if (type2 instanceof kotlin.reflect.jvm.internal.impl.types.e1) {
            kotlin.reflect.jvm.internal.impl.types.e1 e1Var = (kotlin.reflect.jvm.internal.impl.types.e1) type2;
            kotlin.reflect.jvm.internal.impl.types.w1 o5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(type2).H().o();
            kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
            return new z2(kotlin.reflect.jvm.internal.impl.types.w0.l(e1Var, null, o5, null, false, 26, null), null, 2, null);
        }
        throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + type).toString());
    }

    @NotNull
    public static final kotlin.reflect.r c(@NotNull kotlin.reflect.r lowerBound, @NotNull kotlin.reflect.r upperBound) {
        kotlin.jvm.internal.g0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.g0.p(upperBound, "upperBound");
        kotlin.reflect.jvm.internal.impl.types.t0 type = ((z2) lowerBound).getType();
        kotlin.jvm.internal.g0.n(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        kotlin.reflect.jvm.internal.impl.types.t0 type2 = ((z2) upperBound).getType();
        kotlin.jvm.internal.g0.n(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new z2(kotlin.reflect.jvm.internal.impl.types.w0.e((kotlin.reflect.jvm.internal.impl.types.e1) type, (kotlin.reflect.jvm.internal.impl.types.e1) type2), null, 2, null);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.d d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.name.c p5 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.p(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(dVar));
        if (p5 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d p6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(dVar).p(p5);
            kotlin.jvm.internal.g0.o(p6, "getBuiltInClassByFqName(...)");
            return p6;
        }
        throw new IllegalArgumentException("Not a readonly collection: " + dVar);
    }
}
