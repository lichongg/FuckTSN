package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKCallableImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n+ 2 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,276:1\n230#2,5:277\n230#2,5:282\n230#2,5:287\n230#2,5:292\n230#2,2:302\n232#2,3:308\n1#3:297\n1563#4:298\n1634#4,3:299\n1011#4,2:311\n1563#4:313\n1634#4,3:314\n1788#4,4:317\n1869#4,2:321\n1761#4,3:323\n37#5:304\n36#5,3:305\n*S KotlinDebug\n*F\n+ 1 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n*L\n107#1:277,5\n158#1:282,5\n206#1:287,5\n214#1:292,5\n248#1:302,2\n248#1:308,3\n234#1:298\n234#1:299,3\n65#1:311,2\n85#1:313\n85#1:314,3\n124#1:317,4\n132#1:321,2\n220#1:323,3\n249#1:304\n249#1:305,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e0<R> implements kotlin.reflect.c<R>, c3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final f3.a<List<Annotation>> f44334a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final f3.a<ArrayList<KParameter>> f44335b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f3.a<z2> f44336c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final f3.a<List<b3>> f44337d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final f3.a<Object[]> f44338e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.s<Boolean> f44339f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n*L\n1#1,328:1\n65#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            return kotlin.comparisons.a.l(((KParameter) t5).getName(), ((KParameter) t6).getName());
        }
    }

    @NotNull
    public abstract kotlin.reflect.jvm.internal.calls.g<?> W();

    @NotNull
    public abstract KDeclarationContainerImpl X();

    @Nullable
    public abstract kotlin.reflect.jvm.internal.calls.g<?> Y();

    @NotNull
    /* renamed from: Z */
    public abstract CallableMemberDescriptor e0();

    public abstract boolean c0();

    /* JADX INFO: Access modifiers changed from: private */
    public static final z2 E(e0 e0Var) {
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = e0Var.e0().getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        return new z2(returnType, new d0(e0Var));
    }

    private final Object[] V() {
        return (Object[]) this.f44338e.invoke().clone();
    }

    private final int a0(KParameter kParameter) {
        if (!this.f44339f.getValue().booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before");
        }
        if (!p3.m(kParameter.getType())) {
            return 1;
        }
        kotlin.reflect.r type = kParameter.getType();
        kotlin.jvm.internal.g0.n(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        List<Method> n6 = kotlin.reflect.jvm.internal.calls.n.n(kotlin.reflect.jvm.internal.impl.types.g2.a(((z2) type).getType()));
        kotlin.jvm.internal.g0.m(n6);
        return n6.size();
    }

    public final R S(@NotNull Map<KParameter, ? extends Object> args, @Nullable kotlin.coroutines.e<?> eVar) {
        kotlin.jvm.internal.g0.p(args, "args");
        List<KParameter> parameters = getParameters();
        boolean z5 = false;
        if (parameters.isEmpty()) {
            try {
                return (R) W().call(isSuspend() ? new kotlin.coroutines.e[]{eVar} : new kotlin.coroutines.e[0]);
            } catch (IllegalAccessException e6) {
                throw new IllegalCallableAccessException(e6);
            }
        }
        int size = parameters.size() + (isSuspend() ? 1 : 0);
        Object[] V = V();
        if (isSuspend()) {
            V[parameters.size()] = eVar;
        }
        boolean booleanValue = this.f44339f.getValue().booleanValue();
        int i6 = 0;
        for (KParameter kParameter : parameters) {
            int a02 = booleanValue ? a0(kParameter) : 1;
            if (args.containsKey(kParameter)) {
                V[kParameter.getIndex()] = args.get(kParameter);
            } else if (kParameter.p()) {
                if (booleanValue) {
                    int i7 = i6 + a02;
                    for (int i8 = i6; i8 < i7; i8++) {
                        int i9 = (i8 / 32) + size;
                        Object obj = V[i9];
                        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlin.Int");
                        V[i9] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i8 % 32)));
                    }
                } else {
                    int i10 = (i6 / 32) + size;
                    Object obj2 = V[i10];
                    kotlin.jvm.internal.g0.n(obj2, "null cannot be cast to non-null type kotlin.Int");
                    V[i10] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i6 % 32)));
                }
                z5 = true;
            } else if (!kParameter.a()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            if (kParameter.h() == KParameter.Kind.VALUE) {
                i6 += a02;
            }
        }
        if (!z5) {
            try {
                kotlin.reflect.jvm.internal.calls.g<?> W = W();
                Object[] copyOf = Arrays.copyOf(V, size);
                kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
                return (R) W.call(copyOf);
            } catch (IllegalAccessException e7) {
                throw new IllegalCallableAccessException(e7);
            }
        }
        kotlin.reflect.jvm.internal.calls.g<?> Y = Y();
        if (Y != null) {
            try {
                return (R) Y.call(V);
            } catch (IllegalAccessException e8) {
                throw new IllegalCallableAccessException(e8);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + e0());
    }

    @Override // kotlin.reflect.c
    public R call(@NotNull Object... args) {
        kotlin.jvm.internal.g0.p(args, "args");
        try {
            return (R) W().call(args);
        } catch (IllegalAccessException e6) {
            throw new IllegalCallableAccessException(e6);
        }
    }

    @Override // kotlin.reflect.c
    public R callBy(@NotNull Map<KParameter, ? extends Object> args) {
        kotlin.jvm.internal.g0.p(args, "args");
        return b0() ? R(args) : S(args, null);
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this.f44334a.invoke();
        kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this.f44335b.invoke();
        kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public kotlin.reflect.r getReturnType() {
        z2 invoke = this.f44336c.invoke();
        kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public List<kotlin.reflect.s> getTypeParameters() {
        List<b3> invoke = this.f44337d.invoke();
        kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
        return invoke;
    }

    public e0() {
        f3.a<List<Annotation>> c6 = f3.c(new u(this));
        kotlin.jvm.internal.g0.o(c6, "lazySoft(...)");
        this.f44334a = c6;
        f3.a<ArrayList<KParameter>> c7 = f3.c(new v(this));
        kotlin.jvm.internal.g0.o(c7, "lazySoft(...)");
        this.f44335b = c7;
        f3.a<z2> c8 = f3.c(new w(this));
        kotlin.jvm.internal.g0.o(c8, "lazySoft(...)");
        this.f44336c = c8;
        f3.a<List<b3>> c9 = f3.c(new x(this));
        kotlin.jvm.internal.g0.o(c9, "lazySoft(...)");
        this.f44337d = c9;
        f3.a<Object[]> c10 = f3.c(new y(this));
        kotlin.jvm.internal.g0.o(c10, "lazySoft(...)");
        this.f44338e = c10;
        this.f44339f = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type F(e0 e0Var) {
        Type U = e0Var.U();
        if (U == null) {
            return e0Var.W().getReturnType();
        }
        return U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G(e0 e0Var) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> typeParameters = e0Var.e0().getTypeParameters();
        kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = typeParameters;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var : list) {
            kotlin.jvm.internal.g0.m(j1Var);
            arrayList.add(new b3(e0Var, j1Var));
        }
        return arrayList;
    }

    private final R R(Map<KParameter, ? extends Object> map) {
        Object T;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                T = map.get(kParameter);
                if (T == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.p()) {
                T = null;
            } else if (kParameter.a()) {
                T = T(kParameter.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            arrayList.add(T);
        }
        kotlin.reflect.jvm.internal.calls.g<?> Y = Y();
        if (Y != null) {
            try {
                return (R) Y.call(arrayList.toArray(new Object[0]));
            } catch (IllegalAccessException e6) {
                throw new IllegalCallableAccessException(e6);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + e0());
    }

    private final Object T(kotlin.reflect.r rVar) {
        Class e6 = l3.a.e(kotlin.reflect.jvm.c.b(rVar));
        if (e6.isArray()) {
            Object newInstance = Array.newInstance(e6.getComponentType(), 0);
            kotlin.jvm.internal.g0.o(newInstance, "run(...)");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + e6.getSimpleName() + ", because it is not an array type");
    }

    private final Type U() {
        ParameterizedType parameterizedType;
        Type type;
        WildcardType wildcardType;
        Type[] lowerBounds;
        if (isSuspend()) {
            Object A3 = kotlin.collections.f0.A3(W().b());
            if (A3 instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) A3;
            } else {
                parameterizedType = null;
            }
            if (parameterizedType != null) {
                type = parameterizedType.getRawType();
            } else {
                type = null;
            }
            if (kotlin.jvm.internal.g0.g(type, kotlin.coroutines.e.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.g0.o(actualTypeArguments, "getActualTypeArguments(...)");
                Object At = kotlin.collections.n.At(actualTypeArguments);
                if (At instanceof WildcardType) {
                    wildcardType = (WildcardType) At;
                } else {
                    wildcardType = null;
                }
                if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                    return (Type) kotlin.collections.n.jc(lowerBounds);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] d(e0 e0Var) {
        int i6;
        int i7;
        List<KParameter> parameters = e0Var.getParameters();
        int size = parameters.size() + (e0Var.isSuspend() ? 1 : 0);
        if (e0Var.f44339f.getValue().booleanValue()) {
            i6 = 0;
            for (KParameter kParameter : parameters) {
                if (kParameter.h() == KParameter.Kind.VALUE) {
                    i7 = e0Var.a0(kParameter);
                } else {
                    i7 = 0;
                }
                i6 += i7;
            }
        } else {
            List<KParameter> list = parameters;
            if ((list instanceof Collection) && list.isEmpty()) {
                i6 = 0;
            } else {
                Iterator<T> it = list.iterator();
                i6 = 0;
                while (it.hasNext()) {
                    if (((KParameter) it.next()).h() == KParameter.Kind.VALUE && (i6 = i6 + 1) < 0) {
                        kotlin.collections.f0.a0();
                    }
                }
            }
        }
        int i8 = (i6 + 31) / 32;
        Object[] objArr = new Object[size + i8 + 1];
        for (KParameter kParameter2 : parameters) {
            if (kParameter2.p() && !p3.n(kParameter2.getType())) {
                objArr[kParameter2.getIndex()] = p3.g(kotlin.reflect.jvm.d.i(kParameter2.getType()));
            } else if (kParameter2.a()) {
                objArr[kParameter2.getIndex()] = e0Var.T(kParameter2.getType());
            }
        }
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[size + i9] = 0;
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(e0 e0Var) {
        List<KParameter> parameters = e0Var.getParameters();
        if ((parameters instanceof Collection) && parameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            if (p3.m(((KParameter) it.next()).getType())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(e0 e0Var) {
        return p3.e(e0Var.e0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList l(e0 e0Var) {
        int i6;
        CallableMemberDescriptor e02 = e0Var.e0();
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        if (!e0Var.c0()) {
            kotlin.reflect.jvm.internal.impl.descriptors.z0 k6 = p3.k(e02);
            if (k6 != null) {
                arrayList.add(new d2(e0Var, 0, KParameter.Kind.INSTANCE, new a0(k6)));
                i6 = 1;
            } else {
                i6 = 0;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.z0 f02 = e02.f0();
            if (f02 != null) {
                arrayList.add(new d2(e0Var, i6, KParameter.Kind.EXTENSION_RECEIVER, new b0(f02)));
                i6++;
            }
        } else {
            i6 = 0;
        }
        int size = e02.g().size();
        while (i7 < size) {
            arrayList.add(new d2(e0Var, i6, KParameter.Kind.VALUE, new c0(e02, i7)));
            i7++;
            i6++;
        }
        if (e0Var.b0() && (e02 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) && arrayList.size() > 1) {
            kotlin.collections.f0.r0(arrayList, new a());
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.t0 t(CallableMemberDescriptor callableMemberDescriptor, int i6) {
        kotlin.reflect.jvm.internal.impl.descriptors.q1 q1Var = callableMemberDescriptor.g().get(i6);
        kotlin.jvm.internal.g0.o(q1Var, "get(...)");
        return q1Var;
    }

    protected final boolean b0() {
        if (kotlin.jvm.internal.g0.g(getName(), "<init>") && X().c().isAnnotation()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.c
    @Nullable
    public KVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = e0().getVisibility();
        kotlin.jvm.internal.g0.o(visibility, "getVisibility(...)");
        return p3.t(visibility);
    }

    @Override // kotlin.reflect.c
    public boolean isAbstract() {
        if (e0().i() == Modality.ABSTRACT) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.c
    public boolean isFinal() {
        if (e0().i() == Modality.FINAL) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.c
    public boolean isOpen() {
        if (e0().i() == Modality.OPEN) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.t0 r(kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var) {
        return z0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.t0 s(kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var) {
        return z0Var;
    }
}
