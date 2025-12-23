package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKClassImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n1634#2,3:415\n*S KotlinDebug\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl\n*L\n409#1:415,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0<T> extends KDeclarationContainerImpl implements kotlin.reflect.d<T>, d1, c3 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f44361f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44362g;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Class<T> f44363d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.s<h0<T>.b> f44364e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nKClassImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl$Data\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n4154#2:415\n4254#2,2:416\n11546#2,9:435\n13472#2:444\n13473#2:446\n11555#2:447\n11228#2:471\n11563#2,3:472\n1563#3:418\n1634#3,3:419\n1617#3,9:422\n1869#3:431\n1870#3:433\n1626#3:434\n1563#3:448\n1634#3,3:449\n1634#3,3:452\n1740#3,3:455\n1617#3,9:458\n1869#3:467\n1870#3:469\n1626#3:470\n1#4:432\n1#4:445\n1#4:468\n*S KotlinDebug\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl$Data\n*L\n85#1:415\n85#1:416,2\n136#1:435,9\n136#1:444\n136#1:446\n136#1:447\n198#1:471\n198#1:472,3\n121#1:418\n121#1:419,3\n132#1:422,9\n132#1:431\n132#1:433\n132#1:434\n159#1:448\n159#1:449,3\n165#1:452,3\n182#1:455,3\n196#1:458,9\n196#1:467\n196#1:469\n196#1:470\n132#1:432\n136#1:445\n196#1:468\n*E\n"})
    public final class b extends KDeclarationContainerImpl.b {

        /* renamed from: x, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f44365x = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.s f44366d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final f3.a f44367e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final f3.a f44368f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final f3.a f44369g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final f3.a f44370h;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        private final f3.a f44371i;

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final f3.a f44372j;

        /* renamed from: k, reason: collision with root package name */
        @NotNull
        private final kotlin.s f44373k;

        /* renamed from: l, reason: collision with root package name */
        @NotNull
        private final f3.a f44374l;

        /* renamed from: m, reason: collision with root package name */
        @NotNull
        private final f3.a f44375m;

        /* renamed from: n, reason: collision with root package name */
        @NotNull
        private final f3.a f44376n;

        /* renamed from: o, reason: collision with root package name */
        @NotNull
        private final f3.a f44377o;

        /* renamed from: p, reason: collision with root package name */
        @NotNull
        private final f3.a f44378p;

        /* renamed from: q, reason: collision with root package name */
        @NotNull
        private final f3.a f44379q;

        /* renamed from: r, reason: collision with root package name */
        @NotNull
        private final f3.a f44380r;

        /* renamed from: s, reason: collision with root package name */
        @NotNull
        private final f3.a f44381s;

        /* renamed from: t, reason: collision with root package name */
        @NotNull
        private final f3.a f44382t;

        /* renamed from: u, reason: collision with root package name */
        @NotNull
        private final f3.a f44383u;

        /* renamed from: v, reason: collision with root package name */
        @NotNull
        private final f3.a f44384v;

        public b() {
            super();
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.f44366d = kotlin.t.b(lazyThreadSafetyMode, new i0(this));
            this.f44367e = f3.c(new t0(h0.this));
            this.f44368f = f3.c(new v0(h0.this));
            this.f44369g = f3.c(new w0(h0.this, this));
            this.f44370h = f3.c(new x0(h0.this));
            this.f44371i = f3.c(new y0(h0.this));
            this.f44372j = f3.c(new z0(this, h0.this));
            this.f44373k = kotlin.t.b(lazyThreadSafetyMode, new a1(this, h0.this));
            this.f44374l = f3.c(new b1(this, h0.this));
            this.f44375m = f3.c(new c1(this, h0.this));
            this.f44376n = f3.c(new j0(h0.this, this));
            this.f44377o = f3.c(new k0(h0.this));
            this.f44378p = f3.c(new l0(h0.this));
            this.f44379q = f3.c(new m0(h0.this));
            this.f44380r = f3.c(new n0(h0.this));
            this.f44381s = f3.c(new o0(this));
            this.f44382t = f3.c(new p0(this));
            this.f44383u = f3.c(new q0(this));
            this.f44384v = f3.c(new r0(this));
        }

        private final Collection<e0<?>> P() {
            T b6 = this.f44378p.b(this, f44365x[10]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        private final Collection<e0<?>> R() {
            T b6 = this.f44379q.b(this, f44365x[11]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        private final Collection<e0<?>> S() {
            T b6 = this.f44380r.b(this, f44365x[12]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type l0() {
            return Object.class;
        }

        @NotNull
        public final Collection<e0<?>> I() {
            T b6 = this.f44384v.b(this, f44365x[16]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @NotNull
        public final Collection<e0<?>> J() {
            T b6 = this.f44381s.b(this, f44365x[13]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @NotNull
        public final Collection<e0<?>> K() {
            T b6 = this.f44382t.b(this, f44365x[14]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @NotNull
        public final List<Annotation> L() {
            T b6 = this.f44368f.b(this, f44365x[1]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (List) b6;
        }

        @NotNull
        public final Collection<kotlin.reflect.i<T>> M() {
            T b6 = this.f44371i.b(this, f44365x[4]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @NotNull
        public final Collection<e0<?>> N() {
            T b6 = this.f44383u.b(this, f44365x[15]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @NotNull
        public final Collection<e0<?>> O() {
            T b6 = this.f44377o.b(this, f44365x[9]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.d Q() {
            T b6 = this.f44367e.b(this, f44365x[0]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) b6;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.km.g T() {
            return (kotlin.reflect.jvm.internal.impl.km.g) this.f44366d.getValue();
        }

        @NotNull
        public final Collection<kotlin.reflect.d<?>> U() {
            T b6 = this.f44372j.b(this, f44365x[5]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @Nullable
        public final T V() {
            return (T) this.f44373k.getValue();
        }

        @Nullable
        public final String W() {
            return (String) this.f44370h.b(this, f44365x[3]);
        }

        @NotNull
        public final List<kotlin.reflect.d<? extends T>> X() {
            T b6 = this.f44376n.b(this, f44365x[8]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (List) b6;
        }

        @Nullable
        public final String Y() {
            return (String) this.f44369g.b(this, f44365x[2]);
        }

        @NotNull
        public final List<kotlin.reflect.r> Z() {
            T b6 = this.f44375m.b(this, f44365x[7]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (List) b6;
        }

        @NotNull
        public final List<kotlin.reflect.s> a0() {
            T b6 = this.f44374l.b(this, f44365x[6]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (List) b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List A(b bVar) {
            return kotlin.collections.f0.I4(bVar.P(), bVar.S());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List B(h0 h0Var) {
            Annotation[] annotations = h0Var.c().getAnnotations();
            kotlin.jvm.internal.g0.o(annotations, "getAnnotations(...)");
            ArrayList arrayList = new ArrayList();
            for (Annotation annotation : annotations) {
                if (!h0.f44362g.contains(l3.a.e(l3.a.a(annotation)).getName())) {
                    arrayList.add(annotation);
                }
            }
            return p3.v(arrayList);
        }

        private final String C(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.g0.m(simpleName);
                return kotlin.text.u.K5(simpleName, enclosingMethod.getName() + kotlin.text.v0.f47959c, null, 2, null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                kotlin.jvm.internal.g0.m(simpleName);
                return kotlin.text.u.K5(simpleName, enclosingConstructor.getName() + kotlin.text.v0.f47959c, null, 2, null);
            }
            kotlin.jvm.internal.g0.m(simpleName);
            return kotlin.text.u.J5(simpleName, kotlin.text.v0.f47959c, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List D(h0 h0Var) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> P = h0Var.P();
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(P, 10));
            Iterator<T> it = P.iterator();
            while (it.hasNext()) {
                arrayList.add(new m1(h0Var, (kotlin.reflect.jvm.internal.impl.descriptors.j) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List E(b bVar) {
            return kotlin.collections.f0.I4(bVar.O(), bVar.P());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection F(h0 h0Var) {
            return h0Var.S(h0Var.n0(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection G(h0 h0Var) {
            return h0Var.S(h0Var.p0(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.d H(h0 h0Var) {
            kotlin.reflect.jvm.internal.impl.descriptors.d b6;
            kotlin.reflect.jvm.internal.impl.name.b i02 = h0Var.i0();
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k b7 = h0Var.j0().getValue().b();
            kotlin.reflect.jvm.internal.impl.descriptors.f0 b8 = b7.b();
            if (i02.i() && h0Var.c().isAnnotationPresent(Metadata.class)) {
                b6 = b7.a().b(i02);
            } else {
                b6 = kotlin.reflect.jvm.internal.impl.descriptors.x.b(b8, i02);
            }
            if (b6 == null) {
                return h0Var.g0(i02, b7);
            }
            return b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection b0(h0 h0Var) {
            return h0Var.S(h0Var.n0(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection c0(h0 h0Var) {
            return h0Var.S(h0Var.p0(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.km.g d0(b bVar) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n nVar;
            kotlin.reflect.jvm.internal.impl.descriptors.d Q = bVar.Q();
            if (Q instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) {
                nVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) Q;
            } else {
                nVar = null;
            }
            if (nVar == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.km.internal.g.i(nVar.Z0(), nVar.Y0().g(), false, null, 6, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List e0(b bVar, h0 h0Var) {
            kotlin.reflect.jvm.internal.impl.km.g T = bVar.T();
            if (T != null) {
                kotlin.reflect.jvm.internal.impl.name.b b6 = d3.b(T.k());
                ClassLoader j6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(h0Var.c());
                List<String> l6 = T.l();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = l6.iterator();
                while (it.hasNext()) {
                    kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h((String) it.next());
                    kotlin.jvm.internal.g0.o(h6, "identifier(...)");
                    kotlin.reflect.d dVar = null;
                    Class q5 = p3.q(j6, b6.d(h6), 0, 2, null);
                    if (q5 != null) {
                        dVar = l3.a.i(q5);
                    }
                    if (dVar != null) {
                        arrayList.add(dVar);
                    }
                }
                return arrayList;
            }
            Class<?>[] declaredClasses = h0Var.c().getDeclaredClasses();
            kotlin.jvm.internal.g0.o(declaredClasses, "getDeclaredClasses(...)");
            ArrayList arrayList2 = new ArrayList();
            for (Class<?> cls : declaredClasses) {
                kotlin.jvm.internal.g0.m(cls);
                kotlin.reflect.d i6 = l3.a.i(cls);
                if (i6 != null) {
                    arrayList2.add(i6);
                }
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object f0(b bVar, h0 h0Var) {
            Field declaredField;
            kotlin.reflect.jvm.internal.impl.km.g T = bVar.T();
            if (T == null || (kotlin.reflect.jvm.internal.impl.km.a.a(T) != ClassKind.OBJECT && kotlin.reflect.jvm.internal.impl.km.a.a(T) != ClassKind.COMPANION_OBJECT)) {
                return null;
            }
            if (kotlin.reflect.jvm.internal.impl.km.a.a(T) == ClassKind.COMPANION_OBJECT && !kotlin.collections.f0.a2(kotlin.reflect.jvm.internal.impl.builtins.d.f44402a.b(), d3.b(T.k()).e())) {
                declaredField = h0Var.c().getEnclosingClass().getDeclaredField(d3.c(T.k()));
            } else {
                declaredField = h0Var.c().getDeclaredField("INSTANCE");
            }
            Object obj = declaredField.get(null);
            kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String g0(h0 h0Var) {
            if (!h0Var.c().isAnonymousClass()) {
                kotlin.reflect.jvm.internal.impl.name.b i02 = h0Var.i0();
                if (i02.i()) {
                    return null;
                }
                return i02.a().a();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List h0(h0 h0Var, b bVar) {
            List J;
            ClassLoader j6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(h0Var.c());
            kotlin.reflect.jvm.internal.impl.km.g T = bVar.T();
            if (T != null) {
                List<String> m6 = T.m();
                J = new ArrayList();
                Iterator<T> it = m6.iterator();
                while (it.hasNext()) {
                    kotlin.reflect.d<?> a6 = d3.a(j6, (String) it.next());
                    if (a6 != null) {
                        J.add(a6);
                    }
                }
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b bVar2 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f44984a;
                if (kotlin.jvm.internal.g0.g(bVar2.f(h0Var.c()), Boolean.TRUE)) {
                    Class<?>[] c6 = bVar2.c(h0Var.c());
                    if (c6 != null) {
                        J = new ArrayList(c6.length);
                        for (Class<?> cls : c6) {
                            J.add(l3.a.i(cls));
                        }
                    } else {
                        J = null;
                    }
                    if (J == null) {
                        J = kotlin.collections.f0.J();
                    }
                } else {
                    J = kotlin.collections.f0.J();
                }
            }
            kotlin.jvm.internal.g0.n(J, "null cannot be cast to non-null type kotlin.collections.List<kotlin.reflect.KClass<out T of kotlin.reflect.jvm.internal.KClassImpl>>");
            return J;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String i0(h0 h0Var, b bVar) {
            if (!h0Var.c().isAnonymousClass()) {
                kotlin.reflect.jvm.internal.impl.name.b i02 = h0Var.i0();
                if (i02.i()) {
                    return bVar.C(h0Var.c());
                }
                String b6 = i02.h().b();
                kotlin.jvm.internal.g0.o(b6, "asString(...)");
                return b6;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List j0(b bVar, h0 h0Var) {
            Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = bVar.Q().o().i();
            kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
            ArrayList arrayList = new ArrayList(i6.size());
            for (kotlin.reflect.jvm.internal.impl.types.t0 t0Var : i6) {
                kotlin.jvm.internal.g0.m(t0Var);
                arrayList.add(new z2(t0Var, new s0(t0Var, bVar, h0Var)));
            }
            if (!kotlin.reflect.jvm.internal.impl.builtins.j.v0(bVar.Q())) {
                if (!arrayList.isEmpty()) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind h6 = kotlin.reflect.jvm.internal.impl.resolve.i.e(((z2) it.next()).getType()).h();
                        kotlin.jvm.internal.g0.o(h6, "getKind(...)");
                        if (h6 != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE && h6 != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
                            break;
                        }
                    }
                }
                kotlin.reflect.jvm.internal.impl.types.e1 i7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(bVar.Q()).i();
                kotlin.jvm.internal.g0.o(i7, "getAnyType(...)");
                arrayList.add(new z2(i7, u0.f47601a));
            }
            return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type k0(kotlin.reflect.jvm.internal.impl.types.t0 t0Var, b bVar, h0 h0Var) {
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                Class<?> s5 = p3.s((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
                if (s5 != null) {
                    if (kotlin.jvm.internal.g0.g(h0Var.c().getSuperclass(), s5)) {
                        Type genericSuperclass = h0Var.c().getGenericSuperclass();
                        kotlin.jvm.internal.g0.m(genericSuperclass);
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = h0Var.c().getInterfaces();
                    kotlin.jvm.internal.g0.o(interfaces, "getInterfaces(...)");
                    int bg = kotlin.collections.n.bg(interfaces, s5);
                    if (bg >= 0) {
                        Type type = h0Var.c().getGenericInterfaces()[bg];
                        kotlin.jvm.internal.g0.m(type);
                        return type;
                    }
                    throw new KotlinReflectionInternalError("No superclass of " + bVar + " in Java reflection for " + c6);
                }
                throw new KotlinReflectionInternalError("Unsupported superclass of " + bVar + ": " + c6);
            }
            throw new KotlinReflectionInternalError("Supertype not a class: " + c6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List m0(b bVar, h0 h0Var) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> t5 = bVar.Q().t();
            kotlin.jvm.internal.g0.o(t5, "getDeclaredTypeParameters(...)");
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = t5;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var : list) {
                kotlin.jvm.internal.g0.m(j1Var);
                arrayList.add(new b3(h0Var, j1Var));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List y(b bVar) {
            return kotlin.collections.f0.I4(bVar.J(), bVar.K());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List z(b bVar) {
            return kotlin.collections.f0.I4(bVar.O(), bVar.R());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44386a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f44386a = iArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends kotlin.reflect.jvm.internal.impl.resolve.scopes.f {
        d(kotlin.reflect.jvm.internal.impl.descriptors.impl.k kVar, kotlin.reflect.jvm.internal.impl.storage.n nVar) {
            super(nVar, kVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.f
        protected List<kotlin.reflect.jvm.internal.impl.descriptors.y> k() {
            return kotlin.collections.f0.J();
        }
    }

    static {
        Set<kotlin.reflect.jvm.internal.impl.name.b> b6 = kotlin.reflect.jvm.internal.impl.a.f44394a.b();
        HashSet hashSet = new HashSet();
        Iterator<T> it = b6.iterator();
        while (it.hasNext()) {
            hashSet.add(((kotlin.reflect.jvm.internal.impl.name.b) it.next()).a().toString());
        }
        f44362g = hashSet;
    }

    public h0(@NotNull Class<T> jClass) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        this.f44363d = jClass;
        this.f44364e = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new f0(this));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d f0(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k kVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.k kVar2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.k(new kotlin.reflect.jvm.internal.impl.descriptors.impl.p(kVar.b(), bVar.f()), bVar.h(), Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS, kotlin.collections.f0.l(kVar.b().p().h().s()), kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a, false, kVar.a().u());
        kVar2.F0(new d(kVar2, kVar.a().u()), kotlin.collections.u1.k(), null);
        return kVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b h0(h0 h0Var) {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.name.b i0() {
        return k3.f47513a.c(c());
    }

    private final kotlin.reflect.jvm.internal.impl.km.g l0() {
        return this.f44364e.getValue().T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.w0 m0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0 deserializeToDescriptor, ProtoBuf.Property proto) {
        kotlin.jvm.internal.g0.p(deserializeToDescriptor, "$this$deserializeToDescriptor");
        kotlin.jvm.internal.g0.p(proto, "proto");
        return deserializeToDescriptor.u(proto, true);
    }

    @Override // kotlin.reflect.d
    @Nullable
    public T A() {
        return this.f44364e.getValue().V();
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String D() {
        return this.f44364e.getValue().Y();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> Q(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k n02 = n0();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return kotlin.collections.f0.I4(n02.a(name, noLookupLocation), p0().a(name, noLookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> U(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k n02 = n0();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return kotlin.collections.f0.I4(n02.c(name, noLookupLocation), p0().c(name, noLookupLocation));
    }

    @Override // kotlin.jvm.internal.s
    @NotNull
    public Class<T> c() {
        return this.f44363d;
    }

    @Override // kotlin.reflect.d
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof h0) && kotlin.jvm.internal.g0.g(l3.a.g(this), l3.a.g((kotlin.reflect.d) obj));
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.i<T>> f() {
        return this.f44364e.getValue().M();
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.f44364e.getValue().L();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.s> getTypeParameters() {
        return this.f44364e.getValue().a0();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.r> i() {
        return this.f44364e.getValue().Z();
    }

    @NotNull
    public final kotlin.s<h0<T>.b> j0() {
        return this.f44364e;
    }

    @Override // kotlin.reflect.jvm.internal.d1
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d d() {
        return this.f44364e.getValue().Q();
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> o() {
        return this.f44364e.getValue().I();
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        kotlin.reflect.jvm.internal.impl.name.b i02 = i0();
        kotlin.reflect.jvm.internal.impl.name.c f6 = i02.f();
        if (f6.c()) {
            str = "";
        } else {
            str = f6.a() + '.';
        }
        sb.append(str + kotlin.text.u.w2(i02.g().a(), '.', kotlin.text.v0.f47959c, false, 4, null));
        return sb.toString();
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String x() {
        return this.f44364e.getValue().W();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.d<?>> y() {
        return this.f44364e.getValue().U();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.d<? extends T>> z() {
        return this.f44364e.getValue().X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d g0(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k kVar) {
        KotlinClassHeader.Kind kind;
        int i6;
        KotlinClassHeader e6;
        if (c().isSynthetic()) {
            return f0(bVar, kVar);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f a6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f.f44967c.a(c());
        if (a6 != null && (e6 = a6.e()) != null) {
            kind = e6.c();
        } else {
            kind = null;
        }
        if (kind == null) {
            i6 = -1;
        } else {
            i6 = c.f44386a[kind.ordinal()];
        }
        switch (i6) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + c() + " (kind = " + kind + ')');
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
                return f0(bVar, kVar);
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + c() + " (kind = " + kind + ')');
        }
    }

    private final kotlin.reflect.jvm.internal.impl.km.Modality o0() {
        kotlin.reflect.jvm.internal.impl.km.Modality b6;
        kotlin.reflect.jvm.internal.impl.km.g l02 = l0();
        if (l02 != null && (b6 = kotlin.reflect.jvm.internal.impl.km.a.b(l02)) != null) {
            return b6;
        }
        if (!c().isAnnotation() && !c().isEnum()) {
            if (kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f44984a.f(c()), Boolean.TRUE)) {
                return kotlin.reflect.jvm.internal.impl.km.Modality.SEALED;
            }
            if (Modifier.isAbstract(c().getModifiers())) {
                return kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT;
            }
            if (!Modifier.isFinal(c().getModifiers())) {
                return kotlin.reflect.jvm.internal.impl.km.Modality.OPEN;
            }
            return kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
        }
        return kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
    }

    @Override // kotlin.reflect.d
    public boolean B() {
        ClassKind classKind;
        kotlin.reflect.jvm.internal.impl.km.g l02 = l0();
        if (l02 != null) {
            classKind = kotlin.reflect.jvm.internal.impl.km.a.a(l02);
        } else {
            classKind = null;
        }
        if (classKind == ClassKind.COMPANION_OBJECT) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.d
    public boolean C(@Nullable Object obj) {
        Integer g6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.g(c());
        if (g6 != null) {
            return kotlin.jvm.internal.u0.B(obj, g6.intValue());
        }
        Class k6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.k(c());
        if (k6 == null) {
            k6 = c();
        }
        return k6.isInstance(obj);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> P() {
        kotlin.reflect.jvm.internal.impl.descriptors.d d6 = d();
        if (d6.h() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE && d6.h() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.OBJECT) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f6 = d6.f();
            kotlin.jvm.internal.g0.o(f6, "getConstructors(...)");
            return f6;
        }
        return kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 R(int i6) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n nVar;
        Class<?> declaringClass;
        if (kotlin.jvm.internal.g0.g(c().getSimpleName(), "DefaultImpls") && (declaringClass = c().getDeclaringClass()) != null && declaringClass.isInterface()) {
            kotlin.reflect.d i7 = l3.a.i(declaringClass);
            kotlin.jvm.internal.g0.n(i7, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((h0) i7).R(i6);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d d6 = d();
        if (d6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) {
            nVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) d6;
        } else {
            nVar = null;
        }
        if (nVar != null) {
            ProtoBuf.Class Z0 = nVar.Z0();
            GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = JvmProtoBuf.f46268j;
            kotlin.jvm.internal.g0.o(classLocalVariable, "classLocalVariable");
            ProtoBuf.Property property = (ProtoBuf.Property) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.b(Z0, classLocalVariable, i6);
            if (property != null) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.w0) p3.h(c(), property, nVar.Y0().g(), nVar.Y0().j(), nVar.b1(), g0.f44351a);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.d
    @Nullable
    public KVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = d().getVisibility();
        kotlin.jvm.internal.g0.o(visibility, "getVisibility(...)");
        return p3.t(visibility);
    }

    @Override // kotlin.reflect.d
    public int hashCode() {
        return l3.a.g(this).hashCode();
    }

    @Override // kotlin.reflect.d
    public boolean isAbstract() {
        if (o0() == kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.d
    public boolean isFinal() {
        if (o0() == kotlin.reflect.jvm.internal.impl.km.Modality.FINAL) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.d
    public boolean isOpen() {
        if (o0() == kotlin.reflect.jvm.internal.impl.km.Modality.OPEN) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.d
    public boolean k() {
        kotlin.reflect.jvm.internal.impl.km.g l02 = l0();
        if (l02 == null) {
            if (c().getDeclaringClass() != null && !Modifier.isStatic(c().getModifiers())) {
                return true;
            }
            return false;
        }
        return kotlin.reflect.jvm.internal.impl.km.a.e(l02);
    }

    @Override // kotlin.reflect.d
    public boolean m() {
        if (o0() == kotlin.reflect.jvm.internal.impl.km.Modality.SEALED) {
            return true;
        }
        return false;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k n0() {
        return d().s().r();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k p0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k r02 = d().r0();
        kotlin.jvm.internal.g0.o(r02, "getStaticScope(...)");
        return r02;
    }

    @Override // kotlin.reflect.d
    public boolean u() {
        kotlin.reflect.jvm.internal.impl.km.g l02 = l0();
        if (l02 == null || !kotlin.reflect.jvm.internal.impl.km.a.d(l02)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.d
    public boolean v() {
        kotlin.reflect.jvm.internal.impl.km.g l02 = l0();
        if (l02 == null || !kotlin.reflect.jvm.internal.impl.km.a.h(l02)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.d
    public boolean w() {
        kotlin.reflect.jvm.internal.impl.km.g l02 = l0();
        if (l02 == null || !kotlin.reflect.jvm.internal.impl.km.a.c(l02)) {
            return false;
        }
        return true;
    }
}
