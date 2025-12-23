package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t extends g<b> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f46688b = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @Nullable
        public final g<?> a(@NotNull t0 argumentType) {
            g0.p(argumentType, "argumentType");
            if (x0.a(argumentType)) {
                return null;
            }
            t0 t0Var = argumentType;
            int i6 = 0;
            while (kotlin.reflect.jvm.internal.impl.builtins.j.d0(t0Var)) {
                t0Var = ((c2) kotlin.collections.f0.m5(t0Var.G0())).getType();
                g0.o(t0Var, "getType(...)");
                i6++;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(c6);
                return n6 == null ? new t(new b.a(argumentType)) : new t(n6, i6);
            }
            if (c6 instanceof j1) {
                return new t(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.f44585b.m()), 0);
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final t0 f46689a;

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && g0.g(this.f46689a, ((a) obj).f46689a);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull t0 type) {
                super(null);
                g0.p(type, "type");
                this.f46689a = type;
            }

            @NotNull
            public final t0 getType() {
                return this.f46689a;
            }

            public int hashCode() {
                return this.f46689a.hashCode();
            }

            @NotNull
            public String toString() {
                return "LocalClass(type=" + this.f46689a + ')';
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.t$b$b, reason: collision with other inner class name */
        public static final class C0913b extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final f f46690a;

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0913b) && g0.g(this.f46690a, ((C0913b) obj).f46690a);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0913b(@NotNull f value) {
                super(null);
                g0.p(value, "value");
                this.f46690a = value;
            }

            public final int a() {
                return this.f46690a.c();
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.name.b b() {
                return this.f46690a.d();
            }

            @NotNull
            public final f c() {
                return this.f46690a;
            }

            public int hashCode() {
                return this.f46690a.hashCode();
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.f46690a + ')';
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull b value) {
        super(value);
        g0.p(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(@NotNull f value) {
        this(new b.C0913b(value));
        g0.p(value, "value");
    }

    @NotNull
    public final t0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        b a6 = a();
        if (a6 instanceof b.a) {
            return ((b.a) a()).getType();
        }
        if (!(a6 instanceof b.C0913b)) {
            throw new NoWhenBranchMatchedException();
        }
        f c6 = ((b.C0913b) a()).c();
        kotlin.reflect.jvm.internal.impl.name.b a7 = c6.a();
        int b6 = c6.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d b7 = kotlin.reflect.jvm.internal.impl.descriptors.x.b(module, a7);
        if (b7 == null) {
            return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE, a7.toString(), String.valueOf(b6));
        }
        e1 s5 = b7.s();
        g0.o(s5, "getDefaultType(...)");
        t0 E = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.E(s5);
        for (int i6 = 0; i6 < b6; i6++) {
            E = module.p().m(Variance.INVARIANT, E);
            g0.o(E, "getArrayType(...)");
        }
        return E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public t0 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        t1 k6 = t1.f47332b.k();
        kotlin.reflect.jvm.internal.impl.descriptors.d F = module.p().F();
        g0.o(F, "getKClass(...)");
        return w0.h(k6, F, kotlin.collections.f0.l(new e2(b(module))));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, int i6) {
        this(new f(classId, i6));
        g0.p(classId, "classId");
    }
}
