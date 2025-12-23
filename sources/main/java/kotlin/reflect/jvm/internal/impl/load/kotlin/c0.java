package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.r0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmethodSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/MethodSignatureMappingKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n*L\n1#1,200:1\n13#2:201\n*S KotlinDebug\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/MethodSignatureMappingKt\n*L\n81#1:201\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c0 {
    @NotNull
    public static final String b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar, boolean z5, boolean z6) {
        String b6;
        kotlin.jvm.internal.g0.p(yVar, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z6) {
            if (yVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
                b6 = "<init>";
            } else {
                b6 = yVar.getName().b();
                kotlin.jvm.internal.g0.o(b6, "asString(...)");
            }
            sb.append(b6);
        }
        sb.append("(");
        z0 f02 = yVar.f0();
        if (f02 != null) {
            t0 type = f02.getType();
            kotlin.jvm.internal.g0.o(type, "getType(...)");
            a(sb, type);
        }
        Iterator<q1> it = yVar.g().iterator();
        while (it.hasNext()) {
            t0 type2 = it.next().getType();
            kotlin.jvm.internal.g0.o(type2, "getType(...)");
            a(sb, type2);
        }
        sb.append(")");
        if (z5) {
            if (j.c(yVar)) {
                sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                t0 returnType = yVar.getReturnType();
                kotlin.jvm.internal.g0.m(returnType);
                a(sb, returnType);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String c(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, boolean z5, boolean z6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if ((i6 & 2) != 0) {
            z6 = true;
        }
        return b(yVar, z5, z6);
    }

    @Nullable
    public static final String d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.g0.p(aVar, "<this>");
        f0 f0Var = f0.f45887a;
        if (kotlin.reflect.jvm.internal.impl.resolve.i.E(aVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = aVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b6 : null;
        if (dVar == null || dVar.getName().i()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a a6 = aVar.a();
        d1 d1Var = a6 instanceof d1 ? (d1) a6 : null;
        if (d1Var == null) {
            return null;
        }
        return b0.a(f0Var, dVar, c(d1Var, false, false, 3, null));
    }

    public static final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a f6) {
        kotlin.reflect.jvm.internal.impl.descriptors.y l6;
        kotlin.jvm.internal.g0.p(f6, "f");
        if (!(f6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.y)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar = (kotlin.reflect.jvm.internal.impl.descriptors.y) f6;
        if (kotlin.jvm.internal.g0.g(yVar.getName().b(), "remove") && yVar.g().size() == 1 && !r0.n((CallableMemberDescriptor) f6)) {
            List<q1> g6 = yVar.a().g();
            kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
            t0 type = ((q1) kotlin.collections.f0.m5(g6)).getType();
            kotlin.jvm.internal.g0.o(type, "getType(...)");
            s g7 = g(type);
            s.d dVar = g7 instanceof s.d ? (s.d) g7 : null;
            if ((dVar != null ? dVar.i() : null) != JvmPrimitiveType.INT || (l6 = kotlin.reflect.jvm.internal.impl.load.java.h.l(yVar)) == null) {
                return false;
            }
            List<q1> g8 = l6.a().g();
            kotlin.jvm.internal.g0.o(g8, "getValueParameters(...)");
            t0 type2 = ((q1) kotlin.collections.f0.m5(g8)).getType();
            kotlin.jvm.internal.g0.o(type2, "getType(...)");
            s g9 = g(type2);
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = l6.b();
            kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(b6), o.a.f44594f0.i()) && (g9 instanceof s.c) && kotlin.jvm.internal.g0.g(((s.c) g9).i(), "java/lang/Object")) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final String f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.g0.p(dVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.n(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(dVar).i());
        if (n6 == null) {
            return j.b(dVar, null, 2, null);
        }
        String h6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.h(n6);
        kotlin.jvm.internal.g0.o(h6, "internalNameByClassId(...)");
        return h6;
    }

    @NotNull
    public static final s g(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        return (s) j.e(t0Var, u.f46003a, i0.f45949o, h0.f45915a, null, null, 32, null);
    }

    private static final void a(StringBuilder sb, t0 t0Var) {
        sb.append(g(t0Var));
    }
}
