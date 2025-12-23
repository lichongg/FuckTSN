package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKotlinTypeRefiner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypeRefiner.kt\norg/jetbrains/kotlin/types/checker/KotlinTypeRefinerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1563#2:91\n1634#2,3:92\n*S KotlinDebug\n*F\n+ 1 KotlinTypeRefiner.kt\norg/jetbrains/kotlin/types/checker/KotlinTypeRefinerKt\n*L\n78#1:91\n78#1:92,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final e0<t<c0>> f47171a = new e0<>("KotlinTypeRefiner");

    @NotNull
    public static final e0<t<c0>> a() {
        return f47171a;
    }

    @NotNull
    public static final List<t0> b(@NotNull g gVar, @NotNull Iterable<? extends t0> types) {
        g0.p(gVar, "<this>");
        g0.p(types, "types");
        ArrayList arrayList = new ArrayList(f0.d0(types, 10));
        Iterator<? extends t0> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a(it.next()));
        }
        return arrayList;
    }
}
