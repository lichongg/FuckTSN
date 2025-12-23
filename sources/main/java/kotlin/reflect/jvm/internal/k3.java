package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.r;
import kotlin.reflect.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRuntimeTypeMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/RuntimeTypeMapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k3 f47513a = new k3();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f47514b = kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(new kotlin.reflect.jvm.internal.impl.name.c("java.lang.Void"));

    private final r.e d(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        return new r.e(new d.b(e(yVar), kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c(yVar, false, false, 1, null)));
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b c(@NotNull Class<?> klass) {
        kotlin.reflect.jvm.internal.impl.name.b m6;
        kotlin.jvm.internal.g0.p(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.g0.o(componentType, "getComponentType(...)");
            PrimitiveType a6 = a(componentType);
            return a6 != null ? new kotlin.reflect.jvm.internal.impl.name.b(kotlin.reflect.jvm.internal.impl.builtins.o.B, a6.getArrayTypeName()) : kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.f44599i.m());
        }
        if (kotlin.jvm.internal.g0.g(klass, Void.TYPE)) {
            return f47514b;
        }
        PrimitiveType a7 = a(klass);
        if (a7 != null) {
            return new kotlin.reflect.jvm.internal.impl.name.b(kotlin.reflect.jvm.internal.impl.builtins.o.B, a7.getTypeName());
        }
        kotlin.reflect.jvm.internal.impl.name.b e6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(klass);
        return (e6.i() || (m6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.m(e6.a())) == null) ? e6 : m6;
    }

    @NotNull
    public final t f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 possiblyOverriddenProperty) {
        kotlin.jvm.internal.g0.p(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        kotlin.reflect.jvm.internal.impl.descriptors.w0 a6 = ((kotlin.reflect.jvm.internal.impl.descriptors.w0) kotlin.reflect.jvm.internal.impl.resolve.i.L(possiblyOverriddenProperty)).a();
        kotlin.jvm.internal.g0.o(a6, "getOriginal(...)");
        if (a6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0) a6;
            ProtoBuf.Property K = n0Var.K();
            GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f46262d;
            kotlin.jvm.internal.g0.o(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(K, propertySignature);
            if (jvmPropertySignature != null) {
                return new t.c(a6, K, jvmPropertySignature, n0Var.a0(), n0Var.A());
            }
        } else if (a6 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.f) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.f fVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.f) a6;
            kotlin.reflect.jvm.internal.impl.descriptors.e1 source = fVar.getSource();
            x3.a aVar = source instanceof x3.a ? (x3.a) source : null;
            y3.l c6 = aVar != null ? aVar.c() : null;
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.w) {
                return new t.a(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.w) c6).N());
            }
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z) {
                Method N = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z) c6).N();
                kotlin.reflect.jvm.internal.impl.descriptors.y0 setter = fVar.getSetter();
                kotlin.reflect.jvm.internal.impl.descriptors.e1 source2 = setter != null ? setter.getSource() : null;
                x3.a aVar2 = source2 instanceof x3.a ? (x3.a) source2 : null;
                y3.l c7 = aVar2 != null ? aVar2.c() : null;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z zVar = c7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z) c7 : null;
                return new t.b(N, zVar != null ? zVar.N() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + a6 + " (source = " + c6 + ')');
        }
        kotlin.reflect.jvm.internal.impl.descriptors.x0 getter = a6.getGetter();
        kotlin.jvm.internal.g0.m(getter);
        r.e d6 = d(getter);
        kotlin.reflect.jvm.internal.impl.descriptors.y0 setter2 = a6.getSetter();
        return new t.d(d6, setter2 != null ? d(setter2) : null);
    }

    @NotNull
    public final r g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y possiblySubstitutedFunction) {
        Method N;
        d.b b6;
        d.b e6;
        kotlin.jvm.internal.g0.p(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        kotlin.reflect.jvm.internal.impl.descriptors.y a6 = ((kotlin.reflect.jvm.internal.impl.descriptors.y) kotlin.reflect.jvm.internal.impl.resolve.i.L(possiblySubstitutedFunction)).a();
        kotlin.jvm.internal.g0.o(a6, "getOriginal(...)");
        if (!(a6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c)) {
            if (a6 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) {
                kotlin.reflect.jvm.internal.impl.descriptors.e1 source = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) a6).getSource();
                x3.a aVar = source instanceof x3.a ? (x3.a) source : null;
                y3.l c6 = aVar != null ? aVar.c() : null;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z zVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z) c6 : null;
                if (zVar != null && (N = zVar.N()) != null) {
                    return new r.c(N);
                }
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + a6);
            }
            if (!(a6 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.b)) {
                if (b(a6)) {
                    return d(a6);
                }
                throw new KotlinReflectionInternalError("Unknown origin of " + a6 + " (" + a6.getClass() + ')');
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e1 source2 = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.b) a6).getSource();
            x3.a aVar2 = source2 instanceof x3.a ? (x3.a) source2 : null;
            y3.l c7 = aVar2 != null ? aVar2.c() : null;
            if (c7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t) {
                return new r.b(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t) c7).N());
            }
            if (c7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.q) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.q qVar = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.q) c7;
                if (qVar.k()) {
                    return new r.a(qVar.getElement());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + a6 + " (" + c7 + ')');
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t tVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t) a6;
        kotlin.reflect.jvm.internal.impl.protobuf.n K = tVar.K();
        if ((K instanceof ProtoBuf.Function) && (e6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.e((ProtoBuf.Function) K, tVar.a0(), tVar.A())) != null) {
            return new r.e(e6);
        }
        if (!(K instanceof ProtoBuf.Constructor) || (b6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.b((ProtoBuf.Constructor) K, tVar.a0(), tVar.A())) == null) {
            return d(a6);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b7 = possiblySubstitutedFunction.b();
        kotlin.jvm.internal.g0.o(b7, "getContainingDeclaration(...)");
        if (kotlin.reflect.jvm.internal.impl.resolve.j.b(b7)) {
            return new r.e(b6);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b8 = possiblySubstitutedFunction.b();
        kotlin.jvm.internal.g0.o(b8, "getContainingDeclaration(...)");
        if (!kotlin.reflect.jvm.internal.impl.resolve.j.d(b8)) {
            return new r.d(b6);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.j jVar = (kotlin.reflect.jvm.internal.impl.descriptors.j) possiblySubstitutedFunction;
        if (jVar.m0()) {
            if (!kotlin.jvm.internal.g0.g(b6.e(), "constructor-impl") || !kotlin.text.u.Z1(b6.d(), ")V", false, 2, null)) {
                throw new IllegalArgumentException(("Invalid signature: " + b6).toString());
            }
        } else {
            if (!kotlin.jvm.internal.g0.g(b6.e(), "constructor-impl")) {
                throw new IllegalArgumentException(("Invalid signature: " + b6).toString());
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d J = jVar.J();
            kotlin.jvm.internal.g0.o(J, "getConstructedClass(...)");
            String u5 = kotlin.reflect.jvm.internal.calls.n.u(J);
            if (kotlin.text.u.Z1(b6.d(), ")V", false, 2, null)) {
                b6 = d.b.c(b6, null, kotlin.text.u.B4(b6.d(), ExifInterface.GPS_MEASUREMENT_INTERRUPTED) + u5, 1, null);
            } else if (!kotlin.text.u.Z1(b6.d(), u5, false, 2, null)) {
                throw new IllegalArgumentException(("Invalid signature: " + b6).toString());
            }
        }
        return new r.e(b6);
    }

    private k3() {
    }

    private final PrimitiveType a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        if (kotlin.reflect.jvm.internal.impl.resolve.h.p(yVar) || kotlin.reflect.jvm.internal.impl.resolve.h.q(yVar)) {
            return true;
        }
        if (kotlin.jvm.internal.g0.g(yVar.getName(), kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f44459e.a()) && yVar.g().isEmpty()) {
            return true;
        }
        return false;
    }

    private final String e(CallableMemberDescriptor callableMemberDescriptor) {
        String e6 = kotlin.reflect.jvm.internal.impl.load.java.r0.e(callableMemberDescriptor);
        if (e6 == null) {
            if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.x0) {
                String b6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(callableMemberDescriptor).getName().b();
                kotlin.jvm.internal.g0.o(b6, "asString(...)");
                return kotlin.reflect.jvm.internal.impl.load.java.h0.b(b6);
            }
            if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y0) {
                String b7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(callableMemberDescriptor).getName().b();
                kotlin.jvm.internal.g0.o(b7, "asString(...)");
                return kotlin.reflect.jvm.internal.impl.load.java.h0.e(b7);
            }
            String b8 = callableMemberDescriptor.getName().b();
            kotlin.jvm.internal.g0.o(b8, "asString(...)");
            return b8;
        }
        return e6;
    }
}
