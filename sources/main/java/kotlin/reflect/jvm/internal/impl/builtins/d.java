package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCompanionObjectMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompanionObjectMapping.kt\norg/jetbrains/kotlin/builtins/CompanionObjectMapping\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,20:1\n1563#2:21\n1634#2,3:22\n1634#2,3:25\n*S KotlinDebug\n*F\n+ 1 CompanionObjectMapping.kt\norg/jetbrains/kotlin/builtins/CompanionObjectMapping\n*L\n12#1:21\n12#1:22,3\n16#1:25,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f44402a = new d();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.b> f44403b;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        ArrayList arrayList = new ArrayList(f0.d0(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(o.c((PrimitiveType) it.next()));
        }
        List J4 = f0.J4(f0.J4(f0.J4(arrayList, o.a.f44597h.m()), o.a.f44601j.m()), o.a.f44619s.m());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        Iterator it2 = J4.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(aVar.c((kotlin.reflect.jvm.internal.impl.name.c) it2.next()));
        }
        f44403b = linkedHashSet;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.b> a() {
        return f44403b;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.b> b() {
        return f44403b;
    }

    private d() {
    }
}
