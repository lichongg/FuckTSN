package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.j;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n295#2,2:430\n774#2:432\n865#2,2:433\n1563#2:435\n1634#2,3:436\n1563#2:439\n1634#2,3:440\n1617#2,9:443\n1869#2:452\n1870#2:454\n1626#2:455\n669#2,11:457\n1#3:453\n1#3:456\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor\n*L\n141#1:430,2\n153#1:432\n153#1:433,2\n153#1:435\n153#1:436,3\n159#1:439\n159#1:440,3\n190#1:443,9\n190#1:452\n190#1:454\n190#1:455\n220#1:457,11\n190#1:453\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a implements kotlin.reflect.jvm.internal.impl.descriptors.u {

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g A;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.Class f46864g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f46865h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final e1 f46866i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b f46867j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final Modality f46868k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.s f46869l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final ClassKind f46870m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.o f46871n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f46872o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.l f46873p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final b f46874q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final c1<a> f46875r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    private final c f46876s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f46877t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.descriptors.c> f46878u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.c>> f46879v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.descriptors.d> f46880w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.d>> f46881x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j<o1<kotlin.reflect.jvm.internal.impl.types.e1>> f46882y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private final m0.a f46883z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,429:1\n1563#2:430\n1634#2,3:431\n1460#2,5:435\n1460#2,5:440\n1#3:434\n211#4,5:445\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassMemberScope\n*L\n274#1:430\n274#1:431,3\n354#1:435,5\n360#1:440,5\n366#1:445,5\n*E\n"})
    final class a extends w {

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f46884g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> f46885h;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.types.t0>> f46886i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ n f46887j;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n$a$a, reason: collision with other inner class name */
        public static final class C0916a extends kotlin.reflect.jvm.internal.impl.resolve.l {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List<D> f46888a;

            C0916a(List<D> list) {
                this.f46888a = list;
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.m
            public void a(CallableMemberDescriptor fakeOverride) {
                kotlin.jvm.internal.g0.p(fakeOverride, "fakeOverride");
                OverridingUtil.K(fakeOverride, null);
                this.f46888a.add(fakeOverride);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.l
            protected void e(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
                kotlin.jvm.internal.g0.p(fromSuper, "fromSuper");
                kotlin.jvm.internal.g0.p(fromCurrent, "fromCurrent");
                if (fromCurrent instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.s) {
                    ((kotlin.reflect.jvm.internal.impl.descriptors.impl.s) fromCurrent).P0(kotlin.reflect.jvm.internal.impl.descriptors.t.f45040a, fromSuper);
                }
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n r8, kotlin.reflect.jvm.internal.impl.types.checker.g r9) {
            /*
                r7 = this;
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.g0.p(r9, r0)
                r7.f46887j = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r2 = r8.Y0()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.Z0()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "getFunctionList(...)"
                kotlin.jvm.internal.g0.o(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.Z0()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "getPropertyList(...)"
                kotlin.jvm.internal.g0.o(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.Z0()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "getTypeAliasList(...)"
                kotlin.jvm.internal.g0.o(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.Z0()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "getNestedClassNameList(...)"
                kotlin.jvm.internal.g0.o(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r8 = r8.Y0()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r8 = r8.g()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.f0.d0(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L58:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L70
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.f r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(r8, r6)
                r1.add(r6)
                goto L58
            L70:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k
                r6.<init>(r1)
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r1.f46884g = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r8 = r7.t()
                kotlin.reflect.jvm.internal.impl.storage.n r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.i r8 = r8.e(r9)
                r1.f46885h = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r8 = r7.t()
                kotlin.reflect.jvm.internal.impl.storage.n r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.i r8 = r8.e(r9)
                r1.f46886i = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n.a.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n, kotlin.reflect.jvm.internal.impl.types.checker.g):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection G(a aVar) {
            return aVar.n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46751o, kotlin.reflect.jvm.internal.impl.resolve.scopes.k.f46777a.c(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        }

        private final <D extends CallableMemberDescriptor> void H(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends D> collection, List<D> list) {
            t().c().n().b().v(fVar, collection, new ArrayList(list), I(), new C0916a(list));
        }

        private final n I() {
            return this.f46887j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection J(a aVar) {
            return aVar.f46884g.g(aVar.I());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        protected boolean B(@NotNull d1 function) {
            kotlin.jvm.internal.g0.p(function, "function");
            return t().c().t().a(this.f46887j, function);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
        @NotNull
        public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            e(name, location);
            return super.a(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            e(name, location);
            return super.c(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
        public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            t3.a.a(t().c().p(), location, I(), name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            kotlin.reflect.jvm.internal.impl.descriptors.d i6;
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(location, "location");
            e(name, location);
            c cVar = I().f46876s;
            return (cVar == null || (i6 = cVar.i(name)) == null) ? super.g(name, location) : i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
            kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
            kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
            return this.f46885h.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        protected void k(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
            kotlin.jvm.internal.g0.p(result, "result");
            kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
            c cVar = I().f46876s;
            List d6 = cVar != null ? cVar.d() : null;
            if (d6 == null) {
                d6 = kotlin.collections.f0.J();
            }
            result.addAll(d6);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        protected void o(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<d1> functions) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(functions, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator<kotlin.reflect.jvm.internal.impl.types.t0> it = this.f46886i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().r().a(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            functions.addAll(t().c().c().d(name, this.f46887j));
            H(name, arrayList, functions);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        protected void p(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<w0> descriptors) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(descriptors, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator<kotlin.reflect.jvm.internal.impl.types.t0> it = this.f46886i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().r().c(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            H(name, arrayList, descriptors);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        @NotNull
        protected kotlin.reflect.jvm.internal.impl.name.b q(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return this.f46887j.f46867j.d(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        @Nullable
        protected Set<kotlin.reflect.jvm.internal.impl.name.f> w() {
            List<kotlin.reflect.jvm.internal.impl.types.t0> i6 = I().f46874q.i();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = i6.iterator();
            while (it.hasNext()) {
                Set<kotlin.reflect.jvm.internal.impl.name.f> f6 = ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().f();
                if (f6 == null) {
                    return null;
                }
                kotlin.collections.f0.s0(linkedHashSet, f6);
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        @NotNull
        protected Set<kotlin.reflect.jvm.internal.impl.name.f> x() {
            List<kotlin.reflect.jvm.internal.impl.types.t0> i6 = I().f46874q.i();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = i6.iterator();
            while (it.hasNext()) {
                kotlin.collections.f0.s0(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().b());
            }
            linkedHashSet.addAll(t().c().c().e(this.f46887j));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w
        @NotNull
        protected Set<kotlin.reflect.jvm.internal.impl.name.f> y() {
            List<kotlin.reflect.jvm.internal.impl.types.t0> i6 = I().f46874q.i();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = i6.iterator();
            while (it.hasNext()) {
                kotlin.collections.f0.s0(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().d());
            }
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List C(List list) {
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1563#2:430\n1634#2,3:431\n1617#2,9:434\n1869#2:443\n1870#2:445\n1626#2:446\n1563#2:447\n1634#2,3:448\n1#3:444\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassTypeConstructor\n*L\n241#1:430\n241#1:431,3\n245#1:434,9\n245#1:443\n245#1:445\n245#1:446\n252#1:447\n252#1:448,3\n245#1:444\n*E\n"})
    final class b extends kotlin.reflect.jvm.internal.impl.types.b {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i<List<j1>> f46889d;

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public boolean d() {
            return true;
        }

        public b() {
            super(n.this.Y0().h());
            this.f46889d = n.this.Y0().h().e(new o(n.this));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b, kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        /* renamed from: K, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public n c() {
            return n.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public List<j1> getParameters() {
            return this.f46889d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected Collection<kotlin.reflect.jvm.internal.impl.types.t0> r() {
            String b6;
            kotlin.reflect.jvm.internal.impl.name.c a6;
            List<ProtoBuf.Type> p5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.p(n.this.Z0(), n.this.Y0().j());
            n nVar = n.this;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(p5, 10));
            Iterator<T> it = p5.iterator();
            while (it.hasNext()) {
                arrayList.add(nVar.Y0().i().u((ProtoBuf.Type) it.next()));
            }
            List I4 = kotlin.collections.f0.I4(arrayList, n.this.Y0().c().c().c(n.this));
            ArrayList<k0.b> arrayList2 = new ArrayList();
            Iterator it2 = I4.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((kotlin.reflect.jvm.internal.impl.types.t0) it2.next()).I0().c();
                k0.b bVar = c6 instanceof k0.b ? (k0.b) c6 : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.v j6 = n.this.Y0().c().j();
                n nVar2 = n.this;
                ArrayList arrayList3 = new ArrayList(kotlin.collections.f0.d0(arrayList2, 10));
                for (k0.b bVar2 : arrayList2) {
                    kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(bVar2);
                    if (n6 == null || (a6 = n6.a()) == null || (b6 = a6.a()) == null) {
                        b6 = bVar2.getName().b();
                        kotlin.jvm.internal.g0.o(b6, "asString(...)");
                    }
                    arrayList3.add(b6);
                }
                j6.b(nVar2, arrayList3);
            }
            return kotlin.collections.f0.a6(I4);
        }

        @NotNull
        public String toString() {
            String fVar = n.this.getName().toString();
            kotlin.jvm.internal.g0.o(fVar, "toString(...)");
            return fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected h1 v() {
            return h1.a.f44688a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List L(n nVar) {
            return n1.g(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$EnumEntryClassDescriptors\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1208#2,2:430\n1236#2,4:432\n1634#2,3:436\n1634#2,3:439\n1617#2,9:442\n1869#2:451\n1870#2:453\n1626#2:454\n1#3:452\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$EnumEntryClassDescriptors\n*L\n389#1:430,2\n389#1:432,4\n421#1:436,3\n422#1:439,3\n426#1:442,9\n426#1:451\n426#1:453\n426#1:454\n426#1:452\n*E\n"})
    final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, ProtoBuf.EnumEntry> f46891a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> f46892b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f46893c;

        public c() {
            List<ProtoBuf.EnumEntry> enumEntryList = n.this.Z0().getEnumEntryList();
            kotlin.jvm.internal.g0.o(enumEntryList, "getEnumEntryList(...)");
            List<ProtoBuf.EnumEntry> list = enumEntryList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(n.this.Y0().g(), ((ProtoBuf.EnumEntry) obj).getName()), obj);
            }
            this.f46891a = linkedHashMap;
            this.f46892b = n.this.Y0().h().c(new p(this, n.this));
            this.f46893c = n.this.Y0().h().e(new q(this));
        }

        private final Set<kotlin.reflect.jvm.internal.impl.name.f> e() {
            HashSet hashSet = new HashSet();
            Iterator<kotlin.reflect.jvm.internal.impl.types.t0> it = n.this.o().i().iterator();
            while (it.hasNext()) {
                for (kotlin.reflect.jvm.internal.impl.descriptors.k kVar : n.a.a(it.next().r(), null, null, 3, null)) {
                    if ((kVar instanceof d1) || (kVar instanceof w0)) {
                        hashSet.add(((CallableMemberDescriptor) kVar).getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = n.this.Z0().getFunctionList();
            kotlin.jvm.internal.g0.o(functionList, "getFunctionList(...)");
            n nVar = n.this;
            Iterator<T> it2 = functionList.iterator();
            while (it2.hasNext()) {
                hashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(nVar.Y0().g(), ((ProtoBuf.Function) it2.next()).getName()));
            }
            List<ProtoBuf.Property> propertyList = n.this.Z0().getPropertyList();
            kotlin.jvm.internal.g0.o(propertyList, "getPropertyList(...)");
            n nVar2 = n.this;
            Iterator<T> it3 = propertyList.iterator();
            while (it3.hasNext()) {
                hashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(nVar2.Y0().g(), ((ProtoBuf.Property) it3.next()).getName()));
            }
            return u1.C(hashSet, hashSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.d f(c cVar, n nVar, kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            ProtoBuf.EnumEntry enumEntry = cVar.f46891a.get(name);
            if (enumEntry != null) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.q.G0(nVar.Y0().h(), nVar, name, cVar.f46893c, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(nVar.Y0().h(), new r(nVar, enumEntry)), e1.f44683a);
            }
            return null;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> d() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> keySet = this.f46891a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.d i6 = i((kotlin.reflect.jvm.internal.impl.name.f) it.next());
                if (i6 != null) {
                    arrayList.add(i6);
                }
            }
            return arrayList;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.descriptors.d i(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return this.f46892b.invoke(name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List g(n nVar, ProtoBuf.EnumEntry enumEntry) {
            return kotlin.collections.f0.a6(nVar.Y0().c().d().c(nVar.d1(), enumEntry));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set h(c cVar) {
            return cVar.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class d extends AdaptedFunctionReference implements Function1<ProtoBuf.Type, kotlin.reflect.jvm.internal.impl.types.e1> {
        d(Object obj) {
            super(1, obj, v0.class, "simpleType", "simpleType(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;Z)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.types.e1 invoke(ProtoBuf.Type p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return v0.q((v0) this.receiver, p02, false, 2, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class e extends FunctionReferenceImpl implements Function1<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.types.e1> {
        e(Object obj) {
            super(1, obj, n.class, "getValueClassPropertyType", "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.types.e1 invoke(kotlin.reflect.jvm.internal.impl.name.f p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return ((n) this.receiver).e1(p02);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class f extends FunctionReferenceImpl implements Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, a> {
        f(Object obj) {
            super(1, obj, a.class, "<init>", "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final a invoke(kotlin.reflect.jvm.internal.impl.types.checker.g p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return new a((n) this.receiver, p02);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.o outerContext, @NotNull ProtoBuf.Class classProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull e1 sourceElement) {
        super(outerContext.h(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.a(nameResolver, classProto.getFqName()).h());
        kotlin.reflect.jvm.internal.impl.resolve.scopes.l lVar;
        kotlin.jvm.internal.g0.p(outerContext, "outerContext");
        kotlin.jvm.internal.g0.p(classProto, "classProto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.g0.p(sourceElement, "sourceElement");
        this.f46864g = classProto;
        this.f46865h = metadataVersion;
        this.f46866i = sourceElement;
        this.f46867j = kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.a(nameResolver, classProto.getFqName());
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.n0 n0Var = kotlin.reflect.jvm.internal.impl.serialization.deserialization.n0.f47030a;
        this.f46868k = n0Var.b(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e.d(classProto.getFlags()));
        this.f46869l = kotlin.reflect.jvm.internal.impl.serialization.deserialization.o0.a(n0Var, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d.d(classProto.getFlags()));
        ClassKind a6 = n0Var.a(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46211f.d(classProto.getFlags()));
        this.f46870m = a6;
        List<ProtoBuf.TypeParameter> typeParameterList = classProto.getTypeParameterList();
        kotlin.jvm.internal.g0.o(typeParameterList, "getTypeParameterList(...)");
        ProtoBuf.TypeTable typeTable = classProto.getTypeTable();
        kotlin.jvm.internal.g0.o(typeTable, "getTypeTable(...)");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.h(typeTable);
        j.a aVar = kotlin.reflect.jvm.internal.impl.metadata.deserialization.j.f46256b;
        ProtoBuf.VersionRequirementTable versionRequirementTable = classProto.getVersionRequirementTable();
        kotlin.jvm.internal.g0.o(versionRequirementTable, "getVersionRequirementTable(...)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.o a7 = outerContext.a(this, typeParameterList, nameResolver, hVar, aVar.a(versionRequirementTable), metadataVersion);
        this.f46871n = a7;
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46218m.d(classProto.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        boolean booleanValue = d6.booleanValue();
        this.f46872o = booleanValue;
        ClassKind classKind = ClassKind.ENUM_CLASS;
        if (a6 == classKind) {
            lVar = new kotlin.reflect.jvm.internal.impl.resolve.scopes.q(a7.h(), this, booleanValue || kotlin.jvm.internal.g0.g(a7.c().i().a(), Boolean.TRUE));
        } else {
            lVar = k.c.f46780b;
        }
        this.f46873p = lVar;
        this.f46874q = new b();
        this.f46875r = c1.f44676e.a(this, a7.h(), a7.c().n().c(), new f(this));
        this.f46876s = a6 == classKind ? new c() : null;
        kotlin.reflect.jvm.internal.impl.descriptors.k e6 = outerContext.e();
        this.f46877t = e6;
        this.f46878u = a7.h().g(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e(this));
        this.f46879v = a7.h().e(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f(this));
        this.f46880w = a7.h().g(new g(this));
        this.f46881x = a7.h().e(new h(this));
        this.f46882y = a7.h().g(new i(this));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.d g6 = a7.g();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h j6 = a7.j();
        n nVar = e6 instanceof n ? (n) e6 : null;
        this.f46883z = new m0.a(classProto, g6, j6, sourceElement, nVar != null ? nVar.f46883z : null);
        this.A = !kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.d(classProto.getFlags()).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b() : new s0(a7.h(), new j(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List P0(n nVar) {
        return kotlin.collections.f0.a6(nVar.f46871n.c().d().b(nVar.f46883z));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d R0() {
        if (!this.f46864g.hasCompanionObjectName()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f g6 = a1().g(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(this.f46871n.g(), this.f46864g.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) g6;
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.c T0() {
        Object obj;
        if (this.f46870m.isSingleton()) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.i l6 = kotlin.reflect.jvm.internal.impl.resolve.h.l(this, e1.f44683a);
            l6.b1(s());
            return l6;
        }
        List<ProtoBuf.Constructor> constructorList = this.f46864g.getConstructorList();
        kotlin.jvm.internal.g0.o(constructorList, "getConstructorList(...)");
        Iterator<T> it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46219n.d(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor != null) {
            return this.f46871n.f().r(constructor, true);
        }
        return null;
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.c> U0() {
        List<ProtoBuf.Constructor> constructorList = this.f46864g.getConstructorList();
        kotlin.jvm.internal.g0.o(constructorList, "getConstructorList(...)");
        ArrayList<ProtoBuf.Constructor> arrayList = new ArrayList();
        for (Object obj : constructorList) {
            Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46219n.d(((ProtoBuf.Constructor) obj).getFlags());
            kotlin.jvm.internal.g0.o(d6, "get(...)");
            if (d6.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(arrayList, 10));
        for (ProtoBuf.Constructor constructor : arrayList) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0 f6 = this.f46871n.f();
            kotlin.jvm.internal.g0.m(constructor);
            arrayList2.add(f6.r(constructor, false));
        }
        return arrayList2;
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> V0() {
        if (this.f46868k != Modality.SEALED) {
            return kotlin.collections.f0.J();
        }
        List<Integer> sealedSubclassFqNameList = this.f46864g.getSealedSubclassFqNameList();
        kotlin.jvm.internal.g0.m(sealedSubclassFqNameList);
        if (sealedSubclassFqNameList.isEmpty()) {
            return kotlin.reflect.jvm.internal.impl.resolve.a.f46650a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.m c6 = this.f46871n.c();
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.d g6 = this.f46871n.g();
            kotlin.jvm.internal.g0.m(num);
            kotlin.reflect.jvm.internal.impl.descriptors.d b6 = c6.b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.a(g6, num.intValue()));
            if (b6 != null) {
                arrayList.add(b6);
            }
        }
        return arrayList;
    }

    private final a a1() {
        return this.f46875r.c(this.f46871n.c().n().c());
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.o Y0() {
        return this.f46871n;
    }

    @NotNull
    public final ProtoBuf.Class Z0() {
        return this.f46864g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        return this.f46877t;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a b1() {
        return this.f46865h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.l r0() {
        return this.f46873p;
    }

    @NotNull
    public final m0.a d1() {
        return this.f46883z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f() {
        return this.f46879v.invoke();
    }

    public final boolean f1(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return a1().u().contains(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public o1<kotlin.reflect.jvm.internal.impl.types.e1> g0() {
        return this.f46882y.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        return this.f46866i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        return this.f46869l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind h() {
        return this.f46870m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        return this.f46868k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46214i.d(this.f46864g.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        return d6.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46216k.d(this.f46864g.getFlags()).booleanValue() && this.f46865h.e(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public List<z0> j0() {
        List<ProtoBuf.Type> b6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.b(this.f46864g, this.f46871n.j());
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(b6, 10));
        Iterator<T> it = b6.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.n0(V(), new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.b(this, this.f46871n.i().u((ProtoBuf.Type) it.next()), null, null), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean k() {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46212g.d(this.f46864g.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        return d6.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean l0() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46211f.d(this.f46864g.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        return this.f46874q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.resolve.scopes.k o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f46875r.c(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46215j.d(this.f46864g.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        return d6.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d s0() {
        return this.f46880w.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        return this.f46871n.i().m();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(q0() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean u() {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46217l.d(this.f46864g.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        return d6.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46216k.d(this.f46864g.getFlags()).booleanValue() && this.f46865h.c(1, 4, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean w() {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46213h.d(this.f46864g.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        return d6.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c z() {
        return this.f46878u.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d Q0(n nVar) {
        return nVar.R0();
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> S0() {
        return kotlin.collections.f0.I4(kotlin.collections.f0.I4(U0(), kotlin.collections.f0.R(z())), this.f46871n.c().c().b(this));
    }

    private final o1<kotlin.reflect.jvm.internal.impl.types.e1> W0() {
        if (!isInline() && !v()) {
            return null;
        }
        o1<kotlin.reflect.jvm.internal.impl.types.e1> b6 = x0.b(this.f46864g, this.f46871n.g(), this.f46871n.j(), new d(this.f46871n.i()), new e(this));
        if (b6 != null) {
            return b6;
        }
        if (this.f46865h.c(1, 5, 1)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.c z5 = z();
        if (z5 != null) {
            List<q1> g6 = z5.g();
            kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.name.f name = ((q1) kotlin.collections.f0.G2(g6)).getName();
            kotlin.jvm.internal.g0.o(name, "getName(...)");
            kotlin.reflect.jvm.internal.impl.types.e1 e12 = e1(name);
            if (e12 != null) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.z(name, e12);
            }
            throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
        }
        throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection X0(n nVar) {
        return nVar.S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
    
        if (r1 == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.types.e1 e1(kotlin.reflect.jvm.internal.impl.name.f r6) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n$a r0 = r5.a1()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            java.util.Collection r6 = r0.c(r6, r1)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r0 = 0
            r1 = 0
            r2 = r0
        L13:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L2d
            java.lang.Object r3 = r6.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.w0 r4 = (kotlin.reflect.jvm.internal.impl.descriptors.w0) r4
            kotlin.reflect.jvm.internal.impl.descriptors.z0 r4 = r4.f0()
            if (r4 != 0) goto L13
            if (r1 == 0) goto L2a
        L28:
            r2 = r0
            goto L30
        L2a:
            r1 = 1
            r2 = r3
            goto L13
        L2d:
            if (r1 != 0) goto L30
            goto L28
        L30:
            kotlin.reflect.jvm.internal.impl.descriptors.w0 r2 = (kotlin.reflect.jvm.internal.impl.descriptors.w0) r2
            if (r2 == 0) goto L38
            kotlin.reflect.jvm.internal.impl.types.t0 r0 = r2.getType()
        L38:
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = (kotlin.reflect.jvm.internal.impl.types.e1) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n.e1(kotlin.reflect.jvm.internal.impl.name.f):kotlin.reflect.jvm.internal.impl.types.e1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.c g1(n nVar) {
        return nVar.T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection h1(n nVar) {
        return nVar.V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o1 i1(n nVar) {
        return nVar.W0();
    }
}
