package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.i;
import kotlin.reflect.jvm.internal.impl.types.t1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends e1 implements e4.b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final c2 f46653b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final b f46654c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f46655d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final t1 f46656e;

    public /* synthetic */ a(c2 c2Var, b bVar, boolean z5, t1 t1Var, int i6, v vVar) {
        this(c2Var, (i6 & 2) != 0 ? new c(c2Var) : bVar, (i6 & 4) != 0 ? false : z5, (i6 & 8) != 0 ? t1.f47332b.k() : t1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return this.f46656e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return this.f46655d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        g0.p(newAttributes, "newAttributes");
        return new a(this.f46653b, I0(), J0(), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public b I0() {
        return this.f46654c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public a S0(@NotNull g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        c2 a6 = this.f46653b.a(kotlinTypeRefiner);
        g0.o(a6, "refine(...)");
        return new a(a6, I0(), J0(), H0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public k r() {
        return i.a(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.f46653b);
        sb.append(')');
        sb.append(J0() ? "?" : "");
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public a M0(boolean z5) {
        if (z5 == J0()) {
            return this;
        }
        return new a(this.f46653b, I0(), z5, H0());
    }

    public a(@NotNull c2 typeProjection, @NotNull b constructor, boolean z5, @NotNull t1 attributes) {
        g0.p(typeProjection, "typeProjection");
        g0.p(constructor, "constructor");
        g0.p(attributes, "attributes");
        this.f46653b = typeProjection;
        this.f46654c = constructor;
        this.f46655d = z5;
        this.f46656e = attributes;
    }
}
