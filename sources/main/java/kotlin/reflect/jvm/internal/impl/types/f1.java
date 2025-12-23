package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f1 extends e1 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final w1 f47244b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<c2> f47245c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f47246d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f47247e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, e1> f47248f;

    /* JADX WARN: Multi-variable type inference failed */
    public f1(@NotNull w1 constructor, @NotNull List<? extends c2> arguments, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.k memberScope, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends e1> refinedTypeFactory) {
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        kotlin.jvm.internal.g0.p(memberScope, "memberScope");
        kotlin.jvm.internal.g0.p(refinedTypeFactory, "refinedTypeFactory");
        this.f47244b = constructor;
        this.f47245c = arguments;
        this.f47246d = z5;
        this.f47247e = memberScope;
        this.f47248f = refinedTypeFactory;
        if (!(r() instanceof kotlin.reflect.jvm.internal.impl.types.error.f) || (r() instanceof kotlin.reflect.jvm.internal.impl.types.error.j)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + r() + '\n' + I0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return this.f47245c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return t1.f47332b.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public w1 I0() {
        return this.f47244b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return this.f47246d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new g1(this, newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public e1 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        e1 invoke = this.f47248f.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return this.f47247e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public e1 M0(boolean z5) {
        if (z5 == J0()) {
            return this;
        }
        if (z5) {
            return new c1(this);
        }
        return new a1(this);
    }
}
