package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z extends b0 implements x, e4.c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f47374d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e1 f47375b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f47376c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ z c(a aVar, m2 m2Var, boolean z5, boolean z6, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            if ((i6 & 4) != 0) {
                z6 = false;
            }
            return aVar.b(m2Var, z5, z6);
        }

        @JvmOverloads
        @Nullable
        public final z b(@NotNull m2 type, boolean z5, boolean z6) {
            kotlin.jvm.internal.g0.p(type, "type");
            if (type instanceof z) {
                return (z) type;
            }
            kotlin.jvm.internal.v vVar = null;
            if (!z6 && !d(type, z5)) {
                return null;
            }
            if (type instanceof k0) {
                k0 k0Var = (k0) type;
                kotlin.jvm.internal.g0.g(k0Var.Q0().I0(), k0Var.R0().I0());
            }
            return new z(n0.c(type).M0(false), z5, vVar);
        }

        private final boolean a(m2 m2Var) {
            if (!(m2Var.I0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.r) && !(m2Var.I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) && !(m2Var instanceof kotlin.reflect.jvm.internal.impl.types.checker.i) && !(m2Var instanceof n1)) {
                return false;
            }
            return true;
        }

        private final boolean d(m2 m2Var, boolean z5) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.t0 t0Var;
            if (!a(m2Var)) {
                return false;
            }
            if (m2Var instanceof n1) {
                return j2.l(m2Var);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = m2Var.I0().c();
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.t0) {
                t0Var = (kotlin.reflect.jvm.internal.impl.descriptors.impl.t0) c6;
            } else {
                t0Var = null;
            }
            if (t0Var != null && !t0Var.O0()) {
                return true;
            }
            if (z5 && (m2Var.I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1)) {
                return j2.l(m2Var);
            }
            return !kotlin.reflect.jvm.internal.impl.types.checker.s.f47194a.a(m2Var);
        }
    }

    public /* synthetic */ z(e1 e1Var, boolean z5, kotlin.jvm.internal.v vVar) {
        this(e1Var, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0, kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return false;
    }

    private z(e1 e1Var, boolean z5) {
        this.f47375b = e1Var;
        this.f47376c = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public e1 M0(boolean z5) {
        return z5 ? R0().M0(z5) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return new z(R0().O0(newAttributes), this.f47376c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    protected e1 R0() {
        return this.f47375b;
    }

    @NotNull
    public final e1 U0() {
        return this.f47375b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public z T0(@NotNull e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        return new z(delegate, this.f47376c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    @NotNull
    public t0 p0(@NotNull t0 replacement) {
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        return i1.e(replacement.L0(), this.f47376c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    public String toString() {
        return R0() + " & Any";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    public boolean E0() {
        if (!(R0().I0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.r) && !(R0().I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1)) {
            return false;
        }
        return true;
    }
}
