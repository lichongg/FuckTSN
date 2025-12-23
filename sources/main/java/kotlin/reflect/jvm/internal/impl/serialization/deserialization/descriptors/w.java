package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.k;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class w extends kotlin.reflect.jvm.internal.impl.resolve.scopes.l {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f46920f = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(w.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(w.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.o f46921b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final a f46922c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f46923d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j f46924e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface a {
        @NotNull
        Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

        @NotNull
        Set<kotlin.reflect.jvm.internal.impl.name.f> b();

        @NotNull
        Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

        @NotNull
        Set<kotlin.reflect.jvm.internal.impl.name.f> d();

        @Nullable
        i1 e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        void f(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> collection, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1, @NotNull u3.b bVar);

        @NotNull
        Set<kotlin.reflect.jvm.internal.impl.name.f> g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$NoReorderImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,512:1\n502#1:513\n508#1:517\n508#1:532\n508#1:546\n492#1:572\n493#1,5:575\n492#1:580\n493#1,5:583\n502#1:644\n502#1:648\n1634#2,3:514\n1617#2,9:518\n1869#2:527\n1870#2:530\n1626#2:531\n1617#2,9:533\n1869#2:542\n1870#2:544\n1626#2:545\n1617#2,9:547\n1869#2:556\n1870#2:558\n1626#2:559\n1374#2:560\n1460#2,5:561\n1374#2:566\n1460#2,5:567\n865#2,2:573\n865#2,2:581\n865#2,2:588\n865#2,2:590\n865#2,2:592\n1634#2,3:594\n1617#2,9:597\n1869#2:606\n1870#2:608\n1626#2:609\n1208#2,2:610\n1236#2,4:612\n1491#2:616\n1516#2,3:617\n1519#2,3:627\n1491#2:630\n1516#2,3:631\n1519#2,3:641\n1634#2,3:645\n1634#2,3:649\n1#3:528\n1#3:529\n1#3:543\n1#3:557\n1#3:607\n382#4,7:620\n382#4,7:634\n*S KotlinDebug\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$NoReorderImplementation\n*L\n429#1:513\n432#1:517\n435#1:532\n438#1:546\n447#1:572\n447#1:575,5\n450#1:580\n450#1:583,5\n421#1:644\n425#1:648\n429#1:514,3\n432#1:518,9\n432#1:527\n432#1:530\n432#1:531\n435#1:533,9\n435#1:542\n435#1:544\n435#1:545\n438#1:547,9\n438#1:556\n438#1:558\n438#1:559\n441#1:560\n441#1:561,5\n444#1:566\n444#1:567,5\n447#1:573,2\n450#1:581,2\n473#1:588,2\n477#1:590,2\n492#1:592,2\n502#1:594,3\n508#1:597,9\n508#1:606\n508#1:608\n508#1:609\n412#1:610,2\n412#1:612,4\n415#1:616\n415#1:617,3\n415#1:627,3\n418#1:630\n418#1:631,3\n418#1:641,3\n421#1:645,3\n425#1:649,3\n432#1:529\n435#1:543\n438#1:557\n508#1:607\n415#1:620,7\n418#1:634,7\n*E\n"})
    final class b implements a {

        /* renamed from: o, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f46925o = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<ProtoBuf.Function> f46926a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<ProtoBuf.Property> f46927b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<ProtoBuf.TypeAlias> f46928c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46929d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46930e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46931f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46932g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46933h;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46934i;

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46935j;

        /* renamed from: k, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46936k;

        /* renamed from: l, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46937l;

        /* renamed from: m, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46938m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ w f46939n;

        public b(@NotNull w wVar, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            kotlin.jvm.internal.g0.p(functionList, "functionList");
            kotlin.jvm.internal.g0.p(propertyList, "propertyList");
            kotlin.jvm.internal.g0.p(typeAliasList, "typeAliasList");
            this.f46939n = wVar;
            this.f46926a = functionList;
            this.f46927b = propertyList;
            this.f46928c = wVar.t().c().g().e() ? typeAliasList : kotlin.collections.f0.J();
            this.f46929d = wVar.t().h().e(new x(this));
            this.f46930e = wVar.t().h().e(new y(this));
            this.f46931f = wVar.t().h().e(new z(this));
            this.f46932g = wVar.t().h().e(new a0(this));
            this.f46933h = wVar.t().h().e(new b0(this));
            this.f46934i = wVar.t().h().e(new c0(this));
            this.f46935j = wVar.t().h().e(new d0(this));
            this.f46936k = wVar.t().h().e(new e0(this));
            this.f46937l = wVar.t().h().e(new f0(this, wVar));
            this.f46938m = wVar.t().h().e(new g0(this, wVar));
        }

        private final List<i1> A() {
            List<ProtoBuf.TypeAlias> list = this.f46928c;
            w wVar = this.f46939n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                i1 A = wVar.t().f().A((ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.n) it.next()));
                if (A != null) {
                    arrayList.add(A);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set D(b bVar, w wVar) {
            List<ProtoBuf.Function> list = bVar.f46926a;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar2 = bVar.f46939n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(wVar2.t().g(), ((ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.n) it.next())).getName()));
            }
            return u1.C(linkedHashSet, wVar.x());
        }

        private final List<d1> F() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46932g, this, f46925o[3]);
        }

        private final List<w0> G() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46933h, this, f46925o[4]);
        }

        private final List<i1> H() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46931f, this, f46925o[2]);
        }

        private final List<d1> I() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46929d, this, f46925o[0]);
        }

        private final List<w0> J() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46930e, this, f46925o[1]);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, Collection<d1>> K() {
            return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46935j, this, f46925o[6]);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, Collection<w0>> L() {
            return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46936k, this, f46925o[7]);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, i1> M() {
            return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46934i, this, f46925o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set P(b bVar, w wVar) {
            List<ProtoBuf.Property> list = bVar.f46927b;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar2 = bVar.f46939n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(wVar2.t().g(), ((ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.n) it.next())).getName()));
            }
            return u1.C(linkedHashSet, wVar.y());
        }

        private final List<d1> u() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> x5 = this.f46939n.x();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = x5.iterator();
            while (it.hasNext()) {
                kotlin.collections.f0.s0(arrayList, x((kotlin.reflect.jvm.internal.impl.name.f) it.next()));
            }
            return arrayList;
        }

        private final List<w0> v() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> y5 = this.f46939n.y();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = y5.iterator();
            while (it.hasNext()) {
                kotlin.collections.f0.s0(arrayList, y((kotlin.reflect.jvm.internal.impl.name.f) it.next()));
            }
            return arrayList;
        }

        private final List<d1> w() {
            List<ProtoBuf.Function> list = this.f46926a;
            w wVar = this.f46939n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                d1 s5 = wVar.t().f().s((ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.n) it.next()));
                if (!wVar.B(s5)) {
                    s5 = null;
                }
                if (s5 != null) {
                    arrayList.add(s5);
                }
            }
            return arrayList;
        }

        private final List<w0> z() {
            List<ProtoBuf.Property> list = this.f46927b;
            w wVar = this.f46939n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                w0 v5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0.v(wVar.t().f(), (ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.n) it.next()), false, 2, null);
                if (v5 != null) {
                    arrayList.add(v5);
                }
            }
            return arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            if (!b().contains(name)) {
                return kotlin.collections.f0.J();
            }
            Collection<d1> collection = K().get(name);
            return collection == null ? kotlin.collections.f0.J() : collection;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46937l, this, f46925o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            if (!d().contains(name)) {
                return kotlin.collections.f0.J();
            }
            Collection<w0> collection = L().get(name);
            return collection == null ? kotlin.collections.f0.J() : collection;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46938m, this, f46925o[9]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @Nullable
        public i1 e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return M().get(name);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        public void f(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(result, "result");
            kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
            kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
            kotlin.jvm.internal.g0.p(location, "location");
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.i())) {
                for (Object obj : G()) {
                    kotlin.reflect.jvm.internal.impl.name.f name = ((w0) obj).getName();
                    kotlin.jvm.internal.g0.o(name, "getName(...)");
                    if (nameFilter.invoke(name).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.d())) {
                for (Object obj2 : F()) {
                    kotlin.reflect.jvm.internal.impl.name.f name2 = ((d1) obj2).getName();
                    kotlin.jvm.internal.g0.o(name2, "getName(...)");
                    if (nameFilter.invoke(name2).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            List<ProtoBuf.TypeAlias> list = this.f46928c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar = this.f46939n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(wVar.t().g(), ((ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.n) it.next())).getName()));
            }
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List B(b bVar) {
            return bVar.w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List C(b bVar) {
            return bVar.z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map E(b bVar) {
            List<d1> F = bVar.F();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : F) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((d1) obj).getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                Object obj2 = linkedHashMap.get(name);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(name, obj2);
                }
                ((List) obj2).add(obj);
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map N(b bVar) {
            List<w0> G = bVar.G();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : G) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((w0) obj).getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                Object obj2 = linkedHashMap.get(name);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(name, obj2);
                }
                ((List) obj2).add(obj);
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map O(b bVar) {
            List<i1> H = bVar.H();
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(kotlin.collections.i1.j(kotlin.collections.f0.d0(H, 10)), 16));
            for (Object obj : H) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((i1) obj).getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                linkedHashMap.put(name, obj);
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List r(b bVar) {
            return kotlin.collections.f0.I4(bVar.I(), bVar.u());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List s(b bVar) {
            return kotlin.collections.f0.I4(bVar.J(), bVar.v());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List t(b bVar) {
            return bVar.A();
        }

        private final List<d1> x(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            List<d1> I = I();
            w wVar = this.f46939n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : I) {
                if (kotlin.jvm.internal.g0.g(((kotlin.reflect.jvm.internal.impl.descriptors.k) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            wVar.o(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<w0> y(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            List<w0> J = J();
            w wVar = this.f46939n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : J) {
                if (kotlin.jvm.internal.g0.g(((kotlin.reflect.jvm.internal.impl.descriptors.k) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            wVar.p(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,512:1\n269#1:513\n269#1:528\n269#1:543\n287#1,17:581\n305#1,2:604\n296#1:606\n303#1:607\n305#1,2:613\n287#1,17:620\n305#1,2:642\n296#1:644\n370#1,11:645\n370#1,11:656\n1491#2:514\n1516#2,3:515\n1519#2,3:525\n1491#2:529\n1516#2,3:530\n1519#2,3:540\n1491#2:544\n1516#2,3:545\n1519#2,3:555\n1252#2,2:560\n1563#2:562\n1634#2,3:563\n1255#2:566\n1491#2:567\n1516#2,3:568\n1519#2,3:578\n1625#2:598\n1869#2:599\n1870#2:602\n1626#2:603\n1625#2:608\n1869#2:609\n1870#2:611\n1626#2:612\n1625#2:615\n1869#2:616\n1870#2:618\n1626#2:619\n1625#2:637\n1869#2:638\n1870#2:640\n1626#2:641\n382#3,7:518\n382#3,7:533\n382#3,7:548\n463#3:558\n413#3:559\n382#3,7:571\n1#4:600\n1#4:601\n1#4:610\n1#4:617\n1#4:639\n*S KotlinDebug\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation\n*L\n233#1:513\n235#1:528\n239#1:543\n272#1:581,17\n272#1:604,2\n272#1:606\n287#1:607\n287#1:613,2\n310#1:620,17\n310#1:642,2\n310#1:644\n348#1:645,11\n356#1:656,11\n233#1:514\n233#1:515,3\n233#1:525,3\n235#1:529\n235#1:530,3\n235#1:540,3\n239#1:544\n239#1:545,3\n239#1:555,3\n244#1:560,2\n246#1:562\n246#1:563,3\n244#1:566\n269#1:567\n269#1:568,3\n269#1:578,3\n272#1:598\n272#1:599\n272#1:602\n272#1:603\n287#1:608\n287#1:609\n287#1:611\n287#1:612\n303#1:615\n303#1:616\n303#1:618\n303#1:619\n310#1:637\n310#1:638\n310#1:640\n310#1:641\n233#1:518,7\n235#1:533,7\n239#1:548,7\n244#1:558\n244#1:559\n269#1:571,7\n272#1:601\n287#1:610\n303#1:617\n310#1:639\n*E\n"})
    final class c implements a {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f46940j = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(c.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(c.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> f46941a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> f46942b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> f46943c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<d1>> f46944d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<w0>> f46945e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, i1> f46946f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46947g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i f46948h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ w f46949i;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1\n*L\n1#1,512:1\n*E\n"})
        public static final class a implements Function0<Object> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.p<Object> f46950a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ByteArrayInputStream f46951b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ w f46952c;

            public a(kotlin.reflect.jvm.internal.impl.protobuf.p<Object> pVar, ByteArrayInputStream byteArrayInputStream, w wVar) {
                this.f46950a = pVar;
                this.f46951b = byteArrayInputStream;
                this.f46952c = wVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke() {
                return (kotlin.reflect.jvm.internal.impl.protobuf.n) this.f46950a.a(this.f46951b, this.f46952c.t().c().k());
            }
        }

        public c(@NotNull w wVar, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> z5;
            kotlin.jvm.internal.g0.p(functionList, "functionList");
            kotlin.jvm.internal.g0.p(propertyList, "propertyList");
            kotlin.jvm.internal.g0.p(typeAliasList, "typeAliasList");
            this.f46949i = wVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                kotlin.reflect.jvm.internal.impl.name.f b6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(wVar.t().g(), ((ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.n) obj)).getName());
                Object obj2 = linkedHashMap.get(b6);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(b6, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.f46941a = r(linkedHashMap);
            w wVar2 = this.f46949i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : propertyList) {
                kotlin.reflect.jvm.internal.impl.name.f b7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(wVar2.t().g(), ((ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.n) obj3)).getName());
                Object obj4 = linkedHashMap2.get(b7);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(b7, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.f46942b = r(linkedHashMap2);
            if (this.f46949i.t().c().g().e()) {
                w wVar3 = this.f46949i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : typeAliasList) {
                    kotlin.reflect.jvm.internal.impl.name.f b8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(wVar3.t().g(), ((ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.n) obj5)).getName());
                    Object obj6 = linkedHashMap3.get(b8);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(b8, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                z5 = r(linkedHashMap3);
            } else {
                z5 = kotlin.collections.i1.z();
            }
            this.f46943c = z5;
            this.f46944d = this.f46949i.t().h().i(new h0(this));
            this.f46945e = this.f46949i.t().h().i(new i0(this));
            this.f46946f = this.f46949i.t().h().c(new j0(this));
            this.f46947g = this.f46949i.t().h().e(new k0(this, this.f46949i));
            this.f46948h = this.f46949i.t().h().e(new l0(this, this.f46949i));
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.d1> m(kotlin.reflect.jvm.internal.impl.name.f r6) {
            /*
                r5 = this;
                java.util.Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> r0 = r5.f46941a
                kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.g0.o(r1, r2)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w r2 = r5.f46949i
                java.lang.Object r0 = r0.get(r6)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w r3 = r5.f46949i
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w$c$a r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w$c$a
                r0.<init>(r1, r4, r3)
                kotlin.sequences.m r0 = kotlin.sequences.p.u(r0)
                java.util.List r0 = kotlin.sequences.p.I3(r0)
                if (r0 == 0) goto L2c
                java.util.Collection r0 = (java.util.Collection) r0
                goto L32
            L2c:
                java.util.List r0 = kotlin.collections.f0.J()
                java.util.Collection r0 = (java.util.Collection) r0
            L32:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r3 = new java.util.ArrayList
                int r0 = r0.size()
                r3.<init>(r0)
                java.util.Iterator r0 = r1.iterator()
            L42:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L6b
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r4 = r2.t()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0 r4 = r4.f()
                kotlin.jvm.internal.g0.m(r1)
                kotlin.reflect.jvm.internal.impl.descriptors.d1 r1 = r4.s(r1)
                boolean r4 = r2.B(r1)
                if (r4 == 0) goto L64
                goto L65
            L64:
                r1 = 0
            L65:
                if (r1 == 0) goto L42
                r3.add(r1)
                goto L42
            L6b:
                r2.o(r6, r3)
                java.util.List r6 = kotlin.reflect.jvm.internal.impl.utils.a.c(r3)
                java.util.Collection r6 = (java.util.Collection) r6
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.c.m(kotlin.reflect.jvm.internal.impl.name.f):java.util.Collection");
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> n(kotlin.reflect.jvm.internal.impl.name.f r9) {
            /*
                r8 = this;
                java.util.Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> r0 = r8.f46942b
                kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.g0.o(r1, r2)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w r2 = r8.f46949i
                java.lang.Object r0 = r0.get(r9)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w r3 = r8.f46949i
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w$c$a r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w$c$a
                r0.<init>(r1, r4, r3)
                kotlin.sequences.m r0 = kotlin.sequences.p.u(r0)
                java.util.List r0 = kotlin.sequences.p.I3(r0)
                if (r0 == 0) goto L2c
                java.util.Collection r0 = (java.util.Collection) r0
                goto L32
            L2c:
                java.util.List r0 = kotlin.collections.f0.J()
                java.util.Collection r0 = (java.util.Collection) r0
            L32:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r3 = new java.util.ArrayList
                int r0 = r0.size()
                r3.<init>(r0)
                java.util.Iterator r0 = r1.iterator()
            L42:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L66
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r4 = r2.t()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0 r4 = r4.f()
                kotlin.jvm.internal.g0.m(r1)
                r5 = 2
                r6 = 0
                r7 = 0
                kotlin.reflect.jvm.internal.impl.descriptors.w0 r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0.v(r4, r1, r7, r5, r6)
                if (r1 == 0) goto L42
                r3.add(r1)
                goto L42
            L66:
                r2.p(r9, r3)
                java.util.List r9 = kotlin.reflect.jvm.internal.impl.utils.a.c(r3)
                java.util.Collection r9 = (java.util.Collection) r9
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.c.n(kotlin.reflect.jvm.internal.impl.name.f):java.util.Collection");
        }

        private final i1 o(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            ProtoBuf.TypeAlias parseDelimitedFrom;
            byte[] bArr = this.f46943c.get(fVar);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.f46949i.t().c().k())) == null) {
                return null;
            }
            return this.f46949i.t().f().A(parseDelimitedFrom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set p(c cVar, w wVar) {
            return u1.C(cVar.f46941a.keySet(), wVar.x());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection q(c cVar, kotlin.reflect.jvm.internal.impl.name.f it) {
            kotlin.jvm.internal.g0.p(it, "it");
            return cVar.m(it);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> r(Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.i1.j(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.a) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(n1.f44123a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection s(c cVar, kotlin.reflect.jvm.internal.impl.name.f it) {
            kotlin.jvm.internal.g0.p(it, "it");
            return cVar.n(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final i1 t(c cVar, kotlin.reflect.jvm.internal.impl.name.f it) {
            kotlin.jvm.internal.g0.p(it, "it");
            return cVar.o(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set u(c cVar, w wVar) {
            return u1.C(cVar.f46942b.keySet(), wVar.y());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            return !b().contains(name) ? kotlin.collections.f0.J() : this.f46944d.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46947g, this, f46940j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            return !d().contains(name) ? kotlin.collections.f0.J() : this.f46945e.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46948h, this, f46940j[1]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @Nullable
        public i1 e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return this.f46946f.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        public void f(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(result, "result");
            kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
            kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
            kotlin.jvm.internal.g0.p(location, "location");
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.i())) {
                Set<kotlin.reflect.jvm.internal.impl.name.f> d6 = d();
                ArrayList arrayList = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.name.f fVar : d6) {
                    if (nameFilter.invoke(fVar).booleanValue()) {
                        arrayList.addAll(c(fVar, location));
                    }
                }
                k.b INSTANCE = k.b.f46724a;
                kotlin.jvm.internal.g0.o(INSTANCE, "INSTANCE");
                kotlin.collections.f0.r0(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.d())) {
                Set<kotlin.reflect.jvm.internal.impl.name.f> b6 = b();
                ArrayList arrayList2 = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : b6) {
                    if (nameFilter.invoke(fVar2).booleanValue()) {
                        arrayList2.addAll(a(fVar2, location));
                    }
                }
                k.b INSTANCE2 = k.b.f46724a;
                kotlin.jvm.internal.g0.o(INSTANCE2, "INSTANCE");
                kotlin.collections.f0.r0(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            return this.f46943c.keySet();
        }
    }

    protected abstract void k(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> collection, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.name.b q(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> w();

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> x();

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> y();

    protected w(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.o c6, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, @NotNull List<ProtoBuf.TypeAlias> typeAliasList, @NotNull Function0<? extends Collection<kotlin.reflect.jvm.internal.impl.name.f>> classNames) {
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(functionList, "functionList");
        kotlin.jvm.internal.g0.p(propertyList, "propertyList");
        kotlin.jvm.internal.g0.p(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.g0.p(classNames, "classNames");
        this.f46921b = c6;
        this.f46922c = r(functionList, propertyList, typeAliasList);
        this.f46923d = c6.h().e(new u(classNames));
        this.f46924e = c6.h().g(new v(this));
    }

    private final a r(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        return this.f46921b.c().g().c() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d s(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        return this.f46921b.c().b(q(fVar));
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> v() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.b(this.f46924e, this, f46920f[1]);
    }

    private final i1 z(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        return this.f46922c.e(fVar);
    }

    protected boolean A(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return u().contains(name);
    }

    protected boolean B(@NotNull d1 function) {
        kotlin.jvm.internal.g0.p(function, "function");
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return this.f46922c.a(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f46922c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return this.f46922c.c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return this.f46922c.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        if (A(name)) {
            return s(name);
        }
        if (this.f46922c.g().contains(name)) {
            return z(name);
        }
        return null;
    }

    @NotNull
    protected final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> n(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        kotlin.jvm.internal.g0.p(location, "location");
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c;
        if (kindFilter.a(aVar.g())) {
            k(arrayList, nameFilter);
        }
        this.f46922c.f(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.a(aVar.c())) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : u()) {
                if (nameFilter.invoke(fVar).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, s(fVar));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.h())) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : this.f46922c.g()) {
                if (nameFilter.invoke(fVar2).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, this.f46922c.e(fVar2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
    }

    protected void o(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<d1> functions) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(functions, "functions");
    }

    protected void p(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<w0> descriptors) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(descriptors, "descriptors");
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.o t() {
        return this.f46921b;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.f> u() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46923d, this, f46920f[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set l(Function0 function0) {
        return kotlin.collections.f0.f6((Iterable) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set m(w wVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> w5 = wVar.w();
        if (w5 == null) {
            return null;
        }
        return u1.C(u1.C(wVar.u(), wVar.f46922c.g()), w5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return v();
    }
}
