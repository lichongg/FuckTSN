package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.z;
import kotlin.reflect.jvm.internal.impl.load.kotlin.b0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c0;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.z0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.impl.utils.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmBuiltInsCustomizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInsCustomizer.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,376:1\n1761#2,3:377\n1617#2,9:380\n1869#2:389\n1870#2:391\n1626#2:392\n1563#2:393\n1634#2,3:394\n774#2:397\n865#2:398\n1761#2,3:399\n866#2:402\n774#2:403\n865#2:404\n2746#2,3:405\n866#2:408\n1563#2:409\n1634#2,3:410\n1761#2,3:413\n1617#2,9:416\n1869#2:425\n1870#2:427\n1626#2:428\n1#3:390\n1#3:426\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInsCustomizer.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer\n*L\n120#1:377,3\n136#1:380,9\n136#1:389\n136#1:391\n136#1:392\n195#1:393\n195#1:394,3\n209#1:397\n209#1:398\n214#1:399,3\n209#1:402\n317#1:403\n317#1:404\n319#1:405,3\n317#1:408\n326#1:409\n326#1:410,3\n353#1:413,3\n257#1:416,9\n257#1:425\n257#1:427\n257#1:428\n136#1:390\n257#1:426\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t implements r3.a, r3.c {

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44511i = {o0.u(new PropertyReference1Impl(t.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), o0.u(new PropertyReference1Impl(t.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), o0.u(new PropertyReference1Impl(t.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final f0 f44512a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.d f44513b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44514c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final t0 f44515d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44516e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.a<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.d> f44517f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44518g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<Pair<String, String>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g> f44519h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44520a = new a("HIDDEN", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final a f44521b = new a("VISIBLE", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final a f44522c = new a("DEPRECATED_LIST_METHODS", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final a f44523d = new a("NOT_CONSIDERED", 3);

        /* renamed from: e, reason: collision with root package name */
        public static final a f44524e = new a("DROP", 4);

        /* renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ a[] f44525f;

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ kotlin.enums.a f44526g;

        private static final /* synthetic */ a[] a() {
            return new a[]{f44520a, f44521b, f44522c, f44523d, f44524e};
        }

        static {
            a[] a6 = a();
            f44525f = a6;
            f44526g = kotlin.enums.c.c(a6);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f44525f.clone();
        }

        private a(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends h0 {
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
        /* renamed from: E0, reason: merged with bridge method [inline-methods] */
        public k.c r() {
            return k.c.f46780b;
        }

        c(f0 f0Var, kotlin.reflect.jvm.internal.impl.name.c cVar) {
            super(f0Var, cVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends b.AbstractC0925b<kotlin.reflect.jvm.internal.impl.descriptors.d, a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f44528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<a> f44529b;

        d(String str, Ref.ObjectRef<a> objectRef) {
            this.f44528a = str;
            this.f44529b = objectRef;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.t$a] */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.t$a] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.t$a] */
        /* JADX WARN: Type inference failed for: r0v7, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.t$a] */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC0925b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.d javaClassDescriptor) {
            g0.p(javaClassDescriptor, "javaClassDescriptor");
            String a6 = b0.a(kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a, javaClassDescriptor, this.f44528a);
            w wVar = w.f44533a;
            if (wVar.f().contains(a6)) {
                this.f44529b.element = a.f44520a;
            } else if (wVar.i().contains(a6)) {
                this.f44529b.element = a.f44521b;
            } else if (wVar.c().contains(a6)) {
                this.f44529b.element = a.f44522c;
            } else if (wVar.d().contains(a6)) {
                this.f44529b.element = a.f44524e;
            }
            return this.f44529b.element == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = this.f44529b.element;
            return aVar == null ? a.f44523d : aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44527a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.f44520a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.f44522c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.f44523d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.f44524e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.f44521b.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f44527a = iArr;
        }
    }

    public t(@NotNull f0 moduleDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Function0<JvmBuiltIns.a> settingsComputation) {
        g0.p(moduleDescriptor, "moduleDescriptor");
        g0.p(storageManager, "storageManager");
        g0.p(settingsComputation, "settingsComputation");
        this.f44512a = moduleDescriptor;
        this.f44513b = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f44483a;
        this.f44514c = storageManager.e(settingsComputation);
        this.f44515d = q(storageManager);
        this.f44516e = storageManager.e(new k(this, storageManager));
        this.f44517f = storageManager.d();
        this.f44518g = storageManager.e(new l(this));
        this.f44519h = storageManager.i(new m(this));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g C() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44518g, this, f44511i[2]);
    }

    private final JvmBuiltIns.a D() {
        return (JvmBuiltIns.a) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44514c, this, f44511i[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g I(t tVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.c(tVar.f44512a.p(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null)));
    }

    private final t0 q(kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.k kVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.k(new c(this.f44512a, new kotlin.reflect.jvm.internal.impl.name.c("java.io")), kotlin.reflect.jvm.internal.impl.name.f.h("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, kotlin.collections.f0.l(new z0(nVar, new n(this))), e1.f44683a, false, nVar);
        kVar.F0(k.c.f46780b, u1.k(), null);
        kotlin.reflect.jvm.internal.impl.types.e1 s5 = kVar.s();
        g0.o(s5, "getDefaultType(...)");
        return s5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 r(t tVar) {
        kotlin.reflect.jvm.internal.impl.types.e1 i6 = tVar.f44512a.p().i();
        g0.o(i6, "getAnyType(...)");
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g s(t tVar, Pair pair) {
        g0.p(pair, "<destruct>");
        String str = (String) pair.component1();
        String str2 = (String) pair.component2();
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.b(tVar.f44512a.p(), '\'' + str + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + str2 + "()' stdlib extension instead", str2 + "()", "HIDDEN", false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d u(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.load.java.components.j EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.j.f45398a;
        g0.o(EMPTY, "EMPTY");
        return nVar.K0(EMPTY, dVar);
    }

    private final kotlin.reflect.jvm.internal.impl.types.e1 v() {
        return (kotlin.reflect.jvm.internal.impl.types.e1) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44516e, this, f44511i[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection x(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.k it) {
        g0.p(it, "it");
        return it.a(fVar, NoLookupLocation.FROM_BUILTINS);
    }

    @Override // r3.c
    public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull d1 functionDescriptor) {
        g0.p(classDescriptor, "classDescriptor");
        g0.p(functionDescriptor, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n z5 = z(classDescriptor);
        if (z5 == null || !functionDescriptor.getAnnotations().l(r3.d.a())) {
            return true;
        }
        if (!D().b()) {
            return false;
        }
        String c6 = c0.c(functionDescriptor, false, false, 3, null);
        z H = z5.H();
        kotlin.reflect.jvm.internal.impl.name.f name = functionDescriptor.getName();
        g0.o(name, "getName(...)");
        Collection<d1> a6 = H.a(name, NoLookupLocation.FROM_BUILTINS);
        if ((a6 instanceof Collection) && a6.isEmpty()) {
            return false;
        }
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            if (g0.g(c0.c((d1) it.next(), false, false, 3, null), c6)) {
                return true;
            }
        }
        return false;
    }

    @Override // r3.a
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        g0.p(classDescriptor, "classDescriptor");
        if (classDescriptor.h() != ClassKind.CLASS || !D().b()) {
            return kotlin.collections.f0.J();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n z5 = z(classDescriptor);
        if (z5 == null) {
            return kotlin.collections.f0.J();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d f6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f(this.f44513b, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(z5), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f44461i.a(), null, 4, null);
        if (f6 == null) {
            return kotlin.collections.f0.J();
        }
        h2 c6 = x.a(f6, z5).c();
        List<kotlin.reflect.jvm.internal.impl.descriptors.c> f7 = z5.f();
        ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.c> arrayList = new ArrayList();
        for (Object obj : f7) {
            kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) obj;
            if (cVar.getVisibility().d()) {
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f8 = f6.f();
                g0.o(f8, "getConstructors(...)");
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> collection = f8;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar2 : collection) {
                        g0.m(cVar2);
                        if (w(cVar2, c6, cVar)) {
                            break;
                        }
                    }
                }
                if (!H(cVar, classDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.j.l0(cVar) && !w.f44533a.e().contains(b0.a(kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a, z5, c0.c(cVar, false, false, 3, null)))) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(arrayList, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar3 : arrayList) {
            y.a<? extends y> n6 = cVar3.n();
            n6.r(classDescriptor);
            n6.h(classDescriptor.s());
            n6.g();
            n6.c(c6.j());
            if (!w.f44533a.h().contains(b0.a(kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a, z5, c0.c(cVar3, false, false, 3, null)))) {
                n6.l(C());
            }
            y build = n6.build();
            g0.n(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.c) build);
        }
        return arrayList2;
    }

    @Override // r3.a
    @NotNull
    public Collection<t0> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        g0.p(classDescriptor, "classDescriptor");
        kotlin.reflect.jvm.internal.impl.name.d p5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(classDescriptor);
        w wVar = w.f44533a;
        return wVar.j(p5) ? kotlin.collections.f0.Q(v(), this.f44515d) : wVar.k(p5) ? kotlin.collections.f0.l(this.f44515d) : kotlin.collections.f0.J();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b8 A[SYNTHETIC] */
    @Override // r3.a
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.d1> d(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r7, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.d r8) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.t.d(kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d):java.util.Collection");
    }

    @Override // r3.a
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.jvm.internal.impl.name.f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        z H;
        Set<kotlin.reflect.jvm.internal.impl.name.f> b6;
        g0.p(classDescriptor, "classDescriptor");
        if (!D().b()) {
            return u1.k();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n z5 = z(classDescriptor);
        return (z5 == null || (H = z5.H()) == null || (b6 = H.b()) == null) ? u1.k() : b6;
    }

    private final a A(y yVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = yVar.b();
        g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object b7 = kotlin.reflect.jvm.internal.impl.utils.b.b(kotlin.collections.f0.l((kotlin.reflect.jvm.internal.impl.descriptors.d) b6), new s(this), new d(c0.c(yVar, false, false, 3, null), new Ref.ObjectRef()));
        g0.o(b7, "dfs(...)");
        return (a) b7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable B(t tVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar2;
        Collection<t0> i6 = dVar.o().i();
        g0.o(i6, "getSupertypes(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = i6.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((t0) it.next()).I0().c();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n nVar = null;
            if (c6 != null) {
                fVar = c6.a();
            } else {
                fVar = null;
            }
            if (fVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) fVar;
            } else {
                dVar2 = null;
            }
            if (dVar2 != null && (nVar = tVar.z(dVar2)) == null) {
                nVar = dVar2;
            }
            if (nVar != null) {
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    private final boolean E(d1 d1Var, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = d1Var.b();
        g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String c6 = c0.c(d1Var, false, false, 3, null);
        if (z5 ^ w.f44533a.g().contains(b0.a(kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a, (kotlin.reflect.jvm.internal.impl.descriptors.d) b6, c6))) {
            return true;
        }
        Boolean e6 = kotlin.reflect.jvm.internal.impl.utils.b.e(kotlin.collections.f0.l(d1Var), q.f44508a, new r(this));
        g0.o(e6, "ifAny(...)");
        return e6.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable F(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.a().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean G(t tVar, CallableMemberDescriptor callableMemberDescriptor) {
        boolean z5;
        if (callableMemberDescriptor.h() == CallableMemberDescriptor.Kind.DECLARATION) {
            kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = tVar.f44513b;
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = callableMemberDescriptor.b();
            g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (dVar.c((kotlin.reflect.jvm.internal.impl.descriptors.d) b6)) {
                z5 = true;
                return Boolean.valueOf(z5);
            }
        }
        z5 = false;
        return Boolean.valueOf(z5);
    }

    private final boolean H(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.name.d dVar2;
        if (jVar.g().size() == 1) {
            List<q1> g6 = jVar.g();
            g0.o(g6, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((q1) kotlin.collections.f0.m5(g6)).getType().I0().c();
            if (c6 != null) {
                dVar2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(c6);
            } else {
                dVar2 = null;
            }
            if (g0.g(dVar2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(dVar))) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.e1 o(t tVar, kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.x.d(tVar.D().a(), g.f44487d.a(), new k0(nVar, tVar.D().a())).s();
    }

    private final d1 p(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n nVar, d1 d1Var) {
        y.a<? extends d1> n6 = d1Var.n();
        n6.r(nVar);
        n6.p(kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e);
        n6.h(nVar.s());
        n6.a(nVar.V());
        d1 build = n6.build();
        g0.m(build);
        return build;
    }

    private final Collection<d1> t(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.k, ? extends Collection<? extends d1>> function1) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n z5 = z(dVar);
        if (z5 == null) {
            return kotlin.collections.f0.J();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> g6 = this.f44513b.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(z5), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f44461i.a());
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.collections.f0.y3(g6);
        if (dVar2 == null) {
            return kotlin.collections.f0.J();
        }
        k.b bVar = kotlin.reflect.jvm.internal.impl.utils.k.f47493c;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(g6, 10));
        Iterator<T> it = g6.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o((kotlin.reflect.jvm.internal.impl.descriptors.d) it.next()));
        }
        kotlin.reflect.jvm.internal.impl.utils.k b6 = bVar.b(arrayList);
        boolean c6 = this.f44513b.c(dVar);
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k H = this.f44517f.a(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(z5), new p(z5, dVar2)).H();
        g0.o(H, "getUnsubstitutedMemberScope(...)");
        Collection<? extends d1> invoke = function1.invoke(H);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : invoke) {
            d1 d1Var = (d1) obj;
            if (d1Var.h() == CallableMemberDescriptor.Kind.DECLARATION && d1Var.getVisibility().d() && !kotlin.reflect.jvm.internal.impl.builtins.j.l0(d1Var)) {
                Collection<? extends y> e6 = d1Var.e();
                g0.o(e6, "getOverriddenDescriptors(...)");
                Collection<? extends y> collection = e6;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.k b7 = ((y) it2.next()).b();
                        g0.o(b7, "getContainingDeclaration(...)");
                        if (b6.contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(b7))) {
                            break;
                        }
                    }
                }
                if (!E(d1Var, c6)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    private static final boolean w(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, h2 h2Var, kotlin.reflect.jvm.internal.impl.descriptors.j jVar2) {
        if (OverridingUtil.x(jVar, jVar2.c(h2Var)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
            return true;
        }
        return false;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n z(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.name.b n6;
        kotlin.reflect.jvm.internal.impl.name.c a6;
        if (kotlin.reflect.jvm.internal.impl.builtins.j.b0(dVar) || !kotlin.reflect.jvm.internal.impl.builtins.j.C0(dVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.d p5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(dVar);
        if (p5.f() && (n6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.n(p5)) != null && (a6 = n6.a()) != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d d6 = kotlin.reflect.jvm.internal.impl.descriptors.q.d(D().a(), a6, NoLookupLocation.FROM_BUILTINS);
            if (d6 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n) {
                return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n) d6;
            }
        }
        return null;
    }
}
