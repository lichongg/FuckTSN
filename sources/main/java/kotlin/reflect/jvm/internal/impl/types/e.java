package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e extends e1 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f47202e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.checker.r f47203b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f47204c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f47205d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    @NotNull
    public abstract e S0(boolean z5);

    public e(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.r originalTypeVariable, boolean z5) {
        kotlin.jvm.internal.g0.p(originalTypeVariable, "originalTypeVariable");
        this.f47203b = originalTypeVariable;
        this.f47204c = z5;
        this.f47205d = kotlin.reflect.jvm.internal.impl.types.error.i.b(ErrorScopeKind.STUB_TYPE_SCOPE, originalTypeVariable.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return t1.f47332b.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return this.f47204c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return this;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.checker.r R0() {
        return this.f47203b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public e S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return this.f47205d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public e1 M0(boolean z5) {
        if (z5 == J0()) {
            return this;
        }
        return S0(z5);
    }
}
