package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeIntersectionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n3301#2,10:60\n*S KotlinDebug\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope\n*L\n36#1:60,10\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x extends kotlin.reflect.jvm.internal.impl.resolve.scopes.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f46808d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f46809b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final k f46810c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTypeIntersectionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1563#2:60\n1634#2,3:61\n*S KotlinDebug\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope$Companion\n*L\n50#1:60\n50#1:61,3\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final k a(@NotNull String message, @NotNull Collection<? extends t0> types) {
            g0.p(message, "message");
            g0.p(types, "types");
            Collection<? extends t0> collection = types;
            ArrayList arrayList = new ArrayList(f0.d0(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((t0) it.next()).r());
            }
            kotlin.reflect.jvm.internal.impl.utils.j<k> b6 = g4.a.b(arrayList);
            k b7 = b.f46733d.b(message, b6);
            return b6.size() <= 1 ? b7 : new x(message, b7, null);
        }
    }

    public /* synthetic */ x(String str, k kVar, kotlin.jvm.internal.v vVar) {
        this(str, kVar);
    }

    private x(String str, k kVar) {
        this.f46809b = str;
        this.f46810c = kVar;
    }

    @JvmStatic
    @NotNull
    public static final k n(@NotNull String str, @NotNull Collection<? extends t0> collection) {
        return f46808d.a(str, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.a o(kotlin.reflect.jvm.internal.impl.descriptors.a selectMostSpecificInEachOverridableGroup) {
        g0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.a p(d1 selectMostSpecificInEachOverridableGroup) {
        g0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.a q(w0 selectMostSpecificInEachOverridableGroup) {
        g0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.p.b(super.a(name, location), u.f46805a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.p.b(super.c(name, location), v.f46806a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h6 = super.h(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : h6) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.k) obj) instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        g0.n(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return f0.I4(kotlin.reflect.jvm.internal.impl.resolve.p.b(list, w.f46807a), list2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a
    @NotNull
    protected k j() {
        return this.f46810c;
    }
}
