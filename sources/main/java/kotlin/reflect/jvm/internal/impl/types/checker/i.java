package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i extends e1 implements e4.b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final CaptureStatus f47172b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final n f47173c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final m2 f47174d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final t1 f47175e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f47176f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f47177g;

    public /* synthetic */ i(CaptureStatus captureStatus, n nVar, m2 m2Var, t1 t1Var, boolean z5, boolean z6, int i6, kotlin.jvm.internal.v vVar) {
        this(captureStatus, nVar, m2Var, (i6 & 8) != 0 ? t1.f47332b.k() : t1Var, (i6 & 16) != 0 ? false : z5, (i6 & 32) != 0 ? false : z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return this.f47175e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return this.f47176f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        g0.p(newAttributes, "newAttributes");
        return new i(this.f47172b, I0(), this.f47174d, newAttributes, J0(), this.f47177g);
    }

    @NotNull
    public final CaptureStatus R0() {
        return this.f47172b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public n I0() {
        return this.f47173c;
    }

    @Nullable
    public final m2 T0() {
        return this.f47174d;
    }

    public final boolean U0() {
        return this.f47177g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public i M0(boolean z5) {
        return new i(this.f47172b, I0(), this.f47174d, H0(), z5, false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public i S0(@NotNull g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.f47172b;
        n a6 = I0().a(kotlinTypeRefiner);
        m2 m2Var = this.f47174d;
        return new i(captureStatus, a6, m2Var != null ? kotlinTypeRefiner.a(m2Var).L0() : null, H0(), J0(), false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return kotlin.reflect.jvm.internal.impl.types.error.i.a(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public i(@NotNull CaptureStatus captureStatus, @NotNull n constructor, @Nullable m2 m2Var, @NotNull t1 attributes, boolean z5, boolean z6) {
        g0.p(captureStatus, "captureStatus");
        g0.p(constructor, "constructor");
        g0.p(attributes, "attributes");
        this.f47172b = captureStatus;
        this.f47173c = constructor;
        this.f47174d = m2Var;
        this.f47175e = attributes;
        this.f47176f = z5;
        this.f47177g = z6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return f0.J();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@NotNull CaptureStatus captureStatus, @Nullable m2 m2Var, @NotNull c2 projection, @NotNull j1 typeParameter) {
        this(captureStatus, new n(projection, null, null, typeParameter, 6, null), m2Var, null, false, false, 56, null);
        g0.p(captureStatus, "captureStatus");
        g0.p(projection, "projection");
        g0.p(typeParameter, "typeParameter");
    }
}
