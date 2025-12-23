package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStarProjectionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarProjectionImpl.kt\norg/jetbrains/kotlin/types/StarProjectionImplKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1563#2:102\n1634#2,3:103\n1563#2:106\n1634#2,3:107\n*S KotlinDebug\n*F\n+ 1 StarProjectionImpl.kt\norg/jetbrains/kotlin/types/StarProjectionImplKt\n*L\n66#1:102\n66#1:103,3\n73#1:106\n73#1:107,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends x1 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<w1> f47296d;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends w1> list) {
            this.f47296d = list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.x1
        public c2 k(w1 key) {
            kotlin.jvm.internal.g0.p(key, "key");
            if (!this.f47296d.contains(key)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = key.c();
            kotlin.jvm.internal.g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return j2.s((kotlin.reflect.jvm.internal.impl.descriptors.j1) c6);
        }
    }

    private static final t0 a(List<? extends w1> list, List<? extends t0> list2, kotlin.reflect.jvm.internal.impl.builtins.j jVar) {
        t0 p5 = h2.g(new a(list)).p((t0) kotlin.collections.f0.G2(list2), Variance.OUT_VARIANCE);
        if (p5 != null) {
            return p5;
        }
        e1 z5 = jVar.z();
        kotlin.jvm.internal.g0.o(z5, "getDefaultBound(...)");
        return z5;
    }

    @NotNull
    public static final t0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var) {
        kotlin.jvm.internal.g0.p(j1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = j1Var.b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        if (b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters = ((kotlin.reflect.jvm.internal.impl.descriptors.g) b6).o().getParameters();
            kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = parameters;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                w1 o5 = ((kotlin.reflect.jvm.internal.impl.descriptors.j1) it.next()).o();
                kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
                arrayList.add(o5);
            }
            List<t0> upperBounds = j1Var.getUpperBounds();
            kotlin.jvm.internal.g0.o(upperBounds, "getUpperBounds(...)");
            return a(arrayList, upperBounds, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(j1Var));
        }
        if (!(b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.y)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.y) b6).getTypeParameters();
        kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list2 = typeParameters;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            w1 o6 = ((kotlin.reflect.jvm.internal.impl.descriptors.j1) it2.next()).o();
            kotlin.jvm.internal.g0.o(o6, "getTypeConstructor(...)");
            arrayList2.add(o6);
        }
        List<t0> upperBounds2 = j1Var.getUpperBounds();
        kotlin.jvm.internal.g0.o(upperBounds2, "getUpperBounds(...)");
        return a(arrayList2, upperBounds2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(j1Var));
    }
}
