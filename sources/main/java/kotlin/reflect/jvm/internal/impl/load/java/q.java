package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFakePureImplementationsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FakePureImplementationsProvider.kt\norg/jetbrains/kotlin/load/java/FakePureImplementationsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,38:1\n1299#2,4:39\n11228#3:43\n11563#3,3:44\n126#4:47\n153#4,3:48\n*S KotlinDebug\n*F\n+ 1 FakePureImplementationsProvider.kt\norg/jetbrains/kotlin/load/java/FakePureImplementationsProvider\n*L\n18#1:39,4\n36#1:43\n36#1:44,3\n32#1:47\n32#1:48,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f45732a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f45733b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> f45734c;

    static {
        q qVar = new q();
        f45732a = qVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f45733b = linkedHashMap;
        kotlin.reflect.jvm.internal.impl.name.i iVar = kotlin.reflect.jvm.internal.impl.name.i.f46374a;
        qVar.c(iVar.m(), qVar.a("java.util.ArrayList", "java.util.LinkedList"));
        qVar.c(iVar.o(), qVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        qVar.c(iVar.n(), qVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        qVar.c(aVar.c(new kotlin.reflect.jvm.internal.impl.name.c("java.util.function.Function")), qVar.a("java.util.function.UnaryOperator"));
        qVar.c(aVar.c(new kotlin.reflect.jvm.internal.impl.name.c("java.util.function.BiFunction")), qVar.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(kotlin.o0.a(((kotlin.reflect.jvm.internal.impl.name.b) entry.getKey()).a(), ((kotlin.reflect.jvm.internal.impl.name.b) entry.getValue()).a()));
        }
        f45734c = i1.B0(arrayList);
    }

    private final List<kotlin.reflect.jvm.internal.impl.name.b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(new kotlin.reflect.jvm.internal.impl.name.c(str)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c(kotlin.reflect.jvm.internal.impl.name.b bVar, List<kotlin.reflect.jvm.internal.impl.name.b> list) {
        Map<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> map = f45733b;
        for (Object obj : list) {
            map.put(obj, bVar);
        }
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c classFqName) {
        kotlin.jvm.internal.g0.p(classFqName, "classFqName");
        return f45734c.get(classFqName);
    }

    private q() {
    }
}
