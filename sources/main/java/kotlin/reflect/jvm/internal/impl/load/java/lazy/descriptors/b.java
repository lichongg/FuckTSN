package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeclaredMemberIndex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeclaredMemberIndex.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/ClassDeclaredMemberIndex\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n996#2:67\n1025#2,3:68\n1028#2,3:78\n682#2:81\n712#2,4:82\n1163#2,3:95\n1163#2,3:98\n382#3,7:71\n774#4:86\n865#4,2:87\n1208#4,2:89\n1236#4,4:91\n*S KotlinDebug\n*F\n+ 1 DeclaredMemberIndex.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/ClassDeclaredMemberIndex\n*L\n52#1:67\n52#1:68,3\n52#1:78,3\n53#1:81\n53#1:82,4\n57#1:95,3\n60#1:98,3\n52#1:71,7\n54#1:86\n54#1:87,2\n54#1:89,2\n54#1:91,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final y3.g f45530a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<y3.q, Boolean> f45531b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function1<y3.r, Boolean> f45532c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, List<y3.r>> f45533d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, y3.n> f45534e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, y3.w> f45535f;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull y3.g jClass, @NotNull Function1<? super y3.q, Boolean> memberFilter) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        kotlin.jvm.internal.g0.p(memberFilter, "memberFilter");
        this.f45530a = jClass;
        this.f45531b = memberFilter;
        a aVar = new a(this);
        this.f45532c = aVar;
        kotlin.sequences.m P0 = kotlin.sequences.p.P0(kotlin.collections.f0.E1(jClass.r()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : P0) {
            kotlin.reflect.jvm.internal.impl.name.f name = ((y3.r) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.f45533d = linkedHashMap;
        kotlin.sequences.m P02 = kotlin.sequences.p.P0(kotlin.collections.f0.E1(this.f45530a.F()), this.f45531b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : P02) {
            linkedHashMap2.put(((y3.n) obj3).getName(), obj3);
        }
        this.f45534e = linkedHashMap2;
        Collection<y3.w> z5 = this.f45530a.z();
        Function1<y3.q, Boolean> function1 = this.f45531b;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : z5) {
            if (((Boolean) function1.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(arrayList, 10)), 16));
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((y3.w) obj5).getName(), obj5);
        }
        this.f45535f = linkedHashMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(b bVar, y3.r m6) {
        kotlin.jvm.internal.g0.p(m6, "m");
        return bVar.f45531b.invoke(m6).booleanValue() && !y3.p.c(m6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> a() {
        kotlin.sequences.m P0 = kotlin.sequences.p.P0(kotlin.collections.f0.E1(this.f45530a.r()), this.f45532c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = P0.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((y3.r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f45535f.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
    @Nullable
    public y3.n c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return this.f45534e.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        kotlin.sequences.m P0 = kotlin.sequences.p.P0(kotlin.collections.f0.E1(this.f45530a.F()), this.f45531b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = P0.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((y3.n) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
    @NotNull
    public Collection<y3.r> e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        List<y3.r> list = this.f45533d.get(name);
        return list != null ? list : kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
    @Nullable
    public y3.w f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return this.f45535f.get(name);
    }
}
