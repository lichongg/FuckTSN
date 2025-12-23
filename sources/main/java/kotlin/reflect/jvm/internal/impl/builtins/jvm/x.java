package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmappingUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 mappingUtil.kt\norg/jetbrains/kotlin/builtins/jvm/MappingUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1563#2:25\n1634#2,3:26\n1563#2:29\n1634#2,3:30\n*S KotlinDebug\n*F\n+ 1 mappingUtil.kt\norg/jetbrains/kotlin/builtins/jvm/MappingUtilKt\n*L\n20#1:25\n20#1:26,3\n21#1:29\n21#1:30,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x {
    @NotNull
    public static final x1 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d from, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d to) {
        g0.p(from, "from");
        g0.p(to, "to");
        from.t().size();
        to.t().size();
        x1.a aVar = x1.f47366c;
        List<j1> t5 = from.t();
        g0.o(t5, "getDeclaredTypeParameters(...)");
        List<j1> list = t5;
        ArrayList arrayList = new ArrayList(f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((j1) it.next()).o());
        }
        List<j1> t6 = to.t();
        g0.o(t6, "getDeclaredTypeParameters(...)");
        List<j1> list2 = t6;
        ArrayList arrayList2 = new ArrayList(f0.d0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            e1 s5 = ((j1) it2.next()).s();
            g0.o(s5, "getDefaultType(...)");
            arrayList2.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e(s5));
        }
        return x1.a.e(aVar, i1.B0(f0.o6(arrayList, arrayList2)), false, 2, null);
    }
}
