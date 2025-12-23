package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q implements p {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final g f47191c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final f f47192d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final OverridingUtil f47193e;

    public q(@NotNull g kotlinTypeRefiner, @NotNull f kotlinTypePreparator) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0.p(kotlinTypePreparator, "kotlinTypePreparator");
        this.f47191c = kotlinTypeRefiner;
        this.f47192d = kotlinTypePreparator;
        OverridingUtil m6 = OverridingUtil.m(c());
        g0.o(m6, "createWithTypeRefiner(...)");
        this.f47193e = m6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public boolean a(@NotNull t0 a6, @NotNull t0 b6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        return e(a.b(false, false, null, f(), c(), 6, null), a6.L0(), b6.L0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.p
    @NotNull
    public OverridingUtil b() {
        return this.f47193e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.p
    @NotNull
    public g c() {
        return this.f47191c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public boolean d(@NotNull t0 subtype, @NotNull t0 supertype) {
        g0.p(subtype, "subtype");
        g0.p(supertype, "supertype");
        return g(a.b(true, false, null, f(), c(), 6, null), subtype.L0(), supertype.L0());
    }

    public final boolean e(@NotNull TypeCheckerState typeCheckerState, @NotNull m2 a6, @NotNull m2 b6) {
        g0.p(typeCheckerState, "<this>");
        g0.p(a6, "a");
        g0.p(b6, "b");
        return kotlin.reflect.jvm.internal.impl.types.h.f47257a.m(typeCheckerState, a6, b6);
    }

    @NotNull
    public f f() {
        return this.f47192d;
    }

    public final boolean g(@NotNull TypeCheckerState typeCheckerState, @NotNull m2 subType, @NotNull m2 superType) {
        g0.p(typeCheckerState, "<this>");
        g0.p(subType, "subType");
        g0.p(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.h.v(kotlin.reflect.jvm.internal.impl.types.h.f47257a, typeCheckerState, subType, superType, false, 8, null);
    }

    public /* synthetic */ q(g gVar, f fVar, int i6, kotlin.jvm.internal.v vVar) {
        this(gVar, (i6 & 2) != 0 ? f.a.f47169a : fVar);
    }
}
