package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.calls.m;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKParameterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KParameterImpl.kt\nkotlin/reflect/jvm/internal/KParameterImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,113:1\n1#2:114\n37#3:115\n36#3,3:116\n37#3:119\n36#3,3:120\n*S KotlinDebug\n*F\n+ 1 KParameterImpl.kt\nkotlin/reflect/jvm/internal/KParameterImpl\n*L\n89#1:115\n89#1:116,3\n92#1:119\n92#1:120,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d2 implements KParameter {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44325f = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(d2.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(d2.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final e0<?> f44326a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44327b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final KParameter.Kind f44328c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final f3.a f44329d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final f3.a f44330e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Type {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Type[] f44331a;

        /* renamed from: b, reason: collision with root package name */
        private final int f44332b;

        public a(@NotNull Type[] types) {
            kotlin.jvm.internal.g0.p(types, "types");
            this.f44331a = types;
            this.f44332b = Arrays.hashCode(types);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && Arrays.equals(this.f44331a, ((a) obj).f44331a);
        }

        @Override // java.lang.reflect.Type
        @NotNull
        public String getTypeName() {
            return kotlin.collections.n.Eh(this.f44331a, ", ", "[", "]", 0, null, null, 56, null);
        }

        public int hashCode() {
            return this.f44332b;
        }

        @NotNull
        public String toString() {
            return getTypeName();
        }
    }

    private final Type j(Type... typeArr) {
        int length = typeArr.length;
        if (length != 0) {
            return length != 1 ? new a(typeArr) : (Type) kotlin.collections.n.At(typeArr);
        }
        throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
    }

    public d2(@NotNull e0<?> callable, int i6, @NotNull KParameter.Kind kind, @NotNull Function0<? extends kotlin.reflect.jvm.internal.impl.descriptors.t0> computeDescriptor) {
        kotlin.jvm.internal.g0.p(callable, "callable");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(computeDescriptor, "computeDescriptor");
        this.f44326a = callable;
        this.f44327b = i6;
        this.f44328c = kind;
        this.f44329d = f3.c(computeDescriptor);
        this.f44330e = f3.c(new b2(this));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.t0 r() {
        T b6 = this.f44329d.b(this, f44325f[0]);
        kotlin.jvm.internal.g0.o(b6, "getValue(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.t0) b6;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return kotlin.jvm.internal.g0.g(this.f44326a, d2Var.f44326a) && getIndex() == d2Var.getIndex();
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        T b6 = this.f44330e.b(this, f44325f[1]);
        kotlin.jvm.internal.g0.o(b6, "getValue(...)");
        return (List) b6;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.f44327b;
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public kotlin.reflect.r getType() {
        kotlin.reflect.jvm.internal.impl.types.t0 type = r().getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        return new z2(type, new c2(this));
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KParameter.Kind h() {
        return this.f44328c;
    }

    public int hashCode() {
        return (this.f44326a.hashCode() * 31) + getIndex();
    }

    @NotNull
    public final e0<?> l() {
        return this.f44326a;
    }

    @NotNull
    public String toString() {
        return j3.f47506a.j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(d2 d2Var) {
        List r5;
        kotlin.reflect.jvm.internal.impl.descriptors.t0 r6 = d2Var.r();
        if ((r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.z0) && kotlin.jvm.internal.g0.g(p3.k(d2Var.f44326a.e0()), r6) && d2Var.f44326a.e0().h() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = d2Var.f44326a.e0().b();
            kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> s5 = p3.s((kotlin.reflect.jvm.internal.impl.descriptors.d) b6);
            if (s5 != null) {
                return s5;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + r6);
        }
        kotlin.reflect.jvm.internal.calls.g<?> W = d2Var.f44326a.W();
        if (W instanceof kotlin.reflect.jvm.internal.calls.m) {
            if (d2Var.f44326a.c0()) {
                kotlin.reflect.jvm.internal.calls.m mVar = (kotlin.reflect.jvm.internal.calls.m) W;
                kotlin.ranges.m f6 = mVar.f(d2Var.getIndex() + 1);
                int f7 = mVar.f(0).f() + 1;
                r5 = kotlin.collections.f0.r5(mVar.b(), new kotlin.ranges.m(f6.e() - f7, f6.f() - f7));
            } else {
                kotlin.reflect.jvm.internal.calls.m mVar2 = (kotlin.reflect.jvm.internal.calls.m) W;
                r5 = kotlin.collections.f0.r5(mVar2.b(), mVar2.f(d2Var.getIndex()));
            }
            Type[] typeArr = (Type[]) r5.toArray(new Type[0]);
            return d2Var.j((Type[]) Arrays.copyOf(typeArr, typeArr.length));
        }
        if (W instanceof m.b) {
            Class[] clsArr = (Class[]) ((m.b) W).f().get(d2Var.getIndex()).toArray(new Class[0]);
            return d2Var.j((Type[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        return W.b().get(d2Var.getIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(d2 d2Var) {
        return p3.e(d2Var.r());
    }

    @Override // kotlin.reflect.KParameter
    public boolean a() {
        kotlin.reflect.jvm.internal.impl.descriptors.t0 r5 = r();
        if ((r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.q1) && ((kotlin.reflect.jvm.internal.impl.descriptors.q1) r5).z0() != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    @Nullable
    public String getName() {
        kotlin.reflect.jvm.internal.impl.descriptors.q1 q1Var;
        kotlin.reflect.jvm.internal.impl.descriptors.t0 r5 = r();
        if (r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.q1) {
            q1Var = (kotlin.reflect.jvm.internal.impl.descriptors.q1) r5;
        } else {
            q1Var = null;
        }
        if (q1Var == null || q1Var.b().n0()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = q1Var.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        if (name.i()) {
            return null;
        }
        return name.b();
    }

    @Override // kotlin.reflect.KParameter
    public boolean p() {
        kotlin.reflect.jvm.internal.impl.descriptors.q1 q1Var;
        kotlin.reflect.jvm.internal.impl.descriptors.t0 r5 = r();
        if (r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.q1) {
            q1Var = (kotlin.reflect.jvm.internal.impl.descriptors.q1) r5;
        } else {
            q1Var = null;
        }
        if (q1Var != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.f(q1Var);
        }
        return false;
    }
}
