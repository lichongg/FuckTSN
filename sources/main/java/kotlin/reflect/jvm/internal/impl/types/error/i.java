package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f47232a = new i();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final f0 f47233b = d.f47213a;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f47234c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final t0 f47235d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final t0 f47236e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final w0 f47237f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Set<w0> f47238g;

    @JvmStatic
    public static final boolean o(@Nullable t0 t0Var) {
        if (t0Var == null) {
            return false;
        }
        w1 I0 = t0Var.I0();
        return (I0 instanceof h) && ((h) I0).e() == ErrorTypeKind.UNINFERRED_TYPE_VARIABLE;
    }

    static {
        String format = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        g0.o(format, "format(...)");
        kotlin.reflect.jvm.internal.impl.name.f k6 = kotlin.reflect.jvm.internal.impl.name.f.k(format);
        g0.o(k6, "special(...)");
        f47234c = new a(k6);
        f47235d = d(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        f47236e = d(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        e eVar = new e();
        f47237f = eVar;
        f47238g = u1.f(eVar);
    }

    @JvmStatic
    @NotNull
    public static final f a(@NotNull ErrorScopeKind kind, boolean z5, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(formatParams, "formatParams");
        return z5 ? new j(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)) : new f(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    @NotNull
    public static final f b(@NotNull ErrorScopeKind kind, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(formatParams, "formatParams");
        return a(kind, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    @NotNull
    public static final g d(@NotNull ErrorTypeKind kind, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(formatParams, "formatParams");
        return f47232a.g(kind, kotlin.collections.f0.J(), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    public static final boolean m(@Nullable k kVar) {
        if (kVar == null) {
            return false;
        }
        i iVar = f47232a;
        return iVar.n(kVar) || iVar.n(kVar.b()) || kVar == f47233b;
    }

    private final boolean n(k kVar) {
        return kVar instanceof a;
    }

    @NotNull
    public final g c(@NotNull ErrorTypeKind kind, @NotNull w1 typeConstructor, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(typeConstructor, "typeConstructor");
        g0.p(formatParams, "formatParams");
        return f(kind, kotlin.collections.f0.J(), typeConstructor, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final h e(@NotNull ErrorTypeKind kind, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(formatParams, "formatParams");
        return new h(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final g f(@NotNull ErrorTypeKind kind, @NotNull List<? extends c2> arguments, @NotNull w1 typeConstructor, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(arguments, "arguments");
        g0.p(typeConstructor, "typeConstructor");
        g0.p(formatParams, "formatParams");
        return new g(typeConstructor, b(ErrorScopeKind.ERROR_TYPE_SCOPE, typeConstructor.toString()), kind, arguments, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final g g(@NotNull ErrorTypeKind kind, @NotNull List<? extends c2> arguments, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(arguments, "arguments");
        g0.p(formatParams, "formatParams");
        return f(kind, arguments, e(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final a h() {
        return f47234c;
    }

    @NotNull
    public final f0 i() {
        return f47233b;
    }

    @NotNull
    public final Set<w0> j() {
        return f47238g;
    }

    @NotNull
    public final t0 k() {
        return f47236e;
    }

    @NotNull
    public final t0 l() {
        return f47235d;
    }

    @NotNull
    public final String p(@NotNull t0 type) {
        g0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.types.typeUtil.e.A(type);
        w1 I0 = type.I0();
        g0.n(I0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((h) I0).f(0);
    }

    private i() {
    }
}
