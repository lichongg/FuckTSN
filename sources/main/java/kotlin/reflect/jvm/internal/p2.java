package kotlin.reflect.jvm.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.t;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKPropertyImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KPropertyImpl.kt\nkotlin/reflect/jvm/internal/KPropertyImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,334:1\n1#2:335\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class p2<V> extends e0<V> implements kotlin.reflect.n<V> {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final b f47544m = new b(null);

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Object f47545n = new Object();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final KDeclarationContainerImpl f47546g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final String f47547h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final String f47548i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private final Object f47549j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.s<Field> f47550k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final f3.a<kotlin.reflect.jvm.internal.impl.descriptors.w0> f47551l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }

        @NotNull
        public final Object a() {
            return p2.f47545n;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class c<V> extends a<V, V> implements n.c<V> {

        /* renamed from: i, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f47552i = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(c.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final f3.a f47553g = f3.c(new q2(this));

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final kotlin.s f47554h = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new r2(this));

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.calls.g i0(c cVar) {
            kotlin.reflect.jvm.internal.calls.g b6;
            b6 = u2.b(cVar, true);
            return b6;
        }

        @Override // kotlin.reflect.jvm.internal.e0
        @NotNull
        public kotlin.reflect.jvm.internal.calls.g<?> W() {
            return (kotlin.reflect.jvm.internal.calls.g) this.f47554h.getValue();
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof c) && kotlin.jvm.internal.g0.g(f0(), ((c) obj).f0());
        }

        @Override // kotlin.reflect.c
        @NotNull
        public String getName() {
            return "<get-" + f0().getName() + kotlin.text.v0.f47962f;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.x0 e0() {
            T b6 = this.f47553g.b(this, f47552i[0]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.x0) b6;
        }

        @NotNull
        public String toString() {
            return "getter of " + f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.x0 j0(c cVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.x0 getter = cVar.f0().e0().getGetter();
            if (getter == null) {
                kotlin.reflect.jvm.internal.impl.descriptors.impl.l0 d6 = kotlin.reflect.jvm.internal.impl.resolve.h.d(cVar.f0().e0(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b());
                kotlin.jvm.internal.g0.o(d6, "createDefaultGetter(...)");
                return d6;
            }
            return getter;
        }

        public int hashCode() {
            return f0().hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class d<V> extends a<V, kotlin.n1> implements j.a<V> {

        /* renamed from: i, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f47555i = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(d.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final f3.a f47556g = f3.c(new s2(this));

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final kotlin.s f47557h = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new t2(this));

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.calls.g i0(d dVar) {
            kotlin.reflect.jvm.internal.calls.g b6;
            b6 = u2.b(dVar, false);
            return b6;
        }

        @Override // kotlin.reflect.jvm.internal.e0
        @NotNull
        public kotlin.reflect.jvm.internal.calls.g<?> W() {
            return (kotlin.reflect.jvm.internal.calls.g) this.f47557h.getValue();
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof d) && kotlin.jvm.internal.g0.g(f0(), ((d) obj).f0());
        }

        @Override // kotlin.reflect.c
        @NotNull
        public String getName() {
            return "<set-" + f0().getName() + kotlin.text.v0.f47962f;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.y0 e0() {
            T b6 = this.f47556g.b(this, f47555i[0]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.y0) b6;
        }

        @NotNull
        public String toString() {
            return "setter of " + f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.y0 j0(d dVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.y0 setter = dVar.f0().e0().getSetter();
            if (setter == null) {
                kotlin.reflect.jvm.internal.impl.descriptors.w0 e02 = dVar.f0().e0();
                g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0;
                kotlin.reflect.jvm.internal.impl.descriptors.impl.m0 e6 = kotlin.reflect.jvm.internal.impl.resolve.h.e(e02, aVar.b(), aVar.b());
                kotlin.jvm.internal.g0.o(e6, "createDefaultSetter(...)");
                return e6;
            }
            return setter;
        }

        public int hashCode() {
            return f0().hashCode();
        }
    }

    private p2(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, Object obj) {
        this.f47546g = kDeclarationContainerImpl;
        this.f47547h = str;
        this.f47548i = str2;
        this.f47549j = obj;
        this.f47550k = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new n2(this));
        f3.a<kotlin.reflect.jvm.internal.impl.descriptors.w0> b6 = f3.b(w0Var, new o2(this));
        kotlin.jvm.internal.g0.o(b6, "lazySoft(...)");
        this.f47551l = b6;
    }

    @Override // kotlin.reflect.c
    public boolean isSuspend() {
        return false;
    }

    @NotNull
    public abstract c<V> n0();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a<PropertyType, ReturnType> extends e0<ReturnType> implements kotlin.reflect.i<ReturnType>, n.a<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.e0
        @Nullable
        public kotlin.reflect.jvm.internal.calls.g<?> Y() {
            return null;
        }

        @NotNull
        public abstract kotlin.reflect.jvm.internal.impl.descriptors.v0 e0();

        @NotNull
        public abstract p2<PropertyType> f0();

        @Override // kotlin.reflect.jvm.internal.e0
        @NotNull
        public KDeclarationContainerImpl X() {
            return f0().X();
        }

        @Override // kotlin.reflect.jvm.internal.e0
        public boolean c0() {
            return f0().c0();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Field f0(p2 p2Var) {
        Class<?> enclosingClass;
        t f6 = k3.f47513a.f(p2Var.e0());
        if (!(f6 instanceof t.c)) {
            if (f6 instanceof t.a) {
                return ((t.a) f6).b();
            }
            if ((f6 instanceof t.b) || (f6 instanceof t.d)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        t.c cVar = (t.c) f6;
        kotlin.reflect.jvm.internal.impl.descriptors.w0 b6 = cVar.b();
        d.a d6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.d(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
        if (d6 == null) {
            return null;
        }
        if (kotlin.reflect.jvm.internal.impl.load.java.n.e(b6) || kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f(cVar.e())) {
            enclosingClass = p2Var.X().c().getEnclosingClass();
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.k b7 = b6.b();
            enclosingClass = b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? p3.s((kotlin.reflect.jvm.internal.impl.descriptors.d) b7) : p2Var.X().c();
        }
        if (enclosingClass == null) {
            return null;
        }
        try {
            return enclosingClass.getDeclaredField(d6.e());
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @NotNull
    public KDeclarationContainerImpl X() {
        return this.f47546g;
    }

    @Override // kotlin.reflect.jvm.internal.e0
    public boolean c0() {
        return this.f47549j != CallableReference.NO_RECEIVER;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public String getName() {
        return this.f47547h;
    }

    @Nullable
    public final Object k0() {
        return kotlin.reflect.jvm.internal.calls.n.h(this.f47549j, e0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected final Object l0(@Nullable Member member, @Nullable Object obj, @Nullable Object obj2) {
        try {
            Object obj3 = f47545n;
            if ((obj == obj3 || obj2 == obj3) && e0().f0() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object k02 = c0() ? k0() : obj;
            if (k02 == obj3) {
                k02 = null;
            }
            if (!c0()) {
                obj = obj2;
            }
            if (obj == obj3) {
                obj = null;
            }
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(kotlin.reflect.jvm.a.a(this));
            }
            if (member == 0) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(k02);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) member;
                if (k02 == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    kotlin.jvm.internal.g0.o(cls, "get(...)");
                    k02 = p3.g(cls);
                }
                return method.invoke(null, k02);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                kotlin.jvm.internal.g0.o(cls2, "get(...)");
                obj = p3.g(cls2);
            }
            return method2.invoke(null, k02, obj);
        } catch (IllegalAccessException e6) {
            throw new IllegalPropertyDelegateAccessException(e6);
        }
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 e0() {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 invoke = this.f47551l.invoke();
        kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
        return invoke;
    }

    @Nullable
    public final Field o0() {
        return this.f47550k.getValue();
    }

    @NotNull
    public final String p0() {
        return this.f47548i;
    }

    @NotNull
    public String toString() {
        return j3.f47506a.k(e0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.w0 e0(p2 p2Var) {
        return p2Var.X().L(p2Var.getName(), p2Var.f47548i);
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @NotNull
    public kotlin.reflect.jvm.internal.calls.g<?> W() {
        return n0().W();
    }

    @Override // kotlin.reflect.jvm.internal.e0
    @Nullable
    public kotlin.reflect.jvm.internal.calls.g<?> Y() {
        return n0().Y();
    }

    public boolean equals(@Nullable Object obj) {
        p2<?> d6 = p3.d(obj);
        if (d6 == null || !kotlin.jvm.internal.g0.g(X(), d6.X()) || !kotlin.jvm.internal.g0.g(getName(), d6.getName()) || !kotlin.jvm.internal.g0.g(this.f47548i, d6.f47548i) || !kotlin.jvm.internal.g0.g(this.f47549j, d6.f47549j)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((X().hashCode() * 31) + getName().hashCode()) * 31) + this.f47548i.hashCode();
    }

    @Override // kotlin.reflect.n
    public boolean isConst() {
        return e0().isConst();
    }

    @Override // kotlin.reflect.n
    public boolean isLateinit() {
        return e0().B0();
    }

    @Nullable
    protected final Member j0() {
        if (!e0().X()) {
            return null;
        }
        t f6 = k3.f47513a.f(e0());
        if (f6 instanceof t.c) {
            t.c cVar = (t.c) f6;
            if (cVar.f().hasDelegateMethod()) {
                JvmProtoBuf.JvmMethodSignature delegateMethod = cVar.f().getDelegateMethod();
                if (!delegateMethod.hasName() || !delegateMethod.hasDesc()) {
                    return null;
                }
                return X().K(cVar.d().getString(delegateMethod.getName()), cVar.d().getString(delegateMethod.getDesc()));
            }
        }
        return o0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p2(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p2(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.g0.p(r8, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.g0.p(r9, r0)
            kotlin.reflect.jvm.internal.impl.name.f r0 = r9.getName()
            java.lang.String r3 = r0.b()
            java.lang.String r0 = "asString(...)"
            kotlin.jvm.internal.g0.o(r3, r0)
            kotlin.reflect.jvm.internal.k3 r0 = kotlin.reflect.jvm.internal.k3.f47513a
            kotlin.reflect.jvm.internal.t r0 = r0.f(r9)
            java.lang.String r4 = r0.a()
            java.lang.Object r6 = kotlin.jvm.internal.CallableReference.NO_RECEIVER
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.p2.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.w0):void");
    }
}
