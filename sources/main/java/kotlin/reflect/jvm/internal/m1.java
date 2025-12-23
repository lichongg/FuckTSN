package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.h;
import kotlin.reflect.jvm.internal.calls.m;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKFunctionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KFunctionImpl.kt\nkotlin/reflect/jvm/internal/KFunctionImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,235:1\n2746#2,3:236\n1761#2,3:240\n1563#2:244\n1634#2,3:245\n1563#2:249\n1634#2,3:250\n1563#2:253\n1634#2,3:254\n1563#2:257\n1634#2,3:258\n183#3:239\n184#3:243\n1#4:248\n*S KotlinDebug\n*F\n+ 1 KFunctionImpl.kt\nkotlin/reflect/jvm/internal/KFunctionImpl\n*L\n157#1:236,3\n164#1:240,3\n72#1:244\n72#1:245,3\n87#1:249\n87#1:250,3\n123#1:253\n123#1:254,3\n128#1:257\n128#1:258,3\n164#1:239\n164#1:243\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m1 extends e0<Object> implements kotlin.jvm.internal.c0<Object>, kotlin.reflect.i<Object>, p {

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f47523m = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(m1.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final KDeclarationContainerImpl f47524g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final String f47525h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final Object f47526i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final f3.a f47527j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.s f47528k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.s f47529l;

    /* synthetic */ m1(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, Object obj, int i6, kotlin.jvm.internal.v vVar) {
        this(kDeclarationContainerImpl, str, str2, yVar, (i6 & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    @Nullable
    public Object D0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Nullable
    public Object E0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Nullable
    public Object F0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Nullable
    public Object G0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Nullable
    public Object H0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Nullable
    public Object I0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public Object invoke() {
        return m0();
    }

    @Nullable
    public Object m0() {
        return call(new Object[0]);
    }

    @Nullable
    public Object n0(Object obj) {
        return call(obj);
    }

    @Nullable
    public Object o0(Object obj, Object obj2) {
        return call(obj, obj2);
    }

    @Nullable
    public Object p0(Object obj, Object obj2, Object obj3) {
        return call(obj, obj2, obj3);
    }

    @Nullable
    public Object q0(Object obj, Object obj2, Object obj3, Object obj4) {
        return call(obj, obj2, obj3, obj4);
    }

    @Nullable
    public Object r0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return call(obj, obj2, obj3, obj4, obj5);
    }

    @Nullable
    public Object s0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return call(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Nullable
    public Object t0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, java.lang.reflect.Member] */
    public static final kotlin.reflect.jvm.internal.calls.g J0(m1 m1Var) {
        GenericDeclaration genericDeclaration;
        kotlin.reflect.jvm.internal.calls.g<?> gVar;
        k3 k3Var = k3.f47513a;
        r g6 = k3Var.g(m1Var.e0());
        if (g6 instanceof r.e) {
            kotlin.reflect.jvm.internal.impl.descriptors.y e02 = m1Var.e0();
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = e02.b();
            kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
            if (kotlin.reflect.jvm.internal.impl.resolve.j.d(b6) && (e02 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) && ((kotlin.reflect.jvm.internal.impl.descriptors.j) e02).m0()) {
                throw new KotlinReflectionInternalError(m1Var.e0().b() + " cannot have default arguments");
            }
            kotlin.reflect.jvm.internal.impl.descriptors.y N0 = m1Var.N0(m1Var.e0());
            if (N0 != null) {
                r g7 = k3Var.g(N0);
                kotlin.jvm.internal.g0.n(g7, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction");
                r.e eVar = (r.e) g7;
                genericDeclaration = m1Var.X().H(eVar.c(), eVar.b(), true);
            } else {
                KDeclarationContainerImpl X = m1Var.X();
                r.e eVar2 = (r.e) g6;
                String c6 = eVar2.c();
                String b7 = eVar2.b();
                kotlin.jvm.internal.g0.m(m1Var.W().c());
                genericDeclaration = X.H(c6, b7, !Modifier.isStatic(r5.getModifiers()));
            }
        } else if (g6 instanceof r.d) {
            if (m1Var.b0()) {
                Class<?> c7 = m1Var.X().c();
                List<KParameter> parameters = m1Var.getParameters();
                ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    kotlin.jvm.internal.g0.m(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(c7, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            genericDeclaration = m1Var.X().G(((r.d) g6).b());
        } else {
            if (g6 instanceof r.a) {
                List<Method> d6 = ((r.a) g6).d();
                Class<?> c8 = m1Var.X().c();
                List<Method> list = d6;
                ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(c8, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, d6);
            }
            genericDeclaration = null;
        }
        if (genericDeclaration instanceof Constructor) {
            gVar = m1Var.i0((Constructor) genericDeclaration, m1Var.e0(), true);
        } else if (genericDeclaration instanceof Method) {
            if (m1Var.e0().getAnnotations().b(p3.l()) != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.k b8 = m1Var.e0().b();
                kotlin.jvm.internal.g0.n(b8, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((kotlin.reflect.jvm.internal.impl.descriptors.d) b8).l0()) {
                    gVar = m1Var.k0((Method) genericDeclaration);
                }
            }
            gVar = m1Var.l0((Method) genericDeclaration, m1Var.W().a());
        } else {
            gVar = null;
        }
        if (gVar != null) {
            return kotlin.reflect.jvm.internal.calls.n.i(gVar, m1Var.e0(), true);
        }
        return null;
    }

    private final Object L0() {
        return kotlin.reflect.jvm.internal.calls.n.h(this.f47526i, e0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.calls.g h0(m1 m1Var) {
        Object d6;
        kotlin.reflect.jvm.internal.calls.g<?> j02;
        r g6 = k3.f47513a.g(m1Var.e0());
        if (g6 instanceof r.d) {
            if (m1Var.b0()) {
                Class<?> c6 = m1Var.X().c();
                List<KParameter> parameters = m1Var.getParameters();
                ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    kotlin.jvm.internal.g0.m(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(c6, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            d6 = m1Var.X().F(((r.d) g6).b());
        } else if (g6 instanceof r.e) {
            kotlin.reflect.jvm.internal.impl.descriptors.y e02 = m1Var.e0();
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = e02.b();
            kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
            if (kotlin.reflect.jvm.internal.impl.resolve.j.d(b6) && (e02 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) && ((kotlin.reflect.jvm.internal.impl.descriptors.j) e02).m0()) {
                kotlin.reflect.jvm.internal.impl.descriptors.y e03 = m1Var.e0();
                KDeclarationContainerImpl X = m1Var.X();
                String b7 = ((r.e) g6).b();
                List<kotlin.reflect.jvm.internal.impl.descriptors.q1> g7 = m1Var.e0().g();
                kotlin.jvm.internal.g0.o(g7, "getValueParameters(...)");
                return new m.b(e03, X, b7, g7);
            }
            r.e eVar = (r.e) g6;
            d6 = m1Var.X().K(eVar.c(), eVar.b());
        } else if (g6 instanceof r.c) {
            d6 = ((r.c) g6).b();
            kotlin.jvm.internal.g0.n(d6, "null cannot be cast to non-null type java.lang.reflect.Member");
        } else {
            if (!(g6 instanceof r.b)) {
                if (!(g6 instanceof r.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                List<Method> d7 = ((r.a) g6).d();
                Class<?> c7 = m1Var.X().c();
                List<Method> list = d7;
                ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(c7, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, d7);
            }
            d6 = ((r.b) g6).d();
            kotlin.jvm.internal.g0.n(d6, "null cannot be cast to non-null type java.lang.reflect.Member");
        }
        if (d6 instanceof Constructor) {
            j02 = m1Var.i0((Constructor) d6, m1Var.e0(), false);
        } else {
            if (!(d6 instanceof Method)) {
                throw new KotlinReflectionInternalError("Could not compute caller for function: " + m1Var.e0() + " (member = " + d6 + ')');
            }
            Method method = (Method) d6;
            j02 = !Modifier.isStatic(method.getModifiers()) ? m1Var.j0(method) : m1Var.e0().getAnnotations().b(p3.l()) != null ? m1Var.k0(method) : m1Var.l0(method, false);
        }
        return kotlin.reflect.jvm.internal.calls.n.j(j02, m1Var.e0(), false, 2, null);
    }

    private final kotlin.reflect.jvm.internal.calls.h<Constructor<?>> i0(Constructor<?> constructor, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, boolean z5) {
        return (z5 || !kotlin.reflect.jvm.internal.impl.resolve.jvm.b.f(yVar)) ? c0() ? new h.c(constructor, L0()) : new h.e(constructor) : c0() ? new h.a(constructor, L0()) : new h.b(constructor);
    }

    @Nullable
    public Object A0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Nullable
    public Object B0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Nullable
    public Object C0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @NotNull
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.y e0() {
        T b6 = this.f47527j.b(this, f47523m[0]);
        kotlin.jvm.internal.g0.o(b6, "getValue(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.y) b6;
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @NotNull
    public kotlin.reflect.jvm.internal.calls.g<?> W() {
        return (kotlin.reflect.jvm.internal.calls.g) this.f47528k.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @NotNull
    public KDeclarationContainerImpl X() {
        return this.f47524g;
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @Nullable
    public kotlin.reflect.jvm.internal.calls.g<?> Y() {
        return (kotlin.reflect.jvm.internal.calls.g) this.f47529l.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.e0
    public boolean c0() {
        return this.f47526i != CallableReference.NO_RECEIVER;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public Object invoke(@Nullable Object obj) {
        return n0(obj);
    }

    @NotNull
    public String toString() {
        return j3.f47506a.f(e0());
    }

    @Nullable
    public Object u0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Nullable
    public Object v0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Nullable
    public Object w0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Nullable
    public Object x0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Nullable
    public Object y0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Nullable
    public Object z0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    private m1(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, Object obj) {
        this.f47524g = kDeclarationContainerImpl;
        this.f47525h = str2;
        this.f47526i = obj;
        this.f47527j = f3.b(yVar, new j1(this, str));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f47528k = kotlin.t.b(lazyThreadSafetyMode, new k1(this));
        this.f47529l = kotlin.t.b(lazyThreadSafetyMode, new l1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.y K0(m1 m1Var, String str) {
        return m1Var.X().I(str, m1Var.f47525h);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.lang.reflect.Member] */
    private final kotlin.reflect.jvm.internal.impl.descriptors.y N0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        CallableMemberDescriptor callableMemberDescriptor;
        List<kotlin.reflect.jvm.internal.impl.descriptors.q1> g6 = yVar.g();
        kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
        List<kotlin.reflect.jvm.internal.impl.descriptors.q1> list = g6;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((kotlin.reflect.jvm.internal.impl.descriptors.q1) it.next()).Q()) {
                    break;
                }
            }
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = yVar.b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        if (kotlin.reflect.jvm.internal.impl.resolve.j.g(b6)) {
            ?? c6 = W().c();
            kotlin.jvm.internal.g0.m(c6);
            if (Modifier.isStatic(c6.getModifiers())) {
                Iterator<CallableMemberDescriptor> it2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.z(yVar, false).iterator();
                loop0: while (true) {
                    if (it2.hasNext()) {
                        callableMemberDescriptor = it2.next();
                        List<kotlin.reflect.jvm.internal.impl.descriptors.q1> g7 = callableMemberDescriptor.g();
                        kotlin.jvm.internal.g0.o(g7, "getValueParameters(...)");
                        List<kotlin.reflect.jvm.internal.impl.descriptors.q1> list2 = g7;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it3 = list2.iterator();
                            while (it3.hasNext()) {
                                if (((kotlin.reflect.jvm.internal.impl.descriptors.q1) it3.next()).Q()) {
                                    break loop0;
                                }
                            }
                        }
                    } else {
                        callableMemberDescriptor = null;
                        break;
                    }
                }
                if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) {
                    return (kotlin.reflect.jvm.internal.impl.descriptors.y) callableMemberDescriptor;
                }
            }
        }
        return null;
    }

    private final boolean O0(Method method) {
        kotlin.reflect.jvm.internal.impl.types.t0 type;
        kotlin.reflect.jvm.internal.impl.descriptors.z0 c02 = e0().c0();
        if (c02 != null && (type = c02.getType()) != null && kotlin.reflect.jvm.internal.impl.resolve.j.c(type)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.g0.o(parameterTypes, "getParameterTypes(...)");
            Class cls = (Class) kotlin.collections.n.Fc(parameterTypes);
            if (cls != null && cls.isInterface()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final h.AbstractC0872h j0(Method method) {
        if (c0()) {
            return new h.AbstractC0872h.a(method, L0());
        }
        return new h.AbstractC0872h.e(method);
    }

    private final h.AbstractC0872h k0(Method method) {
        if (c0()) {
            return new h.AbstractC0872h.b(method);
        }
        return new h.AbstractC0872h.f(method);
    }

    private final kotlin.reflect.jvm.internal.calls.g<?> l0(Method method, boolean z5) {
        Object L0;
        if (c0()) {
            if (O0(method)) {
                L0 = this.f47526i;
            } else {
                L0 = L0();
            }
            return new h.AbstractC0872h.c(method, z5, L0);
        }
        return new h.AbstractC0872h.g(method);
    }

    public boolean equals(@Nullable Object obj) {
        m1 c6 = p3.c(obj);
        if (c6 == null || !kotlin.jvm.internal.g0.g(X(), c6.X()) || !kotlin.jvm.internal.g0.g(getName(), c6.getName()) || !kotlin.jvm.internal.g0.g(this.f47525h, c6.f47525h) || !kotlin.jvm.internal.g0.g(this.f47526i, c6.f47526i)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.jvm.internal.c0
    public int getArity() {
        return kotlin.reflect.jvm.internal.calls.i.a(W());
    }

    @Override // kotlin.reflect.c
    @NotNull
    public String getName() {
        String b6 = e0().getName().b();
        kotlin.jvm.internal.g0.o(b6, "asString(...)");
        return b6;
    }

    public int hashCode() {
        return (((X().hashCode() * 31) + getName().hashCode()) * 31) + this.f47525h.hashCode();
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
        return o0(obj, obj2);
    }

    @Override // kotlin.reflect.i
    public boolean isExternal() {
        return e0().isExternal();
    }

    @Override // kotlin.reflect.i
    public boolean isInfix() {
        return e0().isInfix();
    }

    @Override // kotlin.reflect.i
    public boolean isInline() {
        return e0().isInline();
    }

    @Override // kotlin.reflect.i
    public boolean isOperator() {
        return e0().isOperator();
    }

    @Override // kotlin.reflect.c
    public boolean isSuspend() {
        return e0().isSuspend();
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return p0(obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        return q0(obj, obj2, obj3, obj4);
    }

    @Override // kotlin.jvm.functions.Function5
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        return r0(obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        return s0(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7) {
        return t0(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8) {
        return u0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m1(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
    }

    @Override // kotlin.jvm.functions.Function9
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9) {
        return v0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public m1(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.y r11) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.g0.p(r10, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.g0.p(r11, r0)
            kotlin.reflect.jvm.internal.impl.name.f r0 = r11.getName()
            java.lang.String r3 = r0.b()
            java.lang.String r0 = "asString(...)"
            kotlin.jvm.internal.g0.o(r3, r0)
            kotlin.reflect.jvm.internal.k3 r0 = kotlin.reflect.jvm.internal.k3.f47513a
            kotlin.reflect.jvm.internal.r r0 = r0.g(r11)
            java.lang.String r4 = r0.a()
            r7 = 16
            r8 = 0
            r6 = 0
            r1 = r9
            r2 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.m1.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.y):void");
    }

    @Override // kotlin.jvm.functions.Function10
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10) {
        return w0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11) {
        return x0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12) {
        return y0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13) {
        return z0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14) {
        return A0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15) {
        return B0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16) {
        return C0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17) {
        return D0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18) {
        return E0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19) {
        return F0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20) {
        return G0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21) {
        return H0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21, @Nullable Object obj22) {
        return I0(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
