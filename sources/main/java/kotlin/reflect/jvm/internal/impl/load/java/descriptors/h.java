package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\norg/jetbrains/kotlin/load/java/descriptors/UtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1563#2:66\n1634#2,3:67\n*S KotlinDebug\n*F\n+ 1 util.kt\norg/jetbrains/kotlin/load/java/descriptors/UtilKt\n*L\n40#1:66\n40#1:67,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {
    @NotNull
    public static final List<q1> a(@NotNull Collection<? extends t0> newValueParameterTypes, @NotNull Collection<? extends q1> oldValueParameters, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        g0.p(newValueParameterTypes, "newValueParameterTypes");
        g0.p(oldValueParameters, "oldValueParameters");
        kotlin.reflect.jvm.internal.impl.descriptors.a newOwner = aVar;
        g0.p(newOwner, "newOwner");
        newValueParameterTypes.size();
        oldValueParameters.size();
        List<Pair> o6 = f0.o6(newValueParameterTypes, oldValueParameters);
        ArrayList arrayList = new ArrayList(f0.d0(o6, 10));
        for (Pair pair : o6) {
            t0 t0Var = (t0) pair.component1();
            q1 q1Var = (q1) pair.component2();
            int index = q1Var.getIndex();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = q1Var.getAnnotations();
            kotlin.reflect.jvm.internal.impl.name.f name = q1Var.getName();
            g0.o(name, "getName(...)");
            boolean Q = q1Var.Q();
            boolean w02 = q1Var.w0();
            boolean u02 = q1Var.u0();
            t0 k6 = q1Var.z0() != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(newOwner).p().k(t0Var) : null;
            e1 source = q1Var.getSource();
            g0.o(source, "getSource(...)");
            arrayList.add(new u0(newOwner, null, index, annotations, name, t0Var, Q, w02, u02, k6, source));
            newOwner = aVar;
        }
        return arrayList;
    }

    @Nullable
    public static final z0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        g0.p(dVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.d x5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.x(dVar);
        if (x5 == null) {
            return null;
        }
        k r02 = x5.r0();
        z0 z0Var = r02 instanceof z0 ? (z0) r02 : null;
        return z0Var == null ? b(x5) : z0Var;
    }
}
