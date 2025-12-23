package kotlin.reflect.jvm.internal.impl.load.java;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuiltinSpecialProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/BuiltinSpecialProperties\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,50:1\n1563#2:51\n1634#2,3:52\n1504#2:55\n1534#2,3:56\n1537#2,3:66\n1252#2,4:71\n1563#2:78\n1634#2,3:79\n382#3,7:59\n463#3:69\n413#3:70\n153#4,3:75\n*S KotlinDebug\n*F\n+ 1 BuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/BuiltinSpecialProperties\n*L\n31#1:51\n31#1:52,3\n32#1:55\n32#1:56,3\n32#1:66,3\n33#1:71,4\n42#1:78\n42#1:79,3\n32#1:59,7\n33#1:69\n33#1:70\n37#1:75,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f45440a = new i();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> f45441b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.f, List<kotlin.reflect.jvm.internal.impl.name.f>> f45442c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45443d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45444e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f45445f;

    static {
        kotlin.reflect.jvm.internal.impl.name.c d6;
        kotlin.reflect.jvm.internal.impl.name.c d7;
        kotlin.reflect.jvm.internal.impl.name.c c6;
        kotlin.reflect.jvm.internal.impl.name.c c7;
        kotlin.reflect.jvm.internal.impl.name.c d8;
        kotlin.reflect.jvm.internal.impl.name.c c8;
        kotlin.reflect.jvm.internal.impl.name.c c9;
        kotlin.reflect.jvm.internal.impl.name.c c10;
        kotlin.reflect.jvm.internal.impl.name.c c11;
        kotlin.reflect.jvm.internal.impl.name.c c12;
        kotlin.reflect.jvm.internal.impl.name.c c13;
        kotlin.reflect.jvm.internal.impl.name.d dVar = o.a.f44619s;
        d6 = j.d(dVar, CommonNetImpl.NAME);
        Pair a6 = kotlin.o0.a(d6, kotlin.reflect.jvm.internal.impl.builtins.o.f44569m);
        d7 = j.d(dVar, "ordinal");
        Pair a7 = kotlin.o0.a(d7, kotlin.reflect.jvm.internal.impl.name.f.h("ordinal"));
        c6 = j.c(o.a.X, "size");
        Pair a8 = kotlin.o0.a(c6, kotlin.reflect.jvm.internal.impl.name.f.h("size"));
        kotlin.reflect.jvm.internal.impl.name.c cVar = o.a.f44586b0;
        c7 = j.c(cVar, "size");
        Pair a9 = kotlin.o0.a(c7, kotlin.reflect.jvm.internal.impl.name.f.h("size"));
        d8 = j.d(o.a.f44595g, "length");
        Pair a10 = kotlin.o0.a(d8, kotlin.reflect.jvm.internal.impl.name.f.h("length"));
        c8 = j.c(cVar, "keys");
        Pair a11 = kotlin.o0.a(c8, kotlin.reflect.jvm.internal.impl.name.f.h("keySet"));
        c9 = j.c(cVar, "values");
        Pair a12 = kotlin.o0.a(c9, kotlin.reflect.jvm.internal.impl.name.f.h("values"));
        c10 = j.c(cVar, "entries");
        Pair a13 = kotlin.o0.a(c10, kotlin.reflect.jvm.internal.impl.name.f.h("entrySet"));
        c11 = j.c(o.a.P0, "size");
        Pair a14 = kotlin.o0.a(c11, kotlin.reflect.jvm.internal.impl.name.f.h("length"));
        c12 = j.c(o.a.Q0, "size");
        Pair a15 = kotlin.o0.a(c12, kotlin.reflect.jvm.internal.impl.name.f.h("length"));
        c13 = j.c(o.a.R0, "size");
        Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> W = i1.W(a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, kotlin.o0.a(c13, kotlin.reflect.jvm.internal.impl.name.f.h("length")));
        f45441b = W;
        Set<Map.Entry<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f>> entrySet = W.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(kotlin.collections.f0.d0(entrySet, 10));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((kotlin.reflect.jvm.internal.impl.name.c) entry.getKey()).f(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) pair.getSecond();
            Object obj = linkedHashMap.get(fVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(fVar, obj);
            }
            ((List) obj).add((kotlin.reflect.jvm.internal.impl.name.f) pair.getFirst());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(i1.j(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), kotlin.collections.f0.e2((Iterable) entry2.getValue()));
        }
        f45442c = linkedHashMap2;
        Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> map = f45441b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> entry3 : map.entrySet()) {
            kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.n(entry3.getKey().d().i());
            kotlin.jvm.internal.g0.m(n6);
            linkedHashSet.add(n6.a().b(entry3.getValue()));
        }
        f45443d = linkedHashSet;
        Set<kotlin.reflect.jvm.internal.impl.name.c> keySet = f45441b.keySet();
        f45444e = keySet;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(keySet, 10));
        Iterator<T> it2 = keySet.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((kotlin.reflect.jvm.internal.impl.name.c) it2.next()).f());
        }
        f45445f = kotlin.collections.f0.f6(arrayList2);
    }

    @NotNull
    public final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> a() {
        return f45441b;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.name.f> b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name1) {
        kotlin.jvm.internal.g0.p(name1, "name1");
        List<kotlin.reflect.jvm.internal.impl.name.f> list = f45442c.get(name1);
        return list == null ? kotlin.collections.f0.J() : list;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.c> c() {
        return f45444e;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return f45445f;
    }

    private i() {
    }
}
