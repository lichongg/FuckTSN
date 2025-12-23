package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.k0;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.x0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntersectionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/IntersectionTypeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,183:1\n1563#2:184\n1634#2,3:185\n1563#2:188\n1634#2,3:189\n1563#2:192\n1634#2,3:193\n*S KotlinDebug\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/IntersectionTypeKt\n*L\n26#1:184\n26#1:185,3\n38#1:188\n38#1:189,3\n58#1:192\n58#1:193,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {
    @NotNull
    public static final m2 a(@NotNull Collection<? extends m2> types) {
        e1 Q0;
        g0.p(types, "types");
        int size = types.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (m2) f0.k5(types);
        }
        Collection<? extends m2> collection = types;
        ArrayList arrayList = new ArrayList(f0.d0(collection, 10));
        boolean z5 = false;
        boolean z6 = false;
        for (m2 m2Var : collection) {
            z5 = z5 || x0.a(m2Var);
            if (m2Var instanceof e1) {
                Q0 = (e1) m2Var;
            } else {
                if (!(m2Var instanceof k0)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (kotlin.reflect.jvm.internal.impl.types.g0.a(m2Var)) {
                    return m2Var;
                }
                Q0 = ((k0) m2Var).Q0();
                z6 = true;
            }
            arrayList.add(Q0);
        }
        if (z5) {
            return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, types.toString());
        }
        if (!z6) {
            return b0.f47159a.d(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(f0.d0(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(n0.d((m2) it.next()));
        }
        b0 b0Var = b0.f47159a;
        return w0.e(b0Var.d(arrayList), b0Var.d(arrayList2));
    }
}
