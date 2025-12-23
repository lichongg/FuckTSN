package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g extends e1 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final w1 f47222b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final k f47223c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final ErrorTypeKind f47224d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<c2> f47225e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f47226f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final String[] f47227g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final String f47228h;

    public /* synthetic */ g(w1 w1Var, k kVar, ErrorTypeKind errorTypeKind, List list, boolean z5, String[] strArr, int i6, v vVar) {
        this(w1Var, kVar, errorTypeKind, (i6 & 8) != 0 ? f0.J() : list, (i6 & 16) != 0 ? false : z5, strArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return this.f47225e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return t1.f47332b.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public w1 I0() {
        return this.f47222b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return this.f47226f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public e1 M0(boolean z5) {
        w1 I0 = I0();
        k r5 = r();
        ErrorTypeKind errorTypeKind = this.f47224d;
        List<c2> G0 = G0();
        String[] strArr = this.f47227g;
        return new g(I0, r5, errorTypeKind, G0, z5, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        g0.p(newAttributes, "newAttributes");
        return this;
    }

    @NotNull
    public final String R0() {
        return this.f47228h;
    }

    @NotNull
    public final ErrorTypeKind S0() {
        return this.f47224d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public g S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public final g U0(@NotNull List<? extends c2> newArguments) {
        g0.p(newArguments, "newArguments");
        w1 I0 = I0();
        k r5 = r();
        ErrorTypeKind errorTypeKind = this.f47224d;
        boolean J0 = J0();
        String[] strArr = this.f47227g;
        return new g(I0, r5, errorTypeKind, newArguments, J0, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public k r() {
        return this.f47223c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public g(@NotNull w1 constructor, @NotNull k memberScope, @NotNull ErrorTypeKind kind, @NotNull List<? extends c2> arguments, boolean z5, @NotNull String... formatParams) {
        g0.p(constructor, "constructor");
        g0.p(memberScope, "memberScope");
        g0.p(kind, "kind");
        g0.p(arguments, "arguments");
        g0.p(formatParams, "formatParams");
        this.f47222b = constructor;
        this.f47223c = memberScope;
        this.f47224d = kind;
        this.f47225e = arguments;
        this.f47226f = z5;
        this.f47227g = formatParams;
        t0 t0Var = t0.f44062a;
        String debugMessage = kind.getDebugMessage();
        Object[] copyOf = Arrays.copyOf(formatParams, formatParams.length);
        String format = String.format(debugMessage, Arrays.copyOf(copyOf, copyOf.length));
        g0.o(format, "format(...)");
        this.f47228h = format;
    }
}
