package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.ranges.t;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStandardClassIds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIdsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,341:1\n1193#2,2:342\n1267#2,4:344\n*S KotlinDebug\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIdsKt\n*L\n340#1:342,2\n340#1:344,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: private */
    public static final b l(String str) {
        c b6 = i.f46374a.b();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(b6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b m(String str) {
        c d6 = i.f46374a.d();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(d6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b n(String str) {
        c g6 = i.f46374a.g();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(g6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b o(String str) {
        c c6 = i.f46374a.c();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(c6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b p(String str) {
        c e6 = i.f46374a.e();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(e6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b q(String str) {
        c f6 = i.f46374a.f();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(f6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b s(f fVar) {
        i iVar = i.f46374a;
        c f6 = iVar.a().f();
        f h6 = f.h(fVar.getIdentifier() + iVar.a().h().getIdentifier());
        g0.o(h6, "identifier(...)");
        return new b(f6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b t(String str) {
        c h6 = i.f46374a.h();
        f h7 = f.h(str);
        g0.o(h7, "identifier(...)");
        return new b(h6, h7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b u(String str) {
        c i6 = i.f46374a.i();
        f h6 = f.h(str);
        g0.o(h6, "identifier(...)");
        return new b(i6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b v(b bVar) {
        c g6 = i.f46374a.g();
        f h6 = f.h('U' + bVar.h().getIdentifier());
        g0.o(h6, "identifier(...)");
        return new b(g6, h6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<V, K> r(Map<K, ? extends V> map) {
        Set<Map.Entry<K, ? extends V>> entrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(f0.d0(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair a6 = o0.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(a6.getFirst(), a6.getSecond());
        }
        return linkedHashMap;
    }
}
