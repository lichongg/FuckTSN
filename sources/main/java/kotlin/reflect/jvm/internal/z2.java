package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKTypeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypeImpl.kt\nkotlin/reflect/jvm/internal/KTypeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1#2:137\n1573#3:138\n1604#3,4:139\n*S KotlinDebug\n*F\n+ 1 KTypeImpl.kt\nkotlin/reflect/jvm/internal/KTypeImpl\n*L\n81#1:138\n81#1:139,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z2 implements kotlin.jvm.internal.h0 {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f47629e = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(z2.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(z2.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.t0 f47630a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final f3.a<Type> f47631b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f3.a f47632c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final f3.a f47633d;

    public z2(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 type, @Nullable Function0<? extends Type> function0) {
        kotlin.jvm.internal.g0.p(type, "type");
        this.f47630a = type;
        f3.a<Type> aVar = null;
        f3.a<Type> aVar2 = function0 instanceof f3.a ? (f3.a) function0 : null;
        if (aVar2 != null) {
            aVar = aVar2;
        } else if (function0 != null) {
            aVar = f3.c(function0);
        }
        this.f47631b = aVar;
        this.f47632c = f3.c(new v2(this));
        this.f47633d = f3.c(new w2(this, function0));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47634a;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f47634a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(z2 z2Var, Function0 function0) {
        kotlin.reflect.t e6;
        List<kotlin.reflect.jvm.internal.impl.types.c2> G0 = z2Var.f47630a.G0();
        if (G0.isEmpty()) {
            return kotlin.collections.f0.J();
        }
        kotlin.s b6 = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new x2(z2Var));
        List<kotlin.reflect.jvm.internal.impl.types.c2> list = G0;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        int i6 = 0;
        for (Object obj : list) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            kotlin.reflect.jvm.internal.impl.types.c2 c2Var = (kotlin.reflect.jvm.internal.impl.types.c2) obj;
            if (c2Var.b()) {
                e6 = kotlin.reflect.t.f47635c.c();
            } else {
                kotlin.reflect.jvm.internal.impl.types.t0 type = c2Var.getType();
                kotlin.jvm.internal.g0.o(type, "getType(...)");
                z2 z2Var2 = new z2(type, function0 == null ? null : new y2(z2Var, i6, b6));
                int i8 = a.f47634a[c2Var.c().ordinal()];
                if (i8 == 1) {
                    e6 = kotlin.reflect.t.f47635c.e(z2Var2);
                } else if (i8 == 2) {
                    e6 = kotlin.reflect.t.f47635c.a(z2Var2);
                } else {
                    if (i8 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    e6 = kotlin.reflect.t.f47635c.b(z2Var2);
                }
            }
            arrayList.add(e6);
            i6 = i7;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.g t(z2 z2Var) {
        return z2Var.E(z2Var.f47630a);
    }

    @NotNull
    public final z2 F(boolean z5) {
        if (!kotlin.reflect.jvm.internal.impl.types.n0.b(this.f47630a) && q() == z5) {
            return this;
        }
        kotlin.reflect.jvm.internal.impl.types.t0 p5 = kotlin.reflect.jvm.internal.impl.types.j2.p(this.f47630a, z5);
        kotlin.jvm.internal.g0.o(p5, "makeNullableAsSpecified(...)");
        return new z2(p5, this.f47631b);
    }

    @Override // kotlin.jvm.internal.h0
    @Nullable
    public Type b() {
        f3.a<Type> aVar = this.f47631b;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof z2)) {
            return false;
        }
        z2 z2Var = (z2) obj;
        return kotlin.jvm.internal.g0.g(this.f47630a, z2Var.f47630a) && kotlin.jvm.internal.g0.g(n(), z2Var.n()) && kotlin.jvm.internal.g0.g(getArguments(), z2Var.getArguments());
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        return p3.e(this.f47630a);
    }

    @Override // kotlin.reflect.r
    @NotNull
    public List<kotlin.reflect.t> getArguments() {
        T b6 = this.f47633d.b(this, f47629e[1]);
        kotlin.jvm.internal.g0.o(b6, "getValue(...)");
        return (List) b6;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.t0 getType() {
        return this.f47630a;
    }

    public int hashCode() {
        int hashCode = this.f47630a.hashCode() * 31;
        kotlin.reflect.g n6 = n();
        return ((hashCode + (n6 != null ? n6.hashCode() : 0)) * 31) + getArguments().hashCode();
    }

    @Override // kotlin.reflect.r
    @Nullable
    public kotlin.reflect.g n() {
        return (kotlin.reflect.g) this.f47632c.b(this, f47629e[0]);
    }

    @Override // kotlin.reflect.r
    public boolean q() {
        return this.f47630a.J0();
    }

    @NotNull
    public String toString() {
        return j3.f47506a.l(this.f47630a);
    }

    private final kotlin.reflect.g E(kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        kotlin.reflect.jvm.internal.impl.types.t0 type;
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            Class<?> s5 = p3.s((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
            if (s5 == null) {
                return null;
            }
            if (s5.isArray()) {
                kotlin.reflect.jvm.internal.impl.types.c2 c2Var = (kotlin.reflect.jvm.internal.impl.types.c2) kotlin.collections.f0.p5(t0Var.G0());
                if (c2Var != null && (type = c2Var.getType()) != null) {
                    kotlin.reflect.g E = E(type);
                    if (E != null) {
                        return new h0(p3.f(l3.a.e(kotlin.reflect.jvm.c.a(E))));
                    }
                    throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                return new h0(s5);
            }
            if (!kotlin.reflect.jvm.internal.impl.types.j2.l(t0Var)) {
                Class<?> i6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.i(s5);
                if (i6 != null) {
                    s5 = i6;
                }
                return new h0(s5);
            }
            return new h0(s5);
        }
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) {
            return new b3(null, (kotlin.reflect.jvm.internal.impl.descriptors.j1) c6);
        }
        if (!(c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.i1)) {
            return null;
        }
        throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l(z2 z2Var) {
        Type b6 = z2Var.b();
        kotlin.jvm.internal.g0.m(b6);
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.h(b6);
    }

    private static final List<Type> r(kotlin.s<? extends List<? extends Type>> sVar) {
        return (List) sVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type s(z2 z2Var, int i6, kotlin.s<? extends List<? extends Type>> sVar) {
        Class<?> cls;
        Type b6 = z2Var.b();
        if (b6 instanceof Class) {
            Class cls2 = (Class) b6;
            if (cls2.isArray()) {
                cls = cls2.getComponentType();
            } else {
                cls = Object.class;
            }
            kotlin.jvm.internal.g0.m(cls);
            return cls;
        }
        if (b6 instanceof GenericArrayType) {
            if (i6 == 0) {
                Type genericComponentType = ((GenericArrayType) b6).getGenericComponentType();
                kotlin.jvm.internal.g0.m(genericComponentType);
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + z2Var);
        }
        if (b6 instanceof ParameterizedType) {
            Type type = r(sVar).get(i6);
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            kotlin.jvm.internal.g0.o(lowerBounds, "getLowerBounds(...)");
            Type type2 = (Type) kotlin.collections.n.Fc(lowerBounds);
            if (type2 == null) {
                Type[] upperBounds = wildcardType.getUpperBounds();
                kotlin.jvm.internal.g0.o(upperBounds, "getUpperBounds(...)");
                type2 = (Type) kotlin.collections.n.jc(upperBounds);
            }
            kotlin.jvm.internal.g0.m(type2);
            return type2;
        }
        throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + z2Var);
    }

    public /* synthetic */ z2(kotlin.reflect.jvm.internal.impl.types.t0 t0Var, Function0 function0, int i6, kotlin.jvm.internal.v vVar) {
        this(t0Var, (i6 & 2) != 0 ? null : function0);
    }
}
