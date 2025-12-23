package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKTypeParameterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypeParameterImpl.kt\nkotlin/reflect/jvm/internal/KTypeParameterImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1563#2:92\n1634#2,3:93\n*S KotlinDebug\n*F\n+ 1 KTypeParameterImpl.kt\nkotlin/reflect/jvm/internal/KTypeParameterImpl\n*L\n38#1:92\n38#1:93,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b3 implements kotlin.reflect.s, d1 {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44261d = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b3.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.j1 f44262a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final f3.a f44263b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final c3 f44264c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44265a;

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
            f44265a = iArr;
        }
    }

    public b3(@Nullable c3 c3Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 descriptor) {
        h0<?> h0Var;
        Object W;
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        this.f44262a = descriptor;
        this.f44263b = f3.c(new a3(this));
        if (c3Var == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = d().b();
            kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
            if (b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                W = e((kotlin.reflect.jvm.internal.impl.descriptors.d) b6);
            } else {
                if (!(b6 instanceof CallableMemberDescriptor)) {
                    throw new KotlinReflectionInternalError("Unknown type parameter container: " + b6);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.k b7 = ((CallableMemberDescriptor) b6).b();
                kotlin.jvm.internal.g0.o(b7, "getContainingDeclaration(...)");
                if (b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                    h0Var = e((kotlin.reflect.jvm.internal.impl.descriptors.d) b7);
                } else {
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t tVar = b6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t) b6 : null;
                    if (tVar == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + b6);
                    }
                    kotlin.reflect.d i6 = l3.a.i(b(tVar));
                    kotlin.jvm.internal.g0.n(i6, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    h0Var = (h0) i6;
                }
                W = b6.W(new n(h0Var), kotlin.n1.f44123a);
            }
            c3Var = (c3) W;
        }
        this.f44264c = c3Var;
    }

    @Override // kotlin.reflect.jvm.internal.d1
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.j1 d() {
        return this.f44262a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof b3)) {
            return false;
        }
        b3 b3Var = (b3) obj;
        return kotlin.jvm.internal.g0.g(this.f44264c, b3Var.f44264c) && kotlin.jvm.internal.g0.g(getName(), b3Var.getName());
    }

    @Override // kotlin.reflect.s
    @NotNull
    public List<kotlin.reflect.r> getUpperBounds() {
        T b6 = this.f44263b.b(this, f44261d[0]);
        kotlin.jvm.internal.g0.o(b6, "getValue(...)");
        return (List) b6;
    }

    public int hashCode() {
        return (this.f44264c.hashCode() * 31) + getName().hashCode();
    }

    @NotNull
    public String toString() {
        return kotlin.jvm.internal.v0.f44065f.a(this);
    }

    private final Class<?> b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t tVar) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.r rVar;
        Object obj;
        Class<?> a6;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s b02 = tVar.b0();
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f fVar = null;
        if (b02 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.r) {
            rVar = (kotlin.reflect.jvm.internal.impl.load.kotlin.r) b02;
        } else {
            rVar = null;
        }
        if (rVar != null) {
            obj = rVar.g();
        } else {
            obj = null;
        }
        if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f) {
            fVar = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f) obj;
        }
        if (fVar != null && (a6 = fVar.a()) != null) {
            return a6;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + tVar);
    }

    private final h0<?> e(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.d dVar2;
        Class<?> s5 = p3.s(dVar);
        if (s5 != null) {
            dVar2 = l3.a.i(s5);
        } else {
            dVar2 = null;
        }
        h0<?> h0Var = (h0) dVar2;
        if (h0Var != null) {
            return h0Var;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + dVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(b3 b3Var) {
        List<kotlin.reflect.jvm.internal.impl.types.t0> upperBounds = b3Var.d().getUpperBounds();
        kotlin.jvm.internal.g0.o(upperBounds, "getUpperBounds(...)");
        List<kotlin.reflect.jvm.internal.impl.types.t0> list = upperBounds;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new z2((kotlin.reflect.jvm.internal.impl.types.t0) it.next(), null, 2, 0 == true ? 1 : 0));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public String getName() {
        String b6 = d().getName().b();
        kotlin.jvm.internal.g0.o(b6, "asString(...)");
        return b6;
    }

    @Override // kotlin.reflect.s
    public boolean j() {
        return d().j();
    }

    @Override // kotlin.reflect.s
    @NotNull
    public KVariance l() {
        int i6 = a.f44265a[d().l().ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return KVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return KVariance.IN;
        }
        return KVariance.INVARIANT;
    }
}
