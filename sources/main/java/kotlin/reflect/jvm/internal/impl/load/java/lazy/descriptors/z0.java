package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.utils.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaStaticClassScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaStaticClassScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaStaticClassScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,171:1\n1491#2:172\n1516#2,3:173\n1519#2,3:183\n1563#2:192\n1634#2,3:193\n382#3,7:176\n77#4:186\n97#4,5:187\n*S KotlinDebug\n*F\n+ 1 LazyJavaStaticClassScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaStaticClassScope\n*L\n112#1:172\n112#1:173,3\n112#1:183,3\n168#1:192\n168#1:193,3\n112#1:176,7\n114#1:186\n114#1:187,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z0 extends a1 {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final y3.g f45668n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.c f45669o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends b.AbstractC0925b<kotlin.reflect.jvm.internal.impl.descriptors.d, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f45670a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<R> f45671b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<kotlin.reflect.jvm.internal.impl.resolve.scopes.k, Collection<R>> f45672c;

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, Set<R> set, Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.k, ? extends Collection<? extends R>> function1) {
            this.f45670a = dVar;
            this.f45671b = set;
            this.f45672c = function1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC0925b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.d current) {
            kotlin.jvm.internal.g0.p(current, "current");
            if (current == this.f45670a) {
                return true;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k r02 = current.r0();
            kotlin.jvm.internal.g0.o(r02, "getStaticScope(...)");
            if (!(r02 instanceof a1)) {
                return true;
            }
            this.f45671b.addAll((Collection) this.f45672c.invoke(r02));
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return n1.f44123a;
        }

        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull y3.g jClass, @NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.c ownerDescriptor) {
        super(c6);
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        kotlin.jvm.internal.g0.p(ownerDescriptor, "ownerDescriptor");
        this.f45668n = jClass;
        this.f45669o = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n0(y3.q it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection o0(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.k it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.c(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection p0(kotlin.reflect.jvm.internal.impl.resolve.scopes.k it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void C(@NotNull Collection<d1> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(result, "result");
        kotlin.jvm.internal.g0.p(name, "name");
        Collection<? extends d1> e6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, v0(name, S()), result, S(), M().a().c(), M().a().k().b());
        kotlin.jvm.internal.g0.o(e6, "resolveOverridesForStaticMembers(...)");
        result.addAll(e6);
        if (this.f45668n.E()) {
            if (kotlin.jvm.internal.g0.g(name, kotlin.reflect.jvm.internal.impl.builtins.o.f44562f)) {
                d1 g6 = kotlin.reflect.jvm.internal.impl.resolve.h.g(S());
                kotlin.jvm.internal.g0.o(g6, "createEnumValueOfMethod(...)");
                result.add(g6);
            } else if (kotlin.jvm.internal.g0.g(name, kotlin.reflect.jvm.internal.impl.builtins.o.f44560d)) {
                d1 h6 = kotlin.reflect.jvm.internal.impl.resolve.h.h(S());
                kotlin.jvm.internal.g0.o(h6, "createEnumValuesMethod(...)");
                result.add(h6);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a1, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void D(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> result) {
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> collection;
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(result, "result");
        Set q02 = q0(S(), new LinkedHashSet(), new w0(name));
        if (result.isEmpty()) {
            fVar = name;
            collection = result;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : q02) {
                kotlin.reflect.jvm.internal.impl.descriptors.w0 u02 = u0((kotlin.reflect.jvm.internal.impl.descriptors.w0) obj);
                Object obj2 = linkedHashMap.get(u02);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(u02, obj2);
                }
                ((List) obj2).add(obj);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection e6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(fVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, S(), M().a().c(), M().a().k().b());
                kotlin.jvm.internal.g0.o(e6, "resolveOverridesForStaticMembers(...)");
                kotlin.collections.f0.s0(arrayList, e6);
            }
            collection.addAll(arrayList);
        } else {
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> e7 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, q02, result, S(), M().a().c(), M().a().k().b());
            fVar = name;
            collection = result;
            kotlin.jvm.internal.g0.o(e7, "resolveOverridesForStaticMembers(...)");
            collection.addAll(e7);
        }
        if (this.f45668n.E() && kotlin.jvm.internal.g0.g(fVar, kotlin.reflect.jvm.internal.impl.builtins.o.f44561e)) {
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection, kotlin.reflect.jvm.internal.impl.resolve.h.f(S()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> E(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        Set<kotlin.reflect.jvm.internal.impl.name.f> e6 = kotlin.collections.f0.e6(O().invoke().d());
        q0(S(), e6, v0.f45653a);
        if (this.f45668n.E()) {
            e6.add(kotlin.reflect.jvm.internal.impl.builtins.o.f44561e);
        }
        return e6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b A() {
        return new b(this.f45668n, u0.f45650a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.load.java.descriptors.c S() {
        return this.f45669o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> w(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        return u1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> y(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        Set<kotlin.reflect.jvm.internal.impl.name.f> e6 = kotlin.collections.f0.e6(O().invoke().a());
        z0 b6 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.b(S());
        Set<kotlin.reflect.jvm.internal.impl.name.f> b7 = b6 != null ? b6.b() : null;
        if (b7 == null) {
            b7 = u1.k();
        }
        e6.addAll(b7);
        if (this.f45668n.E()) {
            e6.addAll(kotlin.collections.f0.Q(kotlin.reflect.jvm.internal.impl.builtins.o.f44562f, kotlin.reflect.jvm.internal.impl.builtins.o.f44560d));
        }
        e6.addAll(M().a().w().g(S(), M()));
        return e6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void z(@NotNull Collection<d1> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(result, "result");
        kotlin.jvm.internal.g0.p(name, "name");
        M().a().w().e(S(), name, result, M());
    }

    private final <R> Set<R> q0(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, Set<R> set, Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.k, ? extends Collection<? extends R>> function1) {
        kotlin.reflect.jvm.internal.impl.utils.b.b(kotlin.collections.f0.l(dVar), x0.f45657a, new a(dVar, set, function1));
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable r0(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = dVar.o().i();
        kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
        return kotlin.sequences.p.l0(kotlin.sequences.p.S1(kotlin.collections.f0.E1(i6), y0.f45659a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d s0(kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.w0 u0(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var) {
        if (w0Var.h().isReal()) {
            return w0Var;
        }
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> e6 = w0Var.e();
        kotlin.jvm.internal.g0.o(e6, "getOverriddenDescriptors(...)");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> collection = e6;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(collection, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var2 : collection) {
            kotlin.jvm.internal.g0.m(w0Var2);
            arrayList.add(u0(w0Var2));
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.w0) kotlin.collections.f0.m5(kotlin.collections.f0.e2(arrayList));
    }

    private final Set<d1> v0(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        z0 b6 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.b(dVar);
        if (b6 == null) {
            return u1.k();
        }
        return kotlin.collections.f0.f6(b6.a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }
}
